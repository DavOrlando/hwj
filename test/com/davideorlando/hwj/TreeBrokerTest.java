package com.davideorlando.hwj;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.davideorlando.hwj.model.BinaryTreeBroker;
import com.davideorlando.hwj.model.Node;

public class TreeBrokerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_getBinaryTree_Foglia() {
		Node binaryTree = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(1);
		assertNull(binaryTree.getSx());
		assertNull(binaryTree.getDx());
	}
	
	@Test
	public void test_getBinaryTree_NodoConFiglioSinistro() {
		Node binaryTree = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(2);
		assertNotNull(binaryTree.getSx());
		assertNull(binaryTree.getDx());
	}
	
	@Test
	public void test_getBinaryTree_AlberoDueFigli() {
		Node binaryTree = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(3);
		assertNotNull(binaryTree.getSx());
		assertNotNull(binaryTree.getDx());
		assertNull(binaryTree.getDx().getDx());
		assertNull(binaryTree.getDx().getSx());
		assertNull(binaryTree.getSx().getDx());
		assertNull(binaryTree.getSx().getSx());
	}
	
	@Test
	public void test_getBinaryTree_AlberoQuattroElementi() {
		Node binaryTree = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(4);
		assertNotNull(binaryTree.getSx());
		assertNotNull(binaryTree.getDx());
		assertNotNull(binaryTree.getSx().getSx());
		assertNull(binaryTree.getSx().getDx());
		assertNull(binaryTree.getDx().getDx());
		assertNull(binaryTree.getDx().getSx());
	}
	
	@Test
	public void test_getBinaryTree_AlberoCinqueElementi() {
		Node binaryTree = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(5);
		assertNotNull(binaryTree.getSx());
		assertNotNull(binaryTree.getDx());
		assertNotNull(binaryTree.getSx().getSx());
		assertNotNull(binaryTree.getDx().getSx());
		assertNull(binaryTree.getSx().getDx());
		assertNull(binaryTree.getDx().getDx());
	}
	
	@Test
	public void test_getBinaryTree_AlberoSeiElementi() {
		Node binaryTree = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(6);
		assertNotNull(binaryTree.getSx());
		assertNotNull(binaryTree.getDx());
		assertNotNull(binaryTree.getSx().getSx());
		assertNotNull(binaryTree.getDx().getSx());
		assertNotNull(binaryTree.getSx().getDx());
		assertNull(binaryTree.getDx().getDx());
	}

	@Test
	public void test_getBinaryTree_AlberoSetteElementi() {
		Node binaryTree = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(7);
		assertNotNull(binaryTree.getSx());
		assertNotNull(binaryTree.getDx());
		assertNotNull(binaryTree.getSx().getSx());
		assertNotNull(binaryTree.getDx().getSx());
		assertNotNull(binaryTree.getSx().getDx());
		assertNotNull(binaryTree.getDx().getDx());
	}
}
