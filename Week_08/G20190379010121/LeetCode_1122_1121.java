class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        for(int i = 0; i < arr1.length; i ++){
            bucket[arr1[i]] ++;
        }
        int j = 0;
        for(int i = 0;i < arr2.length; i ++){
            while(bucket[arr2[i]] > 0){
                arr1[j] = arr2[i];
                bucket[arr2[i]] --;
                j ++;
            }
        }
        for(int i = 0;i < bucket.length; i ++){
            while(bucket[i] > 0){
                arr1[j++] = i;
                bucket[i]--;
            }
        }
        return arr1;

    }
}

