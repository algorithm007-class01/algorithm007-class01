class Solution {
    public String reverseWords(String s) {
        char[] sentence = s.toCharArray();
        int i = 0, j = 0;
        while(j < sentence.length) {
            while(i < sentence.length && sentence[i] == ' ') ++i;
            while(j < sentence.length && sentence[j] != ' ') ++j;
            reverse(sentence, i, j - 1);
            i = j;
            ++j;
        }
        s = String.valueOf(sentence);
        return s;
    }
    
    private void reverse(char[] arr, int start, int end) {
        if (arr.length == 0) return;
        
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++start;
            --end;
        }
    }
}