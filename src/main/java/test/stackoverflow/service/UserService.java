package test.stackoverflow.service;

import java.util.List;
import test.stackoverflow.dto.user.ExternalItemsUserDto;
import test.stackoverflow.dto.user.ExternalUserInfoDto;
import test.stackoverflow.model.User;

public interface UserService {
    void showUsers(List<User> users);

    ExternalItemsUserDto getUsersFromApi();

    List<ExternalUserInfoDto> getFilteredDtos(ExternalItemsUserDto dto, String... countries);

    List<User> getTagsForUsersFromApi(List<User> users);
}
