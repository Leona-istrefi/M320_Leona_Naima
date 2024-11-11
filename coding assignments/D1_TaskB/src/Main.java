import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user inputs for heating system 1
        System.out.println("Enter initial temperature for heating 1:");
        int initialTemp1 = scanner.nextInt();
        System.out.println("Enter minimum temperature for heating 1:");
        int minTemp1 = scanner.nextInt();
        System.out.println("Enter maximum temperature for heating 1:");
        int maxTemp1 = scanner.nextInt();
        System.out.println("Enter increment value for heating 1:");
        int increment1 = scanner.nextInt();

        // Create heating 1 object
        TaskB heating1 = new TaskB(initialTemp1, minTemp1, maxTemp1, increment1);

        // Get user inputs for heating system 2
        System.out.println("Enter initial temperature for heating 2:");
        int initialTemp2 = scanner.nextInt();
        System.out.println("Enter minimum temperature for heating 2:");
        int minTemp2 = scanner.nextInt();
        System.out.println("Enter maximum temperature for heating 2:");
        int maxTemp2 = scanner.nextInt();
        System.out.println("Enter increment value for heating 2:");
        int increment2 = scanner.nextInt();

        // Create heating 2 object
        TaskB heating2 = new TaskB(initialTemp2, minTemp2, maxTemp2, increment2);

        // Testing heating1
        heating1.increaseTemperature();
        heating1.decreaseTemperature();
        heating1.decreaseTemperature();

        // Testing heating2
        heating2.increaseTemperature();
        heating2.increaseTemperature();
        heating2.decreaseTemperature();

        scanner.close();
    }
}
