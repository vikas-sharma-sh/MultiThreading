// Shared resource class - Counter
class Counter {
    private int count = 0; // Shared variable that multiple threads will update

    // Increments the count value by 1
    // ⚠️ Not thread-safe: multiple threads may corrupt the result
    // synchronized is thread safe
    public synchronized void incre() {
        count++;
    }
//    public void incre() {
//        count++;
//    }

    // Returns the current value of count
    public int getCount() {
        return count;
    }
}

// Thread class that will increment the counter
class CounterThread extends Thread {
    private Counter counter; // Shared counter object

    // Constructor accepts a shared counter instance
    CounterThread(Counter counter) {
        this.counter = counter;
    }

    // Code that will run in the new thread
    @Override
    public void run() {
        // Loop 10 times and increment the shared counter
        for (int i = 0; i < 10; i++) {
            counter.incre(); // This is not synchronized — race conditions can occur
        }
    }
}

// Main class to test the Counter with multiple threads
public class CounterTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(); // Create a shared Counter instance

        // Create two threads that will both update the same counter
        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);

        t1.start(); // Start thread t1 (it runs counter.incre() 10 times)
        t2.start(); // Start thread t2 (also runs counter.incre() 10 times)

        // Wait for both threads to finish before moving forward
        t1.join(); // Ensures t1 completes before main thread continues
        t2.join(); // Ensures t2 completes before main thread continues

        // Print final result of counter
        // Expected output: 20 (10 + 10)
        // ⚠️ May be less than 20 due to race conditions if both threads modify `count` at the same time
        System.out.println("Final Count: " + counter.getCount());
    }
}
/*
 t1.start() – Creates and runs a new thread
Starts a new thread, and it will call run() in that new thread.

Allows parallel execution.

 t1.join() – Waits for the thread to finish
Used after t1.start().

Makes the current thread wait until t1 has finished executing.

Ensures that the main thread doesn’t move on until t1 completes.
 */