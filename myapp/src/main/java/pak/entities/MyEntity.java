package pak.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({
        @NamedQuery(name = "MyEntity.searchByOwner",
                query = "SELECT b FROM MyEntity b WHERE b.owner = :owner")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "MyEntity.searchByDescription",
                query = "SELECT * FROM MY_ENTITY b WHERE b.description = :description",
                resultClass = MyEntity.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class MyEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_myentity")
    @SequenceGenerator(name = "seq_myentity", sequenceName = "seq_myentity", allocationSize = 1, initialValue = 4)
    @Column(name = "application_id")
    private Long id;

    @Column(name = "app_name", nullable = false, unique = true, length = 2000)
    private String name;

    private String description;

    private String owner;

}
