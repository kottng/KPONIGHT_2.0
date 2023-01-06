package org.hse.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class FileEditor {
    public static void findRequires(ArrayList<File> arr, Graph graph, Map<String,Node> mapNode, Graph graphReverse, Map<String,Node> mapNodeReverse) throws FileNotFoundException {
        for (var i : arr) {
            Node new_elem_reverse = new Node(i.getName());
            Node new_elem = new Node(i.getName());
            mapNode.put(i.getName(), new_elem);
            mapNodeReverse.put(i.getName(), new_elem_reverse);
            graph.addNode(new_elem);
            graphReverse.addNode(new_elem_reverse);
        }

        // перебираем все файлы из списка пулла файлов
        for(File file: arr) {
            // взяли и теперь сканируем его
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                //сканируем очередную строчку
                String line = scanner.nextLine();
                String way;
                String name_of_dominante_file;
                int position_of_filename = 0;

                if (line.contains("require")) {
                    //если строчка содержит require, то файл может зависеть от других
                    way = line.substring(9, line.length()-1);
                    position_of_filename = way.lastIndexOf("/");
                    if (position_of_filename != -1){
                        //если ввод корректен
                        name_of_dominante_file = way.substring(position_of_filename + 1, way.length());
                        graph.addEdge(mapNode.get(file.getName()), mapNode.get(name_of_dominante_file));
                        graphReverse.addEdge(mapNodeReverse.get(name_of_dominante_file), mapNodeReverse.get(file.getName()));
                    } else {
                        //если ввод некорректный
                        System.out.println("You've got a problem with a content of your file");
                        name_of_dominante_file = "";
                    }
                    //на этом моменте у нас есть имя файла, и одно из имен файлов, от которых исходник зависит
                    //теперь нам надо записать эту зависимость в дерево или словарь
                    //предлагаю полностью отказаться от словаря - сразу в дерево запишем, и больше не будем себе мозги






                    //?
//                    if (treeDependencies.containsKey(file.getName())) {
//                        //если в словаре уже есть такой элемент, то добавим туда его
////                        System.out.println("WE GOT ONE MORE");
//                        treeDependencies.get(file.getName()).add(name_of_dominante_file);
////                        Printer.printContent(arr, treeDependencies);
//                    } else {
//                        //если в словаре нет такого элемента
////                        System.out.println("WE GOT A NEW ONE");
//                        ArrayList<String> new_name_of_dominante_file = new ArrayList<>();
//                        treeDependencies.put(file.getName(), new_name_of_dominante_file);
//                        treeDependencies.get(file.getName()).add(name_of_dominante_file);
////                        Printer.printContent(arr, treeDependencies);
//                    }
                     //?
                } /*else {
                    //?
                    name_of_dominante_file = "NoDominante";
                    if (!treeDependencies.containsKey(file.getName())) {
                        ArrayList<String> new_name_of_dominante_file = new ArrayList<>();
                        treeDependencies.put(file.getName(), new_name_of_dominante_file);
                        treeDependencies.get(file.getName()).add(name_of_dominante_file);
                    }
                    //?
//                    Printer.printContent(arr, treeDependencies);
                }
                */
            }
//            if (treeDependencies.get(file.getName()).size() > 1) {
//                treeDependencies.get(file.getName()).remove(0);
//            }
        }
    }

//    public static void buildTree(Map<String,ArrayList<String>> treeDependencies, Graph graph, Map<String,Node> mapNode, ArrayList<File> fileList) {
//
//
//
//
//
//        //?
//        for (var i : fileList) {
//            Node new_elem = new Node(i.getName());
//            mapNode.put(i.getName(), new_elem);
//        }
//        for (var i : fileList) {
//            for (var j : treeDependencies.get(i.getName())) {
//                if (j != null) {
//                    graph.addEdge(mapNode.get(i.getName()), mapNode.get(j));
//                }
//            }
//        }
//        //?
//
//
//
//
//
//    }
}
