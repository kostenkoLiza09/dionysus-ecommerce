package ua.com.dionysus.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.dionysus.data.dto.product.ProductProcessDto;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.facade.process.ProductProcessFacade;

@RestController
@RequestMapping("products/{id}/process")
public class ProductProcessController {

    private final ProductProcessFacade productProcessFacade;

    public ProductProcessController(ProductProcessFacade productProcessFacade) {
        this.productProcessFacade = productProcessFacade;
    }

    @PutMapping("/wine/attach")
    public ResponseEntity<DataContainer<Boolean>> attachWine
            (@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.attachWine(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @PutMapping("/whiskey/attach")
    public ResponseEntity<DataContainer<Boolean>> attachWhiskey
            (@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.attachWhiskey(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @PutMapping("/liqueur/attach")
    public ResponseEntity<DataContainer<Boolean>> attachLiqueur
            (@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.attachLiqueur(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @PutMapping("/rum/attach")
    public ResponseEntity<DataContainer<Boolean>> attachRum
            (@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.attachRum(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @PutMapping("/tequila/attach")
    public ResponseEntity<DataContainer<Boolean>> attachTequila
            (@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.attachTequila(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @PutMapping("/wine/detach")
    public ResponseEntity<DataContainer<Boolean>> detachWine
            (@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.detachWine(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @PutMapping("/whiskey/detach")
    public ResponseEntity<DataContainer<Boolean>> detachWhiskey
            (@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.detachWhiskey(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @PutMapping("/liqueur/detach")
    public ResponseEntity<DataContainer<Boolean>> detachLiqueur
            (@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.detachLiqueur(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @PutMapping("/rum/detach")
    public ResponseEntity<DataContainer<Boolean>> detachRum
            (@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.detachRum(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @PutMapping("/tequila/detach")
    public ResponseEntity<DataContainer<Boolean>> detachTequila
            (@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.detachWine(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }
}