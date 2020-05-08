package cst8284.assignment2.officeManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AssistantTest {
	

	Assistant testAssist;

	@BeforeEach
	void setUp() throws Exception {
		testAssist=new Assistant("Tyler","Bay",100);
		testAssist.setAddress("123 Fake St");
		testAssist.setExtraHours(10);
		testAssist.setOverTimeRate(10);
	}


	@Test
	void testComputeSalary() {
		double expectedSalary = 200;
		assertEquals(testAssist.computeSalary(),expectedSalary);
	}

	@Test
	void testToString() {
		String expectedToString = ("Job Function: Assistant" +"\n"
				+"Name: "+"Tyler Bay"+"\n"
				+"Address: "+"123 Fake St"+"\n"
				+"Salary: "+"100.0"+"\n"
				+"Hourly Rate for Overtime: "+"10.0" +"\n"
				+"Extra Hours: "+"10"+"\n"
				);
		assertEquals(testAssist.toString(), expectedToString);
	}

	@Test
	void testSetExtraHours() {
		int newHours = 12;
		testAssist.setExtraHours(newHours);
		assertEquals(testAssist.getExtraHours(),newHours);
	}

	@Test
	void testSetOverTimeRate() {
		double newRate = 15;
		testAssist.setOverTimeRate(newRate);
		assertEquals(testAssist.getOverTimeRate(),newRate);
	}

	@Test
	void testGetExtraHours() {
		int expectedHours = 10;
		assertEquals(testAssist.getExtraHours(),expectedHours);
	}

	@Test
	void testGetOverTimeRate() {
		int expectedRate = 10;
		assertEquals(testAssist.getOverTimeRate(),expectedRate);
	}

}
