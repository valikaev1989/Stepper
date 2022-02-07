public class PrintStatistics {
    static Converter converter = new Converter(75, 50, 1000);

    public PrintStatistics() {
    }

    public static void printAllStatistics(int month) {
        System.out.println("Статистика за месяц №" + month + ":");
        printTotalNumberSteps(month);
        printMaxStepsInMonth(month);
        printAverageValueOfSteps(month);
        printCalBurned(month);
        printPathTraveled(month);
        printBestSeries(month);
    }

    public static void printTotalNumberSteps(int month) {
        StepTracker.MonthData monthData = StepTracker.monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            System.out.println((i + 1) + " день: " + monthData.dataAndSteps[i] + " шагов");
        }
    }

    public static void printMaxStepsInMonth(int month) {
        System.out.println("Ваш рекорд по шагам в этом месяце был: " + StepTracker.getMaxStepsInMonth(month));
    }

    public static void printAverageValueOfSteps(int month) {
        String cut = String.format("%.02f", StepTracker.getAverageValueOfSteps(month));
        System.out.println("Среднее количество шагов за месяц: " + cut);
    }

    public static void printCalBurned(int month) {
        String cut = String.format("%.02f", converter.getCalBurned(StepTracker.getSumStepsOfMonth(month)));
        System.out.println("За месяц вы сожгли: " + cut + " калорий");
    }

    public static void printPathTraveled(int month) {
        String cut = String.format("%.02f", converter.getPathTraveled(StepTracker.getSumStepsOfMonth(month)));
        System.out.println("За месяц вы прошли: " + cut + " километров");
    }

    public static void printBestSeries(int month) {
        int bestSeries = StepTracker.getBestSeries(month);
        if (bestSeries == 1) {
            System.out.println("Всего " + bestSeries + " раз Вы смогли достичь цели в этом месяце");
        } else if (bestSeries == 0) {
            System.out.println("В этом месяце Вы ни разу не достигли цели");
        } else if (bestSeries < 5) {
            System.out.println("Лучшая серия с достижением цели: " + bestSeries + " дня");
        } else {
            System.out.println("Лучшая серия с достижением цели: " + bestSeries + " дней");
        }
    }
}