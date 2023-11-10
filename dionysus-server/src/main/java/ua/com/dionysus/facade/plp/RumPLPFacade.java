package ua.com.dionysus.facade.plp;

import ua.com.dionysus.data.dto.product.plp.LiqueurPLPDto;
import ua.com.dionysus.data.dto.product.plp.RumPLPDto;

import java.util.Collection;

public interface RumPLPFacade {

    Collection<RumPLPDto> findAll();
}
