package ua.com.dionysus.facade.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.dto.LiqueurDto;
import ua.com.dionysus.facade.crud.LiqueurCrudFacade;
import ua.com.dionysus.persistence.sql.models.product.LiqueurProduct;
import ua.com.dionysus.persistence.sql.type.CountryType;
import ua.com.dionysus.persistence.sql.type.liqueur.LiqueurBrandType;
import ua.com.dionysus.persistence.sql.type.liqueur.LiqueurRegionType;
import ua.com.dionysus.persistence.sql.type.liqueur.LiqueurStyleType;
import ua.com.dionysus.service.product.LiqueurCrudService;

import java.util.List;

@Service
public class LiqueurCrudFacadeImpl implements LiqueurCrudFacade {

    private final LiqueurCrudService liqueurCrudService;

    public LiqueurCrudFacadeImpl(LiqueurCrudService liqueurCrudService) {
        this.liqueurCrudService = liqueurCrudService;
    }

    @Override
    public void create(LiqueurDto dto) {
        LiqueurProduct   liqueurProduct = new LiqueurProduct();
        liqueurProduct.setLiqueurBrandType(LiqueurBrandType.valueOf(dto.getLiqueurBrandType()));
        liqueurProduct.setLiqueurStyleType(LiqueurStyleType.valueOf(dto.getLiqueurStyleType()));
        liqueurProduct.setLiqueurRegionType(LiqueurRegionType.valueOf(dto.getLiqueurRegionType()));

        liqueurProduct.setCountryType(CountryType.valueOf(dto.getCountryType()));
        liqueurProduct.setName(dto.getName());
        liqueurProduct.setDescription(dto.getDescription());
        liqueurProduct.setAge(dto.getAge());
        liqueurProduct.setAlcohol_by_volume(dto.getAlcohol_by_volume());

        liqueurProduct.setQuantity(dto.getQuantity());
        liqueurProduct.setVolume(dto.getVolume());
        liqueurProduct.setPrice(dto.getPrice());
        liqueurCrudService.create(liqueurProduct);
    }

    @Override
    public void update(Long id, LiqueurDto dto) {
        LiqueurProduct   liqueurProduct = liqueurCrudService.findById(id);
        liqueurProduct.setLiqueurBrandType(LiqueurBrandType.valueOf(dto.getLiqueurBrandType()));
        liqueurProduct.setLiqueurStyleType(LiqueurStyleType.valueOf(dto.getLiqueurStyleType()));
        liqueurProduct.setLiqueurRegionType(LiqueurRegionType.valueOf(dto.getLiqueurRegionType()));

        liqueurProduct.setCountryType(CountryType.valueOf(dto.getCountryType()));
        liqueurProduct.setName(dto.getName());
        liqueurProduct.setDescription(dto.getDescription());
        liqueurProduct.setAge(dto.getAge());
        liqueurProduct.setAlcohol_by_volume(dto.getAlcohol_by_volume());

        liqueurProduct.setQuantity(dto.getQuantity());
        liqueurProduct.setVolume(dto.getVolume());
        liqueurProduct.setPrice(dto.getPrice());
        liqueurCrudService.create(liqueurProduct);

    }

    @Override
    public void delete(Long id) {
        liqueurCrudService.delete(id);

    }

    @Override
    public LiqueurDto findById(Long id) {
        return new LiqueurDto(liqueurCrudService.findById(id));
    }

    @Override
    public DataTableResponse<LiqueurDto> findAll(DataTableRequest request) {
        Page<LiqueurProduct> page = liqueurCrudService.findAll(request);
        DataTableResponse<LiqueurDto> dataTableResponse = new DataTableResponse<LiqueurDto>(request, page);
        List<LiqueurDto> list = page.getContent().stream().map(LiqueurDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }
}
