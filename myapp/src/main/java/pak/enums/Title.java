package pak.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pak.exception.AppException;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Title {

    JUNIOR(1L),
    MIDDLE(2L),
    SENIOR(3L),
    LEAD(4L);

    private final Long id;

    public static Title valueOf(Long id) {
        return Arrays
                .stream(values())
                .filter(title -> title.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new AppException(ErrorType.INVALID_DATA));
    }

}
