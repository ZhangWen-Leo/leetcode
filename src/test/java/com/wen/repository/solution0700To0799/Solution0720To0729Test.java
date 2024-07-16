package com.wen.repository.solution0700To0799;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Solution0720To0729Test {
	Solution0720To0729 solution = new Solution0720To0729();

	@Test
	public void accountsMerge1() {
		List<String> john1 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
		List<String> john2 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
		List<String> mary = Arrays.asList("Mary", "mary@mail.com");
		List<String> john3 = Arrays.asList("John", "johnnybravo@mail.com");
		List<List<String>> input = Arrays.asList(john1, john2, mary, john3);

		List<List<String>> output = solution.accountsMerge(input);

		Assert.assertEquals(3, output.size());
		Assert.assertArrayEquals(new String[]{"John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"},
			output.get(0).toArray());
		Assert.assertArrayEquals(new String[]{"Mary", "mary@mail.com"},
			output.get(1).toArray());
		Assert.assertArrayEquals(new String[]{"John", "johnnybravo@mail.com"},
			output.get(2).toArray());
	}

	@Test
	public void accountsMerge3() {
		List<String> david1 = Arrays.asList("David", "David0@m.co", "David1@m.co");
		List<String> david2 = Arrays.asList("David", "David3@m.co", "David4@m.co");
		List<String> david3 = Arrays.asList("David", "David4@m.co", "David5@m.co");
		List<String> david4 = Arrays.asList("David", "David2@m.co", "David3@m.co");
		List<String> david5 = Arrays.asList("David", "David1@m.co", "David2@m.co");
		List<List<String>> input = Arrays.asList(david1, david2, david3, david4, david5);

		List<List<String>> output = solution.accountsMerge(input);

		Assert.assertEquals(1, output.size());
		Assert.assertArrayEquals(new String[]{"David", "David0@m.co", "David1@m.co", "David2@m.co", "David3@m.co",
				"David4@m.co", "David5@m.co"},
			output.get(0).toArray());
	}

	@Test
	public void accountsMerge4() {
		List<String> Alex = Arrays.asList("Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co");
		List<String> Ethan = Arrays.asList("Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co");
		List<String> Kevin = Arrays.asList("Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co");
		List<String> Gabe1 = Arrays.asList("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co");
		List<String> Gabe2 = Arrays.asList("Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co");
		List<List<String>> input = Arrays.asList(Alex, Ethan, Kevin, Gabe1, Gabe2);

		List<List<String>> output = solution.accountsMerge(input);

		Assert.assertEquals(4, output.size());
		output.sort(Comparator.comparing(a -> a.get(0)));
		Assert.assertArrayEquals(new String[]{"Alex", "Alex0@m.co", "Alex4@m.co", "Alex5@m.co"},
			output.get(0).toArray());
		Assert.assertArrayEquals(new String[]{"Ethan", "Ethan0@m.co", "Ethan3@m.co"},
			output.get(1).toArray());
		Assert.assertArrayEquals(new String[]{"Gabe", "Gabe0@m.co", "Gabe2@m.co", "Gabe3@m.co", "Gabe4@m.co"},
			output.get(2).toArray());
		Assert.assertArrayEquals(new String[]{"Kevin", "Kevin2@m.co", "Kevin4@m.co"},
			output.get(3).toArray());
	}
}
