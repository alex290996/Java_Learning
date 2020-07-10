public class SuspendResume {
    public static void main (String args[]){
        NewThread ob1 = new NewThread("Один");
        NewThread ob2 = new NewThread("Два");

    try{
        Thread.sleep(1000);
         ob1.mysuspend();
        System.out.println("Приостановка потока один");
        Thread.sleep(1000);
        synchronized (ob1) {
            ob1.myresume();
        }
        System.out.println("Возобновление потока один");
         ob2.mysuspend();
        System.out.println("Приостановление потока один");
        Thread.sleep(1000);
        synchronized (ob2) {
            ob2.myresume();
        }
        System.out.println("Возабновление потока два");

    } catch (InterruptedException e) {
        e.printStackTrace();
        System.out.println("Главный поток прерван");
    }

    try {
        System.out.println("Ожидание завершения потоков");
        ob1.t.join();
        ob2.t.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
        System.out.println("Главный поток прерван");
    }
    System.out.println("Главный поток завершен");
    }
}
