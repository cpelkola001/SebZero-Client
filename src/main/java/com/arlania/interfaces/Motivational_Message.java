package com.arlania.interfaces;

import com.arlania.RSInterface;

public class Motivational_Message {
	
	public static void motivationalMessage() {
		int interfaceId = 18900;
		int children = 0;
		int totalChildren = 1;
		
        RSInterface Inteface = RSInterface.addInterface(interfaceId);
        RSInterface.setChildren(totalChildren, Inteface);
        
        interfaceId++;
		RSInterface.addBackground(interfaceId, 0, 0x000000);
        RSInterface.setBounds(interfaceId, 1, 1, children, Inteface);

        

	}

}
