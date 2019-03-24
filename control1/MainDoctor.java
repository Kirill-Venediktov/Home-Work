package control1;

public class MainDoctor {

    public static void GetPacientList (String[] pacientList){
            for (int i = 0; i < pacientList.length; i++) {
                if (pacientList[i] == null) {
                    System.out.println("Конец списка");
                    break;
                }
                System.out.println(pacientList[i]);

            }
        }
    }