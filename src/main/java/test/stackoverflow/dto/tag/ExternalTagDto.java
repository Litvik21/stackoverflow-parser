package test.stackoverflow.dto.tag;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExternalTagDto {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
