package pak.datajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seq_myentity", sequenceName = "seq_myentity", allocationSize = 50, initialValue = 4)
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
@Getter
@Setter
public class MyEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_myentity")
    @Column(name = "application_id")
    private Long id;

    @Column(name = "app_name", nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    private String owner;

    public MyEntity(String name, String owner,
                    String description) {
        this.name = name;
        this.owner = owner;
        this.description = description;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", description='" + description + '\'' +
                '}';
    }

}
