package ua.com.dionysus.persistence.sql.models.product;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import ua.com.dionysus.persistence.sql.BaseProduct;
import ua.com.dionysus.persistence.sql.type.rum.RumBrandType;
import ua.com.dionysus.persistence.sql.type.rum.RumRegionType;
import ua.com.dionysus.persistence.sql.type.rum.RumStyleType;

@Getter
@Setter
@Entity
@DiscriminatorValue("rum_products")
public class RumProduct extends BaseProduct {

    @Enumerated(EnumType.STRING)
    @Column(name = "rum_brand", nullable = false, updatable = false)
    private RumBrandType rumBrandType;

    @Enumerated(EnumType.STRING)
    @Column(name = "rum_region", nullable = false, updatable = false)
    private RumRegionType rumRegionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "rum_style", nullable = false, updatable = false)
    private RumStyleType rumStyleType;
}