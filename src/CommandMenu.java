import java.util.Scanner;

public class CommandMenu {
    private int month;
    StepTracker stepTracker = new StepTracker();
    PrintStatistics printStatistics = new PrintStatistics();
    Scanner scanner = new Scanner(System.in);

    public CommandMenu() {
    }

    public void pointInput() {
        System.out.println("Какой месяц?");
        month = scanner.nextInt();
        if (!stepTracker.checkMonth(month)) {
            System.out.println("Вы ошиблись, такого месяца нет в календаре");
            return;
        }
        System.out.println("Какой день?");
        int data = scanner.nextInt();
        if (data > 30 || data < 1) {
            System.out.println("Вы ошиблись, такой день отсутствует в месяце");
            return;
        }
        System.out.println("Сколько шагов Вы прошли в этот день?");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Введены некорректные данные. Попробуйте снова");
        } else {
            int newSteps = stepTracker.getNewStepsForDay(month, data, steps);
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

    public void pointStatistics() {
        System.out.println("Какой месяц выберите?");
        month = scanner.nextInt();
        if (stepTracker.checkMonth(month)) {
            printStatistics.printAllStatistics(month);
        } else {
            System.out.println("Вы ошиблись, такого месяца нет в календаре");
        }
    }

    public void pointPurpose() {
        System.out.println("Какая новая цель?");
        int newPurpose = scanner.nextInt();
        if (newPurpose <= 0) {
            System.out.println("Вы ввели некорректные данные, попробуйте еще раз");
            System.out.println("Текущая цель осталась неизменна: " + stepTracker.setOldPurposeForSteps() + " шагов"
                    + " в день");
        } else {
            System.out.println("Предыдущая цель была: " + stepTracker.setOldPurposeForSteps() + " шагов в день");
            stepTracker.setNewPurposeForSteps(newPurpose);
            System.out.println("Новая цель: " + stepTracker.setNewPurposeForSteps(newPurpose) + " шагов в день");
        }
    }
}