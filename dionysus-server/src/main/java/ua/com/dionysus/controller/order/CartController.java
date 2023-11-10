package ua.com.dionysus.controller.order;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.dionysus.data.dto.order.CartDto;
import ua.com.dionysus.data.dto.order.CartEntryDto;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.facade.order.CartFacade;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {


    private CartFacade cartFacade;


    @GetMapping
    public ResponseEntity<DataContainer<CartDto>> getCart() {
        return ResponseEntity.ok(new DataContainer<>(cartFacade.findActive()));
    }

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> add(@RequestBody CartEntryDto cartEntryDto) {
        cartFacade.add(cartEntryDto);
        return ResponseEntity.ok(new DataContainer<>(Boolean.TRUE));
    }
}
