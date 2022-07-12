package com.arlania;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class NpcDefinitionDumper {

	private int totalItems;

	public NpcDefinitionDumper(int totalItems) {
		this.totalItems = totalItems;
	}

	public static void main(String[] args) {
		new NpcDefinitionDumper(20000).execute();
	}

	public void execute() {
		System.out.println("Started Dumping... " + totalItems);
		int itemCount = 0;
		for (int i = 0; i < totalItems; i++) {
			ItemDef itemDef = ItemDef.forID(15956);
			if (itemDef != null) {
				LIST.add(itemDef);
			}
			itemCount++;
		}
		System.out.println("itemCount: " + itemCount);
		dump();
	}

	private void dump() {
		try (PrintWriter file = new PrintWriter(new FileOutputStream(new File("itemdef.txt"), true))) {
			LIST.forEach(item -> {
				if(item == null) {
					System.out.println("Found item thats null");
					return;
				}
				file.append("ID: " + item.id);
				file.println();
				file.append("Name: " + item.name);
				file.println();
				file.append("ModelID: " + item.modelID + " MaleEquip: " + item.maleEquip1 + " FemaleEquip: " + item.femaleEquip1);
				file.println();
				});

			file.flush();
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finished Dumping!");
		
	}
	
	}

	private List<ItemDef> LIST = new ArrayList<>();
}
