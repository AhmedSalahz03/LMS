package application;

import java.util.ArrayList;

public class Person {
	String username;
	String password;
	String firstName;
	String lastName;
	String address;
	String cellphone;
	String email;
	String type;
	String isBlocked;
	

	
	Person (String type, String username, String password, String firstName, String lastName, String address, String cellphone, String email, String isBlocked) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.cellphone = cellphone;
		this.email = email;
		this.type = type;
		this.isBlocked = isBlocked;
		
	}
	public String getIsBlocked() {
		return isBlocked;
	}
	public void setIsBlocked(String isBlocked) {
		this.isBlocked = isBlocked;
	}
	public String getType() {
		return type;
	}
	public String getUsername () {
		return username;
	}
	public String getPassword () {
		return password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName () {
		return lastName;
	}
	

}
