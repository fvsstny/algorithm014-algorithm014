/*
 * File Name:SearchReverse is created on 2020/9/6 11:19 上午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

/**
 * @author lite
 * @Description: 使用二分查找
 * 由于是由有序数组旋转而  =>  由两段有序数组组成
 * 比较 nums[left] 与 nums[mid]
 * 1.nums[left] > nums[mid]
 * 1.1 target >= n.left && target < n.mid => 在左段, mid - 1 继续迭代
 * 1.2 target >= n.mid  =>  mid + 1 在右段,继续迭代
 * 2.nums[left] > nums[mid]
 * 2.1 target > n.mid && target <= n.right  => 在右段 mid + 1
 * 2.2 target <= n.mid  => mid - 1
 * @date: 2020/9/6 11:19 上午
 * @since JDK 1.8
 */
public class SearchReverse {

    public static void main(String[] args) {

        SearchReverse test = new SearchReverse();
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(test.search(nums, 0));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 判断左右段
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
