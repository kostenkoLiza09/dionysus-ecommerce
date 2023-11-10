package ua.com.dionysus.facade.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.dto.WineDto;
import ua.com.dionysus.facade.crud.WineCrudFacade;
import ua.com.dionysus.persistence.sql.models.product.WineProduct;
import ua.com.dionysus.persistence.sql.type.CountryType;
import ua.com.dionysus.persistence.sql.type.wine.WineBrandType;
import ua.com.dionysus.persistence.sql.type.wine.WineRegionType;
import ua.com.dionysus.persistence.sql.type.wine.WineStyleType;
import ua.com.dionysus.persistence.sql.type.wine.WineVarietalType;
import ua.com.dionysus.service.product.WineCrudService;

import java.util.List;

@Service
public class WineCrudFacadeImpl implements WineCrudFacade {

    private final WineCrudService wineCrudService;

    public WineCrudFacadeImpl(WineCrudService wineCrudService) {
        this.wineCrudService = wineCrudService;
    }

    @Override
    public void create(WineDto dto) {
        WineProduct wineProduct = new WineProduct();
        wineProduct.setWineBrandType(WineBrandType.valueOf(dto.getWineBrandType()));
        wineProduct.setWineRegionType(WineRegionType.valueOf(dto.getWineRegionType()));
        wineProduct.setWineStyleType(WineStyleType.valueOf(dto.getWineStyleType()));
        wineProduct.setWineVarietalType(WineVarietalType.valueOf(dto.getWineVarietalType()));

        wineProduct.setCountryType(CountryType.valueOf(dto.getCountryType()));
        wineProduct.setName(dto.getName());
        wineProduct.setDescription(dto.getDescription());
        wineProduct.setAge(dto.getAge());
        wineProduct.setAlcohol_by_volume(dto.getAlcohol_by_volume());

        wineProduct.setVolume(dto.getVolume());
        wineProduct.setQuantity(dto.getQuantity());
        wineProduct.setPrice(dto.getPrice());
        wineCrudService.create(wineProduct);
    }

    @Override
    public void update(Long id, WineDto dto) {
        WineProduct wineProduct = wineCrudService.findById(id);
        wineProduct.setWineBrandType(WineBrandType.valueOf(dto.getWineBrandType()));
        wineProduct.setWineRegionType(WineRegionType.valueOf(dto.getWineRegionType()));
        wineProduct.setWineStyleType(WineStyleType.valueOf(dto.getWineStyleType()));
        wineProduct.setWineVarietalType(WineVarietalType.valueOf(dto.getWineVarietalType()));

        wineProduct.setCountryType(CountryType.valueOf(dto.getCountryType()));
        wineProduct.setName(dto.getName());
        wineProduct.setDescription(dto.getDescription());
        wineProduct.setAge(dto.getAge());
        wineProduct.setAlcohol_by_volume(dto.getAlcohol_by_volume());

        wineProduct.setVolume(dto.getVolume());
        wineProduct.setQuantity(dto.getQuantity());
        wineCrudService.create(wineProduct);

    }

    @Override
    public void delete(Long id) {
    wineCrudService.delete(id);
    }

    @Override
    public WineDto findById(Long id) {
        return new WineDto(wineCrudService.findById(id));
    }

    @Override
    public DataTableResponse<WineDto> findAll(DataTableRequest request) {
        Page<WineProduct> page = wineCrudService.findAll(request);
        DataTableResponse<WineDto> dataTableResponse = new DataTableResponse<WineDto>(request, page);
        List<WineDto> list = page.getContent().stream().map(WineDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }
}
