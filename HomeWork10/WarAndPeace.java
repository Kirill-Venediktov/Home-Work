package HomeWork10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class WarAndPeace {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = WarAndPeace.class.getClassLoader();
        File file = new File(loader.getResource("wp.txt").getFile());
        File file2 = new File(loader.getResource("articles.txt").getFile());

        List<String> lines = Files.readAllLines(file.toPath());
        List<String> articles = Files.readAllLines(file2.toPath());

//        for (String string : lines){
//            System.out.println(string);

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

        List<String> letters = new ArrayList<>();
        for (String line : lines) {
            String[] wordSplit = line.toLowerCase() // приведение к нижнему регистру
                    .replaceAll("\\p{Punct}", " ") // знаки препинания на пробел
                    .replaceAll("\\d", "")
                    .trim() // убираем пробелы
                    .split("");
            for (String s : wordSplit) {
                if (s.length() > 0 && !s.equals(" ")) {
                    letters.add(s.trim());
                }
            }
        }
//        for(String sig : letters){
//            System.out.println(sig);
//        }

//        System.out.println(letters.toString());


//        for (String word : words) {
//            System.out.println(word);
//        }
        List<String> wordsCopy = new ArrayList<>(words);

//             Сосчитать частоту встречаемости слов
        Map<String, Integer> freq = new HashMap<>();

        while (wordsCopy.size() > 0) {
            String w = wordsCopy.get(0);
            wordsCopy.remove(0);
            int count = 1;
            for (int i = 0; i < wordsCopy.size(); i++) {
                if (wordsCopy.get(i).equals(w)) {
                    count++;
                    wordsCopy.remove(i);
                    i--;
                }
            }
            freq.put(w, count);
        }

        System.out.println(freq.toString());

        // Собрать все слова в группы по количеству букв
        Map<Integer, HashSet<String>> wordLength = new TreeMap<>();
        for (String word : words) {
            if (!wordLength.containsKey(word.length())) {
                wordLength.put(word.length(), new HashSet<>());
            }
            wordLength.get(word.length()).add(word);
        }

//       System.out.println(wordLength.toString());

        //Вывести топ 10 самых частых слов и фраз

        Comparator<Map.Entry<String, Integer>> entryComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };

        Set<Map.Entry<String, Integer>> sort = new TreeSet<>(entryComparator);
        sort.addAll(freq.entrySet());
        for (int i = 0; i < 10; i++) {
            System.out.println(((TreeSet<Map.Entry<String, Integer>>) sort).pollLast());
        }

        // Тоже, что и 2, но без артиклей, частиц и тп
        Map<Integer, HashSet<String>> wArtMap = new HashMap<>(wordLength);
        for (int i = 1; i <= wArtMap.size(); i++) {
            wArtMap.get(i).removeAll(articles);
        }

//        System.out.println(wArtMap.toString());

        // Вывести частоту встречаемости букв анг алфавита по этой книге. Вывести в процентах для каждой буквы.

        Map<String, ArrayList<String>> sign = new HashMap<>();
        for (String str : letters) {
            if (!sign.containsKey(str)) {
                sign.put(str, new ArrayList<>());
            }
            sign.get(str).add(str);
        }

        Map<String, Integer> percent = new TreeMap<>();
        for (Map.Entry<String, ArrayList<String>> entry : sign.entrySet()) {
            if (!percent.containsKey(entry.getKey())) {
                percent.put(entry.getKey(), Math.round(entry.getValue().size() * 100 / letters.size()));
                System.out.println("количество букв: " + entry.getValue().size());
                System.out.println("общее число букв" + letters.size());
            }
        }
        for (Map.Entry<String, Integer> entry : percent.entrySet()) {
            System.out.println(entry.getKey() + " Процент от общего числа: " + entry.getValue() + "%");
        }


    }
}

