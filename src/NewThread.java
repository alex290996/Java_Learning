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

synchronized void myresume () {
            suspendFlag = false;
            notify();
}

}
