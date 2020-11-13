package com.wang.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表的运用:
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Leetcode1 {

    /**
     *   定义一个Map 【key：数组的值 value：索引】;
     *   遍历数组 如果目标元素（target-nums[i]）不存在于Map中，将其放入Map;
     *   如果Map中存在，则直接返回;
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) { //过滤掉第一个元素
                int value = target - nums[i];// nums[i]所对应的目标元素
                if (tempMap.get(value) != null){ // 如果value存在于map中 就说明找到了目标元素
                    return new int[]{tempMap.get(value),i};
                }
            }
            tempMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Leetcode1 leetcode1 = new Leetcode1();
        int[] twoSum = leetcode1.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(twoSum));
    }

}
