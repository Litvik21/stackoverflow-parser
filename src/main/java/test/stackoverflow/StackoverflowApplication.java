package test.stackoverflow;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import test.stackoverflow.dto.mapper.UserMapper;
import test.stackoverflow.dto.user.ExternalItemsUserDto;
import test.stackoverflow.dto.user.ExternalUserInfoDto;
import test.stackoverflow.model.User;
import test.stackoverflow.service.UserService;

@SpringBootApplication
public class StackoverflowApplication {
    private final UserService service;
    private final UserMapper mapper;

    public StackoverflowApplication(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowApplication.class);
    }

    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            ExternalItemsUserDto usersFromApi = service.getUsersFromApi();

            List<ExternalUserInfoDto> filteredDtos = service
                    .getFilteredDtos(usersFromApi, "Romania", "Moldova");

            List<User> users = filteredDtos.stream()
                    .map(mapper::toModel)
                    .collect(Collectors.toList());

            List<User> usersWithTags = service.getTagsForUsersFromApi(users);

            service.showUsers(usersWithTags);
        };
    }
}
