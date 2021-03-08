import java.io.*;
import java.util.Scanner;

public class Scanners {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Введите число:");

            int number = sc.nextInt();

            System.out.println("Спасибо! Вы ввели число " + number);

            sc.close();//вот теперь мы сделали все правильно!



            Scanner scan = new Scanner("На голой ветке\n" +
                    "Ворон сидит одиноко.\n" +
                    "Осенний вечер.\n\n***" +
                    " \n" +
                    " \n" +
                    "В небе такая луна,\n" +
                    "Словно дерево спилено под корень:\n" +
                    "Белеет свежий срез.\n\n***" +
                    " \n" +
                    " \n" +
                    "Как разлилась река!\n" +
                    "Цапля бредет на коротких ножках,\n" +
                    "По колено в воде.");

            scan.useDelimiter("\n/*/*/*");

            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }

            scan.close();

        }
    }

