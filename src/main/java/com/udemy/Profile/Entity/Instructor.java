package com.udemy.Profile.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
public class Instructor {

    public Instructor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail instructorDetail;

    @JsonManagedReference
    @OneToMany(mappedBy = "instructor",  cascade =  {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,},
            fetch = FetchType.LAZY)
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course cor){
        if(this.courses==null){
            this.courses=new ArrayList<>();
        }
        this.courses.add(cor);
        cor.setInstructor(this);
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }
}
