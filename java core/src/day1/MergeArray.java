package day1;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args){
        int size;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Create array 1");
        int[] array1 = createArray();

        System.out.println("Create array 2");
        int[] array2 = createArray();

        System.out.printf("%-20s%s", "Elements in array1: ", "");
        for (int j = 0; j < array1.length; j++) {
            System.out.print(array1[j] + "\t");
        }

        System.out.printf("\n%-20s%s", "Elements in array2: ", "");
        for (int j = 0; j < array2.length; j++) {
            System.out.print(array2[j] + "\t");
        }

        int[] newArray = merge(array1, array2);

        System.out.printf("\n%-20s%s", "Elements in array after merge: ", "");
        for (int j = 0; j < newArray.length; j++) {
            System.out.print(newArray[j] + "\t");
        }
    }

    public static int[] createArray(){
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
        int[] array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        return array;
    }

    public static int[] merge(int[] array1, int[] array2){
        int newSize = array1.length + array2.length;
        int[] newArray = new int[newSize];
        int counter = 0;
        for (; counter < array1.length; counter++) {
            newArray[counter] = array1[counter];
        }

        for (int j = 0; j < array2.length; j++){
            newArray[counter++] = array2[j];
        }
        return newArray;
    }


}
