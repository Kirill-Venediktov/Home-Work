package HomeWork2;

public class task6 {
    public static void main(String[] args) {

        int count = 0;

        for (int i = 1; i < 1000000; i++) {
            int right = (i / 100) % 10 + (i / 10) % 10 + i  % 10;
            int left = (i / 100000) % 10 + (i / 10000) % 10 + (i / 1000) % 10;

            if (left == right ) {
                count++;
            }
        }

        System.out.println("Число счастливых билетов: " + count);

    }
}
