package HomeWork2;

public class task5 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        for (int i = 1; i < 7; i++) {
            System.out.println(a);
            System.out.println(b);
            a = a + b;
            b = a + b;
            }

        }
    }
