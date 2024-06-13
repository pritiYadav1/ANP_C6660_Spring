package com.sms.model;



import com.sms.entities.Teacher;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO 
{

	private Long id;
	@NotNull
	@Size(min=3,max=20,message = "first name shauld have min 3 to max 20 charactes")
	private String firstName;
	@NotNull
	@Size(min=3,max=20,message = "last name shauld have min 3 to max 20 charactes")
	private String lastName;
	@NotNull
	@Size(min=3,max=20,message = "email shauld have min 3 to max 20 charactes")
	private String email;
	private Teacher teacher;
}
