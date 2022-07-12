package com.arlania;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

@SuppressWarnings("all")
public final class ObjectDef {

	public static void dump() {
		for (int i = 0; i < streamIndices667.length - 1; i++) {
			ObjectDef object = forID(i);
			BufferedWriter bw = null;
			System.out.println("dumped " + i);
			try {
				bw = new BufferedWriter(new FileWriter("./objects.txt", true));
				bw.write("ID: " + i);
				bw.newLine();
				if (object.name != null) {
					bw.write("Name: " + object.name);
					bw.newLine();
				}
				bw.write("models: ");
				if (object.objectModelIDs != null)
					for (int model : object.objectModelIDs)
						bw.write(model + ", ");
				bw.newLine();
				bw.write("types: ");
				if (object.objectModelTypes != null)
					for (int type : object.objectModelTypes)
						bw.write(type + ", ");
				bw.newLine();
				bw.write("children ids: ");
				if (object.configObjectIDs != null)
					for (int type : object.configObjectIDs)
						bw.write(type + ", ");
				bw.newLine();
				bw.write("Varbit idx: " + object.varbitIndex);
				bw.newLine();
				bw.write("Config idx: " + object.configID);
				bw.newLine();
				bw.write("actions: ");
				if (object.actions != null)
					for (String type : object.actions)
						bw.write(type + ", ");
				bw.newLine();
				bw.newLine();
				bw.newLine();
				bw.flush();
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static ObjectDef forIDOSRS(int i) {
		for (int j = 0; j < 20; j++) {
			if (cache[j].type == i) {
				return cache[j];
			}
		}
		cacheIndex = (cacheIndex + 1) % 20;
		ObjectDef objectDef = cache[cacheIndex];
		streamOSRS.currentOffset = streamIndicesOSRS[i];
		objectDef.type = i;
		objectDef.setDefaults();
		try {
			objectDef.readValues(streamOSRS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectDef;
	}

	private static boolean isOSRSObject(int objectId) {
		for (int i = 0; i < OBJECTS_OSRS.length; i++) {
			if (objectId == OBJECTS_OSRS[i]) {
				return true;
			}
		}
		return false;
	}

	private static final int[] OBJECTS_OSRS = {

			732, 4451, 6926, 7823, 7824, 7825, 7826, 7827, 7828, 7829, 7830, 7834, 11853, 14645, 14674, 14675, 17118,
			20196, 21696, 21697, 21698, 21699, 21700, 21701, 21702, 21703, 21704, 21705, 21706, 21707, 21708, 21709,
			21710, 21711, 21712, 21713, 21714, 21715, 21716, 21717, 21718, 21748, 21749, 21750, 21751, 21752, 21753,
			21754, 21755, 21756, 21757, 21758, 21759, 21760, 21761, 21762, 21763, 21765, 21766, 21767, 21768, 21769,
			21770, 21772, 21773, 21775, 21776, 21777, 21779, 21780, 21946, 21947, 22494, 22495, 23100, 23101, 26571,
			26572, 1502, 12930, 12931, 12932, 20737, 23102, 23104, 23106, 23107, 23108, 23109, 23112, 23610, 26294,
			6775, 27059, 27059, 26765,

			11698, 11699, 11700,

			26765 };
	private final static int[] hotSpotIDs = new int[] { 13374, 13375, 13376, 13377, 13378, 39260, 39261, 39262, 39263,
			39264, 39265, 2715, 13366, 13367, 13368, 13369, 13370, 13371, 13372, 15361, 15362, 15363, 15366, 15367,
			15364, 15365, 15410, 15412, 15411, 15414, 15415, 15413, 15416, 15416, 15418, 15419, 15419, 15419, 15419,
			15419, 15419, 15419, 15419, 15402, 15405, 15401, 15398, 15404, 15403, 15400, 15400, 15399, 15302, 15302,
			15302, 15302, 15302, 15302, 15304, 15303, 15303, 15301, 15300, 15300, 15300, 15300, 15299, 15299, 15299,
			15299, 15298, 15443, 15445, 15447, 15446, 15444, 15441, 15439, 15448, 15450, 15266, 15265, 15264, 15263,
			15263, 15263, 15263, 15263, 15263, 15263, 15263, 15267, 15262, 15260, 15261, 15268, 15379, 15378, 15377,
			15386, 15383, 15382, 15384, 34255, 15380, 15381, 15346, 15344, 15345, 15343, 15342, 15296, 15297, 15297,
			15294, 15293, 15292, 15291, 15290, 15289, 15288, 15287, 15286, 15282, 15281, 15280, 15279, 15278, 15277,
			15397, 15396, 15395, 15393, 15392, 15394, 15390, 15389, 15388, 15387, 44909, 44910, 44911, 44908, 15423,
			15423, 15423, 15423, 15420, 48662, 15422, 15421, 15425, 15425, 15424, 18813, 18814, 18812, 18815, 18811,
			18810, 15275, 15275, 15271, 15271, 15276, 15270, 15269, 13733, 13733, 13733, 13733, 13733, 13733, 15270,
			15274, 15273, 15406, 15407, 15408, 15409, 15368, 15375, 15375, 15375, 15375, 15376, 15376, 15376, 15376,
			15373, 15373, 15374, 15374, 15370, 15371, 15372, 15369, 15426, 15426, 15435, 15438, 15434, 15434, 15431,
			15431, 15431, 15431, 15436, 15436, 15436, 15436, 15436, 15436, 15437, 15437, 15437, 15437, 15437, 15437,
			15350, 15348, 15347, 15351, 15349, 15353, 15352, 15354, 15356, 15331, 15331, 15331, 15331, 15355, 15355,
			15355, 15355, 15330, 15330, 15330, 15330, 15331, 15331, 15323, 15325, 15325, 15324, 15324, 15329, 15328,
			15326, 15327, 15325, 15325, 15324, 15324, 15330, 15330, 15330, 15330, 15331, 15331, 34138, 15330, 15330,
			34138, 34138, 15330, 34138, 15330, 15331, 15331, 15337, 15336, 39230, 39231, 36692, 39229, 36676, 34138,
			15330, 15330, 34138, 34138, 15330, 34138, 15330, 15331, 15331, 36675, 36672, 36672, 36675, 36672, 36675,
			36675, 36672, 15331, 15331, 15330, 15330, 15257, 15256, 15259, 15259, 15327, 15326 };

	public static ObjectDef forID(int i) {
		boolean loadNew = (
		/* i == 8550 || i == 8551 || i == 7847 || i == 8150 || */i == 32159 || i == 32157 || i == 36672 || i == 36675
				|| i == 36692 || i == 34138 || i >= 39260 && i <= 39271 || i == 39229 || i == 39230 || i == 39231
				|| i == 36676 || i == 36692 || i > 11915 && i <= 11929 || i >= 11426 && i <= 11444
				|| i >= 14835 && i <= 14845 || i >= 11391 && i <= 11397 || i >= 12713 && i <= 12715);
		for (int j = 0; j < 20; j++)
			if (cache[j].type == i) {
				return cache[j];
			}
		if (isOSRSObject(i)) {
			return forIDOSRS(i);
		}
		cacheIndex = (cacheIndex + 1) % 20;
		ObjectDef objectDef = cache[cacheIndex];
		try {

			if (i > streamIndices.length || loadNew)
				stream667.currentOffset = streamIndices667[i];
			else
				stream.currentOffset = streamIndices[i];
		} catch (Exception e) {
			e.printStackTrace();
		}
		objectDef.type = i;
		objectDef.setDefaults();
		if (i > streamIndices.length || loadNew)
			objectDef.readValues(stream667);
		else
			objectDef.readValues(stream);
		/* Removing doors etc */
		boolean removeObject = i == 5244 || i == 2623 || i == 2956 || i == 463 || i == 462 || i == 10527 || i == 10529
				|| i == 40257 || i == 296 || i == 300 || i == 1747 || i == 7332 || i == 7326 || i == 7325 || i == 7385
				|| i == 7331 || i == 7385 || i == 7320 || i == 7317 || i == 7323 || i == 7354 || i == 1536 || i == 1537
				|| i == 5126 || i == 1551 || i == 1553 || i == 1516 || i == 1519 || i == 1557 || i == 1558 || i == 7126
				|| i == 733 || i == 14233 || i == 14235 || i == 1596 || i == 1597 || i == 14751 || i == 14752
				|| i == 14923 || i == 36844 || i == 30864 || i == 2514 || i == 1805 || i == 15536 || i == 2399
				|| i == 14749 || i == 29315 || i == 29316 || i == 29319 || i == 29320 || i == 29360 || i == 1528
				|| i == 36913 || i == 36915 || i == 15516 || i == 35549 || i == 35551 || i == 26808 || i == 26910
				|| i == 26913 || i == 24381 || i == 15514 || i == 25891 || i == 26082 || i == 26081 || i == 1530
				|| i == 16776 || i == 16778 || i == 28589 || i == 1533 || i == 17089 || i == 1600 || i == 1601
				|| i == 11707 || i == 24376 || i == 24378 || i == 40108 || i == 59 || i == 2069 || i == 36846
				|| i == 1534 || i == 1531 || i == 2595;
		if (removeObject) {
			for (int i4 = 0; i4 < objectDef.objectModelIDs.length; i4++)
				objectDef.objectModelIDs[i4] = 0;
			objectDef.isUnwalkable = false;
			return objectDef;
		}
		if (objectDef.varbitIndex <= 484 && objectDef.varbitIndex >= 469) {
			objectDef.configID = objectDef.varbitIndex;
			objectDef.varbitIndex = -1;
		}
		if (objectDef.name != null && i != 591) {
			String s = objectDef.name.toLowerCase();
			if (s.contains("bank") && !s.contains("closed")) {
				objectDef.actions = new String[5];
				objectDef.actions[0] = "Use";
			}
		}
		


		if (i == 375) {
			objectDef.name = "@red@SebZero Chest @yel@(Easy)";
		}
		
		if (i == 5542) {
			objectDef.objectModelIDs = new int[] { 42745};
			objectDef.name = "@whi@Summer Event Pinata";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@or2@Open";
			objectDef.actions[1] = "@re1@Check rewards";
		}
		if (i == 2396) {
			objectDef.name = "@whi@Bed";
		}
		if (i == 15471) {
			objectDef.name = "@whi@Cash bowl";
		}
		if (i == 47748) {
			objectDef.name = "@gre@Christmas Tree";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@red@Offer presents";
		}
		if (i == 2615) {
			objectDef.name = "@whi@Coffin";
		}
		if (i == 2145) {
			objectDef.name = "@whi@Coffin";
		}
		if (i == 866) {
			objectDef.objectModelIDs = new int[] { 42803};
			objectDef.name = "@whi@Doll";
		}
		if (i == 867) {
			objectDef.objectModelIDs = new int[] { 35082};
			objectDef.name = "@whi@T.V";
			objectDef.modelSizeX = 200;
			objectDef.modelSizeH = 200;
			objectDef.modelSizeY = 200;
		}
		if (i == 3005) {
			objectDef.objectModelIDs = new int[] {2207};
			objectDef.name = "@gre@Salvage @mag@Statue";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@whi@Exchange";
		}
		if (i == 592) {
			objectDef.objectModelIDs = new int[] {44892};
			objectDef.name = "@yel@Smite @red@Barrows";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Teleport-to";
			objectDef.modelSizeX = 165;
			objectDef.modelSizeH = 165;
			objectDef.modelSizeY = 165;
		}
		if (i == 3006) {
			objectDef.objectModelIDs = new int[] { 2208};
			objectDef.name = "@red@Weapon Upgrade Statue";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@whi@Exchange";
		}
		if (i == 3010) {
			objectDef.objectModelIDs = new int[] { 2209};
			objectDef.name = "@cya@Misc Upgrade Statue";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@whi@Exchange";
		}
		if (i == 3008) {
			objectDef.objectModelIDs = new int[] { 2210};
			objectDef.name = "@yel@Armor Upgrade Statue";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@whi@Exchange";
		}
		if (i == 5411) {
			objectDef.objectModelIDs = new int[] {30921};
			objectDef.name = "@mag@SebZero @or2@Halloween@mag@ Event @or2@2021";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@bla@Enter";
		}
		if (i == 2021) {
			objectDef.objectModelIDs = new int[] { 34885};
			objectDef.name = "@cya@Forge@mag@ Table";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@whi@Use";
			objectDef.modelSizeX = 200;
			objectDef.modelSizeH = 200;
			objectDef.modelSizeY = 200;
		}
		if (i == 26270) {
			objectDef.name = "@or2@Pumpkin";
		}
		if (i == 13481) {
			objectDef.hasActions = false;
		}
		if (i == 21181) {
			objectDef.name = "@whi@Abandoned shed";
			objectDef.hasActions = false;
		}
		if (i == 1) {
			objectDef.hasActions = false;
		}
		if (i == 64) {
			objectDef.hasActions = false;
		}
		if (i == 4301) {
			objectDef.hasActions = false;
		}
		if (i == 1990) {
			objectDef.hasActions = false;
		}
		if (i == 3009) {
			objectDef.objectModelIDs = new int[] { 2211};
			objectDef.name = "@mag@Battlepass Statue";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@whi@Exchange";
		}
		if (i == 6301) {
			objectDef.name = "@mag@Q's Throne";
			objectDef.objectModelIDs = new int[] { 6164};
		}
		if (i == 797) {
			objectDef.mapSceneID = -1;
			objectDef.objectModelIDs = new int[] { 12528};
		}
		if (i == 798) {
			objectDef.mapSceneID = -1;
			objectDef.objectModelIDs = new int[] { 12529};
		}
		if (i == 799) {
			objectDef.mapSceneID = -1;
			objectDef.objectModelIDs = new int[] { 12527};
		}
		if (i == 4170) {
			objectDef.objectModelIDs = new int[] { 30884};
			objectDef.name = "@red@Bloodslayer chest";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@or2@Open";
			objectDef.actions[1] = "@bla@Check rewards";
			objectDef.modelSizeX = 200;
			objectDef.modelSizeH = 200;
			objectDef.modelSizeY = 200;
		}
		if (i == 4101) {
			objectDef.objectModelIDs = new int[] { 30884};
			objectDef.name = "@enc@Enchanted chest";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@or2@Open";
			objectDef.actions[1] = "@bla@Check rewards";
			objectDef.modelSizeX = 200;
			objectDef.modelSizeH = 200;
			objectDef.modelSizeY = 200;
		}
		if (i == 3662) {
			objectDef.objectModelIDs = new int[] { 50503};
			objectDef.name = "@gre@Superiors Coffin";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@or2@Search";
			objectDef.actions[1] = "@whi@Check rewards";
			objectDef.modelSizeX = 200;
			objectDef.modelSizeH = 200;
			objectDef.modelSizeY = 200;
		}
		
		if (i == 569) {
			objectDef.objectModelIDs = new int[] { 27248};
			objectDef.name = "@pur@Femboy's Statue";
			//objectDef.description = "A Sculpture of sharps wang, crafte by himself";
			objectDef.hasActions = false;
			objectDef.modelSizeX = 100;
			objectDef.modelSizeH = 100;
			objectDef.modelSizeY = 100;
		}
		
		if (i == 567) {
			objectDef.objectModelIDs = new int[] { 52154};
			objectDef.name = "Statue of Eset";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Investigate";
			objectDef.modelSizeX = 200;
			objectDef.modelSizeH = 200;
			objectDef.modelSizeY = 200;
		}
		if (i == 562) {
			objectDef.objectModelIDs = new int[] { 52155};
			objectDef.name = "Statue Of Poseidon";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Investigate";
			objectDef.modelSizeX = 185;
			objectDef.modelSizeH = 185;
			objectDef.modelSizeY = 185;
		}
		if (i == 563) {
			objectDef.objectModelIDs = new int[] { 52156};
			objectDef.name = "Statue Of Thannatos";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Investigate";
			objectDef.modelSizeX = 200;
			objectDef.modelSizeH = 200;
			objectDef.modelSizeY = 200;
		}
		if (i == 564) {
			objectDef.objectModelIDs = new int[] { 52157};
			objectDef.name = "Statue Of Jing Wei";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Investigate";
			objectDef.modelSizeX = 200;
			objectDef.modelSizeH = 200;
			objectDef.modelSizeY = 200;
		}
		if (i == 565) {
			objectDef.objectModelIDs = new int[] { 52158};
			objectDef.name = "Statue Of Artemis";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Investigate";
			objectDef.modelSizeX = 200;
			objectDef.modelSizeH = 200;
			objectDef.modelSizeY = 200;
		}
		if (i == 566) {
			objectDef.objectModelIDs = new int[] { 52159};
			objectDef.name = "Statue Of Nemisis";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Investigate";
			objectDef.modelSizeX = 200;
			objectDef.modelSizeH = 200;
			objectDef.modelSizeY = 200;
		}
		if (i == 3449) {
			objectDef.objectModelIDs = new int[] { 50503};
			objectDef.name = "@gre@Superiors Coffin";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@or2@Search";
			objectDef.actions[1] = "@whi@Check rewards";
			objectDef.modelSizeX = 200;
			objectDef.modelSizeH = 200;
			objectDef.modelSizeY = 200;
		}
		if (i == 4171) {
			objectDef.objectModelIDs = new int[] { 23608};
			objectDef.name = "@or1@Daily login reward chest";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@or2@Open";
		}
		
		
		if (i == 2213) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Open-Bank";
			objectDef.actions[1] = "@or2@Open-POS";
			objectDef.name = "@or1@Bank Booth";
		}

		if (i == 16792) {
			objectDef.objectModelIDs = new int[] { 16792};
			objectDef.actions[0] = "Kiss";
			objectDef.name = "@whi@Lucky dice";
		}
		if (i == 6970) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@or2@Board";
			objectDef.name = "Summertime boat";
		}
		if (i == 2337) {
			objectDef.objectModelIDs = new int[] { 44715};
			objectDef.name = "@or2@Item Forging Table";
		}
		
		if (i == 409) {
			objectDef.name = "@red@Altar";

		}
		
		if (i == 411) {
			objectDef.name = "@red@Chaos @gre@Altar";

		}
		
		if (i == 10660) {
			objectDef.name = "@red@ Deluxe @gre@Tree";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Cut down";
		}
		
		if (i == 23095) {
			objectDef.name = "@red@Final Room Portal";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Enter";
		}
		
		if(i == 4090) {
			objectDef.name = "@red@Special Altar";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@gre@Recharge Special";
		}
		if(i == 13479) {
			objectDef.name = "@red@Special Altar";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@gre@Recharge Stat's";
		}
		
		if (i == 4163) {
			objectDef.name = "@red@Bloodwell";
			objectDef.objectModelIDs = new int[] { 34256};
			objectDef.actions = new String[] { "@or2@Fill", "@mag@Open perk tree", null, null, null };
			objectDef.modelSizeX = 220;
			objectDef.modelSizeH = 220;
			objectDef.modelSizeY = 260;
		}
		
		
		if (i == 2160) {
			objectDef.name = "@gre@League @or2@of @blu@Legends @or2@Arcade";
			objectDef.objectModelIDs = new int[] { 13889};
			objectDef.actions[0] = "@whi@Play";
			objectDef.modelSizeX = 50;
			objectDef.modelSizeH = 50;
			objectDef.modelSizeY = 50;
		}
		
		if (i == 2161) {
			objectDef.name = "@gre@League @or2@of @blu@Legends Veigar Boss ";
			objectDef.objectModelIDs = new int[] { 52900};
			objectDef.actions[0] = "@whi@Play";
		}
		
		if (i == 4164) {
			objectDef.name = "@whi@Milos Dream";
			objectDef.objectModelIDs = new int[] { 41508};
			objectDef.actions[0] = "@or1@Visit";
		}
		
		
		if (i == 376) {
			objectDef.name = "@red@SebZero Chest @yel@(Medium)";
		}
		if (i == 1994) {
			objectDef.name = "@red@SebZero Chest @yel@(Hard)";
		}
		
		if (i == 5259) {
			objectDef.actions = new String[5];
			objectDef.name = "Ghost Town Barrier";
			objectDef.actions[0] = "Pass";
		}
		
		if (i == 11356) {
			objectDef.name = "@cya@Uber Zone";
			objectDef.actions[0] = "Visit";
		}
		
		if (i == 13619) {
			objectDef.name = "@red@Room 2 Portal";
			objectDef.actions[0] = "Enter";
		}

		if (i == 2466) {
			objectDef.name = "Key Floor 2 Portal";
			objectDef.actions[1] = "Info (Displays Information)";
		}
		if (i == 44379) {
			objectDef.name = "Bone Pile";
			objectDef.actions[0] = "Search the rubbish";
		}
		
		
		if (i == 2467) {
			objectDef.name = "Key Floor 3 Portal";
			objectDef.actions[1] = "Info (Displays Information)";
		}

		if (i == 10805 || i == 10806 || i == 10807) {
			objectDef.name = "Grand Exchange clerk";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Use";
		}
		if(i == 2469) {
			objectDef.name = "@red@Ironman Minigame";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@yel@Teleport";
		}
		if(i == 8972) {
			objectDef.name = "@red@Ironman Zone Room 2";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@or2@Teleport";
		}
		if (i == 10091) {
			objectDef.actions = new String[] { "Bait", null, null, null, null };
			objectDef.name = "@yel@Rocktail spot";
		}
		if (i == 7836 || i == 7808) {
			objectDef.hasActions = true;
			objectDef.actions = new String[] { "Dump-weeds", null, null, null, null };
			objectDef.name = "Compost bin";
		}
		if (i == 884) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Donate";
			objectDef.actions[1] = "Fall-in";
			objectDef.name = "Well of Goodwill";
		}
		if (i == 25014 || i == 25026 || i == 25020 || i == 25019 || i == 25024 || i == 25025 || i == 25016 || i == 5167
				|| i == 5168) {
			objectDef.actions = new String[5];
		}
		if (i == 1948) {
			objectDef.name = "Wall";
		}
		if (i == 21505 || i == 21507) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Go-through";
			objectDef.actions[1] = "Go Back";
		}
		if (i == 25029) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Go-through";
		}
		if (i == 19187 || i == 19175) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Dismantle";
		}
		
		

		
		if (i == 6434) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Enter";
		}
		if (i == 2182) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Buy-Items";
			objectDef.name = "Culinaromancer's chest";
		}
		if (i == 10177) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Climb-down";
			objectDef.actions[1] = "Climb-up";
		}
		if (i == 39515) {
			objectDef.name = "Frost Dragon Portal";
		}
		if (i == 2026) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Net";
		}
		
		
		if (i == 11231) {
			objectDef.name = "Last Man Standing Chest";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Open";
		}
		
		if (i == 2029) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Lure";
			objectDef.actions[1] = "Bait";
		}
		if (i == 2030) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Cage";
			objectDef.actions[1] = "Harpoon";
		}
		if (i == 7352) {
			objectDef.name = "Gatestone portal";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Enter";
		}
		if (i == 47120) {
			objectDef.name = "Altar";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Craft-rune";
		}
		if (i == 20331) {
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Steal-from";
		}
		
		if (i == 8799) {
			objectDef.name = "Grand Exchange";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Access";
		}
		
		if (i == 13621) {
			objectDef.name = "@cya@Zulrah Portal";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Access";
		}
		if (i == 13620) {
			objectDef.name = "@blu@Investor Npc Portal";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Access";
		}
		
		if (i == 13622) {
			objectDef.name = "@yel@Skotizo Portal";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Access";
		}
		if (i == 13623) {
			objectDef.name = "@red@Instance Spidey";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Access";
		}
		if (i == 13628) {
			objectDef.name = "@blu@Brothers of Terror";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Access";
		}
		if (i == 4987) {
			objectDef.objectModelIDs = new int[] { 4928};
		}
		if (i == 4985) {
			objectDef.objectModelIDs = new int[] { 4928};
		}
		if (i == 4988) {
			objectDef.objectModelIDs = new int[] { 4928};
		}
		if (i == 4990) {
			objectDef.objectModelIDs = new int[] { 4928};
		}
		
		if (i == 53979) {
			objectDef.name = "Trapped SebZero crystal";
			objectDef.hasActions = false;
		}
		if (i == 38693) {
			objectDef.hasActions = false;
		}
		if (i == 57165) {
			objectDef.hasActions = false;
		}
		if (i == 57164) {
			objectDef.hasActions = false;
		}
		if (i == 48673) {
			objectDef.hasActions = false;
		}
		if (i == 9320) {
			objectDef.hasActions = false;
		}
		if (i == 10251) {
			objectDef.hasActions = false;
		}
		if (i == 6282) {
			objectDef.hasActions = false;
		}
		if (i == 7141) {
			objectDef.hasActions = false;
		}
		if (i == 14219) {
			objectDef.hasActions = false;
		}
		if (i == 9299) {
			objectDef.hasActions = false;
		}
		if (i == 13596) {
			objectDef.hasActions = false;
		}
		if (i == 13595) {
			objectDef.hasActions = false;
		}
		if (i == 42019) {
			objectDef.name = "@or2@barrier";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@or2@Cross";
		}
		
		if (i == 42425) {
			objectDef.name = "@or2@Room 2 Portal";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@or2@Enter";
		}
		if (i == 39515) {
			objectDef.name = "@or2@Room 3 Portal";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@or2@Enter";
		}
		
		if (i == 9075) {
			objectDef.name = "@whi@Bank Chest";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Access";
		}
		
		if (i == 2995) {
			objectDef.name = "@cya@Uber Chest";
			objectDef.actions[0] = "Open";
			objectDef.actions[1] = "@red@Check Rewards";
		}
		
		if (i == 19042) {
			objectDef.name = "@bla@Dungeon Chest(Floor 1)";
			objectDef.actions[0] = "Open";
		}
		
		if (i == 10804) {
			objectDef.name = "@red@Bonds Dungeon";
			objectDef.actions[0] = "Enter";
		}
		
		
		
		if (i == 49347) {
			objectDef.name = "@yel@Deluxe Chest";
			objectDef.actions[0] = "Open";
			objectDef.actions[1] = "@red@Check Rewards";
		}
		
		if (i == 16050) {
			objectDef.name = "@whi@Deluxe Zone";
			objectDef.actions[0] = "Visit";
		}
		
		if (i == 16082) {
			objectDef.name = "@whi@Deluxe Zone";
			objectDef.actions[0] = "Visit";
		}
		
		if (i == 27330) {
			objectDef.name = "World Teleporter";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "@whi@Open";
		}
		
		
		if (i == 57437) {
			objectDef.name = "@cya@Frozen Chest";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Open";
		}
		
		if (i == 47180) {
			objectDef.name = "Frost Dragon Portal Device";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Activate";
		}
		if (i == 13493) {
			objectDef.name = "SebZero Armour";
		}
		if (i == 8702) {
			objectDef.name = "Rocktail Barrel";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Fish-from";
		}
		if (i == 2783) {
			objectDef.hasActions = true;
			objectDef.name = "Anvil";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Smith-on";
		}
		if (i == 172) {
			objectDef.name = "Starter chest";
			objectDef.actions[1] = "@red@Check Rewards";
		}
		if (i == 4123) {
			objectDef.name = "@re1@Forgotten Minigame chest";
			objectDef.actions[1] = "Check Rewards";
		}
		if (i == 7350) {
			objectDef.actions[1] = "@cya@Check Rewards";
			objectDef.objectModelIDs = new int[] { 61349}; //61349
			objectDef.name = "@whi@Grand Donation chest";
			objectDef.modelSizeX = 158;
			objectDef.modelSizeH = 158;
			objectDef.modelSizeY = 158;
		}
		if (i == 47857) {
		}
		if (i == 47763) {
			objectDef.name = "@cya@Christmas Wardrobe";
			objectDef.actions[0] = "@red@Enter";
		}
		if (i == 62) {
			objectDef.name = "@blu@Crystal Teleport";
			objectDef.actions[0] = "@whi@Speak with Wizard";
		}
		if (i == 7989) {
			objectDef.hasActions = false;

		}
		if (i == 13325) {
			objectDef.hasActions = false;
		}
		if (i == 9029) {
			objectDef.hasActions = false;
		}
		if (i == 3626) {
			objectDef.hasActions = false;
		}
		if (i == 5979) {
			objectDef.hasActions = false;
		}
		if (i == 1583) {
			objectDef.hasActions = false;
		}
		if (i == 4927) {
			objectDef.hasActions = false;
		}
		
			if (i == 7864) {
			objectDef.hasActions = false;

		}
			
			if (i == 28780) {
			objectDef.name = "@whi@Portal zone";
			objectDef.hasActions = true;
			objectDef.actions[0] = "@or2@Visit";
			objectDef.actions[1] = "@mag@Concession Visit";
		}
			
			
			if (i == 4390) {
				objectDef.name = "@bla@KBD Teleport";
				objectDef.actions[0] = "@or2@Use";
				objectDef.objectModelIDs = new int[] { 40974};
				objectDef.modelSizeX = 68;
				objectDef.modelSizeH = 68;
				objectDef.modelSizeY = 68;
		}
			if (i == 4389) {
				objectDef.name = "@mag@Skotizo Teleport";
				objectDef.actions[0] = "@or2@Use";
				objectDef.objectModelIDs = new int[] { 40960};
				objectDef.modelSizeX = 68;
				objectDef.modelSizeH = 68;
				objectDef.modelSizeY = 68;
			}	
			
			if (i == 13635) {
				objectDef.name = "@yel@Portals @red@Room";
				objectDef.actions = new String[] { "@re1@Back to", null, null, null, null };
				objectDef.objectModelIDs = new int[] { 10613};
			}	
			
			if (i == 4483) {
				objectDef.name = "Keepsake wardrobe";
				objectDef.actions[0] = "Open";
			}	
			
			
			if (i == 6606) {
				objectDef.name = "@gre@Room 2 Portal";
				objectDef.actions[0] = "@or2@Use";
				objectDef.objectModelIDs = new int[] { 38318};
			}	
			if (i == 4407) {
				objectDef.name = "@red@Venenatis Teleport";
				objectDef.actions[0] = "@or2@Use";
				objectDef.objectModelIDs = new int[] { 40975};
				objectDef.modelSizeX = 68;
				objectDef.modelSizeH = 68;
				objectDef.modelSizeY = 68;
			}
			if (i == 4406) {
				objectDef.name = "@cya@Vetion Teleport";
				objectDef.actions[0] = "@or2@Use";
				objectDef.objectModelIDs = new int[] { 40963};
				objectDef.modelSizeX = 68;
				objectDef.modelSizeH = 68;
				objectDef.modelSizeY = 68;
			}
			
			if (i == 4114) {
			objectDef.name = "@cya@VIP chest";
			objectDef.actions[1] = "@red@Check Rewards";
		}
		if (i == 8416) {
			objectDef.actions = new String[] { "Chop", null, null, null, null };
			objectDef.name = "@red@Crystal tree's";
		}
		if (i == 42220) {
			objectDef.name = "@or2@Crystal Hearts Boss";
			objectDef.actions = new String[] { "Visit", null, null, null, null };
		}
		if (i == 42219) {
			objectDef.name = "@or2@Skilling Boss";
			objectDef.objectModelIDs = new int[] { 45573};
			objectDef.actions = new String[] { "Visit", null, null, null, null };
		}
		if (i == 12451) {
			objectDef.name = "@or2@Upgraded Crystal Chest";
		}
		if (i == 2879) {
			objectDef.name = "@cya@Upgrading Pool";
		}
		if (i == 38660) {
			objectDef.name = "@yel@SebZero's Star";
		}
		if (i == 14434) {
			objectDef.name = "@whi@SebZero's Evil Tree";
			objectDef.objectModelIDs = new int[] { 45770};
		}
		if (i == 46935) {
			objectDef.name = "@yel@Slayer Boss Portal";
		}
		if (i == 1306) {
			objectDef.name = "@yel@SebZero's Magical Trees";
		}
		
		if (i == 15541) {
			objectDef.name = "@yel@Item Combiner";
			objectDef.objectModelIDs = new int[] {61956};
			objectDef.modelSizeX = 140;
			objectDef.modelSizeH = 140;
			objectDef.modelSizeY = 140;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Access";
		}
		
		
		if (i == 9031) {
			objectDef.name = "@cya@Ironman Rocks";
		}
		if (i == 7316) {
			objectDef.name = "@cya@Boss";
		}
		if (i == 8689) {
			objectDef.name = "Rock";
			objectDef.hasActions = false;
			objectDef.objectModelIDs = new int[] { 1};
		}
		
		
		if (i == 8417) {
			objectDef.actions = new String[] { "Chop", null, null, null, null };
			objectDef.name = "@yel@Raid tree's";
		}
		
		if (i == 54587) {
			objectDef.name = "@red@Raids @gre@Chest";
			objectDef.objectModelIDs = new int[] { 40286};
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Open";
		}
		if (i == 2183) {
			objectDef.name = "@bla@Treasure chest";
		}
		if (i == 42611) {
			
			objectDef.name = "@red@Raids @gre@Portal";
			objectDef.actions[0] = "Enter";
		
		}
		
		
		if (i == 6420) {
			objectDef.name = "Medium chest";
			objectDef.objectModelIDs = new int[] { 40288};
			objectDef.actions[1] = "@red@Check Rewards";
		}
		if (i == 6714) {
			objectDef.hasActions = true;
			objectDef.name = "Door";
			objectDef.actions[0] = "Open";
		}
		if (i == 8550 || i == 8150 || i == 8551 || i == 7847 || i == 8550) {
			objectDef.actions = new String[] { null, "Inspect", null, "Guide", null };

			objectDef.hasActions = true;

		}
		if (i == 42151 || i == 42160) {
			objectDef.name = "Rocks";
			objectDef.hasActions = true;
			objectDef.mapSceneID = 11;
		}
		if (i == 42158 || i == 42157) {
			objectDef.name = "Rocks";
			objectDef.hasActions = true;
			objectDef.mapSceneID = 12;
		}
		if (i == 42123 || i == 42124 || i == 42119 || i == 42120 || i == 42118 || i == 42122) {
			objectDef.name = "Tree";
			objectDef.hasActions = true;
			objectDef.actions = new String[] { "Cut", null, null, null, null };
			objectDef.mapSceneID = 0;
		}
		if (i == 19030 ||i == 19031 || i == 42124 || i == 42119 || i == 42120 || i == 42118 || i == 42122) {
			objectDef.mapSceneID = -1;
		}
		
		if (i == 42893) {
			objectDef.name = "Tree";
			objectDef.hasActions = true;
			objectDef.actions = new String[] { "Cut", null, null, null, null };
			objectDef.mapSceneID = 6;
		}
		if (i == 42127 || i == 42131 || i == 42133 || i == 42129 || i == 42134) {
			objectDef.name = "Tree";
			objectDef.hasActions = true;
			objectDef.actions = new String[] { "Cut", null, null, null, null };
			objectDef.mapSceneID = 6;
		}
		if (i == 42082 || i == 42083)
			objectDef.mapSceneID = 0;
		if (i >= 42087 && i <= 42117)
			objectDef.mapSceneID = 4;
		if (i > 30000 && objectDef.name != null && objectDef.name.toLowerCase().contains("gravestone"))
			objectDef.mapSceneID = 34;
		if (i == 36676) {
			objectDef.objectModelIDs = new int[] { 17374, 17383 };
			objectDef.objectModelTypes = null;
		}
		
		if (i == 6195) {
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Teleport";
			objectDef.name = "@red@Blood Slayer Dungeon";
			objectDef.objectModelIDs = new int[] { 10619};
		}
		
		if (i == 34255) {
			objectDef.configID = 8002;
			objectDef.configObjectIDs = new int[] { 15385 };
		}
		if (i == 13830) {
			// objectDef.objectModelIDs = new int[] {12199};
			objectDef.configID = 8003;
			objectDef.configObjectIDs = new int[] { 13217, 13218, 13219, 13220, 13221, 13222, 13223 };
		}
		if (i == 21634) {
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Sail";
		}
		if (i == 10284) {
			objectDef.name = "Chest";
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Open";
		}
		if (i == 22721) {
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Smelt";
		}
		if (i == 7837) {
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
		}
		if (i == 26280) {
			objectDef.hasActions = true;
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Study";
		}
		if (i == 27339 || i == 27306) {
			objectDef.hasActions = true;
			objectDef.name = "Mystical Monolith";
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Travel";
			objectDef.actions[1] = "Pray-at";
		}

		for (int i1 : hotSpotIDs) {
			if (i1 == i) {
				objectDef.configID = 8000;
				objectDef.configObjectIDs = new int[] { i, 0 - 1 };
			}
		}
		if (i == 15314 || i == 15313) {
			objectDef.configID = 8000;
			objectDef.configObjectIDs = new int[] { i, -1 };
		}
		if (i == 15306) {
			objectDef.configID = 8001;
			objectDef.configObjectIDs = new int[] { i, -1, 13015 };
		}
		if (i == 15305) {
			objectDef.configID = 8001;
			objectDef.configObjectIDs = new int[] { i, -1, 13016 };
		}
		if (i == 15317) {
			objectDef.configID = 8001;
			objectDef.configObjectIDs = new int[] { i, -1, 13096 };
		}
		if (i == 8550) {
			objectDef.configObjectIDs = new int[] { 8576, 8575, 8574, 8573, 8576, 8576, 8558, 8559, 8560, 8561, 8562,
					8562, 8562, 8580, 8581, 8582, 8583, 8584, 8584, 8584, 8535, 8536, 8537, 8538, 8539, 8539, 8539,
					8641, 8642, 8643, 8644, 8645, 8645, 8645, 8618, 8619, 8620, 8621, 8622, 8623, 8624, 8624, 8624,
					8595, 8596, 8597, 8598, 8599, 8600, 8601, 8601, 8601, 8656, 8657, 8658, 8659, 8660, 8661, 8662,
					8663, 8664, 8664, 8664, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8563, 8564, 8565, 8566, 8576,
					8576, 8576, 8585, 8586, 8587, 8588, 8576, 8576, 8576, 8540, 8541, 8542, 8543, 8576, 8576, 8576,
					8646, 8647, 8648, 8649, 8576, 8576, 8576, 8625, 8626, 8627, 8628, 8629, 8630, 8576, 8576, 8576,
					8602, 8603, 8604, 8605, 8606, 8607, 8576, 8576, 8576, 8665, 8666, 8667, 8668, 8669, 8670, 8671,
					8672, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8567, 8568, 8569, 8576,
					8576, 8576, 8576, 8589, 8590, 8591, 8576, 8576, 8576, 8576, 8544, 8545, 8546, 8576, 8576, 8576,
					8576, 8650, 8651, 8652, 8576, 8576, 8576, 8576, 8631, 8632, 8633, 8634, 8635, 8576, 8576, 8576,
					8576, 8608, 8609, 8610, 8611, 8612, 8576, 8576, 8576, 8576, 8673, 8674, 8675, 8676, 8677, 8678,
					8679, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8570, 8571, 8572, 8576,
					8576, 8576, 8576, 8592, 8593, 8594, 8576, 8576, 8576, 8576, 8547, 8548, 8549, 8576, 8576, 8576,
					8576, 8653, 8654, 8655, 8576, 8576, 8576, 8576, 8636, 8637, 8638, 8639, 8640, 8576, 8576, 8576,
					8576, 8613, 8614, 8615, 8616, 8617, 8576, 8576, 8576, 8576, 8680, 8681, 8682, 8683, 8684, 8685,
					8686, 8576, 8576, 8576, 8576 };
		}
		if (i == 8551) {
			objectDef.configObjectIDs = new int[] { 8576, 8575, 8574, 8573, 8576, 8576, 8558, 8559, 8560, 8561, 8562,
					8562, 8562, 8580, 8581, 8582, 8583, 8584, 8584, 8584, 8535, 8536, 8537, 8538, 8539, 8539, 8539,
					8641, 8642, 8643, 8644, 8645, 8645, 8645, 8618, 8619, 8620, 8621, 8622, 8623, 8624, 8624, 8624,
					8595, 8596, 8597, 8598, 8599, 8600, 8601, 8601, 8601, 8656, 8657, 8658, 8659, 8660, 8661, 8662,
					8663, 8664, 8664, 8664, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8563, 8564, 8565, 8566, 8576,
					8576, 8576, 8585, 8586, 8587, 8588, 8576, 8576, 8576, 8540, 8541, 8542, 8543, 8576, 8576, 8576,
					8646, 8647, 8648, 8649, 8576, 8576, 8576, 8625, 8626, 8627, 8628, 8629, 8630, 8576, 8576, 8576,
					8602, 8603, 8604, 8605, 8606, 8607, 8576, 8576, 8576, 8665, 8666, 8667, 8668, 8669, 8670, 8671,
					8672, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8567, 8568, 8569, 8576,
					8576, 8576, 8576, 8589, 8590, 8591, 8576, 8576, 8576, 8576, 8544, 8545, 8546, 8576, 8576, 8576,
					8576, 8650, 8651, 8652, 8576, 8576, 8576, 8576, 8631, 8632, 8633, 8634, 8635, 8576, 8576, 8576,
					8576, 8608, 8609, 8610, 8611, 8612, 8576, 8576, 8576, 8576, 8673, 8674, 8675, 8676, 8677, 8678,
					8679, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8576, 8570, 8571, 8572, 8576,
					8576, 8576, 8576, 8592, 8593, 8594, 8576, 8576, 8576, 8576, 8547, 8548, 8549, 8576, 8576, 8576,
					8576, 8653, 8654, 8655, 8576, 8576, 8576, 8576, 8636, 8637, 8638, 8639, 8640, 8576, 8576, 8576,
					8576, 8613, 8614, 8615, 8616, 8617, 8576, 8576, 8576, 8576, 8680, 8681, 8682, 8683, 8684, 8685,
					8686, 8576, 8576, 8576, 8576 };
		}
		if (i == 7847) {
			objectDef.configObjectIDs = new int[] { 7843, 7842, 7841, 7840, 7843, 7843, 7843, 7843, 7867, 7868, 7869,
					7870, 7871, 7899, 7900, 7901, 7902, 7903, 7883, 7884, 7885, 7886, 7887, 7919, 7920, 7921, 7922,
					7923, 7851, 7852, 7853, 7854, 7855, 7918, 7917, 7916, 7915, 41538, 41539, 41540, 41541, 41542, 7843,
					7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843,
					7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7872, 7873, 7874,
					7875, 7843, 7904, 7905, 7906, 7907, 7843, 7888, 7889, 7890, 7891, 7843, 7924, 7925, 7926, 7927,
					7843, 7856, 7857, 7858, 7859, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843,
					7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843,
					7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7876, 7877,
					7878, 7843, 7843, 7908, 7909, 7910, 7843, 7843, 7892, 7893, 7894, 7843, 7843, 7928, 7929, 7930,
					7843, 7843, 7860, 7861, 7862, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843,
					7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843,
					7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7879, 7880,
					7881, 7882, 7843, 7911, 7912, 7913, 7914, 7843, 7895, 7896, 7897, 7898, 7843, 7931, 7932, 7933,
					7934, 7843, 7863, 7865, 7866, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843,
					7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843, 7843,
					7843, 7843, 7843, 7843, 7843 };
		}
		if (i == 8150) {
			objectDef.configObjectIDs = new int[] { 8135, 8134, 8133, 8132, 8139, 8140, 8141, 8142, 8143, 8143, 8143,
					8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140,
					8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142,
					8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143,
					8143, 21101, 21127, 21159, 21178, 21185, 21185, 21185, 17776, 8139, 8140, 8141, 8142, 8143, 8143,
					8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139,
					8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141, 8142, 8143, 8143, 8143, 8139, 8140, 8141,
					8142, 8143, 8143, 8143, 17777, 17778, 17780, 17781, 17781, 17781, -1, -1, -1, -1, -1, -1, -1, -1,
					-1, -1, -1, -1, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145,
					8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146,
					8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8144, 8145, 8146, 8147, 8148, 8149, 8144,
					8145, 8146, 8144, 8145, 8146, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135,
					8135, 8135, 9044, 9045, 9046, 9047, 9048, 9048, 9049, 9050, 9051, 9052, 9053, 9054, 8139, 8140,
					8141, 8142, 8143, 8143, 8143, 8144, 8145, 8146, 8135, 8135, 8135, 8135, 8135, 8135, -1, 8135, 8135,
					8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135,
					8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135, 8135,
					8135 };
		}

		switch (i) {
		case 6725:
		case 6714:
		case 6734:
		case 6730:
		case 6749:
		case 6742:
		case 6723:
		case 6728:
		case 6747:
		case 6744:
		case 6741:
		case 6779:
		case 6743:
		case 6719:
		case 6717:
		case 6731:
		case 6716:
		case 6720:
		case 6738:
		case 6726:
		case 6740:
		case 6721:
		case 6748:
		case 6729:
		case 6745:
		case 6718:
		case 6780:
		case 6746:
		case 6750:
		case 6722:
		case 6715:
			objectDef.name = "Door";
			objectDef.hasActions = true;
			break;
		case 4875:
			objectDef.name = "Banana Stall";
			break;
		case 4874:
			objectDef.name = "Ring Stall";
			break;
		case 13493:
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Steal from";
			break;
		case 13492:
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Steal from";
			break;
		case 13491:
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Steal from";
			break;
		case 2152:
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Infuse Pouches";
			objectDef.actions[1] = "Renew Points";
			objectDef.name = "Summoning Obelisk";
			break;
		case 4306:
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Use";
			break;
		case 2732:
			objectDef.actions = new String[5];
			objectDef.actions[0] = "Add logs";
			break;
		case 2:
			objectDef.name = "Entrance";
			break;
		}

		boolean debug = false;

		if (debug) {
			objectDef.name = "" + i;
			objectDef.hasActions = true;
			objectDef.actions = new String[] { "lol", null, null, null, null, null };
		}
		return objectDef;
	}

	private void setDefaults() {
		objectModelIDs = null;
		objectModelTypes = null;
		name = null;
		description = null;
		modifiedModelColors = null;
		originalModelColors = null;
		sizeX = 1;
		sizeY = 1;
		isUnwalkable = true;
		aBoolean757 = true;
		hasActions = false;
		adjustToTerrain = false;
		nonFlatShading = false;
		aBoolean764 = false;
		animationID = -1;
		anInt775 = 16;
		brightness = 0;
		contrast = 0;
		actions = null;
		mapFunctionID = -1;
		mapSceneID = -1;
		aBoolean751 = false;
		aBoolean779 = true;
		modelSizeX = 128;
		modelSizeH = 128;
		modelSizeY = 128;
		plane = 0;
		offsetX = 0;
		offsetH = 0;
		offsetY = 0;
		aBoolean736 = false;
		isSolidObject = false;
		anInt760 = -1;
		varbitIndex = -1;
		configID = -1;
		configObjectIDs = null;
	}

	public void method574(OnDemandFetcher fetcher) {
		System.out.println("shud do this one " + type);
		if (objectModelIDs == null)
			return;
		System.out.println("shud do this one " + type);
		for (int j = 0; j < objectModelIDs.length; j++) {
			fetcher.insertExtraFilesRequest(objectModelIDs[j] & 0xffff, 0);
		}
	}

	public static void nullLoader() {
		modelCache = null;
		completedModelCache = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public static void unpackConfig(CacheArchive streamLoader, CacheArchive secondArchive) {
		stream = new Stream(streamLoader.getDataForName("loc.dat"));
		Stream stream = new Stream(streamLoader.getDataForName("loc.idx"));
		stream667 = new Stream(secondArchive.getDataForName("loc2.dat"));
		Stream streamIdx667 = new Stream(secondArchive.getDataForName("loc2.idx"));
		streamOSRS = new Stream(FileOperations.ReadFile(signlink.findcachedir() + "loc.dat"));
		Stream streamIdxOSRS = new Stream(FileOperations.ReadFile(signlink.findcachedir() + "loc.idx"));

		// FileOperations.WriteFile("C:\\Users\\te12ga8\\Dropbox\\Source\\data\\clipping\\objects\\loc.dat",
		// ObjectDef.stream.buffer);
		// FileOperations.WriteFile("C:\\Users\\te12ga8\\Dropbox\\Source\\data\\clipping\\objects\\loc.idx",
		// stream.buffer);
		// FileOperations.WriteFile("C:\\Users\\te12ga8\\Dropbox\\Source\\data\\clipping\\objects\\loc2.dat",
		// stream667.buffer);
		// FileOperations.WriteFile("C:\\Users\\te12ga8\\Dropbox\\Source\\data\\clipping\\objects\\loc2.idx",
		// streamIdx667.buffer);

		int totalObjects = stream.readUnsignedWord();
		int totalObjects667 = streamIdx667.readUnsignedWord();
		int totalObjectsOSRS = streamIdxOSRS.readUnsignedWord();
		streamIndices = new int[totalObjects];
		streamIndices667 = new int[totalObjects667];
		streamIndicesOSRS = new int[totalObjectsOSRS];
		int i = 2;
		for (int j = 0; j < totalObjects; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedWord();
		}
		i = 2;
		for (int j = 0; j < totalObjects667; j++) {
			streamIndices667[j] = i;
			i += streamIdx667.readUnsignedWord();
		}
		i = 2;
		for (int j = 0; j < totalObjectsOSRS; j++) {
			streamIndicesOSRS[j] = i;
			i += streamIdxOSRS.readUnsignedWord();
		}
		cache = new ObjectDef[20];
		for (int k = 0; k < 20; k++) {
			cache[k] = new ObjectDef();
		}
	}

	public boolean allModelsFetched(int i) {
		if (objectModelTypes == null) {
			if (objectModelIDs == null)
				return true;
			if (i != 10)
				return true;
			boolean flag1 = true;
			for (int k = 0; k < objectModelIDs.length; k++)
				flag1 &= Model.modelIsFetched(objectModelIDs[k] & 0xffff);
			return flag1;
		}
		for (int j = 0; j < objectModelTypes.length; j++)
			if (objectModelTypes[j] == i)
				return Model.modelIsFetched(objectModelIDs[j] & 0xffff);

		return true;
	}

	public Model renderObject(int objectType, int face, int zA, int zB, int zD, int zC, int k1) {
		Model model = getAnimatedModel(objectType, k1, face);
		if (model == null)
			return null;
		if (adjustToTerrain || nonFlatShading)
			model = new Model(adjustToTerrain, nonFlatShading, model);
		if (adjustToTerrain) {
			int l1 = (zA + zB + zD + zC) / 4;
			for (int i2 = 0; i2 < model.anInt1626; i2++) {
				int vertexX = model.anIntArray1627[i2];
				int vertexZ = model.anIntArray1629[i2];
				int l2 = zA + ((zB - zA) * (vertexX + 64)) / 128;
				int i3 = zC + ((zD - zC) * (vertexX + 64)) / 128;
				int j3 = l2 + ((i3 - l2) * (vertexZ + 64)) / 128;
				model.anIntArray1628[i2] += j3 - l1;
			}
			model.normalise();
		}
		return model;
	}

	public boolean isAllModelsFetched() {
		if (objectModelIDs == null)
			return true;
		boolean flag1 = true;
		for (int i = 0; i < objectModelIDs.length; i++)
			flag1 &= Model.modelIsFetched(objectModelIDs[i] & 0xffff);
		return flag1;
	}

	public ObjectDef getTransformedObject() {
		int configIdx = -1;
		if (varbitIndex != -1) {
			VarBit varBit = VarBit.cache[varbitIndex];
			int j = varBit.configId;
			int k = varBit.leastSignificantBit;
			int l = varBit.mostSignificantBit;
			int i1 = Client.anIntArray1232[l - k];
			configIdx = clientInstance.variousSettings[j] >> k & i1;
		} else if (configID != -1)
			configIdx = clientInstance.variousSettings[configID];
		if (configIdx < 0 || configIdx >= configObjectIDs.length || configObjectIDs[configIdx] == -1)
			return null;
		else
			return forID(configObjectIDs[configIdx]);
	}
	


	private Model getAnimatedModel(int objectType, int animId, int face) {
		Model model = null;
		long hash;
		if (objectModelTypes == null) {
			if (objectType != 10)
				return null;
			hash = (long) ((type << 8) + face) + ((long) (animId + 1) << 32);
			Model model_1 = (Model) completedModelCache.get(hash);
			if (model_1 != null)
				return model_1;
			if (objectModelIDs == null)
				return null;
			boolean mirror = aBoolean751 ^ (face > 3);
			int modelAmt = objectModelIDs.length;
			for (int ptr = 0; ptr < modelAmt; ptr++) {
				int subModelID = objectModelIDs[ptr];
				if (mirror)
					subModelID += 0x10000;
				model = (Model) modelCache.get(subModelID);
				if (model == null) {
					model = Model.fetchModel(subModelID & 0xffff);
					if (model == null)
						return null;
					if (mirror)
						model.mirrorModel();
					modelCache.put(model, subModelID);
				}
				if (modelAmt > 1)
					modelParts[ptr] = model;
			}
			if (modelAmt > 1)
				model = new Model(modelAmt, modelParts);
		} else {
			int i1 = -1;
			for (int j1 = 0; j1 < objectModelTypes.length; j1++) {
				if (objectModelTypes[j1] != objectType)
					continue;
				i1 = j1;
				break;
			}
			if (i1 == -1)
				return null;
			hash = (long) ((type << 8) + (i1 << 3) + face) + ((long) (animId + 1) << 32);
			Model model_2 = (Model) completedModelCache.get(hash);
			if (model_2 != null)
				return model_2;
			int subModelId = objectModelIDs[i1];
			boolean mirror = aBoolean751 ^ (face > 3);
			if (mirror)
				subModelId += 0x10000;
			model = (Model) modelCache.get(subModelId);
			//texturize(model, type); // useless spot
			if (model == null) {
				model = Model.fetchModel(subModelId & 0xffff);
				if (model == null)
					return null;
				if (mirror)
					model.mirrorModel();
				modelCache.put(model, subModelId);
			}
		}
		boolean rescale;
		rescale = modelSizeX != 128 || modelSizeH != 128 || modelSizeY != 128;
		boolean hasOffsets;
		hasOffsets = offsetX != 0 || offsetH != 0 || offsetY != 0;
		Model model_3 = new Model(modifiedModelColors == null, FrameReader.isNullFrame(animId),
				face == 0 && animId == -1 && !rescale && !hasOffsets, model);
		if (animId != -1) {
			model_3.createBones();
			model_3.applyTransform(animId);
			model_3.triangleSkin = null;
			model_3.vertexSkin = null;
		}
		while (face-- > 0)
			model_3.rotateBy90();
		if (modifiedModelColors != null) {
			for (int k2 = 0; k2 < modifiedModelColors.length; k2++)
				model_3.recolour(modifiedModelColors[k2], originalModelColors[k2]);
		}
		//texturize(model_3, type);
		if (rescale)
			model_3.scaleT(modelSizeX, modelSizeY, modelSizeH);
		if (hasOffsets)
			model_3.translate(offsetX, offsetH, offsetY);
		// model_3.light(74, 1000, -90, -580, -90, !nonFlatShading);
		model_3.light(64 + brightness, 768 + contrast * 5, -50, -10, -50, !nonFlatShading);
		// 64 + aByte737, 768 + aByte742 * 5, -50, -10, -50, !aBoolean769
		
		if (anInt760 == 1)
			model_3.myPriority = model_3.modelHeight;
		completedModelCache.put(model_3, hash);
		return model_3;
	}

	private void readValues(Stream stream) {
		int i = -1;
		label0: do {
			int opcode;
			do {
				opcode = stream.readUnsignedByte();
				if (opcode == 0)
					break label0;
				if (opcode == 1) {
					int k = stream.readUnsignedByte();
					if (k > 0)
						if (objectModelIDs == null || lowMem) {
							objectModelTypes = new int[k];
							objectModelIDs = new int[k];
							for (int k1 = 0; k1 < k; k1++) {
								objectModelIDs[k1] = stream.readUnsignedWord();
								objectModelTypes[k1] = stream.readUnsignedByte();
							}
						} else {
							stream.currentOffset += k * 3;
						}
				} else if (opcode == 2)
					name = stream.readString();
				else if (opcode == 3)
					description = stream.readBytes();
				else if (opcode == 5) {
					int l = stream.readUnsignedByte();
					if (l > 0)
						if (objectModelIDs == null || lowMem) {
							objectModelTypes = null;
							objectModelIDs = new int[l];
							for (int l1 = 0; l1 < l; l1++)
								objectModelIDs[l1] = stream.readUnsignedWord();
						} else {
							stream.currentOffset += l * 2;
						}
				} else if (opcode == 14)
					sizeX = stream.readUnsignedByte();
				else if (opcode == 15)
					sizeY = stream.readUnsignedByte();
				else if (opcode == 17)
					isUnwalkable = false; // solid
				else if (opcode == 18)
					aBoolean757 = false; // impenetrable
				else if (opcode == 19) {
					i = stream.readUnsignedByte();
					if (i == 1)
						hasActions = true; // is interactive
				} else if (opcode == 21)
					adjustToTerrain = true; // contouredGround
				else if (opcode == 22)
					nonFlatShading = false; // delay shading
				else if (opcode == 23)
					aBoolean764 = true; // occludes
				else if (opcode == 24) {
					animationID = stream.readUnsignedWord();
					if (animationID == 65535)
						animationID = -1;
				} else if (opcode == 28)
					anInt775 = stream.readUnsignedByte(); // decorDisplacement
				else if (opcode == 29)
					brightness = stream.readSignedByte(); // ambientLighting
				else if (opcode == 39)
					contrast = stream.readSignedByte(); // light diffusion
				else if (opcode >= 30 && opcode < 39) {
					if (actions == null)
						actions = new String[10];
					actions[opcode - 30] = stream.readString();
					if (actions[opcode - 30].equalsIgnoreCase("hidden"))
						actions[opcode - 30] = null;
				} else if (opcode == 40) {
					int i1 = stream.readUnsignedByte();
					modifiedModelColors = new int[i1];
					originalModelColors = new int[i1];
					for (int i2 = 0; i2 < i1; i2++) {
						modifiedModelColors[i2] = stream.readUnsignedWord();
						originalModelColors[i2] = stream.readUnsignedWord();
					}
				} else if (opcode == 60)
					mapFunctionID = stream.readUnsignedWord();// mini map function
				else if (opcode == 62)
					aBoolean751 = true; // inverted
				else if (opcode == 64)
					aBoolean779 = false; // castsShadow
				else if (opcode == 65)
					modelSizeX = stream.readUnsignedWord(); // scaleX
				else if (opcode == 66)
					modelSizeH = stream.readUnsignedWord(); // why the fuck is this H, its Y lol
				else if (opcode == 67)
					modelSizeY = stream.readUnsignedWord(); // Z
				else if (opcode == 68)
					mapSceneID = stream.readUnsignedWord(); // map scene
				else if (opcode == 69)
					plane = stream.readUnsignedByte(); // surroundings
				else if (opcode == 70)
					offsetX = stream.readSignedWord(); // translateX
				else if (opcode == 71)
					offsetH = stream.readSignedWord(); // Translate Y
				else if (opcode == 72)
					offsetY = stream.readSignedWord(); // Translate Z
				else if (opcode == 73)
					aBoolean736 = true; // obstructsGround
				else if (opcode == 74) {
					isSolidObject = true; // hollow?
				} else {
					if (opcode != 75)
						continue;
					anInt760 = stream.readUnsignedByte(); //supportItems i think
				}
				continue label0;
			} while (opcode != 77);
			varbitIndex = stream.readUnsignedWord();
			if (varbitIndex == 65535)
				varbitIndex = -1;
			configID = stream.readUnsignedWord();
			if (configID == 65535)
				configID = -1;
			int j1 = stream.readUnsignedByte();
			configObjectIDs = new int[j1 + 1];
			for (int j2 = 0; j2 <= j1; j2++) {
				configObjectIDs[j2] = stream.readUnsignedWord();
				if (configObjectIDs[j2] == 65535)
					configObjectIDs[j2] = -1;
			}

		} while (true);
		if (i == -1) {
			hasActions = objectModelIDs != null && (objectModelTypes == null || objectModelTypes[0] == 10);
			if (actions != null)
				hasActions = true;
		}
		if (isSolidObject) { // hollow?
			isUnwalkable = false; // solid object
			aBoolean757 = false; // impenetrable object
		}
		if (anInt760 == -1) // support items
			anInt760 = isUnwalkable ? 1 : 0; // supportItems = solid ? 1 : 0;
	}

	private ObjectDef() {
		type = -1;
	}

	public boolean aBoolean736;
	private byte brightness;
	private int offsetX;
	public String name;
	private int modelSizeY;
	private static final Model[] modelParts = new Model[4];
	private byte contrast;
	public int sizeX;
	private int offsetH;
	public int mapFunctionID;
	private int[] originalModelColors;
	private int modelSizeX;
	public int configID;
	private boolean aBoolean751;
	public static boolean lowMem;
	private static Stream stream;
	private static Stream stream667;
	private static Stream streamOSRS;
	public int type;
	private static int[] streamIndices;
	private static int[] streamIndices667;
	private static int[] streamIndicesOSRS;
	public boolean aBoolean757;
	public int mapSceneID;
	public int configObjectIDs[];
	private int anInt760;
	public int sizeY;
	public boolean adjustToTerrain;
	public boolean aBoolean764;
	public static Client clientInstance;
	private boolean isSolidObject;
	public boolean isUnwalkable;
	public int plane;
	private boolean nonFlatShading;
	private static int cacheIndex;
	private int modelSizeH;
	public int[] objectModelIDs;
	public int varbitIndex;
	public int anInt775;
	public int[] objectModelTypes;
	public byte description[];
	public boolean hasActions;
	public boolean aBoolean779;
	public static MemCache completedModelCache = new MemCache(30);// 30
	public int animationID;
	public boolean isTexturized = false;
	private static ObjectDef[] cache;
	private int offsetY;
	private int[] modifiedModelColors;
	public static MemCache modelCache = new MemCache(500);
	public String actions[];

}
