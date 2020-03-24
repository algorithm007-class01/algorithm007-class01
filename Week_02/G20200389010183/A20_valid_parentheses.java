package com.szp.leetcode.q1_50;

public class A20_valid_parentheses {
    class Solution {
        public boolean isValid(String s) {
            if(null == s || s.length() == 0)
                return true;
            if(s.length() % 2 == 1)
                return false;
            char[] parenttheses = new char[]{'(',')','{','}','[',']'};
            char[] stack = new char[(s.length() / 2)];
            int index = 0;
            for(char c : s.toCharArray()){
                if(isLeft(c)){
                    if(index == stack.length){
                        return false;
                    }
                    stack[index] = c;
                    index++;
                }else{
                    if(index == 0)
                        return false;
                    if(isPare(c,stack[index-1])){
                        index--;
                    }else {
                        return false;
                    }
                }
            }
            return index == 0;
        }

        private boolean isPare(char c, char c1) {
            return Math.abs(c-c1) <=  2;
        }

        private boolean isLeft(char c) {
            return c == '(' || c == '{' || c == '[';
        }

    }
/*
* 示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
链接：https://leetcode-cn.com/problems/valid-parentheses
* */
    public static void main(String[] args) {
        Solution solution = new A20_valid_parentheses().new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid(""));
        System.out.println(solution.isValid("({["));
    }
}
