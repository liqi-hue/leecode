package com.atguigu.algorithm.slidingwindows;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: liqi
 * @create 2021-07-22 6:47 PM
 */

public class SlidingWindow {

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] max = slidingWindow.getMax(arr, 3);
        System.out.println(Arrays.toString(max));
    }
    /**
     * LeeCode 239. 滑动窗口最大值
     * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
     * 返回滑动窗口中的最大值。
     *
     */
    // 暴力解法 方法超时
    public int[] getMax1(int[] nums,int k){
        int[] arr = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = i + 1; j < k + i; j++) {
                if (max < nums[j]){
                    max = nums[j];
                }
            }
            arr[i] = max;
        }
        return arr;
    }
    // 使用大顶堆优化 方法仍然超时
    public int[] getMax2(int[] nums,int k){
        int[] arr = new int[nums.length - k + 1];
        // 使用大顶堆，优先队列实现,默认是小顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> {return o2 - o1; });
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        arr[0] = maxHeap.peek();
        for (int i = 1; i < nums.length - k + 1; i++) {
            maxHeap.remove(nums[i-1]);
            maxHeap.add(nums[i+k-1]);
            arr[i] = maxHeap.peek();
        }
        return arr;
    }

    // 使用双向队列优化
    public int[] getMax3(int[] nums,int k){
        int[] arr = new int[nums.length - k + 1];
        // 队列保存数组索引,大元素在队首，小元素在队列末尾
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        // 先遍历第一个窗口
        for (int i = 0; i < k; i++) {
            // 把最大的元素放在队列首位，
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        arr[0] = nums[deque.getFirst()];
        // 遍历队尾的元素,即直接判断新添加的元素和弹出的元素
        for (int i = k; i < nums.length; i++) {
            // 弹出元素的索引 i - k, 如果弹出的元素就是最大值，删除最大值
            if (!deque.isEmpty() && i - k == deque.getFirst()){
                deque.removeFirst();
            }
            // 新增的元素是否可以删除队列尾元素
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
            arr[i-k+1] = nums[deque.getFirst()];
        }
        return arr;
    }

    // 左右扫描
    public int[] getMax(int[] nums,int k){
        int len = nums.length;
        int[] arr = new int[len-k+1];
        // 把数组分为块，每个块 k 元素
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            // 左扫描，模 k 为判断是否是每个块的开始位置,如果扫描过程数组的元素大于块的前一个元素则块中保存数组元素，
            // 反之保存块的前一个元素
            if (i % k == 0){
                left[i] = nums[i];
            }else {
                left[i] = nums[i] > left[i-1] ? nums[i] : left[i-1];
            }
            // 右扫描
            int j = len - 1 - i;
            if (j % k == k - 1 || j == len - 1){
                right[j] = nums[j];
            }else {
                right[j] = nums[j] > right[j+1] ? nums[j] : right[j+1];
            }
        }

        // 对每个窗口计算最大值
        for (int i = 0; i < len - k + 1; i++) {
            arr[i] = Math.max(right[i],left[i+k-1]);
        }
        return arr;
    }
}
