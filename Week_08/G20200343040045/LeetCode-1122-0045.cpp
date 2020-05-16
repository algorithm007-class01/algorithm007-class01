#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
   public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        int tmp = 0;
        // 2层遍历，将数据交换到前面
        for (int i = 0; i < arr2.size(); ++i)
            for (int j = 0; j < arr1.size(); ++j) {
                if (arr1[j] == arr2[i]) {
                    swap(arr1[j], arr1[tmp]);
                    ++tmp;
                }
            }
        // 对arr1后面的数据进行排序
        sort(arr1.begin() + tmp, arr1.end());
        return arr1;
    }
};
