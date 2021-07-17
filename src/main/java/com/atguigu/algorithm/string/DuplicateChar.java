package com.atguigu.algorithm.string;

/**
 * @author: liqi
 * @create 2021-07-17 18:03
 */

public class DuplicateChar {

    public static void main(String[] args) {
        DuplicateChar duplicateChar = new DuplicateChar();
        String s1 = "bcabc";
        String s2 = "cbacdcbc";
        System.out.println(s2.substring(2));
        System.out.println(duplicateChar.duplicate(s1));
        System.out.println(duplicateChar.duplicate(s2));
    }

    /**
     * LeeCode 316. 去除重复字母
     * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
     * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     *                              {f,s,e,a,c,b,t,g,e,r,c,s,a,}
     */
    // 暴力法，贪心，递归
    public String duplicate(String s){

        if (s.length() == 0) return "";
        // position 记为当前最左侧的字符
        int position = 0;
        for (int i = 0; i < s.length(); i++) {
            // 找到下一个比 position 小的字符
            if (s.charAt(i) < s.charAt(position)){
                // 定义一个布尔变量，表示当前i位置的字母是否可以替换position位置的字母
                boolean isReplaceable = true;
                // 遍历i之前的所有字母，判断是否在i后面重复出现
                for (int j = position; j < i; j++) {
                    // 定义一个布尔变量，表示j位置的字母是否重复出现
                    boolean isDuplicated = false;
                    for (int k = i + 1; k < s.length(); k++) {
                        if (s.charAt(k) == s.charAt(j)){
                            isDuplicated = true;
                            break;
                        }
                    }
                    if (!isDuplicated){
                        isReplaceable = false;
                        break;
                    }
                }
                if (isReplaceable){
                    position = i;
                }
            }
        }
        // 遍历结束，position位置的字母就是结果中最左侧的元素
        return s.charAt(position) + duplicate(s.substring(position+1).replaceAll(s.charAt(position) + "", ""));
    }

}
