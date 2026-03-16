package com.udemy.Profile.DAO;

import com.udemy.Profile.Entity.Instructor;
import com.udemy.Profile.Exception.InstructorNotFound;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorRepoImple implements InstructorRepo{

    private final EntityManager em;
@Autowired
    public InstructorRepoImple(EntityManager em) {
        this.em = em;
    }
@Transactional
    @Override
    public String saveInstructor(Instructor instructor) {

        this.em.persist(instructor);
        return "Hey Instructor details saved successfully";
    }

    @Override
    public List<Instructor> getAllInstructor() {
        TypedQuery<Instructor> query=this.em.createQuery(" FROM Instructor",Instructor.class);


        List<Instructor> list=query.getResultList();
        if(list==null||list.size()==0){
            throw new InstructorNotFound("We dont have this instuctor with this id");
        }
        return query.getResultList();

    }

    @Override
    public Instructor getInstructorById(int id) {

        Instructor inst= this.em.find(Instructor.class,id);
        if(inst==null){
            throw new InstructorNotFound("Hey There is no data for it");
        }
        return inst;
    }

@Transactional
    @Override
    public Instructor updateInstructor(Instructor instructor) {
    Instructor inst=this.em.find(Instructor.class,instructor.getId());
    if(inst==null){
        throw new InstructorNotFound("Hey There is no data for it");
    }
    inst.setEmail(instructor.getEmail());
    inst.setFirstName(instructor.getFirstName());
    inst.setLastName(instructor.getLastName());
    inst.setCourses(instructor.getCourses());

     return   inst;
    }


}
