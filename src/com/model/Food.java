package com.model;


public class Food {
	
	

	 private String foodname,description,foodtype,diet,unit;
	
	 
	 
	public String getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	int serving,alcohol;
	

	int age;


	int gender;
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int i) {
		this.age = i;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(int alcohol) {
		this.alcohol = alcohol;
	}
	
	public int getServing() {
		return serving;
	}
	public void setServing(int serving) {
		this.serving = serving;
	}
	

	int id,energy,calories, vitaminA,vitaminC,iron;
	 double bmi;
	 private int weight;
	 double height;
	 public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	
	double total;
	 
	 public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVitaminA() {
		return vitaminA;
	}
	public void setVitaminA(int vitaminA) {
		this.vitaminA = vitaminA;
	}
	public int getVitaminC() {
		return vitaminC;
	}
	public void setVitaminC(int vitaminC) {
		this.vitaminC = vitaminC;
	}
	public int getIron() {
		return iron;
	}
	public void setIron(int iron) {
		this.iron = iron;
	}
	private float sugar,fat,fiber,calcium;
	 
	private double protein;
	
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}

	public float getSugar() {
		return sugar;
	}
	public void setSugar(float sugar) {
		this.sugar = sugar;
	}
	public float getFat() {
		return fat;
	}
	public void setFat(float fat) {
		this.fat = fat;
	}
	public float getFiber() {
		return fiber;
	}
	public void setFiber(float fiber) {
		this.fiber = fiber;
	}
	public float getCalcium() {
		return calcium;
	}
	public void setCalcium(float calcium) {
		this.calcium = calcium;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	
}
	