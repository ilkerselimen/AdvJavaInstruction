package Threads;
/*
Birden fazla thread aynı değişkende değişiklik yaparken
CPU üzerinde farklı çekirdeklerde çalışabilir.
Değişkenin bilgisi hız kazanmak için main memory yerine çekirdeğin cacheinde
tutulursa bir threadin yaptığı güncellemeden diğer threadlerin haberi olmayabilir.
Değişken bilgisinin cache yerine main memorye yazılıp oradan çağrılmasını sağlamak için
Volatile keywordü kullanılır. Dolayısıyla her threadin güncellemeleri görmesi garanti altına alınır.
 */
public class Volatile {

    public volatile static int flag=0;//değişken bilgisinin main memoryde tutulmasını garanti ediyoruz

    public static int counter=0;

    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag==0){//flag değeri 1. çekirdeğin cache(ön bellek) de tutulursa
                    System.out.println("Thread1 çalışıyor...");
                    counter++;
                }
            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                flag=1;//flag değeri 2. çekirdeğin cache(ön bellek) de tutulursa
                System.out.println("Flag değeri 1 olarak güncellendi...");
            }
        });
        thread2.start();

        //iki ayrı çekirdeğin cacheinde flag değeri tutuluyorsa threadler güncel değeri göremeyebilirler..!

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("counter: "+counter);


    }

}
