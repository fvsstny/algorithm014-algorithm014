/*
 * File Name:MinPathSum is created on 2020/9/20 10:36 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

/**
 * @author lite
 * @Description: dp[i[[j] 为最短路径和; grid[i[[j] 为当前格的值
 * 1. i = 0: dp[i[[j] = dp[i[[j - 1] + grid[i[[j]
 * 2. j = 0; dp[i[[j] =  dp[i - 1[[j] + grid[i[[j]
 * 3. 其他情况 dp[i[[j] = Math.min(dp[i-1[[j], dp[i[[j-1]) + grid[i[[j]
 * @date: 2020/9/20 10:36 下午
 * @since JDK 1.8
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
