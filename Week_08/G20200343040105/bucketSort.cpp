class Solution {
public:
    void bucketSort (vector<int>& vec) {
        int len = vec.size();
        vector<int> buckets(len, 0);
        for (int i = 0; i < eln; ++i) {
            buckets[vec[i]]++;
        }

        int index = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < buckets[i]; ++j) {
                vec[index++] = i;
            }
        }
        return arr;
    }
};