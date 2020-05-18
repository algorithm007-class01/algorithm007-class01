package rotation.one.week.nine;

import java.util.Stack;

public class LeetCode_917_0145 {
    public String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack<>();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.push(c);
            }
        }
        StringBuilder bd = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                bd.append(letters.pop());
            }else {
                bd.append(c);
            }
        }
        return bd.toString();
    }

}
