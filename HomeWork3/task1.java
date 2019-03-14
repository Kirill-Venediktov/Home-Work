package HomeWork3;

import java.util.Arrays;

public class task1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int a = 0;
        for (int i = 0; i < arr.length; i++){
            a += 2;
            arr[i] = a;
        }

        System.out.println("Массив:");
        System.out.println(Arrays.toString(arr));

        System.out.println("Элементы массива в строчку:");

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println("");
        System.out.println("Элементы массива в столбик:");


        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }

    }



}
