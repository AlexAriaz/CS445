package edu.iit.cs445.vin;

import static org.junit.Assert.*;
import org.junit.Test;

public class AdminTest {
	
	@Test
	public void test_Admin()throws AssertionError{
		Admin a=new Admin();
		assertEquals("Default Admin", a.getName());
		assertEquals(502,a.getID());
	}
	
	@Test
	public void test_nonDefaultAdmin()throws AssertionError{
		Admin a=new Admin("Bob");
		assertEquals("Bob", a.getName());
		assertEquals(500, a.getID());
	}
	
	@Test
	public void test_setName(){
		Admin a=new Admin();
		a.setName("Dante Bosco");
		assertTrue("Dante Bosco".equals(a.getName()));
	}
	
}
