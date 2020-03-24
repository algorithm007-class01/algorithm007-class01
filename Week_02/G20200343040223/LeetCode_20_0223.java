package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode_20_0223 {

    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                if(stack.pop() != map.get(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
