package com.arlania;

public class ItemDef_Suic {

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

	public static ItemDef newIDS(ItemDef itemDef, int id) {

		switch (id) {


		/**
		 * Texturized models
		 */

        case 2754:
            itemDef.modelID = 61217;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.maleEquip1 = 23909;
            ItemDef.copyMostDefs(itemDef, 18751);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.femaleEquip1 = 23909;
            itemDef.name = "Hercules gloves";
            break;

        case 5023:
            itemDef.name = "Summer Tickets";
            break;
        case 14490:
        case 14492:
        case 14494:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Wield";
            itemDef.actions[2] = "@or2@Salvage";
            break;
            
        case 2755:
            itemDef.modelID = 23910;
            itemDef.actions = new String[5];
            itemDef.actions[0] = "Wield";
            itemDef.actions[2] = "@or2@Salvage";
            ItemDef.copyMostDefs(itemDef, 11733);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.maleEquip1 = 23910;
            itemDef.femaleEquip1 = 23910;
            itemDef.name = "Hercules boots";
            break;

		case 1018:
			itemDef.modelID = 23960;
			itemDef.name = "Louis Head";
			itemDef.femaleEquip1 = 23961;
			itemDef.maleEquip1 = 23961;
			itemDef.description = "Louis' Head";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
			itemDef.actions[4] = "Drop";
			break;


        case 1413:
            itemDef.name = "Scythe Of Virtur";
            itemDef.modelID = 23962;
            itemDef.maleEquip1 = 23963;
            itemDef.femaleEquip1 = 23963;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.stackable = false;
            break;


        case 12426:
            itemDef.name = "Icy Glaive";
            itemDef.modelID = 23964;
            itemDef.maleEquip1 = 23965;
            itemDef.femaleEquip1 = 23965;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.stackable = false;
			itemDef.animateInventory = true;
			itemDef.originalModelColors = new int[] { 60, 62 };
			itemDef.newModelColor = new int[] { 51, 53 };
            break;
            
        case 12434:
        	itemDef.actions = new String[5];
        	itemDef.actions[1] = "Equip";
        	itemDef.actions[2] = "@or2@Salvage";
        	break;
            
        case 12435:
        	itemDef.actions = new String[5];
        	itemDef.actions[1] = "Equip";
        	itemDef.actions[2] = "@or2@Salvage";
        	break;
        	
            
        case 12436:
        	itemDef.actions = new String[5];
        	itemDef.actions[1] = "Equip";
        	itemDef.actions[2] = "@or2@Salvage";
        	break;
        	
        	
        case 19100:
            itemDef.name = "DBZ final room key";
            itemDef.actions = new String[5];
            break;

        case 5150:
            itemDef.name = "Gluttony glaive";
            itemDef.modelID = 23964;
            itemDef.maleEquip1 = 23965;
            itemDef.femaleEquip1 = 23965;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.stackable = false;
			itemDef.animateInventory = true;
			itemDef.originalModelColors = new int[] { 60, 62 };
			itemDef.newModelColor = new int[] { 52, 61 };
            break;


        case 15105:
            itemDef.name = "Mysterious Emblem(1)";
            break;
        case 15106:
            itemDef.name = "Mysterious Emblem(2)";
            break;
        case 15104:
            itemDef.name = "Mysterious Emblem(3)";
            break;
        case 15103:
            itemDef.name = "Mysterious Emblem(4)";
            break;

        case 14639:
            itemDef.name = "Soul Fragments";
            break;

        case 18811:
            itemDef.name = "Vader TP";
            break;


        case 3271:
            itemDef.modelID = 23915;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.maleEquip1 = 23916;
            itemDef.femaleEquip1 = 23916;
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.name = "Vader Helmet";
            break;

        case 3272:
            itemDef.modelID = 23917;
            itemDef.actions = new String[5];
            ItemDef.copyMostDefs(itemDef, 1127);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.maleEquip1 = 23918;
            itemDef.femaleEquip1 = 23918;
            itemDef.name = "Vader Platebody";
            break;

        case 3273:
            itemDef.modelID = 23919;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.maleEquip1 = 23919;
            itemDef.femaleEquip1 = 23919;
            ItemDef.copyMostDefs(itemDef, 1079);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.name = "Vader Platelegs";
            break;

		case 3283:
			itemDef.modelID = 23920;
			itemDef.name = "Vader Gloves";
			itemDef.description = "Death Is Upon Us!";
			itemDef.maleEquip1 = 23921;
			itemDef.femaleEquip1 = 23921;
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.modelZoom = 672;
			itemDef.rotationY = 81;
			itemDef.rotationX = 1670;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 0;
			break;

		case 3284:
			itemDef.modelID = 23922;
			itemDef.name = "Vader Boots";
			itemDef.description = "Death Is Upon Us!";
			itemDef.maleEquip1 = 23922;
			itemDef.femaleEquip1 = 23922;
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.modelZoom = 672;
			itemDef.rotationY = 81;
			itemDef.rotationX = 1670;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 0;
			break;
			
		case 3985:
			itemDef.maleEquip1 = 97417;
			itemDef.femaleEquip1 = 97417;
			itemDef.modelID = 97417;
			itemDef.name = "Darkness Boots";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 5082:
			itemDef.maleEquip1 = 97421;
			itemDef.femaleEquip1 = 97421;
			itemDef.modelID = 97420;
			itemDef.name = "Darkness Robe bottoms";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 5083:
			itemDef.maleEquip1 = 97423;
			itemDef.femaleEquip1 = 97423;
			itemDef.modelID = 97422;
			itemDef.name = "Darkness Robe top";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 5084:
			itemDef.maleEquip1 = 97414;
			itemDef.femaleEquip1 = 97414;
			itemDef.modelID = 97413;
			itemDef.name = "Darkness Mask";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 15656:
			itemDef.maleEquip1 = 97425;
			itemDef.femaleEquip1 = 97425;
			itemDef.modelID = 97424;
			itemDef.name = "Darkness staff";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 17151:
			itemDef.maleEquip1 = 97419;
			itemDef.femaleEquip1 = 97419;
			itemDef.modelID = 97418;
			itemDef.name = "Darkness gloves";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 4643:
			itemDef.name = "Dark purplefire helmet";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 3064:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 3983:
			itemDef.name = "Dark purplefire cape";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 3984:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;

		case 3285:
			itemDef.modelID = 23923;
			itemDef.name = "Vader Cape";
			itemDef.description = "Death Is Upon Us!";
			itemDef.maleEquip1 = 23924;
			itemDef.femaleEquip1 = 23924;
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            ItemDef.copyMostDefs(itemDef, 1021);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			break;

		case 1021:
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 18946:
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 18934:
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 17904:
			itemDef.name = "Ragnorak helmet";
			itemDef.modelID = 23460;
			itemDef.femaleEquip1 = 23459; //65343
			itemDef.maleEquip1 = 23459; //65343
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;

		case 17906:
			itemDef.name = "Ragnorak platebody";
			itemDef.modelID = 23456;
			itemDef.femaleEquip1 = 23455;
			itemDef.maleEquip1 = 23455;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;

		case 17907:
			itemDef.name = "Ragnorak platelegs";
			itemDef.modelID = 23458;
			itemDef.femaleEquip1 = 23457;
			itemDef.maleEquip1 = 23457;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;

		case 17919:
			itemDef.name = "Ragnorak cape";
			itemDef.modelID = 23461;
			itemDef.femaleEquip1 = 23461;
			itemDef.maleEquip1 = 23461;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;

		case 936:
			itemDef.name = "Dragonslayer helmet";
			itemDef.modelID = 23433;
			itemDef.femaleEquip1 = 23434; //65343
			itemDef.maleEquip1 = 23434; //65343
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;

		case 937:
			itemDef.name = "Dragonslayer platebody";
			itemDef.modelID = 23435;
			itemDef.femaleEquip1 = 23436;
			itemDef.maleEquip1 = 23436;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;



		case 938:
			itemDef.name = "Dragonslayer platelegs";
			itemDef.modelID = 23437;
			itemDef.femaleEquip1 = 23438;
			itemDef.maleEquip1 = 23438;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;

		case 939:
			itemDef.name = "Dragonslayer cape";
			itemDef.modelID = 23439;
			itemDef.femaleEquip1 = 23439;
			itemDef.maleEquip1 = 23439;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;

		case 19124:
			itemDef.name = "Leafy monarch helmet";
			itemDef.modelID = 23151;
			itemDef.femaleEquip1 = 23152; //65343
			itemDef.maleEquip1 = 23152; //65343
			changeTexture(id, 70, 82);
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;
		case 19125:
			itemDef.name = "Monarch platebody";
			itemDef.modelID = 23149;
			itemDef.femaleEquip1 = 23150;
			itemDef.maleEquip1 = 23150;
			changeTexture(id, 70, 82);
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;
		case 19126:
			itemDef.name = "Monarch platelegs";
			itemDef.modelID = 23147;
			itemDef.femaleEquip1 = 23148;
			itemDef.maleEquip1 = 23148; //65349
			changeTexture(id, 70, 82);
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;
		case 19772:
			itemDef.name = "Monarch gauntlets";
			itemDef.modelID = 23145;
			itemDef.femaleEquip1 = 23146;
			itemDef.maleEquip1 = 23146; //65350
            ItemDef.copyMostDefs(itemDef, 2942);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			changeTexture(id, 70, 82);
            itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 19774:
			itemDef.name = "Monarch boots";
			itemDef.modelID = 23144;
			itemDef.femaleEquip1 = 23144;
			itemDef.maleEquip1 = 23144;
            ItemDef.copyMostDefs(itemDef, 11733);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			changeTexture(id, 70, 82);
            itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
			
		case 19127:
			itemDef.name = "Noxious gauntlets";
			itemDef.modelID = 23145;
			itemDef.femaleEquip1 = 23146;
			itemDef.maleEquip1 = 23146; //65350
            ItemDef.copyMostDefs(itemDef, 2942);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			changeTexture(id, 70, 71);
            itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 19128:
			itemDef.name = "Noxious boots";
			itemDef.modelID = 23144;
			itemDef.femaleEquip1 = 23144;
			itemDef.maleEquip1 = 23144;
            ItemDef.copyMostDefs(itemDef, 11733);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			changeTexture(id, 70, 71);
            itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 19129:
			itemDef.name = "Noxious drape";
			itemDef.modelID = 23143;
			itemDef.femaleEquip1 = 23142;
			itemDef.maleEquip1 = 23142;
			changeTexture(id, 70, 71);
            itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;

		case 935:
			itemDef.name = "Youtubers Cape";
			itemDef.modelID = 23439;
			itemDef.femaleEquip1 = 23439;
			itemDef.maleEquip1 = 23439;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";

            itemDef.actions[4] = "Drop";
			break;

		case 925:
			itemDef.name = " Lucid blade";
			itemDef.modelID = 23425;
			itemDef.femaleEquip1 = 23424;
			itemDef.maleEquip1 = 23424;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;


		case 3278:
			itemDef.name = "RWB Glaive";
			itemDef.modelID = 23531;
			itemDef.femaleEquip1 = 23532;
			itemDef.maleEquip1 = 23532;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;

		case 3279:
			itemDef.name = "Red Virus";
			itemDef.modelID = 23533;
			itemDef.femaleEquip1 = 23534;
			itemDef.maleEquip1 = 23534;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";

            itemDef.actions[4] = "Drop";
			break;


        case 3282:
            itemDef.modelID = 23539;
            itemDef.stackable = false;
            itemDef.name = "God Staff";
            itemDef.description = "You must be a baller to own this one.";
            itemDef.maleEquip1 = 23540;
            itemDef.femaleEquip1 = 23540;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
           // itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;


		case 3280:
			itemDef.modelID = 23535;
			itemDef.name = "Youtuber Aura";
			itemDef.femaleEquip1 = 23536;
			itemDef.maleEquip1 = 23536;
			itemDef.description = "Flex the yters";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
			itemDef.actions[4] = "Drop";
			break;

		case 3281:
			itemDef.modelID = 23537;
			itemDef.name = "Youtubers Amulet";
			itemDef.femaleEquip1 = 23538;
			itemDef.maleEquip1 = 23538;
			itemDef.description = "Flex the yters";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
			itemDef.actions[4] = "Drop";
			break;

		case 933:
			itemDef.name = "@mag@Celestial Glaive";
            itemDef.modelID = 23964;
            itemDef.maleEquip1 = 23965;
            itemDef.femaleEquip1 = 23965;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.stackable = false;
			itemDef.animateInventory = true;
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 60, 62 };
			itemDef.newModelColor = new int[] { 55, 64};
            break;

            
		case 16520:
			itemDef.name = "@red@Owner Glaive";
            itemDef.modelID = 23964;
            itemDef.maleEquip1 = 23965;
            itemDef.femaleEquip1 = 23965;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.stackable = false;
			itemDef.animateInventory = true;
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 60, 62 };
			itemDef.newModelColor = new int[] { 61, 61};
            break;

		case 17931:
			itemDef.name = "Sire's Glaive";
			itemDef.modelID = 23470;
			itemDef.femaleEquip1 = 23471;
			itemDef.maleEquip1 = 23471;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";

            itemDef.actions[4] = "Drop";
			break;
		case 3905:
			itemDef.name = "Kings cape";
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;
		case 19088:
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;
		case 19091:
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;
		case 19090:
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;
		case 17932:
			itemDef.modelID = 23472;
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 500;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.name = "Luigi's Head";
			itemDef.femaleEquip1 = 23473;
			itemDef.maleEquip1 = 23473;
			itemDef.description = "Luigi's head";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;

  		case 5118:
			itemDef.name = "Satanic Helmet";
			itemDef.modelID = 40080;
			itemDef.maleEquip1 = 40081;
			itemDef.femaleEquip1 = 40081;
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;

  		case 5119:
			itemDef.name = "Satanic Body";
			itemDef.modelID = 40082;
			itemDef.maleEquip1 = 40083;
			itemDef.femaleEquip1 = 40083;
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;

  		case 5120:
			itemDef.name = "Satanic Legs";
			itemDef.modelID = 40084;
			itemDef.maleEquip1 = 40085;
			itemDef.femaleEquip1 = 40085;
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;


		case 14983:
 			itemDef.name = "Georgie's raincoat";
 			itemDef.description = "Georgie's raincoat";
            itemDef.modelID = 74065;
            itemDef.modelZoom = 1596;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
			itemDef.modelOffsetY = 45;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 14984:
 			itemDef.name = "Georgie's jeans";
 			itemDef.description = "Georgie's jeans";
            itemDef.modelID = 74066;
            itemDef.modelZoom = 1587;
            itemDef.rotationX = 0;
            itemDef.rotationY = 252;
			itemDef.modelOffsetY = -26;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 14985:
 			itemDef.name = "Georgie's boots";
 			itemDef.description = "Georgie's boots";
            itemDef.modelID = 74067;
            itemDef.modelZoom = 1539;
            itemDef.rotationX = 0;
            itemDef.rotationY = 339;
			itemDef.modelOffsetY = 26;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 14986:
 			itemDef.name = "Georgie's balloon";
 			itemDef.description = "Georgie's balloon";
            itemDef.modelID = 74068;
            itemDef.modelZoom = 2287;
            itemDef.rotationX = 784;
            itemDef.rotationY = 839;
			itemDef.modelOffsetY = 42;
			itemDef.modelOffset1 = -50;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 15255:
 			itemDef.modelID = 40234;
 			itemDef.name = "Pennywise mask";
 			itemDef.description = "pennywise set";
            itemDef.modelZoom = 900;
            itemDef.rotationY = 100;
 			itemDef.rotationX = 0;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 40235;
 			itemDef.femaleEquip1 = 40235;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
 			itemDef.actions[4] = "Drop";
 			break;

 		case 15256:
 			itemDef.modelID = 40236;
 			itemDef.name = "Pennywise Legs";
 			itemDef.description = "pennywise set";
            itemDef.modelZoom = 1800;
            itemDef.rotationY = 500;
 			itemDef.rotationX = 0;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 40237;
 			itemDef.femaleEquip1 = 40237;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
 			itemDef.actions[4] = "Drop";
 			break;

 		case 15257:
 			itemDef.modelID = 40230;
 			itemDef.name = "Pennywise Body";
 			itemDef.description = "pennywise set";
 		     itemDef.modelZoom = 1500;
            itemDef.rotationY = 500;
 			itemDef.rotationX = 0;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 40231;
 			itemDef.femaleEquip1 = 40231;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
 			itemDef.actions[4] = "Drop";
 			break;

		case 15258:
 			itemDef.modelID = 40232;
 			itemDef.name = "Pennywise Gloves";
 			itemDef.description = "pennywise set";
		     itemDef.modelZoom = 1000;
             itemDef.rotationY = 500;
  			itemDef.rotationX = 0;
  			itemDef.modelOffset1 = -1;
  			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 40233;
 			itemDef.femaleEquip1 = 40233;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
 			itemDef.actions[4] = "Drop";
 			break;

		case 15268:
 			itemDef.modelID = 40228;
 			itemDef.name = "Pennywise Boots";
 			itemDef.description = "pennywise set";
 		     itemDef.modelZoom = 1000;
             itemDef.rotationY = 500;
  			itemDef.rotationX = 0;
  			itemDef.modelOffset1 = -1;
  			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 40229;
 			itemDef.femaleEquip1 = 40229;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
 			itemDef.actions[4] = "Drop";
 			break;

		case 14987:
			itemDef.modelID = 40227;
            ItemDef.copyMostDefs(itemDef, 1959);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.name = "@yel@Jack o' Lantern";
			itemDef.modelZoom = 2000;
			itemDef.description = "@yel@Scary looking Jack o' Lantern";
			itemDef.groundActions = new String[5];
 			itemDef.actions = new String[5];
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;

			
		case 17933:
			itemDef.modelID = 23475;
			itemDef.name = "Mario's Head";
			itemDef.femaleEquip1 = 23476;
			itemDef.maleEquip1 = 23476;
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.modelZoom = 1300;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.description = "Mario's head";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;

		case 934:
			itemDef.name = " Mask of the Dead 15%";
			itemDef.modelID = 23430;
			itemDef.femaleEquip1 = 23431;
			itemDef.maleEquip1 = 23431;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;

		case 14988:
			itemDef.name = "@whi@Freddy Kruger Mask";
            itemDef.modelID = 40211;
            itemDef.maleEquip1 = 40211;
            itemDef.femaleEquip1 = 40211;
            itemDef.modelZoom = 791;
            itemDef.rotationX = 0;
            itemDef.rotationY = 545;
			//itemDef.modelOffsetY = 0;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 14989:
			itemDef.name = "@whi@Freddy Kruger body";
            itemDef.modelID = 40209;
            itemDef.maleEquip1 = 40209;
            itemDef.femaleEquip1 = 40209;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1296;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
			itemDef.modelOffsetY = 45;
			break;
			
		case 14990:
			itemDef.name = "@whi@Freddy Kruger legs";
            itemDef.modelID = 40212;
            itemDef.maleEquip1 = 40212;
            itemDef.femaleEquip1 = 40212;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1087;
            itemDef.rotationX = 0;
            itemDef.rotationY = 252;
			itemDef.modelOffsetY = -26;
			break;
			
			
			
		case 14991:
			itemDef.name = "@whi@Freddy Kruger boots";
            itemDef.modelID = 40208;
            itemDef.maleEquip1 = 40208;
            itemDef.femaleEquip1 = 40208;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 739;
            itemDef.rotationX = 0;
            itemDef.rotationY = 339;
			itemDef.modelOffsetY = 26;
			break;
			
		case 14992:
			itemDef.name = "@whi@Freddy Kruger Claws";
            itemDef.modelID = 40210;
            itemDef.maleEquip1 = 40210;
            itemDef.femaleEquip1 = 40210;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1052;
            itemDef.rotationX = 1157;
            itemDef.rotationY = 809;
			itemDef.modelOffsetY = 26;
  			itemDef.modelOffset1 = -43;
            itemDef.stackable = false;
			break;
			
