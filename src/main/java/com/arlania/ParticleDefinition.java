package com.arlania;

import java.util.Random;

public class ParticleDefinition {

	public static final Random RANDOM = new Random(System.currentTimeMillis());
	
	private ParticleVector gravity;
	

	
	private float startSize = 1f;
	private float endSize = 1f;
	
	public int particleDepth;
	
	private int startColor = -1;
	private int firstColor = -1;
	private int secondColor = -1;
	private int thirdColor = -1;
	private int fourthColor = -1;
	private int fifthColor = -1;
	private boolean changingColors;
	private int endColor = -1;
	
	private ParticleVector startVelocity = ParticleVector.ZERO;
	private ParticleVector endVelocity = ParticleVector.ZERO;
	
	private SpawnShape spawnShape = new PointSpawnShape(ParticleVector.ZERO);
	
	private float startAlpha = 1f;
	private float endAlpha = 0.05f;
	
	private int lifeSpan = 1;
	private int spawnRate = 1;
	private Sprite sprite;
	private ParticleVector velocityStep;
	private int colorStep;
	private float sizeStep;
	private float alphaStep;
	public int colorIndex = 0;
	public int[] colors;
	
	public void setColors(int... colors) {
		this.colors = colors;
	}
	
	public boolean hasChangingColors() {
		return changingColors;
	}
	
	public void setChangingColors() {
		changingColors = true;
	}
	
	public int getNextColor() {
		int index = colorIndex++ % colors.length;
		int color = colors[index];
		return color;
	}
	
	public void increaseColor() {
		if(++colorIndex >= colors.length) {
		    colorIndex = 0;
		}
	}
	
	public int getColor() {
		return colors[colorIndex];
	}
	
	public boolean areColorsSet() {
		return colors != null;
	}
	
