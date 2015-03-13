/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CVRP.FileProcessing;

import CVRP.utils.TLArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Juuso
 */
public class TLFileWriter {

    private String fileName;
    private boolean append;
    private BufferedWriter writer;
    private File file;
    private final String path = "CVRP_saves/";
    private String folder;

    public TLFileWriter(String fileName, String folder, boolean append) {
        this.fileName = fileName;
        this.folder = folder;
        this.append = append;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getFileName() {
        return fileName;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public boolean isAppend() {
        return append;
    }


    public void setAppend(boolean append) {
        this.append = append;

    }


    public void write(TLArrayList<String> lines) {
        createFileWriter();
        try {
            if (lines.get(0) == null) {
                writer.write("Tnull");
            } else {
                writer.write(lines.get(0));
            }
            for (int i = 1; i < lines.size(); i++) {
                writer.newLine();
                if (lines.get(i) == null) {
                    writer.write("Tnull");
                } else {
                    writer.write(lines.get(i));
                }
            }
            writer.close();
        } catch (IOException ex) {
            throw new Error(ex.getCause());
        }
    }

    private void createFileWriter() {
        createFile();

        try {
            this.writer = new BufferedWriter(new FileWriter(file, append));

        } catch (IOException ex) {
            throw new Error(ex.getCause());
        }
    }

    private void createFile() {
        String path = this.path + folder + "/" + fileName + ".txt";
        file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new Error(ex.getMessage());
            }
        }
    }

}
