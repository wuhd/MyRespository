package com.java.learning.designmode;

public class ConcreteObserver implements Observer {

	private String observerState;
	
	public void update(String state) {
		observerState = state;
		
		System.out.println("ConcreteObserver state " + observerState);
	}

}
