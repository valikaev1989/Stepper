public class PrintStatistics {
    Converter converter = new Converter(75, 50, 1000);
    StepTracker stepTracker = new StepTracker();

    public PrintStatistics() {
    }

    public void printAllStatistics(int month) {
        System.out.println("Статистика за месяц №" + month + ":");
        printTotalNumberSteps(month);
        printMaxStepsInMonth(month);
        printAverageValueOfSteps(month);
        printCalBurned(month);
        printPathTraveled(month);
        printBestSeries(month);
    }

    private void printTotalNumberSteps(int month) {
        for (int i = 0; i < stepTracker.getTotalNumberSteps(month).length; i++) {
            System.out.println((i + 1) + " день: " + stepTracker.getTotalNumberSteps(month)[i] + " шагов");
        }
    }

    private void printMaxStepsInMonth(int month) {
        System.out.println("Ваш рекорд по шагам в этом месяце был: " + stepTracker.getMaxStepsInMonth(month));
    }

    private void printAverageValueOfSteps(int month) {
        String cut = String.format("%.02f", stepTracker.getAverageValueOfSteps(month));
        System.out.println("Среднее количество шагов за месяц: " + cut);
    }

    private void printCalBurned(int month) {
        String cut = String.format("%.02f", converter.getCalBurned(stepTracker.getSumStepsOfMonth(month)));
        System.out.println("За месяц вы сожгли: " + cut + " калорий");
    }

    private void printPathTraveled(int month) {
        String cut = String.format("%.02f", converter.getPathTraveled(stepTracker.getSumStepsOfMonth(month)));
        System.out.println("За месяц вы прошли: " + cut + " километров");
    }

    private void printBestSeries(int month) {
        int bestSeries = stepTracker.getBestSeries(month);
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