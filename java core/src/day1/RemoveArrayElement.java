package day1;

import java.util.Scanner;

public class RemoveArrayElement {
    public static void main(String[] args){
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        System.out.print("\nEnter an removal element: ");
        int removal_element = scanner.nextInt();
        for (int j = 0; j < array.length; j++){
            if (array[j] == removal_element){
                for (int count = j; count < array.length-1; count++){
                    array[count] = array[count+1];
                }
                array[array.length-1] = 0;
                j--;
            }
        }
        System.out.printf("\n%-20s%s", "New array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
