package ArraysAndHashing;

public class ValidAnagram {
	public static void main(String[] args) {
		String s1 = "anagram", t1 = "nagaram";
		String s2 = "car", t2 = "bag";

		System.out.println(isAnagram(s1, t1));
		System.out.println(isAnagram(s2, t2));
	}

	private static boolean isAnagram(String s1, String t1) {
		if (s1.length() != t1.length()) { return false; }
		int[] freq = new int[26];
		for (int i : s1.toCharArray()) { freq[(i - 'a')]++; } // 'z' = 122, 'a' = 97
		for (int j : t1.toCharArray()) { freq[(j - 'a')]--; } // (97 - 97) = 0, (122 - 97) = 25
		for (int k : freq) { if (k != 0) return false; } // Primitive int arrays default all values to 0
		return true;
	}
}