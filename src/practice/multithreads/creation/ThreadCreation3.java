package practice.multithreads.creation;

public class ThreadCreation3 {
    public static void main(String[] args) {
        // Task 4 : anonymous class ile thread olusumu
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
               Thread.currentThread().setName("Fare");
               String name = Thread.currentThread().getName();
               for (int i=1; i <=100 ; i++) {
                    System.out.println(name + " : kaciyorum...");
                }
            }
        });

        // Task 5 : Lambda expression ile thread olusturalim

        Thread thread2 = new Thread(()-> {
            Thread.currentThread().setName("Kedi");
            String name = Thread.currentThread().getName();
            for(int i=1 ; i<=100; i++) {
                System.out.println(name + " : yakalayacagim...");
            }
        });

        thread1.start();
        thread2.start();
    }
}
