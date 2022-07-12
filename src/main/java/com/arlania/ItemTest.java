package com.arlania;

public class ItemTest {
	
}

/*public class ItemTest {

    public static void main(String[] args) throws IOException {

        Stream data = new Stream(Files.readAllBytes(Paths.get(signlink.findcachedir() + "original_obj.dat")));
        Stream indices = new Stream(Files.readAllBytes(Paths.get(signlink.findcachedir() + "original_obj.idx")));

        read(signlink.findcachedir() + "obj.dat", signlink.findcachedir() + "obj.idx");
        read(signlink.findcachedir() + "original_obj.dat", signlink.findcachedir() + "original_obj.idx");
    }

    private static void read(String dataPath, String indexPath) throws IOException {
        Stream data = new Stream(Files.readAllBytes(Paths.get(dataPath)));
        Stream indices = new Stream(Files.readAllBytes(Paths.get(indexPath)));

        int totalItems = indices.readUnsignedWord();
        int[] streamIndices = new int[totalItems + 1000];
        int i = 2;
        for (int j = 0; j < totalItems; j++) {
            streamIndices[j] = i;
            i += indices.readUnsignedWord();
        }

        System.out.println("Read " + totalItems + " items. " + Arrays.toString(streamIndices));
    }
}*/

/*public class ItemTest {

	public static void main(String[] args) throws IOException {

		int[] first = read(signlink.findcachedir() + "obj.dat", signlink.findcachedir() + "obj.idx", false);
		int[] second = read(signlink.findcachedir() + "original_obj.dat", signlink.findcachedir() + "original_obj.idx",
				true);

		ItemDef.cache = new ItemDef[10];
		for (int k = 0; k < 10; k++) {
			ItemDef.cache[k] = new ItemDef();
		}
		
		ItemDef.repackConfig();

		for (int i = 0; i < second.length; i++) {
			if (first[i] != second[i]) {
				ItemDef.forID(i);
				System.out.println("Started going wrong for item: " + i);
				return;
			}
		}
	}

	private static int[] read(String dataPath, String indexPath, boolean set) throws IOException {
		Stream data = new Stream(Files.readAllBytes(Paths.get(dataPath)));
		Stream indices = new Stream(Files.readAllBytes(Paths.get(indexPath)));

		int totalItems = indices.readUnsignedWord();
		System.out.println("Read " + totalItems + " items. ");
		int[] streamIndices = new int[totalItems + 1000];
		int i = 2;
		for (int j = 0; j < totalItems; j++) {
			streamIndices[j] = i;
			i += indices.readUnsignedWord();
		}

		if (set) {
			ItemDef.stream = data;
			ItemDef.totalItems = totalItems;
			ItemDef.streamIndices = streamIndices;
		}
		return streamIndices;
	}
}*/