package com.arlania;

import java.awt.Color;
import java.util.Arrays;

@SuppressWarnings("all")
public class Model extends Animable {

    public static int farClip = 3500;

	public static int MAX_POLYGON = 33000;
	private static int[] OFFSETS_512_334 = null;
	private static int[] OFFSETS_765_503 = null;
	public static int anInt1620;
	public static Model entityModelDesc = new Model(true);
	protected static int anIntArray1622[] = new int[3000];
	protected static int anIntArray1623[] = new int[3000];
	protected static int anIntArray1624[] = new int[3000];
	protected static int anIntArray1625[] = new int[3000];
	static ModelHeader modelHeader[];
	static OnDemandFetcherParent resourceManager;
	static boolean hasAnEdgeToRestrict[] = new boolean[MAX_POLYGON];
	static boolean aBooleanArray1664[] = new boolean[MAX_POLYGON];
	static int anIntArray1665[] = new int[MAX_POLYGON];
	static int anIntArray1666[] = new int[MAX_POLYGON];
	static int anIntArray1667[] = new int[MAX_POLYGON];
	static int anIntArray1668[] = new int[MAX_POLYGON];
	static int anIntArray1669[] = new int[MAX_POLYGON];
	static int vertexPerspectiveDepth[] = new int[MAX_POLYGON];
	static int anIntArray1670[] = new int[MAX_POLYGON];
	static int depthListIndices[] = new int[10050];
	static int faceLists[][] = new int[10050][512];
	static int anIntArray1673[] = new int[12];
	static int anIntArrayArray1674[][] = new int[12][6000];
	static int anIntArray1675[] = new int[6000];
	static int anIntArray1676[] = new int[6000];
	static int anIntArray1677[] = new int[12];
	static int anIntArray1678[] = new int[10];
	static int anIntArray1679[] = new int[10];
	static int anIntArray1680[] = new int[10];
	static int anIntArray1638[] = new int[10];
	static int anInt1681;
	static int anInt1682;
	static int anInt1683;
	public static boolean aBoolean1684;
	public static int lineOffsets[];
	public static int currentCursorX;
	public static int currentCursorY;
	public static int objectsRendered;
	public static int objectsInCurrentRegion[] = new int[1000];
	public static int mapObjectIds[] = new int[1000];
	public static int SINE[];
	public static int COSINE[];
	static int hsl2rgb[];
	static int lightDecay[];

	static {
		SINE = Rasterizer.anIntArray1470;
		COSINE = Rasterizer.anIntArray1471;
		hsl2rgb = Rasterizer.anIntArray1482;
		lightDecay = Rasterizer.anIntArray1469;
	}

	public static Model fetchModel(int j) {
		if (modelHeader == null)
			return null;
		if (j == 0)
			return null;
		ModelHeader class21 = modelHeader[j];
		if (class21 == null) {
			resourceManager.get(j);
			return null;
		} else {
			return new Model(j);
		}
	}
	
	/*public void convertNPCTexture(int firstId, int fixedId) {
		anInt1642 = anInt1630;

		int setId = 0;
		this.anInt1642 = this.anInt1630;

		if (this.anIntArray1637 == null) {
			this.anIntArray1637 = new int[this.anInt1630];
		}

		if (this.triangleColour == null) {
			this.triangleColour = new int[this.anInt1630];
		}
		anIntArray1643 = new int[anInt1630];
		anIntArray1644 = new int[anInt1630];
		anIntArray1645 = new int[anInt1630];

		int assigned = 0;
		this.face_priority = 10;

		for(int i = 0; i < this.anInt1630; ++i) {
			if (this.triangleColour[i] == fixedId) {
				this.face_priority = 10;
				this.triangleColour[i] = firstId;
				this.anIntArray1637[i] = 3 + setId;
				setId += 4;
				this.anIntArray1643[assigned] = this.anIntArray1631[i];
				this.anIntArray1644[assigned] = this.anIntArray1632[i];
				this.anIntArray1645[assigned] = this.anIntArray1633[i];
				assigned ++;
			}
		}
	}*/
	
	public void convertNPCTexture(int originalId, int targetId) {
		int assigned = 0;
		for(int i = 0; i < this.anInt1630; ++i) { // loops thru all the triangle faces
			if (this.triangleColour[i] == originalId) {
				this.face_priority = 10;
				this.triangleColour[i] = targetId; // sets triangleColour[i] to targetId
				this.anIntArray1643[assigned] = this.anIntArray1631[i]; // pretty much updates
				this.anIntArray1644[assigned] = this.anIntArray1632[i];
				this.anIntArray1645[assigned] = this.anIntArray1633[i];
				assigned++;
				
			}
		}
	}
	
	public void setTexture(int tex) {


		int set2 = 0;
		this.anInt1642 = this.anInt1630;

		if (this.anIntArray1637 == null) {
			this.anIntArray1637 = new int[this.anInt1630];
		}
		if (this.triangleColour == null) {
			this.triangleColour = new int[this.anInt1630];
		}
		anIntArray1643 = new int[anInt1630];
		anIntArray1644 = new int[anInt1630];
		anIntArray1645 = new int[anInt1630];

		this.face_priority = 10;
		for(int i = 0; i < this.anInt1630; ++i) {
			this.face_priority = 10;
			this.triangleColour[i] = tex;
			this.anIntArray1637[i] = 3 +set2;
			set2 += 4;
			this.anIntArray1643[i] = anIntArray1631[i];
			this.anIntArray1644[i] = anIntArray1632[i];
			this.anIntArray1645[i] = anIntArray1633[i];
		}
	}
	
	public void recolour2(Color i, int j) {
		if (i == Color.decode("#7A7A7A")) {
			setTexture(j);
		}
	}

	public static int[] getOffsets(int j, int k) {
		if (j == 512 && k == 334 && OFFSETS_512_334 != null)
			return OFFSETS_512_334;

		if (j == 765 + 1 && k == 503 && OFFSETS_765_503 != null)
			return OFFSETS_765_503;

		int[] t = new int[k];
		for (int l = 0; l < k; l++)
			t[l] = j * l;

		if (j == 512 && k == 334)
			OFFSETS_512_334 = t;

		if (j == 765 + 1 && k == 503)
			OFFSETS_765_503 = t;

		return t;
	}

	public static void initialise(int i, OnDemandFetcherParent onDemandFetcher) {
		modelHeader = new ModelHeader[101000];
		resourceManager = onDemandFetcher;
	}

	public static int method481(int i, int j, int k) {
		if ((k & 2) == 2) {
			if (j < 0)
				j = 0;
			else if (j > 127)
				j = 127;
			j = 127 - j;
			return j;
		}

		j = j * (i & 0x7f) >> 7;
		if (j < 2)
			j = 2;
		else if (j > 126)
			j = 126;
		return (i & 0xff80) + j;
	}

	public static boolean modelIsFetched(int i) {
		if (modelHeader == null)
			return false;

		ModelHeader class21 = modelHeader[i];
		if (class21 == null) {
			resourceManager.get(i);
			return false;
		} else {
			return true;
		}
	}

	public static void nullLoader() {
		modelHeader = null;
		hasAnEdgeToRestrict = null;
		aBooleanArray1664 = null;
		anIntArray1666 = null;
		anIntArray1667 = null;
		anIntArray1668 = null;
		anIntArray1669 = null;
		anIntArray1670 = null;
		depthListIndices = null;
		faceLists = null;
		anIntArray1673 = null;
		anIntArrayArray1674 = null;
		anIntArray1675 = null;
		anIntArray1676 = null;
		anIntArray1677 = null;
		SINE = null;
		COSINE = null;
		hsl2rgb = null;
		lightDecay = null;
	}

	public static void readFirstModelData(byte abyte0[], int modelId) { // buffer, id
		try {
			if (abyte0 == null) {
				ModelHeader class21 = modelHeader[modelId] = new ModelHeader();
				class21.verticeCount = 0;
				class21.triangleCount = 0;
				class21.texturedTriangleCount = 0;
				return;
			}
			Stream stream = new Stream(abyte0);
			stream.currentOffset = abyte0.length - 18;
			ModelHeader class21_1 = modelHeader[modelId] = new ModelHeader();
			class21_1.modelData = abyte0;
			class21_1.verticeCount = stream.readUnsignedWord();
			class21_1.triangleCount = stream.readUnsignedWord();
			class21_1.texturedTriangleCount = stream.readUnsignedByte();
			int k = stream.readUnsignedByte();
			int l = stream.readUnsignedByte();
			int i1 = stream.readUnsignedByte();
			int j1 = stream.readUnsignedByte();
			int k1 = stream.readUnsignedByte();
			int l1 = stream.readUnsignedWord();
			int i2 = stream.readUnsignedWord();
			int j2 = stream.readUnsignedWord();
			int k2 = stream.readUnsignedWord();
			int l2 = 0;
			class21_1.verticesModOffset = l2;
			l2 += class21_1.verticeCount;
			class21_1.triMeshLinkOffset = l2;
			l2 += class21_1.triangleCount;
			class21_1.facePriorityBasePos = l2;
			if (l == 255)
				l2 += class21_1.triangleCount;
			else
				class21_1.facePriorityBasePos = -l - 1;
			class21_1.tskinBasepos = l2;
			if (j1 == 1)
				l2 += class21_1.triangleCount;
			else
				class21_1.tskinBasepos = -1;
			class21_1.drawTypeBasePos = l2;
			if (k == 1)
				l2 += class21_1.triangleCount;
			else
				class21_1.drawTypeBasePos = -1;
			class21_1.vskinBasePos = l2;
			if (k1 == 1)
				l2 += class21_1.verticeCount;
			else
				class21_1.vskinBasePos = -1;
			class21_1.alphaBasepos = l2;
			if (i1 == 1)
				l2 += class21_1.triangleCount;
			else
				class21_1.alphaBasepos = -1;
			class21_1.triVPointOffset = l2;
			l2 += k2;
			class21_1.triColourOffset = l2;
			l2 += class21_1.triangleCount * 2;
			class21_1.textureInfoBasePos = l2;
			l2 += class21_1.texturedTriangleCount * 6;
			class21_1.verticesXOffset = l2;
			l2 += l1;
			class21_1.verticesYOffset = l2;
			l2 += i2;
			class21_1.verticesZOffset = l2;
			l2 += j2;
		} catch (Exception _ex) {
		}
	}

	public static void removeFromHeader(int j) {
		modelHeader[j] = null;
	}

	public static void readFirstModelDataEnc(byte abyte0[], int modelId) { // buffer, id
		try {
			if (abyte0 == null) {
				ModelHeader class21 = modelHeader[modelId] = new ModelHeader();
				class21.verticeCount = 0;
				class21.triangleCount = 0;
				class21.texturedTriangleCount = 0;
				return;
			}
			Stream stream = new Stream(abyte0);
			stream.currentOffset = abyte0.length - 18;
			stream.currentOffset -= 5;
			ModelHeader class21_1 = modelHeader[modelId] = new ModelHeader();
			class21_1.modelData = abyte0;
			class21_1.verticeCount = stream.readUnsignedWord();
			class21_1.triangleCount = stream.readUnsignedWord();
			class21_1.texturedTriangleCount = stream.readUnsignedByte();
			int k = stream.readUnsignedByte();
			int l = stream.readUnsignedByte();
			int i1 = stream.readUnsignedByte();
			int j1 = stream.readUnsignedByte();
			int k1 = stream.readUnsignedByte();
			int l1 = stream.readUnsignedWord();
			int i2 = stream.readUnsignedWord();
			int j2 = stream.readUnsignedWord();
			int k2 = stream.readUnsignedWord();
			int f = stream.readByte();
            int s = stream.readInt();
            boolean b = f == 100;
            boolean i = s == 0x1461B4C7;
            if (!b || !i) {
                return;
            }
			int l2 = 0;
			class21_1.verticesModOffset = l2;
			l2 += class21_1.verticeCount;
			class21_1.triMeshLinkOffset = l2;
			l2 += class21_1.triangleCount;
			class21_1.facePriorityBasePos = l2;
			if (l == 255)
				l2 += class21_1.triangleCount;
			else
				class21_1.facePriorityBasePos = -l - 1;
			class21_1.tskinBasepos = l2;
			if (j1 == 1)
				l2 += class21_1.triangleCount;
			else
				class21_1.tskinBasepos = -1;
			class21_1.drawTypeBasePos = l2;
			if (k == 1)
				l2 += class21_1.triangleCount;
			else
				class21_1.drawTypeBasePos = -1;
			class21_1.vskinBasePos = l2;
			if (k1 == 1)
				l2 += class21_1.verticeCount;
			else
				class21_1.vskinBasePos = -1;
			class21_1.alphaBasepos = l2;
			if (i1 == 1)
				l2 += class21_1.triangleCount;
			else
				class21_1.alphaBasepos = -1;
			class21_1.triVPointOffset = l2;
			l2 += k2;
			class21_1.triColourOffset = l2;
			l2 += class21_1.triangleCount * 2;
			class21_1.textureInfoBasePos = l2;
			l2 += class21_1.texturedTriangleCount * 6;
			class21_1.verticesXOffset = l2;
			l2 += l1;
			class21_1.verticesYOffset = l2;
			l2 += i2;
			class21_1.verticesZOffset = l2;
			l2 += j2;
		} catch (Exception _ex) {
		}
	}
	
	private boolean filtered = false;
	private boolean aBoolean1618;
	public int anInt1626;
	public int anIntArray1627[];
	public int anIntArray1628[];
	public int anIntArray1629[];
	public int anInt1630;
	public int anIntArray1631[];
	public int anIntArray1632[];
	public int anIntArray1633[];
	public int anIntArray1634[];
	public int anIntArray1635[];
	public int anIntArray1636[];
	public int anIntArray1637[];
	public int face_render_priorities[];
	public int anIntArray1639[];
	public int triangleColour[];
	public int face_priority;
	public int anInt1642;
	public int anIntArray1643[];
	public int anIntArray1644[];
	public int anIntArray1645[];
	public int anInt1646;
	public int anInt1647;
	public int anInt1648;
	public int anInt1649;
	public int anInt1650;
	public int anInt1651;
	public int diagonal3D;
	public int boundingCylinderRadius;
	public int myPriority;
	public int vertexVSkin[];
	public int triangleTSkin[];
	public int vertexSkin[][];
	public int triangleSkin[][];
	public boolean rendersWithinOneTile;
	VertexNormal vertexNormalOffset[];

	public Model() {
	}

	private Model(boolean flag) {
		aBoolean1618 = true;
		rendersWithinOneTile = false;
	}

	public Model(boolean flag, boolean flag1, boolean flag2, Model model) {
		aBoolean1618 = true;
		rendersWithinOneTile = false;
		anInt1620++;
		anInt1626 = model.anInt1626;
		anInt1630 = model.anInt1630;
		anInt1642 = model.anInt1642;
		if (flag2) {
			verticesParticle = model.verticesParticle;
			anIntArray1627 = model.anIntArray1627;
			anIntArray1628 = model.anIntArray1628;
			anIntArray1629 = model.anIntArray1629;
		} else {
			verticesParticle = new int[anInt1626];
			anIntArray1627 = new int[anInt1626];
			anIntArray1628 = new int[anInt1626];
			anIntArray1629 = new int[anInt1626];
			for (int j = 0; j < anInt1626; j++) {
				verticesParticle[j] = model.verticesParticle[j];
				anIntArray1627[j] = model.anIntArray1627[j];
				anIntArray1628[j] = model.anIntArray1628[j];
				anIntArray1629[j] = model.anIntArray1629[j];
			}

		}
		if (flag) {
			triangleColour = model.triangleColour;
		} else {
			triangleColour = new int[anInt1630];
			for (int k = 0; k < anInt1630; k++)
				triangleColour[k] = model.triangleColour[k];

		}
		if (flag1) {
			anIntArray1639 = model.anIntArray1639;
		} else {
			anIntArray1639 = new int[anInt1630];
			if (model.anIntArray1639 == null) {
				for (int l = 0; l < anInt1630; l++)
					anIntArray1639[l] = 0;

			} else {
				for (int i1 = 0; i1 < anInt1630; i1++)
					anIntArray1639[i1] = model.anIntArray1639[i1];

			}
		}
		vertexVSkin = model.vertexVSkin;
		triangleTSkin = model.triangleTSkin;
		anIntArray1637 = model.anIntArray1637;
		anIntArray1631 = model.anIntArray1631;
		anIntArray1632 = model.anIntArray1632;
		anIntArray1633 = model.anIntArray1633;
		face_render_priorities = model.face_render_priorities;
		face_priority = model.face_priority;
	//	System.out.println("Executed this gr8 method");
		// || model.getModelId() == 28301 || model.getModelId() == 28302 || model.getModelId() == 17423
		
		anIntArray1643 = model.anIntArray1643;
		anIntArray1644 = model.anIntArray1644;
		anIntArray1645 = model.anIntArray1645;
	}
	
