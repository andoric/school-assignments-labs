package cst8284.junit.lab4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CounterTest {
	private Counter counterDefaultZero;
	private static final int VALUE_IS_ZERO = 0;
	private static final int VALUE_IS_ONE = 1;
	private static final int NEGATIVE_VALUE = -1;
	private static final int MAX_VALUE = Integer.MAX_VALUE;
	
	
	
	

	@Before
	public void setUp() throws Exception {
		counterDefaultZero = new Counter(VALUE_IS_ZERO);
	}

	

	@Test
	public void testCounter() {
		Counter defaultConstructorSetsToZeroCounter = new Counter();
		assertEquals(counterDefaultZero,defaultConstructorSetsToZeroCounter);
	}

	@Test
	public void testCounterInt() {
		Counter intConstructorCounter = new Counter(VALUE_IS_ZERO);
		assertEquals(counterDefaultZero,intConstructorCounter);
	}
	@Test 	//bonus
	public void testCounterIntNeg() {
		Counter cannotBeNegativeCounter = new Counter(NEGATIVE_VALUE);
		assertEquals(counterDefaultZero,cannotBeNegativeCounter); 
	}

	@Test
	public void testIncrement() {
		Counter valueIsOneCounter = new Counter(VALUE_IS_ONE);
		counterDefaultZero.increment();
		assertEquals(counterDefaultZero,valueIsOneCounter);
	}

	@Test
	public void testDecrement() {
		Counter valueIsOneCounter = new Counter(VALUE_IS_ONE); 
		valueIsOneCounter.decrement();
		assertEquals(counterDefaultZero,valueIsOneCounter);

	}

	@Test
	public void testGetCount() {
		Counter secondCounter = new Counter(VALUE_IS_ZERO);
		assertEquals(counterDefaultZero.getCount(),secondCounter.getCount());
	}
	
	@Test //bonus
	public void testGetCountFalse() {
		Counter valueIsOneCounter = new Counter(VALUE_IS_ONE);
		assertFalse(counterDefaultZero.getCount()==valueIsOneCounter.getCount());
	}

	@Test
	public void testAdd() {
		Counter valueIsOneCounter = new Counter(VALUE_IS_ONE);
		Counter valueIsTwoCounter = new Counter(2);
//		Counter maxCounter = new Counter(MAX_VALUE);
//		Counter valueIsFiveCounter = new Counter(5);
//		System.out.println(maxCounter.add(valueIsFiveCounter).getCount());  on testing this consistently loses 2 in the math.
//		assertEquals(maxCounter.add(valueIsFiveCounter),valueIsFiveCounter);
		assertEquals(valueIsOneCounter.add(valueIsOneCounter),valueIsTwoCounter); //1+1=2===TRUE
	}

	@Test
	public void testSub() {
		Counter valueIsOneCounter = new Counter(VALUE_IS_ONE);
		Counter valueIsTwoCounter = new Counter(2);
		assertEquals(valueIsTwoCounter.sub(valueIsOneCounter),valueIsOneCounter); //2-1=1===TRUE

	}

	@Test
	public void testToString() {
		String a,b;
		a= counterDefaultZero.toString();
		b= "Count is 0";
		assertEquals(a,b);
	}
	@Test
	public void testMaxValue() {
		Counter maxValueCounter = new Counter(MAX_VALUE);
		maxValueCounter.increment(); //incrementing a max value wraps around to zero.
		assertEquals(counterDefaultZero,maxValueCounter);
	}
	

}
