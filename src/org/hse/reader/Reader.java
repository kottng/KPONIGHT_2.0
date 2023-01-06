package org.hse.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Reader {
    public static void getALLFiles(File rootDirection, ArrayList<File> fileList) {
//        if (rootDirection.isDirectory()) {
//            System.out.println("searching: " + rootDirection.getAbsolutePath());
        File[] directoryFiles = rootDirection.listFiles();
        if (directoryFiles != null) {
            for (File file: directoryFiles) {
                if (!file.isDirectory()) {
                    if (file.getName().toLowerCase().endsWith(".txt")) {
                        fileList.add(file);
                    }
                } else {
                    getALLFiles(file, fileList);
                }
            }
        }
//        }
    }
}
