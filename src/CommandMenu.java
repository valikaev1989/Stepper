import java.util.Scanner;

public class CommandMenu {
    static int month;
    static int data;
    static int steps;
    static int newPurpose;
    static StepTracker steptracker = new StepTracker();
    static Scanner scanner = new Scanner(System.in);


    public CommandMenu() {
    }

    public static void pointInput() {
        System.out.println("Какой месяц?");
        month = scanner.nextInt();
        if (!StepTracker.monthToData.containsKey(month)) {
            System.out.println("Вы ошиблись, такого месяца нет в календаре");
            return;
        }
        System.out.println("Какой день?");
        data = scanner.nextInt();
        if (data > 30 || data < 1) {
            System.out.println("Вы ошиблись, такой день отсутствует в месяце");
            return;
        }
        System.out.println("Сколько шагов Вы прошли в этот день?");
        steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Введены некорректные данные. Попробуйте снова");
        } else {
            int newSteps = StepTracker.getNewStepsForDay(month, data, steps);
            if (newSteps == 1) {
                System.out.println("Новые данные по шагам занесены в систему. В этот месяц: " + month + ", в этот день: "
                        + data + ", вы совершили: " + newSteps + " шаг.");
            } else if (newSteps < 5) {
                System.out.println("Новые данные по шагам занесены в систему. В этот месяц: " + month + ", в этот день: "
                        + data + ", вы совершили: " + newSteps + " шага.");
            } else {
                System.out.println("Новые данные по шагам занесены в систему. В этот месяц: " + month + ", в этот день: "
                        + data + ", вы совершили: " + newSteps + " шагов.");
            }
        }
    }

    public static void pointStatistics() {
        System.out.println("Какой месяц выберите?");
        month = scanner.nextInt();
        if (StepTracker.monthToData.containsKey(month)) {
            PrintStatistics.printAllStatistics(month);
        } else {
            System.out.println("Вы ошиблись, такого месяца нет в календаре");
        }
    }

    public static void pointPurpose() {
        System.out.println("Какая новая цель?");
        newPurpose = scanner.nextInt();
        if (newPurpose <= 0) {
            System.out.println("Вы ввели некорректные данные, попробуйте еще раз");
            System.out.println("Текущая цель осталась неизменна: " + StepTracker.PurposeForSteps + " шагов" + " в день");
        } else {
            System.out.println("Предыдущая цель была: " + StepTracker.PurposeForSteps + " шагов в день");
            steptracker.setNewPurposeForSteps(newPurpose);
            System.out.println("Новая цель: " + StepTracker.PurposeForSteps + " шагов в день");
        }
    }
}
