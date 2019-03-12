package HomeWork2;

import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите число a (целое): ");
        int a = in.nextInt();
        System.out.println("Введите число b (целое): ");
        int b = in.nextInt();
        System.out.println("Введите число c (целое): ");
        int c = in.nextInt();

        if  ((a > b) && (b > c)) {
            System.out.println("Цифры в порядке возрастания: " + c +"," + b + ","+ a);
        }

            else if  ((a > c) && (c > b)) {
                System.out.println("Цифры в порядке возрастания: " + b + "," + c + "," + a);
        }

            else if  ((b > a) && (a > c)) {
            System.out.println("Цифры в порядке возрастания: " + c + "," + a + "," + b);
        }

            else if  ((b > c) && (c > a)) {
                System.out.println("Цифры в порядке возрастания: " + a + "," + c + "," + b);
            }

            else if  ((c > a) && (a > b)) {
                System.out.println("Цифры в порядке возрастания: " + b + "," + a + "," + c);

        }
            else {
            System.out.println("Цифры в порядке возрастания: " + a + "," + b + "," + c);
        }
    }


}
