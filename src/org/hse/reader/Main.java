package org.hse.reader;

import java.io.*;

import java.io.File;
import java.util.*;


public class Main {
//    private static Map<String,ArrayList<String>> treeDependencies = new HashMap<String,ArrayList<String>>();
    private static Map<String,Node> mapNodes = new HashMap<String,Node>();
    private static Map<String,Node> mapNodesReverse = new HashMap<String,Node>();
    private static Graph graph = new Graph();
    private static Graph graphReverse = new Graph();

    private static ArrayList<File> fileList; // это массив всех файлов в корневой папке
//    private static ArrayList<File> fileList; // это массив всех файлов в корневой папке

    public static void main(String[] args) throws FileNotFoundException {
        fileList = new ArrayList<>();
        Reader.getALLFiles(new File("/Users/dpk/Desktop/root_folder"), fileList);
        for(File file: fileList) {
            System.out.println(file.getAbsolutePath());
        }
        FileEditor.findRequires(fileList, graph, mapNodes, graphReverse, mapNodesReverse);

//        Printer.printContent(fileList, treeDependencies);
//        FileEditor.buildTree(treeDependencies, graph, mapNodes, fileList);
//        require 'root_folder/folder2/new_file.txt'




//        Node A = new Node("A");
//        Node B = new Node("B");
//        graph.addNode(A);
//        graph.addNode(B);
//        graph.addEdge(A, B);
//        graph.addEdge(B, A);

//        Printer.printGraph(graph);
        Printer.printGraphReverse(graphReverse);

//        graphReverse.dfs();

        System.out.println(graph.hasCycle());
//        Printer.printArray(fileList);
    }
}


//        for(File file: fileList) {
//            System.out.println(file.getAbsolutePath());
//        }