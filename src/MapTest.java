import java.util.*;

public class MapTest {
    public static void main(String args[]) {
        Map map = new HashMap<>(); //Хранит значения в таблице по хеш-коду
        Map map1 = new Hashtable(); //Тоже что и HashMap только с synchronized
        Map map2 = new LinkedHashMap(); // Порядок добавления сохраняется
        Map map3 = new TreeMap(); //Сортировка по методу Red-Black three
        map.put("1", "one");
        map.put("3", "three");
        map.put("2", "two");
        System.out.println(map.get(2));
    }
}
