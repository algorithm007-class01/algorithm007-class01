/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    if(m<=0 || !nums1) {
        for(let i=0; i<nums2.length; i++){
            nums1[i] = nums2[i];
        }
        return;
    };
    if(n<=0 || !nums2) return;

    // 从num1尾部开始由大到小排序
    let last = m+n-1;
    let mLast = m-1;
    let nLast = n-1;
    while(mLast>=0 || nLast>=0){
        if(mLast<0){
            nums1[last--] = nums2[nLast--];
            continue;
        }
        if(nLast<0){
            nums1[last--] = nums1[mLast--];
            continue;
        }

        if(nums1[mLast] <= nums2[nLast]){
            nums1[last--] = nums2[nLast--];
        }
        else{
            nums1[last--] = nums1[mLast--];
        }
    }
    
};