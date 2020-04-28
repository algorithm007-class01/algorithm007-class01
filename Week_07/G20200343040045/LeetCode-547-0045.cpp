#include <iostream>
#include <vector>
using namespace std;

class UF
{
public:
    UF(int n)
    {
        count = n;
        parent.resize(n);
        size.resize(n);
        for(int i = 0; i < n; i++)
        {
            parent[i] =i;
            size[i] = 1;
        }
    }
    // 节点p 和 节点 q 连通
    void Union(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ)
            return;
        
        if(size[rootP] > size[rootQ])
        {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        else
        {
            parent[rootP] = rootQ;
            size[rootQ] += rootP;
        }
        count--;//连通个数 -1
    }
    //判断节点p 和 节点 q 是否连通
    bool connected(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP==rootQ;
    }
    //返回当前连通个数
    int count_num()
    {
        return count;
    }
private:
    int count;// 连通的个数
    vector<int> parent;// 节点的父节点
    vector<int> size;// 节点的重量
    int find(int x)// 寻找 x 节点的父节点
    {
        while(parent[x] != x)
        {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
};

class Solution {
   public:
    int findCircleNum(vector<vector<int>>& M) {
          // base case
        if(M.size()==0)
            return 0;
        
        int m = M.size();//行数
        int n = M[0].size();//列数
        UF* uf = new UF(m);
        for(int i = 0; i < m; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                if(M[i][j] == 1)
                {
                    uf->Union(i,j);
                }
            }
        }
        return uf->count_num();
    }
};

