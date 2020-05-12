public class LeetCode_242_0147 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int count = 0;
        int[] container = new int[255];
        for (char c : s.toCharArray()) {
            container[c - 'a']++;
            if (container[c - 'a'] > 0) {
                count++;
            }
        }
        for (char c : t.toCharArray()) {
            container[c - 'a']--;
            if (container[c - 'a'] < 0) {
                return false;
            } else {
                count--;
            }
        }
        return count == 0;
    }
}
