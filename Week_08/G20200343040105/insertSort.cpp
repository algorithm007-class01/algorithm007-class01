class Solution {
public:
    void insertSort (int arr[], int len) {
        int preindex, current;
        for (int i = 1; i < len; i++) {
            preindex = i - 1;
            current = arr[i];
            while (preindex >= 0 && arr[preindex] >= current) {
                arr[preindex + 1] = arr[preindex];
                preindex--;
            }
            ara[preindex + 1] = current;
        }
        return arr;
    }
};

/*
写法2：
    for (int i = 1; i < arr.size(); ++i) {
        for (int j = 0; j <= i; ++j) {
            if (arr[i] < arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }


写法3：
    for (int i = 1; i < len; ++i) {
        for (int j = i; j > 0 && arr[j] < arr[j - 1]; --j) {
                std::swap(arr[j], arr[j - 1]);
        }
    }
*/
