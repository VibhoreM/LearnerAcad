package com.simpli.p1;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model {
	
	
	
	
	String Username = "Admin";
	String pwd= "Admin";
	
	String uname;
	String passwrd;
	
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPasswrd() {
		return passwrd;
	}

	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public boolean verify() {	
		if(getUsername().equals(getUname()) && getPwd().equals(getPasswrd())){
			return true;
		}
		else {
			return false; 
			}
	}

	
}
