public class InsertionSort {
    public int[] insertion(int[] array) {
        int len = array.length;
        int preIndex;
        int currNum;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            currNum = array[i];
            while (preIndex >= 0 && array[preIndex] > currNum) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = currNum;
        }
        return array;
    }
}
