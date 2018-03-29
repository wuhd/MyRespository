package com.java.learning.designmode;
/**
 * 具体的观察者对象
 */
public class ConcreteObserver implements Observer {

	private String observerState;
	
	public void update(String state) {
		observerState = state;
		
		System.out.println("ConcreteObserver state " + observerState);
	}

}
