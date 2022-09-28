package pak.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pak.enums.Country;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MyEntityDto {

    private Long id;

    private String name;

    private String info;

    private Country country;

    private Long titleId;

}
