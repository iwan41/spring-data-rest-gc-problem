package com.springdatarest.memory.overflow;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people2", path = "people2")
public interface Person2Repository extends PagingAndSortingRepository<Person2, Long> {

    List<Person> findByLastName(@Param("name") String name);

}