/*
 * File Name:LRUCache is created on 2020/10/3 11:17 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author lite
 * @Description: hash表 + 双向链表
 * 1.get
 *  1.1 key存在 删除该节点 并放到队首;
 *  1.2 key不存在 直接返回-1
 * 2.put
 *  2.1 key不存在 新建node 并放到队首 增加size 并判断是否超过capacity,超过需要移除队尾元素
 *  2.2 key存在 更新value 删除后重新插入队首
 * @date: 2020/10/3 11:17 下午
 * @since JDK 1.8
 */
public class LRUCache {
    private Map<Integer, LinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        move2head(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            node = new LinkedNode(key, value);
            cache.put(key, node);
            add2head(node);
            ++size;
            if (size > capacity) {
                LinkedNode curTail = removeTail();
                cache.remove(curTail.key);
                --size;
            }
        } else {
            node.value = value;
            move2head(node);
        }
    }

    private void move2head(LinkedNode node) {
        removeNode(node);
        add2head(node);
    }

    private void removeNode(LinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void add2head(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private LinkedNode removeTail() {
        LinkedNode curTail = tail.prev;
        removeNode(curTail);
        return curTail;
    }

    static class LinkedNode {
        int key;
        int value;

        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
