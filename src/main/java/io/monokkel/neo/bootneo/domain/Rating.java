package io.monokkel.neo.bootneo.domain;

import org.springframework.data.neo4j.annotation.*;

/**
 * Created by astensby on 07/10/14.
 */
@RelationshipEntity(type="RATED")
public class Rating {

    @GraphId
    Long id;

    @Fetch
    @StartNode
    Person person;

    @Fetch
    @EndNode
    Beer beer;

    Long rating;

    public Rating() {

    }

    public Rating(Person person, Beer beer, Long rating) {
        this.person = person;
        this.beer = beer;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
