public class PercolationStats {

	private double[] numberOfTrials;
	private static int inputSize;
	private static int noOfTrials;
	private double mean;
	private double standardDeviation;

	/**
	 * PercolationStats constructor perform T independent experiments on an
	 * N-by-N grid
	 * 
	 * @param N
	 *            size of the grid
	 * @param T
	 *            number of trials
	 */
	public PercolationStats(int N, int T) {

		try {
			checkForValidityOfInput(N, T);
			
			numberOfTrials = new double[T];

			for (int i = 0; i < T; i++) {
				Percolation percolationBoard = new Percolation(N);
				int openSites = 0;
				while (!percolationBoard.percolates()) {
					int xAxisOfblockToOpen = StdRandom.uniform(N) + 1;
					int yAxisOfblockToOpen = StdRandom.uniform(N) + 1;
					if (!percolationBoard.isOpen(xAxisOfblockToOpen,
							yAxisOfblockToOpen)) {
						percolationBoard.open(xAxisOfblockToOpen,
								yAxisOfblockToOpen);
						openSites++;
					}

				}

				numberOfTrials[i] = openSites
						/ (double) (inputSize * inputSize);

			}
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Mean method helps in calculating the mean of the trails
	 * 
	 * @return mean value in double data type
	 */
	public double mean() {
		
		 mean = StdStats.mean(numberOfTrials);
		
		 return mean;
	}

	/**
	 * stddev helps in calculating the standard deviation
	 * 
	 * @return standard deviation in double data type
	 */
	public double stddev() {

		standardDeviation = StdStats.stddev(numberOfTrials);

		return standardDeviation;

	}

	/**
	 * confidenceLo helps in calculating the low confidence level
	 * 
	 * @return confidence level in double data type
	 */
	public double confidenceLo() {
		
        
		double temp = (1.96 * Math.sqrt(standardDeviation))
				/ Math.sqrt(noOfTrials);

		return mean - temp;
	}

	/**
	 * confidenceHi helps in calculating the high confidence level
	 * 
	 * @return confidence level in double
	 */
	public double confidenceHi() {

		double temp = (1.96 * Math.sqrt(standardDeviation))
				/ Math.sqrt(noOfTrials);

		return mean + temp;

	}

	/**
	 * Checks for the validity of the inputs
	 * 
	 * @param x
	 *            size of the grid
	 * @param y
	 *            number of trials
	 * @throws IllegalArgumentException
	 *             when the size/trial goes below zero
	 */
	private void checkForValidityOfInput(int x, int y)
			throws IllegalArgumentException {
		if (x <= 0) {
			throw new IllegalArgumentException(" The size of the grid " + x
					+ " is invalid. Since it is below 1");
		} else if (y <= 0) {
			throw new IllegalArgumentException(" The number of trials " + y
					+ " is invalid. Since it is below 1");
		}

	}

	/**
	 * Main reads input value for the size and number of trials for the prg.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		inputSize = Integer.parseInt(args[0]);
		noOfTrials = Integer.parseInt(args[1]);

		PercolationStats percolationStat = new PercolationStats(inputSize,
				noOfTrials);

		System.out.println("mean                    = "
				+ percolationStat.mean());
		System.out.println("stddev                  = "
				+ percolationStat.stddev());
		System.out.println("95% confidence interval = "
				+ percolationStat.confidenceLo() + ", "
				+ percolationStat.confidenceHi());

	}

}
