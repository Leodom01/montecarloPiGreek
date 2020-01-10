package multi_threaded_pi;

import java.util.Scanner;

public class Multi_thread_main{

	static int square_e_min;
	static int square_e_max;
	static long point_n_min;
	static long point_n_max;
	static long steps;
	static long steps_done;	
	
	public static void main(String args[]) {
		
		int core_n;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Lato del quadrato minore:");
		square_e_min = in.nextInt();
		System.out.println("Lato del quadrato maggiore:");
		square_e_max = in.nextInt();
		System.out.println("Numero punti minore:");
		point_n_min = in.nextInt();
		System.out.println("Numeri punti maggiore:");
		point_n_max = in.nextInt();
		System.out.println("Numero di step:");
		steps = in.nextInt();
		steps_done = 0;
		//Got all the input data
		
		core_n = Runtime.getRuntime().availableProcessors();
		Thread [] trds = new Thread[core_n];
		
		for(int i=0; i<core_n; i++) {
			if(steps > steps_done) {
				trds[i] = new Thread(new Task());
				trds[i].start();
			}
		}
		
		while(steps_done < steps) {
			for(int i=0; i<core_n; i++) {
				if(!(trds[i].isAlive())) {
					trds[i] = new Thread(new Task());
					trds[i].start(); 
				}
			}
		}
		
		in.close();
		
	}
	
}
