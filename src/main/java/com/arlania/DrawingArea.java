package com.arlania;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.util.Arrays;
import java.util.Hashtable;

public class DrawingArea extends QueueNode {

    public static void initDrawingArea(int i, int j, int[] ai) {
        pixels = ai;
        width = j;
        height = i;
        setDrawingArea(i, 0, j, 0);
    }

    public static int HSBtoRGB(float hue, float saturation, float brightness) {
        int r = 0, g = 0, b = 0;
        if (saturation == 0) {
            r = g = b = (int) (brightness * 255.0f + 0.5f);
        } else {
            float h = (hue - (float) Math.floor(hue)) * 6.0f;
            float f = h - (float) java.lang.Math.floor(h);
            float p = brightness * (1.0f - saturation);
            float q = brightness * (1.0f - saturation * f);
            float t = brightness * (1.0f - (saturation * (1.0f - f)));
            switch ((int) h) {
                case 0:
                    r = (int) (brightness * 255.0f + 0.5f);
                    g = (int) (t * 255.0f + 0.5f);
                    b = (int) (p * 255.0f + 0.5f);
                    break;
                case 1:
                    r = (int) (q * 255.0f + 0.5f);
                    g = (int) (brightness * 255.0f + 0.5f);
                    b = (int) (p * 255.0f + 0.5f);
                    break;
                case 2:
                    r = (int) (p * 255.0f + 0.5f);
                    g = (int) (brightness * 255.0f + 0.5f);
                    b = (int) (t * 255.0f + 0.5f);
                    break;
                case 3:
                    r = (int) (p * 255.0f + 0.5f);
                    g = (int) (q * 255.0f + 0.5f);
                    b = (int) (brightness * 255.0f + 0.5f);
                    break;
                case 4:
                    r = (int) (t * 255.0f + 0.5f);
                    g = (int) (p * 255.0f + 0.5f);
                    b = (int) (brightness * 255.0f + 0.5f);
                    break;
                case 5:
                    r = (int) (brightness * 255.0f + 0.5f);
                    g = (int) (p * 255.0f + 0.5f);
                    b = (int) (q * 255.0f + 0.5f);
                    break;
            }
        }
        return (r << 16) + (g << 8) + (b);
    }

    public static void drawCircle(double x, double y, double width, double height, int color, int alpha, boolean fill) {


        if (x < clipLeft) {
            width -= clipLeft - x;
            x = clipLeft;
        }
        if (y < clipTop) {
            height -= clipTop - y;
            y = clipTop;
        }
        if (x + width > clipRight)
            width = clipRight - x;
        if (y + height > clipBottom)
            height = clipBottom - y;

        Graphics2D graphics = DrawingArea.createGraphics(DrawingArea.pixels, DrawingArea.width, DrawingArea.height);
        final Color CONVERTED_COLOR = new Color((color >> 16 & 0xff), (color >> 8 & 0xff), (color & 0xff), alpha);
        graphics.setColor(CONVERTED_COLOR);
        RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        graphics.setRenderingHints(render);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        Ellipse2D.Double ellipse = new Ellipse2D.Double(x, y, width, height);
        if (fill) {
            graphics.fill(ellipse);
        }
        graphics.draw(ellipse);
    }

    public static void drawColorPicker(int x, int y, int w, int h, int hueWidth, float hue) {

        if (x < clipLeft) {
            w -= clipLeft - x;
            x = clipLeft;
        }
        if (y < clipTop) {
            h -= clipTop - y;
            y = clipTop;
        }
        if (x + w > clipRight)
            w = clipRight - x;
        if (y + h > clipBottom)
            h = clipBottom - y;

        createSB(x, y, w, h, hue);
        createHueRGB(x + w, y, hueWidth, h);
        drawStroke(x, y, w + hueWidth, h, 0, 1);
    }

    private static void createHueRGB(int x, int y, int hueWidth, int hueHeight) {
        for (int pX = x; pX < x + hueWidth; pX++) {
            for (int pY = y; pY < y + hueHeight; pY++) {
                float hue = MathUtils.map(pY, y, y + hueHeight, 1f, 0f);
                pixels[pX + pY * DrawingArea.width] = Color.HSBtoRGB(hue, 1f, 1f);
            }
        }
    }

    private static void createSB(int x, int y, int pickerWidth, int pickerHeight, float hue) {
        for (int pX = x; pX < x + pickerWidth; pX++) {
            for (int pY = y; pY < y + pickerHeight; pY++) {
                float saturation = MathUtils.map(pX, x, x + pickerWidth, 0f, 1f);
                float brightness = MathUtils.map(pY, y, y + pickerHeight, 1f, 0f);
                pixels[pX + pY * DrawingArea.width] = Color.HSBtoRGB(hue, saturation, brightness);

            }
        }
    }

