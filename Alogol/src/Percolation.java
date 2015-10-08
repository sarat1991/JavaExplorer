
public class Percolation {

	private WeightedQuickUnionUF tempUnionFindVirtualTop;
	private WeightedQuickUnionUF tempUnionFindVirtualBottom;
	private int[][] percolationBoard;

	private int inputSize = 0;

	/**
	 * Converts 2D input to 1D value
	 * 
	 * @param x
	 *            x-axis value
	 * @param y
	 *            y-axis value
	 * @return
	 * 			  1D integer value
	 */
	private int convert2DtoID(int x, int y) {

		return y + x * inputSize;

	}

	

	/**
	 * Constructs a percolation board of size N*N. The board has the -2 for
	 * value for open and -1 value for close
	 * 
	 * @param N
	 *            Size of the board
	 */
	public Percolation(int N) {
		try {
			checkForValidityOfInput(N);
			inputSize = N;
			tempUnionFindVirtualTop = new WeightedQuickUnionUF(N * N + 2);
			tempUnionFindVirtualBottom = new WeightedQuickUnionUF(N * N + 1);
			percolationBoard = new int[N][N];

			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++) {
					percolationBoard[i][j] = -1;
				}
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * opens a block in the percolation board
	 * 
	 * @param i
	 *            - x axis value
	 * @param j
	 *            - y axis value
	 */
	public void open(int i, int j) {
		try {
			checkForValidityOfInput(i, j);

			int x = i - 1;
			int y = j - 1;
			// Opening the particular slot in the board.
			percolationBoard[x][y] = -2;

			if (x == 0) {// connecting first row to virtual top
				tempUnionFindVirtualTop.union(inputSize * inputSize,
						convert2DtoID(x, y));
				tempUnionFindVirtualBottom.union(inputSize * inputSize,
						convert2DtoID(x, y));
			}
			if (x == inputSize - 1) {// connecting the last row to virtual
										// bottom
				
				tempUnionFindVirtualTop.union(inputSize * inputSize + 1,
						convert2DtoID(x, y));
			}
			// Check whether the 4 adjacent boxes are open or not.

			// Check for Top box if Top box is present.

			boolean isTopSlotOpen = (x) != 0 ? isOpen(i - 1, j) : false;

			if (isTopSlotOpen) {
				int root = convert2DtoID(i - 2, j - 1);
				int child = convert2DtoID(i - 1, j - 1);
				tempUnionFindVirtualBottom.union(root, child);
				tempUnionFindVirtualTop.union(root, child);
			}

			// Check for Bottom box if bottom box is present.

			boolean isBottomSlotOpen = (x) != inputSize - 1 ? isOpen(i + 1, j)
					: false;

			if (isBottomSlotOpen) {
				int child = convert2DtoID(x + 1, y);
				int root = convert2DtoID(x, y);
				tempUnionFindVirtualBottom.union(root, child);
				tempUnionFindVirtualTop.union(root, child);
			}

			// Check for Left box if Left box is present.

			boolean isLeftSlotOpen = (y) != 0 ? isOpen(i, j - 1) : false;

			if (isLeftSlotOpen) {
				int root = convert2DtoID(x, y - 1);
				int child = convert2DtoID(x, y);
				tempUnionFindVirtualBottom.union(root, child);
				tempUnionFindVirtualTop.union(root, child);
			}

			// Check for right box if right box is present.

			boolean isRightSlotOpen = (y) != inputSize - 1 ? isOpen(i, j + 1)
					: false;

			if (isRightSlotOpen) {
				int child = convert2DtoID(x, y + 1);
				int root = convert2DtoID(x, y);
				tempUnionFindVirtualBottom.union(root, child);
				tempUnionFindVirtualTop.union(root, child);
			}
		} catch (IndexOutOfBoundsException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Checks whether the block is open or not
	 * 
	 * @param i
	 *            x-axis value
	 * @param j
	 *            y-axis value
	 * @return boolean value of the result.
	 */
	public boolean isOpen(int i, int j) {

		try {
			checkForValidityOfInput(i, j);

			if (percolationBoard[i - 1][j - 1] == -2)
				return true;
			else
				return false;
		} catch (IndexOutOfBoundsException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Checks whether the block is full or not
	 * 
	 * @param i
	 *            x-axis value
	 * @param j
	 *            y-axis value
	 * @return boolean value of the result.
	 */
	public boolean isFull(int i, int j) {

		try {
			checkForValidityOfInput(i, j);

			int indexInWeightedUnion = convert2DtoID(i - 1, j - 1);

			if (percolationBoard[i - 1][j - 1] == -1)
				return false;
			else {
				if (tempUnionFindVirtualTop.connected(inputSize * inputSize,
						indexInWeightedUnion)
						&& (tempUnionFindVirtualBottom.connected(inputSize
								* inputSize, indexInWeightedUnion))) {
					return true;
				} else
					return false;
			}
		} catch (IndexOutOfBoundsException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Checks whether the board can be percolated or not
	 * 
	 * @return boolean of the result.
	 */
	public boolean percolates() {

		if (tempUnionFindVirtualTop.connected(inputSize * inputSize, inputSize
				* inputSize + 1)) {
			return true;
		} else
			return false;
	}

	/**
	 * Checks for the validity of the input
	 * 
	 * @param x
	 *            x-axis value
	 * @param y
	 *            y-axis value
	 * @throws IndexOutOfBoundsException
	 *             when the row/column index is out of bounds.
	 */
	private void checkForValidityOfInput(int x, int y)
			throws IndexOutOfBoundsException {
		if ((x <= 0 || x > (inputSize))) {
			throw new IndexOutOfBoundsException("row index " + x
					+ " out of bounds");
		} else if ((y <= 0 || y > (inputSize))) {
			throw new IndexOutOfBoundsException("column index " + y
					+ " out of bounds");
		}

	}

	/**
	 * Checks for the validity of the input
	 * 
	 * @param n
	 *            size of the gird
	 * @throws IllegalArgumentException
	 *             when size of the grid is less than zero
	 */
	private void checkForValidityOfInput(int n) throws IllegalArgumentException {
		if (n <= 0) {
			throw new IllegalArgumentException(" The size of the grid " + n
					+ " is invalid");

		}

	}

}
