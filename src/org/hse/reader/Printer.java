package org.hse.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Printer {
//    public static void printArray(ArrayList<File> arr) {
//        for(File file: arr) {
//            System.out.println(file.getAbsolutePath());
//        }
//    }

    public static void printArray(ArrayList<Node> arr) {
            for (Node n : arr) {
                if (n != null) {
                    System.out.println(n.getLabel());
                }
            }
    }

    public static void printContent(ArrayList<File> arr, Map<String,ArrayList<String>> treeDependencies) throws FileNotFoundException {
//        for (File file: arr) {
//            Scanner scanner = new Scanner(file);
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                System.out.println(line);
//            }
//        }
        for (var i : treeDependencies.keySet()) {
            System.out.print(i);
            System.out.println(" : ");
            for (var j : treeDependencies.get(i)) {
                System.out.println(j);
            }
            System.out.println();
        }
    }

    public static void printGraph(Graph graph) {
        for (var i : graph.getNodes()) {
            System.out.print("File ");
            System.out.print(i.getLabel());
            System.out.println(" has a dominant files: ");
            Printer.printArray(i.getAdjacencyList());
        }

    }

    public static void printGraphReverse(Graph graph) {
        for (var i : graph.getNodes()) {
            System.out.print("File ");
            System.out.print(i.getLabel());
            System.out.println(" has a sub files: ");
            Printer.printArray(i.getAdjacencyList());
        }

    }



}
