import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solutions
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        if (a==0)
            System.out.println("нулевое число");
        else
        {
            if (a > 0)
            {
                if (a % 2 == 0)
                    System.out.println("положительное четное число");
                else
                    System.out.println("положительное нечетное число");
            } else
            {
                if (-a % 2 == 0)
                    System.out.println("отрицательное четное число");
                else
                    System.out.println("отрицательное нечетное число");
            }
        }


    }
}