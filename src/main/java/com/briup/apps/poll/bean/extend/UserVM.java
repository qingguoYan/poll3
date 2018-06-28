package com.briup.apps.poll.bean.extend;


import java.util.List;

import com.briup.apps.poll.bean.Clazz;

public class UserVM {
	private long id;
	private String gender;
	private String birth;
	private String hiredate;
	private String type;
	private List<Clazz> clazz;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Clazz> getCalzz() {
		return clazz;
	}
	public void setCalzz(List<Clazz> calzz) {
		this.clazz = calzz;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
}
