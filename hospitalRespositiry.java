package com.hospital.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.Entity.hospitalEntity;

public interface hospitalRespositiry  extends JpaRepository<hospitalEntity, Integer>
{
 @Transactional
 @Modifying	
 @Query("update  hospitalEntity hd set hd.bloodtest=?1, hd.sugartest=?2,hd.date=?3 where hd.emailid=?4")	
 int  updateBloodTestAndSugarTestBysuingEmalid(String bloodtest ,String sugartest,String date,String emailid);

 
  @Query("select hd from hospitalEntity hd  where hd.name=?1 or hd.gender=?2 or hd.emailid=?3")
  List<hospitalEntity> getAllTheData(String name,String gender,String emailid);
  
  
  @Transactional
  @Modifying
  @Query("delete from hospitalEntity hd where hd.name=?1")
  int deletePateinetDetails(String name);
}
