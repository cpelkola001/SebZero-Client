package com.arlania;

import com.google.gson.annotations.Expose;
import com.shobudesign.Npc;

public final class NPCDef {

	public int frontLight = 68;
	public int backLight = 820;
	public int rightLight = 0;
	public int middleLight = -1; // Cannot be 0
	public int leftLight = 0;
	public static NPCDef copyAnimations(NPCDef npcDef, int npcId) {
		NPCDef npcDef1 = NPCDef.forID(npcId);
		npcDef.runAnim = npcDef1.runAnim;
		npcDef.standAnim = npcDef1.standAnim;
		npcDef.walkAnim = npcDef1.walkAnim;
		npcDef.turn180AnimIndex = npcDef1.turn180AnimIndex;
		npcDef.turn90CCWAnimIndex = npcDef1.turn90CCWAnimIndex;
		npcDef.turn90CWAnimIndex = npcDef1.turn90CWAnimIndex;
		return npcDef;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NPCDef other = (NPCDef) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public void recolor(int targetColor, int newColor) { // edited by Milo
		
		int firstFreeSlot = originalColours.length;
		
		if (originalColours != null) {
			firstFreeSlot = originalColours.length;
		}
		for (int i = 0; i < originalColours.length; i++) {
			if (originalColours[i] == 0) {
				firstFreeSlot = i;
			}
			if (originalColours[i] == targetColor) {
				System.out.println("Was same");
				destColours[i] = newColor;
				return;
			}
		}
		if (firstFreeSlot == originalColours.length) {
			int newLength = firstFreeSlot + 1;
			System.out.println("Set newLength(param) to firstFreeSlot + 1");
			int targetColors[] = new int[newLength];
			int newColors[] = new int[newLength];
			System.arraycopy(originalColours, 0, targetColors, 0, firstFreeSlot);
			System.arraycopy(destColours, 0, newColors, 0, firstFreeSlot);
			originalColours = targetColors;
			destColours = newColors;
		}
		
		originalColours[firstFreeSlot] = targetColor;
		destColours[firstFreeSlot] = newColor;
	}
	
	/**
	 * 	public void recolor(int targetColor, int newColor) { // edited by Milo
		
		int firstFreeSlot = originalModelColors.length;
		
		if (originalModelColors != null) {
			firstFreeSlot = originalModelColors.length;
		}
		for (int i = 0; i < originalModelColors.length; i++) {
			if (originalModelColors[i] == 0) {
				firstFreeSlot = i;
			}
			if (originalModelColors[i] == targetColor) {
				System.out.println("Was same");
				newModelColor[i] = newColor;
				return;
			}
		}
		if (firstFreeSlot == originalModelColors.length) {
			int newLength = firstFreeSlot + 1;
			System.out.println("Set newLength(param) to firstFreeSlot + 1");
			int targetColors[] = new int[newLength];
			int newColors[] = new int[newLength];
			System.arraycopy(originalModelColors, 0, targetColors, 0, firstFreeSlot);
			System.arraycopy(newModelColor, 0, newColors, 0, firstFreeSlot);
			originalModelColors = targetColors;
			newModelColor = newColors;
		}
		
		originalModelColors[firstFreeSlot] = targetColor;
		newModelColor[firstFreeSlot] = newColor;
	}
	 * @param npc
	 * @param npcId
	 * @return
	 */
	
	public static NPCDef copyModel(NPCDef npc, int npcId) {
		NPCDef npc1 = NPCDef.forID(npcId);
		npc.runAnim = npc1.runAnim;
		npc.standAnim = npc1.standAnim;
		npc.walkAnim = npc1.walkAnim;
		npc.turn180AnimIndex = npc1.turn180AnimIndex;
		npc.turn90CCWAnimIndex = npc1.turn90CCWAnimIndex;
		npc.turn90CWAnimIndex = npc1.turn90CWAnimIndex;
		npc.models = npc1.models;
		npc.combatLevel = npc1.combatLevel;
		npc.sizeXZ = npc1.sizeXZ;
		npc.sizeY = npc1.sizeY;
		npc.description = npc1.description;
		npc.actions = npc1.actions;
		npc.originalColours = npc1.originalColours;
		npc.destColours = npc1.destColours;
		return npc;
	}
	
	public void convertTexture(Model model, int id) {
		switch (id) {
			
		case 6593:
		case 6594:
			model.convertNPCTexture(40, 59);
			break;
			
		case 6595:
		case 6596:
			model.convertNPCTexture(40, 71);
			break;
		case 6599:
		case 6600:
			model.convertNPCTexture(40, 40);
			break;
		case 1222:
			model.convertNPCTexture(40, 83);
			break;
		case 6603:
		case 6604:
			model.convertNPCTexture(40, 58);
			break;
		
			
		}
	}

	public static NPCDef forID(int i) {
		for (int j = 0; j < 20; j++)
			if (cache[j].type == (long) i)
				return cache[j];
		cacheIndex = (cacheIndex + 1) % 20;
		NPCDef npc = cache[cacheIndex] = new NPCDef();
		if (i < streamIndices.length) {
            stream.currentOffset = streamIndices[i];
            npc.readValues(stream);
        }
        npc.type = i;
		if (npc.name != null && npc.name.toLowerCase().contains("bank")) {
			if (npc.actions != null) {
				for (int l = 0; l < npc.actions.length; l++) {
					if (npc.actions[l] != null && npc.actions[l].equalsIgnoreCase("Collect"))
						npc.actions[l] = null;
				}
			}
		}
		npc.id = i;
		switch (i) {

		case 9772:
			npc.standAnim = 13696;
			break;
		case 9855:
			npc.standAnim = 13467;
			npc.walkAnim = 13467;
			break;
			
		case 8275:
			npc.actions = new String[] {"Talk-to", null, "Get-task", "Trade" , "Rewards"};
			break;
			
		case 1394:
			npc.name = "@yel@Sell Me Items NOW";
			npc.actions = new String[] {"Trade", null, null, null, null};
			break;
			
			// Lava dragon
		case 2751:
			npc.name = "@or2@Hellfire Dragon";
		    npc.actions = new String[] {null, "Attack", null, null, null};
		    npc.combatLevel = 252;
		    npc.models = new int[] {61300,61301,61302,61423};
		    npc.standAnim = 90;
		    npc.squaresNeeded = 4;
		    npc.walkAnim = 79;
		    npc.drawMinimapDot = true;
		break;
		case 6839:
			npc.sizeY = 80;
			npc.sizeXZ = 80;
		    npc.actions = new String[] {null, "Attack", null, null, null};
		    npc.drawMinimapDot = true;
		break;
		
		case 780:
            npc.name = "Krampus Demon";
            npc.models = new int[]{72065,72066,72067,72068,72069,72070,72071};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 5;
			npc.combatLevel =75;
			npc.description = "Your time has came to an end.";
			npc.sizeY = 400;
			npc.sizeXZ = 400;
		    npc.actions = new String[] {null, "Attack", null, null, null};
		    npc.drawMinimapDot = true;
		break;
		
		case 6594:
			npc.name = "@or2@Hellfire Dragon Pet";
			npc.actions = new String[5];
		    npc.combatLevel = 252;
		    npc.models = new int[] {61300,61301,61302,61423};
		    npc.standAnim = 90;
		    npc.squaresNeeded = 4;
		    npc.walkAnim = 79;
			npc.sizeY = 70;
			npc.sizeXZ = 70;
		    npc.drawMinimapDot = false;
		break;
		
		case 6595:
			npc.name = "@or2@Bluefire UBER Dragon";
		    npc.actions = new String[] {null, "Attack", null, null, null};
		    npc.combatLevel = 252;
		    npc.models = new int[] {61300,61301,61302,61423};
		    npc.standAnim = 90;
		    npc.squaresNeeded = 4;
		    npc.walkAnim = 79;
		    npc.drawMinimapDot = true;
		break;
		
		
		case 885:
			npc.name = "Ghost of Georgie";
			npc.sizeY = 60;
			npc.sizeXZ = 60;
		    npc.models = new int[] {74069,74070,74071,74072}; //74065,74066,74067,74068
		    npc.actions = new String[] {"Speak-to", null, "View Halloween Store" , null, null};
		break;
		
		case 11:
            npc.name = "@bla@Darth Vader";
            npc.models = new int[]{23916, 23918, 23919, 23921, 23922,23924,23897};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 2;
			npc.combatLevel =750;
			npc.description = "this is what its like being on the dark side";
			npc.actions = new String[5];
			npc.sizeY = 170;
			npc.sizeXZ = 170;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
		case 4972:
			npc.models = new int[] {23966};
			npc.name = "Virulent Dragon";
			//definition.rdc2 = 2592952;
			npc.sizeXZ = npc.sizeXZ * 1;
			npc.sizeY = npc.sizeY * 1;
			npc.squaresNeeded = 3;
			break;			
			
		case 12800:
			npc.models = new int[] {61189};
			NPCDef copyAnimations = NPCDef.forID(4972);
			npc.runAnim = copyAnimations.runAnim;
			npc.standAnim = copyAnimations.standAnim;
			npc.walkAnim = copyAnimations.walkAnim;
			npc.name = "@whi@Darkrealm Lugia";
			npc.actions = new String[5];
			//definition.rdc2 = 2592952;
			npc.sizeXZ = npc.sizeXZ * 1;
			npc.sizeY = npc.sizeY * 1;
			npc.squaresNeeded = 3;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;	
			
		case 12807:
			npc.models = new int[] {61189};
			NPCDef copyAnimations3 = NPCDef.forID(4972);
			npc.runAnim = copyAnimations3.runAnim;
			npc.standAnim = copyAnimations3.standAnim;
			npc.walkAnim = copyAnimations3.walkAnim;
			npc.name = "@whi@Darkrealm Lugia Pet";
			npc.actions = new String[5];
			//definition.rdc2 = 2592952;
			npc.sizeY = 50;
			npc.sizeXZ = 50;
			npc.squaresNeeded = 6;
		    npc.drawMinimapDot = false;
			break;	
			
		case 12805:
			npc.models = new int[] {61185};
			NPCDef copyAnimations1 = NPCDef.forID(4972);
			npc.runAnim = copyAnimations1.runAnim;
			npc.standAnim = copyAnimations1.standAnim;
			npc.walkAnim = copyAnimations1.walkAnim;
			npc.name = "@red@Scarlett @bla@Falcon";
			npc.sizeY = 75;
			npc.sizeXZ = 75;
			npc.squaresNeeded = 3;
			break;	
			
		case 12806:
			npc.name = "@red@Blood Ninja";
            npc.models = new int[]{61311,61313,61312,61314,61315,61316,61317};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			//definition.rdc2 = 2592952;
			//npc.sizeXZ = npc.sizeXZ * 2;
			//npc.sizeY = npc.sizeY * 2;
			//npc.squaresNeeded = 2;
			break;	
			
		case 1120:
		npc.name = "Vasa Nistirio";
		npc.description = "Olm Dragon.";
		npc.models = new int[] {23967};
		npc.combatLevel = 83;
		npc.standAnim = 203;
		npc.walkAnim = 204;
		npc.actions = new String[] {null, "Attack", null, null, null};
		npc.sizeY = npc.sizeY * 1;
		npc.squaresNeeded = 1;
		break;
		
		case 819:
			npc.name = "Vasa Nistirio Jr";
			npc.models = new int[]{23967};
			npc.combatLevel = 83;
			npc.standAnim = 303;
			npc.walkAnim = 304;
			npc.sizeY = 30;
			npc.sizeXZ = 30;
			npc.actions = new String[5];


			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 820:
			npc.name = "Supreme Darkbeast Jr";
			npc.models = new int[]{23968};
			npc.combatLevel = 83;
			npc.standAnim = 303;
			npc.walkAnim = 304;
			npc.sizeY = 30;
			npc.sizeXZ = 30;
			npc.actions = new String[5];


			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 4971:
			npc.name = "Virulent Dragon Jr";
			npc.models = new int[]{23966};
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.actions = new String[5];


			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 6249:
			npc.name = "Leo Jr";
			npc.models = new int[]{23976};
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.actions = new String[5];


			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
		
		case 1123:
		npc.name = "Sable Beast";
		npc.models = new int[] {60848};
		npc.combatLevel = 83;
		npc.actions = new String[] {null, "Attack", null, null, null};
		npc.sizeY = npc.sizeY * 1;
		npc.squaresNeeded = 1;
		break;
		
		
		
		case 812:
			npc.name = "Stoned toad";
			npc.models = new int[] {23969};
			npc.combatLevel = 699;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeXZ = npc.sizeXZ * 2;
			npc.sizeY = npc.sizeY * 2;
			npc.actions = new String[] {null, "Attack", null, null, null};
			break;
			
		case 816:
			npc.name = "Stoned Toad Jr";
			npc.models = new int[]{23969};
			npc.walkAnim = 819;
			npc.standAnim = 808;
			npc.combatLevel = 699;
			npc.sizeY = 90;
			npc.sizeXZ = 90;
			npc.actions = new String[5];


			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 817:
			npc.name = "Drakkon Jr";
			npc.models = new int[]{23974};
            npc.combatLevel = 2000;
            npc.standAnim = 12248;
            npc.walkAnim = 12246;
			npc.sizeY = 30;
			npc.sizeXZ = 30;
			npc.actions = new String[5];


			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 818:
			npc.name = "Galvek Jr";
			npc.models = new int[]{23970};
			npc.combatLevel = 699;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 90;
			npc.sizeXZ = 90;
			npc.actions = new String[5];


			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 8000:
			npc.name = "Galvek the great";
			npc.models = new int[] {23970};
			npc.combatLevel = 699;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeXZ = npc.sizeXZ * 2;
			npc.sizeY = npc.sizeY * 2;
			npc.actions = new String[] {null, "Attack", null, null, null};
			break;
			
        case 201:
            npc.name = "Drakkon";
            npc.actions = new String[5];
            npc.actions[1] = "Attack";
            npc.models = new int[] {23974};
            npc.combatLevel = 2000;
            npc.standAnim = 12248;
            npc.walkAnim = 12246;
            npc.sizeXZ = 100;
            npc.sizeY = 100;
            npc.squaresNeeded = 4;
            break;
			
		case 815:
			npc.name = "Zorbak Jr";
			npc.models = new int[]{23973};
			npc.walkAnim = 11975;
			npc.standAnim = 11973;
			npc.combatLevel = 0;
			npc.sizeY = 90;
			npc.sizeXZ = 90;
			npc.actions = new String[5];


			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 5922:
			npc.name = "Zorbak";
			npc.combatLevel = 0;
			npc.models = new int[]{23973};
			npc.combatLevel = 16;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 200;
			npc.sizeXZ = 200;
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 6357:
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.models = new int[1];
			npc.models[0] = 100200;
			npc.name = "Ancient King";
			npc.combatLevel = 0;
			npc.description = "It's a forgotten Ancient King";
			npc.standAnim = 11973;
			npc.walkAnim = 11975;
			npc.sizeXZ = 125;
			npc.sizeY = 125;
			npc.squaresNeeded = 2;
			break;
			
		case 810:
			npc.name = "Mewtwo Jr";
			npc.models = new int[]{23975};
			npc.walkAnim = 11975;
			npc.standAnim = 11973;
			npc.combatLevel = 0;
			npc.sizeY = 50;
			npc.sizeXZ = 50;
			npc.actions = new String[5];


			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
			
		case 6250:
		npc.name = "Leo the Lion";
		npc.models = new int[] {23976};
		npc.combatLevel = 333;
		npc.actions = new String[] {null, "Attack", null, null, null};
		npc.squaresNeeded = 4;
		npc.sizeY = 180;
		npc.sizeXZ = 180;
		break;
			
		case 13:
		npc.name = "Dark Minion";
		npc.models = new int[] {60961};
		npc.combatLevel = 333;
		npc.actions = new String[] {null, "Attack", null, null, null};
		npc.squaresNeeded = 3;
		npc.standAnim = 808;
		npc.walkAnim = 819;
		npc.sizeY = 50;
		npc.sizeXZ = 50;
		break;
			
		
		case 6596:
			npc.name = "@or2@Bluefire Dragon Pet";
			npc.actions = new String[5];
		    npc.combatLevel = 252;
		    npc.models = new int[] {61300,61301,61302,61423};
		    npc.standAnim = 90;
		    npc.squaresNeeded = 4;
		    npc.walkAnim = 79;
			npc.sizeY = 70;
			npc.sizeXZ = 70;
		    npc.drawMinimapDot = false;
		break;
		
		case 6599:
			npc.name = "Summer SebZero Dragon";
		    npc.actions = new String[] {null, "Attack", null, null, null};
		    npc.combatLevel = 252;
		    npc.models = new int[] {61300,61301,61302,61423};
		    npc.standAnim = 90;
		    npc.squaresNeeded = 4;
		    npc.walkAnim = 79;
		    npc.drawMinimapDot = true;
		break;
		
		case 6600:
			npc.name = "@or2@Lava Dragon Pet";
		    npc.combatLevel = 252;
			npc.actions = new String[5];
		    npc.models = new int[] {61300,61301,61302,61423};
		    npc.standAnim = 90;
		    npc.squaresNeeded = 4;
		    npc.walkAnim = 79;
			npc.sizeY = 70;
			npc.sizeXZ = 70;
		    npc.drawMinimapDot = false;
		break;
		case 67:
            npc.name = "Lava Berserk";
            npc.models = new int[]{62302};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "This guy would rip your chest in a million peices";
			npc.actions = new String[5];
			npc.sizeY = 220;
			npc.sizeXZ = 220;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
		
		
	case 68:
        npc.name = "Kalvoth";
        npc.models = new int[]{65212, 65213, 65214, 65216, 65215};
        npc.walkAnim = 819;
        npc.standAnim = 808;
        npc.squaresNeeded = 1;
		npc.combatLevel =75;
		npc.description = "This demon has immense amount of strength. Be ready!";
		npc.actions = new String[5];
		npc.sizeY = 220;
		npc.sizeXZ = 220;
		npc.actions = new String[] {null, "Attack",  null, null, null};
		break;
		
		
		case 6603:
			npc.name = "@gre@Forest Dragon";
		    npc.actions = new String[] {null, "Attack", null, null, null};
		    npc.combatLevel = 252;
		    npc.models = new int[] {61300,61301,61302,61423};
		    npc.standAnim = 90;
		    npc.squaresNeeded = 4;
		    npc.walkAnim = 79;
		    npc.drawMinimapDot = true;
		break;
		
		case 6604:
			npc.name = "@or2@Cool Dragon Pet";
		    npc.combatLevel = 252;
			npc.actions = new String[5];
		    npc.models = new int[] {61300,61301,61302,61423};
		    npc.standAnim = 90;
		    npc.squaresNeeded = 4;
		    npc.walkAnim = 79;
			npc.sizeY = 70;
			npc.sizeXZ = 70;
		    npc.drawMinimapDot = false;
		break;
		
		
			
		case 7846:
			npc.name = "@red@Deluxe Impling";
			break;
		case 5083:
			npc.name = "@whi@Snowy butterfly";
			break;
		case 6307:
			npc.name = "@or2@Venomous Spider";
			npc.description = "One of the guiders of the mighty God Zamorak!";
			npc.sizeXZ = 800;
			npc.sizeY = 800;
			npc.walkAnim = 5325;
			npc.standAnim = 5326;
			npc.combatLevel = 420;
			npc.squaresNeeded = 3;
			npc.models = new int[] { 20309, 20312 };
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.originalColours = new int[6];
			npc.originalColours[0] = 960;
			npc.originalColours[1] = 33728;
			npc.originalColours[2] = 22443;
			npc.originalColours[3] = 11200;
			npc.originalColours[4] = 56256;
			npc.originalColours[5] = 50099;
			npc.destColours = new int[6];
			npc.destColours[0] = 6; // 2ndary spider top arms
			npc.destColours[1] = 665; // spider top arms
			npc.destColours[2] = 660; // spuder under legs
			npc.destColours[3] = 22425; // back of spiders teeth
			npc.destColours[4] = 6; // spiders trim
			npc.destColours[5] = 22425; // spiders joints (cant really notice)
			break;
			
			
			
		case 8888:
			npc.name = "@red@Floating Around Prime Torva Legs";
			npc.description = "I am floating around sir";
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeXZ = 200;
			npc.sizeY = 200;
			npc.combatLevel = 0;
			npc.models = new int[] { 55111 };
			npc.actions = new String[5];

			npc.actions[3] = "@red@Pick Up the legs!!!";
			break;
			
		case 8891:
			ItemDef texturizedModel = ItemDef.forID(4648);
			npc.name = "@red@Floating Around Prime Torva Legs";
			npc.description = "I am floating around sir";
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeXZ = 200;
			npc.sizeY = 200;
			npc.combatLevel = 0;
			npc.models = new int[] { texturizedModel.maleEquip1 };
			npc.originalColours = new int[] {40, 24};
			npc.destColours = new int[] {60, 60};
			npc.actions = new String[5];
			npc.actions[0] = "@or2@Get overload effect";
			npc.actions[3] = "@red@Pick Up the legs!!!";
			break;
			
			
			
			
			
		case 6333:
			npc.name = "King black dragon";
			npc.actions = new String[5];


			npc.models = new int[] { 95136, 95137, 95138, 95139 };
			npc.combatLevel = 276;
			npc.standAnim = 90;
			npc.walkAnim = 4635;
			npc.sizeY = 63;
			npc.sizeXZ = 63;
			npc.squaresNeeded = 3;
			break;
		case 4433:
			npc.name= "@red@Most useful @yel@Fairy@red@ ever";
			npc.actions = new String[5];
			npc.actions[0] = "@or2@Talk to";
			break;
			
		case 9911:
			npc.name = "@or2@Yk'Lagor the Thunderous";
			npc.models = new int[]{61125};
			npc.originalColours = new int[] {60};
			npc.destColours = new int[] {56};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			break;
		case 15:
			npc.name = "@whi@Zeus";
			npc.walkAnim = 819;
			npc.standAnim = 808;
			npc.models = new int[]{23875};//23877,23879,23881,23883,23885,23887
			npc.combatLevel = 6;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 190;
			npc.sizeXZ = 190;
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			npc.combatLevel = 129;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			break;
			
			
		case 601:
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.name = "@whi@Luke Skywalker";
			npc.models = new int[] {23888};
			npc.combatLevel = 385;
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 100;
			npc.sizeXZ = 100;
			break;
			
		case 1069:
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.name = "@whi@Storm Trooper";
			npc.models = new int[] {23891};
			npc.combatLevel = 385;
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 200;
			npc.sizeXZ = 200;
			break;
			
		case 12213:
			npc.name = "@or2@Shenron";
			npc.models = new int[] {60875};
            npc.actions = new String[] {null, null, null, null, null};
			npc.combatLevel = 785;
			npc.standAnim = 5070;
			npc.walkAnim = 5070;
        	npc.sizeY = 70;
			npc.sizeXZ = 70;
            npc.squaresNeeded = 1;
            npc.drawMinimapDot = false;
			break;
			
		case 1222:
			npc.name = "@red@Blood Shenron";
			npc.models = new int[] {48945};
            npc.actions = new String[] {null, null, null, null, null};
			npc.combatLevel = 785;
			npc.standAnim = 5070;
			npc.walkAnim = 5070;
        	npc.sizeY = 70;
			npc.sizeXZ = 70;
            npc.squaresNeeded = 1;
            npc.drawMinimapDot = false;
			break;
			
		case 12240:
			npc.name = "@re1@Bye's Custom pet";
			npc.models = new int[] {49027};
            npc.actions = new String[] {null, null, null, null, null};
			npc.combatLevel = 785;
			NPCDef copyAnimationsdickvagina2 = NPCDef.forID(6311);
			npc.standAnim = copyAnimationsdickvagina2.standAnim;
			NPCDef copyAnimationsdickvagina1 = NPCDef.forID(96);
			npc.runAnim = copyAnimationsdickvagina1.runAnim;
			npc.walkAnim = copyAnimationsdickvagina1.walkAnim;
        	npc.sizeY = 110;
			npc.sizeXZ = 110;
			break;
			
		case 160:
			npc.models = new int[] {74516};
			NPCDef copyNPCAnimations = NPCDef.forID(4972);
			npc.runAnim = copyNPCAnimations.runAnim;
			npc.walkAnim = copyNPCAnimations.walkAnim;
			npc.standAnim = 808;
			npc.name = "@whi@SebZero's Custom pet";
			npc.actions = new String[5];
			//definition.rdc2 = 2592952;
        	npc.sizeY = 180;
			npc.sizeXZ = 180;
			npc.squaresNeeded = 1;
            npc.drawMinimapDot = false;
			npc.actions = new String[] {null, null,  null, null, null};
			break;	
			
		case 53:
			npc.models = new int[] {74518};
			NPCDef copyNPCAnimations1 = NPCDef.forID(4972);
			npc.runAnim = copyNPCAnimations1.runAnim;
			npc.walkAnim = copyNPCAnimations1.walkAnim;
			npc.standAnim = copyNPCAnimations1.standAnim;
			npc.name = "@cya@Blue eyes white dragon";
			npc.actions = new String[5];
			//definition.rdc2 = 2592952;
        	npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.squaresNeeded = 1;
            npc.drawMinimapDot = false;
			npc.actions = new String[] {null, null,  null, null, null};
			break;
			
		case 2332:
			npc.models = new int[] {74729};
			NPCDef copyNPCAnimations122 = NPCDef.forID(4972);
			npc.runAnim = copyNPCAnimations122.runAnim;
			npc.walkAnim = copyNPCAnimations122.walkAnim;
			npc.standAnim = copyNPCAnimations122.standAnim;
			npc.name = "@mag@Ninja's Dragon";
			npc.actions = new String[5];
			//definition.rdc2 = 2592952;
        	npc.sizeY = 150;
			npc.sizeXZ = 150;
			npc.squaresNeeded = 1;
            npc.drawMinimapDot = false;
			npc.actions = new String[] {null, null,  null, null, null};
			break;
		case 1006:
			npc.models = new int[] {74558};
			NPCDef copyNPCAnimations2 = NPCDef.forID(4972);
			npc.runAnim = copyNPCAnimations2.runAnim;
			npc.walkAnim = copyNPCAnimations2.walkAnim;
			npc.standAnim = copyNPCAnimations2.standAnim;
			npc.name = "@yel@Cash Dragon";
			npc.actions = new String[5];
			//definition.rdc2 = 2592952;
        	npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.squaresNeeded = 1;
            npc.drawMinimapDot = false;
			npc.actions = new String[] {null, null,  null, null, null};
			break;
		case 54:
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.name = "@red@Wise old man";
			npc.models = new int[] {74763};
			npc.combatLevel = 785;
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 100;
			npc.sizeXZ = 100;
			break;
			
		case 13463:
            npc.name = "@or2Dat Boi";
            npc.actions = new String[] {null, null, null, null, null};
            npc.combatLevel = 600;
            npc.models = new int[] {60890};
            npc.standAnim = 2433;
            npc.squaresNeeded = 1;
            npc.walkAnim = 2433;
            npc.drawMinimapDot = true;
            break;
            
		case 12239:
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.name = "@bla@Exoden";
			npc.models = new int[] {100239};
			npc.combatLevel = 785;
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 100;
			npc.sizeXZ = 100;
			break;
			
		case 16:
			npc.name = "@whi@Hades";
			npc.walkAnim = 819;
			npc.standAnim = 808;
			npc.models = new int[]{23877,23879,23881,23883,23885,23887}; //23877,23879,23881,23883,23885,23887
			npc.combatLevel = 6;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 170;
			npc.sizeXZ = 170;
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			npc.combatLevel = 624;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			break;
			
		case 1982:
			npc.name = "Charizard";
			npc.models = new int[]{28405};
			npc.walkAnim = 819;
			npc.standAnim = 808;
			npc.squaresNeeded = 1;
			npc.sizeXZ = 100;
			npc.sizeY = 100;
			npc.actions = new String[] {null, "Attack", null, null, null};
			npc.squaresNeeded = 2;
			break;
			
		case 6306:
			npc.name = "Darklord";
			npc.description = "A being from the underworld";
			npc.combatLevel = 3982;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeXZ = 155;
			npc.sizeY = 155;
			npc.models = new int[6];
			npc.models[0] = 91321; //HEAD
			npc.models[1] = 91316; //CHEST
			npc.models[2] = 91274; //CAPE
			npc.models[3] = 91319; //HAND
			npc.models[4] = 91322; //LEG
			npc.models[5] = 91317; //BOOT
			npc.actions = new String[5];
			npc.actions[0] = "Examine";
			npc.actions[1] = "Attack";
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			break;
			
		case 9641:
			npc.combatLevel = 1337;
			npc.name = "@pr2@DBZ Reward Chest";
			npc.actions = new String[5];
			npc.actions[0] = "@red@Open";
			npc.actions[3] = "@gre@Check Rewards";
			npc.models = new int[] {91455};
			npc.sizeXZ = npc.sizeXZ * 2;
			npc.sizeY = npc.sizeY * 2;
			npc.degreesToTurn = 0;
			break;
			
		case 9642:
			npc.combatLevel = 1337;
			npc.name = "@pr2@Final Chest";
			npc.actions = new String[5];
			npc.actions[0] = "@red@Spawn Boss";
			npc.actions[3] = "@gre@Add required items";
			npc.models = new int[] {91455};
			npc.sizeXZ = npc.sizeXZ * 2;
			npc.sizeY = npc.sizeY * 2;
			npc.degreesToTurn = 0;
			break;
			
		case 9647:
			npc.originalColours = new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 40;
			npc.destColours[0] = 60;
			npc.name = "Infernal Wizard";
			npc.description = "A being from the underworld";
			npc.combatLevel = 464;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeXZ = 125;
			npc.sizeY = 125;
			npc.models = new int[6];
			npc.models[0] = 94080; //HEAD
			npc.models[1] = 97279; //CHEST
			npc.models[2] = 96203; //CAPE
			npc.models[3] = 94079; //HAND
			npc.models[4] = 97281; //LEG
			npc.models[5] = 94078; //BOOT
			npc.actions = new String[5];
			npc.actions[0] = "Examine";
			npc.actions[1] = "Attack";
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			npc.drawMinimapDot = true;
			break;
			
			
		case 6303:
			npc.models = new int[]{61237};
			npc.name = "Dantes Satan";
			npc.combatLevel = 666;
			npc.standAnim = 10921;
			npc.walkAnim = 10920;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
		//	npc.type = 8349;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 60;
			npc.sizeXZ = 60;
			npc.squaresNeeded = 2;
			break;
		case 6304:
			npc.models = new int[]{91780};
			npc.name = "Pet Abbadon";
			npc.sizeXZ = 35;
			npc.sizeY = 35;
			npc.combatLevel = 666;
			npc.standAnim = 10921;
			npc.walkAnim = 10920;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 2;
		    npc.drawMinimapDot = false;
			break;
		case 367:
			npc.name = "@or2@Item Gambler";
			npc.models = new int[]{44603};
			npc.actions = new String[5];
			npc.actions[0] = "@red@Info";
			npc.drawMinimapDot = false;
			break;
		case 2358:
			npc.name = "@or2@Raids Npc";
			npc.actions = new String[5];
			npc.actions[0] = "@red@Talk to";
			break;
		case 2880:
			npc.name = "@or2@Raid Lizard";
			npc.actions = new String[5];
			npc.actions[0] = "@red@ATTACK";
			break;
		case 6308:
			npc.name = "@yel@Pet @or2@Venomous Spider";
			npc.description = "One of the guiders of the mighty God Zamorak!";
			npc.sizeXZ = 177;
			npc.sizeY = 177;
			npc.walkAnim = 5325;
			npc.standAnim = 5326;
			npc.combatLevel = 420;
			npc.squaresNeeded = 3;
			npc.models = new int[] { 20309, 20312 };
			npc.actions = new String[5];
			npc.originalColours = new int[6];
			npc.originalColours[0] = 960;
			npc.originalColours[1] = 33728;
			npc.originalColours[2] = 22443;
			npc.originalColours[3] = 11200;
			npc.originalColours[4] = 56256;
			npc.originalColours[5] = 50099;
			npc.destColours = new int[6];
			npc.destColours[0] = 6; // 2ndary spider top arms
			npc.destColours[1] = 665; // spider top arms
			npc.destColours[2] = 660; // spider under legs
			npc.destColours[3] = 22425; // back of spiders teeth
			npc.destColours[4] = 6; // spiders trim
			npc.destColours[5] = 22425; // spiders joints (cant really notice)
		    npc.drawMinimapDot = false;
			break;
		case 6309:
			npc.name = "@or2@Venom spider";
			npc.description = "Venom spider!";
			npc.sizeXZ = 350;
			npc.sizeY = 350;
			npc.walkAnim = 5325;
			npc.standAnim = 5326;
			npc.combatLevel = 164;
			npc.squaresNeeded = 3;
			npc.models = new int[] { 20309, 20312 };
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.originalColours = new int[6];
			npc.originalColours[0] = 960;
			npc.originalColours[1] = 33728;
			npc.originalColours[2] = 22443;
			npc.originalColours[3] = 11200;
			npc.originalColours[4] = 56256;
			npc.originalColours[5] = 50099;
			npc.destColours = new int[6];
			npc.destColours[0] = 6; // 2ndary spider top arms
			npc.destColours[1] = 54169; // spider top arms
			npc.destColours[2] = 54164; // spuder under legs
			npc.destColours[3] = 22425; // back of spiders teeth
			npc.destColours[4] = 6; // spiders trim
			npc.destColours[5] = 22425; // spiders joints (cant really notice)
			break;
		case 9993:
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.originalColours= new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 65;
			npc.destColours[0] = 60;
			npc.models = new int[]{94488};
			npc.name = "@or2@Infernal Beast";
			npc.combatLevel = 1337;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 63;
			npc.sizeXZ = 60;
			npc.squaresNeeded = 2;
			break;
		case 9995:
			npc.name = "@or2@Infernal Beast Pet";
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.originalColours = new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 65;
			npc.destColours[0] = 60;
			npc.models = new int[]{94488};
			npc.combatLevel = 1337;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.sizeY = 25;
			npc.sizeXZ = 25;
			npc.squaresNeeded = 2;
		    npc.drawMinimapDot = false;
			break;
			
		case 420:
			npc.name = "@gre@Joker";
			npc.walkAnim = 819;
			npc.standAnim = 808;
			npc.models = new int[]{23890};
			npc.combatLevel = 6;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 120;
			npc.sizeXZ = 120;
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 197:
			npc.name = "@whi@Advanced Box";
		    npc.models = new int[]{23121};
			npc.originalColours = new int[]{63};
			npc.destColours = new int[] {66};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.sizeXZ = 130;
			npc.sizeY = 130;
            npc.squaresNeeded = 1;
        	npc.sizeY = 300;
			npc.sizeXZ = 300;
			npc.squaresNeeded = 1;
            npc.actions = new String[] {null, "Attack", null, null, null};
            break;
            
		case 191:
			npc.name = "@bla@Extreme Box";
		    npc.models = new int[]{23121};
			npc.originalColours = new int[]{63};
			npc.destColours = new int[] {52};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.sizeXZ = 130;
			npc.sizeY = 130;
            npc.squaresNeeded = 1;
        	npc.sizeY = 300;
			npc.sizeXZ = 300;
			npc.squaresNeeded = 1;
            npc.actions = new String[] {null, "Attack", null, null, null};
            break;
            
		case 225:
			npc.name = "@bla@Advanced box pet";
		    npc.models = new int[]{23121};
			npc.originalColours = new int[]{63};
			npc.destColours = new int[] {66};
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
            break;
            
		case 227:
			npc.name = "@red@Supreme box pet";
		    npc.models = new int[]{23121};
			npc.originalColours = new int[]{63};
			npc.destColours = new int[] {59};
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
            break;
            
		case 223:
			npc.name = "@bla@Extreme box pet";
		    npc.models = new int[]{23121};
			npc.originalColours = new int[]{63};
			npc.destColours = new int[] {52};
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
            break;
            
		case 192:
			npc.name = "@red@Supreme Box";
		    npc.models = new int[]{23121};
			npc.originalColours = new int[]{63};
			npc.destColours = new int[] {59};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.sizeXZ = 130;
			npc.sizeY = 130;
            npc.squaresNeeded = 1;
        	npc.sizeY = 300;
			npc.sizeXZ = 300;
			npc.squaresNeeded = 1;
            npc.actions = new String[] {null, "Attack", null, null, null};
            break;
            
		case 11384:
			npc.name = "@red@MASSive Owner Box";
		    npc.models = new int[]{23121};
			npc.originalColours = new int[]{63};
			npc.destColours = new int[] {52};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
        	npc.sizeY = 300;
			npc.sizeXZ = 300;
			npc.squaresNeeded = 1;
            npc.actions = new String[] {null, "Attack", null, null, null};
            break;
            
		case 3155:
			npc.name = "@gre@Box Zone";
		    npc.models = new int[]{23121};
			npc.originalColours = new int[]{63};
			npc.destColours = new int[] {59};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.sizeXZ = 130;
			npc.sizeY = 130;
            npc.squaresNeeded = 1;
        	npc.sizeY = 300;
			npc.sizeXZ = 300;
			npc.squaresNeeded = 1;
            npc.actions = new String[] {null, "@whi@Visit", null, null, null};
            break;
            
		case 8493:
			npc.name = "@gre@Hulk";
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.originalColours = new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 65;
			npc.destColours[0] = 60;
			npc.models = new int[]{94259};
			npc.combatLevel = 1337;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.squaresNeeded = 2;
			npc.drawMinimapDot = true;
			break;
			
		case 8507:
			npc.name = "@or2@Custom Vorago";
			npc.walkAnim = 1660;
			npc.standAnim = -1;
			npc.models = new int[]{90322};
			npc.combatLevel = 1337;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 65;
			npc.sizeXZ = 65;
			npc.squaresNeeded = 3;
			npc.drawMinimapDot = true;
			break;
			
		case 8512:
			npc.name = "@or2@Custom Vorago Pet";
			npc.walkAnim = -1;
			npc.standAnim = -1;
			npc.models = new int[]{90322};
			npc.combatLevel = 1337;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.sizeY = 65 / 3;
			npc.sizeXZ = 65 / 3;
			npc.squaresNeeded = 2;
		    npc.drawMinimapDot = false;
			break;
			
		case 641:
			npc.name = "@or2@Charizard Pet";
			npc.models = new int[]{28405};
			npc.sizeY = 60;
			npc.sizeXZ = 60;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 12822:
			npc.name = "@or2@Dark Charizard Pet";
			npc.models = new int[]{65258};
			npc.sizeY = 60;
			npc.sizeXZ = 60;
			NPCDef copyAnimations118 = NPCDef.forID(641);
			npc.runAnim = copyAnimations118.runAnim;
			npc.standAnim = copyAnimations118.standAnim;
			npc.walkAnim = copyAnimations118.walkAnim;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
				
		case 12812:
			npc.name = "@or2@Yoshi pet";
			npc.models = new int[]{44359};
			npc.sizeY = 60;
			npc.sizeXZ = 60;
			NPCDef copyAnimations119 = NPCDef.forID(8548);
			npc.runAnim = copyAnimations119.runAnim;
			npc.standAnim = copyAnimations119.standAnim;
			npc.walkAnim = copyAnimations119.walkAnim;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 1008:
			npc.name = "@or2@Bulbasaur Pet";
			npc.models = new int[]{28402};
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 1252:
			npc.name = "@or2@Founder Pet";
			npc.models = new int[]{40150,40152,40154,40156,40158};
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 3137:
			npc.name = "@or2@Eevee Pet";
			npc.models = new int[]{44203};
			npc.sizeY = 50;
			npc.sizeXZ = 50;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
			
		case 5960:
			npc.name = "@or2@Kallen Pet";
			npc.models = new int[]{97380};
			npc.sizeY = 70;
			npc.sizeXZ = 70;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 3138:
			npc.name = "@yel@Jolteon Pet";
			npc.models = new int[]{44206};
			npc.sizeY = 90;
			npc.sizeXZ = 90;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 642:
			npc.name = "@red@Flareon Pet";
			npc.models = new int[]{44207};
			npc.sizeY = 90;
			npc.sizeXZ = 90;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 644:
			npc.name = "@re1@Vaporeon Pet";
			npc.models = new int[]{44208};
			npc.sizeY = 110;
			npc.sizeXZ = 110;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
			
			
		case 722:
			npc.name = "@red@Sylveon Pet";
			npc.models = new int[]{44211};
			npc.sizeY = 110;
			npc.sizeXZ = 110;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
		case 811:
			npc.name = "Ugly Ant Man Jr";
			npc.models = new int[]{94278};
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.combatLevel = 1337;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 1785:
			npc.name = "@or2@Pet Bugatti";
			npc.models = new int[]{13006};
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 1739:
			npc.name = "@or2@Lucario Pet";
			npc.models = new int[]{23141};
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 1946:
			npc.name = "@or2@Skotizo Jr";
			npc.models[0] = 44711;// 31653
			NPCDef skotizo1 = forID(4698);
			npc.standAnim = skotizo1.standAnim;
			npc.walkAnim = skotizo1.walkAnim;
			npc.sizeY = 50;
			npc.sizeXZ = 50;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 744:
			npc.name = "@or2@Godzilla Jr";
			npc.models = new int[]{61225};
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];


			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 1060:
			npc.name = "@or2@Broly Pet";
			npc.models = new int[]{27631};
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
			
		case 904:
			npc.name = "@whi@Bloodbag Merchant";
			npc.actions = new String[5];
			npc.actions = new String[] {"View-items", null,null, null, null};
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 1209:
            npc.models = new int[]{74677};
			npc.name = "@re1@Zen-OH";
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 669:
            npc.models = new int[]{74678};
			npc.name = "@re1@Cell Jr";
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
			
		case 670:
            npc.models = new int[]{74679};
			npc.name = "@yel@Golden Frieza";
			npc.sizeY = 200;
			npc.sizeXZ = 200;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
			
		case 671:
            npc.models = new int[]{74680,74682,74684,74686,74688};
			npc.name = "@yel@Golden Kidbuu";
			npc.sizeY = 200;
			npc.sizeXZ = 200;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
			
		case 672:
            npc.models = new int[]{74693,74695,74697,74699,74700,74702};
			npc.name = "@gre@Piccolo";
			npc.sizeY = 200;
			npc.sizeXZ = 200;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
			
		case 673:
            npc.models = new int[]{74691};
			npc.name = "@yel@Super Great Monkey";
			npc.sizeY = 200;
			npc.sizeXZ = 200;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
			
		case 674:
            npc.models = new int[]{74706,74708,74710,74712,74713};
			npc.name = "@blu@Gotenks";
			npc.sizeY = 200;
			npc.sizeXZ = 200;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
			
		case 675:
            npc.models = new int[]{74703}; //74704 is another kid dbz char
			npc.name = "@or1@Goten";
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
			
		case 676:
            npc.models = new int[]{74669,74671,74673,74675,74676}; //74704 is another kid dbz char
			npc.name = "@bla@Raditz";
			npc.sizeY = 130;
			npc.sizeXZ = 130;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
			
		case 678:
            npc.models = new int[]{74722,74717,74724,74720,74719}; //74704 is another kid dbz char
			npc.name = "@re1@Beerus";
			npc.sizeY = 130;
			npc.sizeXZ = 130;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
			
		case 679:
            npc.models = new int[]{74704}; //74704 is another kid dbz char
			npc.name = "@re1@Beerus";
			npc.sizeY = 130;
			npc.sizeXZ = 130;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
		case 2026:
            npc.models = new int[]{74734,74735,74736,74733,74732,74731,74730}; //74704 is another kid dbz char
			npc.name = "@blu@Morrigan Pale";
			npc.sizeY = 160;
			npc.sizeXZ = 160;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
		case 2027:
            npc.models = new int[]{74741,74742,74743,74744,74745,74746}; //74704 is another kid dbz char
			npc.name = "@re1@Nemisis";
			npc.sizeY = 170;
			npc.sizeXZ = 170;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
		case 2030:
            npc.models = new int[]{74747,74748,74749,74750,74751,74752}; //74704 is another kid dbz char
			npc.name = "@whi@Poseidon";
			npc.sizeY = 180;
			npc.sizeXZ = 180;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
		case 2028:
            npc.models = new int[]{74754,74756,74757,74758,74759,74760,74761}; //74704 is another kid dbz char
			npc.name = "@red@Artemis";
			npc.sizeY = 180;
			npc.sizeXZ = 180;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
		case 2029:
            npc.models = new int[]{74764,74765,74766,74767,74768,74769,74770,74771}; //74704 is another kid dbz char
			npc.name = "@red@Jing Wei";
			npc.sizeY = 180;
			npc.sizeXZ = 180;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
		case 2025:
            npc.models = new int[]{74772,74773,74774,74775,74776,74777,74778}; //74704 is another kid dbz char
			npc.name = "@red@Thanatos";
			npc.sizeY = 160;
			npc.sizeXZ = 160;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
		case 2086:
            npc.models = new int[]{74762}; //74704 is another kid dbz char
			npc.name = "@yel@Legendary Guard";
			npc.sizeY = 125;
			npc.sizeXZ = 125;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
		case 680:
            npc.models = new int[]{74726}; //74704 is another kid dbz char
			npc.name = "@red@Mutated Magma bloat";
			npc.sizeY = 130;
			npc.sizeXZ = 130;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = true;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
			
		case 809:
            npc.models = new int[]{23122, 23123, 23125, 23127, 23112};
			npc.name = "@or2@God Fusion Goku Pet";
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 11888:
            npc.models = new int[]{23723};
			npc.name = "@or2@Craterman";
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.actions = new String[5];

            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
		case 806:
			npc.name = "@or2@Goku Pet";
            npc.models = new int[]{23820, 23782, 23780, 23778, 23787};
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 808:
			npc.name = "@or2@Vegeta Pet";
            npc.models = new int[]{23786, 23787, 23789, 23791, 23793};
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;

			
		case 755:
			npc.name = "@or2@Cookie Monster Pet";
			npc.models = new int[]{28328};
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 5539:
			npc.name = "@or2@Elemental Pet";
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			copyModel(npc, 5540);
			break;
			
		case 5540:
			npc.name = "@or2@Elemental Pet";
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 640:
			npc.name = "@or2@Joker Pet";
			npc.models = new int[]{23890};
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 639:
			npc.name = "@or2@Charmander Pet";
			npc.models = new int[]{28401};
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			break;
			
		case 8497:
			npc.name = "@gre@Hulks Pet";
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.originalColours = new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 65;
			npc.destColours[0] = 60;
			npc.models = new int[]{94259};
			npc.combatLevel = 1337;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.sizeY = 50;
			npc.sizeXZ = 50;
			npc.squaresNeeded = 2;
		    npc.drawMinimapDot = false;
			break;
		case 9912:
			npc.name = "@or2@Ugly Ant Man";
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[]{94278};
			npc.combatLevel = 1337;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 200;
			npc.sizeXZ = 200;
			npc.squaresNeeded = 4;
			npc.drawMinimapDot = true;
			break;
		case 196:
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.name = "@bla@Room one SebZero minion";
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.drawMinimapDot = true;
			break;
		case 282:
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.name = "@bla@Room three SebZero minion";
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.drawMinimapDot = true;
			break;
		case 158:
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.name = "@bla@Room four SebZero minion";
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.drawMinimapDot = true;
			break;
		case 181:
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.name = "@bla@Room five SebZero minion";
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.drawMinimapDot = true;
			break;
		case 202:
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.name = "@bla@Room six SebZero minion";
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.drawMinimapDot = true;
			break;
			
		case 1683:
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.name = "@bla@Room two SebZero minion";
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.drawMinimapDot = true;
			break;
		case 9903:
			npc.name = "@bla@King Kong";
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[]{96953};
			npc.combatLevel = 1337;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 150;
			npc.sizeXZ = 150;
			npc.squaresNeeded = 2;
			npc.drawMinimapDot = true;
			break;
		case 9913:
			npc.originalColours = new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 40;
			npc.destColours[0] = 59;
			npc.name = "@or2@Weird af BOSS";
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[]{94388};
			npc.combatLevel = 1337;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.squaresNeeded = 5;
			npc.drawMinimapDot = true;
			break;
			
		case 5441:
		npc.name = "@whi@DBZ Store";
        npc.models = new int[]{23820, 23782, 23780, 23778, 23777};
        npc.walkAnim = 819;
        npc.standAnim = 808;
        npc.squaresNeeded = 1;
		npc.sizeY = 150;
		npc.sizeXZ = 150;
		break;
		
		case 6:
		npc.name = "@or2@Time Wizard";
        npc.models = new int[]{60964};
        npc.walkAnim = 819;
        npc.standAnim = 808;
        npc.squaresNeeded = 1;
		npc.sizeY = 150;
		npc.sizeXZ = 150;
		break;
		
		case 5:
		npc.name = "@or2@Exodia The Forbidden One";
        npc.models = new int[]{60951};
        npc.walkAnim = 819;
        npc.standAnim = 808;
        npc.squaresNeeded = 1;
		npc.sizeY = 150;
		npc.sizeXZ = 150;
		break;
		
		case 4:
		npc.name = "@or2@Obelisk The Tormentor";
        npc.models = new int[]{60949};
        npc.walkAnim = 819;
        npc.standAnim = 808;
        npc.squaresNeeded = 1;
		npc.sizeY = 150;
		npc.sizeXZ = 150;
		break;
		
		case 9932:
			npc.originalColours = new int[2];
			npc.destColours = new int[2];
			npc.originalColours[0] = 40;
			npc.destColours[0] = 57;
			npc.originalColours[1] = 53;
			npc.destColours[1] = 57;
			npc.name = "@bla@GodZilla";
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[]{61225};
			npc.combatLevel = 1337;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 175;
			npc.sizeXZ = 175;
			npc.squaresNeeded = 3;
			npc.drawMinimapDot = true;
			break;
		case 9994:
			npc.name = "@whi@Jinni";
			npc.actions = new String[5];
			npc.models = new int[] {97410};
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.squaresNeeded = 2;
			break;
		case 9996:
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.originalColours= new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 62;
			npc.destColours[0] = 59;
			npc.models = new int[]{94346};
			npc.name = "@or2@Shaman Defenders Pet";
			npc.combatLevel = 1337;
			//npc.standAnim = 10921;
			//npc.walkAnim = 10920;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.sizeY = 55;
			npc.sizeXZ = 55;
			npc.squaresNeeded = 2;
		    npc.drawMinimapDot = false;
			break;
			/*ModelID: [21147]
					---------------------------------Stand animation 5530
					---------------------------------Walk animation 5531
					---------------------------------ID: 1552
					Name: Santa
					Original Colors: [6798, 8078, 8741, 25238, 6587, 5400]
					Dest Colors: [86, 10351, 933, 933, 10351, 0]
					---------------------------------
					ModelID: [235, 189, 299, 4226, 4218, 162, 4924, 4925, 4926]
					---------------------------------Stand animation 808
					---------------------------------Walk animation 819
					---------------------------------ID: 1553*/
		case 6310:
			npc.name = "Pet Le'fosh The Brutal";
			npc.description = "Iktomi's brethren!";
			npc.walkAnim = 5325;
			npc.standAnim = 5326;
			npc.combatLevel = 164;
			npc.squaresNeeded = 3;
			npc.models = new int[] { 20309, 20312 };
			npc.actions = new String[5];
			npc.originalColours = new int[6];
			npc.originalColours[0] = 960;
			npc.originalColours[1] = 33728;
			npc.originalColours[2] = 22443;
			npc.originalColours[3] = 11200;
			npc.originalColours[4] = 56256;
			npc.originalColours[5] = 50099;
			npc.destColours = new int[6];
			npc.destColours[0] = 6; // 2ndary spider top arms
			npc.destColours[1] = 54169; // spider top arms
			npc.destColours[2] = 54164; // spuder under legs
			npc.destColours[3] = 22425; // back of spiders teeth
			npc.destColours[4] = 6; // spiders trim
			npc.destColours[5] = 22425; // spiders joints (cant really notice)
		    npc.drawMinimapDot = false;
			break;
		case 10702:
			npc.name = "Super Angry wolf";
			npc.description = "This npc drops good gear";
			npc.combatLevel = 173;
			NPCDef copyAnimationsdickvagina = NPCDef.forID(96);
			npc.runAnim = copyAnimationsdickvagina.runAnim;
			npc.standAnim = copyAnimationsdickvagina.standAnim;
			npc.walkAnim = copyAnimationsdickvagina.walkAnim;
			npc.models = new int[] { 100305 };
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			break;
		case 6311:
			npc.name = "Custom Hellhound";
			npc.description = "This npc drops good gear";
			npc.combatLevel = 173;
			npc.walkAnim = 1197;
			npc.standAnim = 1198;
			npc.models = new int[] { 3879 };
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.originalColours = new int[8];
			npc.originalColours[0] = 9129; // body
			npc.originalColours[1] = 10155; // hair
			npc.originalColours[2] = 127; // claws
			npc.originalColours[3] = 10126; // end of tail
			npc.originalColours[4] = 11177; // nothing
			npc.originalColours[5] = 4818; // ears
			npc.originalColours[6] = 12; // nose
			npc.originalColours[7] = 0; // eyes
			npc.destColours = new int[8];
			npc.destColours[0] = 660;
			npc.destColours[1] = 3;
			npc.destColours[2] = 3;
			npc.destColours[3] = 3;
			npc.destColours[4] = 3;
			npc.destColours[5] = 3;
			npc.destColours[6] = 995;
			npc.destColours[7] = 995;
			break;
		case 6316:
			npc.name = "Mini Custom Hound";
			npc.description = "Sharp likes sucky fucky, sucky likes suki diki";
			npc.sizeXZ = 50;
			npc.sizeY = 50;
			npc.combatLevel = 173;
			npc.walkAnim = 1197;
			npc.standAnim = 1198;
			npc.models = new int[] { 3879 };
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.originalColours = new int[8];
			npc.originalColours[0] = 9129; // body
			npc.originalColours[1] = 10155; // hair
			npc.originalColours[2] = 127; // claws
			npc.originalColours[3] = 10126; // end of tail
			npc.originalColours[4] = 11177; // nothing
			npc.originalColours[5] = 4818; // ears
			npc.originalColours[6] = 12; // nose
			npc.originalColours[7] = 0; // eyes
			npc.destColours = new int[8];
			npc.destColours[0] = 660;
			npc.destColours[1] = 3;
			npc.destColours[2] = 3;
			npc.destColours[3] = 3;
			npc.destColours[4] = 3;
			npc.destColours[5] = 3;
			npc.destColours[6] = 995;
			npc.destColours[7] = 995;
			break;
		case 6312:
			npc.name = "Pet Custom hound";
			npc.description = "hehe";
			npc.sizeXZ = 70;
			npc.sizeY = 70;
			npc.combatLevel = 173;
			npc.walkAnim = 1197;
			npc.standAnim = 1198;
			npc.models = new int[] { 3879 };
			npc.actions = new String[5];
			npc.originalColours = new int[8];
			npc.originalColours[0] = 9129; // body
			npc.originalColours[1] = 10155; // hair
			npc.originalColours[2] = 127; // claws
			npc.originalColours[3] = 10126; // end of tail
			npc.originalColours[4] = 11177; // nothing
			npc.originalColours[5] = 4818; // ears
			npc.originalColours[6] = 12; // nose
			npc.originalColours[7] = 0; // eyes
			npc.destColours = new int[8];
			npc.destColours[0] = 660;
			npc.destColours[1] = 3;
			npc.destColours[2] = 3;
			npc.destColours[3] = 3;
			npc.destColours[4] = 3;
			npc.destColours[5] = 3;
			npc.destColours[6] = 995;
			npc.destColours[7] = 995;
		    npc.drawMinimapDot = false;
			break;
		case 6322:
			npc.name = "Pet Custom hound";
			npc.description = "hehe a pet hellhound";
			npc.sizeXZ = 70;
			npc.sizeY = 70;
			npc.combatLevel = 173;
			npc.walkAnim = 1197;
			npc.standAnim = 1198;
			npc.models = new int[] { 3879 };
			npc.actions = new String[5];
			npc.originalColours = new int[8];
			npc.originalColours[0] = 9129; // body
			npc.originalColours[1] = 10155; // hair
			npc.originalColours[2] = 127; // claws
			npc.originalColours[3] = 10126; // end of tail
			npc.originalColours[4] = 11177; // nothing
			npc.originalColours[5] = 4818; // ears
			npc.originalColours[6] = 12; // nose
			npc.originalColours[7] = 0; // eyes
			npc.destColours = new int[8];
			npc.destColours[0] = 49863;
			npc.destColours[1] = 49863;
			npc.destColours[2] = 49863;
			npc.destColours[3] = 49863;
			npc.destColours[4] = 49863;
			npc.destColours[5] = 49863;
			npc.destColours[6] = 49863;
			npc.destColours[7] = 49863;
		    npc.drawMinimapDot = false;
			break;
		case 6313:
			npc.name = "Abyzou Heartwrencher";
			npc.sizeXZ = 160;
			npc.sizeY = 160;
			npc.combatLevel = 718;
			npc.walkAnim = 63;
			npc.standAnim = 66;
			npc.models = new int[] { 17375, 17391, 17384, 17399 };
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.originalColours = new int[9];
			npc.originalColours[0] = 5219; // teeth
			npc.originalColours[1] = 910; // inside of mouth. Ankles. End of tail
			npc.originalColours[2] = 1814; // around face. Start of tail
			npc.originalColours[3] = 1938; // around face and back of head. Top part of legs and end bit of tail.
			npc.originalColours[4] = 1690; // top of forehead
			npc.originalColours[5] = 921; // eyebrows
			npc.originalColours[6] = 0; // horns. Feet
			npc.originalColours[7] = 962; // eye colour
			npc.originalColours[8] = 912; // knees, dick, end of tail
			npc.destColours = new int[9];
			npc.destColours[0] = 5584;
			npc.destColours[1] = 5584;
			npc.destColours[2] = 43;
			npc.destColours[3] = 6550;
			npc.destColours[4] = 6550;
			npc.destColours[5] = 43;
			npc.destColours[6] = 5584;
			npc.destColours[7] = 9152;
			npc.destColours[8] = 42;
			break;
			
		case 3218:
			npc.name = "@whi@Tax Bag shop";
			break;
			
		case 10038:
			npc.name = "To'Kash the Bloodchiller";
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.standAnim = 14967;
			npc.walkAnim = 14966;
			npc.combatLevel = 1337;
			npc.sizeXZ = 160;
			npc.sizeY = 160;
			break;
			
			
		case 10140:
			npc.name = "Bal'lak The Pummeler";
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.standAnim = 14967;
			npc.walkAnim = 14966;
			npc.sizeXZ = 160;
			npc.sizeY = 160;
			npc.combatLevel = 1337;
			break;
		case 6314:
			npc.name = "@red@Custom @or2@Abyzou Heartwrencher";
			npc.sizeXZ = 160;
			npc.sizeY = 160;
			npc.combatLevel = 1337;
			npc.walkAnim = 63;
			npc.standAnim = 66;
			npc.models = new int[] { 17375, 17391, 17384, 17399 };
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.originalColours = new int[9];
			npc.originalColours[0] = 5219; // teeth
			npc.originalColours[1] = 910; // inside of mouth. Ankles. End of tail
			npc.originalColours[2] = 1814; // around face. Start of tail
			npc.originalColours[3] = 1938; // around face and back of head. Top part of legs and end bit of tail.
			npc.originalColours[4] = 1690; // top of forehead
			npc.originalColours[5] = 921; // eyebrows
			npc.originalColours[6] = 0; // horns. Feet
			npc.originalColours[7] = 962; // eye colour
			npc.originalColours[8] = 912; // knees, dick, end of tail
			npc.destColours = new int[9];
			npc.destColours[0] = 49863;
			npc.destColours[1] = 49863;
			npc.destColours[2] = 49863;
			npc.destColours[3] = 49863;
			npc.destColours[4] = 49863;
			npc.destColours[5] = 49863;
			npc.destColours[6] = 49863;
			npc.destColours[7] = 49863;
			npc.destColours[8] = 49863;
			// npc.anInt55:-1, npc.anInt57:-1, npc.anInt58:-1, npc.anInt59:-1,
			// npc.anInt75:-1, entity.anInt79:16, npc.anInt83:-1, npc.anInt85:0,
			// npc.anInt86:128, npc.anInt91:128, entity.anInt92:0, entity.anInt56:13
			break;
		case 6325:
			npc.name = "Mini Abyzou Heartwrencher";
			npc.sizeXZ = 50;
			npc.sizeY = 50;
			npc.combatLevel = 178;
			npc.walkAnim = 63;
			npc.standAnim = 66;
			npc.models = new int[] { 17375, 17391, 17384, 17399 };
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.originalColours = new int[9];
			npc.originalColours[0] = 5219; // teeth
			npc.originalColours[1] = 910; // inside of mouth. Ankles. End of tail
			npc.originalColours[2] = 1814; // around face. Start of tail
			npc.originalColours[3] = 1938; // around face and back of head. Top part of legs and end bit of tail.
			npc.originalColours[4] = 1690; // top of forehead
			npc.originalColours[5] = 921; // eyebrows
			npc.originalColours[6] = 0; // horns. Feet
			npc.originalColours[7] = 962; // eye colour
			npc.originalColours[8] = 912; // knees, dick, end of tail
			npc.destColours = new int[9];
			npc.destColours[0] = 5584;
			npc.destColours[1] = 5584;
			npc.destColours[2] = 43;
			npc.destColours[3] = 6550;
			npc.destColours[4] = 6550;
			npc.destColours[5] = 43;
			npc.destColours[6] = 5584;
			npc.destColours[7] = 9152;
			npc.destColours[8] = 42;
			// npc.anInt55:-1, npc.anInt57:-1, npc.anInt58:-1, npc.anInt59:-1,
			// npc.anInt75:-1, entity.anInt79:16, npc.anInt83:-1, npc.anInt85:0,
			// npc.anInt86:128, npc.anInt91:128, entity.anInt92:0, entity.anInt56:13
			break;
		case 6328:
			npc.name = "Mini Abyzou Heartwrencher Pet";
		    npc.drawMinimapDot = false;
			npc.combatLevel = 178;
			npc.walkAnim = 63;
			npc.standAnim = 66;
			npc.sizeXZ = 30;
			npc.sizeY = 30;
			npc.models = new int[] { 17375, 17391, 17384, 17399 };
			npc.actions = new String[5];
			npc.originalColours = new int[9];
			npc.originalColours[0] = 5219; // teeth
			npc.originalColours[1] = 910; // inside of mouth. Ankles. End of tail
			npc.originalColours[2] = 1814; // around face. Start of tail
			npc.originalColours[3] = 1938; // around face and back of head. Top part of legs and end bit of tail.
			npc.originalColours[4] = 1690; // top of forehead
			npc.originalColours[5] = 921; // eyebrows
			npc.originalColours[6] = 0; // horns. Feet
			npc.originalColours[7] = 962; // eye colour
			npc.originalColours[8] = 912; // knees, dick, end of tail
			npc.destColours = new int[9];
			npc.destColours[0] = 5584;
			npc.destColours[1] = 5584;
			npc.destColours[2] = 43;
			npc.destColours[3] = 6550;
			npc.destColours[4] = 6550;
			npc.destColours[5] = 43;
			npc.destColours[6] = 5584;
			npc.destColours[7] = 9152;
			npc.destColours[8] = 42;
			// npc.anInt55:-1, npc.anInt57:-1, npc.anInt58:-1, npc.anInt59:-1,
			// npc.anInt75:-1, entity.anInt79:16, npc.anInt83:-1, npc.anInt85:0,
			// npc.anInt86:128, npc.anInt91:128, entity.anInt92:0, entity.anInt56:13
			break;
		case 6315:
			npc.name = "Heartwrencher Pet";
		    npc.drawMinimapDot = false;
			npc.combatLevel = 718;
			npc.walkAnim = 63;
			npc.standAnim = 66;
			npc.sizeXZ = 50;
			npc.sizeY = 50;
			npc.models = new int[] { 17375, 17391, 17384, 17399 };
			npc.actions = new String[5];
			npc.originalColours = new int[9];
			npc.originalColours[0] = 5219; // teeth
			npc.originalColours[1] = 910; // inside of mouth. Ankles. End of tail
			npc.originalColours[2] = 1814; // around face. Start of tail
			npc.originalColours[3] = 1938; // around face and back of head. Top part of legs and end bit of tail.
			npc.originalColours[4] = 1690; // top of forehead
			npc.originalColours[5] = 921; // eyebrows
			npc.originalColours[6] = 0; // horns. Feet
			npc.originalColours[7] = 962; // eye colour
			npc.originalColours[8] = 912; // knees, dick, end of tail
			npc.destColours = new int[9];
			npc.destColours[0] = 49863;
			npc.destColours[1] = 49863;
			npc.destColours[2] = 49863;
			npc.destColours[3] = 49863;
			npc.destColours[4] = 49863;
			npc.destColours[5] = 49863;
			npc.destColours[6] = 49863;
			npc.destColours[7] = 49863;
			npc.destColours[8] = 49863;
			break;
			
		case 9864:
			npc.combatLevel = 1;
			npc.models = new int[] { 44202,44429,44431,44432,44433,44434,94073 };
			npc.sizeXZ = 200;
			npc.sizeY = 200;
			npc.name = "@whi@Byakuya";
			npc.standAnim = -1;
			npc.walkAnim = -1;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			break;
			
		case 3:
			npc.combatLevel = 1;
			npc.models = new int[] {44734,44385,44386,44388,44389,44387,23994,23340 };
			npc.sizeXZ = 200;
			npc.sizeY = 200;
			npc.name = "@whi@Tezkid";
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			break;
			
		case 229:
			npc.name = "Scrooge Mcduck Pet";
		    npc.models = new int[]{40025};
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
            break;
            
		case 4581:
			npc.name = "Starwars Zone";
		    npc.models = new int[]{40028};
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.sizeY = 120;
			npc.sizeXZ = 120;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[0] = "@whi@Visit";
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
            break;
            
		case 729:
			npc.name = "@yel@Token Zone";
		    npc.models = new int[]{40087};
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[0] = "@whi@Visit";
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
            break;
            
		case 2322:
			npc.name = "Killer chucky pet";
		    npc.models = new int[]{40032};
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
            break;
            
            
            
		case 727:
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.models = new int[1];
			npc.models[0] = 40031;
			npc.name = "Luigi";
			npc.combatLevel = 100;
			npc.description = "It's Luigi.";
			npc.standAnim = 11973;
			npc.walkAnim = 11975;
			npc.squaresNeeded = 1;
			break;
			
		case 728:
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.models = new int[1];
			npc.models[0] = 40079;
			npc.name = "Bowser";
			npc.combatLevel = 100;
			npc.description = "It's Bowser";
			npc.standAnim = 11973;
			npc.walkAnim = 11975;
			npc.squaresNeeded = 1;
			npc.sizeY = 50;
			npc.sizeXZ = 50;
			break;
            
		case 10004:
			npc.name = "Yugi Muto";
		    npc.models = new int[]{60974};
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
            npc.headIcon = -1;
            break;
		case 230:
			npc.name = "Baby Yoda Pet";
		    npc.models = new int[]{40028};
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
            break;
			
		case 12299:
			npc.name = "Mew";
		    npc.models = new int[]{60977};
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			npc.actions[1] = "Attack";
            break;
			
            
		case 4541:
			npc.combatLevel = 1000;
			npc.models = new int[] { 95059, 95055, 95053, 95051, 95047, 95045, 94073 };
			npc.sizeXZ = 300;
			npc.sizeY = 300;
			npc.name = "@yel@Milo";
			npc.standAnim = -1;
			npc.walkAnim = -1;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			break;

            case 10000:
                npc.combatLevel = 999;
                npc.models = new int[] {60974};
                npc.name = "Yugi Muto";
                npc.sizeXZ = 250;
                npc.sizeY = 250;
                npc.walkAnim = 819;
                npc.standAnim = 808;
                npc.actions = new String[5];
                npc.actions[1] = "Attack";
                npc.headIcon = 1;
                break;

            case 10001:
                npc.combatLevel = 999;
                npc.models = new int[] {100001};
                npc.name = "Exodia The Forbidden One";
                npc.sizeXZ = 150;
                npc.sizeY = 150;
                npc.walkAnim = 819;
                npc.standAnim = 808;
                npc.actions = new String[5];
                npc.actions[1] = "Attack";
                npc.headIcon = 0;
                break;

            case 10002:
                npc.combatLevel = 999;
                npc.models = new int[] {100002};
                npc.name = "Time Wizard";
                npc.sizeXZ = 150;
                npc.sizeY = 150;
                npc.walkAnim = 819;
                npc.standAnim = 808;
                npc.actions = new String[5];
                npc.actions[1] = "Attack";
                npc.headIcon = 1;
                break;

            case 10003:
                npc.combatLevel = 999;
                npc.models = new int[] {100003};
                npc.name = "Dark Magician";
                npc.sizeXZ = 150;
                npc.sizeY = 150;
                npc.walkAnim = 819;
                npc.standAnim = 808;
                npc.actions = new String[5];
                npc.actions[1] = "Attack";
                npc.headIcon = 2;
                break;
                

            case 4543:
                npc.combatLevel = 244;
                npc.models = new int[] {40235,40237,40231,40233,40229,25141};
                npc.name = "@yel@P@red@E@yel@N@red@N@yel@Y@red@W@yel@I@red@S@yel@E";
                npc.sizeXZ = 150;
                npc.sizeY = 150;
                npc.walkAnim = 819;
                npc.standAnim = 808;
                npc.actions = new String[5];
                npc.actions[1] = "Attack";
                break;
            case 4544:
                npc.models = new int[] {56401};
                npc.name = "@whi@Summer surfer";
                npc.sizeXZ = 50;
                npc.sizeY = 50;
                npc.walkAnim = 819;
                npc.standAnim = 808;
    			npc.actions = new String[5];
    			npc.actions = new String[] {null, null, null, null, null};
                break;
                
            case 4545:
                npc.models = new int[] {74065,74066,74067,74068};
                npc.name = "@yel@Georgie";
                npc.sizeXZ = 50;
                npc.sizeY = 50;
                npc.walkAnim = 819;
                npc.standAnim = 808;
    			npc.actions = new String[5];
    			npc.actions = new String[] {null, null, null, null, null};
                break;
                
            case 4250:
                npc.models = new int[] {40208,40209,40210,40211,40212};
                npc.name = "@yel@Freddy Kruger";
                npc.sizeXZ = 50;
                npc.sizeY = 50;
                npc.walkAnim = 819;
                npc.standAnim = 808;
    			npc.actions = new String[5];
    			npc.actions = new String[] {null, null, null, null, null};
                break;
            case 4251:
                npc.models = new int[] {40214,40215,40216,40217,40218,40219};
                npc.name = "@yel@Michael Myers";
                npc.sizeXZ = 50;
                npc.sizeY = 50;
                npc.walkAnim = 819;
                npc.standAnim = 808;
    			npc.actions = new String[5];
    			npc.actions = new String[] {null, null, null, null, null};
                break;
            case 4252:
                npc.models = new int[] {40501};
                npc.name = "@yel@Jason";
                npc.sizeXZ = 50;
                npc.sizeY = 50;
                npc.walkAnim = 819;
                npc.standAnim = 808;
    			npc.actions = new String[5];
    			npc.actions = new String[] {null, null, null, null, null};
                break;
            case 3920:
                npc.models = new int[] {40504};
                npc.name = "@bla@Slenderman";
                npc.sizeXZ = 50;
                npc.sizeY = 50;
                npc.walkAnim = 819;
                npc.standAnim = 808;
    			npc.actions = new String[5];
    			npc.actions = new String[] {null, null, null, null, null};
                break;
            case 4546:
                npc.models = new int[] {40227};
                npc.name = "@yel@Jack o'Lantern";
                npc.sizeXZ = 100;
                npc.sizeY = 100;
                npc.walkAnim = 819;
                npc.standAnim = 808;
    			npc.actions = new String[5];
    			npc.actions = new String[] {null, null, null, null, null};
                break;
                
		case 6318:
			npc.name = "Pet Emeraldencher";
			npc.combatLevel = 718;
			npc.walkAnim = 63;
			npc.standAnim = 66;
			npc.sizeXZ = 70;
			npc.sizeY = 70;
			npc.models = new int[] { 17375, 17391, 17384, 17399 };
			npc.actions = new String[5];
			npc.originalColours = new int[9];
			npc.originalColours[0] = 5219; // teeth
			npc.originalColours[1] = 910; // inside of mouth. Ankles. End of tail
			npc.originalColours[2] = 1814; // around face. Start of tail
			npc.originalColours[3] = 1938; // around face and back of head. Top part of legs and end bit of tail.
			npc.originalColours[4] = 1690; // top of forehead
			npc.originalColours[5] = 921; // eyebrows
			npc.originalColours[6] = 0; // horns. Feet
			npc.originalColours[7] = 962; // eye colour
			npc.originalColours[8] = 912; // knees, dick, end of tail
			npc.destColours = new int[9];
			npc.destColours[0] = 13333;
			npc.destColours[1] = 13333;
			npc.destColours[2] = 13333;
			npc.destColours[3] = 13333;
			npc.destColours[4] = 13333;
			npc.destColours[5] = 13333;
			npc.destColours[6] = 13333;
			npc.destColours[7] = 13333;
			npc.destColours[8] = 13333;
		    npc.drawMinimapDot = false;
			// npc.anInt55:-1, npc.anInt57:-1, npc.anInt58:-1, npc.anInt59:-1,
			// npc.anInt75:-1, entity.anInt79:16, npc.anInt83:-1, npc.anInt85:0,
			// npc.anInt86:128, npc.anInt91:128, entity.anInt92:0, entity.anInt56:13
			break;
		case 6319:
			npc.name = "Custom Wrencher";
			npc.combatLevel = 1337;
			npc.walkAnim = 63;
			npc.standAnim = 66;
			npc.sizeXZ = 70;
			npc.sizeY = 70;
			npc.models = new int[] { 17375, 17391, 17384, 17399 };
			npc.actions = new String[5];


			npc.originalColours = new int[9];
			npc.originalColours[0] = 5219; // teeth
			npc.originalColours[1] = 910; // inside of mouth. Ankles. End of tail
			npc.originalColours[2] = 1814; // around face. Start of tail
			npc.originalColours[3] = 1938; // around face and back of head. Top part of legs and end bit of tail.
			npc.originalColours[4] = 1690; // top of forehead
			npc.originalColours[5] = 921; // eyebrows
			npc.originalColours[6] = 0; // horns. Feet
			npc.originalColours[7] = 962; // eye colour
			npc.originalColours[8] = 912; // knees, dick, end of tail
			npc.destColours = new int[9];
			npc.destColours[0] = 5584;
			npc.destColours[1] = 5584;
			npc.destColours[2] = 43;
			npc.destColours[3] = 6334;
			npc.destColours[4] = 6550;
			npc.destColours[5] = 43;
			npc.destColours[6] = 5584;
			npc.destColours[7] = 9152;
			npc.destColours[8] = 42;
			// npc.anInt55:-1, npc.anInt57:-1, npc.anInt58:-1, npc.anInt59:-1,
			// npc.anInt75:-1, entity.anInt79:16, npc.anInt83:-1, npc.anInt85:0,
			// npc.anInt86:128, npc.anInt91:128, entity.anInt92:0, entity.anInt56:13
			break;
		/*
		 * Rick & Morty
		 */

			
			
		case 8548:
			npc.models = new int[] {44359};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.name = "Yoshi";
		    npc.combatLevel = 400;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack", null, null, null};
			npc.sizeXZ = 90;
			npc.sizeY = 90;
			break;
			
		case 4595:
			npc.models = new int[2];
			npc.models[0] = 40506;
			npc.models[1] = 40505;
			npc.name = "@yel@P@red@E@yel@N@red@N@yel@Y@red@W@yel@I@red@S@yel@E";
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.sizeXZ = 200;
			npc.sizeY = 200;
			NPCDef ven1 = forID(60);
			npc.standAnim = ven1.standAnim;
			npc.walkAnim = ven1.walkAnim;
			npc.combatLevel = 464;
			npc.squaresNeeded = 1;
			break;
			
		case 4596:
			npc.models = new int[] {44391};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.name = "Soul crusher";
		    npc.combatLevel = 400;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack", null, null, null};
			npc.sizeXZ = 200;
			npc.sizeY = 200;
			break;
		case 1070:
			npc.models = new int[] {44408};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.name = "Belly Blob";
		    npc.combatLevel = 400;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack", null, null, null};
			npc.sizeXZ = 120;
			npc.sizeY = 120;
			break;
			
		case 1072: //44427,44428,44429,44430,44431,44432,44433,44434
			npc.models = new int[] { 44429,44431,44432,44433,44434};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.name = "Byakuya Kuchiki";
		    npc.combatLevel = 400;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack", null, null, null};
			npc.sizeXZ = 120;
			npc.sizeY = 120;
			break;
			
			
		case 12849:
			npc.name = "@or2@Looney Zone";
			npc.actions = new String[5];
			npc.actions[0] = "@whi@Visit";
			npc.models[0] = 44360; // HEADnpc
			npc.standAnim = 808;
			npc.walkAnim = 819;
			break;
			
		case 1973:
			npc.name = "Bugs Bunny";
			npc.description = "Bugs Bunny";
			npc.combatLevel = 179;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[1];
			npc.models[0] = 44348; // HEAD
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
			
		case 1068:
			npc.name = "Corrupt Santa";
			npc.description = "Corrupt Santa";
			npc.combatLevel = 179;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[1];
			npc.models[0] = 44394; // HEAD
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.sizeXZ = 220;
			npc.sizeY = 220;
			break;
			
		case 1067:
			npc.name = "Slenderman";
			npc.description = "Slenderman";
			npc.combatLevel = 666;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[1];
			npc.models[0] = 44403; // HEAD
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
		case 12808:
			npc.name = "Thanos";
			npc.description = "Thanos";
			npc.combatLevel = 1471;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[1];
			npc.models[0] = 63004; // HEAD
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 75:
			npc.name = "Sylvester";
			npc.description = "its the one and only";
			npc.combatLevel = 179;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[1];
			npc.models[0] = 44352; // HEAD
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 103:
			npc.name = "Wile E";
			npc.description = "its the one and only";
			npc.combatLevel = 179;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[1];
			npc.models[0] = 44349; // HEAD
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 6351:
			npc.name = "Rick";
			npc.description = "Rise above, focus on science.";
			npc.combatLevel = 256;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[1];
			npc.models[0] = 95023; // HEAD
			npc.actions = new String[5];
			npc.actions[0] = "Attack";
			break;
			
		case 1684:
            npc.name = "Apollo Ranger";
            npc.models = new int[]{40269, 40271, 40273, 40275, 40276,23832,23439};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 170;
			npc.sizeXZ = 170;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 764:
			npc.name = "Pet Grinch(red)";
			npc.combatLevel = 0;
			npc.description = "The..The..The..The...Grinch!!";
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[]{72051,72052,72053,72054,72055};
			npc.actions = new String[5];
		    npc.drawMinimapDot = false;
			break;
			
			
		case 765:
			npc.name = "Pet Grinch (green)";
			npc.combatLevel = 0;
			npc.description = "The..The..The..The...Grinch!!";
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[]{72056,72057,72060,72054,72055};
			npc.actions = new String[5];
		    npc.drawMinimapDot = false;
			break;
			
			
		case 766:
			npc.name = "Pet Grinch (blue)";
			npc.combatLevel = 0;
			npc.description = "The..The..The..The...Grinch!!";
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[]{72058,72059,72061,72054,72055};
			npc.actions = new String[5];
		    npc.drawMinimapDot = false;
			break;
			
		case 767:
            npc.name = "Krampus";
            npc.models = new int[]{62940};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "You better not pout, you better not cry...";
			npc.sizeY = 120;
			npc.sizeXZ = 120;
			npc.actions = new String[5];
			npc.actions[0] = "Talk To";
			npc.actions[1] = null;
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			break;
			
		case 768:
            npc.name = "Rudolph the Reindeer";
            npc.models = new int[]{58886};
			NPCDef NPCDEFINITION = NPCDef.forID(1061);
			npc.runAnim = NPCDEFINITION.runAnim;
			npc.standAnim = NPCDEFINITION.standAnim;
			npc.walkAnim = NPCDEFINITION.walkAnim;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.description = "you'll go down in history.";
			npc.actions = new String[5];
		    npc.drawMinimapDot = false;
			break;
			
		case 769:
			npc.models = new int[]{72051,72052,72053,72054,72055};
			npc.name = "@gre@The Grinch";
			npc.combatLevel = 666;
			npc.description = "The..The..The..The...Grinch!!";
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.actions = new String[5];
			npc.sizeY = 140;
			npc.sizeXZ = 140;
			npc.actions = new String[] {null, "Attack",  null, null, null};
		    npc.drawMinimapDot = true;
			break;
			
			
		case 6353:
			npc.name = "Pet Morty";
			npc.combatLevel = 0;
			npc.description = "Get your shit together.";
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[1];
			npc.models[0] = 95024; // HEAD
			npc.actions = new String[5];
		    npc.drawMinimapDot = false;
			break;
		case 6354:
			npc.name = "Pet Chilli";
			npc.description = "Wow, you look hot";
			npc.combatLevel = 0;
			npc.models = new int[1];
			npc.models[0] = 95025;
			npc.actions = new String[5];
			npc.squaresNeeded = 2;
			npc.standAnim = 808;
			npc.walkAnim = 819;
		    npc.drawMinimapDot = false;			
			break;
		case 6355:
			npc.name = "Pet Mayonaise";
			npc.description = "Mmmmmm, yummy";
			npc.combatLevel = 0;
			npc.models = new int[1];
			npc.models[0] = 95026;
			npc.actions = new String[5];
			npc.squaresNeeded = 2;
			npc.standAnim = 808;
			npc.walkAnim = 819;
		    npc.drawMinimapDot = false;
			break;
		case 6666:
			npc.name = "Nightmare Beast";
			npc.models = new int[]{98000};
			npc.standAnim = 2729;
			npc.walkAnim = 2731;
			npc.actions = new String[]{null, "Attack", null, null, null};
			npc.combatLevel = 101;
			npc.sizeXZ = 80;
			npc.sizeY = 80;
			npc.drawMinimapDot = false;
			break;
		/*
		 * End Of Rick & Morty
		 */
		case 6356:	
			npc.name = "Pet Striped Leopard";
			npc.walkAnim = 5226;
			npc.standAnim = 5225;
			npc.combatLevel = 0;
			npc.models = new int[1];
			npc.models[0] = 95044;
			npc.actions = new String[5];
		    npc.drawMinimapDot = false;
			// npc.anInt55:-1, npc.anInt57:-1, npc.anInt58:-1, npc.anInt59:-1,
			// npc.anInt75:-1, entity.anInt79:32, npc.anInt83:-1, npc.anInt85:0,
			// npc.anInt86:128, npc.anInt91:128, entity.anInt92:0, entity.anInt56:4
			break;

		case 7700:
			npc.models = new int[] { 33012 };
			npc.name = "JalTok-Jad";
			npc.standAnim = 7589;
			npc.walkAnim = 7588;
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.destColours = null;
			npc.originalColours = null;
			npc.combatLevel = 900;
			npc.squaresNeeded = 5;
			npc.sizeXZ = 128;
			npc.sizeY = 128;
			break;

		case 7702:
			npc.models = new int[] { 33014 };
			npc.name = "Jal-Xil";
			npc.standAnim = 7602;
			npc.walkAnim = 7603;
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.destColours = null;
			npc.originalColours = null;
			npc.combatLevel = 370;
			npc.squaresNeeded = 3;
			npc.sizeXZ = 128;
			npc.sizeY = 128;
			break;

		case 7703:
			npc.models = new int[] { 33000 };
			npc.name = "Jal-Zek";
			npc.standAnim = 7609;
			npc.walkAnim = 7608;
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.destColours = null;
			npc.originalColours = null;
			npc.combatLevel = 490;
			npc.squaresNeeded = 4;
			npc.sizeXZ = 128;
			npc.sizeY = 128;
			break;

		case 7750:
			npc.models = new int[] { 33099 };
			npc.name = "Jal-MejJak";
			npc.standAnim = 2867;
			npc.walkAnim = 2863;
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.destColours = null;
			npc.originalColours = null;
			npc.combatLevel = 250;
			npc.squaresNeeded = 1;
			npc.sizeXZ = 128;
			npc.sizeY = 128;
			break;

		case 7706:
			npc.models = new int[] { 33011 };
			npc.name = "TzKal-Zuk";
			npc.standAnim = 7564;
			npc.walkAnim = 7564;
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.destColours = null;
			npc.originalColours = null;
			npc.combatLevel = 1400;
			npc.squaresNeeded = 7;
			npc.sizeXZ = 128;
			npc.sizeY = 128;
			break;
		case 7893:
			npc.models = new int[] { 33036 };
			npc.name = "@cya@Ancestral Glyph";
			npc.standAnim = 7567;
			npc.walkAnim = 7567;
			npc.actions = new String[] { null, null, null, null, null };
			npc.destColours = null;
			npc.originalColours = null;
			npc.combatLevel = 0;
			npc.squaresNeeded = 3;
			npc.sizeXZ = 128;
			npc.sizeY = 128;
			npc.drawMinimapDot = false;
			break;

			
		case 131:
			npc.combatLevel = 25;
			break;
		case 5453://icelord
			npc.combatLevel = 25;
			break;

		case 8327:
			npc.combatLevel = 110;
			npc.headIcon = -1;
			break;
			

		case 12841:
			npc.combatLevel = 792;
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.standAnim = 14967;
			break;
			
		case 8949:
			npc.models = new int[] { 23868 };
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.name = "Juggernaut";
			npc.sizeXZ = 170;
			npc.sizeY = 170;
			npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 8948:
			npc.models = new int[] { 44495 };
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.name = " @whi@Vote box";
			npc.sizeXZ = 30;
			npc.sizeY = 30;
			npc.drawMinimapDot = true;
			break;
			
		//case 12808:
			//npc.combatLevel = 792;
			//npc.actions = new String[] { null, null, null, null, null };
			//npc.standAnim = 14967;
			//npc.walkAnim = 14412;
			//break;

		case 6727:
			npc.name = "Tangleroot";
			npc.combatLevel = 0;
			npc.models = new int[1];
			npc.models[0] = 32202;
			npc.actions = new String[5];


			npc.walkAnim = 7313;
			npc.standAnim = 7312;
			npc.description = "Its a Tangleroot.";
			npc.squaresNeeded = 1;
			break;
		case 6728:
			npc.name = "Rocky";
			npc.combatLevel = 0;
			npc.models = new int[1];
			npc.models[0] = 32203;
			npc.actions = new String[5];


			npc.walkAnim = 7316;
			npc.standAnim = 7315;
			npc.description = "Its a Rocky.";
			npc.squaresNeeded = 1;
			break;
		case 6729:
			npc.name = "Giant squirrel";
			npc.combatLevel = 0;
			npc.models = new int[1];
			npc.models[0] = 32206;
			npc.actions = new String[5];


			npc.walkAnim = 7310;
			npc.standAnim = 7309;
			npc.description = "Its a Giant squirrel.";
			npc.squaresNeeded = 1;
			break;
		case 7788:
			npc.name = "Emeralds Quest NPC";
			npc.combatLevel = 1337;
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[9];
			npc.models[0] = 74505; // HEAD
			npc.models[1] = 246; // JAW
			npc.models[2] = 74507; // CHEST
			npc.models[3] = 90404; // CAPE
			npc.models[4] = 49347; // ARM
			npc.models[5] = 74504; // HAND
			npc.models[6] = 74511; // WEP
			npc.models[7] = 74509; // LEG
			npc.models[8] = 74501; // BOOT
			npc.actions = new String[5];
			npc.actions[0] = "Talk To";
			npc.actions[1] = null;
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			break;
		case 6730:
			npc.name = "Rift guardian";
			npc.combatLevel = 0;
			npc.models = new int[1];
			npc.models[0] = 32204;
			npc.actions = new String[5];


			npc.walkAnim = 7306;
			npc.standAnim = 7307;
			npc.description = "Its a Rift guardian.";
			npc.squaresNeeded = 1;
			break;
		case 6723:
			npc.name = "Rock Golem";
			npc.combatLevel = 0;
			npc.models = new int[1];
			npc.models[0] = 29755;
			npc.actions = new String[5];


			npc.walkAnim = 7181;
			npc.standAnim = 7180;
			npc.description = "Its a Rock Golem.";
			npc.squaresNeeded = 1;
			npc.sizeXZ = npc.sizeY = 110;
			break;
		case 6724:
			npc.name = "Heron";
			npc.combatLevel = 0;
			npc.models = new int[1];
			npc.models[0] = 29756;
			npc.actions = new String[5];


			npc.walkAnim = 6774;
			npc.standAnim = 6772;
			npc.description = "Its a Heron.";
			npc.squaresNeeded = 1;
			break;

		case 6726:
			npc.name = "Beaver";
			npc.combatLevel = 0;
			npc.models = new int[1];
			npc.models[0] = 29754;
			npc.actions = new String[5];


			npc.walkAnim = 7178;
			npc.standAnim = 7177;
			npc.description = "Its a Beaver.";
			npc.squaresNeeded = 1;
			break;
			
		case 174:
			npc.name = "Charmander";
			npc.combatLevel = 0;
			npc.models = new int[]{28401};
			npc.combatLevel = 16;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
			

		case 2843:
			npc.name = "Charizard";
			npc.combatLevel = 666;
			npc.models = new int[]{28405};
			npc.combatLevel = 16;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			break;
			
		case 842:
			npc.name = "Bulbasaur";
			npc.combatLevel = 0;
			npc.models = new int[]{28402};
			npc.combatLevel = 42;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.drawMinimapDot = true;
			break;
			
		case 12842:
			npc.name = "Venusaur";
			npc.combatLevel = 0;
			npc.models = new int[]{44204};
			npc.combatLevel = 42;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			NPCDef copyAnimations177 = NPCDef.forID(842);
			npc.runAnim = copyAnimations177.runAnim;
			npc.standAnim = copyAnimations177.standAnim;
			npc.walkAnim = copyAnimations177.walkAnim;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.drawMinimapDot = true;
			break;
			
		case 2045:
			npc.name = "Snakeling";
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.models = new int[1];
			npc.models[0] = 14408;
			npc.standAnim = 5070;
			npc.walkAnim = 5070;
			npc.combatLevel = 1;
			npc.sizeXZ = 30;
			npc.sizeY = 30;
			break;

		case 6098:
			npc.name = "Vote boss";
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.models = new int[1];
			npc.models[0] = 64098;
			npc.combatLevel = 1;
			npc.sizeXZ = 100;
			npc.sizeY = 100;
			break;
			
		case 9935:
			npc.originalColours = new int[2];
			npc.destColours = new int[2];
			npc.originalColours[0] = 59;
			npc.destColours[0] = 55;
			npc.originalColours[1] = 65;
			npc.destColours[1] = 55;
			npc.name = "Dark Purplefire Wyrm";
			npc.models = new int[]{96321};
			// npc.boundDim = 1;
			npc.standAnim = 12790;
			npc.walkAnim = 12790;
			npc.combatLevel = 382;
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.sizeXZ = 90;
			npc.sizeY = 90;
			// npc.sizeXZ = 35;
			// npc.sizeY = 75;
			break;
			
		case 3334:
			npc.name = "WildyWyrm";
			npc.models = new int[] { 63604 };
			// npc.boundDim = 1;
			npc.standAnim = 12790;
			npc.walkAnim = 12790;
			npc.combatLevel = 382;
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.sizeXZ = 225;
			npc.sizeY = 200;
			// npc.sizeXZ = 35;
			// npc.sizeY = 75;
			break;
		case 9676:
			npc.name = "Custom WildyWyrm";
			npc.models = new int[] { 94435 };
			npc.standAnim = 12790;
			npc.walkAnim = 12790;
			npc.combatLevel = 420;
			npc.actions = new String[5];
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.sizeXZ = 150;
			npc.sizeY = 150;
			break;
		/*
		 * case 152: npc.name = "Custom Npc Boss"; npc.models = new int[] { 75500 };
		 * //npc.boundDim = 1; NPCDef cnpc = forID(2633); npc.standAnim =
		 * cnpc.standAnim; npc.walkAnim = cnpc.walkAnim; npc.combatLevel = 885;
		 * npc.actions = new String[5]; npc.actions = new String[] {null, "Attack",
		 * null, null, null}; npc.sizeXZ = 125; npc.sizeY = 100; //npc.sizeXZ = 35;
		 * //npc.sizeY = 75; break;
		 */
		case 1:
			npc.name = "Poison";
			npc.actions = new String[] { null, null, null, null, null };
			npc.sizeXZ = 1;
			npc.sizeY = 1;
			npc.drawMinimapDot = false;
			break;
		case 0:
			npc.name = " ";
			npc.actions = new String[] { null, null, null, null, null };
			npc.sizeXZ = 1;
			npc.sizeY = 1;
			npc.drawMinimapDot = false;
			break;

		case 2000:
			npc.models = new int[2];
			npc.models[0] = 28294;
			npc.models[1] = 28295;
			npc.name = "Venenatis";
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.sizeXZ = 200;
			npc.sizeY = 200;
			NPCDef ven = forID(60);
			npc.standAnim = ven.standAnim;
			npc.walkAnim = ven.walkAnim;
			npc.combatLevel = 464;
			npc.squaresNeeded = 3;
			break;
			
			
		case 10100:
			npc.models = new int[2];
			npc.models[0] = 40506;
			npc.models[1] = 40505;
			npc.name = "Pennywise baby spider";
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.sizeXZ = 50;
			npc.sizeY = 50;
			NPCDef ven3 = forID(60);
			npc.standAnim = ven3.standAnim;
			npc.walkAnim = ven3.walkAnim;
			npc.combatLevel = 464;
			npc.squaresNeeded = 1;
			break;
			
		case 3192:
			npc.name = "SebZero Shop";
			npc.combatLevel = 999;
			npc.actions = new String[] { "Trade", null, null, null, null };
			break;
		case 2436:
			npc.name = "Corona Warriors";
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[9];
			npc.models[0] = 230; // HEAD
			npc.models[1] = 246; // JAW
			npc.models[2] = 49352; // CHEST
			npc.models[3] = 10313; // CAPE
			npc.models[4] = 49347; // ARM
			npc.models[5] = 49349; // HAND
			npc.models[6] = 5409; // WEP
			npc.models[7] = 49351; // LEG
			npc.models[8] = 49348; // BOOT
			npc.actions = new String[5];
			npc.actions[0] = "Examine";
			npc.actions[1] = "Attack";
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			break;
		case 9944:
			npc.name = "@or2@Hurricane Warrior";
			npc.originalColours= new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 40;
			npc.destColours[0] = 51;
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[9];
			npc.models[0] = 91609; // HEAD
			npc.models[2] = 91611; // CHEST
			npc.models[3] = 9638; // CAPE
			npc.models[7] = 91607; // LEG
			npc.models[6] = 111; // WEP
			npc.actions = new String[5];
			npc.actions[0] = "Examine";
			npc.actions[1] = "Attack";
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			break;
		case 200:
			npc.name = "Darth Beasts";
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[9];
			npc.models[0] = 65523; // HEAD
			npc.models[1] = 246; // JAW
			npc.models[2] = 65517; // CHEST
			npc.models[3] = 65528; // CAPE
			npc.models[4] = 49347; // ARM
			npc.models[5] = 65520; // HAND
			npc.models[6] = 65527; // WEP
			npc.models[7] = 65525; // LEG
			npc.models[8] = 65518; // BOOT
			npc.actions = new String[5];
			npc.actions[0] = "Examine";
			npc.actions[1] = "Attack";
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			break;
			
			
		case 8572:
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.originalColours= new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 62;
			npc.destColours[0] = 51;
			npc.models = new int[]{94346};
			npc.name = "@or2@Shaman Defender(Minigame Boss)";
			npc.combatLevel = 1337;
			//npc.standAnim = 10921;
			//npc.walkAnim = 10920;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 111;
			npc.sizeXZ = 123;
			npc.squaresNeeded = 2;
			break;
			
		case 8573:
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.originalColours= new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 62;
			npc.destColours[0] = 51;
			npc.models = new int[]{94346};
			npc.name = "@or2@Shamans minion";
			npc.combatLevel = 1337;
			//npc.standAnim = 10921;
			//npc.walkAnim = 10920;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 111 / 2;
			npc.sizeXZ = 123 / 2;
			npc.squaresNeeded = 2;
			break;
			
		case 9203:
			npc.name = "Dark Wizards";
			npc.drawMinimapDot = true;
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[9];
			npc.models[0] = 97426; // HEAD
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			npc.sizeY = 200;
			npc.sizeXZ = 200;
			break;
			
		case 9231:
			npc.originalColours= new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 40;
			npc.destColours[0] = 59;
			npc.name = "Hellfire Wizards";
			npc.drawMinimapDot = true;
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[9];
			npc.models[0] = 94613; // HEAD
			npc.models[2] = 94615; // CHEST
			npc.models[3] = 9638; // CAPE
			npc.models[7] = 94617; // LEG
			npc.actions = new String[5];
			npc.actions[0] = "Examine";
			npc.actions[1] = "Attack";
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			npc.drawMinimapDot = true;
			break;
			
		case 9237:
			npc.originalColours= new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 40;
			npc.destColours[0] = 51;
			npc.name = "Skyrocket Wizards";
			npc.drawMinimapDot = true;
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[9];
			npc.models[0] = 94613; // HEAD
			npc.models[2] = 94615; // CHEST
			npc.models[3] = 9638; // CAPE
			npc.models[7] = 94617; // LEG
			npc.actions = new String[5];
			npc.actions[0] = "Examine";
			npc.actions[1] = "Attack";
			npc.actions[2] = null;
			npc.actions[4] = null;
			npc.drawMinimapDot = true;
			break;
		
		
			
			
		case 9273:
			npc.drawMinimapDot = true;
			npc.name = "Rick";
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[9];
			npc.models[0] = 23795; // HEAD
			npc.actions = new String[5];
			npc.actions[0] = "Examine";
			npc.actions[1] = "Attack";
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			break;
			
			
		case 9277:
			npc.combatLevel = 1337;
			npc.drawMinimapDot = true;
			npc.originalColours= new int[2];
			npc.destColours = new int[2];
			npc.originalColours[0] = 60;
			npc.destColours[0] = 68;
			npc.originalColours[1] = 40;
			npc.destColours[1] = 68;
			npc.name = "Lord Valor";
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[9];
			npc.models[0] = 94425; // HEAD
			npc.models[2] = 94427; // CHEST
			npc.models[3] = 9638; // CAPE
			//npc.models[6] = 94629; // WEP
			npc.models[7] = 94429; // LEG
			npc.actions = new String[5];
			npc.actions[0] = "Examine";
			npc.actions[1] = "Attack";
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			break;
			
			
		case 9280:
			npc.combatLevel = 420;
			npc.drawMinimapDot = true;
			npc.originalColours= new int[2];
			npc.destColours = new int[2];
			npc.originalColours[0] = 60;
			npc.destColours[0] = 68;
			npc.originalColours[1] = 40;
			npc.destColours[1] = 68;
			npc.name = " Valors Minion";
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.models = new int[9];
			npc.models[0] = 94425; // HEAD
			npc.models[2] = 94427; // CHEST
			npc.models[3] = 9638; // CAPE
			//npc.models[6] = 94629; // WEP
			npc.models[7] = 94429; // LEG
			npc.actions = new String[5];
			npc.actions[0] = "Examine";
			npc.actions[1] = "Attack";
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			npc.sizeXZ = npc.sizeXZ / 2 + 13;
			npc.sizeY = npc.sizeY / 2 + 13;
			break;
			
			
			
		case 1440:
			npc.models = new int[] {44162};
			NPCDef NPCDEF = NPCDef.forID(4972);
			npc.runAnim = NPCDEF.runAnim;
			npc.standAnim = NPCDEF.standAnim;
			npc.walkAnim = NPCDEF.walkAnim;
			npc.originalColours = new int[] {40};
			npc.destColours = new int[] {81};
			npc.name = "@mag@Mystic @re1@Beast";
			npc.actions = new String[5];
			//definition.rdc2 = 2592952;
			npc.sizeXZ = 70;
			npc.sizeY = 70;
			npc.squaresNeeded = 2;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;	
			
			
		case 9247:
			npc.models = new int[] {100242};
			NPCDef copyAnimationsdick = NPCDef.forID(4972);
			npc.runAnim = copyAnimationsdick.runAnim;
			npc.standAnim = copyAnimationsdick.standAnim;
			npc.walkAnim = copyAnimationsdick.walkAnim;
			npc.name = "@whi@Lucid Dragon";
			npc.actions = new String[5];
			//definition.rdc2 = 2592952;
			npc.sizeXZ = npc.sizeXZ * 1;
			npc.sizeY = npc.sizeY * 1;
			npc.squaresNeeded = 3;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;	
			
			
		case 172:
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.originalColours= new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 40;
			npc.destColours[0] = 59;
			npc.name = "@red@Heated Pyro";
			npc.models = new int[6];
			npc.models[0] = 28378; // HEAD
			npc.models[1] = 28380; // CHEST
			npc.models[2] = 28387; // CAPE
			npc.models[3] = 28382; // LEG
			npc.models[4] = 28384; // GLOVES
			npc.models[5] = 28385; // BOOTS
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.drawMinimapDot = true;
			break;
			
		case 169:
			npc.sizeXZ = 180;
			npc.sizeY = 180;
			npc.combatLevel = 337;
			NPCDef copyAnimations198 = NPCDef.forID(1);
			npc.runAnim = copyAnimations198.runAnim;
			npc.standAnim = copyAnimations198.standAnim;
			npc.walkAnim = copyAnimations198.walkAnim;
			npc.name = "Cloud";
			npc.models = new int[7];
			npc.models[0] = 28356; // HEAD
			npc.models[1] = 28358; // CHEST
			npc.models[2] = 28363; // CAPE
			npc.models[3] = 28360; // LEG
			npc.models[4] = 28365; // GLOVES
			npc.models[5] = 28366; // BOOTS
			npc.models[6] = 28361; // WEP28389
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.drawMinimapDot = true;
			break;
			
		case 168:
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.originalColours= new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 40;
			npc.destColours[0] = 59;
			npc.name = "Zeus";
			npc.models = new int[6];
			npc.models[0] = 23102; // HEAD
			npc.models[1] = 23106; // CHEST
			npc.models[2] = 23104; // LEG
			npc.models[3] = 23100; // GLOVES
			npc.models[4] = 23098; // BOOTS
			npc.models[5] = 23097; // WEP28389
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.drawMinimapDot = true;
			break;
			
		case 170:
			npc.walkAnim = 1660;
			npc.standAnim = 11973;
			npc.originalColours= new int[1];
			npc.destColours = new int[1];
			npc.originalColours[0] = 40;
			npc.destColours[0] = 59;
			npc.name = "Trinity Killer";
			npc.models = new int[7];
			npc.models[0] = 28391; // HEAD
			npc.models[1] = 28393; // CHEST
			npc.models[2] = 28400; // CAPE
			npc.models[3] = 28395; // LEG
			npc.models[4] = 28397; // GLOVES
			npc.models[5] = 28398; // BOOTS
			npc.models[6] = 28389; // WEP28389
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.drawMinimapDot = true;
			break;
			
		/*
		 * case 2436: npc.models = new int[2]; npc.models[0] = 28294; npc.models[1] =
		 * 28295; npc.models[2] = 28295; npc.models[3] = 28295; npc.models[4] = 28295;
		 * npc.models[5] = 28295; npc.models[6] = 28295; npc.models[7] = 28295;
		 * npc.models[8] = 28295; npc.name = "AvalonPS Warriors"; npc.actions = new
		 * String[] {null, "Attack", null, null, null}; npc.sizeXZ = 200; npc.sizeY =
		 * 200; npc.standAnim = ven1.standAnim; npc.walkAnim = ven1.walkAnim;
		 * npc.combatLevel = 464; npc.squaresNeeded = 3; break;
		 */
		case 2042:// turgoise

			npc.name = "Zulrah";
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.models = new int[1];
			npc.models[0] = 14407;
			npc.standAnim = 5070;
			npc.walkAnim = 5070;
			npc.combatLevel = 725;
			npc.sizeXZ = 80;
			npc.sizeY = 80;
			break;
		case 2043:// regular
			npc.name = "Zulrah";
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.models = new int[1];
			npc.models[0] = 14408;
			npc.standAnim = 5070;
			npc.walkAnim = 5070;
			npc.combatLevel = 725;
			npc.sizeXZ = 80;
			npc.sizeY = 80;
			break;
		case 2044:// melee
			npc.name = "Zulrah";
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.models = new int[1];
			npc.models[0] = 14409;
			npc.standAnim = 5070;
			npc.walkAnim = 5070;
			npc.combatLevel = 725;
			npc.sizeXZ = 80;
			npc.sizeY = 80;
			break;
		case 2001:
			npc.models = new int[1];
			npc.models[0] = 28293;
			npc.name = "Scorpia";
			npc.actions = new String[] { null, "Attack", null, null, null };
			NPCDef scor = forID(107);
			npc.standAnim = scor.standAnim;
			npc.walkAnim = scor.walkAnim;
			npc.combatLevel = 464;
			npc.squaresNeeded = 3;
			break;
		case 7286:
			npc.name = "Skotizo";
			npc.description = "Badass from the depths of hell";
			npc.combatLevel = 321;
			NPCDef skotizo = forID(4698);
			npc.standAnim = skotizo.standAnim;
			npc.walkAnim = skotizo.walkAnim;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.models = new int[1];
			npc.models[0] = 44711;// 31653
			npc.sizeXZ = 200; // resize if you wish hes a bit small cause personal preference
			npc.sizeY = 200; // resize
			npc.squaresNeeded = 3;
			npc.drawMinimapDot = true;
			break;
		case 6766:
			npc.name = "Lizardman shaman";
			npc.description = "It's a lizardman.";
			npc.combatLevel = 150;
			npc.walkAnim = 7195;
			npc.standAnim = 7191;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.models = new int[1];
			npc.models[0] = 4039;
			npc.sizeXZ = 108;
			npc.sizeY = 108;
			npc.squaresNeeded = 3;
			break;
		case 5886:
			npc.name = "Abyssal Sire";
			npc.description = "It's an abyssal sire.";
			npc.combatLevel = 350;
			npc.walkAnim = 4534;
			npc.standAnim = 4533;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.models = new int[1];
			npc.models[0] = 29477;
			npc.sizeXZ = 108;
			npc.sizeY = 108;
			npc.squaresNeeded = 6;
			break;
		case 499:
			npc.name = "Summer Devil";
			npc.description = "It looks like its glowing";
			npc.combatLevel = 301;
			npc.walkAnim = 1828;
			npc.standAnim = 1829;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.models = new int[1];
			npc.models[0] = 23721;
			npc.sizeXZ = 240;
			npc.sizeY = 240;
			npc.squaresNeeded = 4;
			break;
		case 1999:
			npc.name = "@red@Bloated Infernal";
			npc.actions = new String[5];
			npc.models = new int[] {100299};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 450;
			npc.sizeXZ = 450;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
		case 3544:
			npc.models = new int[2];
			npc.sizeXZ = 70;
			npc.sizeY = 70;
			npc.name = "@red@UMD Pet";
			npc.models[1] = 29270;
			npc.actions = new String[5];
			npc.actions[4] = "@red@Fix Prime Legs";
			npc.combatLevel = 318;
			npc.standAnim = 4484;
			npc.walkAnim = 4488;
			npc.originalColours = new int[9];
			npc.originalColours[0] = 5219; // teeth
			npc.originalColours[1] = 910; // inside of mouth. Ankles. End of tail
			npc.originalColours[2] = 1814; // around face. Start of tail
			npc.originalColours[3] = 1938; // around face and back of head. Top part of legs and end bit of tail.
			npc.originalColours[4] = 1690; // top of forehead
			npc.originalColours[5] = 921; // eyebrows
			npc.originalColours[6] = 0; // horns. Feet
			npc.originalColours[7] = 962; // eye colour
			npc.originalColours[8] = 912; // knees, dick, end of tail
			npc.destColours = new int[9];
			npc.destColours[0] = 6970;
			npc.destColours[1] = 6970;
			npc.destColours[2] = 6970;
			npc.destColours[3] = 6970;
			npc.destColours[4] = 6970;
			npc.destColours[5] = 6970;
			npc.destColours[6] = 6970;
			npc.destColours[7] = 6970;
			npc.destColours[8] = 6970;
			npc.sizeXZ = 37;
			npc.sizeY = 37;
		    npc.drawMinimapDot = false;
			break;
		case 8945:
			copyModel(npc, 494);
			npc.name = "@whi@Pet Banker";;
			npc.actions = new String[5];
			npc.actions[0] = "@or2@Bank";
			npc.standAnim = 808;
			npc.walkAnim = 819;
		    npc.drawMinimapDot = false;
			break;
		case 2009:
			npc.name = "Callisto";
			npc.models = new int[] { 28298 };
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.combatLevel = 470;
			NPCDef callisto = forID(105);
			npc.standAnim = callisto.standAnim;
			npc.walkAnim = callisto.walkAnim;
			npc.actions = callisto.actions;
			npc.sizeXZ = npc.sizeY = 110;
			npc.squaresNeeded = 4;
			break;
		case 2006:
			npc.models = new int[1];
			npc.models[0] = 28300;
			npc.name = "Vet'ion";
			npc.actions = new String[] { null, "Attack", null, null, null };
			NPCDef vet = forID(90);
			npc.standAnim = vet.standAnim;
			npc.walkAnim = vet.walkAnim;
			npc.combatLevel = 464;
			break;
		case 2003:
			npc.models = new int[1];
			npc.models[0] = 28281;
			npc.name = "Kraken";
			npc.actions = new String[] { null, "Attack", null, null, null };
			NPCDef eld = forID(3847);
			npc.models = new int[1];
			npc.models[0] = 28233;
			npc.combatLevel = 291;
			npc.standAnim = 3989;
			npc.walkAnim = eld.walkAnim;
			npc.sizeXZ = npc.sizeY = 84;
			break;
		case 8281:
			npc.sizeXZ = npc.sizeY = 50;
			break;
			case 2004:
			npc.models = new int[1];
			npc.models[0] = 28231;
			npc.name = "Cave kraken";
			npc.actions = new String[] { null, "Attack", null, null, null };
			NPCDef cave = forID(3847);
			npc.models = new int[1];
			npc.models[0] = 28233;
			npc.combatLevel = 127;
			npc.standAnim = 3989;
			npc.walkAnim = cave.walkAnim;
			npc.sizeXZ = npc.sizeY = 42;
			break;
		case 457:
			npc.name = "@whi@Ghost Town Citizen";
			npc.actions = new String[] { "Talk-to", null, "Teleport", null, null };
			break;
		case 273:
			npc.name = "Point/Ticket Shop";
			npc.actions = new String[] {"MOB Point Shop", null,null, null, null};
			break;
		case 932:
			npc.name = "@whi@Vip Slayer Dungeon";
			npc.actions = new String[] {"Talk", null,null, null, null};
			break;
		
		case 905:
			npc.name = "@whi@Compare Item Stats";
			npc.actions = new String[] {"Compare", null,null, null, null};
			break;
		
		case 1090:
			npc.name = "@whi@Raid Shop";
			npc.actions = new String[] {"Open", null,null, null, null};
			break;
		
		case 560:
			npc.name = "@whi@Loyalty Point Shop";
			npc.actions = new String[] {"Open", null,null, null, null};
			break;
		case 4559:
			npc.name = "@whi@Prestige Shop";
			npc.actions = new String[] {"Open", null,null, null, null};
			break;
		case 232:
			npc.name = "@whi@LONNEY Shop";
			npc.actions = new String[] {"Open", null,null, null, null};
			break;
		case 712:
			npc.name = "@yel@Skilling Point Shop";
          //  npc.models = new int[]{100480};
			npc.actions = new String[] {"Open", null,null, null, null};
			break;
		case 263:
			npc.name = "@whi@Crypto Exchange Shop";
			npc.actions = new String[] { "Trade", null, null, null, null };
			break;
		
		
		case 543:
			npc.name = "Decanter";
			break;
		
        case 2509:
            npc.name = "Iron man";
            npc.models = new int[]{61151,61155,61158,83176,91319};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.sizeXZ *=3;
            npc.sizeY *=3;
            npc.squaresNeeded = 1;
            npc.actions = new String[] {null, "Attack", null, null, null};
            break;
            
		case 920:
			npc.name = "Archeology Exchange";
			break;
		
		
		case 4902:
			npc.name = "@whi@Afk Miner";
			npc.actions = new String[] { "Talk-To", "Trade", null, null, null };
			break;
		case 4475:
			npc.name = "@whi@Item Upgrader";
			npc.actions = new String[] { "Upgrade", null, null, null, null };
			break;
		case 5417:
			npc.combatLevel = 210;
			break;
		case 5418:
			npc.combatLevel = 90;
			break;
		case 6715:
			npc.combatLevel = 91;
			break;
		case 6716:
			npc.combatLevel = 128;
			break;
		case 6701:
			npc.combatLevel = 173;
			break;
		case 6725:
			npc.combatLevel = 224;
			break;
		case 6691:
			npc.squaresNeeded = 2;
			npc.combatLevel = 301;
			break;
		case 212:
			npc.name = "Donator Shop";
			npc.actions = new String[] { "View Shop 1", null, "View Shop 2", null, null };
			break;
			
		case 659:
			npc.models = new int[] { 40078}; //40078
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.name = "@cya@Donator @mag@Shop";
			break;
			
		case 741:
			npc.name = "Donator Shop 2";
			break;
		case 2998:
			npc.name = "Gambler";
			npc.actions = new String[] { "Trade", null, null, null, null };
			break;
		case 2633:
			npc.name = "Trivia Point Shop";
			break;
		case 8710:
		case 8707:
		case 8706:
		case 8705:
			npc.name = "Musician";
			npc.actions = new String[] { "Listen-to", null, null, null, null };
			break;

		case 947:
			npc.name = "Player Owned Shop Manager";
			npc.actions = new String[] { "Talk-to", null, "View Shops", "My Shop", "Claim Earnings" };
			break;
		case 9939:
			npc.combatLevel = 607;
			break;
		case 688:
			npc.name = "Archer";
			break;
		case 4540:
			npc.combatLevel = 299;
			break;
		case 3101:
			npc.sizeY = npc.sizeXZ = 80;
			npc.squaresNeeded = 1;
			npc.actions = new String[] { "Talk-to", null, "Start", "Rewards", null };
			break;
		case 6222:
			npc.name = "Kree'arra";
			npc.squaresNeeded = 5;
			npc.standAnim = 6972;
			npc.walkAnim = 6973;
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.sizeY = npc.sizeXZ = 110;
			break;
		case 6203:
			npc.models = new int[] { 27768, 27773, 27764, 27765, 27770 };
			npc.name = "K'ril Tsutsaroth";
			npc.squaresNeeded = 5;
			npc.standAnim = 6943;
			npc.walkAnim = 6942;
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.sizeY = npc.sizeXZ = 110;
			break;
		case 1610:
		case 491:
		case 10216:
			npc.actions = new String[] { null, "Attack", null, null, null };
			break;
		case 7969:
			npc.actions = new String[] { "Talk-to", null, "Trade", null, null };
			break;
		case 1382:
			npc.name = "Glacial Queen";
			npc.models = new int[] { 97437 };
			npc.squaresNeeded = 3;
			// npc.anInt86 = 475;
			npc.sizeXZ = 200;
			npc.sizeY = 200;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.combatLevel = 123;
			npc.drawMinimapDot = true;
			npc.combatLevel = 188;
			break;
		case 12101:
			npc.name = "Apricity Queen";
			npc.models = new int[] { 97441 };
			npc.squaresNeeded = 3;
			// npc.anInt86 = 475;
			npc.sizeXZ = 200;
			npc.sizeY = 200;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.combatLevel = 123;
			npc.drawMinimapDot = true;
			npc.combatLevel = 188;
			break;
		/*
		 * case 1383: npc.name = "Unstable glacyte"; npc.models = new int[]{58942};
		 * npc.standAnim = 10867; npc.walkAnim = 10901; npc.actions = new String[]{null,
		 * "Attack", null, null, null}; npc.combatLevel = 101; npc.drawMinimapDot =
		 * false; break; case 1384: npc.name = "Sapping glacyte"; npc.models = new
		 * int[]{58939}; npc.standAnim = 10867; npc.walkAnim = 10901; npc.actions = new
		 * String[]{null, "Attack", null, null, null}; npc.combatLevel = 101;
		 * npc.drawMinimapDot = true; break; case 1385: npc.name = "Enduring glacyte";
		 * npc.models = new int[]{58937}; npc.standAnim = 10867; npc.walkAnim = 10901;
		 * npc.actions = new String[]{null, "Attack", null, null, null}; npc.combatLevel
		 * = 101; npc.drawMinimapDot = true; break;
		 */
		case 4249:
			npc.name = "Gambler";
			break;
		case 6970:
			npc.actions = new String[] { "Trade", null, "Exchange Shards", null, null };
			break;
		case 4657:
			npc.actions = new String[] { "Talk-to", null, "Check Total", "Teleport", null };
			break;
		case 364:
			npc.actions = new String[] { "Talk-to", null, "Vote Rewards", "Loyalty Titles", null };
			break;
		case 8591:
			npc.actions = new String[] { "Talk-to", null, "Trade", null, null };
			break;
		
		case 919:
			npc.name = "Archeology Tutor";
			break;
		
		case 316:
		case 315:
		case 309:
		case 314:
		case 312:
		case 313:
			npc.sizeXZ = 30;
			break;
		case 318:
			npc.sizeXZ = 30;
			npc.actions = new String[] { "Net", null, "Lure", null, null };
			break;
		case 805:
			npc.actions = new String[] { "Trade", null, "Tan hide", null, null };
			break;
		case 461:
		case 844:
		case 650:
		case 5112:
			npc.actions = new String[] { "Trade", null, null, null, null };
			break;
		case 3789:
            npc.models = new int[]{15148};
			npc.sizeXZ = 40;
			npc.sizeY = 40;
			npc.actions = new String[] { "Trade", null, null, null, null };
			break;
		case 802:
		case 520:
		case 521:
		case 11226:
			npc.actions = new String[] { "Trade", null, null, null, null };
			break;
		case 8022:
		case 8028:
			String color = i == 8022 ? "Yellow" : "Green";
			npc.name = "" + color + " energy source";
			npc.actions = new String[] { "Siphon", null, null, null, null };
			break;
		case 8444:
			npc.actions = new String[5];
			npc.actions[0] = "Trade";
			break;
		case 257:
			npc.name = "@red@Weapon upgrades";
			npc.models = new int[] { 230, 246, 244, 167, 176, 297, 267, 181,40056}; //40078
			npc.actions = new String[5];
			npc.actions[0] = "@whi@Upgrade";
			npc.standAnim = 808;
			npc.walkAnim = 819;
			break;
			
		case 435:
			npc.name = "@mag@Salvage Exchanger";
			npc.models = new int[] { 230, 246, 244, 167, 176, 297, 267, 181,40267}; //40078
			npc.actions = new String[5];
			npc.actions[0] = "@whi@View";
			npc.standAnim = 808;
			npc.walkAnim = 819;
			break;
			
		case 436:
			npc.name = "@gre@Donation Store";
			npc.models = new int[] {60711}; //40078
			npc.actions = new String[5];
			npc.actions[0] = "@whi@View";
            npc.standAnim = 2433;
            npc.squaresNeeded = 1;
            npc.walkAnim = 2433;
            npc.drawMinimapDot = true;
			break;
			
		case 382:
			npc.name = "@blu@NPC Task Master";
			npc.models = new int[] { 230, 246, 244, 167, 176, 297, 267, 181,40189}; //40078
			npc.actions = new String[5];
			npc.actions[0] = "@whi@Open";
			npc.standAnim = 808;
			npc.walkAnim = 819;
			break;
			
		case 380:
			npc.name = "@cya@Misc upgrades";
			npc.models = new int[] { 230, 246, 244, 167, 176, 297, 267, 181,187}; //40078
			npc.actions = new String[5];
			npc.actions[0] = "@whi@Upgrade";
			npc.standAnim = 808;
			npc.walkAnim = 819;
			break;
		case 20:
			npc.name = "@whi@Dreamflow Assassin";
            npc.models = new int[]{44641,44642,44643,44644,44645,44646,44647,44648};
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeXZ = 180;
			npc.sizeY = 180;
			break;
			
		case 12810:
			npc.name = "Investor Boss";
            npc.models = new int[]{44624,44625,44626,44627,44628,44629,44630};
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeXZ = 350;
			npc.sizeY = 350;
			break;
			
		case 12801:
			npc.name = "@bla@Apollyon";
            npc.models = new int[]{44631, 44632, 44633, 44634, 44635,44636,44637};
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeXZ = 250;
			npc.sizeY = 250;
			break;
		case 12802:
			npc.name = "@cya@Aquatic Frost Beast";
            npc.models = new int[]{44638};
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.sizeXZ = 300;
			npc.sizeY = 300;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			break;
		case 3000:
			npc.name = "@cya@Doomed Nightbeast";
            npc.models = new int[]{25154};
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.sizeXZ = 80;
			npc.sizeY = 80;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			break;
		case 2579:
			npc.name = "SebZero's Veteran";
			npc.description = "One of SebZero veterans.";
			npc.combatLevel = 200;
			npc.actions = new String[5];
			npc.actions[0] = "Talk-to";
			// npc.actions[2] = "Trade";
			npc.models = new int[7];
			npc.models[0] = 65289;
			npc.models[1] = 62746;
			npc.models[2] = 62743;
			npc.models[3] = 65305;
			npc.models[4] = 13319;
			npc.models[5] = 27738;
			npc.models[6] = 20147;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.npcHeadModels = NPCDef.forID(517).npcHeadModels;
			break;
		case 6830:
		case 6841:
		case 6796:
		case 7331:
		case 6831:
		case 7361:
		case 6847:
		case 6872:
		case 7353:
		case 6835:
		case 6845:
		case 6808:
		case 7370:
		case 7333:
		case 7351:
		case 7367:
		case 6853:
		case 6855:
		case 6857:
		case 6859:
		case 6861:
		case 6863:
		case 9481:
		case 6827:
		case 6889:
		case 6813:
		case 6817:
		case 7372:
		case 8575:
		case 7345:
		case 6799:
		case 7335:
		case 7347:
		case 6800:
		case 9488:
		case 6804:
		case 6822:
		case 6849:
		case 7355:
		case 7357:
		case 7359:
		case 7341:
		case 7329:
		case 7339:
		case 7349:
		case 7375:
		case 7343:
		case 6820:
		case 6865:
		case 6809:
		case 7363:
		case 7337:
		case 7365:
		case 6991:
		case 6992:
		case 6869:
		case 6818:
		case 6843:
		case 6823:
		case 7377:
		case 6887:
		case 6885:
		case 6883:
		case 6881:
		case 6879:
		case 6877:
		case 6875:
		case 6833:
		case 6851:
		case 5079:
		case 5080:
		case 6824:
			npc.actions = new String[] { null, null, null, null, null };
			break;
		case 6806: // thorny snail
		case 6807:
		case 6994: // spirit kalphite
		case 6995:
		case 6867: // bull ant
		case 6868:
		case 6794: // spirit terrorbird
		case 6795:
		case 6815: // war tortoise
		case 6816:
		case 6874:// pack yak
		case 6873: // pack yak
		case 3594: // yak
		case 3590: // war tortoise
		case 3596: // terrorbird
			npc.actions = new String[] { "Store", null, null, null, null };
			break;
		case 548:
			npc.actions = new String[] { "Trade", null, null, null, null };
			break;
		case 3299:
		case 437:
			npc.actions = new String[] { "Trade", null, null, null, null };
			break;
		case 1265:
			npc.drawMinimapDot = true;
            npc.name = "@gre@Emerald crab";
            npc.models = new int[]{44250};
			npc.sizeY = 210;
			npc.sizeXZ = 210;
			break;
			
		case 5957:
			npc.models = new int[2];
			npc.models[0] = 44262; //HEAD
			npc.name = "Noxious Troll";
            npc.walkAnim = 819;
            npc.standAnim = 808;
		    npc.combatLevel = 187;
		    npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack", null, null, null};
	        npc.walkAnim = 11975;
	        npc.standAnim = 11973;
		    npc.squaresNeeded = 2;
			npc.sizeXZ = 340;
			npc.sizeY = 340;
			break;
			
		case 5958:
			npc.models = new int[2];
			npc.models[0] = 97431; //HEAD
			npc.name = "Azazel Beast";
            npc.walkAnim = 819;
            npc.standAnim = 808;
		    npc.combatLevel = 187;
		    npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack", null, null, null};
	        npc.walkAnim = 11975;
	        npc.standAnim = 11973;
		    npc.squaresNeeded = 3;
			npc.sizeXZ = 170;
			npc.sizeY = 170;
			break;
			
		case 5959:
			npc.models = new int[2];
			npc.models[0] = 44264; //HEAD
			npc.name = "Ravana";
            npc.walkAnim = 819;
            npc.standAnim = 808;
		    npc.combatLevel = 187;
		    npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack", null, null, null};
	        npc.walkAnim = 11975;
	        npc.standAnim = 11973;
		    npc.squaresNeeded = 3;
			npc.sizeXZ = 170;
			npc.sizeY = 170;
			break;
			
			
		case 185:
			npc.models = new int[7];
			npc.models[0] = 44303; //cape
			npc.models[1] = 44305; //Helmet
			npc.models[2] = 44307; //legs
			npc.models[3] = 44309; //body
			npc.models[4] = 23429; //sword
			npc.models[5] = 40102; //boots
			npc.models[6] = 80004; //boots
			npc.name = "Luminitous Warrior";
            npc.walkAnim = 819;
            npc.standAnim = 808;
		    npc.combatLevel = 187;
		    npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack", null, null, null};
	        npc.walkAnim = 11975;
	        npc.standAnim = 11973;
		    npc.squaresNeeded = 3;
			npc.sizeXZ = 170;
			npc.sizeY = 170;
			break;
			
			
			
		case 1267:
		case 8459:
			npc.drawMinimapDot = true;
			break;
		case 961:
			npc.actions = new String[] { null, null, "Buy Consumables", "Restore Stats", null };
			npc.name = "Healer";
			break;
		case 705:
			npc.actions = new String[] { null, null, "Buy Armour", "Buy Weapons", "Buy Jewelries" };
			npc.name = "Warrior";
			break;
		case 1861:
			npc.actions = new String[] { null, null, "Buy Equipment", "Buy Ammunition", null };
			npc.name = "Archer";
			break;
		case 946:
			npc.actions = new String[] { null, null, "Buy Equipment", "Buy Runes", null };
			npc.name = "Mage";
			break;
		case 2253:
			npc.actions = new String[] { null, null, "Buy Skillcapes", "Buy Skillcapes (t)", "Buy Hoods" };
			break;
		case 2292:
			npc.actions = new String[] { "Trade", null, null, null, null };
			npc.name = "Merchant";
			break;
		case 2676:
			npc.actions = new String[] { "Makeover", null, null, null, null };
			break;
		case 494:
		case 1360:
			npc.actions = new String[] { "Talk-to", null, null, null, null };
			break;
		case 1685:
			npc.name = "Pure";
			npc.actions = new String[] { "Trade", null, null, null, null };
			break;
			
		case 422:
			npc.name = "Onslaught";
			npc.description = "I Will CRUSH YOU";
			npc.combatLevel = 256;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[1];
			npc.models[0] = 40199; //HEAD
			npc.sizeY = 350;
			npc.sizeXZ = 350;
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 421:
			npc.name = "Rick";
			npc.combatLevel = 0;
			npc.description = "Get your shit together.";
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.models = new int[1];
			npc.models[0] = 23795; //HEAD
			npc.actions = new String[5];
			npc.sizeY = 180;
			npc.sizeXZ = 180;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
	     case 9:
	         npc.name = "Helicopter";
	         npc.description = "Ancient Beast";
	         npc.standAnim = 24502;
	         npc.walkAnim = 24503;
	         npc.models = new int[1];
	         npc.models[0] = 57555;
	         npc.actions = new String[5];
	         npc.actions[1] = "Attack";
	         npc.combatLevel = 100;
	         npc.sizeXZ = 220;
	         npc.sizeY = 220;
	         break;
	         
	         
			case 186:
	            npc.name = "Sirenic Predator";
	            npc.models = new int[]{ 90026, 90029, 90032, 94700};//
	            npc.squaresNeeded = 1;
				npc.combatLevel =32;
				npc.description = "Gods of Sirenic";
				npc.actions = new String[5];
				npc.sizeY = 110;
				npc.sizeXZ = 110;
				npc.actions = new String[] {null, "Attack",  null, null, null};
				break;
				
				
			case 527:
	            npc.name = "Storm Breaker";
	            npc.models = new int[]{40253, 40263, 40257, 40261, 40259,40255};
	            npc.walkAnim = 819;
	            npc.standAnim = 808;
	            npc.squaresNeeded = 3;
				npc.combatLevel =155;
				npc.description = "He interrupts you while praying to SebZero gods";
				npc.actions = new String[5];
				npc.sizeY = 240;
				npc.sizeXZ = 240;
				npc.actions = new String[] {null, "Attack",  null, null, null};
				break;
				
			case 12815:
	            npc.name = "Sirenic Archer";
	            npc.models = new int[]{57558,57562,57560,23110,44282,44413,44401};
	            npc.walkAnim = 10210;
	            npc.standAnim = 12155;
	            npc.squaresNeeded = 1;
				npc.combatLevel =155;
				npc.description = "He interrupts you while praying to SebZero gods";
				npc.actions = new String[5];
				npc.sizeY = 100;
				npc.sizeXZ = 100;
				npc.actions = new String[] {null, "Attack",  null, null, null};
				break;
			
			case 12836:
	            npc.name = "Rajin";
	            npc.models = new int[]{61488,61463,61466,61462,61451,23778,23922};
	            npc.walkAnim = 819;
	            npc.standAnim = 808;
	            npc.squaresNeeded = 1;
				npc.combatLevel =75;
				npc.description = "Almighty powerful Rajin";
				npc.actions = new String[5];
				npc.sizeY = 160;
				npc.sizeXZ = 160;
				npc.actions = new String[] {null, "Attack",  null, null, null};
                npc.headIcon = 2;
				break;
				
				//3105 9834
			case 12837:
	            npc.name = "Zombie Hill Giant";
	            npc.models = new int[]{62661,62662,62663,62664,62666};
				NPCDef copyAnimations18 = NPCDef.forID(117);
				npc.runAnim = copyAnimations18.runAnim;
				npc.standAnim = copyAnimations18.standAnim;
				npc.walkAnim = copyAnimations18.walkAnim;
				npc.combatLevel =75;
				npc.description = "I wonder what happened to his skin";
				npc.actions = new String[5];
				npc.sizeY = 160;
				npc.sizeXZ = 160;
				npc.actions = new String[] {null, "Attack",  null, null, null};
				break;
			
			case 13635:
				npc.name = "Troll King";
	            npc.models = new int[]{62661};
	            npc.actions = new String[] {null, "Attack", null, null, null};
	            npc.combatLevel = 800;
	            npc.standAnim = 10814;
	            npc.walkAnim = 10812;
				break;
				
			case 13747:
				npc.name = "The Mummy";
	            npc.models = new int[]{62661};
	            npc.actions = new String[] {null, "Attack", null, null, null};
				npc.actions = new String[5];
				npc.sizeY = 150;
				npc.sizeXZ = 150;
	            npc.degreesToTurn = 32 ;
	            npc.combatLevel = 682;
				break;
				
			case 304:
	            npc.name = "Elon Musk Pet";
	            npc.models = new int[]{74583,74584,74585,74586,74587,74588};
				NPCDef copyAnimations269 = NPCDef.forID(100);
				npc.runAnim = copyAnimations269.runAnim;
				npc.standAnim = copyAnimations269.standAnim;
				npc.walkAnim = copyAnimations269.walkAnim;
				npc.description = "this man is very high class";
				npc.actions = new String[5];
				npc.sizeY = 70;
				npc.sizeXZ = 70;
			    npc.drawMinimapDot = false;
				npc.headIcon = -1;
	            npc.squaresNeeded = 1;
				break;
			case 310:
				npc.sizeXZ = 30;
	            npc.name = "AFK Fishing spot";
				break;
			case 11839:
	            npc.name = "Crash Bandicoot Pet";
	            npc.models = new int[]{62782};
				NPCDef copyAnimations249 = NPCDef.forID(100);
				npc.runAnim = copyAnimations249.runAnim;
				npc.standAnim = copyAnimations249.standAnim;
				npc.walkAnim = copyAnimations249.walkAnim;
				npc.combatLevel =75;
				npc.description = "I wonder what happened to his skin";
				npc.actions = new String[5];
				npc.sizeY = 70;
				npc.sizeXZ = 70;
			    npc.drawMinimapDot = false;
				npc.headIcon = -1;
	            npc.squaresNeeded = 1;
				break;
				
			case 12839:
	            npc.name = "Crash Bandicoot";
	            npc.models = new int[]{62782};
				NPCDef copyAnimations121 = NPCDef.forID(100);
				npc.runAnim = copyAnimations121.runAnim;
				npc.standAnim = copyAnimations121.standAnim;
				npc.walkAnim = copyAnimations121.walkAnim;
				npc.combatLevel =75;
				npc.description = "I wonder what happened to his skin";
				npc.actions = new String[5];
				npc.sizeY = 100;
				npc.sizeXZ = 100;
	            npc.squaresNeeded = 1;
				npc.actions = new String[] {null, "Attack",  null, null, null};
				break;
			case 604:
	            npc.name = "@mag@Guard";
	            npc.models = new int[]{74590,74591,74592,74593,74565}; //74565 74591 is legs
	            npc.walkAnim = 819;
	            npc.standAnim = 808;
	            npc.squaresNeeded = 1;
				npc.combatLevel =75;
				npc.description = "Dont make him Angry";
				npc.actions = new String[5];
				npc.sizeY = 30;
				npc.sizeXZ = 30;
				npc.actions = new String[] {null, "Attack",  null, null, null};
				break;
			case 1002:
	            npc.name = "@mag@Guard";
	            npc.models = new int[]{74590,74591,74592,74593,74594}; //74565 74591 is legs
	            npc.walkAnim = 819;
	            npc.standAnim = 808;
	            npc.squaresNeeded = 1;
				npc.combatLevel =75;
				npc.description = "Dont make him Angry";
				npc.actions = new String[5];
				npc.sizeY = 30;
				npc.sizeXZ = 30;
				npc.actions = new String[] {null, "Attack",  null, null, null};
				break;
			case 1001:
	            npc.name = "@mag@Guard";
	            npc.models = new int[]{74590,74591,74592,74593,74595}; //74565 74591 is legs
	            npc.walkAnim = 819;
	            npc.standAnim = 808;
	            npc.squaresNeeded = 1;
				npc.combatLevel =75;
				npc.description = "Dont make him Angry";
				npc.actions = new String[5];
				npc.sizeY = 30;
				npc.sizeXZ = 30;
				npc.actions = new String[] {null, "Attack",  null, null, null};
				break;
		case 100:
            npc.name = "Goku";
            npc.models = new int[]{23820, 23782, 23780, 23778, 23787};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 220;
			npc.sizeXZ = 220;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
		case 366:
            npc.name = "Ultra Pummeler";
            npc.models = new int[]{74589};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 60;
			npc.sizeXZ = 60;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
		case 1164:
            npc.name = "@Whi@Afk Fishing Shop";
			break;
		case 12113:
            npc.name = "Inuyasha";
            npc.models = new int[]{100012, 100013, 100014, 100015, 100016,100017};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 200;
			npc.sizeXZ = 200;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
			
			case 5931:
	            npc.name = "@re1@Ahri";
	            npc.models = new int[]{32884,32885,32886,32887,32888};
	            npc.walkAnim = 819;
	            npc.standAnim = 808;
	            npc.squaresNeeded = 1;
				npc.combatLevel =75;
				npc.description = "she thicc";
				npc.actions = new String[5];
				npc.sizeY = 200;
				npc.sizeXZ = 200;
	            npc.drawMinimapDot = true;
				npc.actions = new String[] {null, "Attack",  null, null, null};
				break;
				
			case 307:
	            npc.name = "Byakuya Kuchiki";
	            npc.models = new int[]{74845,74847,74848,74849,74850};
	            npc.walkAnim = 819;
	            npc.standAnim = 808;
	            npc.squaresNeeded = 3;
				npc.combatLevel =75;
				npc.description = "Only the strongest warriors have slain Byakuya Kuchiki.";
				npc.actions = new String[5];
				npc.sizeY = 170;
				npc.sizeXZ = 170;
	            npc.drawMinimapDot = true;
				npc.actions = new String[] {null, "Attack",  null, null, null};
				break;	
				
				case 299:
		            npc.name = "Drugo";
		            npc.models = new int[]{74818,74820,74822,74824,74823,74825,74827,74829,74830};
		            npc.walkAnim = 819;
		            npc.standAnim = 808;
		            npc.squaresNeeded = 3;
					npc.combatLevel =75;
					npc.description = "an Undefeated warrior";
					npc.actions = new String[5];
					npc.sizeY = 170;
					npc.sizeXZ = 170;
		            npc.drawMinimapDot = true;
					npc.actions = new String[] {null, "Attack",  null, null, null};
					break;	
				
				case 254:
		            npc.name = "@re1@MysteryMan";
		            npc.models = new int[]{18600,18601,18603,18605,18606};
		            npc.walkAnim = 819;
		            npc.standAnim = 808;
		            npc.squaresNeeded = 3;
					npc.combatLevel =75;
					npc.description = "he thicc";
					npc.actions = new String[5];
					npc.sizeY = 350;
					npc.sizeXZ = 350;
		            npc.drawMinimapDot = true;
					npc.actions = new String[] {null, "Attack",  null, null, null};
					break;
				
				case 30:
		            npc.name = "@whi@Ironman Supply shop";
		            npc.models = new int[]{100025, 100026, 100027, 100028, 100029,100030,100031,100032,100035};
		            npc.walkAnim = 819;
		            npc.standAnim = 808;
		            npc.squaresNeeded = 1;
					npc.combatLevel =75;
					npc.description = "Dont make him Angry";
					npc.actions = new String[5];
					npc.sizeY = 130;
					npc.sizeXZ = 130;
		            npc.drawMinimapDot = true;
					npc.actions = new String[] {"Talk-to", null, null, null, null};
					break;
					
					
		case 12114:
            npc.name = "@whi@Iron Maniac (@bla@Melee)";
            npc.models = new int[]{100025, 100026, 100027, 100028, 100029,100030,100031,100032,100035};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 100;
			npc.sizeXZ = 100;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 12115:
            npc.name = "@whi@Iron Maniac (@bla@Magic)";
            npc.models = new int[]{100025, 100026, 100027, 100028, 100029,100030,100031,100032,100034};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 100;
			npc.sizeXZ = 100;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 12116:
            npc.name = "@whi@Iron Maniac (@bla@Range)";
            npc.models = new int[]{100025, 100026, 100027, 100028, 100029,100030,100031,100032,100033};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 100;
			npc.sizeXZ = 100;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 12117:
			npc.name = "Albedo Summer Guardian";
			npc.actions = new String[5];
			npc.models = new int[] { 59513 };
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 45;
			npc.sizeXZ = 45;
			npc.squaresNeeded = 2;
			break;
			
		case 11362:
			npc.name = "@whi@Veigar Boss";
			npc.actions = new String[5];
			npc.models = new int[] {100077};
			npc.standAnim = 808;
			npc.walkAnim = 5761;
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 11364:
			npc.name = "@whi@Ezreal";
			npc.actions = new String[5];
			npc.models = new int[] {100078,100079,100080,100081,100082};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 80;
			npc.sizeXZ = 80;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 11365:
			npc.name = "@whi@Blood Reaper";
			npc.actions = new String[5];
			npc.models = new int[] {100083};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 130;
			npc.sizeXZ = 130;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
		case 2264:
			npc.name = "@whi@Avatar the Air bender";
			npc.actions = new String[5];
			npc.models = new int[] {100004,100005,100006,100007,100008,100010,100009,100011};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 130;
			npc.sizeXZ = 130;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 11361:
			npc.name = "@gre@Superior";
			npc.actions = new String[5];
			npc.models = new int[] {100300};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 250;
			npc.sizeXZ = 250;
			npc.combatLevel =500;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 9287:
			npc.name = "@whi@God King Garen";
			npc.actions = new String[5];
			npc.models = new int[] {100310,100311,100312,100313,100314,100315};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 650;
			npc.sizeXZ = 650;
			npc.combatLevel =500;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;

		case 9286:
			npc.name = "@gre@Superior";
			npc.actions = new String[5];
			npc.models = new int[] {100300};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 250;
			npc.sizeXZ = 250;
			npc.combatLevel =500;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 9285:
			npc.name = "@blu@Daily task master";
			npc.actions = new String[5];
			npc.models = new int[] {100067,100068,100069,100070,100071,100072};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 150;
			npc.sizeXZ = 150;
			npc.combatLevel =999;
			npc.actions = new String[] {"Talk-to", null, null, null, null};
			break;
			
			
		case 11360:
			npc.name = "@whi@Lili";
			npc.actions = new String[5];
			npc.models = new int[] {100059,100061,100063,100066,100065};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 130;
            npc.drawMinimapDot = true;
			npc.sizeXZ = 130;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
		case 11380:
			npc.name = "@whi@ShadowLord";
			npc.actions = new String[5];
			npc.models = new int[] {96279,96280,96277,96275,96284};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 130;
            npc.drawMinimapDot = true;
			npc.sizeXZ = 130;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
		case 11382:
			npc.name = "@whi@Maniac ogre child";
			npc.actions = new String[5];
			npc.models = new int[] {97436};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 10;
			npc.sizeXZ = 10;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
			
		case 11383:
			npc.name = "Obito Uchiha";
			npc.actions = new String[5];
			npc.models = new int[] {97354,97358,97360,97362,97363,97364,97366};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 130;
			npc.sizeXZ = 130;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
		case 10010:
			npc.name = "@red@Diablo Mass boss";
			npc.actions = new String[5];
			npc.models = new int[] {97377,97375,97374,97372,97370,61288};
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 250;
			npc.sizeXZ = 250;
            npc.drawMinimapDot = true;
			npc.originalColours = new int[] {40};
			npc.destColours = new int[] {61};
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 11369:
			npc.name = "@whi@Nishimiya";
			npc.actions = new String[5];
			npc.models = new int[] {97381,97382,97383,97384,97385};
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 120;
			npc.sizeXZ = 120;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
		case 11305:
			npc.name = "@whi@Uru Isiha";
			npc.actions = new String[5];
			npc.models = new int[] {97387,97388,97389,97390,97391,97392,97393};
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 120;
			npc.sizeXZ = 120;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
		case 11306:
			npc.name = "@whi@Neighborhood Dealer";
			npc.actions = new String[5];
			npc.models = new int[] {13344,23444,23448,23450,23452,23442};
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 120;
			npc.sizeXZ = 120;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {"Re-up", null,  null, null, null};
			break;
			
		case 11307:
			npc.name = "@whi@Killing Machine";
			npc.actions = new String[5];
			npc.models = new int[] {97402,97403,97404,97405,97406,97407};
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 60;
			npc.sizeXZ = 60;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 11202:
			npc.name = "@whi@Big Smoke";
			npc.actions = new String[5];
			npc.models = new int[] {100296,100283,100280,100279,100294};
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 180;
			npc.sizeXZ = 180;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 11203:
			npc.name = "@whi@Jinni";
			npc.actions = new String[5];
			npc.models = new int[] {97410};
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 100;
			npc.sizeXZ = 100;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
		case 11204:
			npc.name = "@whi@Zombie kid";
			npc.actions = new String[5];
			npc.models = new int[] {97434};
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 100;
			npc.sizeXZ = 100;
            npc.drawMinimapDot = true;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
		case 11205:
			npc.name = "@whi@Purplefire Huntress";
			npc.actions = new String[5];
			npc.models = new int[] {100276};
			npc.standAnim = 808;
			npc.walkAnim = 819;
        	npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
		case 51:
			npc.name = "@whi@Lightreaper";
			npc.actions = new String[5];
			npc.models = new int[] {100265,100267,100269,100271,100263,100261,100260};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 160;
			npc.sizeXZ = 160;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 11381:
			npc.name = "@red@Yu-Gi-Oh Raids";
			npc.actions = new String[5];
			npc.models = new int[] {97335,97336,97337,97338,97339};
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 130;
			npc.sizeXZ = 130;
			npc.actions = new String[5];
			npc.actions[0] = "@red@Talk to";
			break;
			
			
			
			
		case 12823:
            npc.name = "Asuna";
            npc.models = new int[]{65523, 65524, 65525, 65526, 65527};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =196;
			npc.description = "Maybe i can take her on a date?";
			npc.actions = new String[5];
			npc.sizeY = 220;
			npc.sizeXZ = 220;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 11813:
            npc.name = "Naruto";
            npc.models = new int[]{65395,65529,65534,65399,65400}; //65397, 65398, 
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =157;
			npc.description = "Naruto doesn't want to do this..";
			npc.actions = new String[5];
			npc.sizeY = 250;
			npc.sizeXZ = 250;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
		case 12809:
            npc.name = "Kirito";
            npc.models = new int[]{65396, 65166, 65167, 65168, 65169,65170,65171};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 110;
			npc.sizeXZ = 110;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
		case 11808:
            npc.name = "Akuna";
            npc.models = new int[]{65331, 65332, 65333, 65334, 65335,65330,65340};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 110;
			npc.sizeXZ = 110;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 11811:
            npc.name = "Akuna Guardian";
            npc.models = new int[]{65331, 65332, 65333, 65334, 65335,65330,65340};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.headIcon = -1;
			break;
			
		case 12826:
            npc.name = "Blood Genie";
            npc.models = new int[]{61382};
			NPCDef copyAnimations7 = NPCDef.forID(3022);
			npc.runAnim = copyAnimations7.runAnim;
			npc.standAnim = copyAnimations7.standAnim;
			npc.walkAnim = copyAnimations7.walkAnim;
            npc.squaresNeeded = 1;
		    npc.drawMinimapDot = false;
			npc.description = "This pet will give me a great amount of blood money while equipped";
			npc.actions = new String[5];
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			break;
			
			
		case 12833:
            npc.name = "MR. Incredible"; 
            npc.models = new int[]{60997}; 
			NPCDef copyAnimations9 = NPCDef.forID(100); 
			npc.runAnim = copyAnimations9.runAnim; 
			npc.standAnim = copyAnimations9.standAnim; 
			npc.walkAnim = copyAnimations9.walkAnim; 
            npc.squaresNeeded = 1; 
			npc.actions = new String[5]; 
			npc.actions = new String[] {null, "Attack",  null, null, null};
			npc.sizeY = 180;  
			npc.sizeXZ = 180; 
			break;

			
		case 12835:
            npc.name = "Demogorgon";
            npc.models = new int[]{61461};
			NPCDef copyAnimations29 = NPCDef.forID(100);
			npc.runAnim = copyAnimations29.runAnim;
			npc.standAnim = copyAnimations29.standAnim;
			npc.walkAnim = copyAnimations29.walkAnim;
            npc.squaresNeeded = 1;
			npc.description = "Monsters INC";
			npc.actions = new String[5];
			npc.sizeY = 170;
			npc.sizeXZ = 170;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 12834:
            npc.name = "Mike Wazowski";
            npc.models = new int[]{61458};
			NPCDef copyAnimations19 = NPCDef.forID(100);
			npc.runAnim = copyAnimations19.runAnim;
			npc.standAnim = copyAnimations19.standAnim;
			npc.walkAnim = copyAnimations19.walkAnim;
            npc.squaresNeeded = 1;
			npc.description = "Monsters INC";
			npc.actions = new String[5];
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 12825:
            npc.name = "Killer Imp";
            npc.models = new int[]{61375};
			NPCDef copyAnimations6 = NPCDef.forID(1531);
			npc.runAnim = copyAnimations6.runAnim;
			npc.standAnim = copyAnimations6.standAnim;
			npc.walkAnim = copyAnimations6.walkAnim;
            npc.squaresNeeded = 1;
			npc.description = "Dont fuck with imps";
			npc.actions = new String[5];
			npc.sizeY = 150;
			npc.sizeXZ = 150;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 259:
            npc.name = "King Khione";
            npc.models = new int[]{60818}; //60818
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 150;
			npc.sizeXZ = 150;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.actions[2] = "Show Drops";
			break;
			
		case 2907:
            npc.name = "Razorspawn";
            npc.models = new int[]{44491};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.actions = new String[5];
			npc.sizeY = 90;
			npc.sizeXZ = 90;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 1049:
            npc.name = "Bob Marley";
            npc.models = new int[]{44312};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 110;
			npc.sizeXZ = 110;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
			
		case 130:
            npc.name = "Nox";
            npc.models = new int[]{44241};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 110;
			npc.sizeXZ = 110;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 2005:
            npc.name = "Trainer May";
            npc.models = new int[]{44209};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 270;
			npc.sizeXZ = 270;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;

		/*case 6142:
            npc.models = new int[]{15285};
			break;
		case 6143:
            npc.models = new int[]{15288};
			break;
		case 6144:
            npc.models = new int[]{15287};
			break;
		case 6145:
            npc.models = new int[]{15286};
			break;*/
		case 25:
            npc.name = "@whi@Sephiroth";
            npc.models = new int[]{28373, 28316, 28368, 28318, 28319,28321};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 200;
			npc.sizeXZ = 200;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 3224:
            npc.name = "@mag@Yippie";
            npc.models = new int[]{23477};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "He looks like hes from the 80s";
			npc.actions = new String[5];
			npc.sizeY = 125;
			npc.sizeXZ = 125;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;

		case 3225:
            npc.name = "@gre@Tank";
            npc.models = new int[]{23479};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 2;
			npc.combatLevel =88;
			npc.description = "dont stand in front of this";
			npc.actions = new String[5];
			npc.sizeY = 250;
			npc.sizeXZ = 250;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 3226:
            npc.name = "Kirby";
            npc.models = new int[]{23481};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 2;
			npc.combatLevel =88;
			npc.description = "Its kirby!";
			npc.actions = new String[5];
			npc.sizeY = 250;
			npc.sizeXZ = 250;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
		case 82:
            npc.name = "Frost Demon";
            npc.models = new int[]{61226};
			npc.combatLevel =75;
			npc.sizeXZ = npc.sizeXZ * 2;
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.sizeY = npc.sizeY * 2;
			npc.description = "@red@<shad=1>Blood slayer NPC";
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 34:
            npc.name = "Blood warrior";
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.models = new int[]{21636};
			npc.combatLevel =75;
			npc.sizeXZ = npc.sizeXZ * 2;
			npc.sizeY = npc.sizeY * 2;
			npc.description = "@red@<shad=1>Blood slayer NPC";
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 667:
			npc.sizeXZ = 140;
			npc.sizeY = 140;
            npc.name = "Blood Demon";
			npc.description = "@red@<shad=1>Blood slayer NPC";
            break;
            
		case 353:
            npc.name = "Otaku";
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.models = new int[]{61280};
			npc.combatLevel =75;
			npc.description = "@red@<shad=1>Blood slayer NPC";
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 354:
            npc.name = "Ryuk";
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.models = new int[]{61285};
			npc.combatLevel =75;
			npc.description = "@red@<shad=1>Blood slayer NPC";
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 49:
            npc.name = "Revenant Hellhound";
            npc.models = new int[]{61161};
			npc.combatLevel =86;
			npc.description = "@red@<shad=1>Blood slayer NPC";
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 1532:
            npc.name = "@red@Blood Slayer Shop";
            npc.models = new int[]{61187};
            npc.walkAnim = 819;
            npc.standAnim = 808;
			npc.description = "@red@<shad=1>Blood slayer NPC";
			npc.actions = new String[5];
			npc.actions[0] = "@or2@Open";
			break;
				
		case 1531:
            npc.name = "@red@Blood Slayer Master";
			npc.description = "@red@<shad=1>Blood slayer Imp";
			npc.actions = new String[5];
			npc.actions[0] = "@or2@Talk-to";
			npc.sizeXZ = 200;
			npc.sizeY = 200;
			break;
			
		case 7553:
            npc.name = "Pestilent Bloat";
            npc.models = new int[]{61163};
            npc.walkAnim  = 502;
            npc.standAnim = 520;
			npc.description = "@red@<shad=1>Blood slayer NPC";
			npc.actions = new String[5];
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 101:
            npc.name = "Vegeta";
            npc.models = new int[]{23786, 23787, 23789, 23791, 23793};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 140;
			npc.sizeXZ = 140;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 4291:
		case 4292:
            npc.name = "Frankenstein";
            npc.models = new int[]{23528};
            npc.walkAnim = 819;
            npc.standAnim = 808;
            npc.squaresNeeded = 1;
			npc.combatLevel =75;
			npc.description = "Dont make him Angry";
			npc.actions = new String[5];
			npc.sizeY = 220;
			npc.sizeXZ = 220;
			npc.actions = new String[] {null, "Attack",  null, null, null};
			break;
			
		case 3030:
			npc.name = "King black dragon";
			npc.actions = new String[5];
			npc.models = new int[] { 17414, 17415, 17429, 17422 };
			npc.combatLevel = 276;
			npc.standAnim = 90;
			npc.walkAnim = 4635;
			npc.sizeY = 63;
			npc.sizeXZ = 63;
			npc.squaresNeeded = 3;
			break;
			
		case 3078:
			npc.name = "Pet Emeralds Dragon";
			npc.actions = new String[5];
			npc.models = new int[] { 95136, 95137, 95138, 95139 };
			npc.combatLevel = 276;
			npc.standAnim = 90;
			npc.walkAnim = 4635;
			npc.sizeY = 50;
			npc.sizeXZ = 50;
			npc.squaresNeeded = 3;
		    npc.drawMinimapDot = false;
			break;
			
		case 12483:
			npc.name = "King black dragon";
			npc.actions = new String[5];
			npc.actions[0] = "Attack";
			npc.models = new int[] { 95136, 95137, 95138, 95139 };
			npc.combatLevel = 276;
			npc.standAnim = 90;
			npc.walkAnim = 4635;
			npc.sizeY = 85;
			npc.sizeXZ = 85;
			npc.squaresNeeded = 5;
			break;

		case 3031:
			npc.name = "General graardor";
			npc.actions = new String[5];
			npc.models = new int[] { 27785, 27789 };
			npc.combatLevel = 624;
			npc.standAnim = 7059;
			npc.walkAnim = 7058;
			npc.sizeY = 40;
			npc.sizeXZ = 40;
			break;
			
		case 12820:
			npc.models = new int[] { 44640 };
			npc.name = "Elemental-Jad";
			npc.standAnim = 7589;
			npc.walkAnim = 7588;
			npc.actions = new String[] { null, "Attack", null, null, null };
			npc.destColours = null;
			npc.originalColours = null;
			npc.combatLevel = 900;
			npc.squaresNeeded = 5;
			npc.sizeXZ = 128;
			npc.sizeY = 128;
			break;	

		case 3032:
			npc.name = "@or2@Yk'Lagor the Thunderous";
			npc.actions = new String[5];
			npc.originalColours = new int[] {60};
			npc.destColours = new int[] {56};
			npc.models = new int[] { 61125 };
			npc.combatLevel = 702;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			npc.sizeY = 45;
			npc.sizeXZ = 45;
			npc.squaresNeeded = 2;
			break;
			
		case 9177:
			npc.name = "Pet Skeletal Horror";
			npc.actions = new String[5];
			npc.models = new int[] { 48292 };
			npc.combatLevel = 702;
			npc.standAnim = 12074;
			npc.walkAnim = 12078;
			npc.sizeY = 50;
			npc.sizeXZ = 50;
			npc.squaresNeeded = 3;
		    npc.drawMinimapDot = false;
			break;
			
			
		case 3705:
			npc.name = "@blu@Milo Skeleton";
			npc.models = new int[] { 35771 };
			break;

		case 3033:
			npc.name = "Chaos elemental";
			npc.actions = new String[5];
			npc.models = new int[] { 11216 };
			npc.combatLevel = 305;
			npc.standAnim = 3144;
			npc.walkAnim = 3145;
			npc.sizeY = 62;
			npc.sizeXZ = 62;
			break;

		case 8133:
			npc.name = "Corporeal beast";
			npc.models = new int[] { 50945 };
			npc.sizeY = 85;
			npc.sizeXZ = 85;
			break;
			
		case 3034:
			npc.name = "Corporeal beast";
			npc.actions = new String[5];
			npc.models = new int[] { 50945 };
			npc.combatLevel = 785;
			npc.standAnim = 10056;
			npc.walkAnim = 10055;
			npc.sizeY = 15;
			npc.sizeXZ = 15;
			npc.squaresNeeded = 2;
			break;

		case 3035:
			npc.name = "Kree'arra";
			npc.actions = new String[5];
			npc.models = new int[] { 28003, 28004 };
			npc.combatLevel = 580;
			npc.standAnim = 6972;
			npc.walkAnim = 6973;
			npc.sizeY = 43;
			npc.sizeXZ = 43;
			npc.squaresNeeded = 2;
			break;

		case 3036:
			npc.name = "K'ril tsutsaroth";
			npc.actions = new String[5];
			npc.models = new int[] { 27768, 27773, 27764, 27765, 27770 };
			npc.combatLevel = 650;
			npc.standAnim = 6943;
			npc.walkAnim = 6942;
			npc.sizeY = 43;
			npc.sizeXZ = 43;
			npc.squaresNeeded = 2;
			break;
		case 3037:
			npc.name = "Commander zilyana";
			npc.actions = new String[5];
			npc.models = new int[] { 28057, 28071, 28078, 28056 };
			npc.combatLevel = 596;
			npc.standAnim = 6963;
			npc.walkAnim = 6962;
			npc.sizeY = 103;
			npc.sizeXZ = 103;
			npc.squaresNeeded = 2;
			break;
		case 3089:
			npc.models = new int[2];
			npc.sizeXZ = 35;
			npc.sizeY = 35;
			npc.name = "@red@Emeralds cutey";
			npc.models[1] = 29270;
			npc.actions = new String[5];
			npc.combatLevel = 318;
			npc.standAnim = 4484;
			npc.walkAnim = 4488;
			npc.originalColours = new int[9];
			npc.originalColours[0] = 5219; // teeth
			npc.originalColours[1] = 910; // inside of mouth. Ankles. End of tail
			npc.originalColours[2] = 1814; // around face. Start of tail
			npc.originalColours[3] = 1938; // around face and back of head. Top part of legs and end bit of tail.
			npc.originalColours[4] = 1690; // top of forehead
			npc.originalColours[5] = 921; // eyebrows
			npc.originalColours[6] = 0; // horns. Feet
			npc.originalColours[7] = 962; // eye colour
			npc.originalColours[8] = 912; // knees, dick, end of tail
			npc.destColours = new int[9];
			npc.destColours[0] = 271833;
			npc.destColours[1] = 271833;
			npc.destColours[2] = 271833;
			npc.destColours[3] = 271833;
			npc.destColours[4] = 271833;
			npc.destColours[5] = 271833;
			npc.destColours[6] = 271833;
			npc.destColours[7] = 271833;
			npc.destColours[8] = 271833;
			break;
		case 3038:
			npc.name = "Dagannoth supreme";
			npc.actions = new String[5];
			npc.models = new int[] { 9941, 9943 };
			npc.combatLevel = 303;
			npc.standAnim = 2850;
			npc.walkAnim = 2849;
			npc.sizeY = 105;
			npc.sizeXZ = 105;
			npc.squaresNeeded = 2;
			break;

		case 3039:
			npc.name = "Dagannoth prime"; // 9940, 9943, 9942
			npc.actions = new String[5];
			npc.models = new int[] { 9940, 9943, 9942 };
			npc.originalColours = new int[] { 11930, 27144, 16536, 16540 };
			npc.destColours = new int[] { 5931, 1688, 21530, 21534 };
			npc.combatLevel = 303;
			npc.standAnim = 2850;
			npc.walkAnim = 2849;
			npc.sizeY = 105;
			npc.sizeXZ = 105;
			npc.squaresNeeded = 2;
			break;

		case 3040:
			npc.name = "Dagannoth rex";
			npc.actions = new String[5];
			npc.models = new int[] { 9941 };
			npc.originalColours = new int[] { 16536, 16540, 27144, 2477 };
			npc.destColours = new int[] { 7322, 7326, 10403, 2595 };
			npc.combatLevel = 303;
			npc.standAnim = 2850;
			npc.walkAnim = 2849;
			npc.sizeY = 105;
			npc.sizeXZ = 105;
			npc.squaresNeeded = 2;
			break;
		case 3047:
			npc.name = "Frost dragon";
			npc.combatLevel = 166;
			npc.standAnim = 13156;
			npc.walkAnim = 13157;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			// npc.type = 51;
			npc.degreesToTurn = 32;
			npc.models = new int[] { 56767, 55294 };
			npc.actions = new String[5];
			npc.sizeY = 72;
			npc.sizeXZ = 72;
			npc.squaresNeeded = 2;
			break;
			
		case 8349:
			npc.models = new int[] { 44733 };
			npc.name = "Tormented demon";
			break;
			
		case 1158:
			npc.models = new int[] { 70009};
			npc.name = "Kalphite Queen";
			npc.sizeY = 72;
			npc.sizeXZ = 72;
			npc.squaresNeeded = 2;
			break;
			
		case 1160:
			npc.models = new int[] { 70009};
			npc.name = "Kalphite Queen";
			npc.sizeY = 72;
			npc.sizeXZ = 72;
			npc.squaresNeeded = 2;
			break;
			
		case 3048:
			npc.models = new int[] { 44733 };
			npc.name = "Tormented demon";
			npc.combatLevel = 450;
			npc.standAnim = 10921;
			npc.walkAnim = 10920;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			// npc.type = 8349;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.sizeY = 60;
			npc.sizeXZ = 60;
			npc.squaresNeeded = 2;
			break;
		case 3050:
			npc.models = new int[] { 24602, 24605, 24606 };
			npc.name = "Kalphite queen";
			npc.actions = new String[5];
			npc.combatLevel = 333;
			npc.standAnim = 6236;
			npc.walkAnim = 6236;
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.squaresNeeded = 2;
			break;
		case 3077:
			npc.models = new int[] { 24602, 24605, 24606 };
			npc.name = "Demi's noob pet";
		    npc.drawMinimapDot = false;
			npc.actions = new String[5];
			npc.originalColours = new int[9];
			npc.originalColours[0] = 5219; // teeth
			npc.originalColours[1] = 910; // inside of mouth. Ankles. End of tail
			npc.originalColours[2] = 1814; // around face. Start of tail
			npc.originalColours[3] = 1938; // around face and back of head. Top part of legs and end bit of tail.
			npc.originalColours[4] = 1690; // top of forehead
			npc.originalColours[5] = 921; // eyebrows
			npc.originalColours[6] = 0; // horns. Feet
			npc.originalColours[7] = 962; // eye colour
			npc.originalColours[8] = 912; // knees, dick, end of tail
			npc.destColours = new int[9];
			npc.destColours[0] = 955;
			npc.destColours[1] = 955;
			npc.destColours[2] = 995;
			npc.destColours[3] = 995;
			npc.destColours[4] = 995;
			npc.destColours[5] = 995;
			npc.destColours[6] = 995;
			npc.destColours[7] = 995;
			npc.destColours[8] = 995;
			npc.combatLevel = 333;
			npc.standAnim = 6236;
			npc.walkAnim = 6236;
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.squaresNeeded = 2;
			break;
		case 3051:
			npc.models = new int[] { 46141 };
			npc.name = "Slash bash";
			npc.actions = new String[5];
			npc.combatLevel = 111;
			npc.standAnim = 11460;
			npc.walkAnim = 11461;
			npc.sizeY = 65;
			npc.sizeXZ = 65;
			npc.squaresNeeded = 2;
			break;
		case 3052:
			npc.models = new int[] { 61189 };
			npc.name = "Phoenix";
			npc.actions = new String[5];
			npc.combatLevel = 235;
			npc.standAnim = 11074;
			npc.walkAnim = 11075;
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.squaresNeeded = 2;
			break;
			
			
			
		case 3053:
			npc.models = new int[] { 46058, 46057 };
			npc.name = "Bandos avatar";
			npc.actions = new String[5];
			npc.combatLevel = 299;
			npc.standAnim = 11242;
			npc.walkAnim = 11255;
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.squaresNeeded = 2;
			break;
		case 3054:
			npc.models = new int[] { 23800 };
			npc.name = "Supreme Nex";
			npc.actions = new String[5];
			npc.combatLevel = 565;
			npc.standAnim = 6320;
			npc.walkAnim = 6319;
			npc.sizeY = 95;
			npc.sizeXZ = 95;
			npc.squaresNeeded = 1;
			break;
		case 2783:
			npc.models = new int[] { 97411};
			npc.name = "Sirenic Ogre";
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.squaresNeeded = 2;
			npc.walkAnim = 819;
			npc.standAnim = 808;
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			break;
			
		case 17:
			npc.name = "@whi@Hercules";
			npc.walkAnim = 819;
			npc.standAnim = 808;
			npc.models = new int[]{23899,23901,23903,23905,23907,23909,23910};
			npc.combatLevel = 6;
			npc.turn180AnimIndex = -1;
			npc.turn90CCWAnimIndex = -1;
			npc.turn90CWAnimIndex = -1;
			npc.degreesToTurn = 32;
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.sizeY = 130;
			npc.sizeXZ = 130;
			npc.squaresNeeded = 1;
			npc.drawMinimapDot = true;
			npc.combatLevel = 624;
			npc.standAnim = 808;
			npc.walkAnim = 819;
			break;
			
		case 203:
			npc.models = new int[] { 23803 };
			npc.name = "Kid Buu Pet";
		    npc.drawMinimapDot = false;
			npc.actions = new String[5];
			npc.combatLevel = 210;
			npc.sizeY = 75;
			npc.sizeXZ = 75;
			npc.squaresNeeded = 1;
			break;
			
			
		case 204:
			npc.models = new int[] { 23804};
		    npc.drawMinimapDot = false;
			npc.name = "Perfect Cell Pet";
			npc.actions = new String[5];
			npc.combatLevel = 210;
			npc.sizeY = 75;
			npc.sizeXZ = 75;
			npc.squaresNeeded = 1;
			break;
		case 207:
			npc.models = new int[] { 23805};
		    npc.drawMinimapDot = false;
			npc.name = "Frieza Pet (first form)";
			npc.actions = new String[5];
			npc.combatLevel = 210;
			npc.sizeY = 75;
			npc.sizeXZ = 75;
			npc.squaresNeeded = 1;
			break;
			
			
		case 180:
			npc.models = new int[] { 23805};
			npc.name = "Frieza (first form)";
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.combatLevel = 295;
			npc.sizeY = 195;
			npc.sizeXZ = 195;
			npc.squaresNeeded = 1;
			break;
			
		case 218:
			npc.models = new int[] { 23806};
		    npc.drawMinimapDot = false;
			npc.name = "Frieza Pet (second form)";
			npc.actions = new String[5];
			npc.combatLevel = 210;
			npc.sizeY = 75;
			npc.sizeXZ = 75;
			npc.squaresNeeded = 1;
			break;
			
			
		case 216:
			npc.models = new int[] { 23807};
		    npc.drawMinimapDot = false;
			npc.name = "Frieza Pet (final form)";
			npc.actions = new String[5];
			npc.combatLevel = 210;
			npc.sizeY = 75;
			npc.sizeXZ = 75;
			npc.squaresNeeded = 1;
			break;
			
		case 219:
			npc.models = new int[] { 23808};
			npc.name = "Herbal Rogue";
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.combatLevel = 295;
			npc.sizeY = 55;
			npc.sizeXZ = 55;
			npc.squaresNeeded = 1;
			break;
			
			
		case 175:
			npc.models = new int[] { 23803 };
			npc.name = "Kid Buu";
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.combatLevel = 265;
			npc.sizeY = 195;
			npc.sizeXZ = 195;
			npc.squaresNeeded = 1;
			break;
			
		case 4569:
			npc.models = new int[] { 23804 };
			npc.name = "@bla@DBZ Zone";
            npc.actions = new String[] {null, "@whi@Visit", null, null, null};
			npc.combatLevel = 295;
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.squaresNeeded = 1;
			break;
			
		case 176:
			npc.models = new int[] { 23803 };
			npc.name = "Kidbuu";
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.combatLevel = 295;
			npc.sizeY = 195;
			npc.sizeXZ = 195;
			npc.squaresNeeded = 1;
			break;
			
		case 3154:
			npc.models = new int[] { 23800 };
			npc.name = "Supreme Nex";
			npc.actions = new String[5];
			npc.actions[1] = "Attack";
			npc.originalColours = new int[1];
			npc.originalColours[0] = 5219; // teeth
			npc.destColours = new int[1];
			npc.destColours[0] = 7777;
			npc.combatLevel = 565;
			npc.standAnim = 6320;
			npc.walkAnim = 6319;
			npc.sizeY = 295;
			npc.sizeXZ = 295;
			npc.squaresNeeded = 1;
			break;
		case 3055:
			npc.models = new int[] { 51852, 51853 };
			npc.name = "Jungle strykewyrm";
			npc.actions = new String[5];


			npc.combatLevel = 110;
			npc.standAnim = 12790;
			npc.walkAnim = 12790;
			npc.sizeY = 60;
			npc.sizeXZ = 60;
			npc.squaresNeeded = 1;
			break;
		case 3056:
			npc.models = new int[] { 51848, 51850 };
			npc.name = "Desert strykewyrm";
			npc.actions = new String[5];


			npc.combatLevel = 130;
			npc.standAnim = 12790;
			npc.walkAnim = 12790;
			npc.sizeY = 60;
			npc.sizeXZ = 60;
			npc.squaresNeeded = 1;
			break;
		case 3057:
			npc.models = new int[] { 51847, 51849 };
			npc.name = "Ice strykewyrm";
			npc.actions = new String[5];


			npc.combatLevel = 210;
			npc.standAnim = 12790;
			npc.walkAnim = 12790;
			npc.sizeY = 65;
			npc.sizeXZ = 65;
			npc.squaresNeeded = 1;
			break;
		case 5301:
			npc.name = "@or2@Sirenic Dragon";
		    npc.actions = new String[] {null, "Attack", null, null, null};
		    npc.combatLevel = 252;
		    npc.models = new int[] {61300,61301,61302,61423};
		    npc.standAnim = 90;
		    npc.squaresNeeded = 4;
		    npc.walkAnim = 79;
		    npc.drawMinimapDot = true;
		break;
		case 3058:
			npc.models = new int[] { 49142, 49144 };
			npc.name = "Green dragon";
			npc.actions = new String[5];


			npc.combatLevel = 79;
			npc.standAnim = 12248;
			npc.walkAnim = 12246;
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.squaresNeeded = 2;
			break;
			
			
		case 8670:
			npc.models = new int[] {97300};
			npc.name = "Great Olm";
			npc.actions = new String[5];
			npc.actions[1] = "@or2@Attack";
			npc.combatLevel = 379;
			npc.standAnim = 12248;
			npc.walkAnim = 12246;
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.squaresNeeded = 3;
			break;
			
		case 224:
			npc.models = new int[] {97300};
			npc.name = "Great Olm";
			npc.actions = new String[5];
			npc.actions[1] = "@or2@Attack";
			npc.combatLevel = 379;
			npc.standAnim = 12248;
			npc.walkAnim = 12246;
			npc.sizeY = 100;
			npc.sizeXZ = 100;
			npc.squaresNeeded = 3;
			break;
			
		case 8779:
			npc.models = new int[] {97300};
		    npc.drawMinimapDot = false;
			npc.name = "Great Olm Pet";
			npc.actions = new String[5];
			npc.combatLevel = 379;
			npc.standAnim = 12248;
			npc.walkAnim = 12246;
			npc.sizeY = 45;
			npc.sizeXZ = 45;
			npc.squaresNeeded = 2;
			break;
			
		case 8675:
			npc.models = new int[] {97300};
			npc.name = "Custom Olm Minion";
			npc.actions = new String[5];
			npc.actions[1] = "@or2@Attack";
			npc.combatLevel = 166;
			npc.standAnim = 12248;
			npc.walkAnim = 12246;
			npc.sizeY = 100 / 2;
			npc.sizeXZ = 100 / 2;
			npc.squaresNeeded = 2;
			break;
			
		case 5469:
			npc.actions = new String[] {null, "Attack", null, null, null};
			npc.models = new int[1];
			npc.models[0] = 23141;
			npc.name = "Lucario";
			npc.description = "It's Lucario.";
			npc.standAnim = 11973;
			npc.walkAnim = 11975;
			break;
			
		case 3263:
			npc.actions = new String[] {null, "Attack", null, null, null};
			npc.models = new int[1];
			npc.models[0] = 23141;
			npc.name = "Lucario";
			npc.description = "It's Lucario.";
			npc.standAnim = 11973;
			npc.walkAnim = 11975;
			break;
			
		case 3060:
			npc.models = new int[] { 49137, 49144 };
			npc.name = "Blue dragon";
			npc.actions = new String[5];


			npc.combatLevel = 111;
			npc.standAnim = 12248;
			npc.walkAnim = 12246;
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.squaresNeeded = 2;
			break;
		case 3061:
			npc.models = new int[] { 14294, 49144 };
			npc.name = "Black dragon";
			npc.actions = new String[5];


			npc.combatLevel = 227;
			npc.standAnim = 12248;
			npc.walkAnim = 12246;
			npc.sizeY = 70;
			npc.sizeXZ = 70;
			npc.squaresNeeded = 2;
			break;
		}
		if (npc.actions != null) {
			for (int index = 0; index < npc.actions.length; index++) {
				if (npc.actions[index] != null && npc.actions[index].contains("Attack"))
					npc.actions[2] = "Show Drops";
			}
		}
		
		if (npc.actions != null) {
			for (int x = 0; x < npc.actions.length; x++) {
				if(npc.actions[x] != null && pets[x].contains(npc.actions[x])) {
				npc.actions[0] = "Talk To the pet";
				npc.actions[3] = "Pick the pet up!";
				}
		}
		}
		npc = Npc.forId(i, npc);
		return npc;
	}
	
