package test.stackoverflow.dto.tag;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ExternalItemsTagDto {
    private ExternalTagDto[] items;
}
