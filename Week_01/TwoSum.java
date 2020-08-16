/*
 * File Name:TwoSum is created on 2020/8/12 8:01 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lite
 * @Description: 暴力;hash
 * @date: 2020/8/12 8:01 下午
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum test = new TwoSum();
        System.out.println(Arrays.toString(test.violence(nums, target)));
        System.out.println(Arrays.toString(test.hash(nums, target)));
    }

    public int[] violence(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("无解");
    }

    public int[] hash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (map.containsKey(pair)) {
                return new int[] {map.get(pair), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("无解");
    }
}
