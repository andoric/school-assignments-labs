package cst8284.shape;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquareTest {
	
	Square testSquare;

	@BeforeEach
	void setUp() throws Exception {
		testSquare = new Square(1);
	}

	@Test
	void testGetArea() {
		double expectedValue = 1.0;
		assertEquals(testSquare.getArea(), expectedValue);
	}

	@Test
	void testGetPerimeter() {
		double expectedValue = 4.0;
		assertEquals(testSquare.getPerimeter(), expectedValue);
	}

}
