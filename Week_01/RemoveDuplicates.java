/*
 * File Name:RemoveDuplicates is created on 2020/8/13 10:35 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

/**
 * @author lite
 * @Description: 有序数组删除重复元素 => 移动不重复元素至左侧(双指针解)
 * @date: 2020/8/13 10:35 下午
 * @since JDK 1.8
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates test = new RemoveDuplicates();
        int[] test1 = {1, 1, 2};
        int[] test2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] test3 = {0, 1, 2, 3, 4, 5};
        System.out.println(test.removeDuplicates(test1));
        System.out.println(test.removeDuplicates(test2));
        System.out.println(test.removeDuplicates(test3));
    }

    public int removeDuplicates(int[] nums) {
        if (null == nums || 0 == nums.length) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                // 避免数组数据全不重复时的无效复制
                if (j - i > 1) {
                    nums[i + 1] = nums[j];
                }
                i++;
            }
        }
        return  i + 1;
    }
}
