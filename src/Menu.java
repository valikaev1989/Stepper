import java.util.Scanner;

public class Menu {
    static int month;
    static int data;
    static int steps;
    static int newPurpose;
    static StepTracker steptracker = new StepTracker();
    static Scanner scanner = new Scanner(System.in);
    static boolean printMenu = true;
    public Menu() {
    }
    static void start() {
        System.out.println("Здравствуйте, выберите команду:");
        while (printMenu) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                pointInput();
            }else if (command ==2) {
                pointStatistics();
            }else if (command == 3) {
                pointPurpose();
            }else if (command == 4) {
                System.out.println("Программа завершена");
                break;
            }
        }
    }

    private static void pointPurpose() {
        System.out.println("Какая новая цель?");
        newPurpose = scanner.nextInt();
        steptracker.newPurposeForSteps(newPurpose);
    }

    private static void pointStatistics() {
        System.out.println("Какой месяц выберите?");
        month = scanner.nextInt();
        steptracker.printAllStatistics(month);
    }

    private static void pointInput() {
        System.out.println("Какой месяц?");
        month = scanner.nextInt();
        if (month > 12 || month < 1){
            System.out.println("Вы ошиблись, такого месяца нет в календаре");
            return;
        }
        System.out.println("Какой день?");
        data = scanner.nextInt();
        if (data > 30 || data < 1){
            System.out.println("Вы ошиблись, такой день отсутствует в месяце");
            return;
        }
        System.out.println("Сколько шагов Вы прошли в этот день?");
        steps = scanner.nextInt();
        steptracker.newStepsForDay(month, data, steps);
    }

    private static void printMenu () {
        System.out.println(" 1 - Ввести количество шагов за определенный день");
        System.out.println(" 2  - Напечатать статистику за определенный месяц");
        System.out.println(" 3 - Изменить цель по количеству шагов в день");
        System.out.println(" 4 - Выйти из приложения");
        }
}






