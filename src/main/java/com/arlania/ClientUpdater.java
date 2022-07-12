package com.arlania;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;


public class ClientUpdater {

	private static ClientUpdater INSTANCE;

	public static ClientUpdater getClientUpdater() {
		if (INSTANCE == null)
			INSTANCE = new ClientUpdater();
		return INSTANCE;
	}

	/*public boolean checkVersion() {
		if (Configuration.ACTUAL_CLIENT_VERSION > Configuration.CLIENT_VER) {
			showOptions();
			return true;
		}
		return false;

	}*/

	public ClientUpdater() {

	}

	private Client c;

	public ClientUpdater(Client c) {
		this.c = c;
	}

	 public File downloadClient() throws IOException {
	        File jar = new File(Configuration.CLIENT_LOCATION);

	        if (!jar.exists())
	            jar.createNewFile();

	        try (OutputStream stream = new FileOutputStream(jar)) {

	            URLConnection link = new URL(Configuration.CLIENT_LINK).openConnection();
	            link.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
	            
	            try (InputStream in = link.getInputStream()) {

	                long downloaded = 0;
	                long size = link.getContentLength();

	                byte[] b = new byte[1024];

	                int pct, length;

	                while ((length = in.read(b, 0, b.length)) > -1) {

	                    stream.write(b, 0, length);
	                    downloaded += length;

	                    pct = (int) ((downloaded * 100) / size);

	                    c.setLoadingText(pct, Configuration.NAME + " is updating (" + (downloaded / 1000) + "/ "
	                            + (size / 1000) + " kb (" + pct + "%)");

	                }

	            }
	        }
	        Desktop.getDesktop().open(jar);
	        System.exit(0);
	        return jar;
	    }

	final double getVersion() {
		try {
			URLConnection connection = new URL("https://vortexps.com/vortexUpdater/version.txt").openConnection();
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			return Double.valueOf(reader.readLine().replaceAll("[^\\d.]", ""));
		} catch (Exception e) {
			e.printStackTrace();
			drawText("Something went wrong with the update. Redownload your client from https://SebZerops.com/",
					JOptionPane.ERROR_MESSAGE);
		}
		return -1;
	}

	void drawText(String text, int type) {
		JOptionPane.showMessageDialog(null, text, Configuration.NAME + " update", type);
	}

	void showOptions() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		JTextArea text = new JTextArea(7, 5);
		JScrollPane scrollPane = new JScrollPane(text);
		text.setText("A client update is available (ver: "
				+ new DecimalFormat("##.#").format("Ys")
				+ "). You must update in order to play. \n\nEvery client update will come with new features, improvements and fixes. Please update your client to keep up with the game."
				+ "\n\nWould you like to update now? ");
		text.setFont(new Font("Times New Roman", 0, 18));
		text.setWrapStyleWord(true);
		text.setLineWrap(true);
		text.setCaretPosition(0);
		text.setEditable(false);
		scrollPane.setPreferredSize(new Dimension(400, 200));

		int op = JOptionPane.showConfirmDialog(null, scrollPane, Configuration.NAME + " ~ UPDATE AVAILABLE!",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (op == 0)
			try {
				downloadClient();
			} catch (IOException e) {
				drawText("Please redownload the client from https://SebZerops.com/", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
				e.printStackTrace();
			}
		else
			System.exit(0);
	}

}
