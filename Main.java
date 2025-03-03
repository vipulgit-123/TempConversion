import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("The Temperature Conversion");

        Scanner sc = new Scanner(System.in);
        String temp = "";
        double cel =0 ,fah =0,kel=0;

        while(true) {
            System.out.println("Enter the Temperature Degree : Choose in between \"Celsius\", \"Fahrenheit\", \"Kelvin\" ");
            temp = sc.nextLine();
            if (temp.equals("Celsius") || temp.equals("Fahrenheit") || temp.equals("Kelvin")) {
                break;
            } else {
                System.out.println("Error : Please Enter the valid input");
            }
        }
            if (temp.equals("Celsius"))
            {
                cel = correctTemperature(sc,"Celsius");
                fah=1.8*cel+32;
                kel = cel + 273.15;
                System.out.printf("Temperature in Fahrenheit :%.2f Temperature in Kelvin :%.2f \n", fah,kel);
            }
            else if (temp.equals("Fahrenheit"))
            {
                fah = correctTemperature(sc,"Fahrenheit");
                cel = (fah - 32)/1.8;
                kel = cel + 273.15 ;
                System.out.printf("Temperature in Celsius: %.2f Temperature in Kelvin :%.2f \n", cel,kel);
            }
            else if (temp.equals("kelvin"))
            {
                kel = correctTemperature(sc,"Kelvin");
                cel = kel - 273.15;
                fah =(kel - 273.15)* 1.8 + 32;
                System.out.printf("Temperature in Celsius: %.2f Temperature in Fahrenheit :%.2f \n", cel,fah);
            }
        }

    private static double correctTemperature(Scanner sc, String scale){
        double temp =0;
        while (true){
            try{
                System.out.println("Enter the temperature " +scale);
                temp= sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid numeric temperature value.");
                sc.nextLine(); // Clear the invalid input
            }
        }
        return temp;
    }
}