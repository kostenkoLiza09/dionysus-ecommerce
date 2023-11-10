package ua.com.dionysus.facade.plp;

import ua.com.dionysus.data.dto.product.plp.LiqueurPLPDto;
import ua.com.dionysus.data.dto.product.plp.WinePLPDto;

import java.util.Collection;

public interface WinePLPFacade {

    Collection<WinePLPDto> findAll();
}
