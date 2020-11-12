//package com.archit.coding.leetcode;
//
//import java.util.ArrayList;
//import java.util.ListDemo;
//import java.util.TreeMap;
//
//public class DesignInMemoryFileSystem_588 {
//  public static void main(String[] args) {
//
//  }
//
//  static class FileSystem {
//
//    TreeMap<String, Node> system;
//
//    public FileSystem() {
//      Dir root = new Dir("/");
//      this.system = new TreeMap<>();
//      this.system.put("/", root);
//    }
//
//    public ListDemo<String> ls(String path) {
//      String[] levels = path.split("/");
//      int n = levels.length;
//      ListDemo<String> result = new ArrayList<>();
//      Node root = system.get("/");
//      for (int i = 1; i < n; i++) {
//        root = root.dirs.get(levels[i]);
//      }
//
//      for (String keys : root.dirs.keySet()) {
//        result.add(keys);
//      }
//
//      return result;
//    }
//
//    public void mkdir(String path) {
//      String[] levels = path.split("/");
//      int n = levels.length;
//      Node root = system.get("/");
//      for (int i = 1; i < n; i++) {
//        if (!root.dirs.containsKey(levels[i])) {
//          Dir child = new Dir(levels[i]);
//          root.dirs.put(levels[i], child);
//        }
//        root = root.dirs.get(levels[i]);
//      }
//    }
//
//    public void addContentToFile(String filePath, String content) {
//      String[] levels = path.split("/");
//      int n = levels.length;
//      String[] fileName = levels[n-1];
//
//      Node root = system.get("/");
//      for (int i = 1; i < n-1; i++) {
//        if (!root.dirs.containsKey(levels[i])) {
//          Dir child = new Dir(levels[i]);
//          root.dirs.put(levels[i], child);
//        }
//        root = root.dirs.get(levels[i]);
//      }
//      if(root.dirs.containsKey(fileName)) {
//        File file = root.dirs.get(fileName);
//        file.append(content);
//      } else {
//
//        File file = new File(fileName, content);
//        root.dirs.put(fileName, file);
//      }
//    }
//
//    public String readContentFromFile(String filePath) {
//      String[] levels = path.split("/");
//      int n = levels.length;
//      String[] fileName = levels[n-1];
//
//      Node root = system.get("/");
//      for (int i = 1; i < n-1; i++) {
//        if (!root.dirs.containsKey(levels[i])) {
//          Dir child = new Dir(levels[i]);
//          root.dirs.put(levels[i], child);
//        }
//        root = root.dirs.get(levels[i]);
//      }
//      File file = root.dirs.get(fileName);
//      return file.content;
//    }
//  }
//
//  class Node {
//    String name;
//    boolean dir;
//
//    public Node(String name, boolean dir) {
//      this.name = name;
//      this.dir = dir;
//    }
//  }
//
//  static class File extends Node {
//    StringBuilder content;
//
//    public File (String name, String content) {
//      super(name, false);
//      this.content = new StringBuilder(content);
//    }
//
//    public void append(String content) {
//      this.content.append(content);
//    }
//  }
//
//  static class Dir extends Node {
//    public TreeMap<String, Node> dirs;
//
//    public Dir(String name) {
//      super(name, true);
//      this.dirs = new TreeMap<>();
//    }
//  }
///**
// * Your FileSystem object will be instantiated and called as such:
// * FileSystem obj = new FileSystem();
// * ListDemo<String> param_1 = obj.ls(path);
// * obj.mkdir(path);
// * obj.addContentToFile(filePath,content);
// * String param_4 = obj.readContentFromFile(filePath);
// */
//
//
///*
//1. Store the content in StringBuilder. Call .append() to add.
//2. Node parent class (String name).
//3. File (String content)
//4. Dir (Map<>)
//*/
//}
