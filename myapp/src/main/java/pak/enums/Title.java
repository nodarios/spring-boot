package pak.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Title {

    JUNIOR(1L),
    MIDDLE(2L),
    SENIOR(3L),
    LEAD(4L);

    private final Long id;

    public static Title getById(Long id) {
        return Arrays
                .stream(values())
                .filter(title -> title.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
