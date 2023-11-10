package ua.com.dionysus.controller.open;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.dionysus.data.dto.product.pdp.*;
import ua.com.dionysus.data.response.DataContainer;
import ua.com.dionysus.facade.pdp.*;

@RestController
@RequestMapping("products/")
public class ProductsPDPController {

    private final WinePDPFacade winePDPFacade;
    private final TequilaPDPFacade tequilaPDPFacade;
    private final RumPDPFacade rumPDPFacade;
    private final WhiskeyPDPFacade whiskeyPDPFacade;
    private final LiqueurPDPFacade liqueurPDPFacade;

    public ProductsPDPController(WinePDPFacade winePDPFacade,
                                 TequilaPDPFacade tequilaPDPFacade,
                                 RumPDPFacade rumPDPFacade,
                                 WhiskeyPDPFacade whiskeyPDPFacade,
                                 LiqueurPDPFacade liqueurPDPFacade) {
        this.winePDPFacade = winePDPFacade;
        this.tequilaPDPFacade = tequilaPDPFacade;
        this.rumPDPFacade = rumPDPFacade;
        this.whiskeyPDPFacade = whiskeyPDPFacade;
        this.liqueurPDPFacade = liqueurPDPFacade;
    }


    @GetMapping("wine/{id}/pdp")

    public ResponseEntity<DataContainer<WinePDPDto>> findByWine(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(winePDPFacade.findById(id)));
    }

    @GetMapping("tequila/{id}/pdp")
    public ResponseEntity<DataContainer<TequilaPDPDto>> findByTequila(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(tequilaPDPFacade.findById(id)));
    }

    @GetMapping("rum/{id}/pdp")
    public ResponseEntity<DataContainer<RumPDPDto>> findByRum(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(rumPDPFacade.findById(id)));
    }

    @GetMapping("whiskey/{id}/pdp")
    public ResponseEntity<DataContainer<WhiskeyPDPDto>> findByWhiskey(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(whiskeyPDPFacade.findById(id)));
    }

    @GetMapping("liqueur/{id}/pdp")
    public ResponseEntity<DataContainer<LiqueurPDPDto>> findByLiqueur(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(liqueurPDPFacade.findById(id)));
    }
}