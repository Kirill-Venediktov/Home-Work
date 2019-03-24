package control1;

public class Terapeft {
    public static void getTerapList(String[] terapList){
        for (int i = 0; i < terapList.length; i++) {
            if (terapList[i] == null){
                System.out.println("Конец списка");
                break;
            }
            System.out.println(terapList[i]);
        }
    }
}
