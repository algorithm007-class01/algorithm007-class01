class Solution {
    public int firstUniqChar(String s) {
        char[] map = new char[26];

        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map[c - 'a'] == 1) return i; 
        }
        return -1;
    }
}