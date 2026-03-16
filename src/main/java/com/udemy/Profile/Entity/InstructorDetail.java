package com.udemy.Profile.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
    public InstructorDetail() {
    }

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @Column(name="utube_link")
    private String youtubeChannelLink;
    @Column(name="hobby")
    private String hobby;

    @JsonBackReference
    @OneToOne(mappedBy = "instructorDetail")
    private Instructor instructor;



    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannelLink() {
        return youtubeChannelLink;
    }

    public void setYoutubeChannelLink(String youtubeChannelLink) {
        this.youtubeChannelLink = youtubeChannelLink;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


}
