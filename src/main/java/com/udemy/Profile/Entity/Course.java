package com.udemy.Profile.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="topic")
    private String topic;

    @Column(name="branch")
    private String branch;

    @Column(name="duration")
    private int duration_in_hours;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="instructor_id")
    private Instructor instructor;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="course_id")
    private List<Review> reviews=new ArrayList<>();;


    public void addReview(Review review){

        this.reviews.add(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Course() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getDuration_in_hours() {
        return duration_in_hours;
    }

    public void setDuration_in_hours(int duration_in_hours) {
        this.duration_in_hours = duration_in_hours;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }



}
