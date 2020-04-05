package com.example.demo;

/**
 * Description 首页
 *
 * @Author daijinming
 * @Date 2020/3/14 14:29
 **/
public class Two_delete_common {
    //去掉重复的元素，返回数据的长度
    public static void main(String[] args) {
        int  nums[]={1,2,3,3,4,4,5};
        int p=0;
        int q=1;
        if (nums.length==0){
            return ;
        }
        while(q<nums.length){
            if(nums[p]!= nums[q]) {
                nums[p+1]=nums[q];
                p++;
                }
                q++;
            }
            for (int j=0;j<p+1;j++){
                System.out.print(nums[j]);
            }
        }






    }



