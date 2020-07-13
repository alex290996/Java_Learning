/* Отображение содержимого текстового файла.
 */
/*Чтобы воспользоваться этой программой, укажите
        имя файла, который требуется просмотреть.
        Например, чтобы просмотреть файл TEST.TXT,
        введите в командной строке следующую команду:
        java ShowFile TEST.TXT*/
import java.io.*;
class ShowFile {
    public static void main(String args[]) {
        int i;
        FileInputStream fin;
// сначала убедиться, что имя файла указано
        if (args.length != 1) {
            System.out.println(
                    "Использование: ShowFile имя_файла");
            return;
        }
// Попытка открыть файл
        try {
            fin = new FileInputStream(args[0]);
        } catch (FileNotFoundException е) {
            System.out.println("Heвoзмoжнo открыть файл");
            return;
        }
//Теперь файл открыт и готов к чтению.
        // Далее из него читаются символы до тех пор,
        // пока не встретится признак конца файла
        try {
            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Oшибкa чтения из файла");
        } finally {
            // закрыть файл
            try {
                fin.close();
            } catch (IOException е) {
                System.out.println("Oшибкa закрытия файла");
            }
        }
    }
}


/* Ниже оператор try с ресурсами применяется сначала для открытия, а затем для автоматического
закрытия файла по завершении блока этого оператора
        try(FileinputStream fin = new FileinputStream(args[O]))
        {
        do {
        i = fin.read ( ) ;
        if(i != -1) System.out.print((char) i);
        }while(i != -1);
        }catch(FileNotFoundException е) {
        System.out.println("Фaйл не найден.");
        }catch(IOException е) {
        System.out.println("Пpoизomлa ошибка ввода-вывода");
        }
 */


/* Версия программы CopyFile, в которой демонстрируется
применение оператора try с ресурсами и управление
двумя ресурсами (в данном случае - файлами)
в одном операторе try
*/
class CopyFile {
    public static void main(String args[]) throws IOException
    {
        int i;
        // сначала убедиться, что заданы оба файла
        if(args.length != 2) {
            System.out.println("Иcпoльзoвaниe: CopyFile откуда куда");
            return;}
            // открыть два файла и управлять ими в операторе try
            try (FileInputStream fin = new FileInputStream(args[0]);
                 FileOutputStream fout = new FileOutputStream(args[1] )){
        do {
            i = fin.read();
            if (i != -1) fout.write(i);
        } while (i != -1) ;
        }catch(IOException е){
            System.out.println("Oшибкa ввода-вывода: " + е);
            }
    }
}