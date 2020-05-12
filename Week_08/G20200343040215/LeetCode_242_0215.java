public class LeetCode_242_0215 {
    public boolean isAnagram(String s, String t) {
        int[] m = new int[26];
        if (s.length()!=t.length()){
            return false;
        }

        for (int i=0;i<s.length();i++){
            m[s.charAt(i)-'a']++;
            m[t.charAt(i)-'a']--;
        }
        for (int j:m){
            if (j!=0){
                return false;
            }
        }
        return true;
    }
}
