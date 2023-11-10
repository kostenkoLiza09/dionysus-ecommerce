package ua.com.dionysus.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.dto.WhiskeyDto;
import ua.com.dionysus.data.response.DataContainer;

import ua.com.dionysus.facade.crud.WhiskeyCrudFacade;

@RestController
@RequestMapping("product/whiskey")
public class WhiskeyCrudController {

    private final WhiskeyCrudFacade whiskeyCrudFacade;

    public WhiskeyCrudController(WhiskeyCrudFacade whiskeyCrudFacade) {
        this.whiskeyCrudFacade = whiskeyCrudFacade;
    }

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> createWhiskey(@RequestBody WhiskeyDto dto) {
        whiskeyCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> updateWhiskey(@RequestBody WhiskeyDto dto, @PathVariable Long id) {
        whiskeyCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> deleteWhiskey(@PathVariable Long id) {
        whiskeyCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<WhiskeyDto>> findByIdWhiskey(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(whiskeyCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<WhiskeyDto>>> findAllWhiskey(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sort,
            @RequestParam String order) {
        DataTableRequest request = new DataTableRequest();
        request.setPage(page);
        request.setSize(size);
        request.setSort(sort);
        request.setOrder(order);
        return ResponseEntity.ok(new DataContainer<>(whiskeyCrudFacade.findAll(request)));
    }
}