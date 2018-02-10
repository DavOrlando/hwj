package com.davideorlando.hwj;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.davideorlando.hwj.adder.BinaryTreeAdderCunc;
import com.davideorlando.hwj.model.BinaryTreeBroker;
import com.davideorlando.hwj.model.Node;
import com.davideorlando.hwj.model.SimpleNode;

public class BinaryTreeAdderCuncTest {
	
	private Node fogliaConValoreUno;

	
	@Before
	public void setUp() throws Exception {
		fogliaConValoreUno = new SimpleNode(1);
	}

	@Test
	public void test_ComputeOnerousSum_SommaSuNull() {
		assertEquals(0, new BinaryTreeAdderCunc().computeOnerousSum(null));
	}
	
	@Test
	public void test_ComputeOnerousSum_SommaSuFogliaConValoreUno() {
		assertEquals(1, new BinaryTreeAdderCunc().computeOnerousSum(fogliaConValoreUno));
	}
	
	@Test
	public void test_ComputeOnerousSum_SommaSuAlberoValoreDueFiglioDestro() {
		Node nodoConValoreUnoFiglioDestro = new SimpleNode(null,fogliaConValoreUno,1);
		assertEquals(2, new BinaryTreeAdderCunc().computeOnerousSum(nodoConValoreUnoFiglioDestro));
	}
	
	@Test
	public void test_ComputeOnerousSum_SommaSuAlberoValoreTreFiglioSinistro() {
		Node nodoConValore3FiglioSinistro = new SimpleNode(fogliaConValoreUno,null,2);
		assertEquals(3, new BinaryTreeAdderCunc().computeOnerousSum(nodoConValore3FiglioSinistro));
	}
	
	@Test
	public void test_ComputeOnerousSum_SommaSuAlberoSommaQuattro() {
		Node alberoSommaQuattro = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(4);
		assertEquals(4, new BinaryTreeAdderCunc().computeOnerousSum(alberoSommaQuattro));
	}
	
	@Test
	public void test_ComputeOnerousSum_SommaSuAlberoSommaMille() {
		Node mille = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(1000);
		assertEquals(1000, new BinaryTreeAdderCunc().computeOnerousSum(mille));
	}
	
	@Test
	public void test_ComputeOnerousSum_SommaSuAlberoSommaDiecimila() {
		Node diecimila = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(10000);
		assertEquals(10000, new BinaryTreeAdderCunc().computeOnerousSum(diecimila));
	}
}
