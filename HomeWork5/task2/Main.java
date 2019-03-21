package HomeWork5.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число x: ");
        double x = in.nextDouble();
        System.out.println("Введите число y: ");
        double y = in.nextDouble();
        System.out.println("Введите знак действия (+, -, *, /): ");
        String sign = scan.nextLine();

        while (y == 0 && sign.equals("/")){
            System.out.println("Введите число y: (при делении оно не должно равняться нулю!) ");
            y = in.nextDouble();
            }
        if (sign.equals("+")) {
            Addition add = new Addition(x, y);
            System.out.println("Cумма:" + add.execute(x, y));
        } else if (sign.equals("-")) {
            Substraction sub = new Substraction(x, y);
            System.out.println("Разность: " + sub.execute(x, y));
        } else if (sign.equals("*")) {
            Multiplication mult = new Multiplication(x, y);
            System.out.println("Произведение: " + mult.execute(x, y));
            } else if (sign.equals("/")){
            Division div = new Division(x, y);
            System.out.println("Результат деления: " + div.execute(x, y));
        } else {
            System.out.println("Введен неккоректный знак");
        }

    }
}
