package com.wen.contest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class WeeklyContest232 {

    /**
     * 5701. 仅执行一次字符串交换能否使两个字符串相等
     */
    public boolean areAlmostEqual(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) {
            return false;
        }

        int count = 0;
        char need1 = ' ', need2 = ' ';
        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (count == 0) {
                    count++;
                    need1 = s2.charAt(i);
                    need2 = s1.charAt(i);
                }
                else if (count == 1) {
                    count++;
                    if (need1 != s1.charAt(i) || need2 != s2.charAt(i)) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        return count != 1;
    }

    public int findCenter(int[][] edges) {
        int[] edge1 = edges[0], edge2 = edges[1];
        int a = edge1[0], b = edge1[1];
        int c = edge2[0], d = edge2[1];

        if (a == c || a == d) {
            return a;
        }
        else if (b == c || b == d) {
            return b;
        }
        return 0;
    }

    class ClassPass {
        int pass;
        int sum;
        double priority;

        public ClassPass(int pass, int sum) {
            this.pass = pass;
            this.sum = sum;
            this.priority = getPriority(pass, sum);
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        if (classes.length == 1) {
            return passRate(classes[0], extraStudents);
        }
        PriorityQueue<ClassPass> queue = new PriorityQueue<>(new Comparator<ClassPass>() {
            @Override
            public int compare(ClassPass o1, ClassPass o2) {
                if (o1.priority == o2.priority) {
                    return o1.sum - o2.sum;
                }
                else if (o1.priority < o2.priority) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });

        for (int[] o: classes) {
            queue.offer(new ClassPass(o[0], o[1]));
        }

        while (extraStudents > 0) {
            ClassPass min = queue.poll();
            double nextPriority = queue.peek().priority;
            do {
                extraStudents--;
                min.sum++;
                min.pass++;
                min.priority = getPriority(min.pass, min.sum);
            } while (extraStudents > 0 && min.priority >= nextPriority);
            queue.offer(min);
        }
        double res = 0;
        for (ClassPass classPass: queue) {
            res += passRate(classPass.pass, classPass.sum);
        }
        return res / classes.length;
    }
    private double passRate(int[] o, int add) {
        return passRate(o[0], o[1], add);
    }
    private double passRate(int pass, int sum) {
        return passRate(pass, sum, 0);
    }
    private double passRate(int pass, int sum, int add) {
        return (double) (pass + add) / (sum + add);
    }
    private double getPriority(int pass, int sum) {
        return (double) (sum - pass) / (sum * (sum + 1));
    }

    public int maximumScore(int[] nums, int k) {
        int len = nums.length;

        int res = nums[k];
        int min = nums[k];
        int i = k, j = k;
        while (i > 0 || j < len - 1) {
            if (i > 0 && nums[i - 1] >= min) {
                i--;
            }
            else if (j < len - 1 && nums[j + 1] >= min) {
                j++;
            }
            else {
                res = Math.max(res, (j - i + 1) * min);
                if (i > 0 && j < len - 1) {
                    min = Math.max(nums[i - 1], nums[j + 1]);
                }
                else if (i > 0) {
                    min = nums[i - 1];
                }
                else {
                    min = nums[j + 1];
                }
            }
        }
        res = Math.max(res, (j - i + 1) * min);

        return res;
    }

}
