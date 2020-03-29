//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//示例:
//    给定 nums = [2, 7, 11, 15], target = 9
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//链接：https://leetcode-cn.com/problems/two-sum


//3种实现思路：
//0、如果数组有序前提下，课采用此类解法，时间空间复杂度，最优
//1、暴力求解，循环，
//2、两边hash求解，典型的空间换时间，a+b=c, 换位，a=c-b ，因为a、b均在数组中，那么意味着，数组中每个数都有一个对应的值
//3、针对2的优化，主要体现了每次遍历时候即可进行匹配和数组值得映射

/**
 * 采用思路3：不开辟新数组 时间复杂度：O(n),空间复杂度：O(1)
 * 1、使用两个指针，快指针和慢指针，起始位置指针位置为0
 * 2、快指针扫描数组，遇非0元素，则将值放到慢指针的位置，快、慢指针+1
 * 3、重复上述步骤2，直至快指针到数组结尾，
 * 4、将慢指针后面的元素全部归0
 *
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        twoSum3(nums);
    }

    // 方法一：暴力法，for循环依次求解
    // 时间复杂度O(n^2) 空间复杂度O(1)
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] > target) break;
                if(nums[j] > target) continue;
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];

    }
    // 方法二：两边hash求解，空间换时间，a+b=c, 换位，a=c-b ，因为a、b均在数组中，那么意味着，数组中每个数都有一个对应的值
    // 那么先遍历数组，求出每个值的对应的另一个数，这种一对一可以用hashmap做映射，
    // 时间复杂度O(n) 空间复杂度O(n),针对于方法一解法，此解法是典型的空间换时间
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(target - nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            // 找到自己另一半，但不能是自己
            if(hashMap.containsKey(nums[i]) && hashMap.get(nums[i]) != i){
                return new int[]{i,hashMap.get(nums[i])};
            }
        }

        return null;
    }

    // 方法三：一遍hash求解，
    // 针对方法二，发现，实际每次遍历时候，都需要排除自己，
    // 那么如果第一次遍历时候，将自己存放在映射关系，那么后续遍历可以直接使用，无需再次开启遍历进行匹配
    // 时间复杂度O(n) 空间复杂度O(n),
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int who = target - nums[i];
            if(hashMap.containsKey(who)){
                // 如果匹配，即之前遍历已经有另一半了
                return new int[]{hashMap.get(who),i};
            }
            hashMap.put(nums[i],i);
        }

        return new int[0];
    }

    // 不符合题意，舍去，排序后改变下标位置
    // 如果题意中，元素有序情况，此种解法可用
    // 时间复杂度O(n) 空间复杂度O(1),
    public int[] twoSum0(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return nums;
        }

        // 排序
        //Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        boolean yes = false;
        while (start < end){
            if(nums[start]  > target){
                break;
            }
            if(nums[end] > target){
                end--;
            }
            int sum = nums[start] + nums[end];
            if(sum == target){
                yes = true;
                break;
            }
            if(sum > target){
                end--;
            }else {
                start++;
            }
        }
        int[] result = yes?new int[]{start,end}:new int[]{};
        System.out.println(Arrays.toString(result));
        return result;
    }

}