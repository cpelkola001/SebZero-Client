package com.arlania;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class ClientLauncher {

    public static final String DIRECTORY = System.getProperty("user.home") + "/SebZero/";
    
	public static void main(String[] args) {
		new File(DIRECTORY).mkdir();
		double currVersion = 11;
		double clientVersion = 11;

		// check client version
		try {
			// gets the current version number from website
			URLConnection connection = new URL("https://vortexps.com/vortexUpdater/version.txt").openConnection();
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			currVersion = Double.valueOf(reader.readLine().replaceAll("[^\\d.]", ""));

			// gets the client version from system
			File versionFile = new File(DIRECTORY + "clientversion");
			BufferedReader versionReader = new BufferedReader(new FileReader(versionFile));
			clientVersion = Double.parseDouble(versionReader.readLine());
		} catch (IOException e) {
			System.out.println(
					"Error with retrieving current client version and your client version. If this occurs again, please let Milo know.");
			e.printStackTrace();
		}

		// if currentVersion and the clientVersion exist/ are greater than 0 and they
		// arent the same - updates the client
		if ((currVersion != clientVersion) || currVersion == 0.0 || clientVersion == 0.0) {
			System.out.println(String.format("Downloading new client. Current Version = %f Client version = %f",
					currVersion, clientVersion));
			// download client
			try {
				URLConnection connection = new URL("https://vortexps.com/vortexUpdater/SebZero.jar")
						.openConnection();
				connection.setRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
				connection.connect();

				BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
				FileOutputStream fileOutputStream = new FileOutputStream(DIRECTORY + "SebZero.jar");

				byte dataBuffer[] = new byte[1024];
				int bytesRead;
				while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
					fileOutputStream.write(dataBuffer, 0, bytesRead);
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Error updating SebZero Client, please let Alfie#3108 know and download client from SebZerops.com");
				e.printStackTrace();
			}
		} else {
			System.out.println(String.format("Update not needed. Current Version = %f Client version = %f", currVersion,
					clientVersion));
		}

		// launch the client
		try {
			Runtime.getRuntime().exec("java -jar Avalon.jar", null, new File(DIRECTORY));
			Thread.sleep(500);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error starting game, please let Milo#0002 know and download client from https://SebZero317.com/");
		}
	}
}
