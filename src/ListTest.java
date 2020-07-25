import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListTest {
    public static void main(String args[]) {
        List list = new ArrayList();
        //ArrayList - Использует обычные массивы, быстрый в плане перебора элементов, но медленный в плане удаления
        //Использует arraycopy()
        List list2 = new Vector();
        //Vector - тоже самое что и ArrayList, только его методы synchronized
        List list3 = new LinkedList();
        //LinkedList - В основе заложен связанный список, каздый элемент массива ссылается на предыдущий и последующий
        //из плюсов быстрый доступ к первому и последнему элементу, удаление происходит переписыванием от первого до последнего
        // таблицы взаимосвязей
        list.add("1");
        list.add("2");
        list.add("3");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
