package com.company;

import javax.swing.*;
import java.io.*;

import static com.company.RBTree.nil;

public class Main {
    static String fileName="english2.txt";
    static RBTree rbTree;

    public static void main(String[] args) throws IOException {

         rbTree=new RBTree();
readFile();

       // rbTree.count(rbTree.root);

//
//         Node x=new Node("ahmed",nil);
//         Node y=new Node("peter",nil);
//         Node z=new Node("omar",nil);
//        Node z1=new Node("farah",nil);
//        Node z2=new Node("sama",nil);
//        Node z3=new Node("kero",nil);
//        Node z4=new Node("zaitoon",nil);
//        Node z5=new Node("islam",nil);
//        Node z6=new Node("fanta",nil);
//        rbTree.insert(x);
//        rbTree.insert(y);
//        rbTree.insert(z);
//       rbTree.insert(z1);
//     rbTree.insert(z2);
//        rbTree.insert(z3);
//        rbTree.insert(z4);
//       rbTree.insert(z5);
//        rbTree.insert(z6);
//
       // rbTree.printTree(rbTree.root);
        rbTree.count(rbTree.root);
        System.out.println("number of nodes = "+rbTree.getCount());
        System.out.println("height of tree = "+rbTree.height(rbTree.root));





//        x.setRight(y);
//        x.setLeft(z);
//        y.setParent(x);
//        z.setParent(x);
//        z.setLeft(A);
//        A.setParent(z);
//
//        Node temp=x.getRight();
//        x.setRight(temp.getLeft());
//       System.out.println(temp.getValue());


    }



    public static void  readFile() throws IOException {
        FileReader fileReader=new FileReader(fileName);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line=null;
        while((line=bufferedReader.readLine())!=null){
            Node x=new Node(line,nil);
            rbTree.insert(x);
        }


    }

    public static void writeFile()throws IOException{
        FileWriter fileWriter=new FileWriter(fileName,false);

        PrintWriter printWriter=new PrintWriter(fileWriter);
        printWriter.println("");
        fileWriter.close();

    }






}