	public static ParticleDefinition[] cache = new ParticleDefinition[] {
			new ParticleDefinition() { {
				//Completionist Cape
				setStartVelocity(new ParticleVector(0, -2, 0));
				setEndVelocity(new ParticleVector(0, -2, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(19); // 19
				setStartColor(0x2b569b);
				setSpawnRate(4);
				setStartSize(1.25f);
				setEndSize(0);
				setStartAlpha(0.095f);
				initializeSteps();
				setColorStep(0x000000);}//which cape is it?
			},
			new ParticleDefinition() { {
				//Trimmed Completionist Cape
				setStartVelocity(new ParticleVector(0, -2, 0));
				setEndVelocity(new ParticleVector(0, -2, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(19);
				setStartColor(0xFFD900);
				setSpawnRate(4);
				setStartSize(1.25f);
				setEndSize(0);
				setStartAlpha(0.095f);
				initializeSteps();
				setColorStep(0x000000);}
			},
			new ParticleDefinition() { {
				//Max Cape
				setStartVelocity(new ParticleVector(1, -1, 1));
				setEndVelocity(new ParticleVector(1, -1, 1));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(19);
				setStartColor(0x96D0E3);
				setSpawnRate(1);
				setStartSize(1.7f);
				setEndSize(0);
				setStartAlpha(0.100f);
				initializeSteps();
				setColorStep(0x000000); }
			},
			new ParticleDefinition() { {
				//Master Dung. Cape
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(19);
				setStartColor(0x000000);
				setSpawnRate(4);
				setStartSize(1.25f);
				setEndSize(0.11f);
				setStartAlpha(0.020f);
				initializeSteps();
				setColorStep(0x000000); }
			},
			
			new ParticleDefinition() { {
				//Custom Infernal Cape
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(40);
				setSpawnRate(1);
				setStartColor(0xFF8C00);
				setStartSize(1.0f);
				setEndSize(0);
				setStartAlpha(0.1f);
				initializeSteps();
				setColorStep(0x000000);
				//setChangingColors();
				//hasChangingColors();
				//setFirstColor(0xFF0000);
				//setSecondColor(0x7CFC00);
				//setThirdColor(0x800080);
				//setFourthColor(0x371789);
				//setFifthColor(0x53f3fc);
				//setColors(new int[] {0xFF0000, 0x7CFC00, 0x800080, 0x371789, 0x53f3fc});
				}
			},
			
			new ParticleDefinition() { {
				//Custom Sled
				setStartVelocity(new ParticleVector(1, -1, 0));
				setEndVelocity(new ParticleVector(1, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(250);
				setStartColor(0x691fd1);
				setSpawnRate(1);
				setStartSize(1.7f);
				setEndSize(0);
				setStartAlpha(0.100f);
				initializeSteps();
				setColorStep(0x000000); }
			},
			new ParticleDefinition() { {
				//Primordials
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(40);
				setStartColor(0x4f0303);
				setSpawnRate(1);
				setStartSize(0.7f);
				setEndSize(0);
				setStartAlpha(0.100f);
				initializeSteps();
				setColorStep(0x000000); }
			},
			new ParticleDefinition() { {
				//Infernal Wings
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(19);
				setStartColor(0xe04014);
				setSpawnRate(1);
				setStartSize(0.6f);
				setEndSize(0);
				setStartAlpha(0.100f);
				initializeSteps();
				setColorStep(0x000000); }
			},
			new ParticleDefinition() { {
			// Custom Infernal staff
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(75);
				setStartColor(0xe04014);
				//setEndColor(0x000000);
				setSpawnRate(1);
				setStartSize(1.1f);
				setEndSize(0);
				setStartAlpha(0.100f);
				initializeSteps();
				//christmas colors :D how do u know
				setColors(new int[] {0xfc780c, 0xe58209, 0xffa332, 0xce7a12, 0xdb4d1a, 0xff4300, 0xe57a22});
	}
	},
			new ParticleDefinition() { {
			// Custom Infernal staff
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(50);
				setStartColor(0xf71d04);
				//setEndColor(0x000000);
				setSpawnRate(1);
				setStartSize(1.05f);
				setEndSize(0);
				setStartAlpha(0.100f);
				initializeSteps();
				//christmas colors :D how do u know
				setColors(new int[] {0xf71d04, 0xed230b, 0xb59b98});
			}
	},
			
			new ParticleDefinition() { {
				//Primordials
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(30);
				setStartColor(0xf98518);
				setSpawnRate(1);
				setStartSize(0.55f);
				setEndSize(0);
				setStartAlpha(0.100f);
				initializeSteps();
				setColorStep(0x000000); }
	},
			
			new ParticleDefinition() { {
				//Pegasians
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(40);
				setStartColor(0x2f8c42);
				setSpawnRate(1);
				setStartSize(0.7f);
				setEndSize(0);
				setStartAlpha(0.100f);
				initializeSteps();
				setColorStep(0x000000); }
			},
			
			new ParticleDefinition() { {
				//Primordials
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(30);
				setStartColor(0x7ec0ee);
				setSpawnRate(1);
				setStartSize(0.55f);
				setEndSize(0);
				setStartAlpha(0.100f);
				initializeSteps();
				setColorStep(0x000000);
				}
	},
			
			new ParticleDefinition() { {
				//Custom Cape Texturized
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(141);
				setStartColor(0xf21515);
				setEndColor(0x000000);
				setSpawnRate(1);
				setStartSize(1.2f);
				setEndSize(0);
				setStartAlpha(0.1f);
				initializeSteps();
				setColorStep(0x000000);
				}
			},
			
			new ParticleDefinition() { {
				//Custom Boots Texturized
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(135);
				setStartColor(0xf21515);
				//setEndColor(0x000000);
				setSpawnRate(1);
				setStartSize(1.1f);
				setEndSize(0);
				setStartAlpha(0.1f);
				initializeSteps();
				setColors(new int[] {0xf21515, 0x8c2525, 0x725e5e});
				}
			},
			
			new ParticleDefinition() { {
				//Custom Gloves Texturized
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(48);
				setStartColor(0xf21515);
				//setEndColor(0x000000);
				setSpawnRate(1);
				setStartSize(0.85f);
				setEndSize(0);
				setStartAlpha(0.1f);
				initializeSteps();
				setColors(new int[] {0xf21515, 0x8c2525, 0x725e5e});
				}
			},
			
			new ParticleDefinition() { {
				//Custom Gloves Texturized Infernal
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(48);
				setStartColor(0xed8c17);
				//setEndColor(0x000000);
				setSpawnRate(1);
				setStartSize(0.85f);
				setEndSize(0);
				setStartAlpha(0.1f);
				initializeSteps();
				setColors(new int[] {0x66615b, 0x66615b, 0xed8c17});
				}
			},
			
			new ParticleDefinition() { {
				//Custom Gloves Texturized Infernal
				setStartVelocity(new ParticleVector(0, -1, 0));
				setEndVelocity(new ParticleVector(0, -1, 0));
				setGravity(new ParticleVector(0, 2 / 4, 0));
				setLifeSpan(300);
				setStartColor(0xed8c17);
				//setEndColor(0x000000);
				setSpawnRate(1);
				setStartSize(0.85f);
				setEndSize(0);
				setStartAlpha(0.1f);
				initializeSteps();
				setColors(new int[] {0x66615b, 0x66615b, 0xed8c17});
				}
			},
	};
	
	public final SpawnShape getSpawnedShape() {
		return spawnShape;
	}

	public final float getStartAlpha() {
		return startAlpha;
	}

	public final void setStartAlpha(float startAlpha) {
		this.startAlpha = startAlpha;
	}

	public final float getAlphaStep() {
		return alphaStep;
	}

	public final Sprite getSprite() {
		return sprite;
	}

	public final void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public final int getSpawnRate() {
		return this.spawnRate;
	}

	public final void setSpawnRate(int spawnRate) {
		this.spawnRate = spawnRate;
	}
	
	public final void setStartSize(float startSize) {
		this.startSize = startSize;
	}
	
	public final float getStartSize() {
		return startSize;
	}
	
	public float getEndSize() {
		return endSize;
	}
	
    public int getEndColor() {
        return endColor;
    }

	public final void setEndSize(float endSize) {
		this.endSize = endSize;
	}

	public final int getStartColor() {
		return startColor;
	}
	
	public final int getFirstColor() {
		return firstColor;
	}
	
	public final int getSecondColor() {
		return secondColor;
	}
	
	public final int getThirdColor() {
		return thirdColor;
	}
	
	public final int getFourthColor() {
		return fourthColor;
	}
	
	public final int getFifthColor() {
		return fifthColor;
	}
	
	public final void setFirstColor(int firstColor) {
		this.firstColor = firstColor;
	}
	
	public final void setSecondColor(int secondColor) {
		this.secondColor = secondColor;
	}
	
	public final void setThirdColor(int thirdColor) {
		this.thirdColor = thirdColor;
	}
	
	public final void setFourthColor(int fourthColor) {
		this.fourthColor = fourthColor;
	}
	
	public final void setFifthColor(int fifthColor) {
		this.fifthColor = fifthColor;
	}


	public final void setStartColor(int startColor) {
		this.startColor = startColor;
	}
	
	public final void setEndColor(int endColor) {
		this.endColor = endColor;
	}
	
	public int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
	
	public final ParticleVector getStartVelocity(int id) {
		switch (id) {
		default:
			return new ParticleVector(this.startVelocity.getX() + randomWithRange(-1, 1), this.startVelocity.getY() + randomWithRange(0, 0), this.startVelocity.getZ() + randomWithRange(-1, 1));
		}
	}
	
    public ParticleVector getGravity() {
        return gravity;
    }


    public void setGravity(ParticleVector gravity) {
        this.gravity = gravity;
    }

	public final void setStartVelocity(ParticleVector startVelocity) {
		this.startVelocity = startVelocity;
	}
	
    public ParticleVector getEndVelocity() {
        return endVelocity;
    }

	public final void setEndVelocity(ParticleVector endVelocity) {
		this.endVelocity = endVelocity;
	}

	public final int getLifeSpan() {
		return lifeSpan;
	}

	public final void setLifeSpan(int lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public final void setColorStep(int colorStep) {
		this.colorStep = colorStep;
	}

	public final float getSizeStep() {
		return sizeStep;
	}

	public final ParticleVector getVelocityStep() {
		return velocityStep;
	}

	public final int getColorStep() {
		return colorStep;
	}
	
	public void redrawParticle() {
		this.velocityStep = endVelocity.subtract(startVelocity).divide(lifeSpan);
		this.alphaStep = (endAlpha - startAlpha) / lifeSpan;
		this.sizeStep = (endSize - startSize) / (lifeSpan * 1f);
	}

	public void initializeSteps() {
		
		this.sizeStep = (endSize - startSize) / (lifeSpan * 1f);
		this.colorStep = (endColor - startColor) / lifeSpan;
		this.velocityStep = endVelocity.subtract(startVelocity).divide(lifeSpan);
		this.alphaStep = (endAlpha - startAlpha) / lifeSpan;
	}
}