package com.java.learning.designmode;

public class ConcreteSubject extends Subject {
	private String state;
	
	public void setState(String state){
		this.state = state;
	}
	
	public void change(String newState){
		setState(newState);
		System.out.println("ConcreteSubject state " + state);
		notifyChange(state);
	}
}
