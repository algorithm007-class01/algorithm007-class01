package cxl.study.datastructure.sort;

public class SelectionSort {

    public void selectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
            for (int num : nums) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,24,1,3,4,12,32,56};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

}
