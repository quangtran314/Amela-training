package day1;

import java.util.Scanner;

public class PrimeNumberPrinting {
    public static void main(String[] args){
        System.out.print("List of prime number smaller 100: ");
        int i = 2;
        while(i < 100){
            if (isPrime(i)){
                System.out.print(i + " ");
            }
            i++;
        }
    }

    public static boolean isPrime(int number){
        if (number < 2){
            return false;
        } else {
            int i = 2;
            while(i <= Math.sqrt(number)){
                if(number % i == 0){
                    return false;
                }
                i++;
            }
            return true;
        }
    }
}
