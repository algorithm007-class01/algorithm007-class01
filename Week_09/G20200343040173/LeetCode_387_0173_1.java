import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}