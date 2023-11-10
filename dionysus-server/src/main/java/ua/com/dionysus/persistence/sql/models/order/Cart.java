package ua.com.dionysus.persistence.sql.models.order;

import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.BaseEntity;
import ua.com.dionysus.persistence.sql.models.user.User;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart extends BaseEntity {


    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date created;

    @ManyToOne
    private User user;

    @Column(name = "active")
    private Boolean active;

    public Cart() {
        this.created = new Date();
        this.active = true;
    }
}