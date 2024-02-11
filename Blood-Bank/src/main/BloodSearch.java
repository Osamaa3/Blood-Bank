package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BloodSearch{
	public Receiver[] searchreceiver(String type) {
		Receiver[] receiver = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/Blood Bank","root","");
			Statement stmt=con.createStatement();
			ResultSet r = stmt.executeQuery("select * from blooddonation where bloodtype = '"+type+"'");
			r.next();
			int count = r.getInt(1);
			if(count>0) {				
				ResultSet rs=stmt.executeQuery("select * from blooddonation where bloodtype = '"+type+"'");
				//select * from bloodonation where bloodtype = '"+type+"'
				int noOfreceiver;
				
				rs.last();
				noOfreceiver = rs.getRow();
				rs.beforeFirst();
				
				//
				receiver = new Receiver[noOfreceiver];
				
				int i = 0;
				
				while(rs.next()){
					int requestid = rs.getInt(1);
					String requser = rs.getString(2);
					String patientdetails = rs.getString(3);
					String reqtype = rs.getString(4);
					String criteria = rs.getString(5);
					String donorlist = rs.getString(6);

					//
					receiver[i] = new Receiver(requestid,requser,patientdetails,reqtype,criteria,donorlist);
					System.out.println(receiver);
					
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
		return receiver;
	}
}