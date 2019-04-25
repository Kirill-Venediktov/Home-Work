package HomeWork15.port;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class port {

    public static final int PORTS = 3;

    public static void main(String[] args) {
        ArrayList<Berth> berths = new ArrayList<>();
        for (int i = 0; i < PORTS; i++) {
            Berth berth = new Berth();
            berth.setId(i+1);
            berths.add(berth);
        }

        Random ran = new Random();

        for(int i=1;i<10;i++) {
            int a = ran.nextInt(PORTS);
            new ship(berths.get(a)).start();
        }
    }
}

class Berth {
    Semaphore semaphore = new Semaphore(1);
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }
}

class ship extends Thread {
    Berth berth;

    public ship(Berth berth) {
        this.berth = berth;
    }

    @Override
    public void run() {
        try {
            berth.semaphore.acquire();

            Random ran = new Random();
            int a = ran.nextInt(3);

            switch (a) {
                case 0:
                    System.out.println(Thread.currentThread().getName() + " Корабль разгружается" + " у причала №" + berth.getId());
                    Thread.sleep(1000);
                    break;
                case 1:
                    System.out.println(Thread.currentThread().getName() + " Корабль загружается" + " у причала №" + berth.getId());
                    Thread.sleep(2000);
                    break;
                case 2:
                    System.out.println(Thread.currentThread().getName() + " Корабль разгружаетя и загружается" + " у причала №" + berth.getId());
                    Thread.sleep(5000);
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        berth.semaphore.release();
    }
}

