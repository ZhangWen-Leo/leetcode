package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.ListNode;
import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0140To0149 {

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
}
