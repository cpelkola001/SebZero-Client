package com.arlania;

public class ItemDef_Emerald {
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
        

//    public static void newIDS(ItemDef itemDef, int id) {
//        switch (id) {
//            case 20700:
//                itemDef.name = "Pro Defender";
//                itemDef.modelID = 98650;
//                itemDef.maleEquip1 = 98651;
//                itemDef.femaleEquip1 = 98651;
//                itemDef.actions = new String[] {null, "Equip", "Upgrade", null, null};
//                break;
//            case 3980:
//                itemDef.name = "Exile cape";
//    			itemDef.editedModelColor = new int[] { 51 };//old
//    			itemDef.newModelColor = new int[] { 53 };//new
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//
//            case 16641:
//                ItemDef.copyModel(itemDef, 4078);
//                itemDef.name = "@bla@Minigame Key";
//                break;
//            case 6041:
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.name = "DR Amulet";
//                break;
//            case 12631:
//                itemDef.name = "@whi@Sailboat";
//                itemDef.modelID = 35151;
//                break;
//            case 20693:
//                ItemDef.copyModel(itemDef, 13262);
//                itemDef.name = "Tier 1 Defender";
//                break;
//
//            case 169:
//                ItemDef.copyModel(itemDef, 18732);
//                break;
//            case 171:
//                ItemDef.copyModel(itemDef, 18733);
//                break;
//            case 173:
//                ItemDef.copyModel(itemDef, 18734);
//                break;
//
//            case 20694:
//                ItemDef.copyModel(itemDef, 13262);
//                itemDef.name = "Tier 2 Defender";
//                break;
//            case 3931:
//                changeTexture(id, 40, 58);
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.name = "Godzilla Cape";
//                break;
//
//            case 20695:
//                ItemDef.copyModel(itemDef, 13262);
//                itemDef.name = "Tier 3 Defender";
//                break;
//
//            case 20696:
//                ItemDef.copyModel(itemDef, 13262);
//                itemDef.name = "Tier 4 Defender";
//                break;
//
//            case 20697:
//                ItemDef.copyModel(itemDef, 13262);
//                itemDef.name = "Tier 5 Defender";
//                break;
//
//            case 20698:
//                ItemDef.copyModel(itemDef, 13262);
//                itemDef.name = "Tier 6 Defender";
//                break;
//
//            case 20699:
//                ItemDef.copyModel(itemDef, 13262);
//                itemDef.name = "Tier 7 Defender";
//                break;
//
//            case 18955:
//                itemDef.name = "Exile Boots";
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//
//            case 4001:
//                itemDef.name = "Exile Helmet";
//    			itemDef.editedModelColor = new int[] { 51 };//old
//    			itemDef.newModelColor = new int[] { 53 };//new
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//            case 3999:
//                itemDef.name = "Exile Platebody";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.editedModelColor = new int[] { 51 };//old
//    			itemDef.newModelColor = new int[] { 53 };//new
//                break;
//
//            case 4000:
//                itemDef.name = "Exile Platelegs";
//    			itemDef.editedModelColor = new int[] { 51 };//old
//    			itemDef.newModelColor = new int[] { 53 };//new
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//
//            case 18956:
//                itemDef.name = "Exile Gloves";
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//
//            case 18957:
//                itemDef.name = "Exile Whip";
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//
//
//
//            case 13094:
//                itemDef.modelID = 40226;
//                itemDef.name = "@or2@Halloween @bla@Scythe";
//                itemDef.description = "Trick or Treat";
//                itemDef.maleEquip1 = 40226;
//                itemDef.femaleEquip1 = 40226;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1252;
//                itemDef.rotationX = 1157;
//                itemDef.rotationY = 809;
//    			//itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = -43;
//                itemDef.stackable = false;
//                break;
//
//            case 13095:
//                itemDef.modelID = 40225;
//                itemDef.stackable = false;
//                itemDef.name = "H'ween Aura";
//                itemDef.description = "Trick or Treat";
//                itemDef.maleEquip1 = 40225;
//                itemDef.femaleEquip1 = 40225;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[4] = "Drop";
//                break;
//
//
//            case 18980:
//                itemDef.modelZoom = 1000;
//                itemDef.rotationX = 175;
//                itemDef.rotationY = 100;
//                itemDef.modelID = 99277;
//                itemDef.maleEquip1 = 19993;
//                itemDef.femaleEquip1 = 19993;
//
//                break;
//    		case 6507:
//    			itemDef.modelID = 43098;
//                itemDef.modelZoom = 600;
//                itemDef.rotationX = 75;
//    			itemDef.name = "Deluge Potion";
//    			itemDef.animateInventory = true;
//                itemDef.actions[0] = "@whi@Consume";
//    			break;
//
//            case 11425:
//                itemDef.name = "Duel-Disc Offhand";
//                itemDef.description = "Duel-Disc Offhand";
//                ItemDef.copyMostDefs(itemDef, 8736);
//                itemDef.modelID = 74851;
//                itemDef.maleEquip1 = 60981;
//                itemDef.femaleEquip1 = 60981;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@whi@Charge";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 18981:
//                itemDef.modelZoom = 1577;
//                itemDef.rotationX = 1532;
//                itemDef.rotationY = 522;
//                itemDef.modelID = 99276;
//                itemDef.maleEquip1 = 19995;
//                itemDef.femaleEquip1 = 19995;
//
//                break;
//
//            case 3307:
//                itemDef.modelID = 23991;
//                itemDef.maleEquip1 = 23991;
//                itemDef.femaleEquip1 = 23991;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "@yel@Yellow Super Saiyan Aura";
//                break;
//
//
//            case 6489:
//                itemDef.modelID = 63010;
//                itemDef.maleEquip1 = 63010;
//                itemDef.femaleEquip1 = 63010;
//                itemDef.modelZoom = 1200;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "null";
//                break;
//
//            case 5048:
//                itemDef.modelID = 40159;
//                itemDef.maleEquip1 = 40160;
//                itemDef.femaleEquip1 = 40160;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Skiller Flex";
//                break;
//
//            case 5049:
//                itemDef.modelID = 40162;
//                itemDef.maleEquip1 = 40161;
//                itemDef.femaleEquip1 = 40161;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Elegant black hat";
//                break;
//
//            case 5050:
//                itemDef.modelID = 40164;
//                itemDef.maleEquip1 = 40163;
//                itemDef.femaleEquip1 = 40163;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Elegant black shirt";
//                break;
//
//            case 5051:
//                itemDef.modelID = 40166;
//                itemDef.maleEquip1 = 40165;
//                itemDef.femaleEquip1 = 40165;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "elegant black trousers";
//                break;
//
//            case 4804:
//                itemDef.modelID = 100310;
//                itemDef.maleEquip1 = 100310;
//                itemDef.femaleEquip1 = 100310;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Garen helmet";
//                break;
//
//            case 4805:
//                itemDef.modelID = 100311;
//                itemDef.maleEquip1 = 100311;
//                itemDef.femaleEquip1 = 100311;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Garen Top";
//                break;
//
//            case 4806:
//                itemDef.modelID = 100312;
//                itemDef.maleEquip1 = 100312;
//                itemDef.femaleEquip1 = 100312;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Garen Leggings";
//                break;
//
//            case 4807:
//                itemDef.modelID = 100313;
//                itemDef.maleEquip1 = 100313;
//                itemDef.femaleEquip1 = 100313;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Garen Gloves";
//                break;
//
//            case 4808:
//                itemDef.modelID = 100314;
//                itemDef.maleEquip1 = 100314;
//                itemDef.femaleEquip1 = 100314;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Garen Boots";
//                break;
//
//
//
//            case 3308:
//                itemDef.modelID = 23992;
//                itemDef.maleEquip1 = 23992;
//                itemDef.femaleEquip1 = 23992;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Black Super Saiyan Aura";
//                break;
//
//
//            case 12238:
//				itemDef.name = "@red@Owner Maul";
//                ItemDef.copyMostDefs(itemDef, 4078);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.modelZoom = 2200;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//				itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//				itemDef.stackable = false;
//                itemDef.modelID = 61165;
//                itemDef.maleEquip1 = 61166;
//                itemDef.femaleEquip1 = 61166;
//                break;
//
//            case 3309:
//                itemDef.modelID = 23993;
//                itemDef.maleEquip1 = 23993;
//                itemDef.femaleEquip1 = 23993;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Red Super Saiyan Aura";
//                break;
//
//            case 6828:
//                itemDef.actions = new String[5];
//                itemDef.actions[2] = "Claim";
//                itemDef.name = "Imbued Package";
//                break;
//
//            case 3576:
//                itemDef.actions = new String[5];
//                itemDef.actions[0] = "Claim";
//                itemDef.name = "@yel@Loot box (tier 1)";
//                break;
//
//            case 3578:
//
//                itemDef.actions[0] = "Claim";
//                itemDef.name = "Loot box (tier 2)";
//                break;
//
//            case 10205:
//                itemDef.originalModelColors = new int[] { 60 };
//                itemDef.newModelColor = new int[] { 57 };
//                itemDef.animateInventory = true;
//                itemDef.actions[0] = "Claim";
//                itemDef.modelID = 97574;
//                itemDef.name = "@cya@Bond Casket";
//                break;
//
//
//            case 10478:
//                itemDef.modelZoom = 1017;
//                itemDef.rotationX = 50;
//                itemDef.rotationY = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 0;
//                itemDef.originalModelColors = new int[] { 40 };
//                itemDef.newModelColor = new int[] { 59 };
//                itemDef.animateInventory = true;
//                itemDef.actions[0] = "Claim";
//                itemDef.modelID = 19296;
//                itemDef.name = "@whi@Diamond chest";
//                break;
//
//
//            case 14033:
//                ItemDef.copyMostDefs(itemDef, 2714);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.originalModelColors = new int[] { 60 };
//                itemDef.newModelColor = new int[] { 58 };
//                itemDef.animateInventory = true;
//                itemDef.actions[0] = "Claim";
//                itemDef.modelID = 97574;
//                itemDef.name = "@gre@Green Arsenic chest";
//                break;
//
//            case 16488:
//                ItemDef.copyMostDefs(itemDef, 2714);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.originalModelColors = new int[] { 60 };
//                itemDef.newModelColor = new int[] { 53 };
//                itemDef.animateInventory = true;
//                itemDef.actions[0] = "Claim";
//                itemDef.modelID = 97574;
//                itemDef.name = "@blu@Blue Arsenic chest";
//                break;
//
//            case 2795:
//
//                itemDef.actions[0] = "Claim";
//                itemDef.name = "Loot box (tier 3)";
//                break;
//
//            case 3311:
//                itemDef.modelID = 23995;
//                itemDef.maleEquip1 = 23996;
//                itemDef.femaleEquip1 = 23996;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Skotizos Mace";
//                break;
//
//            case 3312:
//                itemDef.modelID = 61218;
//                itemDef.maleEquip1 = 61219;
//                itemDef.femaleEquip1 = 61219;
//                ItemDef.copyMostDefs(itemDef, 1021);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "@whi@Nirvana Slayer cape";
//                break;
//
//            case 14036:
//                itemDef.modelID = 23997;
//                itemDef.maleEquip1 = 23998;
//                itemDef.femaleEquip1 = 23998;
//                ItemDef.copyMostDefs(itemDef, 1021);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "@red@Blood @bla@Slayer cape";
//                break;
//
//            case 14931:
//                itemDef.modelID = 61462;
//                itemDef.maleEquip1 = 61462;
//                itemDef.femaleEquip1 = 61462;
//                ItemDef.copyMostDefs(itemDef, 1021);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "@whi@Yin @or2@And@bla@ Yang@or2@ Cape";
//                break;
//
//
//            case 16519:
//                itemDef.modelID = 61452;
//                itemDef.maleEquip1 = 61450;
//                itemDef.femaleEquip1 = 61450;
//                ItemDef.copyMostDefs(itemDef, 1021);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "@red@Universal @whi@ Wings";
//                break;
//
//            case 3313:
//                itemDef.modelID = 24000;
//                itemDef.maleEquip1 = 23999;
//                itemDef.femaleEquip1 = 23999;
//                itemDef.actions = new String[] {null, "Wear", "Dissolve", null, null};
//                itemDef.name = "Corrupt Platebody";
//                break;
//
//            case 3314:
//                itemDef.modelID = 24002;
//                itemDef.maleEquip1 = 24001;
//                itemDef.femaleEquip1 = 24001;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Corrupt Platelegs";
//                break;
//
//            case 5214:
//                itemDef.name = "Omniscient Blade";
//                itemDef.modelID = 44731;
//                itemDef.maleEquip1 = 44732;
//                itemDef.femaleEquip1 = 44732;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 20916:
//                itemDef.name = "Holy scythe of vitur";
//                itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
//                itemDef.modelZoom = 2105;
//                itemDef.rotationX = 23;
//                itemDef.rotationY = 327;
//                itemDef.modelOffsetX = 1;
//    	    itemDef.modelOffsetY = 17;
//                itemDef.modelID = 29564;
//                itemDef.maleEquip1 = 29560;
//                itemDef.femaleEquip1 = 29555;
//                break;
//
//            case 20917:
//                itemDef.name = "Saguine scythe of vitur";
//                itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
//                itemDef.modelZoom = 2105;
//                itemDef.rotationX = 23;
//                itemDef.rotationY = 327;
//                itemDef.modelOffsetX = 1;
//                itemDef.modelOffsetY = 17;
//                itemDef.modelID = 29566;
//                itemDef.maleEquip1 = 29562;
//                itemDef.femaleEquip1 = 29557;
//                break;
//            case 20918:
//    			itemDef.name = "Holy ghrazi rapier";
//    			itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
//    			itemDef.modelZoom = 2064;
//    			itemDef.rotationY = 0;
//    			itemDef.rotationX = 1603;
//    			//itemDef.rotationZ = 552;
//    			itemDef.modelOffsetX = 5;
//    			itemDef.modelOffsetY = -18;
//    			itemDef.modelID = 29565;
//    			itemDef.maleEquip1 = 29558;
//    			itemDef.femaleEquip1 = 29561;
//    			itemDef.editedModelColor = new int[] { 90, };
//                            itemDef.newModelColor = new int[] { -9762 };
//    			break;
//            case 20919:
//    			itemDef.name = "Holy sanguinesti staff";
//    			itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
//    			itemDef.modelZoom = 2258;
//    			itemDef.rotationY = 552;
//    			itemDef.rotationX = 1558;
//    			//itemDef.modelOffsetX = -5;
//    			itemDef.modelOffsetY = 3;
//    			itemDef.modelID = 29563;
//    			itemDef.maleEquip1 = 29559;
//    			break;
//
//            case 6531:
//                itemDef.name = "@bla@Nightmare Scythe";
//                itemDef.modelID = 40207;
//                itemDef.maleEquip1 = 40207;
//                itemDef.femaleEquip1 = 40207;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 5215:
//                itemDef.name = "Diamond Owner cape";
//                itemDef.modelID = 44733;
//                itemDef.maleEquip1 = 44734;
//                itemDef.femaleEquip1 = 44734;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 14553:
//                itemDef.name = "Supporter cape";
//                itemDef.modelID = 60899;
//                itemDef.maleEquip1 = 60899;
//                itemDef.femaleEquip1 = 60899;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16469:
//                itemDef.name = "Community cape";
//                itemDef.modelID = 60994;
//                itemDef.maleEquip1 = 60994;
//                itemDef.femaleEquip1 = 60994;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//
//            case 14551:
//                itemDef.name = "Administrator cape";
//                itemDef.modelID = 60880;
//                itemDef.maleEquip1 = 60880;
//                itemDef.femaleEquip1 = 60880;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 14552:
//                itemDef.name = "Moderator cape";
//                itemDef.modelID = 60889;
//                itemDef.maleEquip1 = 60889;
//                itemDef.femaleEquip1 = 60889;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 7037:
//                itemDef.name = "Staff cape";
//                itemDef.modelID = 97427;
//                itemDef.maleEquip1 = 97428;
//                itemDef.femaleEquip1 = 97428;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 7038:
//                itemDef.name = "Staff wings";
//                itemDef.modelID = 97429;
//                itemDef.maleEquip1 = 97430;
//                itemDef.femaleEquip1 = 97430;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//
//            case 3315:
//                itemDef.modelID = 24004;
//                itemDef.maleEquip1 = 24003;
//                itemDef.femaleEquip1 = 24003;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Corrupt Boots";
//                break;
//
//
//            case 3318:
//                itemDef.modelID = 24006;
//                itemDef.maleEquip1 = 24005;
//                itemDef.femaleEquip1 = 24005;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Corrupt Gloves";
//                break;
//
//
//
//            case 3638:
//                itemDef.name = "Advanced box pet";
//                itemDef.modelID = 23121;
//                itemDef.modelZoom = 2750;
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//
//            case 19961:
//                itemDef.name = "@whi@Summer Angel Guardian";
//                itemDef.modelID = 59513;
//                itemDef.modelZoom = 1750;
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//            case 3891:
//                itemDef.name = "Yugi Muto Pet";
//                itemDef.modelID = 60974;
//                itemDef.modelZoom = 1750;
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//            case 3639:
//                itemDef.name = "Extreme box pet";
//                itemDef.modelID = 23121;
//                itemDef.modelZoom = 2750;
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//            case 605:
//                ItemDef.copyModel(itemDef, 4078);
//                itemDef.name = "Halloween Event Key@0r2@(1)";
//                break;
//
//            case 1590:
//                itemDef.name = "Halloween Event Key@0r2@(2)";
//                break;
//
//            case 993:
//                itemDef.name = "Halloween Event Key@0r2@(3)";
//                break;
//
//            case 3640:
//                itemDef.name = "Supreme box pet";
//                itemDef.modelID = 23121;
//                itemDef.modelZoom = 2750;
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//            case 5042:
//                itemDef.name = "Conqueror Helmet";
//                itemDef.modelID = 40190;
//                itemDef.maleEquip1 = 40191;
//                itemDef.femaleEquip1 = 40191;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 7029:
//                itemDef.name = "Japers Fishing Hat";
//                itemDef.modelID = 60500;
//                itemDef.maleEquip1 = 60501;
//                itemDef.femaleEquip1 = 60501;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 7030:
//                itemDef.name = "Japers Fishing Vest";
//                itemDef.modelID = 60502;
//                itemDef.maleEquip1 = 60503;
//                itemDef.femaleEquip1 = 60503;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 7031:
//                itemDef.name = "Japers Fishing Trousers";
//                itemDef.modelID = 60504;
//                itemDef.maleEquip1 = 60505;
//                itemDef.femaleEquip1 = 60505;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 7032:
//                itemDef.name = "Japers Fishing Gloves";
//                itemDef.modelID = 60506;
//                itemDef.maleEquip1 = 60507;
//                itemDef.femaleEquip1 = 60507;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 7033:
//                itemDef.name = "Japers Fishing Boots";
//                itemDef.modelID = 60508;
//                itemDef.maleEquip1 = 60508;
//                itemDef.femaleEquip1 = 60508;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5043:
//                itemDef.name = "Conqueror Chestplate";
//                itemDef.modelID = 40192;
//                itemDef.maleEquip1 = 40193;
//                itemDef.femaleEquip1 = 40193;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 5044:
//                itemDef.name = "Conqueror Platelegs";
//                itemDef.modelID = 40194;
//                itemDef.maleEquip1 = 40195;
//                itemDef.femaleEquip1 = 40195;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 5045:
//                itemDef.name = "Conqueror Gloves";
//                itemDef.modelID = 40196;
//                itemDef.maleEquip1 = 40197;
//                itemDef.femaleEquip1 = 40197;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 5046:
//                itemDef.name = "Conqueror Boots";
//                itemDef.modelID = 40198;
//                itemDef.maleEquip1 = 40198;
//                itemDef.femaleEquip1 = 40198;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3810:
//                itemDef.modelID = 24009;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 24015;
//                itemDef.femaleEquip1 = 24015;
//                itemDef.name = "Omega Helmet";
//                break;
//
//            case 3811:
//                itemDef.modelID = 24010;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 24016;
//                itemDef.femaleEquip1 = 24016;
//                itemDef.name = "Omega Platebody";
//                break;
//
//            case 3812:
//                itemDef.modelID = 24011;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 24017;
//                itemDef.femaleEquip1 = 24017;
//                itemDef.name = "Omega Platelegs";
//                break;
//
//            case 3813:
//                itemDef.modelID = 24012;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 24018;
//                itemDef.femaleEquip1 = 24018;
//                itemDef.name = "Omega Gloves";
//                break;
//
//            case 3814:
//                itemDef.modelID = 24013;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 24019;
//                itemDef.femaleEquip1 = 24019;
//                itemDef.name = "Omega Boots";
//                break;
//
//            case 3815:
//                itemDef.modelID = 24014;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 24020;
//                itemDef.femaleEquip1 = 24020;
//                itemDef.name = "Omega Wings";
//                break;
//
//            case 15375:
//                itemDef.animateInventory = true;
//                itemDef.name = "@yel@Chance Box";
//                ItemDef.copyModel(itemDef, 3912);
//                changeTexture(id, 63, 55);
//                break;
//
//            case 3912:
//                itemDef.animateInventory = true;
//                itemDef.name = "@gre@Wealth box";
//                changeTexture(id, 63, 80);
//                break;
//
//
//            case 6503:
//                itemDef.name = "@or2@Halloween Box@bla@(DPS)";
//                ItemDef.copyModel(itemDef, 3912);
//                changeTexture(id, 63, 88);
//                itemDef.animateInventory = true;
//                break;
//
//            case 6504:
//                itemDef.name = "@or2@Halloween Box@bla@(Cosmetic)";
//                ItemDef.copyModel(itemDef, 3912);
//                changeTexture(id, 63, 88);
//                itemDef.animateInventory = true;
//                break;
//
//            case 3322:
//                itemDef.modelID = 24008;
//                itemDef.maleEquip1 = 24007;
//                itemDef.femaleEquip1 = 24007;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "@Corrupt Helmet";
//                break;
//
//            case 3310:
//                itemDef.modelID = 23994;
//                itemDef.maleEquip1 = 23994;
//                itemDef.femaleEquip1 = 23994;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Blue Super Saiyan Aura";
//                break;
//
//
//
//            case 18982:
//                itemDef.modelZoom = 1461;
//                itemDef.rotationX = 1517;
//                itemDef.rotationY = 476;
//                itemDef.modelID = 99275;
//                itemDef.maleEquip1 = 19996;
//                itemDef.femaleEquip1 = 19996;
//                break;
//
//            case 19002:
//                itemDef.modelZoom = 1772;
//                itemDef.rotationX = 793;
//                itemDef.rotationY = 416;
//                itemDef.modelID = 99274;
//                itemDef.maleEquip1 = 5001;
//                itemDef.femaleEquip1 = 5001;
//                break;
//
//            case 3300:
//                itemDef.modelZoom = 1416;
//                itemDef.rotationX = 1559;
//                itemDef.rotationY = 538;
//                itemDef.modelID = 95112;
//                itemDef.maleEquip1 = 95111;
//                itemDef.femaleEquip1 = 95111;
//                break;
//
//            case 3301:
//                itemDef.modelZoom = 1416;
//                itemDef.rotationX = 1559;
//                itemDef.rotationY = 538;
//                itemDef.modelID = 95113;
//                itemDef.maleEquip1 = 95114;
//                itemDef.femaleEquip1 = 95114;
//                break;
//
//            case 3302:
//                itemDef.modelZoom = 1416;
//                itemDef.rotationX = 1559;
//                itemDef.rotationY = 538;
//                itemDef.modelID = 95116;
//                itemDef.maleEquip1 = 95115;
//                itemDef.femaleEquip1 = 95115;
//                break;
//
//            case 18933:
//                itemDef.modelZoom = 1416;
//                itemDef.rotationX = 1559;
//                itemDef.rotationY = 538;
//                itemDef.modelID = 99273;
//                itemDef.maleEquip1 = 80004;
//                itemDef.femaleEquip1 = 80004;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//
//            case 3077:
//                itemDef.modelZoom = 1611;
//                itemDef.rotationX = 549;
//                itemDef.rotationY = 780;
//                break;
//
//            case 20571:
//                itemDef.modelID = 61121;
//                itemDef.maleEquip1 = 61124;
//                itemDef.femaleEquip1 = 61124;
//                itemDef.modelZoom = 1611;
//                itemDef.rotationX = 549;
//                itemDef.rotationY = 780;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 20583:
//                itemDef.modelID = 61137;
//                itemDef.modelZoom = 511;
//                itemDef.name = "Black-Star Dragon Ball(1)";
//                break;
//
//            case 20584:
//                itemDef.modelID = 61138;
//                itemDef.modelZoom = 511;
//                itemDef.name = "Black-Star Dragon Ball(2)";
//                break;
//
//            case 20585:
//                itemDef.modelID = 61139;
//                itemDef.modelZoom = 531;
//                itemDef.name = "Black-Star Dragon Ball(3)";
//                itemDef.modelOffsetX = 3;
//                break;
//
//            case 20586:
//                itemDef.modelID = 61140;
//                itemDef.modelZoom = 551;
//                itemDef.name = "Black-Star Dragon Ball(4)";
//                break;
//            case 20587:
//                itemDef.modelID = 61141;
//                itemDef.modelZoom = 600;
//                itemDef.name = "Black-Star Dragon Ball(5)";
//                break;
//            case 20588:
//                itemDef.modelID = 61145;
//                itemDef.modelZoom = 651;
//                itemDef.name = "Black-Star Dragon Ball(6)";
//                break;
//            case 20589:
//                itemDef.modelID = 61148;
//                itemDef.modelZoom = 711;
//                itemDef.modelOffsetX = 3;
//                itemDef.name = "Black-Star Dragon Ball(7)";
//                break;
//            case 20590:
//                itemDef.modelID = 61148;
//                itemDef.modelZoom = 711;
//                itemDef.modelOffsetX = 3;
//                itemDef.name = "@or2@Black-Star Complete set";
//                break;
//
//            case 8033:
//                ItemDef.copyMostDefs(itemDef, 20582);
//                itemDef.modelID = 60679;
//                itemDef.modelZoom = 711;
//                itemDef.modelOffsetX = 3;
//                itemDef.name = "@re1@Q's @or2@Namek Complete set";
//                break;
//
//            case 8045:
//                ItemDef.copyMostDefs(itemDef, 20582);
//                itemDef.modelID = 60678;
//                itemDef.modelZoom = 711;
//                itemDef.modelOffsetX = 3;
//                itemDef.name = "@bla@Femboy's @mag@Namek Complete set";
//                break;
//
//
//            case 7013:
//                ItemDef.copyMostDefs(itemDef, 20582);
//                itemDef.modelID = 12892;
//                itemDef.modelZoom = 711;
//                itemDef.modelOffsetX = 3;
//                itemDef.name = "@cya@SebZero's @bla@Namek Complete set";
//                break;
//
//            case 7015:
//                ItemDef.copyMostDefs(itemDef, 20582);
//                itemDef.modelID = 12891;
//                itemDef.modelZoom = 711;
//                itemDef.modelOffsetX = 3;
//                itemDef.name = "@red@Ninja's @bla@Namek Complete set";
//                break;
//
//    		case 20591:
//    			itemDef.modelID = 44729;
//    			itemDef.name = "Custom Aura";
//    			itemDef.modelZoom = 2000;
//    			itemDef.rotationY = 0;
//    			itemDef.rotationX = 0;
//    			itemDef.modelOffsetX = 0;
//    			itemDef.modelOffsetY = 5;
//    			itemDef.femaleEquip1 = 61149;
//    			itemDef.maleEquip1 = 61149;
//    			itemDef.description = "Flex the donations";
//    			itemDef.groundActions = new String[5];
//    			itemDef.groundActions[2] = "Take";
//    			itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//    			itemDef.actions[4] = "Drop";
//    			break;
//
//            case 18636:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 61150;
//                itemDef.modelZoom = 1500;
//                itemDef.rotationY = 700;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 =  61151;
//                itemDef.femaleEquip1 = 61151;
//                itemDef.name = "@yel@Iron Man Helmet";
//                break;
//
//            case 18637:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 61156;
//                itemDef.modelZoom = 1500;
//                itemDef.rotationY = 700;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 =  61155;
//                itemDef.femaleEquip1 = 61155;
//                itemDef.name = "@yel@Iron Man Platebody";
//                break;
//
//            case 18638:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 61157;
//                itemDef.modelZoom = 1500;
//                itemDef.rotationY = 700;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 =  61158;
//                itemDef.femaleEquip1 = 61158;
//                itemDef.name = "@yel@Iron Man Legs";
//                break;
//
//            case 18470:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 23603;
//                itemDef.modelZoom = 1500;
//                itemDef.rotationY = 700;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 =  23604;
//                itemDef.femaleEquip1 = 23604;
//                itemDef.name = "@yel@Iron Man gloves";
//                break;
//            case 18471:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 23602;
//                itemDef.modelZoom = 1500;
//                itemDef.rotationY = 700;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 =  23602;
//                itemDef.femaleEquip1 = 23602;
//                itemDef.name = "@yel@Iron Man boots";
//                break;
//
//            case 20575:
//                itemDef.modelID = 61127;
//                itemDef.modelZoom = 511;
//                itemDef.name = "Namek Dragon Ball(1)";
//                break;
//            case 20576:
//                itemDef.modelID = 61128;
//                itemDef.modelZoom = 511;
//                itemDef.name = "Namek Dragon Ball(2)";
//                break;
//
//            case 20577:
//                itemDef.modelID = 61131;
//                itemDef.modelZoom = 531;
//                itemDef.name = "Namek Dragon Ball(3)";
//                itemDef.modelOffsetX = 3;
//                break;
//
//            case 20578:
//                itemDef.modelID = 61132;
//                itemDef.modelZoom = 551;
//                itemDef.name = "Namek Dragon Ball(4)";
//                break;
//            case 20579:
//                itemDef.modelID = 61133;
//                itemDef.modelZoom = 600;
//                itemDef.name = "Namek Dragon Ball(5)";
//                break;
//            case 20580:
//                itemDef.modelID = 61134;
//                itemDef.modelZoom = 651;
//                itemDef.name = "Namek Dragon Ball(6)";
//                break;
//            case 20581:
//                itemDef.modelID = 61136;
//                itemDef.modelZoom = 711;
//                itemDef.modelOffsetX = 3;
//                itemDef.name = "Namek Dragon Ball(7)";
//                break;
//            case 20582:
//                itemDef.modelID = 61136;
//                itemDef.modelZoom = 711;
//                itemDef.modelOffsetX = 3;
//                itemDef.name = "@or2@Namek Complete set";
//                break;
//            case 19893:
//                itemDef.modelZoom = 1826;
//                itemDef.rotationX = 1954;
//                itemDef.rotationY = 613;
//
//                break;
//
//
//            case 19025:
//                itemDef.modelID = 74728;
//                itemDef.maleEquip1 =  74727;
//                itemDef.femaleEquip1 = 74727;
//                itemDef.modelZoom = 1087;
//                itemDef.rotationX = 176;
//                itemDef.rotationY = 230;
//                break;
//
//            case 18895:
//                itemDef.modelZoom = 700;
//                itemDef.rotationX = 100;
//                itemDef.rotationY = 520;
//                break;
//
//            case 18934:
//                itemDef.modelZoom = 1422;
//                itemDef.rotationX = 1592;
//                itemDef.rotationY = 416;
//                itemDef.modelID = 99272;
//                itemDef.maleEquip1 = 80007;
//                itemDef.femaleEquip1 = 80007;
//                break;
//
//            case 18896:
//                itemDef.modelZoom = 2242;
//                itemDef.rotationX = 1769;
//                itemDef.rotationY = 513;
//                break;
//
//            case 18946:
//                itemDef.modelZoom = 1366;
//                itemDef.rotationX = 740;
//                itemDef.rotationY = 453;
//                break;
//
//            case 18943:
//                itemDef.modelZoom = 1515;
//                itemDef.rotationX = 2000;
//                itemDef.rotationY = 472;
//
//                break;
//
//            case 18944:
//                itemDef.modelZoom = 1632;
//                itemDef.rotationX = 2000;
//                itemDef.rotationY = 577;
//
//                break;
//
//            case 18945:
//                itemDef.modelZoom = 971;
//                itemDef.rotationX = 207;
//                itemDef.rotationY = 230;
//                break;
//
//            case 19886:
//                itemDef.modelZoom = 886;
//                break;
//
//            case 19106:
//                itemDef.modelZoom = 886;
//                break;
//
//
//            case 3820:
//                itemDef.name = "Lucid Full Helm";
//                itemDef.modelZoom = 948;
//                itemDef.rotationX = 145;
//                itemDef.rotationY = 100;
//    			itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//
//            case 19027:
//                itemDef.modelZoom = 1801;
//                itemDef.rotationX = 679;
//                itemDef.rotationY = 619;
//                break;
//
//            case 18967:
//                itemDef.modelZoom = 944;
//                itemDef.rotationX = 190;
//                itemDef.rotationY = 100;
//                break;
//
//            case 19024:
//                itemDef.modelZoom = 1437;
//                itemDef.rotationX = 100;
//                itemDef.rotationY = 472;
//                break;
//
//            case 16555:
//                itemDef.modelZoom = 3512;
//                itemDef.rotationX = 1463;
//                itemDef.rotationY = 519;
//                break;
//
//            case 19004:
//                itemDef.modelZoom = 1656;
//                itemDef.rotationX = 2000;
//                itemDef.rotationY = 1603;
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 9104:
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//            	break;
//
//            case 11605:
//                itemDef.modelZoom = 1872;
//                itemDef.rotationX = 345;
//                itemDef.rotationY = 384;
//                break;
//
//            case 18901:
//                itemDef.modelZoom = 1654;
//                itemDef.rotationX = 1004;
//                itemDef.rotationY = 472;
//                break;
//
//            case 18922:
//                itemDef.modelZoom = 2944;
//                itemDef.rotationX = 100;
//                itemDef.rotationY = 100;
//                break;
//
//            case 18998:
//                itemDef.modelZoom = 712;
//                itemDef.rotationX = 1845;
//                itemDef.rotationY = 121;
//                break;
//
//            case 18961:
//                itemDef.modelZoom = 1900;
//                itemDef.rotationX = 1545;
//                itemDef.rotationY = 657;
//                itemDef.modelID = 99271;
//                itemDef.maleEquip1 = 11118;
//                itemDef.femaleEquip1 = 11118;
//                break;
//
//
//            case 19060:
//                itemDef.modelZoom = 1000;
//                itemDef.rotationX = 1532;
//                itemDef.rotationY = 532;
//                itemDef.modelID = 99270;
//                itemDef.maleEquip1 = 82948;
//                itemDef.femaleEquip1 = 82948;
//                break;
//
//            case 18960:
//                itemDef.modelZoom = 1888;
//                itemDef.rotationX = 1532;
//                itemDef.rotationY = 532;
//                itemDef.modelID = 99269;
//                itemDef.maleEquip1 = 11115;
//                itemDef.femaleEquip1 = 11115;
//                break;
//
//            case 19061:
//                itemDef.modelZoom = 2200;
//                itemDef.rotationX = 1532;
//                itemDef.rotationY = 532;
//                itemDef.modelID = 99268;
//                itemDef.maleEquip1 = 82949;
//                itemDef.femaleEquip1 = 82949;
//                break;
//
//
//            case 19022:
//                itemDef.modelZoom = 1034;
//                itemDef.rotationX = 1805;
//                itemDef.rotationY = 1603;
//                break;
//
//            case 4777:
//                itemDef.modelZoom = 2686;
//                itemDef.rotationX = 1545;
//                itemDef.rotationY = 657;
//                itemDef.modelID = 99267;
//                itemDef.maleEquip1 = 91274;
//                itemDef.femaleEquip1 = 91274;
//                break;
//
//            case 19055:
//                itemDef.modelZoom = 1909;
//                itemDef.rotationX = 746;
//                itemDef.rotationY = 416;
//                itemDef.modelID = 99266;
//                itemDef.maleEquip1 = 75500;
//                itemDef.femaleEquip1 = 75500;
//                break;
//
//            case 18965:
//                itemDef.modelZoom = 1521;
//                itemDef.rotationX = 370;
//                itemDef.rotationY = 1879;
//                itemDef.modelID = 99265;
//                itemDef.maleEquip1 = 12316;
//                itemDef.femaleEquip1 = 12316;
//                break;
//
//
//            case 4761:
//    			itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//            	itemDef.name = "King's Helmet";
//                itemDef.modelZoom = 886;
//                itemDef.rotationX = 145;
//                itemDef.rotationY = 100;
//                break;
//
//            case 17914:
//                itemDef.modelZoom = 854;
//                itemDef.rotationX = 2000;
//                itemDef.rotationY = 461;
//                break;
//
//            case 4765:
//                itemDef.modelZoom = 1000;
//                itemDef.rotationX = 235;
//                itemDef.rotationY = 100;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.name = "Kings boots";
//                break;
//
//            case 4764:
//                itemDef.modelZoom = 827;
//                itemDef.rotationX = 1864;
//                itemDef.rotationY = 206;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.name = "Kings gloves";
//                break;
//
//            case 3069:
//                itemDef.modelZoom = 2000;
//                itemDef.rotationX = 791;
//                itemDef.rotationY = 720;
//
//                break;
//
//            case 3928:
//                itemDef.modelZoom = 4083;
//                itemDef.rotationX = 1442;
//                itemDef.rotationY = 423;
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 10857:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.modelID = 97408;
//                itemDef.maleEquip1 = 97408;
//                itemDef.femaleEquip1 = 97408;
//                itemDef.name = "Purplefire wings";
//                break;
//
//            case 18865:
//                itemDef.modelZoom = 1812;
//                itemDef.rotationX = 1483;
//                itemDef.rotationY = 438;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.modelID = 100268;
//                itemDef.maleEquip1 = 100269;
//                itemDef.femaleEquip1 = 100269;
//                itemDef.name = "Lightreapers scythe";
//                break;
//
//            case 18871:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.modelID = 100270;
//                itemDef.maleEquip1 = 100271;
//                itemDef.femaleEquip1 = 100271;
//                itemDef.name = "Lightreapers wings";
//                break;
//
//            case 18872:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.modelID = 100261;
//                itemDef.maleEquip1 = 100261;
//                itemDef.femaleEquip1 = 100261;
//                itemDef.name = "Lightreapers boots";
//                break;
//
//                case 18873:
//                    itemDef.actions = new String[5];
//                    itemDef.actions[1] = "Wear";
//                    itemDef.actions[2] = "@or2@Salvage";
//                    itemDef.actions[4] = "Drop";
//                    itemDef.modelID = 100262;
//                    itemDef.maleEquip1 = 100263;
//                    itemDef.femaleEquip1 = 100263;
//                    itemDef.name = "Lightreapers gloves";
//                    break;
//
//            case 18894:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.name = "Kings dreadful shield";
//                break;
//
//            case 2760:
//                itemDef.modelID = 28388;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 = 28389;
//                changeTexture(id, 57, 73);
//                itemDef.femaleEquip1 = 28389;
//                itemDef.animateInventory = true;
//                itemDef.name = "Exodens Blade";
//                break;
//
//            case 17776:
//    			itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.name = "@cya@Cane spirit shield";
//                break;
//
//            case 5079:
//                itemDef.modelZoom = 1073;
//                itemDef.rotationX = 276;
//                itemDef.rotationY = 100;
//                break;
//
//            case 18985:
//                itemDef.modelZoom = 2533;
//                itemDef.rotationX = 793;
//                itemDef.rotationY = 296;
//                itemDef.modelID = 99263;
//                itemDef.maleEquip1 = 22;
//                itemDef.femaleEquip1 = 22;
//                break;
//
//            case 18950:
//                itemDef.modelZoom = 1182;
//                itemDef.rotationX = 100;
//                itemDef.rotationY = 100;
//                itemDef.modelID = 99262;
//                itemDef.maleEquip1 = 10031;
//                itemDef.femaleEquip1 = 10031;
//                break;
//
//            case 3911:
//                itemDef.modelZoom = 2294;
//                itemDef.rotationX = 1002;
//                itemDef.rotationY = 442;
//                break;
//
//            case 19067:
//                itemDef.modelZoom = 1299;
//                itemDef.rotationX = 749;
//                itemDef.rotationY = 1422;
//                itemDef.modelID = 99261;
//                itemDef.maleEquip1 = 8393;
//                itemDef.femaleEquip1 = 8393;
//                break;
//
//            case 18989:
//                itemDef.modelZoom = 2038;
//                itemDef.rotationX = 734;
//                itemDef.rotationY = 246;
//                itemDef.modelID = 99260;
//                itemDef.maleEquip1 = 2600;
//                itemDef.femaleEquip1 = 2600;
//                break;
//
//            case 19009:
//                itemDef.modelZoom = 1423;
//                itemDef.rotationX = 1924;
//                itemDef.rotationY = 1452;
//                break;
//
//            case 3951:
//                itemDef.modelZoom = 2216;
//                itemDef.rotationX = 100;
//                itemDef.rotationY = 1849;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//    			itemDef.name = "Jinni Battlestaff";
//    			changeTexture(id, 40, 64);
//                break;
//
//            case 5089:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.modelZoom = 1890;
//                itemDef.rotationX = 478;
//                itemDef.rotationY = 324;
//                itemDef.name = "Kings Sword";
//                break;
//
//            case 5081:
//                itemDef.modelZoom = 2000;
//                itemDef.rotationX = 533;
//                itemDef.rotationY = 333;
//                break;
//
//            case 5131:
//                itemDef.modelZoom = 2116;
//                itemDef.rotationX = 1760;
//                itemDef.rotationY = 533;
//                itemDef.modelID = 99258;
//                itemDef.maleEquip1 = 95093;
//                itemDef.femaleEquip1 = 95093;
//                break;
//
//            case 5130:
//                itemDef.modelZoom = 2116;
//                itemDef.rotationX = 1760;
//                itemDef.rotationY = 533;
//                itemDef.modelID = 99257;
//                itemDef.maleEquip1 = 91644;
//                itemDef.femaleEquip1 = 91644;
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                break;
//
//            case 5132:
//                itemDef.name = "Covid Minigun";
//                itemDef.modelZoom = 2116;
//                itemDef.rotationX = 1760;
//                itemDef.rotationY = 533;
//                itemDef.modelID = 99256;
//                itemDef.maleEquip1 = 95100;
//                itemDef.femaleEquip1 = 95100;
//                break;
//
//            case 5134:
//                itemDef.modelZoom = 2116;
//                itemDef.rotationX = 1760;
//                itemDef.rotationY = 533;
//                itemDef.modelID = 99255;
//                itemDef.maleEquip1 = 95090;
//                itemDef.femaleEquip1 = 95090;
//                break;
//
//            case 896:
//                itemDef.name = "Beginners Bow";
//                ItemDef.copyMostDefs(itemDef, 13899);
//                itemDef.modelID = 74807;
//                itemDef.maleEquip1 = 74808;
//                itemDef.femaleEquip1 = 74808;
//                break;
//
//            case 17911:
//                itemDef.name = "Hellfire Helm";
//                break;
//
//            case 17908:
//     			itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//     			itemDef.actions[4] = "Drop";
//                itemDef.name = "Hellfire Platebody";
//                break;
//
//            case 14705:
//                itemDef.name = "Enchanted Dust";
//                break;
//
//            case 17909:
//                itemDef.name = "Hellfire Platelegs";
//                break;
//
//            case 911:
//                itemDef.name = "Vip spirit shield";
//                break;
//
//            case 3986:
//                itemDef.name = "Vip Fire Cape";
//                break;
//
//            case 17151:
//                itemDef.name = "Darkness gloves";
//                break;
//
//            case 15026:
//    			itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.name = "Primordial gloves";
//                break;
//
//            case 15032:
//     			itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//     			itemDef.actions[4] = "Drop";
//                itemDef.name = "Hulk's Gloves";
//                break;
//
//            case 14435:
//                itemDef.modelID = 60854;
//                itemDef.maleEquip1 = 60854;
//                itemDef.name = "Inquisitor Staff";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//
//            case 14436:
//                itemDef.modelID = 60856;
//                itemDef.maleEquip1 = 60856;
//                itemDef.modelZoom = 2000;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.name = "Spear of Annihilation";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 18493:
//                itemDef.modelID = 60858;
//                itemDef.maleEquip1 = 60858;
//                itemDef.modelZoom = 1200;
//                itemDef.rotationX = 0;
//                itemDef.name = "Mihawk sword";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 14437:
//                itemDef.modelID = 60852;
//                itemDef.maleEquip1 = 60852;
//                itemDef.modelZoom = 1100;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -180;
//                itemDef.name = "Khione Helmet";
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                break;
//
//            case 14438:
//                itemDef.modelID = 60850;
//                itemDef.maleEquip1 = 60850;
//                itemDef.modelZoom = 1600;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -70;
//                itemDef.name = "Khione Platebody";
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                break;
//
//            case 14439:
//                itemDef.modelID = 60853;
//                itemDef.maleEquip1 = 60853;
//                itemDef.modelZoom = 1200;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = 6;
//                itemDef.modelOffsetX = 1;
//                itemDef.name = "Khione Platelegs";
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                break;
//
//            case 16438:
//                itemDef.modelID = 60929;
//                itemDef.maleEquip1 = 60929;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = 10;
//                itemDef.name = "L33t's Helmet";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 14563:
//                itemDef.name = "L33t's Gloves";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 6613:
//                itemDef.name = "L33t's Boots";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 16439:
//                itemDef.modelID = 23167;
//                itemDef.maleEquip1 = 23167;
//                itemDef.modelZoom = 1200;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = 10;
//                itemDef.name = "L33t's Platebody";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 16440:
//                itemDef.modelID = 60914;
//                itemDef.maleEquip1 = 60914;
//                itemDef.modelZoom = 1200;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = 1;
//                itemDef.name = "L33t's Platelegs";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 16460:
//                itemDef.modelID = 60922;
//                itemDef.maleEquip1 = 60928;
//                itemDef.modelZoom = 1200;
//                itemDef.rotationX = 0;
//                itemDef.name = "L33t's Shield";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 14440:
//                itemDef.modelID = 60844;
//                itemDef.maleEquip1 = 60844;
//                itemDef.modelZoom = 1100;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -180;
//                itemDef.name = "Sable Helmet";
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                break;
//
//            case 14441:
//                itemDef.modelID = 60842;
//                itemDef.maleEquip1 = 60842;
//                itemDef.modelZoom = 1200;
//                itemDef.rotationX = 0;
//                itemDef.modelZoom = 1600;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -70;
//                itemDef.name = "Sable Platebody";
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                break;
//
//            case 14442:
//                itemDef.modelID = 60847;
//                itemDef.maleEquip1 = 60847;
//                itemDef.modelZoom = 1300;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = 1;
//                itemDef.name = "Sable Platelegs";
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                break;
//
//            case 18024:
//                itemDef.modelID = 23699;
//                itemDef.maleEquip1 = 23699;
//                ItemDef.copyMostDefs(itemDef, 14443);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Summer SebZero Mask";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 18419:
//                itemDef.modelID = 60603;
//                itemDef.maleEquip1 = 60603;
//                ItemDef.copyMostDefs(itemDef, 14443);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Apricity Helmet";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 18420:
//                itemDef.modelID = 60605;
//                itemDef.maleEquip1 = 60605;
//                ItemDef.copyMostDefs(itemDef, 14482);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Apricity Robe top";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 18421:
//                itemDef.modelID = 60604;
//                itemDef.maleEquip1 = 60604;
//                ItemDef.copyMostDefs(itemDef, 14483);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Apricity Robe legs";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 18422:
//                itemDef.modelID = 60599;
//                itemDef.maleEquip1 = 60599;
//                ItemDef.copyMostDefs(itemDef, 14443);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Seraphic Helmet";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 18423:
//                itemDef.modelID = 60601;
//                itemDef.maleEquip1 = 60601;
//                ItemDef.copyMostDefs(itemDef, 14482);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Seraphic Robe top";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 18424:
//                itemDef.modelID = 60600;
//                itemDef.maleEquip1 = 60600;
//                ItemDef.copyMostDefs(itemDef, 14483);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Seraphic Robe legs";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 18425:
//                itemDef.modelID = 97443;
//                itemDef.maleEquip1 = 97437;
//                ItemDef.copyMostDefs(itemDef, 12164);
//                itemDef.modelZoom = 1900;
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Apricity Charm";
//                itemDef.actions = new String[5];
//                break;
//
//            case 18426:
//                itemDef.modelID = 97446;
//                itemDef.maleEquip1 = 97446;
//                ItemDef.copyMostDefs(itemDef, 12164);
//                itemDef.modelZoom = 1900;
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Seraphic Charm";
//                itemDef.actions = new String[5];
//                break;
//
//            case 18427:
//                itemDef.modelID = 97445;
//                itemDef.maleEquip1 = 97445;
//                ItemDef.copyMostDefs(itemDef, 12164);
//                itemDef.modelZoom = 1900;
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Glacial Charm";
//                itemDef.actions = new String[5];
//                break;
//
//            case 14443:
//                itemDef.modelID = 60870;
//                itemDef.maleEquip1 = 60870;
//                itemDef.modelZoom = 1100;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -210;
//                itemDef.name = "Glacial Helmet";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//            case 14482:
//                itemDef.modelID = 60874;
//                itemDef.maleEquip1 = 60874;
//                itemDef.modelZoom = 1600;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -120;
//                itemDef.name = "Glacial Robe top";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 14483:
//                itemDef.modelID = 60873;
//                itemDef.maleEquip1 = 60873;
//                itemDef.modelZoom = 1200;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = 1;
//                itemDef.name = "Glacial Robe legs";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 5054:
//                itemDef.modelID = 75030;
//                itemDef.maleEquip1 = 75031;
//                itemDef.actions = new String[] {"Wear", "Wear", "Wear", null, null};
//                break;
//
//            case 12629:
//                itemDef.name = "Beast Range Gloves";
//                break;
//
//            case 18347:
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.name = "Ranger gloves";
//                break;
//
//            case 19033:
//                itemDef.name = "Glaiven gloves!";
//                break;
//
//            case 11292:
//                itemDef.name = "Gold Range boxing gloves";
//                break;
//
//            case 4794:
//                itemDef.modelID = 44256;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                ItemDef.copyMostDefs(itemDef, 1127);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//                itemDef.maleEquip1 = 44257;
//                itemDef.femaleEquip1 = 44257;
//                itemDef.originalModelColors = new int[] { 40 };
//                itemDef.newModelColor = new int[] { 61 };
//                itemDef.name = "Noxious Platebody";
//                break;
//
//            case 4795:
//                itemDef.modelID = 44258;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                ItemDef.copyMostDefs(itemDef, 1079);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.maleEquip1 = 44259;
//                itemDef.femaleEquip1 = 44259;
//                itemDef.originalModelColors = new int[] { 40 };
//                itemDef.newModelColor = new int[] { 61 };
//                itemDef.name = "Noxious PlateLegs";
//                break;
//
//            case 4796:
//                itemDef.modelID = 44260;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.maleEquip1 = 44261;
//                itemDef.femaleEquip1 = 44261;
//                itemDef.originalModelColors = new int[] { 40 };
//                itemDef.newModelColor = new int[] { 61 };
//                itemDef.name = "Noxious Blade";
//                break;
//
//            case 4797:
//                itemDef.modelID = 44254;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                ItemDef.copyMostDefs(itemDef, 1163);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.maleEquip1 = 44255;
//                itemDef.femaleEquip1 = 44255;
//                itemDef.originalModelColors = new int[] { 40 };
//                itemDef.newModelColor = new int[] { 61 };
//                itemDef.name = "Noxious Facemask";
//                break;
//
//            case 6443:
//                itemDef.modelID = 24023;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 24023;
//                itemDef.femaleEquip1 = 24023;
//                itemDef.name = "Galvek Boots";
//                break;
//
//            case 6444:
//                itemDef.modelID = 24024;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 24025;
//                itemDef.femaleEquip1 = 24025;
//                itemDef.name = "Galvek Gloves";
//                break;
//
//            case 6445:
//                itemDef.modelID = 24026;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 24027;
//                itemDef.femaleEquip1 = 24027;
//                itemDef.name = "Galvek Helmet";
//                break;
//
//            case 6446:
//                itemDef.modelID = 24028;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 24029;
//                itemDef.femaleEquip1 = 24029;
//                itemDef.name = "Galvek Platelegs";
//                break;
//
//            case 6447:
//                itemDef.modelID = 24030;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 24031;
//                itemDef.femaleEquip1 = 24031;
//                itemDef.name = "Galvek platebody";
//                break;
//
//            case 6449:
//                itemDef.modelID = 40010;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 40011;
//                itemDef.femaleEquip1 = 40011;
//                itemDef.name = "SSGJ hair";
//                break;
//
//            case 6450:
//                itemDef.modelID = 40013;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 40012;
//                itemDef.femaleEquip1 = 40012;
//                itemDef.name = "Dreamy Platebody";
//                break;
//
//            case 6451:
//                itemDef.modelID = 40015;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 40014;
//                itemDef.femaleEquip1 = 40014;
//                itemDef.name = "Dreamy Platelegs";
//                break;
//
//            case 6452:
//                itemDef.modelID = 40017;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 40016;
//                itemDef.femaleEquip1 = 40016;
//                itemDef.name = "Dreamy Gloves";
//                break;
//
//            case 6480:
//                itemDef.modelID = 40018;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 40018;
//                itemDef.femaleEquip1 = 40018;
//                itemDef.name = "Dreamy Boots";
//                break;
//
//            case 6481:
//                itemDef.modelID = 40020;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 40019;
//                itemDef.femaleEquip1 = 40019;
//                itemDef.name = "Dreamy Wings";
//                break;
//
//            case 6482:
//                itemDef.modelID = 62658;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 62659;
//                itemDef.femaleEquip1 = 62659;
//                ItemDef.copyMostDefs(itemDef, 9792);
//                itemDef.name = "@whi@Alpha @yel@Donator @whi@Cape";
//                break;
//
//            case 16539:
//                itemDef.modelID = 55229;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip2 = 55228;
//                itemDef.femaleEquip2 = 55228;
//                itemDef.maleEquip1 = 55227;
//                itemDef.femaleEquip1 = 55227;
//                ItemDef.copyMostDefs(itemDef, 9792);
//                itemDef.name = "@mag@Divine cape";
//                break;
//
//            case 7026:
//                itemDef.modelID = 34420;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 34420;
//                itemDef.femaleEquip1 = 34420;
//                itemDef.name = "@re1@Vendetta cape";
//                itemDef.modelZoom = 3000;
//                itemDef.rotationX = 1100;
//                itemDef.rotationY = 0;
//                itemDef.modelOffsetY = 0;
//                itemDef.modelOffset1 = 0;
//                break;
//
//            case 13028:
//                itemDef.modelID = 74025;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 74025;
//                itemDef.femaleEquip1 = 74025;
//                itemDef.name = "@red@Ninja's @bla@Wings";
//                itemDef.modelZoom = 3000;
//                itemDef.rotationX = 1100;
//                itemDef.rotationY = 0;
//                itemDef.modelOffsetY = 0;
//                itemDef.modelOffset1 = 0;
//                break;
//
//            case 13032:
//                itemDef.modelID = 74026;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 74026;
//                itemDef.femaleEquip1 = 74026;
//                itemDef.name = "@red@Ninja's @bla@Offhand";
//                itemDef.modelZoom = 1104;
//                itemDef.rotationX = 357;
//                itemDef.rotationY = 235;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = 9;
//                itemDef.stackable = false;
//                break;
//
//            case 3949:
//                itemDef.name = "@blu@Peacekeeper Slayer helmet";
//                itemDef.modelID = 100168;
//                itemDef.maleEquip1 = 100169;
//                itemDef.femaleEquip1 = 100169;
//                ItemDef.copyMostDefs(itemDef, 15496);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3950:
//                itemDef.name = "@gre@Natures Slayer helmet";
//                itemDef.modelID = 100166;
//                itemDef.maleEquip1 = 100167;
//                itemDef.femaleEquip1 = 100167;
//                ItemDef.copyMostDefs(itemDef, 15496);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3952:
//                itemDef.name = "@yel@Thunderlight Slayer helmet";
//                itemDef.modelID = 100170;
//                itemDef.maleEquip1 = 100171;
//                itemDef.femaleEquip1 = 100171;
//                ItemDef.copyMostDefs(itemDef, 15496);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 15376:
//                itemDef.name = "@red@Warriors Slayer helmet";
//                itemDef.modelID = 100172;
//                itemDef.maleEquip1 = 100173;
//                itemDef.femaleEquip1 = 100173;
//                ItemDef.copyMostDefs(itemDef, 15496);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 15377:
//                itemDef.name = "@cya@Banished Slayer helmet";
//                itemDef.modelID = 100176;
//                itemDef.maleEquip1 = 100177;
//                itemDef.femaleEquip1 = 100177;
//                ItemDef.copyMostDefs(itemDef, 15496);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//    		case 15497:
//                itemDef.name = "@mag@Infused Slayer helmet";
//                itemDef.modelID = 100174;
//                itemDef.maleEquip1 = 100175;
//                itemDef.femaleEquip1 = 100175;
//                ItemDef.copyMostDefs(itemDef, 15496);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				//itemDef.modelZoom = 2200;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//                itemDef.actions = new String[] { null, "Equip", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 6483:
//                itemDef.modelID = 40024;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 40023;
//                itemDef.femaleEquip1 = 40023;
//                itemDef.name = "Daffy Duck Staff";
//                break;
//
//            case 13992:
//                itemDef.name = "Azazels Faceguard";
//                itemDef.modelID = 44275;
//                itemDef.maleEquip1 = 44276;
//                itemDef.femaleEquip1 = 44276;
//                ItemDef.copyMostDefs(itemDef, 1163);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//
//            case 18995:
//                itemDef.name = "Celestial Donator Cape";
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 18999:
//                itemDef.name = "Vetern Cape";
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 19741:
//                itemDef.name = " Luminita Cape";
//                itemDef.modelID = 44302;
//                ItemDef.copyMostDefs(itemDef, 1007);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.maleEquip1 = 44303;
//                itemDef.femaleEquip1 = 44303;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//
//            case 19742:
//                itemDef.name = " Luminita Full Helmet";
//                itemDef.modelID = 44304;
//                itemDef.maleEquip1 = 44305;
//                itemDef.femaleEquip1 = 44305;
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//
//            case 19743:
//                itemDef.name = "Luminita Platelegs";
//                itemDef.modelID = 44306;
//                itemDef.maleEquip1 = 44307;
//                itemDef.femaleEquip1 = 44307;
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//
//            case 19744:
//                itemDef.name = " Luminita Platebody";
//                itemDef.modelID = 44308;
//                itemDef.maleEquip1 = 44309;
//                itemDef.femaleEquip1 = 44309;
//                ItemDef.copyMostDefs(itemDef, 1127);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//
//            case 7159:
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 13239:
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 13235:
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 15019:
//    			ItemDef.copyModel(itemDef, 1639);
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.name = "Infernal ring";
//                break;
//
//            case 15220:
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 15018:
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 15020:
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 16137:
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 744:
//                itemDef.actions = new String[] {null,null, null, null, null};
//                itemDef.animateInventory = true;
//                break;
//
//            case 14666:
//                itemDef.animateInventory = true;
//                break;
//
//            case 19155:
//                itemDef.name = "Detrimental Cape";
//                itemDef.modelID = 23143;
//                itemDef.femaleEquip1 = 23142;
//                itemDef.maleEquip1 = 23142;
//                ItemDef.copyMostDefs(itemDef, 1021);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                changeTexture(id, 70, 62);
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 13995:
//                itemDef.name = "Azazels Staff";
//                itemDef.modelID = 44279;
//                itemDef.maleEquip1 = 44280;
//                itemDef.femaleEquip1 = 44280;
//                ItemDef.copyMostDefs(itemDef, 4153);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.stackable = false;
//                break;
//
//            case 14447:
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.name = "Azazels Gauntlents";
//                break;
//
//            case 7774:
//                itemDef.name = "@yel@Raid Token";
//                break;
//
//            case 7775:
//                itemDef.name = "Raid Token";
//                break;
//
//            case 6640:
//                itemDef.name = "@yel@Cash Crystal";
//                break;
//
//            case 14448:
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.name = "Azazels Boots";
//                break;
//
//            case 13993:
//                itemDef.name = "Azazels Robe bottoms";
//                itemDef.modelID = 44277;
//                itemDef.maleEquip1 = 44278;
//                itemDef.femaleEquip1 = 44278;
//                ItemDef.copyMostDefs(itemDef, 1079);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//
//            case 13994:
//                itemDef.name = "Azazels Robe top";
//                itemDef.modelID = 44273;
//                itemDef.maleEquip1 = 44274;
//                itemDef.femaleEquip1 = 44274;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                ItemDef.copyMostDefs(itemDef, 1127);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.stackable = false;
//                break;
//
//            case 13991:
//                itemDef.name = "Azazels Cape";
//                itemDef.modelID = 44266;
//                itemDef.maleEquip1 = 44267;
//                itemDef.femaleEquip1 = 44267;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//
//            case 4741:
//                itemDef.modelID = 44201;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 44202;
//                itemDef.femaleEquip1 = 44202;
//                itemDef.name = "Emeralds staff";
//                break;
//
//            case 17379:
//                itemDef.modelID = 60869;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 60869;
//                itemDef.femaleEquip1 = 60869;
//                itemDef.name = "Caldeira Crossbow";
//                break;
//            case 17380:
//                itemDef.modelID = 60866;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 60866;
//                itemDef.femaleEquip1 = 60866;
//                itemDef.name = "Blight Bound Crossbow";
//                break;
//
//            case 8817:
//                itemDef.modelID = 60825;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 60825;
//                itemDef.femaleEquip1 = 60825;
//                itemDef.name = "Lorien's staff";
//                break;
//
//            case 17845:
//                itemDef.modelID = 48365;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 48366;
//                itemDef.femaleEquip1 = 48366;
//                itemDef.name = "Martys Wand";
//                break;
//
//            case 16495:
//                itemDef.modelID = 60932;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 60932;
//                itemDef.femaleEquip1 = 60932;
//                itemDef.name = "Playerones Crossbow";
//                break;
//
//            case 7047:
//                ItemDef.copyMostDefs(itemDef, 18744);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.modelID = 48826;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 48827;
//                itemDef.femaleEquip1 = 48827;
//                itemDef.modelZoom = 1800;
//                itemDef.name = "@whi@Easter bunny mask";
//                break;
//
//            case 6942:
//                ItemDef.copyMostDefs(itemDef, 18744);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.modelID = 48831;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 48832;
//                itemDef.femaleEquip1 = 48832;
//                itemDef.modelZoom = 1800;
//                itemDef.name = "@bla@Corrupt bunny mask";
//                break;
//
//
//            case 7028:
//                itemDef.modelZoom = -530;
//				itemDef.rotationX = 217;
//				itemDef.rotationY = 530;
//                itemDef.modelID = 48817;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 48816;
//                itemDef.femaleEquip1 = 48816;
//                itemDef.name = "@mag@Skotizos Amulet";
//                break;
//
//            case 7027:
//                ItemDef.copyMostDefs(itemDef, 10366);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = -2;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.modelID = 48813;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 48815;
//                itemDef.femaleEquip1 = 48815;
//                itemDef.name = "@red@Scarlett's @bla@necklace";
//                break;
//
//            case 10506:
//                itemDef.name = "Khione Shards";
//                break;
//
//            case 17846:
//                itemDef.modelID = 91084;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelZoom = 600;
//                itemDef.maleEquip1 = 91085;
//                itemDef.femaleEquip1 = 91085;
//    			itemDef.originalModelColors = new int[] { 60 };
//    			itemDef.newModelColor = new int[] { 64 };
//                itemDef.name = "Martys Book";
//                break;
//
//            case 16458:
//                itemDef.modelID = 60930;
//                itemDef.maleEquip1 = 60930;
//                itemDef.femaleEquip1 = 60930;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelZoom = 600;
//                itemDef.name = "Monkeys Offhand";
//                break;
//
//            case 14554:
//                itemDef.modelID = 60893;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelZoom = 600;
//                itemDef.maleEquip1 = 60890;
//                itemDef.femaleEquip1 = 60890;
//    			itemDef.originalModelColors = new int[] { 60 };
//    			itemDef.newModelColor = new int[] { 58 };
//                itemDef.name = "Loriens Book";
//                break;
//
//            case 5250:
//                itemDef.modelID = 65279;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 65278;
//                itemDef.femaleEquip1 = 65278;
//                itemDef.name = "@gre@Catastrophic @bla@staff";
//                break;
//
//            case 5251:
//                itemDef.modelID = 65275;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 65274;
//                itemDef.femaleEquip1 = 65274;
//                itemDef.name = "@dev@Developer Katana";
//                break;
//
//            case 6498:
//                itemDef.modelID = 48380;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 48380;
//                itemDef.femaleEquip1 = 48380;
//                itemDef.name = "@or2@A Regular Fishing Rod";
//                break;
//
//            case 6320:
//                itemDef.name = "Blade of Mercy";
//                itemDef.modelID = 24021;
//                itemDef.maleEquip1 = 24022;
//                itemDef.femaleEquip1 = 24022;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                break;
//
//            case 559:
//                System.out.println("ITEM DEF MODEL ID: " + itemDef.modelID);
//                break;
//
//            case 3910:
//            case 3909:
//                break;
//
//            case 3960:
//    			itemDef.name = "Godzilla Helmet";
//    			changeTexture(id, 60, 58);
//                itemDef.modelZoom = 877;
//                itemDef.rotationX = 100;
//                itemDef.rotationY = 100;
//    			itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//
//            case 3908:
//                itemDef.modelZoom = 877;
//                itemDef.rotationX = 100;
//                itemDef.rotationY = 100;
//                break;
//
//            case 4779:
//                recolorItem(itemDef, 4777, new int[] { 36799 }, new int[] { 729 });
//                itemDef.name = "Red Darklord Cape";
//                break;
//
//            case 15566:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 61448;
//                itemDef.modelZoom = 1700;
//                itemDef.rotationY = 750;
//                itemDef.rotationX = 180;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 =  61448;
//                itemDef.femaleEquip1 = 61448;
//                itemDef.maleEquip2 = 61450;
//                itemDef.femaleEquip2 = 61450;
//                itemDef.name = "@red@Owner Cape";
//                break;
//
//            case 3267:
//                itemDef.modelID = 23478;
//                itemDef.maleEquip1 = 23478;
//                itemDef.femaleEquip1 = 23478;
//                itemDef.name = "Opulant Cape";
//                ItemDef.copyMostDefs(itemDef, 9792);
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                break;
//
//            case 18393:
//                itemDef.modelID = 68825;
//                itemDef.maleEquip1 = 68825;
//                itemDef.femaleEquip1 = 68825;
//                itemDef.name = "Ring of Torture";
//                itemDef.actions[1] = "Wield";
//                itemDef.modelZoom = 500;
//                itemDef.rotationY = 100;
//                break;
//
//            case 18394:
//                itemDef.modelID = 75084;
//                itemDef.maleEquip1 = 75084;
//                itemDef.femaleEquip1 = 75084;
//                itemDef.name = "Leafy Wings";
//                itemDef.actions[1] = "Wield";
//                itemDef.modelZoom = 2000;
//                break;
//
//            case 18395:
//                itemDef.modelID = 83234;
//                itemDef.maleEquip1 = 83233;
//                itemDef.femaleEquip1 = 83233;
//                itemDef.actions[1] = "Wield";
//                itemDef.modelZoom = 2000;
//                itemDef.name = "Immortal Blade";
//                break;
//
//            case 2543:
//                itemDef.modelID = 23480;
//                itemDef.maleEquip1 = 23480;
//                itemDef.femaleEquip1 = 23480;
//                itemDef.actions[1] = "Wield";
//                itemDef.name = "Emeralds Tri-blade";
//                itemDef.rotationY = 200;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                break;
//
//            case 1667:
//                itemDef.modelID = 23483;
//                itemDef.maleEquip1 = 23482;
//                itemDef.femaleEquip1 = 23482;
//                itemDef.actions[1] = "Wield";
//                itemDef.name = "green new blade";
//                break;
//
//            case 1666:
//                itemDef.modelID = 23485;
//                itemDef.maleEquip1 = 23484;
//                itemDef.femaleEquip1 = 23484;
//                itemDef.actions[1] = "Wield";
//                itemDef.name = "Lollipop";
//                break;
//
//
//            case 4781:
//                recolorItem(itemDef, 3821, new int[] {63015, 64166, 682, 801}, new int[] {22054, 22054, 22054, 22054});
//                itemDef.name = "Hulk's Justiciar Body";
//                break;
//
//            case 4782:
//                recolorItem(itemDef, 3822, new int[] {64172, 64020, 534, 64038}, new int[] {22054, 22054, 22054, 22054});
//                itemDef.name = "Hulk's Justiciar Legs";
//                break;
//
//            case 20240:
//                itemDef.stackable = false;
//                recolorItem(itemDef, 3820, new int[] {64160, 64046, 64169}, new int[] {22054, 22054, 22054});
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.name = "Hulk's Justiciar Helm";
//                break;
//
//            case 4785:
//    			itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//            case 18387:
//                recolorItem(itemDef, 3820, new int[] {64160, 64046, 64169}, new int[] {66034, 66034, 66034});
//                itemDef.name = "Vapor Helm";
//                break;
//
//            case 899:
//                itemDef.modelID = 23180;
//                itemDef.name = "Saradomin Helmet";
//                itemDef.description = "Man this shet looks gud";
//                itemDef.maleEquip1 = 23181;
//                itemDef.femaleEquip1 = 23181;
//                itemDef.actions = new String[5];
//                itemDef.modelZoom = 1300;
//                itemDef.rotationY = 520;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "<col=C3C0B2>Dissolve Into Orbs Into Orbs";
//                itemDef.actions[4] = "Drop";
//
//                break;
//
//
//            case 902:
//                itemDef.modelID = 23345;
//                itemDef.name = "Archers Helmet";
//                itemDef.description = "Man this shet looks gud";
//                itemDef.maleEquip1 = 23346;
//                itemDef.femaleEquip1 = 23346;
//                itemDef.actions = new String[5];
//                itemDef.modelZoom = 1300;
//                itemDef.rotationY = 520;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//
//                break;
//
//            case 903:
//                itemDef.modelID = 23347;
//                itemDef.name = "Archers Platebody";
//                itemDef.description = "Man this shet looks gud";
//                itemDef.maleEquip1 = 23348;
//                itemDef.femaleEquip1 = 23348;
//                itemDef.actions = new String[5];
//                itemDef.modelZoom = 1300;
//                itemDef.rotationY = 520;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//
//                break;
//
//            case 919:
//                itemDef.modelID = 61221;
//                itemDef.name = "@gre@Green Arsenic Gloves";
//                itemDef.description = "Man this shet looks gud";
//                itemDef.maleEquip1 = 61220;
//                itemDef.femaleEquip1 = 61220;
//                itemDef.actions = new String[5];
//                itemDef.modelZoom = 1300;
//                itemDef.rotationY = 520;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.actions[1] = "Wear";
//
//                itemDef.actions[4] = "Drop";
//break;
//
//            case 910:
//                itemDef.modelID = 23360;
//                itemDef.name = "Virtual Gloves";
//                itemDef.description = "Man this shet looks gud";
//                itemDef.maleEquip1 = 23361;
//                itemDef.femaleEquip1 = 23361;
//                itemDef.actions = new String[5];
//                itemDef.modelZoom = 1300;
//                itemDef.rotationY = 520;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.actions[1] = "Wear";
//
//                itemDef.actions[4] = "Drop";
//
//                break;
//
//            case 905:
//                itemDef.modelID = 23351;
//                itemDef.name = "Archers Wings";
//                itemDef.description = "Man this shet looks gud";
//                itemDef.maleEquip1 = 23352;
//                itemDef.femaleEquip1 = 23352;
//                itemDef.actions = new String[5];
//                itemDef.modelZoom = 1300;
//                itemDef.rotationY = 520;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//
//                break;
//
//            case 904:
//                itemDef.modelID = 23349;
//                itemDef.name = "Archers Platelegs";
//                itemDef.description = "Man this shet looks gud";
//                itemDef.maleEquip1 = 23350;
//                itemDef.femaleEquip1 = 23350;
//                itemDef.actions = new String[5];
//                itemDef.modelZoom = 1300;
//                itemDef.rotationY = 520;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//
//                break;
//
//            case 900:
//                itemDef.modelID = 23182;
//                itemDef.name = "Saradomin Platebody";
//                itemDef.description = "Man this shet looks gud";
//                itemDef.maleEquip1 = 23183;
//                itemDef.femaleEquip1 = 23183;
//                itemDef.actions = new String[5];
//                itemDef.modelZoom = 1300;
//                itemDef.rotationY = 520;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.actions[1] = "Wear";
//
//                itemDef.actions[4] = "Drop";
//
//                break;
//
//
//            case 901:
//                itemDef.modelID = 23184;
//                itemDef.name = "Saradomin Platelegs";
//                itemDef.description = "Man this shet looks gud";
//                itemDef.maleEquip1 = 23185;
//                itemDef.femaleEquip1 = 22185;
//                itemDef.actions = new String[5];
//                itemDef.modelZoom = 1300;
//                itemDef.rotationY = 520;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.actions[1] = "Wear";
//
//                itemDef.actions[4] = "Drop";
//
//                break;
//
//            case 18390:
//                recolorItem(itemDef, 3657, new int[] {70830, 70830, 70830}, new int[] {22114, 22114, 22114});
//                itemDef.name = "WTF Boots";
//                break;
//
//            case 18388:
//                recolorItem(itemDef, 3822, new int[] {64172, 64020, 534, 64038}, new int[] {66034, 66034, 66034, 66034});
//                itemDef.name = "Vapor Legs";
//                break;
//
//            case 18389:
//                recolorItem(itemDef, 3821, new int[] {64172, 64020, 534, 64038}, new int[] {66034, 66034, 66034, 66034});
//                itemDef.name = "Vapor Body";
//                break;
//
//            case 4784:
//                recolorItem(itemDef, 4777, new int[] {36799}, new int[] {22054});
//                itemDef.name = "Fate's Darklord Cape";
//                break;
//
//            case 4780:
//                recolorItem(itemDef, 19886, new int[] { 7254, 7278, 7258, 7250, 7233, 7454, 7248, 7218, 7243, 7223 },
//                        new int[] { 22054, 22054, 22054, 22054, 22054, 22054, 22054, 22054, 22054, 22054 });
//                itemDef.name = "Fate's Collector Necklace";
//                break;
//
//            case 5174:
//                ItemDef.copyModel(itemDef, 3757);
//                itemDef.name = "Hellfire Blade";
//                itemDef.animateInventory = true;
//                break;
//
//            case 16498:
//                ItemDef.copyModel(itemDef, 12852);
//                itemDef.name = "@gre@Custom @mag@Pet @gre@Token";
//                itemDef.animateInventory = true;
//                break;
//
//            case 16543:
//                ItemDef.copyModel(itemDef, 6666);
//                itemDef.name = "@red@Blood Summer flippers";
//                itemDef.animateInventory = true;
//                break;
//
//            case 6666:
//                itemDef.name = "Summertime flippers";
//                itemDef.animateInventory = true;
//                break;
//
//            case 16499:
//                ItemDef.copyModel(itemDef, 12852);
//                itemDef.name = "@gre@Custom @blu@Cape @blu@Token";
//                itemDef.animateInventory = true;
//                break;
//
//            case 16500:
//                ItemDef.copyModel(itemDef, 12852);
//                itemDef.name = "@gre@Custom @red@Weapon @gre@Token";
//                itemDef.animateInventory = true;
//                break;
//
//            case 16501:
//                ItemDef.copyModel(itemDef, 12852);
//                itemDef.name = "@red@Custom @bla@set @red@Token";
//                itemDef.animateInventory = true;
//                break;
//
//            case 16496:
//                ItemDef.copyModel(itemDef, 15682);
//                itemDef.name = "@red@Blood Set Crate";
//                itemDef.animateInventory = true;
//    			ItemDef itemdef4 = ItemDef.forID(15682);
//    			itemDef.modelOffset1 = itemdef4.modelOffset1;
//    			itemDef.modelOffsetX = itemdef4.modelOffsetX;
//    			itemDef.modelOffsetY = itemdef4.modelOffsetY;
//    			itemDef.modelZoom = itemdef4.modelZoom;
//    			itemDef.rotationX = itemdef4.rotationX;
//    			itemDef.rotationY = itemdef4.rotationY;
//                itemDef.actions = new String[5];
//                itemDef.actions[0] = "@bla@Open";
//                break;
//
//            case 5175:
//                ItemDef.copyModel(itemDef, 13902);
//                itemDef.name = "@mag@Celestial hammer";
//                itemDef.animateInventory = true;
//                break;
//
//
//            case 5176:
//                ItemDef.copyModel(itemDef, 13887);
//                itemDef.name = "Onyx Vesta Chainbody";
//                itemDef.animateInventory = true;
//                break;
//
//            case 5177:
//                ItemDef.copyModel(itemDef, 13893);
//                itemDef.name = "Onyx Vesta Plateskirt";
//                itemDef.animateInventory = true;
//                break;
//
//            case 5178:
//                ItemDef.copyModel(itemDef, 3758);
//                itemDef.name = "Hellfire Shield";
//                itemDef.animateInventory = true;
//                break;
//
//            case 5180:
//                ItemDef.copyModel(itemDef, 19706);
//                itemDef.name = "Body of idk what";
//                itemDef.animateInventory = true;
//                break;
//
//            case 5181:
//                ItemDef.copyModel(itemDef, 19707);
//                itemDef.name = "Legs of idk what";
//                itemDef.animateInventory = true;
//                break;
//
//            case 5182:
//                ItemDef.copyModel(itemDef, 19708);
//                itemDef.name = "Helm of idk what";
//                itemDef.animateInventory = true;
//                break;
//
//
//            case 3958:
//                itemDef.name = "Godzilla Platebody";
//                changeTexture(id, 60, 58);
//    			itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//
//            case 5198:
//                ItemDef.copyModel(itemDef, 3958);
//                itemDef.name = "Virulent Platebody";
//                changeTexture(id, 60, 72);
//                break;
//
//            case 5199:
//                ItemDef.copyModel(itemDef, 3959);
//                itemDef.name = "Virulent Platelegs";
//                changeTexture(id, 60, 72);
//                break;
//
//            case 5203:
//                ItemDef.copyModel(itemDef, 19055);
//                itemDef.name = "A cool Sword";
//                itemDef.modelID = 99500;
//                itemDef.maleEquip1 = 99500;
//                itemDef.femaleEquip1 = 99500;
//                break;
//
//            case 5200:
//                ItemDef.copyModel(itemDef, 3960);
//                itemDef.name = "Virulent Helm";
//                changeTexture(id, 60, 72);
//                break;
//
//            case 5201:
//                ItemDef.copyModel(itemDef, 3943);
//                itemDef.name = "Bluefire VIP Necklace";
//                changeTexture(id, 58, 62);
//                break;
//
//            /**
//             * case 19706: case 19707: case 19708:
//             */
//            case 3941:
//                itemDef.modelID = 80527;
//                itemDef.name = "Blazed Scimitar";
//                itemDef.description = "might be hot!";
//                itemDef.stackable = false;
//                itemDef.maleEquip1 = 80528;
//                itemDef.femaleEquip1 = 80528;
//                ItemDef.copyMostDefs(itemDef, 13899);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			//itemDef.modelZoom = 2200;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 19119:
//                ItemDef.copyModel(itemDef, 3941);
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.name = "Justin's Scythe";
//                changeTexture(id, 40, 68);
//                break;
//
//            case 18683:
//                ItemDef.copyModel(itemDef, 3941);
//                itemDef.name = "Olm Scythe";
//                itemDef.actions[2] = "@or2@Salvage";
//                changeTexture(id, 40, 70);
//                break;
//
//            case 18748:
//                ItemDef.copyModel(itemDef, 3092);
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.name = "Demonic Cape";
//                changeTexture(id, 40, 70);
//                itemDef.animateInventory = true;
//                break;
//
//            case 19958:
//                ItemDef.copyModel(itemDef, 3092);
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.name = "Abomination cape";
//                changeTexture(id, 57, 84);
//                itemDef.animateInventory = true;
//                itemDef.stackable = false;
//                break;
//
//            case 3914:
//                ItemDef.copyModel(itemDef, 12708);
//            	break;
//            case 20451:
//                ItemDef.copyModel(itemDef, 14639);
//                itemDef.name = "@gre@Giant Soul";
//                itemDef.actions[0] = "@whi@Consume";
//                itemDef.animateInventory = true;
//                break;
//
//            case 20450:
//                ItemDef.copyModel(itemDef, 14639);
//                itemDef.name = "@yel@Hades Soul";
//                itemDef.actions[0] = "@whi@Consume";
//                itemDef.animateInventory = true;
//                break;
//
//            case 20565:
//                ItemDef.copyModel(itemDef, 14639);
//                itemDef.name = "@cya@Jinni Soul";
//                itemDef.actions[0] = "@whi@Consume";
//                itemDef.animateInventory = true;
//                break;
//            case 20566:
//                ItemDef.copyModel(itemDef, 14639);
//                itemDef.name = "@bla@Godzilla Soul";
//                itemDef.actions[0] = "@whi@Consume";
//                itemDef.animateInventory = true;
//                break;
//            case 20567:
//                ItemDef.copyModel(itemDef, 14639);
//                itemDef.name = "@yel@Hades Soul";
//                itemDef.actions[0] = "@whi@Consume";
//                itemDef.animateInventory = true;
//                break;
//            case 20568:
//                ItemDef.copyModel(itemDef, 14639);
//                itemDef.name = "@Osh@King Kong Soul";
//                itemDef.actions[0] = "@whi@Consume";
//                itemDef.animateInventory = true;
//                break;
//            case 20569:
//                ItemDef.copyModel(itemDef, 14639);
//                itemDef.name = "@gre@Hulk Soul";
//                itemDef.actions[0] = "@whi@Consume";
//                itemDef.animateInventory = true;
//                break;
//            case 20570:
//                ItemDef.copyModel(itemDef, 14639);
//                itemDef.name = "@mag@Purple Wyrm Soul";
//                itemDef.actions[0] = "@whi@Consume";
//                itemDef.animateInventory = true;
//                break;
//            case 16456:
//                itemDef.name = "@red@Grand Mystery chest";
//                itemDef.modelID = 10513;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 16711);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.modelZoom = 900;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions[0] = "Open";
//                itemDef.actions[1] = null;
//                itemDef.actions[2] = null;
//                itemDef.actions[3] = null;
//                break;
//
//
//            case 3989:
//                ItemDef.copyModel(itemDef, 3912);
//                itemDef.name = "Random DR Item Box";
//                changeTexture(id, 63, 73);
//                itemDef.animateInventory = true;
//                break;
//
//            case 14019:
//                itemDef.name = "Max Cape";
//                ItemDef.copyMostDefs(itemDef, 1021);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//                break;
//
//            case 3444:
//                itemDef.name = "Toxic Wings(30DR)";
//                itemDef.animateInventory = true;
//                break;
//            case 6821:
//                itemDef.name = "Iron Orb";
//                itemDef.animateInventory = true;
//                break;
//            case 1481:
//                itemDef.name = "Blood Orb";
//                itemDef.animateInventory = true;
//                break;
//
//            case 3438:
//                ItemDef.copyModel(itemDef, 1513);
//                itemDef.name = "Raid's Log";
//                itemDef.animateInventory = true;
//                break;
//
//            case 17630:
//                ItemDef.copyModel(itemDef, 440);
//                itemDef.name = "Raid's Ore";
//                itemDef.animateInventory = true;
//                break;
//
//            case 6200:
//                itemDef.name = "Raid's Fish";
//                itemDef.animateInventory = true;
//                break;
//
//            case 14667:
//                itemDef.name = "Corona fragment";
//                itemDef.animateInventory = true;
//                break;
//
//            case 13591:
//                itemDef.name = "Raid's Key";
//                itemDef.animateInventory = true;
//                break;
//            case 5258:
//                itemDef.modelID = 44465;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 44466;
//                itemDef.femaleEquip1 = 44466;
//                itemDef.actions[2] = "Dissolve";
//                itemDef.name = "Grinch Mask";
//                break;
//            case 5259:
//                itemDef.modelID = 44467;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "Dissolve";
//                itemDef.maleEquip1 = 44468;
//                itemDef.femaleEquip1 = 44468;
//                itemDef.name = "Grinch Top";
//                break;
//            case 5260:
//                itemDef.modelID = 44469;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "Dissolve";
//                itemDef.maleEquip1 = 44470;
//                itemDef.femaleEquip1 = 44470;
//                itemDef.name = "Grinch Legs";
//                break;
//            case 5261:
//                itemDef.modelID = 44471;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "Dissolve";
//                itemDef.maleEquip1 = 44472;
//                itemDef.femaleEquip1 = 44472;
//                itemDef.name = "Grinch Gloves";
//                break;
//            case 5262:
//                itemDef.modelID = 44473;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 44473;
//                itemDef.femaleEquip1 = 44473;
//                itemDef.actions[2] = "Dissolve";
//                itemDef.name = "Grinch Boots";
//                break;
//            case 5263:
//                itemDef.name = "@red@Owner Sword";
//                ItemDef itemdef5 = ItemDef.forID(7158);
//                itemDef.modelID = 44474;
//                itemDef.femaleEquip1 = 44475;
//                itemDef.maleEquip1 = 44475;
//                itemDef.modelOffset1 = itemdef5.modelOffset1;
//                itemDef.modelOffsetX = itemdef5.modelOffsetX;
//                itemDef.modelOffsetY = itemdef5.modelOffsetY;
//                itemDef.modelZoom = itemdef5.modelZoom;
//                itemDef.rotationX = itemdef5.rotationX;
//                itemDef.rotationY = itemdef5.rotationY;
//                itemDef.actions = new String[5];
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
//                break;
//
//            case 5267:
//                itemDef.name = "@red@Q's Owner Sword";
//                ItemDef itemdef50 = ItemDef.forID(7158);
//                itemDef.modelID = 44474;
//                itemDef.femaleEquip1 = 44475;
//                itemDef.maleEquip1 = 44475;
//                itemDef.modelOffset1 = itemdef50.modelOffset1;
//                itemDef.modelOffsetX = itemdef50.modelOffsetX;
//                itemDef.modelOffsetY = itemdef50.modelOffsetY;
//                itemDef.modelZoom = itemdef50.modelZoom;
//                itemDef.rotationX = itemdef50.rotationX;
//                itemDef.rotationY = itemdef50.rotationY;
//                itemDef.actions = new String[5];
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
//                break;
//
//
//            case 5271:
//                itemDef.name = "Frozen Battlesword Tier II";
//                ItemDef itemdef15 = ItemDef.forID(7158);
//                itemDef.modelID = 44474;
//                itemDef.femaleEquip1 = 44475;
//                itemDef.maleEquip1 = 44475;
//                itemDef.modelOffset1 = itemdef15.modelOffset1;
//                itemDef.modelOffsetX = itemdef15.modelOffsetX;
//                itemDef.modelOffsetY = itemdef15.modelOffsetY;
//                itemDef.modelZoom = itemdef15.modelZoom;
//                itemDef.rotationX = itemdef15.rotationX;
//                itemDef.rotationY = itemdef15.rotationY;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "Dissolve";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 5272:
//                itemDef.name = "Frozen Battlesword Tier III";
//                ItemDef itemdef16 = ItemDef.forID(7158);
//                itemDef.modelID = 44474;
//                itemDef.femaleEquip1 = 44475;
//                itemDef.maleEquip1 = 44475;
//                itemDef.modelOffset1 = itemdef16.modelOffset1;
//                itemDef.modelOffsetX = itemdef16.modelOffsetX;
//                itemDef.modelOffsetY = itemdef16.modelOffsetY;
//                itemDef.modelZoom = itemdef16.modelZoom;
//                itemDef.rotationX = itemdef16.rotationX;
//                itemDef.rotationY = itemdef16.rotationY;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "Dissolve";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 5264:
//                itemDef.modelID = 44485;
//                itemDef.modelZoom = 2000;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "Dissolve";
//                itemDef.maleEquip1 = 44486;
//                itemDef.femaleEquip1 = 44486;
//                itemDef.name = "Christmas Scythe";
//                break;
//
//
//            case 16470:
//                itemDef.modelID = 44485;
//                itemDef.modelZoom = 2000;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 44486;
//                itemDef.femaleEquip1 = 44486;
//                itemDef.name = "Fe's Scythe";
//                break;
//
//            case 16483:
//                itemDef.modelID = 60998;
//                itemDef.modelZoom = 2000;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 60998;
//                itemDef.femaleEquip1 = 60998;
//                itemDef.name = "Fe's Aura";
//                break;
//
//            case 16472:
//                itemDef.modelID = 61001;
//                itemDef.modelZoom = 2000;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 61001;
//                itemDef.femaleEquip1 = 61001;
//                itemDef.name = "Event Manager Cape";
//                break;
//
//
//            case 16481:
//                itemDef.modelID = 61003;
//                itemDef.modelZoom = 2000;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 61003;
//                itemDef.femaleEquip1 = 61003;
//                itemDef.name = "Event Manager Aura";
//                break;
//            case 16434:
//                itemDef.modelID = 44489;
//                itemDef.modelZoom = 2000;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 44489;
//                itemDef.femaleEquip1 = 44489;
//                itemDef.name = "Slendermans Aura";
//                break;
//
//
//
//            case 19156:
//                itemDef.modelID = 44283;
//                itemDef.name = "Red Sharingan Aura";
//                itemDef.description = "Red Sharingan Aura";
//                itemDef.modelZoom = 1600;
//                itemDef.rotationY = 500;
//                itemDef.rotationX = 0;
//                itemDef.modelOffset1 = -1;
//                itemDef.modelOffsetY = -1;
//                itemDef.maleEquip1 = 44283;
//                itemDef.femaleEquip1 = 44283;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 11132:
//                itemDef.modelID = 44480;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 44480;
//                itemDef.femaleEquip1 = 44480;
//                itemDef.modelZoom = 1200;
//                itemDef.name = "Naruto legs";
//                break;
//            case 11162:
//                itemDef.modelID = 44481;
//                itemDef.modelZoom = 1000;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = 160;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 44481;
//                itemDef.femaleEquip1 = 44481;
//                itemDef.name = "Naruto top";
//                break;
//            case 17835:
//                itemDef.modelID = 65395;
//                itemDef.femaleEquip1 = 65395;
//                itemDef.maleEquip1 = 65395;
//                itemDef.rotationX = 120;
//                itemDef.name = "Naruto Helmet";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                break;
//            case 11163:
//                itemDef.modelID = 44482;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Open";
//                itemDef.modelZoom = 2000;
//                itemDef.name = "Random box";
//                break;
//            case 11206:
//                itemDef.modelID = 44483;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Open";
//                itemDef.modelZoom = 2000;
//                itemDef.name = "Investor Chest";
//                break;
//            case 11207:
//                itemDef.modelID = 44484;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Open";
//                itemDef.modelZoom = 1250;
//                itemDef.name = "Mystery Chest";
//                break;
//            case 11209:
//                itemDef.modelID = 44485;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Open";
//                itemDef.modelZoom = 1250;
//                itemDef.name = "Imbued Chest";
//                break;
//            case 4153:
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 10905:
//                itemDef.modelID = 44281;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 44282;
//                ItemDef.copyMostDefs(itemDef, 4153);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.femaleEquip1 = 44282;
//                itemDef.name = "Detrimental Minigun";
//                break;
//
//            case 15654:
//                ItemDef.copyModel(itemDef, 10689);
//                itemDef.name = "Galaxy boots";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.animateInventory = true;
//                break;
//
//            case 3087:
//                itemDef.name = "Skotizos helm";
//                itemDef.animateInventory = true;
//                break;
//            case 3086:
//                itemDef.name = "Skotizos platebody";
//                itemDef.animateInventory = true;
//                break;
//            case 3085:
//                itemDef.name = "Skotizos platelegs";
//                itemDef.animateInventory = true;
//                break;
//            case 3088:
//                itemDef.name = "Skotizos sword";
//                itemDef.animateInventory = true;
//                break;
//
//
//            case 15655:
//                ItemDef.copyModel(itemDef, 18956);
//                itemDef.name = "Galaxy gloves";
//                itemDef.animateInventory = true;
//                break;
//
//
//            case 7118:
//                itemDef.name = "@cya@Test Mystery box";
//                itemDef.modelID = 61290;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 16711);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.modelZoom = 1550;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions[0] = "Open";
//                itemDef.actions[1] = null;
//                itemDef.actions[2] = null;
//                itemDef.actions[3] = null;
//                break;
//
//    		case 20928:
//    			itemDef.name = "@whi@Avatar air bender mask";
//                itemDef.modelID = 100004;
//                itemDef.maleEquip1 = 100004;
//                itemDef.femaleEquip1 = 100004;
//                itemDef.modelZoom = 791;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 545;
//    			//itemDef.modelOffsetY = 0;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[3] = "Dissolve";
//     			itemDef.actions[4] = "Drop";
//    			break;
//
//    		case 20936:
//    			itemDef.name = "@whi@Avatar air bender body";
//                itemDef.modelID = 100005;
//                itemDef.maleEquip1 = 100005;
//                itemDef.femaleEquip1 = 100005;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[3] = "Dissolve";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1296;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 45;
//    			break;
//
//    		case 20937:
//    			itemDef.name = "@whi@Avatar air bender legs";
//                itemDef.modelID = 100006;
//                itemDef.maleEquip1 = 100006;
//                itemDef.femaleEquip1 = 100006;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[3] = "Dissolve";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1087;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 252;
//    			itemDef.modelOffsetY = -26;
//    			break;
//
//    		case 17850:
//    			itemDef.name = "@whi@Vendetta Helmet";
//                itemDef.modelID = 100490;
//                itemDef.maleEquip1 = 100490;
//                itemDef.femaleEquip1 = 100490;
//                itemDef.modelZoom = 791;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 545;
//    			//itemDef.modelOffsetY = 0;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//    			break;
//
//    		case 17847:
//    			itemDef.name = "@whi@Vendetta body";
//                itemDef.modelID = 100478;
//                itemDef.maleEquip1 = 100478;
//                itemDef.femaleEquip1 = 100478;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1296;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 45;
//    			break;
//
//    		case 17848:
//    			itemDef.name = "@whi@Vendetta legs";
//                itemDef.modelID = 100479;
//                itemDef.maleEquip1 = 100479;
//                itemDef.femaleEquip1 = 100479;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1087;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 252;
//    			itemDef.modelOffsetY = -26;
//    			break;
//
//
//
//    		case 17851:
//    			itemDef.name = "@whi@Vendetta boots";
//                itemDef.modelID = 100488;
//                itemDef.maleEquip1 = 100488;
//                itemDef.femaleEquip1 = 100488;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 739;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 339;
//    			itemDef.modelOffsetY = 26;
//    			break;
//
//    		case 17852:
//    			itemDef.name = "@whi@Vendetta gloves";
//                itemDef.modelID = 100489;
//                itemDef.maleEquip1 = 100489;
//                itemDef.femaleEquip1 = 100489;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 374;
//                itemDef.rotationX = 496;
//                itemDef.rotationY = 287;
//    			itemDef.modelOffsetY = 0;
//    			break;
//
//       		case 9530:
//    			itemDef.name = "@red@Ninja's @bla@Helmet";
//                itemDef.modelID = 74018;
//                itemDef.maleEquip1 = 74018;
//                itemDef.femaleEquip1 = 74018;
//                itemDef.modelZoom = 791;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 545;
//    			//itemDef.modelOffsetY = 0;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//    			itemDef.stackable = false;
//    			break;
//
//    		case 9531:
//    			itemDef.name = "@red@Ninja's @bla@Body";
//                itemDef.modelID = 74019;
//                itemDef.maleEquip1 = 74019;
//                itemDef.femaleEquip1 = 74019;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1296;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 45;
//    			itemDef.stackable = false;
//    			break;
//
//    		case 9532:
//    			itemDef.name = "@red@Ninja's @bla@Legs";
//                itemDef.modelID = 74020;
//                itemDef.maleEquip1 = 74020;
//                itemDef.femaleEquip1 = 74020;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1087;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 252;
//    			itemDef.modelOffsetY = -26;
//    			itemDef.stackable = false;
//    			break;
//
//
//
//    		case 9533:
//    			itemDef.name = "@red@Ninja's @bla@Boots";
//                itemDef.modelID = 74021;
//                itemDef.maleEquip1 = 74021;
//                itemDef.femaleEquip1 = 74021;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 739;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 339;
//    			itemDef.modelOffsetY = 26;
//    			itemDef.stackable = false;
//    			break;
//
//    		case 9534:
//    			itemDef.name = "@red@Ninja's @bla@Gloves";
//                itemDef.modelID = 74022;
//                itemDef.maleEquip1 = 74022;
//                itemDef.femaleEquip1 = 74022;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 374;
//                itemDef.rotationX = 496;
//                itemDef.rotationY = 287;
//    			itemDef.modelOffsetY = 0;
//    			itemDef.stackable = false;
//    			break;
//
//    		case 12178:
//    			itemDef.name = "@whi@Bye's Helmet";
//                itemDef.modelID = 72045;
//                itemDef.maleEquip1 = 72045;
//                itemDef.femaleEquip1 = 72045;
//                itemDef.modelZoom = 791;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 545;
//    			//itemDef.modelOffsetY = 0;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//    			break;
//
//    		case 12179:
//    			itemDef.name = "@whi@Bye's body";
//                itemDef.modelID = 72046;
//                itemDef.maleEquip1 = 72046;
//                itemDef.femaleEquip1 = 72046;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1296;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 45;
//    			break;
//
//    		case 12180:
//    			itemDef.name = "@whi@Bye's legs";
//                itemDef.modelID = 72047;
//                itemDef.maleEquip1 = 72047;
//                itemDef.femaleEquip1 = 72047;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1087;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 252;
//    			itemDef.modelOffsetY = -26;
//    			break;
//
//
//
//    		case 12181:
//    			itemDef.name = "@whi@Bye's boots";
//                itemDef.modelID = 72048;
//                itemDef.maleEquip1 = 72048;
//                itemDef.femaleEquip1 = 72048;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 739;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 339;
//    			itemDef.modelOffsetY = 26;
//    			break;
//
//    		case 12182:
//    			itemDef.name = "@whi@Bye's gloves";
//                itemDef.modelID = 72049;
//                itemDef.maleEquip1 = 72049;
//                itemDef.femaleEquip1 = 72049;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 374;
//                itemDef.rotationX = 496;
//                itemDef.rotationY = 287;
//    			itemDef.modelOffsetY = 0;
//    			break;
//
//    		case 12185:
//    			itemDef.name = "@red@Ninja's @bla@Scythe";
//                itemDef.modelID = 72050;
//                itemDef.maleEquip1 = 72050;
//                itemDef.femaleEquip1 = 72050;
//                itemDef.actions = new String[5];
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
//                itemDef.modelZoom = 2287;
//                itemDef.rotationX = 784;
//                itemDef.rotationY = 839;
//    			itemDef.modelOffsetY = 12;
//    			break;
//
//
//    		case 13389:
//    			itemDef.name = "@red@Ninja's @bla@Bow";
//                itemDef.modelID = 24465;
//                itemDef.maleEquip1 = 24465;
//                itemDef.femaleEquip1 = 24465;
//                itemDef.actions = new String[5];
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
//                itemDef.modelZoom = 3000;
//                itemDef.rotationX = 357;
//                itemDef.rotationY = 113;
//    			itemDef.modelOffsetY = 40;
//      			itemDef.modelOffset1 = 10;
//    			break;
//
//
//
//    		case 13388:
//    			itemDef.name = "@red@Ninja's @bla@Staff";
//                itemDef.modelID = 24466;
//                itemDef.maleEquip1 = 24466;
//                itemDef.femaleEquip1 = 24466;
//                itemDef.actions = new String[5];
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
//                itemDef.modelZoom = 3000;
//                itemDef.rotationX = 357;
//                itemDef.rotationY = 113;
//    			itemDef.modelOffsetY = 40;
//      			itemDef.modelOffset1 = 10;
//    			break;
//
//    		case 13390:
//    			itemDef.modelID = 97448;
//                ItemDef.copyMostDefs(itemDef, 12164);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.modelZoom = 2000;
//                itemDef.animateInventory = true;
//    			itemDef.name = "@cya@SebZero's Custom Charm";
//    			itemDef.actions = new String[] { null, null, null, null, null };
//    			break;
//
//    		case 13030:
//    			itemDef.modelID = 97448;
//                ItemDef.copyMostDefs(itemDef, 12164);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.modelZoom = 2000;
//                itemDef.animateInventory = true;
//    			itemDef.name = "@red@Ninja's @bla@Lucky charm";
//    			itemDef.actions = new String[] { null, null, null, null, null };
//    			break;
//
//
//    		case 20931:
//    			itemDef.name = "@whi@Avatar air bender boots";
//                itemDef.modelID = 100007;
//                itemDef.maleEquip1 = 100007;
//                itemDef.femaleEquip1 = 100007;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[3] = "Dissolve";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 739;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 339;
//    			itemDef.modelOffsetY = 26;
//    			break;
//
//    		case 20932:
//    			itemDef.name = "@whi@Avatar air bender gloves";
//                itemDef.modelID = 100008;
//                itemDef.maleEquip1 = 100008;
//                itemDef.femaleEquip1 = 100008;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[3] = "Dissolve";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 374;
//                itemDef.rotationX = 496;
//                itemDef.rotationY = 287;
//    			itemDef.modelOffsetY = 0;
//    			break;
//
//
//
//    		case 20933:
//    			itemDef.name = "@whi@Avatar air bender cape";
//                itemDef.modelID = 100010;
//                itemDef.maleEquip1 = 100010;
//                itemDef.femaleEquip1 = 100010;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[3] = "Dissolve";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 3000;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 148;
//    			itemDef.modelOffsetY = 0;
//    			break;
//
//    		case 20934:
//    			itemDef.name = "@whi@Avatar air bender stick";
//                itemDef.modelID = 100009;
//                itemDef.maleEquip1 = 100009;
//                itemDef.femaleEquip1 = 100009;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[3] = "Dissolve";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 2287;
//                itemDef.rotationX = 784;
//                itemDef.rotationY = 839;
//    			itemDef.modelOffsetY = 12;
//    			break;
//    		case 20935:
//    			itemDef.name = "@whi@Avatar air bender Aura";
//                itemDef.modelID = 100011;
//                itemDef.maleEquip1 = 100011;
//                itemDef.femaleEquip1 = 100011;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[3] = "Dissolve";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 3200;
//                itemDef.rotationX = 1661;
//                itemDef.rotationY = 61;
//    			itemDef.modelOffsetY = 0;
//    			break;
//
//    		case 20938:
//    			itemDef.name = "@whi@Inuyasha helmet";
//                itemDef.modelID = 100012;
//                itemDef.maleEquip1 = 100012;
//                itemDef.femaleEquip1 = 100012;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1100;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -180;
//    			break;
//    		case 8568:
//    			itemDef.name = "@re1@Ninetails helmet";
//                itemDef.modelID = 32884;
//                itemDef.maleEquip1 = 32884;
//                itemDef.femaleEquip1 = 32884;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1100;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -180;
//    			break;
//    		case 8569:
//    			itemDef.name = "@re1@Ahri helmet";
//                itemDef.modelID = 32884;
//                itemDef.maleEquip1 = 32884;
//                itemDef.femaleEquip1 = 32884;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1365;
//                itemDef.rotationX = 183;
//                itemDef.rotationY = 339;
//    			itemDef.modelOffsetY = -113;
//      			itemDef.modelOffset1 = 0;
//                itemDef.stackable = false;
//    			break;
//    		case 8570:
//    			itemDef.name = "@whi@Ahri Body";
//                itemDef.modelID = 32885;
//                itemDef.maleEquip1 = 32885;
//                itemDef.femaleEquip1 = 32885;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1348;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 50;
//    			break;
//    		case 17855:
//    			itemDef.name = "@whi@Ahri legs";
//                itemDef.modelID = 32886;
//                itemDef.maleEquip1 = 32886;
//                itemDef.femaleEquip1 = 32886;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1348;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 30;
//    			break;
//    		case 8572:
//    			itemDef.name = "@whi@Ahri boots";
//                itemDef.modelID = 32887;
//                itemDef.maleEquip1 = 32887;
//                itemDef.femaleEquip1 = 32887;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 774;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 0;
//    			break;
//
//    		case 17856:
//    			itemDef.name = "@whi@Ahri gloves";
//                itemDef.modelID = 32888;
//                itemDef.maleEquip1 = 32888;
//                itemDef.femaleEquip1 = 32888;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1035;
//                itemDef.rotationX = 1643;
//                itemDef.rotationY = 78;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 50;
//    			break;
//
//    		case 17746:
//    			itemDef.name = "@whi@Ezreal helmet";
//                itemDef.modelID = 100078;
//                itemDef.maleEquip1 = 100078;
//                itemDef.femaleEquip1 = 100078;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 478;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 165;
//                itemDef.modelOffsetX = 2;
//                itemDef.modelOffsetY = 180;
//    			break;
//    		case 17748:
//    			itemDef.name = "@whi@Ezreal Body";
//                itemDef.modelID = 100079;
//                itemDef.maleEquip1 = 100079;
//                itemDef.femaleEquip1 = 100079;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1348;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 50;
//    			break;
//
//    		case 17749:
//    			itemDef.name = "@whi@Ezreal legs";
//                itemDef.modelID = 100080;
//                itemDef.maleEquip1 = 100080;
//                itemDef.femaleEquip1 = 100080;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1348;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 30;
//    			break;
//
//
//    		case 17751:
//    			itemDef.name = "@whi@Ezreal boots";
//                itemDef.modelID = 100081;
//                itemDef.maleEquip1 = 100081;
//                itemDef.femaleEquip1 = 100081;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 774;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 0;
//    			break;
//
//
//    		case 17756:
//    			itemDef.name = "@whi@Ezreal gloves";
//                itemDef.modelID = 100082;
//                itemDef.maleEquip1 = 100082;
//                itemDef.femaleEquip1 = 100082;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1035;
//                itemDef.rotationX = 1643;
//                itemDef.rotationY = 78;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 50;
//    			break;
//
//
//
//
//    		case 20939:
//    			itemDef.name = "@whi@Inuyasha platebody";
//                itemDef.modelID = 100013;
//                itemDef.maleEquip1 = 100013;
//                itemDef.femaleEquip1 = 100013;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1417;
//                itemDef.rotationX = 26;
//                itemDef.rotationY = 96;
//
//    			itemDef.modelOffsetY = 61;
//    			break;
//
//    		case 20940:
//    			itemDef.name = "@whi@Inuyasha legs";
//                itemDef.modelID = 100014;
//                itemDef.maleEquip1 = 100014;
//                itemDef.femaleEquip1 = 100014;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			//itemDef.modelZoom = 2200;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1417;
//                itemDef.rotationX = 26;
//                itemDef.rotationY = 26;
//    			itemDef.modelOffsetY = 0;
//    			break;
//
//    		case 20941:
//    			itemDef.name = "@whi@Inuyasha boots";
//                itemDef.modelID = 100015;
//                itemDef.maleEquip1 = 100015;
//                itemDef.femaleEquip1 = 100015;
//                itemDef.actions = new String[5];
//                itemDef.modelZoom = 704;
//                itemDef.rotationX = 304;
//                itemDef.rotationY = 26;
//    			itemDef.modelOffsetY = 0;
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//    			break;
//    		case 20942:
//    			itemDef.name = "@whi@Inuyasha gloves";
//                itemDef.modelID = 100016;
//                itemDef.maleEquip1 = 100016;
//                itemDef.femaleEquip1 = 100016;
//                itemDef.modelZoom = 1283;
//                itemDef.rotationX = 1226;
//                itemDef.rotationY = 496;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//    			break;
//
//    		case 20943:
//    			itemDef.name = "@whi@Inuyasha sword";
//                itemDef.modelID = 100017;
//                itemDef.maleEquip1 = 100017;
//                itemDef.femaleEquip1 = 100017;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1000;
//                itemDef.rotationX = 1713;
//                itemDef.rotationY = 217;
//    			break;
//
//    		case 6308:
//    			itemDef.name = "@re1@MysteryMan Helmet";
//                itemDef.modelID = 18599;
//                itemDef.maleEquip1 = 18600;
//                itemDef.femaleEquip1 = 18600;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1200;
//    			break;
//
//    		case 6310:
//    			itemDef.name = "@re1@MysteryMan Chestplate";
//                itemDef.modelID = 18601;
//                itemDef.maleEquip1 = 18601;
//                itemDef.femaleEquip1 = 18601;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1200;
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//    			break;
//
//    		case 6311:
//    			itemDef.name = "@re1@MysteryMan Platelegs";
//                itemDef.modelID = 18602;
//                itemDef.maleEquip1 = 18603;
//                itemDef.femaleEquip1 = 18603;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1200;
//    			break;
//
//    		case 12856:
//    			itemDef.name = "@re1@MysteryMan Gloves";
//                itemDef.modelID = 18604;
//                itemDef.maleEquip1 = 18605;
//                itemDef.femaleEquip1 = 18605;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 800;
//    			break;
//
//    		case 6313:
//    			itemDef.name = "@re1@MysteryMan Boots";
//                itemDef.modelID = 18606;
//                itemDef.maleEquip1 = 18606;
//                itemDef.femaleEquip1 = 18606;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1200;
//    			break;
//
//
//    		case 13024:
//    			itemDef.name = "@whi@Bye's Sword";
//                itemDef.modelID = 74023;
//                itemDef.maleEquip1 = 74023;
//                itemDef.femaleEquip1 = 74023;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1052;
//                itemDef.rotationX = 1157;
//                itemDef.rotationY = 809;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = -43;
//                itemDef.stackable = false;
//    			break;
//
//    		case 13026:
//    			itemDef.name = "@whi@Bye's Offhand";
//                itemDef.modelID = 74024;
//                itemDef.maleEquip1 = 74024;
//                itemDef.femaleEquip1 = 74024;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1104;
//                itemDef.rotationX = 357;
//                itemDef.rotationY = 235;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = 9;
//                itemDef.stackable = false;
//    			break;
//
//
//
//    		case 8040:
//    			itemDef.name = "@cya@SebZero's @bla@scythe";
//                itemDef.modelID = 32319;
//                itemDef.maleEquip1 = 32319;
//                itemDef.femaleEquip1 = 32319;
//                itemDef.actions = new String[5];
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
//                itemDef.modelZoom = 3000;
//                itemDef.rotationX = 374;
//                itemDef.rotationY = 61;
//    			itemDef.modelOffsetY = 43;
//      			itemDef.modelOffset1 = 96;
//    			break;
//
//
//    		case 7016:
//    			itemDef.name = "@cya@SebZero's @bla@Offhand";
//                itemDef.modelID = 12893;
//                itemDef.maleEquip1 = 12893;
//                itemDef.femaleEquip1 = 12893;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1104;
//                itemDef.rotationX = 357;
//                itemDef.rotationY = 235;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = 9;
//                itemDef.stackable = false;
//    			break;
//
//    		case 8041:
//    			itemDef.name = "@cya@SebZero's @bla@bow";
//                itemDef.modelID = 46060;
//                itemDef.maleEquip1 = 46060;
//                itemDef.femaleEquip1 = 46060;
//                itemDef.actions = new String[5];
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
//                itemDef.modelZoom = 3000;
//                itemDef.rotationX = 357;
//                itemDef.rotationY = 113;
//    			itemDef.modelOffsetY = 40;
//      			itemDef.modelOffset1 = 10;
//    			break;
//    		case 8042:
//    			itemDef.name = "@cya@SebZero's  @bla@Staff";
//                itemDef.modelID = 46061;
//                itemDef.maleEquip1 = 46061;
//                itemDef.femaleEquip1 = 46061;
//                itemDef.actions = new String[5];
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
//                itemDef.modelZoom = 1296;
//                itemDef.rotationX = 791;
//                itemDef.rotationY = 26;
//    			itemDef.modelOffsetY = 25;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//
//    		case 8034:
//    			itemDef.name = "@cya@SebZero's @bla@helmet";
//                itemDef.modelID = 28890;
//                itemDef.maleEquip1 = 28890;
//                itemDef.femaleEquip1 = 28890;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 391;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 240;
//    			itemDef.modelOffsetY = 800;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 8035:
//    			itemDef.name = "@cya@SebZero's @bla@platebody";
//                itemDef.modelID = 28891;
//                itemDef.maleEquip1 = 28891;
//                itemDef.femaleEquip1 = 28891;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1887;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 40;
//      			itemDef.modelOffset1 = 0;
//
//    			break;
//
//    		case 8036:
//    			itemDef.name = "@cya@SebZero's @bla@legs";
//                itemDef.modelID = 28892;
//                itemDef.maleEquip1 = 28892;
//                itemDef.femaleEquip1 = 28892;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1817;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 40;
//      			itemDef.modelOffset1 = 0;
//                itemDef.stackable = false;
//    			break;
//
//    		case 8037:
//    			itemDef.name = "@cya@SebZero's @bla@boots";
//                itemDef.modelID = 28893;
//                itemDef.maleEquip1 = 28893;
//                itemDef.femaleEquip1 = 28893;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 704;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 0;
//      			itemDef.modelOffset1 = 0;
//    			break;
//    		case 8038:
//    			itemDef.name = "@cya@SebZero's @bla@gloves";
//                itemDef.modelID = 28894;
//                itemDef.maleEquip1 = 28894;
//                itemDef.femaleEquip1 = 28894;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1470;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 1157;
//    			itemDef.modelOffsetY = 50;
//      			itemDef.modelOffset1 = 0;
//    			break;
//    		case 8039:
//    			itemDef.name = "@cya@SebZero's @bla@Wings";
//                itemDef.modelID = 28895;
//                itemDef.maleEquip1 = 28895;
//                itemDef.femaleEquip1 = 28895;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 3000;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 0;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 10906:
//    			itemDef.name = "@re1@Q's @whi@helmet";
//                itemDef.modelID = 25792;
//                itemDef.maleEquip1 = 25792;
//                itemDef.femaleEquip1 = 25792;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 583;
//                itemDef.rotationX = 339;
//                itemDef.rotationY = 460;
//                changeTexture(id, 40, 87);
//    			break;
//
//    		case 7607:
//    			itemDef.name = "@re1@Q's @whi@platebody";
//                itemDef.modelID = 25793;
//                itemDef.maleEquip1 = 25793;
//                itemDef.femaleEquip1 = 25793;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1400;
//                itemDef.rotationX = 43;
//                itemDef.rotationY = 26;
//    			itemDef.modelOffsetY = 61;
//                changeTexture(id, 40, 87);
//
//    			break;
//
//    		case 7608:
//    			itemDef.name = "@re1@Q's @whi@legs";
//                itemDef.modelID = 25794;
//                itemDef.maleEquip1 = 25794;
//                itemDef.femaleEquip1 = 25794;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1400;
//                itemDef.rotationX = 43;
//                itemDef.rotationY = 26;
//    			itemDef.modelOffsetY = 31;
//      			itemDef.modelOffset1 = -3;
//                changeTexture(id, 40, 87);
//    			break;
//
//    		case 7609:
//    			itemDef.name = "@re1@Q's @whi@boots";
//                itemDef.modelID = 25795;
//                itemDef.maleEquip1 = 25795;
//                itemDef.femaleEquip1 = 25795;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 791;
//                itemDef.rotationX = 322;
//                itemDef.rotationY = 113;
//    			itemDef.modelOffsetY = 21;
//      			itemDef.modelOffset1 = 6;
//                changeTexture(id, 40, 87);
//    			break;
//    		case 7610:
//    			itemDef.name = "@re1@Q's @whi@gloves";
//                itemDef.modelID = 25796;
//                itemDef.maleEquip1 = 25796;
//                itemDef.femaleEquip1 = 25796;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 478;
//                itemDef.rotationX = 513;
//                itemDef.rotationY = 287;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = 9;
//                changeTexture(id, 40, 87);
//    			break;
//    		case 19881:
//    			itemDef.name = "@whi@SebZero Creator helmet";
//                itemDef.modelID = 100018;
//                itemDef.maleEquip1 = 100018;
//                itemDef.femaleEquip1 = 100018;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 583;
//                itemDef.rotationX = 339;
//                itemDef.rotationY = 460;
//    			break;
//
//    		case 19882:
//    			itemDef.name = "@whi@SebZero Creator platebody";
//                itemDef.modelID = 100019;
//                itemDef.maleEquip1 = 100019;
//                itemDef.femaleEquip1 = 100019;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1400;
//                itemDef.rotationX = 43;
//                itemDef.rotationY = 26;
//    			itemDef.modelOffsetY = 61;
//    			break;
//
//    		case 19883:
//    			itemDef.name = "@whi@SebZero Creator legs";
//                itemDef.modelID = 100020;
//                itemDef.maleEquip1 = 100020;
//                itemDef.femaleEquip1 = 100020;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1400;
//                itemDef.rotationX = 43;
//                itemDef.rotationY = 26;
//    			itemDef.modelOffsetY = 31;
//      			itemDef.modelOffset1 = -3;
//    			break;
//
//    		case 19884:
//    			itemDef.name = "@whi@SebZero Creator boots";
//                itemDef.modelID = 100021;
//                itemDef.maleEquip1 = 100021;
//                itemDef.femaleEquip1 = 100021;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 791;
//                itemDef.rotationX = 322;
//                itemDef.rotationY = 113;
//    			itemDef.modelOffsetY = 21;
//      			itemDef.modelOffset1 = 6;
//    			break;
//    		case 19885:
//    			itemDef.name = "@whi@SebZero Creator gloves";
//                itemDef.modelID = 100022;
//                itemDef.maleEquip1 = 100022;
//                itemDef.femaleEquip1 = 100022;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 478;
//                itemDef.rotationX = 513;
//                itemDef.rotationY = 287;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = 9;
//    			break;
//    		case 19905:
//    			itemDef.name = "@whi@SebZero Creator offhand";
//                itemDef.modelID = 100023;
//                itemDef.maleEquip1 = 100023;
//                itemDef.femaleEquip1 = 100023;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1104;
//                itemDef.rotationX = 357;
//                itemDef.rotationY = 235;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = 9;
//    			break;
//
//    		case 19906:
//    			itemDef.name = "@whi@SebZero Creator Sword";
//                itemDef.modelID = 100024;
//                itemDef.maleEquip1 = 100024;
//                itemDef.femaleEquip1 = 100024;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1104;
//                itemDef.rotationX = 287;
//                itemDef.rotationY = 183;
//    			itemDef.modelOffsetY = 61;
//      			itemDef.modelOffset1 = 96;
//    			break;
//
//    		case 18886:
//    			itemDef.name = "@whi@Iron helmet";
//                itemDef.modelID = 100025;
//                itemDef.maleEquip1 = 100025;
//                itemDef.femaleEquip1 = 100025;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1278;
//                itemDef.rotationX = 9;
//                itemDef.rotationY = 339;
//    			itemDef.modelOffsetY = -78;
//      			itemDef.modelOffset1 = -9;
//                itemDef.stackable = false;
//    			break;
//
//    		case 19908:
//    			itemDef.name = "@whi@Iron Platebody";
//                itemDef.modelID = 100026;
//                itemDef.maleEquip1 = 100026;
//                itemDef.femaleEquip1 = 100026;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1504;
//                itemDef.rotationX = 61;
//               //itemDef.rotationY = 43;
//    			itemDef.modelOffsetY = -100;
//                itemDef.stackable = false;
//    			break;
//
//
//    		case 19909:
//    			itemDef.name = "@whi@Iron Platelegs";
//                itemDef.modelID = 100027;
//                itemDef.maleEquip1 = 100027;
//                itemDef.femaleEquip1 = 100027;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1243;
//                itemDef.rotationX = 43;
//                itemDef.rotationY = 43;
//                itemDef.stackable = false;
//      			//itemDef.modelOffsetY = 98;
//    			break;
//
//    		case 19910:
//    			itemDef.name = "@whi@Iron Boots";
//                itemDef.modelID = 100028;
//                itemDef.maleEquip1 = 100028;
//                itemDef.femaleEquip1 = 100028;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 913;
//                itemDef.rotationX = 9;
//                itemDef.rotationY = 0;
//      			itemDef.modelOffsetY = 5;
//      			itemDef.modelOffset1 = -4;
//                itemDef.stackable = false;
//    			break;
//
//    		case 19911:
//    			itemDef.name = "@whi@Iron Gloves";
//                itemDef.modelID = 100029;
//                itemDef.maleEquip1 = 100029;
//                itemDef.femaleEquip1 = 100029;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1157;
//                itemDef.rotationX = 270;
//                itemDef.rotationY = 220;
//      			itemDef.modelOffsetY = 252;
//      			itemDef.modelOffset1 = -4;
//                itemDef.stackable = false;
//    			break;
//
//
//    		case 19912:
//    			itemDef.name = "@whi@Iron Cape";
//                itemDef.modelID = 100030;
//                itemDef.maleEquip1 = 100030;
//                itemDef.femaleEquip1 = 100030;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1991;
//                itemDef.rotationX = 9;
//                itemDef.rotationY = 1939;
//      			//itemDef.modelOffsetY = 252;
//      			itemDef.modelOffset1 = -4;
//                itemDef.stackable = false;
//    			break;
//
//
//    		case 19913:
//    			itemDef.name = "@whi@Iron Amulet";
//                itemDef.modelID = 100031;
//                itemDef.maleEquip1 = 100031;
//                itemDef.femaleEquip1 = 100031;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1291;
//      			itemDef.modelOffsetY = -381;
//      			itemDef.modelOffset1 = -4;
//                itemDef.stackable = false;
//    			break;
//
//
//    		case 17853:
//    			itemDef.name = "@whi@Vendetta's Spear";
//                itemDef.modelID = 100496;
//                itemDef.maleEquip1 = 100496;
//                itemDef.femaleEquip1 = 100496;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1052;
//                itemDef.rotationX = 1157;
//                itemDef.rotationY = 809;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = -43;
//                itemDef.stackable = false;
//    			break;
//
//    		case 17854:
//    			itemDef.name = "@whi@Vendetta's Shield";
//                itemDef.modelID = 100495;
//                itemDef.maleEquip1 = 100495;
//                itemDef.femaleEquip1 = 100495;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1104;
//                itemDef.rotationX = 357;
//                itemDef.rotationY = 235;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = 9;
//                itemDef.stackable = false;
//    			break;
//
//    		case 19914:
//    			itemDef.name = "@whi@Iron Offhand";
//                itemDef.modelID = 100032;
//                itemDef.maleEquip1 = 100032;
//                itemDef.femaleEquip1 = 100032;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1104;
//                itemDef.rotationX = 357;
//                itemDef.rotationY = 235;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = 9;
//                itemDef.stackable = false;
//    			break;
//
//
//    		case 19915:
//    			itemDef.name = "@whi@Iron Bow";
//                itemDef.modelID = 100033;
//                itemDef.maleEquip1 = 100033;
//                itemDef.femaleEquip1 = 100033;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1748;
//                itemDef.rotationX = 1209;
//                itemDef.rotationY = 61;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = -26;
//                itemDef.stackable = false;
//    			break;
//
//
//    		case 19916:
//    			itemDef.name = "@whi@Iron Staff";
//                itemDef.modelID = 100034;
//                itemDef.maleEquip1 = 100034;
//                itemDef.femaleEquip1 = 100034;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 2252;
//                itemDef.rotationX = 183;
//                itemDef.rotationY = 61;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = 43;
//                itemDef.stackable = false;
//    			break;
//
//
//    		case 18887:
//    			itemDef.name = "@whi@Iron Sword";
//                itemDef.modelID = 100035;
//                itemDef.maleEquip1 = 100035;
//                itemDef.femaleEquip1 = 100035;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1052;
//                itemDef.rotationX = 1157;
//                itemDef.rotationY = 809;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = -43;
//                itemDef.stackable = false;
//    			break;
//
//
//    		case 19918:
//    			itemDef.name = "@whi@Magic Helmet";
//                itemDef.modelID = 100036;
//                itemDef.maleEquip1 = 100036;
//                itemDef.femaleEquip1 = 100036;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1052;
//                itemDef.rotationX = 2043;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 50;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 19919:
//    			itemDef.name = "@whi@Magic Platebody";
//                itemDef.modelID = 100037;
//                itemDef.maleEquip1 = 100037;
//                itemDef.femaleEquip1 = 100037;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1348;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 78;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 19920:
//    			itemDef.name = "@whi@Magic Platelegs";
//                itemDef.modelID = 100038;
//                itemDef.maleEquip1 = 100038;
//                itemDef.femaleEquip1 = 100038;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1609;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 0;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 19921:
//    			itemDef.name = "@whi@Magic Boots";
//                itemDef.modelID = 100039;
//                itemDef.maleEquip1 = 100039;
//                itemDef.femaleEquip1 = 100039;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//    			break;
//
//    		case 19922:
//    			itemDef.name = "@whi@Magic Gloves";
//                itemDef.modelID = 100040;
//                itemDef.maleEquip1 = 100040;
//                itemDef.femaleEquip1 = 100040;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1070;
//                itemDef.rotationX = 252;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 40;
//      			itemDef.modelOffset1 = 0;
//                itemDef.stackable = false;
//    			break;
//
//
//    		case 19923:
//    			itemDef.name = "@pur@Ninja's Staff";
//                itemDef.modelID = 100041;
//                itemDef.maleEquip1 = 100041;
//                itemDef.femaleEquip1 = 100041;
//                itemDef.actions = new String[5];
//    			itemDef.actions = new String[] { null, "Equip", "@or2@Operate", null, "Drop" };
//                itemDef.modelZoom = 1296;
//                itemDef.rotationX = 791;
//                itemDef.rotationY = 26;
//    			itemDef.modelOffsetY = 25;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//
//    		case 19924:
//    			itemDef.name = "@whi@Magic Book";
//                itemDef.modelID = 100042;
//                itemDef.maleEquip1 = 100042;
//                itemDef.femaleEquip1 = 100042;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1504;
//                itemDef.rotationX = 1348;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 40;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 19925:
//    			itemDef.name = "@whi@Melee Helmet";
//                itemDef.modelID = 100043;
//                itemDef.maleEquip1 = 100043;
//                itemDef.femaleEquip1 = 100043;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 391;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 240;
//    			itemDef.modelOffsetY = 800;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//
//    		case 19926:
//    			itemDef.name = "@whi@Melee Platebody";
//                itemDef.modelID = 100044;
//                itemDef.maleEquip1 = 100044;
//                itemDef.femaleEquip1 = 100044;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1887;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 40;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 19927:
//    			itemDef.name = "@whi@Melee Platelegs";
//                itemDef.modelID = 100045;
//                itemDef.maleEquip1 = 100045;
//                itemDef.femaleEquip1 = 100045;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1817;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 40;
//      			itemDef.modelOffset1 = 0;
//                itemDef.stackable = false;
//    			break;
//
//    		case 19928:
//    			itemDef.name = "@whi@Melee boots";
//                itemDef.modelID = 100046;
//                itemDef.maleEquip1 = 100046;
//                itemDef.femaleEquip1 = 100046;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 704;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 0;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 19929:
//    			itemDef.name = "@whi@Melee gloves";
//                itemDef.modelID = 100047;
//                itemDef.maleEquip1 = 100047;
//                itemDef.femaleEquip1 = 100047;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1470;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 1157;
//    			itemDef.modelOffsetY = 50;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//
//    		case 19930:
//    			itemDef.name = "@whi@Melee cape";
//                itemDef.modelID = 100048;
//                itemDef.maleEquip1 = 100048;
//                itemDef.femaleEquip1 = 100048;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 3000;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 0;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//
//    		case 19931:
//    			itemDef.name = "@whi@Melee blade";
//                itemDef.modelID = 100049;
//                itemDef.maleEquip1 = 100049;
//                itemDef.femaleEquip1 = 100049;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 3000;
//                itemDef.rotationX = 374;
//                itemDef.rotationY = 61;
//    			itemDef.modelOffsetY = 43;
//      			itemDef.modelOffset1 = 96;
//    			break;
//
//
//    		case 19948:
//    			itemDef.name = "@whi@Range Helmet";
//                itemDef.modelID = 100050;
//                itemDef.maleEquip1 = 100050;
//                itemDef.femaleEquip1 = 100050;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1365;
//                itemDef.rotationX = 183;
//                itemDef.rotationY = 339;
//    			itemDef.modelOffsetY = -113;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 19933:
//    			itemDef.name = "@whi@Range Platebody";
//                itemDef.modelID = 100051;
//                itemDef.maleEquip1 = 100051;
//                itemDef.femaleEquip1 = 100051;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1626;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 50;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 19934:
//    			itemDef.name = "@whi@Range Platelegs";
//                itemDef.modelID = 100052;
//                itemDef.maleEquip1 = 100052;
//                itemDef.femaleEquip1 = 100052;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1470;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 78;
//    			itemDef.modelOffsetY = 9;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 19940:
//    			itemDef.name = "@whi@Range boots";
//                itemDef.modelID = 100053;
//                itemDef.maleEquip1 = 100053;
//                itemDef.femaleEquip1 = 100053;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 652;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 0;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//
//    		case 19941:
//    			itemDef.name = "@whi@Range offhand";
//                itemDef.modelID = 100056;
//                itemDef.maleEquip1 = 100056;
//                itemDef.femaleEquip1 = 100056;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1226;
//                itemDef.rotationX = 530;
//                itemDef.rotationY = 252;
//    			itemDef.modelOffsetY = 0;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//
//    		case 19942:
//    			itemDef.name = "@whi@Range gloves";
//                itemDef.modelID = 100054;
//                itemDef.maleEquip1 = 100054;
//                itemDef.femaleEquip1 = 100054;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1226;
//                itemDef.rotationX = 339;
//                itemDef.rotationY = 26;
//    			itemDef.modelOffsetY = 35;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//
//    		case 19944:
//    			itemDef.name = "@whi@Range cape";
//                itemDef.modelID = 100055;
//                itemDef.maleEquip1 = 100055;
//                itemDef.femaleEquip1 = 100055;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 3000;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 0;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//
//    		case 19946:
//    			itemDef.name = "@whi@Range bow";
//                itemDef.modelID = 100057;
//                itemDef.maleEquip1 = 100057;
//                itemDef.femaleEquip1 = 100057;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 3000;
//                itemDef.rotationX = 357;
//                itemDef.rotationY = 113;
//    			itemDef.modelOffsetY = 40;
//      			itemDef.modelOffset1 = 10;
//    			break;
//
//    		case 19949:
//    			itemDef.name = "@whi@Lili's Mask";
//                itemDef.modelID = 100058;
//                itemDef.maleEquip1 = 100059;
//                itemDef.femaleEquip1 = 100059;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 583;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 478;
//    			itemDef.modelOffsetY = 0;
//    			break;
//
//
//    		case 19950:
//    			itemDef.name = "@whi@Lili's top";
//                itemDef.modelID = 100060;
//                itemDef.maleEquip1 = 100061;
//                itemDef.femaleEquip1 = 100061;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1200;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 478;
//    			itemDef.modelOffsetY = 0;
//    			break;
//    		case 19951:
//    			itemDef.name = "@whi@Lili's skirt";
//                itemDef.modelID = 100062;
//                itemDef.maleEquip1 = 100063;
//                itemDef.femaleEquip1 = 100063;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1570;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 443;
//    			itemDef.modelOffsetY = 10;
//    			break;
//
//    		case 19952:
//    			itemDef.name = "@whi@Lili's boots";
//                itemDef.modelID = 100066;
//                itemDef.maleEquip1 = 100066;
//                itemDef.femaleEquip1 = 100066;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 670;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 1139;
//    			itemDef.modelOffsetY = 0;
//    			break;
//
//    		case 19953:
//    			itemDef.name = "@whi@Lili's gloves";
//                itemDef.modelID = 100064;
//                itemDef.maleEquip1 = 100065;
//                itemDef.femaleEquip1 = 100065;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 617;
//                itemDef.rotationX = 513;
//                itemDef.rotationY = 1139;
//    			itemDef.modelOffsetY = 0;
//    			break;
//
//    		case 19954:
//    			itemDef.name = "@whi@Naraku Helmet";
//                itemDef.modelID = 100067;
//                itemDef.maleEquip1 = 100067;
//                itemDef.femaleEquip1 = 100067;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 565;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 80;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 19955:
//    			itemDef.name = "@whi@Naraku Platebody";
//                itemDef.modelID = 100068;
//                itemDef.maleEquip1 = 100068;
//                itemDef.femaleEquip1 = 100068;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1365;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 60;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//    		case 19956:
//    			itemDef.name = "@whi@Naraku Platelegs";
//                itemDef.modelID = 100069;
//                itemDef.maleEquip1 = 100069;
//                itemDef.femaleEquip1 = 100069;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1365;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 60;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//
//    		case 19998:
//    			itemDef.name = "@whi@Naraku boots";
//                itemDef.modelID = 100070;
//                itemDef.maleEquip1 = 100070;
//                itemDef.femaleEquip1 = 100070;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 635;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 0;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//
//    		case 19959:
//    			itemDef.name = "@whi@Naraku gloves";
//                itemDef.modelID = 100071;
//                itemDef.maleEquip1 = 100071;
//                itemDef.femaleEquip1 = 100071;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 965;
//                itemDef.rotationX = 449;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 40;
//      			itemDef.modelOffset1 = -2;
//    			break;
//
//    		case 19960:
//    			itemDef.name = "@whi@Naraku wings";
//                itemDef.modelID = 100072;
//                itemDef.maleEquip1 = 100072;
//                itemDef.femaleEquip1 = 100072;
//                itemDef.actions = new String[5];
//     			itemDef.actions[1] = "Wear";
//     			itemDef.actions[4] = "Drop";
//                itemDef.modelZoom = 1626;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 113;
//    			itemDef.modelOffsetY = 40;
//      			itemDef.modelOffset1 = 0;
//    			break;
//
//            case 15501:
//                ItemDef.copyModel(itemDef, 14691);
//                itemDef.name = "Donation Chest";
//                itemDef.animateInventory = true;
//                break;
//
//            case 455:
//                itemDef.name = "SebZero Scratch Card";
//                itemDef.animateInventory = true;
//                break;
//
//            case 10169:
//                ItemDef.copyModel(itemDef, 455);
//                itemDef.name = "OP ScratchCard";
//                itemDef.animateInventory = true;
//                break;
//
//
//            case 18405:
//                ItemDef.copyModel(itemDef, 7462);
//                itemDef.stackable = false;
//                itemDef.name = "Onyx Gauntlets";
//                itemDef.description = "Formed from a Onyx Gem";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 5173:
//                ItemDef.copyModel(itemDef, 18865);
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.name = "Hellfire Shadow Scythe";
//                itemDef.animateInventory = true;
//                itemDef.modelZoom = 1812;
//                itemDef.rotationX = 1483;
//                itemDef.rotationY = 438;
//
//                break;
//
//            case 5167:
//                ItemDef.copyModel(itemDef, 20054);
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.name = "Galaxy Lucky Ring";
//                itemDef.animateInventory = true;
//                break;
//
//            case 9928:
//                itemDef.name = "Banished Helmet";
//                changeTexture(id, 55, 58);
//                itemDef.modelID = 61004;
//                itemDef.maleEquip1 = 61005;
//                itemDef.femaleEquip1 = 61005;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 9929:
//                itemDef.name = "Banished Platebody";
//                changeTexture(id, 55, 58);
//                itemDef.modelID = 61006;
//                itemDef.maleEquip1 = 61007;
//                itemDef.femaleEquip1 = 61007;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 9930:
//                itemDef.name = "Banished legs";
//                changeTexture(id, 55, 58);
//                itemDef.modelID = 61008;
//                itemDef.maleEquip1 = 61009;
//                itemDef.femaleEquip1 = 61009;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//
//            case 9500:
//                itemDef.name = "Inferior Helm";
//                itemDef.modelID = 23853;
//                itemDef.maleEquip1 = 23854;
//                itemDef.femaleEquip1 = 23854;
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 9501:
//                itemDef.name = "Inferior Body";
//                itemDef.modelID = 23857;
//                itemDef.maleEquip1 = 23858;
//                itemDef.femaleEquip1 = 23858;
//                ItemDef.copyMostDefs(itemDef, 1127);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 9502:
//                itemDef.name = "Inferior legs";
//                itemDef.modelID = 23859;
//                itemDef.maleEquip1 = 23860;
//                itemDef.femaleEquip1 = 23860;
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 587:
//                itemDef.name = "Slayer Orb";
//                itemDef.actions = new String[] { null, "ACTIVATE", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//
//
//
//            case 6830:
//                itemDef.name = "Supreme Package";
//                itemDef.actions = new String[] { null, "Open", null, null, "Drop" };
//                break;
//            case 9503:
//                itemDef.name = "Blessed Amulet(3%DR)";
//                ItemDef.copyModel(itemDef, 15418);
//                break;
//
//
//
//
//
//            case 5169:
//                ItemDef.copyModel(itemDef, 13899);
//                itemDef.name = "Onyx Longsword";
//                itemDef.animateInventory = true;
//                break;
//
//            case 5171:
//                ItemDef.copyModel(itemDef, 18971);
//                itemDef.name = "Supreme Bow";
//                itemDef.animateInventory = true;
//                break;
//
//            case 13702:
//                ItemDef.copyModel(itemDef, 3931);
//                itemDef.name = "Godzilla Cape+";
//                changeTexture(id, 40, 66);
//                itemDef.actions[1] = "Wield";
//                break;
//            case 13703:
//                ItemDef.copyModel(itemDef, 3958);
//                itemDef.name = "Godzilla Platebody+";
//                changeTexture(id, 60, 66);
//                itemDef.actions[1] = "Wield";
//                break;
//            case 13704:
//                ItemDef.copyModel(itemDef, 3959);
//                itemDef.name = "Godzilla Platelegs+";
//                changeTexture(id, 60, 66);
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 3959:
//                itemDef.name = "Godzilla Platelegs";
//                changeTexture(id, 60, 58);
//    			itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//
//            case 13705:
//                ItemDef.copyModel(itemDef, 3960);
//                itemDef.name = "Godzilla Helmet+";
//                changeTexture(id, 60, 66);
//                itemDef.actions[1] = "Wield";
//                break;
//            case 13706:
//                ItemDef.copyModel(itemDef, 3958);
//                itemDef.name = "Godzilla Platebody+";
//                changeTexture(id, 60, 66);
//                itemDef.actions[1] = "Wield";
//                break;
//            case 13840:
//                itemDef.name = "Dragonslayer helmet+";
//                itemDef.modelID = 23433;
//                itemDef.femaleEquip1 = 23434;
//                itemDef.maleEquip1 = 23434;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 13841:
//                itemDef.name = "Dragonslayer platebody+";
//                itemDef.modelID = 23435;
//                itemDef.femaleEquip1 = 23436;
//                itemDef.maleEquip1 = 23436;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 13842:
//                itemDef.name = "Dragonslayer platelegs+";
//                itemDef.modelID = 23437;
//                itemDef.femaleEquip1 = 23438;
//                itemDef.maleEquip1 = 23438;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 13843:
//                itemDef.name = "Dragonslayer cape+";
//                itemDef.modelID = 23439;
//                itemDef.femaleEquip1 = 23439;
//                itemDef.maleEquip1 = 23439;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//
//            case 13707:
//                ItemDef.copyModel(itemDef, 5186);
//                itemDef.name = "Godzilla Boots+";
//                itemDef.actions[1] = "Wield";
//                break;
//
//            case 13708:
//                ItemDef.copyModel(itemDef, 5187);
//                itemDef.name = "Godzilla Gloves+";
//                itemDef.actions[1] = "Wield";
//                break;
//
//
//            case 9505:
//                itemDef.name = "Emperor Helm";
//                itemDef.modelID = 23862;
//                itemDef.maleEquip1 = 23863;
//                itemDef.femaleEquip1 = 23863;
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 1127:
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 1079:
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 18929:
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 9506:
//                itemDef.name = "Emperor Body";
//                itemDef.modelID = 23864;
//                itemDef.maleEquip1 = 23865;
//                itemDef.femaleEquip1 = 23865;
//                ItemDef.copyMostDefs(itemDef, 1127);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 9507:
//                itemDef.name = "Emperor Legs";
//                itemDef.modelID = 23866;
//                itemDef.maleEquip1 = 23867;
//                itemDef.femaleEquip1 = 23867;
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5186:
//                ItemDef.copyModel(itemDef, 6619);
//                itemDef.name = "Godzilla Boots";
//                itemDef.animateInventory = true;
//    			itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//            case 5187:
//                ItemDef.copyModel(itemDef, 20022);
//                itemDef.name = "Godzilla Gloves";
//                itemDef.animateInventory = true;
//    			itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//            case 5188:
//                ItemDef.copyModel(itemDef, 6619);
//                itemDef.name = "Onyx Boots";
//                itemDef.animateInventory = true;
//                break;
//            case 5189:
//                ItemDef.copyModel(itemDef, 20022);
//                itemDef.name = "Onyx Range Gloves";
//                itemDef.animateInventory = true;
//                break;
//
//            case 19468:
//                ItemDef.copyModel(itemDef, 17293);
//                itemDef.name = "Staff of Envy";
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                break;
//            case 1163:
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//            	break;
//            case 19721:
//                itemDef.modelID = 23187;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.modelZoom = 500;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.maleEquip1 = 23188;
//                itemDef.femaleEquip1 = 23188;
//                itemDef.name = "Blessed Hood";
//                break;
//            case 18892:
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//    			break;
//            case 5172:
//                ItemDef.copyModel(itemDef, 18931);
//                itemDef.name = "Onyx Supreme Crossbow";
//                itemDef.animateInventory = true;
//                itemDef.modelZoom = 1966;
//                itemDef.rotationX = 341;
//                itemDef.rotationY = 446;
//                break;
//            case 19137:
//                itemDef.name = "Incredible Pernix hood";
//                itemDef.modelID = 23163;
//                itemDef.femaleEquip1 = 23164;
//                itemDef.maleEquip1 = 23164;
//                ItemDef.copyMostDefs(itemDef, 14011);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.editedModelColor = new int[] { 70 };
//                itemDef.newModelColor = new int[] {63 };
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 19138:
//                itemDef.name = "Incredible pernix body";
//                itemDef.modelID = 23166;
//                itemDef.femaleEquip1 = 23168;
//                itemDef.maleEquip1 = 23168;
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.editedModelColor = new int[] { 70 };
//                itemDef.newModelColor = new int[] {63 };
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 19139:
//                itemDef.name = "Incredible pernix legs";
//                itemDef.modelID = 23169;
//                itemDef.femaleEquip1 = 23170;
//                itemDef.maleEquip1 = 23170;
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.editedModelColor = new int[] { 70 };
//                itemDef.newModelColor = new int[] {63 };
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 3316:
//    			itemDef.originalModelColors = new int[] { 62 };
//    			itemDef.newModelColor = new int[] { 58 };
//                itemDef.name = "Godzilla Spirit Shield";
//    			itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//            case 14559:
//                itemDef.name = "Godzilla Whip";
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                break;
//            case 15657:
//                itemDef.modelID = 23316;
//                itemDef.name = "Toxic helmet";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.femaleEquip1 = 23317;
//                itemDef.maleEquip1 = 23317;
//                itemDef.description = "Toxic helmet";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 15658:
//                itemDef.modelID = 23318;
//                itemDef.name = "Toxic Platebody";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.femaleEquip1 = 23319;
//                itemDef.maleEquip1 = 23319;
//                itemDef.description = "Toxic helmet";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 4280:
//                itemDef.name = "Yoshi's Platelegs";
//                itemDef.modelID = 62555;
//                itemDef.maleEquip1 = 62556;
//                itemDef.femaleEquip1 = 62556;
//    			changeTexture(id, 40, 58);
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 4281:
//                itemDef.name = "Yoshi's Platebody";
//                itemDef.modelID = 62552;
//                itemDef.maleEquip1 = 62553;
//                itemDef.femaleEquip1 = 62553;
//    			changeTexture(id, 40, 58);
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 4282:
//                itemDef.name = "Yoshi's Helmet";
//                itemDef.modelID = 61523;
//                itemDef.maleEquip1 = 61524;
//                itemDef.femaleEquip1 = 61524;
//    			changeTexture(id, 40, 58);
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 4283:
//                itemDef.name = "Yoshi's Boots";
//                itemDef.modelID = 44412;
//                itemDef.maleEquip1 = 44412;
//                itemDef.femaleEquip1 = 44412;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 4284:
//                itemDef.name = "Yoshi's Gloves";
//                itemDef.modelID = 44413;
//                itemDef.maleEquip1 = 44413;
//                itemDef.femaleEquip1 = 44413;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5256:
//                itemDef.modelID = 48383;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 48382;
//                itemDef.femaleEquip1 = 44382;
//                itemDef.name = "Brutal Sword";
//                break;
//            case 5257:
//                itemDef.modelID = 48384;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 48385;
//                itemDef.femaleEquip1 = 48385;
//                itemDef.name = "Brutal Platebody";
//                break;
//            case 5265:
//                itemDef.modelID = 48387;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 48386;
//                itemDef.femaleEquip1 = 48386;
//                itemDef.name = "Brutal Full Helmet";
//                break;
//            case 5268:
//                itemDef.modelID = 48391;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 48390;
//                itemDef.femaleEquip1 = 44390;
//                itemDef.name = "Brutal Wings";
//                break;
//
//            case 4285:
//                itemDef.name = "Soulcrusher Platebody";
//                itemDef.modelID = 44414;
//                itemDef.maleEquip1 = 44414;
//                itemDef.femaleEquip1 = 44414;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 4286:
//                itemDef.name = "Soulcrusher Platelegs";
//                itemDef.modelID = 44415;
//                itemDef.maleEquip1 = 44415;
//                itemDef.femaleEquip1 = 44415;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 4295:
//                itemDef.name = "Soulcrusher Helmet";
//                itemDef.modelID = 44416;
//                itemDef.maleEquip1 = 44416;
//                itemDef.femaleEquip1 = 44416;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 4296:
//                itemDef.name = "Soulcrusher Boots";
//                itemDef.modelID = 44417;
//                itemDef.maleEquip1 = 44417;
//                itemDef.femaleEquip1 = 44417;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 4297:
//                itemDef.name = "Soulcrusher Gloves";
//                itemDef.modelID = 44418;
//                itemDef.maleEquip1 = 44418;
//                itemDef.femaleEquip1 = 44418;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16510:
//                itemDef.name = "Akasha Boots";
//                itemDef.modelID = 61395;
//                itemDef.maleEquip1 = 61395;
//                itemDef.femaleEquip1 = 61395;
//                ItemDef.copyMostDefs(itemDef, 11733);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16511:
//                itemDef.name = "Akasha Cape";
//                itemDef.modelID = 61414;
//                itemDef.femaleEquip1 = 61427;
//                itemDef.maleEquip1 = 61427;
//                ItemDef.copyMostDefs(itemDef, 1021);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 16513:
//                itemDef.name = "Akasha Gloves";
//                itemDef.modelID = 61430;
//                itemDef.maleEquip1 = 61431;
//                itemDef.femaleEquip1 = 61431;
//                ItemDef.copyMostDefs(itemDef, 2902);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//    		case 16514:
//    			itemDef.name = "Akasha Helm";
//    			itemDef.modelID = 61433;
//    			itemDef.maleEquip1 = 61437;
//    			itemDef.femaleEquip1 = 61437;
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//    			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//    			itemDef.stackable = false;
//    			break;
//    		case 16515:
//    			itemDef.name = "Akasha Body";
//    			itemDef.modelID = 61442;
//    			itemDef.maleEquip1 = 61443;
//    			itemDef.femaleEquip1 = 61443;
//                ItemDef.copyMostDefs(itemDef, 1127);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//    			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//    			itemDef.stackable = false;
//    			break;
//    		case 16516:
//    			itemDef.name = "Akasha leggings";
//    			itemDef.modelID = 61439;
//    			itemDef.maleEquip1 = 61441;
//    			itemDef.femaleEquip1 = 61441;
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//    			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//    			itemDef.stackable = false;
//    			break;
//    		case 16518:
//    			itemDef.name = "Akasha Staff";
//    			itemDef.modelID = 61444;
//    			itemDef.maleEquip1 = 61445;
//    			itemDef.femaleEquip1 = 61445;
//                ItemDef.copyMostDefs(itemDef, 3282);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//    			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//    			itemDef.stackable = false;
//    			break;
//            case 5226:
//                itemDef.name = "Vanquisher Boots";
//                itemDef.modelID = 44453;
//                itemDef.maleEquip1 = 44453;
//                itemDef.femaleEquip1 = 44453;
//                ItemDef.copyMostDefs(itemDef, 11733);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5227:
//                itemDef.name = "Vanquisher Gloves";
//                itemDef.modelID = 44459;
//                itemDef.maleEquip1 = 44454;
//                itemDef.femaleEquip1 = 44454;
//                ItemDef.copyMostDefs(itemDef, 2902);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5228:
//                itemDef.name = "Vanquisher Helmet";
//                itemDef.modelID = 44460;
//                itemDef.maleEquip1 = 44455;
//                itemDef.femaleEquip1 = 44455;
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5229:
//                itemDef.name = "Vanquisher Platebody";
//                ItemDef.copyMostDefs(itemDef, 1127);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.modelID = 44461;
//                itemDef.maleEquip1 = 44456;
//                itemDef.femaleEquip1 = 44456;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5230:
//                itemDef.name = "Vanquisher Platelegs";
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.modelID = 44462;
//                itemDef.maleEquip1 = 44457;
//                itemDef.femaleEquip1 = 44457;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5231:
//                itemDef.name = "Vanquisher Whip";
//                itemDef.modelID = 44463;
//                ItemDef.copyMostDefs(itemDef, 4151);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.modelZoom = 2200;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.maleEquip1 = 44458;
//                itemDef.femaleEquip1 = 44458;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5232:
//                itemDef.name = "Frozen Key";
//                itemDef.modelID = 44464;
//                itemDef.stackable = true;
//                break;
//
//            case 5266:
//                itemDef.name = "Grand Donation Key";
//                itemDef.modelID = 61304;
//                itemDef.stackable = true;
//                break;
//
//            case 14037:
//                itemDef.name = "Creators Mask";
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.modelID = 35432;
//                itemDef.maleEquip1 = 35432;
//                itemDef.femaleEquip1 = 35432;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//            case 14038:
//                itemDef.name = "Creators Platebody";
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.modelID = 35433;
//                itemDef.maleEquip1 = 35433;
//                itemDef.femaleEquip1 = 35433;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//            case 14039:
//                itemDef.name = "Creators Platelegs";
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.modelID = 35434;
//                itemDef.maleEquip1 = 35434;
//                itemDef.femaleEquip1 = 35434;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//            case 14040:
//                itemDef.name = "Creators Gloves";
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.modelID = 35435;
//                itemDef.maleEquip1 = 35435;
//                itemDef.femaleEquip1 = 35435;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//            case 14041:
//                itemDef.name = "Creators Boots";
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.modelID = 35436;
//                itemDef.maleEquip1 = 35436;
//                itemDef.femaleEquip1 = 35436;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//            case 14042:
//                itemDef.name = "Creators Sword";
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.modelID = 35437;
//                itemDef.maleEquip1 = 35437;
//                itemDef.femaleEquip1 = 35437;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//            case 14043:
//                itemDef.name = "Inuyasha Mask";
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.modelID = 35438;
//                itemDef.maleEquip1 = 35438;
//                itemDef.femaleEquip1 = 35438;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//            case 14503:
//                itemDef.name = "Inuyasha Body";
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.modelID = 35439;
//                itemDef.maleEquip1 = 35439;
//                itemDef.femaleEquip1 = 35439;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//            case 14504:
//                itemDef.name = "Inuyasha Legs";
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.modelID = 35440;
//                itemDef.maleEquip1 = 35440;
//                itemDef.femaleEquip1 = 35440;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//            case 14510:
//                itemDef.name = "Inuyasha Gloves";
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.modelID = 35441;
//                itemDef.maleEquip1 = 35441;
//                itemDef.femaleEquip1 = 35441;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//            case 14511:
//                itemDef.name = "Inuyasha Boots";
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.modelID = 35442;
//                itemDef.maleEquip1 = 35442;
//                itemDef.femaleEquip1 = 35442;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//            case 14512:
//                itemDef.name = "Inuyasha Sword";
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.modelID = 35443;
//                itemDef.maleEquip1 = 35443;
//                itemDef.femaleEquip1 = 35443;
//                itemDef.actions = new String[5];
//    			itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//    			itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//            case 16443:
//                itemDef.name = "Dreamflow Mask";
//                itemDef.modelZoom = 760;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 82;
//                itemDef.modelID = 44641;
//                itemDef.maleEquip1 = 44641;
//                itemDef.femaleEquip1 = 44641;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16444:
//                itemDef.name = "Dreamflow body";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.modelID = 44642;
//                itemDef.maleEquip1 = 44642;
//                itemDef.femaleEquip1 = 44642;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16445:
//                itemDef.name = "Dreamflow Legs";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.modelID = 44643;
//                itemDef.maleEquip1 = 44643;
//                itemDef.femaleEquip1 = 44643;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 17837:
//                itemDef.name = "@red@Blood arsenic scythe";
//                itemDef.modelID = 61286;
//                itemDef.maleEquip1 = 61288;
//                itemDef.femaleEquip1 = 61288;
//                ItemDef.copyMostDefs(itemDef, 13899);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//    			changeTexture(id, 40, 61);
//                break;
//            case 16435:
//                itemDef.name = "@red@Blood arsenic blade";
//                itemDef.modelID = 61253;
//                itemDef.maleEquip1 = 61254;
//                itemDef.femaleEquip1 = 61254;
//                ItemDef.copyMostDefs(itemDef, 13899);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16523:
//                itemDef.name = "@red@AS Sav@bla@(@red@AR@bla@)";
//                itemDef.modelID = 44241;
//                itemDef.maleEquip1 = 44242;
//                itemDef.femaleEquip1 = 44242;
//                ItemDef.copyMostDefs(itemDef, 13899);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16525:
//                itemDef.name = "@red@mp7a2@bla@(@red@SMG@bla@)";
//                itemDef.modelID = 44243;
//                itemDef.maleEquip1 = 44244;
//                itemDef.femaleEquip1 = 44244;
//                ItemDef.copyMostDefs(itemDef, 13899);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16526:
//                itemDef.name = "@whi@Steyr AUG@bla@(@whi@AR@bla@)";
//                itemDef.modelID = 44245;
//                itemDef.maleEquip1 = 44246;
//                itemDef.femaleEquip1 = 44246;
//                ItemDef.copyMostDefs(itemDef, 13899);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16528:
//                itemDef.name = "@or2@Tommy Gun@or1@(@or2@AR@or1@)";
//                itemDef.modelID = 44247;
//                itemDef.maleEquip1 = 44248;
//                itemDef.femaleEquip1 = 44248;
//                ItemDef.copyMostDefs(itemDef, 13899);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16436:
//                itemDef.name = "@red@Blood arsenic crossbow";
//                itemDef.modelID = 61255;
//                itemDef.maleEquip1 = 61257;
//                itemDef.femaleEquip1 = 61257;
//                ItemDef.copyMostDefs(itemDef, 13530);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16463:
//                itemDef.name = "@red@Blood arsenic staff";
//                itemDef.modelID = 61259;
//                itemDef.maleEquip1 = 61262;
//                itemDef.femaleEquip1 = 61262;
//                ItemDef.copyMostDefs(itemDef, 1395);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16489:
//                itemDef.name = "@red@Blood arsenic helmet";
//                itemDef.modelID = 61193;
//                itemDef.maleEquip1 = 61198;
//                itemDef.femaleEquip1 = 61198;
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                changeTexture(id, 40, 61);
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16490:
//                itemDef.name = "@red@Blood arsenic body";
//                itemDef.modelID = 61199;
//                itemDef.maleEquip1 = 61203;
//                itemDef.femaleEquip1 = 61203;
//                ItemDef.copyMostDefs(itemDef, 1127);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                changeTexture(id, 40, 61);
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16491:
//                itemDef.name = "@red@Blood arsenic legs";
//                itemDef.modelID = 61205;
//                itemDef.maleEquip1 = 61209;
//                itemDef.femaleEquip1 = 61209;
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//                changeTexture(id, 40, 61);
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16493:
//                itemDef.modelID = 61268;
//                itemDef.name = "@red@Blood Arsenic Gloves";
//                itemDef.description = "Man this shet looks gud";
//                itemDef.maleEquip1 = 61266;
//                itemDef.femaleEquip1 = 61266;
//                itemDef.actions = new String[5];
//                itemDef.modelZoom = 1300;
//                itemDef.rotationY = 520;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[4] = "Drop";
//                break;
//    		case 16494:
//    			itemDef.name = "@red@Blood Arsenic Boots";
//    			itemDef.stackable = false;
//    			ItemDef.copyModel(itemDef, 4803);
//    			itemDef.originalModelColors = new int[] { 60 };
//    			itemDef.newModelColor = new int[] { 61 };
//    			itemDef.animateInventory = true;
//    			break;
//            case 16475:
//                itemDef.name = "@blu@Blue arsenic blade";
//                itemDef.modelID = 61241;
//                itemDef.maleEquip1 = 61244;
//                itemDef.femaleEquip1 = 61244;
//                ItemDef.copyMostDefs(itemDef, 13899);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16476:
//                itemDef.name = "@blu@Blue arsenic crossbow";
//                itemDef.modelID = 61245;
//                itemDef.maleEquip1 = 61248;
//                itemDef.femaleEquip1 = 61248;
//                ItemDef.copyMostDefs(itemDef, 13530);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16478:
//                itemDef.name = "@blu@Blue arsenic staff";
//                itemDef.modelID = 61249;
//                itemDef.maleEquip1 = 61250;
//                itemDef.femaleEquip1 = 61250;
//                ItemDef.copyMostDefs(itemDef, 1395);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16480:
//                itemDef.name = "@blu@Blue arsenic helmet";
//                itemDef.modelID = 61193;
//                itemDef.maleEquip1 = 61198;
//                itemDef.femaleEquip1 = 61198;
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                changeTexture(id, 40, 53);
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16484:
//                itemDef.name = "@blu@Blue arsenic body";
//                itemDef.modelID = 61199;
//                itemDef.maleEquip1 = 61203;
//                itemDef.femaleEquip1 = 61203;
//                ItemDef.copyMostDefs(itemDef, 1127);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                changeTexture(id, 40, 53);
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16485:
//                itemDef.name = "@blu@Blue arsenic legs";
//                itemDef.modelID = 61205;
//                itemDef.maleEquip1 = 61209;
//                itemDef.femaleEquip1 = 61209;
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//                changeTexture(id, 40, 53);
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16486:
//                itemDef.modelID = 61252;
//                itemDef.name = "@blu@Blue Arsenic Gloves";
//                itemDef.description = "Man this shet looks gud";
//                itemDef.maleEquip1 = 61251;
//                itemDef.femaleEquip1 = 61251;
//                itemDef.actions = new String[5];
//                itemDef.modelZoom = 1300;
//                itemDef.rotationY = 520;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 16524:
//                itemDef.name = "Almighty Rajin blade";
//                itemDef.modelID = 62655;
//                itemDef.maleEquip1 = 61451;
//                itemDef.femaleEquip1 = 61451;
//                ItemDef.copyMostDefs(itemDef, 13899);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 6638:
//            	itemDef.name = "@re1@Squeal of Fortune spin";
//            	itemDef.actions = new String[] { null, null, null, null, "Drop" };
//            	break;
//            case 14027:
//                itemDef.name = "@gre@Green arsenic blade";
//                itemDef.modelID = 61171;
//                itemDef.maleEquip1 = 61172;
//                itemDef.femaleEquip1 = 61172;
//                ItemDef.copyMostDefs(itemDef, 13899);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 14028:
//                itemDef.name = "@gre@Green arsenic crossbow";
//                itemDef.modelID = 61173;
//                itemDef.maleEquip1 = 61175;
//                itemDef.femaleEquip1 = 61175;
//                ItemDef.copyMostDefs(itemDef, 13530);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 14029:
//                itemDef.name = "@gre@Green arsenic staff";
//                itemDef.modelID = 61176;
//                itemDef.maleEquip1 = 61178;
//                itemDef.femaleEquip1 = 61178;
//                ItemDef.copyMostDefs(itemDef, 1395);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 14030:
//                itemDef.name = "@gre@Green arsenic helmet";
//                itemDef.modelID = 61193;
//                itemDef.maleEquip1 = 61198;
//                itemDef.femaleEquip1 = 61198;
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                changeTexture(id, 40, 58);
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 14031:
//                itemDef.name = "@gre@Green arsenic body";
//                itemDef.modelID = 61199;
//                itemDef.maleEquip1 = 61203;
//                itemDef.femaleEquip1 = 61203;
//                ItemDef.copyMostDefs(itemDef, 1127);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                changeTexture(id, 40, 58);
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 14032:
//                itemDef.name = "@gre@Green arsenic legs";
//                itemDef.modelID = 61205;
//                itemDef.maleEquip1 = 61209;
//                itemDef.femaleEquip1 = 61209;
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//                changeTexture(id, 40, 58);
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 16446:
//                itemDef.name = "Dreamflow Boots";
//                ItemDef.copyMostDefs(itemDef, 11733);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.modelID = 44644;
//                itemDef.maleEquip1 = 44644;
//                itemDef.femaleEquip1 = 44644;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16448:
//                itemDef.name = "Dreamflow Gloves";
//                ItemDef.copyMostDefs(itemDef, 2902);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.modelID = 44645;
//                itemDef.maleEquip1 = 44645;
//                itemDef.femaleEquip1 = 44645;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16449:
//                itemDef.name = "Dreamflow Cape";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.modelID = 44646;
//                itemDef.maleEquip1 = 44646;
//                itemDef.femaleEquip1 = 44646;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16450:
//                itemDef.name = "Dreamflow Sword";
//                itemDef.modelZoom = 1000;
//                itemDef.rotationX = 1713;
//                itemDef.rotationY = 217;
//                itemDef.modelID = 44647;
//                itemDef.maleEquip1 = 44647;
//                itemDef.femaleEquip1 = 44647;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 16451:
//                itemDef.name = "Dreamflow Offhand";
//                itemDef.modelZoom = 1104;
//                itemDef.rotationX = 357;
//                itemDef.rotationY = 235;
//    			itemDef.modelOffsetY = 26;
//      			itemDef.modelOffset1 = 9;
//                itemDef.modelID = 44648;
//                itemDef.maleEquip1 = 44648;
//                itemDef.femaleEquip1 = 44648;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 5243:
//                itemDef.name = "Investor Helmet";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.modelID = 44624;
//                itemDef.maleEquip1 = 44624;
//                itemDef.femaleEquip1 = 44624;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 5244:
//                itemDef.name = "Investor top";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.modelID = 44625;
//                itemDef.maleEquip1 = 44625;
//                itemDef.femaleEquip1 = 44625;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5245:
//                itemDef.name = "Investor legs";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.modelID = 44626;
//                itemDef.maleEquip1 = 44626;
//                itemDef.femaleEquip1 = 44626;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5246:
//                itemDef.name = "Investor boots";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.modelID = 44627;
//                itemDef.maleEquip1 = 44627;
//                itemDef.femaleEquip1 = 44627;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5247:
//                itemDef.name = "Investor Gloves";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.modelID = 44628;
//                itemDef.maleEquip1 = 44628;
//                itemDef.femaleEquip1 = 44628;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5249:
//                itemDef.name = "Investor Bow";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.modelID = 44629;
//                itemDef.maleEquip1 = 44629;
//                itemDef.femaleEquip1 = 44629;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5248:
//                itemDef.name = "Investor Auras";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.modelID = 44625;
//                itemDef.maleEquip1 = 44630;
//                itemDef.femaleEquip1 = 44630;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 5069:
//                itemDef.name = "Frozen Staff Tier I";
//                itemDef.modelID = 44426;
//                itemDef.modelZoom = 1000;
//                itemDef.maleEquip1 = 44426;
//                itemDef.femaleEquip1 = 44426;
//                itemDef.actions = new String[] { null, "Wear", "Dissolve", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5273:
//                itemDef.name = "Frozen Staff Tier II";
//                itemDef.modelID = 44426;
//                itemDef.maleEquip1 = 44426;
//                itemDef.modelZoom = 2000;
//                itemDef.femaleEquip1 = 44426;
//                itemDef.actions = new String[] { null, "Wear", "Dissolve", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5274:
//                itemDef.name = "Frozen Staff Tier III";
//                itemDef.modelID = 44426;
//                itemDef.maleEquip1 = 44426;
//                itemDef.modelZoom = 2000;
//                itemDef.femaleEquip1 = 44426;
//                itemDef.actions = new String[] { null, "Wear", "Dissolve", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 5121:
//                itemDef.name = "@yel@Electric Thumper";
//                itemDef.modelID = 44477;
//                itemDef.maleEquip1 = 44478;
//                itemDef.femaleEquip1 = 44478;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 3966:
//                itemDef.name = "Forgotten robetop";
//                itemDef.modelID = 44385;
//                itemDef.maleEquip1 = 44385;
//                itemDef.femaleEquip1 = 44385;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                itemDef.modelZoom = 1591;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 50;
//                break;
//            case 3967:
//                itemDef.name = "Forgotten robe bottoms";
//                itemDef.modelID = 44386;
//                itemDef.maleEquip1 = 44386;
//                itemDef.femaleEquip1 = 44386;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                itemDef.modelZoom = 1591;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 0;
//                break;
//            case 3968:
//                itemDef.name = "Mask of the Forgotten";
//                itemDef.modelID = 44387;
//                itemDef.maleEquip1 = 44387;
//                itemDef.femaleEquip1 = 44387;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                itemDef.modelZoom = 1157;
//                itemDef.rotationX = 565;
//                itemDef.rotationY = 496;
//    			itemDef.modelOffsetY = 0;
//                break;
//            case 3969:
//                itemDef.name = "Forgotten Gloves";
//                itemDef.modelID = 44388;
//                itemDef.maleEquip1 = 44388;
//                itemDef.femaleEquip1 = 44388;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                itemDef.modelZoom = 443;
//                itemDef.rotationX = 461;
//                itemDef.rotationY = 26;
//    			itemDef.modelOffsetY = 45;
//                break;
//            case 3970:
//                itemDef.name = "Forgotten Boots";
//                itemDef.modelID = 44389;
//                itemDef.maleEquip1 = 44389;
//                itemDef.femaleEquip1 = 44389;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                itemDef.modelZoom = 722;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 0;
//                break;
//            case 15659:
//                itemDef.modelID = 23320;
//                itemDef.name = "Toxic Platelegs";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 5;
//                itemDef.femaleEquip1 = 23321;
//                itemDef.maleEquip1 = 23321;
//                itemDef.description = "Toxic helmet";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 15660:
//                itemDef.modelID = 23332;
//                itemDef.name = "Chucky Doll";
//                ItemDef.copyMostDefs(itemDef, 4279);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//                itemDef.modelOffsetY = -50;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.femaleEquip1 = 23332;
//                itemDef.maleEquip1 = 23332;
//                itemDef.description = "Chucky Doll";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 16429:
//                /*  318 */       itemDef.modelID = 23339;
//                /*  319 */       itemDef.maleEquip1 = 23340;
//                itemDef.femaleEquip1 = 23340;
//                /*  320 */       itemDef.name = "Staff of Blood";
//                /*  321 */       itemDef.groundActions = new String[5];
//                /*  154 */       itemDef.groundActions[2] = "Take";
//                /*  155 */       itemDef.actions = new String[5];
//                /*  156 */       itemDef.actions[1] = "Wear";
//
//                itemDef.actions[4] = "Drop";
//                itemDef.rotationX = 0;
//                /*  330 */       itemDef.rotationY = 0;
//                /*  332 */       itemDef.modelOffsetX = 0;
//                /*  333 */       itemDef.modelOffsetY = 0;
//                break;
//            case 7806:
//                ItemDef.copyMostDefs(itemDef, 13899);
//                itemDef.modelID = 74803;
//                itemDef.maleEquip1 = 74804;
//                itemDef.femaleEquip1 = 74804;
//                itemDef.name = "Beginners Warhammer";
//                break;
//            case 13867:
//                itemDef.modelID = 74805;
//                itemDef.maleEquip1 = 74806;
//                itemDef.femaleEquip1 = 74806;
//                ItemDef.copyMostDefs(itemDef, 13899);
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[4] = "Drop";
//                itemDef.name = "Beginners Wand";
//                break;
//
//            case 15661:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//
//                itemDef.actions[4] = "Drop";
//                itemDef.modelID = 23333;
//                itemDef.name = "Beginner Boots";
//                itemDef.modelZoom = 900;
//                itemDef.rotationY = 165;
//                itemDef.rotationX = 99;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 0;
//                itemDef.maleEquip1 = 23333;
//                itemDef.femaleEquip1 = 23333;
//                itemDef.description = "Beginner Boots";
//                break;
//            case 15662:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//
//                itemDef.actions[4] = "Drop";
//                itemDef.modelID = 23334;
//                itemDef.modelZoom = 900;
//                itemDef.rotationY = 165;
//                itemDef.rotationX = 99;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 90;
//                itemDef.name = "Beginner Gloves";
//                itemDef.maleEquip1 = 23334;
//                itemDef.femaleEquip1 = 23334;
//                itemDef.description = "Beginner Gloves";
//                break;
//            case 15663:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[4] = "Drop";
//                itemDef.modelID = 61503;
//                itemDef.name = "Beginner Helm";
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.maleEquip1 = 61512;
//                itemDef.femaleEquip1 = 61512;
//                itemDef.description = "Beginner Helm";
//                break;
//            case 15664:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                ItemDef.copyMostDefs(itemDef, 1127);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions[4] = "Drop";
//                itemDef.modelID = 61514;
//                itemDef.name = "Beginner Body";
//                itemDef.maleEquip1 = 61515;
//                itemDef.femaleEquip1 = 61515;
//                itemDef.description = "Beginner Body";
//                break;
//            case 15665:
//
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[4] = "Drop";
//                itemDef.modelID = 61516;
//                itemDef.name = "Beginner Legs";
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.maleEquip1 = 61517;
//                itemDef.femaleEquip1 = 61517;
//                itemDef.description = "Beginner Legs";
//                break;
//            case 16428:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//
//                itemDef.actions[4] = "Drop";
//                itemDef.modelID = 23338;
//                itemDef.modelZoom = 1350;
//                itemDef.rotationY = 265;
//                itemDef.rotationX = 99;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 0;
//                itemDef.name = "Beginner Wings";
//                itemDef.maleEquip1 = 23338;
//                itemDef.femaleEquip1 = 23338;
//                itemDef.description = "Beginner Wings";
//                break;
//
//            case 13221:
//                itemDef.name = "Cane helmet+";
//                itemDef.modelID = 23156;
//                itemDef.femaleEquip1 = 23157;
//                itemDef.maleEquip1 = 23157;
//
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 13222:
//                itemDef.name = "Cane platebody+";
//                itemDef.modelID = 23158;
//                itemDef.femaleEquip1 = 23159;
//                itemDef.maleEquip1 = 23159;
//
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 13223:
//                itemDef.name = "Cane platelegs+";
//                itemDef.modelID = 23160;
//                itemDef.femaleEquip1 = 23161;
//                itemDef.maleEquip1 = 23161;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 13226:
//                ItemDef.copyModel(itemDef, 3974);
//                itemDef.name = "Sirenic Wings+";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.originalModelColors = new int[] { 59 };
//                itemDef.newModelColor = new int[] { 53};
//                break;
//            case 13224:
//                itemDef.name = "Sirenic legs+";
//                ItemDef.copyModel(itemDef, 18940);
//                itemDef.description = "Sirenic legs+";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 13250:
//                ItemDef.copyModel(itemDef, 18942);
//                itemDef.name = "Sirenic Full Helm+";
//                itemDef.description = "Sirenic Full Helm+";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 13225:
//                ItemDef.copyModel(itemDef, 18941);
//                itemDef.name = "Sirenic top+";
//                itemDef.description = "Sirenic top+";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 13251:
//                itemDef.modelID = 23898;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23899;
//                itemDef.femaleEquip1 = 23899;
//                itemDef.name = "Hercules helm+";
//                break;
//
//            case 13252:
//                itemDef.modelID = 23900;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23901;
//                itemDef.femaleEquip1 = 23901;
//                itemDef.name = "Hercules fighterbody+";
//                break;
//
//            case 13253:
//                itemDef.modelID = 23902;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23903;
//                itemDef.femaleEquip1 = 23903;
//                itemDef.name = "Hercules fighterlegs+";
//                break;
//
//
//            case 13254:
//                itemDef.modelID = 23904;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23905;
//                itemDef.femaleEquip1 = 23905;
//                itemDef.name = "Hercules Kiteshield+";
//                break;
//
//            case 13255:
//                itemDef.modelID = 23906;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23907;
//                itemDef.femaleEquip1 = 23907;
//                itemDef.name = "Hercules fightercape+";
//                break;
//
//            case 13260:
//                itemDef.modelID = 38557;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 38558;
//                itemDef.femaleEquip1 = 38558;
//                itemDef.name = "Hercules sword";
//                break;
//
//            case 13261:
//                itemDef.modelID = 23910;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23910;
//                itemDef.femaleEquip1 = 23910;
//                itemDef.name = "Hercules boots";
//                break;
//            case 13692:
//                itemDef.modelID = 23187;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.modelZoom = 800;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 = 23188;
//                itemDef.femaleEquip1 = 23188;
//                itemDef.name = "Blessed Hood+";
//                break;
//            case 13693:
//                itemDef.modelID = 23191;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.modelZoom = 900;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 = 23192;
//                itemDef.femaleEquip1 = 23192;
//                itemDef.name = "Blessed Platebody+";
//                break;
//
//            case 13694:
//                itemDef.modelID = 23341;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.modelZoom = 900;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.originalModelColors = new int[] { 40};
//                itemDef.newModelColor = new int[] { 71 };
//                itemDef.maleEquip1 = 23342;
//                itemDef.femaleEquip1 = 23342;
//                itemDef.name = "Blessed Kiteshield+";
//                break;
//
//            case 13695:
//                itemDef.modelID = 23189;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.modelZoom = 900;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 = 23190;
//                itemDef.femaleEquip1 = 23190;
//                itemDef.name = "Blessed Platelegs+";
//                break;
//
//
//            case 18940:
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//            case 18941:
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//            case 18942:
//                itemDef.actions[2] = "@or2@Salvage";
//                break;
//            case 19131:
//                itemDef.name = "Lightreaper mask";
//                itemDef.modelID = 100264;
//                itemDef.femaleEquip1 = 100265;
//                itemDef.maleEquip1 = 100265;
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 19132:
//                itemDef.name = "Lightreaper platebody";
//                itemDef.modelID = 100259;
//                itemDef.femaleEquip1 = 100260;
//                itemDef.maleEquip1 = 100260;
//                ItemDef.copyMostDefs(itemDef, 1127);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 19133:
//                itemDef.name = "Lightreaper platelegs";
//                itemDef.modelID = 100266;
//                itemDef.femaleEquip1 = 100267;
//                itemDef.maleEquip1 = 100267;
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 19134:
//                itemDef.name = "Royal Reaper's gauntlets";
//                itemDef.modelID = 23145;
//                itemDef.femaleEquip1 = 23146;
//                itemDef.maleEquip1 = 23146;
//                itemDef.editedModelColor = new int[] { 70 };
//                itemDef.newModelColor = new int[] {63 };
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 3648:
//                itemDef.name = "Mylos Helmet";
//                itemDef.modelID = 40034;
//                itemDef.maleEquip1 = 40033;
//                itemDef.femaleEquip1 = 40033;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3649:
//                itemDef.name = "Mylos Platebody";
//                itemDef.modelID = 40036;
//                itemDef.maleEquip1 = 40035;
//                itemDef.femaleEquip1 = 40035;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3650:
//                itemDef.name = "Mylos Platelegs";
//                itemDef.modelID = 40038;
//                itemDef.maleEquip1 = 40037;
//                itemDef.femaleEquip1 = 40037;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3651:
//                itemDef.name = "Mylos War Axe";
//                itemDef.modelID = 40040;
//                itemDef.maleEquip1 = 40039;
//                itemDef.femaleEquip1 = 40039;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3652:
//                itemDef.name = "Mylos gauntlents";
//                itemDef.modelID = 40042;
//                itemDef.maleEquip1 = 40041;
//                itemDef.femaleEquip1 = 40041;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3659:
//                itemDef.name = "Mylos Boots";
//                itemDef.modelID = 40043;
//                itemDef.maleEquip1 = 40043;
//                itemDef.femaleEquip1 = 40043;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//
//
//            case 5112:
//                itemDef.name = "Angelic Helmet";
//                itemDef.modelID = 40070;
//                itemDef.maleEquip1 = 40070;
//                itemDef.femaleEquip1 = 40070;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 4691:
//                ItemDef.copyModel(itemDef, 10874);
//                itemDef.rotationY = 232;
//                itemDef.name = "Colorful Tokens";
//                break;
//
//            case 5113:
//                itemDef.name = "Angelic Legs";
//                itemDef.modelID = 40071;
//                itemDef.maleEquip1 = 40072;
//                itemDef.femaleEquip1 = 40072;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 8654:
//                ItemDef.copyMostDefs(itemDef, 13899);
//                itemDef.modelID = 40088;
//                itemDef.maleEquip1 = 40089;
//                itemDef.femaleEquip1 = 40089;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "Imbued Sword";
//                break;
//
//            case 8655:
//                ItemDef.copyMostDefs(itemDef, 13899);
//                itemDef.modelID = 40090;
//                itemDef.maleEquip1 = 40091;
//                itemDef.femaleEquip1 = 40091;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "Imbued Bow";
//                break;
//
//
//            case 6183:
//                itemDef.actions = new String[] {"Open", null, "Open-all", null, null};
//                itemDef.name = "Mystery box";
//                break;
//
//
//            case 8656:
//                ItemDef.copyMostDefs(itemDef, 13899);
//                itemDef.modelID = 40092;
//                itemDef.maleEquip1 = 40093;
//                itemDef.femaleEquip1 = 40093;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "Imbued Staff";
//                break;
//
//
//            case 18911:
//                ItemDef.copyMostDefs(itemDef, 13899);
//                itemDef.modelID = 21341;
//                itemDef.maleEquip1 = 21342;
//                itemDef.femaleEquip1 = 21342;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "Saturated Sword";
//                changeTexture(id, 40, 51);
//                break;
//
//            case 18912:
//                ItemDef.copyMostDefs(itemDef, 13899);
//                itemDef.modelID = 21343;
//                itemDef.maleEquip1 = 21344;
//                itemDef.femaleEquip1 = 21344;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "Saturated Bow";
//                changeTexture(id, 40, 51);
//                break;
//
//            case 14581:
//                ItemDef.copyMostDefs(itemDef, 13899);
//                itemDef.modelID = 21345;
//                itemDef.maleEquip1 = 21346;
//                itemDef.femaleEquip1 = 21346;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "Saturated Staff";
//                changeTexture(id, 40, 51);
//                break;
//
//
//
//
//
//
//
//            case 5114:
//                itemDef.name = "Angelic Platebody";
//                itemDef.modelID = 40073;
//                itemDef.maleEquip1 = 40074;
//                itemDef.femaleEquip1 = 40074;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 5115:
//                itemDef.name = "Yoshi Bow";
//                itemDef.modelID = 40077;
//                itemDef.maleEquip1 = 40076;
//                itemDef.femaleEquip1 = 40076;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//
//
//
//            case 4056:
//                itemDef.modelID = 40107;
//                itemDef.maleEquip1 = 40108;
//                itemDef.femaleEquip1 = 40108;
//                itemDef.actions = new String[] {null, "Wear", "@or2@Salvage", null, null};
//                itemDef.name = "Misery Helmet";
//                break;
//
//            case 4057:
//                itemDef.modelID = 40109;
//                itemDef.maleEquip1 = 40110;
//                itemDef.femaleEquip1 = 40110;
//                itemDef.actions = new String[] {null, "Wear", "@or2@Salvage", null, null};
//                itemDef.name = "Misery Platebody";
//                break;
//
//
//            case 4058:
//                itemDef.modelID = 40111;
//                itemDef.maleEquip1 = 40112;
//                itemDef.femaleEquip1 = 40112;
//                itemDef.actions = new String[] {null, "Wear", "@or2@Salvage", null, null};
//                itemDef.name = "Misery Platelegs";
//                break;
//
//
//            case 4059:
//                itemDef.modelID = 40113;
//                itemDef.maleEquip1 = 40114;
//                itemDef.femaleEquip1 = 40114;
//                itemDef.actions = new String[] {null, "Wear", "@or2@Salvage", null, null};
//                itemDef.name = "Blade of Misery";
//                break;
//
//
//            case 4060:
//                itemDef.modelID = 40115;
//                itemDef.maleEquip1 = 40116;
//                itemDef.femaleEquip1 = 40116;
//                itemDef.modelZoom = 1800;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "@cya@Imbued Platelegs@bla@(@cya@Melee@bla@)";
//                break;
//
//            case 4061:
//                itemDef.modelID = 40117;
//                itemDef.maleEquip1 = 40118;
//                itemDef.femaleEquip1 = 40118;
//                itemDef.modelZoom = 1600;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "@cya@Imbued Platebody@bla@(@cya@Melee@bla@)";
//                break;
//
//
//            case 4062:
//                itemDef.modelID = 40120;
//                itemDef.maleEquip1 = 40120;
//                itemDef.femaleEquip1 = 40120;
//                itemDef.modelZoom = 1800;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "@cya@Imbued Boots@bla@(@cya@Melee@bla@)";
//                break;
//
//
//            case 4063:
//                itemDef.modelID = 40121;
//                itemDef.maleEquip1 = 40122;
//                itemDef.modelZoom = 1800;
//                itemDef.femaleEquip1 = 40122;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "@cya@Imbued Platelegs@bla@(@cya@Range@bla@)";
//                break;
//
//            case 4064:
//                itemDef.modelID = 40123;
//                itemDef.maleEquip1 = 40124;
//                itemDef.modelZoom = 1800;
//                itemDef.femaleEquip1 = 40124;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "@cya@Imbued Platebody@bla@(@cya@Range@bla@)";
//                break;
//
//            case 4065:
//                itemDef.modelID = 40125;
//                itemDef.maleEquip1 = 40126;
//                itemDef.modelZoom = 1800;
//                itemDef.femaleEquip1 = 40126;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "@cya@Imbued Boots@bla@(@cya@Range@bla@)";
//                break;
//
//
//
//            case 4067:
//                itemDef.modelID = 40127;
//                itemDef.maleEquip1 = 40128;
//                itemDef.modelZoom = 1800;
//                itemDef.femaleEquip1 = 40128;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "@cya@Imbued Robe bottoms@bla@(@cya@Magic@bla@)";
//                break;
//
//            case 4085:
//                itemDef.modelID = 40129;
//                itemDef.maleEquip1 = 40130;
//                itemDef.modelZoom = 1800;
//                itemDef.femaleEquip1 = 40130;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "@cya@Imbued Robe top@bla@(@cya@Magic@bla@)";
//                break;
//
//            case 4555:
//                itemDef.modelID = 40131;
//                itemDef.modelZoom = 1800;
//                itemDef.maleEquip1 = 40132;
//                itemDef.femaleEquip1 = 40132;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, null};
//                itemDef.name = "@cya@Imbued boots@bla@(@cya@Magic@bla@)";
//                break;
//
//
//
//            case 16545:
//                itemDef.modelID = 40133;
//                itemDef.maleEquip1 = 40134;
//                itemDef.femaleEquip1 = 40134;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Dedi Wizard hat";
//                break;
//
//            case 13998:
//                ItemDef.copyModel(itemDef, 85);
//                itemDef.actions = new String[5];
//                itemDef.actions[2] = "Open";
//                itemDef.animateInventory = true;
//                itemDef.name = "Sephiroths Chest Key";
//                break;
//
//            case 16546:
//                itemDef.modelID = 40135;
//                itemDef.maleEquip1 = 40136;
//                itemDef.femaleEquip1 = 40136;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Dedi Wizard Robetop";
//                break;
//
//
//            case 16548:
//                itemDef.modelID = 40137;
//                itemDef.maleEquip1 = 40138;
//                itemDef.femaleEquip1 = 40138;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Dedi Wizard robelegs";
//                break;
//
//            case 16549:
//                itemDef.modelID = 40139;
//                itemDef.maleEquip1 = 40140;
//                itemDef.femaleEquip1 = 40140;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Royal legs";
//                break;
//
//            case 16550:
//                itemDef.modelID = 40141;
//                itemDef.maleEquip1 = 40142;
//                itemDef.femaleEquip1 = 40142;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Royal Sword";
//                break;
//
//            case 16551:
//                itemDef.modelID = 40143;
//                itemDef.maleEquip1 = 40144;
//                itemDef.femaleEquip1 = 40144;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Royal Platebody";
//                break;
//
//            case 16553:
//                itemDef.modelID = 40145;
//                itemDef.maleEquip1 = 40145;
//                itemDef.femaleEquip1 = 40145;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Royal Boots";
//                break;
//
//            case 16556:
//                itemDef.modelID = 40146;
//                itemDef.maleEquip1 = 40147;
//                itemDef.femaleEquip1 = 40147;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Royal Gloves";
//                break;
//
//            case 16558:
//                itemDef.modelID = 40148;
//                itemDef.maleEquip1 = 40149;
//                itemDef.femaleEquip1 = 40149;
//                itemDef.actions = new String[] {null, "Wear", null, null, null};
//                itemDef.name = "Royal Helmet";
//                break;
//
//
//            case 5107:
//                itemDef.name = "Youtubers Hood";
//                itemDef.modelID = 40059;
//                itemDef.maleEquip1 = 40060;
//                itemDef.femaleEquip1 = 40060;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3945:
//                itemDef.name = "Resilience Boots";
//                itemDef.modelID = 40102;
//                itemDef.maleEquip1 = 40102;
//                itemDef.femaleEquip1 = 40102;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3946:
//                itemDef.name = "Resilience Blade(MH)";
//                itemDef.modelID = 40103;
//                itemDef.maleEquip1 = 40104;
//                itemDef.femaleEquip1 = 40104;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3947:
//                itemDef.name = "Resilience Blade(OH)";
//                itemDef.modelID = 40103;
//                itemDef.maleEquip1 = 40105;
//                itemDef.femaleEquip1 = 40105;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3948:
//                itemDef.name = "Resilience Backblade";
//                itemDef.modelID = 40106;
//                itemDef.maleEquip1 = 40106;
//                itemDef.femaleEquip1 = 40106;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//
//            case 3944:
//                itemDef.name = "Resilience Gloves";
//                itemDef.modelID = 40100;
//                itemDef.maleEquip1 = 40101;
//                itemDef.femaleEquip1 = 40101;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3939:
//                itemDef.name = "Resilience Legs";
//                itemDef.modelID = 40098;
//                itemDef.maleEquip1 = 40099;
//                itemDef.femaleEquip1 = 40099;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3938:
//                itemDef.name = "Resilience Body";
//                itemDef.modelID = 40096;
//                itemDef.maleEquip1 = 40097;
//                itemDef.femaleEquip1 = 40097;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3937:
//                itemDef.name = "Resilience Hood";
//                itemDef.modelID = 40094;
//                itemDef.maleEquip1 = 40095;
//                itemDef.femaleEquip1 = 40095;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 5108:
//                itemDef.name = "Youtubers bell";
//                itemDef.modelID = 40061;
//                itemDef.maleEquip1 = 40062;
//                itemDef.femaleEquip1 = 40062;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 5109:
//                itemDef.name = "Youtubers Robe bottoms";
//                itemDef.modelID = 40063;
//                itemDef.maleEquip1 = 40064;
//                itemDef.femaleEquip1 = 40064;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 5110:
//                itemDef.name = "Youtubers Robe top";
//                itemDef.modelID = 40065;
//                itemDef.maleEquip1 = 40066;
//                itemDef.femaleEquip1 = 40066;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 5111:
//                itemDef.name = "Youtubers backsack";
//                itemDef.modelID = 40067;
//                itemDef.maleEquip1 = 40068;
//                itemDef.femaleEquip1 = 40058;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
////bloodmoney model =40050
//
//
//
//
//
//
//
//            case 3918:
//                itemDef.name = "Fantasy Gloves(10%Dr)";
//                itemDef.modelID = 62739;
//                itemDef.maleEquip1 = 40053;
//                ItemDef.copyMostDefs(itemDef, 7461);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.femaleEquip1 = 40053;
//                itemDef.animateInventory = true;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 17842:
//                itemDef.name = "Bloodshed gloves";
//                ItemDef.copyMostDefs(itemDef, 7461);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.modelID = 62739;
//                itemDef.maleEquip1 = 62726;
//                itemDef.femaleEquip1 = 62726;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Buff", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 17843:
//                itemDef.name = "OP Bloody gloves@whi@+";
//                ItemDef.copyModel(itemDef, 7461);
//                itemDef.actions = new String[] { null, "Wear", "@or2@Buff", null, "Drop" };
//                itemDef.stackable = false;
//                itemDef.animateInventory = true;
//                break;
//            case 17844:
//                itemDef.name = "OP Bloody gloves@whi@++";
//                ItemDef.copyModel(itemDef, 7461);
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                itemDef.animateInventory = true;
//                break;
//
//            case 6659:
//                itemDef.name = "Gluttony Helmet";
//                itemDef.modelID = 40170;
//                itemDef.maleEquip1 = 40171;
//                itemDef.femaleEquip1 = 40171;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 6783:
//                itemDef.name = "Gluttony Platebody";
//                itemDef.modelID = 40172;
//                itemDef.maleEquip1 = 40173;
//                itemDef.femaleEquip1 = 40173;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 6784:
//                itemDef.name = "Gluttony Platelegs";
//                itemDef.modelID = 40174;
//                itemDef.maleEquip1 = 40175;
//                itemDef.femaleEquip1 = 40175;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 6785:
//                itemDef.name = "Gluttony Gloves";
//                itemDef.modelID = 40176;
//                itemDef.maleEquip1 = 40177;
//                itemDef.femaleEquip1 = 40177;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 6786:
//                itemDef.name = "Gluttony Boots";
//                itemDef.modelID = 40178;
//                itemDef.maleEquip1 = 40178;
//                itemDef.femaleEquip1 = 40178;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//
//            case 6927:
//                itemDef.name = "Immoral Helmet";
//                itemDef.modelID = 40179;
//                itemDef.maleEquip1 = 40180;
//                itemDef.femaleEquip1 = 40180;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 6928:
//                itemDef.name = "Immoral Platebody";
//                itemDef.modelID = 40181;
//                itemDef.maleEquip1 = 40182;
//                itemDef.femaleEquip1 = 40182;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 6929:
//                itemDef.name = "Immoral Platelegs";
//                itemDef.modelID = 40183;
//                itemDef.maleEquip1 = 40184;
//                itemDef.femaleEquip1 = 40184;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 6930:
//                itemDef.name = "Immoral Longsword";
//                itemDef.modelID = 40185;
//                itemDef.maleEquip1 = 40186;
//                itemDef.femaleEquip1 = 40186;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 6931:
//                itemDef.name = "Immoral Shield";
//                itemDef.modelID = 40188;
//                itemDef.maleEquip1 = 40189;
//                itemDef.femaleEquip1 = 40189;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//
//            case 17849:
//                itemDef.modelZoom = 1200;
//                itemDef.name = "@tox@Dual Toxic Pistols";
//                itemDef.modelID = 62744;
//                itemDef.maleEquip1 = 62748;
//                itemDef.femaleEquip1 = 62748;
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.stackable = false;
//                break;
//
//            case 16540:
//                itemDef.modelZoom = 1200;
//                itemDef.name = "@tox@Dual Toxic Pistols@or2@+";
//                itemDef.modelID = 62744;
//                itemDef.maleEquip1 = 62748;
//                itemDef.femaleEquip1 = 62748;
//                itemDef.actions = new String[] { null, "Wear", "@or2@Salvage", null, "Drop" };
//                itemDef.stackable = false;
//                break;
//            case 3919:
//                itemDef.name = "Demi Boots";
//                itemDef.modelID = 40054;
//                itemDef.maleEquip1 = 40054;
//                itemDef.femaleEquip1 = 40054;
//                itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
//                itemDef.stackable = false;
//                break;
//
//            case 3920:
//                itemDef.name = "@red@Owner staff";
//                itemDef.modelZoom = 2000;
//                ItemDef.copyModel(itemDef, 17009);
//                itemDef.modelID = 40055;
//                itemDef.maleEquip1 = 40056;
//                itemDef.femaleEquip1 = 40056;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
//                itemDef.stackable = false;
//                break;
//
//            case 8031:
//                itemDef.name = "@red@Q's Owner staff";
//                itemDef.modelZoom = 2000;
//                ItemDef.copyModel(itemDef, 17009);
//                itemDef.modelID = 40055;
//                itemDef.maleEquip1 = 40056;
//                itemDef.femaleEquip1 = 40056;
//                itemDef.actions = new String[] {null, "Wear", "Operate", null, "Drop"};
//                itemDef.stackable = false;
//                break;
//
//
//
//
//            case 19135:
//                itemDef.name = "Royal Reaper's  boots";
//                itemDef.modelID = 23144;
//                itemDef.femaleEquip1 = 23144;
//                itemDef.maleEquip1 = 23144;
//                itemDef.editedModelColor = new int[] { 70 };
//                itemDef.newModelColor = new int[] {63 };
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//
//                itemDef.actions[4] = "Drop";
//                break;
//            case 19136:
//                itemDef.name = "Royal Reaper's drape";
//                itemDef.modelID = 23143;
//                itemDef.femaleEquip1 = 23142;
//                itemDef.maleEquip1 = 23142;
//                itemDef.editedModelColor = new int[] { 70 };
//                itemDef.newModelColor = new int[] {63 };
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 3647:
//                itemDef.name = "Pet Killer chucky";
//                itemDef.modelID = 40032;
//                itemDef.modelZoom = 2750;
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//
//            case 18411:
//                itemDef.name = "Dark Charizard Pet";
//                itemDef.modelID = 65258;
//                itemDef.modelZoom = 2750;
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//    			itemDef.actions = new String[] { null, null, "Summon", "Salvage", "Drop" };
//                break;
//
//            case 11862:
//                itemDef.name = "@whi@Akasha mage set";
//                break;
//
//
//            case 18412:
//                itemDef.name = "Yoshi Pet";
//                itemDef.modelID = 44359;
//                itemDef.modelZoom = 2500;
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", "@or2@Salvage", "Drop" };
//                break;
//
//            case 18413:
//                itemDef.name = "Akuna Guardian";
//                itemDef.modelID = 65331;
//                itemDef.modelZoom = 2500;
//                itemDef.rotationY = 340;
//                itemDef.rotationX = 0;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", "@or2@Salvage", "Drop" };
//                break;
//
//
//            case 18904:
//                itemDef.name = "Iron Partyhat";
//                break;
//
//
//            case 7011:
//                itemDef.modelID = 65319;
//                ItemDef.copyMostDefs(itemDef, 18904);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Test Partyhat";
//                break;
//
//
//
//            case 16566:
//                itemDef.name = "@red@Pokeball";
//                itemDef.modelID = 65339;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 16711);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.modelZoom = 720;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions[0] = "Open";
//                itemDef.actions[1] = null;
//                itemDef.actions[2] = null;
//                itemDef.actions[3] = null;
//                break;
//
//
//
//            case 16509:
//                itemDef.name = "Pet Mew";
//                itemDef.modelID = 60977;
//                itemDef.modelZoom = 3000;
//                itemDef.rotationY = 0;
//                itemDef.rotationX = 0;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//            case 7034:
//                itemDef.name = "Shenron";
//                itemDef.modelID = 60875;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//            case 21059:
//                itemDef.name = "@red@Blood Shenron";
//                itemDef.modelID = 48945;
//                ItemDef.copyMostDefs(itemDef, 7034);
//                changeTexture(id, 40, 83);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//                itemDef.animateInventory = true;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//
//            case 14555:
//                itemDef.name = "Bye's Custom Pet";
//                itemDef.modelID = 49027;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//            case 7014:
//                itemDef.name = "SebZero's Custom Pet";
//                itemDef.modelID = 74516;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//            case 7040:
//                itemDef.name = "Zulrah snakeling";
//                itemDef.modelID = 14407;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//
//            case 7036:
//                itemDef.name = "Datboii Pet";
//                itemDef.modelID = 60890;
//                itemDef.groundActions = new String[] { null, null, "Take", null, null };
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//            case 3642:
//                itemDef.name = "Demonic Glaive";
//                itemDef.modelID = 40030;
//                itemDef.maleEquip1 = 40029;
//                itemDef.femaleEquip1 = 40029;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.stackable = false;
//                break;
//
//            case 3641:
//                itemDef.name = "@yel@Solace Glaive";
//                itemDef.modelID = 23964;
//                itemDef.maleEquip1 = 23965;
//                itemDef.femaleEquip1 = 23965;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.stackable = false;
//                itemDef.animateInventory = true;
//                itemDef.originalModelColors = new int[] { 60, 62 };
//                itemDef.newModelColor = new int[] { 56, 63};
//                break;
//
//            case 10350:
//        		itemDef.originalModelColors = new int[] { 206197, 193185,};
//        		itemDef.newModelColor = new int[] { 6153135 };
//                break;
//
//            case 19123:
//                itemDef.name = "Thermo Sword";
//                ItemDef Reaper = ItemDef.forID(1305);
//                itemDef.modelID = 23153;
//                itemDef.femaleEquip1 = 23154;
//                itemDef.maleEquip1 = 23154;
//                itemDef.modelOffset1 = Reaper.modelOffset1;
//                itemDef.modelOffsetX = Reaper.modelOffsetX;
//                itemDef.modelOffsetY = Reaper.modelOffsetY;
//                itemDef.modelZoom = Reaper.modelZoom;
//                itemDef.rotationX = Reaper.rotationX;
//                itemDef.rotationY = Reaper.rotationY;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//
//                itemDef.actions[4] = "Drop";
//                itemDef.editedModelColor = new int[] { 70 };
//                itemDef.newModelColor = new int[] {62 };
//                break;
//
//            case 932:
//                itemDef.name = "Bluefire UBER Sword";
//                ItemDef Reaper1 = ItemDef.forID(1305);
//                itemDef.modelID = 23153;
//                itemDef.femaleEquip1 = 23154;
//                itemDef.maleEquip1 = 23154;
//                itemDef.modelOffset1 = Reaper1.modelOffset1;
//                itemDef.modelOffsetX = Reaper1.modelOffsetX;
//                itemDef.modelOffsetY = Reaper1.modelOffsetY;
//                itemDef.modelZoom = Reaper1.modelZoom;
//                itemDef.rotationX = Reaper1.rotationX;
//                itemDef.rotationY = Reaper1.rotationY;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wear";
//
//                itemDef.actions[4] = "Drop";
//                changeTexture(id, 70, 71);
//                break;
//
//            case 17890:
//                itemDef.modelID = 23443;
//                itemDef.name = "Deluxe Stoner Pants";
//                itemDef.femaleEquip1 = 23444;
//                itemDef.maleEquip1 = 23444;
//                itemDef.description = "check the pockets!";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 11142:
//                itemDef.modelID = 40266;
//                itemDef.name = "Phoenix DDoS Protector";
//                itemDef.femaleEquip1 = 40267;
//                itemDef.maleEquip1 = 40267;
//                itemDef.description = "Hopefully he protects us against future Ddos attacks!";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 17891:
//                itemDef.modelID = 23445;
//                itemDef.name = "Deluxe Stoner Hat";
//                itemDef.femaleEquip1 = 23446;
//                itemDef.maleEquip1 = 23446;
//                itemDef.description = "cool beanie!";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 17892:
//                itemDef.modelID = 23447;
//                itemDef.name = "Deluxe Stoner Shirt";
//                itemDef.femaleEquip1 = 23448;
//                itemDef.maleEquip1 = 23448;
//                itemDef.description = "Kingdoms favorite shirt";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 8001:
//                itemDef.name = "Corgi Crossbow";
//                itemDef.modelID = 64495;
//                itemDef.maleEquip1 = 64496;
//                itemDef.femaleEquip1 = 64496;
//                itemDef.modelZoom = 1700;
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[4] = "Drop";
//                itemDef.stackable = false;
//                break;
//
//
//            case 17893:
//                itemDef.modelID = 23449;
//                itemDef.name = "Deluxe Stoner Gloves";
//                itemDef.femaleEquip1 = 23450;
//                itemDef.maleEquip1 = 23450;
//                itemDef.description = "I should try rolling a blunt with these on";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//            case 17894:
//                itemDef.modelID = 23451;
//                itemDef.name = "Deluxe Stoner Boots";
//                itemDef.femaleEquip1 = 23452;
//                itemDef.maleEquip1 = 23452;
//                itemDef.description = "pair of stoner boots";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 6191:
//                itemDef.modelID = 23441;
//                itemDef.name = "Unpacked Bong";
//                itemDef.femaleEquip1 = 23442;
//                itemDef.maleEquip1 = 23442;
//                itemDef.rotationY = 165;
//                itemDef.rotationX = 169;
//                itemDef.modelZoom = 650;
//                itemDef.description = "its a stoner bong, save it in ur inventory";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "take";
//                itemDef.actions = new String[5];
//                itemDef.actions[0] = "Fill";
//                itemDef.actions[4] = "Drop";
//                break;
//
//
//            case 14044:
//                itemDef.femaleEquip1 = 11180;
//                itemDef.maleEquip1 = 11180;
//                break;
//
//            case 14046:
//                itemDef.femaleEquip1 = 11192;
//                itemDef.maleEquip1 = 11192;
//                break;
//            case 8451:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "Upgrade";
//                itemDef.modelID = 96283;
//                itemDef.modelZoom = 1000;
//                itemDef.rotationY = 100;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 = 96284;
//                itemDef.femaleEquip1 = 96284;
//                itemDef.name = "@blu@FinalShadow Helmet";
//                break;
//
//
//            case 8452:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "Upgrade";
//                itemDef.modelID = 96274;
//                itemDef.modelZoom = 1500;
//                itemDef.rotationY = 500;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 = 96275;
//                itemDef.femaleEquip1 = 96275;
//                itemDef.name = "@blu@FinalShadow PlateBody";
//                break;
//
//            case 8453:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "Upgrade";
//                itemDef.modelID = 96276;
//                itemDef.modelZoom = 1500;
//                itemDef.rotationY = 500;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 = 96277;
//                itemDef.femaleEquip1 = 96277;
//                itemDef.name = "@blu@FinalShadow Legs";
//                break;
//
//            case 8454:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "Upgrade";
//                itemDef.modelID = 96280;
//                itemDef.modelZoom = 1500;
//                itemDef.rotationY = 500;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 = 96280;
//                itemDef.femaleEquip1 = 96280;
//                itemDef.name = "@blu@FinalShadow Boots";
//                break;
//
//            case 8455:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "Upgrade";
//                itemDef.modelID = 96278;
//                itemDef.modelZoom = 1500;
//                itemDef.rotationY = 500;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 = 96279;
//                itemDef.femaleEquip1 = 96279;
//                itemDef.name = "@blu@FinalShadow Gloves";
//                break;
//
//
//            case 8456:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97335;
//                itemDef.maleEquip1 = 97335;
//                itemDef.femaleEquip1 = 97335;
//                itemDef.modelZoom = 900;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 80;
//                itemDef.name = "@whi@Yugi Skeleton Helmet";
//                break;
//
//
//            case 8457:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97336;
//                itemDef.maleEquip1 = 97336;
//                itemDef.femaleEquip1 = 97336;
//                itemDef.modelZoom = 861;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 50;
//                itemDef.name = "@whi@Yugi Skeleton Body";
//                break;
//
//
//
//            case 8458:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97337;
//                itemDef.maleEquip1 = 97337;
//                itemDef.femaleEquip1 = 97337;
//                itemDef.modelZoom = 861;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 0;
//                itemDef.name = "@whi@Yugi Skeleton Legs";
//                break;
//
//            case 8459:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97338;
//                itemDef.maleEquip1 = 97338;
//                itemDef.femaleEquip1 = 97338;
//                itemDef.modelZoom = 1123;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 240;
//    			itemDef.modelOffsetY = -100;
//                itemDef.name = "@whi@Yugi Skeleton Boots";
//                break;
//
//
//            case 8460:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97339;
//                itemDef.maleEquip1 = 97339;
//                itemDef.femaleEquip1 = 97339;
//                itemDef.modelZoom = 513;
//                itemDef.rotationX = 409;
//                itemDef.rotationY = 0;
//    			itemDef.modelOffsetY = 40;
//                itemDef.name = "@whi@Yugi Skeleton Gloves";
//                break;
//
//
//            case 8461:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97344;
//                itemDef.maleEquip1 = 97344;
//                itemDef.femaleEquip1 = 97344;
//                itemDef.modelZoom = 617;
//                itemDef.rotationX = 339;
//                itemDef.rotationY = 61;
//    			itemDef.modelOffsetX = 5;
//    			itemDef.modelOffsetY = 0;
//                itemDef.name = "@whi@Nike court visions";
//                break;
//
//            case 8463:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97351;
//                itemDef.maleEquip1 = 97351;
//                itemDef.femaleEquip1 = 97351;
//                itemDef.name = "@yel@Golden Casket aura";
//                break;
//
//            case 8464:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97352;
//                itemDef.maleEquip1 = 97352;
//                itemDef.femaleEquip1 = 97352;
//                itemDef.name = "@whi@Obito Uchiha  aura T1";
//                break;
//
//            case 8465:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97353;
//                itemDef.maleEquip1 = 97353;
//                itemDef.femaleEquip1 = 97353;
//                itemDef.name = "@whi@Obito Uchiha  aura T2";
//                break;
//
//            case 8466:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97354;
//                itemDef.maleEquip1 = 97354;
//                itemDef.femaleEquip1 = 97354;
//                itemDef.name = "@whi@Obito Uchiha  aura T3";
//                break;
//
//            case 8467:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97355;
//                itemDef.maleEquip1 = 97355;
//                itemDef.femaleEquip1 = 97355;
//                itemDef.name = "@whi@Obito Uchiha  aura T4";
//                break;
//
//            case 8468:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97356;
//                itemDef.maleEquip1 = 97356;
//                itemDef.femaleEquip1 = 97356;
//                itemDef.name = "@whi@Obito Uchiha  aura T5";
//                break;
//
//
//            case 8469:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97357;
//                itemDef.maleEquip1 = 97358;
//                itemDef.femaleEquip1 = 97358;
//                itemDef.name = "@whi@Obito Uchiha Helmet";
//                break;
//
//            case 8470:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97359;
//                itemDef.maleEquip1 = 97360;
//                itemDef.femaleEquip1 = 97360;
//                itemDef.name = "@whi@Obito Uchiha Body";
//                break;
//
//
//            case 8471:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97361;
//                itemDef.maleEquip1 = 97362;
//                itemDef.femaleEquip1 = 97362;
//                itemDef.name = "@whi@Obito Uchiha Legs";
//                break;
//
//
//            case 8472:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97363;
//                itemDef.maleEquip1 = 97363;
//                itemDef.femaleEquip1 = 97363;
//                itemDef.name = "@whi@Obito Uchiha Boots";
//                break;
//
//
//            case 8473:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97364;
//                itemDef.maleEquip1 = 97364;
//                itemDef.femaleEquip1 = 97364;
//                itemDef.name = "@whi@Obito Uchiha Gloves";
//                break;
//
//
//
//            case 8474:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97365;
//                itemDef.maleEquip1 = 97366;
//                itemDef.femaleEquip1 = 97366;
//                itemDef.name = "@whi@Obito Uchiha Staff";
//                break;
//
//            case 8475:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97367;
//                itemDef.maleEquip1 = 97368;
//                itemDef.femaleEquip1 = 97368;
//                itemDef.name = "@whi@Obito Uchiha Dagger";
//                break;
//
//            case 8476:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.modelID = 97369;
//                itemDef.maleEquip1 = 97370;
//                itemDef.femaleEquip1 = 97370;
//                itemDef.name = "@whi@Diablo Helmet";
//                break;
//
//
//            case 8477:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.modelID = 97371;
//                itemDef.maleEquip1 = 97372;
//                itemDef.femaleEquip1 = 97372;
//                itemDef.name = "@whi@Diablo Platebody";
//                break;
//
//
//            case 8478:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.modelID = 97373;
//                itemDef.maleEquip1 = 97374;
//                itemDef.femaleEquip1 = 97374;
//                itemDef.name = "@whi@Diablo Platelegs";
//                break;
//
//            case 8479:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.modelID = 97375;
//                itemDef.maleEquip1 = 97375;
//                itemDef.femaleEquip1 = 97375;
//                itemDef.name = "@whi@Diablo Boots";
//                break;
//
//
//            case 8480:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.modelID = 97376;
//                itemDef.maleEquip1 = 97377;
//                itemDef.femaleEquip1 = 97377;
//                itemDef.name = "@whi@Diablo Gloves";
//                break;
//
//            case 8481:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.modelID = 97378;
//                itemDef.maleEquip1 = 97379;
//                itemDef.femaleEquip1 = 97379;
//                itemDef.name = "@whi@Diablo Wings";
//                break;
//
//
//            case 8482:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97387;
//                itemDef.maleEquip1 = 97387;
//                itemDef.femaleEquip1 = 97387;
//                itemDef.modelZoom = 748;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 340;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = -100;
//                itemDef.name = "@whi@Uru Isiha Helmet";
//                break;
//
//            case 8483:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97388;
//                itemDef.maleEquip1 = 97388;
//                itemDef.femaleEquip1 = 97388;
//                itemDef.modelZoom = 1348;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 50;
//                itemDef.name = "@whi@Uru Isiha Body";
//                break;
//
//            case 8484:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97389;
//                itemDef.maleEquip1 = 97389;
//                itemDef.femaleEquip1 = 97389;
//                itemDef.modelZoom = 1348;
//                itemDef.rotationX = 0;
//                itemDef.rotationY = 0;
//                itemDef.modelOffsetX = 0;
//                itemDef.modelOffsetY = 30;
//                itemDef.name = "@whi@Uru Isiha Legs";
//                break;
//
//
//            case 8485:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97390;
//                itemDef.maleEquip1 = 97390;
//                itemDef.femaleEquip1 = 97390;
//                itemDef.modelZoom = 704;
//                itemDef.rotationX = 304;
//                itemDef.rotationY = 26;
//    			itemDef.modelOffsetY = 0;
//                itemDef.name = "@whi@Uru Isiha Boots";
//                break;
//
//
//
//            case 8486:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97391;
//                itemDef.maleEquip1 = 97391;
//                itemDef.femaleEquip1 = 97391;
//                itemDef.modelZoom = 1283;
//                itemDef.rotationX = 1226;
//                itemDef.rotationY = 496;
//                itemDef.name = "@whi@Uru Isiha Gloves";
//                break;
//
//
//            case 8487:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 43076;
//                itemDef.maleEquip1 = 43076;
//                itemDef.femaleEquip1 = 43076;
//                itemDef.name = "@whi@Uru Isiha Aura";
//                break;
//
//
//            case 8488:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 97393;
//                itemDef.maleEquip1 = 97393;
//                itemDef.femaleEquip1 = 97393;
//                itemDef.modelZoom = 1000;
//                itemDef.rotationX = 1713;
//                itemDef.rotationY = 217;
//                itemDef.name = "@whi@Uru Isiha Bow";
//                break;
//
//
//
//            case 8490:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 28509;
//                itemDef.maleEquip1 = 28510;
//                itemDef.femaleEquip1 = 28510;
//                itemDef.name = "@whi@Summer crab legs";
//                break;
//
//            case 8491:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 28511;
//                itemDef.maleEquip1 = 28512;
//                itemDef.femaleEquip1 = 28512;
//                itemDef.name = "@whi@Summer crab body";
//                break;
//
//            case 8492:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 28513;
//                itemDef.maleEquip1 = 28514;
//                itemDef.femaleEquip1 = 28514;
//                itemDef.name = "@whi@Summer crab helmet";
//                break;
//
//            case 8493:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 28515;
//                itemDef.maleEquip1 = 28516;
//                itemDef.femaleEquip1 = 28516;
//                itemDef.name = "@whi@Summer crab gloves";
//                break;
//
//            case 8494:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 28517;
//                itemDef.maleEquip1 = 28517;
//                itemDef.femaleEquip1 = 28517;
//                itemDef.name = "@whi@Summer crab boots";
//                break;
//
//
//            case 8495:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 28518;
//                itemDef.maleEquip1 = 28518;
//                itemDef.femaleEquip1 = 28518;
//                itemDef.name = "@whi@Summer crab ring";
//                break;
//
//
//            case 8496:
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelID = 28519;
//                itemDef.maleEquip1 = 28520;
//                itemDef.femaleEquip1 = 28520;
//                itemDef.name = "@whi@Summer crab necklace";
//                break;
//
//                case 8498:
//                    itemDef.modelID = 56401;
//                    itemDef.actions = new String[5];
//                    itemDef.name = "@re1@Pet Summer surfer";
//                    itemDef.modelZoom = 3000;
//                    itemDef.rotationX = 0;
//                    itemDef.rotationY = 0;
//        			itemDef.modelOffsetY = 0;
//          			itemDef.modelOffset1 = 70;
//                    itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                    break;
//
//                case 5606:
//                    itemDef.name = "@re1@Instance voucher";
//                    itemDef.actions[0] = "@gre@Redeem";
//                    itemDef.actions[1] = null;
//                    itemDef.actions[2] = null;
//                    itemDef.actions[3] = null;
//                    break;
//
//            case 6192:
//                itemDef.modelID = 23441;
//                itemDef.name = "Packed Bong";
//                itemDef.femaleEquip1 = 23442;
//                itemDef.maleEquip1 = 23442;
//                itemDef.rotationY = 165;
//                itemDef.rotationX = 169;
//                itemDef.modelZoom = 650;
//                itemDef.description = "its a stoner bong, save it in ur inventory";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "take";
//                itemDef.actions = new String[5];
//                itemDef.actions[0] = "Smoke";
//                itemDef.actions[4] = "Drop";
//                break;
//
//
//            case 3275:
//                itemDef.modelID = 23892;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 23893;
//                itemDef.femaleEquip1 = 23893;
//                itemDef.name = "Star wars gun";
//                break;
//
//            case 3290:
//                itemDef.modelID = 44402;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 44402;
//                itemDef.femaleEquip1 = 44402;
//                itemDef.name = "Martian Raygun";
//                break;
//
//
//            case 3291:
//                itemDef.modelID = 44404;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 44405;
//                itemDef.femaleEquip1 = 44405;
//                itemDef.name = "Staff of Grace";
//                break;
//
//            case 3292:
//                itemDef.modelID = 44406;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 44407;
//                itemDef.femaleEquip1 = 44407;
//                itemDef.name = "Staff of Grace";
//                break;
//
//
//            case 3276:
//                itemDef.modelID = 23894;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23895;
//                itemDef.femaleEquip1 = 23895;
//                itemDef.name = "Saber";
//                break;
//
//           case 10835:
//                itemDef.actions = new String[5];
//                itemDef.actions = new String[] { "Add-to-pouch", "@red@Convert", null,null, null};
//                itemDef.name = "@or1@SebZero Taxbag";
//                break;
//
//            case 6532:
//                itemDef.modelID = 60743;
//                itemDef.modelZoom = 675;
//                itemDef.rotationY = 500;
//                itemDef.rotationX = 0;
//                itemDef.modelOffset1 = -1;
//                itemDef.modelOffsetY = -1;
//                itemDef.actions = new String[5];
//                itemDef.actions[0] = "Redeem";
//                itemDef.name = "@mag@Donator Tickets";
//                break;
//
//
//            case 8699:
//                itemDef.modelID = 61159;
//                itemDef.modelZoom = 675;
//                itemDef.rotationY = 500;
//                itemDef.rotationX = 0;
//                itemDef.modelOffset1 = -1;
//                itemDef.modelOffsetY = -1;
//                itemDef.actions = new String[5];
//                itemDef.animateInventory = true;
//                itemDef.actions = new String[] { null, null, null,null, null};
//                itemDef.name = "@red@Milos dreampass";
//                break;
//
//
//
//            case 15223:
//                itemDef.modelID = 48618;
//                itemDef.modelZoom = 1025;
//                itemDef.rotationY = 500;
//                itemDef.rotationX = 0;
//                itemDef.modelOffset1 = -1;
//                itemDef.modelOffsetY = -1;
//                itemDef.actions = new String[5];
//                itemDef.animateInventory = true;
//                itemDef.actions = new String[] { null, null, null,null, null};
//                itemDef.name = "@yel@Beta ticket";
//                break;
//
//            case 3274:
//                itemDef.modelID = 23896;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23897;
//                itemDef.femaleEquip1 = 23897;
//                itemDef.name = "dual-sided Saber";
//                break;
//
//            case 11978:
//                itemDef.modelID = 61125;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 19101);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//                itemDef.animateInventory = true;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.modelZoom = 5075;
//                itemDef.name = "Pet Yk'Lagor the Thunderous";
//                itemDef.actions = new String[] { null, null, "Summon", null, "Drop" };
//                break;
//
//
//
//            case 17903:
//                itemDef.modelID = 23453;
//                itemDef.name = "Weed leaf";
//                itemDef.femaleEquip1 = 23454;
//                itemDef.maleEquip1 = 23454;
//                itemDef.description = "a lovely cape";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Equip";
//
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 9943:
//                itemDef.name = "Oz of Jane";
//                itemDef.description = "a lovely smell drifts in the air";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 17413:
//                itemDef.name = "Bong Water";
//                itemDef.groundActions = new String[5];
//                itemDef.groundActions[2] = "Take";
//                itemDef.actions = new String[5];
//                itemDef.actions[4] = "Drop";
//                break;
//
//            case 6193:
//                itemDef.modelID = 23876;
//                itemDef.actions = new String[5];
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[1] = "Wield";
//                itemDef.modelZoom = 2000;
//                itemDef.rotationX = 0;
//                itemDef.modelOffsetY = -6;
//                itemDef.modelOffsetX = 1;
//                itemDef.maleEquip1 = 23877;
//                itemDef.femaleEquip1 = 23877;
//                itemDef.name = "Hades flagcape";
//                break;
//
//            case 6194:
//                itemDef.modelID = 23878;
//                itemDef.actions = new String[5];
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 23879;
//                itemDef.femaleEquip1 = 23879;
//                itemDef.name = "Hades full helm";
//                break;
//
//            case 6195:
//                itemDef.modelID = 23880;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                ItemDef.copyMostDefs(itemDef, 1127);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.animateInventory = true;
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23881;
//                itemDef.femaleEquip1 = 23881;
//                itemDef.name = "Hades Platebody";
//                break;
//            case 6196:
//                itemDef.modelID = 23882;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 1079);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23883;
//                itemDef.femaleEquip1 = 23883;
//                itemDef.name = "Hades Platelegs";
//                break;
//            case 6197:
//                itemDef.modelID = 23884;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 4153);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.modelZoom = 1100;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23885;
//                itemDef.femaleEquip1 = 23885;
//                itemDef.name = "Hades Hammer";
//                break;
//
//
//            case 14053:
//                itemDef.modelID = 61318;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 13899);
//				itemDef.modelZoom = 800;
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 61328;
//                itemDef.femaleEquip1 = 61328;
//                itemDef.name = "Infinity Gauntlet";
//                break;
//
//            case 14535:
//                itemDef.modelID = 61330;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 13899);
//				itemDef.modelZoom = 800;
//                itemDef.actions[1] = "Wield";
//                itemDef.maleEquip1 = 61328;
//                itemDef.femaleEquip1 = 61328;
//                itemDef.name = "Powered Infinity Gauntlet";
//                break;
//
//
//            case 14054:
//                itemDef.modelID = 61319;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 5266);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.modelZoom = 400;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Green Infinity stone";
//                break;
//
//            case 14055:
//                itemDef.modelID = 61320;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 5266);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.modelZoom = 400;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Blue Infinity stone";
//                break;
//
//            case 14063:
//                itemDef.modelID = 61321;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 5266);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.modelZoom = 575;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Orange Infinity stone";
//                break;
//
//            case 14388:
//                itemDef.modelID = 61329;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 5266);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.modelZoom = 400;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Yellow Infinity stone";
//                break;
//
//            case 14523:
//                itemDef.modelID = 61323;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 5266);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.modelZoom = 400;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Red Infinity stone";
//                break;
//
//            case 14524:
//                itemDef.modelID = 61326;
//                itemDef.actions = new String[5];
//                ItemDef.copyMostDefs(itemDef, 5266);
//				itemDef.modelOffset1 = itemDef.modelOffset1;
//				itemDef.modelOffsetY = itemDef.modelOffsetY;
//				itemDef.modelZoom = 400;
//				itemDef.rotationX = itemDef.rotationX;
//				itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Purple Infinity stone";
//                break;
//
//
//            case 6198:
//                itemDef.modelID = 23887;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.modelZoom = 1783;
//                itemDef.rotationX = 513;
//                itemDef.rotationY = 165;
//    			itemDef.modelOffsetY = 0;
//      			itemDef.modelOffset1 = 0;
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23887;
//                itemDef.femaleEquip1 = 23887;
//                itemDef.name = "Hades Shield";
//                break;
//
//
//            case 2749:
//                itemDef.modelID = 23898;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                ItemDef.copyMostDefs(itemDef, 1163);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.maleEquip1 = 23899;
//                itemDef.femaleEquip1 = 23899;
//                itemDef.name = "Hercules helm";
//                break;
//
//            case 2750:
//                itemDef.modelID = 23900;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23901;
//                itemDef.femaleEquip1 = 23901;
//                ItemDef.copyMostDefs(itemDef, 1127);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.name = "Hercules fighterbody";
//                break;
//
//            case 2751:
//                itemDef.modelID = 23902;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23903;
//                ItemDef.copyMostDefs(itemDef, 1079);
//    			itemDef.modelOffset1 = itemDef.modelOffset1;
//    			itemDef.modelOffsetY = itemDef.modelOffsetY;
//    			itemDef.rotationX = itemDef.rotationX;
//    			itemDef.rotationY = itemDef.rotationY;
//                itemDef.femaleEquip1 = 23903;
//                itemDef.name = "Hercules fighterlegs";
//                break;
//
//
//            case 2753:
//                itemDef.modelID = 23904;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23905;
//                itemDef.femaleEquip1 = 23905;
//                itemDef.name = "Hercules Kiteshield";
//                break;
//
//            case 2752:
//                itemDef.modelID = 23906;
//                itemDef.actions = new String[5];
//                itemDef.actions[1] = "Wield";
//                itemDef.actions[2] = "@or2@Salvage";
//                itemDef.maleEquip1 = 23907;
//                itemDef.femaleEquip1 = 23907;
//                itemDef.name = "Hercules fightercape";
//                break;
//        }
//
//        switch (itemDef.id) {
//
//        }
//    }
}


