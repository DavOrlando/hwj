package com.davideorlando.hwj.adder;

import java.util.stream.StreamSupport;

import com.davideorlando.hwj.model.Node;
import com.davideorlando.hwj.model.NodeSpliterator;
import com.davideorlando.hwj.processor.FakeProcessor;

public class BinaryTreeAdderStream implements BinaryTreeAdder {

	@Override
	public int computeOnerousSum(Node root) {
		if(root==null)
			return 0;
		return StreamSupport.stream(new NodeSpliterator<Node>(root),true)
		.mapToInt(x->new FakeProcessor().onerousFunction(x.getValue()))
		.sum();
	}

}
