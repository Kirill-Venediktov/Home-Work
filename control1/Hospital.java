package control1;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String sign = in.nextLine();
        if (sign.equals("MainDoctorPassword")) {
            System.out.println("Добрый день, Главный врач!");
            System.out.println("Введите команду для продолжения работы: ");
            sign = in.nextLine();
            if (sign.equals("Список")) {
                // вывод списка
            } else if (sign.equals("Хирург")){
                // список к хирургу
            } else if (sign.equals("Терапевт")) {
                // список к терапевту
            } else if (sign.equals("Лор")) {
                //список к лору
            }else {
                System.out.println("Введена неккоректная команда");
            }
        } else if (sign.equals("HirurgPassword")){
            System.out.println("Добрый день, Хирург!");
            System.out.println("Введите команду для продолжения работы: ");
            sign = in.nextLine();
            if (sign.equals("Запись")) {
                Pacient.getHirList;
            } else {
                System.out.println("Введена неккоректная команда");
            }
        } else if (sign.equals("TerapeftPassword")) {
            System.out.println("Добрый день, Терапевт!");
            System.out.println("Введите команду для продолжения работы: ");
            sign = in.nextLine();
            if (sign.equals("Запись")) {
                //список к терапевту
            } else {
                System.out.println("Введена неккоректная команда");
            }
        }
            else if (sign.equals("LorPassword")) {
                System.out.println("Добрый день, Лор!");
                System.out.println("Введите команду для продолжения работы: ");
                sign = in.nextLine();
                if (sign.equals("Запись")) {
                    //список к терапевту
            }   else {
                    System.out.println("Введена неккоректная команда");
            }
        } else if (sign.equals("PacientPassword")) {
                Pacient pac1 = new Pacient();
            System.out.println("Добрый день, Иван Иванович!");
            do { System.out.println("Выберите врача для записи: ");
            sign = in.nextLine();
            if (sign.equals("Хирург")){
                pac1.setHirList();
            } else if (sign.equals("Терапевт")) {
                pac1.setTerapList();
            } else if (sign.equals("ЛОР")){
                pac1.setLorList();
            }} while (!sign.equals("Хирург") || sign.equals("Терапевт") || sign.equals("ЛОР"));

            } else {
                System.out.println("Неизвестный пользователь");
                System.out.println("Введите пароль для регистрации: ");
                sign = in.nextLine();


        }

    }
}
