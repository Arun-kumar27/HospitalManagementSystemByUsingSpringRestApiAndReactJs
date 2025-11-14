package com.hospital.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HospitalException {
	  @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) 
	  {
	          Map<String, String> map = new HashMap<>();

	        ex.getBindingResult().getAllErrors().forEach(error -> {
	            String fieldName = ((FieldError) error).getField();
	            String errorMessage = error.getDefaultMessage();
	            map.put(fieldName, errorMessage);
	        });
	      return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
	    }
	    
	  @ExceptionHandler(InvalidDataEntry.class)
	  public ResponseEntity<String> invalidDataEntryExceptionHandler(InvalidDataEntry invalid)
	  {
		 String msg=invalid.getMsg();
		 return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
	  }
	  

}
