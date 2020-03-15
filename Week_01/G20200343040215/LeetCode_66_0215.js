/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    if (digits === null || digits.length < 1) return [1];
	if (digits.length === 0 && digits[0] === 0) return [1];
    let flag =  true;//进位标志
    for(let i = digits.length-1; i>=0; i--){
        if(flag){
            digits[i] +=1;
            flag=false;
        }
        
        if(digits[i]<=9){
            return digits;
        }
        else{
            digits[i] = 0;
            flag= true;
        }
    }

    if(flag){
        digits.unshift(1);
    }
    return digits;
};