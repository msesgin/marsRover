package marsRover;

/**
 * The Class Rover.
 */
public class Rover {

	/** The x coordinate. */
	private int x_coordinate;

	/** The y coordinate. */
	private int y_coordinate;

	/** The facing. */
	private String facing;

	/**
	 * Instantiates a new rover.
	 */
	public Rover() {
		super();
	}

	/**
	 * Instantiates a new rover.
	 *
	 * @param x_coordinate the x coordinate
	 * @param y_coordinate the y coordinate
	 * @param facing the facing
	 */
	public Rover(int x_coordinate, int y_coordinate, String facing) {
		super();
		this.x_coordinate = x_coordinate;
		this.y_coordinate = y_coordinate;
		this.facing = facing;
	}

	/**
	 * Gets the x coordinate.
	 *
	 * @return the x coordinate
	 */
	public int getX_coordinate() {
		return x_coordinate;
	}

	/**
	 * Sets the x coordinate.
	 *
	 * @param x_coordinate the new x coordinate
	 */
	public void setX_coordinate(int x_coordinate) {
		this.x_coordinate = x_coordinate;
	}

	/**
	 * Gets the y coordinate.
	 *
	 * @return the y coordinate
	 */
	public int getY_coordinate() {
		return y_coordinate;
	}

	/**
	 * Sets the y coordinate.
	 *
	 * @param y_coordinate the new y coordinate
	 */
	public void setY_coordinate(int y_coordinate) {
		this.y_coordinate = y_coordinate;
	}

	/**
	 * Gets the facing.
	 *
	 * @return the facing
	 */
	public String getFacing() {
		return facing;
	}

	/**
	 * Sets the facing.
	 *
	 * @param facing the new facing
	 */
	public void setFacing(String facing) {
		this.facing = facing;
	}

}
