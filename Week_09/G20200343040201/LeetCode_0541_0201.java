public class LeetCode_0541_0201 {

    public String reverseStr(String s, int k) {
        char[] charArr = s.toCharArray();
        int p = 0;
        while (true) {
            if (p + 2 * k - 1 < charArr.length) {
                reverse(charArr, p, p + k - 1);
                p = p + 2 * k;
            } else if (p + k - 1 < charArr.length) {
                reverse(charArr, p, p + k - 1);
                break;
            } else {
                reverse(charArr, p, charArr.length - 1);
                break;
            }
        }
        return new String(charArr);
    }

    private void reverse(char[] arr, int begin, int end) {
        while (begin < end) {
            char tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;
            begin++;
            end--;
        }
    }

}
