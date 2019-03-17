package HomeWork4.com.companyName.task3;

public class main {
    public static void main(String[] args) {

        dog dog1 = new dog("Шарик");
        dog dog2 = new dog("Бобик", 15,5);
        dog dog3 = new dog("Рекс", 7);
        dog dog4 = new dog(8, "Черный");
        dog dog5 = new dog(9, "Белый", "Невский проспект");

        dog1.info();
        dog2.info();
        dog3.info();
        dog4.info();
        dog5.info();
    }
}
