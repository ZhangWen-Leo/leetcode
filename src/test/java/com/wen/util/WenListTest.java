package com.wen.util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WenListTest {

    WenList solution = new WenList();

    @Test
    public void getIntegerListFromString() {
        List<List<Integer>> list = WenList.getListFromString("[[1,null],[2,3],[3,4]]");
        System.out.println(list);
    }
}