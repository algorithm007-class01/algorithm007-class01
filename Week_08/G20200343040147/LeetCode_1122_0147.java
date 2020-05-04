import java.util.Arrays;

public class LeetCode_1122_0147 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[1001];
        int[] result = new int[arr1.length];
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            res[arr1[i]]++;
        }
        int index = 0;
        for (int j = 0; j < arr2.length; j++) {
            int tmp = res[arr2[j]];
            for (int k = 0; k < tmp; k++) {
                result[index + k] = arr2[j];
            }
            index += (tmp);
            res[arr2[j]] = 0;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (res[arr1[i]] != 0) {
                result[index] = arr1[i];
                res[arr1[i]]--;
                index++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] res = new LeetCode_1122_0147().relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }
}
