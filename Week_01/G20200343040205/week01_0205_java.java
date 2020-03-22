package com.lester.work;


import java.util.*;

public class leetcode {


    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return nums.length;
        int i = 0;
        for(int j = 1;j <nums.length;j++){
            if(nums[j] != nums[i]){
                i ++;
                nums[i] = nums[j];
            }
        }
        return i +  1;



    }
    static class Solution {
        public int maxArea(int[] a) {
            //解法1 双循环 O(n^2)
//            int max = 0;
//            for (int i = 0; i < a.length; i++) {
//                for (int j = i + 1; j < a.length; j++) {
//                    int high = Math.min(a[j], a[i]);
//                    int area = (j - i) * high;
//                    max = Math.max(area, max);
//                }
//
//            }
//            return max;
            int max = 0;
            for (int i = 0, j = a.length - 1; i < j; ) {
                int high;
                if (a[i] < a[j]) {
                    high = a[i];
                    i++;
                } else {
                    high = a[j];
                    j--;
                }
                int weight = j - i + 1;
                max = Math.max(max, weight * high);
            }
            return max;
        }
    }

//    public static int removeDuplicates(int[] nums) {
//        if (nums.length == 0) return 0;
//        int i = 0;
//        for (int j = 1; j < nums.length; j++) {
//            if (nums[j] != nums[i]) {
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//        return i + 1;
//    }

    public static int[] moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }

    public static int climbStairs(int n) {
        if (n < 3) return n;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;

            int i = k + 1, j = nums.length - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }

            }
        }
        return result;
    }

//
//    public List<List<Integer>>  threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<>();
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (nums[i] > 0) break;
//            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            int a = i + 1, b = nums.length - 1;
//            while (a < b) {
//                int sum = nums[i] + nums[a] + nums[b];
//                if (sum < 0) {
//                    while (a < b && nums[a] == nums[++a]) ;
//                } else if (sum > 0) {
//                    while (a < b && nums[b] == nums[--b]) ;
//                } else {
//                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[a], nums[b])));
//                    while (a < b && nums[a] == nums[++a]) ;
//                    while (a < b && nums[b] == nums[--b]) ;
//                }
//            }
//        }
//
//        return result;
//    }
//    int[] a =new int [] {-1, 1,1};
////        Solution solution = new Solution();
////        int max = solution.maxArea(a);
////
////        List<List<Integer>> lists = threeSum(a);
//    int b = removeDuplicates(a);
//
//    ListNode listNode = null;
//    listNode.val = 1;
//
//    String a =  "2020-03-10";
//    ZoneId zoneId = ZoneId.systemDefault();
//    Date start = Date.from(LocalDate.parse(a).plusDays(1).atStartOfDay(zoneId).toInstant());
//



    public static void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            arr[(k+i)%nums.length] = nums[i];
        }

        for(int j = 0;j < arr.length;j++){
            nums[j] = arr[j];
        }
    }

    public static void main(String[] args) {
//        int[] b ={1,2,3,4,5,6,7};
//        int c = 3;
//        rotate(b,c);
//

        int a = 1;
        int b = 3;
        int c = 4;
        b %= c;
        int i = (a + b) % c;
        System.out.println(i);
    }


}
