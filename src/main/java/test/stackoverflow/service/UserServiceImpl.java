package test.stackoverflow.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import test.stackoverflow.dto.tag.ExternalItemsTagDto;
import test.stackoverflow.dto.user.ExternalItemsUserDto;
import test.stackoverflow.dto.mapper.UserMapper;
import test.stackoverflow.model.User;
import test.stackoverflow.util.HttpClient;

@Service
public class UserServiceImpl implements UserService {
    private final HttpClient httpClient;
    private final UserMapper mapper;
    @Value("${test.stackoverflow.key}")
    private String userDataLink;
    @Value("${test.stackoverflow.start}")
    private String tagStartLink;
    @Value("${test.stackoverflow.end}")
    private String tagEndLink;

    public UserServiceImpl( HttpClient httpClient,
                           UserMapper mapper) {
        this.httpClient = httpClient;
        this.mapper = mapper;
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
    public List<User> getFilteredUsers(ExternalItemsUserDto dto) {
        Pattern romania = Pattern.compile("Romania");
        Pattern moldova = Pattern.compile("Moldova");

        return Arrays.stream(dto.getItems())
                .filter(u -> u.getLocation() != null &&
                        (romania.matcher(u.getLocation()).find() ||
                                moldova.matcher(u.getLocation()).find()))
                .filter(u -> u.getReputation() > 223)
                .filter(u -> u.getAnswer_count() > 0)
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public List<User> getTagsForUsersFromApi(List<User> users) {
        for (User user : users) {
            ExternalItemsTagDto externalTags = httpClient
                    .get(tagStartLink + user.getExternalId() + tagEndLink, ExternalItemsTagDto.class);
            if (externalTags.getItems() != null) {
                String tags = Arrays.stream(externalTags.getItems())
                        .filter(t -> t.getName().equals("java") ||
                                t.getName().equals(".net") || t.getName().equals("c#") ||
                                t.getName().equals("docker"))
                        .map(Objects::toString)
                        .collect(Collectors.joining(","));
                user.setTags(tags);
            }
        }
        return users.stream()
                .filter(u -> u.getTags() != null)
                .collect(Collectors.toList());
    }
}