package ua.com.dionysus.data.dto.product.pdp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.models.product.Articles;
import ua.com.dionysus.persistence.sql.models.product.LiqueurProduct;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ArticlesPDPDto {

    private Long id;
    private String name;
    private String imagUrl;
    private String description;

    public ArticlesPDPDto(Articles articles) {
        this.id = articles.getId();
        this.name = articles.getName();
        this.imagUrl = articles.getImagUrl();
        this.description = articles.getDescription();

    }
}
