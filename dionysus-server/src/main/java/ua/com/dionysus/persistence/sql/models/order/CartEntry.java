package ua.com.dionysus.persistence.sql.models.order;

import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.BaseEntity;
import ua.com.dionysus.persistence.sql.BaseProduct;
import ua.com.dionysus.persistence.sql.models.product.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "cart_entries")
public class CartEntry extends BaseEntity {

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private BaseProduct baseProduct;

    @Column(nullable = false)
    private Integer quantity;

    public CartEntry() {
        quantity = 0;
    }
}