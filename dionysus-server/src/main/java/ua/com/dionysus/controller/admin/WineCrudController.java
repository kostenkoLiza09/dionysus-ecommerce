package ua.com.dionysus.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.dto.WineDto;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.facade.crud.WineCrudFacade;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("product/wine")
public class WineCrudController {

    private final WineCrudFacade wineCrudFacade;

    public WineCrudController(WineCrudFacade wineCrudFacade) {
        this.wineCrudFacade = wineCrudFacade;
    }


    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> createWine(@RequestBody WineDto dto) {
        wineCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> updateWine(@RequestBody WineDto dto, @PathVariable Long id) {
        wineCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> deleteWine(@PathVariable Long id) {
        wineCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<WineDto>> findByIdWine(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(wineCrudFacade.findById(id)));
    }


    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<WineDto>>> findAllWine(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sort,
            @RequestParam String order) {
        DataTableRequest request = new DataTableRequest();
        request.setPage(page);
        request.setSize(size);
        request.setSort(sort);
        request.setOrder(order);
        return ResponseEntity.ok(new DataContainer<>(wineCrudFacade.findAll(request)));
    }
}
