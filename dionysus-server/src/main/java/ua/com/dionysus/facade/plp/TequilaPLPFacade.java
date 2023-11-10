package ua.com.dionysus.facade.plp;

import ua.com.dionysus.data.dto.product.plp.LiqueurPLPDto;
import ua.com.dionysus.data.dto.product.plp.TequilaPLPDto;

import java.util.Collection;

public interface TequilaPLPFacade {

    Collection<TequilaPLPDto> findAll();
}
