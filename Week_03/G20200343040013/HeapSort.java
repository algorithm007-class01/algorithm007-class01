
class HeapSort{

    private int[] data;

    private int capacity;

    private int size;

    HeapSort(int k) {
        data = new int[k + 1];
        capacity = k;
        size = 0;
    }

    public boolean insert(int value) {
        if(size > capacity) {
            return false;
        }
        data[size + 1] = value;
        ++size;
        shfitUp(size);
        return true;
    }

    public int removeMax() {
        if (size <= 0) {
            return -1;
        }

        int max = data[1];
        data[1] = data[size];
        size--;
        shiftDown(size);
        return max;
    }

    private void shfitUp(int size) {
        while(size / 2 > 0 && data[size] > data[size / 2]) {
            int tmp = data[size];
            data[size] = data[size / 2];
            data[size / 2] = tmp;
            size /= 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= capacity) {
            int j = 2 * k;
            if (j + 1 <= capacity && data[j] < data[j + 1]) {
                j += 1;
            }

            if (data[k] > data[j]) {
                int tmp = data[k];
                data[k] = data[j];
                data[j] = tmp;
            }
            k = j;
        }
    }
}