package com.example.demo;

/**
 * Description 首页
 *
 * @Author daijinming
 * @Date 2020/3/14 21:24
 **/
public class Two_remove_k {
    //有序数组，向右移动K个元素,n=4,k=2
    public static void main(String[] args) {
        int nums[]={1,2,3,4};
        int temp;
        int k=2;
        int pre;
        for (int j=0;j<k;j++){
            pre=nums[nums.length-1];//pre的这个值要放在循环里面，因为这个是一个变化的值
            for(int i=0;i<nums.length;i++){
                temp=nums[i];
                nums[i]=pre;
                pre=temp;

            }


        }
        for (int i =0;i<nums.length;i++){
            System.out.print(nums[i]);}
        }
    }

