// Воспользоваться встроенными в перечисление методами
        // Перечисление сортов яблок
enum Apple {
    Jonathan, GoldenDel, RedDel, Winesap, Cortland }

    class values {
        public static void main(String args[]) {
        Apple ар;
        System.out.println(
                "Константы перечислимого типа Apple:");
        // применить метод values() - получение массива перечисления
        Apple[] allapples = Apple.values();
            for (Apple a : allapples)
            System.out.println(a);
        System.out.println();
        // применить метод valueOf() - получение конкретного значения из перечисления
        ар = Apple.valueOf("Winesap");
        System.out.println("Пepeмeннaя ар содержит " + ар);
    }
    }