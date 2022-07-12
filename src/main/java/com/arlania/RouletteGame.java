package com.arlania;

public class RouletteGame {

	private int shiftAmount = 20;
	protected int count = 0;

	protected int landCount = -1;

	protected boolean spinStarted = false;

	protected void spin() {
		if (!spinStarted)
			return;
		count++;
		// getShiftAmount(count);
		shiftBoxes();
		final RSInterface boxes = RSInterface.interfaceCache[23059];
		for (int i = 0; i < 500; i++)
			boxes.childX[i] -= shiftAmount;

		boxes.childX[500] = 232;

		shiftBoxes();

		// System.out.println("Landing index: " + getLandingIndex());
		// System.out.println("Boxes childx: " + Arrays.toString(boxes.childX));
		// System.out.println("Boxes childx 5: " + boxes.childX[5]);
	}

	protected int getLandingIndex() {
		System.out.println("Landing index: " + -landCount * 43);
		return -landCount * 43;
	}

	protected void shiftBoxes() {
		final RSInterface boxes = RSInterface.interfaceCache[23059];
		int stopIndex = getLandingIndex();
		if (stopIndex / 4 < boxes.childX[5]) {
			shiftAmount = 40;
		} else if (stopIndex / 2.8 < boxes.childX[5]) {
			shiftAmount = 35;
		} else if (stopIndex / 2.5 < boxes.childX[5]) {
			shiftAmount = 31;
		} else if (stopIndex / 2.2 < boxes.childX[5]) {
			shiftAmount = 27;
		} else if (stopIndex / 1.9 < boxes.childX[5]) {
			shiftAmount = 24;
		} else if (stopIndex / 1.7 < boxes.childX[5]) {
			shiftAmount = 21;
		} else if (stopIndex / 1.65 < boxes.childX[5]) {
			shiftAmount = 18;
		} else if (stopIndex / 1.61 < boxes.childX[5]) {
			shiftAmount = 16;
		} else if (stopIndex / 1.58 < boxes.childX[5]) {
			shiftAmount = 14;
		} else if (stopIndex / 1.55 < boxes.childX[5]) {
			shiftAmount = 12;
		} else if (stopIndex / 1.5 < boxes.childX[5]) {
			shiftAmount = 10;
		} else if (stopIndex / 1.45 < boxes.childX[5]) {
			shiftAmount = 8;
		} else if (stopIndex / 1.4 < boxes.childX[5]) {
			shiftAmount = 6;
		} else if (stopIndex / 1.35 < boxes.childX[5]) {
			shiftAmount = 5;
		} else if (stopIndex / 1.27 < boxes.childX[5]) {
			shiftAmount = 4;
		} else if (stopIndex / 1.13 < boxes.childX[5]) {
			shiftAmount = 3;
		} else if (stopIndex / 1.08 < boxes.childX[5]) {
			shiftAmount = 2;
		} else if (stopIndex < boxes.childX[5]) {
			shiftAmount = 1;
		} else {
			shiftAmount = 0;
			spinStarted = false;
			notifyServer();
		}
	}

	private void notifyServer() {
		Client.stream.createFrame(195);
		Client.stream.writeWord(landCount);
	}

