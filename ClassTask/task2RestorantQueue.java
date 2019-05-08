package ClassTask;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class task2RestorantQueue {

    public static final int NUMBEROFCASS = 3;
    public static final int NUBMEROFVISITORS = 20;
    public static final int NUMBEROFVISITORMANAGERS = 1;

    public static void main(String[] args) {

        Comparator<ArrayBlockingQueue> queueComparator = new Comparator<>() {
            @Override
            public int compare(ArrayBlockingQueue o1, ArrayBlockingQueue o2) {
                return o1.size() - o2.size();
            }
        };

        ConcurrentSkipListSet<ArrayBlockingQueue> setOfQueues = new ConcurrentSkipListSet<>(queueComparator);

        CopyOnWriteArrayList<ArrayBlockingQueue> arrayOfQueues = new CopyOnWriteArrayList<>();

//        arrayOfQueues.sort(queueComparator);

        for(int i = 0; i< NUMBEROFCASS; i++){
            ArrayBlockingQueue<VisitorQ> cassQueue = new ArrayBlockingQueue<>(NUBMEROFVISITORS, true);
            arrayOfQueues.add(i, cassQueue);
        }


        for (int i = 0; i < NUBMEROFVISITORS; i++){
            try {
            VisitorQ visitor = new VisitorQ(i);
            int cass = new Random().nextInt(NUMBEROFCASS);
            arrayOfQueues.get(cass).put(visitor);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        for(int i = 0; i < NUMBEROFCASS; i++){
            new CassQ(arrayOfQueues.get(i)).start();
        }

        for(int i = 0; i < NUMBEROFVISITORMANAGERS; i++){
            new VisitorManagerQ(arrayOfQueues).start();
        }



    }
}

class VisitorManagerQ extends Thread {

    private CopyOnWriteArrayList<ArrayBlockingQueue> arrayOfQueues;

    public VisitorManagerQ(CopyOnWriteArrayList<ArrayBlockingQueue> arrayOfQueues) {
        this.arrayOfQueues = arrayOfQueues;
    }

    @Override
    public void run() {
        while (true) {

            int max = 0;
            int min = task2Restorant.NUBMEROFVISITORS;

            for (ArrayBlockingQueue<VisitorQ> queue : arrayOfQueues){
                max = Math.max(queue.size(), max);
                min = Math.min(queue.size(), min);
            }

            for (ArrayBlockingQueue<VisitorQ> queue1 : arrayOfQueues) {
                if (queue1.size() == max && max != 1) {
                    for (ArrayBlockingQueue<VisitorQ> queue2 : arrayOfQueues){
                        if (queue2.size() == min){
                            try {
                                VisitorQ visitor = queue1.take();
                                System.out.println("Посетитель с id" + visitor.getId() + " перешел из очереди "
                                        + " размером " + max + " в очередь "  + " размером" + min);
                                queue2.put(visitor);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}


class VisitorQ  {
    int id;

    public VisitorQ(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class CassQ extends Thread {

    public static final int MAXWAITNGTIME = 5000;

    private  ArrayBlockingQueue<VisitorQ> cassQueue;

    public CassQ(ArrayBlockingQueue<VisitorQ> cassQueue) {
        this.cassQueue = cassQueue;
    }

    @Override
    public void run() {
        while (true) {

            try {
                VisitorQ visitor = cassQueue.take();
                int waitingTime = new Random().nextInt(MAXWAITNGTIME);
                System.out.println(Thread.currentThread().getName() + " Готовим заказ для посетителя с id  " + visitor.getId());
                Thread.sleep(waitingTime);
                System.out.println("Посетитель с id " + visitor.getId() + " получил свой заказ");
                if (cassQueue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " очередь пуста, шеф");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

