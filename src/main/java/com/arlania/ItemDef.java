package com.arlania;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.arlania.fxscenes.DefEditorSceneController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;

import com.shobudesign.Obj;

public final class ItemDef {
	
	public static final Object[][] customDescData = new Object[][] { // stores all the custom data
		{1057, "Thats a cool hween"},
		{1055, "Also a hween just cooler!!!" + "\\n" + "My id is 1055 by the way\\nYeh thats about it."},
	};
	//public static List<Integer> customDescIds = Arrays.asList(11694, 14484);

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
		ItemDef other = (ItemDef) obj;
		if (id != other.id)
			return false;
		return true;
	}

	private static int[] prices;
	private static List<Integer> untradeableItems = new ArrayList<Integer>();

	public static void nullLoader() {
		modelCache = null;
		spriteCache = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	private int[] transColor;
	private int[] transLevel;

	private int[] originalModelColor;
	private int rotationZ;

	boolean animateInventory;
	
	public String customDescription = "";
	


	public boolean dialogueModelFetched(int j) {
		int k = maleDialogue;
		int l = maleDialogueModel;
		if (j == 1) {
			k = femaleDialogue;
			l = femaleDialogueModel;
		}
		if (k == -1) {
			return true;
		}
		boolean flag = true;
		if (!Model.modelIsFetched(k)) {
			flag = false;
		}
		if (l != -1 && !Model.modelIsFetched(l)) {
			flag = false;
		}
		return flag;
	}
	
	public static void applyTexturing(Model model, int id) {
		switch (id) {
			
		case 19996:
		case 5159:
		case 5172:
		case 5169:
		case 5176:
		case 5177:
		case 5180:
		case 5181:
		case 5182:

		case 5188:
		case 5189:
			model.setTexture(57);
			break;
			
		case 9499:
		case 14666:
			model.setTexture(62);
			break;
			
		case 5170:
			model.setTexture(88);
			break;
			
		case 14044:
			model.setTexture(87);
			break;
			
		case 14046:
			model.setTexture(83);
			break;
			
		case 5022:
			model.setTexture(88);
			break;	
		case 13030:
			model.setTexture(83);
			break;
			
			
		case 7925:
			model.setTexture(69);
			break;
			
		case 6758:
			model.setTexture(89);
			break;
			
		case 6759:
			model.setTexture(83);
			break;
		case 6760:
			model.setTexture(58);
			break;
		case 6762:
			model.setTexture(88);
			break;
		case 20693:
		case 3260:
		case 13998:
			model.setTexture(51);
			break;
			
		case 8699:
			model.setTexture(89);
			break;
		case 744:
			model.setTexture(61);
			break;
		case 6666:
			model.setTexture(63);
			break;
		case 16543:
			model.setTexture(61);
			break;
		case 20694:
		case 14019:
			model.setTexture(52);
			break;
		case 20695:
		case 18957:
		case 18955:
		case 18956:
			model.setTexture(53);
			break;
		case 15019:
			model.setTexture(60);
			break;
		case 13591:
		case 15037:
		case 15118:
			model.setTexture(67);
			break;
			
			
		case 8731:
		case 8732:
			model.setTexture(87);
			break;
			
		
		case 15656:
		case 17594:
			model.setTexture(53);
			break;
		case 9490:
		case 9491:
			model.setTexture(54);
			break;
			
		case 20696:
			model.setTexture(54);
			break;
			
		case 5149:
		case 18753:
			model.setTexture(66);
			break;
			
		case 20697:
			model.setTexture(55);
			break;
			
		case 3921:
			model.setTexture(73);
			break;
			
		case 15654:
		case 15655:
			model.setTexture(40);
			break;
			
		case 13708:
		case 13707:
			model.setTexture(66);
			break;
		case 14559:
		case 5186:
		case 5187:
			model.setTexture(58);
			break;
		case 19080:
			model.setTexture(57);
			break;
			
		case 10852:
			model.setTexture(72);
			break;
			
		case 10853:
			model.setTexture(51);
			break;
			
		case 10854:
			model.setTexture(55);
			break;
			
		case 16533:
			model.setTexture(61);
			break;
			
		case 16534:
			model.setTexture(51);
			break;

		case 20698:
			model.setTexture(56);
			break;
		case 13999:
			model.setTexture(89);
			break;
			
		case 20699:
			model.setTexture(57);
			break;
			
		case 8672:
			model.setTexture(58);
			break;
		case 8671:
			model.setTexture(55);
			break;
		case 8663:
			model.setTexture(56);
			break;
		case 8662:
		case 13390:
			model.setTexture(51);
			break;
		case 8661:
			model.setTexture(75);
			break;
		case 8660:
			model.setTexture(57);
			break;
		case 8659:
		case 4082:
			model.setTexture(61);
			break;
		case 18395:
			model.setTexture(68);
			break;
			
		case 20268:
			model.setTexture(65);
			break;
		case 17843:
			model.setTexture(83);
			break;
		case 17844:
			model.setTexture(84);
			break;
			
		case 5137:
		case 5138:
		case 10346:
		//case 10348:
		//case 10350:
		case 5174:
		//case 11858:
		case 10352:
		case 5178:
		case 5185:
		case 5206:
		case 5173:
			model.setTexture(59);
			break;
			
		case 1639:
			model.setTexture(71);
			break;
			
		case 5167:
			model.setTexture(40);
			break;
			
		case 5168:
			model.setTexture(59);
			break;
			
		case 20451:
			model.setTexture(58);
			break;
		case 20450:
		case 20567:
			model.setTexture(56);
			break;
		case 20565:
			model.setTexture(64);
			break;
		case 1499:
			model.setTexture(64);
			break;
			
		case 15012:
			model.setTexture(64);
			break;
		case 20566:
			model.setTexture(57);
			break;
		case 20568:
			model.setTexture(33);
			break;
		case 10855:
			model.setTexture(66);
			break;
		case 20569:
			model.setTexture(58);
			break;
		case 20570:
		case 3918:
			model.setTexture(55);
			break;
			
		case 16496:
			model.setTexture(61);
			break;
			
		case 16498:
			model.setTexture(64);
			break;
		case 16499:
			model.setTexture(71);
			break;
			
		case 16500:
			model.setTexture(52);
			break;
		case 16501:
			model.setTexture(61);
			break;
		case 5171:
		case 5175:
		case 3438:
		case 17630:
			model.setTexture(55);
			break;
			
			
		
		//case 10346:
		//case 10350:
	//	case 10352:
		//	model.setTexture(57);
		//	break;
		
		
		//case 3083:
			//model.setTexture(59);
			//break;
		
		
		}
		}

	public Model getDialogueModel(int gender) {
		int k = maleDialogue;
		int l = maleDialogueModel;
		if (gender == 1) {
			k = femaleDialogue;
			l = femaleDialogueModel;
		}
		if (k == -1) {
			return null;
		}
		Model model = Model.fetchModel(k);
		if (l != -1) {
			Model model_1 = Model.fetchModel(l);
			Model models[] = { model, model_1 };
			model = new Model(2, models);
		}
		if (originalModelColors != null) {
			for (int i1 = 0; i1 < originalModelColors.length; i1++) {
				model.recolour(originalModelColors[i1], newModelColor[i1]);
			}
		}
		
		if (transColor != null) {
			for (int var7 = 0; var7 < transColor.length; ++var7) {
				model.setAlphaToColor(transColor[var7], transLevel[var7]);
			}
		}
		applyTexturing(model, id);
		return model;
	}

	public boolean equipModelFetched(int gender) {
		int fistModel = maleEquip1;
		int secondModel = maleEquip2;
		int thirdModel = maleEquip3;
		if (gender == 1) {
			fistModel = femaleEquip1;
			secondModel = femaleEquip2;
			thirdModel = femaleEquip3;
		}
		if (fistModel == -1) {
			return true;
		}
		boolean flag = true;
		if (!Model.modelIsFetched(fistModel)) {
			flag = false;
		}
		if (secondModel != -1 && !Model.modelIsFetched(secondModel)) {
			flag = false;
		}
		if (thirdModel != -1 && !Model.modelIsFetched(thirdModel)) {
			flag = false;
		}
		return flag;
	}

	public Model getEquipModel(int gender) {

		int j = maleEquip1;
		int k = maleEquip2;
		int l = maleEquip3;
		if (gender == 1) {
			j = femaleEquip1;
			k = femaleEquip2;
			l = femaleEquip3;
		}
		if (j == -1) {
			return null;
		}
		Model model = Model.fetchModel(j);
		if (k != -1) {
			if (l != -1) {
				Model model_1 = Model.fetchModel(k);
				Model model_3 = Model.fetchModel(l);
				Model model_1s[] = { model, model_1, model_3 };
				model = new Model(3, model_1s);
			} else {
				Model model_2 = Model.fetchModel(k);
				Model models[] = { model, model_2 };
				model = new Model(2, models);
			}
		}
		
		if(id == Client.currentlyEditedItemId) {
			model.translate(DefEditorSceneController.xValue, DefEditorSceneController.yValue, DefEditorSceneController.zValue);
		}
		
		if (id == 5141 || id == 5140 || id == 5139 || id == 5165 || id == 5164 || id == 4769) {
			model.translate(0, 0, 2);
		}

		// if (j == 62367)
		// model.translate(68, 7, -8);
		if (gender == 0 && maleYOffset != 0) {
			model.translate(0, maleYOffset, 0);
		} else if (gender == 1 && femaleYOffset != 0) {
			model.translate(0, femaleYOffset, 0);
		}
		if (originalModelColors != null) {
			for (int i1 = 0; i1 < originalModelColors.length; i1++) {
				model.recolour(originalModelColors[i1], newModelColor[i1]);
			}
		}
		if (transColor != null) {
			for (int var9 = 0; var9 < transColor.length; ++var9) {
				model.setAlphaToColor(transColor[var9], transLevel[var9]);
			}
		}
		applyTexturing(model, id);
		return model;
	}
	
	public static void repack() throws FileNotFoundException {

        try (DataOutputStream dataDOS = new DataOutputStream(new FileOutputStream("./obj.dat"));
             DataOutputStream indexDOS = new DataOutputStream(new FileOutputStream("./obj.idx"))) {
            int count = totalItems + 1000;
            indexDOS.writeShort(count);
            int previousSize = dataDOS.size();
            for (int itemId = 0; itemId < count; itemId++) {
                ItemDef definition = ItemDef.forID(itemId);
                definition.writeValues(dataDOS);
                indexDOS.writeShort(dataDOS.size() - previousSize);
                previousSize = dataDOS.size();
            }
             
        } catch (IOException e) { //fok o whats wrong atm try
            e.printStackTrace();
        }

    }//backup current cache, k fella k done fella k try now fella
	
	public void writeString(String data, DataOutputStream dos) throws IOException {
		dos.writeBytes(data);
		dos.writeByte(10);
		}
	
	private void writeValues(DataOutputStream data) throws IOException {
        if (modelID != 0) {
            data.writeByte(1);
            data.writeInt(modelID);
        }
        if (name != null) {
            data.writeByte(2);
            writeString(name, data);

        }
        if (description != null) {
            data.writeByte(3);
            writeString(description, data);
        }
        if (modelZoom != 2000) {
            data.writeByte(4);
            data.writeShort(modelZoom);
        }
        if (rotationY != 0) {
            data.writeByte(5);
            data.writeShort(rotationY);
        }
        if (rotationX != 0) {
            data.writeByte(6);
            data.writeShort(rotationX);
        }
        if (modelOffset1 != 0) {
            data.writeByte(7);
            data.writeShort(modelOffset1);
        }
        if (modelOffsetY != 0) {
            data.writeByte(8);
            data.writeShort(modelOffsetY);
        }
        //if (tenthOpcode != 0) {
          //  data.writeByte(10);
       //     data.writeShort(tenthOpcode);
      //  }
        if (stackable) {
            data.writeByte(11);
        }
       // if (tenthOpcode != 0) {
       //     data.writeByte(10);
       //     data.writeShort(tenthOpcode);
       // }
        if (value != 0) {
            data.writeByte(12);
            data.writeShort(value);
        }
        if (membersObject) {
            data.writeByte(16);
        }
        if (maleEquip1 != -1) {
            data.writeByte(23);
            data.writeInt(maleEquip1);
            data.writeByte(maleYOffset);
        }
        if (maleEquip2 != -1) {
            data.writeByte(24);
            data.writeInt(maleEquip2);
        }
        if (femaleEquip1 != -1) {
            data.writeByte(25);
            data.writeInt(femaleEquip1);
            data.writeByte(femaleYOffset);
        }
        if (femaleEquip2 != -1) {
            data.writeByte(26);
            data.writeInt(femaleEquip2);
        }
        if (groundActions != null) {
            for (int index = 0; index < groundActions.length; index++) {
                if (groundActions[index] != null) {
                data.writeByte(30 + index);
                    writeString(groundActions[index], data);

                    }

            }
        }
        if (actions != null) {
            for (int index = 0; index < actions.length; index++) {
                if (actions[index] != null) {
                data.writeByte(35 + index);
                writeString(actions[index], data);

            }
            }
        }
        if (originalModelColors != null && newModelColor != null) {
            data.writeByte(40);
            data.writeByte(originalModelColors.length);
            for (int index = 0; index < originalModelColors.length; index++) {
                data.writeShort(originalModelColors[index]);
                data.writeShort(newModelColor[index]);
            }
        }
        if (maleEquip3 != -1) {
            data.writeByte(78);
            data.writeInt(maleEquip3);
        }
        if (femaleEquip3 != -1) {
            data.writeByte(79);
            data.writeInt(femaleEquip3);
        }
        if (maleDialogue != -1) {
            data.writeByte(90);
            data.writeInt(maleDialogue);
        }
        if (femaleDialogue != -1) {
            data.writeByte(91);
            data.writeInt(femaleDialogue);
        }
        if (maleDialogueModel != -1) {
            data.writeByte(92);
            data.writeInt(maleDialogueModel);
        }
        if (femaleDialogueModel != -1) {
            data.writeByte(93);
            data.writeInt(femaleDialogueModel);
        }
        if (modelOffsetX != 0) {
            data.writeByte(95);
            data.writeShort(modelOffsetX);
        }
        if (certID != -1) {
            data.writeByte(97);
            data.writeShort(certID);
        }
        if (certTemplateID != -1) {
            data.writeByte(98);
            data.writeShort(certTemplateID);
        }
        if (stackIDs != null && stackAmounts != null) {
            for (int index = 0; index < stackIDs.length; index++) {
                data.writeByte(100 + index);
                data.writeShort(stackIDs[index]);
                data.writeShort(stackAmounts[index]);
            }
        }
        if (sizeX != 128) {
            data.writeByte(110);
            data.writeShort(sizeX);
        }
        if (sizeY != 128) {
            data.writeByte(111);
            data.writeShort(sizeY);
        }
        if (sizeZ != 128) {
            data.writeByte(112);
            data.writeShort(sizeZ);
        }
        if (shadow != 0) {
            data.writeByte(113);
            data.writeByte(shadow);
        }
        if (lightness != 0) {
            data.writeByte(114);
            data.writeByte(lightness / 5);
        }
        if (team != 0) {
            data.writeByte(115);
            data.writeByte(team);
        }
        if (lendID != -1) {
            data.writeByte(116);
            data.writeShort(lendID);
        }
        if (lentItemID != -1) {
            data.writeByte(117);
            data.writeShort(lentItemID);
        }
        data.writeByte(0);
    }

	public void setDefaults() {
		//tenthOpcode = 0;
		untradeable = false;
		modelID = 0;
		name = null;
		description = null;
		originalModelColors = null;
		newModelColor = null;
		modelZoom = 2000;
		transLevel = null;
		transColor = null;
		rotationY = 0;
		rotationX = 0;
		modelOffsetX = 0;
		modelOffset1 = 0;
		modelOffsetY = 0;
		stackable = false;
		value = 0;
		membersObject = false;
		groundActions = null;
		actions = null;
		maleEquip1 = -1;
		maleEquip2 = -1;
		maleYOffset = 0;
		maleXOffset = 0;
		femaleEquip1 = -1;
		femaleEquip2 = -1;
		femaleYOffset = 0;
		maleEquip3 = -1;
		femaleEquip3 = -1;
		maleDialogue = -1;
		maleDialogueModel = -1;
		femaleDialogue = -1;
		femaleDialogueModel = -1;
		stackIDs = null;
		stackAmounts = null;
		certID = -1;
		certTemplateID = -1;
		sizeX = 128;
		sizeY = 128;
		sizeZ = 128;
		shadow = 0;
		lightness = 0;
		team = 0;
		lendID = -1;
		lentItemID = -1;
	}

	public static void unpackConfig(CacheArchive streamLoader) {
		/*
		 * stream = new Stream(FileOperations.ReadFile("./Cache/obj.dat")); Stream
		 * stream = new Stream(FileOperations.ReadFile("./Cache/obj.idx"));
		 */
		stream = new Stream(streamLoader.getDataForName("obj.dat"));
		Stream stream = new Stream(streamLoader.getDataForName("obj.idx"));
		totalItems = stream.readUnsignedWord();
		streamIndices = new int[totalItems + 1000];
		int i = 0;
		for (int j = 0; j < totalItems; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedWord();
		}
		cache = new ItemDef[10];
		for (int k = 0; k < 10; k++) {
			cache[k] = new ItemDef();
		}
		
		setSettings();
		System.out.println("Unpacking");
		
		/*try {
			repack();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public static ItemDef copyRotations(ItemDef itemDef, int id) {
		ItemDef itemDef2 = ItemDef.forID(id);
		itemDef.modelOffsetY = itemDef2.modelOffsetY;
		itemDef.modelOffsetX = itemDef2.modelOffsetX;
		itemDef.modelOffsetY = itemDef2.modelOffsetY;
		itemDef.modelOffset1 = itemDef2.modelOffset1;
		itemDef.modelZoom = itemDef2.modelZoom;
		itemDef.rotationX = itemDef2.rotationX;
		itemDef.rotationY = itemDef2.rotationY;
		return itemDef;
	}

	public static ItemDef copyModel(ItemDef itemDef, int id) {
		ItemDef itemDef3 = ItemDef.forID(id);
		itemDef.modelID = itemDef3.modelID;
		itemDef.maleEquip1 = itemDef3.maleEquip1;
		itemDef.femaleEquip1 = itemDef3.femaleEquip1;
		itemDef.modelZoom = itemDef3.modelZoom;
		itemDef.rotationX = itemDef3.rotationX;
		itemDef.rotationY = itemDef3.rotationY;
		itemDef.modelOffset1 = itemDef3.modelOffset1;
		itemDef.modelOffsetX = itemDef3.modelOffsetX;
		itemDef.modelOffsetY = itemDef3.modelOffsetY;
		itemDef.actions = itemDef3.actions;
		itemDef.maleEquip2 = itemDef3.maleEquip2;
		itemDef.maleEquip3 = itemDef3.maleEquip3;
		itemDef.femaleEquip2 = itemDef3.femaleEquip2;
		itemDef.femaleEquip3 = itemDef3.femaleEquip3;
		itemDef.maleXOffset = itemDef3.maleXOffset;
		itemDef.maleYOffset = itemDef3.maleYOffset;
		itemDef.femaleYOffset = itemDef3.femaleYOffset;
		itemDef.maleDialogue = itemDef3.maleDialogue;
		itemDef.maleDialogueModel = itemDef3.maleDialogueModel;
		itemDef.femaleDialogueModel = itemDef3.femaleDialogueModel;
		return itemDef;
	}

	public static ItemDef copyMostDefs(ItemDef itemDef, int id) {
		ItemDef itemDef3 = ItemDef.forID(id);
		itemDef.modelZoom = itemDef3.modelZoom;
		itemDef.rotationX = itemDef3.rotationX;
		itemDef.rotationY = itemDef3.rotationY;
		itemDef.modelOffset1 = itemDef3.modelOffset1;
		itemDef.modelOffsetX = itemDef3.modelOffsetX;
		itemDef.modelOffsetY = itemDef3.modelOffsetY;
		itemDef.actions = itemDef3.actions;
		return itemDef;

	}

	public enum CustomItems {
		RED_WINGS(19709, 48334, 48334, 48334, false), // 18888 cape, shield
		ELITE_CROSSBOW(9185, 48353, 48354, 48354, true), // 18889
		ELITE_MAGE_BOOK(3842, 48361, 48362, 48362, false), // 18890
		ELITE_MAGE_WAND(6914, 48363, 48364, 48364, true), // 18891
		LIGHT_BLUE_WINGS(19709, 48375, 48375, 48375, false), // 18892
		GODSTONE_SHIELD(8714, 13086, 13087, 13087, false), // 18893
		BLOODY_DREADFUL_SHIELD(8714, 13701, 13700, 13700, false), // 18894
		JUGGERNAUT_RING(18907, 47762, -1, false), // 18895
		ANCIENT_AXES(4747, 15352, 15351, 15351, false), // 18896
		QUEST_CAPE_WINGS(19709, 27657, 27656, 27656, false), // 18897
		GEMSTONE_SWORD(18351, 82966, 82967, 82967, false), // 18898
		MALEVOLENT_SHIELD(8714, 48394, 48395, 48395, false), // 18899
		NINJA_THROWING_KNIFE(5698, 48396, 48397, 48397, false), // 18900
		RAINBOW_SPIRIT_SHIELD(5698, 80010, 80011, 80011, false), // 18901
		STRIPED_WHIP(18351, 80028, 80029, 80029, true), // 18902
		BLUE_DREADFUL_SHIELD(8714, 80031, 80030, 80030, false), // 18903
		SPECIAL_CUSTOM_PARTYHAT(1038, new int[] { 926, 0, 0, 0 }, new int[] { 33, 0, 0, 0 }), // 18904
		DARK_BLUE_DREADFUL_SHIELD(8714, 16065, false), // 18905
		BLADED_SHIELD(8714, 19550, true), // 18906
		RING_OF_RICHES(18907, 68824, -1, false), // 18907
		TENACIOUS_RING(6737, 68825, -1, false), // 18908
		BLUE_OBBY_SHIELD(8714, 30001, 30000, false), // 18909
		GREEN_OBBY_SHIELD(8714, 30003, 30002, false), // 18910
		CREATURE_WHIP(4151, 4185, 4186, true),
		GOLD_DREADFUL_SHIELD(8714, 55028, 55027, false), // 18912
		MACHINED_CLAWS(14484, 62937, 62936, false), // 18913
		PURPLE_SPIRIT_SHIELD(5698, 87654, 87653, false), // 18914
		NUB_Suic_SWORD(18351, 86044, true), // 18915
		ILLUMINNATION_PLATELEGS(14010, 86065, 86062, false), // 18916
		ILLUMINNATION_PLATEBODY(14009, 86067, 86063, false), // 18917
		ILLUMINNATION_HELM(14008, 86066, 86064, false), // 18918
		MINIGUN(5698, 74119, true), // 18919
		RAINBOW_WINGS(19709, 23231, 23232, false), // 18920
		GOBLIN_MASK(14010, 28666, 28553, false), // 18921
		WHITE_WINGS(19709, 45000, false), // 18922
		ROYAL_THROWING_AXE(1377, 72044, true), // 18923
		RAY_GUN(5698, 74114, false), // 18924
		GHOSTLY_SWORDS(18351, 75058, 75059, true), // 18925
		PINK_WINGS(19709, 75860, 75859, false), // 18926
		DARK_RED_WINGS(19709, 75861, 75862, false), // 18927
		STARTER_Vortex_WINGS(19709, 75863, 75864, false), // 18928
		FIERY_WINGS(19709, 75865, 75866, false), // 18929
		RAINBOW_WHIP(18351, 78101, true), // 18930
		ICY_CROSSBOW(9185, 79411, true), // 18931
		CHILLER_SWORD(18351, 79413, true), // 18932
		RED_SPIRIT_SHIELD(8714, 80004, false), // 18933
		GOLD_SPIRIT_SHIELD(8714, 80007, false), // 18934
		TOY_CROSSBOW(9185, 90009, 90009, true), // 18935
		AMERICAN_PARTYHAT(1048, 74006, 74006, 74007, false), // 18936
		TECHTONIC_ROBE_BOTTOM(18937, 90025, 90023, false), // 18937
		TECHTONIC_ROBE_TOP(18938, 90022, 90020, false), // 18938
		TECHTONIC_HELM(18939, 90019, 90017, false), // 18939
		SIRENIC_PLATELEGS(18940, 90034, 90032, false), // 18940
		SIRENIC_PLATEBODY(18941, 90031, 90029, false), // 18941
		SIRENIC_FULL_HELM(18942, 90028, 90026, false), // 18942
		MALEVOLENT_PLATELEGS(18943, 90043, 90041, false), // 18943
		MALEVOLENT_PLATEBODY(18944, 90040, 90038, false), // 18944
		MALEVOLENT_HELM(18945, 90037, 90035, false), // 18945
		DRAGONBONE_KITESHIELD(8714, 90045, 90044, 90044, false), // 18946
		ARMADYL_CROSSBOW(18357, 90047, 90046, 90046, true), // 18947
		DRAGON_BOOTS(11732, 90049, 90049, 90049, false), // 18948 start
		SKY_TORVA_HELM(14008, 100, 100, 101, false), // 18949
		PAPER_SACK(1048, 10031, 10031, 10031, false), // 18950
		COLORFUL_WINGS(19709, 10094, 10094, 10093, false), // 18951
		ROYAL_CAPE(19709, 1015, 1015, 1017, false), // 18952
		SKY_TORVA_PLATEBODY(14009, 102, 102, 103, false), // 18953
		SKY_TORVA_WINGS(19709, 104, 104, 105, false), // 18954
		SKY_TORVA_BOOTS(11732, 106, 106, 107, false), // 18955
		SKY_TORVA_GLOVES(1059, 108, 108, 109, false), // 18956
		SKY_BRUTAL_WHIP(18351, 110, 110, 111, true), // 18957
		GOLDEN_DEATH_CAPE(19709, 11112, 11112, 11112, false), // 18958
		ONE_GLOVE(1059, 11114, 11114, 11114, false), // 18959
		ONE_LEGS(14010, 11115, 11115, 11115, false), // 18960
		ONE_CAPE(19709, 11118, 11118, 11118, false), // 18961
		SKY_TORVA_PLATELEGS(14010, 112, 112, 113, false), // 18962
		ANIMAL_HELM(14008, 12276, 12276, 15002, false), // 18963
		ANIMAL_BODY(14009, 12278, 12278, 15004, false), // 18964
		ANIMAL_BOW(861, 12323, 12316, 12316, true), // 18965
		HUGE_BIRD_WINGS(19709, 12542, 12542, 12542, false), // 18966
		SPARTA_BOOTS(11732, 13565, 13565, 13565, false), // 18967
		BLUE_DONATOR_CAPE(19709, 13955, 13955, 13956, false), // 18968
		RED_DONATOR_CAPE(19709, 13957, 13957, 13958, false), // 18969
		DOUBLE_ENDED_DILDO(18351, 14053, 14053, 14052, true), // 18970
		FIERY_BOW(861, 14680, 14680, 14679, true), // 18971
		ANIMAL_LEGS(14010, 15005, 15005, 15005, false), // 18972
		ORNAMENTAL_PLATE(14009, 15042, 15042, 82947, false), // 18973
		ORNAMENTAL_PLATELEGS(14010, 15044, 15044, 15043, false), // 18974
		ORNAMENTAL_BOOTS(11732, 15046, 15046, 15045, false), // 18975
		ORNAMENTAL_GLOVES(1059, 15049, 15049, 15047, false), // 18976
		GREEN_DONATOR_CAPE(19709, 16020, 16020, 16021, false), // 18977
		DONATOR_SHIELD(8714, 16034, 16034, 16035, false), // 18978
		COLORFUL_SCARF(1725, 16829, 16829, 16830, false), // 18979
		COLORFUL_HELM(18945, 19993, 19993, 19993, false), // 18980
		COLORFUL_PLATE(14009, 19995, 19995, 19995, false), // 18981
		COLORFUL_PLATELEGS(14010, 19996, 19996, 19996, false), // 18982
		PINK_DILDO(18351, 20, 20, 20, true), // 18983
		ORNAMENTAL_HELM(14008, 2035, 2035, 2036, false), // 18984
		SHARK_TOOTH_SWORD(18351, 22, 22, 22, true), // 18985
		PURPLE_GLASS_WINGS(19709, 23060, 23060, 23061, false), // 18986
		RAINBOW_CAPE(19709, 23234, 23234, 23235, false), // 18987
		STACKED_AXE(18351, 24092, 24092, 24091, true), // 18988
		DOOM_BLADE(18351, 2600, 2600, 2600, true), // 18989
		POOL_CUE(18351, 26096, 26096, 26097, true), // 18990
		GREEN_CROWN(1048, 27222, 27222, 27221, false), // 18991
		RED_CROWN(1048, 27232, 27232, 27231, false), // 18992
		PURPLE_CROWN(1048, 27242, 27242, 27241, false), // 18993
		COLORFUL_LANCE(18351, 27274, 27274, 27275, true), // 18994
		WINGED_DONATOR_CAPE(19709, 27830, 27830, 27831, false), // 18995
		DEVIL_TAIL(14010, 27864, 27864, 27863, false), // 18996
		DEVIL_HORNS(1048, 27874, 27874, 27873, false), // 18997
		PINK_TOP_HAT(1048, 27888, 27888, 27887, false), // 18998
		RED_WINGED_CAPE(19709, 27896, 27896, 27897, false), // 18999
		GUITAR(18351, 49026, 49026, 49026, true), // 19000
		JESTER_SWORD(18351, 49101, 49101, 49102, true), // 19001
		NOOB_GODSWORD(18351, 5000, 5000, 5001, true), // 19002
		FORGOTTEN_LONGSWORD(18351, 5002, 5002, 5003, true), // 19003
		ROYAL_BLADE(18351, 50065, 50065, 50066, true), // 19004
		AKIMBO_DAGGERS(4747, 50134, 50134, 50135, true), // 19005
		FLESH_LONGSWORD(18351, 50224, 50224, 50223, true), // 19006
		ARMADYL_LONGSWORD(18351, 50227, 50227, 50226, true), // 19007
		LEGENDARY_BLADE(18351, 50228, 50228, 50228, true), // 19008
		DRAGONBONE_SCIMITAR(18351, 50941, 50941, 50942, true), // 19009
		DRAGONBONE_CAPE(19709, 50947, 50947, 50946, false), // 19010
		BLAZED_DEATH_CAPE(19709, 5167, 5167, 5166, false), // 19011
		BLUE_DEATH_CAPE(19709, 5168, 5169, 5169, false), // 19012
		STARTER_PLATEBODY(18944, 54171, 54171, 56539, false), // 19013
		STARTER_PLATELEGS(18943, 54012, 54012, 55818, false), // 19014
		BUMBLE_SHIELD(8714, 54445, 54445, 56975, false), // 19015
		STRIPED_PARTYHAT(1048, 58001, 58001, 58000, false), // 19016
		MULTICOLORED_PARTYHAT(1048, 58005, 58005, 58004, false), // 19017
		COLORFUL_SANTA_HAT(1050, 58013, 58013, 58012, false), // 19018
		GOLD_TRIMMED_WINGS(19709, 58025, 58025, 58024, false), // 19019
		PURPLE_WINGS(19709, 58028, 58028, 58027, false), // 19020
		RASTA_WINGS(19709, 58034, 58034, 58033, false), // 19021
		COLORFUL_WHIP(18351, 58051, 58051, 58050, true), // 19022
		GOLDEN_CLAWS(14484, 62000, 62000, 62001, true), // 19023
		SPARTA_PLATEBODY(18944, 62767, 62767, 90052, false), // 19024
		SPARTA_HELM(18945, 62771, 62771, 62770, false), // 19025
		SPARTA_PLATELEGS(18943, 62773, 62773, 62772, false), // 19026
		SPARTA_SHIELD(8714, 62775, 62775, 62774, false), // 19027
		TALIS_SWORD(18351, 62769, 62769, 62788, true), // 19028
		GRIM_PLATEBODY(18944, 62832, 62832, 62831, false), // 19029
		GRIM_PLATELEGS(18943, 62833, 62833, 62930, false), // 19030
		GRIM_HELM(18945, 62835, 62835, 62834, false), // 19031
		STARTER_Vortex_BOOTS(11732, 62837, 62837, 62836, false), // 19032
		GRIM_GLOVES(1059, 62839, 62839, 62838, false), // 19033
		METALIC_PLATEBODY(18944, 62847, 62847, 62846, false), // 19034
		METALIC_PLATELEGS(18943, 62841, 62841, 62840, false), // 19035
		METALIC_HELM(18945, 62849, 62849, 62848, false), // 19036
		CARVED_PLATEBODY(18944, 62853, 62853, 62852, false), // 19037
		CARVED_PLATELEGS(18943, 62855, 62855, 62854, false), // 19038
		CARVED_HELM(18945, 62857, 62857, 62856, false), // 19039
		BLUE_GLASS_WINGS(19709, 64057, 64057, 64058, false), // 19040
		GREEN_GLASS_WINGS(19709, 64059, 64059, 64060, false), // 19041
		RED_GLASS_WINGS(19709, 64061, 64061, 64062, false), // 19042
		YELLOW_GLASS_WINGS(19709, 64063, 64063, 64064, false), // 19043
		BLACK_GLASS_WINGS(19709, 64065, 64065, 64066, false), // 19044
		GODLY_WINGS(19709, 665, 665, 666, false), // 19045
		BLING_CHAIN(19709, 68989, 68989, 68990, false), // 19046
		SUPERMAN_LEGS(18943, 71959, 71959, 71958, false), // 19047
		SUPERMAN_BODY(18944, 71962, 71962, 71960, false), // 19048
		SUPERMAN_BOOTS(11732, 71961, 71961, 71961, false), // 19049
		AMERICAN_PARTYHAT_V2(1048, 74006, 74006, 74007, false), // 19050
		RETRO_PARTYHAT(1048, 74009, 74009, 74008, false), // 19051
		STRIPED_PARTYHAT_V2(1048, 74011, 74011, 74010, false), // 19052
		ZOMBIE_PARTYHAT(1048, 74014, 74014, 74015, false), // 19053
		SUPERMAN_CAPE(19709, 75072, 75072, 75072, false), // 19054
		ICY_KATANA(18351, 75500, 75500, 75500, true), // 19055
		PISTOL(9185, 75501, 75501, 75502, true), // 19056
		GOOGLE_CHROME_SWORD(18351, 75878, 75878, 75878, true), // 19057
		COLORFUL_SHIELD(8714, 7772, 7772, 7772, false), // 19058
		DEVIL_CAPE(19709, 81, 81, 80, false), // 19059
		ONE_HELM(19709, 82948, 82948, 82948, false), // 19060
		ONE_PLATEBODY(18944, 82949, 82949, 82949, false), // 19061
		TRON_SHIELD(8714, 82990, 82990, 82991, false), // 19062
		LEGACY_SHIELD(8714, 82992, 82992, 82993, false), // 19063
		GRIM_SHIELD(8714, 82994, 82994, 82995, false), // 19064
		STRIPED_WINGS(19709, 83010, 83010, 83011, false), // 19065
		TRON_WINGS(19709, 83012, 83012, 83013, false), // 19066
		ENERGY_SWORD(18351, 8393, 8393, 8393, true), // 19067
		COLORFUL_PARTYHAT(1048, 9001, 9001, 9000, false), // 19068
		ZARYTE_BOW(861, 62692, 62750, 62750, true), // 19069
		BRONZE_PARTYHAT(1038, new int[] { 926, 0, 0, 0 }, new int[] { 6028, 0, 0, 0 }), // 19070
		STEEL_PARTYHAT(1038, new int[] { 926, 0, 0, 0 }, new int[] { 61, 0, 0, 0 }), // 19071
		BLACK_PARTYHAT(1038, new int[] { 926, 0, 0, 0 }, new int[] { 3, 0, 0, 0 }), // 19072
		MITHRIL_PARTYHAT(1038, new int[] { 926, 0, 0, 0 }, new int[] { 43297, 0, 0, 0 }), // 19073
		ADAMANT_PARTYHAT(1038, new int[] { 926, 0, 0, 0 }, new int[] { 21662, 0, 0, 0 }), // 19074
		RUNE_PARTYHAT(1038, new int[] { 926, 0, 0, 0 }, new int[] { 36252, 0, 0, 0 }), // 19075
		BARROWS_PARTYHAT(1038, new int[] { 926, 0, 0, 0 }, new int[] { 10388, 0, 0, 0 }), // 19076
		LIME_PARTYHAT(1038, new int[] { 926, 0, 0, 0 }, new int[] { 17350, 0, 0, 0 }), // 19077
		LAVA_PARTYHAT(1038, new int[] { 926, 0, 0, 0 }, new int[] { 6073, 0, 0, 0 }), // 19078
		HELLFIRE_LOGS(1511, 94391, 94391, 94391, false), // 19079
		INFERNAL_BONES(18830, 94530, 94530, 94530, false), // 19080
		INFERNAL_SLED(4084, 94564, 94564, 94564, false), // 19081
		BLACKSTONE_SLED(4084, 94564, 94564, 94564, false), // 19082
		SKYROCKET_SLED(4084, 94564, 94564, 94564, false), // 19083
		PURPLEFIRE_SLED(4084, 94564, 94564, 94564, false), // 19084
		DARK_PURPLEFIRE_SLED(4084, 97334, 97334, 97334, false), // 19085
		HELLFIRE_SLED(4084, 94564, 94564, 94564, false), // 19086
		HULK_SLED(4084, 94564, 94564, 94564, false), // 19087
		INFERNAL_PARTYHAT(1040, 96041, 96042, 96042, false), // 19088
		HULK_PARTYHAT(1040, 96041, 96042, 96042, false), // 19089
		HELLFIRE_PARTYHAT(1040, 96041, 96042, 96042, false), // 19090
		SKYROCKET_PARTYHAT(1040, 96041, 96042, 96042, false), // 19091
		HULK_SANTA_HAT(1050, 96043, 96043, 96044, false), // 19092
		HELLFIRE_SANTA_HAT(1050, 96043, 96044, 96044, false), // 19093
		SKYROCKET_SANTA_HAT(1050, 96043, 96044, 96044, false), // 19094
		FIRST_ROOM_KEY(989, 91454, 91454, 91454, false), // 19095
		SECOND_ROOM_KEY_1(989, 91454, 91454, 91454, false), // 19096
		SECOND_ROOM_KEY_2(989, 91454, 91454, 91454, false), // 19097
		SECOND_ROOM_KEY_3(989, 91454, 91454, 91454, false), // 19098
		SECOND_ROOM_KEY_4(989, 91454, 91454, 91454, false), // 19099
		FINAL_ROOM_KEY(989, 91454, 91454, 91454, false), // 19100
		CUSTOM_SLAY_HELM(13263, 97500, 97501, 97501, false), // 19101
		CUSTOM_TEXTURIZED_BOW(4706, 90686, 90687, 90687, true), // 19102
		RAINBOW_SLED(4084, 94564, 94564, 94564, true), // 19103
		LMS_KEY(989, 91454, 91454, 91454, false), // 19104
		RAINBOW_TEXTURIZED_PARTYHAT(1040, 96041, 96042, 96042, false), // 19105
		EMPIRE_HELMET(3087, 96041, 96042, 96042, false), // 19091
		;

		private int copy;
		private int inventory;
		private int female;
		private int male;
		private boolean weapon;
		private int[] editedModelColor;
		private int[] originalModelColor;
		private boolean copyDef;

		CustomItems(int copy, int model, boolean weapon) {
			this.setCopy(copy);
			this.setInventory(model);
			this.setFemale(model);
			this.setMale(model);
			this.setWeapon(weapon);
		}

		CustomItems(int copy, int inventory, int wield, boolean weapon) {
			this.setCopy(copy);
			this.setInventory(inventory);
			this.setFemale(wield);
			this.setMale(wield);
			this.setWeapon(weapon);
		}

		CustomItems(int copy, int inventory, int female, int male, boolean weapon) {
			this.setCopy(copy);
			this.setInventory(inventory);
			this.setFemale(female);
			this.setMale(male);
			this.setWeapon(weapon);
		}

		CustomItems(int copy, int[] editedModelColor, int[] originalModelColor) {
			setCopyDef(true);
			this.setCopy(copy);
			this.editedModelColor = editedModelColor;
			this.originalModelColor = originalModelColor;
		}

		public int getCopy() {
			return copy;
		}

		public void setCopy(int copy) {
			this.copy = copy;
		}

		public int getInventory() {
			return inventory;
		}

		public void setInventory(int inventory) {
			this.inventory = inventory;
		}

		public int getFemale() {
			return female;
		}

		public void setFemale(int female) {
			this.female = female;
		}

		public int getMale() {
			return male;
		}

		public void setMale(int male) {
			this.male = male;
		}

		public boolean isWeapon() {
			return weapon;
		}

		public void setWeapon(boolean weapon) {
			this.weapon = weapon;
		}

		public int[] getEditedModelColor() {
			return editedModelColor;
		}

		public void setEditedModelColor(int[] editedModelColor) {
			this.editedModelColor = editedModelColor;
		}

		public int[] getOriginalModelColor() {
			return originalModelColor;
		}

		public void setOriginalModelColor(int[] originalModelColor) {
			this.originalModelColor = originalModelColor;
		}

		public boolean isCopyDef() {
			return copyDef;
		}

		public void setCopyDef(boolean copyDef) {
			this.copyDef = copyDef;
		}
	}
	
	private final static Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
			.setPrettyPrinting()
			.create();
	
	private final static Type TYPE = new TypeToken<HashSet<ItemDef>>() {}.getType();
	
	private static boolean hasLoadedCustomItems = false;

	public static String ucFirst(String str) {
		str = str.toLowerCase().replaceAll("_", " ");
		if (str.length() > 1) {
			str = str.substring(0, 1).toUpperCase() + str.substring(1);
		} else {
			return str.toUpperCase();
		}
		return str;
	}

	public static ItemDef forID(int i) {
		if (i != Client.debuggingItem) {
			for (int j = 0; j < 10; j++)
				if (cache[j].id == i) {
					return cache[j];
				}
		}
		cacheIndex = (cacheIndex + 1) % 10;
		ItemDef itemDef = cache[cacheIndex];
		if (i >= streamIndices.length) {
			itemDef.id = 1;
			itemDef.setDefaults();
			return itemDef;
		}
		stream.currentOffset = streamIndices[i];
		itemDef.id = i;
		itemDef.setDefaults();
		
		itemDef.readValues(stream);
		
		/*try {
			DefEditorSceneController.loadCustomItems();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		/*try {
			ItemEditorSceneController.loadCustomItems();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		if (itemDef.certTemplateID != -1) {
			itemDef.toNote();
		}
		if (itemDef.lentItemID != -1) {
			itemDef.toLend();
		}
		/*
		 * if (itemDef.id == i && itemDef.editedModelColor == null) {
		 * itemDef.editedModelColor = new int[1]; itemDef.newModelColor = new int[1];
		 * itemDef.editedModelColor[0] = 0; itemDef.newModelColor[0] = 1; }
		 */
		if (untradeableItems.contains(itemDef.id)) {
			itemDef.untradeable = true;
		}
		//itemDef.value = prices[itemDef.id];
		boolean dump = false;
		if (dump) {
			System.out.println("item name: " + itemDef.name + "");
			System.out.println("model id = " + itemDef.modelID + "");
		}
		int custom_start = 18888;
		// System.out.println("Custom items: "+CustomItems.values().length);
		for (CustomItems custom : CustomItems.values()) {
			if (i == custom_start + custom.ordinal()) {
				itemDef = copyRotations(itemDef, custom.getCopy());
				itemDef.name = ucFirst(custom.name());
				if (custom.isCopyDef()) {
					ItemDef def2 = ItemDef.forID(custom.getCopy());
					itemDef.modelID = def2.modelID;
					itemDef.maleEquip1 = def2.maleEquip1;
					itemDef.femaleEquip1 = def2.femaleEquip1;
					itemDef.originalModelColors = custom.editedModelColor;
					itemDef.newModelColor = custom.originalModelColor;
				} else {
					itemDef.modelID = custom.getInventory();
					itemDef.maleEquip1 = custom.getMale();
					itemDef.femaleEquip1 = custom.getFemale();
				}
				itemDef.actions = new String[5];
				itemDef.actions[1] = custom.isWeapon() ? "Wield" : "Wear";
			}
			switch(itemDef.id) {
			
				
			case 19106:
				copyModel(itemDef, 19886);
				itemDef.name = "@or2@Collector's Necklace @red@(I)";
				itemDef.shadow = 131;
				break;
				
			case 19150:
				itemDef.modelID = 28300;
				itemDef.maleEquip1 = 28300;
				itemDef.femaleEquip1 = 28300;
				break;
				
			case 19151:
				itemDef.modelID = 28301;
				itemDef.maleEquip1 = 28301;
				itemDef.femaleEquip1 = 28301;
				break;
				
			case 19152:
				itemDef.modelID = 28302;
				itemDef.maleEquip1 = 28302;
				itemDef.femaleEquip1 = 28302;
				break;
				
			case 18950:
				itemDef.modelZoom = 3405;
				break;
			}
		}
		
		if (Client.itemDebug) {
			if (itemDef.id == Client.debuggingItem) {
				itemDef.name = "Debugging " + Client.debuggingItem;
				itemDef.rotationY = (Client.iRoty != 0 ? Client.iRoty : itemDef.rotationY);
				itemDef.modelZoom = (Client.iZoom != 0 ? Client.iZoom : itemDef.modelZoom);
				itemDef.rotationX = (Client.iRotx != 0 ? Client.iRotx : itemDef.rotationX);
				itemDef.modelOffset1 = (Client.iOffx != 0 ? Client.iOffx : itemDef.modelOffset1);
				// itemDef.modelOffset2 = (Client.iOffy != 0 ? Client.iOffy :
				// itemDef.modelOffset2);
			}
		}

		//ItemDef_Emerald.newIDS(itemDef, i);
		ItemDef_Milo.newIDS(itemDef, i);
        Obj.forId(i, itemDef);
		return ItemDef_Suic.newIDS(itemDef, i);
	}

	private void readValues(Stream stream) {
		
		do {
			int i = stream.readUnsignedByte();
			if (i == 0) {
				return;
			}
			
			//System.out.println(id +" " + Arrays.toString(originalModelColors) + " " + Arrays.toString(newModelColor));
			
			if (i == 1) {
				modelID = stream.readInt();
			} else if (i == 2) {
				name = stream.readString();
			} else if (i == 3) {
				description = stream.readString();
			} else if (i == 4) {
				modelZoom = stream.readUnsignedWord();
			} else if (i == 5) {
				rotationY = stream.readUnsignedWord();
			} else if (i == 6) {
				rotationX = stream.readUnsignedWord();
			} else if (i == 7) {
				modelOffset1 = stream.readUnsignedWord();
				if (modelOffset1 > 32767) {
					modelOffset1 -= 0x10000;
				}
			} else if (i == 8) {
				modelOffsetY = stream.readUnsignedWord();
				if (modelOffsetY > 32767) {
					modelOffsetY -= 0x10000;
				}
			} else if (i == 10) {
				stream.readUnsignedWord();
			} else if (i == 11) {
				stackable = true;
			} else if (i == 12) {
				value = stream.readUnsignedWord();
			} else if (i == 15) {
                value = stream.readUnsignedWord();

			} else if (i == 16) {
				membersObject = true;
			} else if (i == 23) {
				maleEquip1 = stream.readInt();
				maleYOffset = stream.readSignedByte();
			} else if (i == 24) {
				maleEquip2 = stream.readInt();
			} else if (i == 25) {
				femaleEquip1 = stream.readInt();
				femaleYOffset = stream.readSignedByte();
			} else if (i == 26) {
				femaleEquip2 = stream.readInt();
			} else if (i >= 30 && i < 35) {
				if (groundActions == null) {
					groundActions = new String[5];
				}
				groundActions[i - 30] = stream.readString();
				if (groundActions[i - 30].equalsIgnoreCase("hidden")) {
					groundActions[i - 30] = null;
				}
			} else if (i >= 35 && i < 40) {
				if (actions == null) {
					actions = new String[5];
				}
				actions[i - 35] = stream.readString();
				if (actions[i - 35].equalsIgnoreCase("null")) {
					actions[i - 35] = null;
				}
			} else if (i == 40) {
				int j = stream.readUnsignedByte();
				originalModelColors = new int[j];
				newModelColor = new int[j];
				for (int k = 0; k < j; k++) {
					originalModelColors[k] = stream.readUnsignedWord();
					newModelColor[k] = stream.readUnsignedWord();
				}
			} else if (i == 78) {
				maleEquip3 = stream.readInt();
			} else if (i == 79) {
				femaleEquip3 = stream.readInt();
			} else if (i == 90) {
				maleDialogue = stream.readInt();
			} else if (i == 91) {
				femaleDialogue = stream.readInt();
			} else if (i == 92) {
				maleDialogueModel = stream.readInt();
			} else if (i == 93) {
				femaleDialogueModel = stream.readInt();
			} else if (i == 95) {
				modelOffsetX = stream.readUnsignedWord();
			} else if (i == 97) {
				certID = stream.readUnsignedWord();
			} else if (i == 98) {
				certTemplateID = stream.readUnsignedWord();
			} else if (i >= 100 && i < 110) {
				if (stackIDs == null) {
					stackIDs = new int[10];
					stackAmounts = new int[10];
				}
				stackIDs[i - 100] = stream.readUnsignedWord();
				stackAmounts[i - 100] = stream.readUnsignedWord();
			} else if (i == 110) {
				sizeX = stream.readUnsignedWord();
			} else if (i == 111) {
				sizeY = stream.readUnsignedWord();
			} else if (i == 112) {
				sizeZ = stream.readUnsignedWord();
			} else if (i == 113) {
				shadow = stream.readSignedByte();
			} else if (i == 114) {
				lightness = stream.readSignedByte() * 5;
			} else if (i == 115) {
				team = stream.readUnsignedByte();
			} else if (i == 116) {
				lendID = stream.readUnsignedWord();
			} else if (i == 117) {
                lentItemID = stream.readUnsignedWord();
            } else {
System.out.println("Wow unknown opcode: " + i);
            }
			
		} while (true);
		
	}

	public static void setSettings() {
		try {
			prices = new int[22694];
			int index = 0;
			for (String line : Files.readAllLines(Paths.get(signlink.findcachedir() + "data/data.txt"),
					Charset.defaultCharset())) {
				prices[index] = Integer.parseInt(line);
				index++;
			}
			for (int i : UNTRADEABLE_ITEMS) {
				untradeableItems.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void toNote() {
		ItemDef itemDef = forID(certTemplateID);
		modelID = itemDef.modelID;
		transLevel = itemDef.transLevel;
		transColor = itemDef.transColor;
		modelZoom = itemDef.modelZoom;
		rotationY = itemDef.rotationY;
		rotationX = itemDef.rotationX;
		modelOffsetX = itemDef.modelOffsetX;
		modelOffset1 = itemDef.modelOffset1;
		modelOffsetY = itemDef.modelOffsetY;
		originalModelColors = itemDef.originalModelColors;
		newModelColor = itemDef.newModelColor;
		ItemDef itemDef_1 = forID(certID);
		name = itemDef_1.name;
		membersObject = itemDef_1.membersObject;
		value = itemDef_1.value;
		String s = "a";
		if (name != null) {
	        char c = itemDef_1.name.charAt(0);
	        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
	            s = "an";
	        }
	}
		description = ("Swap this note at any bank for " + s + " " + itemDef_1.name + ".");
		stackable = true;
	}

	private void toLend() {
		ItemDef itemDef = forID(lentItemID);
		actions = new String[5];
		modelID = itemDef.modelID;
		modelOffset1 = itemDef.modelOffset1;
		rotationX = itemDef.rotationX;
		modelOffsetY = itemDef.modelOffsetY;
		modelZoom = itemDef.modelZoom;
		rotationY = itemDef.rotationY;
		modelOffsetX = itemDef.modelOffsetX;
		value = 0;
		ItemDef itemDef_1 = forID(lendID);
		maleDialogueModel = itemDef_1.maleDialogueModel;
		originalModelColors = itemDef_1.originalModelColors;
		maleEquip3 = itemDef_1.maleEquip3;
		maleEquip2 = itemDef_1.maleEquip2;
		femaleDialogueModel = itemDef_1.femaleDialogueModel;
		maleDialogue = itemDef_1.maleDialogue;
		groundActions = itemDef_1.groundActions;
		maleEquip1 = itemDef_1.maleEquip1;
		name = itemDef_1.name;
		femaleEquip1 = itemDef_1.femaleEquip1;
		membersObject = itemDef_1.membersObject;
		femaleDialogue = itemDef_1.femaleDialogue;
		femaleEquip2 = itemDef_1.femaleEquip2;
		femaleEquip3 = itemDef_1.femaleEquip3;
		newModelColor = itemDef_1.newModelColor;
		team = itemDef_1.team;
		if (itemDef_1.actions != null) {
			for (int i_33_ = 0; i_33_ < 4; i_33_++) {
				actions[i_33_] = itemDef_1.actions[i_33_];
			}
		}
		actions[4] = "Discard";
	}

	public static Sprite getSprite(int i, int j, int k) {
		if (k == 0 && !Client.itemEditing) {
			Sprite sprite = (Sprite) spriteCache.get(i);
			if (sprite != null && sprite.maxHeight != j && sprite.maxHeight != -1) {
				sprite.unlink();
				sprite = null;
			}
			if (sprite != null) {
				return sprite;
			}
		}
		ItemDef itemDef = forID(i);
		if (itemDef.stackIDs == null) {
			j = -1;
		}
		if (j > 1) {
			int i1 = -1;
			for (int j1 = 0; j1 < 10; j1++) {
				if (j >= itemDef.stackAmounts[j1] && itemDef.stackAmounts[j1] != 0) {
					i1 = itemDef.stackIDs[j1];
				}
			}
			if (i1 != -1) {
				itemDef = forID(i1);
			}
		}
		Model model = itemDef.getItemModelFinalised(1);
		if (model == null) {
			return null;
		}
		Sprite sprite = null;
		if (itemDef.certTemplateID != -1) {
			sprite = getSprite(itemDef.certID, 10, -1);
			if (sprite == null) {
				return null;
			}
		}
		if (itemDef.lentItemID != -1) {
			sprite = getSprite(itemDef.lendID, 50, 0);
			if (sprite == null) {
				return null;
			}
		}
		Sprite sprite2 = new Sprite(32, 32);
		int k1 = Rasterizer.textureInt1;
		int l1 = Rasterizer.textureInt2;
		int ai[] = Rasterizer.anIntArray1472;
		int ai1[] = DrawingArea.pixels;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.clipLeft;
		int l2 = DrawingArea.clipRight;
		int i3 = DrawingArea.clipTop;
		int j3 = DrawingArea.clipBottom;
		Rasterizer.aBoolean1464 = false;
		DrawingArea.initDrawingArea(32, 32, sprite2.myPixels);
		DrawingArea.drawPixels(32, 0, 0, 0, 32);
		Rasterizer.setDefaultBounds();
		int k3 = itemDef.modelZoom;
		if (k == -1) {
			k3 = (int) (k3 * 1.5D);
		}
		if (k > 0) {
			k3 = (int) (k3 * 1.04D);
		}
		int l3 = Rasterizer.anIntArray1470[itemDef.rotationY] * k3 >> 16;
		int i4 = Rasterizer.anIntArray1471[itemDef.rotationY] * k3 >> 16;
		model.renderSingle(itemDef.rotationX, itemDef.modelOffsetX, itemDef.rotationY, itemDef.modelOffset1,
				l3 + model.modelHeight / 2 + itemDef.modelOffsetY, i4 + itemDef.modelOffsetY);
		sprite2.outline(1);
		if (k > 0)
			sprite2.outline(16777215);

		if (k == 0)
			sprite2.shadow(3153952);
		DrawingArea.initDrawingArea(32, 32, sprite2.myPixels);
		if (itemDef.certTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		if (itemDef.lentItemID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		
		
		if (k == 0 && !itemDef.animateInventory) {
			//System.out.println("DIDNT CACHE: " + itemDef.id);
			spriteCache.put(sprite2, i);
		}
		DrawingArea.initDrawingArea(j2, i2, ai1);
		DrawingArea.setDrawingArea(j3, k2, l2, i3);
		Rasterizer.textureInt1 = k1;
		Rasterizer.textureInt2 = l1;
		Rasterizer.anIntArray1472 = ai;
		Rasterizer.aBoolean1464 = true;
		sprite2.maxWidth = itemDef.stackable ? 33 : 32;
		sprite2.maxHeight = j;
		return sprite2;
	}

	public Model getItemModelFinalised(int amount) {
		if (stackIDs != null && amount > 1) {
			int stackId = -1;
			for (int k = 0; k < 10; k++) {
				if (amount >= stackAmounts[k] && stackAmounts[k] != 0) {
					stackId = stackIDs[k];
				}
			}
			if (stackId != -1) {
				return forID(stackId).getItemModelFinalised(1);
			}
		}
		Model model = (Model) modelCache.get(id);
		if (model != null) {
			return model;
		}
		model = Model.fetchModel(modelID);
		if (model == null) {
			return null;
		}
		if (sizeX != 128 || sizeY != 128 || sizeZ != 128) {
			model.scaleT(sizeX, sizeZ, sizeY);
		}
		if (originalModelColors != null) {
			for (int l = 0; l < originalModelColors.length; l++) {
				model.recolour(originalModelColors[l], newModelColor[l]);
			}
		}
		if (transColor != null) {
			for (int l1d = 0; l1d < transColor.length; ++l1d) {
				model.setAlphaToColor(transColor[l1d], transLevel[l1d]);
			}
		}
		applyTexturing(model, id);
		model.light(64 + shadow, 768 + lightness, -50, -10, -50, true);
		model.rendersWithinOneTile = true;
		modelCache.put(model, id);
		return model;
	}

	public Model getItemModel(int i) {
		if (stackIDs != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++) {
				if (i >= stackAmounts[k] && stackAmounts[k] != 0) {
					j = stackIDs[k];
				}
			}
			if (j != -1) {
				return forID(j).getItemModel(1);
			}
		}
		Model model = Model.fetchModel(modelID);
		if (model == null) {
			return null;
		}
		if (originalModelColors != null) {
			for (int l = 0; l < originalModelColors.length; l++) {
				if (l < newModelColor.length)
					model.recolour(originalModelColors[l], newModelColor[l]);
			}
		}
		if (transColor != null) {
			for (int l4 = 0; l4 < transColor.length; ++l4) {
				model.setAlphaToColor(transColor[l4], transLevel[l4]);
			}
		}
		applyTexturing(model, id);
		return model;
	}
	
	
	public void recolor(int targetColor, int newColor) { // edited by Milo
		
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
	
	/* (test)public void recolor(int targetColor, int newColor) {
		int slot = originalModelColors != null ? originalModelColors.length : 1;
				originalModelColors[slot] = targetColor;
				newModelColor[slot] = newColor;
	}*/
	

	public static final int[] UNTRADEABLE_ITEMS = { 13661, 13262, 6529, 6950, 1464, 2996, 2677, 2678, 2679, 2680, 2682,
			2683, 2684, 2685, 2686, 2687, 2688, 2689, 2690, 6570, 12158, 12159, 12160, 12163, 12161, 12162, 19143,
			19149, 19146, 19157, 19162, 19152, 4155, 8850, 10551, 8839, 8840, 8842, 11663, 11664, 11665, 3842, 3844,
			3840, 8844, 8845, 8846, 8847, 8848, 8849, 8850, 10551, 7462, 7461, 7460, 7459, 7458, 7457, 7456, 7455, 7454,
			7453, 8839, 8840, 8842, 11663, 11664, 11665, 10499, 9748, 9754, 9751, 9769, 9757, 9760, 9763, 9802, 9808,
			9784, 9799, 9805, 9781, 9796, 9793, 9775, 9772, 9778, 9787, 9811, 9766, 9749, 9755, 9752, 9770, 9758, 9761,
			9764, 9803, 9809, 9785, 9800, 9806, 9782, 9797, 9794, 9776, 9773, 9779, 9788, 9812, 9767, 9747, 9753, 9750,
			9768, 9756, 9759, 9762, 9801, 9807, 9783, 9798, 9804, 9780, 9795, 9792, 9774, 9771, 9777, 9786, 9810, 9765,
			9948, 9949, 9950, 12169, 12170, 12171, 20671, 14641, 14642, 6188, 10954, 10956, 10958, 3057, 3058, 3059,
			3060, 3061, 7594, 7592, 7593, 7595, 7596, 14076, 14077, 14081, 10840, 10836, 6858, 6859, 10837, 10838,
			10839, 9925, 9924, 9923, 9922, 9921, 4084, 4565, 20046, 20044, 20045, 1050, 14595, 14603, 14602, 14605,
			11789, 19708, 19706, 19707, 4860, 4866, 4872, 4878, 4884, 4896, 4890, 4896, 4902, 4932, 4938, 4944, 4950,
			4908, 4914, 4920, 4926, 4956, 4926, 4968, 4994, 4980, 4986, 4992, 4998, 18778, 18779, 18780, 18781, 13450,
			13444, 13405, 15502, 10548, 10549, 10550, 10551, 10555, 10552, 10553, 2412, 2413, 2414, 20747, 18365, 18373,
			18371, 15246, 12964, 12971, 12978, 14017, 757, 8851, 13855, 13848, 13857, 13856, 13854, 13853, 13852, 13851,
			13850, 5509, 13653, 14021, 14020, 19111, 14019, 14022, 19785, 19786, 18782, 18351, 18349, 18353, 18357,
			18355, 18359, 18335 };

	public ItemDef() {
		id = -1;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getModelId() {
		return modelID;
	}

	public void setModelId(int modelID) {
		this.modelID = modelID;
	}

	public Model getModel() {
		Model model = (Model) modelCache.get(getId());
		if (model != null)
			return model;
		model = Model.fetchModel(getModelId());
		if (model == null)
			return null;

		int length = Math.max(originalModelColors.length, newModelColor.length);
		for (int i = 0; i < length; i++) {
			if (i < originalModelColors.length && i < newModelColor.length) {
				model.recolour(originalModelColors[i], newModelColor[i]);
			}
		}
		modelCache.put(model, getId());
		return model;

	}
	
	@Expose public int id;
	@Expose public byte femaleYOffset;
	public int value;
	@Expose public int[] originalModelColors;
	public static MemCache spriteCache = new MemCache(100);
	public static MemCache modelCache = new MemCache(50);
	@Expose public int[] newModelColor;
	public boolean membersObject;
	public int femaleEquip3;
	public int certTemplateID;
	public int femaleEquip2;
	@Expose public int maleEquip1;
	public int maleDialogueModel;
	public int sizeX;
	public String groundActions[];
	public int modelOffset1;
	public String name;
	public static ItemDef[] cache;
	public int femaleDialogueModel;
	@Expose public int modelID;
	public int maleDialogue;
	public boolean stackable;
	public String description;
	public int certID;
	public static int cacheIndex;
	@Expose public int modelZoom;
	public static Stream stream;
	public int lightness;
	public int maleEquip3;
	public int maleEquip2;
	public String actions[];
	@Expose public int rotationY;
	public int sizeZ;
	public int sizeY;
	public int[] stackIDs;
	public int modelOffsetY;
	public static int[] streamIndices;
	//public int tenthOpcode;
	@Expose public int shadow;
	public int femaleDialogue;
	@Expose public int rotationX;
	@Expose public int femaleEquip1;
	public int[] stackAmounts;
	public int team;
	public static int totalItems;
	public int modelOffsetX;
	@Expose public byte maleYOffset;
	@Expose public byte maleXOffset;
	public int lendID;
	public int lentItemID;
	public boolean untradeable;
	public int[] editedModelColor;
	
}
