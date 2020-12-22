package com.wen.repository.solution0001To0099;

import java.util.*;

public class Solution0040To0049 {

    /**
     * 40. Combination Sum II
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        return combinationSum2(candidates, target, 0);
    }
    private List<List<Integer>> combinationSum2(int[] candidates, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();

        if (target == 0) {
            result.add(new ArrayList<>());
        }

        if (start < candidates.length && candidates[start] <= target) {
            List<List<Integer>> subLists = combinationSum2(candidates, target - candidates[start], start+1);
            for (List<Integer> subList :
                    subLists) {
                subList.add(0, candidates[start]);
                result.add(subList);
            }

            int next = start+1;
            while (next < candidates.length && candidates[next] == candidates[start]) {
                next++;
            }
            result.addAll(combinationSum2(candidates, target, next));
        }

        return result;
    }

    /**
     * 41. First Missing Positive
     */
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num :
                nums) {
            set.add(num);
        }
        
        int count = 1;
        while (set.contains(count)) {
            count++;
        }
        return count;
    }

    /**
     * 42. Trapping Rain Water
     */
    public int trap(int[] height) {
        List<int[]> list = new ArrayList<>();
        int count = 0, min = 0, i = 0;

        while (i < height.length){
            if (list.isEmpty()) {
                list.add(new int[]{i, height[i]});
                i++;
            }
            else {
                int j = list.size()-1;
                if (list.get(j)[1] <= height[i]) {
                    count += (list.get(j)[1] - min) * (i - list.get(j)[0] - 1);
                    min = list.get(j)[1];
                    list.remove(j);
                }
                else {
                    count += (height[i] - min) * (i - list.get(j)[0] - 1);
                    min = height[i];
                    list.add(new int[]{i, height[i]});
                    i++;
                }
            }
        }

        return count;
    }

    /**
     * 43. Multiply Strings
     */
    private static final int charToInt = -48;
    private static final int intToChar = -charToInt;
    public String multiply(String num1, String num2) {
        String result = "0";
        for (int i = num1.length()-1; i >= 0; i--) {
            char c = num1.charAt(i);
            int num = c + charToInt;
            String singleMulti = multiply(num2, num);
            result = add(result, singleMulti, num1.length() - 1 - i);
        }
        return result;
    }
    public String multiply(String num1, int num2) {
        StringBuilder result = new StringBuilder();
        int add = 0;

        for (int i = num1.length()-1; i >= 0; i--) {
            char c = num1.charAt(i);
            int charNum = c + charToInt;
            int multi = charNum * num2 + add;
            result.insert(0, multi % 10);
            add = multi / 10;
        }
        result.insert(0, add > 0 ? add : "");

        return result.toString();
    }
    public String add(String num1, String num2, int ex) {
        while (ex-- > 0) {
            num2 += "0";
        }
        return add(num1, num2);
    }
    public String add(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length()-1, j = num2.length()-1, add = 0;

        while (i >= 0 && j >= 0) {
            int singleAdd = add(num1.charAt(i), num2.charAt(j)) + add;
            result.insert(0, singleAdd % 10);
            add = singleAdd / 10;
            i--;
            j--;
        }
        if (i >= 0) {
            result.insert(0, add(num1.substring(0, i+1), add));
        }
        else if (j >= 0) {
            result.insert(0, add(num2.substring(0, j+1), add));
        }
        else {
            result.insert(0, add > 0 ? add : "");
        }

        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
    public String add(String num1, int num2) {
        if (num1.length() == 0) {
            return String.valueOf(num2);
        }
        if (num2 == 0) {
            return num1;
        }

        int singleAdd = num1.charAt(num1.length()-1) + charToInt + num2;

        String sub = add(num1.substring(0, num1.length() - 1), singleAdd / 10);

        return (sub.equals("0") ? "" : sub) + (singleAdd % 10);
    }
    public int add(char c1, char c2) {
        return (c1 + charToInt) + (c2 + charToInt);
    }

    /**
     * 44. Wildcard Matching
     */
    private boolean suffix = false;
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.charAt(p.length() - 1) == '*') {
            int end = p.length() - 1;
            while (end > 0 && p.charAt(end - 1) == '*') {
                end--;
            }
            if (end <= 0) {
                return true;
            }
            suffix = true;
            return isMatch(s, p.substring(0, end));
        }

        if (p.charAt(0) == '*') {
            int i = 1;
            while (i < p.length() && p.charAt(i) == '*') {
                i++;
            }
            return isMatchWithPrefix(s, p.substring(i));
        }
        else {
            return isMatchWithoutPrefix(s, p);
        }
    }
    private boolean isMatchWithPrefix(String s, String p) {
        int i = 0, j = 0;
        int count = 0;
        while (i < p.length()) {
            if (p.charAt(i) != '*') {
                count++;
            }
            i++;
        }
        i = 0;
        while (j < s.length() - count + 1) {
            i = 0;
            while (i < p.length() && j + i < s.length()) {
                if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j+i)) {
                    i++;
                }
                else if (p.charAt(i) == '*') {
                    return isMatchWithPrefix(s.substring(j+i), p.substring(i+1));
                }
                else {
                    break;
                }
            }
            if (i >= p.length() && (suffix || j + i >= s.length())) {
                return true;
            }
            j++;
        }
        return false;
    }
    private boolean isMatchWithoutPrefix(String s, String p) {
        int i = 0;
        while (i < s.length() && i < p.length()) {
            if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(i)) {
                i++;
            }
            else if (p.charAt(i) == '*') {
                return isMatchWithPrefix(s.substring(i), p.substring(i+1));
            }
            else {
                return false;
            }
        }
        if (i < s.length()) {
            return suffix;
        }
        else if (i < p.length()) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * 45. Jump Game II
     */
    public int jump(int[] nums) {
        int i = 0, currentMax = 0, count = 0;

        while (currentMax < nums.length - 1) {
            int max = currentMax;
            while (i <= currentMax) {
                max = Integer.max(max, i + nums[i]);
                i++;
            }
            currentMax = max;
            count++;
        }

        return count;
    }

    /**
     * 46. Permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return permute(list);
    }
    private List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> permuteLists = new ArrayList<>();
        if (nums.size() == 0) {
            List<Integer> list = new ArrayList<>();
            permuteLists.add(list);
        }
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            nums.remove(i);
            List<List<Integer>> subLists = permute(nums);
            nums.add(i, val);
            for (List<Integer> list :
                    subLists) {
                list.add(0, val);
                permuteLists.add(list);
            }
        }
        return permuteLists;
    }

    /**
     * 47. Permutations II
     */
    boolean[] check = null;
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        check = new boolean[nums.length];
        this.nums = nums;

        return permuteUnique();
    }
    public List<List<Integer>> permuteUnique() {
        List<List<Integer>> result = new ArrayList<>();

        int i = getFirst();
        if (i == -1) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        while (i < nums.length) {
            if (check[i]) {
                i++;
                continue;
            }
            check[i] = true;
            List<List<Integer>> subLists = permuteUnique();
            for (List<Integer> subList :
                    subLists) {
                subList.add(nums[i]);
            }
            result.addAll(subLists);
            check[i] = false;

            i = getNext(i);
        }

        return result;
    }
    private int getFirst() {
        for (int i = 0; i < nums.length; i++) {
            if (!check[i]) {
                return i;
            }
        }
        return -1;
    }
    private int getNext(int i) {
        int last = i;
        int j = i;
        while (j < nums.length && (check[j] || nums[j] == nums[last])) {
            j++;
        }
        return j;
    }
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        Arrays.sort(nums);
//        List<Integer> list = new ArrayList<>();
//        for (int num :
//                nums) {
//            list.add(num);
//        }
//
//        return permuteUnique(list);
//    }
//    private List<List<Integer>> permuteUnique(List<Integer> nums) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        if (nums.size() == 0) {
//            List<Integer> list = new ArrayList<>();
//            result.add(list);
//            return result;
//        }
//
//        int i = 0;
//        while (i < nums.size()) {
//            int num = nums.get(i);
//            nums.remove(i);
//            List<List<Integer>> subLists = permuteUnique(nums);
//            nums.add(i, num);
//            for (List<Integer> subList :
//                    subLists) {
//                subList.add(0, num);
//            }
//            result.addAll(subLists);
//
//            i++;
//            while (i < nums.size() && nums.get(i) == nums.get(i-1)) {
//                i++;
//            }
//        }
//
//        return result;
//    }

    /**
     * 48. Rotate Image
     */
    public void rotate(int[][] matrix) {
        for (int i = 0; i <= (matrix.length - 1) / 2; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                rotateOne(matrix, i, j);
            }
        }
    }
    private void rotateOne(int[][] matrix, int x, int y) {
        int length = matrix.length;
        int temp = matrix[x][y];


        for (int i = 0; i < 4; i++) {
            int newX = y;
            int newY = length - 1 - x;
            temp += matrix[newX][newY];
            matrix[newX][newY] = temp - matrix[newX][newY];
            temp -= matrix[newX][newY];
            x = newX;
            y = newY;
        }
    }

    /**
     * 49. Group Anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer, Map<Character, Integer>> sets = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            }

            int index = map.hashCode();
            if (sets.get(index) == null) {
                result.add(new ArrayList<>());
                sets.put(index, map);
                indexMap.put(index, result.size() - 1);
            }
            result.get(indexMap.get(index)).add(str);
        }

        return result;
    }
}
