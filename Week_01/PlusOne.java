/*
 * File Name:PlusOne is created on 2020/8/13 9:42 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

import java.util.Arrays;

/**
 * @author lite
 * @Description:
 * @date: 2020/8/13 9:42 下午
 * @since JDK 1.8
 */
public class PlusOne {

    public static void main(String[] args) {
        PlusOne test = new PlusOne();
        int[] test1 = {1, 2, 3};
        int[] test2 = {1, 2, 9};
        int[] test3 = {9, 9, 9};

        System.out.println(Arrays.toString(test.plusOne(test1)));
        System.out.println(Arrays.toString(test.plusOne(test2)));
        System.out.println(Arrays.toString(test.plusOne(test3)));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (0 != digits[i]) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
