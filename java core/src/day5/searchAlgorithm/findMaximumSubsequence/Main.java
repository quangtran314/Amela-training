package day5.searchAlgorithm.findMaximumSubsequence;

import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String string = input.nextLine();
        input.close();

        LinkedList<Character> max = new LinkedList<>();

        // find maximum subsequence
        for (int i = 0; i < string.length(); i++) { 
            LinkedList<Character> list = new LinkedList<>();
            
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) { 
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }

        for (Character ch: max) { 
            System.out.print(ch); 
        }
        System.out.println();
    }
}
