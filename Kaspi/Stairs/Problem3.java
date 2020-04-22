import java.util.ArrayList;

public class Problem3 {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		int in = 6;
		System.out.println(calc(in));
	}
	
	public static int calc(int d) {
		int out = 0;
		int q = 1;
		for (int i = d; i > 0; i--) {
			int counter = 0;
			for (int j = q; j > 0; j--) {
				counter++;
			}
			i = i - q;
			q++;
			out = counter;
		}
		return out;
	}
}