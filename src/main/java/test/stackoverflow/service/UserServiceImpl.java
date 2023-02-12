package test.stackoverflow.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import test.stackoverflow.dto.tag.ExternalItemsTagDto;
import test.stackoverflow.dto.user.ExternalItemsUserDto;
import test.stackoverflow.dto.user.ExternalUserInfoDto;
import test.stackoverflow.model.User;
import test.stackoverflow.util.HttpClient;

@Service
public class UserServiceImpl implements UserService {
    private final HttpClient httpClient;
    @Value("${test.stackoverflow.key}")
    private String userDataLink;
    @Value("${test.stackoverflow.start}")
    private String tagStartLink;
    @Value("${test.stackoverflow.end}")
    private String tagEndLink;
    private final static Long MIN_REPUTATION_RANK = 223L;
    private final static Long MIN_ANSWERS_COUNT = 1L;
    private final static Set<String> TAGS = Set.of("java", ".net", "c#", "docker");

    public UserServiceImpl( HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public void showUsers(List<User> users) {
        System.out.println(users);
    }

    @Override
    public ExternalItemsUserDto getUsersFromApi() {
        return httpClient.get(userDataLink, ExternalItemsUserDto.class);
    }

    @Override
    public List<ExternalUserInfoDto> getFilteredDtos(ExternalItemsUserDto dto) {
        Pattern romania = Pattern.compile("Romania");
        Pattern moldova = Pattern.compile("Moldova");

        return Arrays.stream(dto.getItems())
                .filter(u -> u.getLocation() != null &&
                        (romania.matcher(u.getLocation()).find() ||
                                moldova.matcher(u.getLocation()).find()))
                .filter(u -> u.getReputation() > MIN_REPUTATION_RANK)
                .filter(u -> u.getAnswerCount() >= MIN_ANSWERS_COUNT)
                .toList();
    }

    @Override
    public List<User> getTagsForUsersFromApi(List<User> users) {
        for (User user : users) {
            ExternalItemsTagDto externalTags = httpClient
                    .get(tagStartLink + user.getExternalId() + tagEndLink, ExternalItemsTagDto.class);
            if (externalTags.getItems() != null) {
                user.setTags(Arrays.stream(externalTags.getItems())
                        .filter(t -> TAGS.contains(t.getName()))
                        .map(Objects::toString)
                        .collect(Collectors.joining(",")));
            }
        }
        return users.stream()
                .filter(u -> u.getTags() != null)
                .toList();
    }
}