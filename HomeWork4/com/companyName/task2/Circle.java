package HomeWork4.com.companyName.task2;

public class Circle {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        if (radius < 0) {
            System.out.println("Радиус должен быть положительным");
            return;
        }
    }

    public Circle(){
    }

    public void setRadius(double radius) {
        this.radius = radius;
        if (radius < 0) {
            System.out.println("Радиус должен быть положительным");
            return;
        }
    }

    public double getRadius() {
        return radius;
    }

    public double circleArea(double radius) {
        double area = 0;
        if (radius < 0) {
            System.out.println("Радиус должен быть положительным");
        }
        else {
            area = radius * radius * 3.14;
             }
        return area;
                }

        public double circleArea () {
            double area = 0;
            area = radius * radius * 3.14;
            return area;
        }

        public double  circumferense (int radius) {
            double cf = 0;
            if (radius < 0) {
                System.out.println("Радиус должен быть положительным");
            }
            else {
                cf = radius * 2 * 3.14;
            }
            return cf;
        }
        public double  circumferense () {
            double cf = radius * 2 * 3.14;
            return cf;
        }
}
