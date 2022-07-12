package com.arlania.interfaces;

import com.arlania.Client;
import com.arlania.ColorConstants;
import com.arlania.RSInterface;
import com.arlania.TextDrawingArea;

public class PlayerPanel {

	public static void playerPanelInterface(TextDrawingArea[] tda) {
		int interfaceId = 19850;
		int children = 0;
		int totalChildren = 17;

		RSInterface Inteface = RSInterface.addInterface(interfaceId);
		RSInterface.setChildren(totalChildren, Inteface);

		interfaceId++;
		RSInterface.addText(interfaceId, "", tda, 1, ColorConstants.BLUE, false, true);
		RSInterface.setBounds(interfaceId, 60, 1, children, Inteface);

		interfaceId++;
		children++;
		RSInterface.addSpriteLoader(interfaceId, 1171);
		RSInterface.setBounds(interfaceId, 0, 32, children, Inteface);

		interfaceId++;
		children++;
		RSInterface.addSpriteLoader(interfaceId, 1171);
		RSInterface.setBounds(interfaceId, 0, 230, children, Inteface);

		interfaceId++;
		children++;
		RSInterface.addSpriteLoader(interfaceId, 1165);
		RSInterface.setBounds(interfaceId, 0, 35, children, Inteface);
		
        interfaceId++;
        children++;
        RSInterface.addHoverButtonComplete(interfaceId, children, 3, 7,
        		1374, 1375, 41, 21, "Players tab", Inteface, true);
        RSInterface.setSpriteClicked(interfaceId, 1375);
        Client.setInterfaceClicked(19850, interfaceId, true, true);
        
        interfaceId += 3;
        children += 2;
        RSInterface.addHoverButtonComplete(interfaceId, children, 33, 7,
        		1378, 1379, 41, 21, "World events tab", Inteface, true);
        RSInterface.setSpriteClicked(interfaceId, 1379);
        
        interfaceId += 3;
        children += 2;
        RSInterface.addHoverButtonComplete(interfaceId, children, 63, 7,
        		1382, 1383, 41, 21, "Points & Statistics tab", Inteface, true);
        RSInterface.setSpriteClicked(interfaceId, 1383);
        
        interfaceId += 3;
        children += 2;
        RSInterface.addHoverButtonComplete(interfaceId, children, 93, 7,
        		1380, 1381, 41, 21, "Kill Data", Inteface, true);
        RSInterface.setSpriteClicked(interfaceId, 1381);
        
        interfaceId += 3;
        children += 2;
        RSInterface.addHoverButtonComplete(interfaceId, children, 123, 7,
        		1386, 1386, 41, 21, "Achievement Data", Inteface, true); 
        RSInterface.setSpriteClicked(interfaceId, 1386);
        
        interfaceId += 3;
        children += 2;
        RSInterface.addHoverButtonComplete(interfaceId, children, 153, 7,
        		1376, 1377, 41, 21, "Collection Data", Inteface, true);
        RSInterface.setSpriteClicked(interfaceId, 1377);
               
        interfaceId++;
        children++;
        RSInterface.addButtonWSpriteLoader(interfaceId, 1155, "Refresh");
        RSInterface.setBounds(interfaceId, 170, 235, children, Inteface);
        
        
        children++;
		RSInterface scroll = RSInterface.addTabInterface(15016);
		RSInterface.setBounds(15016, 0, 35, children, Inteface);
		scroll.totalChildren(75);
		scroll.width = 172;
		scroll.height = 196;
		scroll.scrollMax = 1050;

		int k = 0;
		int y = 0;
		for (int i = 39159; i < 39234; i++) {
			scroll.child(k, i, 8, y);
			y += 13;
			k++;
			if (i == 39160) {
				RSInterface.addText(i, "", tda, 2, 0xff0000, false, true);
			} else {
				RSInterface.addText(i, "", tda, 0, 0xff0000, false, true);
			}
		}
	}
}
