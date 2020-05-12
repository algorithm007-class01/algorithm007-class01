class Solution {
public:
    void shellSort (int arr[], int len) {
        for (int gap = len >> 1; gap > 0; gap >>= 1) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j >= gap && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = current;
            }
        }
        return arr;
    }
};
