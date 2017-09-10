package cs.main;



@FunctionalInterface
public interface Draw {

	/**
	 * This method is used to render shapes and user can implement this according to need
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param mchar
	 */
	void draw(int x1, int y1, int x2, int y2, char mchar);
	

	
}
