package test.stackoverflow.service;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import test.stackoverflow.dto.user.ExternalItemsUserDto;
import test.stackoverflow.dto.user.ExternalUserInfoDto;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl service;
    private ExternalItemsUserDto dto;
    private ExternalUserInfoDto user3, user5;

    @BeforeEach
    void setUp() {
        ExternalUserInfoDto[] users = new ExternalUserInfoDto[5];
        ExternalUserInfoDto user1 = new ExternalUserInfoDto();
        user1.setLocation("United Kingdom");
        user1.setAnswerCount(23L);
        user1.setReputation(400L);
        user1.setUserId(0L);
        user1.setLink("");
        user1.setDisplayName("");
        user1.setProfileImage("");
        user1.setProfileUrl("");
        user1.setQuestionCount(0L);
        ExternalUserInfoDto user2 = new ExternalUserInfoDto();
        user2.setLocation("Moldova");
        user2.setAnswerCount(0L);
        user2.setReputation(400L);
        user2.setUserId(0L);
        user2.setLink("");
        user2.setDisplayName("");
        user2.setProfileImage("");
        user2.setProfileUrl("");
        user2.setQuestionCount(0L);
        user3 = new ExternalUserInfoDto();
        user3.setLocation("City, Romania");
        user3.setAnswerCount(23L);
        user3.setReputation(400L);
        user3.setUserId(0L);
        user3.setLink("");
        user3.setDisplayName("");
        user3.setProfileImage("");
        user3.setProfileUrl("");
        user3.setQuestionCount(0L);
        ExternalUserInfoDto user4 = new ExternalUserInfoDto();
        user4.setLocation("Romania");
        user4.setAnswerCount(50L);
        user4.setReputation(40L);
        user4.setUserId(0L);
        user4.setLink("");
        user4.setDisplayName("");
        user4.setProfileImage("");
        user4.setProfileUrl("");
        user4.setQuestionCount(0L);
        user5 = new ExternalUserInfoDto();
        user5.setLocation("Moldova");
        user5.setAnswerCount(1L);
        user5.setReputation(400L);
        user5.setUserId(0L);
        user5.setLink("");
        user5.setDisplayName("");
        user5.setProfileImage("");
        user5.setProfileUrl("");
        user5.setQuestionCount(0L);
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
        List<ExternalUserInfoDto> expected = List.of(user3, user5);
        List<ExternalUserInfoDto> actual = service.getFilteredDtos(dto);

        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected.get(0).getLocation(), actual.get(0).getLocation());
        Assertions.assertEquals(expected.get(0).getAnswerCount(), actual.get(0).getAnswerCount());
        Assertions.assertEquals(expected.get(0).getReputation(), actual.get(0).getReputation());
        Assertions.assertEquals(expected.get(1).getLocation(), actual.get(1).getLocation());
        Assertions.assertEquals(expected.get(1).getAnswerCount(), actual.get(1).getAnswerCount());
        Assertions.assertEquals(expected.get(1).getReputation(), actual.get(1).getReputation());
    }
}