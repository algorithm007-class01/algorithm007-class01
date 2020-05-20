class Solution {
    public String reverseWords(String s) {
        String[] split = s.trim().split(" +");
        Collections.reverse(Arrays.asList(split));
        return String.join(" ", split);
    }
}