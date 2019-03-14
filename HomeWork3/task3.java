package HomeWork3;

import java.util.Arrays;
public class task3 {
    public static void main(String[] args) {

        int[] arr = new int[15];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*10);
        }

        System.out.println(Arrays.toString(arr));

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] == 0) {
                    continue;
                }
                count++;
            }

        }

        System.out.println("Колличество четных элементов в массиве: " + count);
    }


}
