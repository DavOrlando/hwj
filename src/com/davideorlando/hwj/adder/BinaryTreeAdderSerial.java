package com.davideorlando.hwj.adder;

import com.davideorlando.hwj.model.Node;
import com.davideorlando.hwj.processor.FakeProcessor;
import com.davideorlando.hwj.processor.OnerousProcessor;

public class BinaryTreeAdderSerial implements BinaryTreeAdder {

	private OnerousProcessor fakeProcessor;

	public BinaryTreeAdderSerial() {
		this.fakeProcessor = new FakeProcessor();
	}

	@Override
	public int computeOnerousSum(Node root) {
		if (root == null)
			return 0;
		return onerousValue(root.getValue()) + computeOnerousSum(root.getDx()) + computeOnerousSum(root.getSx()); 
	}

	private int onerousValue(int value) {
		return this.fakeProcessor.onerousFunction(value);
	}

}
