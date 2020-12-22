package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.ListNode;
import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution0140To0149 {

    /**
     * 140. Word Break II
     */
    Set<String> wordSet;
    List<String>[] wordResults;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        wordResults = new List[s.length()];

        return wordBreak(s, 0);
    }
    private List<String> wordBreak(String s, int start) {
        if (wordResults[start] != null) {
            return wordResults[start];
        }
        List<String> result = new ArrayList<>();

        for (int i = start; i <= s.length(); i++) {
            String subString = s.substring(start, i);
            if (wordSet.contains(subString)) {
                if (i == s.length()) {
                    result.add(subString);
                }
                else {
                    List<String> subWordResults = wordBreak(s, i);
                    if (subWordResults.size() > 0) {
                        for (String subWordResult :
                                subWordResults) {
                            result.add(subString + " " + subWordResult);
                        }
                    }
                }
            }
        }

        wordResults[start] = result;
        return result;
    }

    /**
     * 141. Linked List Cycle
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head.next, slow = head;
        int fastStep = 2, slowStep = 1;

        while (fast != slow) {
            int step;

            step = fastStep;
            while (step-- > 0) {
                if (fast == null) {
                    return false;
                }
                fast = fast.next;
            }

            step = slowStep;
            while (step-- > 0) {
                if (slow == null) {
                    return false;
                }
                slow = slow.next;
            }
        }

        return true;
    }

    /**
     * 142. Linked List Cycle II
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head.next, slow = head, result = head;
        int fastStep = 2, slowStep = 1;

        while (fast != slow) {
            int step;

            step = fastStep;
            while (step-- > 0) {
                if (fast == null) {
                    return null;
                }
                if (fast == result) {
                    return result;
                }
                if (fast == slow) {
                    break;
                }
                fast = fast.next;
            }

            if (fast == slow) {
                break;
            }
            step = slowStep;
            while (step-- > 0) {
                if (slow == null) {
                    return null;
                }
                slow = slow.next;
            }
        }

        while (true) {
            result = result.next;
            do {
                if (fast == result) {
                    return result;
                }
                fast = fast.next;
            } while (fast != slow);
        }
    }

    /**
     * 143. Reorder List
     */
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j - 1) {
            list.get(j-1).next = null;
            list.get(j).next = list.get(i+1);
            list.get(i).next = list.get(j);
            i++;
            j--;
        }
    }
    public void reorderList_2(ListNode head) {
        ListNode tail, p = head;
        if (p == null) {
            return;
        }
        tail = p.next;
        if (tail == null) {
            return;
        }
        while (tail.next != null) {
            p = tail;
            tail = tail.next;
        }

        p.next = null;
        tail.next = head.next;
        head.next = tail;
        reorderList_2(tail.next);
    }

    /**
     * 144. Binary Tree Preorder Traversal
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            list.add(root.val);
            list.addAll(preorderTraversal(root.left));
            list.addAll(preorderTraversal(root.right));
        }
        return list;
    }

    /**
     * 145. Binary Tree Postorder Traversal
     */
    List<Integer> postorderList;
    public List<Integer> postorderTraversal(TreeNode root) {
        postorderList = new ArrayList<>();
        postOrderTraversal(root);
        return postorderList;
    }
    private void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            postorderList.add(root.val);
        }
    }

    /**
     * 146. LRU Cache
     *
     * 见design/LRUCache
     */

    /**
     * 147. Insertion Sort List
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode sentry = new ListNode(0);
        ListNode current, next = head;

        while (next != null) {
            current = next;
            next = next.next;
            ListNode insertPoint = sentry;

            while (insertPoint.next != null && current.val >= insertPoint.next.val) {
                insertPoint = insertPoint.next;
            }
            current.next = insertPoint.next;
            insertPoint.next = current;
        }

        return sentry.next;
    }

    /**
     * 148. Sort List
     *
     * The number of nodes in the list is in the range [0, 5 * 10^4].
     * -10^5 <= Node.val <= 10^5
     *
     * 解法1
     * 6 ms     37.41%
     * 46.6 MB  5.04%
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        else if (head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;

        while (fast != null && (fast = fast.next) != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode p = slow.next;
        slow.next = null;

        return mergeList(sortList(head), sortList(p));
    }
    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);

        ListNode p1 = l1, p2 = l2, p = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            }
            else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 == null) {
            p.next = p2;
        }
        else {
            p.next = p1;
        }

        return head.next;
    }
//    /**
//     * 超时
//     */
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        return mySortList(head)[0];
//    }
//    public ListNode[] mySortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return new ListNode[]{head, head};
//        }
//
//        ListNode smallerAndSame = new ListNode(0), sTail = smallerAndSame;
//        ListNode bigger = new ListNode(0), bTail = bigger;
//
//        for (ListNode p = head.next; p != null; p = p.next) {
//            if (p.val <= head.val) {
//                sTail.next = p;
//                sTail = sTail.next;
//            }
//            else {
//                bTail.next = p;
//                bTail = bTail.next;
//            }
//        }
//        sTail.next = null;
//        bTail.next = null;
//
//        ListNode[] smallerSort = mySortList(smallerAndSame.next);
//        ListNode[] biggerSort = mySortList(bigger.next);
//
//        if (smallerSort[0] == null) {
//            head.next = biggerSort[0];
//            return new ListNode[]{head, biggerSort[1]};
//        }
//        else {
//            smallerSort[1].next = head;
//            head.next = biggerSort[0];
//            return new ListNode[]{smallerSort[0], biggerSort[1] == null ? head : biggerSort[1]};
//        }
//    }


}
