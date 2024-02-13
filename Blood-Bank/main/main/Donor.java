package main;

public class Donor {
	public int donorid;
	public String name;
	public String contact;
	public int age;
	public String gender;
	public String address;
	public String type;
	public String med_history;
	public String record;
	public Donor() {
	
	}
	
	public Donor(int donorid,String name,String contact,int age,String gender,String address,String blood_type, String med_history,String record) {
		this.donorid = donorid;
		this.name = name;
		this.contact = contact;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.type = blood_type;
		this.med_history = med_history;
		this.record = record;
	}
	
	public String toString() {
        return "ID: " + donorid + " Name: " + name + " Contact: " + contact + " Age: " + age + "Address: " + address + "BloodType: " + type + "MedicalHistory: " + med_history + "DonationRecords" +record;
}
}