package com.wen.contest;

import com.wen.dataStructure.ListNode;

import java.util.*;

public class WeeklyContest223 {

    /**
     * 5649. 解码异或后的数组
     */
    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 1; i < result.length; i++) {
            result[i] = encoded[i-1] ^ result[i-1];
        }

        return result;
    }

    /**
     * 5652. 交换链表中的节点
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left, leftBefore, p, right, rightBefore, newHead;
        newHead = new ListNode(0);
        newHead.next = head;
        p = newHead;
        leftBefore = newHead;
        rightBefore = newHead;
        right = head;

        int count = k;
        while (count-- > 0) {
            leftBefore = p;
            p = p.next;
        }
        left = p;
        while (p.next != null) {
            rightBefore = right;
            right = right.next;
            p = p.next;
        }

        if (left == right) {
            return newHead.next;
        }
        else if (left.next == right) {
            left.next = right.next;
            right.next = left;
            leftBefore.next = right;
        }
        else if (right.next == left) {
            right.next = left.next;
            left.next = right;
            rightBefore.next = left;
        }
        else {
            ListNode leftAfter = left.next, rightAfter = right.next;

            leftBefore.next = right;
            right.next = leftAfter;
            rightBefore.next = left;
            left.next = rightAfter;
        }
        return newHead.next;
    }

    /**
     * 5650. 执行交换操作后的最小汉明距离
     */
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Set<Integer>> sets = new ArrayList<>();

        for (int[] swap:
             allowedSwaps) {
            int a = swap[0], b = swap[1];
            if (!map.containsKey(a) && !map.containsKey(b)) {
                Set<Integer> set = new HashSet<>();
                set.add(a);
                set.add(b);
                map.put(a, set);
                map.put(b, set);
                sets.add(set);
            }
            else if (map.containsKey(a) && map.containsKey(b)) {
                Set<Integer> setA = map.get(a), setB = map.get(b);
                if (setA != setB) {
                    for (Integer numInB :
                            setB) {
                        map.put(numInB, setA);
                    }
                    sets.remove(setB);
                    setA.addAll(setB);
                }
            }
            else if (map.containsKey(a)) {
                Set<Integer> set = map.get(a);
                set.add(b);
                map.put(b, set);
            }
            else {
                Set<Integer> set = map.get(b);
                set.add(a);
                map.put(a, set);
            }
        }

        int count = 0;
        for (Set<Integer> indexSet :
                sets) {
            Map<Integer, Integer> numCountMap = new HashMap<>();
            for (Integer index :
                    indexSet) {
                numCountMap.put(source[index], numCountMap.getOrDefault(source[index], 0) + 1);
            }
            for (Integer index :
                    indexSet) {
                if (numCountMap.getOrDefault(target[index], 0) > 0) {
                    count++;
                    numCountMap.put(target[index], numCountMap.get(target[index]) - 1);
                }
            }
        }
        return target.length - count;
    }

    /**
     * 5639. 完成所有工作的最短时间
     */
    public int minimumTimeRequired(int[] jobs, int k) {
        return 0;
    }
}
