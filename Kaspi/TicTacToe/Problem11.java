public class Problem11 {
	public static void main(String[] args) {
		char[][] matrix = new char[3][3];
		matrix[0][0] = 'O';
		matrix[0][1] = 'X';
		matrix[0][2] = 'X';
		matrix[1][0] = ' ';
		matrix[1][1] = 'X';
		matrix[1][2] = 'X';
		matrix[2][0] = 'X';
		matrix[2][1] = 'X';
		matrix[2][2] = 'X';


		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(" ");
		}

		if (checkHorizontally(matrix) == 'O' ||
			checkVertically(matrix) == 'O' ||
			checkDiagonally(matrix) == 'O') {
			System.out.println("Lose");
		} else if (checkHorizontally(matrix) == 'X' ||
			checkVertically(matrix) == 'X' ||
			checkDiagonally(matrix) == 'X') {
			System.out.println("Win");
		} else {
			System.out.println("Draw");
		}

	}


	public static char checkDiagonally(char[][] matrix) {
		// top-left to bottom-right
		int j = 0;
		String result = "";
		for (int i = 0; i < matrix.length; i++) {
			result += matrix[i][j];
			j++;
		}
		if (result.equals("OOO")) {
			return 'O';
		} else if (result.equals("XXX")) {
			return 'X';
		}

		// top-right to bottom-left
		j = matrix.length - 1;
		result = "";
		for (int i = 0; i < matrix.length; i++) {
			result += matrix[i][j];
			j--;
		}
		if (result.equals("OOO")) {
			return 'O';
		} else if (result.equals("XXX")) {
			return 'X';
		}


		return 'D';
	}

	public static char checkHorizontally(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			String rowResult = "";
			for (int j = 0; j < matrix[i].length; j++) {
				rowResult += matrix[i][j];
			}
			if (rowResult.equals("OOO")) {
				return 'O';
			} else if (rowResult.equals("XXX")) {
				return 'X';
			}
		}
		return 'D';
	}

	public static char checkVertically(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			String rowResult = "";
			for (int j = 0; j < matrix[i].length; j++) {
				rowResult += matrix[j][i];
			}
			if (rowResult.equals("OOO")) {
				return 'O';
			} else if (rowResult.equals("XXX")) {
				return 'X';
			}
		}
		return 'D';
	}
}