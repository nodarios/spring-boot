package pak.entities.relation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    /*
     * to avoid recursion
     * 1. comment out one side of double linkage, as shown below.
     * 2. can use appropriate json annotations, but in this case must use only lists instead of sets.
     * 3. use DTOs without recursion.
     */
    //@ManyToMany(mappedBy = "authors")
    //private Set<Book> books = new HashSet<>();

}
