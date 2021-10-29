package pak.dtos;

import lombok.Getter;
import lombok.Setter;
import pak.enums.Country;

@Getter
@Setter
public class GreetingDto {

    private long id;
    private String content;
    private String nationality;

}
