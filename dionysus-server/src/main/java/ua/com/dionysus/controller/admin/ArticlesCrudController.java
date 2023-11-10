package ua.com.dionysus.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.dto.ArticlesDto;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.facade.crud.ArticlesCrudFacade;

@RestController
@RequestMapping("articles")
public class ArticlesCrudController {

    private final ArticlesCrudFacade articlesCrudFacade;


    public ArticlesCrudController(ArticlesCrudFacade articlesCrudFacade) {
        this.articlesCrudFacade = articlesCrudFacade;
    }

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> createArticles(@RequestBody ArticlesDto dto) {
        articlesCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> updateArticles(@RequestBody ArticlesDto dto, @PathVariable Long id) {
        articlesCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> deleteArticles(@PathVariable Long id) {
        articlesCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<ArticlesDto>> findByIdArticles(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(articlesCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<ArticlesDto>>> findAllArticles(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sort,
            @RequestParam String order) {
        DataTableRequest request = new DataTableRequest();
        request.setPage(page);
        request.setSize(size);
        request.setSort(sort);
        request.setOrder(order);
        return ResponseEntity.ok(new DataContainer<>(articlesCrudFacade.findAll(request)));
    }
}
