package day1;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = Integer.parseInt(sc.nextLine());

        if (isPrime(number)){
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }
        
    }

    public static boolean isPrime(int number){
        if (number < 2){
            return false;
        } else {
            int i = 2;
            while(i < Math.sqrt(number)){
                if(number % i == 0){
                    return false;
                }
                i++;
            }
            return true;
        }
    }
}
