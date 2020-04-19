public class HalfFound {

    public static void main(String[] args) {
        System.out.println(halfLocal());
    }

    public static int halfLocal() {
        int[] array = new int[]{4, 5, 6, 7, 0, 1, 2};

        int start = 0;
        int end = array.length - 1;
        int half = array.length / 2;
        // 终止条件 这个值比任何2边任何的值都小
        while (array[half] <= array[start] && array[half] <= array[end]) {

            // 判断左边是否有序
            if (array[half] >= start) {
                start = array[half];
            } else {
                end = array[half];
            }
        }
        return array[half + 1];
    }
}
