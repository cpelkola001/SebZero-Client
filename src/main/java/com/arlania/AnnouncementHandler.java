package com.arlania;

public class AnnouncementHandler {
    private final int x = 4;
    private final int y = 329;
    private String text = "";


    private final Client instance;

    public AnnouncementHandler(Client client) {
        this.instance = client;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void render() {
        if(text.isEmpty()) {
            return;
        }

        instance.drawingArea.method385(0xffff00, text, y, x);
        boolean hovering = instance.mouseY >= 329 && instance.mouseX <= 503;
        if(hovering) {
            instance.menuActionName[1] = "Dismiss";
            instance.menuActionID[1] = 1773;
            instance.menuActionRow = 2;
        }

    }
}
