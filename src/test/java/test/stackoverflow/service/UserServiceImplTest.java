package test.stackoverflow.service;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import test.stackoverflow.dto.mapper.UserMapper;
import test.stackoverflow.dto.user.ExternalItemsUserDto;
import test.stackoverflow.dto.user.ExternalUserInfoDto;
import test.stackoverflow.model.User;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl service;
    private ExternalItemsUserDto dto;

    @BeforeEach
    void setUp() {
        ExternalUserInfoDto[] users = new ExternalUserInfoDto[5];
        ExternalUserInfoDto user1 = new ExternalUserInfoDto();
        user1.setLocation("United Kingdom");
        user1.setAnswer_count(23L);
        user1.setReputation(400L);
        user1.setUser_id(0L);
        user1.setLink("");
        user1.setDisplay_name("");
        user1.setProfile_image("");
        user1.setProfileUrl("");
        user1.setQuestion_count(0L);
        ExternalUserInfoDto user2 = new ExternalUserInfoDto();
        user2.setLocation("Moldova");
        user2.setAnswer_count(0L);
        user2.setReputation(400L);
        user2.setUser_id(0L);
        user2.setLink("");
        user2.setDisplay_name("");
        user2.setProfile_image("");
        user2.setProfileUrl("");
        user2.setQuestion_count(0L);
        ExternalUserInfoDto user3 = new ExternalUserInfoDto();
        user3.setLocation("City, Romania");
        user3.setAnswer_count(23L);
        user3.setReputation(400L);
        user3.setUser_id(0L);
        user3.setLink("");
        user3.setDisplay_name("");
        user3.setProfile_image("");
        user3.setProfileUrl("");
        user3.setQuestion_count(0L);
        ExternalUserInfoDto user4 = new ExternalUserInfoDto();
        user4.setLocation("Romania");
        user4.setAnswer_count(50L);
        user4.setReputation(40L);
        user4.setUser_id(0L);
        user4.setLink("");
        user4.setDisplay_name("");
        user4.setProfile_image("");
        user4.setProfileUrl("");
        user4.setQuestion_count(0L);
        ExternalUserInfoDto user5 = new ExternalUserInfoDto();
        user5.setLocation("Moldova");
        user5.setAnswer_count(1L);
        user5.setReputation(400L);
        user5.setUser_id(0L);
        user5.setLink("");
        user5.setDisplay_name("");
        user5.setProfile_image("");
        user5.setProfileUrl("");
        user5.setQuestion_count(0L);
        users[0] = user1;
        users[1] = user2;
        users[2] = user3;
        users[3] = user4;
        users[4] = user5;
        dto = new ExternalItemsUserDto();
        dto.setItems(users);
    }

    @Test
    void shouldReturnFilteredUsers() {
        User user1 = new User();
        user1.setLocation("City, Romania");
        user1.setAnswerCount(23L);
        User user2 = new User();
        user2.setLocation("Moldova");
        user2.setAnswerCount(1L);
        List<User> expected = List.of(user1, user2);
        service = new UserServiceImpl(null, new UserMapper());
        List<User> actual = service.getFilteredUsers(dto);

        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected.get(0).getLocation(), actual.get(0).getLocation());
        Assertions.assertEquals(expected.get(0).getAnswerCount(), actual.get(0).getAnswerCount());
        Assertions.assertEquals(expected.get(1).getLocation(), actual.get(1).getLocation());
        Assertions.assertEquals(expected.get(1).getAnswerCount(), actual.get(1).getAnswerCount());
    }
}