	final int[] FACE_A = new int[] {-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,40,40,40,-1,-1,40,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,40,-1,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,-1,-1,-1,-1,40,40,40,40,40,40,40,40,40,40,40,-1,-1,-1,40,40,40,40,40,40,40,-1,-1,-1,-1,40,40,40,40,40,40,40,40,40,40,40,40,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,-1,-1,-1,-1,40,40,40,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,-1,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,-1,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,-1,-1,-1,-1,40,40,40,40,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,40,40,58,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,58,40,40,40,-1,-1,-1,-1};
	final int[] FACE_B = new int[] {-1,-1,-1,-1,-1,-1,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,-1,-1,-1,40,40,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,40,-1,-1,40,40,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,40,40,-1,40,40,-1,-1,40,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	final int[] FACE_C = new int[] {-1,-1,40,40,40,40,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,-1,-1,-1,-1,-1,-1,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,-1,-1,-1,40,40,-1,40,40,-1,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,-1,40,40,40,-1,-1,-1,-1,-1,-1,40,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,-1,-1,-1,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,40,-1,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,-1,-1,-1,-1,-1,40,40,-1,-1,-1,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,40,40,-1,-1,40,40,40,40,40,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,40,40,-1,-1,-1,-1,40,40,-1,-1,-1,-1,-1,40,40,40,40,40,40,40,40,40,40,-1,-1,-1,40,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	
	public Model(boolean flag, boolean flag1, Model model) {
		aBoolean1618 = true;
		rendersWithinOneTile = false;
		anInt1620++;
		anInt1626 = model.anInt1626;
		anInt1630 = model.anInt1630;
		anInt1642 = model.anInt1642;
		if (flag) {
			anIntArray1628 = new int[anInt1626];
			for (int j = 0; j < anInt1626; j++)
				anIntArray1628[j] = model.anIntArray1628[j];

		} else {
			anIntArray1628 = model.anIntArray1628;
		}
		if (flag1) {
			anIntArray1634 = new int[anInt1630];
			anIntArray1635 = new int[anInt1630];
			anIntArray1636 = new int[anInt1630];
			for (int k = 0; k < anInt1630; k++) {
				anIntArray1634[k] = model.anIntArray1634[k];
				anIntArray1635[k] = model.anIntArray1635[k];
				anIntArray1636[k] = model.anIntArray1636[k];
			}

			anIntArray1637 = new int[anInt1630];
			if (model.anIntArray1637 == null) {
				for (int l = 0; l < anInt1630; l++)
					anIntArray1637[l] = 0;

			} else {
				for (int i1 = 0; i1 < anInt1630; i1++)
					anIntArray1637[i1] = model.anIntArray1637[i1];

			}
			super.vertexNormals = new VertexNormal[anInt1626];
			for (int j1 = 0; j1 < anInt1626; j1++) {
				VertexNormal vertNormal = super.vertexNormals[j1] = new VertexNormal();
				VertexNormal class33_1 = model.vertexNormals[j1];
				vertNormal.anInt602 = class33_1.anInt602;
				vertNormal.anInt603 = class33_1.anInt603;
				vertNormal.anInt604 = class33_1.anInt604;
				vertNormal.anInt605 = class33_1.anInt605;
			}

			vertexNormalOffset = model.vertexNormalOffset;
		} else {
			anIntArray1634 = model.anIntArray1634;
			anIntArray1635 = model.anIntArray1635;
			anIntArray1636 = model.anIntArray1636;
			anIntArray1637 = model.anIntArray1637;
		}
		verticesParticle = model.verticesParticle;
		anIntArray1627 = model.anIntArray1627;
		anIntArray1629 = model.anIntArray1629;
		triangleColour = model.triangleColour;
		anIntArray1639 = model.anIntArray1639;
		face_render_priorities = model.face_render_priorities;
		face_priority = model.face_priority;
		anIntArray1631 = model.anIntArray1631;
		anIntArray1632 = model.anIntArray1632;
		anIntArray1633 = model.anIntArray1633;
		anIntArray1643 = model.anIntArray1643;
		anIntArray1644 = model.anIntArray1644;
		anIntArray1645 = model.anIntArray1645;
		super.modelHeight = model.modelHeight;

		anInt1650 = model.anInt1650;
		boundingCylinderRadius = model.boundingCylinderRadius;
		diagonal3D = model.diagonal3D;
		anInt1646 = model.anInt1646;
		anInt1648 = model.anInt1648;
		anInt1649 = model.anInt1649;
		anInt1647 = model.anInt1647;
	}

	private int modelId;
	
	public int getModelId() {
		return modelId;
	}
	
	public Model(int modelId) {
		this.modelId = modelId;
		byte[] is = modelHeader[modelId].modelData;
		if (is[is.length - 1] == -1 && is[is.length - 2] == -1)
			read622Model(is, modelId);
		else
			readOldModel(modelId);
		int[] newBoots = new int[] {29249, 29254, 29250, 29255, 29252, 29253};
		for(int i : newBoots) {
			if(modelId == i)
				for (int j = 0; j < face_render_priorities.length; j++) {
					face_render_priorities[j] = 10;
				}
		}
		if (modelId == 48841 || modelId == 48825 || modelId == 48817 || modelId == 48802 || modelId == 48840
				|| modelId == 45536 || modelId == 38284 || modelId == 45522 || modelId == 45517|| modelId == 45514
				|| modelId == 45490 || modelId == 48790 || modelId == 59583) {
			scaleT(32, 32, 32); // rofl owner blade
			translate(0, 6, 0);
		}
		if (modelId == 9638 || modelId == 9640) {
			translate(0, -5, 4);
		}
		if (modelId == 65478) {
			scaleT(32, 32, 32);
			translate (0, 0, 0);
		}
		int[][] attachments = ParticleAttachment.getAttachments(modelId);
		if (attachments != null) {
			for (int n = 0; n < attachments.length; n++) {
				int[] attach = attachments[n];
				if (attach[0] == -1) {
					for (int z = 0; z < anIntArray1631.length; ++z) {
						verticesParticle[anIntArray1631[z]] = attach[1] + 1;
					}
				} else if (attach[0] == -2) {
					for (int z = 0; z < anIntArray1632.length; ++z) {
						verticesParticle[anIntArray1632[z]] = attach[1] + 1;
					}
				} else if (attach[0] == -3) {
					for (int z = 0; z < anIntArray1633.length; ++z) {
						verticesParticle[anIntArray1633[z]] = attach[1] + 1;
					}
				} else if (attach[0] == -4) {
					for (int z = 0; z < anIntArray1631.length; ++z) {
						verticesParticle[anIntArray1631[z]] = attach[1] + 1;
					}
					for (int z = 0; z < anIntArray1632.length; ++z) {
						verticesParticle[anIntArray1632[z]] = attach[1] + 1;
					}
					for (int z = 0; z < anIntArray1633.length; ++z) {
						verticesParticle[anIntArray1633[z]] = attach[1] + 1;
					}
				} else {
					verticesParticle[attach[0]] = attach[1] + 1;
				}
			}
		}
	}

	public Model(int i, Model amodel[]) {
		aBoolean1618 = true;
		rendersWithinOneTile = false;
		anInt1620++;
		boolean flag = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		anInt1626 = 0;
		anInt1630 = 0;
		anInt1642 = 0;
		face_priority = -1;
		for (int k = 0; k < i; k++) {
			Model model = amodel[k];
			if (model != null) {
				anInt1626 += model.anInt1626;
				anInt1630 += model.anInt1630;
				anInt1642 += model.anInt1642;
				flag |= model.anIntArray1637 != null;
				if (model.face_render_priorities != null) {
					flag1 = true;
				} else {
					if (face_priority == -1)
						face_priority = model.face_priority;
					if (face_priority != model.face_priority)
						flag1 = true;
				}
				flag2 |= model.anIntArray1639 != null;
				flag3 |= model.triangleTSkin != null;
			}
		}
		verticesParticle = new int[anInt1626];
		anIntArray1627 = new int[anInt1626];
		anIntArray1628 = new int[anInt1626];
		anIntArray1629 = new int[anInt1626];
		vertexVSkin = new int[anInt1626];
		anIntArray1631 = new int[anInt1630];
		anIntArray1632 = new int[anInt1630];
		anIntArray1633 = new int[anInt1630];
		anIntArray1643 = new int[anInt1642];
		anIntArray1644 = new int[anInt1642];
		anIntArray1645 = new int[anInt1642];
		if (flag)
			anIntArray1637 = new int[anInt1630];
		if (flag1)
			face_render_priorities = new int[anInt1630];
		if (flag2)
			anIntArray1639 = new int[anInt1630];
		if (flag3)
			triangleTSkin = new int[anInt1630];
		triangleColour = new int[anInt1630];
		anInt1626 = 0;
		anInt1630 = 0;
		anInt1642 = 0;
		int l = 0;
		for (int i1 = 0; i1 < i; i1++) {
			Model model_1 = amodel[i1];
			if (model_1 != null) {
				for (int j1 = 0; j1 < model_1.anInt1630; j1++) {
					if (flag)
						if (model_1.anIntArray1637 == null) {
							anIntArray1637[anInt1630] = 0;
						} else {
							int k1 = model_1.anIntArray1637[j1];
							if ((k1 & 2) == 2)
								k1 += l << 2;
							anIntArray1637[anInt1630] = k1;
						}
					if (flag1)
						if (model_1.face_render_priorities == null)
							face_render_priorities[anInt1630] = model_1.face_priority;
						else
							face_render_priorities[anInt1630] = model_1.face_render_priorities[j1];
					if (flag2)
						if (model_1.anIntArray1639 == null)
							anIntArray1639[anInt1630] = 0;
						else
							anIntArray1639[anInt1630] = model_1.anIntArray1639[j1];

					if (flag3 && model_1.triangleTSkin != null)
						triangleTSkin[anInt1630] = model_1.triangleTSkin[j1];
					triangleColour[anInt1630] = model_1.triangleColour[j1];
					anIntArray1631[anInt1630] = method465(model_1, model_1.anIntArray1631[j1]);
					anIntArray1632[anInt1630] = method465(model_1, model_1.anIntArray1632[j1]);
					anIntArray1633[anInt1630] = method465(model_1, model_1.anIntArray1633[j1]);
					anInt1630++;
				}

				for (int l1 = 0; l1 < model_1.anInt1642; l1++) {
					anIntArray1643[anInt1642] = method465(model_1, model_1.anIntArray1643[l1]);
					anIntArray1644[anInt1642] = method465(model_1, model_1.anIntArray1644[l1]);
					anIntArray1645[anInt1642] = method465(model_1, model_1.anIntArray1645[l1]);
					anInt1642++;
				}

				l += model_1.anInt1642;
			}
		}

	}

	public Model(Model amodel[]) {
		int i = 2;
		aBoolean1618 = true;
		rendersWithinOneTile = false;
		anInt1620++;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		anInt1626 = 0;
		anInt1630 = 0;
		anInt1642 = 0;
		face_priority = -1;
		for (int k = 0; k < i; k++) {
			Model model = amodel[k];
			if (model != null) {
				if (this.particleColors == -1 && model.particleColors != -1) {
					this.particleColors = model.particleColors;
				}
				anInt1626 += model.anInt1626;
				anInt1630 += model.anInt1630;
				anInt1642 += model.anInt1642;
				flag1 |= model.anIntArray1637 != null;
				if (model.face_render_priorities != null) {
					flag2 = true;
				} else {
					if (face_priority == -1)
						face_priority = model.face_priority;
					if (face_priority != model.face_priority)
						flag2 = true;
				}
				flag3 |= model.anIntArray1639 != null;
				flag4 |= model.triangleColour != null;
			}
		}
		verticesParticle = new int[anInt1626];
		anIntArray1627 = new int[anInt1626];
		anIntArray1628 = new int[anInt1626];
		anIntArray1629 = new int[anInt1626];
		anIntArray1631 = new int[anInt1630];
		anIntArray1632 = new int[anInt1630];
		anIntArray1633 = new int[anInt1630];
		anIntArray1634 = new int[anInt1630];
		anIntArray1635 = new int[anInt1630];
		anIntArray1636 = new int[anInt1630];
		anIntArray1643 = new int[anInt1642];
		anIntArray1644 = new int[anInt1642];
		anIntArray1645 = new int[anInt1642];
		if (flag1)
			anIntArray1637 = new int[anInt1630];
		if (flag2)
			face_render_priorities = new int[anInt1630];
		if (flag3)
			anIntArray1639 = new int[anInt1630];
		if (flag4)
			triangleColour = new int[anInt1630];
		anInt1626 = 0;
		anInt1630 = 0;
		anInt1642 = 0;
		int i1 = 0;
		for (int j1 = 0; j1 < i; j1++) {
			Model model_1 = amodel[j1];
			if (model_1 != null) {
				int k1 = anInt1626;
				for (int l1 = 0; l1 < model_1.anInt1626; l1++) {
					anIntArray1627[anInt1626] = model_1.anIntArray1627[l1];
					anIntArray1628[anInt1626] = model_1.anIntArray1628[l1];
					anIntArray1629[anInt1626] = model_1.anIntArray1629[l1];
					anInt1626++;
				}

				for (int i2 = 0; i2 < model_1.anInt1630; i2++) {
					anIntArray1631[anInt1630] = model_1.anIntArray1631[i2] + k1;
					anIntArray1632[anInt1630] = model_1.anIntArray1632[i2] + k1;
					anIntArray1633[anInt1630] = model_1.anIntArray1633[i2] + k1;
					anIntArray1634[anInt1630] = model_1.anIntArray1634[i2];
					anIntArray1635[anInt1630] = model_1.anIntArray1635[i2];
					anIntArray1636[anInt1630] = model_1.anIntArray1636[i2];
					if (flag1)
						if (model_1.anIntArray1637 == null) {
							anIntArray1637[anInt1630] = 0;
						} else {
							int j2 = model_1.anIntArray1637[i2];
							if ((j2 & 2) == 2)
								j2 += i1 << 2;
							anIntArray1637[anInt1630] = j2;
						}
					if (flag2)
						if (model_1.face_render_priorities == null)
							face_render_priorities[anInt1630] = model_1.face_priority;
						else
							face_render_priorities[anInt1630] = model_1.face_render_priorities[i2];
					if (flag3)
						if (model_1.anIntArray1639 == null)
							anIntArray1639[anInt1630] = 0;
						else
							anIntArray1639[anInt1630] = model_1.anIntArray1639[i2];
					if (flag4 && model_1.triangleColour != null)
						triangleColour[anInt1630] = model_1.triangleColour[i2];

					anInt1630++;
				}

				for (int k2 = 0; k2 < model_1.anInt1642; k2++) {
					anIntArray1643[anInt1642] = model_1.anIntArray1643[k2] + k1;
					anIntArray1644[anInt1642] = model_1.anIntArray1644[k2] + k1;
					anIntArray1645[anInt1642] = model_1.anIntArray1645[k2] + k1;
					anInt1642++;
				}

				i1 += model_1.anInt1642;
			}
		}

		calculateDiagonals();
	}

	public void applyTransform(int i) {
		if (vertexSkin == null)
			return;
		if (i == -1)
			return;
		FrameReader class36 = FrameReader.forID(i);
		if (class36 == null)
			return;
		SkinList class18 = class36.mySkinList;
		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		for (int k = 0; k < class36.stepCount; k++) {
			int l = class36.opCodeLinkTable[k];
			method472(class18.opcodes[l], class18.skinList[l], class36.xOffset[k], class36.yOffset[k],
					class36.zOffset[k]);
		}

	}

	public void mixTransform(int ai[], int j, int k) {
		if (k == -1)
			return;
		if (ai == null || j == -1) {
			applyTransform(k);
			return;
		}
		FrameReader class36 = FrameReader.forID(k);
		if (class36 == null)
			return;
		FrameReader class36_1 = FrameReader.forID(j);
		if (class36_1 == null) {
			applyTransform(k);
			return;
		}
		SkinList class18 = class36.mySkinList;
		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		int l = 0;
		int i1 = ai[l++];
		for (int j1 = 0; j1 < class36.stepCount; j1++) {
			int k1;
			for (k1 = class36.opCodeLinkTable[j1]; k1 > i1; i1 = ai[l++])
				;
			if (k1 != i1 || class18.opcodes[k1] == 0)
				method472(class18.opcodes[k1], class18.skinList[k1], class36.xOffset[j1], class36.yOffset[j1], class36.zOffset[j1]);
		}

		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		l = 0;
		i1 = ai[l++];
		for (int l1 = 0; l1 < class36_1.stepCount; l1++) {
			int i2;
			for (i2 = class36_1.opCodeLinkTable[l1]; i2 > i1; i1 = ai[l++])
				;
			if (i2 == i1 || class18.opcodes[i2] == 0)
				method472(class18.opcodes[i2], class18.skinList[i2], class36_1.xOffset[l1], class36_1.yOffset[l1], class36_1.zOffset[l1]);
		}
	}

	public void applyTransform(int firstFrame, int nextFrame, int end, int cycle) {

		try {
			if (vertexSkin != null && firstFrame != -1) {
				FrameReader currentAnimation = FrameReader.forID(firstFrame);
				SkinList list1 = currentAnimation.mySkinList;
				anInt1681 = 0;
				anInt1682 = 0;
				anInt1683 = 0;
				FrameReader nextAnimation = null;
				SkinList list2 = null;
				if (nextFrame != -1) {
					nextAnimation = FrameReader.forID(nextFrame);
					if (nextAnimation.mySkinList != list1)
						nextAnimation = null;
					list2 = nextAnimation.mySkinList;
				}
				if(nextAnimation == null || list2 == null) {
					for (int i_263_ = 0; i_263_ < currentAnimation.stepCount; i_263_++) {
						int i_264_ = currentAnimation.opCodeLinkTable[i_263_];
						method472(list1.opcodes[i_264_], list1.skinList[i_264_], currentAnimation.xOffset[i_263_], currentAnimation.yOffset[i_263_], currentAnimation.zOffset[i_263_]);

					}
				} else {
					for (int i1 = 0; i1 < currentAnimation.stepCount; i1++) {
						int n1 = currentAnimation.opCodeLinkTable[i1];
						int opcode = list1.opcodes[n1];
						int[] skin = list1.skinList[n1];
						int x = currentAnimation.xOffset[i1];
						int y = currentAnimation.yOffset[i1];
						int z = currentAnimation.zOffset[i1];
						boolean found = false;
						for (int i2 = 0; i2 < nextAnimation.stepCount; i2++) {
							int n2 = nextAnimation.opCodeLinkTable[i2];
							if (list2.skinList[n2].equals(skin)) {
								if (opcode != 2) {
									x += (nextAnimation.xOffset[i2] - x) * cycle / end;
									y += (nextAnimation.yOffset[i2] - y) * cycle / end;
									z += (nextAnimation.zOffset[i2] - z) * cycle / end;
								} else {
									x &= 0x7ff;
									y &= 0x7ff;
									z &= 0x7ff;
									int dx = nextAnimation.xOffset[i2] - x & 0x7ff;
									int dy = nextAnimation.yOffset[i2] - y & 0x7ff;
									int dz = nextAnimation.zOffset[i2] - z & 0x7ff;
									if (dx >= 1024) {
										dx -= 2048;
									}
									if (dy >= 1024) {
										dy -= 2048;
									}
									if (dz >= 1024) {
										dz -= 2048;
									}
									x = x + dx * cycle / end & 0x7ff;
									y = y + dy * cycle / end & 0x7ff;
									z = z + dz * cycle / end & 0x7ff;
								}
								found = true;
								break;
							}
						}
						if (!found) {
							if (opcode != 3 && opcode != 2) {
								x = x * (end - cycle) / end;
								y = y * (end - cycle) / end;
								z = z * (end - cycle) / end;
							} else if (opcode == 3) {
								x = (x * (end - cycle) + (cycle << 7)) / end;
								y = (y * (end - cycle) + (cycle << 7)) / end;
								z = (z * (end - cycle) + (cycle << 7)) / end;
							} else {
								x &= 0x7ff;
								y &= 0x7ff;
								z &= 0x7ff;
								int dx = -x & 0x7ff;
								int dy = -y & 0x7ff;
								int dz = -z & 0x7ff;
								if (dx >= 1024) {
									dx -= 2048;
								}
								if (dy >= 1024) {
									dy -= 2048;
								}
								if (dz >= 1024) {
									dz -= 2048;
								}
								x = x + dx * cycle / end & 0x7ff;
								y = y + dy * cycle / end & 0x7ff;
								z = z + dz * cycle / end & 0x7ff;
							}
						}
						method472(opcode, skin, x, y, z);
					}
				}
			}

		} catch(Exception e) {
			//e.printStackTrace();
			applyTransform(firstFrame); //Cheap fix
		}
	}

	public void applyTransform_2(int i, int frame2) {
		if (vertexSkin == null)
			return;
		if (i == -1)
			return;
		FrameReader class36 = FrameReader.forID(i);
		if (class36 == null)
			return;
		FrameReader class36_1 = FrameReader.forID(frame2);
		FrameReader fr = FrameReader.getTween(class36, class36_1);
		class36 = fr;
		SkinList class18 = class36.mySkinList;
		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		for (int k = 0; k < class36.stepCount; k++) {
			int l = class36.opCodeLinkTable[k];
			method472(class18.opcodes[l], class18.skinList[l], class36.xOffset[k], class36.yOffset[k],
					class36.zOffset[k]);
		}

	}

	public void calcDiagonalsAndStats(int i) {
		super.modelHeight = 0;
		anInt1650 = 0;
		anInt1651 = 0;
		anInt1646 = 0xf423f;
		anInt1647 = 0xfff0bdc1;
		anInt1648 = 0xfffe7961;
		anInt1649 = 0x1869f;
		for (int j = 0; j < anInt1626; j++) {
			int k = anIntArray1627[j];
			int l = anIntArray1628[j];
			int i1 = anIntArray1629[j];
			if (k < anInt1646)
				anInt1646 = k;
			if (k > anInt1647)
				anInt1647 = k;
			if (i1 < anInt1649)
				anInt1649 = i1;
			if (i1 > anInt1648)
				anInt1648 = i1;
			if (-l > super.modelHeight)
				super.modelHeight = -l;
			if (l > anInt1651)
				anInt1651 = l;
			int j1 = k * k + i1 * i1;
			if (j1 > anInt1650)
				anInt1650 = j1;
		}

		anInt1650 = (int) Math.sqrt(anInt1650);
		boundingCylinderRadius = (int) Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight);
		if (i != 21073) {
			return;
		} else {
			diagonal3D = boundingCylinderRadius + (int) Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651);
			return;
		}
	}

