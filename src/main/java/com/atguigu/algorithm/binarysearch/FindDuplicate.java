package com.atguigu.algorithm.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: liqi
 * @create 2021-07-16 21:02
 */

public class FindDuplicate {

    /**leecode 287. 寻找重复数
     * 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
     * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate2(nums));
        System.out.println(findDuplicate3(nums));
    }
    // 寻找数组中的重复数(不满足要求)
    public static int findDuplicate(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return nums[i];
            }
            map.put(nums[i],i);
        }
        return -1;
    }
    // 使用 HashSet (不满足要求)
    public static int findDuplicate2(int[] arr){
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashSet.contains(arr[i])){
                return arr[i];
            }
            hashSet.add(arr[i]);
        }
        return -1;
    }
    // (不满足要求)
    public static int findDuplicate3(int[] arr){
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]){
                return arr[i];
            }
        }
        return -1;
    }

    /** int[] arr = {1, 3, 4, 2, 2}
     *  二分查找思路，设重复的那个目标值为 target
     *
     */


    /**
     *  快慢指针法
     */
}

