package com.udemy.Profile.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="review")
public class Review {
    public Review() {
    }
    public Review( int rating, String comments) {

        this.rating = rating;
        this.comments = comments;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

@Column(name="rating")
    private int rating;

    @Column(length=1000)
    private String comments;


}
