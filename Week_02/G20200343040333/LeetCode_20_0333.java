package app;

import java.util.Stack;

public class LeetCode_20_0333 {
    public boolean isValid(String s) {
        //return validLowest(s);
        return validStack(s);
        //return false;

    }
    /**
     * better solution
     * @param s
     * @return
     */
    private boolean validStack(String s) {
        if(null==s||s.length()==1){
            return false;
        }
        if(s.isEmpty()){
            return true;
        }
        if(!(s.contains("{")||s.contains("}")||s.contains("[")||s.contains("]")||s.contains("(")||s.contains(")"))){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        int p=0;
        while(p<s.length()){
            char c=s.charAt(p);
            switch(c){
                case '{':
                case '[':
                case '(':
                stack.add(c);
                break;
                case '}':
                if(stack.size()>0&&stack.peek()=='{'){
                    stack.pop();
                }else{
                    return false;
                }
                break;
                case ']':
                if(stack.size()>0&&stack.peek()=='['){
                    stack.pop();
                }else{
                    return false;
                }
                break;
                case ')':
                if(stack.size()>0&&stack.peek()=='('){
                    stack.pop();
                }else{
                    return false;
                }
                break;

            }
            ++p;
        }
        return stack.size()==0;
    }

    /**
     * 最差写法
     * 
     * @param s
     * @return
     */
    private boolean validLowest(String s) {
        if(null==s||s.length()==1){
            return false;
        }
        if(s.isEmpty()){
            return true;
        }
        if(!(s.contains("{")||s.contains("}")||s.contains("[")||s.contains("]")||s.contains("(")||s.contains(")"))){
            return false;
        }
        
        while(s.contains("()")||s.contains("{}")||s.contains("[]")){
            if(s.contains("{}")){
                s=s.replaceAll("\\{\\}","");
            }
            if(s.isEmpty()){
                return true;
            }
            if(s.contains("()")){
                s=s.replaceAll("\\(\\)","");
            }
            if(s.isEmpty()){
                return true;
            }
            if(s.contains("[]")){
                s=s.replaceAll("\\[\\]","");
            }
            if(s.isEmpty()){
                return true;
            }
        }
        
        
        return s.isEmpty();
    }
}