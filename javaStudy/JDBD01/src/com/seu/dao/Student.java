package com.seu.dao;

public class Student {
	private int id;
	private String usr;
	private String password;
	private int age;
	private String email;
	
	public Student(int i,String u,String p,int a,String em){
		id=i;
		usr=u;
		password=p;
		age=a;
		email=em;
	}
	
	public  int getId() {
		return id;
	}
	
	public  String getUsr() {
		return usr;
	}
	
	public String getPassword() {
		return password;
	}
	
	public  int getAge() {
		return age;
	}
	
	public  String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id="+id+"==usr="+usr+"==password="+password+"==age="+age+"==email="+email;
		
	}
}
