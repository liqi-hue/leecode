package com.atguigu.algorithm.slidingwindows;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liqi
 * @create 2021-07-23 2:50 PM
 */

public class MinWindowSubstring {

    /**
     *LeeCode 76. 最小覆盖子串
     *给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
     * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
     * 只需要包含 t 中所有的字符，考虑重复字符
     */

    // 暴力法
    public String minWindow1(String s, String t){
        String targetStr = "";
        // 先把子串字符出现次数统计
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
        }
        // 拿到所有可能的子串,开始索引
        for (int i = 0; i <= s.length()-t.length(); i++) {
            // 结束索引
            for (int j = i+t.length()-1; j < s.length(); j++) {
                Map<Character,Integer> temp = new HashMap<>();
                // 遍历子串，统计字符出现次数
                for (int k = i; k <= j; k++) {
                    temp.put(s.charAt(k),temp.getOrDefault(s.charAt(k),0) + 1);
                }
                // 与目标子串字符数比较,并考虑替换
                if (test(map,temp) && (targetStr == "" || targetStr.length() > j - i + 1)){
                    targetStr = s.substring(i,j+1);
                }
            }
        }
        return targetStr;
    }

    // 滑动窗口解法
    public String minWindow2(String s, String t){
        String targetStr = "";
        // 先把子串字符出现次数统计
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
        }
        // 定义左右子串的索引
        int start = 0,end = t.length()-1;
        while (end < s.length()){
            Map<Character,Integer> temp = new HashMap<>();
            // 遍历子串，统计字符出现次数(这一步可以优化)
            for (int k = start; k <= end; k++) {
                temp.put(s.charAt(k),temp.getOrDefault(s.charAt(k),0) + 1);
            }
            // 与目标子串字符数比较,并考虑替换
            if (test(map,temp)){
                // 满足覆盖子串继续判断
                if (targetStr == "" || targetStr.length() > end - start + 1){
                    targetStr = s.substring(start,end+1);
                }
                start++;
            }else {
                // 不是覆盖子串则扩大窗口
                end++;
            }
        }
        return targetStr;
    }

    // 滑动窗口解法优化
    public String minWindow3(String s, String t){
        String targetStr = "";
        if (t.length() > s.length()){
            return "";
        }
        // 先把子串字符出现次数统计
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
        }
        // 定义左右子串的索引
        int start = 0,end = t.length()-1;
        // 每次只需要修改 Map 的数据即可，不用遍历整个子串
        Map<Character,Integer> temp = new HashMap<>();
        // 遍历子串，统计字符出现次数
        for (int k = start; k <= end; k++) {
            temp.put(s.charAt(k),temp.getOrDefault(s.charAt(k),0) + 1);
        }
        while (end < s.length()){
            // 与目标子串字符数比较,并考虑替换
            if (test(map,temp)){
                // 满足覆盖子串继续判断
                if (targetStr == "" || targetStr.length() > end - start + 1){
                    targetStr = s.substring(start,end+1);
                }
                temp.put(s.charAt(start),temp.get(s.charAt(start))-1);
                start++;
            }else {
                // 不是覆盖子串则扩大窗口
                end++;
                if (end < s.length()){
                    temp.put(s.charAt(end),temp.getOrDefault(s.charAt(end),0)+1);
                }
            }
        }
        return targetStr;
    }

    // 滑动窗口再次优化(略。。。)
    public String minWindow(String s, String t){

        return "";
    }

    // 判断两个map中保存的字符频次
    public boolean test(Map<Character,Integer> target,Map<Character,Integer> temp){
        for (Character character : target.keySet()) {
            if (temp.getOrDefault(character,-1) < target.get(character)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinWindowSubstring substring = new MinWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(substring.minWindow(s,t));
    }
}
