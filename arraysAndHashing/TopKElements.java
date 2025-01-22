package ArraysAndHashing;

import java.util.*;

public class TopKElements {
	public static void main(String[] args) {
		int[] nums = {4,4,4,7,7,9};
		int k = 2;
		List<Integer> output = findTopK(nums, k);
		System.out.println(output);
	}

	private static List<Integer> findTopK(int[] nums, int k) {
		HashMap<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
				new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			minHeap.add(entry);
			if (minHeap.size() > k) { minHeap.poll(); }
		}
		List<Integer> result = new ArrayList<>();
		while (!minHeap.isEmpty()) { result.add(minHeap.poll().getKey()); }
		return result;
	}
}

// https://neetcode.io/problems/top-k-elements-in-list