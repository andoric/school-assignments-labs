package cst8284.assignment2.officeManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupervisorTest {
	Supervisor testSup;

	@BeforeEach
	void setUp() throws Exception {
		testSup = new Supervisor("Tyler", "Bay", 100);
		testSup.setAddress("123 Fake St");
		testSup.setBonus(100);
	}

	@Test
	void testComputeSalary() {
		double expectedSalary = 200;
		assertEquals(testSup.computeSalary(),expectedSalary);
	}

	@Test
	void testToString() {
		String expectedToString = ("Job Function: Supervisor" +"\n"
				+"Name: "+"Tyler Bay"+"\n"
				+"Address: "+"123 Fake St"+"\n"
				+"Salary: "+"100.0"+"\n"
				+"Bonus: "+"100.0" +"\n"
				);
		assertEquals(testSup.toString(), expectedToString);
	}

	@Test
	void testGetBonus() {
		double expectedBonus = 100;
		assertEquals(testSup.getBonus(),expectedBonus);
	}

	@Test
	void testSetBonus() {
		double newBonus = 200;
		testSup.setBonus(newBonus);
		assertEquals(testSup.getBonus(),newBonus);
	}

}
