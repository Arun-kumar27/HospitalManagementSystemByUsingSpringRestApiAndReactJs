package com.hospital.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class hospitalDto {

    private int id;

    @NotBlank(message = "please enter the name")
    @Size(min = 3, max = 50, message = "name should contain between 3 and 50 characters")
    private String name;

    @NotBlank(message = "please enter address")
    private String address;

    @Min(value = 1, message = "age must be at least 1")
    @Max(value = 120, message = "age must be less than or equal to 120")
    private int age;

    @Min(value = 100, message = "fees must be at least 100")
    private long feez;

    @NotBlank(message = "please provide blood test result")
    private String bloodtest;

    @NotBlank(message = "please provide sugar test result")
    private String sugartest;

    @Min(value = 6000000000L, message = "mobile number must start with 6, 7, 8, or 9")
    @Max(value = 9999999999L, message = "mobile number is invalid")
    private long number;

    @NotBlank(message = "please enter gender")
    private String gender;

    @NotBlank(message = "please enter the email")
    @Email(message = "invalid email")
    private String emailid;
    @NotBlank(message = "please enter the data")
    private String date;
}
