package pak.entity.relation;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /*
     * better to not use below commented code, because:
     * avoids recursion,
     * simpler.
     */
    //@ManyToMany(mappedBy = "authors")
    //private Set<Book> books = new HashSet<>();

}
