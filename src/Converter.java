public class Converter {
    int lengthStep;
    int calBurnedForOneStep;
    int Kcal;
    int calories;

    Converter() {
        lengthStep = 75;
        calories = 1;
        calBurnedForOneStep = calories * 50;
        Kcal = 1000 * calories;
    }

     void thePathTraveled(float steps) {
         String cut = String.format("%.02f", (lengthStep * steps) / 100000);
        System.out.println("За месяц вы прошли: " + cut + " километров");
    }

    void calBurned(float steps) {
        String cut = String.format("%.02f", (steps * calBurnedForOneStep) / Kcal);
        System.out.println("За месяц вы сожгли: " + cut + " калорий");
    }
}