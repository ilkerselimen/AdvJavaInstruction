package Threads;
/*
Deadlock(Ölümcül kilitlenme);iki veya daha fazla threadin işlemlerini tamamlamak için
 birbirinin kilitlemiş olduğu kaynaklara erişmek istemesi gibi durumlarda oluşur.
 Bu da uygulamayı olumsuz etkiler, sunucu cevap veremez hale gelir.
 Genellikle iç içe synchronized blok kullanıldığında karşılaşılır.
 */
public class DeadlockDemo {
    public static void main(String[] args) {
        String obj1="kahve";
        String obj2="şeker";

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj1){
                    System.out.println(Thread.currentThread().getName()+" "+obj1+" i kullanıyor.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(Thread.currentThread().getName()+" "+obj2+" i istiyor.");
                    synchronized (obj2){
                    System.out.println(Thread.currentThread().getName()+" "+obj2+" i kullanıyor.");
                    }
                }
                System.out.println(Thread.currentThread().getName()+" kahvesini içiyor.");
            }
        });
        thread1.setName("Sylwester");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj2){
                    System.out.println(Thread.currentThread().getName()+" "+obj2+" i kullanıyor.");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(Thread.currentThread().getName()+" "+obj1+" i istiyor.");
                    synchronized (obj1){
                        System.out.println(Thread.currentThread().getName()+" "+obj1+" i kullanıyor.");
                    }
                }
                System.out.println(Thread.currentThread().getName()+" kahvesini içiyor.");
            }
        });
        thread2.setName("Tweety");
        thread2.start();


    }

}
