package test.stackoverflow.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExternalItemsUserDto {
    private ExternalUserInfoDto[] items;
}
