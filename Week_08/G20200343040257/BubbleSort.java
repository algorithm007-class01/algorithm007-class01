package cxl.study.datastructure.sort;

public class BubbleSort {

    public void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if(j+1 < nums.length-1 && nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,24,1,3,2,4,1,12,32,56};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

}
