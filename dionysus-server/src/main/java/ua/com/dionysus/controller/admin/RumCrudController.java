package ua.com.dionysus.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.dto.RumDto;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.facade.crud.RumCrudFacade;

@RestController
@RequestMapping("product/rum")
public class RumCrudController {

    private final RumCrudFacade rumCrudFacade;

    public RumCrudController(RumCrudFacade rumCrudFacade) {
        this.rumCrudFacade = rumCrudFacade;
    }

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> createRum(@RequestBody RumDto dto) {
        rumCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> updateRum(@RequestBody RumDto dto, @PathVariable Long id) {
        rumCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> deleteRum(@PathVariable Long id) {
        rumCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<RumDto>> findByIdRum(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(rumCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<RumDto>>> findAllRum(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "desc") String sort,
            @RequestParam(defaultValue = "id") String order) {
        DataTableRequest request = new DataTableRequest();
        request.setPage(page);
        request.setSize(size);
        request.setSort(sort);
        request.setOrder(order);
        return ResponseEntity.ok(new DataContainer<>(rumCrudFacade.findAll(request)));
    }
}
