package HomeWork4.com.companyName.task2;

public class main {
    public static void main(String[] args) {

        Circle circle1 = new Circle();
        Rectangle rec1 = new Rectangle();
        Traingle traingle1 = new Traingle(1, 2, 2, 4, 4, 4);

        rec1.setRx1(1);
        rec1.setRx2(2);
        rec1.setRx3(4);
        rec1.setRy1(1);
        rec1.setRy2(2);
        rec1.setRy3(4);

        System.out.println("Длина окружности: " + circle1.circumferense(5));
        System.out.println("Площадь круга: " + circle1.circleArea(5));
        System.out.println("Периметр прямоугольника: " + rec1.rectPerim());
        System.out.println("Площадь прямоугольника: " + rec1.rectArea());
        System.out.println("Периметр треугольника: " + traingle1.trainglePerim());
        System.out.println("Площадь треугольника: " + traingle1.traingleArea());

    }

}
