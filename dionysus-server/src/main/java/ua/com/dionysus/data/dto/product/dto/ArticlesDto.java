package ua.com.dionysus.data.dto.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.dionysus.data.dto.BaseDto;
import ua.com.dionysus.persistence.sql.models.product.Articles;


@Getter
@Setter
@NoArgsConstructor
public class ArticlesDto extends BaseDto {

    private String name;
    private String description;
    private String imagUrl;

    public ArticlesDto(Articles articles) {
        setId(articles.getId());
        this.name = articles.getName();
        this.description = articles.getDescription();
        this.imagUrl = articles.getImagUrl();
    }
}
