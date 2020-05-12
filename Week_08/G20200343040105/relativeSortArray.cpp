//1122. 数组的相对排序

//思路1：暴力遍历，相同元素计数交换
class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        int tmp = 0;
        for (auto a2 : arr2)
            for (auto& a1 : arr1)
                if (a1 == a2) swap(a1, arr1[tmp++]);
        sort(arr1.begin() + tmp, arr1.end());
        return arr1;
    }
};

//思路2：桶排序
class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        vector<int> bucket(1001, 0);
        for (int n : arr1) bucket[n]++;
        int i = 0;
        for (int n : arr2) {
            while (bucket[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for (int n = 0; n < bucket.size(); ++n) {
            while (bucket[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}