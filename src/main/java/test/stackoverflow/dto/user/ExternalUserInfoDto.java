package test.stackoverflow.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExternalUserInfoDto {
    @JsonProperty(value = "user_id")
    private Long userId;
    private String location;
    private String profileUrl;
    private String link;
    @JsonProperty(value = "profile_image")
    private String profileImage;
    @JsonProperty(value = "display_name")
    private String displayName;
    @JsonProperty(value = "answer_count")
    private Long answerCount;
    @JsonProperty(value = "question_count")
    private Long questionCount;
    private Long reputation;
}
