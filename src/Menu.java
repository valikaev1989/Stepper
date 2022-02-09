import java.util.Scanner;

public class Menu {
    CommandMenu commandMenu = new CommandMenu();
    Scanner scanner = new Scanner(System.in);
    private boolean printMenu = true;

    public void start() {
        System.out.println("Здравствуйте, выберите команду:");
        while (printMenu) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                commandMenu.pointInput();
            } else if (command == 2) {
                commandMenu.pointStatistics();
            } else if (command == 3) {
                commandMenu.pointPurpose();
            } else if (command == 4) {
                System.out.println("Программа завершена");
                printMenu = false;
            } else {
                System.out.println("Такой команды нет в программе, выберите от 1 до 4");
            }
        }
    }

    private void printMenu() {
        System.out.println(" 1 - Ввести количество шагов за определенный день");
        System.out.println(" 2 - Напечатать статистику за определенный месяц");
        System.out.println(" 3 - Изменить цель по количеству шагов в день");
        System.out.println(" 4 - Выйти из приложения");
    }
}