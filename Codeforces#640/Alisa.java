import java.util.Scanner;

public class Alisa {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}

			go(arr);
		}

	}

	public static void go(int[] arr) {
		int alisaSum = 0;
		int bobSum = 0;

		int lastAlisa = arr[0];
		int lastBob = 0;
		
		int step = 0;

		int d = 0;
		int q = arr.length-1;

		for (int i = 0; i < arr.length; i++) {
			lastAlisa = alisa(arr, lastBob, d);
			alisaSum += lastAlisa;
			if (lastAlisa == 0) {
				System.out.println(step + " " + alisaSum + " " + bobSum);
				break;
			} else {
				step++;
			}

			lastBob = bob(arr, lastAlisa, q);
			bobSum += lastBob;
			if (lastBob == 0) {
				System.out.println(step + " " + alisaSum + " " + bobSum);
				break;
			} else {
				step++;
			}

			++d;
			--q;
		}
	}

	public static int bob(int[] arr, int alisaLastDigit, int q) {
		int count = 0;
		if (arr[q] > alisaLastDigit) {
			count = arr[q];
			arr[q] = -1;
			return count;
		}

		for (int i = q; i > 0; i--) {
			if (count > alisaLastDigit) return count;
			if (arr[i] == -2) {
				return count;
			} else if (arr[i] != -1){
				count += arr[i];
				arr[i] = -1;
			}
		}

		return count;
	}


	public static int alisa(int[] arr, int bobLastDigit, int d) {
		int count = 0;
		if (arr[d] > bobLastDigit) {
			count = arr[d];
			arr[d] = -2;
			return count;
		}

		for (int i = d; i < arr.length; i++) {
			if (count > bobLastDigit) return count;
			if (arr[i] == -1) {
				return count;
			} else if (arr[i] != -2){
				count += arr[i];
				arr[i] = -2;
			}
		}
		return count;
	}
}