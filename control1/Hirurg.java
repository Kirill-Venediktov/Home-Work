package control1;

import java.util.Arrays;

public class Hirurg {
    public static void getHirList(String[] hirList){
        for (int i = 0; i < hirList.length; i++) {
            if (hirList[i] == null){
                System.out.println("Конец списка");
                break;
            }
            System.out.println(hirList[i]);
        }
    }
}
