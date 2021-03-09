package com.wen.repository.solution0200To0299;

import java.util.*;

public class Solution0210To0219 {

    /**
     * 210. Course Schedule II
     *
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * ai != bi
     * All the pairs [ai, bi] are distinct.
     *
     * 8ms
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] numOfInDegree = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            if (!map.containsKey(prerequisite[1])) {
                map.put(prerequisite[1], new ArrayList<>());
            }
            map.get(prerequisite[1]).add(prerequisite[0]);
            numOfInDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (numOfInDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (queue.isEmpty()) {
                return new int[0];
            }
            res[i] = queue.poll();
            if (map.containsKey(res[i])) {
                for (int num: map.get(res[i])) {
                    if (--numOfInDegree[num] == 0) {
                        queue.offer(num);
                    }
                }
            }
        }

        return res;
    }

    /**
     * 211. Design Add and Search Words Data Structure
     *
     * 见design/WordDictionary
     */

    /**
     * 214. Shortest Palindrome
     */
    public String shortestPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        int palindromeLastIndex = findIndex(s);

        for (int i = s.length()-1; i > palindromeLastIndex; i--) {
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append(s);

        return stringBuilder.toString();
    }
    private int findIndex(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(0)) {
                int a = 0, b = i;
                while (a < b && s.charAt(a) == s.charAt(b)) {
                    a++;
                    b--;
                }
                if (a >= b) {
                    return i;
                }
            }
        }
        return 0;
    }
}
