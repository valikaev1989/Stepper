import java.util.HashMap;

public class StepTracker {
    private static int purposeForSteps = 10000; // без static переменная остается не изменной
    private static final HashMap<Integer, MonthData> monthToData = new HashMap<>();

    public StepTracker() {
        for (int i = 1; i < 13; i++)
            monthToData.put(i, new MonthData());
    }

    public int setNewPurposeForSteps(int newPurpose) {
        purposeForSteps = newPurpose;
        return purposeForSteps;
    }

    public int setOldPurposeForSteps() {
        return purposeForSteps;
    }

    public boolean checkMonth(int month) {
        return monthToData.containsKey(month);
    }

    public int getNewStepsForDay(int month, int data, int steps) {
        return monthToData.get(month).addData(data, steps);
    }

    public int[] getTotalNumberSteps(int month) {
        MonthData monthData = monthToData.get(month);
        int[] x = new int[30];
        System.arraycopy(monthData.dataAndSteps, 0, x, 0, monthData.dataAndSteps.length);
        return x;
    }

    public int getMaxStepsInMonth(int month) {
        int maxSteps = 0;
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            if (monthData.dataAndSteps[i] > maxSteps) {
                maxSteps = monthData.dataAndSteps[i];
            }
        }
        return maxSteps;
    }

    public double getAverageValueOfSteps(int month) {
        double averageSteps = 0;
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            averageSteps += monthData.dataAndSteps[i];
        }
        averageSteps = averageSteps / monthData.dataAndSteps.length;
        return averageSteps;
    }

    public int getSumStepsOfMonth(int month) {
        int sumSteps = 0;
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            sumSteps += monthData.dataAndSteps[i];
        }
        return sumSteps;
    }

    public int getBestSeries(int month) {
        int bestSeries = 0;
        int finalSeriesSteps = 0;
        int SeriesSteps = 0;
        MonthData monthData = monthToData.get(month);
        for (int i = 0; i < monthData.dataAndSteps.length; i++) {
            if (purposeForSteps <= monthData.dataAndSteps[i]) {
                bestSeries += 1;
                SeriesSteps = bestSeries;
            } else if (purposeForSteps > monthData.dataAndSteps[i]) {
                bestSeries = 0;
                if (finalSeriesSteps < SeriesSteps) {
                    finalSeriesSteps = SeriesSteps;
                }
            }
        }
        return finalSeriesSteps;
    }

    private static class MonthData {
        int[] dataAndSteps;

        private MonthData() {
            dataAndSteps = new int[30];
        }

        private int addData(int data, int steps) {
            return dataAndSteps[data - 1] = steps;
        }
    }
}