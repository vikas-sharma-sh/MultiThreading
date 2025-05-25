class SavingAccount{

    public synchronized void withdraw(String name)  {
        for (int i = 0; i < 5; i++) {
            System.out.println("HElLO SIR : "+ name);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Transaction completed by : " + name);
        System.out.println("**********************Transaction Done *****************************");
    }

}

class MyThreadAccount extends Thread{

    SavingAccount s ;
    String name ;

    MyThreadAccount(SavingAccount s, String name){
        this.s =s ;
        this.name  = name ;

    }

    @Override
    public void run() {
        s.withdraw(name);
    }
}

public class SynchronisationDemo {

    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount();

        MyThreadAccount t1 = new MyThreadAccount(savingAccount,"user1");
        MyThreadAccount t2 = new MyThreadAccount(savingAccount,"user2");

        t1.start();
        t2.start();
    }
}

/*
Without synchronized, both threads might print messages interleaved, which leads
 to confusing output and can simulate data inconsistency in real-world cases like banking apps.
 */