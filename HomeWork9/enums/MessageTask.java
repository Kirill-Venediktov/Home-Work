package HomeWork7.enums;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого приоритела
        // Ответ в консоль

//
//        нинаю как(((
//        памагити((

//         как то через massageList.contains() ????
//        }
    }

    public static void countEachCode(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого кода сообщения
        // Ответ в консоль

    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // Подсчитать количество уникальных сообщений
        // Ответ в консоль
        Set<Message> messages = new HashSet<>(messageList);
        System.out.println("Колличество уникальных сообщений: " + messages.size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // вернуть только неповторяющиеся сообщения и в том порядке, в котором они
        // встретились в первоначальном списке
        // Например, было
//        [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        // на выходе:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        System.out.println(messageList);
        System.out.println();
        Set<Message> messages = new LinkedHashSet<>(messageList);
        messageList.clear();
        messageList.addAll(messages);
        System.out.println(messageList);

        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // удалить из коллекции каждое сообщение с заданным приоритетом
        // вывод до удалеия и после удаления
        List<Message> rm = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            rm.add(new Message(i, priority));
        }
        System.out.println(messageList);
        messageList.removeAll(rm);
        System.out.println(messageList);

    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        // вывод до удалеия и после удаления
        List<Message> rt = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            rt.add(new Message(i, priority));
        }
        System.out.println(messageList);
        messageList.retainAll(rt);
        System.out.println(messageList);

    }


}
