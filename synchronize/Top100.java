package synchronize;

import HomeWork10.WarAndPeace;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Top100 {
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

        Comparator<Map.Entry<String, Integer>> entryComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };
        Map<String, Integer> freq = new HashMap<>();
        Set<Map.Entry<String, Integer>> sort = new TreeSet<>(entryComparator);

        double procNum = Runtime.getRuntime().availableProcessors();

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < procNum; i++ ) {
            double from = Math.floor((i/procNum)*words.size());
            double to = Math.floor(((i+1)/procNum)*words.size());
            if (i == 0) {
                Thread thread = new Thread(new MyThread(new ArrayList<String>(words.subList((int)from,(int) to)), freq));
                thread.start();
                threads.add(thread);
            } else {
                Thread thread = new Thread(new MyThread(new ArrayList<String>(words.subList((int)from+1,(int)to)), freq));
                thread.start();
                threads.add(thread);
            }
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
    }
}

class MyThread implements Runnable {
    ArrayList<String> wordsPart;
    Map<String, Integer> freqPart = new HashMap<>();
    Map<String, Integer> freq;

    public MyThread(ArrayList<String> wordsPart, Map<String, Integer> freq) {
        this.wordsPart = wordsPart;
        this.freq = freq;
    }

    @Override
    public void run() {

        for (String word: wordsPart) {
            if (freqPart.containsKey(word)){
                freqPart.put(word, freqPart.get(word)+1);
            } else {
                freqPart.put(word, 1);
            }
        }

        synchronized (freq) {
            for (Map.Entry<String, Integer> entry: freqPart.entrySet()) {
                String  key = entry.getKey();
                if(freq.containsKey(key)) {
                    freq.put(key, freq.get(key) + entry.getValue());
                } else {
                    freq.put(key, entry.getValue());
                }
            }
        }
    }
}
