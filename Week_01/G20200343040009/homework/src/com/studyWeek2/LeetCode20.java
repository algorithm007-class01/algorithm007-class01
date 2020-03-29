package com.studyWeek2;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 1. 将左括号压入栈
 * 2. 遇到右括号，先判断栈为空，不为空查看栈顶
 * 3. 然后通过map动态获得相应右括号
 * 4. 相等出栈
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')' );
        map.put('{', '}' );
        map.put('[', ']' );
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return Boolean.FALSE;
                }
                char outC = stack.peek();
                if (map.get(outC) != c) {
                    return Boolean.FALSE;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
