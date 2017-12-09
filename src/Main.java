import BasicLists.*;
import LinkedList.*;
import Queue.ArrayQueue;
import Queue.IQueue;
import Queue.LinkedQueue;
import Stack.*;
import Trees.BinarySearchTree;
import WordFrequency.FrequenyList;

import java.io.IOException;
import java.io.PrintWriter;

import static Recursion.RecursiveFunctions.combinations;


public class Main
{
    public static void main(String[] args)
    {
        String path = "D:\\Documents\\IntelliJProjects\\OODataStructures\\src\\";
        String[] listArgs = {path + "test.txt", path + "outTest.txt", "3", "3"};
        try {
            FrequenyList.main(listArgs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//601