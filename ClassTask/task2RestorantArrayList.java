package ClassTask;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class task2RestorantArrayList {

    public static final int NUMBEROFCASS = 3;
    public static final int NUBMEROFVISITORS = 20;
    public static final int NUMBEROFVISITORMANAGERS = 1;

    public static void main(String[] args) {

        CopyOnWriteArrayList<CopyOnWriteArrayList> arrayLists = new CopyOnWriteArrayList<>();

        for(int i = 0; i< NUMBEROFCASS; i++){
            CopyOnWriteArrayList<Visitor> visitors = new CopyOnWriteArrayList<>();
            arrayLists.add(i, visitors);
        }


        for (int i = 0; i < NUBMEROFVISITORS; i++){
                Visitor visitor = new Visitor(i);
                int cass = new Random().nextInt(NUMBEROFCASS);
                arrayLists.get(cass).add(visitor);

        }

        for(int i = 0; i < NUMBEROFCASS; i++){
            new Cass(arrayLists.get(i)).start();
        }

        for(int i = 0; i < NUMBEROFVISITORMANAGERS; i++){

            new VisitorManager(arrayLists).start();
        }



    }
}

class VisitorManager extends Thread {

    private CopyOnWriteArrayList<CopyOnWriteArrayList> arrayLists;

    public VisitorManager(CopyOnWriteArrayList<CopyOnWriteArrayList> arrayLists) {
        this.arrayLists = arrayLists;
    }


    @Override
    public void run() {
        while (true) {

            int max = 0;
            int min = task2RestorantArrayList.NUBMEROFVISITORS;

            for (CopyOnWriteArrayList<Visitor> arrayList : arrayLists) {
                max = Math.max(arrayList.size(), max);
                min = Math.min(arrayList.size(), min);
            }


            for (CopyOnWriteArrayList<Visitor> arrayList1 : arrayLists) {
                if (arrayList1.size() == max && (max - min) > 1) {
                    for (CopyOnWriteArrayList<Visitor> arrayList2 : arrayLists) {
                        if (arrayList2.size() == min) {
                            try {
                                Visitor visitor = arrayList1.remove(arrayList1.size()-1);
                                System.out.println("Посетитель с id" + visitor.getId() + " перешел из очереди "
                                        + " размером " + max + " в очередь "  + " размером" + min);
                                arrayList2.add(visitor);
                            }catch (ArrayIndexOutOfBoundsException e){
                                continue;
                            }
                        }
                    }
                }
            }
        }
    }
}


class Visitor  {
    int id;

    public Visitor(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class Cass extends Thread {

    public static final int MAXWAITNGTIME = 5000;

    private CopyOnWriteArrayList<Visitor> cassList;

    public Cass(CopyOnWriteArrayList<Visitor> cassList) {
        this.cassList = cassList;
    }


    @Override
    public void run() {
        while (true) {

            try {
                if (cassList.isEmpty()){
                    System.out.println(Thread.currentThread().getName() + " очередь пуста, шеф");
                    break;
                }
                Visitor visitor = cassList.remove(0);
                int waitingTime = new Random().nextInt(MAXWAITNGTIME);
                System.out.println(Thread.currentThread().getName() + " Готовим заказ для посетителя с id  " + visitor.getId());
                Thread.sleep(waitingTime);
                System.out.println("Посетитель с id " + visitor.getId() + " получил свой заказ");
            } catch (InterruptedException e) {
                continue;
//                e.printStackTrace();
            }
        }
    }
}
