package HomeWork3;

import java.util.Scanner;

import static java.lang.StringBuilder.*;

public class task6 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите исходную строку: ");
//        String a = in.nextLine();
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder(in.nextLine());

        for (int i = 0; i < stringBuilder.length(); i++) {
            char a = stringBuilder.charAt(i);
            for (int q = 0; q < stringBuilder.length(); q++) {
                if (a == stringBuilder.charAt(q)) {
                    stringBuilder.deleteCharAt(q);
                }
                if (stringBuilder.charAt(q) == ' ') {
                    stringBuilder.deleteCharAt(q);
                }
            }


            }
        System.out.println(stringBuilder);

        }


 //       System.out.println(a.toCharArray());






}
