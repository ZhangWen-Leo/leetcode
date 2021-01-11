package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0160To0169 {
    /**
     * 160. Intersection of Two Linked Lists
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        ListNode tailA = null, tailB = null;
        Boolean swappedA = false, swappedB = false;

        while (pA != pB) {
            if (pA.next == null) {
                if (!swappedA) {
                    tailA = pA;
                    pA = headB;
                    swappedA = true;
                    if (swappedB && tailA != tailB) {
                        return null;
                    }
                }
            }
            else {
                pA = pA.next;
            }

            if (pB.next == null) {
                if (!swappedB) {
                    tailB = pB;
                    pB = headA;
                    swappedB = true;
                    if (swappedA && tailA != tailB) {
                        return null;
                    }
                }
            }
            else {
                pB = pB.next;
            }
        }

        return pA;
    }

    /**
     * 161. One Edit Distance
     */
    public boolean isOneEditDistance(String s, String t) {
        int sLength = s.length(), tLength = t.length();

        if (Math.abs(sLength - tLength) > 1) {
            return false;
        }
        if (sLength == tLength) {
            int i = 0;
            while (i < s.length() && s.charAt(i) == t.charAt(i)) {
                i++;
            }
            return i < s.length()
                    && s.substring(0, i).equals(t.substring(0, i))
                    && s.substring(i+1, sLength).equals(t.substring(i+1, tLength));
        }
        else {
            int length;
            String minS, maxS;
            if (sLength < tLength) {
                length = sLength;
                minS = s;
                maxS = t;
            }
            else {
                length = tLength;
                minS = t;
                maxS = s;
            }
            int i = 0;
            while (i < length && minS.charAt(i) == maxS.charAt(i)) {
                i++;
            }
            return i >= length
                    || (minS.substring(0, i).equals(maxS.substring(0, i))
                    && minS.substring(i, length).equals(maxS.substring(i+1, length+1)));
        }
    }

    /**
     * 162. Find Peak Element
     *
     * 1 <= nums.length <= 1000
     * -231 <= nums[i] <= 231 - 1
     * nums[i] != nums[i + 1] for all valid i.
     */
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length);
    }
    private int findPeakElement(int[] nums, int start, int end) {
        int middle = (start + end) / 2;

        if (middle > 0 && nums[middle] < nums[middle-1]) {
            return findPeakElement(nums, start, middle);
        }
        else if (middle < nums.length - 1 && nums[middle] < nums[middle+1]) {
            return findPeakElement(nums, middle+1, end);
        }
        else {
            return middle;
        }
    }

    /**
     * 163. Missing Ranges
     *
     * -109 <= lower <= upper <= 109
     * 0 <= nums.length <= 100
     * lower <= nums[i] <= upper
     * All the values of nums are unique.
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        int left = lower, right;
        for (int i = 0; i < nums.length; i++) {
            right = nums[i] - 1;
            if (left < right) {
                result.add(left + "->" + right);
            }
            else if (left == right) {
                result.add("" + left);
            }

            left = nums[i] + 1;
        }
        right = upper;
        if (left < right) {
            result.add(left + "->" + right);
        }
        else if (left == right) {
            result.add("" + left);
        }

        return result;
    }

    /**
     * 164. Maximum Gap
     */
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i+1] - nums[i]);
        }

        return max;
    }

    /**
     * 165. Compare Version Numbers
     */
    public int compareVersion(String version1, String version2) {
        int start1 = 0, start2 = 0;

        while (start1 < version1.length() || start2 < version2.length()) {
            int ver1 = 0, ver2 = 0;
            if (start1 < version1.length()) {
                int end = start1 + 1;
                while (end < version1.length() && version1.charAt(end) != '.') {
                    end++;
                }
                ver1 = Integer.valueOf(version1.substring(start1, end));
                start1 = end + 1;
            }
            else {
                ver1 = 0;
            }
            if (start2 < version2.length()) {
                int end = start2 + 1;
                while (end < version2.length() && version2.charAt(end) != '.') {
                    end++;
                }
                ver2 = Integer.valueOf(version2.substring(start2, end));
                start2 = end + 1;
            }

            if (ver1 < ver2) {
                return -1;
            }
            else if (ver1 > ver2) {
                return 1;
            }
        }

        return 0;
    }

    /**
     * 166. Fraction to Recurring Decimal
     */
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0) && numerator != 0) {
            result.append('-');
        }
        long nu = numerator;
        long de = denominator;
        nu = Math.abs(nu);
        de = Math.abs(de);
        result.append(nu / de);
        long left = nu % de;
        List<Long> numeratorList = new ArrayList<>();
        List<Long> resultList = new ArrayList<>();
        boolean circle = false;
        int circleStart = 0;

        while ((left *= 10) > 0) {
            int index = numeratorList.indexOf(left);
            if (index >= 0) {
                circle = true;
                circleStart = numeratorList.indexOf(left);
                break;
            }

            numeratorList.add(left);
            resultList.add(left / de);
            left = left % de;
        }

        if (resultList.size() > 0) {
            result.append('.');
        }

        if (circle) {
            for (int i = 0; i < circleStart; i++) {
                result.append(resultList.get(i));
            }
            result.append('(');
            for (int i = circleStart; i < resultList.size(); i++) {
                result.append(resultList.get(i));
            }
            result.append(')');
        }
        else {
            for (int i = 0; i < resultList.size(); i++) {
                result.append(resultList.get(i));
            }
        }

        return result.toString();
    }
}
