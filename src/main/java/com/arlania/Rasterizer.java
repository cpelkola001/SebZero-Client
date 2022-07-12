package com.arlania;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.imageio.ImageIO;

public final class Rasterizer extends DrawingArea {

	public static int textureAmount = 92; //Increment +1 whenever adding a new texture to /tex in cache
	static boolean aBoolean1462;
	private static boolean aBoolean1463;
	public static boolean aBoolean1464 = true;
	public static int anInt1465;
	public static int textureInt1;
	public static int textureInt2;
	private static int[] anIntArray1468;
	public static final int[] anIntArray1469;
	public static int anIntArray1470[];
	public static int anIntArray1471[];
	public static int anIntArray1472[];
	private static int anInt1473;
	public static Background aBackgroundArray1474s[] = new Background[textureAmount];
	private static boolean[] aBooleanArray1475 = new boolean[textureAmount];
	private static int[] anIntArray1476 = new int[textureAmount];
	private static int anInt1477;
	private static int[][] anIntArrayArray1478;
	private static int[][] anIntArrayArray1479 = new int[textureAmount][];
	public static int anIntArray1480[] = new int[textureAmount];
	public static int anInt1481;
	public static int anIntArray1482[] = new int[0x10000];
	private static int[][] anIntArrayArray1483 = new int[textureAmount][];

	static {
		anIntArray1468 = new int[512];
		anIntArray1469 = new int[2048];
		anIntArray1470 = new int[2048];
		anIntArray1471 = new int[2048];
		for (int i = 1; i < 512; i++) {
			anIntArray1468[i] = 32768 / i;
		}
		for (int j = 1; j < 2048; j++) {
			anIntArray1469[j] = 0x10000 / j;
		}
		for (int k = 0; k < 2048; k++) {
			anIntArray1470[k] = (int)(65536D * Math.sin((double) k * 0.0030679614999999999D));
			anIntArray1471[k] = (int)(65536D * Math.cos((double) k * 0.0030679614999999999D));
		}
	}

	public static void clearCache() {
		anIntArray1468 = null;
		anIntArray1470 = null;
		anIntArray1471 = null;
		anIntArray1472 = null;
		aBackgroundArray1474s = null;
		aBooleanArray1475 = null;
		anIntArray1476 = null;
		anIntArrayArray1478 = null;
		anIntArrayArray1479 = null;
		anIntArray1480 = null;
		anIntArray1482 = null;
		anIntArrayArray1483 = null;
	}

	public static void setDefaultBounds() {
		anIntArray1472 = new int[DrawingArea.height];
		for (int j = 0; j < DrawingArea.height; j++) {
			anIntArray1472[j] = DrawingArea.width * j;
		}
		textureInt1 = DrawingArea.width / 2;
		textureInt2 = DrawingArea.height / 2;
	}

	public static void setBounds(int width, int height) {
		anIntArray1472 = new int[height];
		for (int l = 0; l < height; l++) {
			anIntArray1472[l] = width * l;
		}
		textureInt1 = width / 2;
		textureInt2 = height / 2;
	}

	public static void drawFog(int rgb, int begin, int end) {
		float length = end - begin;
		for (int index = 0; index < pixels.length; index++) {
			float factor = (depthBuffer[index] - begin) / length;
			pixels[index] = blend(pixels[index], rgb, factor);
		}
	}

	private static int blend(int c1, int c2, float factor) {
		if (factor >= 1f) {
			return c2;
		}
		if (factor <= 0f) {
			return c1;
		}

		int r1 = (c1 >> 16) & 0xff;
		int g1 = (c1 >> 8) & 0xff;
		int b1 = (c1) & 0xff;

		int r2 = (c2 >> 16) & 0xff;
		int g2 = (c2 >> 8) & 0xff;
		int b2 = (c2) & 0xff;

		int r3 = r2 - r1;
		int g3 = g2 - g1;
		int b3 = b2 - b1;

		int r = (int) (r1 + (r3 * factor));
		int g = (int) (g1 + (g3 * factor));
		int b = (int) (b1 + (b3 * factor));

		return (r << 16) + (g << 8) + b;
	}

	private static int texelPos(int defaultIndex, int mipmaps) {
		int x = (defaultIndex & 127) >> mipmaps;
		int y = (defaultIndex >> 7) >> mipmaps;
		return x + (y << (7 - mipmaps));
	}

	public static void method366() {
		anIntArrayArray1478 = null;
		for (int j = 0; j < textureAmount; j++) {
			anIntArrayArray1479[j] = null;
		}
	}

	public static void method367(int size) {
		if (anIntArrayArray1478 == null) {
			anInt1477 = size;
			anIntArrayArray1478 = new int[anInt1477][0x10000];
			for (int k = 0; k < textureAmount; k++) {
				anIntArrayArray1479[k] = null;
			}
		}
	}

	public static void method368(CacheArchive streamLoader) {
		anInt1473 = 0;
		for (int index = 0; index < textureAmount; index++) {
			try {
				aBackgroundArray1474s[index] = new Background(streamLoader, String.valueOf(index), 0);
				aBackgroundArray1474s[index].setOffset();
				anInt1473++;
			} catch (Exception ex) {}
		}
		unpackTextures();
	}
	
	public static void unpackTextures() {
		for(int j = 80; j < textureAmount; ++j) {
			try {
				File file = new File(signlink.findcachedir() + "tex/"+j+".png");
				aBackgroundArray1474s[j] = getIndexedImage(j,file);
			} catch (Exception var3) {
				var3.printStackTrace();
			}
		}
	}
	
	public static Background getIndexedImage(int id, File file) throws IOException {
		BufferedImage image = ImageIO.read(file);
		List<Integer> paletteList = new LinkedList<>();
		paletteList.add(0);
		int width = image.getWidth();
		int height = image.getHeight();
		int[] pixels = new int[width * height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int rgb = image.getRGB(x, y);
				int red = rgb >> 16 & 0xff;
				int green = rgb >> 8 & 0xff;
				int blue = rgb & 0xff;
				int alpha = rgb & 0xff;
				rgb = red << 16 | green << 8 | blue;
				if (alpha == 255) {
					rgb = 0;
				}
				int index = paletteList.indexOf(rgb);
				if (index == -1) {

					if (paletteList.size() <= 16384) {
						index = paletteList.size();
						paletteList.add(rgb);
					} else {
						throw new IllegalArgumentException("The target image has more than 255 color in the palette "+id);
					}
				}
				pixels[x + y * width] = (byte) index;
			}
		}
		int[] palette = new int[paletteList.size()];

		final AtomicInteger index = new AtomicInteger(0);


