package ua.com.dionysus.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.dto.TequilaDto;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.facade.crud.TequilaCrudFacade;

@RestController
@RequestMapping("product/tequila")
public class TequilaCrudController {

    private final TequilaCrudFacade tequilaCrudFacade;

    public TequilaCrudController(TequilaCrudFacade tequilaCrudFacade) {
        this.tequilaCrudFacade = tequilaCrudFacade;
    }

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> createTequila(@RequestBody TequilaDto dto) {
        tequilaCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> updateTequila(@RequestBody TequilaDto dto, @PathVariable Long id) {
        tequilaCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> deleteTequila(@PathVariable Long id) {
        tequilaCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<TequilaDto>> findByIdWhiskey(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(tequilaCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<TequilaDto>>> findAllWhiskey(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sort,
            @RequestParam String order) {
        DataTableRequest request = new DataTableRequest();
        request.setPage(page);
        request.setSize(size);
        request.setSort(sort);
        request.setOrder(order);
        return ResponseEntity.ok(new DataContainer<>(tequilaCrudFacade.findAll(request)));
    }
}