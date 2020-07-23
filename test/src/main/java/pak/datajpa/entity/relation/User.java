package pak.datajpa.entity.relation;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    private Integer id;
    private String name;
    private String password;

    /** to solve: Could not write JSON: Infinite recursion */
    @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private UserProfile userProfile;

    /** to solve: Could not write JSON: Infinite recursion */
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<UserProfile2> userProfile2 = new ArrayList<>();
}