	protected void resetBoxes() {
		final RSInterface boxes = RSInterface.interfaceCache[23059];
		// TODO re-do this hardcoded shit
		boxes.childX = new int[] { 0, 43, 86, 129, 172, 215, 258, 301, 344, 387, 430, 473, 516, 559, 602, 645, 688, 731,
				774, 817, 860, 903, 946, 989, 1032, 1075, 1118, 1161, 1204, 1247, 1290, 1333, 1376, 1419, 1462, 1505,
				1548, 1591, 1634, 1677, 1720, 1763, 1806, 1849, 1892, 1935, 1978, 2021, 2064, 2107, 2150, 2193, 2236,
				2279, 2322, 2365, 2408, 2451, 2494, 2537, 2580, 2623, 2666, 2709, 2752, 2795, 2838, 2881, 2924, 2967,
				3010, 3053, 3096, 3139, 3182, 3225, 3268, 3311, 3354, 3397, 3440, 3483, 3526, 3569, 3612, 3655, 3698,
				3741, 3784, 3827, 3870, 3913, 3956, 3999, 4042, 4085, 4128, 4171, 4214, 4257, 4300, 4343, 4386, 4429,
				4472, 4515, 4558, 4601, 4644, 4687, 4730, 4773, 4816, 4859, 4902, 4945, 4988, 5031, 5074, 5117, 5160,
				5203, 5246, 5289, 5332, 5375, 5418, 5461, 5504, 5547, 5590, 5633, 5676, 5719, 5762, 5805, 5848, 5891,
				5934, 5977, 6020, 6063, 6106, 6149, 6192, 6235, 6278, 6321, 6364, 6407, 6450, 6493, 6536, 6579, 6622,
				6665, 6708, 6751, 6794, 6837, 6880, 6923, 6966, 7009, 7052, 7095, 7138, 7181, 7224, 7267, 7310, 7353,
				7396, 7439, 7482, 7525, 7568, 7611, 7654, 7697, 7740, 7783, 7826, 7869, 7912, 7955, 7998, 8041, 8084,
				8127, 8170, 8213, 8256, 8299, 8342, 8385, 8428, 8471, 8514, 8557, 8600, 8643, 8686, 8729, 8772, 8815,
				8858, 8901, 8944, 8987, 9030, 9073, 9116, 9159, 9202, 9245, 9288, 9331, 9374, 9417, 9460, 9503, 9546,
				9589, 9632, 9675, 9718, 9761, 9804, 9847, 9890, 9933, 9976, 10019, 10062, 10105, 10148, 10191, 10234,
				10277, 10320, 10363, 10406, 10449, 10492, 10535, 10578, 10621, 10664, 10707, 10750, 10793, 10836, 10879,
				10922, 10965, 11008, 11051, 11094, 11137, 11180, 11223, 11266, 11309, 11352, 11395, 11438, 11481, 11524,
				11567, 11610, 11653, 11696, 11739, 11782, 11825, 11868, 11911, 11954, 11997, 12040, 12083, 12126, 12169,
				12212, 12255, 12298, 12341, 12384, 12427, 12470, 12513, 12556, 12599, 12642, 12685, 12728, 12771, 12814,
				12857, 12900, 12943, 12986, 13029, 13072, 13115, 13158, 13201, 13244, 13287, 13330, 13373, 13416, 13459,
				13502, 13545, 13588, 13631, 13674, 13717, 13760, 13803, 13846, 13889, 13932, 13975, 14018, 14061, 14104,
				14147, 14190, 14233, 14276, 14319, 14362, 14405, 14448, 14491, 14534, 14577, 14620, 14663, 14706, 14749,
				14792, 14835, 14878, 14921, 14964, 15007, 15050, 15093, 15136, 15179, 15222, 15265, 15308, 15351, 15394,
				15437, 15480, 15523, 15566, 15609, 15652, 15695, 15738, 15781, 15824, 15867, 15910, 15953, 15996, 16039,
				16082, 16125, 16168, 16211, 16254, 16297, 16340, 16383, 16426, 16469, 16512, 16555, 16598, 16641, 16684,
				16727, 16770, 16813, 16856, 16899, 16942, 16985, 17028, 17071, 17114, 17157, 17200, 17243, 17286, 17329,
				17372, 17415, 17458, 17501, 17544, 17587, 17630, 17673, 17716, 17759, 17802, 17845, 17888, 17931, 17974,
				18017, 18060, 18103, 18146, 18189, 18232, 18275, 18318, 18361, 18404, 18447, 18490, 18533, 18576, 18619,
				18662, 18705, 18748, 18791, 18834, 18877, 18920, 18963, 19006, 19049, 19092, 19135, 19178, 19221, 19264,
				19307, 19350, 19393, 19436, 19479, 19522, 19565, 19608, 19651, 19694, 19737, 19780, 19823, 19866, 19909,
				19952, 19995, 20038, 20081, 20124, 20167, 20210, 20253, 20296, 20339, 20382, 20425, 20468, 20511, 20554,
				20597, 20640, 20683, 20726, 20769, 20812, 20855, 20898, 20941, 20984, 21027, 21070, 21113, 21156, 21199,
				21242, 21285, 21328, 21371, 21414, 21457, 150 };
	}
}
