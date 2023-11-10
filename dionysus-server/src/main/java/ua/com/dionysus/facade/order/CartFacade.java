package ua.com.dionysus.facade.order;

import ua.com.dionysus.data.dto.order.CartDto;
import ua.com.dionysus.data.dto.order.CartEntryDto;

public interface CartFacade {


    void add(CartEntryDto dto);
    void update(CartEntryDto dto);

    void remove(CartEntryDto dto);
    void clear();
    CartDto findActive();
}
