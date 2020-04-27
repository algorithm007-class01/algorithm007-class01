class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {

        if(g.empty() || s.empty()) {
            return 0;
        }
        // 为了确保所有的孩子跟饼干都能完全参与匹配一次. 
        // 小孩子的胃口顺序有可能是乱序的.
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());

        // child记录满足孩子胃口的数量,胃口值是g[child]，cookie记录消耗饼干索引,饼干尺度是s[cookie]
        int child = 0;
        int cookie = 0;

	// 孩子胃口只有在匹配的时候才累加，而饼干会一直累加， 换句话孩子胃口是慢指针，饼干尺度是快指针.
        while(child < g.size() && cookie < s.size()) {
            // 孩子胃口跟每块饼干尺度匹配
            if(g[child] <= s[cookie]) {
                child++;
            }
            cookie++;
        }
        return child;
    }
};
