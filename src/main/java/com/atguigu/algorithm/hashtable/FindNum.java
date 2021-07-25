package com.atguigu.algorithm.hashtable;

import java.util.*;

/**
 * @author: liqi
 * @create 2021-07-25 9:44 PM
 */

public class FindNum {
    /**
     * LeeCode 136. 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    public int singleNumber1(int[] nums){
        // 把遍历到的元素都保存在集合中，出现两次就删除，则最后留下只出现一次的元素
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 查询也需要花费线性时间
            if (list.contains(nums[i])){
                // 填入数字是删除索引
                list.remove(new Integer(nums[i]));
            }else {
                list.add(nums[i]);
            }
        }
        return list.get(0);// 花费 O(n^2)
    }
    public int singleNumber2(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 查找花费常数时间
            if (map.get(nums[i]) != null){
                map.remove(nums[i]);
            }else {
                map.put(nums[i],1);
            }
        }
        return map.keySet().iterator().next(); // 花费 O(n)
    }
    // 使用Set存储
    public int singleNumber3(int[] nums){
        Set set = new HashSet();
        int sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            set.add(nums[i]);
        }
        int sum2 = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            sum2 += (int)iterator.next();
        }
        return sum2 * 2 - sum1;
    }
    // 使用位运算
    public int singleNumber(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
