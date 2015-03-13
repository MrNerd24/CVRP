/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CVRP.FileProcessing;

import CVRP.utils.TLArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TLFileReader {

    private TLArrayList<String> lines;
    private String fileName;
    private final String path = "CVRP_saves/";
    private File file;
    private Scanner reader;
    private String folder;

    public TLFileReader(String fileName, String folder) {
        this.fileName = fileName;
        this.folder = folder;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }


    public TLArrayList<String> getRivit() {
        lueTiedosto();
        return lines;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean fileExists() {
        createFile();
        if (file == null) {
            return false;
        }
        return file.exists();
    }

    private void createFile() {
        String path = this.path + folder + "/" + fileName + ".txt";
        file = new File(path);
    }

    private void createScanner() {
        createFile();
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException ex) {
            reader = null;
        }
    }

    private void lueTiedosto() {
        lines = new TLArrayList<String>();
        createScanner();
        if (reader == null) {
            return;
        }

        while (reader.hasNext()) {
            String line = reader.nextLine();
            lines.add(line);
        }
    }

}
