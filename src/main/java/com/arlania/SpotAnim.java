package com.arlania;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;

public final class SpotAnim {

	private static final int CUSTOM_GFX_COUNT = 100;
	private static int FIRST_CUSTOM_GFX_ID;
	private static int LAST_CUSTOM_GFX_ID;
	
	private static int smallRot = 0;
	private static int bigRot = 0;
	
	public static void unpackConfig(CacheArchive streamLoader) {
		Stream stream = new Stream(streamLoader.getDataForName("spotanim.dat"));
		int length = stream.readUnsignedWord();
		
		if (cache == null)
			cache = new SpotAnim[length + CUSTOM_GFX_COUNT];
		
		FIRST_CUSTOM_GFX_ID = LAST_CUSTOM_GFX_ID = length;
		
		for (int j = 0; j < length; j++) {
			if (cache[j] == null)
				cache[j] = new SpotAnim(j);
			cache[j].setId(j);
			cache[j].readValues(stream);
		}
		editExistinGFX();
		//System.out.println("GFX: "+smallRot+", "+bigRot);
		
		try {
			loadCustomGFXes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SpotAnim createNewGFX() {
		SpotAnim newGfx = new SpotAnim(++LAST_CUSTOM_GFX_ID);
		return newGfx;	
	}
	public static SpotAnim createNewGFXFrom(int toCopy) {
		SpotAnim newGfx = cache[toCopy].copy(++LAST_CUSTOM_GFX_ID);
		return newGfx;	
	}
	
	public void setTexture(Model model, int gfxId) { // Milo :D
		switch(gfxId) {
		case 2998:
		case 3012:
			model.setTexture(51);
			break;
		case 3003:
			model.setTexture(40);
			break;
			
		case 3002:
			model.setTexture(58);
			break;
			
		case 3004:
		case 3010:
			model.setTexture(59);
			break;
			
		case 3005:
			model.setTexture(52);
			break;
			
		case 3006:
			model.setTexture(57);
			break;
			
		case 3009:
			model.setTexture(40);
			break;
			
			
	}
	}
	
	private static void editExistinGFX() {
		
		
		//cache[2998].setTexture(model, 2998);
		
		cache[500].setSizeXY(250);
		cache[500].setSizeZ(250);
		//zulrah
		
		cache[1044].setModelId(20390);
		cache[1044].animationId = 5358;
		cache[1044].setSizeXY(112);
		cache[1044].setSizeZ(112);
		cache[1044].rotation = 0;
		cache[1044].shadow = 0;
		cache[1044].lightness = 0;
		cache[1044].originalColours = new int[] { 22476, 25511,  0, 0, 0, 0 };
		cache[1044].destColours = new int[] { 30608, 30236, 0, 0, 0, 0 };
		cache[1044].animation = Animation.anims[5358];
		
		
		cache[1048].setModelId(14116);
		cache[1048].animationId = 5358;
		cache[1048].setSizeXY(60);
		cache[1048].setSizeZ(60);
		cache[1048].shadow = 60;
		
		cache[1050].setModelId(14117);
		cache[1050].animationId = 5358;
		cache[1050].setSizeXY(40);
		cache[1050].setSizeZ(40);
		cache[1050].shadow = 60;
		
		cache[1051].setModelId(14119);
		cache[1051].animationId = 3358;
		cache[1051].setSizeXY(40);
		cache[1051].setSizeZ(40);
		cache[1051].shadow = 90;
		
		cache[1052].setModelId(25090);
		cache[1052].animationId = 5358;
		cache[1052].setSizeXY(120);
		cache[1052].setSizeZ(120);
		cache[1052].shadow = 60;
		
		cache[1053].setModelId(20390);
		cache[1053].animationId = 5358;
		cache[1053].setSizeXY(112);
		cache[1053].setSizeZ(112);
		cache[1053].rotation = 0;
		cache[1053].shadow = 0;
		cache[1053].lightness = 0;
		cache[1053].originalColours = new int[] { 22476, 25511, 0, 0, 0, 0 };
		cache[1053].destColours = new int[] { 818, 6199, 0, 0, 0, 0 };
		cache[1053].animation = Animation.anims[5358];
		
		cache[1054].setModelId(21590);
		cache[1054].animationId = 5358;
		cache[1054].animationId = 5358;
		cache[1054].setSizeXY(112);
		cache[1054].setSizeZ(112);
		cache[1054].rotation = 0;
		cache[1054].shadow = 0;
		cache[1054].lightness = 0;
		cache[1054].originalColours = new int[] { 22476, 25511, 0, 0, 0, 0 };
		cache[1054].destColours = new int[] { 818, 6199, 0, 0, 0, 0 };
		cache[1054].animation = Animation.anims[5358];
		
		cache[1055].setModelId(27968);
		cache[1055].animationId = 5358;
		cache[1055].animationId = 5358;
		cache[1055].setSizeXY(32);
		cache[1055].setSizeZ(32);
		cache[1055].rotation = 30;
		cache[1055].shadow = 60;
		cache[1055].lightness = 60;
		cache[1055].animation = Animation.anims[5358];
		
		
		cache[1056].setModelId(1109);
		cache[1056].rotation = 0;

		
		cache[1049].setModelId(14118);
		cache[1049].animationId = 5358;
		cache[1049].setSizeXY(60);
		cache[1049].setSizeZ(60);
		cache[1049].shadow = 60;
		
		
		cache[1047].setModelId(20390);
		cache[1047].animationId = 5358;
		cache[1047].setSizeXY(112);
		cache[1047].setSizeZ(112);
		cache[1047].rotation = 0;
		cache[1047].shadow = 0;
		cache[1047].lightness = 0;
		cache[1047].originalColours = new int[] { 22476, 25511, 0, 0, 0, 0 };
		cache[1047].destColours = new int[] { 127, 10355, 0, 0, 0, 0 };
		cache[1047].animation = Animation.anims[5358];

		cache[2274].setModelId(cache[2281].getModelId());
		cache[2274].animationId = cache[2281].animationId;
		cache[2274].rotation = 90;
		cache[2274].animation = cache[2281].animation;
		
	}

	private void readValues(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1)
				setModelId(stream.readUnsignedWord());
			else if (i == 2) {
				animationId = stream.readUnsignedWord();
				if (Animation.anims != null)
					animation = Animation.anims[animationId];
			} else if (i == 4)
				setSizeXY(stream.readUnsignedWord());
			else if (i == 5)
				setSizeZ(stream.readUnsignedWord());
			else if (i == 6) {
				rotation = stream.readUnsignedWord();
				if(rotation > bigRot) {
					bigRot = rotation;
				}
				if(rotation < smallRot) {
					smallRot = rotation;
				}
			}else if (i == 7)
				shadow = stream.readUnsignedByte();
			else if (i == 8)
				lightness = stream.readUnsignedByte();
			else if (i == 40) {
				int j = stream.readUnsignedByte();
				for (int k = 0; k < j; k++) {
					originalColours[k] = stream.readUnsignedWord();
					destColours[k] = stream.readUnsignedWord();
				}
			} else
				System.out.println("Error unrecognised spotanim config code: "
						+ i);
		} while (true);
	}

	

