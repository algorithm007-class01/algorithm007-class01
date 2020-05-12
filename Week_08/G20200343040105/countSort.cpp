class Solution {
public:
    void countSort (int arr[], int maxValue) {
        int bucket = new int [maxValue + 1];
        int sortedindex = 0, arrlen = arr.size(), bucketlen = maxValue + 1;

        for (int i = 0; i < arrlen; ++i) {
            if (!bucket[arr[i]]) {
                bucket[arr[i]] = 0;
            }
            bucket[arr[i]]++;
        }

        for (int j = 0; j < bucketlen; ++j) {
            while (bucket[j] > 0) {
                arr[sortedindex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }
};