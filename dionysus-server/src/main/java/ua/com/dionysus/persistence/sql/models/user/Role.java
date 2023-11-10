package ua.com.dionysus.persistence.sql.models.user;
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;


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

    public Role() { }

    public Role(String name) {
        this.name = name;
    }


    public Role(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return name;
    }

}