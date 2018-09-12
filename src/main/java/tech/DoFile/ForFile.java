package tech.DoFile;

import java.io.File;

public class ForFile {
    public static void main(String[] args) {
        File file = new File("./");
        each(file);
    }

    public static void each(File file){
        if(file.isDirectory()){
            for (File listFile:file.listFiles()){
                each(listFile);
            }
        }else {
            System.out.println(file.getAbsolutePath());
        }
    }
}
