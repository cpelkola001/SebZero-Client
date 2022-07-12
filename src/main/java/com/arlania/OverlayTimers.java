package com.arlania;

import java.util.ArrayList;
import java.util.List;

public class OverlayTimers {

    /**
     * List of overlays.
     */
    public static List<OverlayTimers> overlayTimers = new ArrayList<OverlayTimers>();
    
    public final static int WHITE = 0xffffff;

    /**
     * Sprite id to display.
     */
    private int spriteId;

    /**
     * The time the timer was started.
     */
    private long timeStarted;

    /**
     * The time to end the timer.
     */
    private long timeToEnd;

    public OverlayTimers(int spriteId, long timeStarted, long timeToEnd) {
        this.spriteId = spriteId;
        this.timeStarted = timeStarted;
        this.timeToEnd = timeToEnd;
    }

    /**
     * Remove a specific timer that is using the requested sprite id.
     */
    public static void remove(int spriteIdToRemove) {
        for (int index = 0; index < overlayTimers.size(); index++) {
            OverlayTimers data = overlayTimers.get(index);
            if (data.spriteId == spriteIdToRemove) {
                overlayTimers.remove(index);
                break;
            }
        }
    }

    /**
     * Remove all timers.
     */
    public static void clearAllTimers() {
        overlayTimers.clear();
    }



    /**
     * Draw the vengeance, freeze timers etc..
     */
    public static void drawOverlayTimers() {
        if (!Client.overlayTimers) {
            return;
        }
        int xOffset = 0; // Increases depending on amount of timers displayed.
        for (int index = 0; index < overlayTimers.size(); index++) {
            OverlayTimers data = overlayTimers.get(index);

            long currentTime = System.currentTimeMillis();
            if (currentTime > data.timeToEnd) {
                remove(data.spriteId);
                continue;
            }
            int duration = (int) ((data.timeToEnd - data.timeStarted) / 1000);
            if (duration == 0) {
                remove(data.spriteId);
                continue;
            }
            int seconds = (int) (duration - ((currentTime - data.timeStarted) / 1000));
            int x = Client.clientSize == 0 ? 0 : Client.clientWidth - 300;
            int y = Client.clientSize == 0 ? 235 : Client.clientHeight - 225;
            Client.cacheSprite[1266].drawSprite3(x + 7, (y - xOffset) - 15, 100);//Semi transparent background sprite
            Client.cacheSprite[data.spriteId].drawSprite(x + 19, (y - xOffset) - 10);
            Client.instance.newSmallFont.drawBasicString1(getTimeLeft(seconds), x + 26, (y - xOffset) + 26, true, WHITE, true);
            xOffset += 46;
        }
    }

    /**
     * Add a new overlay.
     */
    public static void addNewOverlay(int spriteId, int secondsDuration) {
        for (int index = 0; index < overlayTimers.size(); index++) {
            OverlayTimers data = overlayTimers.get(index);
            if (data.spriteId == spriteId) {
                data.timeStarted = System.currentTimeMillis();
                data.timeToEnd = System.currentTimeMillis() + (secondsDuration * 1000);
                return;
            }
        }
        OverlayTimers.overlayTimers.add(new OverlayTimers(spriteId, System.currentTimeMillis(), System.currentTimeMillis() + (secondsDuration * 1000)));
    }
    
    public static String getTimeLeft(int seconds) {
        int hours = 0;
        int minutes = 0;
        int secondsLeft = 0;

        String time = "";
        if (seconds > 3600) {
            hours = seconds / 3600;
            time = hours + "h";
        }
        int value1 = 0;
        value1 = seconds - (hours * 3600);
        if (value1 > 0) {
            minutes = value1 / 60;
            if (minutes > 0) {
                if (!time.isEmpty()) {
                    time = time + " ";
                }
                time = time + minutes + "m";
            }
        }
        int value2 = value1 - (minutes * 60);
        if (value2 >= 0) {
            secondsLeft = value2;


            if (!time.isEmpty()) {
                time = time + " ";
            }
            time = time + secondsLeft + "s";
        }
        return time;
    }
}