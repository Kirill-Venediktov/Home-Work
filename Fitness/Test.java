package Fitness;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Test {
    public static void main(String[] args) {

        Client client = new Client("Иванов", "Сергей", 1992);
        DayClient dayClient1 = new DayClient("Петров", "Александр", 1990, "2018-12-12", 6);
        DayClient dayClient2 = new DayClient("Сидоров", "Иван", 1994, "2019-04-01", 9);
        DayClient dayClient3 = new DayClient("Сергеев", "Алексей", 1991);
        FullDayClient fullDayClient = new FullDayClient("Андреев", "Геннадий", 1989);

        FitnessRegistrator registrator = new FitnessRegistrator();

        try {
            registrator.add(client, FitnessServiceEnumeration.GYM);
        } catch (IllegalAccessException | NoAccessException | QueueException | IOException e) {
            e.printStackTrace();
        }

        try {
            registrator.add(dayClient1, FitnessServiceEnumeration.GYM);
        } catch (IllegalAccessException | NoAccessException | QueueException | IOException e) {
            e.printStackTrace();
        }

        try {
            registrator.add(dayClient2, FitnessServiceEnumeration.GROUP);
        } catch (IllegalAccessException | NoAccessException | QueueException | IOException e) {
            e.printStackTrace();
        }

        try {
            registrator.add(dayClient3, FitnessServiceEnumeration.GYM);
        } catch (IllegalAccessException | NoAccessException | QueueException | IOException e) {
            e.printStackTrace();
        }

        try {
            registrator.add(fullDayClient, FitnessServiceEnumeration.POOL);
        } catch (IllegalAccessException | NoAccessException | QueueException | IOException e) {
            e.printStackTrace();
        }

        try {
            registrator.ClientsOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }

        registrator.delete(client);

        try {
            registrator.ClientsOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

