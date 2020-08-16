/*
 * File Name:MoveZeros is created on 2020/8/10 11:26 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

import java.util.Arrays;

/**
 * @author lite
 * @Description: 移动零
 * @date: 2020/8/10 11:26 下午
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] test1 = {0, 1, 0, 3, 12};
        int[] test2 = {1, 3, 12, 0, 0};
        int[] test3 = {0, 0, 0, 0};
        int[] test4 = {};
        MoveZeros test = new MoveZeros();
        test.moveZeros(test1);
        System.out.println(Arrays.toString(test1));
        test.moveZeros(test2);
        System.out.println(Arrays.toString(test2));
        test.moveZeros(test3);
        System.out.println(Arrays.toString(test3));
        test.moveZeros(test4);
        System.out.println(Arrays.toString(test4));
    }

    public void moveZeros(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 != nums[i]) {
                // 记录非0元素
//                nums[i] = nums[i] + nums[j];
//                nums[j] = nums[i] - nums[j];
//                nums[i] = nums[i] - nums[j];
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
