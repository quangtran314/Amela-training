package day4.stack_queue.stack.reverse.stringReverse;

import day4.stack_queue.stack.genericStack.*;

public class Reverse{
    private String in;
    private String out;

    public Reverse(String in){
        this.in = in;
    }

    public String doRev(){
        MyGenericStack<Character> stack = new MyGenericStack<Character>();
        
        for(int i = 0; i < in.length(); i++){
            stack.push(in.charAt(i));
        }

        out = "";

        while(!stack.isEmpty()){
            char ch = stack.pop();
            out += ch;
        }
        return out;
    }
}
