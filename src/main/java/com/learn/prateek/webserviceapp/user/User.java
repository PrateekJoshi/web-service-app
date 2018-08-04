package com.learn.prateek.webserviceapp.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/* @ApiModel will be user by swagger to show User model to the consumer */
@ApiModel(description="All details about the user")
public class User {
	private Integer id;
	
	/* Added validation using annotation and error message that consumer will get if validation failed */
	@Size(min=2,message="Name should have atlease two characters")
	@ApiModelProperty(notes="Name should have atlease two characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes="Birthday should be in the past")
	private Date birthday;
	   
	public User()
	{
		
	}
	
	public User(Integer id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
