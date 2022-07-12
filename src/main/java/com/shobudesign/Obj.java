package com.shobudesign;

import com.arlania.ItemDef;

public final class Obj {
    public static ItemDef forId(final int index, final ItemDef def) {
        switch (index) {
            case 7036:
                def.modelID = 60711;
                def.stackable = false;
                def.name = "Dat Boi";
                def.description = "";
                def.actions = new String[5];
                def.modelZoom = 4000;
                def.rotationX = 1590;
                def.actions[2] = "Summon";
                def.actions[4] = "Drop";
                break;
        }
        return def;
    }
}
