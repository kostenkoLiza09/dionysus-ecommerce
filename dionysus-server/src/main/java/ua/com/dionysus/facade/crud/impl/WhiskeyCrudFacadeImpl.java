package ua.com.dionysus.facade.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.dto.WhiskeyDto;
import ua.com.dionysus.facade.crud.WhiskeyCrudFacade;
import ua.com.dionysus.persistence.sql.models.product.WhiskeyProduct;
import ua.com.dionysus.persistence.sql.type.CountryType;
import ua.com.dionysus.persistence.sql.type.whiskey.WhiskeyBrandType;
import ua.com.dionysus.persistence.sql.type.whiskey.WhiskeyRegionType;
import ua.com.dionysus.persistence.sql.type.whiskey.WhiskeyStyleType;
import ua.com.dionysus.service.product.WhiskeyCrudService;

import java.util.List;

@Service
public class WhiskeyCrudFacadeImpl implements WhiskeyCrudFacade {


    private final WhiskeyCrudService whiskeyCrudService;

    public WhiskeyCrudFacadeImpl(WhiskeyCrudService whiskeyCrudService) {
        this.whiskeyCrudService = whiskeyCrudService;
    }

    @Override
    public void create(WhiskeyDto dto) {
        WhiskeyProduct whiskeyProduct = new WhiskeyProduct();
        whiskeyProduct.setWhiskeyBrandType(WhiskeyBrandType.valueOf(dto.getWhiskeyBrandType()));
        whiskeyProduct.setWhiskeyRegionType(WhiskeyRegionType.valueOf(dto.getWhiskeyRegionType()));
        whiskeyProduct.setWhiskeyStyleType(WhiskeyStyleType.valueOf(dto.getWhiskeyStyleType()));

        whiskeyProduct.setCountryType(CountryType.valueOf(dto.getCountryType()));
        whiskeyProduct.setName(dto.getName());
        whiskeyProduct.setDescription(dto.getDescription());
        whiskeyProduct.setAge(dto.getAge());
        whiskeyProduct.setAlcohol_by_volume(dto.getAlcohol_by_volume());

        whiskeyProduct.setQuantity(dto.getQuantity());
        whiskeyProduct.setVolume(dto.getVolume());
        whiskeyProduct.setPrice(dto.getPrice());
        whiskeyCrudService.create(whiskeyProduct);
    }

    @Override
    public void update(Long id, WhiskeyDto dto) {

        WhiskeyProduct whiskeyProduct = whiskeyCrudService.findById(id);
        whiskeyProduct.setWhiskeyBrandType(WhiskeyBrandType.valueOf(dto.getWhiskeyBrandType()));
        whiskeyProduct.setWhiskeyRegionType(WhiskeyRegionType.valueOf(dto.getWhiskeyRegionType()));
        whiskeyProduct.setWhiskeyStyleType(WhiskeyStyleType.valueOf(dto.getWhiskeyStyleType()));

        whiskeyProduct.setCountryType(CountryType.valueOf(dto.getCountryType()));
        whiskeyProduct.setName(dto.getName());
        whiskeyProduct.setDescription(dto.getDescription());
        whiskeyProduct.setAge(dto.getAge());
        whiskeyProduct.setAlcohol_by_volume(dto.getAlcohol_by_volume());

        whiskeyProduct.setQuantity(dto.getQuantity());
        whiskeyProduct.setVolume(dto.getVolume());
        whiskeyCrudService.create(whiskeyProduct);
    }

    @Override
    public void delete(Long id) {
    whiskeyCrudService.delete(id);
    }

    @Override
    public WhiskeyDto findById(Long id) {
        return new WhiskeyDto(whiskeyCrudService.findById(id));    }

    @Override
    public DataTableResponse<WhiskeyDto> findAll(DataTableRequest request) {
        Page<WhiskeyProduct> page = whiskeyCrudService.findAll(request);
        DataTableResponse<WhiskeyDto> dataTableResponse = new DataTableResponse<WhiskeyDto>(request, page);
        List<WhiskeyDto> list = page.getContent().stream().map(WhiskeyDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }
}
