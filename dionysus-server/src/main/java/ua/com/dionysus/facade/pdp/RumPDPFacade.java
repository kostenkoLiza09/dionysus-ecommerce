package ua.com.dionysus.facade.pdp;

import ua.com.dionysus.data.dto.product.pdp.LiqueurPDPDto;
import ua.com.dionysus.data.dto.product.pdp.RumPDPDto;

public interface RumPDPFacade {

   RumPDPDto findById(Long id);
}
