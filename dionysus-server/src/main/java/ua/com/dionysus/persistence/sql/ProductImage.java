package ua.com.dionysus.persistence.sql;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.type.AlcoholType;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_images")
public class ProductImage extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "alcohol_type", nullable = false)
    private AlcoholType alcoholType;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "main_image", nullable = false)
    private Boolean mainImage;

    @ManyToMany(mappedBy = "productImages")
    private Set<BaseProduct> products = new HashSet<>();

    public ProductImage() {
        super();
        this.mainImage = false;
    }
}
