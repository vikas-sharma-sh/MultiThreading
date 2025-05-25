
 class SumTest implements Runnable{
    static int  sum = 0 ;

     @Override
     public void run() {
         for(int i=0;i<5;i++){
             sum += i;
         }
     }
 }



public class SumDemo {
    public static void main(String[] args) throws InterruptedException{
//        SumTest t1 = new SumTest();
//        t1.run();
//        System.out.println("sum is = :"+ " "+ SumTest.sum);

        Thread t1 = new Thread(new SumTest(),"Sum");
        t1.start();
        t1.join();
        System.out.println("sum is : "+" "+ SumTest.sum);

    }

}
