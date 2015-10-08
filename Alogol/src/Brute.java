import java.util.Arrays;

public class Brute {

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
		
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++)
				for (int k = j + 1; k < N; k++)
					for (int l = k + 1; l < N; l++) 
					{

						double slope1 = listOfPoints[i].slopeTo(listOfPoints[j]);
						double slope2 = listOfPoints[i].slopeTo(listOfPoints[k]);
						double slope3 = listOfPoints[i].slopeTo(listOfPoints[l]);

						boolean drawLine = slope1 == slope2 ? slope2 == slope3 ? true:false:false;

						if (drawLine) {
							Point temp[] = new Point[4];
							temp[0] = listOfPoints[i];
							temp[1] = listOfPoints[j];
							temp[2] = listOfPoints[k];
							temp[3] = listOfPoints[l];
							Arrays.sort(temp);
							temp[0].drawTo(temp[3]);
							
							System.out.print(temp[0]);
							for(int counter=1;counter<temp.length;counter++){
								System.out.print("->"+temp[counter]);
							}
							System.out.println();
//							System.out.print(listOfPoints[i] + "->"	+ listOfPoints[j] + "->");
//							System.out.print(listOfPoints[k] + "->"	+ listOfPoints[l] + "\n");

						}

					}

		// display to screen all at once
		StdDraw.show(0);

		// reset the pen radius
		StdDraw.setPenRadius();

	}

}
