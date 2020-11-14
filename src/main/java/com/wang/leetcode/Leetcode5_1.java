package com.wang.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Leetcode5_1 {

    public String longestPalindrome(String s) {
        if (s == null && s.length()<0){
            return "";
        }

        int sIndex = 0;
        int eIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i );//奇数长度
            int len2 = expandAroundCenter(s, i, i + 1 );//奇数长度
            int len = Math.max(len1, len2);
            if (len > (eIndex - sIndex)){
                sIndex = i - (len-1)/2;
                eIndex = i + len/2;
            }
        }

        return s.substring(sIndex, eIndex + 1);

    }

    /**
     * 返回扩散后回文子串的长度
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Leetcode5_1 leetcode5_1 = new Leetcode5_1();
        System.out.println(leetcode5_1.longestPalindrome("babad"));
        System.out.println(leetcode5_1.longestPalindrome("cbbd"));
        System.out.println(leetcode5_1.longestPalindrome("a"));
    }

}
