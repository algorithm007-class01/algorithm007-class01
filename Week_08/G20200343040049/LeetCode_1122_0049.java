class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] dict = new int[1001];
        int[] res = new int[arr1.length];

        for (int i = 0; i < arr1.length;++i) {
            dict[arr1[i]]++;
        }

        // 根据arr2的顺序，填充res数组
        int idx = 0;
        for (int i = 0; i < arr2.length; ++i) {
            while (dict[arr2[i]] > 0) {
                res[idx++] = arr2[i];
                dict[arr2[i]]--;
            }
        }
        // 把arr2中没有的元素填充到res数组
        for (int num = 0; num < dict.length; ++num) {
            while (dict[num] > 0) {
                res[idx++] = num;
                dict[num]--;
            }
        }

        return res;
    }
}