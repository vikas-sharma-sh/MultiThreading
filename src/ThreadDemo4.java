class SleepTest implements Runnable {
    private final String name;

    public SleepTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": " + i);
//            try {
//                Thread.sleep(500); // pause for 500ms
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}

public class ThreadDemo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new SleepTest("Thread-1"));
        Thread t2 = new Thread(new SleepTest("Thread-2"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();


//        try {
//            // Wait for t1 to finish before continuing main thread
//            t1.join();
//            System.out.println("Thread-1 has finished. Main continues...");
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("Main thread ends.");
    }
}
