package HomeWork5.task2;

public class Substraction implements Action {
    public Substraction(double x, double y) {
    }

    @Override
    public double execute(double x, double y) {
        double dif = x - y;
        return dif;
    }
}
