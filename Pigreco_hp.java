package multi_threaded_pi;

import java.awt.List;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

//High performanca class that copies most of mathods and vars from Pigrco_classic but doesn't memorize all of the points in the array
//to avoid memory heap exception but increments the counter point_in and point_n.
//While i've changed point_n and point_in to long it is not really necessary to change also square_e to increase Pi accuracy
public class Pigreco_hp {

	public int square_e;	//Square edge
	public long point_n;		//Point number
	public long point_in;	//Number of points in 
	
	public static final int DIGITS_N = 20;
	
	public Pigreco_hp(int square_e, long point_n) {
		this.square_e = square_e;
		this.point_n = point_n;
		this.point_in = 0;
	}
	
	public void spawnCountPoints() {
		Random rand = new Random();
		Point c = new Point(square_e/2, square_e/2);
		for(int i=0; i<point_n; i++) {
			Point x = new Point(rand.nextInt(square_e), rand.nextInt(square_e));
			if(c.distance(x) <= (square_e/2)) {
				point_in++;
			}
		}
	}
	
	
	@Override
	public String toString() {
		return "Pigreco_hp [square_e=" + square_e + ", point_n=" + point_n + ", point_in=" + point_in + "]";
	}

	public BigDecimal calculatePi() {
		//I decided to create new vars not to lose the original ones
		BigDecimal p_in_4 = new BigDecimal(4*point_in);
		BigDecimal p_n = new BigDecimal(point_n);
		
		//
		return p_in_4.divide(p_n, DIGITS_N, RoundingMode.HALF_UP);
	}
	
	public BigDecimal autoPi() {
		spawnCountPoints();
		return calculatePi();
	}
	
}
