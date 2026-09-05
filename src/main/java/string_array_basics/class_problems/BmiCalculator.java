package string_array_basics.class_problems;

public class BmiCalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-8s %-12s %-12s %-8s %s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-8d %-12.2f %-12.1f %-8.2f %s%n", i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        printWellnessReport(new double[] {1.75, 1.60, 1.82}, new double[] {70, 90, 82});
    }
}
