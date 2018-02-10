package com.davideorlando.hwj.model;

public class BinaryTreeBroker {
	
	private static final int VALORE_UNO = 1;
	public static BinaryTreeBroker instance = new BinaryTreeBroker();
	
	private BinaryTreeBroker() {
		
	}
	
	public Node getBinaryTreeWithAllValuesOne(int numeroNodi) {
		if (numeroNodi==1)
			return new SimpleNode(VALORE_UNO);
		else if(numeroNodi==2)
			return new SimpleNode(getBinaryTreeWithAllValuesOne(numeroNodi-1),null,VALORE_UNO);
		return new SimpleNode(getBinaryTreeWithAllValuesOne(numeroNodi/2),getBinaryTreeWithAllValuesOne((numeroNodi-1)/2),VALORE_UNO);
	}
	
	public static synchronized BinaryTreeBroker getInstance() {
		return instance;
	}
}
