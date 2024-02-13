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
			ResultSet r = stmt.executeQuery("select count(*) from blooddonation where bloodtype = '"+type+"'");
			r.next();
			int count = r.getInt(1);
			if(count>0) {				
				ResultSet rs=stmt.executeQuery("select DonorID from blooddonation where bloodtype = '"+type+"'");
				//select * from bloodonation where bloodtype = '"+type+"'
				int noOfreceiver;
				
				rs.last();
				noOfreceiver = rs.getRow();
				rs.beforeFirst();
				
				//
				receiver = new Receiver[noOfreceiver];
				
				int i = 0;
				
				while(rs.next()){
					int donorid = rs.getInt(1);
					//
					receiver[i] = new Receiver(donorid);
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