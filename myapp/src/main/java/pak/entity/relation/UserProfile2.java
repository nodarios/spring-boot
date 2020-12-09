package pak.entity.relation;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserProfile2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer age;
    private String gender;

    //@JsonBackReference // to solve: Could not write JSON: Infinite recursion
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
