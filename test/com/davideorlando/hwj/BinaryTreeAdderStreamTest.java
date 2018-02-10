package com.davideorlando.hwj;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.davideorlando.hwj.adder.BinaryTreeAdderStream;
import com.davideorlando.hwj.model.BinaryTreeBroker;
import com.davideorlando.hwj.model.Node;
import com.davideorlando.hwj.model.SimpleNode;

public class BinaryTreeAdderStreamTest {
	
	private Node fogliaConValoreUno;

	
	@Before
	public void setUp() throws Exception {
		fogliaConValoreUno = new SimpleNode(1);
	}

	@Test
	public void test_ComputeOnerousSum_SommaSuNull() {
		assertEquals(0, new BinaryTreeAdderStream().computeOnerousSum(null));
	}
	
	@Test
	public void test_ComputeOnerousSum_SommaSuFogliaConValoreUno() {
		assertEquals(1, new BinaryTreeAdderStream().computeOnerousSum(fogliaConValoreUno));
	}
	
	@Test
	public void test_ComputeOnerousSum_SommaSuAlberoConDueFigliDestra() {
		Node alberoConDueFigliDestra = new SimpleNode(null,new SimpleNode(null,fogliaConValoreUno,1),1);
		assertEquals(3, new BinaryTreeAdderStream().computeOnerousSum(alberoConDueFigliDestra));
	}
	
	@Test
	public void test_ComputeOnerousSum_SommaSuAlberoValoreTreFiglioDestro() {
		Node nodoConValore3FiglioSinistro = new SimpleNode(null,fogliaConValoreUno,2);
		assertEquals(3, new BinaryTreeAdderStream().computeOnerousSum(nodoConValore3FiglioSinistro));
	}
	
	@Test
	public void test_ComputeOnerousSum_SommaSuAlberoSommaQuattro() {
		Node alberoSommaQuattro = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(4);
		assertEquals(4, new BinaryTreeAdderStream().computeOnerousSum(alberoSommaQuattro));
	}
	
	@Test
	public void test_ComputeOnerousSum_SommaSuAlberoSommaMille() {
		Node mille = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(1000);
		assertEquals(1000, new BinaryTreeAdderStream().computeOnerousSum(mille));
	}
	
	@Test
	public void test_ComputeOnerousSum_SommaSuAlberoSommaDiecimila() {
		Node diecimila = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(10000);
		assertEquals(10000, new BinaryTreeAdderStream().computeOnerousSum(diecimila));
	}
}
