package com.atguigu.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liqi
 * @create 2021-06-26 15:16
 */

public class TwoNumSum {
    /**
     * 给定一个整数数组 nums和一个整数目标值 target，
     * 请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * @param args
     */
    public static void main(String[] args) {
        getIndex(new int[]{23,12,47,42,69,84},126);
    }
    public static void getIndex(int[] arr,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = target - arr[i];
            if (map.containsKey(temp)){
                System.out.println("[" + map.get(temp) + "," + i + "]");
                return;
            }
            map.put(arr[i],i);
        }
    }
}
