var combine = function(n, k) {
    let ans = [];
    getCombines(1,n, k, [], ans);
    return ans;
}

var getCombines = function(start, n,  k, temp, ans) { 
    if(temp.length == k){
        ans.push(temp);
        return;
    }
    for (let i = start; i <= n - (k -temp.length) + 1; i++) {
        temp.push(i);
        getCombines(i+1, n, k, temp.slice(), ans);
        temp.pop();
    }
}