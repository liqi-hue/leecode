package com.atguigu.algorithm.array;

import java.util.Arrays;

/**
 * @author: liqi
 * @create 2021-07-14 20:47
 */

public class Arrangement {
    /**
     * leecode 31. 下一个排列
     *实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。()
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * 必须 原地 修改，只允许使用额外常数空间。
     */
    public static void main(String[] args) {
        arrangement(new int[]{1,3,2,5,8,3,1});
    }

    // 给定一个数组,求下一个大的排列(把数组看成多位数，即求比他大的下一个多位数排列)
    public static void arrangement(int[] nums){
        if (nums.length > 1){
            int len = nums.length - 1;
            // 如果是降序(从后往前看)直接交换最后两个元素
            if (nums[len-1] < nums[len]){
                swap(nums,len-1,len);
                System.out.println(Arrays.toString(nums));
                return;
            }
            // 思路，从后往前找到数组升序子序列(正着看是降序的)然后交换子序列前的一个元素
            int last = len - 1;
            while (last >= 0 && nums[last] >= nums[last+1]){
                last--;
            }
            int target = last;
            // 如果是最大排列直接反转
            if (last == -1){
                reverse(nums,0,len);
                System.out.println(Arrays.toString(nums));
                return;
            }
            // 找到刚好比last 大的索引
            last++;
            while (last < len+1 && nums[target] < nums[last]){
                // last 为刚好比 target 大的索引的后一个
                last++;
            }
            swap(nums,target,last-1);
            // target 索引之后的元素升序排列（之前是降序）使用双指针交换
            reverse(nums,target+1,nums.length-1);
            System.out.println(Arrays.toString(nums));
        }else {
            System.out.println(Arrays.toString(nums));
        }
    }
    // 交换两数
    public static void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    // 双指针交换
    public static void reverse(int[] nums,int start,int end){
        int temp;
        while (start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
