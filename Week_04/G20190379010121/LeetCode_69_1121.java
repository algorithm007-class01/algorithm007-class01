class Solution {
    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        return mySqrt(x,2,x/2);
    }
    //二分查找
    private int mySqrt(int x,int left,int right){
        if(left > right){
            return right;
        }
        int mid = left + (right - left)/2;
        //相乘整形会溢出，要转型
        long res = (long)mid * mid;
        if(res == x ){
            return mid;
        }else if(res > x){
            return mySqrt(x,left,mid-1);
        }else{
            return mySqrt(x,mid +1,right);
        }
    }


}