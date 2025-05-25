class SharedResource {
    private boolean available = false;

    // Producer puts data in the resource
    public synchronized void produce(String producerName) {
        while (available) {
            try {
                System.out.println(producerName + " waiting to produce...");
                wait(); // Wait until the resource becomes available
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(producerName + " produced item");
        available = true;
        notify(); // Notify a waiting consumer
    }

    // Consumer takes data from the resource
    public synchronized void consume(String consumerName) {
        while (!available) {
            try {
                System.out.println(consumerName + " waiting to consume...");
                wait(); // Wait until the resource is available
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(consumerName + " consumed item");
        available = false;
        notify(); // Notify a waiting producer
    }
}

class Producer extends Thread {
    private SharedResource resource;
    private String name;

    Producer(SharedResource resource, String name) {
        this.resource = resource;
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.produce(name);
            try {
                Thread.sleep(1000); // simulate delay
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Consumer extends Thread {
    private SharedResource resource;
    private String name;

    Consumer(SharedResource resource, String name) {
        this.resource = resource;
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.consume(name);
            try {
                Thread.sleep(1000); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class WaitNotifyDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Producer producer = new Producer(resource, "Producer");
        Consumer consumer = new Consumer(resource, "Consumer");

        producer.start();
        consumer.start();
    }
}
