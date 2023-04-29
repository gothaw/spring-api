package com.radsoltan.column;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ColumnRepository extends PagingAndSortingRepository<Column, Long> {
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @columnRepository.findOne(#id)?.user?.username == authentication.name")
    void deleteById(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #column.user.username == authentication.name")
    void delete(@Param("column") Column entity);
}
