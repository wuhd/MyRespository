package com.java.learning.designmode;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	public void detach(Observer observer){
		observers.remove(observer);
	}
	
	public void notifyChange(String state){
		for (Observer observer : observers) {
			observer.update(state);
		}
	}
}	
