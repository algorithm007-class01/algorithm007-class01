class Solution {
public:
    int GetRoot(vector<int>& relationMap, int v)
    {
        int fatherNode = relationMap[v];
        if (fatherNode == v) {//上级是自己，说明这个人就是真正的老大
            return fatherNode;
        }

        /*上级不是自己，说明这个人也只是个小弟，一直向前递归查找，直到找到真正的老大
        这样一级级返回，整个链条上所有人的上级都被直接设置成了该团伙老大，从而实现了扁平化管理（路径压缩）*/
        relationMap[v] = GetRoot(relationMap, fatherNode);

        return relationMap[v];
    }

    int findCircleNum(vector<vector<int>>& M)
    {
        std::ios::sync_with_stdio(false);
        int n = M.size();
        vector<int> relationMap(n, 0);
        for (int i = 0; i < n; ++i) {
            relationMap[i] = i;//先把每个人的老大初始化为自己，这样江湖上一开始有n个独立团伙
        }

        for (int i = 0; i < M.size(); ++i) {
            for (int j = 0; j < M[i].size(); ++j) {
                if (i != j && M[i][j] == 1) {
                    /*发现俩人是朋友，说明是同伙，开始寻找他们的老大*/
                    int rootI = GetRoot(relationMap, i);
                    int rootJ = GetRoot(relationMap, j);
                    if (rootI != rootJ) {
                        relationMap[rootJ] = rootI;//团伙合并
                    }
                }
            }
        }

        /*经过上面的组织结构优化（路径压缩），现在每个团伙都只有两层组织————老大直接管理小弟，这样一来
        只要遍历每个人，一旦发现其直接上级就是自己则说明发现了一个独立的团伙(如果上级不是自己说明他只是某团伙的小弟，不care了)*/
        int numOfGroup = 0;
        for (int i = 0; i < n; ++i) {
            if (relationMap[i] == i) {
                ++numOfGroup;
            }
        }

        return numOfGroup;
    }
};
