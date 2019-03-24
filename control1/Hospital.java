package control1;

import java.util.Scanner;

public class Hospital {

    public static void open() {
        String[] hirList = new String[100];
        String[] terapList = new String[100];
        String[] lorList = new String[100];
        String[] pacientList = new String[100];
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        int count1 = 0;
        do {
            System.out.println("Введите логин: ");
            String sign = in.nextLine();
            if (sign.equals("MainDoctorLogin")) {
                int count2 = 0;
                System.out.println("Добрый день, Главный врач!");
                do {
                    System.out.println("Введите команду для продолжения работы: ");
                    sign = in.nextLine();
                    if (sign.equals("Список")) {
                        MainDoctor.GetPacientList(pacientList);
                    } else if (sign.equals("Хирург")) {
                        Hirurg.getHirList(hirList);
                    } else if (sign.equals("Терапевт")) {
                        Terapeft.getTerapList(terapList);
                    } else if (sign.equals("Лор")) {
                        LOR.getLorList(lorList);
                    } else if (sign.equals("exit")) {
                        count2++;
                    } else {
                        System.out.println("Введена неизвестная команда");
                    }
                } while (count2 == 0);
            } else if (sign.equals("HirurgLogin")) {
                int count2 = 0;
                System.out.println("Добрый день, Хирург!");
                do {
                    System.out.println("Введите команду для продолжения работы: ");
                    sign = in.nextLine();
                    if (sign.equals("Запись")) {
                        Hirurg.getHirList(hirList);
                    } else if (sign.equals("exit")) {
                        count2++;
                    } else {
                        System.out.println("Введена неизвестная команда");
                    }
                } while (count2 == 0);
            } else if (sign.equals("TerapeftLogin")) {
                int count2 = 0;
                System.out.println("Добрый день, Терапевт!");
                do {
                    System.out.println("Введите команду для продолжения работы: ");
                    sign = in.nextLine();
                    if (sign.equals("Запись")) {
                        Terapeft.getTerapList(terapList);
                    } else if (sign.equals("exit")) {
                        count2++;
                    } else {
                        System.out.println("Введена неизвестная команда");
                    }
                } while (count2 == 0);
            } else if (sign.equals("LorLogin")) {
                int count2 = 0;
                System.out.println("Добрый день, Лор!");
                do {
                    System.out.println("Введите команду для продолжения работы: ");
                    sign = in.nextLine();
                    if (sign.equals("Запись")) {
                        LOR.getLorList(lorList);
                    } else if (sign.equals("exit")) {
                        count2++;
                    } else {
                        System.out.println("Введена неизвестная команда");
                    }
                } while (count2 == 0);
            } else if (sign.equals("PacientLogin")) {
                int count2 = 0;
                System.out.println("Добрый день, Иван Иванович!");
                do {
                    System.out.println("Выберите врача для записи: ");
                    sign = in.nextLine();
                    if (sign.equals("Хирург")) {
                        Pacient.setHirList(hirList);
                    } else if (sign.equals("Терапевт")) {
                        Pacient.setTerapList(terapList);
                    } else if (sign.equals("ЛОР")) {
                        Pacient.setLorList(lorList);
                    } else if (sign.equals("exit")) {
                        count2++;
                    } else {
                        System.out.println("Введена неизвестная команда");
                    }
                } while (count2 == 0);
            } else if (sign.equals("AdminLogin")) {
                int count2 = 0;
                System.out.println("Добрый день, админ!");
                do {
                    System.out.println("Введите команду для продолжения работы: ");
                    sign = in.nextLine();
                    if (sign.equals("Регистрация")) {
                        Admin.setPacientList(pacientList);
                    } else if (sign.equals("Хирург")) {
                        Pacient.setHirList(hirList);
                    } else if (sign.equals("Терапевт")) {
                        Pacient.setTerapList(terapList);
                    } else if (sign.equals("ЛОР")) {
                        Pacient.setLorList(lorList);
                    } else if (sign.equals("exit")) {
                        count2++;
                    } else {
                        System.out.println("Введена неизвестная команда");
                    }
                } while (count2 == 0);
            } else if (sign.equals("exit")) {
                count1++;
            } else {
                System.out.println("Неизвестный логин!");
                System.out.println("Хотите зарегестрироваться? (1 -да, 0 - нет)");
                int x = in2.nextInt();
                if (x == 1) {
                    Admin.setPacientList(pacientList);
                }
            }
        } while (count1 == 0);
    }
}

