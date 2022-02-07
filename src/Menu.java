import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static boolean printMenu = true;

    static void start() {
        System.out.println("Здравствуйте, выберите команду:");
        while (printMenu) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                CommandMenu.pointInput();
            } else if (command == 2) {
                CommandMenu.pointStatistics();
            } else if (command == 3) {
                CommandMenu.pointPurpose();
            } else if (command == 4) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Такой команды нет в программе, выберите от 1 до 4");
            }
        }
    }

    private static void printMenu() {
        System.out.println(" 1 - Ввести количество шагов за определенный день");
        System.out.println(" 2 - Напечатать статистику за определенный месяц");
        System.out.println(" 3 - Изменить цель по количеству шагов в день");
        System.out.println(" 4 - Выйти из приложения");
    }
}






