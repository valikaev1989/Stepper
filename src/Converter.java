public class Converter {
    private static int lengthStep;
    private static int calBurnedForOneStep;
    private static int kcal;


    public Converter(int lengthStep, int calBurnedForOneStep, int kcal) {
        Converter.lengthStep = lengthStep;
        Converter.calBurnedForOneStep = calBurnedForOneStep;
        Converter.kcal = kcal;
    }

    public double getPathTraveled(int sumSteps) {
        return (double) (lengthStep * sumSteps) / 100000;
    }

    public double getCalBurned(int sumSteps) {
        return (double) (sumSteps * calBurnedForOneStep) / kcal;
    }
}