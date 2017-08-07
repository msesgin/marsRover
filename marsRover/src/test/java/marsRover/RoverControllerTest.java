package marsRover;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;

/**
 * The Class RoverControllerTest.
 */
public class RoverControllerTest {

	/** The exception. */
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	/** The plateau. */
	Plateau plateau;
	
	/** The rover. */
	Rover rover;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		plateau = RoverController.createPlateau("5 5");

		rover = RoverController.setPosition("1 2 N");

	}

	/**
	 * Test turn left.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testTurnLeft() throws Exception {

		String testFacing;

		// north turn left
		testFacing = RoverController.turnLeft("N");
		assertTrue(testFacing.equals("W"));

		// west turn left
		testFacing = RoverController.turnLeft("W");
		assertTrue(testFacing.equals("S"));

		// south turn left
		testFacing = RoverController.turnLeft("S");
		assertTrue(testFacing.equals("E"));

		// east turn left
		testFacing = RoverController.turnLeft("E");
		assertTrue(testFacing.equals("N"));

	}

	/**
	 * Test turn right.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testTurnRight() throws Exception {

		String testFacing;

		// north turn right
		testFacing = RoverController.turnRight("N");
		assertTrue(testFacing.equals("E"));

		// west turn right
		testFacing = RoverController.turnRight("E");
		assertTrue(testFacing.equals("S"));

		// south turn right
		testFacing = RoverController.turnRight("S");
		assertTrue(testFacing.equals("W"));

		// east turn right
		testFacing = RoverController.turnRight("W");
		assertTrue(testFacing.equals("N"));

	}

	
	/**
	 * Test move.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testMove() throws Exception {

		// north move
		Rover testRover = RoverController.setPosition("1 2 N");
		RoverController.move(testRover);
		assertTrue(testRover.getX_coordinate() == 1 && testRover.getY_coordinate() == 3
				&& testRover.getFacing().equals("N"));

		// east move
		testRover = RoverController.setPosition("3 3 E");
		RoverController.move(testRover);
		assertTrue(testRover.getX_coordinate() == 4 && testRover.getY_coordinate() == 3
				&& testRover.getFacing().equals("E"));

		// south move
		testRover = RoverController.setPosition("1 2 S");
		RoverController.move(testRover);
		assertTrue(testRover.getX_coordinate() == 1 && testRover.getY_coordinate() == 1
				&& testRover.getFacing().equals("S"));

		// east move
		testRover = RoverController.setPosition("3 3 W");
		RoverController.move(testRover);
		assertTrue(testRover.getX_coordinate() == 2 && testRover.getY_coordinate() == 3
				&& testRover.getFacing().equals("W"));

		// coordinates exceeded exception catched
		testRover = RoverController.setPosition("5 5 N");
		exception.expect(Exception.class);
		RoverController.move(testRover);

	}

	/**
	 * Test process 13 N.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testProcess13N() throws Exception {

		rover = RoverController.setPosition("1 2 N");

		Rover testRover = RoverController.process(rover, "LMLMLMLMM");

		assertTrue(testRover.getX_coordinate() == 1);
		assertTrue(testRover.getY_coordinate() == 3);
		assertTrue(rover.getFacing().equals("N"));

	}

	/**
	 * Test process 51 E.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testProcess51E() throws Exception {

		rover = RoverController.setPosition("3 3 E");

		Rover testRover = RoverController.process(rover, "MMRMMRMRRM");

		assertTrue(testRover.getX_coordinate() == 5);
		assertTrue(testRover.getY_coordinate() == 1);
		assertTrue(rover.getFacing().equals("E"));

	}
}
