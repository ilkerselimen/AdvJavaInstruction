package Threads;
//threadler aynı anda aynı kaynağa erişip değişiklik yapmak isterlerse ne olacak?
//multithreading programlamada birden fazla thread aynı kaynağa(critical section) aynı anda erişip değişiklik yapmaya çalışırsa
//istenmeyen sonuçlar olur. Bu durumda threadlere sırayla erişim verilir. Yani ortak kaynağı bir thread kullanırken diğer
//thread beklemelidir. Bu işlem syncronized keywordü ile gerçekleştirlir.
public class MultiThreading02 {

    public static int counter=0;

    public static void main(String[] args) {

        //iki tane thread oluşturup bu threadlerin aynı kaynağa(counter) erişmesini sağlayalım
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" çalıştı.");
                Counter.count();
            }
        });
        thread1.setName("Tom");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" çalıştı.");
                Counter.count();
            }
        });
        thread2.setName("Jerry");
        thread2.start();




    }

}

class Counter{
    //counter değişkeninin değerini 1000 kez arttırsın.
    public static synchronized void count(){
        //synchronized ile metoda erişen threadleri sıraya koymuş oluruz.
        //yani metodu aynı anda sadece bir thread kullanabilsin
        for (int i = 1; i <1001 ; i++) {
            MultiThreading02.counter++;//1000+1000= beklenen 2000
        }
        System.out.println(Thread.currentThread().getName()+" --> Counter: "+MultiThreading02.counter);
    }
}
