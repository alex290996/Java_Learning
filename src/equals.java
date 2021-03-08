public class equals {
    public static class Main {

        public static void main(String[] args) {

            String address1 = "г. Москва, ул. Академика Королева, дом 12";
            String address2 = new String("Г. МОСКВА, УЛ. АКАДЕМИКА КОРОЛЕВА, ДОМ 12");
            System.out.println(address1.equalsIgnoreCase(address2));
        }
    }
    /**Метод intern() напрямую работает со String Pool’ом. Если ты вызываешь метод intern() у какой-то строки, он:
     Смотрит, есть ли строка с таким текстом в пуле строк
     Если есть — возвращает ссылку на нее в пуле
     Если же нет — помещает строку с этим текстом в пул строк и возвращает ссылку на нее.
     **/

    public static class Main {

        public static void main(String[] args) {

            String s1 = "JavaRush - лучший сайт для изучения Java!";
            String s2 = new String("JavaRush - лучший сайт для изучения Java!");
            System.out.println(s1 == s2.intern());
        }
    }
}
