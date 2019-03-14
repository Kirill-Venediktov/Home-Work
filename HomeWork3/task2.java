package HomeWork3;

import java.util.Arrays;

public class task2 {
    public static void main(String[] args) {

        int[] arr = new int[50];

        int a = 1;

        for (int i = 0; i < arr.length; i++){
            arr[i] = a;
            a += 2;
        }
        System.out.println(Arrays.toString(arr));

        a = 99;
        for (int i = 0; i < arr.length; i++){
            arr[i] = a;
            a -= 2;
        }
        System.out.println(Arrays.toString(arr));
    }
}
