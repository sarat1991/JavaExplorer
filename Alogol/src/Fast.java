import java.util.Arrays;

public class Fast {

	public static void main(String[] args) {
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		StdDraw.show(0);
		StdDraw.setPenRadius(0.002); // make the points a bit larger

		// read in the input
		String filename = args[0];
		In in = new In(filename);
		int N = in.readInt();

		Point[] listOfPoints = new Point[N];

		for (int i = 0; i < N; i++) {
			int x = in.readInt();
			int y = in.readInt();
			Point p = new Point(x, y);
			p.draw();

			listOfPoints[i] = p;
		}

		Arrays.sort(listOfPoints);
		Point listOfCoveredPoints[] = new Point[2*N];
		int listOfCoveredPointsCount = 0;
		for (int i = 0; i < N; i++) {
			
			Point[] slopes = new Point[N - i - 1];
			int slopesCount = 0;

			for (int j = i + 1; j < N; j++) {
				boolean addTolist = true;
				for (int tempCount = 0; tempCount < listOfCoveredPointsCount; tempCount++) {
					if (listOfPoints[j].slopeTo(listOfPoints[i]) == listOfCoveredPoints[tempCount].slopeTo(listOfPoints[j])){
						addTolist = false;
						break;
					}
				}
				if (addTolist) {
					slopes[slopesCount] = listOfPoints[j];
					slopesCount++;
				}

			}

			if (slopesCount > 2) {
				Point tempSlopes[] = new Point[slopesCount];

				for (int tempSlopesCounter = 0; tempSlopesCounter < slopesCount; tempSlopesCounter++) {
					tempSlopes[tempSlopesCounter] = slopes[tempSlopesCounter];
				}

				Arrays.sort(slopes);
				slopes = tempSlopes;
				Arrays.sort(slopes, listOfPoints[i].SLOPE_ORDER);
				
				double currentSlope, previousSlope;
				currentSlope = listOfPoints[i].slopeTo(slopes[0]);
				previousSlope = currentSlope;

				int equalSlopeCount = 0;

				int startIndex = 0;

				
				
				for (int k = 1; k < slopes.length; k++) {
					currentSlope = listOfPoints[i].slopeTo(slopes[k]);

					if (currentSlope == previousSlope) {
						if (equalSlopeCount == 0) {
							startIndex = k - 1;
							equalSlopeCount = 2;
						}

						else if (equalSlopeCount >=2){ 
							equalSlopeCount++;
						}
					} else {
						if (equalSlopeCount > 2) {
							Point temp[] = new Point[equalSlopeCount];
							
							for (int tempCounter = 0, j = startIndex; tempCounter < equalSlopeCount; tempCounter++, j++) {
								temp[tempCounter] = slopes[j];
								//System.out.print("->" + slopes[j]);
							}
							
							Arrays.sort(temp);
							
							System.out.print(listOfPoints[i]);
							for(int counter=0;counter<temp.length;counter++){
								System.out.print("->"+temp[counter]);
							}
							
							
								listOfPoints[i].drawTo(temp[equalSlopeCount - 1]);
							
						
							listOfCoveredPoints[listOfCoveredPointsCount++] = listOfPoints[i];

							System.out.println();

						}
						equalSlopeCount = 0;
						previousSlope = currentSlope;

					}

				}

				if (equalSlopeCount > 2) {

					Point temp[] = new Point[equalSlopeCount];
					//System.out.print(listOfPoints[i]);
					for (int tempCounter = 0, j = startIndex; tempCounter < equalSlopeCount; tempCounter++, j++) {
						temp[tempCounter] = slopes[j];
						//System.out.print("->" + slopes[j]);
					}
					//temp[equalSlopeCount] = listOfPoints[i];
					Arrays.sort(temp);
					
					System.out.print(listOfPoints[i]);
					for(int counter=0;counter<temp.length;counter++){
						System.out.print("->"+temp[counter]);
					}
					
					
						listOfPoints[i].drawTo(temp[equalSlopeCount - 1]);
						
					

					
					listOfCoveredPoints[listOfCoveredPointsCount++] = listOfPoints[i];

					System.out.println();

				}

			}
			StdDraw.show(0);
			StdDraw.setPenRadius();

		}
		
		//System.out.println("Program ended"+listOfCoveredPoints.length);

	}

}
