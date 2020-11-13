package com.wang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode3 {

    /**
     * 思路：
     * 这道题主要用到思路是：滑动窗口
     *
     * 什么是滑动窗口？
     *
     * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，
     * 当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
     *
     * 如何移动？
     *
     * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     *
     * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
     *
     * 时间复杂度：O(n)O(n)
     *
     * 作者：powcai
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> cSet =  new HashSet<Character>();
        int left = 0,right=0; //窗口的左右指针 该指针直接的元素始终是不重复的， 当出现了重复的则窗口左移【left++】
        for (; left < s.length(); left++){
            if (left != 0){// 左移需要将窗口之外的元素删除
                cSet.remove(s.charAt(left-1));
            }
            for (;right < s.length() && !cSet.contains(s.charAt(right)); right++){
                cSet.add(s.charAt(right));
            }
            int newLength = right - left;
            if (maxLength < newLength){
                maxLength = newLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        System.out.println(leetcode3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(leetcode3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(leetcode3.lengthOfLongestSubstring("pwwkew"));

    }

}
