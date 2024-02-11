package main;

public class Receiver {
		public int requestid;
		public String requser;
		public String patientdetails;
		public String reqtype;
		public String criteria;
		public String donorlist;
		public Receiver() {
		
		}
		
		public Receiver(int requestid,String requestinguser,String patientdetails,String requiredtype,String criteria,String donorlist) {
			this.requestid = requestid;
			this.requser = requestinguser;
			this.patientdetails = patientdetails;
			this.reqtype = requiredtype;
			this.criteria = criteria;
			this.donorlist = donorlist;
		}
		
		public String toString() {
	        return "ID: " + requestid + " RequestingUser: " + requser + " PatientDetail: " + patientdetails + " RequiredBloodType: " + reqtype + "criteria: " + criteria + "DonorList: " + donorlist;
	}
	}


