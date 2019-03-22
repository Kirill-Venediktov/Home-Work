package control1;

import java.util.Scanner;

public class Pacient {
    private double[] HirList;
    private double[] TerapList;
    private double[] LorList;

    public Pacient() {
    }


    public double setHirList(double[] hirList) {
        System.out.println("Введите время приема: (с 8.00 до 20.00)");
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        if (x > 8 && x < 20){
            
        }
        } else {
            System.out.println("Введено некорректное время");
        }
        HirList = hirList;
    }

    public double setTerapList(String[] terapList) {
        System.out.println("Введите время приема: (с 8.00 до 20.00)");
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        if (x > 8 && x < 20){

        } else {
            System.out.println("Введено некорректное время");
        }

        TerapList = terapList;
    }

    public double setLorList(String[] lorList) {
        System.out.println("Введите время приема: (с 8.00 до 20.00)");
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        if (x > 8 && x < 20){

        } else {
            System.out.println("Введено некорректное время");

        LorList = lorList;
    }

    public static double[] getHirList() {
        return HirList;
    }

    public static double[] getTerapList() {
        return TerapList;
    }

    public static double[] getLorList() {
        return LorList;
    }
}
