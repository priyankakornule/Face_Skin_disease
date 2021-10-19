package com.model;

public class Register {

	//uid, fname, lname, contact, email, pass
	private int uid;
	private String fname;
	private String lname;
	private String contact;
	private String email;
	private String pass;
	private String dis;
	
	
	
	public String getDis() {
		return dis;
	}
	public void setDis(String dis) {
		this.dis = dis;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	private int hid;
	private int age;
	private String gender;
	private String height;
	private double cms;
	private double weight;
	private String activeness;
	private double calorie;
	
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
	public String getActiveness() {
		return activeness;
	}
	public void setActiveness(String activeness) {
		this.activeness = activeness;
	}
	
	
	private float bmi;
	private String mean;

	public float getBmi() {
		return bmi;
	}
	public void setBmi(float bmi) {
		this.bmi = bmi;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	
	public double getFinalBmi() {
		return finalBmi;
	}
	public void setFinalBmi(double finalBmi) {
		this.finalBmi = finalBmi;
	}


	public double getCms() {
		return cms;
	}
	public void setCms(double cms) {
		this.cms = cms;
	}


	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getCalorie() {
		return calorie;
	}
	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}


	private double finalBmi;
	
	
}
