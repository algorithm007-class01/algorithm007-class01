//	中心扩展法	
class Solution {
public:
    string longestPalindrome(string s) {
        if (s.length() == 0) return "";
        string result("");
        int size = int(s.length());

        //选择一个中心点，向两侧扩展
        for (int i = 0; i < size; ++i) {
            // 奇数组情况
            string tmpStr = expandHelper(s, i, i);
            // 偶数组情况
            string tmpStr2 = expandHelper(s, i, i + 1);

            if (int(tmpStr.length()) > int(result.length())) {
                result = tmpStr;
            }
            if (int(tmpStr2.length()) > int(result.length())) {
                result = tmpStr2;
            } 
        }
        return result;
    }
private:
    string expandHelper(string &s, int left, int right) {
        int size = int(s.size());
        while (left >= 0 && right < size && s[left] == s[right]) {
            left--;
            right++;
        }
        return s.substr(left + 1, right - left - 1);
    }
};