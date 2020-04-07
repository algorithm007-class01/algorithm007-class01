package cxl.study.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_22_0257 {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {


        recursionGenerate(0,  n, "",0,0);

        return result;

    }

    private void recursionGenerate(int level, int max, String s,int leftCount,int rightCount) {


        if(leftCount == max && rightCount == max){
            result.add(s);
            return;
        }
        String left = "(";
        String right = ")";

        if(leftCount < max){
            recursionGenerate(level+1,max,s+left,leftCount+1,rightCount);
        }
        if(rightCount < leftCount){
            recursionGenerate(level+1,max,s+right,leftCount,rightCount+1);
        }


    }

    private boolean validParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        for (char alp : str.toCharArray()) {
            if (alp == '('){
                stack.push(')');
            } else if (alp == '[') {
                stack.push(']');
            } else if (alp == '{'){
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != alp) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        LeetCode_22_GenerateParentheses generateParentheses = new LeetCode_22_GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));

    }


}
