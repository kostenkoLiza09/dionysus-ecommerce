package ua.com.dionysus.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.ProductImageDto;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.facade.crud.ProductImageCrudFacade;
import ua.com.dionysus.util.WebRequestUtil;

@RestController
@RequestMapping("product-images")
public class ProductImageCrudController {

    private final ProductImageCrudFacade productImageCrudFacade;

    public ProductImageCrudController(ProductImageCrudFacade productImageCrudFacade) {
        this.productImageCrudFacade = productImageCrudFacade;
    }

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> create(@RequestBody ProductImageDto dto) {
        productImageCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> update(@RequestBody ProductImageDto dto, @PathVariable Long id) {
        productImageCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> delete(@PathVariable Long id) {
        productImageCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<ProductImageDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(productImageCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<ProductImageDto>>> findAll(WebRequest webRequest) {
        DataTableRequest request = WebRequestUtil.generateDataTableRequest(webRequest);
        return ResponseEntity.ok(new DataContainer<>(productImageCrudFacade.findAll(request)));
    }
}