    public static void drawStroke(int xPos, int yPos, int width, int height, int color, int strokeWidth) {

        drawVerticalStrokeLine(xPos, yPos, height, color, strokeWidth);
        drawVerticalStrokeLine((xPos + width) - strokeWidth, yPos, height, color, strokeWidth);
        drawHorizontalStrokeLine(xPos, yPos, width, color, strokeWidth);
        drawHorizontalStrokeLine(xPos, (yPos + height) - strokeWidth, width, color, strokeWidth);
    }

    private static void drawVerticalStrokeLine(int xPosition, int yPosition, int height, int hexColor,
        int strokeWidth) {
        if (xPosition < clipLeft || xPosition >= clipRight)
            return;
        if (yPosition < clipTop) {
            height -= clipTop - yPosition;
            yPosition = clipTop;
        }
        if (yPosition + height > clipBottom)
            height = clipBottom - yPosition;
        int pixelIndex = xPosition + yPosition * width;
        for (int rowIndex = 0; rowIndex < height; rowIndex++) {
            for (int x = 0; x < strokeWidth; x++) {
                pixels[pixelIndex + x + rowIndex * width] = hexColor;
            }
        }
    }

    private static void drawHorizontalStrokeLine(int xPos, int yPos, int w, int hexColor, int strokeWidth) {
        if (yPos < clipTop || yPos >= clipBottom)
            return;
        if (xPos < clipLeft) {
            w -= clipLeft - xPos;
            xPos = clipLeft;
        }
        if (xPos + w > clipRight)
            w = clipRight - xPos;
        int index = xPos + yPos * width;
        int leftWidth = width - w;
        for (int x = 0; x < strokeWidth; x++) {
            for (int y = 0; y < w; y++) {
                pixels[index++] = hexColor;
            }
            index += leftWidth;
        }

    }

    private static final ColorModel COLOR_MODEL = new DirectColorModel(32, 0xff0000, 0xff00, 0xff);

    public static Graphics2D createGraphics(int[] pixels, int width, int height) {
    	return new BufferedImage(COLOR_MODEL, Raster.createWritableRaster(COLOR_MODEL.createCompatibleSampleModel(width, height), new DataBufferInt(pixels, width * height), null), false,
    	new Hashtable<Object, Object>()).createGraphics();
    	}

