package HomeWork5.task2;

public class Multiplication implements Action {
    public Multiplication (double x, double y) {

    }

    @Override
    public double execute(double x, double y) {
        double mult = x * y;
        return mult;
    }
}
