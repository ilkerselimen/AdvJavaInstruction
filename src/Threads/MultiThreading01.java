package Threads;

public class MultiThreading01 {
    public static void main(String[] args) {
    long start=System.currentTimeMillis();
    CounterWithoutMultiThread counter1=new CounterWithoutMultiThread("Ebubekir");
    CounterWithoutMultiThread counter2=new CounterWithoutMultiThread("Akın");
    counter1.countMe();
        System.out.println("------------------------------");
    counter2.countMe();
    long finish=System.currentTimeMillis();

    System.out.println("WithoutMultiThread ile geçen süre: "+(finish - start));

    System.out.println("------------------------------");

    long startTime=System.currentTimeMillis();
    CounterWithMultiThread counter3=new CounterWithMultiThread("İlker");
    CounterWithMultiThread counter4=new CounterWithMultiThread("Abdullah");
    counter3.start();
    counter3.setName("İlker");
//        try {
//            counter3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("------------------------------");
    counter4.start();
    counter4.setName("Abdullah");
//        try {
//            counter4.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        try {
            counter3.join();//main threade counter3 thredinin işlemi bitene kadar bekle
            counter4.join();//main threade counter4 thredinin işlemi bitene kadar bekle
                            //sonra tekrar main thread e katıl(join)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    long finishTime=System.currentTimeMillis();
    System.out.println("WithMultiThread ile geçen süre: "+(finishTime - startTime));

    }

}

class CounterWithoutMultiThread{

    public String name;

    //constructor
    public CounterWithoutMultiThread(String name) {
        this.name = name;
    }
    //thread kullanmadan 1 den 10 a kadar yazdıran method
    public void countMe()  {
        for (int i = 1; i < 11; i++) {
            try {
                Thread.sleep(500);//0.5sn yavaşlatalım.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : "+i+" - "+name);
        }
    }

}

class CounterWithMultiThread extends Thread{

    public String name;

    public CounterWithMultiThread(String name) {
        this.name = name;
    }
//thread ile ekrana 1 den 10 a kadar yazdırma
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" çalışmaya başladı");
        countMe();
    }

    public void countMe()  {
        for (int i = 1; i < 11; i++) {
            try {
                Thread.sleep(500);//0.5sn yavaşlatalım.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : "+i+" - "+name);
        }
    }

}
