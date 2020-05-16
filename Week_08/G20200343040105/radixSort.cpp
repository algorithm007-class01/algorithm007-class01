class Solution {
    void radix(int arr[],int len) {   
        int n;  
        for (int i = 1; i <= 100; i = i*10) {
            int tmp[20][10] = {0};
            for(int j = 0; j < len; j++) {
                n = (arr[j] / i) % 10;
                tmp[j][n] = arr[j];
            }
            int k = 0;
            for(int p = 0; p < 10; p++) {
                for(int q = 0; q < size; q++) {
                    if(tmp[q][p] != 0) {
                        arr[k++] = tmp[q][p];
                    }    
                }
            }            
        }
        return arr;
    }
};    
