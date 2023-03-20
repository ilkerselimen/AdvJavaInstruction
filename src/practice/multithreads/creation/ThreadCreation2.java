package practice.multithreads.creation;

public class ThreadCreation2 {

    public static void main(String[] args) {
        //!!!Task2:Runnable interfaceni implement eden Counter isminde sınıf oluşturup
            // bu sınıfta harfleri a dan z ye kadar yazdıran iki tane thread oluşturunuz.

        //!!!Task3: Threadler başlamadan önce Yarış başlasın ve bitince Yarış bitti

        System.out.println("Yaris basladi....."); // MAIN

        Counter c1 = new Counter("A"); // MAIN
        Counter c2 = new Counter("B"); //MAIN

        Thread thread1 = new Thread(c1);
        Thread thread2 = new Thread(c2);

        thread1.start(); // MAIN - TH1
        thread2.start(); // MAIN th1 th2


        // main threadini bekletelim
 /*       try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        // join
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Yaris bitti.....");
    }
}
