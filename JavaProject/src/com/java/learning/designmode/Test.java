package com.java.learning.designmode;

public class Test {
	public static void main(String[] args) {
		// ����Ŀ�����
		ConcreteSubject subject = new ConcreteSubject();
		// �����۲��߶���
		Observer observer = new ConcreteObserver();
		// ���۲��߶���ע�ᵽĿ�������
		subject.attach(observer);
		// �ı�Ŀ������״̬
		subject.change("I change");
		
	}
}
