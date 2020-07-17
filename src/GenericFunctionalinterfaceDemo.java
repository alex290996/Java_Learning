/* Применить обобщенный функциональный интерфейс с разнотипными лямбда-выражениями
         Обобщенный функциональный интерфейс*/
interface SomeFunc<T> {
        T func(T t);
}
class GenericFunctionalinterfaceDemo {
    public static void main(String args[]) {
        // использовать строковый вариант
        // функционального интерфейса SomeFunc
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            int i;
            for (i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };
        System.out.println("Лямбдa обращается на "
                + reverse.func("Лямбдa"));
        System.out.println("Bыpaжeниe обращается на "
                + reverse.func("Выражение"));
        // а теперь использовать целочисленный вариант
        // функционального интерфейса SomeFunc
        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++)
                result = i * result;
            return result;
        };
        System.out.println("Фaктopиaл числа 3 равен "
                + factorial.func(3));
        System.out.println("Фaктopиaл числа 5 равен "
                + factorial.func(5));
    }
}


//Передать лямбда-выражение в качестве аргумента вызываемому методу
interface StringFunc {
    String func(String n);
}
class LambdasAsArgumentsDemo {
/*Первый параметр этого метода имеет тип
функционального интерфейса. Следовательно, ему
можно передать ссылку на любой экземпляр этого
интерфейса, включая экземпляр, создаваемый в
лямбда-выражении. А второй параметр обозначает
обрабатываемую символьную строку*/
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }
    public static void main(String args[]) {
    String inStr = "Лямбда-выражения повышают эффективность Java";
    String outStr;
        System.out.println("Этo исходная строка: " + inStr);
        //Ниже приведено простое лямбда-выражение,
        //преобразующее в прописные все буквы в исходной
        // строке, передаваемой методу stringOp()
            outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("Этo строка прописными буквами: "
             + outStr);
        // А здесь передается блочное лямбда-выражение,
        //удаляющее пробелы из исходной символьной строки
            outStr = stringOp((str) -> {
                String result = "";
                int i;
                for(i = 0; i < str.length(); i++)
                    if(str.charAt(i) != ' ')
                     result += str.charAt(i);
                return result;
             } , inStr);
        System.out.println("Этo строка с удаленными пробелами: "
        + outStr);
        //Можно, конечно, передать и экземпляр
        //функционального интерфейса StringFunc,
        // созданный в предыдущем лямбда-выражении.
        //Например, после следующего объявления ссылка
        // reverse делается на экземпляр
        //интерфейса StringFunc
        StringFunc reverse = (str) -> {
            String result = "";
            int i;
            for(i = str.length()-1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        } ;
        /* А теперь ссылку reverse можно передать в
        11 качестве первого параметра методУ stringOp(),
        11 поскольку она делается на объект типа StringFunc*/
        System.out.println("Этo обращенная строка: "
                + stringOp(reverse, inStr) );
}
}

// Сгенерировать исключение из лямбда-выражения
interface DouЬleNumericArrayFunc {
    double func(double[] n) throws EmptyArrayException;
}
class EmptyArrayException extends Exception {
    EmptyArrayException() {
        super("Maccив пуст");
    }
}
class LamЬdaExceptionDemo {
    public static void main(String args[])
            throws EmptyArrayException {
        double[] values = {1.0, 2.0, 3.0, 4.0};
        //В этом лямбда-выражении вычисляется среднее
        // числовых значений типа douЫe в массиве
        DouЬleNumericArrayFunc average = (n) -> {
            double sum = 0;
            if (n.length == 0)
                throw new EmptyArrayException();
            for (int i = 0; i < n.length; i++)
                sum += n[i];
            return sum / n.length;
        };
        System.out.println("Cpeднee равно " + average.func(values));
        // Эта строка кода приводит к генерированию исключения
        System.out.println("Cpeднee равно "
                + average.func(new double[0]));
    }
}

//Продемонстрировать ссылку на статический метод
//Функциональный интерфейс для операций
//над символьными строками
interface StringFunc2 {
    String func(String n);
}
//В этом классе определяется статический
//метод strReverse()
class MyStringOps {
    //Статический метод, изменяющий порядок
    // следования символов в строке
    static String strReverse(String str) {
        String result = "";
        int i;
        for (i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);
        return result;
    }
}
class MethodRefDemo {
// В этом методе функциональный интерфейс указывается в качестве типа первого его
// параметра. Следовательно, ему может быть
//передан любой экземпляр данного интерфейса,
// включая и ссылку на метод
        static String stringOp(StringFunc2 sf, String s) {
            return sf.func(s);
        }
        public static void main(String args[]) {
            String inStr = "Лямбда-выражения повышают "
                    + "эффективность Java";
            String outStr;
        // Здесь ссылка на метод strReverse() передается
        //методу stringOp()
            outStr = stringOp(MyStringOps::strReverse, inStr);
            System.out.println("Иcxoднaя строка: " + inStr);
            System.out.println("Oбpaщeннaя строка: " + outStr);
        }
    }