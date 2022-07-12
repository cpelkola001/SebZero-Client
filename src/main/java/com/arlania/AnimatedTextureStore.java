package com.arlania;

public enum AnimatedTextureStore {
	
		WATER_DROPLETS(17, 2),
		WATER(1, 1),
		WATFER(24, 1),
		MAGIC_TREE_STARS(34, 2),
		FIRECAPE(40, 2, 0x0dbf16),
		CUSTOM(51, 2),
		PROCUSTOM(52, 2),
		NOOBCUSTOM(53, 2),
		NEWBCUSTOM(54, 2),
		XD(55, 2),
		XDHEH(56, 2),
		DADWR(57, 2),
		RANDOMNOOB(12, 1),
		RANDOMOK(19, 1),
		SEC(58, 2),
		INFERNAL(60, 2),
		SECMEN(59, 2),
		WEW(61, 2),
		SUICISNUMBERONE(62, 2),
		WEWXD(63, 2),
		WEXDWXD(64, 2),
		WEXDDWXD(65, 3),
		COOLGUY(66, 2),
		FASTERINFERNAL(67, 4),
		YEAH(68, 2),
		YeahNonInfernal(69, 2),
		COWCAPE(70, 2),
		CUSTOMINFTEXTURE(71, 2),
		GREENINFTEXTURE(72, 2),
		YELLOWINFTEXTURE(73, 2),
		REDINFTEXTURE(74, 2),
		OMNIWEIRDSHIT(75, 2),
		GREEN_FIRE(80, 1),
		PURPLE_NURPLE(81, 1),
		PINK_DILDO(82, 1),
		RED_DILDO(83, 1),
		BRIGHTRED_DILDO(84, 1),
		BLUE_DILDO(85, 1),
		LIGHTNING_DILDO(86, 1),
		GALAXYDRUG(87, 1),
		RAINBOWSHIT(88, 2),
		PURPLESHIT(89, 2),
		COOSHIT(90, 2),
		CO1OSHIT(91, 2),
		RANDOMBRO(25, 1);
	
		private final int material_id;
		private final int speed;
		private int color;
		AnimatedTextureStore(int material_id, int speed) {
			this.material_id = material_id;
			this.speed = speed;
		}
		
		AnimatedTextureStore(int material_id, int speed, int customTextureColor) {
			this.material_id = material_id;
			this.speed = speed;
			this.color = customTextureColor;
		}

		
		public int getId() {
			return material_id;
		}
		
		public int getSpeed() {
			return speed;
		}
		
		public int getCustomColor() {
			return color;
		}

	}