	public Model getModel() {
			Model model = (Model) modelCache.get(getId());
			if (model != null)
				return model;
			model = Model.fetchModel(getModelId());
			if (model == null)
				return null;
			
			int length = Math.max(originalColours.length, destColours.length);
			for (int i = 0; i < length; i++) {
				if (i < originalColours.length && i < destColours.length) {
					model.recolour(originalColours[i], destColours[i]);
				}
			}
			setTexture(model, getId());
			modelCache.put(model, getId());
			return model;
		
	}
	
	public SpotAnim copy(int newId) {
		SpotAnim copied = new SpotAnim(newId);
		copied.anInt400 = anInt400;
		copied.setModelId(modelId);
		copied.animationId = animationId;
		copied.animation = animation;
		copied.originalColours = new int[originalColours.length];
		copied.destColours = new int[destColours.length];
		System.arraycopy(originalColours, 0, copied.originalColours, 0, originalColours.length);
		System.arraycopy(destColours, 0, copied.destColours, 0, destColours.length);
		copied.setSizeXY(sizeXY);
		copied.setSizeZ(sizeZ);
		copied.rotation = rotation;
		copied.shadow = shadow;
		copied.lightness = lightness;
		return copied;
	}
	public void removeRecolors() {
		originalColours = new int[6];
		destColours = new int[6];
	}
	public void brighten(double multiplier) {
		lightness *= multiplier;
	}
	public void darken(double multiplier) {
		shadow *= shadow;
	}
	public void rotate(int angleAmount) {
		rotation += angleAmount;
	}
	
	
	public void setMultiplierWidth(double multiplierWidth) {
		this.multiplierWidth = multiplierWidth;
	}

