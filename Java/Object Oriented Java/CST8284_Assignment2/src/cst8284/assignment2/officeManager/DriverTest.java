package cst8284.assignment2.officeManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DriverTest {
	private Driver testDriver;

	@BeforeEach
	void setUp() throws Exception {
		testDriver = new Driver("Tyler", "Bay", 100);
		testDriver.setLicense("ABCDE");
		testDriver.setAddress("123 Fake St");
		testDriver.setTrafficViolations(0);
		testDriver.setNumDrivingHours(100);
		testDriver.setHourlyRate(10);
	}


	@Test
	void testComputeSalary() {
		double calcValue = 1000;
		assertEquals(testDriver.computeSalary(),calcValue);
	}

	@Test
	void testToString() {
		String toStringValue = ("Job Function: Driver:"+"\n"
				+"Name: "+"Tyler Bay"+"\n"
				+"Address: "+"123 Fake St"+"\n"
				+"Salary: "+"1000.0"+"\n"
				+"Driver Licence Number: "+"ABCDE"+"\n"
				+"Hourly Rate: " + "10.0"+"\n"
				+"Number of Hours: "+"100"+"\n"
				+"Number of traffic violations: "+"0"+"\n");
		assertEquals(testDriver.toString(),toStringValue);
	}


	@Test
	void testCanDrive() {
		Driver cannotDriveViolations = new Driver();
		Driver cannotDriveHours = new Driver();
		cannotDriveViolations.setTrafficViolations(4);
		cannotDriveHours.setNumDrivingHours(301);
		assertFalse(cannotDriveViolations.canDrive());
		assertFalse(cannotDriveHours.canDrive());
		assertTrue(testDriver.canDrive());
	}

	@Test
	void testSetLicense() {
		String newLicense = "EFGH";
		testDriver.setLicense(newLicense);
		assertEquals(testDriver.getLicense(),newLicense);
	}

	@Test
	void testSetTrafficViolations() {
		int newViolations = 1;
		testDriver.setTrafficViolations(newViolations);
		assertEquals(testDriver.getTrafficViolations(),newViolations);
	}

	@Test
	void testSetNumDrivingHours() {
		int newHours = 200;
		testDriver.setNumDrivingHours(newHours);
		assertEquals(testDriver.getNumHours(),newHours);
	}

	@Test
	void testSetHourlyRate() {
		double newRate=12;
		testDriver.setHourlyRate(newRate);
		assertEquals(testDriver.getHourlyRate(),newRate);
	}

	@Test
	void testGetLicense() {
		String licenseValue = "ABCDE";
		assertEquals(testDriver.getLicense(),licenseValue);
	}

	@Test
	void testGetTrafficViolations() {
		int violationValue = 0;
		assertEquals(testDriver.getTrafficViolations(),violationValue);
	}

	@Test
	void testGetNumHours() {
		int hoursValue = 100;
		assertEquals(testDriver.getNumHours(),hoursValue);
	}
	@Test
	void testGetBaseSalary() {
		double baseSalary = testDriver.getNumHours()*testDriver.getHourlyRate();
		assertEquals(testDriver.getBaseSalary(), baseSalary);
	}

}
