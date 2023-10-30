import java.util.Scanner;

public class Main {

    public  static  void printResult(String gamer, int result){
        System.out.println("Остаток палочек: " + result);
        if (result == 1) System.out.println("Победил игрок " + gamer);
    }
    public static int stepComp(int result){
        int max=3;
        if(result > 5){
            while ((result-max)<5) max-=1;
        }
        if(result<5){
            max = 1;
            while ((result-max)!=1) max+=1;
        }

        return max;
    }
    public static void startGame(int var){
        int result  = 15;
        int gamer = 1;
        while (result > 1){
            Scanner scanner = new Scanner(System.in);
            int i;
            //-----
            if(gamer != 3) {
                System.out.println("Игрок" + gamer + ":");
                try {
                    i = scanner.nextInt();
                    if ((i > 0 && i < 4 && result > i)) {
                        result -= i;
                        printResult("Игрок "+var, result);
                        if (gamer == 1) {
                            gamer += var;
                        } else gamer -= var;
                    } else {
                        System.out.println("Вы ввели некорректное число! Попробуйте еще раз");
                    }

                } catch (Exception ex) {
                    System.out.println("Вы ввели некорректное значение! Попробуйте еще раз" + ex.getMessage());
                }
            }else{
                System.out.println("Компьютер:" + stepComp(result));
                printResult("Компьютер", (result -= stepComp((result))) );
                 if (gamer == 1) {
                    gamer += var;
                } else gamer -= var;
            }
        };

    }
    public static void main(String[] args) {

        System.out.println("\t\tДобро пожаловать в игру 15-ки!\n\tНеобходимо вводить числа от 1 до 3, \n" +
                "\tПроигрывает тот кто введет число последним.\n");
        while (true) {
            System.out.println("\t1 - Игрок<>Игрок\t 2 - Игрок<>Компьютер\t 3 - Выход");
            Scanner scanner = new Scanner(System.in);
            System.out.print("\t\tВыберите вариант игры: ");
                try {
                    int var = scanner.nextInt();
                    if(var == 3) break;
                    else  if (var == 1 || var == 2) startGame(var);
                } catch (Exception ex) {
                    System.out.println("Вы выбрали некорректный вариант!");
                }
        }
    }
}