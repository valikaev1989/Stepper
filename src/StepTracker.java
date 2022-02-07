import java.util.HashMap;

public class StepTracker {
    static int PurposeForSteps = 10000;
    static HashMap<Integer, MonthData> monthToData = new HashMap<>();

    public StepTracker() {
        for (int i = 1; i < 13; i++)
            monthToData.put(i, new MonthData());
    }

    public void setNewPurposeForSteps(int newPurpose) {
        PurposeForSteps = newPurpose;
    }

    public static int getNewStepsForDay(int month, int data, int steps) {
        return monthToData.get(month).addData(data, steps);
    }

    public static int getMaxStepsInMonth(int month) {
        int maxSteps = 0;
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            if (monthData.dataAndSteps[i] > maxSteps) {
                maxSteps = monthData.dataAndSteps[i];
            }
        }
        return maxSteps;
    }

    public static double getAverageValueOfSteps(int month) {
        double averageSteps = 0;
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            averageSteps += monthData.dataAndSteps[i];
        }
        averageSteps = averageSteps / monthData.dataAndSteps.length;
        return averageSteps;
    }

    public static int getSumStepsOfMonth(int month) {
        int sumSteps = 0;
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            sumSteps += monthData.dataAndSteps[i];
        }
        return sumSteps;
    }

    public static int getBestSeries(int month) {
        int bestSeries = 0;
        int finalSeriesSteps = 0;
        int SeriesSteps = 0;
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            if (PurposeForSteps <= monthData.dataAndSteps[i]) {
                bestSeries += 1;
                SeriesSteps = bestSeries;
            } else if (PurposeForSteps > monthData.dataAndSteps[i]) {
                bestSeries = 0;
                if (finalSeriesSteps < SeriesSteps) {
                    finalSeriesSteps = SeriesSteps;
                }
            }
        }
        return finalSeriesSteps;
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