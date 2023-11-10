package ua.com.dionysus.persistence.sql.models.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.BaseEntity;

@Entity
@Getter
@Setter
@Table(name = "articles")
public class Articles extends BaseEntity {


    @Column(nullable = false)
    private String imagUrl;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;


}
