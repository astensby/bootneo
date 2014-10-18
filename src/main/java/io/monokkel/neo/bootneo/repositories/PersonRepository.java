package io.monokkel.neo.bootneo.repositories;

import io.monokkel.neo.bootneo.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {


    //Named parameters using @Param and spring-data-rest is currently not supported for Neo4j
    List<Person> findByFirstName(@Param("0") String name);
    //In other words - this is currently not supported:
    //List<Person> findByFirstName(@Param("name") String name);

    //Using @Param and spring-data-rest is however supported in combination with @Query in Neo4j
    @Query("MATCH (p:Person{firstName:{name}}) RETURN p")
    List<Person> getPersonWithFirstName(@Param("name") String name);


}
