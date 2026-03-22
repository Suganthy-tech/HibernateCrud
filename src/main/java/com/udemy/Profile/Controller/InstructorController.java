package com.udemy.Profile.Controller;

import com.udemy.Profile.ApiResponse.ApiResponse;
import com.udemy.Profile.Entity.Instructor;
import com.udemy.Profile.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    private final InstructorService instructorService;
@Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<String>> saveInstructor(@RequestBody Instructor instructor){
      String mes=  this.instructorService.saveInstructor(instructor);

  ApiResponse api= new ApiResponse<String>(mes,true,mes);
return new ResponseEntity<>(api,HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Instructor>> getAllInstructor(){
    List<Instructor> mes=this.instructorService.getAllInstructors();
    return new ResponseEntity<>(mes,HttpStatus.OK);
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable int instructorId){
    Instructor inst=this.instructorService.getInstructorByIdAll(instructorId);
return new ResponseEntity<>(inst,HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor){
    Instructor inst=this.instructorService.updateInstructor(instructor);
            return new ResponseEntity<>(inst,HttpStatus.OK);
    }
  @DeleteMapping("/{instructorId}")
    public ResponseEntity<String> deleteInstructor(@PathVariable int instructorId){
    this.instructorService.deleteInstructor(instructorId);
    return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK);
  }



}
