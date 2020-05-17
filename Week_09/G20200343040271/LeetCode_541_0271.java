
/*
541. 反转字符串 II
给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 
示例:
输入: s = "abcdefg", k = 2
输出: "bacdfeg"
*/

class Solution {
    public String reverseStr(String s, int k) {
        if(s.length() <= 1){
            return s;
        }
        char[] arrs = s.toCharArray();
        for(int i = 0; i < arrs.length; i = 2*k+i){
            int j = i,v = Math.min(i+k-1, arrs.length-1);
            while(j<v){
                char temp = arrs[j];
                arrs[j++] = arrs[v];
                arrs[v--] = temp;
            }
        }
        return new String(arrs);
    }
}