package ua.com.dionysus.persistence.sql;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.type.CountryType;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "product_type")
public class BaseProduct extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "country", nullable = false, updatable = false)
    private CountryType countryType;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = true)
    private Integer age;


    @Column(nullable = true)
    private Double alcohol_by_volume;

    @Column(nullable = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;

    @Column(nullable = true)
    private Integer quantity;


    @Column(nullable = true)
    private Integer volume;


    @ManyToMany
    @JoinTable(
            name="product_image",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name="product_image_id")
    )
    private Set<ProductImage> productImages = new HashSet<>();
}