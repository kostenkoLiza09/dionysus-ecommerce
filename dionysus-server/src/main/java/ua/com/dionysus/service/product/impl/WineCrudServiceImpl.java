package ua.com.dionysus.service.product.impl;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.persistence.sql.models.product.WineProduct;
import ua.com.dionysus.persistence.sql.repository.product.WineRepository;
import ua.com.dionysus.service.crud.CrudHelperService;
import ua.com.dionysus.service.product.WineCrudService;

import java.util.Collection;

@Service
@Transactional
public class WineCrudServiceImpl implements WineCrudService {

    private final WineRepository wineRepository;


    private final CrudHelperService<WineProduct, WineRepository> crudHelperService;

    public WineCrudServiceImpl(WineRepository wineRepository, CrudHelperService<WineProduct,
                               WineRepository> crudHelperService) {
        this.wineRepository = wineRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(WineProduct entity) {
        crudHelperService.create(entity, wineRepository);

    }

    @Override
    public void update(WineProduct entity) {
        crudHelperService.update(entity, wineRepository);
    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, wineRepository);

    }

    @Override
    public WineProduct findById(Long id) {
        return crudHelperService.findById(id, wineRepository);
    }

    @Override
    public Page<WineProduct> findAll(DataTableRequest dataTableRequest) {
        return crudHelperService.findAll(dataTableRequest, wineRepository);
    }

    @Override
    public Collection<WineProduct> findAll() {
        return wineRepository.findAll();
    }
}
