var hammingWeight = function(n) {
    let res = 0;
    while(n!=0){
        res++;
        n &= (n-1);
    }
    return res;
};