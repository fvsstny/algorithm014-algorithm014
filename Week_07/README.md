# 学习笔记
## 字典树 trie树
- 应用于统计(搜索引擎词频统计)和排序大量字符串
- 可以减少大量无意义的字符串比较,比hash表更快
### 基本性质
- 节点本身不存完整的单词
- 根节点到某一个节点的所有边的字符连接起来就是目标节点的字符串值
- 每个节点到左右子节点的边的字符串值都不同

## 并查集
专门用于解决组团 配对问题

### 模板

```java
public class UnionFind {
    private int count = 0;
    private int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }

}
```

## 高级搜索
对朴素搜索进行优化
### 优化方向
- 不重复(斐波那契数列)
- 剪枝(括号生成)
### 搜索方向
- DFS
- BFS
- 双向
- 启发式搜索
## 高级树
### AVL

- 平衡的
- 节点要存平衡因子 （额外的存储空间）
- 4种旋转
- 树的调整很频繁

#### 平衡因子
- 右子树的高度减去左子树的高度
- 在 -1 0 1 之间
#### 旋转操作
保持树的平衡

- 左旋：右右子树
- 右旋：左左子树
- 左(+)右旋：左右子树
- 右(+)左旋：右左子树

![image-20200927231410798](/Users/lite/Library/Application Support/typora-user-images/image-20200927231410798.png)

### 红黑树

- 近似平衡
- 任一节点的左右子树高度差小于两倍

#### 要满足的条件

- 每个节点有颜色，红或黑
- 根是黑
- 每个叶子节点(空节点)，黑色
- 红节点不能相邻
- 任一节点到叶子节点的路径中包含相同个数的黑节点

### AVL 红黑树对比

- 查询：AVL查询更快（严格平衡的）
- 删改：红黑树 插入删除更快（AVL旋转操作很多）
- 空间：AVL更费空间 （每个节点都需要一个integer的空间来存储因子或高度）
- 应用：红黑树作为编程语言库的基本数据结构中；AVL应用在DB中（对查询速度要求高）



