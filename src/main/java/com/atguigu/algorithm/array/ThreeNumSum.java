package com.atguigu.algorithm.array;


import java.util.*;

/**
 * @author: liqi
 * @create 2021-07-14 8:35
 */

public class ThreeNumSum {

    /**LeeCode 15 三数之和
     *给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
     * 使得a + b + c = target ？请你找出所有和为 target 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     */

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        Arrays.sort(arr);
        System.out.println(test(arr, 0));
        System.out.println(optimization(arr, 0));
        System.out.println(twoPointer(arr, 0));

    }

    /** 暴力解法,未去重 */
    public static List<List<Integer>> test(int[] arr, int target){
        List<List<Integer>> list = new ArrayList<>();
        int len = arr.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (arr[i] + arr[j] + arr[k] == target){
                        list.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    }
                }
            }
        }
        return list;
    }

    /** 优化 有  bug */
    public static List<List<Integer>> optimization(int[] arr,int target){
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = target - arr[i];
            // 拿到一组解
            if (map.containsKey(temp)){
                ArrayList<Integer> list = new ArrayList<>(map.get(temp));
                list.add(arr[i]);
                result.add(list);
            }

            for (int j = 0; j < i; j++) {
                // 以两数之和作为 key
                int newKey = arr[i] + arr[j];
                // 如果 Key 不存在，直接添加进去
                if (!map.containsKey(newKey)){
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(arr[i]);
                    arrayList.add(arr[j]);
                    map.put(newKey,arrayList);
                }
            }
        }
        return result;
    }

    /** 优化 双指针法 {2， 4， 1， 6， 8， 3， 6} 要求数组已排序*/

    public static List<List<Integer>> twoPointer(int[] arr,int target){
        List<List<Integer>> result = new ArrayList<>();
        int center;             // 核心指针,作为最小值
        int left;      // 左指针，在核心指针右边
        int right; // 右指针
        for (int i = 0; i < arr.length-2; i++) {// 核心指针到倒数第三个索引就行
            // 核心数大于目标值直接退出
            if (arr[i] > target) break;
            if (i > 0 && arr[i] == arr[i-1]){
                //  有核心指针相同的元素可以直接跳过本次循环
                continue;
            }
            center = i;
            left = center + 1;
            right = arr.length - 1;
            while (left < right){
                if (arr[left] + arr[center] + arr[right] > target){
                    right--;
                }else if(arr[left] + arr[center] + arr[right] < target){
                    left++;
                }else if (arr[left] + arr[center] + arr[right] == target){
                    result.add(Arrays.asList(arr[left],arr[center],arr[right]));
                    left++;
                    right--;
                    // 同核心下，左右指针移动之后值相同(三种情况)也跳过
                    while (left < right && arr[left] == arr[left-1]) left++;
                    while (left < right && arr[right] == arr[right+1]) right--;
//                    if (left-1>=0 && right+1<arr.length && arr[left] == arr[left-1] && arr[right] == arr[right+1]){
//                        left++;
//                        right--;
//                        continue;
//                    }
                }
            }
        }
        for (List<Integer> list : result) {
            list.sort((o1,o2) -> o1 - o2);
        }
        return result;
    }
}