	static String[] pets = new String[] {"Pick Up", "pick up", "Pick up", "Pick-Up", "pick-up", "Pick-up"};

	public Model getHeadModel() {
		if (childrenIDs != null) {
			NPCDef altered = getAlteredNPCDef();
			if (altered == null)
				return null;
			else
				return altered.getHeadModel();
		}
		if (npcHeadModels == null)
			return null;
		boolean everyFetched = false;
		for (int i = 0; i < npcHeadModels.length; i++)
			if (!Model.modelIsFetched(npcHeadModels[i]))
				everyFetched = true;
		if (everyFetched)
			return null;
		Model parts[] = new Model[npcHeadModels.length];
		for (int j = 0; j < npcHeadModels.length; j++)
			parts[j] = Model.fetchModel(npcHeadModels[j]);
		Model completeModel;
		if (parts.length == 1)
			completeModel = parts[0];
		else
			completeModel = new Model(parts.length, parts);
		if (originalColours != null) {
			for (int k = 0; k < originalColours.length; k++)
				completeModel.recolour(originalColours[k], destColours[k]);
		}
		return completeModel;
	}

	public NPCDef getAlteredNPCDef() {
		try {
			int j = -1;
			if (varbitId != -1) {
				VarBit varBit = VarBit.cache[varbitId];
				int k = varBit.configId;
				int l = varBit.leastSignificantBit;
				int i1 = varBit.mostSignificantBit;
				int j1 = Client.anIntArray1232[i1 - l];
				j = clientInstance.variousSettings[k] >> l & j1;
			} else if (varSettingsId != -1) {
				j = clientInstance.variousSettings[varSettingsId];
			}
			if (j < 0 || j >= childrenIDs.length || childrenIDs[j] == -1) {
				return null;
			} else {
				return forID(childrenIDs[j]);
			}
		} catch (Exception e) {
			return null;
		}
	}

