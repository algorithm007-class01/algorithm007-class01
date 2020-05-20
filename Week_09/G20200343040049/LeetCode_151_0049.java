class Solution {
    public String reverseWords(String s) {

        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();

        for (int i = strs.length - 1; i >= 0; --i) {
            if (strs[i].length() == 0) continue;
            res.append(strs[i]).append(" ");
        }

        return res.toString().trim();
    }
}
