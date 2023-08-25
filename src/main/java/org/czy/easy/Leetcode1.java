package org.czy.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author czy
 * @date 2023/08/25
 * @Deprecated 1-两数之和
 **/
public class Leetcode1 {

    /*
      两数之和
      给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
      你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
      你可以按任意顺序返回答案。
      示例 1：
      输入：nums = [2,7,11,15], target = 9
      输出：[0,1]
      解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
      示例 2：
      输入：nums = [3,2,4], target = 6
      输出：[1,2]
      示例 3：
      输入：nums = [3,3], target = 6
      输出：[0,1]
     */

    /**
     * 解题思路:循环遍历数组，先判断传入的最终值减去当前数组元素的key是否存在,
     * 如果不存在则key为当前元素的值,value为当前元素的索引写入到map,用于上面减法运算,
     * 存在则从map中拿着对应的元素值key找到索引，并和当前循环索引值一同返回
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
