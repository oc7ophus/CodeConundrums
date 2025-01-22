package ArraysAndHashing;

import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] strs = {"act","pots","tops","cat","stop","hat","tah","hta"};
		List<List<String>> output = groupAnagrams(strs);
		System.out.println(output);
	}

	private static ArrayList<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) { return new ArrayList<>(); }
		Map<String, List<String>> anagramMap = new HashMap<>();
		for (String str : strs) {
			String sortedStr = charSort(str);
			anagramMap.computeIfAbsent(sortedStr, _ -> new ArrayList<>()).add(str); // If there are no existing keys, initialize ArrayList
		}
		return new ArrayList<>(anagramMap.values());
	}

	private static String charSort(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return Arrays.toString(charArray);
	}
}

// https://neetcode.io/problems/anagram-groups