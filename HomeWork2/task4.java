package HomeWork2;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите простое натуральное число: ");
        int a = in.nextInt();

        for (int i = 2; i < a; i++)
        if (a % i == 0) {
            System.out.println("Вы ввели какую-то дичь");
            break;
        }
        else {
            System.out.println("Вы молодец");
            break;
        }

    }
}
