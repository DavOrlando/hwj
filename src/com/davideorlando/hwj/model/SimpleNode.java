package com.davideorlando.hwj.model;

public class SimpleNode implements Node {

	private Node sx;
	private Node dx;
	private int value;

	public SimpleNode(Node sx, Node dx, int value) {
		this.sx = sx;
		this.dx = dx;
		this.value = value;
	}

	public SimpleNode(int value) {
		this.value = value;
	}

	@Override
	public Node getSx() {
		return this.sx;
	}

	@Override
	public Node getDx() {
		return this.dx;
	}

	@Override
	public int getValue() {
		return value;
	}


}
