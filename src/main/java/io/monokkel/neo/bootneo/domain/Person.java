package io.monokkel.neo.bootneo.domain;

import org.springframework.data.neo4j.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Person {

    @GraphId
    private Long nodeId;

    @Indexed(unique = true)
    private int id;

    private String firstName;

    private String lastName;

    @Fetch
    @RelatedToVia(type = "RATED")
    private Set<Rating> ratings = new HashSet<Rating>();

    @RelatedTo(type = "FAVORITE")
    private Beer favorite;

    public Beer getFavorite() {
        return favorite;
    }

    public void setFavorite(Beer favorite) {
        this.favorite = favorite;
    }

    public Rating rates(Beer beer, Long rating) {
        Rating r = new Rating(this, beer, rating);
        ratings.add(r);
        return r;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }


    public Person() {
    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Long getNodeId() {
        return nodeId;
    }


    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
