import java.util.InputMismatchException;
import java.util.Scanner;

public class MAin1 {
    public static void main(String[] args) {
        System.out.println("The Temperature Conversion");

        Scanner sc = new Scanner(System.in);
        String temp = "";

        // Loop until the user provides a valid input for temperature scale
        while (true) {
            System.out.println("Enter the Temperature Degree");
            System.out.println("Choose in between \"Celsius\", \"Fahrenheit\", \"Kelvin\" ");
            temp = sc.nextLine();

            if (temp.equals("Celsius") || temp.equals("Fahrenheit") || temp.equals("Kelvin")) {
                break; // exit the loop if valid input is given
            } else {
                System.out.println("Error: Please enter a valid input (Celsius, Fahrenheit, Kelvin)");
            }
        }

        double cel = 0, fah = 0, kel = 0;

        // Using helper method to handle input for numeric values
        if (temp.equals("Celsius")) {
            cel = getTemperatureInput(sc, "Celsius");
            fah = 1.8 * cel + 32;
            kel = cel + 273.15;
            System.out.printf("Temperature in Fahrenheit: %.2f Temperature in Kelvin: %.2f\n", fah, kel);
        }
        else if (temp.equals("Fahrenheit")) {
            fah = getTemperatureInput(sc, "Fahrenheit");
            cel = (fah - 32) / 1.8;
            kel = cel + 273.15;
            System.out.printf("Temperature in Celsius: %.2f Temperature in Kelvin: %.2f\n", cel, kel);
        }
        else if (temp.equals("Kelvin")) {
            kel = getTemperatureInput(sc, "Kelvin");
            cel = kel - 273.15;
            fah = (kel - 273.15) * 1.8 + 32;
            System.out.printf("Temperature in Celsius: %.2f Temperature in Fahrenheit: %.2f\n", cel, fah);
        }
    }

    // Helper method to handle temperature input and validate
    private static double getTemperatureInput(Scanner sc, String scale) {
        double temp = 0;
        while (true) {
            try {
                System.out.println("Enter the temperature in " + scale);
                temp = sc.nextDouble();
                break; // exit loop if valid input is given
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid numeric temperature value.");
                sc.nextLine(); // Clear invalid input
            }
        }
        return temp;
    }
}
