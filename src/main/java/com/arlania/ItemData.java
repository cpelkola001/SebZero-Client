package com.arlania;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;

public class ItemData {

    private static Map<Integer, ItemData> loadedItems = new HashMap<>();

    private String name = "";
    private String examine = "";
    private double[] bonuses = new double[18];
    private int[] requirements = new int[25];

    public static void load() {
        Path path = Paths.get(signlink.findcachedir() + "items.txt");
        try {
            List<String> data = Files.readAllLines(path);
            parse(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hasStats() {
        return DoubleStream.of(bonuses).anyMatch(bonus -> bonus > 0);
    }

    private static void parse(List<String> data) {
        int id = 0;
        ItemData itemData = new ItemData();
        for (String line : data) {
        	//System.out.println("line: " + line + " | " + id);
            String[] args = line.split(": ");
            if (args.length > 1) {
                String value = args[1];
                if (line.toLowerCase().startsWith("item id")) {
                    id = Integer.parseInt(value);
                }

                if (line.toLowerCase().startsWith("name")) {
                    itemData.setName(value);
                }

                if (line.toLowerCase().startsWith("examine")) {
                    itemData.setExamine(value);
                }

                if (line.toLowerCase().startsWith("bonus")) {
                    String[] other = line.split("]");
                    int index = Integer.parseInt(line.substring(6, other[0].length()));
                    double bonus = Double.parseDouble(value);
                    itemData.setBonus(index, bonus);
                }

                if (line.toLowerCase().startsWith("requirement")) {
                    // System.out.println("Started for id: " + id);
                    String[] other = line.split("]");
                    int index = Integer.parseInt(line.substring(12, other[0].length()));
                    int requirement = Integer.parseInt(value);
                    itemData.setRequirement(index, requirement);
                }
            }

            if(line.equalsIgnoreCase("finish")) {
            	//System.out.println("Adding: " + itemData);
//                System.out.println("Finished for id: " + id + " | Bonuses: " + Arrays.toString(itemData.getBonuses()));
                loadedItems.put(id, itemData);
                itemData = new ItemData();
              //  System.out.println(loadedItems.size());
            }
        }

    }

    public static Map<Integer, ItemData> getLoadedItems() {
        return loadedItems;
    }

    public static void setLoadedItems(Map<Integer, ItemData> loadedItems) {
        ItemData.loadedItems = loadedItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExamine() {
        return examine;
    }

    public void setExamine(String examine) {
        this.examine = examine;
    }

    public double[] getBonuses() {
        return bonuses;
    }

    public void setBonuses(double[] bonuses) {
        this.bonuses = bonuses;
    }

    public void setBonus(int index, double bonus) {
        this.bonuses[index] = bonus;
    }

    public int[] getRequirements() {
        return requirements;
    }

    public void setRequirements(int[] requirements) {
        this.requirements = requirements;
    }

    public void setRequirement(int index, int requirement) {
        this.requirements[index] = requirement;
    }
}
