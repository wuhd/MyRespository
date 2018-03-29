package com.java.test.strings;

public class TestCase {
	public static void main(String[] args) {
		String msg = "9950000002581849@xmpp07.cqccn.com";
		System.out.println(msg.substring(0, msg.indexOf("@")));
		System.out.println(msg.substring(msg.indexOf("@"), msg.length()));
	}
}
