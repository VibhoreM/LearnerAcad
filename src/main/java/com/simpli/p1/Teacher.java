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

@WebServlet("/Teacher")
public class Teacher extends HttpServlet{

	private String url = "jdbc:mysql://localhost:3306/learner_acad_mgmt_sys";
	private String user = "root";
	private String password = "root";

	private Connection con;
	private PreparedStatement pstmt;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String sname = req.getParameter("tname");
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			String sql = "insert into teachers values (?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,sname);

			int x = pstmt.executeUpdate();
			if(x>0) 
			{

				PrintWriter writer = resp.getWriter();
				writer.println("Teacher added successfully");
				
				resp.sendRedirect("/LearnerAcad_Online_Management_System/Success.html");
				
				
			}
			else {
				PrintWriter writer = resp.getWriter();
				writer.println("Fail");
				
				resp.sendRedirect("/LearnerAcad_Online_Management_System/Fail.html");
			}
			pstmt.close();
			con.close();
		} 
		catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}



}
