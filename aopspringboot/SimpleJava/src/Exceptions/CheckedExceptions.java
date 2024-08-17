package Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedExceptions {
    public void test() {
       // FileInputStream cfg=new FileInputStream("/Desktop/demo.txt"); //this line throws FileNotFound exception
        try {
            FileInputStream cfg=new FileInputStream("/Desktop/demo.txt");
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
