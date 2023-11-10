package ua.com.dionysus.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.dto.LiqueurDto;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.facade.crud.LiqueurCrudFacade;

@RestController
@RequestMapping("product/liqueur")
public class LiqueurCrudController {

    private final LiqueurCrudFacade liqueurCrudFacade;

    public LiqueurCrudController(LiqueurCrudFacade liqueurCrudFacade) {
        this.liqueurCrudFacade = liqueurCrudFacade;
    }

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> createLiqueur(@RequestBody LiqueurDto dto) {
        liqueurCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> updateLiqueur(@RequestBody LiqueurDto dto, @PathVariable Long id) {
        liqueurCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> deleteLiqueur(@PathVariable Long id) {
        liqueurCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<LiqueurDto>> findByIdLiqueur(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(liqueurCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<LiqueurDto>>> findAllLiqueur(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sort,
            @RequestParam String order) {
        DataTableRequest request = new DataTableRequest();
        request.setPage(page);
        request.setSize(size);
        request.setSort(sort);
        request.setOrder(order);
        return ResponseEntity.ok(new DataContainer<>(liqueurCrudFacade.findAll(request)));
    }
}
