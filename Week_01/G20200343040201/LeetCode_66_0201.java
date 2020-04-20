class LeetCode_66_0201 {
    public int[] plusOne(int[] digits) {
        //因为开篇就要对最后一个数做加1的操作作为触发，所以此处需要判空以及对数组长度做一个判断
        if (digits == null || digits.length == 0) return digits;

        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1]++;
            } else {
                break;
            }
        }

        if (digits[0] == 10) {
            /**
             * 如果最后，第一个数等于10，也就是需要进位。
             * 这个需要新建一个长度加1的新数组作为结果了。
             */
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            return newArr;
        } else {
            return digits;
        }
    }
}