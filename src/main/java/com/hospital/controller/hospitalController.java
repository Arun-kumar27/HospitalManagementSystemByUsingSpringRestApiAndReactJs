package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.DTO.hospitalDto;
import com.hospital.Entity.hospitalEntity;
import com.hospital.Service.hospitalService;

import jakarta.validation.Valid;

@RestController
@Validated
@CrossOrigin("http://localhost:5173/")
public class hospitalController 
{
	@Autowired
	private hospitalService service;
	//These http method is used to perform insertion operation in the form JSON format
	@PostMapping("/login")
	public ResponseEntity<hospitalEntity> loginDetails(@Valid @RequestBody hospitalDto dto)
	{
		return service.insertdetails(dto);
	}
	//These http method is used to perform the update operation.
	//These method is also send the data in the JSON format.
	@PutMapping("/update")
	public ResponseEntity<String> updatdetails(@RequestBody hospitalEntity entity)
	{
		return service.updateresultofthepatientbyusongemalid(entity);
	}
	
	//These HTTP method is used to perform the select or get mapping operation.
	//In these method user send the data in the url format.
	@GetMapping("/get")
	public List<hospitalEntity> getallthedataofthepatient(@RequestParam("value") String value)
	{
		 return service.getThePateintDataByUsingNameOrGender(value, value, value);
	}
	
	//These HTTP method is used to perform delete operation or delete mapping.
	//In these method user send the request request in the URL format.
	@DeleteMapping("/delete")
	public int deletethepatientdetailsbyusingname(@RequestParam("name") String name)
	{
		return service.deletethedata(name);
	}
	

}
