package com.atguigu.algorithm.string;

/**
 * @author: liqi
 * @create 2021-07-17 13:36
 */

public class AddString {

    public static void main(String[] args) {
        AddString addString = new AddString();
        String str1 = "12345";
        String str2 = "98765";
        System.out.println(addString.add(str1,str2));
    }

    /**
     * leecode 415 字符串相加
     *给定两个字符串形式的非负整数num1 和num2，计算它们的和。
     * 提示：
     * num1 和num2的长度都小于 5100
     * num1 和num2 都只包含数字0-9
     * num1 和num2 都不包含任何前导零
     * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
     */
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
