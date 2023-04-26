package com.radsoltan.storey;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface StoreyRepository extends PagingAndSortingRepository<Storey, Long> {

    @RestResource(rel = "label-contains", path = "containsLabel")
    Page<Storey> findByLabelContaining(@Param("label") String label, Pageable page);
}
