package com.makers.makersbnb.model;

import jakarta.persistence.*;


@Entity                     // @Entity - instances of this class map to database records
@Table(name = "SPACES")     // @Table - those records can be found in the spaces table
public class Space {


    @Id // the following field (id) is the primary key for this Entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // the value of id is generated automatically
    private Long id;

    private String name; // a second field that holds the name of each space
    private String description; // a second field that holds the description of each space
    private Integer price; // a second field that holds the price of each space


    public Space() {}   // a zero-arguments constructor

    public Space(String name, String description, Integer price) { // a 3-argument constructor
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getter and Setter methods for each field
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getPrice() { return this.price; }
    public void setPrice(Integer price) { this.price = price; }

}