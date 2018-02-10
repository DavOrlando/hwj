package com.davideorlando.hwj.processor;

public class FakeProcessor implements OnerousProcessor {
	private static final int LENTEZZA_MIN = 2000;
	public final static int MIN_COUNT = 1000;
	private int max;
	private java.util.Random random;

	public FakeProcessor(int max) {
		this.max = max;
		this.random = new java.util.Random();
	}

	public FakeProcessor() {
		this(LENTEZZA_MIN);
	}

	@Override
	public int onerousFunction(int value) {
		int r = this.random.nextInt(this.max);
		int n = Math.max(MIN_COUNT, r); // non meno di MIN_COUNT
		// useless but onerous
		for (int counter = 0; counter < n; counter++) {
			r = this.random.nextInt(this.max); // maschera casuale
			r = r ^ this.random.nextInt(this.max); // inverti i bit
			r = r ^ this.random.nextInt(this.max); // due volte
		}
		return value; // n.b. value risulta invariato
	}
}