		case 14994:
			itemDef.name = "@whi@Michael Myers Mask";
            itemDef.modelID = 40217;
            itemDef.maleEquip1 = 40217;
            itemDef.femaleEquip1 = 40217;
            itemDef.modelZoom = 791;
            itemDef.rotationX = 0;
            itemDef.rotationY = 545;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 14995:
			itemDef.name = "@whi@Michael Myers body";
            itemDef.modelID = 40214;
            itemDef.maleEquip1 = 40214;
            itemDef.femaleEquip1 = 40214;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1296;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
			itemDef.modelOffsetY = 45;
			break;
		case 14996:
			itemDef.name = "@whi@Michael Myers legs";
            itemDef.modelID = 40218;
            itemDef.maleEquip1 = 40218;
            itemDef.femaleEquip1 = 40218;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1087;
            itemDef.rotationX = 0;
            itemDef.rotationY = 252;
			itemDef.modelOffsetY = -26;
			break;
		case 14997:
			itemDef.name = "@whi@Michael Myers boots";
            itemDef.modelID = 40213;
            itemDef.maleEquip1 = 40213;
            itemDef.femaleEquip1 = 40213;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 739;
            itemDef.rotationX = 0;
            itemDef.rotationY = 339;
			itemDef.modelOffsetY = 26;
			break;
		case 14998:
			itemDef.name = "@whi@Michael Myers Knife";
            itemDef.modelID = 40216;
            itemDef.maleEquip1 = 40216;
            itemDef.femaleEquip1 = 40216;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1052;
            itemDef.rotationX = 1157;
            itemDef.rotationY = 809;
			itemDef.modelOffsetY = 26;
  			itemDef.modelOffset1 = -43;
            itemDef.stackable = false;
			break;
		case 15000:
			itemDef.name = "@whi@Jason Mask";
            itemDef.modelID = 40223;
            itemDef.maleEquip1 = 40223;
            itemDef.femaleEquip1 = 40223;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 791;
            itemDef.rotationX = 0;
            itemDef.rotationY = 545;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 15001:
			itemDef.name = "@whi@Jason Body";
            itemDef.modelID = 40220;
            itemDef.maleEquip1 = 40220;
            itemDef.femaleEquip1 = 40220;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1296;
            itemDef.rotationX = 0;
            itemDef.rotationY = 0;
			itemDef.modelOffsetY = 45;
            itemDef.stackable = false;
			break;
		case 15002:
			itemDef.name = "@whi@Jason Legs";
            itemDef.modelID = 40222;
            itemDef.maleEquip1 = 40222;
            itemDef.femaleEquip1 = 40222;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1087;
            itemDef.rotationX = 0;
            itemDef.rotationY = 252;
			itemDef.modelOffsetY = -26;
            itemDef.stackable = false;
			break;
		case 15006:
			itemDef.name = "@whi@Jason Gloves";
            itemDef.modelID = 40221;
            itemDef.maleEquip1 = 40221;
            itemDef.femaleEquip1 = 40221;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
           // itemDef.modelZoom = 1052;
            itemDef.rotationX = 1157;
            itemDef.rotationY = 809;
			itemDef.modelOffsetY = 26;
  			itemDef.modelOffset1 = -43;
            itemDef.stackable = false;
			break;
		case 15004:
			itemDef.name = "@whi@Jason Boots";
            itemDef.modelID = 40219;
            itemDef.maleEquip1 = 40219;
            itemDef.femaleEquip1 = 40219;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 739;
            itemDef.rotationX = 0;
            itemDef.rotationY = 339;
			itemDef.modelOffsetY = 26;
            itemDef.stackable = false;
			break;
		case 15005:
			itemDef.name = "@whi@Jason Knife";
            itemDef.modelID = 40219;
            itemDef.maleEquip1 = 40219;
            itemDef.femaleEquip1 = 40219;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 1052;
            itemDef.rotationX = 1157;
            itemDef.rotationY = 809;
			itemDef.modelOffsetY = 26;
  			itemDef.modelOffset1 = -43;
            itemDef.stackable = false;
			break;
		case 15008:
			itemDef.name = "Halloween Hammer";
            itemDef.modelID = 40500;
            itemDef.maleEquip1 = 40500;
            itemDef.femaleEquip1 = 40500;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 2052;
            itemDef.rotationX = 1157;
            itemDef.rotationY = 809;
			itemDef.modelOffsetY = 26;
  			itemDef.modelOffset1 = -43;
            itemDef.stackable = false;
			break;
		case 15009:
			itemDef.name = "Pumpkin Staff";
            itemDef.modelID = 40502;
            itemDef.maleEquip1 = 40502;
            itemDef.femaleEquip1 = 40502;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 2052;
            itemDef.rotationX = 1157;
            itemDef.rotationY = 809;
			itemDef.modelOffsetY = 26;
  			itemDef.modelOffset1 = -43;
            itemDef.stackable = false;
			break;
		case 15010:
			itemDef.name = "Spooky Bow";
            itemDef.modelID = 40503;
            itemDef.maleEquip1 = 40503;
            itemDef.femaleEquip1 = 40503;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.modelZoom = 2052;
            itemDef.rotationX = 1157;
            itemDef.rotationY = 809;
			itemDef.modelOffsetY = 26;
  			itemDef.modelOffset1 = -43;
            itemDef.stackable = false;
			break;
			
		case 17291:
			itemDef.name = "Blood Necklace";
			break;
		case 16453:
			ItemDef.copyModel(itemDef, 19935);
			itemDef.name = "$5 Bond(Tradeable)";
			break;
		case 14546:
            ItemDef.copyMostDefs(itemDef, 4670);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 44046;
			itemDef.name = "Melee Diamond(1)";
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			break;
		case 13022:
            ItemDef.copyMostDefs(itemDef, 4670);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 14614;
			itemDef.name = "@red@Bloodslayer gem";
            itemDef.actions[0] = "Operate";
			itemDef.animateInventory = true;
			break;
		case 14547:
            ItemDef.copyMostDefs(itemDef, 4670);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 44047;
			itemDef.name = "Melee Diamond(2)";
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			break;
			
		case 14548:
            ItemDef.copyMostDefs(itemDef, 4670);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 44048;
			itemDef.name = "Melee Diamond(3)";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[1] = "Equip";
			itemDef.animateInventory = true;
			break;
			
		case 6509:
            ItemDef.copyMostDefs(itemDef, 4670);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 41622;
			itemDef.name = "Range Diamond(1)";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[1] = "Equip";
			break;
		case 6510:
            ItemDef.copyMostDefs(itemDef, 4670);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 41685;
			itemDef.name = "Range Diamond(2)";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[1] = "Equip";
			break;
		case 6511:
            ItemDef.copyMostDefs(itemDef, 4670);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 41686;
			itemDef.name = "Range Diamond(3)";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[1] = "Equip";
			break;
			
		case 6505:
            ItemDef.copyMostDefs(itemDef, 4670);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 44049;
			itemDef.name = "Magic Diamond(1)";
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			break;
		case 6506:
            ItemDef.copyMostDefs(itemDef, 4670);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 44050;
			itemDef.name = "Magic Diamond(2)";
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			break;
		case 6508:
            ItemDef.copyMostDefs(itemDef, 4670);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 44051;
			itemDef.name = "Magic Diamond(3)";
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			break;
			
		case 14549:
			itemDef.modelID = 48768;
            ItemDef.copyMostDefs(itemDef, 5185);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.name = "@whi@Fuzed Diamond@mag@(50% DR)";
			itemDef.animateInventory = true;
			itemDef.actions = new String[5];
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			break;
			
		case 6758:
			itemDef.modelID = 48768;
            ItemDef.copyMostDefs(itemDef, 5185);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.name = "@whi@Saturated Diamond@mag@(20% DR)";
			itemDef.animateInventory = true;
			itemDef.actions = new String[5];
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			break;
			
		case 6759:
			itemDef.modelID = 48768;
            ItemDef.copyMostDefs(itemDef, 5185);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.name = "@red@Bloodshed Diamond(0.25% DMG)";
			itemDef.animateInventory = true;
			itemDef.actions = new String[5];
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			break;
			
			
		case 6760:
			itemDef.modelID = 48768;
            ItemDef.copyMostDefs(itemDef, 5185);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.name = "@gre@Exquisite @bla@Diamond";
			itemDef.animateInventory = true;
			itemDef.actions = new String[5];
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			break;
			
		case 6762:
			itemDef.modelID = 48768;
            ItemDef.copyMostDefs(itemDef, 5185);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.name = "@or1@SebZero Diamond";
			itemDef.animateInventory = true;
			itemDef.actions = new String[5];
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			break;
		case 773:
			itemDef.actions = new String[5];
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			break;
		case 774:
			itemDef.actions = new String[5];
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			break;	
		case 8731:
			itemDef.modelID = 48768;
            ItemDef.copyMostDefs(itemDef, 5185);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.name = "@re1@Q's @whi@DR @re1@diamond";
			itemDef.animateInventory = true;
			itemDef.actions = new String[5];
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			break;

		case 19935:

			itemDef.modelID = 51439;
			itemDef.name = "$5 Bond";
            ItemDef.copyMostDefs(itemDef, 19936);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			changeTexture(id, 40, 58);
			itemDef.animateInventory = true;
			break;
			
		case 17743:
			itemDef.modelID = 51439;
			itemDef.name = "$5 Winter Bond";
            changeTexture(id, 40, 51);
            ItemDef.copyMostDefs(itemDef, 19936);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.animateInventory = true;
			break;
			
		case 17840:
			itemDef.modelID = 51439;
			itemDef.name = "$10 Winter Bond";
            changeTexture(id, 40, 51);
            ItemDef.copyMostDefs(itemDef, 19936);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.animateInventory = true;
			break;
			
		case 17745:
			itemDef.modelID = 51441;
			itemDef.modelZoom = 983;
            itemDef.rotationX = 0;
            itemDef.rotationY = 380;
			itemDef.modelOffsetY = 0;
            itemDef.actions = new String[5];
            itemDef.actions[0] = "Redeem";
			itemDef.name = "LoL Arcade token";
			break;
			
			
		case 19936:
			itemDef.modelID = 51439;
			changeTexture(id, 40, 57);
            ItemDef.copyMostDefs(itemDef, 19936);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.name = "$10 Bond";
			itemDef.animateInventory = true;
			break;
		case 16455:
			changeTexture(id, 40, 51);
			itemDef.modelID = 51439;
            ItemDef.copyMostDefs(itemDef, 19936);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.name = "$25 Bond";
			itemDef.animateInventory = true;
			break;
		case 19938:
			itemDef.modelID = 51439;
            ItemDef.copyMostDefs(itemDef, 19936);
			changeTexture(id, 40, 55);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.name = "$50 Bond";
			itemDef.animateInventory = true;
			break;
			
		case 17750:
			itemDef.modelID = 55349;
            ItemDef.copyMostDefs(itemDef, 10835);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.actions = new String[5];
            itemDef.actions = new String[5];
            itemDef.actions = new String[] { "Add-to-pouch", "@red@Convert", null,null, null};
			itemDef.name = "@red@Bloodbags";
			break;
        case 5020:
			itemDef.modelID = 51439;
			changeTexture(id, 40, 61);
            ItemDef.copyMostDefs(itemDef, 19936);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.actions[0] = "Redeem";
            itemDef.name = "100$ Bond";
			itemDef.animateInventory = true;
            break;

		case 4082:
			itemDef.name = "Blood Shard";
            ItemDef.copyMostDefs(itemDef, 12530);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			ItemDef.copyModel(itemDef, 12530);
			itemDef.animateInventory = true;
			break;
		case 9117:
            ItemDef.copyMostDefs(itemDef, 773);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 62672;
            itemDef.femaleEquip1 = 62672;
            itemDef.maleEquip1 = 62672;
            itemDef.actions[1] = "Equip";
            itemDef.actions[4] = "Drop";
			itemDef.name = "@cya@'perfect' ring(@whi@i)";
			break;
		case 5239:
            ItemDef.copyMostDefs(itemDef, 774);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 62668;
            itemDef.femaleEquip1 = 62667;
            itemDef.maleEquip1 = 62667;
            itemDef.actions[1] = "Equip";
            itemDef.actions[4] = "Drop";
			itemDef.name = "@red@Owners Necklace";
			break;
		case 552:
			itemDef.modelZoom = 570;
			itemDef.name = "@whi@Paper Sailboat Amulet";
			break;
			
		case 5238:
            ItemDef.copyMostDefs(itemDef, 773);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 62669;
            itemDef.femaleEquip1 = 62669;
            itemDef.maleEquip1 = 62669;
            itemDef.actions[1] = "Equip";
            itemDef.actions[4] = "Drop";
			itemDef.name = "@red@Owners Ring";
			break;
		case 15675:
			itemDef.actions = new String[5];
			itemDef.name = "Omniscient scroll";
			break;
			
		case 11309:
            ItemDef.copyMostDefs(itemDef, 2365);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 62736;
			itemDef.name = "@cya@'perfect' bar(@whi@i)";
			break;

		case 9116:
            ItemDef.copyMostDefs(itemDef, 774);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.modelID = 62671;
            itemDef.femaleEquip1 = 62670;
            itemDef.maleEquip1 = 62670;
            itemDef.actions[1] = "Equip";
            itemDef.actions[4] = "Drop";
			itemDef.name = "@cya@'perfect' necklace(@whi@i)";
			break;

		case 14269:
			itemDef.name = "God Potion";
			itemDef.animateInventory = true;
			break;


		case 5185:
			ItemDef.copyModel(itemDef, 15332);
			itemDef.name = "Infinite Overload Potion";
			itemDef.animateInventory = true;
			break;

		case 3961:
			itemDef.modelID = 44600;
            itemDef.actions[0] = "@whi@Consume";
            itemDef.actions[4] = "Drop";
			itemDef.name = "Eternal Potion";
			itemDef.animateInventory = true;
			break;

		case 18928:
			itemDef.name = "Beginner wings";
			break;
		case 19140:
			itemDef.modelID = 23422;
			itemDef.name = "Ring of Overload";
			itemDef.animateInventory = true;
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			itemDef.rotationX = 320; // the rotation x u chose in editor
			itemDef.rotationY = 270;
			break;
		case 3073:
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 2577:
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 19141:
			itemDef.modelID = 23423;
			itemDef.name = "Ring of Overload+";
			itemDef.animateInventory = true;
            itemDef.actions[1] = "Equip";

            itemDef.actions[4] = "Drop";
			itemDef.rotationX = 320; // the rotation x u chose in editor
			itemDef.rotationY = 270;
			break;

		case 19142:
			itemDef.modelID = 23426;
			itemDef.name = "Ring of Overload++";
			itemDef.animateInventory = true;
            itemDef.actions[1] = "Equip";

            itemDef.actions[4] = "Drop";
			itemDef.rotationX = 320; // the rotation x u chose in editor
			itemDef.rotationY = 270;
			break;

		case 5183:
			ItemDef.copyModel(itemDef, 3316);
			itemDef.originalModelColors = new int[] { 62 };
			itemDef.newModelColor = new int[] { 68 };
			itemDef.name = "Texturized Range SS";
			itemDef.animateInventory = true;
			break;

		case 15045:
			ItemDef.copyModel(itemDef, 3316);
			itemDef.originalModelColors = new int[] { 62 };
			itemDef.newModelColor = new int[] { 71 };
			itemDef.name = "Aquatic Shield";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			break;

		case 18749:
			ItemDef.copyModel(itemDef, 3316);
			changeTexture(id, 62, 58);
			itemDef.name = "Forest Shield";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			break;

		case 19475:
			itemDef.name = "Dungeon Floor 2 teleport";
					break;

		case 17922:
			ItemDef.copyModel(itemDef, 19475);
			itemDef.name = "Dungeon Floor 2 teleport";
					break;


		case 17926:
			itemDef.modelID = 23466;
			itemDef.name = "Bloodlightning MainHand";
			itemDef.modelZoom = 2000;
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 5;
			itemDef.femaleEquip1 = 23466;
			itemDef.maleEquip1 = 23466;
			itemDef.description = "Only the finest warriors have this Weapon";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 17927:
			itemDef.modelID = 23467;
			itemDef.name = "Bloodlightning OffHand";
			itemDef.modelZoom = 2000;
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 5;
			itemDef.femaleEquip1 = 23467;
			itemDef.maleEquip1 = 23467;
			itemDef.description = "Only the finest warriors have this Weapon";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 17929:
			itemDef.modelID = 23468;
			itemDef.name = "SebZero Crusher-mainhand";
            ItemDef.copyMostDefs(itemDef, 3316);
			//itemDef.modelOffset1 = itemDef.modelOffset1;
			//itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.modelZoom = 2200;
			//itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.femaleEquip1 = 23468;
			itemDef.maleEquip1 = 23468;
			itemDef.description = "Only the finest warriors have this Weapon";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 17928:
			itemDef.modelID = 23469;
			itemDef.name = "SebZero Crusher-offhand";
			itemDef.modelZoom = 2000;
            ItemDef.copyMostDefs(itemDef, 17039);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.femaleEquip1 = 23469;
			itemDef.maleEquip1 = 23469;
			itemDef.description = "Only the finest warriors have this Weapon";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;


		case 17923:
			ItemDef.copyModel(itemDef, 1481);
			itemDef.name = "Hellfire orbs";
					break;

		case 17924:
			//ItemDef.copyModel(itemDef, 13149);
			itemDef.name = "Nomads Tickets";
					break;

		case 18750:
			ItemDef.copyModel(itemDef, 19088);
			changeTexture(id, 40, 70);
			itemDef.name = "Olm Partyhat";
			itemDef.animateInventory = true;
			break;

		case 14044:
			ItemDef.copyModel(itemDef, 19088);
			changeTexture(id, 40, 87);
			itemDef.name = "@re1@Divine Partyhat";
			itemDef.animateInventory = true;
			break;
			
		case 14046:
			ItemDef.copyModel(itemDef, 19088);
			changeTexture(id, 40, 83);
			itemDef.name = "@red@Blood Partyhat";
			itemDef.animateInventory = true;
			break;
			
			
		case 18751:
			ItemDef.copyModel(itemDef, 4775);
			changeTexture(id, 40, 70);
			itemDef.name = "Olm Gloves(3%Dr)";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			break;

		case 5210:
			ItemDef.copyModel(itemDef, 3316);
			itemDef.originalModelColors = new int[] { 62 };
			itemDef.newModelColor = new int[] { 72 };
			itemDef.name = "Toxic Shield";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			break;

		case 5211:
			ItemDef.copyModel(itemDef, 3316);
			itemDef.originalModelColors = new int[] { 62 };
			itemDef.newModelColor = new int[] { 64 };
			itemDef.name = "Elemental Shield";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			break;


		case 5170:
			ItemDef.copyModel(itemDef, 19476);
			itemDef.name = "Unlimited Prayer Scroll";
			itemDef.animateInventory = true;
			itemDef.actions = new String[5];
			itemDef.actions = new String[] { null, null, null, null, null };
			break;

		case 4670:
		case 4671:
		case 4672:
		case 4673:
			itemDef.actions = new String[5];
			itemDef.actions = new String[] { null, null, null, null, null };
			break;

			
		case 13088:
			itemDef.name = "VIP Battlesword";
			ItemDef itemdef4 = ItemDef.forID(7158);
			itemDef.modelID = 23411;
			itemDef.femaleEquip1 = 23412;
			itemDef.maleEquip1 = 23412;
			itemDef.modelOffset1 = itemdef4.modelOffset1;
			itemDef.modelOffsetX = itemdef4.modelOffsetX;
			itemDef.modelOffsetY = itemdef4.modelOffsetY;
			itemDef.modelZoom = itemdef4.modelZoom;
			itemDef.rotationX = itemdef4.rotationX;
			itemDef.rotationY = itemdef4.rotationY;
			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;

        case 5184:
            itemDef.modelID = 23409;
            itemDef.stackable = false;
            itemDef.name = "TeddyBear";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23410;
            itemDef.femaleEquip1 = 23410;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;


        case 13087:
            itemDef.modelID = 23409;
            itemDef.stackable = false;
            itemDef.name = "TeddyBear";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23410;
            itemDef.femaleEquip1 = 23410;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;


        case 2547:
            itemDef.modelID = 23499;
            itemDef.stackable = false;
            itemDef.name = "Ocean TeddyBear";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23498;
            itemDef.femaleEquip1 = 23498;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 2548:
            itemDef.modelID = 23501;
            itemDef.stackable = false;
            itemDef.name = "Abyssal TeddyBear";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23500;
            itemDef.femaleEquip1 = 23500;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 2549:
            itemDef.modelID = 23502;
            itemDef.stackable = false;
            itemDef.name = "Tainted Boots";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23502;
            itemDef.femaleEquip1 = 23502;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 3075:
            itemDef.modelID = 23515;
            itemDef.stackable = false;
            itemDef.name = "Sires Boots";
            itemDef.description = "if you got these your in for a upgrade soon!";
            itemDef.maleEquip1 = 23515;
            itemDef.femaleEquip1 = 23515;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 3076:
            itemDef.modelID = 23517;
            itemDef.stackable = false;
            itemDef.name = "Sires Helmet";
            itemDef.description = "if you got these your in for a upgrade soon!";
            itemDef.maleEquip1 = 23516;
            itemDef.femaleEquip1 = 23516;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 3078:
            itemDef.modelID = 23519;
            itemDef.stackable = false;
            itemDef.name = "Sires Gloves";
            itemDef.description = "if you got these your in for a upgrade soon!";
            itemDef.maleEquip1 = 23518;
            itemDef.femaleEquip1 = 23518;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 3242:
            itemDef.modelID = 23521;
            itemDef.stackable = false;
            itemDef.name = "Sires Platebody";
            itemDef.description = "if you got these your in for a upgrade soon!";
            itemDef.maleEquip1 = 23520;
            itemDef.femaleEquip1 = 23520;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 3244:
            itemDef.modelID = 23523;
            itemDef.stackable = false;
            itemDef.name = "Sires Platelegs";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23522;
            itemDef.femaleEquip1 = 23522;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;


        case 3250:
            itemDef.modelID = 23525;
            itemDef.stackable = false;
            itemDef.name = "Sires Staff";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23524;
            itemDef.femaleEquip1 = 23524;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;


        case 3254:
            itemDef.modelID = 23526;
            itemDef.stackable = false;
            itemDef.name = "Elemental Off-hand";
            itemDef.description = "what a masterpiece";
            itemDef.maleEquip1 = 23527;
            itemDef.femaleEquip1 = 23527;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 2771:
            itemDef.modelID = 23504;
            itemDef.stackable = false;
            itemDef.name = "Tainted Helmet";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23503;
            itemDef.femaleEquip1 = 23503;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 2772:
            itemDef.modelID = 23506;
            itemDef.stackable = false;
            itemDef.name = "Tainted Gloves";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23505;
            itemDef.femaleEquip1 = 23505;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 2867:
            itemDef.modelID = 23508;
            itemDef.stackable = false;
            itemDef.name = "Tainted Platebody";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23507;
            itemDef.femaleEquip1 = 23507;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 2868:
            itemDef.modelID = 23510;
            itemDef.stackable = false;
            itemDef.name = "Tainted Platelegs";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23509;
            itemDef.femaleEquip1 = 23509;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;


        case 2869:
            itemDef.modelID = 23512;
            itemDef.stackable = false;
            itemDef.name = "Tainted Cape";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23511;
            itemDef.femaleEquip1 = 23511;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 2870:
            itemDef.modelID = 23514;
            itemDef.stackable = false;
            itemDef.name = "Tainted Shield";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23513;
            itemDef.femaleEquip1 = 23513;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;


        case 2545:
            itemDef.modelID = 23497;
            itemDef.stackable = false;
            itemDef.name = "Panda Teddybear";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23496;
            itemDef.femaleEquip1 = 23496;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 2546:
            itemDef.modelID = 23495;
            itemDef.stackable = false;
            itemDef.name = "RA@yel@STA @yel@Ted@yel@dy";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23492;
            itemDef.femaleEquip1 = 23492;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

        case 7617:
            itemDef.modelID = 23413;
            itemDef.stackable = false;
            itemDef.name = "Donators TeddyBear";
            itemDef.description = "Gives you that extra bit of luck!";
            itemDef.maleEquip1 = 23414;
            itemDef.femaleEquip1 = 23414;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;

