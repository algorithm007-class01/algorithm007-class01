class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2){
            return true;
        }
        return isPerfectSquare(num,2,num/2);
    }
    private boolean isPerfectSquare(int num,int left,int right){
        if(left > right){
            return false;
        }
        int mid = left + (right-left ) /2;
        //相乘整形会溢出，要转型
        long res =  (long)mid * mid;
        if(res == num){
            return true;
        }else if(res > num){
            return isPerfectSquare(num,left,mid-1);
        }else {
            return isPerfectSquare(num,mid+1,right);
        }
    }

}