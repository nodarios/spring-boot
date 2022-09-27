package pak.entities.embed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Embedded
    @AttributeOverride(name = "country", column = @Column(name = "address_country"))
    @AttributeOverride(name = "city", column = @Column(name = "address_city"))
    @AttributeOverride(name = "street", column = @Column(name = "address_street"))
    @AttributeOverride(name = "house", column = @Column(name = "address_house"))
    @AttributeOverride(name = "postcode", column = @Column(name = "address_postcode"))
    private Address address;

}
