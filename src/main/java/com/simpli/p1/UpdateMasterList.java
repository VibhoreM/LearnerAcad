package com.simpli.p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateMasterList")
public class UpdateMasterList extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subject = req.getParameter("subject");
		String clas = req.getParameter("clas");
		String teacher = req.getParameter("teacher");
		
		 String url = "jdbc:mysql://localhost:3306/learner_acad_mgmt_sys";
		 String user = "root";
		 String password = "root";

		 Connection con;
		 PreparedStatement pstmt;
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "insert into masterlist values (?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, clas);
			pstmt.setString(3, teacher);
			
			int x = pstmt.executeUpdate();
			if(x>0) 
			{
				resp.sendRedirect("/LearnerAcad_Online_Management_System/Success.html");
			}
			else {
				resp.sendRedirect("/LearnerAcad_Online_Management_System/Fail.html");
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
