package pak.entity.relation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Setter
@Getter
public class UserProfile2 {

    @Id
    @GeneratedValue
    private UUID id;

    private Integer age;

    private String gender;

    @JsonBackReference // to solve: Could not write JSON: Infinite recursion
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
