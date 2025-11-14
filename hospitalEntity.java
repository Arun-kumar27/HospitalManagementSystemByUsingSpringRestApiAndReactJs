package com.hospital.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="hospital_Details")
public class hospitalEntity 
{
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name="patientName",nullable = false)
	private String name;
	@Column(name="patientAdress",nullable = false)
	private String address;
	@Column(name="age",nullable = false)
	private int age;
	@Column(name="Feez",nullable = false)
	private long feez;
	@Column(name="bloddTest",nullable = false)
	private String bloodtest;
	@Column(name="sugarTest",nullable = false)
	private String sugartest;
	@Column(name="number",nullable = false,unique =true)
	private long number;
	@Column(name="gender",nullable = false)
	private String gender;
	@Column(name="Emalid",nullable = false,unique = true)
	private String emailid;
	@Column(name="date",nullable = false)
	private String date;

}
