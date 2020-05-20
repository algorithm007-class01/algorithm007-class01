
/*
557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
*/

class Solution {
    public String reverseWords(String s) {
        return getTwo(s);

    }


    /**
     * 分隔单词，单词翻转
     **/
    public String getTwo(String input){
        final StringBuilder result = new StringBuilder();
        final Stack<Character> stack = new Stack();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                stack.push(input.charAt(i));
            } else {
                result.append(getString(stack));
                result.append(" ");
            }
        }
        if(!stack.isEmpty()){
            result.append(getString(stack));
        }
        return result.toString();
    }
    private String getString(Stack<Character> stack){
        int len = stack.size();
        char[] chars = new char[len];
        for (int j = 0; j < len; j++) {
            chars[j] = stack.pop();
        }
        return new String(chars);
    }


    /**
     * 分隔单词，单词翻转
     **/
    public String getOne(String s){
        String[] arr = s.trim().split("\\s+");
        for(int i = 0; i < arr.length; i++){
            char[] carr = arr[i].toCharArray();
            swap(carr);
            arr[i] = new String(carr);
        }
        return String.join(" ", arr);
    }
    private void swap(char[] arr){
        int i = 0, j = arr.length -1;
        while(i < j){
            char c = arr[i];
            arr[i++] = arr[j];
            arr[j--] = c;
        }
    }
}