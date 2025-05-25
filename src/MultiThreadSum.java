class SumTask implements Runnable {
    private int start, end;
    private int partialSum = 0;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getPartialSum() {
        return partialSum;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            partialSum += i;
        }
        System.out.println(Thread.currentThread().getName() + " calculated sum: " + partialSum);
    }
}

public class MultiThreadSum {
    public static void main(String[] args) throws InterruptedException {
        SumTask task1 = new SumTask(1, 10);  // Sum 1+2+3
        SumTask task2 = new SumTask(11, 15);  // Sum 4+5

        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        int totalSum = task1.getPartialSum() + task2.getPartialSum();
        System.out.println("Total Sum using threads: " + totalSum);
    }
}
