package pak.entities.embed;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
public class Address {

    private String country;

    private String city;

    private String street;

    private String house;

    private String postcode;

}
