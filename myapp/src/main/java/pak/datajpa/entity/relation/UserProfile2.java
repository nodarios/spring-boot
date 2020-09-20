package pak.datajpa.entity.relation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class UserProfile2 {
    @Id
    private Integer id;
    private int age;
    private String gender;

    /** to solve: Could not write JSON: Infinite recursion */
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
