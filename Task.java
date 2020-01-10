package multi_threaded_pi;

public class Task extends Multi_thread_main implements Runnable {

	
	public void run(){
		int square_e = (int) (square_e_min+((square_e_max-square_e_min)*(steps_done+1)/steps));
		long point = point_n_min+((point_n_max-point_n_min)*(steps_done+1)/steps);
		Pigreco_hp me = new Pigreco_hp(square_e, point);
		System.out.println("PI: "+me.autoPi());
		steps_done++;
	  }
	
}
