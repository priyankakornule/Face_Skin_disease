package com.model;

import java.awt.image.BufferedImage;


public class ImageModel {

	int id;
	String name,prediction;
	BufferedImage img;
	int quantity;
	
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrediction() {
		return prediction;
	}
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}
	
	
}
