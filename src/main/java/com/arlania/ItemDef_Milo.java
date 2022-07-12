package com.arlania;

public class ItemDef_Milo {
	public int rdc = 0;
	public int rdc2 = 0;
	public int rdc3 = 0;
	
    public static void changeTexture(int id, int currentID, int targetID) {
        ItemDef itemDef = ItemDef.forID(id);
        int[] idAtm;
        int[] idAfter;
        idAtm = itemDef.originalModelColors = new int[] { currentID };
        idAfter = itemDef.newModelColor = new int[] { targetID };
    }

    public static ItemDef recolorItem(ItemDef itemDef, int id, int[] originalColor, int[] newColor) {
        ItemDef target = ItemDef.forID(id);
        itemDef.modelID = target.modelID;
        itemDef.maleEquip1 = target.maleEquip1;
        itemDef.femaleEquip1 = target.femaleEquip1;
        itemDef.modelZoom = target.modelZoom;
        itemDef.rotationX = target.rotationX;
        itemDef.rotationY = target.rotationY;
        itemDef.modelOffset1 = target.modelOffset1;
        itemDef.modelOffsetX = target.modelOffsetX;
        itemDef.modelOffsetY = target.modelOffsetY;
        itemDef.actions = target.actions;
        itemDef.maleEquip2 = target.maleEquip2;
        itemDef.maleEquip3 = target.maleEquip3;
        itemDef.femaleEquip2 = target.femaleEquip2;
        itemDef.femaleEquip3 = target.femaleEquip3;
        itemDef.maleXOffset = target.maleXOffset;
        itemDef.maleYOffset = target.maleYOffset;
        itemDef.femaleYOffset = target.femaleYOffset;
        itemDef.maleDialogue = target.maleDialogue;
        itemDef.maleDialogueModel = target.maleDialogueModel;
        itemDef.femaleDialogueModel = target.femaleDialogueModel;
        itemDef.originalModelColors = originalColor;
        itemDef.newModelColor = newColor;
        return itemDef;
    }
        

