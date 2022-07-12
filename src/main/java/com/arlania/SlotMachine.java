package com.arlania;

import java.util.Arrays;

public class SlotMachine {

	protected boolean canSpin = false;
	
	int spinAmount = 0;
	
	public void shift() {
		if(!canSpin) {
			return;
		}
		RSInterface items = RSInterface.interfaceCache[57390];
		spinAmount += getSpeed(items.childY[0]);
		items.childY[0] -= getSpeed(spinAmount);
		
		if(items.childY[0] < -2000) {
			System.out.println("???? wtf");
			items.childY[0] = 150;
			spinAmount = -150;
		}
		
		
		System.out.println("Spin amount: " + spinAmount);
		
		System.out.println("Items childs: " + Arrays.toString(items.children));
		System.out.println("New childy: " + items.childY[0]);
		System.out.println("Speed: " + getSpeed(items.childY[0]));
	}
	
	private int getSpeed(int childY) {
		
		if(childY > 1500) {
			return 2;
		} else if(childY > 750) {
			return 3;
		} else {
			return 4;
		}
		
	}
	
	
}
