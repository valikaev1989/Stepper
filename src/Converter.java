public class Converter {
    private final int LENGTH_STEP;
    private final int CAL_BURNED_FOR_ONE_STEP;
    private final int K_CAL;

    public Converter(int lengthStep, int calBurnedForOneStep, int kcal) {
        this.LENGTH_STEP = lengthStep;
        this.CAL_BURNED_FOR_ONE_STEP = calBurnedForOneStep;
        this.K_CAL = kcal;
    }

    public double getPathTraveled(int sumSteps) {
        return (double) (LENGTH_STEP * sumSteps) / 100000;
    }

    public double getCalBurned(int sumSteps) {
        return (double) (sumSteps * CAL_BURNED_FOR_ONE_STEP) / K_CAL;
    }
}