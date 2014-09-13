import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;


public class GeometricTest {
	public static void main(String[] args){
		
		int x[] = {0,1};
		int y[] = {0,1};
		int w[] = {10,20};
		int h[] = {10,20};
		
		// Create shape from co-ordinate
		// The co-ordinate of shape is flip!
		Rectangle2D.Double rect1 = new Rectangle2D.Double(x[0],y[0],w[0],h[0]);
		Rectangle2D.Double rect2 = new Rectangle2D.Double(x[1],y[1],w[1],h[1]);
		
		
		//Create Area from shape
		Area a1 = new Area(rect1);
		Area a2 = new Area(rect2);
		
		// Intersect a1 with a2 -> a1 only change a2 not change
		// Border are exclude in intersection
		a1.intersect(a2);
		
		//Check if it is Empty(not intersect)
		if(a1.isEmpty()){
			System.out.println("Not Intersect");
		}
		
		
		// Subtract area a2 that intersect a1 from a1
		a1.subtract(a2);
		
		
		// Union only not intersect area together and delete intersect area
		// a1 always change
		a1.exclusiveOr(a2);
		
		
		//Return Rectangle2D from Area
		Rectangle2D.Double rect3 = (Double) a1.getBounds2D();
	}
}
