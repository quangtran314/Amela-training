package day4.stack_queue.stack.reverse.intReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseTest {
    public static void main(String[] args) throws IOException{
        int input; 
        int output;
        while(true){
            System.out.print("Enter a number: ");
            System.out.flush();

            input = getInt();

            Reverse reverse = new Reverse(input);
            output = reverse.doRev();
            System.out.println("Reverse: " + output);
        }
    }

    private static int getInt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        int inp = Integer.parseInt(reader.readLine());
        return inp;
    }
}
