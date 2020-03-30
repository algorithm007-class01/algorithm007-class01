/**
 * @param {number} n
 * @return {string[]}
 */
var arr;
var generateParenthesis = function(n) {
    arr = [];
    _generate(0,0,n,'');
    return arr;
};

function _generate(left,right,n,str,){
    //终止条件
        if(left === n &&right ===n){
            arr.push(str)
        }
        if(left<n){
            _generate(left+1,right,n,str+'(');  
        }
        if(right<left){
            _generate(left,right+1,n,str+')');
        }
}
