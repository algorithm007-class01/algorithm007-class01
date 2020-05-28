//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组

package leetcode.editor.cn;

import java.util.*;

// 1122. 数组的相对排序
public class RelativeSortArray_1122 {

    //public static void main(String[] args) {
    //    Solution solution = new RelativeSortArray_1122().new Solution();
    //    System.out.println(solution);
    //}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 计数算法
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counter = new int[1001];
        for (int num : arr1) {
            counter[num] += 1;
        }

        int resultIndex = 0;
        for (int num : arr2) {
            while (counter[num] > 0) {
                arr1[resultIndex++] = num;
                counter[num] -= 1;
            }
        }
        for (int i = 0; i < counter.length; i++) {
            int count = counter[i];
            while (count > 0) {
                arr1[resultIndex++] = i;
                count -= 1;
            }
            
        }
        return arr1;
    }

    // 计数 + 链表
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr2Map = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            arr2Map.put(arr2[i], i);
        }

        int[] counter = new int[arr2.length];
        LinkedList<Integer> remains = new LinkedList<>();
        for (int num : arr1) {
            Integer index = arr2Map.get(num);
            if (index != null) {
                counter[index] += 1;
            } else {
                insertIntoRemains(num, remains);
            }
        }

        int resultIndex = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i] > 0) {
                arr1[resultIndex++] = arr2[i];
                counter[i] -= 1;
            }
        }
        for (Iterator<Integer> iterator = remains.iterator(); iterator.hasNext();) {
            arr1[resultIndex++] = iterator.next();
        }
        return arr1;
    }
    private void insertIntoRemains(int num, LinkedList<Integer> remains) {
        boolean insertFlag = true;
        ListIterator<Integer> iterator = remains.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().intValue() >= num) {
                iterator.previous();
                iterator.add(num);
                insertFlag = false;
                break;
            }

        }
        if (insertFlag) {
            remains.add(num);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
