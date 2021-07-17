package com.atguigu.algorithm.binarysearch;

/**
 * @author: liqi
 * @create 2021-07-16 9:24
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(arr, 2));
        System.out.println(recursionBinary(arr, 21, 0, arr.length));
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix(matrix, 30));
        System.out.println(solution(matrix,30));
    }

    /**
     *
     * @param arr
     * @param num
     * @return 返回索引
     */
    public static int binarySearch(int[] arr,int num){
        // 定义双指针
        int low = 0;
        int high = arr.length - 1;
        int index = (low + high) / 2;
        while (low <=  high){
            if (num > arr[index]){
                low = index + 1;
                index = (low + high) / 2;
            }else if(num < arr[index]){
                high = index - 1;
                index = (low + high) / 2;
            }else {
                return index;
            }
        }
        return -1;
    }

    /** 递归实现二分查找 */
    public static int recursionBinary(int[] arr,int target,int low,int high){
        if (target < arr[0] || target > arr[arr.length-1] || low > high){
            return -1;
        }
        int index = (low + high) / 2;
        if (target > arr[index]){
            return recursionBinary(arr,target,index+1,high);
        }
        if (target < arr[index]){
            return recursionBinary(arr,target,low,index-1);
        }
        return index;
    }

    /** leecode 74 搜索二维矩阵
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     */
    public static boolean searchMatrix(int[][] matrix,int target){
        // 展开二维数组为一维数组
        int m = matrix.length;
        if (m == 0){
            return false;
        }
        // 转一维数组后 row * n + col = index
        // row = index / n; col = index % n
        int n = matrix[0].length;
        int left = 0;
        int right = m * n -1;
        int index;
        while (left <= right){
            index = (left + right) / 2;
            if (target > matrix[index/n][index%n]){
                left = index + 1;
            }else if (target < matrix[index/n][index%n]){
                right = index - 1;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 自己的思路：取最后一列判断目标值小于哪一个数，则在该行的数组查找
     */
    public static boolean solution(int[][] matrix,int target){
        int m = matrix.length;
        if (m == 0){
            return false;
        }
        int n = matrix[0].length;
        int row=0,col=0;
        boolean isExist = false;
        for (int i = 0; i < m; i++) {
            if (target <= matrix[i][n-1]){
                row = i;
                col = n - 1;
                isExist = true;
                break;
            }
        }
        if (isExist){
            int left = 0;
            int right = col;
            while (left <= right){
                int index = (left + right) / 2;
                if (target > matrix[row][index]){
                    left = index + 1;
                }else if (target < matrix[row][index]){
                    right = index - 1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }

    public static int findDuplicateNum(int[] nums){

        return 0;
    }
}
