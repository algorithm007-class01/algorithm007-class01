package rotation.one.week.nine;

import java.util.HashMap;

public class LeetCode_205_0145 {

    public boolean isIsomorphic(String s, String t) {
        boolean res = isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
        return res;
    }

    public boolean isIsomorphicHelper(String s, String t) {
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            }else {
                map.put(c1, c2);
            }
        }
        return true;
    }
}
