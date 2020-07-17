//Простой обобщенный класс с двумя параметрами типа: Т и V
class TwoGen<T, V> {
    T ob1;
    V ob2;
    //передать конструктору ссылки на объекты типа т и V
    TwoGen(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }
        // показать типы Т и V
        void showTypes() {
            System.out.println("Tип Т: " + ob1.getClass().getName());
            System.out.println("Tип V: " + ob2.getClass().getName());
        }
        T getob1() {
            return ob1;
        }
        V getob2 () {
            return ob2;
        }
    }
            // продемонстрировать применение класса ТWoGen
            class SimpGen {
                public static void main(String args[]) {
                    TwoGen<Integer, String> tgObj =
                            new TwoGen<Integer, String> (88, "Обобщения");
// показать типы
                    tgObj.showTypes();
// Получить и показать значения
                    int v = tgObj.getob1();
                    System.out.println("Знaчeниe: " + v);
                    String str = tgObj.getob2();
                    System.out.println("Знaчeниe: " + str);
                }}



//В этой версии класса Stats аргумент типа Т должен
// быть классом NumЬer или наследуемым от него классом
class Stats<T extends Number> {
    T[] nums; //массив класса NumЬer или его подкласса

    //передать конструктору ссылку на массив элементов
    //класса NumЬer или его подкласса
    Stats(T[] о) {
        nums = о;
    }

    // возвратить значение типа douЫe в любом случае
    double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i].doubleValue();
        return sum / nums.length;
    }
}
//продемонстрировать применение класса Stats
class BoundsDemo {
    public static void main(String args[]) {
        Integer inums[] = {1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<Integer>(inums);
        double v = iob.average();
        System.out.println("Cpeднee значение iob равно " + v);
        Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<Double>(dnums);
        double w = dob.average();
        System.out.println("Cpeднee значение dob равно " + w);
    }
}

//Этот код не скомпилируется, так как класс String
//не является производным от класса NumЬer
// String strs[] = { "1", "2", "3", "4", "5" };
// Stats<String> strob = new Stats<String>(strs);
// douЫe х = strob.average();
// System.out.println("Cpeднee значение strob равно " + v);




//Применение метасимволов подстановки
// в качестве аргументов
class Stats2<T extends Number> {
    T[] nums; //массив класса NumЬer или его подкласса

    //передать конструктору ссылку на массив
// элементов класса NumЬer или его подкласса
    Stats2(T[] о) {
        nums = о;
    }

    // возвратить значение типа douЫe в любом случае
    double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i].doubleValue();
        return sum / nums.length;
    }
//Определить равенство двух средних значений.
//Обратите внимание на применение

    // метасимвола подстановки
    boolean sameAvg(Stats2<?> ob) {
        if (average() == ob.average())
            return true;
        return false;
    }
}
//Продемонстрировать применение метасимвола подстановки
    class WildcardDemo {
    public static void main(String args[]) {
        Integer inums[] = {1, 2, 3, 4, 5};
        Stats2<Integer> iob = new Stats2<Integer>(inums);
        double v = iob.average();
        System.out.println("Cpeднee значение iob равно" + v);
        Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats2<Double> dob = new Stats2<Double>(dnums);
        double w = dob.average();
        System.out.println("Cpeднee значение dob равно :" + w);
        Float fnums[] = {1.0F, 2.0F, 3.0F, 4.0F, 5.0F};
        Stats2<Float> fob = new Stats2<Float>(fnums);
        double х = fob.average();
        System.out.println("Cpeднee значение fob равно :" + х);
// выяснить, какие массивы имеют
// одинаковые средние значения
        System.out.print("Cpeдниe значения iob и dob ");
        if (iob.sameAvg(dob)) {
            System.out.println("paвны.");
        } else {
            System.out.println("oтличaютcя.");
        }
        System.out.print("Cpeдниe iob и fob ");
        if (iob.sameAvg(fob))
            System.out.println("oдинaкoвы.");
        else
            System.out.println("oтличaютcя.");
    }
}



// Продемонстрировать простой обобщенный метод
class GenMetDemo {
    //определить, содержится ли объект в массиве
    static <T extends Comparable<T>, V extends T>
    boolean isin(T x, V[] y) {
        for (int i = 0; i < y.length; i++)
            if (x.equals(y[i])) return true;

        return false;
    }

        public static void main(String[] args){
        // применить метод isin() для целых чисел
        Integer[] nums = { 1, 2, 3, 4, 5 } ;
        if(isin(2, nums))
            System.out.println("Чиcлo 2 содержится в массиве nums");
        if(!isin(7, nums))
            System.out.println("Чиcлo 7 отсутствует в массиве nums");
        System.out.println();
        // применить метод isin() для символьных строк
        String[] strs = {"один", "два", "три", "четыре", "пять"  };
        if(isin("двa", strs))
            System.out.println(
                    "два содержится в массиве strs");
        if(!isin("ceмь", strs))
            System.out.println("ceмь отсутствует в массиве strs");
        // Не скомпилируется! Типы должны быть совместимы
        // if(isin("двa", nums))
            // System.out.println("двa содержится в массиве strs ");
    }
}