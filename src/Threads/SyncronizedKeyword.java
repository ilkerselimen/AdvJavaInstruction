package Threads;
//metod içerisinde istenmeyen sonuca sebep olmayan kodlar da varsa

        //Bütün metodu kilitlemek yerine, metot icerisinde kilitlemek istedigimiz
// yeri bir block araligina alip  synchronized (this) keyword unu kullaniyoruz

//syncronized keywordü sadece metodlar ve bloklar için kullanılabilir.
public class SyncronizedKeyword {
    public static void main(String[] args) {
        Brackets2 brackets2=new Brackets2();
        long startTime=System.currentTimeMillis();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9;i++){
                    brackets2.generateBrackets();
                }
            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9;i++){
                    brackets2.generateBrackets();
                }
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime=System.currentTimeMillis();
        //metod syncronized iken
        // System.out.println("Geçen süre :"+(endTime-startTime));//5579

        //syncronized block
        System.out.println("Geçen süre :"+(endTime-startTime));//2805

    }

}
class Brackets2{
    //[ [ [ [ [ ] ] ] ] ] şeklini ekrana yazdıran bir metod
    public void generateBrackets(){
        //this:bu classtan üretilen obje
        //bloğa erişen thread için objeyi kilitle işlem
        //tamamlandığında serbest bırak
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                if (i <= 5) {
                    System.out.print("[ ");
                } else {
                    System.out.print("] ");
                }
            }
            System.out.println();
        }

        //asenkron çalışmasında problem olmayan kodlar
        for (int i=1;i<=5;i++){
            //başka kodlar
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}