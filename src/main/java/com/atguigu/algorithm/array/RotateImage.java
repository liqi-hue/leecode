package com.atguigu.algorithm.array;

/**
 * @author: liqi
 * @create 2021-07-15 20:30
 */

public class RotateImage {
    /**
     * leecode 48. 旋转图像
     *给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * */
    public static void main(String[] args) {
        int[][] image1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] image2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(image1);
        rotate(image2);
        rotate2(image1);
        rotate2(image2);
        rotate3(image1);
        rotate3(image2);
    }
    // 转置，互换
    private static void rotate(int[][] matrix){
        // 矩阵为 n x n
        int len = matrix.length;
        // 反转矩阵，对角线不变，对称的元素互换
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 左右互换
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    // 方法二，分治
    public static void rotate2(int[][] matrix){
        int len = matrix.length;
        // 把矩阵分为四块 以左上为例,长边水平,短边竖直
        // 行列转换关系 列变为行 旧行与新列相加为 len-1
        for (int i = 0; i < len/2 + len%2; i++) {
            for (int j = 0; j < len/2; j++) {
                // 找到每一个点其他三个区域对应的位置
                int[] temp = new int[4];
                int row = i;
                int col = j;
                for (int k = 0; k < 4; k++) {
                    temp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = len - 1 - x;
                }
                // 经过循环一圈 row col 不变
                // 将每个点旋转90度
                for (int k = 0; k < 4; k++) {
                    matrix[row][col] = temp[(k+3)%4];
                    int x = row;
                    row = col;
                    col = len - 1 - x;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    // 方法三，优化方法二
    public static void rotate3(int[][] matrix){
        int len = matrix.length;
        for (int i = 0; i < (len+1) / 2; i++) {
            for (int j = 0; j < len / 2; j++) {
                // 直接逆着旋转四个点  列变为行 旧行与新列相加为 len-1
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
                matrix[j][len-1-i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
