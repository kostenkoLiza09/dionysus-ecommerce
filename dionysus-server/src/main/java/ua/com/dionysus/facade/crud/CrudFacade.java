package ua.com.dionysus.facade.crud;

import ua.com.dionysus.data.dataTable.DataTableRequest;
import ua.com.dionysus.data.dataTable.DataTableResponse;
import ua.com.dionysus.data.dto.BaseDto;

public interface CrudFacade <DTO extends BaseDto>{

    void create(DTO dto);

    void update(Long id, DTO dto);

    void delete(Long id);
    DTO findById(Long id);
    DataTableResponse<DTO> findAll (DataTableRequest request);

}
