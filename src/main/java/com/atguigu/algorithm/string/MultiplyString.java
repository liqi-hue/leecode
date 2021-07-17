package com.atguigu.algorithm.string;

/**
 * @author: liqi
 * @create 2021-07-17 15:28
 */

public class MultiplyString {


    /**
     * LeeCode 43 字符串相乘
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * 说明：
     * num1和num2的长度小于110。
     * num1 和num2 只包含数字0-9。
     * num1 和num2均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */
    public String multiply(String num1,String num2){
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        // num1 x num2 把 num1 拆分
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1  = num1.charAt(i) - '0';
            // 设置中间结果 先补0
            StringBuilder corResult = new StringBuilder();
            for (int j = 0; j < num1.length() - 1 - i; j++) {
                corResult.append(0);
            }
            // 相乘
            int n2 = num2.length() - 1;
            while (n2 >= 0){

            }
        }
        return "";
    }

    // 字符串相加的方法
    public String add(String num1,String num2){
        // 从个位开始加，数组最后一个元素开始
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        StringBuilder builder = new StringBuilder();
        // 定义是否进位
        int carry = 0;
        while (n1 >= 0 || n2 >= 0 || carry != 0){
            int i = n1 >= 0 ? num1.charAt(n1)-'0':0;
            int j = n2 >= 0 ? num2.charAt(n2)-'0':0;
            int result = i + j + carry;
            if (result < 10){
                carry = 0;
            }else {
                carry = 1;
            }
            builder.append(result%10);
            n1--;
            n2--;
        }
        return builder.reverse().toString();
    }
}
