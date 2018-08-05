package com.learn.prateek.webserviceapp.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonFilter declared as we will use it in dynamic filtering in FilteringController.java 

@JsonFilter("filter_field2")
public class SomeBean {
	private String field1;
	private String field2;
	
	@JsonIgnore
	private String field3; //secure filed, we dont want it to send in response (done using static filtering)
	
	
	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}


	public String getField1() {
		return field1;
	}


	public void setField1(String field1) {
		this.field1 = field1;
	}


	public String getField2() {
		return field2;
	}


	public void setField2(String field2) {
		this.field2 = field2;
	}


	public String getField3() {
		return field3;
	}


	public void setField3(String field3) {
		this.field3 = field3;
	}
	
	
	
	
	
}