    	public static Graphics2D createGraphics(boolean renderingHints) {
    	    Graphics2D g2d = createGraphics(pixels, width, height);
    	    if (renderingHints) {
    	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	    }
    	    return g2d;
    	}

    	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font)
    	{
    	    FontMetrics metrics = g.getFontMetrics(font);
    	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
    	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
    	    g.setFont(font);
    	    g.drawString(text, x, y);
    	}

    public static void drawArc(double x, double y, double width, double height, int stroke, double start, double sweep, int color, int alpha, int closure, boolean fill) {
        Graphics2D graphics = DrawingArea.createGraphics(DrawingArea.pixels, DrawingArea.width, DrawingArea.height);
        final Color CONVERTED_COLOR = new Color((color >> 16 & 0xff), (color >> 8 & 0xff), (color & 0xff), alpha);
        graphics.setColor(CONVERTED_COLOR);
        RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        graphics.setRenderingHints(render);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        graphics.setStroke(new BasicStroke(Math.max(stroke, 1)));

        // Closure types - OPEN(0), CHORD(1), PIE(2)
        Arc2D.Double arc = new Arc2D.Double(x + stroke, y + stroke, width, height, start, sweep, closure);

        if (fill) {
            graphics.fill(arc);
            graphics.setColor(Color.decode("0x3f372c").darker());
        }
        graphics.draw(arc);
    }

    public static void drawTransparentBox(int leftX, int topY, int width, int height, int rgbColour, int opacity) {
        if (leftX < DrawingArea.clipLeft) { // if leftX is less than topX
            width -= DrawingArea.clipLeft - leftX; // substract (topX - leftX) from width
            leftX = DrawingArea.clipLeft; // set leftX equal to topX
        }
        if (topY < DrawingArea.clipTop) { // same thing as above but with Y/height
            height -= DrawingArea.clipTop - topY;
            topY = DrawingArea.clipTop;
        }
        if (leftX + width > clipRight) // if sum of leftX/Width is greater than bottomX
            width = clipRight - leftX; // set width equal to the sum of bottomX - leftX
        if (topY + height > clipBottom) // same as above just with Y/height
            height = clipBottom - topY;
        int transparency = 256 - opacity; // set transparency equal to 256 - opacity
        int red = (rgbColour >> 16 & 0xff) * opacity; // set red equal to rgbColour shifted left by 16 bits & 0xff aka 255 since thats the rgb limit, multiplied by opacity
        int green = (rgbColour >> 8 & 0xff) * opacity; // same as with red, but shift 8 bits instead of 16
        int blue = (rgbColour & 0xff) * opacity; // same as green/red, but just & 0xff aka 255
        int leftOver = DrawingArea.width - width; // set leftOver equal to the drawing area's width substracted by the width in params
        int pixelIndex = leftX + topY * DrawingArea.width; // set pixel index equal to the sum of (leftX * topY * DrawingArea.width)
        for (int rowIndex = 0; rowIndex < height; rowIndex++) { // loop thru all the y pixels (i guess)
            for (int columnIndex = 0; columnIndex < width; columnIndex++) { // loop thru all the x pixels (i guess)
                int otherRed = (pixels[pixelIndex] >> 16 & 0xff) * transparency; // set otherRed equal to pixels at pixelIndex shifted by 16 bits to the left & 0xff
                int otherGreen = (pixels[pixelIndex] >> 8 & 0xff) * transparency; // same as above just 8 bits shifted to the left
                int otherBlue = (pixels[pixelIndex] & 0xff) * transparency; // same as above but no bits shifted
                int transparentColour = ((red + otherRed >> 8) << 16) + ((green + otherGreen >> 8) << 8) // calculating the transparentColour
                    + (blue + otherBlue >> 8);
                pixels[pixelIndex++] = transparentColour; // set pixels[pixelIndex] incremented every iteration equal to transparentColour
            }
            pixelIndex += leftOver; // increment pixelIndex by leftOver
        }
    }

    public static void drawAlphaFilledPixels(int xPos, int yPos, int pixelWidth, int pixelHeight, int color,
        int alpha) {// method586
        if (xPos < clipLeft) {
            pixelWidth -= clipLeft - xPos;
            xPos = clipLeft;
        }
        if (yPos < clipTop) {
            pixelHeight -= clipTop - yPos;
            yPos = clipTop;
        }
        if (xPos + pixelWidth > clipRight)
            pixelWidth = clipRight - xPos;
        if (yPos + pixelHeight > clipBottom)
            pixelHeight = clipBottom - yPos;
        color = ((color & 0xff00ff) * alpha >> 8 & 0xff00ff) + ((color & 0xff00) * alpha >> 8 & 0xff00);
        int k1 = 256 - alpha;
        int l1 = width - pixelWidth;
        int i2 = xPos + yPos * width;
        for (int j2 = 0; j2 < pixelHeight; j2++) {
            for (int k2 = -pixelWidth; k2 < 0; k2++) {
                int l2 = pixels[i2];
                l2 = ((l2 & 0xff00ff) * k1 >> 8 & 0xff00ff) + ((l2 & 0xff00) * k1 >> 8 & 0xff00);
                pixels[i2++] = color + l2;
            }
            i2 += l1;
        }
    }

    public static void drawBoxOutline(int leftX, int topY, int width, int height, int rgbColour) {
        drawHorizontalLine(leftX, topY, width, rgbColour);
        drawHorizontalLine(leftX, (topY + height) - 1, width, rgbColour);
        drawVerticalLine(leftX, topY, height, rgbColour);
        drawVerticalLine((leftX + width) - 1, topY, height, rgbColour);
    }

    public static void drawVerticalLine(int xPosition, int yPosition, int height, int rgbColour) {
        if (xPosition < clipLeft || xPosition >= clipRight)
            return;
        if (yPosition < clipTop) {
            height -= clipTop - yPosition;
            yPosition = clipTop;
        }
        if (yPosition + height > clipBottom)
            height = clipBottom - yPosition;
        int pixelIndex = xPosition + yPosition * width;
        for (int rowIndex = 0; rowIndex < height; rowIndex++)
            pixels[pixelIndex + rowIndex * width] = rgbColour;
    }

    public static void method339(int i, int j, int k, int l) {
        if (i < clipTop || i >= clipBottom)
            return;
        if (l < clipLeft) {
            k -= clipLeft - l;
            l = clipLeft;
        }
        if (l + k > clipRight)
            k = clipRight - l;
        int i1 = l + i * width;
        for (int j1 = 0; j1 < k; j1++)
            pixels[i1 + j1] = j;

    }

    public static void drawPixelsWithOpacity(int color, int yPos, int pixelWidth, int pixelHeight, int opacityLevel,
        int xPos) {
        if (xPos < clipLeft) {
            pixelWidth -= clipLeft - xPos;
            xPos = clipLeft;
        }
        if (yPos < clipTop) {
            pixelHeight -= clipTop - yPos;
            yPos = clipTop;
        }
        if (xPos + pixelWidth > clipRight)
            pixelWidth = clipRight - xPos;
        if (yPos + pixelHeight > clipBottom)
            pixelHeight = clipBottom - yPos;
        int l1 = 256 - opacityLevel;
        int i2 = (color >> 16 & 0xff) * opacityLevel;
        int j2 = (color >> 8 & 0xff) * opacityLevel;
        int k2 = (color & 0xff) * opacityLevel;
        int k3 = width - pixelWidth;
        int l3 = xPos + yPos * width;
        if (l3 > pixels.length - 1) {
            l3 = pixels.length - 1;
        }
        for (int i4 = 0; i4 < pixelHeight; i4++) {
            for (int j4 = -pixelWidth; j4 < 0; j4++) {
                int l2 = (pixels[l3] >> 16 & 0xff) * l1;
                int i3 = (pixels[l3] >> 8 & 0xff) * l1;
                int j3 = (pixels[l3] & 0xff) * l1;
                int k4 = ((i2 + l2 >> 8) << 16) + ((j2 + i3 >> 8) << 8) + (k2 + j3 >> 8);
                pixels[l3++] = k4;
            }
            l3 += k3;
        }
    }

    public static void defaultDrawingAreaSize() {
        clipLeft = 0;
        clipTop = 0;
        clipRight = width;
        clipBottom = height;
        viewportRX = clipRight;
        viewport_centerX = clipRight / 1;
    }

    public static void setDrawingArea(int yBottom, int xTop, int xBottom, int yTop) {
        if (xTop < 0)
            xTop = 0;
        if (yTop < 0)
            yTop = 0;
        if (xBottom > width)
            xBottom = width;
        if (yBottom > height)
            yBottom = height;
        clipLeft = xTop;
        clipTop = yTop;
        clipRight = xBottom;
        clipBottom = yBottom;
        viewportRX = clipRight;
        viewport_centerX = clipRight / 2;
        viewport_centerY = clipBottom / 2;
    }

    public static int clamp(int x, int a, int b) {
        return (x < a) ? a : (x > b) ? b : x;
    }

    public static void blur(int[] in, int[] out, int width, int height, int radius) {
        int widthMinus1 = width - 1;
        int tableSize = 2 * radius + 1;
        int divide[] = new int[256 * tableSize];

        for (int i = 0; i < 256 * tableSize; i++)
            divide[i] = i / tableSize;

        int inIndex = 0;

        for (int y = 0; y < height; y++) {
            int outIndex = y;
            int ta = 0, tr = 0, tg = 0, tb = 0;

            for (int i = -radius; i <= radius; i++) {
                int rgb = in[inIndex + clamp(i, 0, width - 1)];
                ta += (rgb >> 24) & 0xff;
                tr += (rgb >> 16) & 0xff;
                tg += (rgb >> 8) & 0xff;
                tb += rgb & 0xff;
            }

            for (int x = 0; x < width; x++) {
                out[outIndex] = (divide[ta] << 24) | (divide[tr] << 16) | (divide[tg] << 8) | divide[tb];

                int i1 = x + radius + 1;
                if (i1 > widthMinus1)
                    i1 = widthMinus1;
                int i2 = x - radius;
                if (i2 < 0)
                    i2 = 0;
                int rgb1 = in[inIndex + i1];
                int rgb2 = in[inIndex + i2];

                ta += ((rgb1 >> 24) & 0xff) - ((rgb2 >> 24) & 0xff);
                tr += ((rgb1 & 0xff0000) - (rgb2 & 0xff0000)) >> 16;
                tg += ((rgb1 & 0xff00) - (rgb2 & 0xff00)) >> 8;
                tb += (rgb1 & 0xff) - (rgb2 & 0xff);
                outIndex += height;
            }
            inIndex += width;
        }
    }

    public static void drawDiagonalLine(int x, int y, int areaWidth, int areaHeight, int color) {// method577
        areaWidth -= x;
        areaHeight -= y;
        if (areaHeight == 0)
            if (areaWidth >= 0) {
                drawHorizontalLine(x, y, areaWidth + 1, color);
                return;
            } else {
                drawHorizontalLine(x + areaWidth, y, -areaWidth + 1, color);
                return;
            }
        if (areaWidth == 0)
            if (areaHeight >= 0) {
                drawVLine(x, y, areaHeight + 1, color);
                return;
            } else {
                drawHLine(x, y + areaHeight, -areaHeight + 1, color);
                return;
            }
        if (areaWidth + areaHeight < 0) {
            x += areaWidth;
            areaWidth = -areaWidth;
            y += areaHeight;
            areaHeight = -areaHeight;
        }
        if (areaWidth > areaHeight) {
            y <<= 16;
            y += 32768;
            areaHeight <<= 16;
            int j1 = (int) Math.floor((double) areaHeight / (double) areaWidth + 0.5D);
            areaWidth += x;
            if (x < clipLeft) {
                y += j1 * (clipLeft - x);
                x = clipLeft;
            }
            if (areaWidth >= clipRight)
                areaWidth = clipRight - 1;
            for (; x <= areaWidth; x++) {
                int l1 = y >> 16;
                if (l1 >= clipTop && l1 < clipBottom)
                    pixels[x + l1 * width] = color;
                y += j1;
            }
            return;
        }
        x <<= 16;
        x += 32768;
        areaWidth <<= 16;
        int k1 = (int) Math.floor((double) areaWidth / (double) areaHeight + 0.5D);
        areaHeight += y;
        if (y < clipTop) {
            x += k1 * (clipTop - y);
            y = clipTop;
        }
        if (areaHeight >= clipBottom)
            areaHeight = clipBottom - 1;
        for (; y <= areaHeight; y++) {
            int i2 = x >> 16;
            if (i2 >= clipLeft && i2 < clipRight)
                pixels[i2 + y * width] = color;
            x += k1;
        }
    }

    public static void drawGradient(int x, int y, int gradientWidth, int gradientHeight, int startColor, int endColor) {
        int k1 = 0;
        int l1 = 0x10000 / gradientHeight;
        if (x < clipLeft) {
            gradientWidth -= clipLeft - x;
            x = clipLeft;
        }
        if (y < clipTop) {
            k1 += (clipTop - y) * l1;
            gradientHeight -= clipTop - y;
            y = clipTop;
        }
        if (x + gradientWidth > clipRight)
            gradientWidth = clipRight - x;
        if (y + gradientHeight > clipBottom)
            gradientHeight = clipBottom - y;
        int i2 = width - gradientWidth;
        int j2 = x + y * width;
        for (int k2 = -gradientHeight; k2 < 0; k2++) {
            int l2 = 0x10000 - k1 >> 8;
            int i3 = k1 >> 8;
            int j3 = ((startColor & 0xff00ff) * l2 + (endColor & 0xff00ff) * i3 & 0xff00ff00)
                + ((startColor & 0xff00) * l2 + (endColor & 0xff00) * i3 & 0xff0000) >>> 8;
            for (int k3 = -gradientWidth; k3 < 0; k3++)
                pixels[j2++] = j3;
            j2 += i2;
            k1 += l1;
        }
    }

    public static void drawAlphaGradient2(int x, int y, int gradientWidth, int gradientHeight, int startColor,
        int endColor, int alpha) {
        int k1 = 0;
        int l1 = 0x10000 / gradientHeight;
        if (x < clipLeft) {
            gradientWidth -= clipLeft - x;
            x = clipLeft;
        }
        if (y < clipTop) {
            k1 -= (clipTop - y) * l1;
            gradientHeight -= clipTop - y;
            y = clipTop;
        }
        if (x + gradientWidth > clipRight)
            gradientWidth = clipRight - x;
        if (y + gradientHeight > clipBottom)
            gradientHeight = clipBottom - y;
        int i2 = width - gradientWidth;
        int total_pixels = x + y * width;
        for (int k2 = -gradientHeight; k2 < 0; k2++) {
            int alpha2 = (gradientHeight + k2) * (gradientHeight / alpha);
            int result_alpha = 256 - alpha2;
            int gradient1 = 0x10000 - k1 >> 8;
            int gradient2 = k1 >> 8;
            int gradient_color = ((startColor & 0xff00ff) * gradient1 + (endColor & 0xff00ff) * gradient2 & 0xff00ff00)
                + ((startColor & 0xff00) * gradient1 + (endColor & 0xff00) * gradient2 & 0xff0000) >>> 8;
            int color = ((gradient_color & 0xff00ff) * alpha >> 8 & 0xff00ff)
                + ((gradient_color & 0xff00) * alpha >> 8 & 0xff00);
            for (int k3 = -gradientWidth; k3 < 0; k3++) {
                int colored_pixel = pixels[total_pixels];
                colored_pixel = ((colored_pixel & 0xff00ff) * result_alpha >> 8 & 0xff00ff)
                    + ((colored_pixel & 0xff00) * result_alpha >> 8 & 0xff00);
                pixels[total_pixels++] = color + colored_pixel;
            }
            total_pixels += i2;
            k1 -= l1;
        }
    }

    public static void method336(int i, int j, int k, int l, int i1) {
        if (k < clipLeft) {
            i1 -= clipLeft - k;
            k = clipLeft;
        }
        if (j < clipTop) {
            i -= clipTop - j;
            j = clipTop;
        }
        if (k + i1 > clipRight)
            i1 = clipRight - k;
        if (j + i > clipBottom)
            i = clipBottom - j;
        int k1 = width - i1;
        int l1 = k + j * width;
        for (int i2 = -i; i2 < 0; i2++) {
            for (int j2 = -i1; j2 < 0; j2++)
                pixels[l1++] = l;

            l1 += k1;
        }

    }

    public void drawAlphaGradient(int x, int y, int gradientWidth, int gradientHeight, int startColor, int endColor,
        int alpha) {
        int k1 = 0;
        int l1 = 0x10000 / gradientHeight;
        if (x < clipLeft) {
            gradientWidth -= clipLeft - x;
            x = clipLeft;
        }
        if (y < clipTop) {
            k1 += (clipTop - y) * l1;
            gradientHeight -= clipTop - y;
            y = clipTop;
        }
        if (x + gradientWidth > clipRight)
            gradientWidth = clipRight - x;
        if (y + gradientHeight > clipBottom)
            gradientHeight = clipBottom - y;
        int i2 = width - gradientWidth;
        int result_alpha = 256 - alpha;
        int total_pixels = x + y * width;
        for (int k2 = -gradientHeight; k2 < 0; k2++) {
            int gradient1 = 0x10000 - k1 >> 8;
            int gradient2 = k1 >> 8;
            int gradient_color = ((startColor & 0xff00ff) * gradient1 + (endColor & 0xff00ff) * gradient2 & 0xff00ff00)
                + ((startColor & 0xff00) * gradient1 + (endColor & 0xff00) * gradient2 & 0xff0000) >>> 8;
            int color = ((gradient_color & 0xff00ff) * alpha >> 8 & 0xff00ff)
                + ((gradient_color & 0xff00) * alpha >> 8 & 0xff00);
            for (int k3 = -gradientWidth; k3 < 0; k3++) {
                int colored_pixel = pixels[total_pixels];
                colored_pixel = ((colored_pixel & 0xff00ff) * result_alpha >> 8 & 0xff00ff)
                    + ((colored_pixel & 0xff00) * result_alpha >> 8 & 0xff00);
                pixels[total_pixels++] = color + colored_pixel;
            }
            total_pixels += i2;
            k1 += l1;
        }
    }

    public static void drawAlphaHorizontalLine2(int x, int y, int lineWidth, int color, int alpha) {// drawAlphaHorizontalLine
        if (y < clipTop || y >= clipBottom)
            return;
        if (x < clipLeft) {
            lineWidth -= clipLeft - x;
            x = clipLeft;
        }
        if (x + lineWidth > clipRight)
            lineWidth = clipRight - x;
        int i3 = x + y * width;
        for (int j3 = 0; j3 < lineWidth; j3++) {
            int alpha2 = (lineWidth - j3) / (lineWidth / alpha);
            int j1 = 256 - alpha2;
            int k1 = (color >> 16 & 0xff) * alpha2;
            int l1 = (color >> 8 & 0xff) * alpha2;
            int i2 = (color & 0xff) * alpha2;
            int j2 = (pixels[i3] >> 16 & 0xff) * j1;
            int k2 = (pixels[i3] >> 8 & 0xff) * j1;
            int l2 = (pixels[i3] & 0xff) * j1;
            int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
            pixels[i3++] = k3;
        }
    }

    public static void resetDepthBuffer() {
        int i = width * height;
        if (depthBuffer.length != i) {
            depthBuffer = new float[i];
        }

        Arrays.fill(depthBuffer, i);
    }

    public static void resetImage() {
        Arrays.fill(pixels, 0);

    }

    public static void drawVLine(int x, int y, int height, int colour) {
        if (x < clipLeft || x >= clipBottom)
            return;
        if (y < clipTop) {
            height -= clipTop - y;
            y = clipTop;
        }
        if (y + height > clipRight)
            height = clipRight - y;
        int ptr = x + y * width;
        for (int y_off = 0; y_off < height; y_off++)
            pixels[ptr + y_off * width] = colour;

    }

    public static void blur(int x, int y, int width, int height, int speed) {
        try {
            blur(pixels, pixels, width, height, speed);
            blur(pixels, pixels, height, width, speed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void drawHLine(int x, int y, int width, int colour) {
        if (y < clipTop || y >= clipBottom)
            return;
        if (x < clipLeft) {
            width -= clipLeft - x;
            x = clipLeft;
        }
        if (x + width > clipRight)
            width = clipRight - x;
        int i1 = x + y * DrawingArea.width;
        for (int x_off = 0; x_off < width; x_off++)
            pixels[i1 + x_off] = colour;

    }


    public static void fillRectangle(int color, int y, int widthz, int heightz, int opacity, int x) {
        if (x < clipLeft) {
            widthz -= clipLeft - x;
            x = clipLeft;
        }
        if (y < clipTop) {
            heightz -= clipTop - y;
            y = clipTop;
        }
        if (x + widthz > clipRight)
            widthz = clipRight - x;
        if (y + heightz > clipBottom)
            heightz = clipBottom - y;
        int decodedOpacity = 256 - opacity;
        int red = (color >> 16 & 0xff) * opacity;
        int green = (color >> 8 & 0xff) * opacity;
        int blue = (color & 0xff) * opacity;
        int pixelWidthStep = width - widthz;
        int startPixel = x + y * width;
        for (int h = 0; h < heightz; h++) {
            for (int w = -widthz; w < 0; w++) {
                int pixelRed = (pixels[startPixel] >> 16 & 0xff) * decodedOpacity;
                int pixelBlue = (pixels[startPixel] >> 8 & 0xff) * decodedOpacity;
                int pixelGreen = (pixels[startPixel] & 0xff) * decodedOpacity;
                int pixelRGB = ((red + pixelRed >> 8) << 16) + ((green + pixelBlue >> 8) << 8)
                    + (blue + pixelGreen >> 8);
                pixels[startPixel++] = pixelRGB;
            }

            startPixel += pixelWidthStep;
        }
    }

    public static void drawPixels(int height_, int yPos, int xPos, int color, int width_, int alpha) {

        if (xPos < clipLeft) {
            width_ -= clipLeft - xPos;
            xPos = clipLeft;
        }
        if (yPos < clipTop) {
            height_ -= clipTop - yPos;
            yPos = clipTop;
        }
        if (xPos + width_ > clipRight)
            width_ = clipRight - xPos;
        if (yPos + height_ > clipBottom)
            height_ = clipBottom - yPos;
        int decodedOpacity = 256 - alpha;
        int widthPixelStep = width - width_;
        int startPixel = xPos + yPos * width;
        int red = (color >> 16 & 0xff) * alpha;
        int green = (color >> 8 & 0xff) * alpha;
        int blue = (color & 0xff) * alpha;
        for (int i2 = -height_; i2 < 0; i2++) {
            for (int j2 = -width_; j2 < 0; j2++) {
                int pixelRed = (pixels[startPixel] >> 16 & 0xff) * decodedOpacity;
                int pixelBlue = (pixels[startPixel] >> 8 & 0xff) * decodedOpacity;
                int pixelGreen = (pixels[startPixel] & 0xff) * decodedOpacity;
                int pixelRGB = ((red + pixelRed >> 8) << 16) + ((green + pixelBlue >> 8) << 8)
                    + (blue + pixelGreen >> 8);
                pixels[startPixel++] = pixelRGB;
            }

            startPixel += widthPixelStep;
        }

    }

    public static void drawPixels(int height_, int yPos, int xPos, int color, int width_) {
        if (xPos < clipLeft) {
            width_ -= clipLeft - xPos;
            xPos = clipLeft;
        }
        if (yPos < clipTop) {
            height_ -= clipTop - yPos;
            yPos = clipTop;
        }
        if (xPos + width_ > clipRight)
            width_ = clipRight - xPos;
        if (yPos + height_ > clipBottom)
            height_ = clipBottom - yPos;
        int k1 = width - width_;
        int l1 = xPos + yPos * width;
        for (int i2 = -height_; i2 < 0; i2++) {
            for (int j2 = -width_; j2 < 0; j2++) {
                int s = l1++;
                if (s < pixels.length)
                    pixels[s] = color;
            }

            l1 += k1;
        }

    }

    public static void fillPixels(int i, int j, int k, int l, int i1) {
        drawLine(i1, l, j, i);
        drawLine((i1 + k) - 1, l, j, i);
        drawLineVertical(i1, l, k, i);
        drawLineVertical(i1, l, k, (i + j) - 1);
    }

    public static void drawRectangle(int y, int height, int opacity, int color, int width, int x) {
        drawHLine(color, width, y, opacity, x);
        drawHLine(color, width, (y + height) - 1, opacity, x);
        if (height >= 3) {
            drawVLine(color, x, opacity, y + 1, height - 2);
            drawVLine(color, (x + width) - 1, opacity, y + 1, height - 2);
        }
    }

    public static void drawRectangle(int x, int y, int width, int height, int color) {
        drawHorizontalLine(x, y, width, color);
        drawHorizontalLine(x, (y + height) - 1, width, color);
        drawVerticalLine(x, y, height, color);
        drawVerticalLine((x + width) - 1, y, height, color);
    }

    public static void drawLine(int yPos, int color, int widthToDraw, int xPos) {
        if (yPos < clipTop || yPos >= clipBottom)
            return;
        if (xPos < clipLeft) {
            widthToDraw -= clipLeft - xPos;
            xPos = clipLeft;
        }
        if (xPos + widthToDraw > clipRight)
            widthToDraw = clipRight - xPos;
        int base = xPos + yPos * width;
        for (int ptr = 0; ptr < widthToDraw; ptr++)
            pixels[base + ptr] = color;

    }

    public static void drawHorizontalLine(int i, int j, int k, int l) {
        if (i < clipTop || i >= clipBottom)
            return;
        if (l < clipLeft) {
            k -= clipLeft - l;
            l = clipLeft;
        }
        if (l + k > clipRight)
            k = clipRight - l;
        int i1 = l + i * width;
        for (int j1 = 0; j1 < k; j1++)
            pixels[i1 + j1] = j;

    }

    protected static void drawHLine(int i, int j, int k, int l, int i1) {
        if (k < clipTop || k >= clipBottom)
            return;
        if (i1 < clipLeft) {
            j -= clipLeft - i1;
            i1 = clipLeft;
        }
        if (i1 + j > clipRight)
            j = clipRight - i1;
        int j1 = 256 - l;
        int k1 = (i >> 16 & 0xff) * l;
        int l1 = (i >> 8 & 0xff) * l;
        int i2 = (i & 0xff) * l;
        int i3 = i1 + k * width;
        for (int j3 = 0; j3 < j; j3++) {
            int j2 = (pixels[i3] >> 16 & 0xff) * j1;
            int k2 = (pixels[i3] >> 8 & 0xff) * j1;
            int l2 = (pixels[i3] & 0xff) * j1;
            int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
            pixels[i3++] = k3;
        }

    }

    public static void drawLineVertical(int heights, int color, int yPos, int xPos) {
        if (xPos < clipLeft || xPos >= clipRight)
            return;
        if (heights < clipTop) {
            yPos -= clipTop - heights;
            heights = clipTop;
        }
        if (heights + yPos > clipBottom)
            yPos = clipBottom - heights;
        int j1 = xPos + heights * width;
        for (int k1 = 0; k1 < yPos; k1++) {
            if (j1 + k1 * width < pixels.length)
                pixels[j1 + k1 * width] = color;
        }

    }

    protected static void drawVLine(int i, int j, int k, int l, int i1) {
        if (j < clipLeft || j >= clipRight)
            return;
        if (l < clipTop) {
            i1 -= clipTop - l;
            l = clipTop;
        }
        if (l + i1 > clipBottom)
            i1 = clipBottom - l;
        int j1 = 256 - k;
        int k1 = (i >> 16 & 0xff) * k;
        int l1 = (i >> 8 & 0xff) * k;
        int i2 = (i & 0xff) * k;
        int i3 = j + l * width;
        for (int j3 = 0; j3 < i1; j3++) {
            int j2 = (pixels[i3] >> 16 & 0xff) * j1;
            int k2 = (pixels[i3] >> 8 & 0xff) * j1;
            int l2 = (pixels[i3] & 0xff) * j1;
            int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
            pixels[i3] = k3;
            i3 += width;
        }
    }

    public static void fillCircle(int posX, int posY, int radius, int colour, int alpha) {
        int dest_intensity = 256 - alpha;
        int src_red = (colour >> 16 & 0xff) * alpha;
        int src_green = (colour >> 8 & 0xff) * alpha;
        int src_blue = (colour & 0xff) * alpha;
        int radiusPixels = posY - radius;
        if (radiusPixels < 0)
            radiusPixels = 0;
        int max = posY + radius;
        if (max >= height)
            max = height - 1;
        for (int y = radiusPixels; y <= max; y++) {
            int beginYPos = y - posY;
            int heighestXPos = (int) Math.sqrt(radius * radius - beginYPos * beginYPos);
            int x = posX - heighestXPos;
            if (x < 0)
                x = 0;
            int maxPixelX = posX + heighestXPos;
            if (maxPixelX >= width)
                maxPixelX = width - 1;
            int pixel_offset = x + y * width;
            for (int pixelX = x; pixelX <= maxPixelX; pixelX++) {
                int dest_red = (pixels[pixel_offset] >> 16 & 0xff) * dest_intensity;
                int dest_green = (pixels[pixel_offset] >> 8 & 0xff) * dest_intensity;
                int dest_blue = (pixels[pixel_offset] & 0xff) * dest_intensity;
                int result_rgb = ((src_red + dest_red >> 8) << 16) + ((src_green + dest_green >> 8) << 8)
                    + (src_blue + dest_blue >> 8);
                pixels[pixel_offset++] = result_rgb;
            }

        }

    }

    public DrawingArea() {

    }

    public static float[] depthBuffer = new float[1];
    public static int pixels[];
    public static int width;
    public static int height;
    public static int clipTop;
    public static int clipBottom;
    public static int clipLeft;
    public static int clipRight;
    public static int viewportRX;
    public static int viewport_centerX;
    public static int viewport_centerY;
}
