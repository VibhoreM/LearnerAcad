package com.simpli.p1;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class Data {
	
	public ResultSet rsSubject;
	public ResultSet rsClass;
	public ResultSet rsTeacher;
	public ResultSet rsStudent;
	public String aa;
	
	public ResultSet getRsStudent() {
		return rsStudent;
	}

	public void setRsStudent(ResultSet rsStudent) {
		this.rsStudent = rsStudent;
	}



	
	
	
	public ResultSet getRsSubject() {
		return rsSubject;
	}

	public void setRsSubject(ResultSet rsSubject) {
		this.rsSubject = rsSubject;
	}

	public ResultSet getRsClass() {
		return rsClass;
	}

	public void setRsClass(ResultSet rsClass) {
		this.rsClass = rsClass;
	}

	public ResultSet getRsTeacher() {
		return rsTeacher;
	}

	public void setRsTeacher(ResultSet rsTeacher) {
		this.rsTeacher = rsTeacher;
	}

	
	
		private String url = "jdbc:mysql://localhost:3306/learner_acad_mgmt_sys";
		private String user = "root";
		private String password = "root";
	
		public Connection con;
		public PreparedStatement pstmt;
	
	
	public Data()
	{
//		this.rsClass = rsClass;
//		this.rsStudent = rsStudent;
//		this.rsTeacher = rsTeacher;
		System.out.println("Constructor called");
		this.aa = "vibhore";
		this.generateStudentData();
		this.generateTeacherData();
		this.generateClassData();//
		this.generateSujectsData();
	}
	
	public void generateSujectsData(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT * FROM subjects";
			pstmt = con.prepareStatement(sql);
			
			setRsSubject(pstmt.executeQuery());
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
		
		public void generateClassData(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "SELECT * FROM classes";
				pstmt = con.prepareStatement(sql);
			
				setRsClass(pstmt.executeQuery());
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
		}
		
		public void generateTeacherData(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "SELECT * FROM teachers";
				pstmt = con.prepareStatement(sql);
			
				setRsTeacher(pstmt.executeQuery());
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
		}
		
		public void generateStudentData(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				
				String sql = "SELECT * FROM students";
				pstmt = con.prepareStatement(sql);
			
				setRsStudent(pstmt.executeQuery());
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
		}
		
//		public void closeCon() throws SQLException {
//			pstmt.close();
//			con.close();
//		}
	
	
}


