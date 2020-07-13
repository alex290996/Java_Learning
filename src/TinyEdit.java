//Простейший текстовый редактор
import java.io.*;
class TinyEdit {
    public static void main(String args[]) throws IOException {
// создать поток ввода типа BufferedReader,
//используя стандартный поток ввода System.in
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
        String str[] = new String[100];
        System.out.println("Bвeдитe строки текста.");
        System.out.println("Bвeдитe 'стоп' для завершения.");
        for (int i = 0; i < 100; i++) {
            str[i] = br.readLine();
            if (str[i].equals("cтoп")) break;
            System.out.println("\nCoдepжимoe вашего файла:");
        }
// вывести текстовые строки
            for (int i = 0; i < 100; i++) {
                if (str[i].equals("cтoп")) break;
                System.out.println(str[i]);
            }
        }
    }

    /*чтения символьных строк с клавиатуры служит версия метода readLine ( )
        BufferedWriter - Буферизированный поток вывода символов
        CharArrayReader - Поток ввода, читающий символы из массива
        CharArrayWriter - Поток вывода, записывающий символы в массив
        FileReader - Поток ввода, читающий символы из файла
        FileWriter - Поток вывода, записывающий символы в файл
        FilterReader - Фильтрованный поток чтения
        FilterWriter - Фильтрованный поток записи
        InputStreamReader - Поток ввода, преобразующий байты в символы
        LineNumЬerReader - Поток ввода, подсчитывающий строки
        OutputStreamWriter - Поток вывода, преобразующий символы в байты
        PipedReader - Канал ввода
        PipedWriter - Канал вывода
        PrintWriter - Поток вывода, содержащий методы print () и println()
        PushbackReader - Поток ввода, позволяющий возвращать символы обратно в поток ввода
        Reader - Абстрактный класс, описывающий поток ввода символов
        StringReader - Поток ввода, читающий символы из строки
        StringWriter - Поток вывода, записывающий символы в строку
        Writer - Абстрактный класс, описывающий поток вывода символов
     */