		case 5197:
			itemDef.modelID = 97448;
            ItemDef.copyMostDefs(itemDef, 12164);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelZoom = 2000;
			itemDef.name = "50% Lucky DR Charm";
			itemDef.actions = new String[] { null, null, null, null, null };
			break;
			
		case 8024:
			itemDef.modelID = 61842;
            ItemDef.copyMostDefs(itemDef, 12164);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelZoom = 2000;
			itemDef.name = "@whi@x2 Pest Control Charm";
			itemDef.actions = new String[] { null, null, null, null, null };
			break;
			
			
		case 8732:
			itemDef.modelID = 97448;
            ItemDef.copyMostDefs(itemDef, 12164);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelZoom = 2000;
            itemDef.animateInventory = true;
			itemDef.name = "@re1@Q's @whi@Lucky @re1@DR Charm";
			itemDef.actions = new String[] { null, null, null, null, null };
			break;
		case 7332:
			itemDef.name = "@dom@Thresh's book";
            itemDef.modelID = 74551;
            itemDef.maleEquip1 = 74552;
            itemDef.femaleEquip1 = 74552;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 10306:
			itemDef.name = "@dom@Thresh's Helmet";
            itemDef.modelID = 74540;
            itemDef.maleEquip1 = 74541;
            itemDef.femaleEquip1 = 74541;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
			
		case 19167:
			itemDef.name = "@dom@Thresh's Platebody";
            itemDef.modelID = 74542;
            itemDef.maleEquip1 = 74543;
            itemDef.femaleEquip1 = 74543;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 19169:
			itemDef.name = "@dom@Thresh's Platelegs";
            itemDef.modelID = 74544;
            itemDef.maleEquip1 = 74545;
            itemDef.femaleEquip1 = 74545;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 20461:
			itemDef.name = "@dom@Thresh's Gloves";
            itemDef.modelID = 74546;
            itemDef.maleEquip1 = 74547;
            itemDef.femaleEquip1 = 74547;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 17309:
			itemDef.name = "@dom@Thresh's Boots";
            itemDef.modelID = 74548;
            itemDef.maleEquip1 = 74548;
            itemDef.femaleEquip1 = 74548;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 17416:
			itemDef.name = "@dom@Thresh's Scythe";
            itemDef.modelID = 74549;
            itemDef.maleEquip1 = 74550;
            itemDef.femaleEquip1 = 74550;
            itemDef.actions = new String[5];
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 7925:
			itemDef.modelID = 48007;
            itemDef.modelZoom = 1243;
            itemDef.rotationX = 1696;
            itemDef.rotationY = 240;
			itemDef.modelOffsetY = 0;
  			itemDef.modelOffset1 = 0;
            itemDef.maleEquip1 = 48007;
            itemDef.femaleEquip1 = 48007;
            itemDef.actions = new String[5];
			itemDef.name = "Femboy's Lucky dildo";
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
            itemDef.animateInventory = true;
			break;
		case 2619:
			itemDef.modelID = 74555;
            itemDef.modelZoom = 1243;
            itemDef.maleEquip1 = 74556;
            itemDef.femaleEquip1 = 74556;
            itemDef.actions = new String[5];
			itemDef.name = "@whi@Spooky mask";
 			itemDef.actions[1] = "Wear";
 			itemDef.actions[4] = "Drop";
			break;
		case 12162:
            itemDef.modelZoom = 1250;
			itemDef.modelID = 18598;
			itemDef.name = "@whi@Lazy Charm @re1@(100 KC)";
            itemDef.actions = new String[5];
            itemDef.actions[2] = "Claim";
			break;

		case 12164:
            itemDef.modelZoom =  1250;
			itemDef.modelID = 18598;
			itemDef.name = "@whi@Lazy Charm @re1@(250 KC)";
            itemDef.actions = new String[5];
            itemDef.actions[2] = "Claim";
			break;

		case 18392:
			itemDef.modelID = 61906;
            ItemDef.copyMostDefs(itemDef, 12164);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.name = "2% Lucky DR Charm";
            itemDef.modelZoom = 2000;
			itemDef.actions = new String[] { null, null, null, null, null };
			break;
		case 4641:
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			break;
		case 4642:
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			break;
		case 18401:
			itemDef.modelID = 61907;
            ItemDef.copyMostDefs(itemDef, 12164);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelZoom = 2000;
			itemDef.name = "5% Lucky DR Charm";
			itemDef.actions = new String[] { null, null, null, null, null };
			break;
		case 6770:
			itemDef.modelID = 61908;
            ItemDef.copyMostDefs(itemDef, 12164);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.modelZoom = 2000;
			itemDef.name = "25% Lucky DR Charm";
			itemDef.actions = new String[] { null, null, null, null, null };
			break;

		case 5168:
			ItemDef.copyModel(itemDef, 19476);
			itemDef.name = "Hellfire Scroll";
			itemDef.animateInventory = true;
			break;

		case 19821:
			itemDef.name = "@yel@Thunderlight Boots";
			itemDef.stackable = false;
			ItemDef.copyModel(itemDef, 4803);
            changeTexture(id, 60, 56);
			itemDef.animateInventory = true;
			break;
			
			
		case 16563:
			itemDef.name = "@gre@Green Arsenic Boots";
			itemDef.stackable = false;
			ItemDef.copyModel(itemDef, 4803);
			itemDef.originalModelColors = new int[] { 60 };
			itemDef.newModelColor = new int[] { 58 };
			itemDef.animateInventory = true;
			break;
			
		case 16479:
			itemDef.name = "@blu@Blue Arsenic Boots";
			itemDef.stackable = false;
			ItemDef.copyModel(itemDef, 4803);
			itemDef.originalModelColors = new int[] { 60 };
			itemDef.newModelColor = new int[] { 53 };
			itemDef.animateInventory = true;
			break;

		case 4803:
			itemDef.name = "@red@Bloodshed Boots";
			itemDef.stackable = false;
			itemDef.originalModelColors = new int[] { 60 };
			itemDef.newModelColor = new int[] { 52 };
            itemDef.actions[2] = "@or2@Salvage";
			break;



		case 5052:
			ItemDef.copyModel(itemDef, 4803);
            changeTexture(id, 60, 57);
			itemDef.name = "@bla@Alpha Boots";
			itemDef.stackable = false;
            itemDef.actions[2] = "@or2@Salvage";
			break;

		case 5195:
			ItemDef.copyModel(itemDef, 3990);
			itemDef.name = "Hulk Minigun";
			itemDef.originalModelColors = new int[] { 40, 24 };
			itemDef.newModelColor = new int[] { 58, 58 };
            itemDef.actions[2] = "@or2@Salvage";
			break;

		case 5158:
			ItemDef.copyModel(itemDef, 3990);
			itemDef.name = "Vprs Lavagun";
			itemDef.originalModelColors = new int[] { 24 };
			itemDef.newModelColor = new int[] { 57 };
            itemDef.actions[2] = "@or2@Salvage";
			break;

		/*
		 * case 19821: itemDef.originalModelColors = new int[2]; itemDef.newModelColor =
		 * new int[2]; itemDef.originalModelColors[0] = 51; itemDef.newModelColor[0] =
		 * 58; itemDef.originalModelColors[1] = 60; itemDef.newModelColor[1] = 59;
		 * itemDef.modelID = 94700; itemDef.maleEquip1 = 94700; itemDef.femaleEquip1 =
		 * 94700; itemDef.modelZoom = 1000; itemDef.modelOffset1 = 0;
		 * itemDef.modelOffsetX = 0; itemDef.rotationX = 2020; itemDef.rotationY = 333;
		 * itemDef.actions = new String[5]; itemDef.actions[1] = "Equip"; itemDef.name =
		 * "50% DR Increasing Boots"; break;
		 */

		case 5159:
			ItemDef.copyModel(itemDef, 20054);
			itemDef.name = "Great Ring";
			break;

		case 8851:
			itemDef.name = "Frankenstein Tokens";
			break;

		case 5179:
			ItemDef.copyModel(itemDef, 3951);
			itemDef.name = "Hellfire Battlestaff";
			itemDef.originalModelColors = new int[] { 40 };
			itemDef.newModelColor = new int[] { 59 };
			break;

		case 5204:
			ItemDef.copyModel(itemDef, 19943);
			itemDef.name = "Genesis nub cape";
			itemDef.modelID = 99888;
			itemDef.maleEquip1 = 99889;
			itemDef.femaleEquip1 = 99890;
			itemDef.originalModelColors = new int[] {978, 945, 968, 960, 65535};
			itemDef.newModelColor = new int[] {40459, 40665, 40549, 40652, 40665};
			break;

		case 19996:
			ItemDef.copyModel(itemDef, 5153);
			itemDef.name = "Dragon Pet Scroll";
			itemDef.actions = new String[] { "Open Interface", null, null, null, null };
			break;


        case 18338:
		//	itemDef.modelID = 10437;
            itemDef.name = "@re1@SebZero @cya@Goodiebag";
			itemDef.actions = new String[] { "@enc@Open", null, null, null, null };
            break;
			
		case 5129:
			ItemDef.copyModel(itemDef, 3951);
			itemDef.name = "Heated Battlestaff";

            itemDef.actions[2] = "@or2@Salvage";
			break;

		case 19079:
			itemDef.actions = new String[] { null, null, null, null, null };
			break;

		case 19080:
            itemDef.name = "@bla@Shadowlord Bones";
            changeTexture(id, 60, 57);
			itemDef.actions = new String[] { "Bury", null, null, null, null };
			break;
			

		case 10852:
			ItemDef.copyModel(itemDef, 19080);
            itemDef.name = "@gre@Zombie bones";
            changeTexture(id, 60, 61);
			itemDef.actions = new String[] { "Bury", null, null, null, null };
			break;
			

		case 10853:
			ItemDef.copyModel(itemDef, 19080);
            itemDef.name = "@whi@Maniac bones";
            changeTexture(id, 60, 63);
			itemDef.actions = new String[] { "Bury", null, null, null, null };
			break;
		case 10855:
			ItemDef.copyModel(itemDef, 19080);
            itemDef.name = "@whi@Bigsmoke bones";
            changeTexture(id, 60, 63);
			itemDef.actions = new String[] { "Bury", null, null, null, null };
			break;
			

		case 10854:
			ItemDef.copyModel(itemDef, 19080);
            itemDef.name = "@whi@Nishimiya bones";
            changeTexture(id, 60, 53);
			itemDef.actions = new String[] { "Bury", null, null, null, null };
			break;
			
		case 23:
            itemDef.name = "@red@Machine parts";
			itemDef.actions = new String[] { "Bury", null, null, null, null };
			break;
			
		case 16533:
			ItemDef.copyModel(itemDef, 19080);
            itemDef.name = "@red@Incredible Bones";
            changeTexture(id, 60, 61);
			itemDef.actions = new String[] { "Bury", null, null, null, null };
			break;
			
		case 16534:
            itemDef.name = "@cya@Sirenic Bones";
			ItemDef.copyModel(itemDef, 19080);
            changeTexture(id, 60, 51);
			itemDef.actions = new String[] { "Bury", null, null, null, null };
			break;

        case 920:
            itemDef.modelID = 23122;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.modelZoom = 1400;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 23122;
            itemDef.femaleEquip1 = 23122;
            itemDef.name = "God Fusion Goku Boots";
            break;

        case 13728:
            itemDef.modelID = 23378;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 23379;
            itemDef.femaleEquip1 = 23379;
            itemDef.name = "helmet";
            break;

        case 13729:
            itemDef.modelID = 23380;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 23381;
            itemDef.femaleEquip1 = 23381;
            itemDef.name = "platebody";
            break;


        case 13730:
            itemDef.modelID = 23382;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 23383;
            itemDef.femaleEquip1 = 23383;
            itemDef.name = "platelegs";
            break;
        case 916:
            itemDef.modelID = 23124;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.modelZoom = 1400;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 23123;
            itemDef.femaleEquip1 = 23123;
            itemDef.name = "God Fusion Goku Helmet";
            break;

        case 917:
            itemDef.modelID = 23126;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.modelZoom = 1400;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 23125;
            itemDef.femaleEquip1 = 23125;
            itemDef.name = "God Fusion Goku Legs";
            break;

        case 918:
            itemDef.modelID = 23128;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.modelZoom = 1400;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 23127;
            itemDef.femaleEquip1 = 23127;
            itemDef.name = "God Fusion Goku Platebody";
            break;

        case 921:
            itemDef.modelID = 23779;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.modelZoom = 1400;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 23778;
            itemDef.femaleEquip1 = 23778;
            itemDef.name = "God Fusion Goku Gloves";
            break;

        case 1499:
            itemDef.name = "Jinni amulet";
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            break;

        case 15012:
            itemDef.name = "Jinni ring (i)";
            itemDef.actions[1] = "Equip";
            break;

        case 19158:
            itemDef.modelID = 40249;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 40249;
            itemDef.femaleEquip1 = 40249;
            itemDef.name = "Sephiroth's gloves";
            break;
        case 19619:
            itemDef.modelID = 28377;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.maleEquip1 = 28378;
            itemDef.femaleEquip1 = 28378;
            itemDef.name = "Heated Helmet";
            break;

        case 732:
			ItemDef.copyModel(itemDef, 7478);
            itemDef.name = "DBZ Token";
            break;

        case 1543:
            itemDef.actions = new String[5];
            itemDef.actions[2] = "Open";
            itemDef.modelID = 23375;
            itemDef.name = "Medium Key";
            break;


        case 18022:
            itemDef.actions = new String[5];
            itemDef.modelID = 59511;
            ItemDef.copyMostDefs(itemDef, 1543);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.name = "Summer Prize Key";
            break;       
            
        case 18023://59512
            itemDef.actions = new String[5];
            itemDef.modelID = 59512;
            ItemDef.copyMostDefs(itemDef, 405);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.name = "Summer Prize Chest";
            itemDef.animateInventory = true;
            break;   
            
            
        case 5205:
            itemDef.actions = new String[5];
            itemDef.actions[2] = "Open";
            itemDef.modelID = 32290;
            ItemDef.copyMostDefs(itemDef, 1543);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.name = "@red@Bloodslayer Key";
            break;
            
        case 11006:
            itemDef.actions = new String[5];
            itemDef.actions[2] = "Open";
            itemDef.modelID = 32377;
            ItemDef.copyMostDefs(itemDef, 1543);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.name = "@enc@Enchanted Key";
            break;

        case 3921:
            itemDef.actions = new String[5];
            itemDef.actions[2] = "Open";
            itemDef.modelID = 23375;
			itemDef.modelZoom = 1416;
            itemDef.name = "Sephiroths Chest Key(1/3)";
            break;

        case 13999:
			itemDef.modelID = 44214;
            itemDef.modelZoom = 1696;
            itemDef.rotationX = 0;
            itemDef.rotationY = 300;
            itemDef.modelOffsetY = 0;
			itemDef.animateInventory = true;
            itemDef.name = "OP Crystal";
            break;

        case 85:
            itemDef.name = "Upgraded Key";
            break;



        case 13727:
            itemDef.name = "@yel@AFK Fragments";
            break;

        case 14006:
            itemDef.modelID = 23373;
            itemDef.maleEquip1 = 23374;
            itemDef.femaleEquip1 = 23374;
            itemDef.name = "Crystal staff";
            break;
		case 19470:
            itemDef.modelID = 28379;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 28380;
            itemDef.femaleEquip1 = 28380;
            itemDef.name = "Heated Platebody";
            break;
		case 14980:
			itemDef.name = "Pet Georgie";
            itemDef.modelID = 74065;
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 14993:
			itemDef.name = "Pet Freddy Kruger";
            itemDef.modelID = 40208;
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 14999:
			itemDef.name = "Pet Michael Myers";
            itemDef.modelID = 40214;
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 15007:
			itemDef.name = "Pet Jason";
            itemDef.modelID = 40501;
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 15011:
			itemDef.name = "Pet Slenderman";
            itemDef.modelID = 40504;
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
        case 19471:
            itemDef.modelID = 28381;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 28382;
            itemDef.femaleEquip1 = 28382;
            itemDef.name = "Heated Platelegs";
            break;
        case 19472:
            itemDef.modelID = 28383;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 800;
            itemDef.maleEquip1 = 28384;
            itemDef.femaleEquip1 = 28384;
            itemDef.name = "Heated Gloves";
            break;
        case 19473:
            itemDef.modelID = 28385;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.maleEquip1 = 28385;
            itemDef.femaleEquip1 = 28385;
            itemDef.name = "Heated Boots";
            break;
        case 19474:
            itemDef.modelID = 28386;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 28387;
            itemDef.femaleEquip1 = 28387;
            itemDef.name = "Heated Wings";
            break;
        case 19620:
            itemDef.modelID = 28388;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 28389;
            itemDef.femaleEquip1 = 28389;
            itemDef.name = "Dagger of Trinity";
            break;

        case 16503:
            itemDef.modelID = 60933;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            changeTexture(id, 60, 57);
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 60934;
            itemDef.femaleEquip1 = 60934;
            itemDef.name = "Asmodeus Helmet";
            break;
            case 16504:
                itemDef.modelID = 60935;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                changeTexture(id, 60, 57);
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 60936;
                itemDef.femaleEquip1 = 60936;
                itemDef.name = "Asmodeus Platebody";
                break;

            case 16505:
                itemDef.modelID = 60937;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                changeTexture(id, 60, 57);
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 60940;
                itemDef.femaleEquip1 = 60940;
                itemDef.name = "Asmodeus Platelegs";
                break;

            case 16506:
                itemDef.modelID = 60941;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                changeTexture(id, 60, 57);
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 60942;
                itemDef.femaleEquip1 = 60942;
                itemDef.name = "Asmodeus Gloves";
                break;
            case 16508:
                itemDef.modelID = 60947;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                changeTexture(id, 60, 57);
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 60947;
                itemDef.femaleEquip1 = 60947;
                itemDef.name = "Asmodeus Boots";
                break;
            
        case 19714:
            itemDef.modelID = 23074;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 23075;
            itemDef.femaleEquip1 = 23075;
            itemDef.name = "Solace Helmet";
            break;
            case 19715:
                itemDef.modelID = 23076;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23077;
                itemDef.femaleEquip1 = 23077;
                itemDef.name = "Solace Platebody";
                break;

            case 19716:
                itemDef.modelID = 23078;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23079;
                itemDef.femaleEquip1 = 23079;
                itemDef.name = "Solace Platelegs";
                break;


            case 924:
                itemDef.modelID = 23371;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23370;
                itemDef.femaleEquip1 = 23370;
    			changeTexture(id, 70, 70);
                itemDef.name = "Toxic Platelegs";
                break;

            case 19717:
                itemDef.modelID = 23080;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23081;
                itemDef.femaleEquip1 = 23081;
                itemDef.name = "Solace Gloves";
                break;
            case 19718:
                itemDef.modelID = 23082;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23082;
                itemDef.femaleEquip1 = 23082;
                itemDef.name = "Solace Boots";
                break;

            case 3082:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                itemDef.name = "Jokers Bow";
                break;
            case 3974:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 11587:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 11588:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 11589:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 11591:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 12708:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 4775:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 5174:
                itemDef.name = "@red@Reapers blade";
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 5178:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 5201:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 11732:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 17909:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 17911:
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 12927:
            	itemDef.modelID = 25000;
            	itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.modelZoom = 1158;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -7;
                itemDef.modelOffsetX = 4;
                itemDef.maleEquip1 = 14403;
    			itemDef.femaleEquip1 = 14403;
    			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
                itemDef.name = "Mega Toxic Blowpipe";
                break;



            case 19719:
                itemDef.modelID = 23083;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23084;
                itemDef.femaleEquip1 = 23084;
                itemDef.name = "Solace Cape";
                break;

            case 19153:
                itemDef.modelID = 23427;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23428;
                itemDef.femaleEquip1 = 23428;
                itemDef.name = "Vorago's Cape";
                break;



    		case 9481:
    			itemDef.name = "Perfect cell helm";
    			itemDef.modelID = 23809;
    			itemDef.maleEquip1 = 23810;
    			itemDef.femaleEquip1 = 23810;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 9482:
    			itemDef.name = "Perfect cell body";
    			itemDef.modelID = 23811;
    			itemDef.maleEquip1 = 23812;
    			itemDef.femaleEquip1 = 23812;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;


    		case 9483:
    			itemDef.name = "Perfect cell legs";
    			itemDef.modelID = 23813;
    			itemDef.maleEquip1 = 23814;
    			itemDef.femaleEquip1 = 23814;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;



    		case 9484:
    			itemDef.name = "Kid Buu Helm";
    			itemDef.modelID = 23816;
    			itemDef.maleEquip1 = 23817;
    			itemDef.femaleEquip1 = 23817;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;


    		case 9485:
    			itemDef.name = "Kid Buu Body";
    			itemDef.modelID = 23818;
    			itemDef.maleEquip1 = 23819;
    			itemDef.femaleEquip1 = 23819;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;


    		case 9486:
    			itemDef.name = "Kid Buu Legs";
    			itemDef.modelID = 23820;
    			itemDef.maleEquip1 = 23821;
    			itemDef.femaleEquip1 = 23821;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 16579:
    			itemDef.name = "Pet Kid Buu";
                itemDef.modelID = 23803;
                itemDef.modelZoom = 2750;
                itemDef.rotationY = 340;
                itemDef.rotationX = 0;
    			itemDef.groundActions = new String[] { null, null, "Take", null, null };
    			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
    			break;


    		case 8703:
    			itemDef.name = "@gre@Toxic Nightmare staff";
    			ItemDef mimic = ItemDef.forID(18684);
    			itemDef.modelID = 4779;
    			itemDef.maleEquip1 = 4780;
    			itemDef.femaleEquip1 = 4780;
                //itemDef.modelZoom = 2750;
    			itemDef.modelOffset1 = mimic.modelOffset1;
    			itemDef.modelOffsetX = mimic.modelOffsetX;
    			itemDef.modelOffsetY = mimic.modelOffsetY;
    			itemDef.rotationX = mimic.rotationX;
    			itemDef.rotationY = mimic.rotationY;
    			itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
    			itemDef.actions[2] = null;
                itemDef.actions[4] = "Drop";
    			break;
    			
