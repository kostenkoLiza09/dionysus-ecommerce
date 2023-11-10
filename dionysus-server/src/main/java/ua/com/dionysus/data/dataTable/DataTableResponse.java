package ua.com.dionysus.data.dataTable;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import ua.com.dionysus.data.dto.BaseDto;
import ua.com.dionysus.persistence.sql.BaseEntity;

import java.util.ArrayList;
import java.util.Collection;


@Getter
@Setter
public class DataTableResponse<DTO extends BaseDto> {

    private int page;
    private int size;
    private int totalPages;
    private long totalElements;
    private boolean first;
    private boolean last;
    private boolean next;
    private boolean previous;
    private String sort;
    private String order;
    private Collection<DTO> items;

    public <E extends BaseEntity> DataTableResponse(DataTableRequest request, Page<E> page) {
        this.page = request.getPage();
        this.size = request.getSize();
        this.sort = request.getSort();
        this.order = request.getOrder();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.first = page.isFirst();
        this.last = page.isLast();
        this.next = page.hasNext();
        this.previous = page.hasPrevious();
        this.items = new ArrayList<>();
    }
}
