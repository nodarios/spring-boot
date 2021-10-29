package pak.entities.convert;

import lombok.Getter;
import lombok.Setter;
import pak.enums.Country;
import pak.enums.Title;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Convert(converter = TitleConverter.class)
    private Title title;

}
