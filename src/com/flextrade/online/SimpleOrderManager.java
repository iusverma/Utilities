package com.flextrade.online;

import java.util.Collection;
import java.util.List;

class SimpleOrderManager {

	private final OrderStore orderStore;
	private final OrderWriter orderWriter;

	public SimpleOrderManager(OrderStore orderStore, OrderWriter orderWriter) {
		this.orderStore = orderStore;
		this.orderWriter = orderWriter;
	}

	public void writeAllOrders() {
		List<Order> allOrders = orderStore.getOrders();
		if (allOrders.size() == 0) {
			throw new InvalidOperationException("No orders in store");
		}
		this.orderWriter.writeOrders(allOrders);
	}
}

// These interfaces and classes already exist in the system.
interface OrderWriter {
	void writeOrders(Collection<Order> orders);
}

interface OrderStore {
	List<Order> getOrders();
}

class Order {
}

class InvalidOperationException extends RuntimeException {
	public InvalidOperationException(String reason) {
		super(reason);
	}
}