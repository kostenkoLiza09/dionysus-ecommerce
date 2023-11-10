package ua.com.dionysus.data.dto.product.plp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.models.product.Articles;
import ua.com.dionysus.persistence.sql.models.product.LiqueurProduct;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ArticlesPLPDto {

    private Long id;
    private String name;
    private String imagUrl;

    public ArticlesPLPDto(Articles articles) {
        this.id = articles.getId();
        this.name = articles.getName();
        this.imagUrl = articles.getImagUrl();

    }
}
