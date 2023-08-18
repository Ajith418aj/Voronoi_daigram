
public class PriorityQueue  implements Comparable<PriorityQueue> {
	
	Point p;
	Boolean type;

	public PriorityQueue(Point p, Boolean type) {
		this.p = p;
		this.type = type;
	}
	
	
	public Point getP() {
		return p;
	}


	public Boolean getType() {
		return type;
	}


	@Override
    public int compareTo(PriorityQueue point) {
        Point p1 = this.p;
        Point p2 = point.p;
		if (p1.y < p2.y) return 1;
        if (p1.y > p2.y) return -1;
        if (p1.x == p2.x) return 0;
        return (p1.x < p2.x) ? -1 : 1;
    }
}
