package com.arlania;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author Suic
 */

public class WheelOfFortune {

    private final int width;
    private final int height;
    private final int strokeWidth;
    private final int color; //unused for now
    private final int alpha;
    private final int closure;
    private final boolean fill;
    private final int segments;
    private final Sprite icon;

    private final double arcLength;

    private double drag = 0.97;
    private double angleVel = 0;
    private double angle = 0;
    private int index = -1;
    private int currentIndex = -1;

    private final double INITIAL_DRAG = 0.993;
    private final double LATER_DRAG = 0.988;
    private final double DRAG_CHANGE_CUTOFF = 3.5;
    private final double END_SPIN_CUTOFF = 0.4;

    private int[] items = {6638, 6638, 6638, 6638, 6638, 6638, 6638, 6638, 6638, 6638}; // test

    private boolean active;


    public WheelOfFortune(int width, int height, int strokeWidth, int color, int alpha, int closure, boolean fill, int segments, Sprite icon) {
        this.width = width;
        this.height = height;
        this.strokeWidth = strokeWidth;
        this.color = color;
        this.alpha = alpha;
        this.closure = closure;
        this.fill = fill;
        this.segments = segments;
        this.icon = icon;
        arcLength = 360D / segments;
    }


    public void render(int x, int y) {
        int idx = 0;
        update();
        for (double theta = 0; theta < 360; theta += arcLength) {
            DrawingArea.drawArc(x, y, width, height, strokeWidth, -(angle + theta), arcLength, 0x3f372c, alpha, closure, fill);
            idx++;
        }

        for (int i = 0; i < items.length; i++) {
            Sprite itemSprite = ItemDef.getSprite(items[i], 1, 0);
            if (itemSprite == null) {
                break;
            }
            double theta = i * arcLength;
            double newPhi = ((angle + theta) + arcLength / 2D);
            double newRadius = width / 3D;

            double wheelCenterX = x + width / 2D;
            double wheelCenterY = y + height / 2D;

            double arcCenterX = (Math.cos(Math.toRadians(newPhi)) * newRadius + wheelCenterX);
            double arcCenterY = (Math.sin(Math.toRadians(newPhi)) * newRadius + wheelCenterY);
            itemSprite.drawSprite((int) (arcCenterX + 2) - itemSprite.myWidth / 2, (int) (arcCenterY + 2) - itemSprite.myHeight / 2);
        }

        icon.drawAdvancedSprite(x + (width / 2) - (icon.myWidth / 2), y - (height / 12), 255);
    }

    private void update() {

        if (!active) {
            return;
        }

        if (angleVel < END_SPIN_CUTOFF) {
            angleVel = 0;
            notifyServer();
            active = false;
            return;
        }

        if (angleVel < DRAG_CHANGE_CUTOFF) {
            drag = LATER_DRAG;
        }

        angle += angleVel;
        angleVel *= drag;

        currentIndex = (int) (Math.floorMod((int) (-angle + (segments * 0.75D) * arcLength), 360) / arcLength);
    }

    public void init() {
        this.drag = INITIAL_DRAG;
        this.angle = 0;
        double spinDurationAfterCutoff = Math.log(END_SPIN_CUTOFF / DRAG_CHANGE_CUTOFF) / Math.log(LATER_DRAG);
        double angleAfterDragChange = DRAG_CHANGE_CUTOFF * (1 - Math.pow(LATER_DRAG, spinDurationAfterCutoff)) / (1 - LATER_DRAG);
        double endAngle = ThreadLocalRandom.current().nextInt(3, 7) * 360 - angleAfterDragChange;
        endAngle -= 90 + arcLength / 2; // center index 0 at the marker
        endAngle -= index * arcLength;  // select the index by shifting it so many segments over
        double offset = ThreadLocalRandom.current()
            .nextDouble(-arcLength / 2 + 5, arcLength / 2 - 5);
        endAngle -= offset;
        double tToCutoff = Math.log(DRAG_CHANGE_CUTOFF / (DRAG_CHANGE_CUTOFF + endAngle * (1 - drag))) / Math
            .log(drag);
        this.angleVel = DRAG_CHANGE_CUTOFF / Math.pow(drag, tToCutoff);
        active = true;
    }

    public void setItems(int[] items) {
        this.items = items;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private void notifyServer() {
        Client.stream.createFrame(225);
        Client.stream.writeByte(index);
    }
}
