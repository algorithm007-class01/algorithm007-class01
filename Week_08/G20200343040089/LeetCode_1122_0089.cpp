//	Relative sorting using the idea of count sorting
class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        int counter[1001] = {0};
        for (int i : arr1) {
            counter[i]++;
        }
        int index = 0;
        for (int i : arr2) {
            while (counter[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        for (int i = 0; i < 1001; ++i) {
            while (counter[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
};