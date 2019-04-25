package HomeWork15.task1Library.port;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class port {
    public static void main(String[] args) {





        for(int i=1;i<10;i++)
            new ship(berth).start();


    }
}
class Berth {
    Semaphore semaphore = new Semaphore(1);

    public Semaphore getSemaphore() {
        return semaphore;
    }
}

class ship extends Thread {
    Berth berth;

    public ship(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();

            Random ran = new Random();
            int a = ran.nextInt(3);

            switch (a) {
                case 0:
                    System.out.println(Thread.currentThread().getName() + " Корабль разгружается");
                    Thread.sleep(1000);
                    break;
                case 1:
                    System.out.println(Thread.currentThread().getName() + " Корабль загружается");
                    Thread.sleep(2000);
                    break;
                case 2:
                    System.out.println(Thread.currentThread().getName() + " Корабль разгружаетя и загружается");
                    Thread.sleep(5000);
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}

