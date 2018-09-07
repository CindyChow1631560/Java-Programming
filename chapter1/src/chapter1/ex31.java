package chapter1;
import java.util.*;
import java.awt.*;
public class ex31 {
	static class Point {
		double x;
		double y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		//Point p=new Point();
		Random random=new Random();
		double p = Double.parseDouble(args[1]);
		if (p < 0 || p > 1) {
			System.out.println("p is not valid!");
			return;
		}
		Point[] points = new Point[N];
		double angle = 360.0 / N;
		//Graphics g = this.CreateGraphics();
		//g.drawOval(1, 1, 1, 1);
		//g.setPenRadius(0.05);
		for (int i = 0; i < N; i++) {
			points[i] = new Point(0.5 + 0.5 * Math.cos(angle * i * Math.PI / 180),
					0.5 + 0.5 * Math.sin(angle * i * Math.PI / 180));
			// g.drawPolygon((int[])points[i].x, (int[])points[i].y,1);
		}
		//StdDraw.setPenRadius(0.01);
		//  Color c = g.getColor();
		//g.setColor(Color.magenta);
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (random.nextDouble()>0) {
					//g.drawLine((int)points[i].x, (int)points[i].y, (int)points[j].x, (int)points[j].y);
				}
			}
		}
	}

}