    		case 8705:
    			itemDef.name = "@red@Thammaron's sceptre";
    			ItemDef mimicdef = ItemDef.forID(18684);
    			itemDef.modelID = 48776;
    			itemDef.maleEquip1 = 48775;
    			itemDef.femaleEquip1 = 48775;
                //itemDef.modelZoom = 2750;
    			itemDef.modelOffset1 = mimicdef.modelOffset1;
    			itemDef.modelOffsetX = mimicdef.modelOffsetX;
    			itemDef.modelOffsetY = mimicdef.modelOffsetY;
    			itemDef.rotationX = mimicdef.rotationX;
    			itemDef.rotationY = mimicdef.rotationY;
    			itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
    			itemDef.actions[2] = null;
                itemDef.actions[4] = "Drop";
    			break;
    			
    		case 8707:
    			itemDef.name = "@yel@Clown shoes";
    			ItemDef mimicdef1 = ItemDef.forID(11733);
    			itemDef.modelID = 48777;
    			itemDef.maleEquip1 = 48777;
    			itemDef.femaleEquip1 = 48777;
                //itemDef.modelZoom = 2750;
    			itemDef.modelOffset1 = mimicdef1.modelOffset1;
    			itemDef.modelOffsetX = mimicdef1.modelOffsetX;
    			itemDef.modelOffsetY = mimicdef1.modelOffsetY;
    			itemDef.rotationX = mimicdef1.rotationX;
    			itemDef.rotationY = mimicdef1.rotationY;
    			itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
    			itemDef.actions[2] = null;
                itemDef.actions[4] = "Drop";
    			break;
    			
    		case 8709:
    			itemDef.name = "@yel@Clown mask";
    			ItemDef mimicdef2 = ItemDef.forID(13168);
    			itemDef.modelID = 48782;
    			itemDef.maleEquip1 = 48778;
    			itemDef.femaleEquip1 = 48778;
                itemDef.modelZoom = 2000;
    			itemDef.modelOffset1 = mimicdef2.modelOffset1;
    			itemDef.modelOffsetX = mimicdef2.modelOffsetX;
    			itemDef.modelOffsetY = mimicdef2.modelOffsetY;
    			itemDef.rotationX = mimicdef2.rotationX;
    			itemDef.rotationY = mimicdef2.rotationY;
    			itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
    			itemDef.actions[2] = null;
                itemDef.actions[4] = "Drop";
    			break;
    			
    		case 8713:
    			itemDef.name = "@yel@SebZero Mask";
    			ItemDef mimicdef3 = ItemDef.forID(13168);
    			itemDef.modelID = 48793;
    			itemDef.maleEquip1 = 48794;
    			itemDef.maleEquip2 = 48790;
    			itemDef.femaleEquip1 = 48794;
    			itemDef.femaleEquip2 = 48795;
               // itemDef.modelZoom = 2000;
    			itemDef.modelOffset1 = mimicdef3.modelOffset1;
    			itemDef.modelOffsetX = mimicdef3.modelOffsetX;
    			itemDef.modelOffsetY = mimicdef3.modelOffsetY;
    			itemDef.rotationX = mimicdef3.rotationX;
    			itemDef.rotationY = mimicdef3.rotationY;
    			itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
    			itemDef.actions[2] = null;
                itemDef.actions[4] = "Drop";
    			break;
    			
    		case 8711:
    			itemDef.name = "@yel@Clown bow-tie";
    			ItemDef mimicdef13 = ItemDef.forID(1464);
    			itemDef.modelID = 48783;
    			itemDef.maleEquip1 = 48779;
    			itemDef.femaleEquip1 = 48779;
                //itemDef.modelZoom = 2000;
    			itemDef.modelOffset1 = mimicdef13.modelOffset1;
    			itemDef.modelOffsetX = mimicdef13.modelOffsetX;
    			itemDef.modelOffsetY = mimicdef13.modelOffsetY;
    			itemDef.rotationX = mimicdef13.rotationX;
    			itemDef.rotationY = mimicdef13.rotationY;
    			itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
    			itemDef.actions[2] = null;
                itemDef.actions[4] = "Drop";
    			break;
    			
    		case 8701:
    			itemDef.name = "@cya@Vorkath's shield";
    			ItemDef copy = ItemDef.forID(6524);
    			itemDef.modelID = 48769;
    			itemDef.femaleEquip1 = 48770;
    			itemDef.maleEquip1 = 48770;
    			itemDef.modelOffset1 = copy.modelOffset1;
    			itemDef.modelOffsetX = copy.modelOffsetX;
    			itemDef.modelOffsetY = copy.modelOffsetY;
    			//itemDef.modelZoom = copy.modelZoom;
    			itemDef.rotationX = copy.rotationX;
    			itemDef.rotationY = copy.rotationY;
    			itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
    			itemDef.actions[2] = "@or2@Upgrade";
                itemDef.actions[4] = "Drop";
    			break;


    		case 4279:
    			itemDef.name = "OP God Shield";
    			ItemDef itemdef7 = ItemDef.forID(6524);
    			itemDef.modelID = 44310;
    			itemDef.femaleEquip1 = 44311;
    			itemDef.maleEquip1 = 44311;
    			itemDef.modelOffset1 = itemdef7.modelOffset1;
    			itemDef.modelOffsetX = itemdef7.modelOffsetX;
    			itemDef.modelOffsetY = itemdef7.modelOffsetY;
    			itemDef.modelZoom = itemdef7.modelZoom;
    			itemDef.rotationX = itemdef7.rotationX;
    			itemDef.rotationY = itemdef7.rotationY;
    			itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
    			itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
    			break;


    		case 3092:
    			itemDef.name = "Cape of Gods";
                   break;



    		case 10296:
    			itemDef.name = "@pur@Ninja's helmet";
                itemDef.modelID = 25149;
                itemDef.maleEquip1 = 25149;
                itemDef.femaleEquip1 = 25149;
                itemDef.actions = new String[5];
     			itemDef.actions[1] = "Wear";
     			itemDef.actions[4] = "Drop";
                itemDef.modelZoom = 1278;
                itemDef.rotationX = 9;
                itemDef.rotationY = 339;
    			itemDef.modelOffsetY = -78;
      			itemDef.modelOffset1 = -9;
                itemDef.stackable = false;
    			break;
    			
    		case 19173:
    			itemDef.name = "@pur@Ninja's Platebody";
                itemDef.modelID = 25150;
                itemDef.maleEquip1 = 25150;
                itemDef.femaleEquip1 = 25150;
                itemDef.actions = new String[5];
     			itemDef.actions[1] = "Wear";
     			itemDef.actions[4] = "Drop";
                itemDef.modelZoom = 1504;
                ItemDef.copyMostDefs(itemDef, 19908);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			//itemDef.modelZoom = 2200;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
                itemDef.stackable = false;
    			break;
    			
    			
    		case 19175:
    			itemDef.name = "@pur@Ninja's Platelegs";
                itemDef.modelID = 25151;
                itemDef.maleEquip1 = 25151;
                itemDef.femaleEquip1 = 25151;
                itemDef.actions = new String[5];
     			itemDef.actions[1] = "Wear";
     			itemDef.actions[4] = "Drop";
                itemDef.modelZoom = 1243;
                itemDef.rotationX = 43;
                itemDef.rotationY = 43;
                itemDef.stackable = false;
      			//itemDef.modelOffsetY = 98;
    			break;
    			
    		case 20453:
    			itemDef.name = "@pur@Ninja's Boots";
                itemDef.modelID = 25152;
                itemDef.maleEquip1 = 25152;
                itemDef.femaleEquip1 = 25152;
                itemDef.actions = new String[5];
     			itemDef.actions[1] = "Wear";
     			itemDef.actions[4] = "Drop";
                itemDef.modelZoom = 913;
                itemDef.rotationX = 9;
                itemDef.rotationY = 0;
      			itemDef.modelOffsetY = 5;
      			itemDef.modelOffset1 = -4;
                itemDef.stackable = false;
    			break;   
    			
    		case 20464:
    			itemDef.name = "@pur@Ninja's Gloves";
                itemDef.modelID = 25153;
                itemDef.maleEquip1 = 25153;
                itemDef.femaleEquip1 = 25153;
                itemDef.actions = new String[5];
     			itemDef.actions[1] = "Wear";
     			itemDef.actions[4] = "Drop";
                itemDef.modelZoom = 1157;
                itemDef.rotationX = 270;
                itemDef.rotationY = 220;
      			itemDef.modelOffsetY = 252;
      			itemDef.modelOffset1 = -4;
                itemDef.stackable = false;
    			break;
    			
    		case 11952:
    			itemDef.name = "@pur@Ninja's Sword";
                itemDef.modelID = 37284;
                itemDef.maleEquip1 = 37284;
                itemDef.femaleEquip1 = 37284;
                itemDef.actions = new String[5];
    			itemDef.actions = new String[] { null, "Equip", "@or2@Operate", null, "Drop" };
                itemDef.modelZoom = 1052;
                itemDef.rotationX = 1157;
                itemDef.rotationY = 809;
    			itemDef.modelOffsetY = 26;
      			itemDef.modelOffset1 = -43;
                itemDef.stackable = false;
    			break;
    		case 14287:
    			itemDef.name = "@pur@Farm God Scythe";
                itemDef.modelID = 74557;
                itemDef.maleEquip1 = 74557;
                itemDef.femaleEquip1 = 74557;
                itemDef.actions = new String[5];
     			itemDef.actions[1] = "Wear";
     			itemDef.actions[4] = "Drop";
                itemDef.modelZoom = 1052;
                itemDef.rotationX = 1157;
                itemDef.rotationY = 809;
    			itemDef.modelOffsetY = 26;
      			itemDef.modelOffset1 = -43;
                itemDef.stackable = false;
    			break;
    		case 4507:
    			itemDef.name = "@whi@Ninja's Offhand";
                itemDef.modelID = 37283;
                itemDef.maleEquip1 = 37283;
                itemDef.femaleEquip1 = 37283;
                itemDef.actions = new String[5];
     			itemDef.actions[1] = "Wear";
     			itemDef.actions[4] = "Drop";
                itemDef.modelZoom = 1104;
                itemDef.rotationX = 357;
                itemDef.rotationY = 235;
    			itemDef.modelOffsetY = 26;
      			itemDef.modelOffset1 = 9;
                itemDef.stackable = false;
    			break;
    		case 4202:
    			itemDef.name = "10% Ironman Ring";
                   break;

    		case 6484:
    			itemDef.name = "Pet Scrooge Mcduck";
                itemDef.modelID = 40025;
                itemDef.modelZoom = 2750;
                itemDef.rotationY = 340;
                itemDef.rotationX = 0;
    			itemDef.groundActions = new String[] { null, null, "Take", null, null };
    			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
    			break;

    		case 16580:
    			itemDef.name = "Pet Perfect Cell";
                itemDef.modelID = 23804;
                itemDef.modelZoom = 2750;
                itemDef.rotationY = 340;
                itemDef.rotationX = 0;
    			itemDef.groundActions = new String[] { null, null, "Take", null, null };
    			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
    			break;

    		case 9487:
    			itemDef.name = "Freiza Helm";
    			itemDef.modelID = 23822;
    			itemDef.maleEquip1 = 23823;
    			itemDef.femaleEquip1 = 23823;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;


    		case 9488:
    			itemDef.name = "Freiza  Body";
    			itemDef.modelID = 23824;
    			itemDef.maleEquip1 = 23825;
    			itemDef.femaleEquip1 = 23825;
    			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
    			itemDef.stackable = false;
    			break;


    		case 9489:
    			itemDef.name = "Freiza  Legs";
    			itemDef.modelID = 23826;
    			itemDef.maleEquip1 = 23827;
    			itemDef.femaleEquip1 = 23827;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 9490:
    			itemDef.name = "Freiza Gloves";
    			itemDef.modelID = 23828;
    			itemDef.maleEquip1 = 23829;
    			itemDef.femaleEquip1 = 23829;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 9491:
    			itemDef.name = "Freiza Boots";
    			itemDef.modelID = 23830;
    			itemDef.maleEquip1 = 23830;
    			itemDef.femaleEquip1 = 23830;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 9492:
    			itemDef.name = "Herbal Bow";
    			itemDef.modelID = 23831;
    			itemDef.maleEquip1 = 23832;
    			itemDef.femaleEquip1 = 23832;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 13201:
    			itemDef.name = "Supreme Herbal Bow";
    			itemDef.modelID = 40238;
    			itemDef.maleEquip1 = 40239;
    			itemDef.femaleEquip1 = 40239;
                ItemDef.copyMostDefs(itemDef, 64);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.modelZoom = 2200;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;


    		case 11148:
    			itemDef.name = "Cronus Helmet";
    			itemDef.modelID = 40277;
    			itemDef.maleEquip1 = 40278;
    			itemDef.femaleEquip1 = 40278;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;
    		case 11149:
    			itemDef.name = "Cronus Platebody";
    			itemDef.modelID = 40279;
    			itemDef.maleEquip1 = 40280;
    			itemDef.femaleEquip1 = 40280;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 11150:
    			itemDef.name = "Cronus Platelegs";
    			itemDef.modelID = 40281;
    			itemDef.maleEquip1 = 40282;
    			itemDef.femaleEquip1 = 40282;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 11160:
    			itemDef.name = "Cronus Gloves";
    			itemDef.modelID = 40283;
    			itemDef.maleEquip1 = 40283;
    			itemDef.femaleEquip1 = 40283;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 11161:
    			itemDef.name = "Cronus Boots";
    			itemDef.modelID = 40284;
    			itemDef.maleEquip1 = 40284;
    			itemDef.femaleEquip1 = 40284;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;




    		case 11143:
    			itemDef.name = "Apollo Helmet";
                ItemDef.copyMostDefs(itemDef, 1163);
				itemDef.modelOffset1 = itemDef.modelOffset1;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				//itemDef.modelZoom = 2200;
				itemDef.rotationX = itemDef.rotationX;
				itemDef.rotationY = itemDef.rotationY;
    			itemDef.modelID = 40268;
    			itemDef.maleEquip1 = 40269;
    			itemDef.femaleEquip1 = 40269;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;
    		case 11144:
    			itemDef.name = "Apollo Platebody";
    			itemDef.modelID = 40270;
                ItemDef.copyMostDefs(itemDef, 1127);
				itemDef.modelOffset1 = itemDef.modelOffset1;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				//itemDef.modelZoom = 2200;
				itemDef.rotationX = itemDef.rotationX;
				itemDef.rotationY = itemDef.rotationY;
                itemDef.animateInventory = true;
    			itemDef.maleEquip1 = 40271;
    			itemDef.femaleEquip1 = 40271;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 11145:
    			itemDef.name = "Apollo Platelegs";
    			itemDef.modelID = 40272;
                ItemDef.copyMostDefs(itemDef, 1079);
				itemDef.modelOffset1 = itemDef.modelOffset1;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				//itemDef.modelZoom = 2200;
				itemDef.rotationX = itemDef.rotationX;
				itemDef.rotationY = itemDef.rotationY;
    			itemDef.maleEquip1 = 40273;
    			itemDef.femaleEquip1 = 40273;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 11146:
    			itemDef.name = "Apollo Gloves";
    			itemDef.modelID = 40274;
                ItemDef.copyMostDefs(itemDef, 2942);
				itemDef.modelOffset1 = itemDef.modelOffset1;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				//itemDef.modelZoom = 2200;
				itemDef.rotationX = itemDef.rotationX;
				itemDef.rotationY = itemDef.rotationY;
    			itemDef.maleEquip1 = 40275;
    			itemDef.femaleEquip1 = 40275;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 11147:
    			itemDef.name = "Apollo Boots";
    			itemDef.modelID = 40276;
                ItemDef.copyMostDefs(itemDef, 11733);
				itemDef.modelOffset1 = itemDef.modelOffset1;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				//itemDef.modelZoom = 2200;
				itemDef.rotationX = itemDef.rotationX;
				itemDef.rotationY = itemDef.rotationY;
    			itemDef.maleEquip1 = 40276;
    			itemDef.femaleEquip1 = 40276;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;



    		case 9493:
    			itemDef.name = "Herbal Helm";
    			itemDef.modelID = 23833;
    			itemDef.maleEquip1 = 23834;
    			itemDef.femaleEquip1 = 23834;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 9494:
    			itemDef.name = "Herbal Body";
    			itemDef.modelID = 23835;
    			itemDef.maleEquip1 = 23836;
    			itemDef.femaleEquip1 = 23836;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

    		case 9495:
    			itemDef.name = "Herbal Legs";
    			itemDef.modelID = 23837;
    			itemDef.maleEquip1 = 23838;
    			itemDef.femaleEquip1 = 23838;
    			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
    			itemDef.stackable = false;
    			break;

            case 3874:
                itemDef.name = "Bloody Skeleton Mask";
                itemDef.modelID = 40205;
                itemDef.maleEquip1 = 40200;
                itemDef.femaleEquip1 = 40200;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.stackable = false;
                ItemDef.copyMostDefs(itemDef, 19101);
				itemDef.modelOffset1 = itemDef.modelOffset1;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				
				itemDef.rotationX = itemDef.rotationX;
				itemDef.rotationY = itemDef.rotationY;
                break;

            case 3875:
                itemDef.name = "Bloody Skeleton Body";
                itemDef.modelID = 40201;
                itemDef.maleEquip1 = 40202;
                itemDef.femaleEquip1 = 40202;
                itemDef.actions = new String[5];
                ItemDef.copyMostDefs(itemDef, 1127);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.stackable = false;
                break;

            case 3876:
                itemDef.name = "Bloody Skeleton Legs";
                itemDef.modelID = 40203;
                itemDef.maleEquip1 = 40204;
                itemDef.femaleEquip1 = 40204;
                itemDef.actions = new String[5];
                ItemDef.copyMostDefs(itemDef, 1079);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.stackable = false;
                break;


    		case 16584:
    			itemDef.name = "Frieza Pet (second form)";
                itemDef.modelID = 23806;
                itemDef.modelZoom = 2750;
                itemDef.rotationY = 340;
                itemDef.rotationX = 0;
    			itemDef.groundActions = new String[] { null, null, "Take", null, null };
    			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
    			break;

    		case 16583:
    			itemDef.name = "Frieza Pet (final form)";
                itemDef.modelID = 23807;
                itemDef.modelZoom = 2750;
                itemDef.rotationY = 340;
                itemDef.rotationX = 0;
    			itemDef.groundActions = new String[] { null, null, "Take", null, null };
    			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
    			break;

    		case 16581:
    			itemDef.name = "Frieza Pet (first form)";
                itemDef.modelID = 23805;
                itemDef.modelZoom = 2750;
                itemDef.rotationY = 340;
                itemDef.rotationX = 0;
    			itemDef.groundActions = new String[] { null, null, "Take", null, null };
    			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
    			break;

            case 79:
                itemDef.modelID = 23176;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 1000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23177;
                itemDef.femaleEquip1 = 23177;
                itemDef.name = "Mystery Cape";
                break;

            case 80:
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                itemDef.modelID = 23178;
                itemDef.name = "BFG Mainhand";
                itemDef.modelZoom = 900;
                itemDef.rotationY = 165;
                itemDef.rotationX = 99;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 0;
                itemDef.maleEquip1 = 100340;
                itemDef.femaleEquip1 = 100340;
                itemDef.description = "CUSTOM BFG-900.";
                break;

            case 755:
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                itemDef.modelID = 23178;
                itemDef.name = "BFG Offhand";
                itemDef.modelZoom = 900;
                itemDef.rotationY = 165;
                itemDef.rotationX = 99;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 0;
                itemDef.maleEquip1 = 65473;
                itemDef.femaleEquip1 = 65473;
                itemDef.description = "CUSTOM BFG-900 OH.";
                break;

            case 3971:
                itemDef.modelID = 44393;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.maleEquip1 = 44392;
                itemDef.femaleEquip1 = 44392;
                itemDef.name = "Archeon bow";
                break;

            case 6499:
                itemDef.modelID = 44701;
                itemDef.actions = new String[5];
                itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
                itemDef.maleEquip1 = 44701;
                itemDef.femaleEquip1 = 44701;
                itemDef.modelZoom = 1800;
                itemDef.rotationX = 357;
                itemDef.rotationY = 113;
    			itemDef.modelOffsetY = 40;
      			itemDef.modelOffset1 = 10;
                itemDef.name = "@red@Owner Bow";
                break;

            case 5265:
                itemDef.modelID = 44701;
                itemDef.actions = new String[5];
                itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
                itemDef.maleEquip1 = 44701;
                itemDef.femaleEquip1 = 44701;
                itemDef.modelZoom = 1800;
                itemDef.rotationX = 357;
                itemDef.rotationY = 113;
    			itemDef.modelOffsetY = 40;
      			itemDef.modelOffset1 = 10;
                itemDef.name = "@red@Q's Owner Bow";
                break;

                
            case 16468:
                itemDef.modelID = 60982;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.maleEquip1 = 60982;
                itemDef.femaleEquip1 = 60982;
                itemDef.name = "Akers Bow";
                break;
                
            case 16459:
                itemDef.modelID = 44701;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.maleEquip1 = 44701;
                itemDef.femaleEquip1 = 44701;
                itemDef.name = "L33t's Bow";
                break;
                
                
            case 8818:
                itemDef.modelID = 60841;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.maleEquip1 = 60841;
                itemDef.femaleEquip1 = 60841;
                itemDef.name = "Emerald Bow";
                break;
                
                
                
            case 14550:
                itemDef.modelID = 60879;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.maleEquip1 = 60879;
                itemDef.femaleEquip1 = 60879;
                itemDef.name = "Monkeys Custom Staff";
                break;

            case 18866:
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.name = "Ki's Sword";
                break;

            case 6990:
            	itemDef.modelZoom = 1329;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 0;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = -1;
            	itemDef.modelID = 44421;
            	itemDef.name = "Byakuya set Package";
            	itemDef.actions = new String[5];
            	itemDef.actions[0] = "Open";
            	break;

