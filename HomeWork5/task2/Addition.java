package HomeWork5.task2;

public class Addition implements Action {
    public Addition(double x, double y) {
    }

    @Override
    public double  execute(double x, double y) {
        double sum = x + y;
        return sum;
    }
}