	public static int NPCAMOUNT = 11599;

	public static void unpackConfig(CacheArchive streamLoader) {
		stream = new Stream(streamLoader.getDataForName("npc.dat"));
		Stream stream2 = new Stream(streamLoader.getDataForName("npc.idx"));
		int totalNPCs = stream2.readUnsignedWord();
		streamIndices = new int[totalNPCs];
		int i = 2;
		for (int j = 0; j < totalNPCs; j++) {
			streamIndices[j] = i;
			i += stream2.readUnsignedWord();
		}
		cache = new NPCDef[20];
		for (int k = 0; k < 20; k++)
			cache[k] = new NPCDef();
		// NPCDefThing2.initialize();
	}

	public static void nullLoader() {
		modelCache = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public Model getAnimatedModel(int j, int k, int ai[]) {
		if (childrenIDs != null) {
			NPCDef npc = getAlteredNPCDef();
			if (npc == null)
				return null;
			else
				return npc.getAnimatedModel(j, k, ai);
		}
		Model completedModel = (Model) modelCache.get(type);
		if (completedModel == null) {
			boolean everyModelFetched = false;
			for (int ptr = 0; ptr < models.length; ptr++)
				if (!Model.modelIsFetched(models[ptr]))
					everyModelFetched = true;

			if (everyModelFetched)
				return null;
			Model parts[] = new Model[models.length];
			for (int j1 = 0; j1 < models.length; j1++)
				parts[j1] = Model.fetchModel(models[j1]);
			if (parts.length == 1)
				completedModel = parts[0];
			else
				completedModel = new Model(parts.length, parts);
			if (originalColours != null) {
				for (int k1 = 0; k1 < originalColours.length; k1++)
					completedModel.recolour(originalColours[k1], destColours[k1]);
			}
			completedModel.createBones();
			completedModel.light(frontLight, backLight, rightLight, middleLight, leftLight, true);
			modelCache.put(completedModel, type);
		}
		Model animatedModel = Model.entityModelDesc;
		animatedModel.method464(completedModel, FrameReader.isNullFrame(k) & FrameReader.isNullFrame(j));
		convertTexture(completedModel, id);
		if (k != -1 && j != -1)
			animatedModel.method471(ai, j, k);
		else if (k != -1)
			animatedModel.applyTransform(k);
		if (sizeXZ != 128 || sizeY != 128)
			animatedModel.scaleT(sizeXZ, sizeXZ, sizeY);
		animatedModel.calculateDiagonals();
		animatedModel.triangleSkin = null;
		animatedModel.vertexSkin = null;
		if (squaresNeeded == 1)
			animatedModel.rendersWithinOneTile = true;
		return animatedModel;
	}

	public Model method164(int j, int frame, int ai[], int nextFrame, int idk, int idk2) {
		if (childrenIDs != null) {
			NPCDef npc = getAlteredNPCDef();
			if (npc == null)
				return null;
			else
				return npc.method164(j, frame, ai, nextFrame, idk, idk2);
		}
		Model completedModel = (Model) modelCache.get(type);
		if (completedModel == null) {
			boolean everyModelFetched = false;
			for (int ptr = 0; ptr < models.length; ptr++)
				if (!Model.modelIsFetched(models[ptr]))
					everyModelFetched = true;

			if (everyModelFetched)
				return null;
			Model parts[] = new Model[models.length];
			for (int j1 = 0; j1 < models.length; j1++)
				parts[j1] = Model.fetchModel(models[j1]);
			if (parts.length == 1)
				completedModel = parts[0];
			else
				completedModel = new Model(parts.length, parts);
			if (originalColours != null) {
				for (int k1 = 0; k1 < originalColours.length; k1++)
					completedModel.recolour(originalColours[k1], destColours[k1]);
			}
			convertTexture(completedModel, id);
			completedModel.createBones();
			completedModel.light(frontLight, backLight, rightLight, middleLight, leftLight, true);
			modelCache.put(completedModel, type);
		}
		Model animatedModel = Model.entityModelDesc;
		animatedModel.method464(completedModel, FrameReader.isNullFrame(frame) & FrameReader.isNullFrame(j));
		if (frame != -1 && j != -1)
			animatedModel.method471(ai, j, frame);
		else if (frame != -1 && nextFrame != -1)
			animatedModel.applyTransform(frame, nextFrame, idk, idk2);
		else if (frame != -1)
			animatedModel.applyTransform(frame);
		if (sizeXZ != 128 || sizeY != 128)
			animatedModel.scaleT(sizeXZ, sizeXZ, sizeY);
		animatedModel.calculateDiagonals();
		animatedModel.triangleSkin = null;
		animatedModel.vertexSkin = null;
		if (squaresNeeded == 1)
			animatedModel.rendersWithinOneTile = true;
		return animatedModel;
	}

	public void readValues(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1) {
				int j = stream.readUnsignedByte();
				models = new int[j];
				for (int j1 = 0; j1 < j; j1++)
					models[j1] = stream.readUnsignedWord();
			} else if (i == 2)
				name = stream.readNewString();
			else if (i == 3) {
				description = stream.readNewString();
			} else if (i == 12)
				squaresNeeded = stream.readSignedByte();
			else if (i == 13)
				standAnim = stream.readUnsignedWord();
			else if (i == 14) {
				walkAnim = stream.readUnsignedWord();
				runAnim = walkAnim;
			} else if (i == 17) {
				walkAnim = stream.readUnsignedWord();
				turn180AnimIndex = stream.readUnsignedWord();
				turn90CWAnimIndex = stream.readUnsignedWord();
				turn90CCWAnimIndex = stream.readUnsignedWord();
				if (walkAnim == 65535)
					walkAnim = -1;
				if (turn180AnimIndex == 65535)
					turn180AnimIndex = -1;
				if (turn90CWAnimIndex == 65535)
					turn90CWAnimIndex = -1;
				if (turn90CCWAnimIndex == 65535)
					turn90CCWAnimIndex = -1;
			} else if (i >= 30 && i < 40) {
				if (actions == null)
					actions = new String[5];
				actions[i - 30] = stream.readNewString();
				if (actions[i - 30].equalsIgnoreCase("hidden"))
					actions[i - 30] = null;
			} else if (i == 40) {
				int k = stream.readUnsignedByte();
				destColours = new int[k];
				originalColours = new int[k];
				for (int k1 = 0; k1 < k; k1++) {
					originalColours[k1] = stream.readUnsignedWord();
					destColours[k1] = stream.readUnsignedWord();
				}
			} else if (i == 60) {
				int l = stream.readUnsignedByte();
				npcHeadModels = new int[l];
				for (int l1 = 0; l1 < l; l1++)
					npcHeadModels[l1] = stream.readUnsignedWord();
			} else if (i == 90)
				stream.readUnsignedWord();
			else if (i == 91)
				stream.readUnsignedWord();
			else if (i == 92)
				stream.readUnsignedWord();
			else if (i == 93)
				drawMinimapDot = false;
			else if (i == 95)
				combatLevel = stream.readUnsignedWord();
			else if (i == 97)
				sizeXZ = stream.readUnsignedWord();
			else if (i == 98)
				sizeY = stream.readUnsignedWord();
			else if (i == 99)
				hasRenderPriority = true;
			else if (i == 100)
				lightning = stream.readSignedByte();
			else if (i == 101)
				shadow = stream.readSignedByte() * 5;
			else if (i == 102)
				headIcon = stream.readUnsignedWord();
			else if (i == 103)
				degreesToTurn = stream.readUnsignedWord();
			else if (i == 106) {
				varbitId = stream.readUnsignedWord();
				if (varbitId == 65535)
					varbitId = -1;
				varSettingsId = stream.readUnsignedWord();
				if (varSettingsId == 65535)
					varSettingsId = -1;
				int i1 = stream.readUnsignedByte();
				childrenIDs = new int[i1 + 1];
				for (int i2 = 0; i2 <= i1; i2++) {
					childrenIDs[i2] = stream.readUnsignedWord();
					if (childrenIDs[i2] == 65535)
						childrenIDs[i2] = -1;
				}
			} else if (i == 107)
				clickable = false;
		} while (true);
	}

	public NPCDef() {
		turn90CCWAnimIndex = -1;
		varbitId = -1;
		turn180AnimIndex = -1;
		varSettingsId = -1;
		combatLevel = -1;
		walkAnim = -1;
		squaresNeeded = 1;
		headIcon = -1;
		standAnim = -1;
		type = -1L;
		degreesToTurn = 32;
		turn90CWAnimIndex = -1;
		clickable = true;
		sizeY = 128;
		drawMinimapDot = true;
		sizeXZ = 128;
		hasRenderPriority = false;
	}
	

	@Expose public int id;
	public int turn90CCWAnimIndex;
	public static int cacheIndex;
	public int varbitId;
	public int turn180AnimIndex;
	public int varSettingsId;
	public static Stream stream;
	@Expose public int combatLevel;
	@Expose public String name;
	public String actions[];
	@Expose public int walkAnim;
	@Expose public int runAnim;
	@Expose public byte squaresNeeded;
	@Expose public int[] destColours;
	public static int[] streamIndices;
	public int[] npcHeadModels;
	@Expose public int headIcon;
	@Expose public int[] originalColours;
	@Expose public int standAnim;
	public long type;
	public int degreesToTurn;
	public static NPCDef[] cache;
	public static Client clientInstance;
	public int turn90CWAnimIndex;
	public boolean clickable;
	public int lightning;
	@Expose public int sizeY;
	@Expose public boolean drawMinimapDot;
	public int childrenIDs[];
	public String description;
	@Expose public int sizeXZ;
	public int shadow;
	@Expose public boolean hasRenderPriority;
	@Expose public int[] models;
	public static MemCache modelCache = new MemCache(30);
}
