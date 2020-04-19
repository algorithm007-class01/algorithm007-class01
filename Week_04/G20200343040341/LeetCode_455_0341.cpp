class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        //sort(g.begin(), g.end());
        //sort(s.begin(), s.end());
        // int count = 0;
        // int j = 0;
        // for(auto i : g){
        //     for(;j<s.size(); j++){
        //         if(s[j] >= i){
        //             count++;
        //             j++;
        //             break;
        //         }
        //     }
        // }
        // return count;

        sort(g.begin(),g.end());
        sort(s.begin(),s.end());
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < g.size() && j < s.size()){
            if(g[i] <= s[j]){
                i++;j++;
                count++;
            }else{
                j++;
            }
        }
        return count;
    }
};