import java.io.BufferedReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        System.out.println(a + " проспонсировал " + b + ", и она стала известной певицей.");
    }
}