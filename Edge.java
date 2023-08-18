
public class Edge {
	
	Point start;
	Point end;
	double slope;
	
	public Edge(Point start, Point end) {
		super();
		this.start = start;
		this.end = end;		
		
		double x = (start.x + end.x) / 2;
        double y = (start.y + end.y) / 2;
        
	}
	
	public double getSlope() {
		this.slope = -1.0 / ((start.y - end.y) / (start.x - end.x));
		return slope;
	}
	
	
}
