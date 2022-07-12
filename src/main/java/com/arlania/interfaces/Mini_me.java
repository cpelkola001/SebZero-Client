package com.arlania.interfaces;

import com.arlania.RSInterface;
import com.arlania.TextDrawingArea;

public class Mini_me {
	
	public static void miniMeInterface(TextDrawingArea[] tda) {
		int interfaceId = 38650;
		int children = 0;
		int totalChildren = 57;
		
        RSInterface Inteface = RSInterface.addInterface(interfaceId);
        RSInterface.setChildren(totalChildren, Inteface);
        
        interfaceId++;
        RSInterface.addSpriteLoader(interfaceId, 1284);
        RSInterface.setBounds(interfaceId, 73, 16, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 737, 16, 16, "Close Window", -1, interfaceId + 1, 1);
        RSInterface.setBounds(interfaceId, 434, 26, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addHoveredImageWSpriteLoader(interfaceId, 738, 16, 16, interfaceId + 1);
        RSInterface.setBounds(interfaceId, 434, 26, children, Inteface);
        
        interfaceId += 2;
        children++;
        RSInterface.addText(interfaceId, "Mini-me Configuration", tda, 2, 0xffb000, true, true);
        RSInterface.setBounds(interfaceId, 268, 26, children, Inteface);

        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1300);
        RSInterface.setBounds(interfaceId, 263, 60, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1298);
        RSInterface.setBounds(interfaceId, 168, 113, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1298);
        RSInterface.setBounds(interfaceId, 168, 149, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1298);
        RSInterface.setBounds(interfaceId, 168, 185, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1298);
        RSInterface.setBounds(interfaceId, 168, 221, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1299);
        RSInterface.setBounds(interfaceId, 138, 148, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1299);
        RSInterface.setBounds(interfaceId, 168, 148, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1299);
        RSInterface.setBounds(interfaceId, 129, 187, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1299);
        RSInterface.setBounds(interfaceId, 176, 187, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1298);
        RSInterface.setBounds(interfaceId, 112, 205, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1298);
        RSInterface.setBounds(interfaceId, 112, 241, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1298);
        RSInterface.setBounds(interfaceId, 224, 205, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1298);
        RSInterface.setBounds(interfaceId, 224, 241, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 153, 95, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1285);
        RSInterface.setBounds(interfaceId, 161, 101, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 153, 95, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 112, 95, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1301);
        RSInterface.setBounds(interfaceId, 116, 100, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 112, 95, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 153, 134, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1287);
        RSInterface.setBounds(interfaceId, 163, 145, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 153, 134, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 112, 134, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1286);
        RSInterface.setBounds(interfaceId, 119, 137, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 112, 134, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 194, 134, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1295);
        RSInterface.setBounds(interfaceId, 201, 142, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 194, 134, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 153, 173, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1290);
        RSInterface.setBounds(interfaceId, 157, 184, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 153, 173, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 97, 173, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1288);
        RSInterface.setBounds(interfaceId, 103, 179, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 97, 173, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 209, 173, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1291);
        RSInterface.setBounds(interfaceId, 214, 178, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 209, 173, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 153, 213, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1292);
        RSInterface.setBounds(interfaceId, 163, 217, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 153, 213, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 153, 253, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1294);
        RSInterface.setBounds(interfaceId, 159, 260, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 153, 253, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 97, 252, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1293);
        RSInterface.setBounds(interfaceId, 100, 256, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 97, 252, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 209, 253, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1289);
        RSInterface.setBounds(interfaceId, 219, 263, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 209, 253, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Mini-me View", tda, 2, 0xFF981F, false, true);
        RSInterface.setBounds(interfaceId, 303, 71, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addChar(interfaceId, 1850);
        RSInterface.setBounds(interfaceId, 273, 185, children, Inteface);

        interfaceId++;
        children++;
        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 1177, 35, 25, "Dismiss Mini-me and Equipment", -1, interfaceId + 1, 1);
        RSInterface.setBounds(interfaceId, 216, 60, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addHoveredImageWSpriteLoader(interfaceId, 1176, 35, 25, interfaceId + 1);
        RSInterface.setBounds(interfaceId, 216, 60, children, Inteface);
	}
}
