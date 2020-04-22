public class Problem1 {
	public static void main(String[] args) {
		int[][] chessBoard = new int[8][8];

		//place rake
		chessBoard[5][3] = 1;
		setRake(chessBoard, 5, 3);

		//place horse
		chessBoard[3][4] = 1;
		setHorse(chessBoard, 3, 4);

		//place rook
		chessBoard[7][3] = 1;
		setRook(chessBoard, 7, 3);

		int result = 0;
		for (int i = 0; i<chessBoard.length; i++) {
			for (int j = 0; j<chessBoard[i].length; j++) {
				System.out.print(chessBoard[i][j] + " ");
				if (chessBoard[i][j] == 1) {
					result += 1;
				}
			}
			System.out.println(" ");
		}

		System.out.println(result - 3);
	}

	public static void setRook(int[][] cb, int i, int j) {
		//horizontal and vertical axises:
		setRake(cb, i, j);

		//diagonal top-left
		int tLeft = j;
		for (int q = i; q > 0; q--) {
			if (tLeft > 0) {
				cb[q-1][tLeft-1] = 1;	
				tLeft -= 1;
			} else break;
		}

		//diagonal top-right:
		int tRight = j;
		for (int q = i; q > 0; q--) {
			if (tRight < cb.length - 1) {
				cb[q-1][tRight+1] = 1;
				tRight += 1;
			} else break;
		}

		//diagonal bottom-left:
		int bLeft = j;
		for (int q = i; q < cb.length - 1; q++) {
			if (bLeft > 0) {
				cb[q+1][bLeft-1] = 1;
				bLeft -= 1;
			} else break;
		}

		//diagonal bottom-right:
		int bRight = j;
		for (int q = i; q < cb.length - 1; q++) {
			if (bRight < cb.length) {
				cb[q+1][bRight+1] = 1;
				bRight += 1;
			} else break;
		}
	}

	public static void setHorse(int[][] cb, int i, int j) {
		//top
		if (i >= 2) {
			if (j > 0) {
				cb[i-2][j-1] = 1;
			}

			if (j < 7) {
				cb[i-2][j+1] = 1;
			}
		}
		//bottom
		if (i <= 5) {
			if (j > 0) {
				cb[i+2][j-1] = 1;
			}

			if (j < 7) {
				cb[i+2][j+1] = 1;
			}
		}
		//right
		if (j <= 5) {
			if (i > 0) {
				cb[i-1][j+2] = 1;
			}

			if (i < 7) {
				cb[i+1][j+2] = 1;
			}
		}
		//left
		if (j >= 2) {
			if (i > 0) {
				cb[i-1][j-2] = 1;
			}

			if (i < 7) {
				cb[i+1][j-2] = 1;
			}
		}
	}

	public static void setRake(int[][] chessBoard, int rowIndex, int colIndex) {
		//bottom
		for (int i = rowIndex + 1; i < chessBoard.length; i++) {
			chessBoard[i][colIndex] = 1;
		}
		//top
		for (int i = rowIndex - 1; i >= 0; i--) {
			chessBoard[i][colIndex] = 1;
		}
		//right
		for (int i = colIndex + 1; i < chessBoard[0].length; i++) {
			chessBoard[rowIndex][i] = 1;
		}
		//left
		for (int i = colIndex - 1; i >= 0; i--) {
			chessBoard[rowIndex][i] = 1;
		}
	}
}