package pak.dtos;

import lombok.Getter;
import lombok.Setter;
import pak.enums.Country;

@Getter
@Setter
public class GreetingPojo {

    private long id;
    private String content;
    private Country country;

}
