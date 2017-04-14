package com.oldw.model;


/**
 * 
 * @author Brave
 */

public class Person {

	private String name;

	private Integer age;

	private String address;
	
	private Integer id;

	
	public Person(String name,Integer age,String address){
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public Person(String name,Integer age,String address,Integer id){
		this(name,age,address);
		this.id = id;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + ", id=" + id + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
