package FileInputOutput;

import java.io.*;

public class MainSerialize {
    public static void main(String[] args) {
        SerializationDemo serializationDemo= new SerializationDemo();
        serializationDemo.i=10;
        serializationDemo.j=20;
        File myFile=new File("Test.txt");
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(myFile);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializationDemo);

            FileInputStream fileInputStream=new FileInputStream(myFile);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            SerializationDemo serializationDemo1=(SerializationDemo) objectInputStream.readObject();

            System.out.println("value of i in serializationDemo1 object : "+serializationDemo1.i);
            System.out.println("value of j in serializationDemo1 object : "+serializationDemo1.j);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
