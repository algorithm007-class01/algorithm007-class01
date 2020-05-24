class Solution {

    int count;
    int[] parent;

    public void init(int n ){
        count = n;
        parent = new int[n];
        for(int i = 0; i < n; i++ ){
            parent[i] = i;
        }
    }

    public int find(int p){
        while( p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p , int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }

    public int findCircleNum(int[][] M) {
        init(M.length);
        for(int i = 0 ; i < M.length ; i++){
            for(int j = 0 ; j < M[i].length; j++){
                if(M[i][j] == 1){
                    union(i,j);
                }
            }
        }
        return count;
    }
}