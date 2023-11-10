package ua.com.dionysus.persistence.sql.models.product;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.BaseProduct;
import ua.com.dionysus.persistence.sql.type.whiskey.WhiskeyBrandType;
import ua.com.dionysus.persistence.sql.type.whiskey.WhiskeyRegionType;
import ua.com.dionysus.persistence.sql.type.whiskey.WhiskeyStyleType;

@Getter
@Setter
@Entity
@DiscriminatorValue("whiskey_products")
public class WhiskeyProduct extends BaseProduct {

    @Enumerated(EnumType.STRING)
    @Column(name= "whiskey_brand",nullable = false, updatable = false)
    private WhiskeyBrandType whiskeyBrandType;

    @Enumerated(EnumType.STRING)
    @Column(name= "whiskey_region",nullable = false, updatable = false)
    private WhiskeyRegionType whiskeyRegionType;

    @Enumerated(EnumType.STRING)
    @Column(name= "whiskey_style",nullable = false, updatable = false)
    private WhiskeyStyleType whiskeyStyleType;

}
