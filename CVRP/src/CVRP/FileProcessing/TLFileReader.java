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

/**
 * This class reads program specific savefiles. The savefolder is hardcoded, so it doesn't have access to any other files.
 * @author Juuso
 */
public class TLFileReader {

    private TLArrayList<String> lines;
    private String fileName;
    private final String path = "CVRP_saves/";
    private File file;
    private Scanner reader;
    private String folder;

    /**
     * Constructs the class. 
     * @param fileName Name of the file that needs to be readed.
     * @param folder The folder where the file is. These are folders inside the hardcoded savefolder.
     */
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

    /**
     * Reads the file and returns the Lines in a list.
     * @return List of lines inside the file.
     */
    public TLArrayList<String> getRivit() {
        readFile();
        return lines;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Tells if the file exists. this is for testing that the filename and folder are correct.
     * @return True if file exists.
     * @return False if the file doesn't exist.
     */
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

    private void readFile() {
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