    public static void newIDS(ItemDef itemDef, int id) {
        switch (id) {
        
        case 18665:
            itemDef.name = "Wardrobe key";
            break;
            
        case 21061:
            itemDef.modelID = 16382;
            itemDef.maleEquip1 = 16383;
            itemDef.femaleEquip1 = 16383;
            itemDef.name = "@red@Blood Pickaxe";
            changeTexture(id, 40, 83);
            ItemDef.copyMostDefs(itemDef, 1267);
    		itemDef.modelOffset1 = itemDef.modelOffset1;
    		itemDef.modelOffsetY = itemDef.modelOffsetY;
    		itemDef.modelZoom = itemDef.modelZoom;
    		itemDef.rotationX = itemDef.rotationX;
    		itemDef.rotationY = itemDef.rotationY;
            break;
            
        case 21060:
            itemDef.modelID = 16381;
            itemDef.name = "@red@Blood Ore";
            changeTexture(id, 40, 83);
            ItemDef.copyMostDefs(itemDef, 440);
    		itemDef.modelOffset1 = itemDef.modelOffset1;
    		itemDef.modelOffsetY = itemDef.modelOffsetY;
    		itemDef.modelZoom = itemDef.modelZoom;
    		itemDef.rotationX = itemDef.rotationX;
    		itemDef.rotationY = itemDef.rotationY;
            break;
        
        case 21054:
            itemDef.name = "@red@Blood slayer Voucher";
            ItemDef.copyModel(itemDef, 5606);
            break;
            
        case 21056:
            itemDef.name = "@red@Rudolph pet";
            itemDef.modelID = 58886;
            itemDef.modelZoom = 2000;
           // itemDef.rotationY = 340;
            itemDef.rotationX = 0;
            itemDef.groundActions = new String[] { null, null, "Take", null, null };
            itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
            break;
            
        case 21055:
            itemDef.name = "@cya@Frozen scroll";
            itemDef.modelID = 10711;
            changeTexture(id, 40, 51);
            itemDef.animateInventory = true;
            ItemDef.copyMostDefs(itemDef, 6949);
    		itemDef.modelOffset1 = itemDef.modelOffset1;
    		itemDef.modelOffsetY = itemDef.modelOffsetY;
    		itemDef.modelZoom = 1050;
    		itemDef.rotationX = itemDef.rotationX;
    		itemDef.rotationY = itemDef.rotationY;
            itemDef.actions = new String[5];
            itemDef.actions[0] = "Redeem";
            itemDef.actions[1] = null;
            itemDef.actions[2] = null;
            itemDef.actions[3] = null;
            break;
        
        case 21049:
            itemDef.name = "@red@Grinch pet (red)";
            itemDef.modelID = 72051;
            itemDef.modelZoom = 1000;
           // itemDef.rotationY = 340;
            itemDef.rotationX = 0;
            itemDef.groundActions = new String[] { null, null, "Take", null, null };
            itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
            break;
            
        case 21050:
            itemDef.name = "@blu@Grinch pet (blue)";
            itemDef.modelID = 72058;
            itemDef.modelZoom = 1000;
            //itemDef.rotationY = 340;
            itemDef.rotationX = 0;
            itemDef.groundActions = new String[] { null, null, "Take", null, null };
            itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
            break;
        
        case 21051:
            itemDef.name = "@gre@Grinch pet (green)";
            itemDef.modelID = 72056;
            itemDef.modelZoom = 1000;
            itemDef.rotationY = 420;
            itemDef.rotationX = 0;
            itemDef.groundActions = new String[] { null, null, "Take", null, null };
            itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
            break;
            
        case 21048:
            itemDef.name = "@re1@Potente's Owner staff";
            changeTexture(id, 40, 88);
            itemDef.modelZoom = 2000;
            ItemDef.copyModel(itemDef, 17009);
            itemDef.modelID = 47023;
            itemDef.maleEquip1 = 47024;
            itemDef.femaleEquip1 = 47024;
            itemDef.actions = new String[] {null, "Wear", null, null, "Drop"};
            itemDef.stackable = false;
            break;
            
        case 21053:
            itemDef.name = "@red@Xmas @gre@Scimitar";
            itemDef.modelZoom = 2500;
            ItemDef.copyModel(itemDef, 1321);
            itemDef.modelID = 72063;
            itemDef.maleEquip1 = 72062;
            itemDef.femaleEquip1 = 72062;
            itemDef.actions = new String[] {null, "Wear", null, null, "Drop"};
            itemDef.stackable = false;
            break;
            
        case 21029:
            ItemDef.copyMostDefs(itemDef, 20582);
            itemDef.modelID = 58190;
            itemDef.modelZoom = 711; 
            itemDef.modelOffsetX = 3;
            itemDef.name = "@or1@Super Saiyan Complete set";
            break;
            
        case 21052:
            itemDef.name = "@red@Xmas @gre@Mystery @red@box";
            itemDef.modelID = 42073;//55380
            changeTexture(id, 40, 59);
            itemDef.animateInventory = true;
            itemDef.actions = new String[5];
            ItemDef.copyMostDefs(itemDef, 6183);
    		itemDef.modelOffset1 = itemDef.modelOffset1;
    		itemDef.modelOffsetY = itemDef.modelOffsetY;
    		itemDef.modelZoom = 1050;
    		itemDef.rotationX = itemDef.rotationX;
    		itemDef.rotationY = itemDef.rotationY;
            itemDef.actions[0] = "Open";
            itemDef.actions[1] = null;
            itemDef.actions[2] = null;
            itemDef.actions[3] = null;
            break;
            
        
    case 15003:
        itemDef.name = "@yel@Beginner Mystery Box";
        itemDef.modelID = 42089;//55380
        changeTexture(id, 40, 56);
        itemDef.animateInventory = true;
        itemDef.actions = new String[5];
        ItemDef.copyMostDefs(itemDef, 6183);
		itemDef.modelOffset1 = itemDef.modelOffset1;
		itemDef.modelOffsetY = itemDef.modelOffsetY;
		itemDef.modelZoom = 1050;
		itemDef.rotationX = itemDef.rotationX;
		itemDef.rotationY = itemDef.rotationY;
        itemDef.actions[0] = "Open";
        itemDef.actions[1] = null;
        itemDef.actions[2] = null;
        itemDef.actions[3] = null;
        break;
        
    case 21028:
        itemDef.name = "@re1@Exorbitant Mystery box";
        itemDef.modelID = 42081;//55380
        changeTexture(id, 40, 81);
        itemDef.animateInventory = true;
        itemDef.actions = new String[5];
        ItemDef.copyMostDefs(itemDef, 6183);
		itemDef.modelOffset1 = itemDef.modelOffset1;
		itemDef.modelOffsetY = itemDef.modelOffsetY;
		itemDef.modelZoom = 1050;
		itemDef.rotationX = itemDef.rotationX;
		itemDef.rotationY = itemDef.rotationY;
        itemDef.actions[0] = "Open";
        itemDef.actions[1] = null;
        itemDef.actions[2] = null;
        itemDef.actions[3] = null;
        break;
        
    case 15373:
        itemDef.name = "@enc@Newbie Mystery box";
        itemDef.modelID = 42082;//55380
        changeTexture(id, 40, 82);
        itemDef.animateInventory = true;
        itemDef.actions = new String[5];
        ItemDef.copyMostDefs(itemDef, 6183);
		itemDef.modelOffset1 = itemDef.modelOffset1;
		itemDef.modelOffsetY = itemDef.modelOffsetY;
		itemDef.modelZoom = 1050;
		itemDef.rotationX = itemDef.rotationX;
		itemDef.rotationY = itemDef.rotationY;
        itemDef.actions[0] = "Open";
        itemDef.actions[1] = null;
        itemDef.actions[2] = null;
        itemDef.actions[3] = null;
        break;
        
    case 6199:
        itemDef.name = "@cya@Gracious Mystery box";
        itemDef.modelID = 42083;//55380
        changeTexture(id, 40, 51);
        itemDef.animateInventory = true;
        itemDef.actions = new String[5];
        ItemDef.copyMostDefs(itemDef, 6183);
		itemDef.modelOffset1 = itemDef.modelOffset1;
		itemDef.modelOffsetY = itemDef.modelOffsetY;
		itemDef.modelZoom = 1050;
		itemDef.rotationX = itemDef.rotationX;
		itemDef.rotationY = itemDef.rotationY;
        itemDef.actions[0] = "Open";
        itemDef.actions[1] = null;
        itemDef.actions[2] = null;
        itemDef.actions[3] = null;
        break;
        
    case 3988:
        itemDef.name = "@gre@Pleasant Mystery box";
        itemDef.modelID = 42084;//55380
        changeTexture(id, 40, 58);
        itemDef.animateInventory = true;
        itemDef.actions = new String[5];
        ItemDef.copyMostDefs(itemDef, 6183);
		itemDef.modelOffset1 = itemDef.modelOffset1;
		itemDef.modelOffsetY = itemDef.modelOffsetY;
		itemDef.modelZoom = 1050;
		itemDef.rotationX = itemDef.rotationX;
		itemDef.rotationY = itemDef.rotationY;
        itemDef.actions[0] = "Open";
        itemDef.actions[1] = null;
        itemDef.actions[2] = null;
        itemDef.actions[3] = null;
        break;
        
    case 15374:
        itemDef.name = "@red@Elemental Mystery box";
        itemDef.modelID = 42085;//55380
        changeTexture(id, 40, 59);
        itemDef.animateInventory = true;
        itemDef.actions = new String[5];
        ItemDef.copyMostDefs(itemDef, 6183);
		itemDef.modelOffset1 = itemDef.modelOffset1;
		itemDef.modelOffsetY = itemDef.modelOffsetY;
		itemDef.modelZoom = 1050;
		itemDef.rotationX = itemDef.rotationX;
		itemDef.rotationY = itemDef.rotationY;
        itemDef.actions[0] = "Open";
        itemDef.actions[1] = null;
        itemDef.actions[2] = null;
        itemDef.actions[3] = null;
        break;
        
    case 13997:
        itemDef.name = "@bla@Regal Mystery box";
        itemDef.modelID = 42086;//55380
        changeTexture(id, 40, 57);
        itemDef.animateInventory = true;
        itemDef.actions = new String[5];
        ItemDef.copyMostDefs(itemDef, 6183);
		itemDef.modelOffset1 = itemDef.modelOffset1;
		itemDef.modelOffsetY = itemDef.modelOffsetY;
		itemDef.modelZoom = 1050;
		itemDef.rotationX = itemDef.rotationX;
		itemDef.rotationY = itemDef.rotationY;
        itemDef.actions[0] = "Open";
        itemDef.actions[1] = null;
        itemDef.actions[2] = null;
        itemDef.actions[3] = null;
        break;
        
    case 10168:
        itemDef.name = "@red@Owners Mystery box";
        itemDef.modelID = 42087;//55380
        changeTexture(id, 40, 83);
        itemDef.animateInventory = true;
        itemDef.actions = new String[5];
        ItemDef.copyMostDefs(itemDef, 6183);
		itemDef.modelOffset1 = itemDef.modelOffset1;
		itemDef.modelOffsetY = itemDef.modelOffsetY;
		itemDef.modelZoom = 1050;
		itemDef.rotationX = itemDef.rotationX;
		itemDef.rotationY = itemDef.rotationY;
        itemDef.actions[0] = "Open";
        itemDef.actions[1] = null;
        itemDef.actions[2] = null;
        itemDef.actions[3] = null;
        break;
        
    case 15521:
        itemDef.name = "@blu@Marvelous Mystery box";
        itemDef.modelID = 42088;//55380
        changeTexture(id, 40, 53);
        itemDef.animateInventory = true;
        itemDef.actions = new String[5];
        ItemDef.copyMostDefs(itemDef, 6183);
		itemDef.modelOffset1 = itemDef.modelOffset1;
		itemDef.modelOffsetY = itemDef.modelOffsetY;
		itemDef.modelZoom = 1050;
		itemDef.rotationX = itemDef.rotationX;
		itemDef.rotationY = itemDef.rotationY;
        itemDef.actions[0] = "Open";
        itemDef.actions[1] = null;
        itemDef.actions[2] = null;
        itemDef.actions[3] = null;
        break;
        
        case 6639:
            itemDef.modelID = 58189;
            itemDef.modelZoom = 1500;
			itemDef.untradeable = true;
            itemDef.name = "@re1@Mini-me pet";
            itemDef.actions = new String[] {"@yel@Summon", null, "@mag@Configure", "@red@Dismiss", null};
            break;
        
		case 21030:
			itemDef.name = "@cya@Galactic OP Shield"; //1163,1127,1079,13000,4131,
            ItemDef.copyMostDefs(itemDef, 8736);
            itemDef.modelID = 74815;
            itemDef.maleEquip1 = 74816;
            itemDef.femaleEquip1 = 74816;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@whi@Charge";
            itemDef.actions[4] = "Drop";
			break;
            
		case 21023:
			itemDef.name = "@whi@Krampus Demon Helmet"; //1163,1127,1079,13000,4131,
            itemDef.modelZoom = 1100;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -180;
            itemDef.modelID = 72071;
            itemDef.maleEquip1 = 72071;
            itemDef.femaleEquip1 = 72071;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21024:
			itemDef.name = "@whi@Krampus Demon Platebody";
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.modelID = 72065;
            itemDef.maleEquip1 = 72065;
            itemDef.femaleEquip1 = 72065;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21025:
			itemDef.name = "@whi@Krampus Demon Platelegs";
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 20;
            itemDef.modelID = 72066;
            itemDef.maleEquip1 = 72066;
            itemDef.femaleEquip1 = 72066;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21026:
			itemDef.name = "@whi@Krampus Demon Boots";
            itemDef.modelZoom = 774;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 0;
            itemDef.modelID = 72068;
            itemDef.maleEquip1 = 72068;
            itemDef.femaleEquip1 = 72068;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21027:
			itemDef.name = "@whi@Krampus Demon Gloves";
            itemDef.modelZoom = 1035;
            itemDef.rotationX = 1643;
            itemDef.rotationY = 78;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.modelID = 72067;
            itemDef.maleEquip1 = 72067;
            itemDef.femaleEquip1 = 72067;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21057:
			itemDef.name = "@whi@Krampus Demon Whip";
            itemDef.modelZoom = 1296;
            itemDef.rotationX = 420;
            itemDef.rotationY = 26;
			itemDef.modelOffsetY = 25;
  			itemDef.modelOffset1 = 0;
            itemDef.modelID = 72069;
            itemDef.maleEquip1 = 72069;
            itemDef.femaleEquip1 = 72069;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
        
		case 21058:
			itemDef.name = "@whi@Krampus Demon Wings";
            itemDef.modelZoom = 3000;
            itemDef.rotationX = 1100;
            itemDef.rotationY = 0;
            itemDef.modelOffsetY = 0;
            itemDef.modelOffset1 = 0;
            itemDef.modelID = 72070;
            itemDef.maleEquip1 = 72070;
            itemDef.femaleEquip1 = 72070;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21034:
			itemDef.name = "@whi@Enchanted Blood Helmet"; //1163,1127,1079,13000,4131,
            ItemDef.copyMostDefs(itemDef, 1163);
            itemDef.modelID = 74839;
            itemDef.maleEquip1 = 74840;
            itemDef.femaleEquip1 = 74840;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21035:
			itemDef.name = "@whi@Enchanted Blood Platebody";
            ItemDef.copyMostDefs(itemDef, 1127);
            itemDef.modelID = 74833;
            itemDef.maleEquip1 = 74834;
            itemDef.femaleEquip1 = 74834;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21036:
			itemDef.name = "@whi@Enchanted Blood Platelegs";
            ItemDef.copyMostDefs(itemDef, 1079);
            itemDef.modelID = 74841;
            itemDef.maleEquip1 = 74842;
            itemDef.femaleEquip1 = 74842;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21037:
			itemDef.name = "@whi@Enchanted Blood Boots";
            ItemDef.copyMostDefs(itemDef, 4131);
            itemDef.modelID = 74835;
            itemDef.maleEquip1 = 74835;
            itemDef.femaleEquip1 = 74835;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21038:
			itemDef.name = "@whi@Enchanted Blood Gloves";
            ItemDef.copyMostDefs(itemDef, 13000);
            itemDef.modelID = 74837;
            itemDef.maleEquip1 = 74838;
            itemDef.femaleEquip1 = 74838;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21039:
			itemDef.name = "@whi@Enchanted Blood Trident";
            ItemDef.copyMostDefs(itemDef, 50);
            itemDef.modelID = 74843;
            itemDef.maleEquip1 = 74844;
            itemDef.femaleEquip1 = 74844;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21040:
			itemDef.name = "@whi@Enchanted Blood Aura";
            ItemDef.copyMostDefs(itemDef, 3893);
            itemDef.modelZoom = 3000;
            itemDef.modelID = 74831;
            itemDef.maleEquip1 = 74832;
            itemDef.femaleEquip1 = 74832;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21042:
			itemDef.name = "@whi@Grand Marshall Helmet"; //1163,1127,1079,13000,4131,
            itemDef.modelID = 74845;
            itemDef.maleEquip1 = 74845;
            itemDef.femaleEquip1 = 74845;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1100;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -180;
			break;
			
		case 21043:
			itemDef.name = "@whi@Grand Marshall Platebody";
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.modelID = 74846;
            itemDef.maleEquip1 = 74846;
            itemDef.femaleEquip1 = 74846;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21044:
			itemDef.name = "@whi@Grand Marshall Platelegs";
            ItemDef.copyMostDefs(itemDef, 1079);
            itemDef.modelID = 74847;
            itemDef.maleEquip1 = 74847;
            itemDef.femaleEquip1 = 74847;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21045:
			itemDef.name = "@whi@Grand Marshall Boots";
            ItemDef.copyMostDefs(itemDef, 4131);
            itemDef.modelID = 74848;
            itemDef.maleEquip1 = 74848;
            itemDef.femaleEquip1 = 74848;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21046:
			itemDef.name = "@whi@Grand Marshall Gloves";
            ItemDef.copyMostDefs(itemDef, 13000);
            itemDef.modelID = 74849;
            itemDef.maleEquip1 = 74849;
            itemDef.femaleEquip1 = 74849;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21047:
			itemDef.name = "@whi@Grand Marshall Cape";
            ItemDef.copyMostDefs(itemDef, 50);
            itemDef.modelID = 74850;
            itemDef.maleEquip1 = 74850;
            itemDef.femaleEquip1 = 74850;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21006:
			itemDef.name = "@whi@Esdeath Helmet"; //1163,1127,1079,13000,4131,
            ItemDef.copyMostDefs(itemDef, 1163);
            itemDef.modelID = 74779;
            itemDef.maleEquip1 = 74780;
            itemDef.femaleEquip1 = 74780;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21007:
			itemDef.name = "@whi@Esdeath Platebody";
            ItemDef.copyMostDefs(itemDef, 1127);
            itemDef.modelID = 74781;
            itemDef.maleEquip1 = 74782;
            itemDef.femaleEquip1 = 74782;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21008:
			itemDef.name = "@whi@Esdeath Platelegs";
            ItemDef.copyMostDefs(itemDef, 1079);
            itemDef.modelID = 74783;
            itemDef.maleEquip1 = 74784;
            itemDef.femaleEquip1 = 74784;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21009:
			itemDef.name = "@whi@Esdeath Boots";
            ItemDef.copyMostDefs(itemDef, 4131);
            itemDef.modelID = 74787;
            itemDef.maleEquip1 = 74787;
            itemDef.femaleEquip1 = 74787;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21010:
			itemDef.name = "@whi@Esdeath Gloves";
            ItemDef.copyMostDefs(itemDef, 13000);
            itemDef.modelID = 74785;
            itemDef.maleEquip1 = 74786;
            itemDef.femaleEquip1 = 74786;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21011:
			itemDef.name = "@whi@Esdeath Bow";
            ItemDef.copyMostDefs(itemDef, 50);
            itemDef.modelID = 74793;
            itemDef.maleEquip1 = 74792;
            itemDef.femaleEquip1 = 74792;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21012:
			itemDef.name = "@whi@Esdeath Aura";
            ItemDef.copyMostDefs(itemDef, 3893);
            itemDef.modelZoom = 3000;
            itemDef.modelID = 74791;
            itemDef.maleEquip1 = 74791;
            itemDef.femaleEquip1 = 74791;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21013:
			itemDef.name = "@whi@Esdeath Cape";
            ItemDef.copyMostDefs(itemDef, 9792);
            itemDef.modelID = 74788;
            itemDef.maleEquip1 = 74789;
            itemDef.femaleEquip1 = 74789;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
        
		case 21014:
			itemDef.name = "@whi@Jing Wei Aura";
            ItemDef.copyMostDefs(itemDef, 3893);
            itemDef.modelZoom = 3000;
            itemDef.modelID = 74794;
            itemDef.maleEquip1 = 74794;
            itemDef.femaleEquip1 = 74794;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21016:
			itemDef.name = "@whi@Thanatos Aura";
            ItemDef.copyMostDefs(itemDef, 3893);
            itemDef.modelZoom = 3000;
            itemDef.modelID = 74796;
            itemDef.maleEquip1 = 74796;
            itemDef.femaleEquip1 = 74796;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21017:
			itemDef.name = "@whi@Artemis Aura";
            ItemDef.copyMostDefs(itemDef, 3893);
            itemDef.modelZoom = 3000;
            itemDef.modelID = 74797;
            itemDef.maleEquip1 = 74797;
            itemDef.femaleEquip1 = 74797;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
        
		case 21018:
			itemDef.name = "@whi@Poseidon Aura";
            ItemDef.copyMostDefs(itemDef, 3893);
            itemDef.modelZoom = 3000;
            itemDef.modelID = 74798;
            itemDef.maleEquip1 = 74798;
            itemDef.femaleEquip1 = 74798;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21019:
			itemDef.name = "@whi@Morrigan Pale Aura";
            ItemDef.copyMostDefs(itemDef, 3893);
            itemDef.modelZoom = 3000;
            itemDef.modelID = 74799;
            itemDef.maleEquip1 = 74799;
            itemDef.femaleEquip1 = 74799;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
			
		case 21020:
			itemDef.name = "@whi@Nemisis Aura";
            ItemDef.copyMostDefs(itemDef, 3893);
            itemDef.modelZoom = 3000;
            itemDef.modelID = 74800;
            itemDef.maleEquip1 = 74800;
            itemDef.femaleEquip1 = 74800;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
			
		case 21015:
			itemDef.name = "@mag@Femboy's Aura";
            ItemDef.copyMostDefs(itemDef, 3893);
            changeTexture(id, 51, 55);
            itemDef.modelZoom = 3000;
            itemDef.modelID = 74791;
            itemDef.maleEquip1 = 74791;
            itemDef.femaleEquip1 = 74791;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
        
		case 20998:
			itemDef.name = "@whi@Thanatos Helmet";
            itemDef.modelID = 74772;
            itemDef.maleEquip1 = 74772;
            itemDef.femaleEquip1 = 74772;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1100;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -180;
			break;
			
		case 20999:
			itemDef.name = "@whi@Thanatos Platebody";
            itemDef.modelID = 74773;
            itemDef.maleEquip1 = 74773;
            itemDef.femaleEquip1 = 74773;
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 21000:
			itemDef.name = "@whi@Thanatos Platelegs";
            itemDef.modelID = 74774;
            itemDef.maleEquip1 = 74774;
            itemDef.femaleEquip1 = 74774;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 30;
			break;
		case 21001:
			itemDef.name = "@whi@Thanatos Boots";
            itemDef.modelID = 74775;
            itemDef.maleEquip1 = 74775;
            itemDef.femaleEquip1 = 74775;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 774;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 0;
			break;
		case 21002:
			itemDef.name = "@whi@Thanatos Gloves";
            itemDef.modelZoom = 1035;
            itemDef.rotationX = 1643;
            itemDef.rotationY = 78;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.modelID = 74776;
            itemDef.maleEquip1 = 74776;
            itemDef.femaleEquip1 = 74776;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 21003:
			itemDef.name = "@whi@Thanatos Scythe";
            itemDef.modelZoom = 1296;
            itemDef.rotationX = 791;
            itemDef.rotationY = 26;
			itemDef.modelOffsetY = 25;
  			itemDef.modelOffset1 = 0;
            itemDef.modelID = 74777;
            itemDef.maleEquip1 = 74777;
            itemDef.femaleEquip1 = 74777;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 21004:
			itemDef.name = "@whi@Thanatos Wings";
            ItemDef.copyMostDefs(itemDef, 9792);
            itemDef.modelID = 74778;
            itemDef.maleEquip1 = 74778;
            itemDef.femaleEquip1 = 74778;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
        
        
		case 20990:
			itemDef.name = "@whi@Jing Wei Helmet";
            itemDef.modelID = 74764;
            itemDef.maleEquip1 = 74764;
            itemDef.femaleEquip1 = 74764;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1100;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -180;
			break;
			
		case 20991:
			itemDef.name = "@whi@Jing Wei Platebody";
            itemDef.modelID = 74765;
            itemDef.maleEquip1 = 74765;
            itemDef.femaleEquip1 = 74765;
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20992:
			itemDef.name = "@whi@Jing Wei Platelegs";
            itemDef.modelID = 74766;
            itemDef.maleEquip1 = 74766;
            itemDef.femaleEquip1 = 74766;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 30;
			break;
			
		case 20993:
			itemDef.name = "@whi@Jing Wei Boots";
            itemDef.modelID = 74767;
            itemDef.maleEquip1 = 74767;
            itemDef.femaleEquip1 = 74767;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 774;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 0;
			break;
			
		case 20994:
			itemDef.name = "@whi@Jing Wei Gloves";
            itemDef.modelZoom = 1035;
            itemDef.rotationX = 1643;
            itemDef.rotationY = 78;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.modelID = 74768;
            itemDef.maleEquip1 = 74768;
            itemDef.femaleEquip1 = 74768;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20995:
			itemDef.name = "@whi@Jing Wei Bow";
            itemDef.modelZoom = 1296;
            itemDef.rotationX = 791;
            itemDef.rotationY = 26;
			itemDef.modelOffsetY = 25;
  			itemDef.modelOffset1 = 0;
            itemDef.modelID = 74769;
            itemDef.maleEquip1 = 74769;
            itemDef.femaleEquip1 = 74769;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20996:
			itemDef.name = "@whi@Jing Wei Cape";
            ItemDef.copyMostDefs(itemDef, 9792);
            itemDef.modelID = 74770;
            itemDef.maleEquip1 = 74770;
            itemDef.femaleEquip1 = 74770;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21021:
			itemDef.name = "@whi@Nemisis Cape";
            ItemDef.copyMostDefs(itemDef, 9792);
            itemDef.modelZoom = 1000;
            itemDef.modelID = 74802;
            itemDef.maleEquip1 = 74802;
            itemDef.femaleEquip1 = 74802;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20997:
			itemDef.name = "@whi@Jing Wei Offhand";
            ItemDef.copyMostDefs(itemDef, 1201);
            itemDef.modelID = 74771;
            itemDef.maleEquip1 = 74771;
            itemDef.femaleEquip1 = 74771;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;

		case 20981:
			itemDef.name = "@whi@Artemis Helmet";
            itemDef.modelID = 74754;
            itemDef.maleEquip1 = 74754;
            itemDef.femaleEquip1 = 74754;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1100;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -180;
			break;
			
		case 20982:
			itemDef.name = "@whi@Artemis Platebody";
            itemDef.modelID = 74756;
            itemDef.maleEquip1 = 74756;
            itemDef.femaleEquip1 = 74756;
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20983:
			itemDef.name = "@whi@Artemis Platelegs";
            itemDef.modelID = 74757;
            itemDef.maleEquip1 = 74757;
            itemDef.femaleEquip1 = 74757;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 30;
			break;
			
		case 20984:
			itemDef.name = "@whi@Artemis Boots";
            itemDef.modelID = 74758;
            itemDef.maleEquip1 = 74758;
            itemDef.femaleEquip1 = 74758;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 774;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 0;
			break;
			
		case 20985:
			itemDef.name = "@whi@Artemis Gloves";
            itemDef.modelZoom = 1035;
            itemDef.rotationX = 1643;
            itemDef.rotationY = 78;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.modelID = 74759;
            itemDef.maleEquip1 = 74759;
            itemDef.femaleEquip1 = 74759;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20986:
			itemDef.name = "@whi@Artemis Bow";
            itemDef.modelZoom = 1296;
            itemDef.rotationX = 791;
            itemDef.rotationY = 26;
			itemDef.modelOffsetY = 25;
  			itemDef.modelOffset1 = 0;
            itemDef.modelID = 74760;
            itemDef.maleEquip1 = 74760;
            itemDef.femaleEquip1 = 74760;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20987:
			itemDef.name = "@whi@Artemis Cape";
            ItemDef.copyMostDefs(itemDef, 9792);
            itemDef.modelID = 74761;
            itemDef.maleEquip1 = 74761;
            itemDef.femaleEquip1 = 74761;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 10136:
			itemDef.name = "@yel@Legendary @re1@Fish";
 			itemDef.actions[0] = "Eat";
			break;
        
		case 20974:
			itemDef.name = "@whi@Poseidons Helmet";
            itemDef.modelID = 74747;
            itemDef.maleEquip1 = 74747;
            itemDef.femaleEquip1 = 74747;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1100;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -180;
			break;
			
		case 20975:
			itemDef.name = "@whi@Poseidons Platebody";
            itemDef.modelID = 74748;
            itemDef.maleEquip1 = 74748;
            itemDef.femaleEquip1 = 74748;
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20976:
			itemDef.name = "@whi@Poseidons Platelegs";
            itemDef.modelID = 74749;
            itemDef.maleEquip1 = 74749;
            itemDef.femaleEquip1 = 74749;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 30;
			break;
			
		case 20977:
			itemDef.name = "@whi@Poseidons Boots";
            itemDef.modelID = 74750;
            itemDef.maleEquip1 = 74750;
            itemDef.femaleEquip1 = 74750;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 774;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 0;
			break;
			
		case 20978:
			itemDef.name = "@whi@Poseidons Gloves";
            itemDef.modelZoom = 1035;
            itemDef.rotationX = 1643;
            itemDef.rotationY = 78;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.modelID = 74751;
            itemDef.maleEquip1 = 74751;
            itemDef.femaleEquip1 = 74751;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20979:
			itemDef.name = "@whi@Poseidons Trident";
            itemDef.modelZoom = 1296;
            itemDef.rotationX = 791;
            itemDef.rotationY = 26;
			itemDef.modelOffsetY = 25;
  			itemDef.modelOffset1 = 0;
            itemDef.modelID = 74752;
            itemDef.maleEquip1 = 74752;
            itemDef.femaleEquip1 = 74752;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20980:
			itemDef.name = "@whi@Poseidons Cape";
            ItemDef.copyMostDefs(itemDef, 9792);
            itemDef.modelID = 74753;
            itemDef.maleEquip1 = 74753;
            itemDef.femaleEquip1 = 74753;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;

		case 20968:
			itemDef.name = "@re1@Nemisis Helmet";
            itemDef.modelID = 74741;
            itemDef.maleEquip1 = 74741;
            itemDef.femaleEquip1 = 74741;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1100;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -180;
			break;
			
		case 20969:
			itemDef.name = "@re1@Nemisis Platebody";
            itemDef.modelID = 74742;
            itemDef.maleEquip1 = 74742;
            itemDef.femaleEquip1 = 74742;
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20970:
			itemDef.name = "@re1@Nemisis Platelegs";
            itemDef.modelID = 74743;
            itemDef.maleEquip1 = 74743;
            itemDef.femaleEquip1 = 74743;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 30;
			break;
			
		case 20971:
			itemDef.name = "@re1@Nemisis Boots";
            itemDef.modelID = 74744;
            itemDef.maleEquip1 = 74744;
            itemDef.femaleEquip1 = 74744;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 774;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 0;
			break;
			
		case 20972:
			itemDef.name = "@re1@Nemisis Gloves";
            itemDef.modelZoom = 1035;
            itemDef.rotationX = 1643;
            itemDef.rotationY = 78;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.modelID = 74745;
            itemDef.maleEquip1 = 74745;
            itemDef.femaleEquip1 = 74745;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20973:
			itemDef.name = "@re1@Nemisis Blade";
            itemDef.modelZoom = 1296;
            itemDef.rotationX = 791;
            itemDef.rotationY = 26;
			itemDef.modelOffsetY = 25;
  			itemDef.modelOffset1 = 0;
            itemDef.modelID = 74746;
            itemDef.maleEquip1 = 74746;
            itemDef.femaleEquip1 = 74746;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;

        case 5219:
            itemDef.name = "Byakuya Blade";
            itemDef.modelID = 44427;
            itemDef.maleEquip1 = 44427;
            itemDef.femaleEquip1 = 44427;
            itemDef.modelZoom = 2287;
            itemDef.rotationX = 784;
            itemDef.rotationY = 839;
			itemDef.modelOffsetY = 12;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.stackable = false;
            break;
        case 5220:
            itemDef.name = "Byakuya Blade (OH)";
            itemDef.modelID = 44428;
            itemDef.maleEquip1 = 44428;
            itemDef.femaleEquip1 = 44428;
            itemDef.modelZoom = 2287;
            itemDef.rotationX = 784;
            itemDef.rotationY = 839;
			itemDef.modelOffsetY = 12;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.stackable = false;
            break;
        case 5221:
            itemDef.name = "Byakuya Boots";
            itemDef.modelID = 44429;
            itemDef.maleEquip1 = 44429;
            itemDef.femaleEquip1 = 44429;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 774;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 0;
            itemDef.stackable = false;
            break;
        case 5222:
            itemDef.name = "Byakuya Gloves";
            itemDef.modelID = 44431;
            itemDef.maleEquip1 = 44431;
            itemDef.femaleEquip1 = 44431;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1035;
            itemDef.rotationX = 1643;
            itemDef.rotationY = 78;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.stackable = false;
            break;
        case 5223:
            itemDef.name = "Byakuya Facemask";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 760;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 82;
            itemDef.modelID = 44432;
            itemDef.maleEquip1 = 44432;
            itemDef.femaleEquip1 = 44432;
            itemDef.stackable = false;
            break;
        case 5224:
            itemDef.name = "Byakuya Legs";
            itemDef.modelID = 44433;
            itemDef.maleEquip1 = 44433;
            itemDef.femaleEquip1 = 44433;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 30;
            itemDef.stackable = false;
            break;
        case 5225:
            itemDef.name = "Byakuya Body";
            itemDef.modelID = 44434;
            itemDef.maleEquip1 = 44434;
            itemDef.femaleEquip1 = 44434;
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.stackable = false;
            break; 
            
		case 20961:
			itemDef.name = "@yel@Morrigan Pale Helmet";
            itemDef.modelID = 74730;
            itemDef.maleEquip1 = 74730;
            itemDef.femaleEquip1 = 74730;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1100;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -180;
			break;
			
		case 20962:
			itemDef.name = "@yel@Morrigan Pale Platebody";
            itemDef.modelID = 74731;
            itemDef.maleEquip1 = 74731;
            itemDef.femaleEquip1 = 74731;
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20963:
			itemDef.name = "@yel@Morrigan Pale Platelegs";
            itemDef.modelID = 74732;
            itemDef.maleEquip1 = 74732;
            itemDef.femaleEquip1 = 74732;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1348;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 30;
			break;
			
		case 20964:
			itemDef.name = "@yel@Morrigan Pale Boots";
            itemDef.modelID = 74733;
            itemDef.maleEquip1 = 74733;
            itemDef.femaleEquip1 = 74733;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 774;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 0;
			break;
			
		case 20965:
			itemDef.name = "@yel@Morrigan Pale Gloves";
            itemDef.modelZoom = 1035;
            itemDef.rotationX = 1643;
            itemDef.rotationY = 78;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 50;
            itemDef.modelID = 74734;
            itemDef.maleEquip1 = 74734;
            itemDef.femaleEquip1 = 74734;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20966:
			itemDef.name = "@yel@Morrigan Pale Staff";
            itemDef.modelZoom = 1296;
            itemDef.rotationX = 791;
            itemDef.rotationY = 26;
			itemDef.modelOffsetY = 25;
  			itemDef.modelOffset1 = 0;
            itemDef.modelID = 74735;
            itemDef.maleEquip1 = 74735;
            itemDef.femaleEquip1 = 74735;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;

		case 20967:
            ItemDef.copyMostDefs(itemDef, 9792);
			itemDef.name = "@yel@Morrigan Pale Cape";
            itemDef.modelID = 74736;
            itemDef.maleEquip1 = 74736;
            itemDef.femaleEquip1 = 74736;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;

        case 20960:
            itemDef.name = "Ninja's Custom Dragon";
            itemDef.modelID = 74729;
            itemDef.groundActions = new String[] { null, null, "Take", null, null };
            itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
            break;
            
        case 3895:
            itemDef.name = "@re1@Zen-OH Pet";
            itemDef.modelID = 74677;
            itemDef.modelZoom = 3000;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
            itemDef.groundActions = new String[] { null, null, "Take", null, null };
            itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
            break;
        
        case 3893:
            itemDef.name = "@cya@Blue eyes white dragon Pet";
            itemDef.modelID = 74518;
            itemDef.modelZoom = 1750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
            itemDef.groundActions = new String[] { null, null, "Take", null, null };
            itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
            break;
            
		case 20944:
			itemDef.name = "@yel@Golden Kidbuu Helmet";
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74681;
            itemDef.maleEquip1 = 74680;
            itemDef.femaleEquip1 = 74680;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20945:
			itemDef.name = "@yel@Golden Kidbuu Platebody";
            ItemDef.copyMostDefs(itemDef, 1127); //1163,1127,1079,13000,4131,
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74683;
            itemDef.maleEquip1 = 74682;
            itemDef.femaleEquip1 = 74682;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20946:
			itemDef.name = "@yel@Golden Kidbuu Platelegs";
            ItemDef.copyMostDefs(itemDef, 1079);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74685;
            itemDef.maleEquip1 = 74684;
            itemDef.femaleEquip1 = 74674;
            ItemDef.copyMostDefs(itemDef, 1079);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20947:
			itemDef.name = "@yel@Golden Kidbuu Gloves";
            ItemDef.copyMostDefs(itemDef, 13000);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74687;
            itemDef.maleEquip1 = 74686;
            itemDef.femaleEquip1 = 74686;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20948:
			itemDef.name = "@yel@Golden Kidbuu Boots";
            ItemDef.copyMostDefs(itemDef, 4131);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74688;
            itemDef.maleEquip1 = 74688;
            itemDef.femaleEquip1 = 74688;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20949:
			itemDef.name = "@re1@Gotenks Helmet";
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74705;
            itemDef.maleEquip1 = 74706;
            itemDef.femaleEquip1 = 74706;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20950:
			itemDef.name = "@re1@Gotenks Platebody";
            ItemDef.copyMostDefs(itemDef, 1127);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74707;
            itemDef.maleEquip1 = 74708;
            itemDef.femaleEquip1 = 74708;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20951:
			itemDef.name = "@re1@Gotenks Platelegs";
            ItemDef.copyMostDefs(itemDef, 1079);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74709;
            itemDef.maleEquip1 = 74710;
            itemDef.femaleEquip1 = 74710;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20952:
			itemDef.name = "@re1@Gotenks Gloves";
            ItemDef.copyMostDefs(itemDef, 13000);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74711;
            itemDef.maleEquip1 = 74712;
            itemDef.femaleEquip1 = 74712;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20953:
			itemDef.name = "@re1@Gotenks Boots";
            ItemDef.copyMostDefs(itemDef, 4131);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74713;
            itemDef.maleEquip1 = 74713;
            itemDef.femaleEquip1 = 74713;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20954:
			itemDef.name = "@re1@DBZ Raids box";
            itemDef.modelID = 74714;
            itemDef.maleEquip1 = 74714;
            itemDef.femaleEquip1 = 74714;
            ItemDef.copyMostDefs(itemDef, 6503);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelZoom = 1500;
            itemDef.actions = new String[5];
 			itemDef.actions[0] = "Open";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20955:
			itemDef.name = "@re1@Beerus Helmet";
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74723;
            itemDef.maleEquip1 = 74722;
            itemDef.femaleEquip1 = 74722;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20956:
			itemDef.name = "@re1@Beerus Platebody";
            ItemDef.copyMostDefs(itemDef, 1127);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74718;
            itemDef.maleEquip1 = 74717;
            itemDef.femaleEquip1 = 74717;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20957:
			itemDef.name = "@re1@Beerus Platelegs";
            ItemDef.copyMostDefs(itemDef, 1079);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74725;
            itemDef.maleEquip1 = 74724;
            itemDef.femaleEquip1 = 74724;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20958:
			itemDef.name = "@re1@Beerus Gloves";
            ItemDef.copyMostDefs(itemDef, 13000);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74721;
            itemDef.maleEquip1 = 74720;
            itemDef.femaleEquip1 = 74720;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 20959:
			itemDef.name = "@re1@Beerus Boots";
            ItemDef.copyMostDefs(itemDef, 4131);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelID = 74719;
            itemDef.maleEquip1 = 74719;
            itemDef.femaleEquip1 = 74719;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
        
		case 2613:
			itemDef.name = "@dom@Raditz Helmet";
            itemDef.modelID = 74668;
            itemDef.maleEquip1 = 74669;
            itemDef.femaleEquip1 = 74669;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 2607:
			itemDef.name = "@dom@Raditz Platebody";
            itemDef.modelID = 74670;
            itemDef.maleEquip1 = 74671;
            itemDef.femaleEquip1 = 74671;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 2609:
			itemDef.name = "@dom@Raditz Platelegs";
            itemDef.modelID = 74672;
            itemDef.maleEquip1 = 74673;
            itemDef.femaleEquip1 = 74673;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 17155:
			itemDef.name = "@dom@Raditz Gloves";
            itemDef.modelID = 74674;
            itemDef.maleEquip1 = 74675;
            itemDef.femaleEquip1 = 74675;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 17299:
			itemDef.name = "@dom@Raditz Boots";
            itemDef.modelID = 74576;
            itemDef.maleEquip1 = 74576;
            itemDef.femaleEquip1 = 74575;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
        case 14512:
            ItemDef.copyModel(itemDef, 12852);
            itemDef.name = "@gre@Custom @mag@Island @gre@Token";
            itemDef.animateInventory = true;
            break;

		case 6611:
			itemDef.name = "@dom@Gladiator Blade";
            itemDef.modelID = 74576;
            itemDef.maleEquip1 = 74577;
            itemDef.femaleEquip1 = 74577;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 10720:
			itemDef.name = "@dom@Gladiator Wings";
            itemDef.modelID = 74578;
            itemDef.maleEquip1 = 74579;
            itemDef.femaleEquip1 = 74579;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 7691:
			itemDef.name = "@or2@Bitcoin";
			itemDef.modelID = 74580;
            ItemDef.copyMostDefs(itemDef, 12164);
            itemDef.modelZoom = 600;
            itemDef.rotationX = 60;
            itemDef.actions = new String[5];
            itemDef.actions[0] = "Redeem";
			break;
			
		case 7692:
			itemDef.name = "@whi@Ethereum";
			itemDef.modelID = 74581;
            ItemDef.copyMostDefs(itemDef, 12164);
            itemDef.modelZoom = 600;
            itemDef.rotationX = 60;
            itemDef.actions = new String[5];
            itemDef.actions[0] = "Redeem";
			break;
			
		case 7694:
			itemDef.name = "@or1@Dogecoin";
			itemDef.modelID = 74582;
            ItemDef.copyMostDefs(itemDef, 12164);
            itemDef.modelZoom = 600;
            itemDef.rotationX = 60;
            itemDef.actions = new String[5];
            itemDef.actions[0] = "Redeem";
			break;
			
		case 7696:
			itemDef.name = "@red@Tesla Aura";
			itemDef.modelID = 74588;
            itemDef.maleEquip1 = 74588;
            itemDef.femaleEquip1 = 74588;
            ItemDef.copyMostDefs(itemDef, 12164);
            itemDef.modelZoom = 3000;
            itemDef.rotationX = 60;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 16628:
			itemDef.name = "@yel@BTC Aura";
			itemDef.modelID = 74632;
            itemDef.maleEquip1 = 74632;
            itemDef.femaleEquip1 = 74632;
            ItemDef.copyMostDefs(itemDef, 12164);
            itemDef.modelZoom = 3000;
            itemDef.rotationX = 60;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21022:
			itemDef.name = "@or2@ETC Aura";
			itemDef.modelID = 74809;
            itemDef.maleEquip1 = 74809;
            itemDef.femaleEquip1 = 74809;
            ItemDef.copyMostDefs(itemDef, 12164);
            itemDef.modelZoom = 3000;
            itemDef.rotationX = 60;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 10171:
			itemDef.modelID = 74633;
            itemDef.maleEquip1 = 74634;
            itemDef.femaleEquip1 = 74634;
			itemDef.name = "@yel@BTC Cape";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 10358:
			itemDef.modelID = 74635;
            itemDef.maleEquip1 = 74636;
            itemDef.femaleEquip1 = 74636;
			itemDef.name = "@yel@BTC Necklace";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 16630:
			itemDef.name = "@or1@DOGE Aura";
			itemDef.modelID = 74658;
            itemDef.maleEquip1 = 74658;
            itemDef.femaleEquip1 = 74658;
            ItemDef.copyMostDefs(itemDef, 12164);
            itemDef.modelZoom = 3000;
            itemDef.rotationX = 60;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 16631:
			itemDef.modelID = 74659;
            itemDef.maleEquip1 = 74660;
            itemDef.femaleEquip1 = 74660;
			itemDef.name = "@or1@DOGE Cape";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 10354:
			itemDef.modelID = 74661;
            itemDef.maleEquip1 = 74662;
            itemDef.femaleEquip1 = 74662;
			itemDef.name = "@or1@DOGE Necklace";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 17458:
			itemDef.name = "@re1@ETH Aura";
			itemDef.modelID = 74663;
            itemDef.maleEquip1 = 74663;
            itemDef.femaleEquip1 = 74663;
            ItemDef.copyMostDefs(itemDef, 12164);
            itemDef.modelZoom = 3000;
            itemDef.rotationX = 60;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 12645:
			itemDef.modelID = 74664;
            itemDef.maleEquip1 = 74665;
            itemDef.femaleEquip1 = 74665;
			itemDef.name = "@or1@ETH Cape";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 10356:
			itemDef.modelID = 74666;
            itemDef.maleEquip1 = 74667;
            itemDef.femaleEquip1 = 74667;
			itemDef.name = "@or1@ETH Necklace";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 15264:
			itemDef.name = "@gre@Afk Fish";
            itemDef.actions = new String[5];
			break;
			
		case 14101:
			itemDef.name = "@gre@Afk Harpoon";
            itemDef.actions = new String[5];
			break;
            
        case 20988:
            ItemDef.copyModel(itemDef, 3912);
            changeTexture(id, 63, 83);
            itemDef.animateInventory = true;
            itemDef.name = "@red@Bloodbag box";
            break;
            
        case 20989:
            ItemDef.copyModel(itemDef, 3912);
            changeTexture(id, 63, 84);
            itemDef.animateInventory = true;
            itemDef.name = "@red@Bloodbag box @whi@(e)";
            break;
            
        case 21005:
            ItemDef.copyModel(itemDef, 3912);
            changeTexture(id, 63, 86);
            itemDef.animateInventory = true;
            itemDef.name = "@yel@Arsenic box";
            break;
            
		case 14121:
			itemDef.name = "@pur@Ninja's bow";
            itemDef.modelID = 48454;
            itemDef.maleEquip1 = 48454;
            itemDef.femaleEquip1 = 48454;
            itemDef.actions = new String[5];
            itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
            itemDef.modelZoom = 3000;
            itemDef.rotationX = 357;
            itemDef.rotationY = 113;
			itemDef.modelOffsetY = 40;
  			itemDef.modelOffset1 = 10;
			break;

   		case 8026:
			itemDef.name = "@or1@Pumpkin @mag@Helmet";
            itemDef.modelID = 74603;
            itemDef.maleEquip1 = 74603;
            itemDef.femaleEquip1 = 74603;
            itemDef.modelZoom = 791;
            itemDef.rotationX = 0;
            itemDef.rotationY = 545;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 8027:
			itemDef.name = "@or1@Pumpkin @mag@Body";
            itemDef.modelID = 74604;
            itemDef.maleEquip1 = 74604;
            itemDef.femaleEquip1 = 74604;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1296;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
			itemDef.modelOffsetY = 45;
			itemDef.stackable = false;
			break;
			
		case 8028:
			itemDef.name = "@or1@Pumpkin @mag@Legs";
            itemDef.modelID = 74605;
            itemDef.maleEquip1 = 74605;
            itemDef.femaleEquip1 = 74605;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1087;
            itemDef.rotationX = 0;
            itemDef.rotationY = 252;
			itemDef.modelOffsetY = -26;
			itemDef.stackable = false;
			break;
			
		case 8029:
			itemDef.name = "@or1@Pumpkin @mag@Boots";
            itemDef.modelID = 74606;
            itemDef.maleEquip1 = 74606;
            itemDef.femaleEquip1 = 74606;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 739;
            itemDef.rotationX = 0;
            itemDef.rotationY = 339;
			itemDef.modelOffsetY = 26;
			itemDef.stackable = false;
			break;
			
		case 8030:
			itemDef.name = "@or1@Pumpkin @mag@Gloves";
            itemDef.modelID = 74607;
            itemDef.maleEquip1 = 74607;
            itemDef.femaleEquip1 = 74607;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 374;
            itemDef.rotationX = 496;
            itemDef.rotationY = 287;
			itemDef.modelOffsetY = 0;
			itemDef.stackable = false;
			break;
			
        case 8073:
            itemDef.modelID = 74608;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Wield";
            itemDef.maleEquip1 = 74608;
            itemDef.femaleEquip1 = 74608;
            itemDef.name = "@or1@Pumpkin @mag@Cape";
            itemDef.modelZoom = 3000;
            itemDef.rotationX = 1100;
            itemDef.rotationY = 0;
            itemDef.modelOffsetY = 0;
            itemDef.modelOffset1 = 0;
            break;
			
   		case 11200:
			itemDef.name = "@whi@Bender's Helmet";
            itemDef.modelID = 74610;
            itemDef.maleEquip1 = 74609;
            itemDef.femaleEquip1 = 74609;
            itemDef.modelZoom = 791;
            itemDef.rotationX = 0;
            itemDef.rotationY = 545;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
   		case 10674:
			itemDef.name = "@yel@Bitcoin Shield";
            itemDef.modelID = 74618;
            itemDef.maleEquip1 = 74617;
            itemDef.femaleEquip1 = 74617;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
   		case 11205:
			itemDef.name = "@whi@Bender's Helmet(i)";
            itemDef.modelID = 74615;
            itemDef.maleEquip1 = 74614;
            itemDef.femaleEquip1 = 74614;
            itemDef.modelZoom = 791;
            itemDef.rotationX = 0;
            itemDef.rotationY = 545;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
   		case 13105:
			itemDef.name = "@re1@Anime Helmet";
            itemDef.modelID = 74619;
            itemDef.maleEquip1 = 74620;
            itemDef.femaleEquip1 = 74620;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 4091:
			itemDef.name = "@re1@Anime Robe Top";
            itemDef.modelID = 74621;
            itemDef.maleEquip1 = 74622;
            itemDef.femaleEquip1 = 74622;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 4103:
			itemDef.name = "@re1@Anime Robe Bottoms";
            itemDef.modelID = 74623;
            itemDef.maleEquip1 = 74624;
            itemDef.femaleEquip1 = 74624;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 2902:
            itemDef.modelID = 74625;
            itemDef.maleEquip1 = 74626;
            itemDef.femaleEquip1 = 74626;
			itemDef.name = "@whi@Anime Gloves";
			itemDef.stackable = false;
			break;
			
		case 6920:
			itemDef.name = "@whi@Anime Boots";
            itemDef.modelID = 74627;
            itemDef.maleEquip1 = 74627;
            itemDef.femaleEquip1 = 74627;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 11202:
			itemDef.name = "@whi@Anime Blade";
            itemDef.modelID = 74628;
            itemDef.maleEquip1 = 74629;
            itemDef.femaleEquip1 = 74629;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.stackable = false;
			break;
			
   		case 11664:
			itemDef.name = "@whi@Void Helmet";
            itemDef.modelID = 74596;
            itemDef.maleEquip1 = 74596;
            itemDef.femaleEquip1 = 74596;
            itemDef.modelZoom = 791;
            itemDef.rotationX = 0;
            itemDef.rotationY = 545;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
   		case 10709:
			itemDef.name = "@pur@Femboy's Helmet";
            itemDef.modelID = 74645;
            itemDef.maleEquip1 = 74645;
            itemDef.femaleEquip1 = 74645;
            itemDef.modelZoom = 791;
            itemDef.rotationX = 0;
            itemDef.rotationY = 545;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 19482:
			itemDef.name = "@pur@Femboy's Platebody";
            itemDef.modelID = 74646;
            itemDef.maleEquip1 = 74646;
            itemDef.femaleEquip1 = 74646;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 19182:
			itemDef.name = "@pur@Femboy's Platelegs";
            itemDef.modelID = 74647;
            itemDef.maleEquip1 = 74647;
            itemDef.femaleEquip1 = 74647;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 10958:
			itemDef.name = "@pur@Femboy's Boots";
            itemDef.modelID = 74648;
            itemDef.maleEquip1 = 74648;
            itemDef.femaleEquip1 = 74648;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 17163:
			itemDef.name = "@pur@Femboy's Gloves";
            itemDef.modelID = 74649;
            itemDef.maleEquip1 = 74649;
            itemDef.femaleEquip1 = 74649;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 374;
            itemDef.rotationX = 496;
            itemDef.rotationY = 287;
			itemDef.modelOffsetY = 0;
			itemDef.stackable = false;
			break;
			
		case 17364:
			itemDef.name = "@pur@Femboy's Staff";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            ItemDef itemdef15 = ItemDef.forID(7158);
            itemDef.modelID = 74650;
            itemDef.femaleEquip1 = 74650;
            itemDef.maleEquip1 = 74650;
            itemDef.modelOffset1 = itemdef15.modelOffset1;
            itemDef.modelOffsetX = itemdef15.modelOffsetX;
            itemDef.modelOffsetY = itemdef15.modelOffsetY;
            itemDef.modelZoom = itemdef15.modelZoom;
            itemDef.rotationX = itemdef15.rotationX;
            itemDef.rotationY = itemdef15.rotationY;
            break;
            
   		case 2627:
			itemDef.name = "@whi@Drugo's Helmet";
            itemDef.modelID = 74817;
            itemDef.maleEquip1 = 74818;
            itemDef.femaleEquip1 = 74818;
            itemDef.modelZoom = 791;
            itemDef.rotationX = 0;
            itemDef.rotationY = 545;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 2623:
			itemDef.name = "@whi@Drugo's Platebody";
            itemDef.modelID = 74819;
            itemDef.maleEquip1 = 74820;
            itemDef.femaleEquip1 = 74820;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 2625:
			itemDef.name = "@whi@Drugo's Platelegs";
            itemDef.modelID = 74821;
            itemDef.maleEquip1 = 74822;
            itemDef.femaleEquip1 = 74822;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 12565:
			itemDef.name = "@whi@Drugo's Boots";
            itemDef.modelID = 74824;
            itemDef.maleEquip1 = 74824;
            itemDef.femaleEquip1 = 74824;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			itemDef.stackable = false;
			break;
			
		case 10075:
            itemDef.modelID = 74823;
            itemDef.maleEquip1 = 74823;
            itemDef.femaleEquip1 = 74823;
			itemDef.name = "@whi@Drugo's Gloves";
			itemDef.stackable = false;
			break;
			
		case 5573:
			itemDef.modelID = 74825;
            itemDef.maleEquip1 = 74825;
            itemDef.femaleEquip1 = 74825;
			itemDef.name = "@whi@Drugo's Cape";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21033:
			itemDef.modelID = 74826;
            itemDef.maleEquip1 = 74827;
            itemDef.femaleEquip1 = 74827;
			itemDef.name = "@whi@Drugo's Aura";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21031:
			itemDef.modelID = 74828;
            itemDef.maleEquip1 = 74830;
            itemDef.femaleEquip1 = 74830;
			itemDef.name = "@whi@Drugo's Sword";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 21032:
			itemDef.modelID = 74828;
            itemDef.maleEquip1 = 74829;
            itemDef.femaleEquip1 = 74829;
			itemDef.name = "@whi@Drugo's Offhand";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 12634:
			itemDef.modelID = 74657;
            itemDef.maleEquip1 = 74657;
            itemDef.femaleEquip1 = 74657;
			itemDef.name = "@pur@Ninja's Cape";
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 8839:
			itemDef.name = "@whi@Void Robe Top";
            itemDef.modelID = 74597;
            itemDef.maleEquip1 = 74597;
            itemDef.femaleEquip1 = 74597;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1296;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
			itemDef.modelOffsetY = 45;
			itemDef.stackable = false;
			break;
			
		case 8840:
			itemDef.name = "@whi@Void Robe Legs";
            itemDef.modelID = 74598;
            itemDef.maleEquip1 = 74598;
            itemDef.femaleEquip1 = 74598;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1087;
            itemDef.rotationX = 0;
            itemDef.rotationY = 252;
			itemDef.modelOffsetY = -26;
			itemDef.stackable = false;
			break;
			
		case 11684:
			itemDef.name = "@whi@Void Boots";
            itemDef.modelID = 74599;
            itemDef.maleEquip1 = 74599;
            itemDef.femaleEquip1 = 74599;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 739;
            itemDef.rotationX = 0;
            itemDef.rotationY = 339;
			itemDef.modelOffsetY = 26;
			itemDef.stackable = false;
			break;
			
		case 11683:
			itemDef.name = "@whi@Void Aura";
            itemDef.modelID = 74600;
            itemDef.maleEquip1 = 74600;
            itemDef.femaleEquip1 = 74600;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 3000;
            itemDef.rotationX = 0;
            itemDef.rotationY = 287;
			itemDef.modelOffsetY = 0;
			itemDef.stackable = false;
			break;
			
		case 8843:
			itemDef.name = "@whi@Void Gloves";
			itemDef.stackable = false;
			break;
			
			
        }

        switch (itemDef.id) {

        }
    }
}