	public void setMultiplierHeight(double multiplierHeight) {
		this.multiplierHeight = multiplierHeight;
	}

	public void recolor(int targetColor, int newColor) {
		int firstFreeSlot = originalColours.length;
	
		for(int i = 0; i< originalColours.length; i ++) {
			if(originalColours[i] == 0) {
				firstFreeSlot = i;
			}
			if(originalColours[i] == targetColor) {
				destColours[i] = newColor;
				return;
			}
		}
		if(firstFreeSlot == originalColours.length) {
			int newLength = firstFreeSlot+1;
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
	
	public void setAnimation(int animationId) {
		this.animationId = animationId;
		this.animation = Animation.anims[animationId];
	}
	
	public void cacheAnimation() {
		if(animationId >= 0) {
			animation = Animation.anims[animationId];
		}
	}
	
	void cache() {
		cache[getId()] = this;
	}

	private SpotAnim(int id) {
		this.setId(id);
		anInt400 = 9;
		animationId = -1;
		originalColours = new int[6];
		destColours = new int[6];
		setSizeXY(128);
		setSizeZ(128);
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public int getSizeXY() {
		return (int) (sizeXY * multiplierWidth);
	}

	public void setSizeXY(int sizeXY) {
		this.sizeXY = sizeXY;
	}

	public int getSizeZ() {
		return (int) (sizeZ * multiplierHeight);
	}

	public void setSizeZ(int sizeZ) {
		this.sizeZ = sizeZ;
	}

	public int anInt400;
	public static SpotAnim cache[];
	@Expose private int id;
	@Expose private int modelId;
	@Expose private int animationId;
	public Animation animation;
	@Expose public int[] originalColours;
	@Expose public int[] destColours;
	@Expose
	private int sizeXY;
	@Expose
	private int sizeZ;
	@Expose public int rotation;
	@Expose public int shadow;
	@Expose public int lightness;
	public static MemCache modelCache = new MemCache(30);
	@Expose public double multiplierWidth = 1.0D;
	@Expose public double multiplierHeight = 1.0D;
	@Override
	public String toString() {
		return "SpotAnim [anInt400=" + anInt400 + ", id=" + getId() + ", modelId=" + modelId + ", animationId=" + animationId
				+ ", " + (animation != null ? "animation=" + animation + ", " : "")
				+ (originalColours != null ? "originalColours=" + Arrays.toString(originalColours) + ", " : "")
				+ (destColours != null ? "destColours=" + Arrays.toString(destColours) + ", " : "") + "sizeXY=" + getSizeXY()
				+ ", sizeZ=" + getSizeZ() + ", rotation=" + rotation + ", shadow=" + shadow + ", lightness=" + lightness
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private final static Gson GSON = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation()
			.setPrettyPrinting()
			.create();
	private final static Type TYPE = new TypeToken<HashSet<SpotAnim>>() {}.getType();
	private final static Path PATH = Paths.get(signlink.findcachedir(), "custom_gfx.json");
	
	private static void loadCustomGFXes() throws IOException {
		File file = PATH.toFile();
		FileReader reader = new FileReader(file);

		HashSet<SpotAnim> customGFXs = GSON.fromJson(reader, TYPE);
		for(SpotAnim custom : customGFXs) {
			if(custom != null) {
				custom.cacheAnimation();
				custom.cache();
				if(custom.id > LAST_CUSTOM_GFX_ID)
					LAST_CUSTOM_GFX_ID = custom.id;
			}
		}	
		System.out.println("[SpotAnim]: loaded "+(customGFXs.size())+" customs.");
	}
	
	public static void saveCustomGFXes() throws IOException {
		
		HashSet<SpotAnim> customGFXs = new HashSet<>();
		File file = PATH.toFile();
		
		if(file.createNewFile())
			System.out.println("[SpotAnim] Created a new file for custom gfxes at '"+PATH.toString()+"'");
		
		FileWriter writer = new FileWriter(file);
		
		for(int i = FIRST_CUSTOM_GFX_ID; i <= LAST_CUSTOM_GFX_ID; i++) {
			SpotAnim custom = cache[i];
			if(custom != null)
				customGFXs.add(custom);
		}
		GSON.toJson(customGFXs, TYPE, writer);
		writer.flush();
		writer.close();
	}
}