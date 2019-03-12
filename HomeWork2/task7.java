package HomeWork2;

public class task7 {
    public static void main(String[] args) {
        int count = 0;
        for (int a = 1; a < 24; a++) {
            for (int b = 1; b < 60; b++) {
                if((a / 10) % 10 == b % 10 && (b / 10) % 10 == a % 10 ) {
                    count++;
                }
            }
        }
        System.out.println("Колличество симметричных комбинаций: " + count);
    }
}
