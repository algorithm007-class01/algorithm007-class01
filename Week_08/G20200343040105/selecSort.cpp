class Solution {
public:
    void selectSort (int arr[]) {
        int len = arr.size();
        int minindex, temp;
        for (int i = 0; i < len - 1; i++) {
            minindex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minindex]) {
                    minindex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minindex];
            arr[minindex] = temp;
        }
        return arr;
    }
};
