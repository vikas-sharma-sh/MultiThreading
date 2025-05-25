class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread()+" "+ "runnable "+ " "+ i);
            System.out.println("runnable "+ " "+ i);
        }
    }
}


public class ThreadDemo2 {

    public static void main(String[] args) {
        //start method is in thread class then m1 is passed in thread constructor
        MyRunnable m1 = new MyRunnable();
        Thread t1 = new Thread(m1);
        t1.start();//for multithreading start method is done

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread());
            System.out.println("main"+ " "+ i);
        }

        //these output is always not guessed it is dependent on thread scheduler




    }

}
