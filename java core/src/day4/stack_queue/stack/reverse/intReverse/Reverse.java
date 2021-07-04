package day4.stack_queue.stack.reverse.intReverse;

import day4.stack_queue.stack.genericStack.*;

public class Reverse {
    private int in;
    private int out;

    public Reverse(int in){
        this.in = in;
    }

    public int doRev(){
        MyGenericStack<Integer> stack = new MyGenericStack<Integer>();
        
        while(in > 0){
            stack.push(in % 10);
            in /= 10;
        }

        out = 0;
        int i = 0;

        while(!stack.isEmpty()){
            int temp = stack.pop();
            out = out + (int) Math.pow(10, i++) * temp;
        }
        return out;
    }
}
