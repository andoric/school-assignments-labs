package cst8284.shape;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TriangleTest {
	private Triangle testTriangle;

	@BeforeEach
	void setUp() throws Exception {
		testTriangle = new Triangle(1);
	}

	@Test
	void testGetArea() {
		double expectedValue = Math.sqrt(3)/4*Math.pow(1,2);
		assertEquals(testTriangle.getArea(),expectedValue);
	}

	@Test
	void testGetPerimeter() {
		double expectedValue = 3.0;
		assertEquals(testTriangle.getPerimeter(),expectedValue);
	}

}
