package io.monokkel.neo.bootneo.domain;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by astensby on 24/08/14.
 */
@NodeEntity
public class Beer {

    @GraphId
    public Long nodeId;

    @Indexed(unique = true)
    public long id;

    public String name;
    public String description;

    @Fetch
    @RelatedToVia(type="RATED", direction = Direction.INCOMING)
    Set<Rating> ratings = new HashSet<Rating>();

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public Beer(){

    }

    public Beer(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
