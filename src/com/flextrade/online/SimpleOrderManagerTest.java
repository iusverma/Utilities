package com.flextrade.online;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleOrderManagerTest {
	private static String INVALID_OPERATION_MSG = "Invalid Operation";

	@Test
	public void testSimpleOrderManagerObjectCreation() {
		SimpleOrderManager sim = new SimpleOrderManager(null, null);
		Assert.assertNotNull(sim);
	}

	@Test(expectedExceptions=NullPointerException.class)
	public void testSimpleOrderManagerOrderStoreNull() {
		SimpleOrderManager sim = new SimpleOrderManager(null, null);
		sim.writeAllOrders();
	}
	
	@Test(expectedExceptions=InvalidOperationException.class)
	public void testInvalidOperationException() {
		throw new InvalidOperationException(INVALID_OPERATION_MSG);
	}
	
	@Test
	public void testInvalidOperationExceptionMessage() {
		try {
			throw new InvalidOperationException(INVALID_OPERATION_MSG);
		}catch(InvalidOperationException e) {
			Assert.assertEquals(e.getMessage(), INVALID_OPERATION_MSG);
		}
	}
	
	@Test
	public void testSimpleOrderManagerOrdersEmptyOrNull() {
		//TODO: write code when OrderStore & OrderWriter are implemented by some class
	}
	
	@Test
	public void testSimpleOrderManagerWriteAllOrders() {
		//TODO: write code when OrderStore & OrderWriter are implemented by some class
	}
}
