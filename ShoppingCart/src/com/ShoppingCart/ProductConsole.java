package com.ShoppingCart;

import java.util.Scanner;

public class ProductConsole
{
    static Scanner scanner = new Scanner(System.in);

    public static double getValues(String prompt)
    {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    public static double getValues(String prompt, double min, double max)
    {
        double value;
        while(true)
        {
            System.out.println(prompt);
            value = scanner.nextDouble();
            if(value >= min && value <= max)
                break;
            System.out.println("Enter a value between : "+ min +" to "+max);
        }
        return value;
    }

    public static double getValues(String prompt , double min)
    {
        double value;
        while(true)
        {
            System.out.println(prompt);
            value = scanner.nextDouble();
            if(value >= min )
                break;
            System.out.println("Enter a value Greater than : "+ min );
        }
        return value;
    }

    public static String readString(String prompt)
    {
        System.out.println(prompt);
        return scanner.nextLine();
    }

}
