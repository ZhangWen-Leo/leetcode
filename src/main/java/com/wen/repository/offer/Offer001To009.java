package com.wen.repository.offer;

import com.wen.dataStructure.ListNode;

public class Offer001To009 {
    /**
     * 05. 替换空格
     */
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                stringBuilder.append("%20");
            }
            else {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 06. 从尾到头打印链表
     */
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        int[] result;
        int count = 0;

        // 数出链表长度
        while (p != null) {
            p = p.next;
            count++;
        }

        result = new int[count];
        p = head;
        for (int i = count-1; i >= 0; i--, p = p.next) {
            result[i] = p.val;
        }

        return result;
    }
}
