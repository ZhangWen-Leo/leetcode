package com.wen.repository.solution0100To0199;

public class Solution0130To0139 {

    /**
     * 135. Candy
     */
    private int[] ratings;
    private int[] candies;
    public int candy(int[] ratings) {
        this.ratings = ratings;
        candies = new int[ratings.length];

        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            count += candy(i);
        }

        return count;
    }
    private int candy(int index) {
        if (candies[index] > 0) {
            return candies[index];
        }

        boolean smallThanLeft = (index == 0 || ratings[index] <= ratings[index - 1]),
                smallThanRight = (index == ratings.length - 1 || ratings[index] <= ratings[index + 1]),
                biggerThanLeft = !smallThanLeft,
                biggerThanRight = !smallThanRight;
        if (smallThanLeft && smallThanRight) {
            candies[index] = 1;
        }
        else if (biggerThanLeft && biggerThanRight) {
            candies[index] = Integer.max(candy(index - 1), candy(index + 1)) + 1;
        }
        else if (biggerThanLeft) {
            candies[index] = candy(index - 1) + 1;
        }
        else {
            candies[index] = candy(index + 1) + 1;
        }

        return candies[index];
    }
}
