# 学习笔记

## 线性表
数据排成线形的结构,数据之间只有前后关系
### 数组
- 一组连续的内存空间,存储一组相同类型的数据
- 访问时可根据下标随机访问 O(1)
- 插入删除需要相应的搬移剩余元素 平均时间复杂度 (1(在最后插入) + ... + n(在最前插入)) / n = O(n)

### 链表
- 通过指针将一组零散的内存连接起来,对连续的内存空间要求不高
- 插入删除操作 仅需操作指针指向 O(1)
- 不支持随机访问 O(n)

### 跳表
- 在基础的有序链表之上增加了索引层(升维的方式对低维数据结构进行加速)
- 插入/删除/查找 都是O(log n)


### 栈
- 先进后出
- 添加删除O(1) 查询O(n)

### 队列
- 先进先出
- 添加删除O(1) 查询O(n)
#### 双端队列
- 两端都可进出

# 作业
## 分析Queue和PriorityQueue源码
### Queue
- 在Java中作为队列的基础抽象,定义为了接口

#### 方法
- add: 添加元素进入队列,成功返回true;失败将抛出IllegalStateException;会检测容量
- offer: 添加元素,失败返回false不会报错

- peek: 查询,返回队首元素,队列为空会返回null
- element: 查询,返回队首元素;队列空抛出异常

- poll: 取出队首元素,队列空返回null
- remove: 取出队首元素;队列空抛出异常

### PriorityQueue
- 小顶堆,无序
- 出/入队就是堆元素的删除/插入
- 非线程安全
#### 主要属性
- Object[] queue                存储元素
- int size                      元素个数
- Comparator<E> comparator      比较器
- int DEFAULT_INITIAL_CAPACITY  默认容量
- int modCount                  修改次数
####方法
- 入队:add offer:相同,add里调用了offer;插入元素时 先找到父元素 跟父元素比较大小,直到比父节点大
- 出队:remove poll:remove调用了poll;删除队首元素,并重新堆化
- 扩容:grow
- 取队首元素: element peek:element 会报错, peek不会
