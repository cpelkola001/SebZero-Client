package com.arlania;

public class CustomAlertInterface {
	
	private int width;
	private int height;
	private int opacity;
	private int color;
	private int scrollWidth;
	private int scrollHeight;
	private int scrollMax;
	
	public CustomAlertInterface(int width, int height, int opacity, int color, int scrollWidth, int scrollHeight, int scrollMax) {
		this.width = width;
		this.height = height;
		this.opacity = opacity;
		this.color = color;
		this.scrollWidth = scrollWidth;
		this.scrollHeight = scrollHeight;
		this.scrollMax = scrollMax;
	}
	
	void draw() {
		DrawingArea.drawTransparentBox(35, 175, width, height, color, opacity);
		
	}
}
