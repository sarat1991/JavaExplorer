/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {

		@Override
		public int compare(Point o1, Point o2) {
			
			try{
			/* Slope between Point o0 to Point o1 */
		       if(null == o1 && null == o2)
		    	   return 0;
		       else if(null ==o1)
		    	   return 1;
		       else if(null == o2)
		    	   return -1;
		       
			double firstSlope = Point.this.slopeTo(o1);
			
			/*Slope between Point o0 to Point o2 */
			
			double secondSlope = Point.this.slopeTo(o2);
			
			if(firstSlope > secondSlope )
				return 1;
			else if(secondSlope > firstSlope)
				return -1;
			else 
				return 0;
			}
			catch(Exception e){
				throw e;
			}
		}
			
	};       

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    
    /**
     * slope between this point and that point
     * @param that
     * @return slope of two points in double
     */
    public double slopeTo(Point that) {
    	try{
    		
    		if(null == that)
		    	   return Double.POSITIVE_INFINITY;
		       
    	    
    	double numerator = that.y - this.y;
    	if(numerator == 0)
    		return 0;
    	double denominator = that.x-this.x;
    	if(denominator == 0)
    		if(numerator>0)
    			return Double.POSITIVE_INFINITY;
    		else
    			return Double.NEGATIVE_INFINITY;
    	else
    		return numerator/denominator;  
    	}
    	catch(Exception e){
    		throw e;
    	}
    }

    
    /* is this point lexicographically smaller than that one?comparing y-coordinates and breaking ties by x-coordinates
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Point that) {
    	try{
    		if(null == that)
		    	   return -1;
    		
	        if(this.y>that.y)
	        	return 1;
	        else if(this.y<that.y)
	        	return -1;
	        else{
	        	if(this.x>that.x)
	        		return 1;
	        	else if(this.x<that.x)
	        		return -1;
	        	else
	        		return 0;
	        }
    	}
    	catch(Exception e){
    		throw e;
    	}
    	
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}
