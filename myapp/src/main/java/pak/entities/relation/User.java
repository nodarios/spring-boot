package pak.entities.relation;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_table")
public class User extends Person {

    @JsonManagedReference // to solve: Could not write JSON: Infinite recursion
    @OneToOne(mappedBy = "user")
    private UserProfile userProfile;

    @JsonManagedReference // to solve: Could not write JSON: Infinite recursion
    @OneToMany(mappedBy = "user")
    private List<UserProfile2> userProfile2 = new ArrayList<>();

}
