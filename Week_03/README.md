# 学习笔记
## 递归
### 递归模板
- 终止条件
- 处理当前层逻辑
- 进入下一层
- 清理当前层

#### 模板代码

```java
public void recur(int level, int param) {
	// terminator
	if	(level > MAX_LEVEL) return;
  
  // process current logic
  process(level, param);
  
  // drill down
  recur(level + 1, param);

  // restore current status
}
```
## 分治
分解子问题 合并结果

```java
Result devideConquer(Problem problem, ...) {
  // terminator
  if (null == problem) return res;
  // prepare data
  Problem[] subProblem = splitProblem(problem);
  // conquer subproblems
  iter sub : subProblem{
  	divideConquer(sub);
  }
  // process and generate final result 比递归多出的一步
  Result res = processResult()
  // resore
  return res;
}
```

## 回溯

- 试错

- 失败后在回退若干步，去尝试其他的分支

- 递归

