public class Problem7 {
	public static void main(String[] args) {
		int num = 1000;

		System.out.println(countFives(num));
	}

	public static int countFives(int num) {
		int count = 0;

		for (int i = 1; i <= num; i++) {
			String numString = Integer.toString(i);
			for (char c : numString.toCharArray()) {
				if (c == '5') {
					count++;
				}
			}
		}

		return count;
	}
}