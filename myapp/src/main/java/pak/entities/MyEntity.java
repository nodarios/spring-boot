package pak.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pak.entities.converter.TitleConverter;
import pak.enums.Country;
import pak.enums.Title;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({
        @NamedQuery(name = "my-entity.search-by-info",
                query = "select e from MyEntity e where e.info = :info")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "my-entity.search-by-info2",
                query = "select * from my_entity e where e.info = :info",
                resultClass = MyEntity.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class MyEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_myentity")
    @SequenceGenerator(name = "seq_myentity", sequenceName = "seq_myentity", allocationSize = 1, initialValue = 5)
    private Long id;

    @Column(nullable = false, unique = true, length = 2000)
    private String name;

    private String info;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(nullable = false)
    @Convert(converter = TitleConverter.class)
    private Title title;

}
