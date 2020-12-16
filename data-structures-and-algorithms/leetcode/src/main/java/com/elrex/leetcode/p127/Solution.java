package com.elrex.leetcode.p127;

import com.elrex.leetcode.utils.IO;

import java.util.*;

/**
 * Problem: 127. Word ladder
 * @see <a href="https://leetcode.com/problems/word-ladder/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/12/16.
 */
public class Solution {

    /**
     * Time complexity: O(N * 26 ^ M), where
     *  N is the number of word in the list
     *  26 is english letter.
     *  M is the length of beginWord/endWord
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = beginWord.length();
        int step = 0;

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                char[] chars = word.toCharArray();
                for (int i = 0; i < length; i++) {
                    char recover = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == recover) continue;
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (endWord.equals(newWord)) return ++step;
                        if (!set.contains(newWord)) continue;
                        set.remove(newWord);
                        queue.offer(newWord);
                    }
                    chars[i] = recover;
                }
            }
        }
        return 0;
    }

    /**
     * Time complexity: O(N * 26 ^ (M/2)), where
     *  N is the number of word in the list
     *  26 is english letter.
     *  M is the length of beginWord/endWord
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        if (!set.contains(endWord)) return 0;

        Set<String> head = new HashSet<>();
        Set<String> tail = new HashSet<>();
        head.add(beginWord);
        tail.add(endWord);
        int length = beginWord.length();
        int step = 0;
        while (!head.isEmpty() && !tail.isEmpty()) {
            step++;
            if (head.size() > tail.size()) {
                Set<String> temp = head;
                head = tail;
                tail = temp;
            }
            Set<String> temp = new HashSet<>();
            for (String word : head) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < length; i++) {
                    char recover = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (tail.contains(newWord)) return ++step;
                        if (!set.contains(newWord)) continue;
                        set.remove(newWord);
                        temp.add(newWord);
                    }
                    chars[i] = recover;
                }
            }
            head = temp;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        // Output: 5
        IO.print(solution.ladderLength(beginWord, endWord, wordList));

        IO.print(solution.ladderLength2(beginWord, endWord, wordList));
    }
}
