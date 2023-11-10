package ua.com.dionysus.controller.open;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.dionysus.data.dto.product.plp.*;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.facade.plp.*;

import java.util.Collection;

@RestController
@RequestMapping("products/")
public class ProductsPLPController {

    private final WinePLPFacade winePLPFacade;
    private final TequilaPLPFacade tequilaPLPFacade;
    private final RumPLPFacade rumPLPFacade;
    private final WhiskeyPLPFacade whiskeyPLPFacade;
    private final LiqueurPLPFacade liqueurPLPFacade;

    public ProductsPLPController(WinePLPFacade winePLPFacade,
                                 TequilaPLPFacade tequilaPLPFacade,
                                 RumPLPFacade rumPLPFacade,
                                 WhiskeyPLPFacade whiskeyPLPFacade,
                                 LiqueurPLPFacade liqueurPLPFacade) {
        this.winePLPFacade = winePLPFacade;
        this.tequilaPLPFacade = tequilaPLPFacade;
        this.rumPLPFacade = rumPLPFacade;
        this.whiskeyPLPFacade = whiskeyPLPFacade;
        this.liqueurPLPFacade = liqueurPLPFacade;
    }

    @GetMapping("whiskey/plp")

    public ResponseEntity<DataContainer<Collection<WhiskeyPLPDto>>> getWhiskeyPLP() {
        return ResponseEntity.ok(new DataContainer<>(whiskeyPLPFacade.findAll()));
    }

    @GetMapping("wine/plp")
    public ResponseEntity<DataContainer<Collection<WinePLPDto>>> getWinePLP() {
        return ResponseEntity.ok(new DataContainer<>(winePLPFacade.findAll()));
    }

    @GetMapping("tequila/plp")
    public ResponseEntity<DataContainer<Collection<TequilaPLPDto>>> getTequilaPLP() {
        return ResponseEntity.ok(new DataContainer<>(tequilaPLPFacade.findAll()));
    }

    @GetMapping("rum/plp")
    public ResponseEntity<DataContainer<Collection<RumPLPDto>>> getRumPLP() {
        return ResponseEntity.ok(new DataContainer<>(rumPLPFacade.findAll()));
    }


    @GetMapping("liqueur/plp")
    public ResponseEntity<DataContainer<Collection<LiqueurPLPDto>>> getLiqueurPLP() {
        return ResponseEntity.ok(new DataContainer<>(liqueurPLPFacade.findAll()));
    }
}