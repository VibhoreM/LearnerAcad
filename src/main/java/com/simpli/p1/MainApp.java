package com.simpli.p1;

//This class was made just to run and check if other java classes are working fine. This will not be used in LA-OMS project.

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class MainApp {
	public static void main(String[] args) {
		Data d = new Data();
		System.out.print(d.aa);
		try {
			//System.out.println(d.getRsStudent().getString("student"));
			while(d.getRsSubject().next()==true) 
			{
				String name = d.getRsSubject().getString(1);
				System.out.println(name);
				
				String name2 = d.getRsSubject().getString(1);
				System.out.println("name22="+name2);
				 
				System.out.println("----");
				
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}