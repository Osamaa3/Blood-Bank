package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Registration {
	public String register(String name,String contact,int age,String gender,String address,String blood_type, String med_history,String record) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/Blood Bank","root","");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into donorregistration(Name,Contact,Age,Gender,Address,BloodType,MedicalHistory,DonationRecord) values('"+name+"','"+contact+"','"+age+"','"+gender+"','"+address+"','"+blood_type+"','"+med_history+"','"+record+"')");

			
			con.close();
		} catch(Exception e){
		   System.out.println(e);
		}
		return "";
	}
}
