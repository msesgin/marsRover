package marsRover;

/**
 * The Class Plateau.
 */
public class Plateau {

	/** The x length. */
	private int x_length =0;
	
	/** The y length. */
	private int y_length =0;

	/**
	 * Instantiates a new plateau.
	 */
	public Plateau() {
		super();
	}

	/**
	 * Instantiates a new plateau.
	 *
	 * @param x_length the x length
	 * @param y_length the y length
	 */
	public Plateau(int x_length, int y_length) {
		super();
		this.x_length = x_length;
		this.y_length = y_length;
	}

	/**
	 * Gets the x length.
	 *
	 * @return the x length
	 */
	public int getX_length() {
		return x_length;
	}

	/**
	 * Sets the x length.
	 *
	 * @param x_length the new x length
	 */
	public void setX_length(int x_length) {
		this.x_length = x_length;
	}

	/**
	 * Gets the y length.
	 *
	 * @return the y length
	 */
	public int getY_length() {
		return y_length;
	}

	/**
	 * Sets the y length.
	 *
	 * @param y_length the new y length
	 */
	public void setY_length(int y_length) {
		this.y_length = y_length;
	}
	
	
}
