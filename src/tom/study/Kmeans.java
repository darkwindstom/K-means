package tom.study;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kmeans {
	
	public static void main(String[] args) {
		
		Point[] setADatas = {new Point(1, 2), new Point(3, 4), new Point(2, 2), new Point(3, 2), new Point(3, 1)};
		Point[] setBDatas = {new Point(6, 4), new Point(7, 6), new Point(5, 6), new Point(6, 5)};		
		Point[] setCDatas = {new Point(5, 4), new Point(3, 4)};
		
		List<Point> setA = new ArrayList<Point>(Arrays.asList(setADatas));
		List<Point> setB = new ArrayList<Point>(Arrays.asList(setBDatas));
		List<Point> setC = new ArrayList<Point>(Arrays.asList(setCDatas));
		
		Kmeans km = new Kmeans();
		
		Point centerA = km.setCenter(setA);
		Point centerB = km.setCenter(setB);
				
		double distA = 0;
		double distB = 0;
			
		for(Point p1 : setC) {
			
			distA = Math.sqrt((centerA.x - p1.x) ^2 + (centerA.y - p1.y) ^2);
			distB = Math.sqrt((centerB.x - p1.x) ^2 + (centerB.y - p1.y) ^2);
			
			if(distA <= distB) {
				setA.add(p1);				
				System.out.println("A:"+p1.toString());				
			} else {
				setB.add(p1);
				System.out.println("B:"+p1.toString());
			}
			
		}
		
	}
	
	private Point setCenter(List<Point> set){
		
		Point setCenter = new Point();
		
		for(Point p1 : set) {
			setCenter.x += p1.x;
			setCenter.y += p1.y;
		}
		
		setCenter.x = setCenter.x / set.size();
		setCenter.y = setCenter.y / set.size();
		
		return setCenter;
		
	}

}
