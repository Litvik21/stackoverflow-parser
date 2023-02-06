package test.stackoverflow;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import test.stackoverflow.dto.user.ExternalItemsUserDto;
import test.stackoverflow.model.User;
import test.stackoverflow.service.UserService;

@SpringBootApplication
public class StackoverflowApplication {
    private final UserService service;

    public StackoverflowApplication(UserService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowApplication.class);
    }

    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            ExternalItemsUserDto usersFromApi = service.getUsersFromApi();

            List<User> filteredUsers = service.getFilteredUsers(usersFromApi);

            List<User> usersWithTags = service.getTagsForUsersFromApi(filteredUsers);

            service.showUsers(usersWithTags);
        };
    }
}
