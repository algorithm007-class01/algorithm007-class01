package Week_01;

public class LeetCode_66_0215 {
    public int[] plusOne(int[] digits) {
        //index>=0，向上进位index--；
        int index = digits.length-1;
        while(true){
            digits[index]++;
            if(digits[index]>9){
                digits[index]=0;
                index--;
            }else{
                return digits;
            }
            //最高位进位，只能是10000；
            if(index==-1){
                digits  = new int[digits.length+1];
                digits[0]=1;
                return digits;
            }

        }
    }
}
