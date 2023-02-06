package test.stackoverflow.dto.mapper;

import org.springframework.stereotype.Component;
import test.stackoverflow.dto.user.ExternalUserInfoDto;
import test.stackoverflow.model.User;

@Component
public class UserMapper {
    public User toModel(ExternalUserInfoDto dto) {
        User user = new User();
        user.setExternalId(dto.getUser_id());
        user.setUsername(dto.getDisplay_name());
        user.setLocation(dto.getLocation());
        user.setAvatarLink(dto.getProfile_image());
        user.setProfileLink(dto.getLink());
        user.setAnswerCount(dto.getAnswer_count());
        user.setQuestionCount(dto.getQuestion_count());

        return user;
    }
}
