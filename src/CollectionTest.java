import java.util.*;
//“Коллекции” — общее название для нескольких структур данных в Java. Данные можно хранить многими разными способами.

public class CollectionTest {
    public static void main(String args[]) {
        Collection collection = new ArrayList();
        collection.add("1"); // добавить значение
        collection.add("2");
        collection.add("3");
        collection.remove("1");
        Iterator iterator = collection.iterator();

        /*Дословно «Iterator» можно перевести как «переборщик». То есть это некая сущность, способная перебрать
        все элементы в коллекции. При этом она позволяет это сделать без вникания во внутреннюю структуру и
        устройство коллекций.*/

        /*while(iterator.hasNext()) {
            //System.out.println(iterator.next());
        }*/
        List collection2 = new ArrayList(); //List - работа с int значением, можно обращаться к элементам как в массиве
        collection2.add("1"); // добавить значение
        collection2.add("2");
        collection2.add("3");
        collection2.set(1, "5");
        //System.out.println(collection2.get(2));
        /*for (Object o: collection2) { //foreach - использует метод Iterator
            //System.out.println(o);
            }*/
        //System.out.println(collection2.size());
        Set collection3 =  new HashSet(); //Set - коллекция уникальных значений
        collection3.add("1"); // добавить значение
        collection3.add("2");
        collection3.add("2");
        collection3.add("2");
        collection3.add("2");
        collection3.add("3");
        collection3.add("4");
        for (Object o: collection3) { //foreach - использует метод Iterator
            System.out.println(o);
            }
        System.out.println("PriorityQueue");
        Queue collection4 = new PriorityQueue(); //приоритет очереди первый пришел, первый ушел
        collection4.add("1"); // добавить значение
        collection4.add("2");
        collection4.offer("3");// добавить значение
         Iterator iterator2 = collection4.iterator();
        while(iterator2.hasNext()) {
            System.out.println(collection4.poll());//выводит и после удаляет
        }
        System.out.println("num of elements" + collection4.size());

        System.out.println("Map");
        Map collection5 = new HashMap();
        collection5.put("1", "Isarow");
        collection5.put("2", "Tolstog");

        Set set = collection5.entrySet();
        for(Object j: set){
            System.out.println(j);
        }
        }
    }

    /*hasNext() - Возвращает истинное значение, если во время итерации встречается большое количество элементов.
    next() - Возвращает следующий указанный элемент во время итерации.
    remove() - Этот метод удаляет текущий элемент. Создает исключение IllegalStateException,
    если предпринята попытка вызвать метод remove(), которому не предшествует вызов метода next().
    LinkedHashSet() - упорядочиный список (запоминае порядок заполнения)
    HashSet() - неупорядоченый (список значений может поменяться)
    TreeSet() - сортирует не зависимо от расположения
     */