		for (int pallet = 0; pallet < paletteList.size(); pallet++) {
			palette[index.getAndIncrement()] = paletteList.get(pallet);
		}
		return new Background(width, height, palette, pixels);
	}

	public static int method369(int texture) {
		if (anIntArray1476[texture] != 0) {
			return anIntArray1476[texture];
		}
		int r = 0;
		int g = 0;
		int b = 0;
		final int textureColorCount = anIntArrayArray1483[texture].length;
		for (int index = 0; index < textureColorCount; index++) {
			r += anIntArrayArray1483[texture][index] >> 16 & 0xff;
			g += anIntArrayArray1483[texture][index] >> 8 & 0xff;
			b += anIntArrayArray1483[texture][index] & 0xff;
		}
		int color = (r / textureColorCount << 16) + (g / textureColorCount << 8) + b / textureColorCount;
		color = method373(color, 1.3999999999999999D);
		if (color == 0) {
			color = 1;
		}
		anIntArray1476[texture] = color;
		return color;
	}

	public static void method370(int texture) {
		try {
			if (anIntArrayArray1479[texture] == null) {
				return;
			}
			anIntArrayArray1478[anInt1477++] = anIntArrayArray1479[texture];
			anIntArrayArray1479[texture] = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static int[] method371(int texture) { // get texels
		if (texture == 1) {
			texture = 24;
		}
			if(texture == 31) {
				texture = 40;
		}
			
			if (texture == 47) {
				texture = 61;
			//	System.out.println("Texture(Rasterizer) = 47");
			}
		
		anIntArray1480[texture] = anInt1481++;
		if(anIntArrayArray1479[texture] != null) {
			return anIntArrayArray1479[texture];
		}
		int texels[];
		if(anInt1477 > 0) {
			texels = anIntArrayArray1478[--anInt1477];
			anIntArrayArray1478[anInt1477] = null;
		} else {
			int j = 0;
			int k = -1;
			for(int l = 0; l < anInt1473; l++) {
				if(anIntArrayArray1479[l] != null && (anIntArray1480[l] < j || k == -1)) {
					j = anIntArray1480[l];
					k = l;
				}
			}
			texels = anIntArrayArray1479[k];
			anIntArrayArray1479[k] = null;
		}
		anIntArrayArray1479[texture] = texels;
		Background background = aBackgroundArray1474s[texture];
		int ai1[] = anIntArrayArray1483[texture];
		if(background.imgWidth == 64) {
			for(int j1 = 0; j1 < 128; j1++) {
				for(int j2 = 0; j2 < 128; j2++) {
					texels[j2 + (j1 << 7)] = ai1[background.imgPixels[(j2 >> 1) + ((j1 >> 1) << 6)]];
				}
			}
		} else {
			for(int k1 = 0; k1 < 16384; k1++) {
				texels[k1] = ai1[background.imgPixels[k1]];
			}
		}
		aBooleanArray1475[texture] = false;
		for(int l1 = 0; l1 < 16384; l1++) {
			texels[l1] &= 0xf8f8ff;
			//System.out.println(texels[l1] &= color);
			int k2 = texels[l1];
			if(k2 == 0) {
				aBooleanArray1475[texture] = true;
			}
			texels[16384 + l1] = k2 - (k2 >>> 3) & 0xf8f8ff;
			texels[32768 + l1] = k2 - (k2 >>> 2) & 0xf8f8ff;
			texels[49152 + l1] = k2 - (k2 >>> 2) - (k2 >>> 3) & 0xf8f8ff;
			//System.out.println("CALLED");
		}
		return texels;
	}

	public static void calculatePalette(double value) {
		Texture.setBrightness(value);
		int pos = 0;
		for (int index = 0; index < 512; index++) {
			final double d1 = index / 8 / 64D + 0.0078125D;
			final double d2 = (index & 7) / 8D + 0.0625D;
			for (int i = 0; i < 128; i++) {
				final double c = i / 128D;
				double r = c;
				double g = c;
				double b = c;
				if (d2 != 0.0D) {
					double d7;
					if (c < 0.5D) {
						d7 = c * (1.0D + d2);
					} else {
						d7 = c + d2 - c * d2;
					}
					final double d8 = 2D * c - d7;
					double d9 = d1 + 0.33333333333333331D;
					if (d9 > 1.0D) {
						d9--;
					}
					final double d10 = d1;
					double d11 = d1 - 0.33333333333333331D;
					if (d11 < 0.0D) {
						d11++;
					}
					if (6D * d9 < 1.0D) {
						r = d8 + (d7 - d8) * 6D * d9;
					} else if (2D * d9 < 1.0D) {
						r = d7;
					} else if (3D * d9 < 2D) {
						r = d8 + (d7 - d8) * (0.66666666666666663D - d9) * 6D;
					} else {
						r = d8;
					}
					if (6D * d10 < 1.0D) {
						g = d8 + (d7 - d8) * 6D * d10;
					} else if (2D * d10 < 1.0D) {
						g = d7;
					} else if (3D * d10 < 2D) {
						g = d8 + (d7 - d8) * (0.66666666666666663D - d10) * 6D;
					} else {
						g = d8;
					}
					if (6D * d11 < 1.0D) {
						b = d8 + (d7 - d8) * 6D * d11;
					} else if (2D * d11 < 1.0D) {
						b = d7;
					} else if (3D * d11 < 2D) {
						b = d8 + (d7 - d8) * (0.66666666666666663D - d11) * 6D;
					} else {
						b = d8;
					}
				}
				final int red = (int)(r * 256D);
				final int green = (int)(g * 256D);
				final int blue = (int)(b * 256D);
				int color = (red << 16) + (green << 8) + blue;
				color = method373(color, value);
				if (color == 0) {
					color = 1;
				}
				anIntArray1482[pos++] = color;
			}
		}
		for (int index = 0; index < textureAmount; index++) {
			if (aBackgroundArray1474s[index] != null) {
				final int[] colors = aBackgroundArray1474s[index].palette;
				anIntArrayArray1483[index] = new int[colors.length];
				for (int i = 0; i < colors.length; i++) {
					anIntArrayArray1483[index][i] = method373(colors[i], value);
					if ((anIntArrayArray1483[index][i] & 0xf8f8ff) == 0 && i != 0) {
						anIntArrayArray1483[index][i] = 1;
					}
				}
			}
		}
		for (int index = 0; index < textureAmount; index++) {
			method370(index);
		}
	}

	static int method373(int color, double amt) {
		double red = (color >> 16) / 256D;
		double green = (color >> 8 & 0xff) / 256D;
		double blue = (color & 0xff) / 256D;
		red = Math.pow(red, amt);
		green = Math.pow(green, amt);
		blue = Math.pow(blue, amt);
		final int red2 = (int)(red * 256D);
		final int green2 = (int)(green * 256D);
		final int blue2 = (int)(blue * 256D);
		return (red2 << 16) + (green2 << 8) + blue2;
	}

	public static void drawMaterializedTriangle(int y1, int y2, int y3, int x1, int x2, int x3, int hsl1, int hsl2, int hsl3, int tx1, int tx2, int tx3, int ty1, int ty2, int ty3, int tz1, int tz2, int tz3, int tex, float z1, float z2, float z3) {
		if (!Client.getOption("hd_tex") || Texture.get(tex) == null) {
			drawGouraudTriangle(y1, y2, y3, x1, x2, x3, hsl1, hsl2, hsl3, z1, z2, z3);
			return;
		}
		

		int area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2) >> 1;

		if (area < 0) area = -area;

		int mipmaps;

		if (area > 16384) {
			mipmaps = 0;
		} else if (area > 4096) {
			mipmaps = 1;
		} else if (area > 1024) {
			mipmaps = 1;
		} else if (area > 256) {
			mipmaps = 2;
		} else if (area > 64) {
			mipmaps = 3;
		} else if (area > 16) {
			mipmaps = 4;
		} else if (area > 4) {
			mipmaps = 5;
		} else if (area > 1) {
			mipmaps = 6;
		} else {
			mipmaps = 7;
		}

		Texture texturePixels = Texture.get(tex);
		if (texturePixels == null) {
			return;
		}

		int[] texels = texturePixels.mipmaps[mipmaps];
		tx2 = tx1 - tx2;
		ty2 = ty1 - ty2;
		tz2 = tz1 - tz2;
		tx3 -= tx1;
		ty3 -= ty1;
		tz3 -= tz1;
		int l4 = (tx3 * ty1 - ty3 * tx1) * WorldController.focalLength << 5;
		int i5 = ty3 * tz1 - tz3 * ty1 << 8;
		int j5 = tz3 * tx1 - tx3 * tz1 << 5;
		int k5 = (tx2 * ty1 - ty2 * tx1) * WorldController.focalLength << 5;
		int l5 = ty2 * tz1 - tz2 * ty1 << 8;
		int i6 = tz2 * tx1 - tx2 * tz1 << 5;
		int j6 = (ty2 * tx3 - tx2 * ty3) * WorldController.focalLength << 5;
		int k6 = tz2 * ty3 - ty2 * tz3 << 8;
		int l6 = tx2 * tz3 - tz2 * tx3 << 5;
		int i7 = 0;
		int j7 = 0;
		if (y2 != y1) {
			i7 = (x2 - x1 << 16) / (y2 - y1);
			j7 = (hsl2 - hsl1 << 15) / (y2 - y1);
		}
		int k7 = 0;
		int l7 = 0;
		if (y3 != y2) {
			k7 = (x3 - x2 << 16) / (y3 - y2);
			l7 = (hsl3 - hsl2 << 15) / (y3 - y2);
		}
		int i8 = 0;
		int j8 = 0;
		if (y3 != y1) {
			i8 = (x1 - x3 << 16) / (y1 - y3);
			j8 = (hsl1 - hsl3 << 15) / (y1 - y3);
		}

		float x21 = x2 - x1;
		float y32 = y2 - y1;
		float x31 = x3 - x1;
		float y31 = y3 - y1;
		float z21 = z2 - z1;
		float z31 = z3 - z1;

		float div = x21 * y31 - x31 * y32;
		float depthSlope = (z21 * y31 - z31 * y32) / div;
		float depthScale = (z31 * x21 - z21 * x31) / div;

		if (y1 <= y2 && y1 <= y3) {
			if (y1 >= DrawingArea.clipBottom) {
				return;
			}
			if (y2 > DrawingArea.clipBottom) {
				y2 = DrawingArea.clipBottom;
			}
			if (y3 > DrawingArea.clipBottom) {
				y3 = DrawingArea.clipBottom;
			}
			z1 = z1 - depthSlope * x1 + depthSlope;
			if (y2 < y3) {
				x3 = x1 <<= 16;
				hsl3 = hsl1 <<= 15;
				if (y1 < 0) {
					x3 -= i8 * y1;
					x1 -= i7 * y1;
					z1 -= depthScale * y1;
					hsl3 -= j8 * y1;
					hsl1 -= j7 * y1;
					y1 = 0;
				}
				x2 <<= 16;
				hsl2 <<= 15;
				if (y2 < 0) {
					x2 -= k7 * y2;
					hsl2 -= l7 * y2;
					y2 = 0;
				}
				int k8 = y1 - textureInt2;
				l4 += j5 * k8;
				k5 += i6 * k8;
				j6 += l6 * k8;
				if (y1 != y2 && i8 < i7 || y1 == y2 && i8 > k7) {
					y3 -= y2;
					y2 -= y1;
					y1 = anIntArray1472[y1];
					while (--y2 >= 0) {
						drawMaterializedScanline(DrawingArea.pixels, texels, y1, x3 >> 16, x1 >> 16, hsl3 >> 7, hsl1 >> 7, l4, k5, j6, i5, l5, k6, z1, depthSlope, mipmaps);
						x3 += i8;
						x1 += i7;
						z1 += depthScale;
						hsl3 += j8;
						hsl1 += j7;
						y1 += DrawingArea.width;
						l4 += j5;
						k5 += i6;
						j6 += l6;
					}
					while (--y3 >= 0) {
						drawMaterializedScanline(DrawingArea.pixels, texels, y1, x3 >> 16, x2 >> 16, hsl3 >> 7, hsl2 >> 7, l4, k5, j6, i5, l5, k6, z1, depthSlope, mipmaps);
						x3 += i8;
						x2 += k7;
						z1 += depthScale;
						hsl3 += j8;
						hsl2 += l7;
						y1 += DrawingArea.width;
						l4 += j5;
						k5 += i6;
						j6 += l6;
					}
					texels = null;
					return;
				}
				y3 -= y2;
				y2 -= y1;
				y1 = anIntArray1472[y1];
				while (--y2 >= 0) {
					drawMaterializedScanline(DrawingArea.pixels, texels, y1, x1 >> 16, x3 >> 16, hsl1 >> 7, hsl3 >> 7, l4, k5, j6, i5, l5, k6, z1, depthSlope, mipmaps);
					x3 += i8;
					x1 += i7;
					z1 += depthScale;
					hsl3 += j8;
					hsl1 += j7;
					y1 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while (--y3 >= 0) {
					drawMaterializedScanline(DrawingArea.pixels, texels, y1, x2 >> 16, x3 >> 16, hsl2 >> 7, hsl3 >> 7, l4, k5, j6, i5, l5, k6, z1, depthSlope, mipmaps);
					x3 += i8;
					x2 += k7;
					z1 += depthScale;
					hsl3 += j8;
					hsl2 += l7;
					y1 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				texels = null;
				return;
			}
			x2 = x1 <<= 16;
			hsl2 = hsl1 <<= 15;
			if (y1 < 0) {
				x2 -= i8 * y1;
				x1 -= i7 * y1;
				z1 -= depthScale * y1;
				hsl2 -= j8 * y1;
				hsl1 -= j7 * y1;
				y1 = 0;
			}
			x3 <<= 16;
			hsl3 <<= 15;
			if (y3 < 0) {
				x3 -= k7 * y3;
				hsl3 -= l7 * y3;
				y3 = 0;
			}
			int l8 = y1 - textureInt2;
			l4 += j5 * l8;
			k5 += i6 * l8;
			j6 += l6 * l8;
			if (y1 != y3 && i8 < i7 || y1 == y3 && k7 > i7) {
				y2 -= y3;
				y3 -= y1;
				y1 = anIntArray1472[y1];
				while (--y3 >= 0) {
					drawMaterializedScanline(DrawingArea.pixels, texels, y1, x2 >> 16, x1 >> 16, hsl2 >> 7, hsl1 >> 7, l4, k5, j6, i5, l5, k6, z1, depthSlope, mipmaps);
					x2 += i8;
					x1 += i7;
					z1 += depthScale;
					hsl2 += j8;
					hsl1 += j7;
					y1 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while (--y2 >= 0) {
					drawMaterializedScanline(DrawingArea.pixels, texels, y1, x3 >> 16, x1 >> 16, hsl3 >> 7, hsl1 >> 7, l4, k5, j6, i5, l5, k6, z1, depthSlope, mipmaps);
					x3 += k7;
					x1 += i7;
					z1 += depthScale;
					hsl3 += l7;
					hsl1 += j7;
					y1 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				texels = null;
				return;
			}
			y2 -= y3;
			y3 -= y1;
			y1 = anIntArray1472[y1];
			while (--y3 >= 0) {
				drawMaterializedScanline(DrawingArea.pixels, texels, y1, x1 >> 16, x2 >> 16, hsl1 >> 7, hsl2 >> 7, l4, k5, j6, i5, l5, k6, z1, depthSlope, mipmaps);
				x2 += i8;
				x1 += i7;
				z1 += depthScale;
				hsl2 += j8;
				hsl1 += j7;
				y1 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			while (--y2 >= 0) {
				drawMaterializedScanline(DrawingArea.pixels, texels, y1, x1 >> 16, x3 >> 16, hsl1 >> 7, hsl3 >> 7, l4, k5, j6, i5, l5, k6, z1, depthSlope, mipmaps);
				x3 += k7;
				x1 += i7;
				z1 += depthScale;
				hsl3 += l7;
				hsl1 += j7;
				y1 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			texels = null;
			return;
		}
		if (y2 <= y3) {
			if (y2 >= DrawingArea.clipBottom) {
				return;
			}
			if (y3 > DrawingArea.clipBottom) {
				y3 = DrawingArea.clipBottom;
			}
			if (y1 > DrawingArea.clipBottom) {
				y1 = DrawingArea.clipBottom;
			}
			z2 = z2 - depthSlope * x2 + depthSlope;
			if (y3 < y1) {
				x1 = x2 <<= 16;
				hsl1 = hsl2 <<= 15;
				if (y2 < 0) {
					x1 -= i7 * y2;
					x2 -= k7 * y2;
					z2 -= depthScale * y2;
					hsl1 -= j7 * y2;
					hsl2 -= l7 * y2;
					y2 = 0;
				}
				x3 <<= 16;
				hsl3 <<= 15;
				if (y3 < 0) {
					x3 -= i8 * y3;
					hsl3 -= j8 * y3;
					y3 = 0;
				}
				int i9 = y2 - textureInt2;
				l4 += j5 * i9;
				k5 += i6 * i9;
				j6 += l6 * i9;
				if (y2 != y3 && i7 < k7 || y2 == y3 && i7 > i8) {
					y1 -= y3;
					y3 -= y2;
					y2 = anIntArray1472[y2];
					while (--y3 >= 0) {
						drawMaterializedScanline(DrawingArea.pixels, texels, y2, x1 >> 16, x2 >> 16, hsl1 >> 7, hsl2 >> 7, l4, k5, j6, i5, l5, k6, z2, depthSlope, mipmaps);
						x1 += i7;
						x2 += k7;
						z2 += depthScale;
						hsl1 += j7;
						hsl2 += l7;
						y2 += DrawingArea.width;
						l4 += j5;
						k5 += i6;
						j6 += l6;
					}
					while (--y1 >= 0) {
						drawMaterializedScanline(DrawingArea.pixels, texels, y2, x1 >> 16, x3 >> 16, hsl1 >> 7, hsl3 >> 7, l4, k5, j6, i5, l5, k6, z2, depthSlope, mipmaps);
						x1 += i7;
						x3 += i8;
						z2 += depthScale;
						hsl1 += j7;
						hsl3 += j8;
						y2 += DrawingArea.width;
						l4 += j5;
						k5 += i6;
						j6 += l6;
					}
					texels = null;
					return;
				}
				y1 -= y3;
				y3 -= y2;
				y2 = anIntArray1472[y2];
				while (--y3 >= 0) {
					drawMaterializedScanline(DrawingArea.pixels, texels, y2, x2 >> 16, x1 >> 16, hsl2 >> 7, hsl1 >> 7, l4, k5, j6, i5, l5, k6, z2, depthSlope, mipmaps);
					x1 += i7;
					x2 += k7;
					z2 += depthScale;
					hsl1 += j7;
					hsl2 += l7;
					y2 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while (--y1 >= 0) {
					drawMaterializedScanline(DrawingArea.pixels, texels, y2, x3 >> 16, x1 >> 16, hsl3 >> 7, hsl1 >> 7, l4, k5, j6, i5, l5, k6, z2, depthSlope, mipmaps);
					x1 += i7;
					x3 += i8;
					z2 += depthScale;
					hsl1 += j7;
					hsl3 += j8;
					y2 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				texels = null;
				return;
			}
			x3 = x2 <<= 16;
			hsl3 = hsl2 <<= 15;
			if (y2 < 0) {
				x3 -= i7 * y2;
				x2 -= k7 * y2;
				z2 -= depthScale * y2;
				hsl3 -= j7 * y2;
				hsl2 -= l7 * y2;
				y2 = 0;
			}
			x1 <<= 16;
			hsl1 <<= 15;
			if (y1 < 0) {
				x1 -= i8 * y1;
				hsl1 -= j8 * y1;
				y1 = 0;
			}
			int j9 = y2 - textureInt2;
			l4 += j5 * j9;
			k5 += i6 * j9;
			j6 += l6 * j9;
			if (i7 < k7) {
				y3 -= y1;
				y1 -= y2;
				y2 = anIntArray1472[y2];
				while (--y1 >= 0) {
					drawMaterializedScanline(DrawingArea.pixels, texels, y2, x3 >> 16, x2 >> 16, hsl3 >> 7, hsl2 >> 7, l4, k5, j6, i5, l5, k6, z2, depthSlope, mipmaps);
					x3 += i7;
					x2 += k7;
					z2 += depthScale;
					hsl3 += j7;
					hsl2 += l7;
					y2 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while (--y3 >= 0) {
					drawMaterializedScanline(DrawingArea.pixels, texels, y2, x1 >> 16, x2 >> 16, hsl1 >> 7, hsl2 >> 7, l4, k5, j6, i5, l5, k6, z2, depthSlope, mipmaps);
					x1 += i8;
					x2 += k7;
					z2 += depthScale;
					hsl1 += j8;
					hsl2 += l7;
					y2 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				texels = null;
				return;
			}
			y3 -= y1;
			y1 -= y2;
			y2 = anIntArray1472[y2];
			while (--y1 >= 0) {
				drawMaterializedScanline(DrawingArea.pixels, texels, y2, x2 >> 16, x3 >> 16, hsl2 >> 7, hsl3 >> 7, l4, k5, j6, i5, l5, k6, z2, depthSlope, mipmaps);
				x3 += i7;
				x2 += k7;
				z2 += depthScale;
				hsl3 += j7;
				hsl2 += l7;
				y2 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			while (--y3 >= 0) {
				drawMaterializedScanline(DrawingArea.pixels, texels, y2, x2 >> 16, x1 >> 16, hsl2 >> 7, hsl1 >> 7, l4, k5, j6, i5, l5, k6, z2, depthSlope, mipmaps);
				x1 += i8;
				x2 += k7;
				z2 += depthScale;
				hsl1 += j8;
				hsl2 += l7;
				y2 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			texels = null;
			return;
		}
		if (y3 >= DrawingArea.clipBottom) {
			return;
		}
		if (y1 > DrawingArea.clipBottom) {
			y1 = DrawingArea.clipBottom;
		}
		if (y2 > DrawingArea.clipBottom) {
			y2 = DrawingArea.clipBottom;
		}
		z3 = z3 - depthSlope * x3 + depthSlope;
		if (y1 < y2) {
			x2 = x3 <<= 16;
			hsl2 = hsl3 <<= 15;
			if (y3 < 0) {
				x2 -= k7 * y3;
				x3 -= i8 * y3;
				z3 -= depthScale * y3;
				hsl2 -= l7 * y3;
				hsl3 -= j8 * y3;
				y3 = 0;
			}
			x1 <<= 16;
			hsl1 <<= 15;
			if (y1 < 0) {
				x1 -= i7 * y1;
				hsl1 -= j7 * y1;
				y1 = 0;
			}
			int k9 = y3 - textureInt2;
			l4 += j5 * k9;
			k5 += i6 * k9;
			j6 += l6 * k9;
			if (k7 < i8) {
				y2 -= y1;
				y1 -= y3;
				y3 = anIntArray1472[y3];
				while (--y1 >= 0) {
					drawMaterializedScanline(DrawingArea.pixels, texels, y3, x2 >> 16, x3 >> 16, hsl2 >> 7, hsl3 >> 7, l4, k5, j6, i5, l5, k6, z3, depthSlope, mipmaps);
					x2 += k7;
					x3 += i8;
					z3 += depthScale;
					hsl2 += l7;
					hsl3 += j8;
					y3 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while (--y2 >= 0) {
					drawMaterializedScanline(DrawingArea.pixels, texels, y3, x2 >> 16, x1 >> 16, hsl2 >> 7, hsl1 >> 7, l4, k5, j6, i5, l5, k6, z3, depthSlope, mipmaps);
					x2 += k7;
					x1 += i7;
					z3 += depthScale;
					hsl2 += l7;
					hsl1 += j7;
					y3 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				texels = null;
				return;
			}
			y2 -= y1;
			y1 -= y3;
			y3 = anIntArray1472[y3];
			while (--y1 >= 0) {
				drawMaterializedScanline(DrawingArea.pixels, texels, y3, x3 >> 16, x2 >> 16, hsl3 >> 7, hsl2 >> 7, l4, k5, j6, i5, l5, k6, z3, depthSlope, mipmaps);
				x2 += k7;
				x3 += i8;
				z3 += depthScale;
				hsl2 += l7;
				hsl3 += j8;
				y3 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			while (--y2 >= 0) {
				drawMaterializedScanline(DrawingArea.pixels, texels, y3, x1 >> 16, x2 >> 16, hsl1 >> 7, hsl2 >> 7, l4, k5, j6, i5, l5, k6, z3, depthSlope, mipmaps);
				x2 += k7;
				x1 += i7;
				z3 += depthScale;
				hsl2 += l7;
				hsl1 += j7;
				y3 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			texels = null;
			return;
		}
		x1 = x3 <<= 16;
		hsl1 = hsl3 <<= 15;
		if (y3 < 0) {
			x1 -= k7 * y3;
			x3 -= i8 * y3;
			z3 -= depthScale * y3;
			hsl1 -= l7 * y3;
			hsl3 -= j8 * y3;
			y3 = 0;
		}
		x2 <<= 16;
		hsl2 <<= 15;
		if (y2 < 0) {
			x2 -= i7 * y2;
			hsl2 -= j7 * y2;
			y2 = 0;
		}
		int l9 = y3 - textureInt2;
		l4 += j5 * l9;
		k5 += i6 * l9;
		j6 += l6 * l9;
		if (k7 < i8) {
			y1 -= y2;
			y2 -= y3;
			y3 = anIntArray1472[y3];
			while (--y2 >= 0) {
				drawMaterializedScanline(DrawingArea.pixels, texels, y3, x1 >> 16, x3 >> 16, hsl1 >> 7, hsl3 >> 7, l4, k5, j6, i5, l5, k6, z3, depthSlope, mipmaps);
				x1 += k7;
				x3 += i8;
				z3 += depthScale;
				hsl1 += l7;
				hsl3 += j8;
				y3 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			while (--y1 >= 0) {
				drawMaterializedScanline(DrawingArea.pixels, texels, y3, x2 >> 16, x3 >> 16, hsl2 >> 7, hsl3 >> 7, l4, k5, j6, i5, l5, k6, z3, depthSlope, mipmaps);
				x2 += i7;
				x3 += i8;
				z3 += depthScale;
				hsl2 += j7;
				hsl3 += j8;
				y3 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			texels = null;
			return;
		}
		y1 -= y2;
		y2 -= y3;
		y3 = anIntArray1472[y3];
		while (--y2 >= 0) {
			drawMaterializedScanline(DrawingArea.pixels, texels, y3, x3 >> 16, x1 >> 16, hsl3 >> 7, hsl1 >> 7, l4, k5, j6, i5, l5, k6, z3, depthSlope, mipmaps);
			x1 += k7;
			x3 += i8;
			z3 += depthScale;
			hsl1 += l7;
			hsl3 += j8;
			y3 += DrawingArea.width;
			l4 += j5;
			k5 += i6;
			j6 += l6;
		}
		while (--y1 >= 0) {
			drawMaterializedScanline(DrawingArea.pixels, texels, y3, x3 >> 16, x2 >> 16, hsl3 >> 7, hsl2 >> 7, l4, k5, j6, i5, l5, k6, z3, depthSlope, mipmaps);
			x2 += i7;
			x3 += i8;
			z3 += depthScale;
			hsl2 += j7;
			hsl3 += j8;
			y3 += DrawingArea.width;
			l4 += j5;
			k5 += i6;
			j6 += l6;
		}
	}

	private static final void drawMaterializedScanline(int[] dest, int[] texels, int offset, int x1, int x2, int hsl1, int hsl2, int t1, int t2, int t3, int t4, int t5, int t6, float z1, float z2, int mipmaps) {
		if(x2 <= x1) {
			return;
		}
		int texPos = 0;
		int rgb = 0;
		if (aBoolean1462) {
			if (x2 > DrawingArea.viewportRX) {
				x2 = DrawingArea.viewportRX;
			}
			if (x1 < 0) {
				x1 = 0;
			}
		}
		if(x1 < x2) {
			offset += x1;
			z1 += z2 * (float) x1;
			int n = x2 - x1 >> 2;
			int dhsl = 0;
			if(n > 0) {
				dhsl = (hsl2 - hsl1) * anIntArray1468[n] >> 15;
			}
			int dist = x1 - textureInt1;
			t1 += (t4 >> 3) * dist;
			t2 += (t5 >> 3) * dist;
			t3 += (t6 >> 3) * dist;
			int i_57_ = t3 >> 14;
			int i_58_;
			int i_59_;
			if(i_57_ != 0) {
				i_58_ = t1 / i_57_;
				i_59_ = t2 / i_57_;
			} else {
				i_58_ = 0;
				i_59_ = 0;
			}
			t1 += t4;
			t2 += t5;
			t3 += t6;
			i_57_ = t3 >> 14;
			int i_60_;
			int i_61_;
			if(i_57_ != 0) {
				i_60_ = t1 / i_57_;
				i_61_ = t2 / i_57_;
			} else {
				i_60_ = 0;
				i_61_ = 0;
			}
			texPos = (i_58_ << 18) + i_59_;
			int dtexPos = (i_60_ - i_58_ >> 3 << 18) + (i_61_ - i_59_ >> 3);
			n >>= 1;
			int light;
			if(n > 0) {
				do {
					hsl1 += dhsl;
					rgb = texels[texelPos((texPos & 0x3f80) + (texPos >>> 25), mipmaps)];
					light = ((hsl1 >> 8 & 0x7f) << 1) * (((rgb >> 16 & 0xff) + (rgb >> 8 & 0xff) + (rgb & 0xff)) / 3) / 384;
					if (light > 127) {
						light = 127;
					}
					texPos += dtexPos;
					if (z1 < depthBuffer[offset]) {
						dest[offset] = anIntArray1482[(hsl1 >> 8 & 0xff80) | light];
						depthBuffer[offset] = z1;
					}
					z1 += z2;
					offset++;
					rgb = texels[texelPos((texPos & 0x3f80) + (texPos >>> 25), mipmaps)];
					light = ((hsl1 >> 8 & 0x7f) << 1) * (((rgb >> 16 & 0xff) + (rgb >> 8 & 0xff) + (rgb & 0xff)) / 3) / 384;
					if (light > 127) {
						light = 127;
					}
					texPos += dtexPos;
					if (z1 < depthBuffer[offset]) {
						dest[offset] = anIntArray1482[(hsl1 >> 8 & 0xff80) | light];
						depthBuffer[offset] = z1;
					}
					z1 += z2;
					offset++;
					rgb = texels[texelPos((texPos & 0x3f80) + (texPos >>> 25), mipmaps)];
					light = ((hsl1 >> 8 & 0x7f) << 1) * (((rgb >> 16 & 0xff) + (rgb >> 8 & 0xff) + (rgb & 0xff)) / 3) / 384;
					if (light > 127) {
						light = 127;
					}
					texPos += dtexPos;
					if (z1 < depthBuffer[offset]) {
						dest[offset] = anIntArray1482[(hsl1 >> 8 & 0xff80) | light];
						depthBuffer[offset] = z1;
					}
					z1 += z2;
					offset++;
					rgb = texels[texelPos((texPos & 0x3f80) + (texPos >>> 25), mipmaps)];
					light = ((hsl1 >> 8 & 0x7f) << 1) * (((rgb >> 16 & 0xff) + (rgb >> 8 & 0xff) + (rgb & 0xff)) / 3) / 384;
					if (light > 127) {
						light = 127;
					}
					texPos += dtexPos;
					if (z1 < depthBuffer[offset]) {
						dest[offset] = anIntArray1482[(hsl1 >> 8 & 0xff80) | light];
						depthBuffer[offset] = z1;
					}
					z1 += z2;
					offset++;
					hsl1 += dhsl;
					rgb = texels[texelPos((texPos & 0x3f80) + (texPos >>> 25), mipmaps)];
					light = ((hsl1 >> 8 & 0x7f) << 1) * (((rgb >> 16 & 0xff) + (rgb >> 8 & 0xff) + (rgb & 0xff)) / 3) / 384;
					if (light > 127) {
						light = 127;
					}
					texPos += dtexPos;
					if (z1 < depthBuffer[offset]) {
						dest[offset] = anIntArray1482[(hsl1 >> 8 & 0xff80) | light];
						depthBuffer[offset] = z1;
					}
					z1 += z2;
					offset++;
					rgb = texels[texelPos((texPos & 0x3f80) + (texPos >>> 25), mipmaps)];
					light = ((hsl1 >> 8 & 0x7f) << 1) * (((rgb >> 16 & 0xff) + (rgb >> 8 & 0xff) + (rgb & 0xff)) / 3) / 384;
					if (light > 127) {
						light = 127;
					}
					texPos += dtexPos;
					if (z1 < depthBuffer[offset]) {
						dest[offset] = anIntArray1482[(hsl1 >> 8 & 0xff80) | light];
						depthBuffer[offset] = z1;
					}
					z1 += z2;
					offset++;
					rgb = texels[texelPos((texPos & 0x3f80) + (texPos >>> 25), mipmaps)];
					light = ((hsl1 >> 8 & 0x7f) << 1) * (((rgb >> 16 & 0xff) + (rgb >> 8 & 0xff) + (rgb & 0xff)) / 3) / 384;
					if (light > 127) {
						light = 127;
					}
					texPos += dtexPos;
					if (z1 < depthBuffer[offset]) {
						dest[offset] = anIntArray1482[(hsl1 >> 8 & 0xff80) | light];
						depthBuffer[offset] = z1;
					}
					z1 += z2;
					offset++;
					rgb = texels[texelPos((texPos & 0x3f80) + (texPos >>> 25), mipmaps)];
					light = ((hsl1 >> 8 & 0x7f) << 1) * (((rgb >> 16 & 0xff) + (rgb >> 8 & 0xff) + (rgb & 0xff)) / 3) / 384;
					if (light > 127) {
						light = 127;
					}
					texPos += dtexPos;
					if (z1 < depthBuffer[offset]) {
						dest[offset] = anIntArray1482[(hsl1 >> 8 & 0xff80) | light];
						depthBuffer[offset] = z1;
					}
					z1 += z2;
					offset++;
					i_58_ = i_60_;
					i_59_ = i_61_;
					t1 += t4;
					t2 += t5;
					t3 += t6;
					i_57_ = t3 >> 14;
					if(i_57_ != 0) {
						i_60_ = t1 / i_57_;
						i_61_ = t2 / i_57_;
					} else {
						i_60_ = 0;
						i_61_ = 0;
					}
					texPos = (i_58_ << 18) + i_59_;
					dtexPos = (i_60_ - i_58_ >> 3 << 18) + (i_61_ - i_59_ >> 3);
				} while(--n > 0);
			}
			n = x2 - x1 & 7;
			if(n > 0) {
				do {
					if((n & 3) == 0) {
						hsl1 += dhsl;
					}
					rgb = texels[texelPos((texPos & 0x3f80) + (texPos >>> 25), mipmaps)];
					light = ((hsl1 >> 8 & 0x7f) << 1) * (((rgb >> 16 & 0xff) + (rgb >> 8 & 0xff) + (rgb & 0xff)) / 3) / 384;
					if (light > 127) {
						light = 127;
					}
					texPos += dtexPos;
					if (z1 < depthBuffer[offset]) {
						dest[offset] = anIntArray1482[(hsl1 >> 8 & 0xff80) | light];
						depthBuffer[offset] = z1;
					}
					z1 += z2;
					offset++;
				} while(--n > 0);
			}
		}
	}

	private static void drawGouraudTriangle(int y1, int y2, int y3, int x1, int x2, int x3, int hsl1, int hsl2, int hsl3) {
		int rgb1 = anIntArray1482[hsl1];
		int rgb2 = anIntArray1482[hsl2];
		int rgb3 = anIntArray1482[hsl3];
		int r1 = rgb1 >> 16 & 0xff;
		int g1 = rgb1 >> 8 & 0xff;
		int b1 = rgb1 & 0xff;
		int r2 = rgb2 >> 16 & 0xff;
		int g2 = rgb2 >> 8 & 0xff;
		int b2 = rgb2 & 0xff;
		int r3 = rgb3 >> 16 & 0xff;
		int g3 = rgb3 >> 8 & 0xff;
		int b3 = rgb3 & 0xff;
		int dx1 = 0;
		int dr1 = 0;
		int dg1 = 0;
		int db1 = 0;
		if (y2 != y1) {
			dx1 = (x2 - x1 << 16) / (y2 - y1);
			dr1 = (r2 - r1 << 16) / (y2 - y1);
			dg1 = (g2 - g1 << 16) / (y2 - y1);
			db1 = (b2 - b1 << 16) / (y2 - y1);
		}
		int dx2 = 0;
		int dr2 = 0;
		int dg2 = 0;
		int db2 = 0;
		if (y3 != y2) {
			dx2 = (x3 - x2 << 16) / (y3 - y2);
			dr2 = (r3 - r2 << 16) / (y3 - y2);
			dg2 = (g3 - g2 << 16) / (y3 - y2);
			db2 = (b3 - b2 << 16) / (y3 - y2);
		}
		int dx3 = 0;
		int dr3 = 0;
		int dg3 = 0;
		int db3 = 0;
		if (y3 != y1) {
			dx3 = (x1 - x3 << 16) / (y1 - y3);
			dr3 = (r1 - r3 << 16) / (y1 - y3);
			dg3 = (g1 - g3 << 16) / (y1 - y3);
			db3 = (b1 - b3 << 16) / (y1 - y3);
		}
		if(y1 <= y2 && y1 <= y3) {
			if(y1 >= DrawingArea.clipBottom) {
				return;
			}
			if(y2 > DrawingArea.clipBottom) {
				y2 = DrawingArea.clipBottom;
			}
			if(y3 > DrawingArea.clipBottom) {
				y3 = DrawingArea.clipBottom;
			}
			if(y2 < y3) {
				x3 = x1 <<= 16;
				r3 = r1 <<= 16;
				g3 = g1 <<= 16;
				b3 = b1 <<= 16;
				if(y1 < 0) {
					x3 -= dx3 * y1;
					x1 -= dx1 * y1;
					r3 -= dr3 * y1;
					g3 -= dg3 * y1;
					b3 -= db3 * y1;
					r1 -= dr1 * y1;
					g1 -= dg1 * y1;
					b1 -= db1 * y1;
					y1 = 0;
				}
				x2 <<= 16;
				r2 <<= 16;
				g2 <<= 16;
				b2 <<= 16;
				if(y2 < 0) {
					x2 -= dx2 * y2;
					r2 -= dr2 * y2;
					g2 -= dg2 * y2;
					b2 -= db2 * y2;
					y2 = 0;
				}
				if(y1 != y2 && dx3 < dx1 || y1 == y2 && dx3 > dx2) {
					y3 -= y2;
					y2 -= y1;
					for(y1 = anIntArray1472[y1]; --y2 >= 0; y1 += DrawingArea.width) {
						drawGouraudScanline(DrawingArea.pixels, y1, x3 >> 16, x1 >> 16, r3, g3, b3, r1, g1, b1);
						x3 += dx3;
						x1 += dx1;
						r3 += dr3;
						g3 += dg3;
						b3 += db3;
						r1 += dr1;
						g1 += dg1;
						b1 += db1;
					}
					while(--y3 >= 0) {
						drawGouraudScanline(DrawingArea.pixels, y1, x3 >> 16, x2 >> 16, r3, g3, b3, r2, g2, b2);
						x3 += dx3;
						x2 += dx2;
						r3 += dr3;
						g3 += dg3;
						b3 += db3;
						r2 += dr2;
						g2 += dg2;
						b2 += db2;
						y1 += DrawingArea.width;
					}
					return;
				}
				y3 -= y2;
				y2 -= y1;
				for(y1 = anIntArray1472[y1]; --y2 >= 0; y1 += DrawingArea.width) {
					drawGouraudScanline(DrawingArea.pixels, y1, x1 >> 16, x3 >> 16, r1, g1, b1, r3, g3, b3);
					x3 += dx3;
					x1 += dx1;
					r3 += dr3;
					g3 += dg3;
					b3 += db3;
					r1 += dr1;
					g1 += dg1;
					b1 += db1;
				}
				while(--y3 >= 0) {
					drawGouraudScanline(DrawingArea.pixels, y1, x2 >> 16, x3 >> 16, r2, g2, b2, r3, g3, b3);
					x3 += dx3;
					x2 += dx2;
					r3 += dr3;
					g3 += dg3;
					b3 += db3;
					r2 += dr2;
					g2 += dg2;
					b2 += db2;
					y1 += DrawingArea.width;
				}
				return;
			}
			x2 = x1 <<= 16;
			r2 = r1 <<= 16;
			g2 = g1 <<= 16;
			b2 = b1 <<= 16;
			if(y1 < 0) {
				x2 -= dx3 * y1;
				x1 -= dx1 * y1;
				r2 -= dr3 * y1;
				g2 -= dg3 * y1;
				b2 -= db3 * y1;
				r1 -= dr1 * y1;
				g1 -= dg1 * y1;
				b1 -= db1 * y1;
				y1 = 0;
			}
			x3 <<= 16;
			r3 <<= 16;
			g3 <<= 16;
			b3 <<= 16;
			if(y3 < 0) {
				x3 -= dx2 * y3;
				r3 -= dr2 * y3;
				g3 -= dg2 * y3;
				b3 -= db2 * y3;
				y3 = 0;
			}
			if(y1 != y3 && dx3 < dx1 || y1 == y3 && dx2 > dx1) {
				y2 -= y3;
				y3 -= y1;
				for(y1 = anIntArray1472[y1]; --y3 >= 0; y1 += DrawingArea.width) {
					drawGouraudScanline(DrawingArea.pixels, y1, x2 >> 16, x1 >> 16, r2, g2, b2, r1, g1, b1);
					x2 += dx3;
					x1 += dx1;
					r2 += dr3;
					g2 += dg3;
					b2 += db3;
					r1 += dr1;
					g1 += dg1;
					b1 += db1;
				}
				while(--y2 >= 0) {
					drawGouraudScanline(DrawingArea.pixels, y1, x3 >> 16, x1 >> 16, r3, g3, b3, r1, g1, b1);
					x3 += dx2;
					x1 += dx1;
					r3 += dr2;
					g3 += dg2;
					b3 += db2;
					r1 += dr1;
					g1 += dg1;
					b1 += db1;
					y1 += DrawingArea.width;
				}
				return;
			}
			y2 -= y3;
			y3 -= y1;
			for(y1 = anIntArray1472[y1]; --y3 >= 0; y1 += DrawingArea.width) {
				drawGouraudScanline(DrawingArea.pixels, y1, x1 >> 16, x2 >> 16, r1, g1, b1, r2, g2, b2);
				x2 += dx3;
				x1 += dx1;
				r2 += dr3;
				g2 += dg3;
				b2 += db3;
				r1 += dr1;
				g1 += dg1;
				b1 += db1;
			}
			while(--y2 >= 0) {
				drawGouraudScanline(DrawingArea.pixels, y1, x1 >> 16, x3 >> 16, r1, g1, b1, r3, g3, b3);
				x3 += dx2;
				x1 += dx1;
				r3 += dr2;
				g3 += dg2;
				b3 += db2;
				r1 += dr1;
				g1 += dg1;
				b1 += db1;
				y1 += DrawingArea.width;
			}
			return;
		}
		if(y2 <= y3) {
			if(y2 >= DrawingArea.clipBottom) {
				return;
			}
			if(y3 > DrawingArea.clipBottom) {
				y3 = DrawingArea.clipBottom;
			}
			if(y1 > DrawingArea.clipBottom) {
				y1 = DrawingArea.clipBottom;
			}
			if(y3 < y1) {
				x1 = x2 <<= 16;
				r1 = r2 <<= 16;
				g1 = g2 <<= 16;
				b1 = b2 <<= 16;
				if(y2 < 0) {
					x1 -= dx1 * y2;
					x2 -= dx2 * y2;
					r1 -= dr1 * y2;
					g1 -= dg1 * y2;
					b1 -= db1 * y2;
					r2 -= dr2 * y2;
					g2 -= dg2 * y2;
					b2 -= db2 * y2;
					y2 = 0;
				}
				x3 <<= 16;
				r3 <<= 16;
				g3 <<= 16;
				b3 <<= 16;
				if(y3 < 0) {
					x3 -= dx3 * y3;
					r3 -= dr3 * y3;
					g3 -= dg3 * y3;
					b3 -= db3 * y3;
					y3 = 0;
				}
				if(y2 != y3 && dx1 < dx2 || y2 == y3 && dx1 > dx3) {
					y1 -= y3;
					y3 -= y2;
					for(y2 = anIntArray1472[y2]; --y3 >= 0; y2 += DrawingArea.width) {
						drawGouraudScanline(DrawingArea.pixels, y2, x1 >> 16, x2 >> 16, r1, g1, b1, r2, g2, b2);
						x1 += dx1;
						x2 += dx2;
						r1 += dr1;
						g1 += dg1;
						b1 += db1;
						r2 += dr2;
						g2 += dg2;
						b2 += db2;
					}
					while(--y1 >= 0) {
						drawGouraudScanline(DrawingArea.pixels, y2, x1 >> 16, x3 >> 16, r1, g1, b1, r3, g3, b3);
						x1 += dx1;
						x3 += dx3;
						r1 += dr1;
						g1 += dg1;
						b1 += db1;
						r3 += dr3;
						g3 += dg3;
						b3 += db3;
						y2 += DrawingArea.width;
					}
					return;
				}
				y1 -= y3;
				y3 -= y2;
				for(y2 = anIntArray1472[y2]; --y3 >= 0; y2 += DrawingArea.width) {
					drawGouraudScanline(DrawingArea.pixels, y2, x2 >> 16, x1 >> 16, r2, g2, b2, r1, g1, b1);
					x1 += dx1;
					x2 += dx2;
					r1 += dr1;
					g1 += dg1;
					b1 += db1;
					r2 += dr2;
					g2 += dg2;
					b2 += db2;
				}
				while(--y1 >= 0) {
					drawGouraudScanline(DrawingArea.pixels, y2, x3 >> 16, x1 >> 16, r3, g3, b3, r1, g1, b1);
					x1 += dx1;
					x3 += dx3;
					r1 += dr1;
					g1 += dg1;
					b1 += db1;
					r3 += dr3;
					g3 += dg3;
					b3 += db3;
					y2 += DrawingArea.width;
				}
				return;
			}
			x3 = x2 <<= 16;
			r3 = r2 <<= 16;
			g3 = g2 <<= 16;
			b3 = b2 <<= 16;
			if(y2 < 0) {
				x3 -= dx1 * y2;
				x2 -= dx2 * y2;
				r3 -= dr1 * y2;
				g3 -= dg1 * y2;
				b3 -= db1 * y2;
				r2 -= dr2 * y2;
				g2 -= dg2 * y2;
				b2 -= db2 * y2;
				y2 = 0;
			}
			x1 <<= 16;
			r1 <<= 16;
			g1 <<= 16;
			b1 <<= 16;
			if(y1 < 0) {
				x1 -= dx3 * y1;
				r1 -= dr3 * y1;
				g1 -= dg3 * y1;
				b1 -= db3 * y1;
				y1 = 0;
			}
			if(dx1 < dx2) {
				y3 -= y1;
				y1 -= y2;
				for(y2 = anIntArray1472[y2]; --y1 >= 0; y2 += DrawingArea.width) {
					drawGouraudScanline(DrawingArea.pixels, y2, x3 >> 16, x2 >> 16, r3, g3, b3, r2, g2, b2);
					x3 += dx1;
					x2 += dx2;
					r3 += dr1;
					g3 += dg1;
					b3 += db1;
					r2 += dr2;
					g2 += dg2;
					b2 += db2;
				}
				while(--y3 >= 0) {
					drawGouraudScanline(DrawingArea.pixels, y2, x1 >> 16, x2 >> 16, r1, g1, b1, r2, g2, b2);
					x1 += dx3;
					x2 += dx2;
					r1 += dr3;
					g1 += dg3;
					b1 += db3;
					r2 += dr2;
					g2 += dg2;
					b2 += db2;
					y2 += DrawingArea.width;
				}
				return;
			}
			y3 -= y1;
			y1 -= y2;
			for(y2 = anIntArray1472[y2]; --y1 >= 0; y2 += DrawingArea.width) {
				drawGouraudScanline(DrawingArea.pixels, y2, x2 >> 16, x3 >> 16, r2, g2, b2, r3, g3, b3);
				x3 += dx1;
				x2 += dx2;
				r3 += dr1;
				g3 += dg1;
				b3 += db1;
				r2 += dr2;
				g2 += dg2;
				b2 += db2;
			}
			while(--y3 >= 0) {
				drawGouraudScanline(DrawingArea.pixels, y2, x2 >> 16, x1 >> 16, r2, g2, b2, r1, g1, b1);
				x1 += dx3;
				x2 += dx2;
				r1 += dr3;
				g1 += dg3;
				b1 += db3;
				r2 += dr2;
				g2 += dg2;
				b2 += db2;
				y2 += DrawingArea.width;
			}
			return;
		}
		if(y3 >= DrawingArea.clipBottom) {
			return;
		}
		if(y1 > DrawingArea.clipBottom) {
			y1 = DrawingArea.clipBottom;
		}
		if(y2 > DrawingArea.clipBottom) {
			y2 = DrawingArea.clipBottom;
		}
		if(y1 < y2) {
			x2 = x3 <<= 16;
			r2 = r3 <<= 16;
			g2 = g3 <<= 16;
			b2 = b3 <<= 16;
			if(y3 < 0) {
				x2 -= dx2 * y3;
				x3 -= dx3 * y3;
				r2 -= dr2 * y3;
				g2 -= dg2 * y3;
				b2 -= db2 * y3;
				r3 -= dr3 * y3;
				g3 -= dg3 * y3;
				b3 -= db3 * y3;
				y3 = 0;
			}
			x1 <<= 16;
			r1 <<= 16;
			g1 <<= 16;
			b1 <<= 16;
			if(y1 < 0) {
				x1 -= dx1 * y1;
				r1 -= dr1 * y1;
				g1 -= dg1 * y1;
				b1 -= db1 * y1;
				y1 = 0;
			}
			if(dx2 < dx3) {
				y2 -= y1;
				y1 -= y3;
				for(y3 = anIntArray1472[y3]; --y1 >= 0; y3 += DrawingArea.width) {
					drawGouraudScanline(DrawingArea.pixels, y3, x2 >> 16, x3 >> 16, r2, g2, b2, r3, g3, b3);
					x2 += dx2;
					x3 += dx3;
					r2 += dr2;
					g2 += dg2;
					b2 += db2;
					r3 += dr3;
					g3 += dg3;
					b3 += db3;
				}
				while(--y2 >= 0) {
					drawGouraudScanline(DrawingArea.pixels, y3, x2 >> 16, x1 >> 16, r2, g2, b2, r1, g1, b1);
					x2 += dx2;
					x1 += dx1;
					r2 += dr2;
					g2 += dg2;
					b2 += db2;
					r1 += dr1;
					g1 += dg1;
					b1 += db1;
					y3 += DrawingArea.width;
				}
				return;
			}
			y2 -= y1;
			y1 -= y3;
			for(y3 = anIntArray1472[y3]; --y1 >= 0; y3 += DrawingArea.width) {
				drawGouraudScanline(DrawingArea.pixels, y3, x3 >> 16, x2 >> 16, r3, g3, b3, r2, g2, b2);
				x2 += dx2;
				x3 += dx3;
				r2 += dr2;
				g2 += dg2;
				b2 += db2;
				r3 += dr3;
				g3 += dg3;
				b3 += db3;
			}
			while(--y2 >= 0) {
				drawGouraudScanline(DrawingArea.pixels, y3, x1 >> 16, x2 >> 16, r1, g1, b1, r2, g2, b2);
				x2 += dx2;
				x1 += dx1;
				r2 += dr2;
				g2 += dg2;
				b2 += db2;
				r1 += dr1;
				g1 += dg1;
				b1 += db1;
				y3 += DrawingArea.width;
			}
			return;
		}
		x1 = x3 <<= 16;
		r1 = r3 <<= 16;
		g1 = g3 <<= 16;
		b1 = b3 <<= 16;
		if(y3 < 0) {
			x1 -= dx2 * y3;
			x3 -= dx3 * y3;
			r1 -= dr2 * y3;
			g1 -= dg2 * y3;
			b1 -= db2 * y3;
			r3 -= dr3 * y3;
			g3 -= dg3 * y3;
			b3 -= db3 * y3;
			y3 = 0;
		}
		x2 <<= 16;
		r2 <<= 16;
		g2 <<= 16;
		b2 <<= 16;
		if(y2 < 0) {
			x2 -= dx1 * y2;
			r2 -= dr1 * y2;
			g2 -= dg1 * y2;
			b2 -= db1 * y2;
			y2 = 0;
		}
		if(dx2 < dx3) {
			y1 -= y2;
			y2 -= y3;
			for(y3 = anIntArray1472[y3]; --y2 >= 0; y3 += DrawingArea.width) {
				drawGouraudScanline(DrawingArea.pixels, y3, x1 >> 16, x3 >> 16, r1, g1, b1, r3, g3, b3);
				x1 += dx2;
				x3 += dx3;
				r1 += dr2;
				g1 += dg2;
				b1 += db2;
				r3 += dr3;
				g3 += dg3;
				b3 += db3;
			}
			while(--y1 >= 0) {
				drawGouraudScanline(DrawingArea.pixels, y3, x2 >> 16, x3 >> 16, r2, g2, b2, r3, g3, b3);
				x2 += dx1;
				x3 += dx3;
				r2 += dr1;
				g2 += dg1;
				b2 += db1;
				r3 += dr3;
				g3 += dg3;
				b3 += db3;
				y3 += DrawingArea.width;
			}
			return;
		}
		y1 -= y2;
		y2 -= y3;
		for(y3 = anIntArray1472[y3]; --y2 >= 0; y3 += DrawingArea.width) {
			drawGouraudScanline(DrawingArea.pixels, y3, x3 >> 16, x1 >> 16, r3, g3, b3, r1, g1, b1);
			x1 += dx2;
			x3 += dx3;
			r1 += dr2;
			g1 += dg2;
			b1 += db2;
			r3 += dr3;
			g3 += dg3;
			b3 += db3;
		}
		while(--y1 >= 0) {
			drawGouraudScanline(DrawingArea.pixels, y3, x3 >> 16, x2 >> 16, r3, g3, b3, r2, g2, b2);
			x2 += dx1;
			x3 += dx3;
			r2 += dr1;
			g2 += dg1;
			b2 += db1;
			r3 += dr3;
			g3 += dg3;
			b3 += db3;
			y3 += DrawingArea.width;
		}
	}


	public static void drawGouraudScanline(int[] dest, int offset, int x1, int x2, int r1, int g1, int b1, int r2, int g2, int b2) {
		int n = x2 - x1;
		if (n <= 0) {
			return;
		}
		r2 = (r2 - r1) / n;
		g2 = (g2 - g1) / n;
		b2 = (b2 - b1) / n;
		if (aBoolean1462) {
			if (x2 > DrawingArea.viewportRX) {
				n -= x2 - DrawingArea.viewportRX;
				x2 = DrawingArea.viewportRX;
			}
			if (x1 < 0) {
				n = x2;
				r1 -= x1 * r2;
				g1 -= x1 * g2;
				b1 -= x1 * b2;
				x1 = 0;
			}
		}
		if (x1 < x2) {
			offset += x1;
			if (anInt1465 == 0) {
				while (--n >= 0) {
					dest[offset] = (r1 & 0xff0000) | (g1 >> 8 & 0xff00) | (b1 >> 16 & 0xff);
					r1 += r2;
					g1 += g2;
					b1 += b2;
					offset++;
				}
			} else {
				final int a1 = anInt1465;
				final int a2 = 256 - anInt1465;
				int rgb;
				int dst;
				while (--n >= 0) {
					rgb = (r1 & 0xff0000) | (g1 >> 8 & 0xff00) | (b1 >> 16 & 0xff);
					rgb = ((rgb & 0xff00ff) * a2 >> 8 & 0xff00ff) + ((rgb & 0xff00) * a2 >> 8 & 0xff00);
					dst = dest[offset];
					dest[offset] = rgb + ((dst & 0xff00ff) * a1 >> 8 & 0xff00ff) + ((dst & 0xff00) * a1 >> 8 & 0xff00);
					r1 += r2;
					g1 += g2;
					b1 += b2;
					offset++;
				}
			}
		}
	}

	public static void drawGouraudTriangle(int y1, int y2, int y3, int x1, int x2, int x3, int hsl1, int hsl2, int hsl3, float z1, float z2, float z3) {
		if (!aBoolean1464) {
			drawGouraudTriangle(y1, y2, y3, x1, x2, x3, hsl1, hsl2, hsl3);
			return;
		}
		int rgb1 = anIntArray1482[hsl1];
		int rgb2 = anIntArray1482[hsl2];
		int rgb3 = anIntArray1482[hsl3];
		int r1 = rgb1 >> 16 & 0xff;
		int g1 = rgb1 >> 8 & 0xff;
		int b1 = rgb1 & 0xff;
		int r2 = rgb2 >> 16 & 0xff;
		int g2 = rgb2 >> 8 & 0xff;
		int b2 = rgb2 & 0xff;
		int r3 = rgb3 >> 16 & 0xff;
		int g3 = rgb3 >> 8 & 0xff;
		int b3 = rgb3 & 0xff;
		int dx1 = 0;
		int dr1 = 0;
		int dg1 = 0;
		int db1 = 0;
		if (y2 != y1) {
			dx1 = (x2 - x1 << 16) / (y2 - y1);
			dr1 = (r2 - r1 << 16) / (y2 - y1);
			dg1 = (g2 - g1 << 16) / (y2 - y1);
			db1 = (b2 - b1 << 16) / (y2 - y1);
		}
		int dx2 = 0;
		int dr2 = 0;
		int dg2 = 0;
		int db2 = 0;
		if (y3 != y2) {
			dx2 = (x3 - x2 << 16) / (y3 - y2);
			dr2 = (r3 - r2 << 16) / (y3 - y2);
			dg2 = (g3 - g2 << 16) / (y3 - y2);
			db2 = (b3 - b2 << 16) / (y3 - y2);
		}
		int dx3 = 0;
		int dr3 = 0;
		int dg3 = 0;
		int db3 = 0;
		if (y3 != y1) {
			dx3 = (x1 - x3 << 16) / (y1 - y3);
			dr3 = (r1 - r3 << 16) / (y1 - y3);
			dg3 = (g1 - g3 << 16) / (y1 - y3);
			db3 = (b1 - b3 << 16) / (y1 - y3);
		}

		float x21 = x2 - x1;
		float y32 = y2 - y1;
		float x31 = x3 - x1;
		float y31 = y3 - y1;
		float z21 = z2 - z1;
		float z31 = z3 - z1;

		float div = x21 * y31 - x31 * y32;
		float depthSlope = (z21 * y31 - z31 * y32) / div;
		float depthScale = (z31 * x21 - z21 * x31) / div;

		if (y1 <= y2 && y1 <= y3) {
			if (y1 >= DrawingArea.clipBottom) {
				return;
			}
			if (y2 > DrawingArea.clipBottom) {
				y2 = DrawingArea.clipBottom;
			}
			if (y3 > DrawingArea.clipBottom) {
				y3 = DrawingArea.clipBottom;
			}
			z1 = z1 - depthSlope * x1 + depthSlope;
			if (y2 < y3) {
				x3 = x1 <<= 16;
				r3 = r1 <<= 16;
				g3 = g1 <<= 16;
				b3 = b1 <<= 16;
				if (y1 < 0) {
					x3 -= dx3 * y1;
					x1 -= dx1 * y1;
					r3 -= dr3 * y1;
					g3 -= dg3 * y1;
					b3 -= db3 * y1;
					r1 -= dr1 * y1;
					g1 -= dg1 * y1;
					b1 -= db1 * y1;
					z1 -= depthScale * y1;
					y1 = 0;
				}
				x2 <<= 16;
				r2 <<= 16;
				g2 <<= 16;
				b2 <<= 16;
				if (y2 < 0) {
					x2 -= dx2 * y2;
					r2 -= dr2 * y2;
					g2 -= dg2 * y2;
					b2 -= db2 * y2;
					y2 = 0;
				}
				if (y1 != y2 && dx3 < dx1 || y1 == y2 && dx3 > dx2) {
					y3 -= y2;
					y2 -= y1;
					for (y1 = anIntArray1472[y1]; --y2 >= 0; y1 += DrawingArea.width) {
						drawGouraudScanline(DrawingArea.pixels, y1, x3 >> 16, x1 >> 16, r3, g3, b3, r1, g1, b1, z1, depthSlope);
						x3 += dx3;
						x1 += dx1;
						r3 += dr3;
						g3 += dg3;
						b3 += db3;
						r1 += dr1;
						g1 += dg1;
						b1 += db1;
						z1 += depthScale;
					}
					while (--y3 >= 0) {
						drawGouraudScanline(DrawingArea.pixels, y1, x3 >> 16, x2 >> 16, r3, g3, b3, r2, g2, b2, z1, depthSlope);
						x3 += dx3;
						x2 += dx2;
						r3 += dr3;
						g3 += dg3;
						b3 += db3;
						r2 += dr2;
						g2 += dg2;
						b2 += db2;
						y1 += DrawingArea.width;
						z1 += depthScale;
					}
					return;
				}
				y3 -= y2;
				y2 -= y1;
				for (y1 = anIntArray1472[y1]; --y2 >= 0; y1 += DrawingArea.width) {
					drawGouraudScanline(DrawingArea.pixels, y1, x1 >> 16, x3 >> 16, r1, g1, b1, r3, g3, b3, z1, depthSlope);
					x3 += dx3;
					x1 += dx1;
					r3 += dr3;
					g3 += dg3;
					b3 += db3;
					r1 += dr1;
					g1 += dg1;
					b1 += db1;
					z1 += depthScale;
				}
				while (--y3 >= 0) {
					drawGouraudScanline(DrawingArea.pixels, y1, x2 >> 16, x3 >> 16, r2, g2, b2, r3, g3, b3, z1, depthSlope);
					x3 += dx3;
					x2 += dx2;
					r3 += dr3;
					g3 += dg3;
					b3 += db3;
					r2 += dr2;
					g2 += dg2;
					b2 += db2;
					y1 += DrawingArea.width;
					z1 += depthScale;
				}
				return;
			}
			x2 = x1 <<= 16;
			r2 = r1 <<= 16;
			g2 = g1 <<= 16;
			b2 = b1 <<= 16;
			if (y1 < 0) {
				x2 -= dx3 * y1;
				x1 -= dx1 * y1;
				r2 -= dr3 * y1;
				g2 -= dg3 * y1;
				b2 -= db3 * y1;
				r1 -= dr1 * y1;
				g1 -= dg1 * y1;
				b1 -= db1 * y1;
				z1 -= depthScale * y1;
				y1 = 0;
			}
			x3 <<= 16;
			r3 <<= 16;
			g3 <<= 16;
			b3 <<= 16;
			if (y3 < 0) {
				x3 -= dx2 * y3;
				r3 -= dr2 * y3;
				g3 -= dg2 * y3;
				b3 -= db2 * y3;
				y3 = 0;
			}
			if (y1 != y3 && dx3 < dx1 || y1 == y3 && dx2 > dx1) {
				y2 -= y3;
				y3 -= y1;
				for (y1 = anIntArray1472[y1]; --y3 >= 0; y1 += DrawingArea.width) {
					drawGouraudScanline(DrawingArea.pixels, y1, x2 >> 16, x1 >> 16, r2, g2, b2, r1, g1, b1, z1, depthSlope);
					x2 += dx3;
					x1 += dx1;
					r2 += dr3;
					g2 += dg3;
					b2 += db3;
					r1 += dr1;
					g1 += dg1;
					b1 += db1;
					z1 += depthScale;
				}
				while (--y2 >= 0) {
					drawGouraudScanline(DrawingArea.pixels, y1, x3 >> 16, x1 >> 16, r3, g3, b3, r1, g1, b1, z1, depthSlope);
					x3 += dx2;
					x1 += dx1;
					r3 += dr2;
					g3 += dg2;
					b3 += db2;
					r1 += dr1;
					g1 += dg1;
					b1 += db1;
					y1 += DrawingArea.width;
					z1 += depthScale;
				}
				return;
			}
			y2 -= y3;
			y3 -= y1;
			for (y1 = anIntArray1472[y1]; --y3 >= 0; y1 += DrawingArea.width) {
				drawGouraudScanline(DrawingArea.pixels, y1, x1 >> 16, x2 >> 16, r1, g1, b1, r2, g2, b2, z1, depthSlope);
				x2 += dx3;
				x1 += dx1;
				r2 += dr3;
				g2 += dg3;
				b2 += db3;
				r1 += dr1;
				g1 += dg1;
				b1 += db1;
				z1 += depthScale;
			}
			while (--y2 >= 0) {
				drawGouraudScanline(DrawingArea.pixels, y1, x1 >> 16, x3 >> 16, r1, g1, b1, r3, g3, b3, z1, depthSlope);
				x3 += dx2;
				x1 += dx1;
				r3 += dr2;
				g3 += dg2;
				b3 += db2;
				r1 += dr1;
				g1 += dg1;
				b1 += db1;
				y1 += DrawingArea.width;
				z1 += depthScale;
			}
			return;
		}
		if (y2 <= y3) {
			if (y2 >= DrawingArea.clipBottom) {
				return;
			}
			if (y3 > DrawingArea.clipBottom) {
				y3 = DrawingArea.clipBottom;
			}
			if (y1 > DrawingArea.clipBottom) {
				y1 = DrawingArea.clipBottom;
			}
			z2 = z2 - depthSlope * x2 + depthSlope;
			if (y3 < y1) {
				x1 = x2 <<= 16;
				r1 = r2 <<= 16;
				g1 = g2 <<= 16;
				b1 = b2 <<= 16;
				if (y2 < 0) {
					x1 -= dx1 * y2;
					x2 -= dx2 * y2;
					r1 -= dr1 * y2;
					g1 -= dg1 * y2;
					b1 -= db1 * y2;
					r2 -= dr2 * y2;
					g2 -= dg2 * y2;
					b2 -= db2 * y2;
					z2 -= depthScale * y2;
					y2 = 0;
				}
				x3 <<= 16;
				r3 <<= 16;
				g3 <<= 16;
				b3 <<= 16;
				if (y3 < 0) {
					x3 -= dx3 * y3;
					r3 -= dr3 * y3;
					g3 -= dg3 * y3;
					b3 -= db3 * y3;
					y3 = 0;
				}
				if (y2 != y3 && dx1 < dx2 || y2 == y3 && dx1 > dx3) {
					y1 -= y3;
					y3 -= y2;
					for (y2 = anIntArray1472[y2]; --y3 >= 0; y2 += DrawingArea.width) {
						drawGouraudScanline(DrawingArea.pixels, y2, x1 >> 16, x2 >> 16, r1, g1, b1, r2, g2, b2, z2, depthSlope);
						x1 += dx1;
						x2 += dx2;
						r1 += dr1;
						g1 += dg1;
						b1 += db1;
						r2 += dr2;
						g2 += dg2;
						b2 += db2;
						z2 += depthScale;
					}
					while (--y1 >= 0) {
						drawGouraudScanline(DrawingArea.pixels, y2, x1 >> 16, x3 >> 16, r1, g1, b1, r3, g3, b3, z2, depthSlope);
						x1 += dx1;
						x3 += dx3;
						r1 += dr1;
						g1 += dg1;
						b1 += db1;
						r3 += dr3;
						g3 += dg3;
						b3 += db3;
						y2 += DrawingArea.width;
						z2 += depthScale;
					}
					return;
				}
				y1 -= y3;
				y3 -= y2;
				for (y2 = anIntArray1472[y2]; --y3 >= 0; y2 += DrawingArea.width) {
					drawGouraudScanline(DrawingArea.pixels, y2, x2 >> 16, x1 >> 16, r2, g2, b2, r1, g1, b1, z2, depthSlope);
					x1 += dx1;
					x2 += dx2;
					r1 += dr1;
					g1 += dg1;
					b1 += db1;
					r2 += dr2;
					g2 += dg2;
					b2 += db2;
					z2 += depthScale;
				}
				while (--y1 >= 0) {
					drawGouraudScanline(DrawingArea.pixels, y2, x3 >> 16, x1 >> 16, r3, g3, b3, r1, g1, b1, z2, depthSlope);
					x1 += dx1;
					x3 += dx3;
					r1 += dr1;
					g1 += dg1;
					b1 += db1;
					r3 += dr3;
					g3 += dg3;
					b3 += db3;
					y2 += DrawingArea.width;
					z2 += depthScale;
				}
				return;
			}
			x3 = x2 <<= 16;
			r3 = r2 <<= 16;
			g3 = g2 <<= 16;
			b3 = b2 <<= 16;
			if (y2 < 0) {
				x3 -= dx1 * y2;
				x2 -= dx2 * y2;
				r3 -= dr1 * y2;
				g3 -= dg1 * y2;
				b3 -= db1 * y2;
				r2 -= dr2 * y2;
				g2 -= dg2 * y2;
				b2 -= db2 * y2;
				z2 -= depthScale * y2;
				y2 = 0;
			}
			x1 <<= 16;
			r1 <<= 16;
			g1 <<= 16;
			b1 <<= 16;
			if (y1 < 0) {
				x1 -= dx3 * y1;
				r1 -= dr3 * y1;
				g1 -= dg3 * y1;
				b1 -= db3 * y1;
				y1 = 0;
			}
			if (dx1 < dx2) {
				y3 -= y1;
				y1 -= y2;
				for (y2 = anIntArray1472[y2]; --y1 >= 0; y2 += DrawingArea.width) {
					drawGouraudScanline(DrawingArea.pixels, y2, x3 >> 16, x2 >> 16, r3, g3, b3, r2, g2, b2, z2, depthSlope);
					x3 += dx1;
					x2 += dx2;
					r3 += dr1;
					g3 += dg1;
					b3 += db1;
					r2 += dr2;
					g2 += dg2;
					b2 += db2;
					z2 += depthScale;
				}
				while (--y3 >= 0) {
					drawGouraudScanline(DrawingArea.pixels, y2, x1 >> 16, x2 >> 16, r1, g1, b1, r2, g2, b2, z2, depthSlope);
					x1 += dx3;
					x2 += dx2;
					r1 += dr3;
					g1 += dg3;
					b1 += db3;
					r2 += dr2;
					g2 += dg2;
					b2 += db2;
					y2 += DrawingArea.width;
					z2 += depthScale;
				}
				return;
			}
			y3 -= y1;
			y1 -= y2;
			for (y2 = anIntArray1472[y2]; --y1 >= 0; y2 += DrawingArea.width) {
				drawGouraudScanline(DrawingArea.pixels, y2, x2 >> 16, x3 >> 16, r2, g2, b2, r3, g3, b3, z2, depthSlope);
				x3 += dx1;
				x2 += dx2;
				r3 += dr1;
				g3 += dg1;
				b3 += db1;
				r2 += dr2;
				g2 += dg2;
				b2 += db2;
				z2 += depthScale;
			}
			while (--y3 >= 0) {
				drawGouraudScanline(DrawingArea.pixels, y2, x2 >> 16, x1 >> 16, r2, g2, b2, r1, g1, b1, z2, depthSlope);
				x1 += dx3;
				x2 += dx2;
				r1 += dr3;
				g1 += dg3;
				b1 += db3;
				r2 += dr2;
				g2 += dg2;
				b2 += db2;
				y2 += DrawingArea.width;
				z2 += depthScale;
			}
			return;
		}
		if (y3 >= DrawingArea.clipBottom) {
			return;
		}
		if (y1 > DrawingArea.clipBottom) {
			y1 = DrawingArea.clipBottom;
		}
		if (y2 > DrawingArea.clipBottom) {
			y2 = DrawingArea.clipBottom;
		}
		z3 = z3 - depthSlope * x3 + depthSlope;
		if (y1 < y2) {
			x2 = x3 <<= 16;
			r2 = r3 <<= 16;
			g2 = g3 <<= 16;
			b2 = b3 <<= 16;
			if (y3 < 0) {
				x2 -= dx2 * y3;
				x3 -= dx3 * y3;
				r2 -= dr2 * y3;
				g2 -= dg2 * y3;
				b2 -= db2 * y3;
				r3 -= dr3 * y3;
				g3 -= dg3 * y3;
				b3 -= db3 * y3;
				z3 -= depthScale * y3;
				y3 = 0;
			}
			x1 <<= 16;
			r1 <<= 16;
			g1 <<= 16;
			b1 <<= 16;
			if (y1 < 0) {
				x1 -= dx1 * y1;
				r1 -= dr1 * y1;
				g1 -= dg1 * y1;
				b1 -= db1 * y1;
				y1 = 0;
			}
			if (dx2 < dx3) {
				y2 -= y1;
				y1 -= y3;
				for (y3 = anIntArray1472[y3]; --y1 >= 0; y3 += DrawingArea.width) {
					drawGouraudScanline(DrawingArea.pixels, y3, x2 >> 16, x3 >> 16, r2, g2, b2, r3, g3, b3, z3, depthSlope);
					x2 += dx2;
					x3 += dx3;
					r2 += dr2;
					g2 += dg2;
					b2 += db2;
					r3 += dr3;
					g3 += dg3;
					b3 += db3;
					z3 += depthScale;
				}
				while (--y2 >= 0) {
					drawGouraudScanline(DrawingArea.pixels, y3, x2 >> 16, x1 >> 16, r2, g2, b2, r1, g1, b1, z3, depthSlope);
					x2 += dx2;
					x1 += dx1;
					r2 += dr2;
					g2 += dg2;
					b2 += db2;
					r1 += dr1;
					g1 += dg1;
					b1 += db1;
					y3 += DrawingArea.width;
					z3 += depthScale;
				}
				return;
			}
			y2 -= y1;
			y1 -= y3;
			for (y3 = anIntArray1472[y3]; --y1 >= 0; y3 += DrawingArea.width) {
				drawGouraudScanline(DrawingArea.pixels, y3, x3 >> 16, x2 >> 16, r3, g3, b3, r2, g2, b2, z3, depthSlope);
				x2 += dx2;
				x3 += dx3;
				r2 += dr2;
				g2 += dg2;
				b2 += db2;
				r3 += dr3;
				g3 += dg3;
				b3 += db3;
				z3 += depthScale;
			}
			while (--y2 >= 0) {
				drawGouraudScanline(DrawingArea.pixels, y3, x1 >> 16, x2 >> 16, r1, g1, b1, r2, g2, b2, z3, depthSlope);
				x2 += dx2;
				x1 += dx1;
				r2 += dr2;
				g2 += dg2;
				b2 += db2;
				r1 += dr1;
				g1 += dg1;
				b1 += db1;
				z3 += depthScale;
				y3 += DrawingArea.width;
			}
			return;
		}
		x1 = x3 <<= 16;
		r1 = r3 <<= 16;
		g1 = g3 <<= 16;
		b1 = b3 <<= 16;
		if (y3 < 0) {
			x1 -= dx2 * y3;
			x3 -= dx3 * y3;
			r1 -= dr2 * y3;
			g1 -= dg2 * y3;
			b1 -= db2 * y3;
			r3 -= dr3 * y3;
			g3 -= dg3 * y3;
			b3 -= db3 * y3;
			z3 -= depthScale * y3;
			y3 = 0;
		}
		x2 <<= 16;
		r2 <<= 16;
		g2 <<= 16;
		b2 <<= 16;
		if (y2 < 0) {
			x2 -= dx1 * y2;
			r2 -= dr1 * y2;
			g2 -= dg1 * y2;
			b2 -= db1 * y2;
			y2 = 0;
		}
		if (dx2 < dx3) {
			y1 -= y2;
			y2 -= y3;
			for (y3 = anIntArray1472[y3]; --y2 >= 0; y3 += DrawingArea.width) {
				drawGouraudScanline(DrawingArea.pixels, y3, x1 >> 16, x3 >> 16, r1, g1, b1, r3, g3, b3, z3, depthSlope);
				x1 += dx2;
				x3 += dx3;
				r1 += dr2;
				g1 += dg2;
				b1 += db2;
				r3 += dr3;
				g3 += dg3;
				b3 += db3;
				z3 += depthScale;
			}
			while (--y1 >= 0) {
				drawGouraudScanline(DrawingArea.pixels, y3, x2 >> 16, x3 >> 16, r2, g2, b2, r3, g3, b3, z3, depthSlope);
				x2 += dx1;
				x3 += dx3;
				r2 += dr1;
				g2 += dg1;
				b2 += db1;
				r3 += dr3;
				g3 += dg3;
				b3 += db3;
				z3 += depthScale;
				y3 += DrawingArea.width;
			}
			return;
		}
		y1 -= y2;
		y2 -= y3;
		for (y3 = anIntArray1472[y3]; --y2 >= 0; y3 += DrawingArea.width) {
			drawGouraudScanline(DrawingArea.pixels, y3, x3 >> 16, x1 >> 16, r3, g3, b3, r1, g1, b1, z3, depthSlope);
			x1 += dx2;
			x3 += dx3;
			r1 += dr2;
			g1 += dg2;
			b1 += db2;
			r3 += dr3;
			g3 += dg3;
			b3 += db3;
			z3 += depthScale;
		}
		while (--y1 >= 0) {
			drawGouraudScanline(DrawingArea.pixels, y3, x3 >> 16, x2 >> 16, r3, g3, b3, r2, g2, b2, z3, depthSlope);
			x2 += dx1;
			x3 += dx3;
			r2 += dr1;
			g2 += dg1;
			b2 += db1;
			r3 += dr3;
			g3 += dg3;
			b3 += db3;
			y3 += DrawingArea.width;
			z3 += depthScale;
		}
	}

	public static void drawGouraudScanline(int[] dest, int offset, int x1, int x2, int r1, int g1, int b1, int r2, int g2, int b2, float z1, float z2) {
		int n = x2 - x1;
		if (n <= 0) {
			return;
		}
		r2 = (r2 - r1) / n;
		g2 = (g2 - g1) / n;
		b2 = (b2 - b1) / n;
		if (aBoolean1462) {
			if (x2 > DrawingArea.viewportRX) {
				n -= x2 - DrawingArea.viewportRX;
				x2 = DrawingArea.viewportRX;
			}
			if (x1 < 0) {
				n = x2;
				r1 -= x1 * r2;
				g1 -= x1 * g2;
				b1 -= x1 * b2;
				x1 = 0;
			}
		}
		if (x1 < x2) {
			offset += x1;
			z1 += z2 * x1;
			if (anInt1465 == 0) {
				while (--n >= 0) {
					if (z1 < depthBuffer[offset]) {
						dest[offset] = (r1 & 0xff0000) | (g1 >> 8 & 0xff00) | (b1 >> 16 & 0xff);
						depthBuffer[offset] = z1;
					}
					z1 += z2;
					r1 += r2;
					g1 += g2;
					b1 += b2;
					offset++;
				}
			} else {
				final int a1 = anInt1465;
				final int a2 = 256 - anInt1465;
				int rgb;
				while (--n >= 0) {
					rgb = r1 & 0xff0000 | g1 >> 8 & 0xff00 | b1 >> 16 & 0xff;
					rgb = ((rgb & 0xff00ff) * a2 >> 8 & 0xff00ff) + ((rgb & 0xff00) * a2 >> 8 & 0xff00);
					int dst = dest[offset];
					if (z1 < depthBuffer[offset]) {
						dest[offset] = rgb + ((dst & 0xff00ff) * a1 >> 8 & 0xff00ff) + ((dst & 0xff00) * a1 >> 8 & 0xff00);
						if (anInt1465 < 200) {
							depthBuffer[offset] = z1;
						}
					}
					offset++;
					z1 += z2;
					r1 += r2;
					g1 += g2;
					b1 += b2;
				}
			}
		}
	}

	private static void drawFlatTriangle(int i, int j, int k, int l, int i1, int j1, int k1) {
		int l1 = 0;
		if(j != i)
			l1 = (i1 - l << 16) / (j - i);
		int i2 = 0;
		if(k != j)
			i2 = (j1 - i1 << 16) / (k - j);
		int j2 = 0;
		if(k != i)
			j2 = (l - j1 << 16) / (i - k);
		if(i <= j && i <= k)
		{
			if(i >= DrawingArea.clipBottom)
				return;
			if(j > DrawingArea.clipBottom)
				j = DrawingArea.clipBottom;
			if(k > DrawingArea.clipBottom)
				k = DrawingArea.clipBottom;
			if(j < k)
			{
				j1 = l <<= 16;
				if(i < 0)
				{
					j1 -= j2 * i;
					l -= l1 * i;
					i = 0;
				}
				i1 <<= 16;
				if(j < 0)
				{
					i1 -= i2 * j;
					j = 0;
				}
				if(i != j && j2 < l1 || i == j && j2 > i2)
				{
					k -= j;
					j -= i;
					for(i = anIntArray1472[i]; --j >= 0; i += DrawingArea.width)
					{
						drawFlatScanline(DrawingArea.pixels, i, k1, j1 >> 16, l >> 16);
						j1 += j2;
						l += l1;
					}

					while(--k >= 0)
					{
						drawFlatScanline(DrawingArea.pixels, i, k1, j1 >> 16, i1 >> 16);
						j1 += j2;
						i1 += i2;
						i += DrawingArea.width;
					}
					return;
				}
				k -= j;
				j -= i;
				for(i = anIntArray1472[i]; --j >= 0; i += DrawingArea.width)
				{
					drawFlatScanline(DrawingArea.pixels, i, k1, l >> 16, j1 >> 16);
					j1 += j2;
					l += l1;
				}

				while(--k >= 0)
				{
					drawFlatScanline(DrawingArea.pixels, i, k1, i1 >> 16, j1 >> 16);
					j1 += j2;
					i1 += i2;
					i += DrawingArea.width;
				}
				return;
			}
			i1 = l <<= 16;
			if(i < 0)
			{
				i1 -= j2 * i;
				l -= l1 * i;
				i = 0;
			}
			j1 <<= 16;
			if(k < 0)
			{
				j1 -= i2 * k;
				k = 0;
			}
			if(i != k && j2 < l1 || i == k && i2 > l1)
			{
				j -= k;
				k -= i;
				for(i = anIntArray1472[i]; --k >= 0; i += DrawingArea.width)
				{
					drawFlatScanline(DrawingArea.pixels, i, k1, i1 >> 16, l >> 16);
					i1 += j2;
					l += l1;
				}

				while(--j >= 0)
				{
					drawFlatScanline(DrawingArea.pixels, i, k1, j1 >> 16, l >> 16);
					j1 += i2;
					l += l1;
					i += DrawingArea.width;
				}
				return;
			}
			j -= k;
			k -= i;
			for(i = anIntArray1472[i]; --k >= 0; i += DrawingArea.width)
			{
				drawFlatScanline(DrawingArea.pixels, i, k1, l >> 16, i1 >> 16);
				i1 += j2;
				l += l1;
			}

			while(--j >= 0)
			{
				drawFlatScanline(DrawingArea.pixels, i, k1, l >> 16, j1 >> 16);
				j1 += i2;
				l += l1;
				i += DrawingArea.width;
			}
			return;
		}
		if(j <= k)
		{
			if(j >= DrawingArea.clipBottom)
				return;
			if(k > DrawingArea.clipBottom)
				k = DrawingArea.clipBottom;
			if(i > DrawingArea.clipBottom)
				i = DrawingArea.clipBottom;
			if(k < i)
			{
				l = i1 <<= 16;
				if(j < 0)
				{
					l -= l1 * j;
					i1 -= i2 * j;
					j = 0;
				}
				j1 <<= 16;
				if(k < 0)
				{
					j1 -= j2 * k;
					k = 0;
				}
				if(j != k && l1 < i2 || j == k && l1 > j2)
				{
					i -= k;
					k -= j;
					for(j = anIntArray1472[j]; --k >= 0; j += DrawingArea.width)
					{
						drawFlatScanline(DrawingArea.pixels, j, k1, l >> 16, i1 >> 16);
						l += l1;
						i1 += i2;
					}

					while(--i >= 0)
					{
						drawFlatScanline(DrawingArea.pixels, j, k1, l >> 16, j1 >> 16);
						l += l1;
						j1 += j2;
						j += DrawingArea.width;
					}
					return;
				}
				i -= k;
				k -= j;
				for(j = anIntArray1472[j]; --k >= 0; j += DrawingArea.width)
				{
					drawFlatScanline(DrawingArea.pixels, j, k1, i1 >> 16, l >> 16);
					l += l1;
					i1 += i2;
				}

				while(--i >= 0)
				{
					drawFlatScanline(DrawingArea.pixels, j, k1, j1 >> 16, l >> 16);
					l += l1;
					j1 += j2;
					j += DrawingArea.width;
				}
				return;
			}
			j1 = i1 <<= 16;
			if(j < 0)
			{
				j1 -= l1 * j;
				i1 -= i2 * j;
				j = 0;
			}
			l <<= 16;
			if(i < 0)
			{
				l -= j2 * i;
				i = 0;
			}
			if(l1 < i2)
			{
				k -= i;
				i -= j;
				for(j = anIntArray1472[j]; --i >= 0; j += DrawingArea.width)
				{
					drawFlatScanline(DrawingArea.pixels, j, k1, j1 >> 16, i1 >> 16);
					j1 += l1;
					i1 += i2;
				}

				while(--k >= 0)
				{
					drawFlatScanline(DrawingArea.pixels, j, k1, l >> 16, i1 >> 16);
					l += j2;
					i1 += i2;
					j += DrawingArea.width;
				}
				return;
			}
			k -= i;
			i -= j;
			for(j = anIntArray1472[j]; --i >= 0; j += DrawingArea.width)
			{
				drawFlatScanline(DrawingArea.pixels, j, k1, i1 >> 16, j1 >> 16);
				j1 += l1;
				i1 += i2;
			}

			while(--k >= 0)
			{
				drawFlatScanline(DrawingArea.pixels, j, k1, i1 >> 16, l >> 16);
				l += j2;
				i1 += i2;
				j += DrawingArea.width;
			}
			return;
		}
		if(k >= DrawingArea.clipBottom)
			return;
		if(i > DrawingArea.clipBottom)
			i = DrawingArea.clipBottom;
		if(j > DrawingArea.clipBottom)
			j = DrawingArea.clipBottom;
		if(i < j)
		{
			i1 = j1 <<= 16;
			if(k < 0)
			{
				i1 -= i2 * k;
				j1 -= j2 * k;
				k = 0;
			}
			l <<= 16;
			if(i < 0)
			{
				l -= l1 * i;
				i = 0;
			}
			if(i2 < j2)
			{
				j -= i;
				i -= k;
				for(k = anIntArray1472[k]; --i >= 0; k += DrawingArea.width)
				{
					drawFlatScanline(DrawingArea.pixels, k, k1, i1 >> 16, j1 >> 16);
					i1 += i2;
					j1 += j2;
				}

				while(--j >= 0)
				{
					drawFlatScanline(DrawingArea.pixels, k, k1, i1 >> 16, l >> 16);
					i1 += i2;
					l += l1;
					k += DrawingArea.width;
				}
				return;
			}
			j -= i;
			i -= k;
			for(k = anIntArray1472[k]; --i >= 0; k += DrawingArea.width)
			{
				drawFlatScanline(DrawingArea.pixels, k, k1, j1 >> 16, i1 >> 16);
				i1 += i2;
				j1 += j2;
			}

			while(--j >= 0)
			{
				drawFlatScanline(DrawingArea.pixels, k, k1, l >> 16, i1 >> 16);
				i1 += i2;
				l += l1;
				k += DrawingArea.width;
			}
			return;
		}
		l = j1 <<= 16;
		if(k < 0)
		{
			l -= i2 * k;
			j1 -= j2 * k;
			k = 0;
		}
		i1 <<= 16;
		if(j < 0)
		{
			i1 -= l1 * j;
			j = 0;
		}
		if(i2 < j2)
		{
			i -= j;
			j -= k;
			for(k = anIntArray1472[k]; --j >= 0; k += DrawingArea.width)
			{
				drawFlatScanline(DrawingArea.pixels, k, k1, l >> 16, j1 >> 16);
				l += i2;
				j1 += j2;
			}

			while(--i >= 0)
			{
				drawFlatScanline(DrawingArea.pixels, k, k1, i1 >> 16, j1 >> 16);
				i1 += l1;
				j1 += j2;
				k += DrawingArea.width;
			}
			return;
		}
		i -= j;
		j -= k;
		for(k = anIntArray1472[k]; --j >= 0; k += DrawingArea.width)
		{
			drawFlatScanline(DrawingArea.pixels, k, k1, j1 >> 16, l >> 16);
			l += i2;
			j1 += j2;
		}

		while(--i >= 0)
		{
			drawFlatScanline(DrawingArea.pixels, k, k1, j1 >> 16, i1 >> 16);
			i1 += l1;
			j1 += j2;
			k += DrawingArea.width;
		}
	}

	private static void drawFlatScanline(int ai[], int i, int j, int l, int i1)
	{
		int k;//was parameter
		if(aBoolean1462)
		{
			if(i1 > DrawingArea.viewportRX)
				i1 = DrawingArea.viewportRX;
			if(l < 0)
				l = 0;
		}
		if(l >= i1)
			return;
		i += l;
		k = i1 - l >> 2;
		if(anInt1465 == 0)
		{
			while(--k >= 0)
			{
				ai[i++] = j;
				ai[i++] = j;
				ai[i++] = j;
				ai[i++] = j;
			}
			for(k = i1 - l & 3; --k >= 0;)
				ai[i++] = j;

			return;
		}
		int j1 = anInt1465;
		int k1 = 256 - anInt1465;
		j = ((j & 0xff00ff) * k1 >> 8 & 0xff00ff) + ((j & 0xff00) * k1 >> 8 & 0xff00);
		while(--k >= 0)
		{
			ai[i++] = j + ((ai[i] & 0xff00ff) * j1 >> 8 & 0xff00ff) + ((ai[i] & 0xff00) * j1 >> 8 & 0xff00);
			ai[i++] = j + ((ai[i] & 0xff00ff) * j1 >> 8 & 0xff00ff) + ((ai[i] & 0xff00) * j1 >> 8 & 0xff00);
			ai[i++] = j + ((ai[i] & 0xff00ff) * j1 >> 8 & 0xff00ff) + ((ai[i] & 0xff00) * j1 >> 8 & 0xff00);
			ai[i++] = j + ((ai[i] & 0xff00ff) * j1 >> 8 & 0xff00ff) + ((ai[i] & 0xff00) * j1 >> 8 & 0xff00);
		}
		for(k = i1 - l & 3; --k >= 0;)
			ai[i++] = j + ((ai[i] & 0xff00ff) * j1 >> 8 & 0xff00ff) + ((ai[i] & 0xff00) * j1 >> 8 & 0xff00);

	}

	public static void drawFlatTriangle(int y1, int y2, int y3, int x1, int x2, int x3, int rgb, float z1, float z2, float z3) {
		if (!aBoolean1464) {
			drawFlatTriangle(y1, y2, y3, x1, x2, x3, rgb);
			return;
		}
		int dx1 = 0;
		if(y2 != y1) {
			final int d = (y2 - y1);
			dx1 = (x2 - x1 << 16) / d;
		}
		int dx2 = 0;
		if(y3 != y2) {
			final int d = (y3 - y2);
			dx2 = (x3 - x2 << 16) / d;
		}
		int dx3 = 0;
		if(y3 != y1) {
			final int d = (y1 - y3);
			dx3 = (x1 - x3 << 16) / d;
		}

		float x21 = x2 - x1;
		float y32 = y2 - y1;
		float x31 = x3 - x1;
		float y31 = y3 - y1;
		float z21 = z2 - z1;
		float z31 = z3 - z1;

		float div = x21 * y31 - x31 * y32;
		float depthSlope = (z21 * y31 - z31 * y32) / div;
		float depthScale = (z31 * x21 - z21 * x31) / div;

		if(y1 <= y2 && y1 <= y3) {
			if(y1 >= DrawingArea.clipBottom) {
				return;
			}
			if(y2 > DrawingArea.clipBottom) {
				y2 = DrawingArea.clipBottom;
			}
			if(y3 > DrawingArea.clipBottom) {
				y3 = DrawingArea.clipBottom;
			}
			z1 = z1 - depthSlope * x1 + depthSlope;
			if(y2 < y3) {
				x3 = x1 <<= 16;
				if(y1 < 0) {
					x3 -= dx3 * y1;
					x1 -= dx1 * y1;
					z1 -= depthScale * y1;
					y1 = 0;
				}
				x2 <<= 16;
				if(y2 < 0) {
					x2 -= dx2 * y2;
					y2 = 0;
				}
				if(y1 != y2 && dx3 < dx1 || y1 == y2 && dx3 > dx2) {
					y3 -= y2;
					y2 -= y1;
					for(y1 = anIntArray1472[y1]; --y2 >= 0; y1 += DrawingArea.width) {
						drawFlatScanline(DrawingArea.pixels, y1, rgb, x3 >> 16, x1 >> 16, z1, depthSlope);
						z1 += depthScale;
						x3 += dx3;
						x1 += dx1;
					}
					while(--y3 >= 0) {
						drawFlatScanline(DrawingArea.pixels, y1, rgb, x3 >> 16, x2 >> 16, z1, depthSlope);
						z1 += depthScale;
						x3 += dx3;
						x2 += dx2;
						y1 += DrawingArea.width;
					}
					return;
				}
				y3 -= y2;
				y2 -= y1;
				for(y1 = anIntArray1472[y1]; --y2 >= 0; y1 += DrawingArea.width) {
					drawFlatScanline(DrawingArea.pixels, y1, rgb, x1 >> 16, x3 >> 16, z1, depthSlope);
					z1 += depthScale;
					x3 += dx3;
					x1 += dx1;
				}
				while(--y3 >= 0) {
					drawFlatScanline(DrawingArea.pixels, y1, rgb, x2 >> 16, x3 >> 16, z1, depthSlope);
					z1 += depthScale;
					x3 += dx3;
					x2 += dx2;
					y1 += DrawingArea.width;
				}
				return;
			}
			x2 = x1 <<= 16;
			if(y1 < 0) {
				x2 -= dx3 * y1;
				x1 -= dx1 * y1;
				z1 -= depthScale * y1;
				y1 = 0;
			}
			x3 <<= 16;
			if(y3 < 0) {
				x3 -= dx2 * y3;
				y3 = 0;
			}
			if(y1 != y3 && dx3 < dx1 || y1 == y3 && dx2 > dx1) {
				y2 -= y3;
				y3 -= y1;
				for(y1 = anIntArray1472[y1]; --y3 >= 0; y1 += DrawingArea.width) {
					drawFlatScanline(DrawingArea.pixels, y1, rgb, x2 >> 16, x1 >> 16, z1, depthSlope);
					z1 += depthScale;
					x2 += dx3;
					x1 += dx1;
				}
				while(--y2 >= 0) {
					drawFlatScanline(DrawingArea.pixels, y1, rgb, x3 >> 16, x1 >> 16, z1, depthSlope);
					z1 += depthScale;
					x3 += dx2;
					x1 += dx1;
					y1 += DrawingArea.width;
				}
				return;
			}
			y2 -= y3;
			y3 -= y1;
			for(y1 = anIntArray1472[y1]; --y3 >= 0; y1 += DrawingArea.width) {
				drawFlatScanline(DrawingArea.pixels, y1, rgb, x1 >> 16, x2 >> 16, z1, depthSlope);
				z1 += depthScale;
				x2 += dx3;
				x1 += dx1;
			}
			while(--y2 >= 0) {
				drawFlatScanline(DrawingArea.pixels, y1, rgb, x1 >> 16, x3 >> 16, z1, depthSlope);
				z1 += depthScale;
				x3 += dx2;
				x1 += dx1;
				y1 += DrawingArea.width;
			}
			return;
		}
		if(y2 <= y3) {
			if(y2 >= DrawingArea.clipBottom) {
				return;
			}
			if(y3 > DrawingArea.clipBottom) {
				y3 = DrawingArea.clipBottom;
			}
			if(y1 > DrawingArea.clipBottom) {
				y1 = DrawingArea.clipBottom;
			}
			z2 = z2 - depthSlope * x2 + depthSlope;
			if(y3 < y1) {
				x1 = x2 <<= 16;
				if(y2 < 0) {
					x1 -= dx1 * y2;
					x2 -= dx2 * y2;
					z2 -= depthScale * y2;
					y2 = 0;
				}
				x3 <<= 16;
				if(y3 < 0) {
					x3 -= dx3 * y3;
					y3 = 0;
				}
				if(y2 != y3 && dx1 < dx2 || y2 == y3 && dx1 > dx3) {
					y1 -= y3;
					y3 -= y2;
					for(y2 = anIntArray1472[y2]; --y3 >= 0; y2 += DrawingArea.width) {
						drawFlatScanline(DrawingArea.pixels, y2, rgb, x1 >> 16, x2 >> 16, z2, depthSlope);
						z2 += depthScale;
						x1 += dx1;
						x2 += dx2;
					}
					while(--y1 >= 0) {
						drawFlatScanline(DrawingArea.pixels, y2, rgb, x1 >> 16, x3 >> 16, z2, depthSlope);
						z2 += depthScale;
						x1 += dx1;
						x3 += dx3;
						y2 += DrawingArea.width;
					}
					return;
				}
				y1 -= y3;
				y3 -= y2;
				for(y2 = anIntArray1472[y2]; --y3 >= 0; y2 += DrawingArea.width) {
					drawFlatScanline(DrawingArea.pixels, y2, rgb, x2 >> 16, x1 >> 16, z2, depthSlope);
					z2 += depthScale;
					x1 += dx1;
					x2 += dx2;
				}
				while(--y1 >= 0) {
					drawFlatScanline(DrawingArea.pixels, y2, rgb, x3 >> 16, x1 >> 16, z2, depthSlope);
					z2 += depthScale;
					x1 += dx1;
					x3 += dx3;
					y2 += DrawingArea.width;
				}
				return;
			}
			x3 = x2 <<= 16;
			if(y2 < 0) {
				x3 -= dx1 * y2;
				x2 -= dx2 * y2;
				z2 -= depthScale * y2;
				y2 = 0;
			}
			x1 <<= 16;
			if(y1 < 0) {
				x1 -= dx3 * y1;
				y1 = 0;
			}
			if(dx1 < dx2) {
				y3 -= y1;
				y1 -= y2;
				for(y2 = anIntArray1472[y2]; --y1 >= 0; y2 += DrawingArea.width) {
					drawFlatScanline(DrawingArea.pixels, y2, rgb, x3 >> 16, x2 >> 16, z2, depthSlope);
					z2 += depthScale;
					x3 += dx1;
					x2 += dx2;
				}
				while(--y3 >= 0) {
					drawFlatScanline(DrawingArea.pixels, y2, rgb, x1 >> 16, x2 >> 16, z2, depthSlope);
					z2 += depthScale;
					x1 += dx3;
					x2 += dx2;
					y2 += DrawingArea.width;
				}
				return;
			}
			y3 -= y1;
			y1 -= y2;
			for(y2 = anIntArray1472[y2]; --y1 >= 0; y2 += DrawingArea.width) {
				drawFlatScanline(DrawingArea.pixels, y2, rgb, x2 >> 16, x3 >> 16, z2, depthSlope);
				z2 += depthScale;
				x3 += dx1;
				x2 += dx2;
			}
			while(--y3 >= 0) {
				drawFlatScanline(DrawingArea.pixels, y2, rgb, x2 >> 16, x1 >> 16, z2, depthSlope);
				z2 += depthScale;
				x1 += dx3;
				x2 += dx2;
				y2 += DrawingArea.width;
			}
			return;
		}
		if(y3 >= DrawingArea.clipBottom) {
			return;
		}
		if(y1 > DrawingArea.clipBottom) {
			y1 = DrawingArea.clipBottom;
		}
		if(y2 > DrawingArea.clipBottom) {
			y2 = DrawingArea.clipBottom;
		}
		z3 = z3 - depthSlope * x3 + depthSlope;
		if(y1 < y2) {
			x2 = x3 <<= 16;
			if(y3 < 0) {
				x2 -= dx2 * y3;
				x3 -= dx3 * y3;
				z3 -= depthScale * y3;
				y3 = 0;
			}
			x1 <<= 16;
			if(y1 < 0) {
				x1 -= dx1 * y1;
				y1 = 0;
			}
			if(dx2 < dx3) {
				y2 -= y1;
				y1 -= y3;
				for(y3 = anIntArray1472[y3]; --y1 >= 0; y3 += DrawingArea.width) {
					drawFlatScanline(DrawingArea.pixels, y3, rgb, x2 >> 16, x3 >> 16, z3, depthSlope);
					z3 += depthScale;
					x2 += dx2;
					x3 += dx3;
				}
				while(--y2 >= 0) {
					drawFlatScanline(DrawingArea.pixels, y3, rgb, x2 >> 16, x1 >> 16, z3, depthSlope);
					z3 += depthScale;
					x2 += dx2;
					x1 += dx1;
					y3 += DrawingArea.width;
				}
				return;
			}
			y2 -= y1;
			y1 -= y3;
			for(y3 = anIntArray1472[y3]; --y1 >= 0; y3 += DrawingArea.width) {
				drawFlatScanline(DrawingArea.pixels, y3, rgb, x3 >> 16, x2 >> 16, z3, depthSlope);
				z3 += depthScale;
				x2 += dx2;
				x3 += dx3;
			}
			while(--y2 >= 0) {
				drawFlatScanline(DrawingArea.pixels, y3, rgb, x1 >> 16, x2 >> 16, z3, depthSlope);
				z3 += depthScale;
				x2 += dx2;
				x1 += dx1;
				y3 += DrawingArea.width;
			}
			return;
		}
		x1 = x3 <<= 16;
		if(y3 < 0) {
			x1 -= dx2 * y3;
			x3 -= dx3 * y3;
			z3 -= depthScale * y3;
			y3 = 0;
		}
		x2 <<= 16;
		if(y2 < 0) {
			x2 -= dx1 * y2;
			y2 = 0;
		}
		if(dx2 < dx3) {
			y1 -= y2;
			y2 -= y3;
			for(y3 = anIntArray1472[y3]; --y2 >= 0; y3 += DrawingArea.width) {
				drawFlatScanline(DrawingArea.pixels, y3, rgb, x1 >> 16, x3 >> 16, z3, depthSlope);
				z3 += depthScale;
				x1 += dx2;
				x3 += dx3;
			}
			while(--y1 >= 0) {
				drawFlatScanline(DrawingArea.pixels, y3, rgb, x2 >> 16, x3 >> 16, z3, depthSlope);
				z3 += depthScale;
				x2 += dx1;
				x3 += dx3;
				y3 += DrawingArea.width;
			}
			return;
		}
		y1 -= y2;
		y2 -= y3;
		for(y3 = anIntArray1472[y3]; --y2 >= 0; y3 += DrawingArea.width) {
			drawFlatScanline(DrawingArea.pixels, y3, rgb, x3 >> 16, x1 >> 16, z3, depthSlope);
			z3 += depthScale;
			x1 += dx2;
			x3 += dx3;
		}
		while(--y1 >= 0) {
			drawFlatScanline(DrawingArea.pixels, y3, rgb, x3 >> 16, x2 >> 16, z3, depthSlope);
			z3 += depthScale;
			x2 += dx1;
			x3 += dx3;
			y3 += DrawingArea.width;
		}
	}

	private static void drawFlatScanline(int dest[], int offset, int rgb, int x1, int x2, float z1, float z2) {
		if(aBoolean1462) {
			if(x2 > DrawingArea.viewportRX) {
				x2 = DrawingArea.viewportRX;
			}
			if(x1 < 0) {
				x1 = 0;
			}
		}
		if(x1 >= x2) {
			return;
		}
		offset += x1;
		z1 += z2 * x1;
		int len = x2 - x1 >> 2;
		if(anInt1465 == 0) {
			while(--len >= 0)  {
				if (z1 < depthBuffer[offset]) {
					dest[offset] = rgb;
					depthBuffer[offset] = z1;
				}
				z1 += z2;
				offset++;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = rgb;
					depthBuffer[offset] = z1;
				}
				z1 += z2;
				offset++;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = rgb;
					depthBuffer[offset] = z1;
				}
				z1 += z2;
				offset++;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = rgb;
					depthBuffer[offset] = z1;
				}
				z1 += z2;
				offset++;
			}
			for(len = x2 - x1 & 3; --len >= 0;) {
				if (z1 < depthBuffer[offset]) {
					dest[offset] = rgb;
					depthBuffer[offset] = z1;
				}
				z1 += z2;
				offset++;
			}
			return;
		}
		int a1 = anInt1465;
		int a2 = 256 - anInt1465;
		rgb = ((rgb & 0xff00ff) * a2 >> 8 & 0xff00ff) + ((rgb & 0xff00) * a2 >> 8 & 0xff00);
		while(--len >= 0) {
			if (z1 < depthBuffer[offset]) {
				dest[offset] = rgb + ((dest[offset] & 0xff00ff) * a1 >> 8 & 0xff00ff) + ((dest[offset] & 0xff00) * a1 >> 8 & 0xff00);
				if (anInt1465 < 200) {
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
			if (z1 < depthBuffer[offset]) {
				dest[offset] = rgb + ((dest[offset] & 0xff00ff) * a1 >> 8 & 0xff00ff) + ((dest[offset] & 0xff00) * a1 >> 8 & 0xff00);
				if (anInt1465 < 200) {
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
			if (z1 < depthBuffer[offset]) {
				dest[offset] = rgb + ((dest[offset] & 0xff00ff) * a1 >> 8 & 0xff00ff) + ((dest[offset] & 0xff00) * a1 >> 8 & 0xff00);
				if (anInt1465 < 200) {
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
			if (z1 < depthBuffer[offset]) {
				dest[offset] = rgb + ((dest[offset] & 0xff00ff) * a1 >> 8 & 0xff00ff) + ((dest[offset] & 0xff00) * a1 >> 8 & 0xff00);
				if (anInt1465 < 200) {
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
		}
		for(len = x2 - x1 & 3; --len >= 0;) {
			if (z1 < depthBuffer[offset]) {
				dest[offset] = rgb + ((dest[offset] & 0xff00ff) * a1 >> 8 & 0xff00ff) + ((dest[offset] & 0xff00) * a1 >> 8 & 0xff00);
				if (anInt1465 < 200) {
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
		}
	}

	private static void drawTexturedTriangle(int y1, int y2, int y3, int x1, int x2, int x3, int c1, int c2, int c3, int tx1, int tx2, int tx3, int ty1, int ty2, int ty3, int tz1, int tz2, int tz3, int tex) {
		c1 = 0x7f - c1 << 1;
		c2 = 0x7f - c2 << 1;
		c3 = 0x7f - c3 << 1;
		int ai[] = method371(tex);
		aBoolean1463 = !aBooleanArray1475[tex];
		tx2 = tx1 - tx2;
		ty2 = ty1 - ty2;
		tz2 = tz1 - tz2;
		tx3 -= tx1;
		ty3 -= ty1;
		tz3 -= tz1;
		int l4 = tx3 * ty1 - ty3 * tx1 << 14;
		int i5 = ty3 * tz1 - tz3 * ty1 << 8;
		int j5 = tz3 * tx1 - tx3 * tz1 << 5;
		int k5 = tx2 * ty1 - ty2 * tx1 << 14;
		int l5 = ty2 * tz1 - tz2 * ty1 << 8;
		int i6 = tz2 * tx1 - tx2 * tz1 << 5;
		int j6 = ty2 * tx3 - tx2 * ty3 << 14;
		int k6 = tz2 * ty3 - ty2 * tz3 << 8;
		int l6 = tx2 * tz3 - tz2 * tx3 << 5;
		int i7 = 0;
		int j7 = 0;
		if(y2 != y1)
		{
			i7 = (x2 - x1 << 16) / (y2 - y1);
			j7 = (c2 - c1 << 16) / (y2 - y1);
		}
		int k7 = 0;
		int l7 = 0;
		if(y3 != y2)
		{
			k7 = (x3 - x2 << 16) / (y3 - y2);
			l7 = (c3 - c2 << 16) / (y3 - y2);
		}
		int i8 = 0;
		int j8 = 0;
		if(y3 != y1)
		{
			i8 = (x1 - x3 << 16) / (y1 - y3);
			j8 = (c1 - c3 << 16) / (y1 - y3);
		}
		if(y1 <= y2 && y1 <= y3)
		{
			if(y1 >= DrawingArea.clipBottom)
				return;
			if(y2 > DrawingArea.clipBottom)
				y2 = DrawingArea.clipBottom;
			if(y3 > DrawingArea.clipBottom)
				y3 = DrawingArea.clipBottom;
			if(y2 < y3)
			{
				x3 = x1 <<= 16;
				c3 = c1 <<= 16;
				if(y1 < 0)
				{
					x3 -= i8 * y1;
					x1 -= i7 * y1;
					c3 -= j8 * y1;
					c1 -= j7 * y1;
					y1 = 0;
				}
				x2 <<= 16;
				c2 <<= 16;
				if(y2 < 0)
				{
					x2 -= k7 * y2;
					c2 -= l7 * y2;
					y2 = 0;
				}
				int k8 = y1 - textureInt2;
				l4 += j5 * k8;
				k5 += i6 * k8;
				j6 += l6 * k8;
				if(y1 != y2 && i8 < i7 || y1 == y2 && i8 > k7)
				{
					y3 -= y2;
					y2 -= y1;
					y1 = anIntArray1472[y1];
					while(--y2 >= 0)
					{
						drawTexturedScanline(DrawingArea.pixels, ai, y1, x3 >> 16, x1 >> 16, c3, c1, l4, k5, j6, i5, l5, k6);
						x3 += i8;
						x1 += i7;
						c3 += j8;
						c1 += j7;
						y1 += DrawingArea.width;
						l4 += j5;
						k5 += i6;
						j6 += l6;
					}
					while(--y3 >= 0)
					{
						drawTexturedScanline(DrawingArea.pixels, ai, y1, x3 >> 16, x2 >> 16, c3, c2, l4, k5, j6, i5, l5, k6);
						x3 += i8;
						x2 += k7;
						c3 += j8;
						c2 += l7;
						y1 += DrawingArea.width;
						l4 += j5;
						k5 += i6;
						j6 += l6;
					}
					return;
				}
				y3 -= y2;
				y2 -= y1;
				y1 = anIntArray1472[y1];
				while(--y2 >= 0)
				{
					drawTexturedScanline(DrawingArea.pixels, ai, y1, x1 >> 16, x3 >> 16, c1, c3, l4, k5, j6, i5, l5, k6);
					x3 += i8;
					x1 += i7;
					c3 += j8;
					c1 += j7;
					y1 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while(--y3 >= 0)
				{
					drawTexturedScanline(DrawingArea.pixels, ai, y1, x2 >> 16, x3 >> 16, c2, c3, l4, k5, j6, i5, l5, k6);
					x3 += i8;
					x2 += k7;
					c3 += j8;
					c2 += l7;
					y1 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				return;
			}
			x2 = x1 <<= 16;
			c2 = c1 <<= 16;
			if(y1 < 0)
			{
				x2 -= i8 * y1;
				x1 -= i7 * y1;
				c2 -= j8 * y1;
				c1 -= j7 * y1;
				y1 = 0;
			}
			x3 <<= 16;
			c3 <<= 16;
			if(y3 < 0)
			{
				x3 -= k7 * y3;
				c3 -= l7 * y3;
				y3 = 0;
			}
			int l8 = y1 - textureInt2;
			l4 += j5 * l8;
			k5 += i6 * l8;
			j6 += l6 * l8;
			if(y1 != y3 && i8 < i7 || y1 == y3 && k7 > i7)
			{
				y2 -= y3;
				y3 -= y1;
				y1 = anIntArray1472[y1];
				while(--y3 >= 0)
				{
					drawTexturedScanline(DrawingArea.pixels, ai, y1, x2 >> 16, x1 >> 16, c2, c1, l4, k5, j6, i5, l5, k6);
					x2 += i8;
					x1 += i7;
					c2 += j8;
					c1 += j7;
					y1 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while(--y2 >= 0)
				{
					drawTexturedScanline(DrawingArea.pixels, ai, y1, x3 >> 16, x1 >> 16, c3, c1, l4, k5, j6, i5, l5, k6);
					x3 += k7;
					x1 += i7;
					c3 += l7;
					c1 += j7;
					y1 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				return;
			}
			y2 -= y3;
			y3 -= y1;
			y1 = anIntArray1472[y1];
			while(--y3 >= 0)
			{
				drawTexturedScanline(DrawingArea.pixels, ai, y1, x1 >> 16, x2 >> 16, c1, c2, l4, k5, j6, i5, l5, k6);
				x2 += i8;
				x1 += i7;
				c2 += j8;
				c1 += j7;
				y1 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			while(--y2 >= 0)
			{
				drawTexturedScanline(DrawingArea.pixels, ai, y1, x1 >> 16, x3 >> 16, c1, c3, l4, k5, j6, i5, l5, k6);
				x3 += k7;
				x1 += i7;
				c3 += l7;
				c1 += j7;
				y1 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			return;
		}
		if(y2 <= y3)
		{
			if(y2 >= DrawingArea.clipBottom)
				return;
			if(y3 > DrawingArea.clipBottom)
				y3 = DrawingArea.clipBottom;
			if(y1 > DrawingArea.clipBottom)
				y1 = DrawingArea.clipBottom;
			if(y3 < y1)
			{
				x1 = x2 <<= 16;
				c1 = c2 <<= 16;
				if(y2 < 0)
				{
					x1 -= i7 * y2;
					x2 -= k7 * y2;
					c1 -= j7 * y2;
					c2 -= l7 * y2;
					y2 = 0;
				}
				x3 <<= 16;
				c3 <<= 16;
				if(y3 < 0)
				{
					x3 -= i8 * y3;
					c3 -= j8 * y3;
					y3 = 0;
				}
				int i9 = y2 - textureInt2;
				l4 += j5 * i9;
				k5 += i6 * i9;
				j6 += l6 * i9;
				if(y2 != y3 && i7 < k7 || y2 == y3 && i7 > i8)
				{
					y1 -= y3;
					y3 -= y2;
					y2 = anIntArray1472[y2];
					while(--y3 >= 0)
					{
						drawTexturedScanline(DrawingArea.pixels, ai, y2, x1 >> 16, x2 >> 16, c1, c2, l4, k5, j6, i5, l5, k6);
						x1 += i7;
						x2 += k7;
						c1 += j7;
						c2 += l7;
						y2 += DrawingArea.width;
						l4 += j5;
						k5 += i6;
						j6 += l6;
					}
					while(--y1 >= 0)
					{
						drawTexturedScanline(DrawingArea.pixels, ai, y2, x1 >> 16, x3 >> 16, c1, c3, l4, k5, j6, i5, l5, k6);
						x1 += i7;
						x3 += i8;
						c1 += j7;
						c3 += j8;
						y2 += DrawingArea.width;
						l4 += j5;
						k5 += i6;
						j6 += l6;
					}
					return;
				}
				y1 -= y3;
				y3 -= y2;
				y2 = anIntArray1472[y2];
				while(--y3 >= 0)
				{
					drawTexturedScanline(DrawingArea.pixels, ai, y2, x2 >> 16, x1 >> 16, c2, c1, l4, k5, j6, i5, l5, k6);
					x1 += i7;
					x2 += k7;
					c1 += j7;
					c2 += l7;
					y2 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while(--y1 >= 0)
				{
					drawTexturedScanline(DrawingArea.pixels, ai, y2, x3 >> 16, x1 >> 16, c3, c1, l4, k5, j6, i5, l5, k6);
					x1 += i7;
					x3 += i8;
					c1 += j7;
					c3 += j8;
					y2 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				return;
			}
			x3 = x2 <<= 16;
			c3 = c2 <<= 16;
			if(y2 < 0)
			{
				x3 -= i7 * y2;
				x2 -= k7 * y2;
				c3 -= j7 * y2;
				c2 -= l7 * y2;
				y2 = 0;
			}
			x1 <<= 16;
			c1 <<= 16;
			if(y1 < 0)
			{
				x1 -= i8 * y1;
				c1 -= j8 * y1;
				y1 = 0;
			}
			int j9 = y2 - textureInt2;
			l4 += j5 * j9;
			k5 += i6 * j9;
			j6 += l6 * j9;
			if(i7 < k7)
			{
				y3 -= y1;
				y1 -= y2;
				y2 = anIntArray1472[y2];
				while(--y1 >= 0)
				{
					drawTexturedScanline(DrawingArea.pixels, ai, y2, x3 >> 16, x2 >> 16, c3, c2, l4, k5, j6, i5, l5, k6);
					x3 += i7;
					x2 += k7;
					c3 += j7;
					c2 += l7;
					y2 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while(--y3 >= 0)
				{
					drawTexturedScanline(DrawingArea.pixels, ai, y2, x1 >> 16, x2 >> 16, c1, c2, l4, k5, j6, i5, l5, k6);
					x1 += i8;
					x2 += k7;
					c1 += j8;
					c2 += l7;
					y2 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				return;
			}
			y3 -= y1;
			y1 -= y2;
			y2 = anIntArray1472[y2];
			while(--y1 >= 0)
			{
				drawTexturedScanline(DrawingArea.pixels, ai, y2, x2 >> 16, x3 >> 16, c2, c3, l4, k5, j6, i5, l5, k6);
				x3 += i7;
				x2 += k7;
				c3 += j7;
				c2 += l7;
				y2 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			while(--y3 >= 0)
			{
				drawTexturedScanline(DrawingArea.pixels, ai, y2, x2 >> 16, x1 >> 16, c2, c1, l4, k5, j6, i5, l5, k6);
				x1 += i8;
				x2 += k7;
				c1 += j8;
				c2 += l7;
				y2 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			return;
		}
		if(y3 >= DrawingArea.clipBottom)
			return;
		if(y1 > DrawingArea.clipBottom)
			y1 = DrawingArea.clipBottom;
		if(y2 > DrawingArea.clipBottom)
			y2 = DrawingArea.clipBottom;
		if(y1 < y2)
		{
			x2 = x3 <<= 16;
			c2 = c3 <<= 16;
			if(y3 < 0)
			{
				x2 -= k7 * y3;
				x3 -= i8 * y3;
				c2 -= l7 * y3;
				c3 -= j8 * y3;
				y3 = 0;
			}
			x1 <<= 16;
			c1 <<= 16;
			if(y1 < 0)
			{
				x1 -= i7 * y1;
				c1 -= j7 * y1;
				y1 = 0;
			}
			int k9 = y3 - textureInt2;
			l4 += j5 * k9;
			k5 += i6 * k9;
			j6 += l6 * k9;
			if(k7 < i8)
			{
				y2 -= y1;
				y1 -= y3;
				y3 = anIntArray1472[y3];
				while(--y1 >= 0)
				{
					drawTexturedScanline(DrawingArea.pixels, ai, y3, x2 >> 16, x3 >> 16, c2, c3, l4, k5, j6, i5, l5, k6);
					x2 += k7;
					x3 += i8;
					c2 += l7;
					c3 += j8;
					y3 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while(--y2 >= 0)
				{
					drawTexturedScanline(DrawingArea.pixels, ai, y3, x2 >> 16, x1 >> 16, c2, c1, l4, k5, j6, i5, l5, k6);
					x2 += k7;
					x1 += i7;
					c2 += l7;
					c1 += j7;
					y3 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				return;
			}
			y2 -= y1;
			y1 -= y3;
			y3 = anIntArray1472[y3];
			while(--y1 >= 0)
			{
				drawTexturedScanline(DrawingArea.pixels, ai, y3, x3 >> 16, x2 >> 16, c3, c2, l4, k5, j6, i5, l5, k6);
				x2 += k7;
				x3 += i8;
				c2 += l7;
				c3 += j8;
				y3 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			while(--y2 >= 0)
			{
				drawTexturedScanline(DrawingArea.pixels, ai, y3, x1 >> 16, x2 >> 16, c1, c2, l4, k5, j6, i5, l5, k6);
				x2 += k7;
				x1 += i7;
				c2 += l7;
				c1 += j7;
				y3 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			return;
		}
		x1 = x3 <<= 16;
		c1 = c3 <<= 16;
		if(y3 < 0)
		{
			x1 -= k7 * y3;
			x3 -= i8 * y3;
			c1 -= l7 * y3;
			c3 -= j8 * y3;
			y3 = 0;
		}
		x2 <<= 16;
		c2 <<= 16;
		if(y2 < 0)
		{
			x2 -= i7 * y2;
			c2 -= j7 * y2;
			y2 = 0;
		}
		int l9 = y3 - textureInt2;
		l4 += j5 * l9;
		k5 += i6 * l9;
		j6 += l6 * l9;
		if(k7 < i8)
		{
			y1 -= y2;
			y2 -= y3;
			y3 = anIntArray1472[y3];
			while(--y2 >= 0)
			{
				drawTexturedScanline(DrawingArea.pixels, ai, y3, x1 >> 16, x3 >> 16, c1, c3, l4, k5, j6, i5, l5, k6);
				x1 += k7;
				x3 += i8;
				c1 += l7;
				c3 += j8;
				y3 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			while(--y1 >= 0)
			{
				drawTexturedScanline(DrawingArea.pixels, ai, y3, x2 >> 16, x3 >> 16, c2, c3, l4, k5, j6, i5, l5, k6);
				x2 += i7;
				x3 += i8;
				c2 += j7;
				c3 += j8;
				y3 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			return;
		}
		y1 -= y2;
		y2 -= y3;
		y3 = anIntArray1472[y3];
		while(--y2 >= 0)
		{
			drawTexturedScanline(DrawingArea.pixels, ai, y3, x3 >> 16, x1 >> 16, c3, c1, l4, k5, j6, i5, l5, k6);
			x1 += k7;
			x3 += i8;
			c1 += l7;
			c3 += j8;
			y3 += DrawingArea.width;
			l4 += j5;
			k5 += i6;
			j6 += l6;
		}
		while(--y1 >= 0)
		{
			drawTexturedScanline(DrawingArea.pixels, ai, y3, x3 >> 16, x2 >> 16, c3, c2, l4, k5, j6, i5, l5, k6);
			x2 += i7;
			x3 += i8;
			c2 += j7;
			c3 += j8;
			y3 += DrawingArea.width;
			l4 += j5;
			k5 += i6;
			j6 += l6;
		}
	}

	private static void drawTexturedScanline(int ai[], int ai1[], int k, int x1, int x2, int l1,
											 int l2, int a1, int i2, int j2, int k2, int a2, int i3)
	{
		int i = 0;//was parameter
		int j = 0;//was parameter
		if(x1 >= x2)
			return;
		int dl = (l2 - l1) / (x2 - x1);
		int n;
		if(aBoolean1462)
		{
			if(x2 > DrawingArea.viewportRX)
				x2 = DrawingArea.viewportRX;
			if(x1 < 0)
			{
				l1 -= x1 * dl;
				x1 = 0;
			}
		}
		if(x1 >= x2)
			return;
		n = x2 - x1 >> 3;
		k += x1;
		int j4 = 0;
		int l4 = 0;
		int l6 = x1 - textureInt1;
		a1 += (k2 >> 3) * l6;
		i2 += (a2 >> 3) * l6;
		j2 += (i3 >> 3) * l6;
		int l5 = j2 >> 14;
		if(l5 != 0)
		{
			i = a1 / l5;
			j = i2 / l5;
			if(i < 0)
				i = 0;
			else
			if(i > 16256)
				i = 16256;
		}
		a1 += k2;
		i2 += a2;
		j2 += i3;
		l5 = j2 >> 14;
		if(l5 != 0)
		{
			j4 = a1 / l5;
			l4 = i2 / l5;
			if(j4 < 7)
				j4 = 7;
			else
			if(j4 > 16256)
				j4 = 16256;
		}
		int j7 = j4 - i >> 3;
		int l7 = l4 - j >> 3;
		if(aBoolean1463)
		{
			while(n-- > 0)
			{
				int rgb;
				int l;
				rgb = ai1[(j & 0x3f80) + (i >> 7)];
				l = l1 >> 16;
				ai[k++] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
				i += j7;
				j += l7;
				l1 += dl;
				rgb = ai1[(j & 0x3f80) + (i >> 7)];
				l = l1 >> 16;
				ai[k++] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
				i += j7;
				j += l7;
				l1 += dl;
				rgb = ai1[(j & 0x3f80) + (i >> 7)];
				l = l1 >> 16;
				ai[k++] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
				i += j7;
				j += l7;
				l1 += dl;
				rgb = ai1[(j & 0x3f80) + (i >> 7)];
				l = l1 >> 16;
				ai[k++] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
				i += j7;
				j += l7;
				l1 += dl;
				rgb = ai1[(j & 0x3f80) + (i >> 7)];
				l = l1 >> 16;
				ai[k++] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
				i += j7;
				j += l7;
				l1 += dl;
				rgb = ai1[(j & 0x3f80) + (i >> 7)];
				l = l1 >> 16;
				ai[k++] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
				i += j7;
				j += l7;
				l1 += dl;
				rgb = ai1[(j & 0x3f80) + (i >> 7)];
				l = l1 >> 16;
				ai[k++] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
				i += j7;
				j += l7;
				l1 += dl;
				rgb = ai1[(j & 0x3f80) + (i >> 7)];
				l = l1 >> 16;
				ai[k++] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
				i += j7;
				j += l7;
				l1 += dl;
				a1 += k2;
				i2 += a2;
				j2 += i3;
				int i6 = j2 >> 14;
				if(i6 != 0)
				{
					j4 = a1 / i6;
					l4 = i2 / i6;
					if(j4 < 7)
						j4 = 7;
					else
					if(j4 > 16256)
						j4 = 16256;
				}
				j7 = j4 - i >> 3;
				l7 = l4 - j >> 3;
				l1 += dl;
			}
			for(n = x2 - x1 & 7; n-- > 0;)
			{
				int rgb;
				int l;
				rgb = ai1[(j & 0x3f80) + (i >> 7)];
				l = l1 >> 16;
				ai[k++] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
				i += j7;
				j += l7;
				l1 += dl;
			}

			return;
		}
		while(n-- > 0)
		{
			int i9;
			int l;
			if((i9 = ai1[(j & 0x3f80) + (i >> 7)]) != 0) {
				l = l1 >> 16;
				ai[k] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;;
			}
			k++;
			i += j7;
			j += l7;
			l1 += dl;
			if((i9 = ai1[(j & 0x3f80) + (i >> 7)]) != 0) {
				l = l1 >> 16;
				ai[k] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;;
			}
			k++;
			i += j7;
			j += l7;
			l1 += dl;
			if((i9 = ai1[(j & 0x3f80) + (i >> 7)]) != 0) {
				l = l1 >> 16;
				ai[k] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;;
			}
			k++;
			i += j7;
			j += l7;
			l1 += dl;
			if((i9 = ai1[(j & 0x3f80) + (i >> 7)]) != 0) {
				l = l1 >> 16;
				ai[k] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;;
			}
			k++;
			i += j7;
			j += l7;
			l1 += dl;
			if((i9 = ai1[(j & 0x3f80) + (i >> 7)]) != 0) {
				l = l1 >> 16;
				ai[k] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;;
			}
			k++;
			i += j7;
			j += l7;
			l1 += dl;
			if((i9 = ai1[(j & 0x3f80) + (i >> 7)]) != 0) {
				l = l1 >> 16;
				ai[k] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;;
			}
			k++;
			i += j7;
			j += l7;
			l1 += dl;
			if((i9 = ai1[(j & 0x3f80) + (i >> 7)]) != 0) {
				l = l1 >> 16;
				ai[k] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;;
			}
			k++;
			i += j7;
			j += l7;
			l1 += dl;
			if((i9 = ai1[(j & 0x3f80) + (i >> 7)]) != 0) {
				l = l1 >> 16;
				ai[k] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;;
			}
			k++;
			i += j7;
			j += l7;
			l1 += dl;
			a1 += k2;
			i2 += a2;
			j2 += i3;
			int j6 = j2 >> 14;
			if(j6 != 0)
			{
				j4 = a1 / j6;
				l4 = i2 / j6;
				if(j4 < 7)
					j4 = 7;
				else
				if(j4 > 16256)
					j4 = 16256;
			}
			j7 = j4 - i >> 3;
			l7 = l4 - j >> 3;
			l1 += dl;
		}
		for(int l3 = x2 - x1 & 7; l3-- > 0;)
		{
			int j9;
			int l;
			if((j9 = ai1[(j & 0x3f80) + (i >> 7)]) != 0) {
				l = l1 >> 16;
				ai[k] = ((j9 & 0xff00ff) * l & ~0xff00ff) + ((j9 & 0xff00) * l & 0xff0000) >> 8;;
			}
			k++;
			i += j7;
			j += l7;
			l1 += dl;
		}

	}

	public static void drawTexturedTriangle(int y1, int y2, int y3, int x1, int x2, int x3, int c1, int c2, int c3, int tx1, int tx2, int tx3, int ty1, int ty2, int ty3, int tz1, int tz2, int tz3, int tex, float z1, float z2, float z3) {
		if (!aBoolean1464) {
			drawTexturedTriangle(y1, y2, y3, x1, x2, x3, c1, c2, c3, tx1, tx2, tx3, ty1, ty2, ty3, tz1, tz2, tz3, tex);
			return;
		}
		c1 = 0x7f - c1 << 1;
		c2 = 0x7f - c2 << 1;
		c3 = 0x7f - c3 << 1;
		int texels[] = method371(tex);
		aBoolean1463 = !aBooleanArray1475[tex];
		tx2 = tx1 - tx2;
		ty2 = ty1 - ty2;
		tz2 = tz1 - tz2;
		tx3 -= tx1;
		ty3 -= ty1;
		tz3 -= tz1;
		int l4 = (tx3 * ty1 - ty3 * tx1) * WorldController.focalLength << 5;
		int i5 = ty3 * tz1 - tz3 * ty1 << 8;
		int j5 = tz3 * tx1 - tx3 * tz1 << 5;
		int k5 = (tx2 * ty1 - ty2 * tx1) * WorldController.focalLength << 5;
		int l5 = ty2 * tz1 - tz2 * ty1 << 8;
		int i6 = tz2 * tx1 - tx2 * tz1 << 5;
		int j6 = (ty2 * tx3 - tx2 * ty3) * WorldController.focalLength << 5;
		int k6 = tz2 * ty3 - ty2 * tz3 << 8;
		int l6 = tx2 * tz3 - tz2 * tx3 << 5;
		int i7 = 0;
		int j7 = 0;
		if (y2 != y1) {
			i7 = (x2 - x1 << 16) / (y2 - y1);
			j7 = (c2 - c1 << 16) / (y2 - y1);
		}
		int k7 = 0;
		int l7 = 0;
		if (y3 != y2) {
			k7 = (x3 - x2 << 16) / (y3 - y2);
			l7 = (c3 - c2 << 16) / (y3 - y2);
		}
		int i8 = 0;
		int j8 = 0;
		if (y3 != y1) {
			i8 = (x1 - x3 << 16) / (y1 - y3);
			j8 = (c1 - c3 << 16) / (y1 - y3);
		}

		float x21 = x2 - x1;
		float y32 = y2 - y1;
		float x31 = x3 - x1;
		float y31 = y3 - y1;
		float z21 = z2 - z1;
		float z31 = z3 - z1;

		float div = x21 * y31 - x31 * y32;
		float depthSlope = (z21 * y31 - z31 * y32) / div;
		float depthScale = (z31 * x21 - z21 * x31) / div;

		if (y1 <= y2 && y1 <= y3) {
			if (y1 >= DrawingArea.clipBottom) {
				return;
			}
			if (y2 > DrawingArea.clipBottom) {
				y2 = DrawingArea.clipBottom;
			}
			if (y3 > DrawingArea.clipBottom) {
				y3 = DrawingArea.clipBottom;
			}
			z1 = z1 - depthSlope * x1 + depthSlope;
			if (y2 < y3) {
				x3 = x1 <<= 16;
				c3 = c1 <<= 16;
				if (y1 < 0) {
					x3 -= i8 * y1;
					x1 -= i7 * y1;
					z1 -= depthScale * y1;
					c3 -= j8 * y1;
					c1 -= j7 * y1;
					y1 = 0;
				}
				x2 <<= 16;
				c2 <<= 16;
				if (y2 < 0) {
					x2 -= k7 * y2;
					c2 -= l7 * y2;
					y2 = 0;
				}
				int k8 = y1 - textureInt2;
				l4 += j5 * k8;
				k5 += i6 * k8;
				j6 += l6 * k8;
				if (y1 != y2 && i8 < i7 || y1 == y2 && i8 > k7) {
					y3 -= y2;
					y2 -= y1;
					y1 = anIntArray1472[y1];
					while (--y2 >= 0) {
						drawTexturedScanline(DrawingArea.pixels, texels, y1, x3 >> 16, x1 >> 16, c3, c1, l4, k5, j6, i5, l5, k6, z1, depthSlope);
						z1 += depthScale;
						x3 += i8;
						x1 += i7;
						c3 += j8;
						c1 += j7;
						y1 += DrawingArea.width;
						l4 += j5;
						k5 += i6;
						j6 += l6;
					}
					while (--y3 >= 0) {
						drawTexturedScanline(DrawingArea.pixels, texels, y1, x3 >> 16, x2 >> 16, c3, c2, l4, k5, j6, i5, l5, k6, z1, depthSlope);
						z1 += depthScale;
						x3 += i8;
						x2 += k7;
						c3 += j8;
						c2 += l7;
						y1 += DrawingArea.width;
						l4 += j5;
						k5 += i6;
						j6 += l6;
					}
					return;
				}
				y3 -= y2;
				y2 -= y1;
				y1 = anIntArray1472[y1];
				while (--y2 >= 0) {
					drawTexturedScanline(DrawingArea.pixels, texels, y1, x1 >> 16, x3 >> 16, c1, c3, l4, k5, j6, i5, l5, k6, z1, depthSlope);
					z1 += depthScale;
					x3 += i8;
					x1 += i7;
					c3 += j8;
					c1 += j7;
					y1 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while (--y3 >= 0) {
					drawTexturedScanline(DrawingArea.pixels, texels, y1, x2 >> 16, x3 >> 16, c2, c3, l4, k5, j6, i5, l5, k6, z1, depthSlope);
					z1 += depthScale;
					x3 += i8;
					x2 += k7;
					c3 += j8;
					c2 += l7;
					y1 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				return;
			}
			x2 = x1 <<= 16;
			c2 = c1 <<= 16;
			if (y1 < 0) {
				x2 -= i8 * y1;
				z1 -= depthScale * y1;
				x1 -= i7 * y1;
				c2 -= j8 * y1;
				c1 -= j7 * y1;
				y1 = 0;
			}
			x3 <<= 16;
			c3 <<= 16;
			if (y3 < 0) {
				x3 -= k7 * y3;
				c3 -= l7 * y3;
				y3 = 0;
			}
			int l8 = y1 - textureInt2;
			l4 += j5 * l8;
			k5 += i6 * l8;
			j6 += l6 * l8;
			if (y1 != y3 && i8 < i7 || y1 == y3 && k7 > i7) {
				y2 -= y3;
				y3 -= y1;
				y1 = anIntArray1472[y1];
				while (--y3 >= 0) {
					drawTexturedScanline(DrawingArea.pixels, texels, y1, x2 >> 16, x1 >> 16, c2, c1, l4, k5, j6, i5, l5, k6, z1, depthSlope);
					z1 += depthScale;
					x2 += i8;
					x1 += i7;
					c2 += j8;
					c1 += j7;
					y1 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while (--y2 >= 0) {
					drawTexturedScanline(DrawingArea.pixels, texels, y1, x3 >> 16, x1 >> 16, c3, c1, l4, k5, j6, i5, l5, k6, z1, depthSlope);
					z1 += depthScale;
					x3 += k7;
					x1 += i7;
					c3 += l7;
					c1 += j7;
					y1 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				return;
			}
			y2 -= y3;
			y3 -= y1;
			y1 = anIntArray1472[y1];
			while (--y3 >= 0) {
				drawTexturedScanline(DrawingArea.pixels, texels, y1, x1 >> 16, x2 >> 16, c1, c2, l4, k5, j6, i5, l5, k6, z1, depthSlope);
				z1 += depthScale;
				x2 += i8;
				x1 += i7;
				c2 += j8;
				c1 += j7;
				y1 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			while (--y2 >= 0) {
				drawTexturedScanline(DrawingArea.pixels, texels, y1, x1 >> 16, x3 >> 16, c1, c3, l4, k5, j6, i5, l5, k6, z1, depthSlope);
				z1 += depthScale;
				x3 += k7;
				x1 += i7;
				c3 += l7;
				c1 += j7;
				y1 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			return;
		}
		if (y2 <= y3) {
			if (y2 >= DrawingArea.clipBottom) {
				return;
			}
			if (y3 > DrawingArea.clipBottom) {
				y3 = DrawingArea.clipBottom;
			}
			if (y1 > DrawingArea.clipBottom) {
				y1 = DrawingArea.clipBottom;
			}
			z2 = z2 - depthSlope * x2 + depthSlope;
			if (y3 < y1) {
				x1 = x2 <<= 16;
				c1 = c2 <<= 16;
				if (y2 < 0) {
					x1 -= i7 * y2;
					x2 -= k7 * y2;
					z2 -= depthScale * y2;
					c1 -= j7 * y2;
					c2 -= l7 * y2;
					y2 = 0;
				}
				x3 <<= 16;
				c3 <<= 16;
				if (y3 < 0) {
					x3 -= i8 * y3;
					c3 -= j8 * y3;
					y3 = 0;
				}
				int i9 = y2 - textureInt2;
				l4 += j5 * i9;
				k5 += i6 * i9;
				j6 += l6 * i9;
				if (y2 != y3 && i7 < k7 || y2 == y3 && i7 > i8) {
					y1 -= y3;
					y3 -= y2;
					y2 = anIntArray1472[y2];
					while (--y3 >= 0) {
						drawTexturedScanline(DrawingArea.pixels, texels, y2, x1 >> 16, x2 >> 16, c1, c2, l4, k5, j6, i5, l5, k6, z2, depthSlope);
						z2 += depthScale;
						x1 += i7;
						x2 += k7;
						c1 += j7;
						c2 += l7;
						y2 += DrawingArea.width;
						l4 += j5;
						k5 += i6;
						j6 += l6;
					}
					while (--y1 >= 0) {
						drawTexturedScanline(DrawingArea.pixels, texels, y2, x1 >> 16, x3 >> 16, c1, c3, l4, k5, j6, i5, l5, k6, z2, depthSlope);
						z2 += depthScale;
						x1 += i7;
						x3 += i8;
						c1 += j7;
						c3 += j8;
						y2 += DrawingArea.width;
						l4 += j5;
						k5 += i6;
						j6 += l6;
					}
					return;
				}
				y1 -= y3;
				y3 -= y2;
				y2 = anIntArray1472[y2];
				while (--y3 >= 0) {
					drawTexturedScanline(DrawingArea.pixels, texels, y2, x2 >> 16, x1 >> 16, c2, c1, l4, k5, j6, i5, l5, k6, z2, depthSlope);
					z2 += depthScale;
					x1 += i7;
					x2 += k7;
					c1 += j7;
					c2 += l7;
					y2 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while (--y1 >= 0) {
					drawTexturedScanline(DrawingArea.pixels, texels, y2, x3 >> 16, x1 >> 16, c3, c1, l4, k5, j6, i5, l5, k6, z2, depthSlope);
					z2 += depthScale;
					x1 += i7;
					x3 += i8;
					c1 += j7;
					c3 += j8;
					y2 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				return;
			}
			x3 = x2 <<= 16;
			c3 = c2 <<= 16;
			if (y2 < 0) {
				x3 -= i7 * y2;
				z2 -= depthScale * y2;
				x2 -= k7 * y2;
				c3 -= j7 * y2;
				c2 -= l7 * y2;
				y2 = 0;
			}
			x1 <<= 16;
			c1 <<= 16;
			if (y1 < 0) {
				x1 -= i8 * y1;
				c1 -= j8 * y1;
				y1 = 0;
			}
			int j9 = y2 - textureInt2;
			l4 += j5 * j9;
			k5 += i6 * j9;
			j6 += l6 * j9;
			if (i7 < k7) {
				y3 -= y1;
				y1 -= y2;
				y2 = anIntArray1472[y2];
				while (--y1 >= 0) {
					drawTexturedScanline(DrawingArea.pixels, texels, y2, x3 >> 16, x2 >> 16, c3, c2, l4, k5, j6, i5, l5, k6, z2, depthSlope);
					z2 += depthScale;
					x3 += i7;
					x2 += k7;
					c3 += j7;
					c2 += l7;
					y2 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while (--y3 >= 0) {
					drawTexturedScanline(DrawingArea.pixels, texels, y2, x1 >> 16, x2 >> 16, c1, c2, l4, k5, j6, i5, l5, k6, z2, depthSlope);
					z2 += depthScale;
					x1 += i8;
					x2 += k7;
					c1 += j8;
					c2 += l7;
					y2 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				return;
			}
			y3 -= y1;
			y1 -= y2;
			y2 = anIntArray1472[y2];
			while (--y1 >= 0) {
				drawTexturedScanline(DrawingArea.pixels, texels, y2, x2 >> 16, x3 >> 16, c2, c3, l4, k5, j6, i5, l5, k6, z2, depthSlope);
				z2 += depthScale;
				x3 += i7;
				x2 += k7;
				c3 += j7;
				c2 += l7;
				y2 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			while (--y3 >= 0) {
				drawTexturedScanline(DrawingArea.pixels, texels, y2, x2 >> 16, x1 >> 16, c2, c1, l4, k5, j6, i5, l5, k6, z2, depthSlope);
				z2 += depthScale;
				x1 += i8;
				x2 += k7;
				c1 += j8;
				c2 += l7;
				y2 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			return;
		}
		if (y3 >= DrawingArea.clipBottom) {
			return;
		}
		if (y1 > DrawingArea.clipBottom) {
			y1 = DrawingArea.clipBottom;
		}
		if (y2 > DrawingArea.clipBottom) {
			y2 = DrawingArea.clipBottom;
		}
		z3 = z3 - depthSlope * x3 + depthSlope;
		if (y1 < y2) {
			x2 = x3 <<= 16;
			c2 = c3 <<= 16;
			if (y3 < 0) {
				x2 -= k7 * y3;
				x3 -= i8 * y3;
				z3 -= depthScale * y3;
				c2 -= l7 * y3;
				c3 -= j8 * y3;
				y3 = 0;
			}
			x1 <<= 16;
			c1 <<= 16;
			if (y1 < 0) {
				x1 -= i7 * y1;
				c1 -= j7 * y1;
				y1 = 0;
			}
			int k9 = y3 - textureInt2;
			l4 += j5 * k9;
			k5 += i6 * k9;
			j6 += l6 * k9;
			if (k7 < i8) {
				y2 -= y1;
				y1 -= y3;
				y3 = anIntArray1472[y3];
				while (--y1 >= 0) {
					drawTexturedScanline(DrawingArea.pixels, texels, y3, x2 >> 16, x3 >> 16, c2, c3, l4, k5, j6, i5, l5, k6, z3, depthSlope);
					z3 += depthScale;
					x2 += k7;
					x3 += i8;
					c2 += l7;
					c3 += j8;
					y3 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				while (--y2 >= 0) {
					drawTexturedScanline(DrawingArea.pixels, texels, y3, x2 >> 16, x1 >> 16, c2, c1, l4, k5, j6, i5, l5, k6, z3, depthSlope);
					z3 += depthScale;
					x2 += k7;
					x1 += i7;
					c2 += l7;
					c1 += j7;
					y3 += DrawingArea.width;
					l4 += j5;
					k5 += i6;
					j6 += l6;
				}
				return;
			}
			y2 -= y1;
			y1 -= y3;
			y3 = anIntArray1472[y3];
			while (--y1 >= 0) {
				drawTexturedScanline(DrawingArea.pixels, texels, y3, x3 >> 16, x2 >> 16, c3, c2, l4, k5, j6, i5, l5, k6, z3, depthSlope);
				z3 += depthScale;
				x2 += k7;
				x3 += i8;
				c2 += l7;
				c3 += j8;
				y3 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			while (--y2 >= 0) {
				drawTexturedScanline(DrawingArea.pixels, texels, y3, x1 >> 16, x2 >> 16, c1, c2, l4, k5, j6, i5, l5, k6, z3, depthSlope);
				z3 += depthScale;
				x2 += k7;
				x1 += i7;
				c2 += l7;
				c1 += j7;
				y3 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			return;
		}
		x1 = x3 <<= 16;
		c1 = c3 <<= 16;
		if (y3 < 0) {
			x1 -= k7 * y3;
			x3 -= i8 * y3;
			z3 -= depthScale * y3;
			c1 -= l7 * y3;
			c3 -= j8 * y3;
			y3 = 0;
		}
		x2 <<= 16;
		c2 <<= 16;
		if (y2 < 0) {
			x2 -= i7 * y2;
			c2 -= j7 * y2;
			y2 = 0;
		}
		int l9 = y3 - textureInt2;
		l4 += j5 * l9;
		k5 += i6 * l9;
		j6 += l6 * l9;
		if (k7 < i8) {
			y1 -= y2;
			y2 -= y3;
			y3 = anIntArray1472[y3];
			while (--y2 >= 0) {
				drawTexturedScanline(DrawingArea.pixels, texels, y3, x1 >> 16, x3 >> 16, c1, c3, l4, k5, j6, i5, l5, k6, z3, depthSlope);
				z3 += depthScale;
				x1 += k7;
				x3 += i8;
				c1 += l7;
				c3 += j8;
				y3 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			while (--y1 >= 0) {
				drawTexturedScanline(DrawingArea.pixels, texels, y3, x2 >> 16, x3 >> 16, c2, c3, l4, k5, j6, i5, l5, k6, z3, depthSlope);
				z3 += depthScale;
				x2 += i7;
				x3 += i8;
				c2 += j7;
				c3 += j8;
				y3 += DrawingArea.width;
				l4 += j5;
				k5 += i6;
				j6 += l6;
			}
			return;
		}
		y1 -= y2;
		y2 -= y3;
		y3 = anIntArray1472[y3];
		while (--y2 >= 0) {
			drawTexturedScanline(DrawingArea.pixels, texels, y3, x3 >> 16, x1 >> 16, c3, c1, l4, k5, j6, i5, l5, k6, z3, depthSlope);
			z3 += depthScale;
			x1 += k7;
			x3 += i8;
			c1 += l7;
			c3 += j8;
			y3 += DrawingArea.width;
			l4 += j5;
			k5 += i6;
			j6 += l6;
		}
		while (--y1 >= 0) {
			drawTexturedScanline(DrawingArea.pixels, texels, y3, x3 >> 16, x2 >> 16, c3, c2, l4, k5, j6, i5, l5, k6, z3, depthSlope);
			z3 += depthScale;
			x2 += i7;
			x3 += i8;
			c2 += j7;
			c3 += j8;
			y3 += DrawingArea.width;
			l4 += j5;
			k5 += i6;
			j6 += l6;
		}
	}

	private static void drawTexturedScanline(int dest[], int src[], int offset, int x1, int x2, int hsl1, int hsl2, int t1, int t2, int t3, int t4, int t5, int t6, float z1, float z2) {
		int darken = 0;
		int srcPos = 0;
		if(x1 >= x2) {
			return;
		}
		int dl = (hsl2 - hsl1) / (x2 - x1);
		int n;
		if(aBoolean1462) {
			if(x2 > DrawingArea.viewportRX) {
				x2 = DrawingArea.viewportRX;
			}
			if(x1 < 0) {
				hsl1 -= x1 * dl;
				x1 = 0;
			}
		}
		if(x1 >= x2) {
			return;
		}
		n = x2 - x1 >> 3;
		offset += x1;
		z1 += z2 * x1;
		int j4 = 0;
		int l4 = 0;
		int l6 = x1 - textureInt1;
		t1 += (t4 >> 3) * l6;
		t2 += (t5 >> 3) * l6;
		t3 += (t6 >> 3) * l6;
		int l5 = t3 >> 14;
		if(l5 != 0) {
			darken = t1 / l5;
			srcPos = t2 / l5;
			if(darken < 0) {
				darken = 0;
			} else if(darken > 16256) {
				darken = 16256;
			}
		}
		t1 += t4;
		t2 += t5;
		t3 += t6;
		l5 = t3 >> 14;
		if(l5 != 0) {
			j4 = t1 / l5;
			l4 = t2 / l5;
			if(j4 < 7) {
				j4 = 7;
			} else if(j4 > 16256) {
				j4 = 16256;
			}
		}
		int j7 = j4 - darken >> 3;
		int l7 = l4 - srcPos >> 3;
		if(aBoolean1463) {
			while(n-- > 0) {
				int rgb;
				int l;
				rgb = src[(srcPos & 0x3f80) + (darken >> 7)];
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
				offset++;
				z1 += z2;
				darken += j7;
				srcPos += l7;
				hsl1 += dl;
				rgb = src[(srcPos & 0x3f80) + (darken >> 7)];
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
				offset++;
				z1 += z2;
				darken += j7;
				srcPos += l7;
				hsl1 += dl;
				rgb = src[(srcPos & 0x3f80) + (darken >> 7)];
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
				offset++;
				z1 += z2;
				darken += j7;
				srcPos += l7;
				hsl1 += dl;
				rgb = src[(srcPos & 0x3f80) + (darken >> 7)];
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
				offset++;
				z1 += z2;
				darken += j7;
				srcPos += l7;
				hsl1 += dl;
				rgb = src[(srcPos & 0x3f80) + (darken >> 7)];
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
				offset++;
				z1 += z2;
				darken += j7;
				srcPos += l7;
				hsl1 += dl;
				rgb = src[(srcPos & 0x3f80) + (darken >> 7)];
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
				offset++;
				z1 += z2;
				darken += j7;
				srcPos += l7;
				hsl1 += dl;
				rgb = src[(srcPos & 0x3f80) + (darken >> 7)];
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
				offset++;
				z1 += z2;
				darken += j7;
				srcPos += l7;
				hsl1 += dl;
				rgb = src[(srcPos & 0x3f80) + (darken >> 7)];
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
				offset++;
				z1 += z2;
				darken += j7;
				srcPos += l7;
				hsl1 += dl;
				t1 += t4;
				t2 += t5;
				t3 += t6;
				int i6 = t3 >> 14;
				if(i6 != 0) {
					j4 = t1 / i6;
					l4 = t2 / i6;
					if(j4 < 7) {
						j4 = 7;
					} else if(j4 > 16256) {
						j4 = 16256;
					}
				}
				j7 = j4 - darken >> 3;
				l7 = l4 - srcPos >> 3;
				hsl1 += dl;
			}
			for(n = x2 - x1 & 7; n-- > 0;) {
				int rgb;
				int l;
				rgb = src[(srcPos & 0x3f80) + (darken >> 7)];
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((rgb & 0xff00ff) * l & ~0xff00ff) + ((rgb & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
				z1 += z2;
				offset++;
				darken += j7;
				srcPos += l7;
				hsl1 += dl;
			}
			return;
		}
		while(n-- > 0) {
			int i9;
			int l;
			if((i9 = src[(srcPos & 0x3f80) + (darken >> 7)]) != 0) {
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
			darken += j7;
			srcPos += l7;
			hsl1 += dl;
			if((i9 = src[(srcPos & 0x3f80) + (darken >> 7)]) != 0) {
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
			darken += j7;
			srcPos += l7;
			hsl1 += dl;
			if((i9 = src[(srcPos & 0x3f80) + (darken >> 7)]) != 0) {
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
			darken += j7;
			srcPos += l7;
			hsl1 += dl;
			if((i9 = src[(srcPos & 0x3f80) + (darken >> 7)]) != 0) {
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
			darken += j7;
			srcPos += l7;
			hsl1 += dl;
			if((i9 = src[(srcPos & 0x3f80) + (darken >> 7)]) != 0) {
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
			darken += j7;
			srcPos += l7;
			hsl1 += dl;
			if((i9 = src[(srcPos & 0x3f80) + (darken >> 7)]) != 0) {
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
			darken += j7;
			srcPos += l7;
			hsl1 += dl;
			if((i9 = src[(srcPos & 0x3f80) + (darken >> 7)]) != 0) {
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
			darken += j7;
			srcPos += l7;
			hsl1 += dl;
			if((i9 = src[(srcPos & 0x3f80) + (darken >> 7)]) != 0) {
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((i9 & 0xff00ff) * l & ~0xff00ff) + ((i9 & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
			darken += j7;
			srcPos += l7;
			hsl1 += dl;
			t1 += t4;
			t2 += t5;
			t3 += t6;
			int j6 = t3 >> 14;
			if(j6 != 0) {
				j4 = t1 / j6;
				l4 = t2 / j6;
				if(j4 < 7) {
					j4 = 7;
				} else if(j4 > 16256) {
					j4 = 16256;
				}
			}
			j7 = j4 - darken >> 3;
			l7 = l4 - srcPos >> 3;
			hsl1 += dl;
		}
		for(int l3 = x2 - x1 & 7; l3-- > 0;) {
			int j9;
			int l;
			if((j9 = src[(srcPos & 0x3f80) + (darken >> 7)]) != 0) {
				l = hsl1 >> 16;
				if (z1 < depthBuffer[offset]) {
					dest[offset] = ((j9 & 0xff00ff) * l & ~0xff00ff) + ((j9 & 0xff00) * l & 0xff0000) >> 8;
					depthBuffer[offset] = z1;
				}
			}
			z1 += z2;
			offset++;
			darken += j7;
			srcPos += l7;
			hsl1 += dl;
		}
	}
}
