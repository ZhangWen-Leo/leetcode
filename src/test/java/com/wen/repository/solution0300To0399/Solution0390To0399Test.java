package com.wen.repository.solution0300To0399;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Solution0390To0399Test {

    private Solution0390To0399 solution = new Solution0390To0399();

    @Test
    public void calcEquation() {
        List<List<String>> equations = new ArrayList<>();
        List<String> equation1 = new ArrayList<>();
        equation1.add("a");
        equation1.add("b");
        equations.add(equation1);
        List<String> equation2 = new ArrayList<>();
        equation2.add("b");
        equation2.add("c");
        equations.add(equation2);

        double[] values = {2, 3};

        List<List<String>> queries = new ArrayList<>();
        List<String> query = new ArrayList<>();
        query.add("a");
        query.add("c");
        queries.add(query);

        System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));
    }
}