import java.util.Scanner;

public class SumOfRoundNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			go(in.nextInt());
		}
	}


	public static void go(int num) {
		String numString = String.valueOf(num);
		int d = 1;

		int counter = 0;
		String out = "";
		for (int i = numString.length()-1; i >= 0; i--) {
			int temp = Integer.parseInt(String.valueOf(numString.charAt(i))) * d;
			if (temp != 0) {
				out += temp + " ";
				counter++;
			}
			d *= 10;
		}
		System.out.println(counter);
		System.out.println(out);
	}
}