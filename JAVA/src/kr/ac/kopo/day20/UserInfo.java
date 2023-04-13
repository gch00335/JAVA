package kr.ac.kopo.day20;

import java.io.Serializable;

/*
	alt+shift+s 누른 후 	c선택 생성자
						o선택 매게변수
						r선택 set
						s선택 override
*/

public class UserInfo implements Serializable {
	private String name;
	private int age;
	private String phone;
	
	public UserInfo() {
	}

	public UserInfo(String name, int age, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}
	
	
	
}
