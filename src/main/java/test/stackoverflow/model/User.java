package test.stackoverflow.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long externalId;
    private String username;
    private String location;
    private Long answerCount;
    private Long questionCount;
    private String tags;
    private String profileLink;
    private String avatarLink;

    @Override
    public String toString() {
        return "User {" +
                " username='" + username + '\'' +
                ", location='" + location + '\'' +
                ", answerCount=" + answerCount +
                ", questionCount=" + questionCount +
                ", tags='" + tags + '\'' +
                ", profileLink='" + profileLink + '\'' +
                ", avatarLink='" + avatarLink + '\'' +
                ", externalId=" + externalId +
                '}' + '\n';
    }
}
