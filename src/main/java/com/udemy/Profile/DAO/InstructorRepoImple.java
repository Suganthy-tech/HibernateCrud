package com.udemy.Profile.DAO;

import com.udemy.Profile.Entity.Course;
import com.udemy.Profile.Entity.Instructor;
import com.udemy.Profile.Entity.Review;
import com.udemy.Profile.Exception.InstructorNotFound;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    for(Course c:inst.getCourses()){
        c.setInstructor(instructor);
    }
    inst.setCourses(instructor.getCourses());

     return   inst;
    }

    @Transactional
    @Override
    public void deleteInstructor(int id) {
        Instructor inst=this.em.find(Instructor.class,id);
        if(inst==null){
            throw new InstructorNotFound("Hey There is no data for it");
        }
        for(Course c:inst.getCourses()){
            c.setInstructor(null);
        }
        inst.getCourses().clear();
        this.em.remove(inst);
    }

    @Override
    public Instructor getInstructorAndCourseByJoinFetch(int id) {
        TypedQuery<Instructor> query=this.em.createQuery("Select i from Instructor i left join fetch i.courses c join fetch c.reviews  where i.id=:data",Instructor.class);
        query.setParameter("data",id);
        List<Instructor> l=query.getResultList();
       return l.stream()
                .findFirst()
                .orElseThrow(() ->
                        new InstructorNotFound("Instructor not found with id " + id));
    }

    @Transactional
    @Override
    public String addCourseReview(int id, Review review) {
       Course cour= this.em.find(Course.class, id);
       cour.addReview(review);
       return "Review Added";
    }


}
