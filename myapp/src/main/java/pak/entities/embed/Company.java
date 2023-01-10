package pak.entities.embed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
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

    @ElementCollection
    @CollectionTable(
            name = "emails"//,
            //joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"),
            //foreignKey = @ForeignKey(name = "fk_name")
    )
    @Column(name = "email")
    private List<String> emails = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "Addresses"//,
            //joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"),
            //foreignKey = @ForeignKey(name = "fk_name")
    )
    @AttributeOverride(name = "country", column = @Column(name = "address_country"))
    @AttributeOverride(name = "city", column = @Column(name = "address_city"))
    @AttributeOverride(name = "street", column = @Column(name = "address_street"))
    @AttributeOverride(name = "house", column = @Column(name = "address_house"))
    @AttributeOverride(name = "postcode", column = @Column(name = "address_postcode"))
    private List<Address> Addresses = new ArrayList<>();

}
