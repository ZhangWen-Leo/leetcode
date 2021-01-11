package com.wen.repository.solution0300To0399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0390To0399 {

    /**
     * 399. Evaluate Division
     */
    private double[][] equationsDp;
    private boolean[][] haveSetDp;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<String> variables = new ArrayList<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            if (!variables.contains(a)) {
                variables.add(a);
            }
            if (!variables.contains(b)) {
                variables.add(b);
            }
        }
        int length = variables.size();
        equationsDp = new double[length][length];
        haveSetDp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            setEquationsDp(i, i, 1);
        }

        for (int k = 0; k < equations.size(); k++) {
            List<String> equation = equations.get(k);
            int i = variables.indexOf(equation.get(0));
            int j = variables.indexOf(equation.get(1));

            setEquationsDp(i, j, values[k]);
        }

        double[] result = new double[queries.size()];
        for (int k = 0; k < queries.size(); k++) {
            List<String> query = queries.get(k);
            int i = variables.indexOf(query.get(0));
            int j = variables.indexOf(query.get(1));

            if (i < 0 || j < 0) {
                result[k] = -1;
            }
            else {
                if (haveSetDp[i][j]) {
                    result[k] = equationsDp[i][j];
                }
                else {
                    result[k] = -1;
                }
            }
        }

        return result;
    }
    private void setEquationsDp(int x, int y, double value) {
        equationsDp[x][y] = value;
        haveSetDp[x][y] = true;
        equationsDp[y][x] = 1.0 / value;
        haveSetDp[y][x] = true;

        int length = equationsDp.length;
        for (int i = 0; i < length; i++) {
            if (haveSetDp[i][x] && !haveSetDp[i][y]) {
                setEquationsDp(i, y, equationsDp[x][y] * equationsDp[i][x]);
            }
            if (haveSetDp[y][i] && !haveSetDp[x][i]) {
                setEquationsDp(x, i, equationsDp[x][y] * equationsDp[y][i]);
            }
        }
    }
}
