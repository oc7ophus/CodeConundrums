package ArraysAndHashing;

public class ContainsDuplicate {
	public static void main(String[] args) {
		int[] testInput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		boolean result = containsDuplicate(testInput);
		System.out.println(result);
	}

	private static boolean containsDuplicate(int[] inputArray) {
		HashTable ht = new HashTable(inputArray.length);
		for (int i : inputArray) {
			if (ht.hasKey(i)) { return true; }
			ht.putKey(i);
		}
		return false;
	}

	public static class HashTable {
		Node[] table;
		int tableCapacity;
		int size;

		public HashTable(int capacity) {
			tableCapacity = capacity;
			table = new Node[capacity];
			size = 0;
		}

		private static class Node {
			int key;
			boolean value;
			Node next;

			Node(int key, boolean value) {
				this.key = key;
				this.value = value;
			}
		}

		private int hash(int key) { return Math.abs(key % tableCapacity); }

		public void putKey(int key) {
			boolean value = true;
			int index = hash(key);
			Node head = table[index];
			while (head != null) {
				if (head.key == key) {
					head.value = value;
					return;
				}
				head = head.next;
			}
			Node newNode = new Node(key, value);
			newNode.next = table[index];
			table[index] = newNode;
			size++;
		}

		public boolean hasKey(int key) {
			int index = hash(key);
			Node head = table[index];
			if (head != null) { return head.value; }
			return false;
		}
	}
}

/*
https://neetcode.io/problems/duplicate-integer
Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

Input: nums = [1, 2, 3, 3]
Output: true

Input: nums = [1, 2, 3, 4]
Output: false
*/