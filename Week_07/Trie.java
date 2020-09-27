/*
 * File Name:Trie is created on 2020/9/21 10:57 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

/**
 * @author lite
 * @Description: 下一节点的next数组 + 表示最后一级的isEnd标志
 * @date: 2020/9/21 10:57 下午
 * @since JDK 1.8
 */
public class Trie {

    private final Trie[] next;
    private boolean isEnd;

    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    public void insert(String word) {
        if (null == word || 0 == word.length()) {
            return;
        }

        Trie curr = this;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int n = c - 'a';
            if (null == curr.next[n]) {
                curr.next[n] = new Trie();
            }
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }

    /**
     * word 是否在trie树内
     *
     * @param word
     *
     * @return
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return null != node && node.isEnd;
    }

    /**
     * trie树里是否有prefix开头的任意词
     *
     * @param prefix
     *
     * @return
     */
    public boolean startWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return null != node;
    }

    public Trie searchPrefix(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            node = node.next[c - 'a'];
            if (null == node) {
                return null;
            }
        }
        return node;
    }
}
