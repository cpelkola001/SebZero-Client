package com.arlania;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javafx.application.Application;

/**
 * A simple utility to print information about certain models. (ATM only colors
 * of item models)
 *
 * @author Stan van der Bend (https://www.rune-server.ee/members/StanDev/)
 * @since 2019-01-31
 * @version 1.0
 */
public class ModelUtil {

	private static Path DUMP_PATH = Paths.get("dumps");
	private static int lastGFX = 0;
	public static SpotAnim spotAnim;
	public static ItemDef itemDef;
	public static boolean keepPlaying = false;

	public static void setGFX(int id) {
		lastGFX = id;
		spotAnim = SpotAnim.cache[id];
	}

	public static boolean parseClientCommand(String command) {
		String[] args = command.split(" ");
		if (command.contains("gfx")) {
			System.out.println(Arrays.toString(args));
			try {

				int gfx = args.length < 2 ? lastGFX : Integer.parseInt(args[1]);
				spotAnim = SpotAnim.cache[gfx];
				lastGFX = gfx;

				switch (args[0]) {
				case "togglegfx":
					keepPlaying = !keepPlaying;
					break;
				case "gfxtool":
					System.out.println("Executed gfxtool");
					new Thread(() -> {
						Application.launch(RecolorApplication.class);
					}).start();

					break;
				case "selectgfx":
					break;
				case "changegfxanim":
					int anim = Integer.parseInt(args[2]);
					spotAnim.setAnimation(anim);
					System.out.println("Set the animation of " + gfx + " to " + anim);
					break;
				case "changegfxmodel":
					int model = Integer.parseInt(args[2]);
					spotAnim.setModelId(model);
					SpotAnim.modelCache.clear();
					System.out.println("Set the model of " + gfx + " to " + model);
					break;
				case "changegfxsize":
					int width = Integer.parseInt(args[2]);
					int height = Integer.parseInt(args[2]);
					spotAnim.setSizeXY(width);
					spotAnim.setSizeZ(height);
					System.out.println("Set the width and height of " + gfx + " to (" + width + ", " + height + ")");
					break;

				/*
				 * case "getxysize": System.out.println(spotAnim.getSizeXY()); break;
				 */

				case "rotategfx":
					int angleAmount = Integer.parseInt(args[2]);
					spotAnim.rotate(angleAmount);
					break;
				case "setgfxrotation":
					int rotation = Integer.parseInt(args[2]);
					spotAnim.rotation = rotation;
					break;
				case "modgfxlight":
					double brightnessMultiplier = Double.parseDouble(args[2]);
					spotAnim.brighten(brightnessMultiplier);
					break;
				case "setgfxlight":
					int lightness = Integer.parseInt(args[2]);
					spotAnim.lightness = lightness;
					break;
				case "modgfxshadow":
					double shadowMultiplier = Double.parseDouble(args[2]);
					spotAnim.darken(shadowMultiplier);
					break;
				case "setgfxshadow":
					int shadowness = Integer.parseInt(args[2]);
					spotAnim.shadow = shadowness;
					break;
				case "recolorgfx":
					int targetColor = Integer.parseInt(args[2]);
					int newColor = Integer.parseInt(args[3]);
					spotAnim.recolor(targetColor, newColor);
					System.out.println("Recolored " + gfx + ": " + targetColor + " -> " + newColor + "");
					break;
				case "removegfxrecolors":
					System.out.println("Removing recolors of " + gfx);
					spotAnim.removeRecolors();
					SpotAnim.modelCache.clear();
					break;
				case "printgfx":
					System.out.println("Printing colors of " + gfx);
					System.out.println(spotAnim.toString());
					break;
				case "printgfxcolors":
					getModelColors(spotAnim.getModel()).forEach(entry -> {
						System.out.println(
								" color(" + entry.getKey() + ") occured " + entry.getValue().get() + " times.");
					});
					break;
				case "cleargfxmodelcache":
					SpotAnim.modelCache.clear();
					break;
				case "addgfx":
					final boolean copyExisting = args.length > 1;
					final SpotAnim newGFX = copyExisting ? SpotAnim.createNewGFXFrom(Integer.parseInt(args[1]))
							: SpotAnim.createNewGFX();
					System.out.println("Created new gfx with id " + (newGFX.getId()));
					newGFX.cache();
					lastGFX = newGFX.getId();
					break;
				case "savegfxs":
					SpotAnim.saveCustomGFXes();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/*if (command.startsWith("itemtool")) {
			String itemID = command.substring(9);
			Client.currentlyEditedItemId = Integer.parseInt(itemID);
			if (Client.currentlyEditedItemId == 0) {
				Client.itemEditing = false;
				System.out.println("Edited item is 0");
			} else {
				System.out.println("True");
				Client.itemEditing = true;
				Client.needDrawTabArea = true;
				RSInterface rsi = RSInterface.interfaceCache[3214];
				for (int slot = 0; slot < 28; slot++) {
					rsi.inv[slot] = Client.currentlyEditedItemId + 1;
					rsi.invStackSizes[slot] = 1;
					//setItems();
				}

				new Thread(() -> {
					Application.launch(SuicsItemEditorApplication.class);
				}).start();
			}
		}*/
		
		if(command.startsWith("defeditor")) {
			new Thread(() -> {
				Application.launch(SuicsItemEditorApplication.class);
			}).start();
		}
		
		if(command.startsWith("npctool")) {
			new Thread(() -> {
				Application.launch(NpcConfigApplication.class);
			}).start();
		}

		switch (command) {

		/*
		 * case "test": System.out.println("Test was executed"); String itemID =
		 * command.substring(5); Client.currentlyEditedItemId =
		 * Integer.parseInt(itemID); System.out.println("Executed test");
		 * System.out.println("Now debugging item: " + itemID); new Thread(() -> {
		 * Application.launch(SuicsItemEditorApplication.class); }).start(); break;
		 */

		case "dumpitemcolors":
			dumpItemModelColors(true);
			break;
		}
		return false;
	}

	public static void dumpItemModelColors(boolean toFile) {

		File savePath = DUMP_PATH.resolve("item_model_colors.txt").toFile();
		FileWriter fileWriter = null;
		if (toFile) {
			try {
				fileWriter = new FileWriter(savePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < ItemDef.totalItems; i++) {
			ItemDef def = ItemDef.forID(i);
			if (def != null && def.name != null && !def.name.isEmpty()) {

				Model invModel = def.getItemModel(1);
				if (invModel != null) {

					if (invModel.triangleColour != null) {

						final String header = "Colors for model[" + def.modelID + "] of item[" + def.id + "] with name "
								+ def.name + ":";
						final FileWriter writer = fileWriter;

						if (toFile) {
							try {
								writer.write(header + System.lineSeparator());
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else
							System.out.println(header);

						for (Map.Entry<Integer, AtomicInteger> entry : getModelColors(invModel)) {
							String line = "	-> color(" + entry.getKey() + ") occured " + entry.getValue().get()
									+ " times.";
							if (toFile) {
								try {
									writer.write(line + System.lineSeparator());
								} catch (IOException e) {
									e.printStackTrace();
								}
							} else
								System.out.println(line);
						}

					}
				}
			}
		}
		if (toFile) {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Set<Entry<Integer, AtomicInteger>> getModelColors(Model model) {
		final TreeMap<Integer, AtomicInteger> weightedColors = new TreeMap<Integer, AtomicInteger>();

		for (int color : model.triangleColour) {
			weightedColors.putIfAbsent(color, new AtomicInteger(0));
			weightedColors.get(color).incrementAndGet();
		}
		return weightedColors.entrySet().stream().sorted(Comparator.comparingInt(entry -> entry.getValue().get()))
				.collect(Collectors.toSet());
	}

}