package com.shobudesign;

import com.arlania.NPCDef;

public final class Npc {
    public static NPCDef forId(final int index, NPCDef def) {
        switch (index) {
            case 13463:
                def.turn180AnimIndex = -1;
                def.turn90CCWAnimIndex = -1;
                def.turn90CWAnimIndex = -1;
                def.sizeY = 80;
                def.sizeXZ = 80;
                def.degreesToTurn = 32;
                def.actions = new String[5];
                def.name = "Dat Boi";
                def.actions = new String[] {null, null, null, null, null};
                def.combatLevel = 600;
                def.models = new int[] {60711};
                def.standAnim = 2433;
                def.squaresNeeded = 1;
                def.walkAnim = 2433;
                def.drawMinimapDot = true;
                break;
        }
        return def;
    }
}
