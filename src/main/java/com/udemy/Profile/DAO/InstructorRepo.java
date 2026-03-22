package com.udemy.Profile.DAO;

import com.udemy.Profile.Entity.Instructor;


import java.util.List;

public interface InstructorRepo {
    public String saveInstructor(Instructor instructor);
    public List<Instructor> getAllInstructor();
    public Instructor getInstructorById(int id);
    public Instructor updateInstructor(Instructor instructor);
    public void deleteInstructor(int id);
    public Instructor getInstructorAndCourseByJoinFetch(int id);
}
