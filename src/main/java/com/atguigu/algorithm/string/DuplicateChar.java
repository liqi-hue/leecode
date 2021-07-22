package com.atguigu.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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
        System.out.println(duplicateChar.duplicate3(s1));
        System.out.println(duplicateChar.duplicate3(s2));
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

    // 贪心策略的优化(内存占用高)
    public String duplicate2(String s) {

        if (s.length() == 0) return "";
        // position 记为当前最左侧的字符
        int position = 0;
        // 定义一个数组保存每个字符出现的频率
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            // 先判断是否小于 position 位置的数
            if (s.charAt(i) < s.charAt(position)){
                position = i;
            }
            // 频率只剩下一次就直接退出
            if (--arr[s.charAt(i)-'a'] == 0){
                break;
            }
        }
        return s.charAt(position) + duplicate2(s.substring(position+1).replaceAll(s.charAt(position) + "",""));
    }
    // 使用栈数据结构优化(最优)
    public String duplicate3(String s) {

        Stack<Character> stack = new Stack<>();
        // 保存入栈的元素
        Set<Character> set = new HashSet<>();

        // 保存元素在字符串最后出现的索引
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),i);
        }

        // 遍历字符串，判断每个字符是否需要入栈
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 没有入过栈,直接入栈
            if (!set.contains(c)){
                // 入栈之前判断栈顶元素可否被当前元素替换
                while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > i){
                    // 弹出栈顶元素
                    set.remove(stack.pop());
                }
                stack.push(c);
                set.add(c);
            }

        }
        // 将栈元素保存为字符串输出
        StringBuilder builder = new StringBuilder();
        for (Character character : stack) {
            builder.append(character.charValue());
        }
        return builder.toString();
    }

}
