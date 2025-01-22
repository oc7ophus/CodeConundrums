package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums1 = {2, 7, 11, 15}; int target1 = 9;
		int[] nums2 = {5, 4, 6, 3}; int target2 = 7;

		System.out.println(Arrays.toString(twoSum(nums1, target1)));
		System.out.println(Arrays.toString(twoSum(nums2, target2)));
	}

	private static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) { return new int[]{map.get(target - nums[i]), i}; }
			map.put(nums[i], i); // We're storing the tuple as the key, and nums[] index as the value
		}
		return nums;
	}
}