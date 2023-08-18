import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class VoronoiDiagram {

	private static TreeSet<Point> beachLine;
	
	public static void main(String[] args) {
		
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Points");
		n = sc.nextInt();
		
		ArrayList<Point> points = new ArrayList<>();
		
		for(int i=0 ; i<n; i++) {			
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			Point e = new Point(x, y);
			points.add(e );
		}	
		
		TreeSet<PriorityQueue> priorityQueue = new TreeSet<>();
		for (Point point : points) {
			priorityQueue.add(new PriorityQueue(point, true));
        }
		
		System.out.println();
		
		for (PriorityQueue pq : priorityQueue) {
			Point point = pq.getP();
			System.out.println(point.x + " "+ point.y);
        }
		
		beachLine = new TreeSet<>();
		
		while ((priorityQueue.size() > 0)) {
			StdDraw.clear();
			PriorityQueue currentSite = priorityQueue.pollFirst();
			for (Point p : points) {
				StdDraw.setPenRadius(.01);
				StdDraw.setPenColor(StdDraw.RED);
		        StdDraw.point(p.x, p.y);
	        }
			
			for (Point p : beachLine) {
				Parabola parabola = new Parabola(p.x, p.y, currentSite.p.y);
				double x = parabola.getFocusX();
				double y = parabola.getFocusY();
				double dir = parabola.getDirectrix();
				for (double i = -1; i < 1; i += 0.001) {
									
					double z = ((i - x) * (i - x) + (y * y) - (dir * dir)) / (2 * (y - dir));
					StdDraw.setPenRadius(.001);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.point(i, z);
				}
			}
		
			StdDraw.setPenRadius(.001);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(-10, currentSite.p.y, 10, currentSite.p.y);
			StdDraw.show(1);
			
			if (currentSite.getType().equals(true)) {
                handleSiteEvent(currentSite);
            }
            else {
                //handleCircleEvent(cur);
            }
		}
				
		System.out.println("------ENDED-----");
		sc.close();
	}

	private static void handleSiteEvent(PriorityQueue current) {
		
		if (beachLine.size() == 0) {
            beachLine.add(current.p);
            return;
        }
		
		Point above = beachLine.first();
		Edge edge = new Edge(above, current.p);
		beachLine.add(current.p);
	}

}
