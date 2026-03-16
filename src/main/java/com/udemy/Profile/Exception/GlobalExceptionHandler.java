package com.udemy.Profile.Exception;

import com.udemy.Profile.ApiResponse.ApiResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(InstructorNotFound.class)
    public ResponseEntity<ApiResponse<String>> InstructorNotFound(InstructorNotFound nf){
                  return new ResponseEntity<>(new ApiResponse<>(    "Not found",false,nf.getMessage()), HttpStatus.NOT_FOUND);
}

@ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGeneric(Exception e){
    return new ResponseEntity<>(new ApiResponse<>("Hey Some issue is there which leads to exception",false,e.getMessage()),HttpStatus.NOT_FOUND);

}
}
