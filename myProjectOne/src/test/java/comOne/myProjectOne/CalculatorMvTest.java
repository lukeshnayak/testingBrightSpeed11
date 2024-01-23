package comOne.myProjectOne;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorMvTest {
	
	//Global Class variable ref 
	CalculatorMv c;
	
	//setup method is responsible to initialize resources
	@Before
	public void setUp() throws Exception {
		c=new CalculatorMv();
	}
	
	//tearDown method is responsible to release resources  
	@After
	public void tearDown() throws Exception {
		c=null;
	}

	//it is a test case
	@Test
	public void testAddition() {
		int result=c.addition(4, 5);
		
		assert result >5:"value should be greater than 5";
	}

	@Test
	public void testSubstract() {
         int result=c.substract(4, 5);
         assert result <5:"value should be greater than 5";
	}

	@Test
	public void testMultiplication() {
		int result= c.multiplication(4, 5);
		assert result >5:"value should be greater than 5";
	}

	@Test
	public void testDivision() {
		int result=c.division(4, 5);
		assert result <5:"value should be greater than 5";
	}

}
