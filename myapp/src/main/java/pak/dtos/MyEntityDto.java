package pak.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pak.enums.Country;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MyEntityDto {

    private Long id;

    private String name;

    private String info;

    private Country country;

    private Long titleId;

}
