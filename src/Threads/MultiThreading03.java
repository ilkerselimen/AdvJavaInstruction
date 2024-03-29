package Threads;

public class MultiThreading03 {

    public static void main(String[] args) {

        Brackets brackets=new Brackets();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <10 ; i++) {
                    brackets.generateBrackets();
                }
            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <10 ; i++) {
                    brackets.generateBrackets();
                }
            }
        });
        thread2.start();
        //iki thread aynı anda methoda erişmeye çalıştığında methodun içindeki işlem
        //tamamlanmadan diğer thread işleme başlayabiliyor bu sebeple sırayla erişmelerini istiyoruz


    }

}

class Brackets{
    // [ [ [ [ [ ] ] ] ] ] şeklini ekrana yazdıran bir method
    public synchronized void generateBrackets(){
        for (int i = 1; i < 11 ; i++) {
            if (i<6){
                System.out.print("[ ");
            }else System.out.print("] ");
        }
        System.out.println(Thread.currentThread().getName());
    }


}