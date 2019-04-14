package Fitness;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalTime;
import java.util.*;

public class FitnessRegistrator {
    //    ArrayList<Human> inGym = new ArrayList<>();
//    ArrayList<Human> inPool = new ArrayList<>();
//    ArrayList<Human> inGroup = new ArrayList<>();
    //либо
    private HashMap<String, HashSet<Human>> clients = new HashMap<>();

    public void add(Human human, FitnessServiceEnumeration type) throws IllegalAccessException, NoAccessException, QueueException, IOException {
        if (FitnessServiceEnumeration.GYM.equals(type)) {
            if (human.getClass().isAnnotationPresent(AccesMode.class)) {
                try {
                    Field field = human.getClass().getDeclaredField("gym");
                    field.setAccessible(true);
                    Access access = (Access) field.get(human);
                    if (LocalTime.now().getHour() > access.getFrom() && LocalTime.now().getHour() < access.getTo()) {
                        if (!clients.containsKey(type.toString())) {
                            clients.put(type.toString(), new HashSet<>());
                        }
                        if (clients.get(type.toString()).size() > 20) {
                            throw new QueueException("Занимается больше чем 20 клиентов");
                        } else {
                            if(human.getClass().getSimpleName().equals("Client")){
                                Field field1 = human.getClass().getDeclaredField("isVisited");
                                field1.setAccessible(true);
                                boolean vis = field1.getBoolean(human);
                                if(vis == false) {
                                    clients.get(type.toString()).add(human);
                                    FitnessLogger.PrintTofile(human, type);
                                    field1.setBoolean(human, true);
                                } else {
                                    throw new NoAccessException("Посетитель уже приходил");
                                }
                            } else{
                                clients.get(type.toString()).add(human);
                                FitnessLogger.PrintTofile(human, type);
                            }
                        }
                    } else {
                        throw new NoAccessException("Посетитель не может заниматься в данное время");
                    }
                } catch (NoSuchFieldException e) {
                    throw new NoAccessException("У посетителя нет доступа");
                }
            } else {
                throw new NoAccessException("У посетителя нет доступа");
            }
        } else if (FitnessServiceEnumeration.POOL.equals(type)) {
            if (human.getClass().isAnnotationPresent(AccesMode.class)) {
                try {
                    Field field = human.getClass().getDeclaredField("pool");
                    field.setAccessible(true);
                    Access access = (Access) field.get(human);
                    if (LocalTime.now().getHour() > access.getFrom() && LocalTime.now().getHour() < access.getTo()) {
                        if (!clients.containsKey(type.toString())) {
                            clients.put(type.toString(), new HashSet<>());
                        }
                        if (clients.get(type.toString()).size() > 20) {
                            throw new QueueException("Занимается больше чем 20 клиентов");
                        } else {
                            if(human.getClass().getSimpleName().equals("Client")){
                                Field field1 = human.getClass().getDeclaredField("isVisited");
                                field1.setAccessible(true);
                                boolean vis = field1.getBoolean(human);
                                if(vis == false) {
                                    clients.get(type.toString()).add(human);
                                    FitnessLogger.PrintTofile(human, type);
                                    field1.setBoolean(human, true);
                                } else {
                                    throw new NoAccessException("Посетитель уже приходил");
                                }
                            } else{
                                clients.get(type.toString()).add(human);
                                FitnessLogger.PrintTofile(human, type);
                            }
                        }
                    } else {
                        throw new NoAccessException("Посетитель не может заниматься в данное время");
                    }
                } catch (NoSuchFieldException e) {
                    throw new NoAccessException("У посетителя нет доступа");
                }
            } else {
                throw new NoAccessException("У посетителя нет доступа");
            }
        } else if (FitnessServiceEnumeration.GROUP.equals(type)) {
            if (human.getClass().isAnnotationPresent(AccesMode.class)) {
                try {
                    Field field = human.getClass().getDeclaredField("group");
                    field.setAccessible(true);
                    Access access = (Access) field.get(human);
                    if (LocalTime.now().getHour() > access.getFrom() && LocalTime.now().getHour() < access.getTo()) {
                        if (!clients.containsKey(type.toString())) {
                            clients.put(type.toString(), new HashSet<>());
                        }
                        if (clients.get(type.toString()).size() > 20) {
                            throw new QueueException("Занимается больше чем 20 клиентов");
                        } else {
                            if(human.getClass().getSimpleName().equals("Client")){
                                Field field1 = human.getClass().getDeclaredField("isVisited");
                                field1.setAccessible(true);
                                boolean vis = field1.getBoolean(human);
                                if(vis == false) {
                                    clients.get(type.toString()).add(human);
                                    FitnessLogger.PrintTofile(human, type);
                                    field1.setBoolean(human, true);
                                } else {
                                    throw new NoAccessException("Посетитель уже приходил");
                                }
                            } else{
                                clients.get(type.toString()).add(human);
                                FitnessLogger.PrintTofile(human, type);
                            }
                        }
                    } else {
                        throw new NoAccessException("Посетитель не может заниматься в данное время");
                    }
                } catch (NoSuchFieldException e) {
                    throw new NoAccessException("У посетителя нет доступа");
                }
            } else {
                throw new NoAccessException("У посетителя нет доступа");
            }
        } else {
            System.out.println("Неверно введено название занятий");
        }
    }

    public void delete(Human human) {
        HashSet<Human> gym = clients.get("GYM");
        HashSet<Human> pool = clients.get("POOL");
        HashSet<Human> group = clients.get("GROUP");
        if (gym.contains(human)) {
            gym.remove(human);
            System.out.println("Посетитель удален из записей в тренаженый зал");
        } else {
            System.out.println("Посетитель не был записан в тренажерный зал");
        }
        if (pool.contains(human)) {
            pool.remove(human);
            System.out.println("Посетитель удален из записей в бассейн");
        } else {
            System.out.println("Посетитель не был записан в бассейн");
        }
        if (group.contains(human)) {
            group.remove(human);
            System.out.println("Посетитель удален из записей на групповые занятия");
        } else {
            System.out.println("Посетитель не был записан на групповые занятия");
        }
    }

    public void ClientsOutput() throws IOException {
        ArrayList<Human> gym = new ArrayList<>(clients.get("GYM"));
        ArrayList<Human> pool = new ArrayList<>(clients.get("POOL"));
        ArrayList<Human> group = new ArrayList<>(clients.get("GROUP"));

        Comparator<Human> comparator = new SurnameComparator().thenComparing(new NameComparator());
        gym.sort(comparator);
        pool.sort(comparator);
        group.sort(comparator);

        StringBuilder strb = new StringBuilder();
        for (Human human : gym) {
            strb.delete(0,strb.length());
            strb.append(human.getSurname() + " " + human.getName() + " " + human.getClass().getSimpleName()
                    + " тренажерный зал");
            System.out.println(strb);
        }
        for (Human human : pool) {
            strb.delete(0,strb.length());
            strb.append(human.getSurname() + " " + human.getName() + " " + human.getClass().getSimpleName()
                    + " тренажерный зал");
            System.out.println(strb);
        }
        for (Human human : group) {
            strb.delete(0,strb.length());
            strb.append(human.getSurname() + " " + human.getName() + " " + human.getClass().getSimpleName()
                    + " тренажерный зал");
            System.out.println(strb);
        }
    }
}

class SurnameComparator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}

class NameComparator implements  Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}



