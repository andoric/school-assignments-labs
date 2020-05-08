package cst8284.shape;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircleTest {
	
	private Circle testCircle;

	@BeforeEach
	void setUp() throws Exception {
		testCircle = new Circle(1);
	}

	@Test
	void testGetArea() {
		double expectedValue = Math.PI*Math.pow(0.5,2);
		assertEquals(testCircle.getArea(),expectedValue);
	}

	@Test
	void testGetPerimeter() {
		double expectedValue = Math.PI*1;
		assertEquals(testCircle.getPerimeter(),expectedValue);
	}

}