            case 13195:
            	itemDef.modelZoom = 1329;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 0;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = -1;
            	itemDef.modelID = 44421;
            	itemDef.name = "Thousands Chest";
            	itemDef.actions = new String[5];
            	itemDef.actions[0] = "Open";
            	break;
            case 13196:
            	itemDef.modelZoom = 1329;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 0;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = -1;
            	itemDef.modelID = 44422;
            	itemDef.name = "Bloodbelly Chest";
            	itemDef.actions = new String[5];
            	itemDef.actions[0] = "Open";
            	break;
            case 13197:
            	itemDef.modelZoom = 1329;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 0;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = -1;
            	itemDef.modelID = 44423;
            	itemDef.name = "Exotic Chest";
            	itemDef.actions = new String[5];
            	itemDef.actions[0] = "Open";
            	break;
            case 13198:
            	itemDef.modelZoom = 1329;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 0;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = -1;
            	itemDef.modelID = 44424;
            	itemDef.name = "Frozen Chest";
            	itemDef.actions = new String[5];
            	itemDef.actions[0] = "Open";
            	break;

            case 6309:
                ItemDef.copyMostDefs(itemDef, 16711);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.modelZoom = 1150;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
            	itemDef.modelID = 44479;
            	itemDef.name = "Crusher Chest";
            	itemDef.actions = new String[5];
            	itemDef.actions[0] = "Open";
            	break;


            case 18457:
            	//itemDef.modelZoom = 1329;
                ItemDef.copyMostDefs(itemDef, 16711);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.modelZoom = 1150;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
            	itemDef.modelID = 44479;
            	itemDef.name = "Bloodlightning Chest";
            	itemDef.actions = new String[5];
            	itemDef.actions[0] = "Open";
            	break;



            case 18458:
            	//itemDef.modelZoom = 1329;
                ItemDef.copyMostDefs(itemDef, 16711);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.modelZoom = 1150;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
            	itemDef.modelID = 44479;
            	itemDef.name = "Bfg-set Chest";
            	itemDef.actions = new String[5];
            	itemDef.actions[0] = "Open";
            	break;
            	
            case 18459:
            	//itemDef.modelZoom = 1329;
                ItemDef.copyMostDefs(itemDef, 16711);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.modelZoom = 1150;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
            	itemDef.modelID = 44479;
            	itemDef.name = "Bloodset Chest";
            	itemDef.actions = new String[5];
            	itemDef.actions[0] = "Open";
            	break;
            	
            case 18460:
            	//itemDef.modelZoom = 1329;
                ItemDef.copyMostDefs(itemDef, 16711);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.modelZoom = 1150;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
            	itemDef.modelID = 44479;
            	itemDef.name = "Imbued package Chest";
            	itemDef.actions = new String[5];
            	itemDef.actions[0] = "Open";
            	break;
            	
            case 405:
            	itemDef.actions[2] = "Open-all";
            	itemDef.modelID = 23600;
            	break;

            case 4636:
                itemDef.modelID = 44395;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.maleEquip1 = 44396;
                itemDef.femaleEquip1 = 44396;
                itemDef.name = "Support Aura";
                break;
            case 4637:
                itemDef.modelID = 44397;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.maleEquip1 = 44398;
                itemDef.femaleEquip1 = 44398;
                itemDef.name = "Moderator Aura";
                break;
            case 4650:
                itemDef.modelID = 44399;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.maleEquip1 = 44400;
                itemDef.femaleEquip1 = 44400;
                itemDef.name = "@yel@Administrator Aura";
                break;

                
            case 19810:
                ItemDef.copyMostDefs(itemDef, 16711);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.modelZoom = 2200;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
                itemDef.modelID = 61305;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.maleEquip1 = 61305;
                itemDef.femaleEquip1 = 61305;
                itemDef.name = "@blu@Discord Aura";
                break;

                
                
            case 4652:
                ItemDef.copyMostDefs(itemDef, 16711);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.modelZoom = 2200;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
                itemDef.modelID = 44401;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.maleEquip1 = 44401;
                itemDef.femaleEquip1 = 44401;
                itemDef.name = "Neo Aura";
                break;
                
                
            case 8562:
                itemDef.modelZoom = 3000;
                itemDef.rotationX = 0;
                itemDef.rotationY = 0;
    			itemDef.modelOffsetY = 0;
                itemDef.modelID = 23992;
                itemDef.maleEquip1 = 23992;
                itemDef.femaleEquip1 = 23992;
                itemDef.actions = new String[] {null, "Wear", null, null, null};
                itemDef.name = "@mag@Divine Aura";
                changeTexture(id, 40, 87); //55561
                itemDef.animateInventory = true;
                break;

                
            case 8566:
                itemDef.modelZoom = 3000;
                itemDef.rotationX = 0;
                itemDef.rotationY = 287;
    			itemDef.modelOffsetY = 0;
                itemDef.modelID = 23992;
                itemDef.maleEquip1 = 23992;
                itemDef.femaleEquip1 = 23992;
                itemDef.actions = new String[] {null, "Wear", null, null, null};
                itemDef.name = "@whi@SebZero Aura";
                changeTexture(id, 40, 83); //55561
                break;
                
            case 19469:
                itemDef.modelID = 99892;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 99891;
                itemDef.femaleEquip1 = 99891;
                itemDef.name = "Trimmed Darklord Cape";
                break;

            case 19720:
                itemDef.modelID = 23085;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23086;
                itemDef.femaleEquip1 = 23086;
    			itemDef.editedModelColor = new int[] { 73 };//old
    			itemDef.newModelColor = new int[] {68 };//new
                itemDef.name = "Staff of Valor";
                break;

            case 15649:
                itemDef.modelID = 90700;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.maleEquip1 = 90701;
                itemDef.femaleEquip1 = 90701;
    			itemDef.editedModelColor = new int[] { 40 };//old
    			itemDef.newModelColor = new int[] {68 };//new
                itemDef.name = "Galaxy Hood";
                break;

            case 15653:
                itemDef.modelID = 94628;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.maleEquip1 = 94629;
                itemDef.femaleEquip1 = 94629;
                itemDef.name = "Galaxy Trident";
                break;

            case 15650:
                itemDef.modelID = 90702;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                ItemDef.copyMostDefs(itemDef, 1127);
				itemDef.modelOffset1 = itemDef.modelOffset1;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				//itemDef.modelZoom = 2200;
				itemDef.rotationX = itemDef.rotationX;
				itemDef.rotationY = itemDef.rotationY;
                itemDef.animateInventory = true;
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.maleEquip1 = 90703;
                itemDef.femaleEquip1 = 90703;
                itemDef.name = "Galaxy Robe top";
                break;

            case 15651:
                itemDef.modelID = 90730;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                ItemDef.copyMostDefs(itemDef, 1079);
                itemDef.animateInventory = true;
  				itemDef.modelOffset1 = itemDef.modelOffset1;
  				itemDef.modelOffsetY = itemDef.modelOffsetY;
  				//itemDef.modelZoom = 2200;
  				itemDef.rotationX = itemDef.rotationX;
  				itemDef.rotationY = itemDef.rotationY;
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.maleEquip1 = 90731;
                itemDef.femaleEquip1 = 90731;
                itemDef.name = "Galaxy Robe bottoms";
                break;

            case 15652:
                itemDef.modelID = 83392;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 83393;
                itemDef.femaleEquip1 = 83393;
                itemDef.name = "Galaxy Mythical Cape";
                break;

            case 1127:
                itemDef.actions = new String[5];
    			itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
    			itemDef.actions[4] = "Drop";
                break;
            case 19722:
                itemDef.modelID = 23191;
                itemDef.actions = new String[5];
    			itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
    			itemDef.actions[4] = "Drop";
                ItemDef.copyMostDefs(itemDef, 1127);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			//itemDef.modelZoom = 2200;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
                itemDef.maleEquip1 = 23192;
                itemDef.femaleEquip1 = 23192;
                itemDef.name = "Blessed Platebody";
                break;

            case 13696:
    			ItemDef.copyModel(itemDef, 1499);
                itemDef.name = "Jinni amulet+";
                itemDef.actions[1] = "Equip";
                break;

            case 13697:
    			ItemDef.copyModel(itemDef, 15012);
                itemDef.name = "Jinni ring (i)+";
                itemDef.actions[1] = "Equip";
                break;
                
    		case 3973:
    			itemDef.name = "@mag@Jinni Cape";
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
    			changeTexture(id, 40, 64);
    			break;
    		case 4799:
    			itemDef.name = "@mag@Jinni Helmet";
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
    			changeTexture(id, 40, 64);
    			break;
    		case 4800:
    			itemDef.name = "@mag@Jinni Platebody";
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
    			changeTexture(id, 40, 64);
    			break;
    		case 4801:
    			itemDef.name = "@mag@Jinni Platelegs";
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
    			changeTexture(id, 40, 64);
    			break;
    		case 5079:
    			itemDef.name = "@mag@Jinni Boots";
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
    			changeTexture(id, 60, 64);
    			break;

    			
    		case 13698:
    			ItemDef.copyModel(itemDef, 3973);
    			
    			itemDef.name = "Jinni Cape+";
    			break;
    		case 13699:
    			ItemDef.copyModel(itemDef, 4799);
    			itemDef.name = "Jinni Helmet+";
    			break;
    		case 13700:
    			ItemDef.copyModel(itemDef, 4800);
    			itemDef.name = "Jinni Platebody+";
    			break;
    		case 13701:
    			ItemDef.copyModel(itemDef, 4801);
    			itemDef.name = "Jinni Platelegs+";
    			break;

            case 16430:
                itemDef.modelID = 23341;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                ItemDef.copyMostDefs(itemDef, 1195);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			//itemDef.modelZoom = 2200;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
    			itemDef.originalModelColors = new int[] { 40};
    			itemDef.newModelColor = new int[] { 71 };
                itemDef.maleEquip1 = 23342;
                itemDef.femaleEquip1 = 23342;
                itemDef.name = "Blessed Kiteshield";
                break;

            case 19723:
                itemDef.modelID = 23189;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                ItemDef.copyMostDefs(itemDef, 1079);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			//itemDef.modelZoom = 2200;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
                itemDef.maleEquip1 = 23190;
                itemDef.femaleEquip1 = 23190;
                itemDef.name = "Blessed Platelegs";
                break;
            case 18363:
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
            	break;
            case 15398:
                itemDef.name = "Blessed Ring";
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                break;
            case 1079:
                itemDef.actions = new String[5];
    			itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
    			itemDef.actions[4] = "Drop";
    			break;
            case 20002:
                itemDef.actions = new String[5];
    			itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
    			itemDef.actions[4] = "Drop";
    			break;
            case 20016:
            case 20017:
            case 20018:
            case 20022:
            case 20021:
                itemDef.actions = new String[5];
    			itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
    			itemDef.actions[4] = "Drop";
    			break;
            case 6733:
                itemDef.actions = new String[5];
    			itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
    			itemDef.actions[4] = "Drop";
    			break;
            case 15493:
                itemDef.modelID = 23301;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 1750;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23302;
                itemDef.femaleEquip1 = 23302;
                itemDef.name = "Athos Helmet";
                break;
            case 15494:
                itemDef.modelID = 23303;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 1750;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23304;
                itemDef.femaleEquip1 = 23304;
                itemDef.name = "Athos Platebody";
                break;

            case 15495:
                itemDef.modelID = 23305;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 1750;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23306;
                itemDef.femaleEquip1 = 23306;
                itemDef.name = "Athos Platelegs";
                break;

            case 19724:
                itemDef.modelID = 23093;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 800;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23093;
                itemDef.femaleEquip1 = 23093;
                itemDef.name = "Blessed Gloves";
                break;

            case 19725:
                itemDef.modelID = 23095;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 800;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23095;
                itemDef.femaleEquip1 = 23095;
                itemDef.name = "Blessed Boots";
                break;



            case 8664:
                itemDef.modelID = 23096;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23097;
                itemDef.femaleEquip1 = 23097;
                itemDef.name = "Exotic Staff";
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 62 };
                break;

            case 8665:
                itemDef.modelID = 40029;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 40027;
                itemDef.femaleEquip1 = 40027;
                itemDef.name = "Exotic Wings";
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 62 };
                break;


            case 8666:
                itemDef.modelID = 23098;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 1200;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23098;
                itemDef.femaleEquip1 = 23098;
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 62 };
                itemDef.name = "Exotic Boots";
                break;

            case 8667:
                itemDef.modelID = 23099;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 1200;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23100;
                itemDef.femaleEquip1 = 23100;
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 62 };
                itemDef.name = "Exotic Gloves";
                break;
            case 8668:
                itemDef.modelID = 23101;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 1200;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23102;
                itemDef.femaleEquip1 = 23102;
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 62 };
                itemDef.name = "Exotic Helmet";
                break;

            case 8669:
                itemDef.modelID = 23103;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23104;
                itemDef.femaleEquip1 = 23104;
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 62 };
                itemDef.name = "Exotic Platelegs";
                break;

            case 8670:
                itemDef.modelID = 23105;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23106;
                itemDef.femaleEquip1 = 23106;
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 62 };
                itemDef.name = "Exotic Platebody";
                break;









            case 19727:
                itemDef.modelID = 23096;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23097;
                itemDef.femaleEquip1 = 23097;
                itemDef.name = "Supreme Staff";
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 59 };
                break;

            case 6485:
                itemDef.modelID = 40029;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 40027;
                itemDef.femaleEquip1 = 40027;
                itemDef.name = "Supreme Wings";
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 59 };
                break;


            case 4766:
                itemDef.modelID = 44354;
                itemDef.actions = new String[5];
     			itemDef.actions[1] = "Wear";
     			itemDef.actions[4] = "Drop";
                itemDef.modelZoom = 1252;
                itemDef.rotationX = 1157;
                itemDef.rotationY = 809;
    			//itemDef.modelOffsetY = 26;
      			itemDef.modelOffset1 = -43;
                itemDef.stackable = false;
                itemDef.maleEquip1 = 44354;
                itemDef.femaleEquip1 = 44354;
                itemDef.name = "Bonescaled Scythe";
                break;
            case 4774:
                itemDef.modelID = 44355;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.maleEquip1 = 44355;
                itemDef.femaleEquip1 = 44355;
                itemDef.name = "Bonescaled Offhand";
                break;

            case 4776:
                itemDef.modelID = 44356;
                itemDef.actions = new String[5];
     			itemDef.actions[1] = "Wear";
     			itemDef.actions[4] = "Drop";
                itemDef.modelZoom = 1052;
                itemDef.rotationX = 1157;
                itemDef.rotationY = 809;
    			//itemDef.modelOffsetY = 26;
      			itemDef.modelOffset1 = -43;
                itemDef.stackable = false;
                itemDef.maleEquip1 = 44356;
                itemDef.femaleEquip1 = 44356;
                itemDef.name = "Bonescaled Waraxe";
                break;

            case 8657:
            	itemDef.modelID = 44424;
                itemDef.actions = new String[5];
                itemDef.actions[0] = "Open";
                itemDef.modelZoom = 1000;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 0;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = -1;
                itemDef.name = "Forgotten set pack";
                break;

            case 8658:
            	itemDef.modelID = 44421;
                itemDef.actions = new String[5];
                itemDef.actions[0] = "Open";
                itemDef.modelZoom = 1000;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 0;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = -1;
                itemDef.name = "Imbued pack";
                break;

            case 8659:
            	itemDef.modelID = 44490;
                itemDef.actions = new String[5];
                itemDef.actions[0] = "Claim";
                itemDef.modelZoom = 1200;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 14;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = 0;
                itemDef.name = "Investor donator rank";
                break;
            case 8660:
            	itemDef.modelID = 44490;
                itemDef.actions = new String[5];
                itemDef.actions[0] = "Claim";
                itemDef.modelZoom = 1200;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 14;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = 0;
                itemDef.name = "Celestial donator rank";
                break;
            case 8661:
            	itemDef.modelID = 44490;
                itemDef.actions = new String[5];
                itemDef.actions[0] = "Claim";
                itemDef.modelZoom = 1200;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 14;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = 0;
                itemDef.name = "Deluxe donator rank";
                break;
            case 8662:
            	itemDef.modelID = 44490;
                itemDef.actions = new String[5];
                itemDef.actions[0] = "Claim";
                itemDef.modelZoom = 1200;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 14;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = 0;
                itemDef.name = "Uber donator rank";
                break;
            case 8663:
            	itemDef.modelID = 44490;
                itemDef.actions = new String[5];
                itemDef.actions[0] = "Claim";
                itemDef.modelZoom = 1200;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 14;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = 0;
                itemDef.name = "Legendary donator rank";
                break;
            case 8671:
            	itemDef.modelID = 44490;
                itemDef.actions = new String[5];
                itemDef.actions[0] = "Claim";
                itemDef.modelZoom = 1200;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 14;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = 0;
                itemDef.name = "Extreme donator rank";
                break;
            case 8672:
            	itemDef.modelID = 44490;
                itemDef.actions = new String[5];
                itemDef.actions[0] = "Claim";
                itemDef.modelZoom = 1200;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 14;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = 0;
                itemDef.name = "Super donator rank";
                break;

            case 8673:
            	itemDef.modelID = 44422;
                itemDef.actions = new String[5];
                itemDef.actions[0] = "Claim";
                itemDef.modelZoom = 1200;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 14;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = 0;
                itemDef.name = "Investor Package";
                break;

            case 8674:
            	itemDef.modelID = 44423;
                itemDef.actions = new String[5];
                itemDef.actions[0] = "Claim";
                itemDef.modelZoom = 1200;
                itemDef.modelOffsetX = 0;
                itemDef.modelOffsetY = 14;
                itemDef.rotationY = 0;
                itemDef.rotationX = 0;
            	itemDef.modelOffset1 = 0;
                itemDef.name = "Mystery Package";
                break;

            case 5022:
    			itemDef.actions = new String[] { null, null, null, null, null };
                itemDef.name = "@or2@Halloween @yel@ticket";
                break;

            case 5116:
                itemDef.modelID = 44357;
                itemDef.modelZoom = 1000;
                itemDef.rotationX = 1713;
                itemDef.rotationY = 217;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.maleEquip1 = 44357;
                itemDef.femaleEquip1 = 44357;
                itemDef.name = "@mag@Wand of Lust";
                break;
    		case 6486:
    			itemDef.name = "Pet Baby Yoda";
                itemDef.modelID = 40028;
                itemDef.modelZoom = 2750;
                itemDef.rotationY = 340;
                itemDef.rotationX = 0;
    			itemDef.groundActions = new String[] { null, null, "Take", null, null };
    			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
    			break;
            case 19728:
                itemDef.modelID = 23098;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 1200;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23098;
                itemDef.femaleEquip1 = 23098;
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 59 };
                itemDef.name = "Supreme Boots";
                break;

            case 19729:
                itemDef.modelID = 23099;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 1200;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23100;
                itemDef.femaleEquip1 = 23100;
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 59 };
                itemDef.name = "Supreme Gloves";
                break;
            case 19730:
                itemDef.modelID = 23101;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 1200;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23102;
                itemDef.femaleEquip1 = 23102;
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 59 };
                itemDef.name = "Supreme Helmet";
                break;

            case 19731:
                itemDef.modelID = 23103;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23104;
                itemDef.femaleEquip1 = 23104;
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 59 };
                itemDef.name = "Supreme Platelegs";
                break;

            case 19732:
                itemDef.modelID = 23105;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23106;
                itemDef.femaleEquip1 = 23106;
    			itemDef.originalModelColors = new int[] { 56};
    			itemDef.newModelColor = new int[] { 59 };
                itemDef.name = "Supreme Platebody";
                break;

            case 19733:
                itemDef.modelID = 23108;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23109;
                itemDef.femaleEquip1 = 23109;
                itemDef.name = "Galvan Platebody";
                break;
            case 19734:
                itemDef.modelID = 23110;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23110;
                itemDef.femaleEquip1 = 23110;
                itemDef.name = "Blessed Boots";
                break;

            case 15418:
                itemDef.name = "Blessed Amulet";
                itemDef.actions[2] = "@or2@Salvage";
                break;

            case 19736:
                itemDef.modelID = 23111;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23112;
                itemDef.femaleEquip1 = 23112;
                itemDef.name = "Blessed Gloves";
                break;

            case 19735:
                itemDef.modelID = 23113;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23114;
                itemDef.femaleEquip1 = 23114;
                itemDef.name = "Galvan Helmet";
                break;

            case 19737:
                itemDef.modelID = 23115;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 2000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23116;
                itemDef.femaleEquip1 = 23116;
                itemDef.name = "Galvan Platelegs";
                break;


            case 3821:
                itemDef.name = "Lucid Platebody";
                itemDef.actions[2] = "@or2@Salvage";
                break;

            case 3822:
                itemDef.name = "Lucid Platelegs";
                itemDef.actions[2] = "@or2@Salvage";
                break;



            case 19691:
                itemDef.modelID = 28390;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 900;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 28391;
                itemDef.femaleEquip1 = 28391;
                itemDef.name = "Trinity Helmet";
                break;

                
                
            case 18396:
                itemDef.modelID = 23171;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.modelZoom = 1000;
                itemDef.rotationX = 0;
                itemDef.modelOffsetY = -6;
                itemDef.modelOffsetX = 1;
                itemDef.maleEquip1 = 23172;
                itemDef.femaleEquip1 = 23172;
                itemDef.name = "Paradox Helmet";
                break;

                case 19692:
                    itemDef.modelID = 28392;
                    itemDef.actions = new String[5];
                    itemDef.actions[1] = "Equip";
                    itemDef.actions[2] = "@or2@Salvage";
                    itemDef.modelZoom = 1400;
                    itemDef.rotationX = 0;
                    itemDef.modelOffsetY = -6;
                    itemDef.modelOffsetX = 1;
                    itemDef.maleEquip1 = 28393;
                    itemDef.femaleEquip1 = 28393;
                    itemDef.name = "Trinity Platebody";
                    break;

                case 19693:
                    itemDef.modelID = 28394;
                    itemDef.actions = new String[5];
                    itemDef.actions[1] = "Equip";
                    itemDef.actions[2] = "@or2@Salvage";
                    itemDef.modelZoom = 1000;
                    itemDef.rotationX = 0;
                    itemDef.modelOffsetY = -6;
                    itemDef.modelOffsetX = 1;
                    itemDef.maleEquip1 = 28395;
                    itemDef.femaleEquip1 = 28395;
                    itemDef.name = "Trinity Platelegs";
                    break;

                case 2902:
                    itemDef.actions = new String[5];
                    itemDef.actions[1] = "Equip";
                    itemDef.actions[2] = "@or2@Salvage";
                    break;
                case 19694:
                    itemDef.modelID = 28396;
                    itemDef.actions = new String[5];
                    itemDef.actions[1] = "Equip";
                    itemDef.actions[2] = "@or2@Salvage";
                    ItemDef.copyMostDefs(itemDef, 2902);
        			itemDef.modelOffset1 = itemDef.modelOffset1;
        			itemDef.modelOffsetY = itemDef.modelOffsetY;
        			//itemDef.modelZoom = 2200;
        			itemDef.rotationX = itemDef.rotationX;
        			itemDef.rotationY = itemDef.rotationY;
                    itemDef.maleEquip1 = 28397;
                    itemDef.femaleEquip1 = 28397;
                    itemDef.name = "Trinity Gloves";
                    break;
                case 19695:
                    itemDef.modelID = 28398;
                    itemDef.modelZoom = 2000;
                    itemDef.rotationX = 10;
                    itemDef.rotationY = 20;
                    itemDef.actions = new String[5];
                    itemDef.actions[1] = "Equip";
                    itemDef.actions[2] = "@or2@Salvage";
                    itemDef.maleEquip1 = 28398;
                    itemDef.femaleEquip1 = 28398;
                    itemDef.name = "Trinity Boots";
                    break;

                case 18397:
                    itemDef.modelID = 28422;
                    itemDef.actions = new String[5];
                    itemDef.actions[1] = "Equip";
                    itemDef.actions[2] = "@or2@Salvage";
                    itemDef.modelZoom = 2000;
                    itemDef.rotationX = 0;
                    itemDef.modelOffsetY = -6;
                    itemDef.modelOffsetX = 1;
                    itemDef.maleEquip1 = 28422;
                    itemDef.femaleEquip1 = 28422;
                    itemDef.name = "Paradox Boots";
                    break;

                case 19696:
                    itemDef.modelID = 28399;
                    itemDef.actions = new String[5];
                    itemDef.actions[1] = "Equip";
                    itemDef.actions[2] = "@or2@Salvage";
                    itemDef.modelZoom = 2000;
                    itemDef.rotationX = 50;
                    itemDef.rotationY = 180;
                    itemDef.modelOffsetY = -6;
                    itemDef.modelOffsetX = 1;
                    itemDef.maleEquip1 = 28400;
                    itemDef.femaleEquip1 = 28400;
                    itemDef.name = "Trinity Cape";
                    break;

                case 19618:
                    itemDef.modelID = 96039;
                    itemDef.actions = new String[5];
                    itemDef.actions[1] = "Equip";
                    itemDef.actions[2] = "@or2@Salvage";
                    itemDef.modelZoom = 2000;
                    itemDef.rotationX = 0;
                    itemDef.modelOffsetY = -6;
                    itemDef.modelOffsetX = 1;
                    itemDef.maleEquip1 = 96040;
                    itemDef.femaleEquip1 = 96040;
                    itemDef.name = "Trinity Sword";
                    break;
                case 16137:
                    itemDef.actions[1] = "Equip";
                    itemDef.actions[2] = "@or2@Salvage";
                    itemDef.actions[4] = "Drop";
                    break;
                case 19154:
                    itemDef.modelID = 23429;
                    itemDef.actions = new String[5];
                    itemDef.actions[1] = "Equip";
                    itemDef.actions[2] = "@or2@Salvage";
                    ItemDef.copyMostDefs(itemDef, 16137);
        			itemDef.modelOffset1 = itemDef.modelOffset1;
        			itemDef.modelOffsetY = itemDef.modelOffsetY;
        			//itemDef.modelZoom = 2200;
        			itemDef.rotationX = itemDef.rotationX;
        			itemDef.rotationY = itemDef.rotationY;
                    itemDef.maleEquip1 = 23429;
                    itemDef.femaleEquip1 = 23429;
                    itemDef.name = "Luminita Sword";
                    break;
                case 19713:
                    itemDef.modelID = 95068;
                    itemDef.actions = new String[5];
                    itemDef.actions[1] = "Equip";
                    itemDef.actions[2] = "@or2@Salvage";
                    itemDef.modelZoom = 2000;
                    itemDef.rotationX = 0;
                    itemDef.modelOffsetY = -6;
                    itemDef.modelOffsetX = 1;
                    itemDef.maleEquip1 = 95069;
                    itemDef.femaleEquip1 = 95069;
                    itemDef.name = "Colorful Swords";
                    break;

                case 19726:
                    itemDef.modelID = 94139;
                    itemDef.actions = new String[5];
                    itemDef.actions[1] = "Equip";
                    itemDef.actions[2] = "@or2@Salvage";
                    itemDef.modelZoom = 900;
                    itemDef.rotationX = 0;
                    itemDef.modelOffsetY = -6;
                    itemDef.modelOffsetX = 1;
                    itemDef.maleEquip1 = 94139;
                    itemDef.femaleEquip1 = 94139;
                    itemDef.name = "Relentless Ring";
                    break;

                case 19738:
                    itemDef.modelID = 91084;
                    itemDef.actions = new String[5];
                    itemDef.actions[1] = "Equip";
                   // itemDef.modelZoom = 2000;
                    //itemDef.rotationX = 0;
                    //itemDef.modelOffsetY = -6;
                    //itemDef.modelOffsetX = 1;
                    itemDef.maleEquip1 = 91085;
                    itemDef.femaleEquip1 = 91085;
                    itemDef.name = "Book of Secrets";
                    break;
        case 19159:
            itemDef.modelID =28355;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 800;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 28356;
            itemDef.femaleEquip1 = 28356;
            itemDef.name = "Cloud's Head";
            break;

        case 20054:
            itemDef.name = "Lucid Ring";
            itemDef.actions[2] = "@or2@Salvage";
            break;

        case 19160:
            itemDef.modelID = 28357;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 800;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 28358;
            itemDef.femaleEquip1 = 28358;
            itemDef.name = "Cloud's Platebody";
            break;

        case 19161:
            itemDef.modelID = 28359;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 800;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 28360;
            itemDef.femaleEquip1 = 28360;
            itemDef.name = "Cloud's Platlegs";
            break;
        case 19163:
            itemDef.modelID = 28361;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 28361;
            itemDef.femaleEquip1 = 28361;
            itemDef.name = "Cloud's Sword";
            break;

        case 19164:
            itemDef.modelID = 28362;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 28363;
            itemDef.femaleEquip1 = 28363;
            itemDef.name = "Cloud's cape";
            break;

        case 19165:
            itemDef.modelID = 28364;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.maleEquip1 = 28365;
            itemDef.femaleEquip1 = 28365;
            itemDef.name = "Cloud's gloves";
            break;

        case 18931:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.name = "@cya@Icy crossbow";
            break;
        case 14731:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            break;
        case 19092:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            break;
        case 15044:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            break;
        case 14729:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            break;
        case 14730:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            break;
                
        case 19166:
            itemDef.modelID = 28366;
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelZoom = 800;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 28366;
            itemDef.femaleEquip1 = 28366;
            itemDef.name = "Cloud's boots";
            break;

		case 13265:
            itemDef.modelZoom = 3000;
			itemDef.modelID = 40251;
			itemDef.name = "Sephiroth Sword";
            ItemDef.copyMostDefs(itemDef, 13899);
			itemDef.femaleEquip1 = 40252;
			itemDef.maleEquip1 = 40252;
			itemDef.description = "Sephiroth sword";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 13289:
            itemDef.modelZoom = 3000;
			itemDef.modelID = 40251;
			itemDef.name = "OP Sephiroth Sword";
            ItemDef.copyMostDefs(itemDef, 13899);
			itemDef.femaleEquip1 = 40252;
			itemDef.maleEquip1 = 40252;
			itemDef.description = "Sephiroth sword";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;

		case 18398:
			itemDef.modelID = 50065;
			itemDef.name = "Royal Scimitar";
			itemDef.modelZoom = 2000;
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 5;
			itemDef.femaleEquip1 = 50066;
			itemDef.maleEquip1 = 50066;
			itemDef.description = "Royal Scimitar";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;


		case 923:
			itemDef.modelID = 23367;
			itemDef.name = "Infartico's Blade";
			itemDef.modelZoom = 2000;
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 5;
			itemDef.femaleEquip1 = 23368;
			itemDef.maleEquip1 = 23368;
			itemDef.description = "Infartico's Blade";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
			itemDef.actions[4] = "Drop";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.animateInventory = true;
			itemDef.originalModelColors = new int[] { 51 };
			itemDef.newModelColor = new int[] { 60 };
			break;

        case 1686:
			itemDef.modelID = 23489;

			itemDef.name = "Elemental Helm";
