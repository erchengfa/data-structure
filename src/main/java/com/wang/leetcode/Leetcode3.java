package com.wang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode3 {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
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
     * @param
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> cSet =  new HashSet<Character>();
        int left = -1,right=-1;//left 指向窗口最左侧元素，right指向窗口最右侧元素
        for (; left < s.length(); left++){
            if (left != -1){// 左移需要将窗口之外的元素删除
                cSet.remove(s.charAt(left));
            }
            //right+1 未窗口右侧的元素 如果这个元素不包含在窗口里，就需要将其纳入到窗口里，right++
            for (;(right + 1) < s.length() && !cSet.contains(s.charAt(right + 1)); right++){
                cSet.add(s.charAt(right + 1));
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
