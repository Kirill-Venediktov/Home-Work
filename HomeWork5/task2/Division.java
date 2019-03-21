package HomeWork5.task2;

public class Division implements Action {
    public Division (double x, double y) {

    }

    @Override
    public double execute (double x, double y) {
        if (y != 0) {
            double div = x / y;
            return div;
        } else {
            System.out.println("Деление на ноль!");
            return 0;
        }
    }
}
