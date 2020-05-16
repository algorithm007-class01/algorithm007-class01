/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function(M) {
    let len = M.length;
    if(len < 1) return 0;
    let count = len;
    let parent = new Array(len);
    for(let i = 0;i < len;i++){
        parent[i] = i;
    }
    for(let i = 0;i < len;i++){
        for(let j = 0; j < len;j++){
            if(M[i][j] == 1){
                union(i,j);
            }
        }
    }
    return count;

    function find(p) {
        while( p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    function union(p,q) {
        let rootP = find(p);
        let rootQ = find(q);
        if(rootP == rootQ){
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
    
};