/*  327 */      itemDef.groundActions = new String[5];
/*  154 */       itemDef.groundActions[2] = "Take";
/*  155 */       itemDef.actions = new String[5];
/*  156 */       itemDef.actions[1] = "Equip";
itemDef.actions[2] = "@or2@Salvage";
			 itemDef.actions[4] = "Drop";
/*  328 */       itemDef.description = "Elemental Helm";
/*  329 */       itemDef.rotationX = 119;
/*  330 */       itemDef.rotationY = 20;
/*  331 */       itemDef.modelZoom = 778;
/*  332 */       itemDef.modelOffsetX = 1;
/*  333 */       itemDef.modelOffsetY = 0;
			itemDef.maleEquip1 = 23488;
/*  152 */       itemDef.femaleEquip1 = 23488;
break;

        case 1685:
			itemDef.modelID = 23487;

			itemDef.name = "Elemental Platebody";
/*  327 */      itemDef.groundActions = new String[5];
/*  154 */       itemDef.groundActions[2] = "Take";
/*  155 */       itemDef.actions = new String[5];
/*  156 */       itemDef.actions[1] = "Equip";
itemDef.actions[2] = "@or2@Salvage";
			 itemDef.actions[4] = "Drop";
/*  328 */       itemDef.description = "Elemental Platebody";
			itemDef.maleEquip1 = 23486;
			/*  332 */       itemDef.modelOffsetX = 1;
			/*  333 */       itemDef.modelOffsetY = 200;
/*  152 */       itemDef.femaleEquip1 = 23486;
break;

        case 2544:
			itemDef.modelID = 23491;

			itemDef.name = "Elemental Platelegs";
/*  327 */      itemDef.groundActions = new String[5];
/*  154 */       itemDef.groundActions[2] = "Take";
/*  155 */       itemDef.actions = new String[5];
/*  156 */       itemDef.actions[1] = "Equip";
itemDef.actions[2] = "@or2@Salvage";
			 itemDef.actions[4] = "Drop";
/*  328 */       itemDef.description = "Elemental Platelegs";
/*  329 */       itemDef.rotationX = 119;
/*  330 */       itemDef.rotationY = 20;
/*  331 */       itemDef.modelZoom = 1665;
/*  332 */       itemDef.modelOffsetX = 7;
/*  333 */       itemDef.modelOffsetY = 5;
			itemDef.maleEquip1 = 23490;
/*  152 */       itemDef.femaleEquip1 = 23490;
break;


        case 927:
			itemDef.modelID = 23385;

			itemDef.name = "Starter Helm";
/*  327 */      itemDef.groundActions = new String[5];
/*  154 */       itemDef.groundActions[2] = "Take";
/*  155 */       itemDef.actions = new String[5];
/*  156 */       itemDef.actions[1] = "Equip";

			 itemDef.actions[4] = "Drop";
/*  328 */       itemDef.description = "Starter Helm";
/*  329 */       itemDef.rotationX = 119;
/*  330 */       itemDef.rotationY = 20;
/*  331 */       itemDef.modelZoom = 778;
/*  332 */       itemDef.modelOffsetX = 1;
/*  333 */       itemDef.modelOffsetY = 0;
			itemDef.maleEquip1 = 23386;
/*  152 */       itemDef.femaleEquip1 = 23386;
break;

        case 928:
			itemDef.modelID = 23387;

			itemDef.name = "Starter Platebody";
/*  327 */      itemDef.groundActions = new String[5];
/*  154 */       itemDef.groundActions[2] = "Take";
/*  155 */       itemDef.actions = new String[5];
/*  156 */       itemDef.actions[1] = "Equip";

			 itemDef.actions[4] = "Drop";
/*  328 */       itemDef.description = "Starter Platebody";
			itemDef.maleEquip1 = 23388;
			/*  332 */       itemDef.modelOffsetX = 1;
			/*  333 */       itemDef.modelOffsetY = 200;
/*  152 */       itemDef.femaleEquip1 = 23388;
break;

        case 929:
			itemDef.modelID = 23389;

			itemDef.name = "Starter Platelegs";
/*  327 */      itemDef.groundActions = new String[5];
/*  154 */       itemDef.groundActions[2] = "Take";
/*  155 */       itemDef.actions = new String[5];
/*  156 */       itemDef.actions[1] = "Equip";

			 itemDef.actions[4] = "Drop";
/*  328 */       itemDef.description = "Starter Platelegs";
/*  329 */       itemDef.rotationX = 119;
/*  330 */       itemDef.rotationY = 20;
/*  331 */       itemDef.modelZoom = 1665;
/*  332 */       itemDef.modelOffsetX = 7;
/*  333 */       itemDef.modelOffsetY = 5;
			itemDef.maleEquip1 = 23390;
