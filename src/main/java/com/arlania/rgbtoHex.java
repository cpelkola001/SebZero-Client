package com.arlania;

import java.awt.Color;
import java.util.Random;



public class rgbtoHex {
	Random ra = new Random();
	int r, g, b; {
	r=ra.nextInt(255);
	g=ra.nextInt(255);
	b=ra.nextInt(255);
	Color color = new Color(r,g,b, b);
	String hex = Integer.toHexString(color.getRGB() & 0xffffff);
	if (hex.length() < 6) {
	    hex = "0" + hex;
	}
	hex = "#" + hex;
}
}
