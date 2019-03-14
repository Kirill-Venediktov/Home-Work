package HomeWork3;

import java.util.Arrays;
import java.util.Scanner;
public class task4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива (четное положительное число) : ");
        int a = in.nextInt();

        while (a % 2 != 0 || a < 0) {
            Scanner in2 = new Scanner(System.in);
            System.out.println("Только положительные и четные числа!");
            System.out.println("Введите размер массива (четное положительное число) : ");
            a = in.nextInt();
        }

        int[] arr = new int [a];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 6) % 10;
            if (Math.random() > 0.5) {
                arr[i] *= -1;
            }
        }
        System.out.println(Arrays.toString(arr));

        int left = 0;
        int right = 0;
        int[] arr2 = new int[a/2];
        System.arraycopy(arr, a/2, arr2, 0, a/2);
        System.out.println(Arrays.toString(arr2));
        for (int i = 0; i < (arr.length)/2; i++) {
            left += Math.abs(arr[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            right += Math.abs(arr2[i]);
        }

        if (left > right) {
            System.out.println("Сумма левой части больше");
        }
        else if (right > left) {
            System.out.println("Сумма правой части больше");
        }
        else {
            System.out.println("Сумма частей равна");
        }

    }

}

