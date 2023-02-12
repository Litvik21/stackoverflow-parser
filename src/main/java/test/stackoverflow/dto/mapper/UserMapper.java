package test.stackoverflow.dto.mapper;

import org.springframework.stereotype.Component;
import test.stackoverflow.dto.user.ExternalUserInfoDto;
import test.stackoverflow.model.User;

@Component
public class UserMapper {
    public User toModel(ExternalUserInfoDto dto) {
        User user = new User();
        user.setExternalId(dto.getUserId());
        user.setUsername(dto.getDisplayName());
        user.setLocation(dto.getLocation());
        user.setAvatarLink(dto.getProfileImage());
        user.setProfileLink(dto.getLink());
        user.setAnswerCount(dto.getAnswerCount());
        user.setQuestionCount(dto.getQuestionCount());

        return user;
    }
}
