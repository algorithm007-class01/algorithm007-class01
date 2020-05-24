/*
 *解码方法 
 */
class Solution {
    /*
     *时间复杂度:O(n)
     *空间复杂度:O(1)
     */
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0'){
            return 0;
        }
        int f0 = 1;
        int f1 = 1;
        int temp = f0;
        for(int i = 1; i < n; i++){
            int pre = s.charAt(i - 1) - '0';
            int cur = s.charAt(i) - '0';
            if(cur == 0 && pre == 0){//当前字符为'0',但前一个字符为'0'
                return 0;
            }else if(cur != 0 && pre == 0){//当前字符不为'0',但前一个字符串为'0'
                temp = f1;
            }else if(cur == 0 && pre != 0){//当前字符为'0',但前一个字符串不为'0'
                if(pre <= 2){
                    temp = f0;
                }else{
                    return 0;
                }
            }else{//当前字符不为'0',且前一个字符也不为'0'
                if((pre * 10 + cur) <= 26){
                    temp = f0 + f1;
                }else{
                    temp = f1;
                }
            }
            f0 = f1;
            f1 = temp;
        }
        return f1;
    }
}