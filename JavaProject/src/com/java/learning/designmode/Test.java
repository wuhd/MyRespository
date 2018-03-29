package com.java.learning.designmode;

public class Test {
	public static void main(String[] args) {
		// 创建目标对象
		ConcreteSubject subject = new ConcreteSubject();
		// 创建观察者对象
		Observer observer = new ConcreteObserver();
		// 将观察者对象注册到目标对象上
		subject.attach(observer);
		// 改变目标对象的状态
		subject.change("I change");
		
	}
}
