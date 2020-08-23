/*
 * File Name:UglyNumber is created on 2020/8/22 3:58 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

import java.util.PriorityQueue;

/**
 * @author lite
 * @Description: 丑数 = 2^x * 3^y * 5^z (xyz 可以为0,1也是丑数)
 * @date: 2020/8/22 3:58 下午
 * @since JDK 1.8
 */
public class UglyNumber {

    public static void main(String[] args) {
        UglyNumber test = new UglyNumber();
        System.out.println(test.heap(12));
        System.out.println(test.dp(12));
    }

    public int heap(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        long cur = 0L;
        heap.add(1L);
        while (n > 0) {
            if (heap.peek() != cur) {
                cur = heap.poll();
                n--;
                heap.add(cur * 2);
                heap.add(cur * 3);
                heap.add(cur * 5);
            } else {
                heap.poll();
            }
        }
        return (int)cur;
    }

    public int dp(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = res[p2] * 2, n3 = res[p3] * 3, n5 = res[p5] * 5;
            res[i] = Math.min(Math.min(n2, n3), n5);
            if (res[i] == n2) {
                p2++;
            }
            if (res[i] == n3) {
                p3++;
            }
            if (res[i] == n5) {
                p5++;
            }
        }
        return res[n - 1];
    }
}
