package com.davideorlando.hwj.model;

import java.util.Spliterator;
import java.util.function.Consumer;

public class NodeSpliterator<T> implements Spliterator<T> {

	private Node root;
	private boolean isSxSplitted;
	private boolean isDxSplitted;


	public NodeSpliterator(Node root) {
		this.root=root;
		this.isDxSplitted=false;
		this.isSxSplitted=false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean tryAdvance(Consumer<? super T> action) {
		action.accept((T) root);
		return false;
	}

	@Override
	public Spliterator<T> trySplit() {
		if(root.getDx()==null && root.getSx()==null)
			return null;
		if(root.getSx()!= null && !isSxSplitted) {
			this.isSxSplitted = true;
			return new NodeSpliterator<>(root.getSx());
		}
		if(root.getDx()!=null && !isDxSplitted) {
			this.isDxSplitted = true;
			return new NodeSpliterator<>(root.getDx());
		}
		return null;
	}

	@Override
	public long estimateSize() {
		return Long.MAX_VALUE;
	}

	@Override
	public int characteristics() {
		return 0;
	}

}
