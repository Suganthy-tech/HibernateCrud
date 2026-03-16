package com.udemy.Profile.Service;

import com.udemy.Profile.DAO.InstructorRepoImple;
import com.udemy.Profile.Entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepoImple instructorRepoImple;
@Autowired
    public InstructorService(InstructorRepoImple instructorRepoImple) {
        this.instructorRepoImple = instructorRepoImple;
    }

    public String saveInstructor(Instructor instructor){
        return this.instructorRepoImple.saveInstructor(instructor);
    }

    public List<Instructor> getAllInstructors(){
    return this.instructorRepoImple.getAllInstructor();
    }
    public Instructor getInstructorById(int id){
    return this.instructorRepoImple.getInstructorById(id);
    }
    public Instructor updateInstructor(Instructor inst){
    return this.instructorRepoImple.updateInstructor(inst);
    }
}
