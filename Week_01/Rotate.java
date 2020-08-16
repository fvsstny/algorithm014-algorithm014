/*
 * File Name:Rotate is created on 2020/8/13 10:53 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

import java.util.Arrays;

/**
 * @author lite
 * @Description: 反转3次;
 * @date: 2020/8/13 10:53 下午
 * @since JDK 1.8
 */
public class Rotate {

    public static void main(String[] args) {
        Rotate test = new Rotate();
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        int[] test2 = {-1, -100, 3, 99};
        test.reverseSolv(test1, 3);
        System.out.println(Arrays.toString(test1));
        test.reverseSolv(test2, 2);
        System.out.println(Arrays.toString(test2));
    }

    public void reverseSolv(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
