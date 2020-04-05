class Solution {
    public int[] plusOne(int[] digits) {
        int p = digits.length-1;
        boolean add = true;
        while(p >= 0 && add){
            int sum1 = digits[p] + 1;
            if(sum1 > 9){
                add = true;
                digits[p--] = sum1 % 10;
            }else{
                add = false;
                digits[p] += 1;
            }
        }
        if(add){
            int[] res = new int[digits.length +1];
            res[0] = 1;
            res[1] = 0;
            for(int i = 2;i < res.length;i ++){
                res[i] = digits[i-1];
            }
            return res;
        }
        return digits;
    }
}