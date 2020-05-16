class Solution {
public:
    string reverseStr(string s, int k) {
        int len = s.size();
        int step = 2 * k;
        for(int i=0; i<len; i+=step){
            if(i + k < len){
                int l = i, r = i + k - 1;
                while(l < r){
                    char temp = s[l];s[l] = s[r];s[r] = temp;
                    l++;r--;
                }
            }else{
                int l = i, r = s.size() - 1;
                while(l < r){
                    char temp = s[l];s[l] = s[r];s[r] = temp;
                    l++;r--;
                }
            }            
        }
        return s;
    }
};