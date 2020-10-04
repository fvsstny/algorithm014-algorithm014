/*
 * File Name:ReversePairs is created on 2020/10/3 11:20 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

/**
 * @author lite
 * @Description: 归并思想:
 * 1.拆分子问题
 * 2.合并结果集时统计翻转对个数
 * @date: 2020/10/3 11:20 下午
 * @since JDK 1.8
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - 1) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        int[] cache = new int[end - start + 1];
        int i = start, t = start, c = 0;
        for (int j = mid + 1; j <= end; j++, c++) {
            while (i <= mid && nums[i] <= 2 * (long)nums[j])
                i++;
            while (t <= mid && nums[t] < nums[j])
                cache[c++] = nums[t++];
            cache[c] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid)
            cache[c++] = nums[t++];
        System.arraycopy(cache, 0, nums, start, end - start + 1);
        return count;
    }
}
