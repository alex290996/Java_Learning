import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayLists {
    public static void main(String[] args) {

        ArrayList<Cat> cats = new ArrayList<>();
        Cat thomas = new Cat("Томас");
        Cat behemoth = new Cat("Бегемот");
        Cat philipp = new Cat("Филипп Маркович");
        Cat pushok = new Cat("Пушок");

        cats.add(thomas);
        cats.add(behemoth);
        cats.add(philipp);
        cats.add(pushok);
        // contains() - метод подволяет проверить содержит ли строка подстроку

        int thomasIndex = cats.indexOf(thomas); //indexOf — может найти индекс объекта в ArrayList’e по ссылке на объект
        System.out.println(thomasIndex);

        /*Кроме того, можно легко узнать, содержит ли ArrayList какой-то конкретный объект, или нет. Это делается с помощью метода contains()*/
        cats.remove(pushok);
        System.out.println(cats.contains(pushok));
        //Чтобы полностью очистить список, используется метод clear()
        cats.clear();

        Cat[] catsArray = {thomas, behemoth, philipp, pushok};

        //В классе Arrays для этого есть метод Arrays.asList().
        // С его помощью мы получаем содержимое массива в виде списка и передаем его в конструктор нашего ArrayList
        ArrayList<Cat> catsList = new ArrayList<>(Arrays.asList(catsArray));
        System.out.println(catsList);

        //Можно сделать и наоборот — получить массив из объекта ArrayList. Для этого используется метод toArray():
        //Обрати внимание: в метод toArray() мы передали пустой массив. Это не ошибка.
        Cat[] catsArray2 = cats.toArray(new Cat[0]);

        System.out.println(Arrays.toString(catsArray2));

        Iterator<Cat> catIterator = cats.iterator();//создаем итератор
        while(catIterator.hasNext()) {//до тех пор, пока в списке есть элементы

            Cat nextCat = catIterator.next();//получаем следующий элемент
            System.out.println(nextCat);//выводим его в консоль
        }
    }
}

class Cat {

    private String name;

    public Cat(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}