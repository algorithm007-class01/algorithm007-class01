package DailyPractice;

import java.util.Arrays;

public class LeetCode_242_0215 {

    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);

        char [] tc =  t.toCharArray();
        Arrays.sort(tc);
       return Arrays.toString(sc).equals(Arrays.toString(tc));
    }

    public boolean isAnagram2(String s, String t) {
        int [] count = new int [26];

        for (int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for (int temp :count){
            if (temp!=0){
                return false;
            }
        }
        return true;
    }
}
