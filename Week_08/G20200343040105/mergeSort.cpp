class Solution {
public:
    void mergeSort (int array[], int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1;

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }
    void merge (int arr[], int left, int mid, int right) {
        int * temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid)   temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }

        //1.复制整个数组a到数组b
        //std::copy(std::begin(a), std::end(a), std::begin(b));

        //2.切片复制数组a到数组b
        /*std::copy(a + src_begin_index,
                    a + src_begin_index + elements_to_copy,
                    b + dest_begin_index);
         */ 
        //std::copy(temp + 1, temp + 4, arr); 即temp数组从下标1开始(包括下标1)，复制3个长度的元素到arr数组中

    }
};  
