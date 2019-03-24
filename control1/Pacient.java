package control1;

import java.util.Scanner;

public class Pacient {

    private static  Scanner in = new Scanner(System.in);
    private static StringBuilder date = new StringBuilder();
    private static String hirDate;
    private static String terapDate;
    private static String lorDate;

    public static String[] setHirList(String[] hirList) {
        if(hirDate == null) {
            int temp;
            int count1 = 0;
            do {
                int count2 = 0;
                do {
                    System.out.println("Введите год приема(2019-2021) :");
                    temp = in.nextInt();
                } while (temp > 2021 || temp < 2019);
                date.append(temp + ".");
                do {
                    System.out.println("Введите месяц приема(01-12) :");
                    temp = in.nextInt();
                } while (temp > 12 || temp < 1);
                date.append(temp + ".");
                do {
                    System.out.println("Введите день приема (1-31):");
                    temp = in.nextInt();
                } while (temp > 31 || temp < 1);
                date.append(temp + " ");
                do {
                    System.out.println("Введите час приема(с 8.00 до 20.00):");
                    temp = in.nextInt();
                } while (temp > 20 || temp < 8);
                date.append(temp + ":");
                do {
                    System.out.println("Введите минуты часа приема(с 00, 20 или 40):");
                    temp = in.nextInt();
                } while (temp != 0 & temp != 20 & temp != 40);
                date.append(temp);
                for (int i = 0; i < hirList.length; i++) {
                    if (date.toString().equals(hirList[i])) {
                        System.out.println("Это время уже занято!");
                        count2++;
                        break;
                    }
                } if (count2 == 0) {
                    for (int i = 0; i < hirList.length; i++) {
                        if (hirList[i] == null) {
                            hirList[i] = date.toString();
                            hirDate = date.toString();
                            count1++;
                            break;
                        }
                    }
                }
            } while (count1 == 0);
            System.out.println("Запись к хирургу успешно завершена");
        } else {
            System.out.println("Вы уже записались к этому врачу");
            System.out.println("Вы записаны на: " + hirDate);
        }

        return hirList;
    }

    public static String[] setTerapList(String[] terapList) {
        if (terapDate == null) {
            int temp;
            int count1 = 0;
            StringBuilder date = new StringBuilder();
            Scanner in = new Scanner(System.in);
            do {
                int count2 = 0;
                do {
                    System.out.println("Введите год приема(2019-2021) :");
                    temp = in.nextInt();
                } while (temp > 2021 || temp < 2019);
                date.append(temp + ".");
                do {
                    System.out.println("Введите месяц приема(01-12) :");
                    temp = in.nextInt();
                } while (temp > 12 || temp < 1);
                date.append(temp + ".");
                do {
                    System.out.println("Введите день приема (1-31):");
                    temp = in.nextInt();
                } while (temp > 31 || temp < 1);
                date.append(temp + " ");
                do {
                    System.out.println("Введите час приема(с 8.00 до 20.00):");
                    temp = in.nextInt();
                } while (temp > 20 || temp < 8);
                date.append(temp + ":");
                do {
                    System.out.println("Введите минуты часа приема(с 00, 20 или 40):");
                    temp = in.nextInt();
                } while (temp != 0 & temp != 20 & temp != 40);
                date.append(temp);
                for (int i = 0; i < terapList.length; i++) {
                    if (date.toString().equals(terapList[i])) {
                        System.out.println("Это время уже занято!");
                        count2++;
                        break;
                    }
                } if (count2 == 0) {
                    for (int i = 0; i < terapList.length; i++) {
                        if (terapList[i] == null) {
                            terapList[i] = date.toString();
                            terapDate = date.toString();
                            count1++;
                            break;
                        }
                    }
                }
            } while (count1 == 0);
            System.out.println("Запись к терапевту успешно завершена");
        } else {
            System.out.println("Вы уже записались к этому врачу");
            System.out.println("Вы записаны на: " + terapDate);
        }

        return terapList;
    }

    public static String[] setLorList(String[] lorList) {
        if (lorDate == null) {
            int temp;
            int count1 = 0;
            StringBuilder date = new StringBuilder();
            Scanner in = new Scanner(System.in);
            do {
                int count2 = 0;
                do {
                    System.out.println("Введите год приема(2019-2021) :");
                    temp = in.nextInt();
                } while (temp > 2021 || temp < 2019);
                date.append(temp + ".");
                do {
                    System.out.println("Введите месяц приема(01-12) :");
                    temp = in.nextInt();
                } while (temp > 12 || temp < 1);
                date.append(temp + ".");
                do {
                    System.out.println("Введите день приема (1-31):");
                    temp = in.nextInt();
                } while (temp > 31 || temp < 1);
                date.append(temp + " ");
                do {
                    System.out.println("Введите час приема(с 8.00 до 20.00):");
                    temp = in.nextInt();
                } while (temp > 20 || temp < 8);
                date.append(temp + ":");
                do {
                    System.out.println("Введите минуты часа приема(с 00, 20 или 40):");
                    temp = in.nextInt();
                } while (temp != 0 & temp != 20 & temp != 40);
                date.append(temp);
                for (int i = 0; i < lorList.length; i++) {
                    if (date.toString().equals(lorList[i])) {
                        System.out.println("Это время уже занято!");
                        count2++;
                        break;
                    }
                } if (count2 == 0){
                    for (int i = 0; i < lorList.length; i++) {
                        if (lorList[i] == null) {
                            lorList[i] = date.toString();
                            lorDate = date.toString();
                            count1++;
                            break;
                        }
                    }
                }
            } while (count1 == 0);
            System.out.println("Запись к ЛОРУ успешно завершена");
        } else {
            System.out.println("Вы уже записались к этому врачу");
            System.out.println("Вы записаны на: " + lorDate);
        }

        return lorList;
    }
}
