package multi_threaded_pi;

import java.awt.List;
import java.math.BigDecimal;
import java.math.MathContext;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Pigreco_classic {

	public int square_e;	//Square edge
	public int round_r;		//Round radius
	public int point_n;		//Point number
	//public ArrayList<Point> points;	//Array of point_n rendom points
	public int point_in;	//Number of points in 
	public int point_out;	//Number of points out
	public Point[] points;
	
	public static final int DIGITS_N = 20;
	
	public Pigreco_classic(int square_e, int point_n) {
		this.square_e = square_e;
		this.point_n = point_n;
		round_r = (int)(square_e/2);
		points = new Point[point_n];
	}
	
	public void generatePoints() {
		Random rand = new Random();
		for(int i=0; i<point_n; i++) {
			points[i] = new Point(rand.nextInt(square_e), rand.nextInt(square_e));
		}
	}
	
	

	public void findPointPosition() {
		Point center = new Point(square_e/2, square_e/2);
		for(int i=0; i<point_n; i++) {
			if(center.distance(points[i])<=round_r){
				point_in++;
			}else {
				point_out++;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Pigreco [square_e=" + square_e + ", round_r=" + round_r + ", point_n=" + point_n + ", points=" + points
				+ ", point_in=" + point_in + ", point_out=" + point_out + "]";
	}
	
	public BigDecimal calculatePi() {
		//I decided to create new vars not to lose the original ones
		BigDecimal p_in_4 = new BigDecimal(4*point_in);
		BigDecimal p_n = new BigDecimal(point_n);
		
		return p_in_4.divide(p_n, new MathContext(DIGITS_N));
	}
	
	public BigDecimal autoPi() {
		generatePoints();
		findPointPosition();
		return calculatePi();
	}
	
}
