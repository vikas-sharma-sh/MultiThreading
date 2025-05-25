class threadTest extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread()+" "+ "child" + " "+ i);
            System.out.println("Child Thread executing......."+ " "+ i);
        }
    }
}


public class ThreadDemo {
    public static void main(String[] args) {
        threadTest t1 = new threadTest();
        t1.start();//start the thread

        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread()+" "+ "main" + " " +i);

            System.out.println("Main Thread " +" "+ i);
        }

    }

}
