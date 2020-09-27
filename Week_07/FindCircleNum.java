/*
 * File Name:FindCircleNum is created on 2020/9/27 10:37 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lite
 * @Description: 1. dfs
 * 2. bfs
 * 3. unionFind
 * @date: 2020/9/27 10:37 下午
 * @since JDK 1.8
 */
public class FindCircleNum {
    public void findCircleNum(int[][] M) {
        System.out.println(dfs(M));
        System.out.println(bfs(M));

    }

    public int dfs(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                recur(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public void recur(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                recur(M, visited, j);
            }
        }
    }

    public int bfs(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    public int unionFind(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }

    int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    void union(int[] parent, int x, int y) {
        int fx = find(parent, x);
        int fy = find(parent, y);
        if (fx != fy) {
            parent[fx] = fy;
        }
    }

}
