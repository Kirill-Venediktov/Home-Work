package control1;

import java.util.Arrays;
import java.util.Scanner;

public class Admin {
    public static String[] setPacientList (String[] pacientList){
        int temp;
        int count1 = 0;
        do {
            int count2 = 0;
            StringBuilder pacient = new StringBuilder();
            Scanner in = new Scanner(System.in);
            System.out.println("Введите фамилию пациента");
            pacient.append(in.nextLine() + " ");
            System.out.println("Введите имя пациента");
            pacient.append(in.nextLine() + " ");
            System.out.println("Введите отчество пациента");
            pacient.append(in.nextLine() + " ");
            System.out.println("Введите логин пациента");
            pacient.append("login: " + in.nextLine());
            for (int i = 0; i < pacientList.length; i++) {
                if (pacient.toString().equals(pacientList[i])) {
                    System.out.println("Пользователь уже существует!");
                    count2++;
                    break;
                }
            }
            if (count2 == 0) {
                for (int i = 0; i < pacientList.length; i++) {
                    if (pacientList[i] == null) {
                        pacientList[i] = pacient.toString();
                        count1++;
                        break;
                    }
                }
            }
        } while (count1 == 0);
        System.out.println("Пользователь успешно добавлен");
        return pacientList;
    }
}
