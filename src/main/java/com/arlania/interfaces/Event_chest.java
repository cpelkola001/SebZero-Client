package com.arlania.interfaces;

import com.arlania.Client;
import com.arlania.RSInterface;
import com.arlania.TextDrawingArea;

public class Event_chest {
	
	public static void eventChestInterface(TextDrawingArea[] tda) {
		int interfaceId = 55580;
		int children = 0;
		int totalChildren = 28;
		
        RSInterface Inteface = RSInterface.addInterface(interfaceId);
        RSInterface.setChildren(totalChildren, Inteface);
        
        interfaceId++;
        RSInterface.addSpriteLoader(interfaceId, 1343);
        RSInterface.setBounds(interfaceId, 12, 11, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Christmas Chest", tda, 2, 0xffb000, true, true);
        RSInterface.setBounds(interfaceId, 344, 23, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 737, 16, 16, "Close Window", -1, interfaceId + 1, 1);
        RSInterface.setBounds(interfaceId, 476, 14, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addHoveredImageWSpriteLoader(interfaceId, 738, 16, 16, interfaceId + 1);
        RSInterface.setBounds(interfaceId, 476, 14, children, Inteface);
        
        interfaceId += 2;
        children++;
        RSInterface.addHoverButtonComplete(interfaceId, children, 18, 27,
        		1345, 1345, 100, 21, "Event Chest Tier I", Inteface, true);
        RSInterface.setSpriteClicked(interfaceId, 1344);
        Client.setInterfaceClicked(55580, interfaceId, true, true);
        
        interfaceId += 3;
        children += 2;
        RSInterface.addText(interfaceId, "@or1@Tier I", tda, 0, 0xffb000, false, true);
        RSInterface.setBounds(interfaceId, 27, 33, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addHoverButtonComplete(interfaceId, children, 118, 27,
        		1345, 1345, 100, 21, "Event Chest Tier II", Inteface, true);
        RSInterface.setSpriteClicked(interfaceId, 1344);
        
        interfaceId += 3;
        children += 2;
        RSInterface.addText(interfaceId, "@or1@Tier II", tda, 0, 0xffb000, false, true);
        RSInterface.setBounds(interfaceId, 127, 33, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1341, 70, 41, "Exchange", -1, interfaceId + 1, 1);
        RSInterface.setBounds(interfaceId, 191, 240, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addHoveredImageWSpriteLoader(interfaceId, 1342, 70, 41, interfaceId + 1);
        RSInterface.setBounds(interfaceId, 191, 240, children, Inteface);
        
        interfaceId += 2;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1348);
        RSInterface.setBounds(interfaceId, 231, 251, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Roll", tda, 1, 0xffb000, false, true);
        RSInterface.setBounds(interfaceId, 204, 252, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Tier I Prize", tda, 2, 0xffb000, false, true);
        RSInterface.setBounds(interfaceId, 67, 239, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Roll all of the items in\\nthe tier for a prize!", tda, 0, 0xffb000, false, true);
        RSInterface.setBounds(interfaceId, 67, 256, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1351, 120, 34, "Event Chest Tier II", -1, interfaceId + 1, 1);
        RSInterface.setBounds(interfaceId, 24, 282, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addHoveredImageWSpriteLoader(interfaceId, 1350, 120, 34, interfaceId + 1);
        RSInterface.setBounds(interfaceId, 24, 282, children, Inteface);
        
        interfaceId += 2;
        children++;
        RSInterface.addText(interfaceId, "@yel@Event Guide", tda, 1, 0xffb000, true, true);
        RSInterface.setBounds(interfaceId, 85, 291, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "@yel@0 / 22 rolls @or1@(0 / 222,000 tokens)", tda, 0, 0xffb000, true, true);
        RSInterface.setBounds(interfaceId, 331, 306, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1349);
        RSInterface.setSpriteLoadingBarPercentage(interfaceId, 0);
        RSInterface.setBounds(interfaceId, 191, 287, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "0% (220,000 tokens left)", tda, 0, 0000000, true, false);
        RSInterface.setBounds(interfaceId, 335, 289, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.itemGroup(interfaceId, 1, 3, 14, 14);
        RSInterface.setBounds(interfaceId, 28, 241, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.itemGroup(interfaceId, 1, 3, 14, 14);
        RSInterface.setBounds(interfaceId, 272, 244, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.itemGroup(interfaceId, 1, 3, 14, 14);
        RSInterface.setBounds(interfaceId, 394, 244, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.itemGroup(interfaceId, 1, 3, 14, 14);
        RSInterface.setBounds(interfaceId, 443, 244, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "?", tda, 2, 0xFFFF00, false, true);
        RSInterface.setBounds(interfaceId, 454, 254, children, Inteface);
        
		interfaceId++;
		children++;
		RSInterface rightScroll = RSInterface.addInterface(interfaceId);
		RSInterface.setBounds(interfaceId, 27, 47, children, Inteface);

		rightScroll.totalChildren(38);
		rightScroll.width = 449;
		rightScroll.height = 185;
		rightScroll.scrollMax = 1000;
		
		int children1 = -1;
		
		for (int i = 0; i < 3; i++) {
	        interfaceId++;
	        children1++;
	        RSInterface.addSpriteHDLoader(interfaceId, 1347);
	        RSInterface.setBounds(interfaceId, 8 + (65 * i), 6, children1, rightScroll);
		}
		
		for (int i = 0; i < 7; i++) {
			interfaceId++;
        	children1++;
        	RSInterface.addToItemGroup(interfaceId, 7, 16, 33, 25, false, null);
        	RSInterface.setBounds(interfaceId, 14 + (i * 65), 11, children1, rightScroll);
		}
		
		for (int i = 0; i < 7; i++) {
			interfaceId++;
        	children1++;
        	RSInterface.addToItemGroup(interfaceId, 7, 16, 33, 25, false, null);
        	RSInterface.setBounds(interfaceId, 14 + (i * 65), 60, children1, rightScroll);
		}
		
		for (int i = 0; i < 7; i++) {
			interfaceId++;
        	children1++;
        	RSInterface.addToItemGroup(interfaceId, 7, 16, 33, 25, false, null);
        	RSInterface.setBounds(interfaceId, 14 + (i * 65), 109, children1, rightScroll);
		}
		
		for (int i = 0; i < 7; i++) {
			interfaceId++;
        	children1++;
        	RSInterface.addToItemGroup(interfaceId, 7, 16, 33, 25, false, null);
        	RSInterface.setBounds(interfaceId, 14 + (i * 65), 158, children1, rightScroll);
		}
		
		for (int i = 0; i < 7; i++) {
			interfaceId++;
        	children1++;
        	RSInterface.addToItemGroup(interfaceId, 7, 16, 33, 25, false, null);
        	RSInterface.setBounds(interfaceId, 14 + (i * 65), 207, children1, rightScroll);
		}
	}

}
