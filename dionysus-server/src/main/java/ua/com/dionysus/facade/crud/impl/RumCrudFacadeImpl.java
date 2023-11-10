package ua.com.dionysus.facade.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.product.dto.RumDto;
import ua.com.dionysus.facade.crud.RumCrudFacade;
import ua.com.dionysus.persistence.sql.models.product.RumProduct;
import ua.com.dionysus.persistence.sql.type.CountryType;
import ua.com.dionysus.persistence.sql.type.rum.RumBrandType;
import ua.com.dionysus.persistence.sql.type.rum.RumRegionType;
import ua.com.dionysus.persistence.sql.type.rum.RumStyleType;
import ua.com.dionysus.service.product.RumCrudService;

import java.util.List;

@Service
public class RumCrudFacadeImpl implements RumCrudFacade {

    private final RumCrudService rumCrudService;

    public RumCrudFacadeImpl(RumCrudService rumCrudService) {
        this.rumCrudService = rumCrudService;
    }

    @Override
    public void create(RumDto dto) {
        RumProduct rumProduct = new RumProduct();
        rumProduct.setRumBrandType(RumBrandType.valueOf(dto.getRumBrandType()));
        rumProduct.setRumStyleType(RumStyleType.valueOf(dto.getRumStyleType()));
        rumProduct.setRumRegionType(RumRegionType.valueOf(dto.getRumRegionType()));

        rumProduct.setCountryType(CountryType.valueOf(dto.getCountryType()));
        rumProduct.setName(dto.getName());
        rumProduct.setDescription(dto.getDescription());
        rumProduct.setAge(dto.getAge());
        rumProduct.setAlcohol_by_volume(dto.getAlcohol_by_volume());

        rumProduct.setQuantity(dto.getQuantity());
        rumProduct.setVolume(dto.getVolume());
        rumProduct.setPrice(dto.getPrice());
        rumCrudService.create(rumProduct);
    }

    @Override
    public void update(Long id, RumDto dto) {
        RumProduct rumProduct = rumCrudService.findById(id);
        rumProduct.setRumBrandType(RumBrandType.valueOf(dto.getRumBrandType()));
        rumProduct.setRumStyleType(RumStyleType.valueOf(dto.getRumStyleType()));
        rumProduct.setRumRegionType(RumRegionType.valueOf(dto.getRumRegionType()));

        rumProduct.setCountryType(CountryType.valueOf(dto.getCountryType()));
        rumProduct.setName(dto.getName());
        rumProduct.setDescription(dto.getDescription());
        rumProduct.setAge(dto.getAge());
        rumProduct.setAlcohol_by_volume(dto.getAlcohol_by_volume());

        rumProduct.setQuantity(dto.getQuantity());
        rumProduct.setVolume(dto.getVolume());
        rumCrudService.create(rumProduct);
    }

    @Override
    public void delete(Long id) {
    rumCrudService.delete(id);
    }

    @Override
    public RumDto findById(Long id) {
        return new RumDto(rumCrudService.findById(id));
    }

    @Override
    public DataTableResponse<RumDto> findAll(DataTableRequest request) {
        Page<RumProduct> page = rumCrudService.findAll(request);
        DataTableResponse<RumDto> dataTableResponse = new DataTableResponse<RumDto>(request, page);
        List<RumDto> list = page.getContent().stream().map(RumDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }
}
