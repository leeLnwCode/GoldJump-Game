package application;

import javafx.scene.image.Image;

public class AssetType {
	
	private String type;
	private String name;
	private double width;
	private double height;
	private int    frames;
	private Image  image;
	
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getFrames() {
		return this.frames;
	}
	public void setFrames(int frames) {
		this.frames = frames;
	}
	public Image getImage() {
		return this.image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
	
	
	public AssetType() {
		this.name = "";
		this.width = 0;
		this.height = 0;
		this.frames = 0;
		this.image = null;
	}
public AssetType(String name , double width , double height , int frames , Image image) {
	this.name = name;
	this.width = width;
	this.height = height;
	this.frames = frames;
	this.image = image;
}
}
