package pak.entities.relation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@Setter
@Getter
public abstract class Person {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String lastName;

    //@Version
    //private long version;

}
