package pak.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pak.validators.IsNationalityGeo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GreetingDto {

    private long id;

    private String content;

    @IsNationalityGeo(message = "nationality is not valid")
    private String nationality;

}
