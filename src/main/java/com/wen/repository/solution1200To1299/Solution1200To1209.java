package com.wen.repository.solution1200To1299;

import com.wen.util.UnionFind;

import java.util.*;

public class Solution1200To1209 {

    /**
     * 1202. Smallest String With Swaps
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }
        int len = s.length();

        UnionFind unionFind = new UnionFind(len);

        for (List<Integer> pair :
                pairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }

        char[] chars = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            if (map.containsKey(root)) {
                map.get(root).offer(chars[i]);
            }
            else {
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(chars[i]);
                map.put(root, minHeap);
            }
        }

        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            chars[i] = map.get(root).poll();
        }

        return String.copyValueOf(chars);
    }

    /**
     * 1203. Sort Items by Groups Respecting Dependencies
     */
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        return null;
    }

    /**
     * 1207. Unique Number of Occurrences
     * 1 <= arr.length <= 1000
     * -1000 <= arr[i] <= 1000
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int[] index = new int[arr.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = 1001;
        }
        for (Integer key:
                map.keySet()) {
            if (index[map.get(key)] < 1001) {
                return false;
            }
            else {
                index[map.get(key)] = key;
            }
        }
        return true;
    }
}
