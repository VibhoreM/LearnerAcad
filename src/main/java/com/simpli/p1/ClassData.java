package com.simpli.p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClassData")
public class ClassData extends HttpServlet{
	
	private String url = "jdbc:mysql://localhost:3306/learner_acad_mgmt_sys";
	private String user = "root";
	private String password = "root";

	public Connection con;
	public PreparedStatement pstmt;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String clas = req.getParameter("clas");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			
			System.out.println(clas);
			
			String sql = "SELECT * FROM masterlist where class = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,clas);
			
			System.out.println("----------------");
			
			ResultSet rs = pstmt.executeQuery();
			
			
			
			String sql2 = "SELECT * FROM studentmasterlist where class = ?";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1,clas);
			
			ResultSet rsStudent = pstmt2.executeQuery();
			
			
			PrintWriter writer = resp.getWriter();
			
			System.out.println("Suject & Tachers for "+clas+" are:-");
			writer.println("Subject & Teachers for "+clas+" are:-");
			while(rs.next()) {
				writer.print(rs.getString("Subject"));
				writer.print("\t");
				writer.println(rs.getString("Teacher"));
			}
			writer.println();
			System.out.println("Students are:-");
			writer.println("Students are:-");
			while(rsStudent.next()) {
				writer.println(rsStudent.getString("Student"));
			}
			pstmt.close();
			pstmt2.close();
			con.close();
			
			writer.println();
			//writer.println("<a href=\"/LearnerAcad_Online_Management_System/Home.html\">"+"Home"+"</a>");
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
