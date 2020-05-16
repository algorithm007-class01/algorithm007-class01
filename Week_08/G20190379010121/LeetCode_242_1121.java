class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.equals(char1,char2);
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] map = new int[26];
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for(int i = 0;i < chars1.length;i ++){
            map[chars1[i]- 'a'] ++;
            map[chars2[i]- 'a'] --;
        }
        for(int i = 0;i < 26 ;i ++){
            if(map[i] != 0){
                return false;
            }
        }
        return true;
    }
}