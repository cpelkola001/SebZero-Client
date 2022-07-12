package com.arlania.interfaces;

import com.arlania.RSInterface;
import com.arlania.TextDrawingArea;

public class NewEquipmentScreen {
	
	
	public static void newEquipmentScreen(TextDrawingArea[] tda) {
		int interfaceId = 55500;
		int children = 0;
		int totalChildren = 71;
		
        RSInterface Inteface = RSInterface.addInterface(interfaceId);
        RSInterface.setChildren(totalChildren, Inteface);
        
        interfaceId++;
        RSInterface.addSpriteLoader(interfaceId, 1324);
        RSInterface.setBounds(interfaceId, 5, 5, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addHoverButtonWSpriteLoader(interfaceId, 737, 16, 16, "Close Window", -1, interfaceId + 1, 1);
        RSInterface.setBounds(interfaceId, 484, 12, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 18, 101, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1285);
        RSInterface.setBounds(interfaceId, 26, 105, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 21, 103, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 18, 61, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1301);
        RSInterface.setBounds(interfaceId, 22, 65, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 22, 65, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 203, 182, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1287);
        RSInterface.setBounds(interfaceId, 213, 191, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 204, 185, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 18, 142, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1286);
        RSInterface.setBounds(interfaceId, 24, 145, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 21, 145, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 203, 142, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1295);
        RSInterface.setBounds(interfaceId, 210, 150, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 206, 143, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 18, 182, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1290);
        RSInterface.setBounds(interfaceId, 22, 192, children, Inteface); //22 , 185
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 20, 183, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 203, 61, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1288);
        RSInterface.setBounds(interfaceId, 209, 65, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 205, 63, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 203, 101, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1291);
        RSInterface.setBounds(interfaceId, 208, 105, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 208, 104, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 18, 222, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1292);
        RSInterface.setBounds(interfaceId, 28, 226, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 21, 224, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 18, 263, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1294);
        RSInterface.setBounds(interfaceId, 24, 270, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 20, 265, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 203, 263, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1293);
        RSInterface.setBounds(interfaceId, 206, 267, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 204, 265, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1297);
        RSInterface.setBounds(interfaceId, 203, 222, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 1289);
        RSInterface.setBounds(interfaceId, 213, 232, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addToItemGroup(interfaceId, 1, 3, 14, 14, true, new String[] { "Remove" , null, null, null, null });
        RSInterface.setBounds(interfaceId, 206, 224, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Attack & Defence bonuses", tda, 2, 0xc79152, false, true);
        RSInterface.setBounds(interfaceId, 277, 46, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Other bonuses", tda, 2, 0xc79152, false, true);
        RSInterface.setBounds(interfaceId, 313, 191, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSprite(interfaceId, 1207);
        RSInterface.setBounds(interfaceId, 250, 66, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Stab +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 268, 70, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSprite(interfaceId, 1207);
        RSInterface.setBounds(interfaceId, 250, 90, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Slash +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 268, 93, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSprite(interfaceId, 1207);
        RSInterface.setBounds(interfaceId, 250, 114, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Crush +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 268, 116, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSprite(interfaceId, 1207);
        RSInterface.setBounds(interfaceId, 250, 138, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Magic +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 268, 140, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSprite(interfaceId, 1207);
        RSInterface.setBounds(interfaceId, 250, 162, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Range +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 268, 164, children, Inteface);

        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 759);
        RSInterface.setBounds(interfaceId, 372, 66, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Stab +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 390, 70, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 759);
        RSInterface.setBounds(interfaceId, 372, 90, children, Inteface);
              
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Slash +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 390, 93, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 759);
        RSInterface.setBounds(interfaceId, 372, 114, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Crush +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 390, 116, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 759);
        RSInterface.setBounds(interfaceId, 372, 138, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Magic +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 390, 140, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addSpriteLoader(interfaceId, 759);
        RSInterface.setBounds(interfaceId, 372, 163, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Range +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 390, 164, children, Inteface);
        
        
        interfaceId++;
        children++;
        RSInterface.addSprite(interfaceId, 1338);
        RSInterface.setBounds(interfaceId, 279, 210, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Strength +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 303, 215, children, Inteface);
        
        
        interfaceId++;
        children++;
        RSInterface.addSprite(interfaceId, 1209);
        RSInterface.setBounds(interfaceId, 278, 232, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Range Str +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 303, 236, children, Inteface);
        
        
        interfaceId++;
        children++;
        RSInterface.addSprite(interfaceId, 1211);
        RSInterface.setBounds(interfaceId, 279, 254, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Magic Dmg +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 303, 256, children, Inteface);
        
        
        interfaceId++;
        children++;
        RSInterface.addSprite(interfaceId, 1337);
        RSInterface.setBounds(interfaceId, 280, 276, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Prayer +0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 303, 277, children, Inteface);
        
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Cmb lvl: 3", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 277, 305, children, Inteface);
        
        
        interfaceId++;
        children++;
        RSInterface.addText(interfaceId, "Dr Bonus: 0", tda, 0, 0xffffff, false, true);
        RSInterface.setBounds(interfaceId, 370, 305, children, Inteface);
        
        interfaceId++;
        children++;
        RSInterface.addCharNew(interfaceId);
        RSInterface.setBounds(interfaceId, 53, 197, children, Inteface);
	}
}
