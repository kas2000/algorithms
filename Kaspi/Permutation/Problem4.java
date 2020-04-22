import java.util.HashMap;

public class Problem4 {
	public static void main(String[] args) {
		String originalString = "tommarvoloriddle";
		String testString = "voldemort";
		System.out.println(checkString(originalString.toLowerCase(), testString.toLowerCase()));
	}


	public static boolean checkString(String s1, String s2) {
		HashMap<Character, Integer> dict = new HashMap<>();
		for (char s : s1.toCharArray()) {
			if (!dict.containsKey(s)) {
				dict.put(s, 1);
			} else {
				int count = dict.get(s);
				count++;
				dict.put(s, count);
			}
		}

		HashMap<Character, Integer> dict2 = new HashMap<>();
		for (char s : s2.toCharArray()) {
			if (!dict2.containsKey(s)) {
				dict2.put(s, 1);
			} else {
				int count = dict2.get(s);
				count++;
				dict2.put(s, count);
			}
		}

		for (Character i : dict2.keySet()) {
			if (dict.containsKey(i)) {
				if (dict.get(i) < dict2.get(i)) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}
}