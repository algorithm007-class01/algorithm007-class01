class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        final String[] words = s.split("\\s+");
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String tmp = words[left];
            words[left++] = words[right];
            words[right--] = tmp;
        }
        return String.join(" ", words);
    }
}