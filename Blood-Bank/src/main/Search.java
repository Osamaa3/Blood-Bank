package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Search {
	public Donor[] searchdonor(String med_history) {
		Donor[] donor = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/Blood Bank","root","");
			Statement stmt=con.createStatement();
			ResultSet r = stmt.executeQuery("select count(*) from donorregistration where MedicalHistory like '%"+med_history+"%' ");
			r.next();
			int count = r.getInt(1);
			if(count>0) {				
				ResultSet rs=stmt.executeQuery("select * from donorregistration where MedicalHistory like '%"+med_history+"%' ");
				int noOfdonors;
				
				rs.last();
				noOfdonors = rs.getRow();
				rs.beforeFirst();
				
		
				donor = new Donor[noOfdonors];
				
				int i = 0;
				
				while(rs.next()){
					int donorid = rs.getInt(1);
					String name = rs.getString(2);
					String contact = rs.getString(3);
					int age = rs.getInt(4);
					String gender = rs.getString(5);
					String address = rs.getString(6);
					String type = rs.getString(7);
					String medhistory = rs.getString(8);
					String record = rs.getString(9);
					donor[i] = new Donor(donorid,name,contact,age,gender,address,type,medhistory,record);
					System.out.println(donor);
					
					i++;
				}
			}
			else {
				System.out.println("data not found");
			}
			con.close();
		} catch(Exception e){
			System.out.println(e);
		}
		return donor;
	}
}