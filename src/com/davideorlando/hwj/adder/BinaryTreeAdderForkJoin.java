package com.davideorlando.hwj.adder;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import com.davideorlando.hwj.model.Node;
import com.davideorlando.hwj.processor.FakeProcessor;

public class BinaryTreeAdderForkJoin implements BinaryTreeAdder {

	private final class NodeAdderTask extends RecursiveTask<Integer> {

		private Node node;
		private FakeProcessor processor;

		public NodeAdderTask(Node node) {
			this.node = node;
			this.processor = new FakeProcessor();
		}

		@Override
		protected Integer compute() {
			Integer acc = 0;
			ArrayList<NodeAdderTask> pendings = new ArrayList<>();
			if (node.getSx() != null) {
				NodeAdderTask nodeAdderTask = new NodeAdderTask(node.getSx());
				nodeAdderTask.fork();
				pendings.add(nodeAdderTask);
			}
			if (node.getDx() != null) {
				NodeAdderTask nodeAdderTask = new NodeAdderTask(node.getDx());
				nodeAdderTask.fork();
				pendings.add(nodeAdderTask);
			}
			for (NodeAdderTask nodo : pendings) 
				acc += nodo.join();
			return acc + this.processor.onerousFunction(node.getValue());
		}
	}

	private ForkJoinPool pool;

	public BinaryTreeAdderForkJoin() {
		this.pool = new ForkJoinPool();
	}

	@Override
	public int computeOnerousSum(Node root) {
		if (root == null)
			return 0;
		return pool.invoke(new NodeAdderTask(root));
	}

}