	public void calculateDiagonals() {
		super.modelHeight = 0;
		anInt1650 = 0;
		anInt1651 = 0;
		for (int i = 0; i < anInt1626; i++) {
			int j = anIntArray1627[i];
			int k = anIntArray1628[i];
			int l = anIntArray1629[i];
			if (-k > super.modelHeight)
				super.modelHeight = -k;
			if (k > anInt1651)
				anInt1651 = k;
			int i1 = j * j + l * l;
			if (i1 > anInt1650)
				anInt1650 = i1;
		}
		anInt1650 = (int) (Math.sqrt(anInt1650) + 0.98999999999999999D);
		boundingCylinderRadius = (int) (Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight)
				+ 0.98999999999999999D);
		diagonal3D = boundingCylinderRadius
				+ (int) (Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651) + 0.98999999999999999D);
	}

	public void createBones() {
		if (vertexVSkin != null) {
			int ai[] = new int[256];
			int j = 0;
			for (int l = 0; l < anInt1626; l++) {
				int j1 = vertexVSkin[l];
				ai[j1]++;
				if (j1 > j)
					j = j1;
			}
			vertexSkin = null;
			vertexSkin = new int[j + 1][];
			for (int k1 = 0; k1 <= j; k1++) {
				vertexSkin[k1] = new int[ai[k1]];
				ai[k1] = 0;
			}

			for (int j2 = 0; j2 < anInt1626; j2++) {
				int l2 = vertexVSkin[j2];
				vertexSkin[l2][ai[l2]++] = j2;
			}

			vertexVSkin = null;
			ai = null;
		}
		if (triangleTSkin != null) {
			int ai1[] = new int[256];
			int k = 0;
			for (int i1 = 0; i1 < anInt1630; i1++) {
				int l1 = triangleTSkin[i1];
				ai1[l1]++;
				if (l1 > k)
					k = l1;
			}
			triangleSkin = null;
			triangleSkin = new int[k + 1][];
			for (int i2 = 0; i2 <= k; i2++) {
				triangleSkin[i2] = new int[ai1[i2]];
				ai1[i2] = 0;
			}

			for (int k2 = 0; k2 < anInt1630; k2++) {
				int i3 = triangleTSkin[k2];
				triangleSkin[i3][ai1[i3]++] = k2;
			}

			triangleTSkin = null;
			ai1 = null;
		}
	}

	private final boolean cursorOn(int cursorX, int cursorY, int proj_vertex_yA, int proj_vertex_yB, int proj_vertex_yC,
								   int proj_vertex_xA, int proj_vertex_xB, int proj_vertex_xC) {
		if (cursorY < proj_vertex_yA && cursorY < proj_vertex_yB && cursorY < proj_vertex_yC)
			return false;
		if (cursorY > proj_vertex_yA && cursorY > proj_vertex_yB && cursorY > proj_vertex_yC)
			return false;
		if (cursorX < proj_vertex_xA && cursorX < proj_vertex_xB && cursorX < proj_vertex_xC)
			return false;
		return cursorX <= proj_vertex_xA || cursorX <= proj_vertex_xB || cursorX <= proj_vertex_xC;
	}

	public void filterTriangles() {
		for (int triangleId = 0; triangleId < anInt1630; triangleId++) {
			int l = anIntArray1631[triangleId];
			int k1 = anIntArray1632[triangleId];
			int j2_ = anIntArray1633[triangleId];
			boolean b = true;
			label2: for (int triId = 0; triId < anInt1630; triId++) {
				if (triId == triangleId)
					continue label2;
				if (anIntArray1631[triId] == l) {
					b = false;
					break label2;
				}
				if (anIntArray1632[triId] == k1) {
					b = false;
					break label2;
				}
				if (anIntArray1633[triId] == j2_) {
					b = false;
					break label2;
				}
			}
			if (b) {
				if (anIntArray1637 != null)
					anIntArray1639[triangleId] = 255;

			}
		}
	}

	/**
	 * @param lighting
	 * @param diffusion
	 * @param x
	 * @param y
	 * @param z
	 * @param immediateShading
	 */
	public void light(int i, int j, int k, int l, int i1, boolean flag) {
		try {
			int j1 = (int) Math.sqrt(k * k + l * l + i1 * i1);
			int k1 = j * j1 >> 8;
			if (anIntArray1634 == null) {
				anIntArray1634 = new int[anInt1630];
				anIntArray1635 = new int[anInt1630];
				anIntArray1636 = new int[anInt1630];
			}
			//if (filterTriangles) {
				removeColors(new int[]{65535});
			//}
			if (super.vertexNormals == null) {
				super.vertexNormals = new VertexNormal[anInt1626];
				for (int l1 = 0; l1 < anInt1626; l1++)
					super.vertexNormals[l1] = new VertexNormal();

			}
			for (int i2 = 0; i2 < anInt1630; i2++) {
				int j2 = anIntArray1631[i2];
				int l2 = anIntArray1632[i2];
				int i3 = anIntArray1633[i2];
				int j3 = anIntArray1627[l2] - anIntArray1627[j2];
				int k3 = anIntArray1628[l2] - anIntArray1628[j2];
				int l3 = anIntArray1629[l2] - anIntArray1629[j2];
				int i4 = anIntArray1627[i3] - anIntArray1627[j2];
				int j4 = anIntArray1628[i3] - anIntArray1628[j2];
				int k4 = anIntArray1629[i3] - anIntArray1629[j2];
				int l4 = k3 * k4 - j4 * l3;
				int i5 = l3 * i4 - k4 * j3;
				int j5;
				for (j5 = j3 * j4 - i4 * k3; l4 > 8192 || i5 > 8192 || j5 > 8192 || l4 < -8192 || i5 < -8192
						|| j5 < -8192; j5 >>= 1) {
					l4 >>= 1;
					i5 >>= 1;
				}

				int k5 = (int) Math.sqrt(l4 * l4 + i5 * i5 + j5 * j5);
				if (k5 <= 0)
					k5 = 1;
				l4 = (l4 * 256) / k5;
				i5 = (i5 * 256) / k5;
				j5 = (j5 * 256) / k5;

				if (anIntArray1637 == null || (anIntArray1637[i2] & 1) == 0) {

					VertexNormal vNormal = super.vertexNormals[j2];
					vNormal.anInt602 += l4;
					vNormal.anInt603 += i5;
					vNormal.anInt604 += j5;
					vNormal.anInt605++;
					vNormal = super.vertexNormals[l2];
					vNormal.anInt602 += l4;
					vNormal.anInt603 += i5;
					vNormal.anInt604 += j5;
					vNormal.anInt605++;
					vNormal = super.vertexNormals[i3];
					vNormal.anInt602 += l4;
					vNormal.anInt603 += i5;
					vNormal.anInt604 += j5;
					vNormal.anInt605++;
					vNormal = null;

				} else {

					int l5 = i + (k * l4 + l * i5 + i1 * j5) / (k1 + k1 / 2);
					anIntArray1634[i2] = method481(triangleColour[i2], l5, anIntArray1637[i2]);

				}
			}

			if (flag) {
				method480(i, k1, k, l, i1);
			} else {
				vertexNormalOffset = new VertexNormal[anInt1626];
				for (int k2 = 0; k2 < anInt1626; k2++) {
					VertexNormal vNormal = super.vertexNormals[k2];
					vertexNormalOffset[k2] = new VertexNormal();
					vertexNormalOffset[k2].anInt602 = vNormal.anInt602;
					vertexNormalOffset[k2].anInt603 = vNormal.anInt603;
					vertexNormalOffset[k2].anInt604 = vNormal.anInt604;
					vertexNormalOffset[k2].anInt605 = vNormal.anInt605;
				}

			}
			if (flag) {
				calculateDiagonals();
				return;
			} else {
				calcDiagonalsAndStats(21073);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void method464(Model model, boolean flag) {
		particleColors = model.particleColors;
		anInt1626 = model.anInt1626;
		anInt1630 = model.anInt1630;
		anInt1642 = model.anInt1642;
		if (anIntArray1622.length < anInt1626) {
			anIntArray1622 = new int[anInt1626 + 10000];
			anIntArray1623 = new int[anInt1626 + 10000];
			anIntArray1624 = new int[anInt1626 + 10000];
		}
		verticesParticle = new int[anInt1626];
		anIntArray1627 = anIntArray1622;
		anIntArray1628 = anIntArray1623;
		anIntArray1629 = anIntArray1624;
		for (int k = 0; k < anInt1626; k++) {
			anIntArray1627[k] = model.anIntArray1627[k];
			anIntArray1628[k] = model.anIntArray1628[k];
			anIntArray1629[k] = model.anIntArray1629[k];
			if (verticesParticle != null) {
				verticesParticle[k] = model.verticesParticle[k];
			}
		}

		if (flag) {
			anIntArray1639 = model.anIntArray1639;
		} else {
			if (anIntArray1625.length < anInt1630)
				anIntArray1625 = new int[anInt1630 + 100];
			anIntArray1639 = anIntArray1625;
			if (model.anIntArray1639 == null) {
				for (int l = 0; l < anInt1630; l++)
					anIntArray1639[l] = 0;

			} else {
				for (int i1 = 0; i1 < anInt1630; i1++)
					anIntArray1639[i1] = model.anIntArray1639[i1];

			}
		}
		anIntArray1637 = model.anIntArray1637;
		triangleColour = model.triangleColour;
		face_render_priorities = model.face_render_priorities;
		face_priority = model.face_priority;
		triangleSkin = model.triangleSkin;
		vertexSkin = model.vertexSkin;
		anIntArray1631 = model.anIntArray1631;
		anIntArray1632 = model.anIntArray1632;
		anIntArray1633 = model.anIntArray1633;
		anIntArray1634 = model.anIntArray1634;
		anIntArray1635 = model.anIntArray1635;
		anIntArray1636 = model.anIntArray1636;
		anIntArray1643 = model.anIntArray1643;
		anIntArray1644 = model.anIntArray1644;
		anIntArray1645 = model.anIntArray1645;
	}

	private final int method465(Model model, int i) {
		int j = -1;
		int p = model.verticesParticle[i];
		int k = model.anIntArray1627[i];
		int l = model.anIntArray1628[i];
		int i1 = model.anIntArray1629[i];
		for (int j1 = 0; j1 < anInt1626; j1++) {
			if (k != anIntArray1627[j1] || l != anIntArray1628[j1] || i1 != anIntArray1629[j1])
				continue;
			j = j1;
			break;
		}

		if (j == -1) {
			verticesParticle[anInt1626] = p;
			anIntArray1627[anInt1626] = k;
			anIntArray1628[anInt1626] = l;
			anIntArray1629[anInt1626] = i1;
			if (model.vertexVSkin != null)
				vertexVSkin[anInt1626] = model.vertexVSkin[i];
			j = anInt1626++;
		}
		return j;
	}

	public void method471(int ai[], int j, int k) {
		if (k == -1)
			return;
		if (ai == null || j == -1) {
			applyTransform(k);
			return;
		}
		FrameReader class36 = FrameReader.forID(k);
		if (class36 == null)
			return;
		FrameReader class36_1 = FrameReader.forID(j);
		if (class36_1 == null) {
			applyTransform(k);
			return;
		}
		SkinList class18 = class36.mySkinList;
		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		int l = 0;
		int i1 = ai[l++];
		for (int j1 = 0; j1 < class36.stepCount; j1++) {
			int k1;
			for (k1 = class36.opCodeLinkTable[j1]; k1 > i1; i1 = ai[l++])
				;
			if (k1 != i1 || class18.opcodes[k1] == 0)
				method472(class18.opcodes[k1], class18.skinList[k1], class36.xOffset[j1], class36.yOffset[j1],
						class36.zOffset[j1]);
		}

		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		l = 0;
		i1 = ai[l++];
		try {
			for (int l1 = 0; l1 < class36_1.stepCount; l1++) {
				int i2;
				for (i2 = class36_1.opCodeLinkTable[l1]; i2 > i1; i1 = ai[l++])
					;
				if (i2 == i1 || class18.opcodes[i2] == 0)
					method472(class18.opcodes[i2], class18.skinList[i2], class36_1.xOffset[l1], class36_1.yOffset[l1],
							class36_1.zOffset[l1]);
			}
		} catch (Exception e) {
		}

	}

	public void method471_2(int mixingData[], int j, int frameId, int frameId2) {
		if (frameId == -1)
			return;
		if (mixingData == null || j == -1) {
			applyTransform(frameId);
			return;
		}
		FrameReader class36 = FrameReader.forID(frameId);
		if (class36 == null)
			return;
		FrameReader class36_1 = FrameReader.forID(j);
		if (class36_1 == null) {
			applyTransform(frameId);
			return;
		}
		FrameReader fr = FrameReader.forID(frameId2);
		FrameReader tween = FrameReader.getTween(class36_1, fr);
		class36 = tween;
		SkinList class18 = class36.mySkinList;
		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		int l = 0;
		int i1 = mixingData[l++];
		for (int j1 = 0; j1 < class36.stepCount; j1++) {
			int k1;
			for (k1 = class36.opCodeLinkTable[j1]; k1 > i1; i1 = mixingData[l++])
				;
			if (k1 != i1 || class18.opcodes[k1] == 0)
				method472(class18.opcodes[k1], class18.skinList[k1], class36.xOffset[j1], class36.yOffset[j1],
						class36.zOffset[j1]);
		}

		anInt1681 = 0;
		anInt1682 = 0;
		anInt1683 = 0;
		l = 0;
		i1 = mixingData[l++];
		for (int l1 = 0; l1 < class36_1.stepCount; l1++) {
			int i2;
			for (i2 = class36_1.opCodeLinkTable[l1]; i2 > i1; i1 = mixingData[l++])
				;
			if (i2 == i1 || class18.opcodes[i2] == 0)
				method472(class18.opcodes[i2], class18.skinList[i2], class36_1.xOffset[l1], class36_1.yOffset[l1],
						class36_1.zOffset[l1]);
		}

	}

	private void method472(int animationType, int skin[], int xOffset, int yOffset, int zOffset) {

		int i1 = skin.length;
		if (animationType == 0) {
			int j1 = 0;
			anInt1681 = 0;
			anInt1682 = 0;
			anInt1683 = 0;
			for (int k2 = 0; k2 < i1; k2++) {
				int l3 = skin[k2];
				if (l3 < vertexSkin.length) {
					int ai5[] = vertexSkin[l3];
					for (int i5 = 0; i5 < ai5.length; i5++) {
						int j6 = ai5[i5];
						anInt1681 += anIntArray1627[j6];
						anInt1682 += anIntArray1628[j6];
						anInt1683 += anIntArray1629[j6];
						j1++;
					}

				}
			}

			if (j1 > 0) {
				anInt1681 = (int)(anInt1681 / j1 + xOffset);
				anInt1682 = (int)(anInt1682 / j1 + yOffset);
				anInt1683 = (int)(anInt1683 / j1 + zOffset);
				return;
			} else {
				anInt1681 = (int)xOffset;
				anInt1682 = (int)yOffset;
				anInt1683 = (int)zOffset;
				return;
			}
		}
		if (animationType == 1) {
			for (int k1 = 0; k1 < i1; k1++) {
				int l2 = skin[k1];
				if (l2 < vertexSkin.length) {
					int ai1[] = vertexSkin[l2];
					for (int i4 = 0; i4 < ai1.length; i4++) {
						int j5 = ai1[i4];
						anIntArray1627[j5] += xOffset;
						anIntArray1628[j5] += yOffset;
						anIntArray1629[j5] += zOffset;
					}

				}
			}

			return;
		}
		if (animationType == 2) {
			for (int l1 = 0; l1 < i1; l1++) {
				int i3 = skin[l1];
				if (i3 < vertexSkin.length) {
					int ai2[] = vertexSkin[i3];
					for (int j4 = 0; j4 < ai2.length; j4++) {
						int k5 = ai2[j4];
						anIntArray1627[k5] -= anInt1681;
						anIntArray1628[k5] -= anInt1682;
						anIntArray1629[k5] -= anInt1683;
						//int j, int k, int l
						if (zOffset != 0) {
							int j7 = SINE[zOffset];
							int i8 = COSINE[zOffset];
							int l8 = anIntArray1628[k5] * j7 + anIntArray1627[k5] * i8 >> 16;
							anIntArray1628[k5] = anIntArray1628[k5] * i8 - anIntArray1627[k5] * j7 >> 16;
							anIntArray1627[k5] = l8;
						}
						if (xOffset != 0) {
							int k7 = SINE[xOffset];
							int j8 = COSINE[xOffset];
							int i9 = anIntArray1628[k5] * j8 - anIntArray1629[k5] * k7 >> 16;
							anIntArray1629[k5] = anIntArray1628[k5] * k7 + anIntArray1629[k5] * j8 >> 16;
							anIntArray1628[k5] = i9;
						}
						if (yOffset != 0) {
							int l7 = SINE[yOffset];
							int k8 = COSINE[yOffset];
							int j9 = anIntArray1629[k5] * l7 + anIntArray1627[k5] * k8 >> 16;
							anIntArray1629[k5] = anIntArray1629[k5] * k8 - anIntArray1627[k5] * l7 >> 16;
							anIntArray1627[k5] = j9;
						}
						anIntArray1627[k5] += anInt1681;
						anIntArray1628[k5] += anInt1682;
						anIntArray1629[k5] += anInt1683;
					}

				}
			}
			return;
		}
		/*if (animationType == 2) {
			for (int l1 = 0; l1 < i1; l1++) {
				int i3 = skin[l1];
				if (i3 < vertexSkin.length) {
					int ai2[] = vertexSkin[i3];
					for (int j4 = 0; j4 < ai2.length; j4++) {
						int k5 = ai2[j4];
						verticesXCoordinate[k5] -= xAnimOffset;
						verticesYCoordinate[k5] -= yAnimOffset;
						verticesZCoordinate[k5] -= zAnimOffset;

						double x_ = xOffset - Math.floor(xOffset);
						double y_ = yOffset - Math.floor(yOffset);
						double z_ = zOffset - Math.floor(zOffset);
						xOffset = (int) xOffset & 0xff;
						yOffset = (int) yOffset & 0xff;
						zOffset = (int) zOffset & 0xff;
						xOffset += x_;
						yOffset += y_;
						zOffset += z_;
						int k6 = (int)((xOffset) * 8);
						int l6 = (int)((yOffset) * 8);
						int i7 = (int)((zOffset) * 8);
						if (i7 != 0) {
							int j7 = SINE[i7];
							int i8 = COSINE[i7];
							int l8 = verticesYCoordinate[k5] * j7 + verticesXCoordinate[k5] * i8 >> 16;
							verticesYCoordinate[k5] = verticesYCoordinate[k5] * i8 - verticesXCoordinate[k5] * j7 >> 16;
							verticesXCoordinate[k5] = l8;
						}
						if (k6 != 0) {
							int k7 = SINE[k6];
							int j8 = COSINE[k6];
							int i9 = verticesYCoordinate[k5] * j8 - verticesZCoordinate[k5] * k7 >> 16;
							verticesZCoordinate[k5] = verticesYCoordinate[k5] * k7 + verticesZCoordinate[k5] * j8 >> 16;
							verticesYCoordinate[k5] = i9;
						}
						if (l6 != 0) {
							int l7 = SINE[l6];
							int k8 = COSINE[l6];
							int j9 = verticesZCoordinate[k5] * l7 + verticesXCoordinate[k5] * k8 >> 16;
							verticesZCoordinate[k5] = verticesZCoordinate[k5] * k8 - verticesXCoordinate[k5] * l7 >> 16;
							verticesXCoordinate[k5] = j9;
						}
						verticesXCoordinate[k5] += xAnimOffset;
						verticesYCoordinate[k5] += yAnimOffset;
						verticesZCoordinate[k5] += zAnimOffset;
					}

				}
			}

			return;
		}*/
		if (animationType == 3) {
			for (int i2 = 0; i2 < i1; i2++) {
				int j3 = skin[i2];
				if (j3 < vertexSkin.length) {
					int ai3[] = vertexSkin[j3];
					for (int k4 = 0; k4 < ai3.length; k4++) {
						int l5 = ai3[k4];
						anIntArray1627[l5] -= anInt1681;
						anIntArray1628[l5] -= anInt1682;
						anIntArray1629[l5] -= anInt1683;
						anIntArray1627[l5] = (int)((anIntArray1627[l5] * xOffset) / 128);
						anIntArray1628[l5] = (int)((anIntArray1628[l5] * yOffset) / 128);
						anIntArray1629[l5] = (int)((anIntArray1629[l5] * zOffset) / 128);
						anIntArray1627[l5] += anInt1681;
						anIntArray1628[l5] += anInt1682;
						anIntArray1629[l5] += anInt1683;
					}

				}
			}

			return;
		}
		if (animationType == 5 && triangleSkin != null && anIntArray1639 != null) {
			for (int j2 = 0; j2 < i1; j2++) {
				int k3 = skin[j2];
				if (k3 < triangleSkin.length) {
					int ai4[] = triangleSkin[k3];
					for (int l4 = 0; l4 < ai4.length; l4++) {
						int i6 = ai4[l4];
						anIntArray1639[i6] += xOffset * 8;
						if (anIntArray1639[i6] < 0)
							anIntArray1639[i6] = 0;
						if (anIntArray1639[i6] > 255)
							anIntArray1639[i6] = 255;
					}

				}
			}

		}
	}

	public void method480(int i, int j, int k, int l, int i1) {
		for (int j1 = 0; j1 < anInt1630; j1++) {
			int k1 = anIntArray1631[j1];
			int i2 = anIntArray1632[j1];
			int j2 = anIntArray1633[j1];
			if (anIntArray1637 == null) {
				int i3 = triangleColour[j1];
				VertexNormal class33 = super.vertexNormals[k1];
				int k2 = i + (k * class33.anInt602 + l * class33.anInt603 + i1 * class33.anInt604)
						/ (j * class33.anInt605);
				anIntArray1634[j1] = method481(i3, k2, 0);
				class33 = super.vertexNormals[i2];
				k2 = i + (k * class33.anInt602 + l * class33.anInt603 + i1 * class33.anInt604) / (j * class33.anInt605);
				anIntArray1635[j1] = method481(i3, k2, 0);
				class33 = super.vertexNormals[j2];
				k2 = i + (k * class33.anInt602 + l * class33.anInt603 + i1 * class33.anInt604) / (j * class33.anInt605);
				anIntArray1636[j1] = method481(i3, k2, 0);
			} else if ((anIntArray1637[j1] & 1) == 0) {
				int j3 = triangleColour[j1];
				int k3 = anIntArray1637[j1];
				VertexNormal class33_1 = super.vertexNormals[k1];
				int l2 = i + (k * class33_1.anInt602 + l * class33_1.anInt603 + i1 * class33_1.anInt604)
						/ (j * class33_1.anInt605);
				anIntArray1634[j1] = method481(j3, l2, k3);
				class33_1 = super.vertexNormals[i2];
				l2 = i + (k * class33_1.anInt602 + l * class33_1.anInt603 + i1 * class33_1.anInt604)
						/ (j * class33_1.anInt605);
				anIntArray1635[j1] = method481(j3, l2, k3);
				class33_1 = super.vertexNormals[j2];
				l2 = i + (k * class33_1.anInt602 + l * class33_1.anInt603 + i1 * class33_1.anInt604)
						/ (j * class33_1.anInt605);
				anIntArray1636[j1] = method481(j3, l2, k3);
			}
		}

		super.vertexNormals = null;
		vertexNormalOffset = null;
		vertexVSkin = null;
		triangleTSkin = null;
		if (anIntArray1637 != null) {
			for (int l1 = 0; l1 < anInt1630; l1++)
				if ((anIntArray1637[l1] & 2) == 2)
					return;

		}
		//anIntArray1640 = null;
	}

	public void mirrorModel() {
		for (int j = 0; j < anInt1626; j++)
			anIntArray1629[j] = -anIntArray1629[j];
		for (int k = 0; k < anInt1630; k++) {
			int l = anIntArray1631[k];
			anIntArray1631[k] = anIntArray1633[k];
			anIntArray1633[k] = l;
		}
	}

	public void normalise() {
		super.modelHeight = 0;
		anInt1651 = 0;
		for (int i = 0; i < anInt1626; i++) {
			int j = anIntArray1628[i];
			if (-j > super.modelHeight)
				super.modelHeight = -j;
			if (j > anInt1651)
				anInt1651 = j;
		}

		boundingCylinderRadius = (int) (Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight)
				+ 0.98999999999999999D);
		diagonal3D = boundingCylinderRadius
				+ (int) (Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651) + 0.98999999999999999D);
	}

	private final void method484(int i) {
		if (aBooleanArray1664[i]) {
			method485(i);
			return;
		}
		int j = anIntArray1631[i];
		int k = anIntArray1632[i];
		int l = anIntArray1633[i];
		Rasterizer.aBoolean1462 = hasAnEdgeToRestrict[i];
		if (anIntArray1639 == null)
			Rasterizer.anInt1465 = 0;
		else
			Rasterizer.anInt1465 = (anIntArray1639)[i];
		int i1;
		if (anIntArray1637 == null)
			i1 = 0;
		else
			i1 = anIntArray1637[i] & 3;
		if (i1 == 0) {
			Rasterizer.drawGouraudTriangle(anIntArray1666[j], anIntArray1666[k],
					anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
					anIntArray1665[l], anIntArray1634[i], anIntArray1635[i],
					anIntArray1636[i], vertexPerspectiveDepth[j],
					vertexPerspectiveDepth[k], vertexPerspectiveDepth[l]);
			return;
		}
		if (i1 == 1) {
			Rasterizer.drawFlatTriangle(anIntArray1666[j], anIntArray1666[k],
					anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
					anIntArray1665[l], hsl2rgb[anIntArray1634[i]], vertexPerspectiveDepth[j],
					vertexPerspectiveDepth[k], vertexPerspectiveDepth[l]);
			return;
		}
		if (i1 == 2) {
			int j1 = anIntArray1637[i] >> 2;
			int l1 = anIntArray1643[j1];
			int j2 = anIntArray1644[j1];
			int l2 = anIntArray1645[j1];
			Rasterizer.drawTexturedTriangle(anIntArray1666[j], anIntArray1666[k],
					anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
					anIntArray1665[l], anIntArray1634[i], anIntArray1635[i],
					anIntArray1636[i], anIntArray1668[l1], anIntArray1668[j2],
					anIntArray1668[l2], anIntArray1669[l1], anIntArray1669[j2],
					anIntArray1669[l2], anIntArray1670[l1], anIntArray1670[j2],
					anIntArray1670[l2], triangleColour[i], vertexPerspectiveDepth[j],
					vertexPerspectiveDepth[k], vertexPerspectiveDepth[l]);
			return;
		}
		if (i1 == 3) {
			int k1 = anIntArray1637[i] >> 2;
			int i2 = anIntArray1643[k1];
			int k2 = anIntArray1644[k1];
			int i3 = anIntArray1645[k1];
			Rasterizer.drawTexturedTriangle(anIntArray1666[j], anIntArray1666[k],
					anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
					anIntArray1665[l], anIntArray1634[i], anIntArray1634[i],
					anIntArray1634[i], anIntArray1668[i2], anIntArray1668[k2],
					anIntArray1668[i3], anIntArray1669[i2], anIntArray1669[k2],
					anIntArray1669[i3], anIntArray1670[i2], anIntArray1670[k2],
					anIntArray1670[i3], triangleColour[i], vertexPerspectiveDepth[j],
					vertexPerspectiveDepth[k], vertexPerspectiveDepth[l]);
		}
	}

	public void read525Model(byte abyte0[], int modelID) {
		Stream nc1 = new Stream(abyte0);
		Stream nc2 = new Stream(abyte0);
		Stream nc3 = new Stream(abyte0);
		Stream nc4 = new Stream(abyte0);
		Stream nc5 = new Stream(abyte0);
		Stream nc6 = new Stream(abyte0);
		Stream nc7 = new Stream(abyte0);
		nc1.currentOffset = abyte0.length - 23;
		int numVertices = nc1.readUnsignedWord();
		int numTriangles = nc1.readUnsignedWord();
		int numTexTriangles = nc1.readUnsignedByte();
		ModelHeader ModelDef_1 = modelHeader[modelID] = new ModelHeader();
		ModelDef_1.modelData = abyte0;
		ModelDef_1.verticeCount = numVertices;
		ModelDef_1.triangleCount = numTriangles;
		ModelDef_1.texturedTriangleCount = numTexTriangles;
		int l1 = nc1.readUnsignedByte();
		boolean bool = (0x1 & l1 ^ 0xffffffff) == -2;
		boolean bool_78_ = (l1 & 0x2 ^ 0xffffffff) == -3;
		int i2 = nc1.readUnsignedByte();
		int j2 = nc1.readUnsignedByte();
		int k2 = nc1.readUnsignedByte();
		int l2 = nc1.readUnsignedByte();
		int i3 = nc1.readUnsignedByte();
		int j3 = nc1.readUnsignedWord();
		int k3 = nc1.readUnsignedWord();
		int l3 = nc1.readUnsignedWord();
		int i4 = nc1.readUnsignedWord();
		int j4 = nc1.readUnsignedWord();
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		int v = 0;
		int hb = 0;
		int P = 0;
		byte G = 0;
		byte[] x = null;
		byte[] O = null;
		byte[] J = null;
		byte[] F = null;
		byte[] cb = null;
		byte[] gb = null;
		byte[] lb = null;
		int[] ab = null;
		int[] kb = null;
		int[] y = null;
		int[] N = null;
		short[] D = null;
		int[] triangleColours2 = new int[numTriangles];
		if (numTexTriangles > 0) {
			O = new byte[numTexTriangles];
			nc1.currentOffset = 0;
			for (int j5 = 0; j5 < numTexTriangles; j5++) {
				byte byte0 = O[j5] = nc1.readSignedByte();
				if (byte0 == 0)
					k4++;
				if (byte0 >= 1 && byte0 <= 3)
					l4++;
				if (byte0 == 2)
					i5++;
			}
		}
		int k5 = numTexTriangles;
		int l5 = k5;
		k5 += numVertices;
		int i6 = k5;
		if (l1 == 1)
			k5 += numTriangles;
		int j6 = k5;
		k5 += numTriangles;
		int k6 = k5;
		if (i2 == 255)
			k5 += numTriangles;
		int l6 = k5;
		if (k2 == 1)
			k5 += numTriangles;
		int i7 = k5;
		if (i3 == 1)
			k5 += numVertices;
		int j7 = k5;
		if (j2 == 1)
			k5 += numTriangles;
		int k7 = k5;
		k5 += i4;
		int l7 = k5;
		if (l2 == 1)
			k5 += numTriangles * 2;
		int i8 = k5;
		k5 += j4;
		int j8 = k5;
		k5 += numTriangles * 2;
		int k8 = k5;
		k5 += j3;
		int l8 = k5;
		k5 += k3;
		int i9 = k5;
		k5 += l3;
		int j9 = k5;
		k5 += k4 * 6;
		int k9 = k5;
		k5 += l4 * 6;
		int l9 = k5;
		k5 += l4 * 6;
		int i10 = k5;
		k5 += l4;
		int j10 = k5;
		k5 += l4;
		int k10 = k5;
		k5 += l4 + i5 * 2;
		v = numVertices;
		hb = numTriangles;
		P = numTexTriangles;
		int[] vertexX = new int[numVertices];
		int[] vertexY = new int[numVertices];
		int[] vertexZ = new int[numVertices];
		int[] facePoint1 = new int[numTriangles];
		int[] facePoint2 = new int[numTriangles];
		int[] facePoint3 = new int[numTriangles];
		verticesParticle = new int[numVertices];
		vertexVSkin = new int[numVertices];
		anIntArray1637 = new int[numTriangles];
		face_render_priorities = new int[numTriangles];
		anIntArray1639 = new int[numTriangles];
		triangleTSkin = new int[numTriangles];
		if (i3 == 1)
			vertexVSkin = new int[numVertices];
		if (bool)
			anIntArray1637 = new int[numTriangles];
		if (i2 == 255)
			face_render_priorities = new int[numTriangles];
		else
			G = (byte) i2;
		if (j2 == 1)
			anIntArray1639 = new int[numTriangles];
		if (k2 == 1)
			triangleTSkin = new int[numTriangles];
		if (l2 == 1)
			D = new short[numTriangles];
		if (l2 == 1 && numTexTriangles > 0)
			x = new byte[numTriangles];
		triangleColours2 = new int[numTriangles];
		int i_115_ = k5;
		int[] texTrianglesPoint1 = null;
		int[] texTrianglesPoint2 = null;
		int[] texTrianglesPoint3 = null;
		if (numTexTriangles > 0) {
			texTrianglesPoint1 = new int[numTexTriangles];
			texTrianglesPoint2 = new int[numTexTriangles];
			texTrianglesPoint3 = new int[numTexTriangles];
			if (l4 > 0) {
				kb = new int[l4];
				N = new int[l4];
				y = new int[l4];
				gb = new byte[l4];
				lb = new byte[l4];
				F = new byte[l4];
			}
			if (i5 > 0) {
				cb = new byte[i5];
				J = new byte[i5];
			}
		}
		nc1.currentOffset = l5;
		nc2.currentOffset = k8;
		nc3.currentOffset = l8;
		nc4.currentOffset = i9;
		nc5.currentOffset = i7;
		int l10 = 0;
		int i11 = 0;
		int j11 = 0;
		for (int k11 = 0; k11 < numVertices; k11++) {
			int l11 = nc1.readUnsignedByte();
			int j12 = 0;
			if ((l11 & 1) != 0)
				j12 = nc2.method421();
			int l12 = 0;
			if ((l11 & 2) != 0)
				l12 = nc3.method421();
			int j13 = 0;
			if ((l11 & 4) != 0)
				j13 = nc4.method421();
			vertexX[k11] = l10 + j12;
			vertexY[k11] = i11 + l12;
			vertexZ[k11] = j11 + j13;
			l10 = vertexX[k11];
			i11 = vertexY[k11];
			j11 = vertexZ[k11];
			if (vertexVSkin != null)
				vertexVSkin[k11] = nc5.readUnsignedByte();
		}
		nc1.currentOffset = j8;
		nc2.currentOffset = i6;
		nc3.currentOffset = k6;
		nc4.currentOffset = j7;
		nc5.currentOffset = l6;
		nc6.currentOffset = l7;
		nc7.currentOffset = i8;
		for (int i12 = 0; i12 < numTriangles; i12++) {
			triangleColours2[i12] = nc1.readUnsignedWord();
			if (l1 == 1) {
				anIntArray1637[i12] = nc2.readSignedByte();
				if (anIntArray1637[i12] == 2)
					triangleColours2[i12] = 65535;
				anIntArray1637[i12] = 0;
			}
			if (i2 == 255) {
				face_render_priorities[i12] = nc3.readSignedByte();
			}
			if (j2 == 1) {
				anIntArray1639[i12] = nc4.readSignedByte();
				if (anIntArray1639[i12] < 0)
					anIntArray1639[i12] = (256 + anIntArray1639[i12]);
			}
			if (k2 == 1)
				triangleTSkin[i12] = nc5.readUnsignedByte();
			if (l2 == 1)
				D[i12] = (short) (nc6.readUnsignedWord() - 1);
			if (x != null)
				if (D[i12] != -1)
					x[i12] = (byte) (nc7.readUnsignedByte() - 1);
				else
					x[i12] = -1;
		}
		nc1.currentOffset = k7;
		nc2.currentOffset = j6;
		int k12 = 0;
		int i13 = 0;
		int k13 = 0;
		int l13 = 0;
		for (int i14 = 0; i14 < numTriangles; i14++) {
			int j14 = nc2.readUnsignedByte();
			if (j14 == 1) {
				k12 = nc1.method421() + l13;
				l13 = k12;
				i13 = nc1.method421() + l13;
				l13 = i13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 2) {
				i13 = k13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 3) {
				k12 = k13;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
			if (j14 == 4) {
				int l14 = k12;
				k12 = i13;
				i13 = l14;
				k13 = nc1.method421() + l13;
				l13 = k13;
				facePoint1[i14] = k12;
				facePoint2[i14] = i13;
				facePoint3[i14] = k13;
			}
		}
		nc1.currentOffset = j9;
		nc2.currentOffset = k9;
		nc3.currentOffset = l9;
		nc4.currentOffset = i10;
		nc5.currentOffset = j10;
		nc6.currentOffset = k10;
		for (int k14 = 0; k14 < numTexTriangles; k14++) {
			int i15 = O[k14] & 0xff;
			if (i15 == 0) {
				texTrianglesPoint1[k14] = nc1.readUnsignedWord();
				texTrianglesPoint2[k14] = nc1.readUnsignedWord();
				texTrianglesPoint3[k14] = nc1.readUnsignedWord();
			}
			if (i15 == 1) {
				texTrianglesPoint1[k14] = nc2.readUnsignedWord();
				texTrianglesPoint2[k14] = nc2.readUnsignedWord();
				texTrianglesPoint3[k14] = nc2.readUnsignedWord();
				kb[k14] = nc3.readUnsignedWord();
				N[k14] = nc3.readUnsignedWord();
				y[k14] = nc3.readUnsignedWord();
				gb[k14] = nc4.readSignedByte();
				lb[k14] = nc5.readSignedByte();
				F[k14] = nc6.readSignedByte();
			}
			if (i15 == 2) {
				texTrianglesPoint1[k14] = nc2.readUnsignedWord();
				texTrianglesPoint2[k14] = nc2.readUnsignedWord();
				texTrianglesPoint3[k14] = nc2.readUnsignedWord();
				kb[k14] = nc3.readUnsignedWord();
				N[k14] = nc3.readUnsignedWord();
				y[k14] = nc3.readUnsignedWord();
				gb[k14] = nc4.readSignedByte();
				lb[k14] = nc5.readSignedByte();
				F[k14] = nc6.readSignedByte();
				cb[k14] = nc6.readSignedByte();
				J[k14] = nc6.readSignedByte();
			}
			if (i15 == 3) {
				texTrianglesPoint1[k14] = nc2.readUnsignedWord();
				texTrianglesPoint2[k14] = nc2.readUnsignedWord();
				texTrianglesPoint3[k14] = nc2.readUnsignedWord();
				kb[k14] = nc3.readUnsignedWord();
				N[k14] = nc3.readUnsignedWord();
				y[k14] = nc3.readUnsignedWord();
				gb[k14] = nc4.readSignedByte();
				lb[k14] = nc5.readSignedByte();
				F[k14] = nc6.readSignedByte();
			}
		}
		if (i2 != 255) {
			for (int i12 = 0; i12 < numTriangles; i12++)
				face_render_priorities[i12] = i2;
		}
		triangleColour = triangleColours2;
		anInt1626 = numVertices;
		anInt1630 = numTriangles;
		anIntArray1627 = vertexX;
		anIntArray1628 = vertexY;
		anIntArray1629 = vertexZ;
		anIntArray1631 = facePoint1;
		anIntArray1632 = facePoint2;
		anIntArray1633 = facePoint3;
		filterTriangles();
		//System.out.println("NO FILTER here");
		convertTexturesTo317(modelID, D, texTrianglesPoint1, texTrianglesPoint2, texTrianglesPoint3, x);
	}
	/**
	 * 
	 * Refactored by Milo
	 * @param modelId
	 * @param textureIds
	 * @param texa
	 * @param texb
	 * @param texc
	 * @param texture_coordinates
	 */
	public void convertTexturesTo317(int modelId, short[] textureIds, int[] texa, int[] texb, int[] texc,
			byte[] texture_coordinates) {
		int set = 0;
		int set2 = 0;
		boolean osrs = (modelId == 59008 || modelId == 59009 || modelId == 59010 || modelId == 59011 || modelId == 59012 || modelId == 59013
				// Custom capes
		|| modelId == 59015 || modelId == 59016 || modelId == 59017 || modelId == 59018 || modelId == 59019 || modelId == 59020 || modelId == 59021 || modelId == 59022 || modelId == 59023
		 || modelId == 59024 || modelId == 59025 || modelId == 59026  || modelId == 59027 || modelId == 59028 || modelId == 59029 || modelId == 33144 || modelId == 33103 || modelId == 33111 || modelId == 99103 || modelId == 99111 || modelId == 99144 || modelId == 98144 || modelId == 98111 || modelId == 98103
				|| modelId == 97144 || modelId == 97111 || modelId == 97103 || modelId == 96144 || modelId == 96111 || modelId == 96103 || modelId == 96244 || modelId == 96211 || modelId == 96203
				|| modelId == 98102 || modelId == 98114 || modelId == 98145 || modelId == 99205 || modelId == 99102 || modelId == 99114 || modelId == 99145 || modelId == 28300 || modelId == 28301 || modelId == 28302 || modelId == 99300 || modelId == 99888 || modelId == 99889 || modelId == 99890
				|| modelId == 99892 || modelId == 98650 || modelId == 98651);
		int max = osrs ? Rasterizer.textureAmount : 50;
		if (textureIds != null) {
			anIntArray1643 = new int[anInt1630];
			anIntArray1644 = new int[anInt1630];
			anIntArray1645 = new int[anInt1630];
			for (int i = 0; i < anInt1630; i++) {

				if (textureIds[i] == -1 && anIntArray1637[i] == 2) {
					triangleColour[i] = 65535;
					anIntArray1637[i] = 0;
				}

				if (textureIds[i] >= max || textureIds[i] < 0 || textureIds[i] == 39) {
					anIntArray1637[i] = 0;
					continue;
				}
				
				switch(modelId) {
				
				case 99300:
				case 99892:
			//	case 98650:
			//	case 98651:
					textureIds[i] = 40;
					break;
					
				case 99205:
					textureIds[i] = 54;
					break;
				
				case 59015:
				case 59016:
				case 59017:
				case 98102:
				case 98114:
					textureIds[i] = 60;
				break;
				
				
				case 28300:
				case 28301:
				case 28302:
				textureIds[i] = 40;
				break;
				
				case 59018:
				case 59019:
				case 59020:
					textureIds[i] = 61;
					break;
					
				case 59021:
				case 59022:
				case 59023:
					textureIds[i] = 62;
					break;
					
				case 59024:
				case 59025:
				case 59026:
					textureIds[i] = 63;
					break;
					
				case 59027:
				case 59028:
				case 59029:
					textureIds[i] = 64;
					break;
					
				case 33144:
				case 33103:
				case 33111:
					textureIds[i] = 71;
					break;
				case 99144:
				case 99103:
				case 99111:
					textureIds[i] = 72;
					break;
				case 98144:
				case 98103:
				case 98111:
					textureIds[i] = 73;
					break;
				case 97144:
				case 97103:
				case 97111:
					textureIds[i] = 74;
					break;
				case 96144:
				case 96103:
				case 96111:
				case 99102:
				case 99114:
				case 99145:
					textureIds[i] = 68;
					break;
				case 99888:
				case 99889:
				case 99890:
					textureIds[i] = 71;
					break;
				case 96244:
				case 96203:
				case 96211:
					textureIds[i] = 60;
					break;
					
				}
				
				/*if (textureIds[i] == 59) {
					textureIds[i] = 60;
				}*/

				anIntArray1637[i] = 2 + set2;
				set2 += 4;
				int a = anIntArray1643[i];
				int b = anIntArray1644[i];
				int c = anIntArray1645[i];
				
				
				triangleColour[i] = textureIds[i];
				int texture_type = -1;

				if (texture_coordinates != null) {
					texture_type = texture_coordinates[i] & 0xff;
					if (texture_type != 0xff) {
						if (texa[texture_type] >= vertexPerspectiveDepth.length || texb[texture_type] >= anIntArray1669.length
								|| texc[texture_type] >= anIntArray1670.length) {
							texture_type = -1;
						}
					}
				}

				if (texture_type == 0xff) {
					texture_type = -1;
					//System.out.println("Yes was");
				}

				anIntArray1643[set] = texture_type == -1 ? a : texa[texture_type];
				anIntArray1644[set] = texture_type == -1 ? b : texb[texture_type];
				anIntArray1645[set++] = texture_type == -1 ? c : texc[texture_type];
			}
			anInt1642 = set;
		}
	}

	public void read622Model(byte abyte0[], int modelID) {
		Stream nc1 = new Stream(abyte0);
		Stream nc2 = new Stream(abyte0);
		Stream nc3 = new Stream(abyte0);
		Stream nc4 = new Stream(abyte0);
		Stream nc5 = new Stream(abyte0);
		Stream nc6 = new Stream(abyte0);
		Stream nc7 = new Stream(abyte0);
		nc1.currentOffset = abyte0.length - 23;
		int numVertices = nc1.readUnsignedWord();
		int numTriangles = nc1.readUnsignedWord();
		int numTexTriangles = nc1.readUnsignedByte();
		ModelHeader ModelDef_1 = modelHeader[modelID] = new ModelHeader();
		ModelDef_1.modelData = abyte0;
		ModelDef_1.verticeCount = numVertices;
		ModelDef_1.triangleCount = numTriangles;
		ModelDef_1.texturedTriangleCount = numTexTriangles;
		int l1 = nc1.readUnsignedByte();
		boolean bool = (0x1 & l1 ^ 0xffffffff) == -2;
		boolean bool_78_ = (l1 & 0x2 ^ 0xffffffff) == -3;
		boolean bool_25_ = (0x4 & l1) == 4;
		boolean bool_26_ = (0x8 & l1) == 8;
		if (!bool_26_) {
			read525Model(abyte0, modelID);
			return;
		}
		int newformat = 0;
		if (bool_26_) {
			nc1.currentOffset -= 7;
			newformat = nc1.readUnsignedByte();
			nc1.currentOffset += 6;
		}
		int i2 = nc1.readUnsignedByte();
		int j2 = nc1.readUnsignedByte();
		int k2 = nc1.readUnsignedByte();
		int l2 = nc1.readUnsignedByte();
		int i3 = nc1.readUnsignedByte();
		int j3 = nc1.readUnsignedWord();
		int k3 = nc1.readUnsignedWord();
		int l3 = nc1.readUnsignedWord();
		int i4 = nc1.readUnsignedWord();
		int j4 = nc1.readUnsignedWord();
		int k4 = 0;
		int l4 = 0;
		int i5 = 0;
		int v = 0;
		int hb = 0;
		int P = 0;
		byte G = 0;
		byte[] x = null;
		byte[] O = null;
		byte[] J = null;
		byte[] F = null;
		byte[] cb = null;
		byte[] gb = null;
		byte[] lb = null;
		int[] ab = null;
		int[] kb = null;
		int[] y = null;
		int[] N = null;
		short[] D = null;
		int[] triangleColours2 = new int[numTriangles];
		if (numTexTriangles > 0) {
			O = new byte[numTexTriangles];
			nc1.currentOffset = 0;
			for (int j5 = 0; j5 < numTexTriangles; j5++) {
				byte byte0 = O[j5] = nc1.readSignedByte();
				if (byte0 == 0)
					k4++;
				if (byte0 >= 1 && byte0 <= 3)
					l4++;
				if (byte0 == 2)
					i5++;
			}
		}
		int k5 = numTexTriangles;
		int l5 = k5;
		k5 += numVertices;
		int i6 = k5;
		if (bool)
			k5 += numTriangles;
		if (l1 == 1)
			k5 += numTriangles;
		int j6 = k5;
		k5 += numTriangles;
		int k6 = k5;
		if (i2 == 255)
			k5 += numTriangles;
		int l6 = k5;
		if (k2 == 1)
			k5 += numTriangles;
		int i7 = k5;
		if (i3 == 1)
			k5 += numVertices;
		int j7 = k5;
		if (j2 == 1)
			k5 += numTriangles;
		int k7 = k5;
		k5 += i4;
		int l7 = k5;
		if (l2 == 1)
			k5 += numTriangles * 2;
		int i8 = k5;
		k5 += j4;
		int j8 = k5;
		k5 += numTriangles * 2;
		int k8 = k5;
		k5 += j3;
		int l8 = k5;
		k5 += k3;
		int i9 = k5;
		k5 += l3;
		int j9 = k5;
		k5 += k4 * 6;
		int k9 = k5;
		k5 += l4 * 6;
		int i_59_ = 6;
		if (newformat != 14) {
			if (newformat >= 15)
				i_59_ = 9;
		} else
			i_59_ = 7;
		int l9 = k5;
		k5 += i_59_ * l4;
		int i10 = k5;
		k5 += l4;
		int j10 = k5;
		k5 += l4;
		int k10 = k5;
		k5 += l4 + i5 * 2;
		v = numVertices;
		hb = numTriangles;
		P = numTexTriangles;
		int[] vertexX = new int[numVertices];
		int[] vertexY = new int[numVertices];
		int[] vertexZ = new int[numVertices];
		int[] facePoint1 = new int[numTriangles];
		int[] facePoint2 = new int[numTriangles];
		int[] facePoint3 = new int[numTriangles];
		verticesParticle = new int[numVertices];
		vertexVSkin = new int[numVertices];
		anIntArray1637 = new int[numTriangles];
		face_render_priorities = new int[numTriangles];
		anIntArray1639 = new int[numTriangles];
		triangleTSkin = new int[numTriangles];
		if (i3 == 1)
			vertexVSkin = new int[numVertices];
		if (bool)
			anIntArray1637 = new int[numTriangles];
		if (i2 == 255)
			face_render_priorities = new int[numTriangles];
		else
			G = (byte) i2;
		if (j2 == 1)
			anIntArray1639 = new int[numTriangles];
		if (k2 == 1)
			triangleTSkin = new int[numTriangles];
		if (l2 == 1)
			D = new short[numTriangles];
		if (l2 == 1 && numTexTriangles > 0)
			x = new byte[numTriangles];
		triangleColours2 = new int[numTriangles];
		int i_115_ = k5;
		int[] texTrianglesPoint1 = null;
		int[] texTrianglesPoint2 = null;
		int[] texTrianglesPoint3 = null;
		if (numTexTriangles > 0) {
			texTrianglesPoint1 = new int[numTexTriangles];
			texTrianglesPoint2 = new int[numTexTriangles];
			texTrianglesPoint3 = new int[numTexTriangles];
			if (l4 > 0) {
				kb = new int[l4];
				N = new int[l4];
				y = new int[l4];
				gb = new byte[l4];
				lb = new byte[l4];
				F = new byte[l4];
			}
			if (i5 > 0) {
				cb = new byte[i5];
				J = new byte[i5];
			}
		}
		nc1.currentOffset = l5;
		nc2.currentOffset = k8;
		nc3.currentOffset = l8;
		nc4.currentOffset = i9;
		nc5.currentOffset = i7;
		int l10 = 0;
		int i11 = 0;
		int j11 = 0;
		for (int k11 = 0; k11 < numVertices; k11++) {
			int l11 = nc1.readUnsignedByte();
			int j12 = 0;
			if ((l11 & 1) != 0)
				j12 = nc2.method421();
			int l12 = 0;
			if ((l11 & 2) != 0)
				l12 = nc3.method421();
			int j13 = 0;
			if ((l11 & 4) != 0)
				j13 = nc4.method421();
			vertexX[k11] = l10 + j12;
			vertexY[k11] = i11 + l12;
			vertexZ[k11] = j11 + j13;
			l10 = vertexX[k11];
			i11 = vertexY[k11];
			j11 = vertexZ[k11];
			if (vertexVSkin != null)
				vertexVSkin[k11] = nc5.readUnsignedByte();
		}
		nc1.currentOffset = j8;
		nc2.currentOffset = i6;
		nc3.currentOffset = k6;
		nc4.currentOffset = j7;
		nc5.currentOffset = l6;
		nc6.currentOffset = l7;
		nc7.currentOffset = i8;
		for (int i12 = 0; i12 < numTriangles; i12++) {
			triangleColours2[i12] = nc1.readUnsignedWord();
			if (l1 == 1) {
				anIntArray1637[i12] = nc2.readSignedByte();
				if (anIntArray1637[i12] == 2)
					triangleColours2[i12] = 65535;
				anIntArray1637[i12] = 0;
			}
			if (i2 == 255) {
				face_render_priorities[i12] = nc3.readSignedByte();
			}
			if (j2 == 1) {
				anIntArray1639[i12] = nc4.readSignedByte();
				if (anIntArray1639[i12] < 0)
					anIntArray1639[i12] = (256 + anIntArray1639[i12]);
			}
			if (k2 == 1)
				triangleTSkin[i12] = nc5.readUnsignedByte();
			if (l2 == 1)
				D[i12] = (short) (nc6.readUnsignedWord() - 1);
			if (x != null)
				if (D[i12] != -1)
					x[i12] = (byte) (nc7.readUnsignedByte() - 1);
				else
					x[i12] = -1;
		}
		nc1.currentOffset = k7;
		nc2.currentOffset = j6;
		int point1 = 0;
		int point2 = 0;
		int point3 = 0;
		int offset = 0;
		for (int i14 = 0; i14 < numTriangles; i14++) {
			int triangleType = nc2.readUnsignedByte();
			if (triangleType == 1) {
				point1 = nc1.method421() + offset;
				offset = point1;
				point2 = nc1.method421() + offset;
				offset = point2;
				point3 = nc1.method421() + offset;
				offset = point3;
				facePoint1[i14] = point1;
				facePoint2[i14] = point2;
				facePoint3[i14] = point3;
			}
			if (triangleType == 2) {
				point2 = point3;
				point3 = nc1.method421() + offset;
				offset = point3;
				facePoint1[i14] = point1;
				facePoint2[i14] = point2;
				facePoint3[i14] = point3;
			}
			if (triangleType == 3) {
				point1 = point3;
				point3 = nc1.method421() + offset;
				offset = point3;
				facePoint1[i14] = point1;
				facePoint2[i14] = point2;
				facePoint3[i14] = point3;
			}
			if (triangleType == 4) {
				int pointOffset = point1;
				point1 = point2;
				point2 = pointOffset;
				point3 = nc1.method421() + offset;
				offset = point3;
				facePoint1[i14] = point1;
				facePoint2[i14] = point2;
				facePoint3[i14] = point3;
			}
		}
		nc1.currentOffset = j9;
		nc2.currentOffset = k9;
		nc3.currentOffset = l9;
		nc4.currentOffset = i10;
		nc5.currentOffset = j10;
		nc6.currentOffset = k10;
		for (int k14 = 0; k14 < numTexTriangles; k14++) {
			int i15 = O[k14] & 0xff;
			if (i15 == 0) {
				texTrianglesPoint1[k14] = nc1.readUnsignedWord();
				texTrianglesPoint2[k14] = nc1.readUnsignedWord();
				texTrianglesPoint3[k14] = nc1.readUnsignedWord();
			}
			if (i15 == 1) {
				texTrianglesPoint1[k14] = nc2.readUnsignedWord();
				texTrianglesPoint2[k14] = nc2.readUnsignedWord();
				texTrianglesPoint3[k14] = nc2.readUnsignedWord();
				if (newformat < 15) {
					kb[k14] = nc3.readUnsignedWord();
					if (newformat >= 14)
						N[k14] = nc3.v(-1);
					else
						N[k14] = nc3.readUnsignedWord();
					y[k14] = nc3.readUnsignedWord();
				} else {
					kb[k14] = nc3.v(-1);
					N[k14] = nc3.v(-1);
					y[k14] = nc3.v(-1);
				}
				gb[k14] = nc4.readSignedByte();
				lb[k14] = nc5.readSignedByte();
				F[k14] = nc6.readSignedByte();
			}
			if (i15 == 2) {
				texTrianglesPoint1[k14] = nc2.readUnsignedWord();
				texTrianglesPoint2[k14] = nc2.readUnsignedWord();
				texTrianglesPoint3[k14] = nc2.readUnsignedWord();
				if (newformat >= 15) {
					kb[k14] = nc3.v(-1);
					N[k14] = nc3.v(-1);
					y[k14] = nc3.v(-1);
				} else {
					kb[k14] = nc3.readUnsignedWord();
					if (newformat < 14)
						N[k14] = nc3.readUnsignedWord();
					else
						N[k14] = nc3.v(-1);
					y[k14] = nc3.readUnsignedWord();
				}
				gb[k14] = nc4.readSignedByte();
				lb[k14] = nc5.readSignedByte();
				F[k14] = nc6.readSignedByte();
				cb[k14] = nc6.readSignedByte();
				J[k14] = nc6.readSignedByte();
			}
			if (i15 == 3) {
				texTrianglesPoint1[k14] = nc2.readUnsignedWord();
				texTrianglesPoint2[k14] = nc2.readUnsignedWord();
				texTrianglesPoint3[k14] = nc2.readUnsignedWord();
				if (newformat < 15) {
					kb[k14] = nc3.readUnsignedWord();
					if (newformat < 14)
						N[k14] = nc3.readUnsignedWord();
					else
						N[k14] = nc3.v(-1);
					y[k14] = nc3.readUnsignedWord();
				} else {
					kb[k14] = nc3.v(-1);
					N[k14] = nc3.v(-1);
					y[k14] = nc3.v(-1);
				}
				gb[k14] = nc4.readSignedByte();
				lb[k14] = nc5.readSignedByte();
				F[k14] = nc6.readSignedByte();
			}
		}
		if (i2 != 255) {
			for (int i12 = 0; i12 < numTriangles; i12++)
				face_render_priorities[i12] = i2;
		}
		triangleColour = triangleColours2;
		anInt1626 = numVertices;
		anInt1630 = numTriangles;
		anIntArray1627 = vertexX;
		anIntArray1628 = vertexY;
		anIntArray1629 = vertexZ;
		anIntArray1631 = facePoint1;
		anIntArray1632 = facePoint2;
		anIntArray1633 = facePoint3;
		filterTriangles();
		//new
		convertTexturesTo317(modelID, D, texTrianglesPoint1, texTrianglesPoint2, texTrianglesPoint3, x);
		if (bool_26_) {
			this.downscale();

			for (int j = 0; j < face_render_priorities.length; j++) {
				face_render_priorities[j] = 10;
			}
		}
		
	}

	private void readOldModel(int i) {
		int j = -870;
		aBoolean1618 = true;
		rendersWithinOneTile = false;
		anInt1620++;
		ModelHeader header = modelHeader[i];
		anInt1626 = header.verticeCount;
		anInt1630 = header.triangleCount;
		anInt1642 = header.texturedTriangleCount;
		verticesParticle = new int[anInt1626];
		anIntArray1627 = new int[anInt1626];
		anIntArray1628 = new int[anInt1626];
		anIntArray1629 = new int[anInt1626];
		anIntArray1631 = new int[anInt1630];
		anIntArray1632 = new int[anInt1630];
		while (j >= 0)
			aBoolean1618 = !aBoolean1618;
		anIntArray1633 = new int[anInt1630];
		anIntArray1643 = new int[anInt1642];
		anIntArray1644 = new int[anInt1642];
		anIntArray1645 = new int[anInt1642];
		if (header.vskinBasePos >= 0)
			vertexVSkin = new int[anInt1626];
		if (header.drawTypeBasePos >= 0)
			anIntArray1637 = new int[anInt1630];
		if (header.facePriorityBasePos >= 0)
			face_render_priorities = new int[anInt1630];
		else
			face_priority = -header.facePriorityBasePos - 1;
		if (header.alphaBasepos >= 0)
			anIntArray1639 = new int[anInt1630];
		if (header.tskinBasepos >= 0)
			triangleTSkin = new int[anInt1630];
		triangleColour = new int[anInt1630];
		Stream stream = new Stream(header.modelData);
		stream.currentOffset = header.verticesModOffset;
		Stream stream_1 = new Stream(header.modelData);
		stream_1.currentOffset = header.verticesXOffset;
		Stream stream_2 = new Stream(header.modelData);
		stream_2.currentOffset = header.verticesYOffset;
		Stream stream_3 = new Stream(header.modelData);
		stream_3.currentOffset = header.verticesZOffset;
		Stream stream_4 = new Stream(header.modelData);
		stream_4.currentOffset = header.vskinBasePos;
		int k = 0;
		int l = 0;
		int i1 = 0;
		for (int j1 = 0; j1 < anInt1626; j1++) {
			int k1 = stream.readUnsignedByte();
			int i2 = 0;
			if ((k1 & 1) != 0)
				i2 = stream_1.method421();
			int k2 = 0;
			if ((k1 & 2) != 0)
				k2 = stream_2.method421();
			int i3 = 0;
			if ((k1 & 4) != 0)
				i3 = stream_3.method421();
			anIntArray1627[j1] = k + i2;
			anIntArray1628[j1] = l + k2;
			anIntArray1629[j1] = i1 + i3;
			k = anIntArray1627[j1];
			l = anIntArray1628[j1];
			i1 = anIntArray1629[j1];
			if (vertexVSkin != null)
				vertexVSkin[j1] = stream_4.readUnsignedByte();
		}
		stream.currentOffset = header.triColourOffset;
		stream_1.currentOffset = header.drawTypeBasePos;
		stream_2.currentOffset = header.facePriorityBasePos;
		stream_3.currentOffset = header.alphaBasepos;
		stream_4.currentOffset = header.tskinBasepos;
		for (int l1 = 0; l1 < anInt1630; l1++) {
			triangleColour[l1] = stream.readUnsignedWord();
			if (anIntArray1637 != null)
				anIntArray1637[l1] = stream_1.readUnsignedByte();
			if (face_render_priorities != null)
				face_render_priorities[l1] = stream_2.readUnsignedByte();
			if (anIntArray1639 != null) {
				anIntArray1639[l1] = stream_3.readUnsignedByte();
			}
			if (triangleTSkin != null)
				triangleTSkin[l1] = stream_4.readUnsignedByte();
		}
		if(anIntArray1639 == null)
			anIntArray1639 = new int[anInt1630];
		stream.currentOffset = header.triVPointOffset;
		stream_1.currentOffset = header.triMeshLinkOffset;
		int j2 = 0;
		int l2 = 0;
		int j3 = 0;
		int k3 = 0;
		for (int l3 = 0; l3 < anInt1630; l3++) {
			int i4 = stream_1.readUnsignedByte();
			if (i4 == 1) {
				j2 = stream.method421() + k3;
				k3 = j2;
				l2 = stream.method421() + k3;
				k3 = l2;
				j3 = stream.method421() + k3;
				k3 = j3;
				anIntArray1631[l3] = j2;
				anIntArray1632[l3] = l2;
				anIntArray1633[l3] = j3;
			}
			if (i4 == 2) {
				j2 = j2;
				l2 = j3;
				j3 = stream.method421() + k3;
				k3 = j3;
				anIntArray1631[l3] = j2;
				anIntArray1632[l3] = l2;
				anIntArray1633[l3] = j3;
			}
			if (i4 == 3) {
				j2 = j3;
				l2 = l2;
				j3 = stream.method421() + k3;
				k3 = j3;
				anIntArray1631[l3] = j2;
				anIntArray1632[l3] = l2;
				anIntArray1633[l3] = j3;
			}
			if (i4 == 4) {
				int k4 = j2;
				j2 = l2;
				l2 = k4;
				j3 = stream.method421() + k3;
				k3 = j3;
				anIntArray1631[l3] = j2;
				anIntArray1632[l3] = l2;
				anIntArray1633[l3] = j3;
			}
		}
		stream.currentOffset = header.textureInfoBasePos;
		for (int j4 = 0; j4 < anInt1642; j4++) {
			anIntArray1643[j4] = stream.readUnsignedWord();
			anIntArray1644[j4] = stream.readUnsignedWord();
			anIntArray1645[j4] = stream.readUnsignedWord();
		}
		
		//System.out.println("NO FI yeeeeLTER here for model id: " + i);
	}

	private int particleColors = -1;

	public void setParticleColors(int colors) {
		this.particleColors = colors;
	}

	public int getParticleColors() {
		return particleColors;
	}

	public final void removeColors(int[] colors) {
		for (int i = 0; i < anInt1630; i++) {
			if (triangleColour != null) {
				for (int col : colors) {
					if (triangleColour[i] == col) {
						anIntArray1631[i] = 0;
						anIntArray1632[i] = 0;
						anIntArray1633[i] = 0;
					}
				}
			}
		}
	}

	public void forceRecolour(int i, int j) {
		for (int k = 0; k < anInt1630; k++)
			triangleColour[k] = j;
	}

	public void setAlphaToColor(int i, int j) {
		for(int k = 0; k < anInt1630; ++k) {
			if(triangleColour[k] == i) {
				anIntArray1639[k] = j;
			}
		}
	}

	public void recolour(int initialColour, int targetColour) {
		for (int k = 0; k < anInt1630; k++)
			if (triangleColour[k] == initialColour) {
				triangleColour[k] = targetColour;
			}
	}

	private final void method485(int i) {
		int j = Rasterizer.textureInt1;
		int k = Rasterizer.textureInt2;
		int l = 0;
		int i1 = anIntArray1631[i];
		int j1 = anIntArray1632[i];
		int k1 = anIntArray1633[i];

		int l1 = anIntArray1670[i1];
		int i2 = anIntArray1670[j1];
		int j2 = anIntArray1670[k1];

		if (l1 >= 50) {
			anIntArray1678[l] = anIntArray1665[i1];
			anIntArray1679[l] = anIntArray1666[i1];
			anIntArray1680[l++] = anIntArray1634[i];
		} else {
			int k2 = anIntArray1668[i1];
			int k3 = anIntArray1669[i1];
			int k4 = anIntArray1634[i];
			if (j2 >= 50) {
				int k5 = (50 - l1) * lightDecay[j2 - l1];
				anIntArray1678[l] = j + (k2 + ((anIntArray1668[k1] - k2) * k5 >> 16)) * WorldController.focalLength / 50;
				anIntArray1679[l] = k + (k3 + ((anIntArray1669[k1] - k3) * k5 >> 16)) * WorldController.focalLength / 50;
				anIntArray1680[l++] = k4 + ((anIntArray1636[i] - k4) * k5 >> 16);
			}
			if (i2 >= 50) {
				int l5 = (50 - l1) * lightDecay[i2 - l1];
				anIntArray1678[l] = j
						+ (k2 + ((anIntArray1668[j1] - k2) * l5 >> 16)) * WorldController.focalLength
						/ 50;
				anIntArray1679[l] = k
						+ (k3 + ((anIntArray1669[j1] - k3) * l5 >> 16)) * WorldController.focalLength
						/ 50;
				anIntArray1680[l++] = k4
						+ ((anIntArray1635[i] - k4) * l5 >> 16);
			}
		}
		if (i2 >= 50) {
			anIntArray1678[l] = anIntArray1665[j1];
			anIntArray1679[l] = anIntArray1666[j1];
			anIntArray1680[l++] = anIntArray1635[i];
		} else {
			int l2 = anIntArray1668[j1];
			int l3 = anIntArray1669[j1];
			int l4 = anIntArray1635[i];
			if (l1 >= 50) {
				int i6 = (50 - i2) * lightDecay[l1 - i2];
				anIntArray1678[l] = j
						+ (l2 + ((anIntArray1668[i1] - l2) * i6 >> 16)) * WorldController.focalLength
						/ 50;
				anIntArray1679[l] = k
						+ (l3 + ((anIntArray1669[i1] - l3) * i6 >> 16)) * WorldController.focalLength
						/ 50;
				anIntArray1680[l++] = l4
						+ ((anIntArray1634[i] - l4) * i6 >> 16);
			}
			if (j2 >= 50) {
				int j6 = (50 - i2) * lightDecay[j2 - i2];
				anIntArray1678[l] = j
						+ (l2 + ((anIntArray1668[k1] - l2) * j6 >> 16)) * WorldController.focalLength
						/ 50;
				anIntArray1679[l] = k
						+ (l3 + ((anIntArray1669[k1] - l3) * j6 >> 16)) * WorldController.focalLength
						/ 50;
				anIntArray1680[l++] = l4
						+ ((anIntArray1636[i] - l4) * j6 >> 16);
			}
		}
		if (j2 >= 50) {
			anIntArray1678[l] = anIntArray1665[k1];
			anIntArray1679[l] = anIntArray1666[k1];
			anIntArray1680[l++] = anIntArray1636[i];
		} else {
			int i3 = anIntArray1668[k1];
			int i4 = anIntArray1669[k1];
			int i5 = anIntArray1636[i];
			if (i2 >= 50) {
				int k6 = (50 - j2) * lightDecay[i2 - j2];
				anIntArray1678[l] = j
						+ (i3 + ((anIntArray1668[j1] - i3) * k6 >> 16)) * WorldController.focalLength
						/ 50;
				anIntArray1679[l] = k
						+ (i4 + ((anIntArray1669[j1] - i4) * k6 >> 16)) * WorldController.focalLength
						/ 50;
				anIntArray1680[l++] = i5
						+ ((anIntArray1635[i] - i5) * k6 >> 16);
			}
			if (l1 >= 50) {
				int l6 = (50 - j2) * lightDecay[l1 - j2];
				anIntArray1678[l] = j
						+ (i3 + ((anIntArray1668[i1] - i3) * l6 >> 16)) * WorldController.focalLength
						/ 50;
				anIntArray1679[l] = k
						+ (i4 + ((anIntArray1669[i1] - i4) * l6 >> 16)) * WorldController.focalLength
						/ 50;
				anIntArray1680[l++] = i5
						+ ((anIntArray1634[i] - i5) * l6 >> 16);
			}
		}
		int j3 = anIntArray1678[0];
		int j4 = anIntArray1678[1];
		int j5 = anIntArray1678[2];
		int i7 = anIntArray1679[0];
		int j7 = anIntArray1679[1];
		int k7 = anIntArray1679[2];
		if ((j3 - j4) * (k7 - j7) - (i7 - j7) * (j5 - j4) > 0) {
			Rasterizer.aBoolean1462 = false;
			if (l == 3) {
				if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.viewportRX
						|| j4 > DrawingArea.viewportRX || j5 > DrawingArea.viewportRX)
					Rasterizer.aBoolean1462 = true;
				int l7;
				if (anIntArray1637 == null)
					l7 = 0;
				else
					l7 = anIntArray1637[i] & 3;
				if (l7 == 0)
					Rasterizer.drawGouraudTriangle(i7, j7, k7, j3, j4, j5,
							anIntArray1680[0], anIntArray1680[1],
							anIntArray1680[2], -1, -1, -1);
				else if (l7 == 1)
					Rasterizer.drawFlatTriangle(i7, j7, k7, j3, j4, j5,
							hsl2rgb[anIntArray1634[i]], -1, -1, -1);
				else if (l7 == 2) {
					int j8 = anIntArray1637[i] >> 2;
					int k9 = anIntArray1643[j8];
					int k10 = anIntArray1644[j8];
					int k11 = anIntArray1645[j8];
					Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5,
							anIntArray1680[0], anIntArray1680[1],
							anIntArray1680[2], anIntArray1668[k9],
							anIntArray1668[k10], anIntArray1668[k11],
							anIntArray1669[k9], anIntArray1669[k10],
							anIntArray1669[k11], anIntArray1670[k9],
							anIntArray1670[k10], anIntArray1670[k11],
							triangleColour[i], -1, -1, -1);
				} else if (l7 == 3) {
					int k8 = anIntArray1637[i] >> 2;
					int l9 = anIntArray1643[k8];
					int l10 = anIntArray1644[k8];
					int l11 = anIntArray1645[k8];
					Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5,
							anIntArray1634[i], anIntArray1634[i],
							anIntArray1634[i], anIntArray1668[l9],
							anIntArray1668[l10], anIntArray1668[l11],
							anIntArray1669[l9], anIntArray1669[l10],
							anIntArray1669[l11], anIntArray1670[l9],
							anIntArray1670[l10], anIntArray1670[l11],
							triangleColour[i], -1, -1, -1);
				}
			}
			if (l == 4) {
				if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.viewportRX
						|| j4 > DrawingArea.viewportRX || j5 > DrawingArea.viewportRX
						|| anIntArray1678[3] < 0
						|| anIntArray1678[3] > DrawingArea.viewportRX)
					Rasterizer.aBoolean1462 = true;
				int i8;
				if (anIntArray1637 == null)
					i8 = 0;
				else
					i8 = anIntArray1637[i] & 3;
				if (i8 == 0) {
					Rasterizer.drawGouraudTriangle(i7, j7, k7, j3, j4, j5,
							anIntArray1680[0], anIntArray1680[1],
							anIntArray1680[2], -1, -1, -1);
					Rasterizer.drawGouraudTriangle(i7, k7, anIntArray1679[3], j3, j5,
							anIntArray1678[3], anIntArray1680[0],
							anIntArray1680[2], anIntArray1680[3], -1, -1, -1);
					return;
				}
				if (i8 == 1) {
					int l8 = hsl2rgb[anIntArray1634[i]];
					Rasterizer.drawFlatTriangle(i7, j7, k7, j3, j4, j5, l8, -1, -1, -1);
					Rasterizer.drawFlatTriangle(i7, k7, anIntArray1679[3], j3, j5,
							anIntArray1678[3], l8, -1, -1, -1);
					return;
				}
				if (i8 == 2) {
					int i9 = anIntArray1637[i] >> 2;
					int i10 = anIntArray1643[i9];
					int i11 = anIntArray1644[i9];
					int i12 = anIntArray1645[i9];
					Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5,
							anIntArray1680[0], anIntArray1680[1],
							anIntArray1680[2], anIntArray1668[i10],
							anIntArray1668[i11], anIntArray1668[i12],
							anIntArray1669[i10], anIntArray1669[i11],
							anIntArray1669[i12], anIntArray1670[i10],
							anIntArray1670[i11], anIntArray1670[i12],
							triangleColour[i], -1, -1, -1);
					Rasterizer.drawTexturedTriangle(i7, k7, anIntArray1679[3], j3, j5,
							anIntArray1678[3], anIntArray1680[0],
							anIntArray1680[2], anIntArray1680[3],
							anIntArray1668[i10], anIntArray1668[i11],
							anIntArray1668[i12], anIntArray1669[i10],
							anIntArray1669[i11], anIntArray1669[i12],
							anIntArray1670[i10], anIntArray1670[i11],
							anIntArray1670[i12], triangleColour[i], -1, -1, -1);
					return;
				}
				if (i8 == 3) {
					int j9 = anIntArray1637[i] >> 2;
					int j10 = anIntArray1643[j9];
					int j11 = anIntArray1644[j9];
					int j12 = anIntArray1645[j9];
					Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5,
							anIntArray1634[i], anIntArray1634[i],
							anIntArray1634[i], anIntArray1668[j10],
							anIntArray1668[j11], anIntArray1668[j12],
							anIntArray1669[j10], anIntArray1669[j11],
							anIntArray1669[j12], anIntArray1670[j10],
							anIntArray1670[j11], anIntArray1670[j12],
							triangleColour[i], -1, -1, -1);
					Rasterizer.drawTexturedTriangle(i7, k7, anIntArray1679[3], j3, j5,
							anIntArray1678[3], anIntArray1634[i],
							anIntArray1634[i], anIntArray1634[i],
							anIntArray1668[j10], anIntArray1668[j11],
							anIntArray1668[j12], anIntArray1669[j10],
							anIntArray1669[j11], anIntArray1669[j12],
							anIntArray1670[j10], anIntArray1670[j11],
							anIntArray1670[j12], triangleColour[i], -1, -1, -1);
				}
			}
		}
	}

	public final void renderAtPoint(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int id) {
		renderAtPointX = j1 + Client.instance.xCameraPos;
		renderAtPointY = l1 + Client.instance.yCameraPos;
		renderAtPointZ = k1 + Client.instance.zCameraPos;
		lastRenderedRotation = i;
		int j2 = l1 * i1 - j1 * l >> 16;
		int k2 = k1 * j + j2 * k >> 16;
		int l2 = anInt1650 * k >> 16;
		int i3 = k2 + l2;
		if (i3 <= 50 || k2 >= farClip)
			return;
		int j3 = l1 * l + j1 * i1 >> 16;
		int k3 = (j3 - anInt1650) * WorldController.focalLength;
		if (k3 / i3 >= DrawingArea.viewport_centerX)
			return;
		int l3 = (j3 + anInt1650) * WorldController.focalLength;
		if (l3 / i3 <= -DrawingArea.viewport_centerX)
			return;
		int i4 = k1 * k - j2 * j >> 16;
		int j4 = anInt1650 * j >> 16;
		int k4 = (i4 + j4) * WorldController.focalLength;
		if (k4 / i3 <= -DrawingArea.viewport_centerY)
			return;
		int l4 = j4 + (super.modelHeight * k >> 16);
		int i5 = (i4 - l4) * WorldController.focalLength;
		if (i5 / i3 >= DrawingArea.viewport_centerY)
			return;
		int j5 = l2 + (super.modelHeight * j >> 16);
		boolean flag = false;
		if (k2 - j5 <= 50)
			flag = true;
		boolean flag1 = false;
		if (i2 > 0 && aBoolean1684) {
			int k5 = k2 - l2;
			if (k5 <= 50)
				k5 = 50;
			if (j3 > 0) {
				k3 /= i3;
				l3 /= k5;
			} else {
				l3 /= i3;
				k3 /= k5;
			}
			if (i4 > 0) {
				i5 /= i3;
				k4 /= k5;
			} else {
				k4 /= i3;
				i5 /= k5;
			}
			int i6 = currentCursorX - Rasterizer.textureInt1;
			int k6 = currentCursorY - Rasterizer.textureInt2;
			if (i6 > k3 && i6 < l3 && k6 > i5 && k6 < k4)
				if (rendersWithinOneTile) {
					mapObjectIds[objectsRendered] = id;
					objectsInCurrentRegion[objectsRendered++] = i2;
				} else
					flag1 = true;
		}
		int l5 = Rasterizer.textureInt1;
		int j6 = Rasterizer.textureInt2;
		int l6 = 0;
		int i7 = 0;
		if (i != 0) {
			l6 = SINE[i];
			i7 = COSINE[i];
		}
		for (int j7 = 0; j7 < anInt1626; j7++) {
			int k7 = anIntArray1627[j7];
			int l7 = anIntArray1628[j7];
			int i8 = anIntArray1629[j7];
			if (i != 0) {
				int j8 = i8 * l6 + k7 * i7 >> 16;
				i8 = i8 * i7 - k7 * l6 >> 16;
				k7 = j8;
			}
			k7 += j1;
			l7 += k1;
			i8 += l1;
			int k8 = i8 * l + k7 * i1 >> 16;
			i8 = i8 * i1 - k7 * l >> 16;
			k7 = k8;
			k8 = l7 * k - i8 * j >> 16;
			i8 = l7 * j + i8 * k >> 16;
			l7 = k8;
			anIntArray1667[j7] = i8 - k2;
			vertexPerspectiveDepth[j7] = i8;
			if (i8 >= 50) {
				anIntArray1665[j7] = l5 + k7 * WorldController.focalLength / i8;
				anIntArray1666[j7] = j6 + l7 * WorldController.focalLength / i8;
			} else {
				anIntArray1665[j7] = -5000;
				flag = true;
			}
			if (flag || anInt1642 > 0) {
				anIntArray1668[j7] = k7;
				anIntArray1669[j7] = l7;
				anIntArray1670[j7] = i8;
			}
		}

		try {
			translateToScreen(flag, flag1, i2, id);
			return;
		} catch (Exception _ex) {
			return;
		}
	}

	public void renderSingle(int rotation_2, int offsetX, int rotation_1, int offsetY, int zoom_sine, int zoom_cosine) {
		try {
			int i = 0;
			int base_draw_x = Rasterizer.textureInt1;
			int base_draw_y = Rasterizer.textureInt2;
			int base_sine = SINE[i];
			int base_cosine = COSINE[i];
			int rot_2_sine = SINE[rotation_2];
			int rot_2_cosine = COSINE[rotation_2];
			int offsetX_sine = SINE[offsetX];
			int offsetX_cosine = COSINE[offsetX];
			int rot_1_sine = SINE[rotation_1];
			int rot_1_cosine = COSINE[rotation_1];
			int calculated_zoom = zoom_sine * rot_1_sine + zoom_cosine * rot_1_cosine >> 16;
			for (int vertexId = 0; vertexId < anInt1626; vertexId++) {
				int baseVertexX = anIntArray1627[vertexId];
				int baseVertexY = anIntArray1628[vertexId];
				int baseVertexZ = anIntArray1629[vertexId];
				if (offsetX != 0) {
					int calculatedVertexX = baseVertexY * offsetX_sine + baseVertexX * offsetX_cosine >> 16;
					baseVertexY = baseVertexY * offsetX_cosine - baseVertexX * offsetX_sine >> 16;
					baseVertexX = calculatedVertexX;
				}
				if (i != 0) {
					int calculatedVertexY = baseVertexY * base_cosine - baseVertexZ * base_sine >> 16;
					baseVertexZ = baseVertexY * base_sine + baseVertexZ * base_cosine >> 16;
					baseVertexY = calculatedVertexY;
				}
				if (rotation_2 != 0) {
					int calculatedVertexZ = baseVertexZ * rot_2_sine + baseVertexX * rot_2_cosine >> 16;
					baseVertexZ = baseVertexZ * rot_2_cosine - baseVertexX * rot_2_sine >> 16;
					baseVertexX = calculatedVertexZ;
				}
				baseVertexX += offsetY;
				baseVertexY += zoom_sine;
				baseVertexZ += zoom_cosine;
				int j6 = baseVertexY * rot_1_cosine - baseVertexZ * rot_1_sine >> 16;
				baseVertexZ = baseVertexY * rot_1_sine + baseVertexZ * rot_1_cosine >> 16;
				baseVertexY = j6;
				anIntArray1667[vertexId] = baseVertexZ - calculated_zoom;
				anIntArray1665[vertexId] = base_draw_x + (baseVertexX << 9) / baseVertexZ;
				anIntArray1666[vertexId] = base_draw_y + (baseVertexY << 9) / baseVertexZ;
				vertexPerspectiveDepth[vertexId] = baseVertexZ;
				if (anInt1642 > 0) {
					anIntArray1668[vertexId] = baseVertexX;
					anIntArray1669[vertexId] = baseVertexY;
					anIntArray1670[vertexId] = baseVertexZ;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			translateToScreen(false, false, 0, -1);
			return;
		} catch (Exception _ex) {
			return;
		}
	}

	public void reset() {
		anIntArray1627 = null;
		anIntArray1628 = null;
		anIntArray1629 = null;
		anIntArray1631 = null;
		anIntArray1632 = null;
		anIntArray1633 = null;
		anIntArray1634 = null;
		anIntArray1635 = null;
		anIntArray1636 = null;
		anIntArray1637 = null;
		face_render_priorities = null;
		anIntArray1639 = null;
		triangleColour = null;
		anIntArray1643 = anIntArray1644 = anIntArray1645 = null;
		vertexVSkin = null;
		triangleTSkin = null;
		vertexSkin = null;
		triangleSkin = null;
		vertexNormalOffset = null;
	}

	public void rotateBy90() {
		for (int j = 0; j < anInt1626; j++) {
			int k = anIntArray1627[j];
			anIntArray1627[j] = anIntArray1629[j];
			anIntArray1629[j] = -k;
		}
	}

	public void rotateX(int i) {
		int k = SINE[i];
		int l = COSINE[i];
		for (int i1 = 0; i1 < anInt1626; i1++) {
			int j1 = anIntArray1628[i1] * l - anIntArray1629[i1] * k >> 16;
			anIntArray1629[i1] = anIntArray1628[i1] * k + anIntArray1629[i1] * l >> 16;
			anIntArray1628[i1] = j1;
		}
	}

	private void downscale() {
		for (int i = 0; i < anInt1626; ++i) {
			anIntArray1627[i] = (anIntArray1627[i] + 7) >> 2;
			anIntArray1628[i] = (anIntArray1628[i] + 7) >> 2;
			anIntArray1629[i] = (anIntArray1629[i] + 7) >> 2;
		}
	}

	public void scaleT(int i, int j, int l) { // x,y,z iirc
		for (int i1 = 0; i1 < anInt1626; i1++) {
			anIntArray1627[i1] = (anIntArray1627[i1] * i) / 128;
			anIntArray1628[i1] = (anIntArray1628[i1] * l) / 128;
			anIntArray1629[i1] = (anIntArray1629[i1] * j) / 128;
		}

	}

	public void translate(int x, int y, int z) {
		for (int i1 = 0; i1 < anInt1626; i1++) {
			anIntArray1627[i1] += x;
			anIntArray1628[i1] += y;
			anIntArray1629[i1] += z;
		}
	}

	private final void translateToScreen(boolean flag, boolean needAddToSelectedObjects, int i, int id) {
		for (int j = 0; j < diagonal3D; j++)
			depthListIndices[j] = 0;

		for (int triangleId = 0; triangleId < anInt1630; triangleId++) {
			int face_a_pos = anIntArray1631[triangleId];
			int face_b_pos = anIntArray1632[triangleId];
			int face_c_pos = anIntArray1633[triangleId];

			int vertexXA = anIntArray1665[face_a_pos];
			int vertexXB = anIntArray1665[face_b_pos];
			int vertexXC = anIntArray1665[face_c_pos];
			if (flag && (vertexXA == -5000 || vertexXB == -5000 || vertexXC == -5000)) {
				aBooleanArray1664[triangleId] = true;
				int j5 = (anIntArray1667[face_a_pos] + anIntArray1667[face_b_pos] + anIntArray1667[face_c_pos]) / 3
						+ boundingCylinderRadius;
				faceLists[j5][depthListIndices[j5]++] = triangleId;
				continue;
			}
			if (needAddToSelectedObjects && cursorOn(currentCursorX, currentCursorY, anIntArray1666[face_a_pos],
					anIntArray1666[face_b_pos], anIntArray1666[face_c_pos], vertexXA, vertexXB, vertexXC)) {
				mapObjectIds[objectsRendered] = id;
				objectsInCurrentRegion[objectsRendered++] = i;
				needAddToSelectedObjects = false;
			}
			if ((vertexXA - vertexXB) * (anIntArray1666[face_c_pos] - anIntArray1666[face_b_pos])
					- (anIntArray1666[face_a_pos] - anIntArray1666[face_b_pos]) * (vertexXC - vertexXB) > 0) {
				aBooleanArray1664[triangleId] = false;
				hasAnEdgeToRestrict[triangleId] = vertexXA < 0 || vertexXB < 0 || vertexXC < 0
						|| vertexXA > DrawingArea.viewportRX || vertexXB > DrawingArea.viewportRX
						|| vertexXC > DrawingArea.viewportRX;
				int k5 = (anIntArray1667[face_a_pos] + anIntArray1667[face_b_pos] + anIntArray1667[face_c_pos]) / 3
						+ boundingCylinderRadius;
				faceLists[k5][depthListIndices[k5]++] = triangleId;
			}
		}

		if (face_render_priorities == null) {
			for (int i1 = diagonal3D - 1; i1 >= 0; i1--) {
				int l1 = depthListIndices[i1];
				if (l1 > 0) {
					int ai[] = faceLists[i1];
					for (int j3 = 0; j3 < l1; j3++)
						method484(ai[j3]);

				}
			}

			return;
		}
		for (int j1 = 0; j1 < 12; j1++) {
			anIntArray1673[j1] = 0;
			anIntArray1677[j1] = 0;
		}

		for (int i2 = diagonal3D - 1; i2 >= 0; i2--) {
			int k2 = depthListIndices[i2];
			if (k2 > 0) {
				int ai1[] = faceLists[i2];
				for (int i4 = 0; i4 < k2; i4++) {
					int l4 = ai1[i4];
					int l5 = face_render_priorities[l4];
					int j6 = anIntArray1673[l5]++;
					anIntArrayArray1674[l5][j6] = l4;
					if (l5 < 10)
						anIntArray1677[l5] += i2;
					else if (l5 == 10)
						anIntArray1675[j6] = i2;
					else
						anIntArray1676[j6] = i2;
				}

			}
		}

		int l2 = 0;
		if (anIntArray1673[1] > 0 || anIntArray1673[2] > 0)
			l2 = (anIntArray1677[1] + anIntArray1677[2]) / (anIntArray1673[1] + anIntArray1673[2]);
		int k3 = 0;
		if (anIntArray1673[3] > 0 || anIntArray1673[4] > 0)
			k3 = (anIntArray1677[3] + anIntArray1677[4]) / (anIntArray1673[3] + anIntArray1673[4]);
		int j4 = 0;
		if (anIntArray1673[6] > 0 || anIntArray1673[8] > 0)
			j4 = (anIntArray1677[6] + anIntArray1677[8]) / (anIntArray1673[6] + anIntArray1673[8]);
		int i6 = 0;
		int k6 = anIntArray1673[10];
		int ai2[] = anIntArrayArray1674[10];
		int ai3[] = anIntArray1675;
		if (i6 == k6) {
			i6 = 0;
			k6 = anIntArray1673[11];
			ai2 = anIntArrayArray1674[11];
			ai3 = anIntArray1676;
		}
		int i5;
		if (i6 < k6)
			i5 = ai3[i6];
		else
			i5 = -1000;
		for (int l6 = 0; l6 < 10; l6++) {
			while (l6 == 0 && i5 > l2) {
				method484(ai2[i6++]);
				if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
					i6 = 0;
					k6 = anIntArray1673[11];
					ai2 = anIntArrayArray1674[11];
					ai3 = anIntArray1676;
				}
				if (i6 < k6)
					i5 = ai3[i6];
				else
					i5 = -1000;
			}
			while (l6 == 3 && i5 > k3) {
				method484(ai2[i6++]);
				if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
					i6 = 0;
					k6 = anIntArray1673[11];
					ai2 = anIntArrayArray1674[11];
					ai3 = anIntArray1676;
				}
				if (i6 < k6)
					i5 = ai3[i6];
				else
					i5 = -1000;
			}
			while (l6 == 5 && i5 > j4) {
				method484(ai2[i6++]);
				if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
					i6 = 0;
					k6 = anIntArray1673[11];
					ai2 = anIntArrayArray1674[11];
					ai3 = anIntArray1676;
				}
				if (i6 < k6)
					i5 = ai3[i6];
				else
					i5 = -1000;
			}
			int i7 = anIntArray1673[l6];
			int ai4[] = anIntArrayArray1674[l6];
			for (int j7 = 0; j7 < i7; j7++)
				method484(ai4[j7]);

		}

		while (i5 != -1000) {
			method484(ai2[i6++]);
			if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
				i6 = 0;
				ai2 = anIntArrayArray1674[11];
				k6 = anIntArray1673[11];
				ai3 = anIntArray1676;
			}
			if (i6 < k6)
				i5 = ai3[i6];
			else
				i5 = -500;
		}

		for (int vertex = 0; vertex < anInt1626; ++vertex) {
			int pid = verticesParticle[vertex] - 1;
			if (pid >= 0) {
				ParticleDefinition def = ParticleDefinition.cache[pid];
				int startColor = def.getStartColor();
				if (this.particleColors != -1) {
					startColor = this.particleColors;
				}
				int x = anIntArray1627[vertex];
				int y = anIntArray1628[vertex];
				int z = anIntArray1629[vertex];
				int depth = vertexPerspectiveDepth[vertex];
				if (lastRenderedRotation != 0) {
					int sine = SINE[lastRenderedRotation];
					int cosine = COSINE[lastRenderedRotation];
					int rotatedX = z * sine + x * cosine >> 16;
					z = z * cosine - x * sine >> 16;
					x = rotatedX;
				}
				x += renderAtPointX;
				z += renderAtPointY;

				ParticleVector pos = new ParticleVector(x, -y, z);

				for (int p = 0; p < def.getSpawnRate(); p++) {
					Particle particle = new Particle(def, pos, depth, pid);
					if(def.areColorsSet()) {
						particle.setColor(def.getNextColor());
					} else {
						particle.setColor(startColor);
					}
					Client.instance.addParticle(particle);
				}
			}
		}
	}

	private int lastRenderedRotation = 0;
	private int renderAtPointX = 0;
	public int renderAtPointZ = 0;
	public int renderAtPointY = 0;
	public int[] verticesParticle;
}
