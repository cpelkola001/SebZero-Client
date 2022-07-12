package com.arlania.interfaces;

import com.arlania.RSInterface;
import com.arlania.TextDrawingArea;

public class DonatorInterface {
	
	
	public static void newDonatorScreen(TextDrawingArea[] tda) {
		int interfaceId = 19005;
		int children = 0;
		int totalChildren = 5;
		
        RSInterface Inteface = RSInterface.addInterface(interfaceId);
        RSInterface.setChildren(totalChildren, Inteface);
        
        interfaceId++;
        RSInterface.addSpriteLoader(interfaceId, 1387);
        RSInterface.setBounds(interfaceId, 5, 5, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Donator Zone Teleports", tda, 2, 0xffb000, true, true);
        RSInterface.setBounds(interfaceId, 238, 25, children, Inteface);        
        
        interfaceId++;
        children++;
        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 737, 16, 16, "Close Window", -1, interfaceId + 1, 1);
        RSInterface.setBounds(interfaceId, 484, 12, children, Inteface);       
        
        interfaceId++;
        children++;
        RSInterface.addHoveredImageWSpriteLoader(interfaceId, 738, 16, 16, interfaceId + 1);
        RSInterface.setBounds(interfaceId, 484, 12, children, Inteface);
        
   		interfaceId++;
   		children++;
   		RSInterface rightScroll = RSInterface.addInterface(interfaceId);
   		RSInterface.setBounds(interfaceId, 27, 47, children, Inteface);

   		rightScroll.totalChildren(12);
   		rightScroll.width = 449;
   		rightScroll.height = 250;
   		rightScroll.scrollMax = 1200;
   		
   		int children1 = -1;
   		
   	        interfaceId++;
   	        children1++;

   	        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1388 ,382, 78, "Regular Donator Zone", -1, interfaceId + 1, 1);
   	        RSInterface.setBounds(interfaceId, 32, 15, children1, rightScroll);

   			interfaceId++;
           	children1++;
   	        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1389 ,382, 78, "Super Donator Zone", -1, interfaceId + 1, 1);
            RSInterface.setBounds(interfaceId, 32, 115, children1, rightScroll);
 
   			interfaceId++;
           	children1++;
   	        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1390 ,382, 78, "Ultra Donator Zone", -1, interfaceId + 1, 1);
            RSInterface.setBounds(interfaceId, 32, 215, children1, rightScroll);
  
   			interfaceId++;
           	children1++;
   	        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1391 ,382, 78, "Mystic Donator Zone", -1, interfaceId + 1, 1);
            RSInterface.setBounds(interfaceId, 32, 315, children1, rightScroll);
            
   			interfaceId++;
           	children1++;
   	        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1392 ,382, 78, "Obsidian Donator Zone", -1, interfaceId + 1, 1);
            RSInterface.setBounds(interfaceId, 32, 415, children1, rightScroll);
            
   			interfaceId++;
           	children1++;
   	        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1393 ,382, 78, "Legendary Donator Zone", -1, interfaceId + 1, 1);
            RSInterface.setBounds(interfaceId, 32, 515, children1, rightScroll);
            
   			interfaceId++;
           	children1++;
   	        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1394 ,382, 78, "Celestial Donator Zone", -1, interfaceId + 1, 1);
            RSInterface.setBounds(interfaceId, 32, 615, children1, rightScroll);
            
   			interfaceId++;
           	children1++;
   	        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1395 ,382, 78, "Executive Donator Zone", -1, interfaceId + 1, 1);
            RSInterface.setBounds(interfaceId, 32, 715, children1, rightScroll);
            
   			interfaceId++;
           	children1++;
   	        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1396 ,382, 78, "Supreme Donator Zone", -1, interfaceId + 1, 1);
            RSInterface.setBounds(interfaceId, 32, 815, children1, rightScroll);
            
   			interfaceId++;
           	children1++;
   	        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1397 ,382, 78, "Divine Donator Zone", -1, interfaceId + 1, 1);
            RSInterface.setBounds(interfaceId, 32, 915, children1, rightScroll);
            
   			interfaceId++;
           	children1++;
   	        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1398 ,382, 78, "Sponsor Donator Zone", -1, interfaceId + 1, 1);
            RSInterface.setBounds(interfaceId, 32, 1015, children1, rightScroll);
            
   			interfaceId++;
           	children1++;
   	        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1399 ,382, 78, "Owner Zone", -1, interfaceId + 1, 1);
            RSInterface.setBounds(interfaceId, 32, 1115, children1, rightScroll);
	}
}
