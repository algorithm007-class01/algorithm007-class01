class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> heap = new PriorityQueue<Integer>();
        for(int i = 0, len = arr.length;i < len;i ++){
            heap.add(arr[i]);
        }
        int[] res = new int[k];
        for(int i = 0;i < k;i ++){
            res[i] = heap.poll();
        }
        return res;
    }
}