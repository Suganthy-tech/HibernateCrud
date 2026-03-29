package com.udemy.Profile.DAO;

public class updateCourseRequest {
    public  int course_id;
    public  String comments;
 public int rating;

    public int getRating() {
        return rating;
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getComments() {
        return comments;
    }
}
