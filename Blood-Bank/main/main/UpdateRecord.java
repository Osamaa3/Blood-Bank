package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateRecord {
	public String update(String donorid,String date,String sign,String medexam,int quantity,String type) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/Blood Bank","root","");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into blooddonation(DonorID,DonationDate,VitalSign,MedicalExamination,QuantityDonated,bloodtype) values('"+donorid+"','"+date+"','"+sign+"','"+medexam+"','"+quantity+"','"+type+"')");

			
			con.close();
		} catch(Exception e){
		   System.out.println(e);
		}
		return "";
	}
}