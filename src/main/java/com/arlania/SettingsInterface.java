package com.arlania;

public class SettingsInterface extends RSInterface {

    public static void load() {
        final int STARTING_POINT = 26253;
        RSInterface main = addInterface(STARTING_POINT);
        addHoverableSprite(STARTING_POINT + 1, 1221, 1222, true, "Go back");
        addSpriteLoader(STARTING_POINT + 2, 1219);
        main.totalChildren(7);
        main.child(0, STARTING_POINT + 1, 8, 7);
        main.child(1, STARTING_POINT + 2, 5, 30);
        addProperConfigButton(STARTING_POINT + 4, 1223, 1224, "Fixed Mode", 0, 4001);
        main.child(2, STARTING_POINT + 4, 13, 40);
        addProperConfigButton(STARTING_POINT + 5, 1225, 1226, "Resizable Mode", 1, 4001);
        main.child(3, STARTING_POINT + 5, 70, 40);
        addProperConfigButton(STARTING_POINT + 6, 1227, 1228, "Fullscreen Mode", 2, 4001);
        main.child(4, STARTING_POINT + 6, 127, 40);

        addTextComponent(STARTING_POINT + 7, "Settings", fonts, 2, ColorConstants.RS_ORANGE, false, true, 0, 0);
        main.child(5, STARTING_POINT + 7, 70, 8);

        main.child(6, STARTING_POINT + 10, 7, 89);


        RSInterface scroll = addInterface(STARTING_POINT + 10);
        scroll.width = 160;
        scroll.height = 169;
        scroll.scrollMax = 370;
        scroll.totalChildren(27);

        int startId = STARTING_POINT + 11;

        addTextComponent(startId, "Toggles", fonts, 0, 0xb3b3e0, false, true, 0, 0);
        scroll.child(0, startId, 3, 3);

        int y = 20;
        for (int i = 0; i < 10; i++) {
            addToggleButton1(startId + 1 + i, 1229, 1710 + i, 15, 15, "Select");
            // addToggleButton(startId + 1 + i,1286,4002,15,15,"Select");
            //   addProperConfigButton(startId + 1 + i, 1286, 1287, "Select", i, 4002 + i);
            scroll.child(1 + i, startId + 1 + i, 5, y);
            y += 18;
        }

        //TODO fog color, depth
        String[] toggleTooltips = {
        		"Moving Textures",
        		"Show Perk Overlays", 
        		"Rank Head Icons", 
        		"Show Fog",
        		"Show Particles", 
        		"Show Prayer Overheads",
        		"Ground Item Names",
        		"Smooth Shading",
        		"Show Progression Overlay",
        		"Show Ground Decorations"};

        y = 20;
        for (int i = 0; i < 10; i++) {
            addTextComponent(startId + 11 + i, toggleTooltips[i], fonts, 0, ColorConstants.RS_ORANGE, false, true, 0, 0);
            scroll.child(11 + i, startId + 11 + i, 25, y + 2);
            y += 18;
        }

        addTextComponent(startId + 21, "Sliders", fonts, 0, 0xb3b3e0, false, true, 0, 0);
        scroll.child(21, startId + 21, 3, y + 1);

        String[] sliderTooltips = {"View Distance", "Texture Animation Speed", "Fog Start Value", "Brightness"};
        int[] minValues = {25, 1, 2000, 300};
        int[] maxValues = {50, 7, 3000, 10};
        int[] defaultValues = {25, 3, 2500, 80};
        for (int i = 0; i < 4; i++) {
            addSlider(startId + 22 + i, minValues[i], maxValues[i], defaultValues[i], 1217, 1218, sliderTooltips[i]);
            scroll.child(22 + i, startId + 22 + i, 3, y + 15);
            y += 20;
        }

        addRGBPicker(startId + 26, 130, 62, 25, 10, 10, "Fog Color");
        scroll.child(26, startId + 26, 3, y + 20);

        //            addTextComponent(startId + 2 + i,"A text",fonts,0,ColorConstants.RS_ORANGE, false,true,0,0);

        /*for (int i = 0; i < 25; i++) {
            addSlider(startId + 1 + i, 10, 100, 50, 1274, 1275, "Test Slider" + i);
            scroll.child(1 + i, startId + 1 + i, 5, 25 + (i * 30));
        }*/
    }

}
