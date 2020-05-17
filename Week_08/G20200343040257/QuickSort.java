package cxl.study.datastructure.sort;

public class QuickSort {

    public void quickSort(int[] arr,int low,int high){
        if(low >= high){
            return;
        }
        int partition = partition(arr,low,high);
        quickSort(arr,low,partition-1);
        quickSort(arr,partition+1,high);
    }

    private int partition(int[] arr, int low, int high) {
        int flag = high; int startIndex = low;
        for (int i=low; i < high; i++) {
            if (arr[i] < arr[flag]) {
                int temp = arr[i];
                arr[i] = arr[startIndex];
                arr[startIndex] = temp;
                startIndex++;
            }
        }
        int temp = arr[flag]; arr[flag] = arr[startIndex]; arr[startIndex] = temp;
        return startIndex;
    }

    public static void main(String[] args) {
        int[] arr = {3,24,1,3,4,12,32,56};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
