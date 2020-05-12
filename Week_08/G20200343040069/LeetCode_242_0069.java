class Solution {

    public boolean isAnagram(String s, String t) {
        if(null == s && null == t) return true;
        if(null == s || null == t) return false;
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> dict = new HashMap<>();
        for(Character c : s.toCharArray()){
            dict.put(c, dict.getOrDefault(c, -1) + 1);
        }

        for(char c : t.toCharArray()){
            if(!dict.containsKey(c) || dict.get(c) < 0){
                return false;
            } else{
                dict.put(c, dict.get(c)-1);
            }
        }
        return true;
    }
}