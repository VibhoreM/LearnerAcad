
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

@WebServlet("/UpdateStudentMasterList")
public class UpdateStudentMasterList extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String student = req.getParameter("student");
		String clas = req.getParameter("clas");
		
		 String url = "jdbc:mysql://localhost:3306/learner_acad_mgmt_sys";
		 String user = "root";
		 String password = "root";

		 Connection con;
		 PreparedStatement pstmt;
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			
			String sql1 = "select * from studentmasterlist WHERE student =?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, student);
			boolean noRecord = true;
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()==true) {
				noRecord = false;
				String sql2 = "UPDATE studentmasterlist SET class=? WHERE student =?";
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, clas);
				pstmt.setString(2, student);
				int y = pstmt.executeUpdate();
				if(y>0) 
				{
					resp.sendRedirect("/LearnerAcad_Online_Management_System/Success.html");
				}
				else {
					resp.sendRedirect("/LearnerAcad_Online_Management_System/Fail.html");
				}
			}
			
			if(noRecord) {
				String sql = "INSERT INTO studentmasterlist VALUES (?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, student);
				pstmt.setString(2, clas);
				
				int x = pstmt.executeUpdate();
				if(x>0) 
				{
					resp.sendRedirect("/LearnerAcad_Online_Management_System/Success.html");
				}
				else {
					resp.sendRedirect("/LearnerAcad_Online_Management_System/Fail.html");
				}
			}
			
			
			
			
				
				
			
			
		
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

