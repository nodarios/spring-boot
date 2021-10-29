package pak.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Country {

    GEO(1L),
    USA(2L);

    private final Long id;

    public static Country getById(Long id) throws Exception {
        return Arrays
                .stream(values())
                .filter(title -> title.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("country not found"));
    }

}
