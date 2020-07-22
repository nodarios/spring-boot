package pak.datajpa.entity.relation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    private Integer id;
    private String name;
    private String password;

    @OneToOne(mappedBy = "user")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user")
    private List<UserProfile2> userProfile2 = new ArrayList<>();
}
