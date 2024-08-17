package FileInputOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestFile {
    public static void main(String[] args) {

        try {
            File myFile=new File("dummyFile.txt");
            if(!myFile.exists()) {
                myFile.createNewFile();
                System.out.println("New File Created" + myFile.getName());
            }else
            {
                System.out.println(myFile.getName()+" is Already Present in System !!");
            }
            FileWriter fileWriter=new FileWriter(myFile);
            fileWriter.write("Hello, I am writing this content to a file ");
            fileWriter.write("\nThis is new Line.");
            fileWriter.close();

            Scanner sc = new Scanner(myFile);
            while(sc.hasNextLine())
            {
                System.out.println(sc.nextLine());
            }
            sc.close();
            if(myFile.exists())
            {
                myFile.delete();
                System.out.println(myFile+" File is deleted");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
