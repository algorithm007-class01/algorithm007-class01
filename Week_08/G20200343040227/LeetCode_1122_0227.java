package week8.homework;

/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * 提示：
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class LeetCode_1122_0227 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //因为最大1000
        int[] bucket = new int[1001];
        for (int a1 : arr1) {
            bucket[a1]++;
        }
        int i = 0;
        for (int a2 : arr2) {
            while (bucket[a2]-- > 0) {
                arr1[i++] = a2;
            }
        }
        for (int j = 0; j < 1001; j++) {
            while (bucket[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }
    public static void main(String[] args){
        int[] ints = new LeetCode_1122_0227().relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
    }
}
