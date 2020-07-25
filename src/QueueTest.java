import java.util.*;

public class QueueTest {
    public static void main(String args[]) {
        Queue queue = new LinkedList();
        Queue queue1 = new PriorityQueue();
        queue1.offer("2");
        queue1.offer("1");// При добавлении сразу проходит сортировку в PriorityQueue
        queue1.offer("3");
        queue.offer("2");//А это просто добавление как add в LinkedList
        queue.add("1");
        queue.add("3");
        //Сортировка LinkedList через Collections.
        List list = (List) queue;
        Collections.sort(list);
        System.out.println("List");
        while (queue.size()>0){
            System.out.println(queue.poll());
        }
        System.out.println("Queue");
        while (queue1.size()>0){
            System.out.println(queue1.poll());
        }
    }
}
