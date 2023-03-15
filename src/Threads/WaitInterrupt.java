package Threads;

public class WaitInterrupt {

    public static int balance=0;

    public static void main(String[] args) {

        WaitInterrupt object = new WaitInterrupt();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                object.withdraw(1000);
            }
        });
        thread1.setName("tüketici");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                object.deposit(2000);
                thread1.interrupt();//thread1 in yaptigi islemi zorla durdurur.
                                    //wait methodu çağırıldığı için bekleme işlemi sonlandırıldı.
            }
        });
        thread2.setName("üreciti");
        thread2.start();

    }


    //para çekme methodu
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para çekmek istiyor.");
        if(balance<=0 || balance<amount){
            System.out.println("Bakiye yetersiz...Mevcut bakiye :"+balance);
            System.out.println("Bakiyenin güncellenmesini bekliyor.");
            try {
                wait();//object serbest bırakılıyor.
            } catch (InterruptedException e) {
                if(balance>=amount){
                    balance=balance-amount;
                    System.out.println("Para çekme işlemi gerçekleşti... Mevcut bakiye : "+balance);
                }else{
                    System.out.println("Bakiye yetersiz...Mevcut bakiye :"+balance);
                    System.out.println("Umudunu kaybetme, yarın yine gel:)");
                }
            }
        }

    }
    //para yatırma methodu
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor...");
        balance=balance+amount;
        System.out.println("Para yatırma işlemi gerçekleşti...Mevcut bakiye:"+balance);
    }

}
