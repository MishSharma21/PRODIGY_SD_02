package SoftwareDevelopment;
import java.util.*;
public class Task1{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the temperature: ");
        double temp=sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter the original unit of temperature K,C,F: ");
        String str=sc.nextLine();
        if(str.equals("K"))
        {
            double celsius= temp-273.15;
            double fahrenheit=9/5*celsius+32;
            System.out.println("Temperature Converted from Kelvin to Celsius is: " + celsius);
            System.out.println("Temperature Converted from Kelvin to Fahrenheit is: " + fahrenheit);
        }
        else if(str.equals("C"))
        {
            double kelvin=temp+273.15;
            double fahrenheit=(9.0/5.0)*temp+32;
            System.out.println("Temperature Converted from Celsius to Kelvin is: " + kelvin);
            System.out.println("Temperature Converted from Celsius to Fahrenheit is: " + fahrenheit);
        }
        else if(str.equals("F"))
        {
            double celsius=(5.0/9.0)*(temp-32);
            double kelvin=celsius+273.15;
            System.out.println("Temprature Converted from Fahrenheit to Celsius is: " + celsius);
            System.out.println("Temprature Converted from Fahrenheit to Kelvin is: " + kelvin);
        }
        else
        {
            System.out.println("Invalid Input.");
        }
        sc.close();
    }
}

