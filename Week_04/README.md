# 学习笔记

## DFS
```java

public List<List<Integer>> dfs(TreeNode root) {
	List<List<Integer>> result new ArrayList<>();
  if (null == root ) return result;
  recur(root, 0, result);
  return reuslt;
}

private void recur(TreeNode root, int level, List<List<Integer>> result) {
  if (result.size == level) result.add(new ArrayList<>);
  result.get(level).add(root.val);
  if (null != root.left) recur(root.left, level+1, result);
  if (null != root.right) recur(root.right, level+1, result);
}

```

## BFS

队列 缓存一层的  

```java
public List<List<Integer>> bfs(TreeNode root) {
  List<List<Integer>> result = new ArrayList<>();
  if (null == root) return result;
  Queue<TreeNode> queue = new LinkedList<>();
  queue.add(root);
  while(!queue.empty()) {
    int size = queue.size();
    List<Integer> levelResult = new ArrayList<>();
    for (int i = 0; i < sizel i++) {
      TreeNode node = node.poll();
      levelResult.add(node.val);
      if (null != node.left) result.add(node.left);
      if (null != node.right) result.add(node.right);
    }
  }
  return result;
}
```

## 贪心

- 每一次都选择局部最优解，期望能得到最优解，并不一定能得到全局最优
- 不与之前的结果做比对 （动态规划会缓存）
- 一个问题可用贪心法解决，贪心算法一般就是最优解

### 经典处理场景

- 最小生成树
- 赫夫曼编码

## 动态规划 DP

- 拆解问题为子问题，根据子问题的解得到原问题的解
- 会跳过重复的子问题，每个子问题仅处理一次（缓存结果，后续遇到直接查表）



## 二分查找

### 前提

- 目标函数单调递增或递减
- 有上下边界
- 能够通过索引访问

```java
public int binarySearch(int[] array, int target) {
  int left = 0, right = array.length - 1, mid;
  while (left <= right) {
    mid = right - left / 2 + left;
    if (array[mid] == target) return mid;
    else if (array[mid] > target) right = mid -1;
    else left = mid +1;
  }
  return -1
}
```

