import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;

//Работа со строками
//StringBuilder - позволяет изменять объект String
//StringBuffer - тоже поддерживает изменения строк, только для Thread. В нем присутствуют synchronized методы.
public class StringBuilderTest {

    public static void main (String args[]) {
        StringBuilder testString = new StringBuilder("Hello");
        testString.append("def");
        testString.insert(0,"-");
        System.out.println(testString);
    }
}

class ReadWriteFile {
    public static void main(String args[]) throws IOException {
        File File = new File("test.txt");
        if(!File.exists()) {
            File.createNewFile();
            // readFile.mkdir(); - создание папки
        }

        if(File.isDirectory()){
            System.out.println("dir");
            //проверка директории
        }

        if(File.isFile()){
            System.out.println("It's file");
            //проверка на существование файла
        }
        FileWriter fileWriter = new FileWriter(File);
        fileWriter.write("str1\n");
        fileWriter.write("str2\n");
        fileWriter.flush();
        // fileWriter.close(); //- закрытие файла
        //чтение файла
        FileReader reader = new FileReader(File);
        /*char[] filestring = new char[20];
        reader.read(filestring);
        System.out.println(filestring);*/

        BufferedWriter StringBufferedWriter = new BufferedWriter(fileWriter);
        StringBufferedWriter.write("str3");
        StringBufferedWriter.newLine();
        StringBufferedWriter.write("str4");
        StringBufferedWriter.flush();
        StringBufferedWriter.close();

        BufferedReader StringBufferedRead = new BufferedReader(reader);
        while(StringBufferedRead.ready()) {
            System.out.println(StringBufferedRead.readLine());
        }
    }
}
