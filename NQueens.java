public class NQueens {
	private int n;
	private int[] queen;
	private int resultCount;
	public NQueens(int n) {
		this.n = n;
		this.queen = new int[n];
	}

	public boolean placeNQueens() throws Exception {
		if (n < 1) {
			throw new Exception();
		} else {
			putQueens(0);
			if (resultCount == 0) {
				return false;
			} else {
				return true;
			}
		}
	}

	private boolean canPut(int row) {
		for (int i = 0; i < row; i++) {
			if ((queen[i] == queen[row])) {
				return false;
			}
			if (Math.abs(i - row) == Math.abs(queen[i] - queen[row])) {
				return false;
			}
		}
		return true;
	}
	private void putQueens(int row) {
		if (row >= n) {
			resultCount++;
			return;
		} else {
			for (int j = 0; j < n; j++) {
				if (resultCount == 1) {
					return;
				}
				queen[row] = j;
				if (canPut(row)) {
					putQueens(row+1);
				}
			}
		}
	}

	public void printToConsole() {
		char[][] chessBoard = new char[n][n];
		try {
			if (placeNQueens()) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (queen[i] == j) {
							chessBoard[i][j] = 'Q';
							System.out.print(chessBoard[i][j] + " ");
						} else {
							chessBoard[i][j] = '-';
							System.out.print(chessBoard[i][j] + " ");
						}
					}
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		NQueens nQueens = new NQueens(18);
		nQueens.printToConsole();
	}

}