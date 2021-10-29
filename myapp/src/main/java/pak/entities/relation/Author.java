package pak.entities.relation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Setter
@Getter
public class Author {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    /*
     * below code is commented to avoid recursion, but lacks double linkage.
     * better to use appropriate json annotations.
     */
    //@ManyToMany(mappedBy = "authors")
    //private Set<Book> books = new HashSet<>();

}
