package pak.entity.relation;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class User extends Person {

    /*
     * better to not use below commented code, because:
     * avoids recursion,
     * simpler.
     */
    //@JsonManagedReference // to solve: Could not write JSON: Infinite recursion
    //@OneToOne(mappedBy = "user")
    //private UserProfile userProfile;

    /*
     * better to not use below commented code, because:
     * avoids recursion,
     * simpler.
     */
    //@JsonManagedReference // to solve: Could not write JSON: Infinite recursion
    //@OneToMany(mappedBy = "user")
    //private List<UserProfile2> userProfile2 = new ArrayList<>();

}
