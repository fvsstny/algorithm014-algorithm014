/*
 * File Name:TopK is created on 2020/8/23 1:37 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lite
 * @Description: map存储统计数据;放入大顶堆中排序
 * @date: 2020/8/23 1:37 下午
 * @since JDK 1.8
 */
public class TopK {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        TopK test = new TopK();
        System.out.println(test.topKFrequent(nums, k)   );
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> summary = new HashMap<>();
        for (int num : nums) {
            summary.put(num, summary.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
            new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        maxHeap.addAll(summary.entrySet());

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
