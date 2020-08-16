/*
 * File Name:Trap is created on 2020/8/14 10:15 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

import java.util.Stack;

/**
 * @author lite
 * @Description: 栈 比栈顶小入栈否则将栈顶出栈 算雨水量 ;
 * @date: 2020/8/14 10:15 下午
 * @since JDK 1.8
 */
public class Trap {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Trap test = new Trap();
        System.out.println(test.stack(height));
    }

    public int stack(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            // 当前比栈顶大 要出栈栈顶
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                // 栈顶的高
                int h = height[stack.pop()];
                // 栈空了 入栈当前下标
                if (stack.empty()) {
                    break;
                }
                // 宽 = 当前下标 - 新栈顶下标 - 1
                int dist = i - stack.peek() - 1;
                // 高 = 当前下标的高 与 新栈顶的高的 小值 - 老栈顶的高
                int high = Math.min(height[i], height[stack.peek()]) - h;
                sum += dist * high;
            }
            stack.push(i);
        }
        return sum;

    }
}
