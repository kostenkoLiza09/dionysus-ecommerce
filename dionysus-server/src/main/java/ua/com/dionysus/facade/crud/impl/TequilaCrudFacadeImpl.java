package ua.com.dionysus.facade.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.dto.TequilaDto;
import ua.com.dionysus.facade.crud.TequilaCrudFacade;
import ua.com.dionysus.persistence.sql.models.product.TequilaProduct;
import ua.com.dionysus.persistence.sql.type.CountryType;
import ua.com.dionysus.persistence.sql.type.tequila.TequilaBrandType;
import ua.com.dionysus.persistence.sql.type.tequila.TequilaRegionType;
import ua.com.dionysus.persistence.sql.type.tequila.TequilaStyleType;
import ua.com.dionysus.service.product.TequilaCrudService;

import java.util.List;

@Service
public class TequilaCrudFacadeImpl implements TequilaCrudFacade {

    private final TequilaCrudService tequilaCrudService;

    public TequilaCrudFacadeImpl(TequilaCrudService tequilaCrudService) {
        this.tequilaCrudService = tequilaCrudService;
    }

    @Override
    public void create(TequilaDto dto) {
        TequilaProduct tequilaProduct = new TequilaProduct();
        tequilaProduct.setTequilaBrandType(TequilaBrandType.valueOf(dto.getTequilaBrandType()));
        tequilaProduct.setTequilaRegionType(TequilaRegionType.valueOf(dto.getTequilaRegionType()));
        tequilaProduct.setTequilaStyleType(TequilaStyleType.valueOf(dto.getTequilaStyleType()));

        tequilaProduct.setCountryType(CountryType.valueOf(dto.getCountryType()));
        tequilaProduct.setName(dto.getName());
        tequilaProduct.setDescription(dto.getDescription());
        tequilaProduct.setAge(dto.getAge());
        tequilaProduct.setAlcohol_by_volume(dto.getAlcohol_by_volume());

        tequilaProduct.setQuantity(dto.getQuantity());
        tequilaProduct.setVolume(dto.getVolume());
        tequilaProduct.setPrice(dto.getPrice());
        tequilaCrudService.create(tequilaProduct);

    }

    @Override
    public void update(Long id, TequilaDto dto) {
        TequilaProduct tequilaProduct = tequilaCrudService.findById(id);
        tequilaProduct.setTequilaBrandType(TequilaBrandType.valueOf(dto.getTequilaBrandType()));
        tequilaProduct.setTequilaRegionType(TequilaRegionType.valueOf(dto.getTequilaRegionType()));
        tequilaProduct.setTequilaStyleType(TequilaStyleType.valueOf(dto.getTequilaStyleType()));

        tequilaProduct.setCountryType(CountryType.valueOf(dto.getCountryType()));
        tequilaProduct.setName(dto.getName());
        tequilaProduct.setDescription(dto.getDescription());
        tequilaProduct.setAge(dto.getAge());
        tequilaProduct.setAlcohol_by_volume(dto.getAlcohol_by_volume());

        tequilaProduct.setQuantity(dto.getQuantity());
        tequilaProduct.setVolume(dto.getVolume());
        tequilaCrudService.create(tequilaProduct);
    }

    @Override
    public void delete(Long id) {
    tequilaCrudService.delete(id);
    }

    @Override
    public TequilaDto findById(Long id) {
        return new TequilaDto(tequilaCrudService.findById(id));

    }

    @Override
    public DataTableResponse<TequilaDto> findAll(DataTableRequest request) {
        Page<TequilaProduct> page = tequilaCrudService.findAll(request);
        DataTableResponse<TequilaDto> dataTableResponse = new DataTableResponse<TequilaDto>(request, page);
        List<TequilaDto> list = page.getContent().stream().map(TequilaDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }
}
