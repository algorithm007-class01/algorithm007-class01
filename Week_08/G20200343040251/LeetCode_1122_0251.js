/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    if(arr1.length <=0 || arr2.length<=0) return arr1||arr2;
    let res =[];
    let map = new Array(1001).fill(0);
    for(let i=0; i< arr1.length; i++){
        map[arr1[i]]++;
    }
    for(let j=0; j<arr2.length;j++){
        let item = arr2[j];
        let count = map[item];
        while(count>0){
             res.push(item);
             count--;
        };
        map[item] =0;
    }
    for(let k=0; k<map.length;k++){
        let val = map[k];
        while(val >0){
            res.push(k);
            val--;
        }
    }
    return res;
};