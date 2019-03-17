package HomeWork4.com.companyName.task3;

public class dog {

    private String name;
    private int weight;
    private int age;
    private String color;
    private String adress;


    public dog (String name) {
        this.name = name;
        weight = 10;
        adress = "Бездомный";

    }

    public dog (String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        adress = "Бездомный";
    }

    public dog (String name, int age) {
        this.name = name;
        this.age = age;
        weight = 10;
        adress = "Бездомный";
    }

    public dog (int weight, String color) {
        this.weight = weight;
        this.color = color;
        name = "Дружок";
        adress = "Бездомный";

    }

    public dog (int weight, String color, String adress) {
        this.weight = weight;
        this.color = color;
        this.adress = adress;
        name = "Дружок";

    }

    public void info() {
        System.out.println("имя: " + name + " вес: " + weight + " возраст: " + age + " цвет: " + color + " адрес: " + adress);
    }


}