/*  152 */       itemDef.femaleEquip1 = 23390;
break;


		case 13266:
			itemDef.modelID = 40243;
			itemDef.name = "Sephiroth Hair";
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 5;
			itemDef.femaleEquip1 = 40244;
			itemDef.maleEquip1 = 40244;
			itemDef.description = "Sephiroth Hair";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 13267:
			itemDef.modelID = 40247;
			itemDef.name = "Sephiroth Body";
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 5;
			itemDef.femaleEquip1 = 40246;
			itemDef.maleEquip1 = 40246;
			itemDef.description = "Sephiroth body";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 13268:
			itemDef.modelID = 40240;
			itemDef.name = "Sephiroth legs";
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 0;
			itemDef.femaleEquip1 = 40248;
			itemDef.maleEquip1 = 40248;
			itemDef.description = "Sephiroth legs";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 6491:
			itemDef.name = "Apollyon Mask";
			itemDef.modelZoom = 2000;
			itemDef.modelID = 44631;
			itemDef.maleEquip1 = 44631;
			itemDef.femaleEquip1 = 44631;
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 6492:
			itemDef.name = "Apollyon Platebody";
			itemDef.modelZoom = 2000;
			itemDef.modelID = 44632;
			itemDef.maleEquip1 = 44632;
			itemDef.femaleEquip1 = 44632;
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 6493:
			itemDef.name = "Apollyon Platelegs";
			itemDef.modelZoom = 2000;
			itemDef.modelID = 44633;
			itemDef.maleEquip1 = 44633;
			itemDef.femaleEquip1 = 44633;
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;

		case 6494:
			itemDef.name = "Apollyon Boots";
			itemDef.modelZoom = 2000;
			itemDef.modelID = 44634;
			itemDef.maleEquip1 = 44634;
			itemDef.femaleEquip1 = 44634;
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 6495:
			itemDef.name = "Apollyon Gloves";
			itemDef.modelZoom = 2000;
			itemDef.modelID = 44635;
			itemDef.maleEquip1 = 44635;
			itemDef.femaleEquip1 = 44635;
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 6934:
			itemDef.name = "Apollyon Staff";
			itemDef.modelZoom = 2000;
			itemDef.modelID = 44636;
			itemDef.maleEquip1 = 44636;
			itemDef.femaleEquip1 = 44636;
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 6935:
			itemDef.name = "Apollyon Staff(OH)";
			itemDef.modelZoom = 2000;
			itemDef.modelID = 44637;
			itemDef.maleEquip1 = 44637;
			itemDef.femaleEquip1 = 44637;
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;

		case 17363:
 			itemDef.name = "Deluxe Keys";
			itemDef.description = "Use deluxe keys on the Deluxe chest, found in the Deluxe zone";
 			break;

		case 7682:
 			itemDef.modelID = 44313;
 			itemDef.name = "VIP Sword";
			itemDef.description = "Vip sword";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44314;
 			itemDef.femaleEquip1 = 44314;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;
		case 7683:
 			itemDef.modelID = 44316;
 			itemDef.name = "VIP Gloves";
			itemDef.description = "Vip gloves";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44315;
 			itemDef.femaleEquip1 = 44315;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;

		case 7684:
 			itemDef.modelID = 44317;
 			itemDef.name = "VIP Helmet";
			itemDef.description = "Vip Helmet";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44318;
 			itemDef.femaleEquip1 = 44318;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;

		case 7685:
 			itemDef.modelID = 44319;
 			itemDef.name = "VIP Platelegs";
			itemDef.description = "Vip Platelegs";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44320;
 			itemDef.femaleEquip1 = 44320;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;

		case 7756:
 			itemDef.modelID = 44327;
 			itemDef.name = "Devastating Helmet";
			itemDef.description = "Devastating Helmet";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44328;
 			itemDef.femaleEquip1 = 44328;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;


		case 7757:
 			itemDef.modelID = 44329;
 			itemDef.name = "Devastating Platebody";
			itemDef.description = "Devastating Platebody";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44330;
 			itemDef.femaleEquip1 = 44330;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;

		case 7758:
 			itemDef.modelID = 44331;
 			itemDef.name = "Devastating Platelegs";
			itemDef.description = "Devastating Platelegs";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44332;
 			itemDef.femaleEquip1 = 44332;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;

		case 7759:
 			itemDef.modelID = 44333;
 			itemDef.name = "Vip Stoner helmet";
			itemDef.description = "Vip Stoner helmet";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44334;
 			itemDef.femaleEquip1 = 44334;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;

		case 7760:
 			itemDef.modelID = 44335;
 			itemDef.name = "Vip Stoner platebody";
			itemDef.description = "Vip Stoner platebody";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44336;
 			itemDef.femaleEquip1 = 44336;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;

		case 7761:
 			itemDef.modelID = 44337;
 			itemDef.name = "Vip Stoner platelegs";
			itemDef.description = "Vip Stoner platelegs";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44338;
 			itemDef.femaleEquip1 = 44338;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;

		case 7762:
 			itemDef.modelID = 44339;
 			itemDef.name = "Vip Stoner Boots";
			itemDef.description = "Vip Stoner Boots";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44339;
 			itemDef.femaleEquip1 = 44339;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;

		case 14453:
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
			break;
		case 14455:
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
			break;
		case 19886:
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
			break;
		case 19106:
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
			break;
		case 19087:
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
			break;
		case 18950:
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
			break;
		case 14457:
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
			break;
		case 7763:
 			itemDef.modelID = 44340;
 			itemDef.name = "Vip Stoner Cape";
			itemDef.description = "Vip Stoner Cape";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44341;
 			itemDef.femaleEquip1 = 44341;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;


		case 7764:
 			itemDef.modelID = 44342;
 			itemDef.name = "Vip Stoner Gun";
			itemDef.description = "Vip Stoner Gun";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44343;
 			itemDef.femaleEquip1 = 44343;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;

		case 7765:
 			itemDef.modelID = 44344;
 			itemDef.name = "Vip Stoner Shield";
			itemDef.description = "Vip Stoner Shield";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 44345;
 			itemDef.femaleEquip1 = 44345;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;


        case 13205:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelID = 40253;
            itemDef.modelZoom = 1200;
            itemDef.rotationY = 500;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 40253;
            itemDef.femaleEquip1 = 40253;
            itemDef.name = "Storm Breaker Boots";
            break;

		case 13207:
 			itemDef.modelID = 40262;
 			itemDef.name = "Storm Breaker Maul";
			itemDef.description = "Toxidian Maul";
            itemDef.modelZoom = 2000;
            itemDef.rotationY = 500;
 			itemDef.modelOffset1 = -1;
 			itemDef.modelOffsetY = -1;
 			itemDef.maleEquip1 = 40263;
 			itemDef.femaleEquip1 = 40263;
 			itemDef.actions = new String[5];
 			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
 			itemDef.actions[4] = "Drop";
 			break;

        case 13206:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelID = 40256;
            itemDef.modelZoom = 1000;
            itemDef.rotationY = 100;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 40257;
            itemDef.femaleEquip1 = 40257;
            itemDef.name = "Storm Breaker Helm";
            break;

        case 13202:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelID = 40260;
            itemDef.modelZoom = 1600;
            itemDef.rotationY = 500;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 40261;
            itemDef.femaleEquip1 = 40261;
            itemDef.name = "Storm Breaker Body";
            break;

        case 13203:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelID = 40258;
            itemDef.modelZoom = 1600;
            itemDef.rotationY = 500;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 40259;
            itemDef.femaleEquip1 = 40259;
            itemDef.name = "Storm Breaker Legs";
            break;

        case 13204:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelID = 40254;
            itemDef.modelZoom = 1600;
            itemDef.rotationY = 500;
            itemDef.rotationX = 0;
            itemDef.modelOffsetY = -6;
            itemDef.modelOffsetX = 1;
            itemDef.maleEquip1 = 40255;
            itemDef.femaleEquip1 = 40255;
            itemDef.name = "Storm Breaker Gloves";
            break;


		case 3258:
			itemDef.modelID = 83347;
			itemDef.name = "Starter Helmet";
			itemDef.modelZoom = 2000;
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 5;
			itemDef.femaleEquip1 = 83347;
			itemDef.maleEquip1 = 83347;
			itemDef.description = "Starter Helmet";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
			itemDef.actions[4] = "Drop";
			break;
		case 3079:
			itemDef.modelID = 83350;
			itemDef.name = "Starter Body";
			itemDef.modelZoom = 2000;
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 5;
			itemDef.femaleEquip1 = 83351;
			itemDef.maleEquip1 = 83351;
			itemDef.description = "Starter body";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
			itemDef.actions[4] = "Drop";
			break;
		case 3080:
			itemDef.modelID = 83348;
			itemDef.name = "Starter legs";
			itemDef.modelZoom = 2000;
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 5;
			itemDef.femaleEquip1 = 83349;
			itemDef.maleEquip1 = 83349;
			itemDef.description = "Starter legs";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
			itemDef.actions[4] = "Drop";
			break;
		case 13269:
			itemDef.modelID = 38327;
			itemDef.name = "Starter Gloves";
			itemDef.modelZoom = 2000;
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 5;
			itemDef.femaleEquip1 = 28320;
			itemDef.maleEquip1 = 28320;
			itemDef.description = "Starter Gloves";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
			itemDef.actions[4] = "Drop";
			break;


		case 13258:
			itemDef.modelID = 57557;
			itemDef.name = "Toxic helmet";
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.femaleEquip1 = 57558;
			itemDef.maleEquip1 = 57558;
			itemDef.description = "Sirenic helmet";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;

		case 18391:
			itemDef.modelID = 65269;
			itemDef.name = "Iphone";
			itemDef.femaleEquip1 = 65268;
			itemDef.maleEquip1 = 65268;
			itemDef.description = "Iphone";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
			itemDef.actions[4] = "Drop";
			break;

		case 13256:
			itemDef.modelID = 57561;
			itemDef.name = "Toxic legs";
            ItemDef.copyMostDefs(itemDef, 1079);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.femaleEquip1 = 57562;
			itemDef.maleEquip1 = 57562;
			itemDef.description = "Sirenic legs";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 13259:
			itemDef.modelID = 57559;
			itemDef.name = "Toxic top";
            ItemDef.copyMostDefs(itemDef, 1127);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.femaleEquip1 = 57560;
			itemDef.maleEquip1 = 57560;
			itemDef.description = "toxic top";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;

		case 3260:
			itemDef.modelID = 94700;
			itemDef.name = "Ki's Boots";
			itemDef.modelZoom = 2000;
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 5;
			itemDef.femaleEquip1 = 94700;
			itemDef.maleEquip1 = 94700;
			itemDef.description = "Sirenic boots";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.newModelColor = new int[] { 59 };
			itemDef.actions[1] = "Equip";
			itemDef.actions[4] = "Drop";
			break;


		case 13270:
			itemDef.modelID = 40250;
			itemDef.name = "Sephiroth Boots";
			itemDef.modelZoom = 2000;
			itemDef.rotationY = 0;
			itemDef.rotationX = 0;
			itemDef.modelOffsetX = 0;
			itemDef.modelOffsetY = 5;
			itemDef.femaleEquip1 = 40250;
			itemDef.maleEquip1 = 40250;
			itemDef.description = "Starter boots";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 7005:
			itemDef.name = "Voldemort Faceguard";
			//itemDef.modelZoom = 2000;
			//itemDef.rotationY = 0;
			//itemDef.rotationX = 0;
			//itemDef.modelOffsetX = 0;
			//itemDef.modelOffsetY = 5;
			itemDef.modelID = 44724;
			itemDef.maleEquip1 = 44718;
			itemDef.femaleEquip1 = 44718;
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			itemDef.stackable = false;
			break;
		case 7006:
			itemDef.name = "Voldemort Robe top";
			//itemDef.modelZoom = 2000;
			//itemDef.rotationY = 0;
			//itemDef.rotationX = 0;
			//itemDef.modelOffsetX = 0;
			//itemDef.modelOffsetY = 5;
			itemDef.modelID = 44725;
			itemDef.maleEquip1 = 44719;
			itemDef.femaleEquip1 = 44719;
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			itemDef.stackable = false;
			break;

		case 7007:
			itemDef.name = "Voldemort Robe legs";
			//itemDef.modelZoom = 2000;
			//itemDef.rotationY = 0;
			//itemDef.rotationX = 0;
			//itemDef.modelOffsetX = 0;
			//itemDef.modelOffsetY = 5;
			itemDef.modelID = 44726;
			itemDef.maleEquip1 = 44720;
			itemDef.femaleEquip1 = 44720;
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			itemDef.stackable = false;
			break;

		case 7008:
			itemDef.name = "Voldemort Gloves";
			//itemDef.modelZoom = 2000;
			//itemDef.rotationY = 0;
			//itemDef.rotationX = 0;
			//itemDef.modelOffsetX = 0;
			//itemDef.modelOffsetY = 5;
			itemDef.modelID = 44727;
			itemDef.maleEquip1 = 44721;
			itemDef.femaleEquip1 = 44721;
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			itemDef.stackable = false;
			break;
		case 7009:
			itemDef.name = "Voldemort Boots";
			//itemDef.modelZoom = 2000;
			//itemDef.rotationY = 0;
			//itemDef.rotationX = 0;
			//itemDef.modelOffsetX = 0;
			//itemDef.modelOffsetY = 5;
			itemDef.modelID = 44722;
			itemDef.maleEquip1 = 44722;
			itemDef.femaleEquip1 = 44722;
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			itemDef.stackable = false;
			break;
		case 7010:
			itemDef.name = "Voldemort Wand";
			//itemDef.modelZoom = 2000;
			//itemDef.rotationY = 0;
			//itemDef.rotationX = 0;
			//itemDef.modelOffsetX = 0;
			//itemDef.modelOffsetY = 5;
			itemDef.modelID = 44723;
			itemDef.maleEquip1 = 44728;
			itemDef.femaleEquip1 = 44728;
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			itemDef.stackable = false;
			break;
		case 3277:
			itemDef.modelID = 44729;
			itemDef.name = "Donators Aura";
            itemDef.modelZoom = 878;
            itemDef.rotationX = 496;
            itemDef.rotationY = 600;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 15;
			changeTexture(id, 40, 60);
			itemDef.femaleEquip1 = 44730;
			itemDef.maleEquip1 = 44730;
			itemDef.description = "Flex the donations";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;

		case 13208:
			itemDef.name = "Royal Pernix hood+";
			itemDef.modelID = 23163;
			itemDef.femaleEquip1 = 23164; //65343
			itemDef.maleEquip1 = 23164; //65343

			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;
		case 13209:
			itemDef.name = "Royal Pernix platebody+";
			itemDef.modelID = 23165;
			itemDef.femaleEquip1 = 23168;
			itemDef.maleEquip1 = 23168;

			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;
		case 13210:
			itemDef.name = "Royal Pernix legs+";
			itemDef.modelID = 23169;
			itemDef.femaleEquip1 = 23170;
			itemDef.maleEquip1 = 23170; //65349

			itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			break;

		case 12852:
			itemDef.name = "Salvage Token";
			break;
		case 13211:
			itemDef.name = "Tier 1 Upgrade Token";
			ItemDef.copyModel(itemDef, 12852);
			break;
		case 13212:
			itemDef.name = "Tier 2 Upgrade Token";
			ItemDef.copyModel(itemDef, 12852);
			break;

        case 19864:
			ItemDef.copyModel(itemDef, 15245);
            itemDef.actions[0] = "Read";
            itemDef.name = "Starter Ticket";
            break;

        case 1464:
			itemDef.modelID = 51439;
            ItemDef.copyMostDefs(itemDef, 19936);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.actions[0] = "Redeem";
            itemDef.name = "$1 Bond";
			changeTexture(id, 40, 59);
			itemDef.animateInventory = true;
            break;



        case 4789:
			itemDef.modelID = 44215;
            itemDef.modelZoom = 1696;
            itemDef.rotationX = 0;
            itemDef.rotationY = 300;
            itemDef.modelOffsetY = 0;
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
            itemDef.name = "Fairy Crystal";
            break;

        case 4790:
			itemDef.modelID = 44214;
            itemDef.modelZoom = 1696;
            itemDef.rotationX = 0;
            itemDef.rotationY = 300;
            itemDef.modelOffsetY = 0;
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
            itemDef.name = "Fire Crystal";
            break;

        case 4791:
			itemDef.modelID = 44213;
            itemDef.modelZoom = 1696;
            itemDef.rotationX = 0;
            itemDef.rotationY = 300;
            itemDef.modelOffsetY = 0;
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
            itemDef.name = "Water Crystal";
            break;

        case 4792:
			itemDef.modelID = 44212;
            itemDef.modelZoom = 1696;
            itemDef.rotationX = 0;
            itemDef.rotationY = 300;
            itemDef.modelOffsetY = 0;
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
            itemDef.name = "@yel@Electric Crystal";
            break;

		case 6500:
			ItemDef.copyModel(itemDef, 15387);
            itemDef.actions[1] = "Withdrawl";
			itemDef.name = "Looting Bag";
			break;

		case 1639:
			itemDef.name = "Beginner ring";
			itemDef.animateInventory = true;
			break;
		case 14872:
			itemDef.name = "Gorgon Helmet";
			itemDef.modelID = 61333;
			itemDef.maleEquip1 = 61335;
			itemDef.femaleEquip1 = 61335;
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62 };
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14873:
			itemDef.name = "Gorgon Body";
			itemDef.modelID = 61339;
			itemDef.maleEquip1 = 61340;
			itemDef.femaleEquip1 = 61340;
            ItemDef.copyMostDefs(itemDef, 1127);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.animateInventory = true;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62};
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14874:
			itemDef.name = "Gorgon Platelegs";
			itemDef.modelID = 61342;
			itemDef.maleEquip1 = 61343;
			itemDef.femaleEquip1 = 61343;
            ItemDef.copyMostDefs(itemDef, 1079);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62 };
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
        case 14694:
            itemDef.name = "Gorgon Gloves";
            itemDef.modelID = 61345;
            itemDef.maleEquip1 = 61346;
            itemDef.femaleEquip1 = 61346;
            ItemDef.copyMostDefs(itemDef, 2902);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
            itemDef.stackable = false;
            break;
        case 14695:
            itemDef.name = "Gorgon Boots";
            itemDef.modelID = 61344;
            itemDef.maleEquip1 = 61344;
            itemDef.femaleEquip1 = 61344;
            ItemDef.copyMostDefs(itemDef, 11733);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
            itemDef.stackable = false;
            break;
		case 14915:
			itemDef.name = "Arctic Frost Full Helmet";
			itemDef.modelID = 61359;
			itemDef.maleEquip1 = 61360;
			itemDef.femaleEquip1 = 61360;
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14916:
			itemDef.name = "Arctic Frost Platebody";
			itemDef.modelID = 61361;
			itemDef.maleEquip1 = 61362;
			itemDef.femaleEquip1 = 61362;
            ItemDef.copyMostDefs(itemDef, 1127);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14917:
			itemDef.name = "Arctic Frost Platelegs";
			itemDef.modelID = 61364;
			itemDef.maleEquip1 = 61367;
			itemDef.femaleEquip1 = 61367;
            ItemDef.copyMostDefs(itemDef, 1079);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62 };
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14918:
			itemDef.name = "Arctic Frost Coif";
			itemDef.modelID = 61368;
			itemDef.maleEquip1 = 61369;
			itemDef.femaleEquip1 = 61369;
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14919:
			itemDef.name = "Arctic Frost Hide body";
			itemDef.modelID = 61370;
			itemDef.maleEquip1 = 61371;
			itemDef.femaleEquip1 = 61371;
            ItemDef.copyMostDefs(itemDef, 1127);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14920:
			itemDef.name = "Arctic Frost Chaps";
			itemDef.modelID = 61372;
			itemDef.maleEquip1 = 61373;
			itemDef.femaleEquip1 = 61373;
            ItemDef.copyMostDefs(itemDef, 1079);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62 };
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14921:
			itemDef.name = "Arctic Frost Bow";
			itemDef.modelID = 61376;
			itemDef.maleEquip1 = 61377;
			itemDef.femaleEquip1 = 61377;
            ItemDef.copyMostDefs(itemDef, 64);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62 };
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14922:
			itemDef.name = "Arctic Frost staff";
			itemDef.modelID = 61378;
			itemDef.maleEquip1 = 61379;
			itemDef.femaleEquip1 = 61379;
            ItemDef.copyMostDefs(itemDef, 64);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62 };
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14923:
			itemDef.name = "Arctic Frost blade";
			itemDef.modelID = 61380;
			itemDef.maleEquip1 = 61381;
			itemDef.femaleEquip1 = 61381;
            ItemDef.copyMostDefs(itemDef, 64);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62 };
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14914:
			itemDef.name = "Arctic Frost Wizard hat";
			itemDef.modelID = 61358;
			itemDef.maleEquip1 = 61357;
			itemDef.femaleEquip1 = 61357;
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			//itemDef.modelZoom = 2200;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14912:
			itemDef.name = "Arctic Frost Robe top";
			itemDef.modelID = 61353;
			itemDef.maleEquip1 = 61354;
			itemDef.femaleEquip1 = 61354;
            ItemDef.copyMostDefs(itemDef, 1127);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14913:
			itemDef.name = "Arctic Frost Robe bottoms";
			itemDef.modelID = 61355;
			itemDef.maleEquip1 = 61356;
			itemDef.femaleEquip1 = 61356;
            ItemDef.copyMostDefs(itemDef, 1079);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62 };
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 9496:
			itemDef.name = "Detrimental Helm";
			itemDef.modelID = 23847;
			itemDef.maleEquip1 = 23848;
			itemDef.femaleEquip1 = 23848;
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62 };
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14932:
			itemDef.name = "Rajin Hat";
			itemDef.modelID = 61518;
			itemDef.maleEquip1 = 61463;
			itemDef.femaleEquip1 = 61463;
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62 };
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14933:
			itemDef.name = "Rajin Body";
			itemDef.modelID = 61520;
			itemDef.maleEquip1 = 61466;
			itemDef.femaleEquip1 = 61466;
            ItemDef.copyMostDefs(itemDef, 1127);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.animateInventory = true;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62};
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 14934:
			itemDef.name = "Rajin Legs";
			itemDef.modelID = 61522;
			itemDef.maleEquip1 = 61488;
			itemDef.femaleEquip1 = 61488;
            ItemDef.copyMostDefs(itemDef, 1079);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62 };
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 16474:
			itemDef.name = "@mag*Oink Mask";
			itemDef.modelID = 61222;
			itemDef.maleEquip1 = 61224;
			itemDef.femaleEquip1 = 61224;
            ItemDef.copyMostDefs(itemDef, 1163);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 9497:
			itemDef.name = "Detrimental Body";
			itemDef.modelID = 23849;
			itemDef.maleEquip1 = 23850;
			itemDef.femaleEquip1 = 23850;
            ItemDef.copyMostDefs(itemDef, 1127);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
            itemDef.animateInventory = true;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62};
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 9498:
			itemDef.name = "Detrimental Legs";
			itemDef.modelID = 23851;
			itemDef.maleEquip1 = 23852;
			itemDef.femaleEquip1 = 23852;
            ItemDef.copyMostDefs(itemDef, 1079);
			itemDef.modelOffset1 = itemDef.modelOffset1;
			itemDef.modelOffsetY = itemDef.modelOffsetY;
			itemDef.rotationX = itemDef.rotationX;
			itemDef.rotationY = itemDef.rotationY;
			itemDef.originalModelColors = new int[] { 52 };
			itemDef.newModelColor = new int[] { 62 };
			itemDef.actions = new String[] { null, "Equip", "@or2@Salvage", null, "Drop" };
			itemDef.stackable = false;
			break;
		case 15037:
			itemDef.name = "Starter boots";
			itemDef.animateInventory = true;
			break;
		case 15118:
			ItemDef.copyModel(itemDef, 13660);
			itemDef.name = "Starter Gloves";
            itemDef.modelID = 23779;
            itemDef.maleEquip1 = 23778;
            itemDef.femaleEquip1 = 23778;
			itemDef.animateInventory = true;
			break;
		case 9499:
			ItemDef.copyModel(itemDef, 13660);
			itemDef.name = "Detrimental Gloves";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.modelID = 23779;
            itemDef.maleEquip1 = 23778;
            itemDef.femaleEquip1 = 23778;
			itemDef.animateInventory = true;
			break;
        case 989:
			ItemDef.copyModel(itemDef, 1545);
            itemDef.actions = new String[5];
            itemDef.actions[2] = "Open";
            itemDef.name = "@yel@Starter keys";
            break;
        case 5136:
			ItemDef.copyModel(itemDef, 13723);
            itemDef.actions[0] = "Break";
            itemDef.name = "DBZ Layer 2 Teleport";
            break;
        case 5149:
			ItemDef.copyModel(itemDef, 579);
            itemDef.actions[0] = "Equip";
            itemDef.name = "Greywave robe top";
            break;
        case 7629:
            itemDef.actions[0] = "Read";
            itemDef.name = "Deluxe Tickets";
            break;
        case 19121:
            itemDef.name = "SebZero Starter Box";
            break;
        case 4278:
            itemDef.actions[0] = "Read";
            break;
        case 926:
			ItemDef.copyModel(itemDef, 4651);
			changeTexture(id, 59, 72);
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            itemDef.name = "Toxic Cape";
			itemDef.modelZoom = 2000;
			itemDef.animateInventory = true;
            break;
        case 930:
			ItemDef.copyModel(itemDef, 4651);
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            itemDef.name = "Aquatic Cape";
			changeTexture(id, 59, 71);
			itemDef.modelZoom = 2000;
			itemDef.animateInventory = true;
            break;
        case 931:
			ItemDef.copyModel(itemDef, 4651);
			changeTexture(id, 59, 64);
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			itemDef.modelZoom = 2000;
            itemDef.name = "Elemental Cape";
			itemDef.animateInventory = true;
            break;
        case 19890:
            itemDef.name = "2H DDR scroll";
            break;
        case 20268:
			ItemDef.copyModel(itemDef, 17680);
            itemDef.name = "Infernal Ashes";
            break;
        case 15648:
            itemDef.name = "X10 Trivia points";
            break;
        case 13691:
			ItemDef.copyModel(itemDef, 15648);
            itemDef.name = "Battlepass";
            break;
        case 20427:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            itemDef.modelID = 100456;
            itemDef.name = "BFG-MH";
            itemDef.modelZoom = 900;
            itemDef.rotationY = 165;
            itemDef.rotationX = 99;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 0;
            itemDef.maleEquip1 = 100457;
            itemDef.femaleEquip1 = 100457;
            changeTexture(id, 40, 82);
			itemDef.animateInventory = true;
            itemDef.description = "A BFG-MH.";
            break;
        case 20431:
            itemDef.actions = new String[5];
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            itemDef.modelID = 100456;
            itemDef.name = "BFG-OH";
            itemDef.modelZoom = 900;
            itemDef.rotationY = 165;
            itemDef.rotationX = 99;
            itemDef.modelOffsetX = 0;
            itemDef.modelOffsetY = 0;
            itemDef.maleEquip1 = 100458;
            itemDef.femaleEquip1 = 100458;
            changeTexture(id, 40, 82);
			itemDef.animateInventory = true;
            itemDef.description = "A BFG-OH.";
            break;
        case 18325:
			ItemDef.copyModel(itemDef, 3087);
            itemDef.actions[0] = "Equip";
            itemDef.name = "SebZero Helmet";
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
        case 13275:
            itemDef.modelID = 23777;
            itemDef.stackable = false;
            itemDef.name = "Goku Boots";
            itemDef.description = "Looking good";
            itemDef.stackable = false;
            itemDef.maleEquip1 = 23777;
            itemDef.femaleEquip1 = 23777;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;
          case 13271:
            itemDef.modelID = 23779;
            itemDef.stackable = false;
            itemDef.name = "Goku Gloves";
            itemDef.description = "Looking good";
            itemDef.stackable = false;
            itemDef.maleEquip1 = 23778;
            itemDef.femaleEquip1 = 23778;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 800;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;
          case 13272:
            itemDef.modelID = 23781;
            itemDef.name = "Goku Hair";
            itemDef.description = "Looking good";
            itemDef.stackable = false;
            itemDef.maleEquip1 = 23780;
            itemDef.femaleEquip1 = 23780;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 1322;
            itemDef.rotationY = 520;
            itemDef.rotationX = 0;
            itemDef.modelOffset1 = -1;
            itemDef.modelOffsetY = 5;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;
          case 13273:
            itemDef.modelID = 23783;
            itemDef.stackable = false;
            itemDef.name = "Goku Legs";
            itemDef.description = "Looking good";
            itemDef.maleEquip1 = 23782;
            itemDef.femaleEquip1 = 23782;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 1322;
            itemDef.rotationY = 520;
            itemDef.rotationX = 0;
            itemDef.modelOffset1 = -1;
            itemDef.modelOffsetY = 5;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;
          case 13274:
            itemDef.modelID = 23785;
            itemDef.name = "Goku Body";
            itemDef.description = "Looking good";
            itemDef.maleEquip1 = 23820;
            itemDef.femaleEquip1 = 23820;
            itemDef.stackable = false;
            itemDef.actions = new String[5];
            itemDef.modelZoom = 1322;
            itemDef.rotationY = 520;
            itemDef.rotationX = 0;
            itemDef.modelOffset1 = -1;
            itemDef.modelOffsetY = 5;
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
            break;
          case 13594:
              itemDef.modelID = 23786;
              itemDef.stackable = false;
              itemDef.name = "Vegeta Armor Boots";
              itemDef.description = "Looking good";
              itemDef.maleEquip1 = 23786;
              itemDef.femaleEquip1 = 23786;
              itemDef.actions = new String[5];
              itemDef.modelZoom = 800;
              itemDef.actions[1] = "Equip";
              itemDef.actions[2] = "@or2@Salvage";
              itemDef.actions[4] = "Drop";
              break;
            case 13595:
              itemDef.modelID = 23788;
              itemDef.stackable = false;
              itemDef.name = "Vegeta Armor Gloves";
              itemDef.description = "Looking good";
              itemDef.maleEquip1 = 23787;
              itemDef.femaleEquip1 = 23787;
              itemDef.actions = new String[5];
              itemDef.modelZoom = 800;
              itemDef.actions[1] = "Equip";
              itemDef.actions[2] = "@or2@Salvage";
              itemDef.actions[4] = "Drop";
              break;
            case 13596:
              itemDef.modelID = 23790;
              itemDef.stackable = false;
              itemDef.name = "Vegeta Hair";
              itemDef.description = "Looking good";
              itemDef.maleEquip1 = 23789;
              itemDef.femaleEquip1 = 23789;
              itemDef.actions = new String[5];
              itemDef.modelZoom = 1322;
              itemDef.rotationY = 520;
              itemDef.rotationX = 0;
              itemDef.modelOffset1 = -1;
              itemDef.modelOffsetY = 5;
              itemDef.actions[1] = "Equip";
              itemDef.actions[2] = "@or2@Salvage";
              itemDef.actions[4] = "Drop";
              break;
            case 13597:
              itemDef.modelID = 23792;
              itemDef.name = "Vegeta Armor Legs";
              itemDef.description = "Looking good";
              itemDef.stackable = false;
              itemDef.maleEquip1 = 23791;
              itemDef.femaleEquip1 = 23791;
              itemDef.actions = new String[5];
              itemDef.modelZoom = 1322;
              itemDef.rotationY = 520;
              itemDef.rotationX = 0;
              itemDef.modelOffset1 = -1;
              itemDef.modelOffsetY = 5;
              itemDef.actions[1] = "Equip";
              itemDef.actions[2] = "@or2@Salvage";
              itemDef.actions[4] = "Drop";
              break;
            case 13664:
              itemDef.modelID = 23794;
              itemDef.name = "Vegeta Body Armor";
              itemDef.description = "Looking good";
              itemDef.stackable = false;
              itemDef.maleEquip1 = 23793;
              itemDef.femaleEquip1 = 23793;
              itemDef.actions = new String[5];
              itemDef.modelZoom = 1322;
              itemDef.rotationY = 520;
              itemDef.rotationX = 0;
              itemDef.modelOffset1 = -1;
              itemDef.modelOffsetY = 5;
              itemDef.actions[1] = "Equip";
              itemDef.actions[2] = "@or2@Salvage";
              itemDef.actions[4] = "Drop";
              break;
            case 18380:
                itemDef.modelID = 80518;
                itemDef.name = "Blazed Helmet";
                itemDef.description = "might be hot!";
                itemDef.stackable = false;
                itemDef.maleEquip1 = 80519;
                itemDef.femaleEquip1 = 80519;
                ItemDef.copyMostDefs(itemDef, 19101);
				itemDef.modelOffset1 = itemDef.modelOffset1;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				itemDef.rotationX = itemDef.rotationX;
				itemDef.rotationY = itemDef.rotationY;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 18381:
                itemDef.modelID = 80520;
                itemDef.name = "Blazed Chestplate";
                itemDef.description = "might be hot!";
                itemDef.stackable = false;
                itemDef.maleEquip1 = 80521;
                itemDef.femaleEquip1 = 80521;
                itemDef.actions = new String[5];
                ItemDef.copyMostDefs(itemDef, 1127);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 18382:
                itemDef.modelID = 80522;
                itemDef.name = "Blazed Platelegs";
                itemDef.description = "might be hot!";
                itemDef.stackable = false;
                itemDef.maleEquip1 = 80523;
                itemDef.femaleEquip1 = 80523;
                ItemDef.copyMostDefs(itemDef, 1079);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 18383:
                itemDef.modelID = 80524;
                itemDef.name = "Blazed Boots";
                itemDef.description = "might be hot!";
                itemDef.stackable = false;
                itemDef.maleEquip1 = 80524;
                itemDef.femaleEquip1 = 80524;
                itemDef.actions = new String[5];
                ItemDef.copyMostDefs(itemDef, 11733);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 18384:
                itemDef.modelID = 80525;
                itemDef.name = "Blazed Wings";
                itemDef.description = "might be hot!";
                itemDef.stackable = false;
                itemDef.maleEquip1 = 80526;
                itemDef.femaleEquip1 = 80526;
                ItemDef.copyMostDefs(itemDef, 1021);
				itemDef.modelOffset1 = itemDef.modelOffset1;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				itemDef.rotationX = itemDef.rotationX;
				itemDef.rotationY = itemDef.rotationY;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 18402:
                itemDef.modelID = 80525;
                itemDef.name = "Blazed Wings";
                itemDef.description = "might be hot!";
                itemDef.stackable = false;
                itemDef.maleEquip1 = 80526;
                itemDef.femaleEquip1 = 80526;
                ItemDef.copyMostDefs(itemDef, 1021);
				itemDef.modelOffset1 = itemDef.modelOffset1;
				itemDef.modelOffsetY = itemDef.modelOffsetY;
				itemDef.rotationX = itemDef.rotationX;
				itemDef.rotationY = itemDef.rotationY;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 18385:
                itemDef.modelID = 80527;
                itemDef.name = "Blazed Scimitar";
                itemDef.description = "might be hot!";
                itemDef.stackable = false;
                itemDef.maleEquip1 = 80528;
                itemDef.femaleEquip1 = 80528;
                ItemDef.copyMostDefs(itemDef, 13899);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 18379:
                itemDef.modelID = 80007;
                itemDef.name = "Blazed Shield";
                itemDef.description = "Looking good";
                itemDef.stackable = false;
                itemDef.maleEquip1 = 80007;
                ItemDef.copyMostDefs(itemDef, 1195);
    			itemDef.modelOffset1 = itemDef.modelOffset1;
    			itemDef.modelOffsetY = itemDef.modelOffsetY;
    			itemDef.rotationX = itemDef.rotationX;
    			itemDef.rotationY = itemDef.rotationY;
                itemDef.femaleEquip1 = 80007;
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
            case 13665:
                itemDef.modelID = 23794;
                itemDef.name = "Dream Boots";
                itemDef.description = "Looking good";
                itemDef.stackable = false;
                itemDef.maleEquip1 = 23793;
                itemDef.femaleEquip1 = 23793;
                itemDef.actions = new String[5];
                itemDef.modelZoom = 1322;
                itemDef.rotationY = 520;
                itemDef.rotationX = 0;
                itemDef.modelOffset1 = -1;
                itemDef.modelOffsetY = 5;
                itemDef.actions[1] = "Equip";
                itemDef.actions[2] = "@or2@Salvage";
                itemDef.actions[4] = "Drop";
                break;
		case 5137:
			ItemDef.copyModel(itemDef, 10340);
			itemDef.name = "Dragon-age Robe top";
			break;
		case 5138:
			ItemDef.copyModel(itemDef, 10338);
			itemDef.name = "Dragon-age Magic robe bottom";
			break;
		case 3956:
			ItemDef.copyModel(itemDef, 3974);
			itemDef.name = "Hellfire Wings";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.originalModelColors = new int[] { 40 };
			itemDef.newModelColor = new int[] { 59 };
			break;
		case 298:
			itemDef.name = "Cosmetic Keepsake key";
			break;
		case 20920:
			itemDef.name = "Double-scoop";
            ItemDef.copyMostDefs(itemDef, 12852);
			itemDef.rotationX = 1400;
            itemDef.modelID = 59504;
            itemDef.modelZoom = 2422;
            itemDef.actions[0] = "Consume";
			break;
		case 20921:
			itemDef.name = "Single-scoop";
            ItemDef.copyMostDefs(itemDef, 12852);
			itemDef.rotationX = 1400;
            itemDef.modelID = 59505;
            itemDef.modelZoom = 2422;
			itemDef.actions = new String[] { "Consume", null, null, null, "Drop" };
			break;
		case 20922:
			itemDef.name = "Triple-scoop";
            ItemDef.copyMostDefs(itemDef, 12852);
			itemDef.rotationX = 1400;
            itemDef.modelID = 59506;
            itemDef.modelZoom = 2422;
            itemDef.actions[0] = "Consume";
			break;
		case 11809:
			itemDef.name = "Aggressive potion(4)";
            ItemDef.copyMostDefs(itemDef, 2432);
			itemDef.rotationX = 200;
            itemDef.modelID = 35737;
            changeTexture(id, 40, 83);
            itemDef.actions[0] = "Consume";
			break;
		case 11810:
			itemDef.name = "Aggressive potion(3)";
            ItemDef.copyMostDefs(itemDef, 2432);
			itemDef.rotationX = 200;
            itemDef.modelID = 35736;
            changeTexture(id, 40, 83);
            itemDef.actions[0] = "Consume";
			break;
		case 11811:
			itemDef.name = "Aggressive potion(2)";
            ItemDef.copyMostDefs(itemDef, 2432);
			itemDef.rotationX = 200;
            itemDef.modelID = 35735;
            changeTexture(id, 40, 83);
            itemDef.actions[0] = "Consume";
			break;
		case 11812:
			itemDef.name = "Aggressive potion(1)";
            ItemDef.copyMostDefs(itemDef, 2432);
			itemDef.rotationX = 200;
            itemDef.modelID = 35734;
            changeTexture(id, 40, 83);
            itemDef.actions[0] = "Consume";
			break;
		case 14259:
			itemDef.name = "Dub potion(4)";
            ItemDef.copyMostDefs(itemDef, 2432);
			itemDef.rotationX = 200;
            itemDef.modelID = 59516;
            itemDef.actions[0] = "Consume";
			break;
		case 18812:
			itemDef.name = "@re1@Strange potion";
            ItemDef.copyMostDefs(itemDef, 2432);
			itemDef.rotationX = 200;
            itemDef.modelID = 49740;
            changeTexture(id, 40, 89);
            itemDef.actions[0] = "Consume";
			break;
		case 14249:
			itemDef.name = "Dub potion(3)";
            ItemDef.copyMostDefs(itemDef, 2432);
			itemDef.rotationX = 200;
            itemDef.modelID = 59515;
            itemDef.actions[0] = "Consume";
			break;
			
		case 20929:
			itemDef.name = "Dub potion(2)";
            ItemDef.copyMostDefs(itemDef, 2432);
			itemDef.rotationX = 200;
            itemDef.modelID = 59529;
            itemDef.actions[0] = "Consume";
			break;
		case 20930:
			itemDef.name = "Dub potion(1)";
            ItemDef.copyMostDefs(itemDef, 2432);
			itemDef.rotationX = 200;
            itemDef.modelID = 59514;
            itemDef.actions[0] = "Consume";
			break;
		case 20926:
			itemDef.name = "Chocolate Single-scoop";
            ItemDef.copyMostDefs(itemDef, 12852);
			itemDef.rotationX = 1400;
            itemDef.modelZoom = 2422;
            itemDef.modelID = 59507;
            itemDef.actions[0] = "Consume";
			break;
		case 20924:
			itemDef.name = "Chocolate Double-scoop";
            ItemDef.copyMostDefs(itemDef, 12852);
			itemDef.rotationX = 1400;
            itemDef.modelZoom = 2422;
            itemDef.modelID = 59508;
            itemDef.actions[0] = "Consume";
			break;
		case 20925:
			itemDef.name = "Chocolate Triple-scoop";
            ItemDef.copyMostDefs(itemDef, 12852);
			itemDef.rotationX = 1400;
            itemDef.modelZoom = 2422;
            itemDef.modelID = 59509;
            itemDef.actions[0] = "Consume";
			break;
		case 20927:
			itemDef.name = "Summer sword";
            itemDef.modelID = 59530;
            itemDef.maleEquip1 = 59530;
            itemDef.femaleEquip1 = 59530;
            itemDef.actions[1] = "Equip";
			itemDef.originalModelColors = new int[] { 40 };
			itemDef.newModelColor = new int[] { 76};
			break;
		case 6583:
			itemDef.name = "Godzilla ring";
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 4769:
			itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.actions[4] = "Drop";
			break;
		case 922:
			ItemDef.copyModel(itemDef, 3974);
			itemDef.name = "Sirenic Wings";
            itemDef.actions[2] = "@or2@Salvage";
			itemDef.originalModelColors = new int[] { 59 };
			itemDef.newModelColor = new int[] { 53};
			break;
		case 2595:
			itemDef.name = "Pet Elon Musk";
            itemDef.modelID = 74583;
            itemDef.modelZoom = 791;
            itemDef.rotationX = 0;
            itemDef.rotationY = 370;
			itemDef.modelOffsetY = -70;
			itemDef.modelOffsetX = 10;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 11218:
			itemDef.name = "Pet Bluefire Dragon";
			ItemDef itemDef7 = ItemDef.forID(12458);
			itemDef.modelID = itemDef7.modelID;
			itemDef.modelOffset1 = itemDef7.modelOffset1;
			itemDef.modelOffsetX = itemDef7.modelOffsetX;
			itemDef.modelOffsetY = itemDef7.modelOffsetY;
			itemDef.modelZoom = itemDef7.modelZoom;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;

		case 5151:
			itemDef.name = "Pet Hellfire Dragon";
			ItemDef itemDef2 = ItemDef.forID(12458);
			itemDef.modelID = itemDef2.modelID;
			itemDef.modelOffset1 = itemDef2.modelOffset1;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;

		case 5157:
			itemDef.name = "Pet Bulbasaur";
            itemDef.modelID = 28402;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
			
		case 14924:
			itemDef.name = "@red@Blood Genie Pet";
            itemDef.modelID = 61382;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;

		case 4742:
			itemDef.name = "Pet Eevee";
            itemDef.modelID = 44203;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;

			
		case 14035:
			itemDef.name = "Pet Lugia";
            itemDef.modelID = 61189;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;

		case 19753:
			itemDef.name = "Kallen pet";
            itemDef.modelID = 97380;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;


		case 4743:
			itemDef.name = "@yel@Pet Jolteon";
            itemDef.modelID = 44206;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;

		case 4744:
			itemDef.name = "Pet Flareon";
            itemDef.modelID = 44207;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;


		case 4786:
			itemDef.name = "Pet Vaporeon";
            itemDef.modelID = 44208;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 4787:
			itemDef.name = "Pet Sylveon";
            itemDef.modelID = 44211;
            itemDef.modelZoom = 2400;
            itemDef.rotationY = 340;
            itemDef.rotationX = 320;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 1648:
			itemDef.name = "Pet AntMan";
            itemDef.modelID = 94278;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 1647:
			itemDef.name = "Pet Mewtwo";
            itemDef.modelID = 23975;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 1855:
			itemDef.name = "Pet Zorbak";
            itemDef.modelID = 23973;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 2756:
			itemDef.name = "Pet Stoned Toad";
            itemDef.modelID = 23969;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 2757:
			itemDef.name = "Drakkon Pet";
            itemDef.modelID = 23974;
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 2758:
			itemDef.name = "Galvek Pet";
            itemDef.modelID = 23970;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;

		case 2759:
			itemDef.name = "Vasa Nistirio Pet";
            itemDef.modelID = 23967;
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 2762:
			itemDef.name = "Supreme Darkbeast Pet";
            itemDef.modelID = 23968;
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 2763:
			itemDef.name = "Virulent Dragon Pet";
            itemDef.modelID = 23966;
            itemDef.modelZoom = 2000;
            itemDef.rotationX = 0;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 2764:
			itemDef.name = "Leo the Lion Pet";
            itemDef.modelID = 23976;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 18377:
			itemDef.name = "Pet Bandicoot";
            itemDef.modelID = 62782;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 5161:
			itemDef.name = "Pet Joker";
            itemDef.modelID = 23107;
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
        case 5561:
            itemDef.name = "VIP Gem";
            break;
        case 7678:
            itemDef.name = "VIP Key";
            break;
        case 16441:
			ItemDef.copyModel(itemDef, 7678);
            itemDef.name = "Minigame Chest key";
            break;
        case 8866:
		//	ItemDef.copyModel(itemDef, 7678);
            itemDef.modelID = 23590;
            itemDef.modelZoom = 400;
            itemDef.name = "@yel@Millenial key";
            break;
        case 10500:
		//	ItemDef.copyModel(itemDef, 7678);
            itemDef.modelID = 23591;
            itemDef.maleEquip1 = 23592;
            itemDef.femaleEquip1 = 23592;
            itemDef.modelZoom = 700;
            itemDef.name = "@yel@Millenial Necklace";
            break;
        case 10502:
			ItemDef.copyModel(itemDef, 773);
            itemDef.modelID = 23593;
            itemDef.maleEquip1 = 23593;
            itemDef.femaleEquip1 = 23593;
            itemDef.modelZoom = 490;
            itemDef.name = "@yel@Millenial Ring";
            break;
		case 18620:
			itemDef.name = "Pet Elemental";
			itemDef2 = ItemDef.forID(12458);
            itemDef.modelZoom = 2750;
            itemDef.rotationY = 340;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 5160:
			itemDef.name = "Pet Charmander";
            itemDef.modelID = 28401;
            itemDef.modelZoom = 1750;
            itemDef.rotationY = 0;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 5162:
			itemDef.name = "Charizard Pet";
            itemDef.modelID = 28405;
            itemDef.modelZoom = 2500;
            itemDef.rotationY = 0;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 14469:
			itemDef.name = "Key loop";
			break;
		case 14470:
			itemDef.name = "Key Teeth";
			break;
		case 14471:
			itemDef.name = "Dungeon Key";
			break;
		case 5163:
			itemDef.name = "@yel@Broly Jr(DOUBLE VOTE PET)";
            itemDef.modelID = 27631;
            itemDef.modelZoom = 1750;
            itemDef.rotationY = 0;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 3317:
            itemDef.actions[1] = "Equip";
            itemDef.actions[2] = "@or2@Salvage";
            itemDef.actions[4] = "Drop";
			itemDef.name = "@red@20% Drop rate ring";
			break;		
		case 4770:
        itemDef.actions[1] = "Equip";
        itemDef.actions[2] = "@or2@Salvage";
        itemDef.actions[4] = "Drop";
        break;
		case 4771:
        itemDef.actions[1] = "Equip";
        itemDef.actions[2] = "@or2@Salvage";
        itemDef.actions[4] = "Drop";
        break;
		case 4772:
        itemDef.actions[1] = "Equip";
        itemDef.actions[2] = "@or2@Salvage";
        itemDef.actions[4] = "Drop";
        break;    
		case 5148:
			itemDef.name = "Skotizo Jr";
			ItemDef.copyModel(itemDef, 12458);
            itemDef.modelZoom = 1750;
            itemDef.rotationY = 0;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 5127:
			itemDef.name = "Goku Jr";
			ItemDef.copyModel(itemDef, 12458);
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 5135:
			itemDef.name = "God Fusion Goku Jr";
			ItemDef.copyModel(itemDef, 12458);
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 5128:
			itemDef.name = "Vegeta Jr";
			ItemDef.copyModel(itemDef, 12458);
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 12001:
			itemDef.name = "Beast Pet";
            itemDef.modelID = 50945;
            itemDef.modelZoom = 8750;
            itemDef.rotationY = 0;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 619:
			itemDef.name = "Pass card";
            itemDef.modelID = 2560;
			ItemDef copythe = ItemDef.forID(5606);
			itemDef.modelOffset1 = copythe.modelOffset1;
			itemDef.modelOffsetX = copythe.modelOffsetX;
			itemDef.modelOffsetY = copythe.modelOffsetY;
            //itemDef.modelZoom = 2250;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			break;
		case 12683:
			itemDef.name = "Godzilla Jr";
            itemDef.modelID = 97210;
            itemDef.modelZoom = 1750;
            itemDef.rotationY = 0;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 5166:
			itemDef.name = "Cookie Monster Pet";
            itemDef.modelID = 28328;
            itemDef.modelZoom = 1750;
            itemDef.rotationY = 0;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 18400:
			itemDef.name = "Pet Bugatti";
            itemDef.modelID = 13006;
            itemDef.modelZoom = 1750;
            itemDef.rotationY = 0;
            itemDef.rotationX = 0;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 19932:
			itemDef.name = "Pet Prime Walking Legs";
			itemDef2 = ItemDef.forID(12458);
			itemDef.modelID = itemDef2.modelID;
			itemDef.modelOffset1 = itemDef2.modelOffset1;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 5152:
			itemDef.name = "Pet Bluefire Dragon";
			itemDef2 = ItemDef.forID(12458);
			itemDef.modelID = itemDef2.modelID;
			itemDef.modelOffset1 = itemDef2.modelOffset1;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 3481:
			itemDef.name = "Ki'S Platebody";
			break;
		case 3483:
			itemDef.name = "Ki's Platelegs";
			break;
		case 4647:
			itemDef.name = "Onyx Platebody";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 4648:
			itemDef.name = "Onyx Platelegs";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 4649:
			itemDef.name = "Onyx FullHelm";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 4762:
			itemDef.name = "Kings platebody";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 4763:
			itemDef.name = "Kings platelegs";
            itemDef.actions[2] = "@or2@Salvage";
			break;

		case 3981:
			itemDef.name = "Onyx Cape";
            itemDef.actions[2] = "@or2@Salvage";
			break;
		case 5153:
			itemDef.name = "Pet Lava Dragon";
			itemDef2 = ItemDef.forID(12458);
			itemDef.modelID = itemDef2.modelID;
			itemDef.modelOffset1 = itemDef2.modelOffset1;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		case 1867:
			itemDef.name = "Founders pet";
			itemDef2 = ItemDef.forID(12458);
			itemDef.modelID = itemDef2.modelID;
			itemDef.modelOffset1 = itemDef2.modelOffset1;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;

		case 5154:
			itemDef.name = "Pet Cool Dragon";
			itemDef2 = ItemDef.forID(12458);
			itemDef.modelID = itemDef2.modelID;
			itemDef.modelOffset1 = itemDef2.modelOffset1;
			itemDef.modelOffsetX = itemDef2.modelOffsetX;
			itemDef.modelOffsetY = itemDef2.modelOffsetY;
			itemDef.modelZoom = itemDef2.modelZoom;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
			break;
		}


		switch (itemDef.id) {
		case 6570:
		case 3064:
		case 3978:
		case 3932:
		case 4635:
		case 3973:
		case 4800:
		case 4801:
		case 3983:
		case 3943:
		case 19079:
		case 19080:
		case 3644:
		case 19081:
		case 19082:
		case 19083:
		case 19084:
		case 19085:
		case 19086:
		case 19087:
		case 19088:
		case 19089:
		case 19090:
		case 19091:
		case 3092:
		case 3824:
		case 3974:
		case 3811:
		case 4630:
		case 4767:
		case 5120:
		case 5121:
		case 5122:
		case 5077:
		case 4751:
		case 4762:
		case 4763:
		case 4764:
		case 4765:
		case 5089:
		case 3907:
		case 3905:
		case 5164:
		case 5139:
		case 5140:
		case 5141:
		case 4769:
		case 5165:
		case 5275:
		case 5276:
		case 3912:
		case 19101:
		case 19103:
		case 5147:
		case 3991:
		case 19900:
		case 19901:
		case 3980:
		case 3982:
		case 3990:
		case 4649:
		case 4648:
		case 4647:
		case 3981:
		case 19990:
		case 19991:
		case 3996:
		case 3995:
		case 3994:
		case 19943:
		case 19105:
		case 19996:
		case 3956:
		case 5022:
			itemDef.animateInventory = true;
			break;
		}
		return itemDef;
	}
}

