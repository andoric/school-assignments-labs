package cst8284.assignment2.officeManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	private Employee testEmp;

	@BeforeEach
	void setUp() throws Exception {
		testEmp = new Employee("Tyler", "Bay", 100);
		testEmp.setAddress("123 Fake St");
	}


	@Test
	void testGetName() {
		String name = "Tyler Bay";
		assertEquals(testEmp.getName(), name);
	}

	@Test
	void testSetFirstName() {
		String newFirstName = "Jason";
		String newExpectedName = "Jason Bay";
		testEmp.setFirstName(newFirstName);
		assertEquals(testEmp.getName(),newExpectedName);
	}

	@Test
	void testSetLastName() {
		String newLastName = "Munro";
		String newExpectedName = "Tyler Munro";
		testEmp.setLastName(newLastName);
		assertEquals(testEmp.getName(),newExpectedName);
	}

	@Test
	void testSetAddress() {
		String newAddress = "1318 Gladu St";
		testEmp.setAddress(newAddress);
		assertEquals(testEmp.getAddress(), newAddress);
	}

	@Test
	void testSetBaseSalary() {
		double newSalary = 200;
		testEmp.setBaseSalary(newSalary);
		assertEquals(testEmp.getBaseSalary(),newSalary);
	}

	@Test
	void testGetBaseSalary() {
		double baseSalary = 100;
		assertEquals(testEmp.getBaseSalary(), baseSalary);
	}

	@Test
	void testGetAddress() {
		String address = "123 Fake St";
		assertEquals(testEmp.getAddress(), address);
	}

	@Test
	void testComputeSalary() {
		double finalSalary = 100;
		assertEquals(testEmp.computeSalary(),finalSalary);
	}

	@Test
	void testToString() {
		String toStringValue = ("Name: Tyler Bay"+"\n"
				+ "Address: 123 Fake St"+"\n"
				+ "Salary: 100.0"+"\n");
		assertEquals(testEmp.toString(),toStringValue);
	}

}
