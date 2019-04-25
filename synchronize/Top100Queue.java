package synchronize;

import HomeWork10.WarAndPeace;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Top100Queue {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = WarAndPeace.class.getClassLoader();
        File file = new File(loader.getResource("wp.txt").getFile());

        List<String> lines = Files.readAllLines(file.toPath());

        List<String> words = new ArrayList<>();

        for (String line : lines) {
            String[] wordSplit = line.toLowerCase() // приведение к нижнему регистру
                    .replaceAll("\\p{Punct}", " ") // знаки препинания на пробел
                    .trim() // убираем пробелы
                    .split("\\s");
            for (String s : wordSplit) {
                if (s.length() > 0) {
                    words.add(s.trim());
                }
            }
        }
//        words.add("EndEndEnd");
        Comparator<Map.Entry<String, Integer>> entryComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };

        ArrayBlockingQueue<String> wordGet = new ArrayBlockingQueue<>(5, true);
        ArrayBlockingQueue<String> wordGive = new ArrayBlockingQueue<>(5, true);

        ConcurrentHashMap freq = new ConcurrentHashMap();
        Set<Map.Entry<String, Integer>> sort = new TreeSet<>(entryComparator);
        ArrayList<Thread> threads = new ArrayList<>();
        double procNum = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i< procNum; i++) {
            Mediator mediator = new Mediator(wordGet, wordGive);
            threads.add(mediator);
        }
        for (int i = 0; i< procNum; i++) {
            Giver giver = new Giver(wordGive, freq);
            threads.add(giver);
        }

        for (int i = 0; i < procNum; i++) {
            double from = Math.floor((i / procNum) * words.size());
            double to = Math.floor(((i + 1) / procNum) * words.size());
            if (i == 0) {
                ArrayList<String> wordPart = new ArrayList<>(words.subList((int) from, (int) to));
                wordPart.add("EndEndEnd");
                Grabber grabber = new Grabber(wordPart, wordGet);
                //grabber.start();
                threads.add(grabber);
            } else {
                ArrayList<String> wordPart = new ArrayList<>(words.subList((int) from +1, (int) to));
                wordPart.add("EndEndEnd");
                Grabber grabber = new Grabber(wordPart, wordGet);
                //grabber.start();
                threads.add(grabber);
            }
        }

        for (Thread thread: threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sort.addAll(freq.entrySet());
        for (int i = 0; i < 100; i++) {
            System.out.println(((TreeSet<Map.Entry<String, Integer>>) sort).pollLast());
        }

        System.out.println("Количество элементов в  wordGet: " + wordGet.size());
        System.out.println("Количество элементов в  wordGive: " + wordGive.size());




    }
}
class Grabber extends Thread {
    private ArrayList<String> wordsPart;
    private ArrayBlockingQueue<String> wordGet;

    public Grabber(ArrayList<String> wordsPart, ArrayBlockingQueue<String> wordGet) {
        this.wordsPart = wordsPart;
        this.wordGet = wordGet;
    }

    @Override
    public void run() {

        for (String word: wordsPart) {
            try {
//                if (word.equals("EndEndEnd")){
////                    sleep(1000);
//                }
                wordGet.put(word);
//                System.out.println("Достаем из списка " + word);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Mediator extends Thread {
    private ArrayBlockingQueue<String> wordGet;
    private ArrayBlockingQueue<String> wordGive;

    public Mediator(ArrayBlockingQueue<String> wordGet, ArrayBlockingQueue<String> wordGive) {
        this.wordGet = wordGet;
        this.wordGive = wordGive;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String word = wordGet.take();
                if (word.equals("EndEndEnd")) {
//                    wordGet.drainTo(wordGive);
                    wordGive.put(word);
//                    System.out.println(wordGet.size());
                    break;

//                    if(wordGet.size() != 0){
//                        wordGet.offer(word);
//                        continue;
//                    } else {
//                        wordGive.put(word);
//                        System.out.println(wordGet.size());
//                        break;
//                    }
                } else {
                    wordGive.put(word);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Giver extends Thread {
    private ArrayBlockingQueue<String> wordGive;
    Map<String, Integer> freq;

    public Giver(ArrayBlockingQueue<String> wordGive, Map<String, Integer> freq) {
        this.wordGive = wordGive;
        this.freq = freq;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String word = wordGive.take();
                if (word.equals("EndEndEnd")) {
                    break;

//
//                    if (wordGive.size() != 0){
//                        wordGive.offer(word);
//                        continue;
//                    } else {
//                        System.out.println(wordGive.size());
//                        break;
//                    }
                }
//                System.out.println("Помещаем в map " + word);
                if (freq.containsKey(word)){
                    freq.put(word, freq.get(word)+1);
                } else {
                    freq.put(word, 1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

