package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateReceiver {
	public String update(String requser,String patientdeails,String reqtype,String criteria,String donorid) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/Blood Bank","root","");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into bloodreceiver(RequestingUser,PatientDetails,RequiredBloodType,Criteria,DonorID) values('"+requser+"','"+patientdeails+"','"+reqtype+"','"+criteria+"','"+donorid+"')");

			
			con.close();
		} catch(Exception e){
		   System.out.println(e);
		}
		return "";
	}
}
	