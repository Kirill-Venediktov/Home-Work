package HomeWork7.solarSys;

import java.util.Scanner;

public enum Planet {
    MERCURY(100, 20, 100), VENUS(150,25,150), EARTH(150, 25, 200), MARS(120, 23, 250),
    JUPITER(1000,300,500), SATURN(500,150, 600), URANUS(400, 120,700), NEPTUNE(200, 75, 800);

    private int mass;
    private int radius;
    private int orbitRadius;

    Planet(int mass, int radius, int orbitRadius) {
        this.mass = mass;
        this.radius = radius;
        this.orbitRadius = orbitRadius;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "mass=" + mass +
                ", radius=" + radius +
                ", orbitRadius=" + orbitRadius +
                '}';
    }

}
class SunSys {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название интересующей планеты: ");
        String pl = in.nextLine();
        switch (pl) {
            case "Меркурий":
                System.out.println(Planet.MERCURY);
                break;
            case "Венера":
                System.out.println(Planet.VENUS);
                break;
            case "Земля":
                System.out.println(Planet.EARTH);
                break;
            case "Марс":
                System.out.println(Planet.MARS);
                break;
            case "Юпитер":
                System.out.println(Planet.JUPITER);
                break;
            case "Сатурн":
                System.out.println(Planet.SATURN);
                break;
            case "Уран":
                System.out.println(Planet.URANUS);
                break;
            case "Нептун":
                System.out.println(Planet.NEPTUNE);
                break;
            default:
                System.out.println("Неверное название");
                break;
        }
    }
}

