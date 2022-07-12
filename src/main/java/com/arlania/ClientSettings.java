package com.arlania;

public class ClientSettings {
    public static int movingTextures = 0;
    public static int showPerkOverlays = 0;
    public static int rankHeadIcons = 1;
    public static int showFog = 1;
    public static int showParticles = 1;
    public static int showPrayerOverheads = 1;
    public static int groundItemNames = 1;
    public static int smoothShading = 1;
    public static int showProgressionOverlay = 1;
    public static int showGroundDecorations = 1;

    public static int viewDistance = 25;
    public static int textureAnimationSpeed = 3;
    public static int fogStartValue = 2500;
    public static int fogColor = 0;

    public static void clamp() {
        if(movingTextures != 0 && movingTextures != 1) {
            movingTextures = 0;
        }

        if(showPerkOverlays != 0 && showPerkOverlays != 1) {
            showPerkOverlays = 0;
        }

        if(rankHeadIcons != 0 && rankHeadIcons != 1) {
            rankHeadIcons = 1;
        }

        if(showFog != 0 && showFog != 1) {
            showFog = 1;
        }

        if(showParticles != 0 && showParticles != 1) {
            showParticles = 1;
        }

        if(showPrayerOverheads != 0 && showPrayerOverheads != 1) {
            showPrayerOverheads = 1;
        }

        if(groundItemNames != 0 && groundItemNames != 1) {
            groundItemNames = 1;
        }

        if(smoothShading != 0 && smoothShading != 1) {
            smoothShading = 1;
        }

        if(showProgressionOverlay != 0 && showProgressionOverlay != 1) {
            showProgressionOverlay = 1;
        }

        if(showGroundDecorations != 0 && showGroundDecorations != 1) {
            showGroundDecorations = 1;
        }

        if (ClientSettings.viewDistance < 25) {
            ClientSettings.viewDistance = 25;
        }
        if (ClientSettings.viewDistance > 50) {
            ClientSettings.viewDistance = 50;
        }

        if(textureAnimationSpeed < 0 || textureAnimationSpeed > 7) {
            textureAnimationSpeed = 3;
        }

        if(fogStartValue < 1000 || fogStartValue > 4000) {
            fogStartValue = 2500;
        }

        Client.instance.updateGameArea();
    }
}
