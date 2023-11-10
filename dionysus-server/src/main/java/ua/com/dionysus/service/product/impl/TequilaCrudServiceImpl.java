package ua.com.dionysus.service.product.impl;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.persistence.sql.models.product.TequilaProduct;
import ua.com.dionysus.persistence.sql.repository.product.TequilaRepository;
import ua.com.dionysus.service.crud.CrudHelperService;
import ua.com.dionysus.service.product.TequilaCrudService;

import java.util.Collection;

@Service
@Transactional
public class TequilaCrudServiceImpl implements TequilaCrudService {

    private final TequilaRepository tequilaRepository;


    private final CrudHelperService<TequilaProduct, TequilaRepository> crudHelperService;

    public TequilaCrudServiceImpl(TequilaRepository tequilaRepository,
                                  CrudHelperService<TequilaProduct, TequilaRepository> crudHelperService) {
        this.tequilaRepository = tequilaRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(TequilaProduct entity) {
        crudHelperService.create(entity, tequilaRepository);
    }

    @Override
    public void update(TequilaProduct entity) {
        crudHelperService.update(entity, tequilaRepository);

    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, tequilaRepository);
    }

    @Override
    public TequilaProduct findById(Long id) {
        return crudHelperService.findById(id, tequilaRepository);

    }



    @Override
    public Page<TequilaProduct> findAll(DataTableRequest dataTableRequest) {
        return crudHelperService.findAll(dataTableRequest, tequilaRepository);

    }

    @Override
    public Collection<TequilaProduct> findAll() {
        return tequilaRepository.findAll();    }
}
