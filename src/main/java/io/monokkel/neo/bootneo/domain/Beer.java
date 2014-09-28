package io.monokkel.neo.bootneo.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

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

    public Beer(String name, String description) {
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
