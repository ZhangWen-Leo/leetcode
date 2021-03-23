package com.wen.repository.solution0300To0399.design;

import java.util.Iterator;
import java.util.List;

/**
 * 341. Flatten Nested List Iterator
 *
 * TODO 待优化
 */
public class NestedIterator implements Iterator<Integer> {

    private int current;
    private List<NestedInteger> nestedList;
    private NestedIterator subIterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        current = 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            System.out.println("没有下一个了");
            return -1;
        }

        if (subIterator != null) {
            if (subIterator.hasNext()) {
                return subIterator.next();
            }
            else {
                subIterator = null;
            }
        }

        NestedInteger currentNode = nestedList.get(current);
        if (currentNode.isInteger()) {
            current++;
            return currentNode.getInteger();
        }
        else {
            subIterator = new NestedIterator(currentNode.getList());
            current++;
            if (subIterator.hasNext()) {
                return subIterator.next();
            }
            else {
                subIterator = null;
                return next();
            }
        }
    }

    @Override
    public boolean hasNext() {
        if (subIterator != null && subIterator.hasNext()) {
            return true;
        }
        if (current >= nestedList.size()) {
            return false;
        }

        for (int i = current; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                return true;
            }
            else {
                if ((new NestedIterator(nestedList.get(i).getList())).hasNext()) {
                    return true;
                }
            }
        }

        return false;
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

