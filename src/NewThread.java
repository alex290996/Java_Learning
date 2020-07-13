public class NewThread implements Runnable{
    String name;
    Thread t;
    boolean suspendFlag;

        NewThread(String threadname){
            name = threadname;
            t = new Thread(this, name);
            System.out.println("Новый поток" + t);
            suspendFlag = false;
            t.start();
        }

    @Override
    public void run() {
try {
    for(int i = 15; i > 0; i--) {
     System.out.println(name + ":" + i);
     Thread.sleep(200);
        // returns the state of this thread
        /*currentThread() - текущий поток выполнения
        getState() - статус потока. Значения: BLOCKED - Приостановил выполнение, ожидает блокировки; NEW - Ожидает выполнения;
        RUNNABLE - Выполняется; TERMINATED - Завершен; TIMED_WAITING - приостановил выполнение на определенный промежуток времени;
        WAITING - Ожидает некоторого действия.
        wait() - приостанавливает выполнение потока
        notify() - возобновление потока
        join() - завершает поток после выполнения либо через определенный интервал времени*/
        Thread.State state = Thread.currentThread().getState();
        System.out.println(Thread.currentThread().getName());
        System.out.println("state = " + state);
     synchronized (this) {
         while(suspendFlag) {
             wait();
         }
     }
    }
}
catch (InterruptedException e) {
    System.out.println(name + " прерван");
}
    }
    synchronized void mysuspend () {
            suspendFlag = true;
}
    void myresume () {
            suspendFlag = false;
            notify();
}
}

/*Когда переменная-экземпляр объявлена как transient, ее значение не должно сохраняться,
когда сохраняется объект, как показано ниже.
class Т {
transient int а; //не сохранится
int Ь; // сохранится
}

Модификатор доступа volatile сообщает компилятору, что модифицируемая
им переменная может быть неожиданно изменена в других частях программы.
Одна из таких ситуаций возникает в многопоточных программах, где иногда в двух
или больше потоках исполнения разделяется общая переменная. Из соображений
эффективности в каждом потоке может храниться своя закрытая копия этой
переменной. Настоящая (или главная) копия переменной обновляется в разные
моменты, например при входе в синхронизированный метод.
 */
