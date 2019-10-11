package pak.datajpa.entity;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="seq_myentity", sequenceName = "seq_myentity", allocationSize=50)
public class MyEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_myentity")
    @Column(name="application_id")
    private Integer id;

    @Column(name = "app_name", nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    private String owner;

    public MyEntity() {
    }

    public MyEntity(String name, String owner,
                    String description) {
        this.name = name;
        this.owner = owner;
        this.description = description;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", description='" + description + '\'' +
                '}';
    }
}
