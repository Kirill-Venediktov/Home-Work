package HomeWork4.com.companyName.task4;

public class main {
    public static void main(String[] args) {

        cat cat = new cat("Барсик", 5, 6, 9);
        cat cat1 = new cat("Рыжик", 4, 5, 8);
        boolean f = cat.fight(cat1);

        if (f == true) {
            System.out.println("Барсик победил");
        }
        else {
            System.out.println("Барсик проиграл");
        }
    }
}
