package cxl.study.datastructure.sort;

/**
 * 插入排序
 */
public class InsertSort {

    public static  void sort(int[] arrays){
        if(arrays.length<=1){
            return;
        }
        for (int i = 1; i < arrays.length; i++) {
            int temp = arrays[i];
            int j = i -1;
            for (; j >=0; j--) {
                if(arrays[j]>temp){
                    arrays[j+1] = arrays[j];
                }else {
                    break;
                }
            }
            arrays[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ints = {2,4,5,1,2,4,7,33,2};
        InsertSort.sort(ints);
        for (int i : ints) {
            System.out.print(i+" ");
        }
    }

}
