package io.monokkel.neo.bootneo.repositories;

import io.monokkel.neo.bootneo.domain.Beer;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by astensby on 28/09/14.
 */
@RepositoryRestResource(collectionResourceRel = "beer", path = "beer")
public interface BeerRepository extends GraphRepository<Beer> {

}
