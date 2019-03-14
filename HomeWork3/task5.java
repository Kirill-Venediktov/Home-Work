package HomeWork3;
import java.util.Scanner;
public class task5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите исходную строку: ");
        String a = in.nextLine();

        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите подстроку, которую нужно заменить: ");
        String b = in.nextLine();

        Scanner in3 = new Scanner(System.in);
        System.out.println("Введите подстроку, на которую нужно заменить: ");
        String c = in.nextLine();

        String s = a.replaceAll(b, c);


        System.out.println("Получилась строка: ");
        System.out.println(s);





    }
}
