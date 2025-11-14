package com.hospital.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospital.DAO.hospitalDAO;
import com.hospital.DTO.hospitalDto;
import com.hospital.Entity.hospitalEntity;
import com.hospital.Exception.InvalidDataEntry;

@Service
public class hospitalService
{
	@Autowired
	hospitalDAO dao;
	@Autowired
	ModelMapper mapper;
	public ResponseEntity<hospitalEntity> insertdetails(hospitalDto dto)
	{
		hospitalEntity entity=mapper.map(dto, hospitalEntity.class);
	    hospitalEntity result=dao.hospitaldao(entity);
	    if(result.getId()!=0)
	    {
	    	return new ResponseEntity<hospitalEntity>(result,HttpStatus.CREATED);
	    }
	    else
	    {
	    	return new ResponseEntity<hospitalEntity>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	//update operation 
	public ResponseEntity<String> updateresultofthepatientbyusongemalid(hospitalEntity hospitalEntity)
	{
		int data=dao.updatepatientdetailsBususingEmalid(hospitalEntity);
		if(data!=0)
		{
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else
		{
			throw new InvalidDataEntry("invalid data entry");
		}
	}
	
	
	//Select operation by using EMAILID or gender or name;
	public List<hospitalEntity> getThePateintDataByUsingNameOrGender(String name,String gender,String emailid)
	{
	 	return dao.findAllTheDataByUsingAnyField(name, gender, emailid);
	}
	
	//Delete operation by using name
	public int deletethedata(String name)
	{
		 return dao.deletetehpatientdata(name);
	}
}
