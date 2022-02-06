import java.util.HashMap;

public class StepTracker {
    int PurposeForSteps = 10000;
    Converter converter = new Converter();
    HashMap<Integer, MonthData> monthToData = new HashMap<>();

    public StepTracker() {
        for (int i = 1; i < 13; i++)
            monthToData.put(i, new MonthData());
    }


    void newPurposeForSteps(int newPurpose) {
        if (newPurpose <= 0) {
            System.out.println("Вы ввели некорректные данные, попробуйте еще раз");
            System.out.println("Текущая цель осталась неизменна: " + PurposeForSteps + " шагов" + " в день");
        }else {
            System.out.println("Предыдущая цель была: " + PurposeForSteps + " шагов в день");
            PurposeForSteps = newPurpose;
            System.out.println("Новая цель: " + PurposeForSteps + " шагов в день");
        }
    }

    void newStepsForDay(int month, int data, int steps) {
        int answer = monthToData.get(month).addData(data, steps);
        if (steps < 0) {
            System.out.println("Введены некорректные данные. Попробуйте снова");
        } else if (steps < 5) {
            System.out.println("Новые данные по шагам занесены в систему. В этот месяц: " + month + ", в этот день: "
            + data + ", вы совершили: " + answer + " шага.");
        }else {
            System.out.println("Новые данные по шагам занесены в систему. В этот месяц: " + month + ", в этот день: "
            + data + ", вы совершили: " + answer + " шагов.");
        }
    }
    void maxStepsInMonth(int month) {
        int maxSteps = 0;
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            if (monthData.dataAndSteps[i] > maxSteps) {
                maxSteps = monthData.dataAndSteps[i];
            }
        }System.out.println("Ваш рекорд по шагам в этом месяце был: " + maxSteps);
    }

    void averageValueOfSteps(int month) {
        double averageSteps = 0;
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            if (monthData.dataAndSteps[i] > averageSteps) {
                averageSteps += monthData.dataAndSteps[i];
                averageSteps = averageSteps / monthData.dataAndSteps.length;
            }
        }String str = String.format("%.02f", averageSteps);
         System.out.println("Среднее количество шагов за месяц: " + str);
    }

    int sumStepsOfMonth(int month) {
        int sumSteps = 0;
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
                sumSteps += monthData.dataAndSteps[i];
        }return sumSteps;
    }

    void totalNumberSteps(int month) {
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            System.out.println((i + 1) + " день: " + monthData.dataAndSteps[i] + " шагов");
        }
    }

    void bestSeries(int month){
        int bestSeries = 0;
        int finalSeriesSteps = 0;
        int SeriesSteps = 0;
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            if(PurposeForSteps <= monthData.dataAndSteps[i]) {
                bestSeries += 1;
                SeriesSteps = bestSeries;
           }else if(PurposeForSteps > monthData.dataAndSteps[i]) {
               bestSeries = 0;
               if(finalSeriesSteps < SeriesSteps){
                   finalSeriesSteps = SeriesSteps;
               }
           }
        }
        if(finalSeriesSteps == 1){
            System.out.println("Всего " + finalSeriesSteps + " раз Вы смогли достичь цели в этом месяце");
        }else if(finalSeriesSteps == 0){
            System.out.println("В этом месяце Вы ни разу не достигли цели");
        }else if(finalSeriesSteps < 5){
            System.out.println("Лучшая серия с достижением цели: " + finalSeriesSteps + " дня");
        }else {
            System.out.println("Лучшая серия с достижением цели: " + finalSeriesSteps + " дней");
        }
    }

    void printAllStatistics(int month) {
        if (monthToData.containsKey(month)) {
            System.out.println("Статистика за месяц №" + month + ":");
            totalNumberSteps(month);
            maxStepsInMonth(month);
            averageValueOfSteps(month);
            converter.calBurned(sumStepsOfMonth(month));
            converter.thePathTraveled(sumStepsOfMonth(month));
            bestSeries(month);
        } else {
            System.out.println("Вы ошиблись, такого месяца нет в календаре");
        }
    }

      static class MonthData {
        int[] dataAndSteps;
        private MonthData() {
            dataAndSteps = new int[30];
        }
        private int addData(int data, int steps) {
            return dataAndSteps[data - 1] = steps;
        }
    }
}