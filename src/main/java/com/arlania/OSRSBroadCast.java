package com.arlania;
public final class OSRSBroadCast {

    private String text = "Click this Message to read our latest Patch Notes!";
    private String link = "http://Equinox317.com";

    private final Client instance = Client.instance;

    public OSRSBroadCast(final String text, String link) {
        this.text = text;
        this.link = link;
    }

    public OSRSBroadCast(final String text) {
        this.text = text;
    }
    
    public String getLink() {
    	return link;
    }

    private int x = 0;

    public void isHovered(final int mouseX, final int mouseY) {

        x = text.length() * 6;
        final boolean hovered = mouseX >= 5 && mouseX <= x && mouseY >= 318 && mouseY <= 333;

        if (hovered && instance.isDisplayed && !link.isEmpty()) {
            instance.menuActionName[1] = "Open Link";
            instance.menuActionName[2] = "Dismiss";
            instance.menuActionID[1] = 5000;
            instance.menuActionID[2] = 5001;
            instance.menuActionRow = 3;
        }
    }

    public void dismiss() {
        instance.isDisplayed = false;
    }

    public void process() {
    	
        instance.drawingArea.method385(0xffff00, Client.capitalizeFirstChar(text), 340, 15);

    }
}