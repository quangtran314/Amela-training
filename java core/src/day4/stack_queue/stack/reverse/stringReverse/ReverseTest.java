package day4.stack_queue.stack.reverse.stringReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseTest {
    public static void main(String[] args) throws IOException{
        String input, output;
        while(true){
            System.out.print("Enter a string: ");
            System.out.flush();

            input = getString();
            
            if(input.equals("")){
                break;
            } 

            Reverse reverse = new Reverse(input);
            output = reverse.doRev();
            System.out.println("Reverse: " + output);
        }
    }

    private static String getString() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        String inp = reader.readLine();
        return inp;
    }
}
