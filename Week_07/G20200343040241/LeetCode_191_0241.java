
/**
 *给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class LeetCode_191_0241 {


    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1')
                count++;
        }
        return count;
    }


    public static void main(String[] args) {
        LeetCode_191_0241 leetCode = new LeetCode_191_0241();
        System.out.println(leetCode.hammingWeight(00000000000000000000000000001011));
    }
}
