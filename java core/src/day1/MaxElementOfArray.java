package day1;

import java.util.Scanner;

public class MaxElementOfArray{
    public static void main(String[] args){
        int x_size, y_size;
        int[][] matrix;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter first parameter of matrix:");
            x_size = Integer.parseInt(scanner.nextLine());
            if (x_size > 20)
                System.out.println("Size does not exceed 20");
        } while (x_size > 20);

        do {
            System.out.print("Enter second parameter of matrix:");
            y_size = Integer.parseInt(scanner.nextLine());
            if (y_size > 20)
                System.out.println("Size does not exceed 20");
        } while (y_size > 20);

        matrix = new int[x_size][y_size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]" + ": ");
                matrix[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }

        System.out.println("Elements in matrix: ");
        for (int x = 0; x < matrix.length; x++){
            for (int y = 0; y < matrix[x].length; y++){
                System.out.print(matrix[x][y] + " ");
            }
            System.out.println();
        }
        
        int max = matrix[0][0];
        for (int x = 0; x < matrix.length; x++){
            for (int y = 0; y < matrix[x].length; y++){
                if (max < matrix[x][y]){
                    max = matrix[x][y];
                }
            }
        }
        System.out.println("Max element of matrix: " + max);
    }
}