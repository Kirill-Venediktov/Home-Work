package HomeWork11;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOtask {
    public static void main(String[] args) {
//        File fileRead = new File("src/HomeWork11/one.txt");
//        File break1 = new File("src/HomeWork11/break1.txt");
//        File break2 = new File("src/HomeWork11/break2.txt");


//        String fileRead = "src/HomeWork11/one.txt";
//        String fileWrite = "src/HomeWork11/two.txt";

//        try {
//            IOtask.copyFile(true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            IOtask.breakFile(true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//

//            try {
//                IOtask.mergeFile(true);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }


//        try {
//            IOtask.length();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            IOtask.encode();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            IOtask.decode();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            IOtask.encodeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            IOtask.decodeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //  Скопировать файл (имена файлов задаются с клавиатуры). Программа должна выводить количество скопированных байт
    public static void copyFile(boolean append) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название считываемого файла");
        String fileRead = in.nextLine();
        System.out.println("Введите название файла для копирования: ");
        String fileWrite = in.nextLine();

        try (FileInputStream inputStream = new FileInputStream(fileRead)) {

            System.out.println("Скопировано " + inputStream.available() + " байт");
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                try (FileOutputStream outputStream = new FileOutputStream(fileWrite, append)) {
                    outputStream.write(data);
                }
            }
        }
    }

    //    Разбить/склеить файл. (имена файлов и размер куска задаются с клавиатуры)
    public static void breakFile(boolean append) throws IOException {
//        String fileRead = "src/HomeWork11/one.txt";
//        String break1 = "src/HomeWork11/break1.txt";
//        String break2 = "src/HomeWork11/break2.txt";

        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите название считываемого файла");
        String fileRead = in.nextLine();
        try (FileInputStream inputStream = new FileInputStream(fileRead)) {

            System.out.println("Доступно " + inputStream.available() + " байт");
            System.out.println("Введите колличество байт, которые Вы хотите скопировать: ");
            int size = in.nextInt();
            System.out.println("Введите название первого файла для разбивки: ");
            String break1 = in2.nextLine();
            System.out.println("Введите название второго файла для разбивки: ");
            String break2 = in2.nextLine();

            for (int i = 0; i < size; i++) {
                int data = inputStream.read();
                try (FileOutputStream outputStream = new FileOutputStream(break1, append)) {
                    outputStream.write(data);
                }
            }
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                try (FileOutputStream outputStream = new FileOutputStream(break2, append)) {
                    outputStream.write(data);
                }
            }
        }
    }

    public static void mergeFile(boolean append) throws IOException {
//        String partFile1 = "src/HomeWork11/break1.txt";
//        String partFile2 = "src/HomeWork11/break2.txt";
//        String merge = "src/HomeWork11/merge.txt";

        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите название первого файла для объединения: ");
        String partFile1 = in.nextLine();
        System.out.println("Введите название второго файла для объединения: ");
        String partFile2 = in.nextLine();
        System.out.println("Введите название  файла для сохранения: ");
        String merge = in2.nextLine();
        try (FileInputStream inputStream = new FileInputStream(partFile1)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                try (FileOutputStream outputStream = new FileOutputStream(merge, append)) {
                    outputStream.write(data);
                }
            }
        }
        try (FileInputStream inputStream = new FileInputStream(partFile2)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                try (FileOutputStream outputStream = new FileOutputStream(merge, append)) {
                    outputStream.write(data);
                }
            }
        }
    }

    //Посчитать в файле количество символов , (запятая). Количество вывести в консоль.
    public static void length() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название считываемого файла");
        String fileRead = in.nextLine();
        StringBuilder sb = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(fileRead)) {
            System.out.println(inputStream.available());
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                sb.append((char) data);
            }
            int count = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == ',') {
                    count++;
                }
            }
            System.out.println("Колличество запятых в тексте: " + count);
        }
    }

    // Зашифровать/ дешифровать файл паролем (XOR) (посмотреть в интернете)
    public static void encode() throws IOException {
//        String fileRead = "src/HomeWork11/one.txt";
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите название считываемого файла");
        String fileRead = in.nextLine();
        File encodeFile = new File("src/HomeWork11/encode.txt");
        System.out.println("Введите ключ для зашифровки");
        String key = in2.nextLine();
        StringBuilder sb = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(fileRead)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                sb.append((char) data);
            }
        }
        byte[] text = sb.toString().getBytes("UTF-8");
        byte[] keyb = key.getBytes("UTF-8");
        byte[] res = new byte[text.length];

        for (int i = 0; i < text.length; i++) {
            res[i] = (byte) (text[i] ^ keyb[i % keyb.length]);
        }
        try (FileOutputStream outputStream = new FileOutputStream(encodeFile, false)) {
            outputStream.write(res);
        }

    }

    public static void decode() throws IOException {
//        String fileRead = "src/HomeWork11/encode.txt";

        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите название считываемого файла");
        String fileRead = in.nextLine();
        File decodeFile = new File("src/HomeWork11/decode.txt");
        System.out.println("Введите пароль для расшифровки");
        String key = in2.nextLine();
        StringBuilder sb = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(fileRead)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                sb.append((char) data);
            }
        }
        byte[] text = sb.toString().getBytes("UTF-8");
        byte[] keyb = key.getBytes("UTF-8");
        byte[] res = new byte[text.length];
        for (int i = 0; i < text.length; i++) {
            res[i] = (byte) (text[i] ^ keyb[i % key.length()]);
        }
        try (FileOutputStream outputStream = new FileOutputStream(decodeFile, false)) {
            outputStream.write(res);
        }
    }

//    Зашифровать/ дешифровать файл другим файлом

    public static void encodeFile() throws IOException {
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите пкть к считываемому файлу");
        String fileRead = in.nextLine();
        File encodeFile = new File("src/HomeWork11/encode.txt");
        System.out.println("Введите путь к файлу-ключу");
        String fileKey = in2.nextLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbKey = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(fileRead)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                sb.append((char) data);
            }
        }
        try (FileInputStream inputStream = new FileInputStream(fileKey)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                sbKey.append((char) data);
            }
        }
        byte[] text = sb.toString().getBytes("UTF-8");
        byte[] key = sbKey.toString().getBytes("UTF-8");
        byte[] res = new byte[text.length];
        for (int i = 0; i < text.length; i++) {
            res[i] = (byte) (text[i] ^ key[i % key.length]);
        }
        try (FileOutputStream outputStream = new FileOutputStream(encodeFile, false)) {
            outputStream.write(res);

        }
    }

    public static void decodeFile() throws IOException {
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите название считываемого файла");
        String fileRead = in.nextLine();
        File decodeFile = new File("src/HomeWork11/decode.txt");
        System.out.println("Введите путь к файлу-ключу");
        String fileKey = in2.nextLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbKey = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(fileRead)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                sb.append((char) data);
            }
        }
        try (FileInputStream inputStream = new FileInputStream(fileKey)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                sbKey.append((char) data);
            }
        }
        byte[] text = sb.toString().getBytes("UTF-8");
        byte[] key = sbKey.toString().getBytes("UTF-8");
        byte[] res = new byte[text.length];
        for (int i = 0; i < text.length; i++) {
            res[i] = (byte) (text[i] ^ key[i % key.length]);
        }
        try (FileOutputStream outputStream = new FileOutputStream(decodeFile, false)) {
            outputStream.write(res);
        }
    }
}


