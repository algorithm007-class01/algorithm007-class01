package app;

import java.util.Stack;

public class LeetCode_155_0333 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public LeetCode_155_0333() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            if(x<=minStack.peek()){
                minStack.push(x);
            }
        }
    }
    
    public void pop() {
        int top=stack.pop();
        if(top==minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}