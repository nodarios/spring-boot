package pak.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pak.enums.Country;
import pak.validators.IsNameValid;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MyEntityDto {

    private Long id;

    @IsNameValid(message = "name is not valid")
    private String name;

    private String info;

    @NotNull
    private Country country;

    @NotNull
    @Min(1)
    @Max(4)
    private Long titleId;

}
