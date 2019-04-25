package test;

import HomeWork10.WarAndPeace;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class test {
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
        System.out.println(words.size());

        double procNum = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < procNum; i++ ) {
            double from = (i/procNum)*words.size();
            double to = ((i+1)/procNum)*words.size();
            double fromR = Math.floor((i/procNum)*words.size());
            double toR = Math.floor(((i+1)/procNum)*words.size());
            if (i == 0) {
                System.out.println("итерация " + i + " from " +from + " to " + to);
                System.out.println("итерация " + i + " from " + (int)fromR + " to " + (int)toR);
            } else {
                System.out.println("итерация " + i + " from " + from + " to " + to);
                System.out.println("итерация " + i + " from " + ((int)fromR + 1) + " to " + ((int)toR));
            }
        }
    }
}
