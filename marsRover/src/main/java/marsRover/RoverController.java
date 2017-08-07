package marsRover;

/**
 * The Class RoverController.
 */
public class RoverController {

	/** The plateau. */
	static Plateau plateau;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String args[]) throws Exception {

		createPlateau("5 5");

		Rover rover = setPosition("1 2 N");
		process(rover, "LMLMLMLMM");
		System.out.println(rover.getX_coordinate() + " " + rover.getY_coordinate() + " " + rover.getFacing());


		rover = setPosition("3 3 E");
		process(rover, "MMRMMRMRRM");
		System.out.println(rover.getX_coordinate() + " " + rover.getY_coordinate() + " " + rover.getFacing());

	}

	/**
	 * Creates the plateau.
	 *
	 * @param plateauCoordinates the plateau coordinates
	 * @return the plateau
	 */
	public static Plateau createPlateau(String plateauCoordinates) {

		String delims = "[ ]";
		String[] tokens = plateauCoordinates.split(delims);

		plateau = new Plateau(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));

		return plateau;

	}

	/**
	 * Sets the position.
	 *
	 * @param roverPosition the rover position
	 * @return the rover
	 */
	public static Rover setPosition(String roverPosition) {

		String delims = "[ ]";
		String[] tokens = roverPosition.split(delims);

		Rover rover = new Rover(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), tokens[2]);

		return rover;
	}

	/**
	 * Process.
	 *
	 * @param rover the rover
	 * @param commands the commands
	 * @return the rover
	 * @throws Exception the exception
	 */
	public static Rover process(Rover rover, String commands) throws Exception {
		Character command = null;
		for (int i = 0; i < commands.length(); i++) {
			command = commands.charAt(i);

			if (command.equals('L')) {
				rover.setFacing(turnLeft(rover.getFacing()));
			} else if (command.equals('R')) {
				rover.setFacing(turnRight(rover.getFacing()));
			} else if (command.equals('M')) {
				rover = move(rover);
			} else {
				throw new IllegalArgumentException("Speak in Mars language, please!");
			}
		}

		return rover;
	}

	/**
	 * Move.
	 *
	 * @param rover the rover
	 * @return the rover
	 * @throws Exception the exception
	 */
	public static Rover move(Rover rover) throws Exception {

		Rover newRover = rover;

		switch (rover.getFacing()) {
		case "N":
			rover.setY_coordinate(rover.getY_coordinate() + 1);
			break;
		case "W":
			rover.setX_coordinate(rover.getX_coordinate() - 1);
			break;
		case "S":
			rover.setY_coordinate(rover.getY_coordinate() - 1);
			break;
		case "E":
			rover.setX_coordinate(rover.getX_coordinate() + 1);
			break;
		default:
			break;
		}

		if (newRover.getX_coordinate() < 0 || newRover.getX_coordinate() > plateau.getX_length()
				|| newRover.getY_coordinate() < 0 || newRover.getY_coordinate() > plateau.getY_length()) {
			throw new Exception("plateau coordinates exceeded");
		}

		return newRover;

	}

	/**
	 * Turn left.
	 *
	 * @param facing the facing
	 * @return the string
	 */
	public static String turnLeft(String facing) {

		String newFacing = facing;

		switch (facing) {
		case "N":
			newFacing = "W";
			break;
		case "W":
			newFacing = "S";
			break;
		case "S":
			newFacing = "E";
			break;
		case "E":
			newFacing = "N";
			break;
		default:
			break;
		}
		return newFacing.toString();
	}

	/**
	 * Turn right.
	 *
	 * @param facing the facing
	 * @return the string
	 */
	public static String turnRight(String facing) {

		String newFacing = facing;

		switch (facing) {
		case "N":
			newFacing = "E";
			break;
		case "E":
			newFacing = "S";
			break;
		case "S":
			newFacing = "W";
			break;
		case "W":
			newFacing = "N";
			break;
		default:
			break;
		}
		return newFacing.toString();
	}

}
