package ua.com.dionysus.controller.open;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.dionysus.data.dto.product.pdp.ArticlesPDPDto;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.facade.pdp.ArticlesPDPFacade;

@RestController
@RequestMapping("articles/{id}/pdp")
public class ArticlesPDPController {

    private final ArticlesPDPFacade articlesPDPFacade;

    public ArticlesPDPController(ArticlesPDPFacade articlesPDPFacade) {
        this.articlesPDPFacade = articlesPDPFacade;
    }

    @GetMapping()
    public ResponseEntity<DataContainer<ArticlesPDPDto>> findByRum(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(articlesPDPFacade.findById(id)));
    }
}
