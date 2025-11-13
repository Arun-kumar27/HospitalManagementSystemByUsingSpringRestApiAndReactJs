package com.hospital.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.Entity.hospitalEntity;
import com.hospital.Repository.hospitalRespositiry;

@Repository
public class hospitalDAO 
{
	@Autowired
	hospitalRespositiry respositiry;
	public hospitalEntity hospitaldao(hospitalEntity hospitalEntity)
	{
		return respositiry.save(hospitalEntity);
	}
	public int updatepatientdetailsBususingEmalid(hospitalEntity entity) 
	{
		
		return  respositiry.updateBloodTestAndSugarTestBysuingEmalid(entity.getBloodtest(), entity.getSugartest(), entity.getDate(), entity.getEmailid());
    }	
	
	//get all the data by using ANY filed
	public List<hospitalEntity> findAllTheDataByUsingAnyField(String name,String gender,String emailid)
	{
		 return respositiry.getAllTheData(name, gender, emailid);
		
	}
	//Delete All the patient data by using name
	public int deletetehpatientdata(String name)
	{
	    return  respositiry.deletePateinetDetails(name);
	}

}
