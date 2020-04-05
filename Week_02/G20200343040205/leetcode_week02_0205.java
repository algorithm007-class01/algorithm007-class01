package com.lester.work;

import java.util.*;

public class leetcode_week02_0205 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];

        int [] arr = new int[nums.length-k+1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            arr[i] = max;
        }
        return arr;
    }
}
class Solution {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public void clean(int i,int k){
        if(deq.isEmpty() && deq.getFirst() == i-k){
            deq.removeFirst();
        }

        while(!deq.isEmpty() && nums[i] > nums[deq.getLast()]){
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindows(int[] nums,int k){
        int n = nums.length;
        if(n * k == 0){
            return new int[0];
        }
        int max_idx = 0;
        if(k == 1){
            return nums;
        }

        for(int i = 0;i<k;i++){
            clean(i,k);
            deq.addLast(i);
            if(nums[i]>nums[max_idx]){
                max_idx = i;
            }

        }
        int[] out = new int[n-k+1];
        out[0] = nums[max_idx];

        for(int i = k;i<n;i++){
            clean(i,k);
            deq.addLast(i);
            out[i-k+1] = nums[deq.getFirst()];
        }

        return out;
    }


}

class Solution2 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }
        Map<String,List> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        String []strs = new String []{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }
}
class Solution3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }
}