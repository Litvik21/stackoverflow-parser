package test.stackoverflow.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExternalUserInfoDto {
    private Long user_id;
    private String location;
    private String profileUrl;
    private String link;
    private String profile_image;
    private String display_name;
    private Long answer_count;
    private Long question_count;
    private Long reputation;
}
