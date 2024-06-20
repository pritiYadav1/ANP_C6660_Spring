package com.sms.model;



import com.sms.entities.Teacher;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO 
{

	private Long id;
	@NotBlank
	@Size(min=3,max=20,message = "first name shauld have min 3 to max 20 charactes")
	private String firstName;
	@NotBlank
	@Size(min=3,max=20,message = "last name shauld have min 3 to max 20 charactes")
	private String lastName;
	@NotBlank
	@Email
	@Size(min=3,max=20,message = "email shauld have min 3 to max 20 charactes")
	private String email;
	private Teacher teacher;
}
