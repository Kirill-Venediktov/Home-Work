package HomeWork4.com.companyName.task4;

public class cat {
    private String name;
    private int age;
    private int weight;
    private int strength;

    public cat() {

    }

    public cat(String name, int age, int weight, int strength) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public boolean fight (cat anotherCat) {
        boolean res;
        if (this.strength > anotherCat.strength && this.weight > anotherCat.weight) {
            res = true;
        }
        else if (this.age > anotherCat.age && this.strength > anotherCat.strength) {
            res = true;
        }
        else {
            res = false;
        }
        return res;
    }
}
