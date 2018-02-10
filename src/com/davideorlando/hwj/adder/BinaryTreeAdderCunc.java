package com.davideorlando.hwj.adder;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

import com.davideorlando.hwj.model.Node;
import com.davideorlando.hwj.processor.FakeProcessor;

public class BinaryTreeAdderCunc implements BinaryTreeAdder {
	

	private final class NodeAdderTask implements Callable<Integer> {
		private FakeProcessor processor;

		public NodeAdderTask() {
			this.processor = new FakeProcessor();
		}
		
		@Override
		public Integer call() throws Exception {
			Node node = buffer.removeFirst();
			if (node.getSx() != null) {
				buffer.addLast(node.getSx());
				results.add(completion.submit(new NodeAdderTask()));
			}
			if (node.getDx() != null) {
				buffer.addLast(node.getDx());
				results.add(completion.submit(new NodeAdderTask()));
			}
			return processor.onerousFunction(node.getValue());
		}
	}

	private Deque<Node> buffer;
	private ExecutorService pool;
	private LinkedBlockingQueue<Future<Integer>> results;
	private CompletionService<Integer> completion;

	public BinaryTreeAdderCunc() {
		this.buffer = new LinkedBlockingDeque<>();
		this.pool = Executors.newFixedThreadPool(java.lang.Runtime.getRuntime().availableProcessors());
		this.results = new LinkedBlockingQueue<>();
		this.completion = new ExecutorCompletionService<>(pool);
	}

	@Override
	public int computeOnerousSum(Node root) {
		if(root==null)
			return 0;
		try {
			this.buffer.addFirst(root);
			int somma= pool.submit(new NodeAdderTask()).get();
			Iterator<Future<Integer>> it = results.iterator();
			while(it.hasNext()) {
				somma += completion.take().get();
				it.next();
			}
			return somma;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return 0;
		} finally {
			pool.shutdown();
		}

	}

}
