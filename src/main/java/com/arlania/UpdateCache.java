package com.arlania;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UpdateCache implements Runnable {

    //public static final String ZIP_URL = "https://dl.dropboxusercontent.com/s/hr0mzqqww3ufqeo/cache.zip?dl=0";
    public static final String ZIP_URL = "http://localhost/cache.zip";
    public static final String VERSION_URL = "https://dl.dropboxusercontent.com/s/nd0u80giy1yrusp/cacheVersion.txt?dl=0";
    public static final String VERSION_FILE = signlink.findcachedir() + "cacheVersion.dat";
    private Client client;
    Client frame;

    public UpdateCache(Client client) {
        this.client = client;
    }

    private void drawLoadingText(int amount, String text) {
        client.drawLoadingText2(amount, text);
    }

    @SuppressWarnings("resource")
    public double getCurrentVersion() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(VERSION_FILE)));
            return Double.parseDouble(br.readLine());
        } catch (Exception e) {
            return 0.0;
        }
    }

    public double getNewestVersion(){
        try {
            URL tmp = new URL(VERSION_URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(tmp.openStream()));
            return Double.parseDouble(br.readLine());
        } catch (Exception e) {
            handleException(e);
            return -1;
        }
    }

    private void handleException(Exception e){
        StringBuilder strBuff = new StringBuilder();
        strBuff.append("Please Screenshot this message, and send it to an admin!\r\n\r\n");
        for(StackTraceElement s : e.getStackTrace())
            strBuff.append(s.toString()).append("\r\n");
        System.out.println("strBuff.toString(): " + strBuff.toString());
        //alert("Exception [" + e.getClass().getSimpleName() + "]",strBuff.toString(),true);
    }

    @Override
    public void run() {
        drawLoadingText(0, "Checking Versions");
        try{
            double newest = getNewestVersion();
            System.out.println("Cache version: " + this.getCurrentVersion() + " || Latest Cache version: " + getNewestVersion());
            if(newest > this.getCurrentVersion()){
                if(this.getCurrentVersion() == 0.0) {
                    updateClient(false);
                    OutputStream out = new FileOutputStream(VERSION_FILE);
                    out.write(String.valueOf(getNewestVersion()).getBytes());
                    out.close();
                    //Jframe.frame.setTitle("Equinox v" + newest);
                } else {
                    updateClient(true);
                    drawLoadingText(0, "Cache has been updated");
                    OutputStream out = new FileOutputStream(VERSION_FILE);
                    out.write(String.valueOf(newest).getBytes());
                    out.close();
                    //Jframe.frame.setTitle("Equinox v" + newest);
                }
            }
        }catch(Exception e){
            handleException(e);
        }
    }

    private void updateClient(boolean updating) {
        File clientZip = downloadClient(updating);
        if(clientZip != null){
            unZip(updating, clientZip);
        }
    }

    private void unZip(boolean updating, File clientZip) {
        try {
            unZipFile(updating, clientZip,new File(signlink.findcachedir()));
            clientZip.delete();
        } catch (IOException e) {
            handleException(e);
        }
    }

    private void unZipFile(boolean updating, File zipFile,File outFile) throws IOException {
        ZipInputStream zin = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFile)));
        ZipEntry e;
        long max = 0;
        long curr = 0;
        while((e = zin.getNextEntry()) != null)
            max += e.getSize();
        zin.close();
        ZipInputStream in = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFile)));
        while((e = in.getNextEntry()) != null){
            if(e.isDirectory())
                new File(outFile,e.getName()).mkdirs();
            else{
                FileOutputStream out = new FileOutputStream(new File(outFile,e.getName()));
                byte[] b = new byte[1024];
                int len;
                while((len = in.read(b,0,b.length)) > -1){
                    curr += len;
                    out.write(b, 0, len);
                    setUnzipPercent(updating, (int)((curr * 100) / max));
                }
                out.flush();
                out.close();
            }
        }
        zipFile.delete();
        in.close();
    }

    public int percent = 0;
    public void setDownloadPercent(boolean updating, int amount){
        //System.out.println("download amount: " + amount);
        percent = amount;
        drawLoadingText(amount, (updating ? "Downloading Updated" : "Downloading") + " Cache" + " - " + amount + "%");
    }

    public int percent2 = 0;
    public void setUnzipPercent(boolean updating, int amount){
        percent2 = amount;
        //System.out.println("unzip amount: " + amount);
        drawLoadingText(amount, (updating ? "Extracting New" : "Extracting") + " Cache" + " - " + amount + "%");
    }

    private File downloadClient(boolean updating){
        File folder = new File(ClientLauncher.DIRECTORY);
        boolean folderExists = folder.exists();
        if(!folderExists) folder.mkdir();

        File ret = new File(signlink.findcachedir() + "cache.zip");
        try{
            OutputStream out = new FileOutputStream(ret);
            URLConnection conn = new URL(ZIP_URL).openConnection();
            InputStream in = conn.getInputStream();
            long max = conn.getContentLength();
            long curr = 0;
            byte[] b = new byte[1024];
            int len;
            while((len = in.read(b, 0, b.length)) > -1){
                out.write(b,0,len);
                curr += len;
                setDownloadPercent(updating, (int)((curr * 100) / max));
            }
            out.flush();
            out.close();
            in.close();
            return ret;
        }catch(Exception e){
            handleException(e);
            ret.delete();
            return null;
        }
    }
}
