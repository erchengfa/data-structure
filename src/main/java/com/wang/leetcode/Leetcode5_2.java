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
 *
 * 解答思路：
 * 状态：dp[i][j] 表示i 到 j之间是否为回文串，s[i...j] 表示i到j之间的字符串
 * 转移方程：dp[i][j] = (s[i] == s[j]) and dp[i+1][j -1]
 * 边界条件：(j+1) - i 代表该串的长度 如果 j+1 - i < 4 (等同 j - i < 3)
 *          说明该串的子串 没有元素 和只有一个元素。
 *          此时只要判断该串的两边的字符是否相等
 *
 */
public class Leetcode5_2 {

    public String longestPalindrome(String s) {
        int n = s.length(); //字符串的长度
        String result = "";
        //定义一个状态的二维数组 用来记录
        boolean[][] dp = new boolean[n][n];

        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (left == right){ //如果当前串只有一个元素
                    dp[left][right] = true;
                }else if (s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                } else {
                    if (right - left < 3){ //如果其字串只有1元素或者0个元素 则当前串是回文数
                        dp[left][right] = true;
                    }else {
                        dp[left][right] = dp[left + 1][right - 1]; //否则由子串决定
                    }
                }
                if (dp[left][right] && result.length() < (right + 1 - left)) {
                    result = s.substring(left, right + 1);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Leetcode5_2 leetcode5_1 = new Leetcode5_2();

        System.out.println("babad".substring(1,4));
        System.out.println(leetcode5_1.longestPalindrome("babad"));
        System.out.println(leetcode5_1.longestPalindrome("cbbd"));
        System.out.println(leetcode5_1.longestPalindrome("a"));
    }

}
