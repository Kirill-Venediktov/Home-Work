package control1;

public class LOR {
    public static void getLorList(String[] lorList){
        for (int i = 0; i < lorList.length; i++) {
            if (lorList[i] == null){
                System.out.println("Конец списка");
                break;
            }
            System.out.println(lorList[i]);
        }
    }
}

