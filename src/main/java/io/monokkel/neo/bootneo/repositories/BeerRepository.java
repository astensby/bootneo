package io.monokkel.neo.bootneo.repositories;

import io.monokkel.neo.bootneo.domain.Beer;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by astensby on 28/09/14.
 */
@RepositoryRestResource(collectionResourceRel = "beer", path = "beer")
public interface BeerRepository extends GraphRepository<Beer> {

    List<Beer> findByName(@Param("0") String name);

    @Query("MATCH (b:Beer) WHERE b.name=~{regexp} RETURN b")
    List<Beer> findByNameRegexp(@Param("regexp") String regexp);

}
