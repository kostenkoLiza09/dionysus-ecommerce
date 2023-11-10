package ua.com.dionysus.controller.open;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.dionysus.data.dto.product.plp.ArticlesPLPDto;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.facade.plp.ArticlesPLPFacade;

import java.util.Collection;

@RestController
@RequestMapping("articles/plp")
public class ArticlesPLPController {

    private final ArticlesPLPFacade articlesPLPFacade;

    public ArticlesPLPController(ArticlesPLPFacade articlesPLPFacade) {
        this.articlesPLPFacade = articlesPLPFacade;
    }

    @GetMapping()

    public ResponseEntity<DataContainer<Collection<ArticlesPLPDto>>> getArticlesPLP() {
        return ResponseEntity.ok(new DataContainer<>(articlesPLPFacade.findAll()));
    }
}
