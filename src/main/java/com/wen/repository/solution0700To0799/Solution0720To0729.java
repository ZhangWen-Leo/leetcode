package com.wen.repository.solution0700To0799;

import java.util.*;
import java.util.stream.Collectors;

public class Solution0720To0729 {

	/**
	 * 721. Accounts Merge
	 *
	 * <p>1 <= accounts.length <= 1000</p>
	 * <p>2 <= accounts[i].length <= 10</p>
	 * <p>1 <= accounts[i][j].length <= 30</p>
	 * <p>accounts[i][0] consists of English letters.</p>
	 * <p>accounts[i][j] (for j > 0) is a valid email.</p>
	 */
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		class Account {
			final String name;
			final Set<String> emails = new HashSet<>();

			Account(String name) {
				this.name = name;
			}

			List<String> toList() {
				List<String> list = new LinkedList<>();
				list.add(this.name);
				List<String> sortedEmails = new ArrayList<>(this.emails);
				Collections.sort(sortedEmails);
				list.addAll(sortedEmails);
				return list;
			}

			void merge(Account account) {
				this.emails.addAll(account.emails);
			}
		}
		Map<String, Account> map = new HashMap<>();
		List<Account> accountList = new ArrayList<>();

		for (List<String> account : accounts) {
			String name = account.get(0);
			List<Account> existAccounts = new ArrayList<>();
			for (int i = 1; i < account.size(); i++) {
				String email = account.get(i);
				if (map.containsKey(email)) {
					existAccounts.add(map.get(email));
				}
			}
			Account targetAccount;
			if (existAccounts.isEmpty()) {
				targetAccount = new Account(name);
				accountList.add(targetAccount);
			} else {
				targetAccount = existAccounts.get(0);
				for (Account existAccount : existAccounts.subList(1, existAccounts.size())) {
					if (existAccount == targetAccount) {
						continue;
					}
					existAccount.emails.forEach(email -> map.put(email, targetAccount));
					targetAccount.merge(existAccount);
					accountList.remove(existAccount);
				}
			}
			List<String> emails = account.subList(1, account.size());
			targetAccount.emails.addAll(emails);
			for (String email : emails) {
				map.put(email, targetAccount);
			}
		}

		return accountList.stream().map(Account::toList).collect(Collectors.toList());
	}

	/**
	 * 724. Find Pivot Index
	 *
	 * <p>The length of nums will be in the range [0, 10000].</p>
	 * <p>Each element nums[i] will be an integer in the range [-1000, 1000].</p>
	 */
	public int pivotIndex(int[] nums) {
		int len = nums.length;

		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		int leftSum = 0, rightSum = sum;
		for (int i = 0; i < len; i++) {
			rightSum -= nums[i];
			if (leftSum == rightSum) {
				return i;
			}
			leftSum += nums[i];
		}

		return -1;
	}
}
