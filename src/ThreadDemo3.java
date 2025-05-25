class yieldTest implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            Thread.yield();
        }
    }
}



public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new yieldTest());
        t1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+" "+":"+ i);
        }

    }
}
