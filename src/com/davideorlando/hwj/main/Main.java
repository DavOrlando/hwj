package com.davideorlando.hwj.main;

import com.davideorlando.hwj.adder.BinaryTreeAdderCunc;
import com.davideorlando.hwj.adder.BinaryTreeAdderForkJoin;
import com.davideorlando.hwj.adder.BinaryTreeAdderSerial;
import com.davideorlando.hwj.adder.BinaryTreeAdderStream;
import com.davideorlando.hwj.model.BinaryTreeBroker;
import com.davideorlando.hwj.model.Node;

public class Main {

	private static final int CENTO = 100;
	private static final int MILLE = 1000;
	private static final int DIECIMILA = 10000;
	private static final int CENTOMILA = 100000;
	private static final int TRECENTOMILA = 300000;

	public static void main(String[] args) {

		Main main = new Main();
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("Preparazione di alcuni alberi...");
		System.out.println("Albero con 100 nodi.");
		Node centoTree = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(CENTO);
		System.out.println("Albero con 1000 nodi.");
		Node milleTree = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(MILLE);
		System.out.println("Albero con 10000 nodi.");
		Node diecimilaTree = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(DIECIMILA);
		System.out.println("Albero con 100000 nodi.");
		Node centomilaTree = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(CENTOMILA);
		System.out.println("Albero con 1000000 nodi.");
		Node trecentomilaTre = BinaryTreeBroker.getInstance().getBinaryTreeWithAllValuesOne(TRECENTOMILA);
		System.out.println("Preparazione completata!");
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("\n\n");

		main.warmUp(diecimilaTree);

		// HWJ1 Misurazione speed-up
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("Speed-Up HWJ1 - Soluzione Concorrente");
		System.out.println("Speed-up - 100 nodi:\t" + main.getSpeedUpCunc(centoTree));
		System.out.println("Speed-up - 1000 nodi:\t" + main.getSpeedUpCunc(milleTree));
		System.out.println("Speed-up - 10000 nodi:\t" + main.getSpeedUpCunc(diecimilaTree));
		System.out.println("Speed-up - 100000 nodi:\t" + main.getSpeedUpCunc(centomilaTree));
		System.out.println("Speed-up - 300000 nodi:\t" + main.getSpeedUpCunc(trecentomilaTre));
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("\n\n");

		// HWJ3 Misurazione speed-up
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("Speed-Up HWJ3 - Soluzione Fork/Join");
		System.out.println("Speed-up - 100 nodi:\t" + main.getSpeedUpForkJoin(centoTree));
		System.out.println("Speed-up - 1000 nodi:\t" + main.getSpeedUpForkJoin(milleTree));
		System.out.println("Speed-up - 10000 nodi:\t" + main.getSpeedUpForkJoin(diecimilaTree));
		System.out.println("Speed-up - 100000 nodi:\t" + main.getSpeedUpForkJoin(centomilaTree));
		System.out.println("Speed-up - 300000 nodi:\t" + main.getSpeedUpForkJoin(trecentomilaTre));
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("\n\n");

		// HWJ4 Misurazione speed-up
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("Speed-Up HWJ4 - Soluzione Stream");
		System.out.println("Speed-up - 100 nodi:\t" + main.getSpeedUpStream(centoTree));
		System.out.println("Speed-up - 1000 nodi:\t" + main.getSpeedUpStream(milleTree));
		System.out.println("Speed-up - 10000 nodi:\t" + main.getSpeedUpStream(diecimilaTree));
		System.out.println("Speed-up - 100000 nodi:\t" + main.getSpeedUpStream(centomilaTree));
		System.out.println("Speed-up - 300000 nodi:\t" + main.getSpeedUpStream(trecentomilaTre));
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("\n\n");

	}

	private String getSpeedUpStream(Node tree) {
		return new Double(getTimeSerialSum(tree) / getTimeStreamSum(tree)).toString();
	}

	private String getSpeedUpCunc(Node tree) {
		return new Double(getTimeSerialSum(tree) / getTimeCuncSum(tree)).toString();
	}

	private String getSpeedUpForkJoin(Node tree) {
		return new Double(getTimeSerialSum(tree) / getTimeForkJoinSum(tree)).toString();
	}

	private double getTimeStreamSum(Node tree) {
		double beforeStreamSum = System.currentTimeMillis();
		new BinaryTreeAdderStream().computeOnerousSum(tree);
		double afterStreamSum = System.currentTimeMillis();
		return afterStreamSum - beforeStreamSum;
	}

	private double getTimeSerialSum(Node tree) {
		double beforeSerialSum = System.currentTimeMillis();
		new BinaryTreeAdderSerial().computeOnerousSum(tree);
		double afterSerialSum = System.currentTimeMillis();
		return afterSerialSum - beforeSerialSum;
	}

	private double getTimeCuncSum(Node tree) {
		double beforeCuncSum = System.currentTimeMillis();
		new BinaryTreeAdderCunc().computeOnerousSum(tree);
		double afterCuncSum = System.currentTimeMillis();
		return afterCuncSum - beforeCuncSum;
	}

	private double getTimeForkJoinSum(Node tree) {
		double beforeCuncSum = System.currentTimeMillis();
		new BinaryTreeAdderForkJoin().computeOnerousSum(tree);
		double afterCuncSum = System.currentTimeMillis();
		return afterCuncSum - beforeCuncSum;
	}

	private void warmUp(Node tree) {
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("Warm-up:");
		for (int i = 0; i < 3; i++)
			warmUpForSerialSum(tree);
		for (int i = 0; i < 3; i++)
			warmUpForCuncSum(tree);
		for (int i = 0; i < 3; i++)
			warmUpForForkJoinSum(tree);
		for (int i = 0; i < 3; i++)
			warmUpForStreamSum(tree);
		System.out.println("Warm-up completo!");
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("\n\n\n\n");
	}

	private void warmUpForSerialSum(Node tree) {
		System.out.println("Inizio della somma con algoritmo seriale");
		double timeForSum = getTimeSerialSum(tree);
		System.out.println(
				"Fine della somma con algoritmo seriale. " + "Tempo necessario: " + timeForSum / 1000 + " secondi");
	}

	private void warmUpForCuncSum(Node tree) {
		System.out.println("Inizio della somma con algoritmo parallelo");
		double timeForSum = getTimeCuncSum(tree);
		System.out.println(
				"Fine della somma con algoritmo parallelo. " + "Tempo necessario: " + timeForSum / 1000 + " secondi");
	}

	private void warmUpForForkJoinSum(Node tree) {
		System.out.println("Inizio della somma con framework fork/join");
		double timeForSum = getTimeForkJoinSum(tree);
		System.out.println(
				"Fine della somma con framework fork/join. " + "Tempo necessario: " + timeForSum / 1000 + " secondi");
	}

	private void warmUpForStreamSum(Node tree) {
		System.out.println("Inizio della somma con stream");
		double timeForSum = getTimeStreamSum(tree);
		System.out.println("Fine della somma con stream. " + "Tempo necessario: " + timeForSum / 1000 + " secondi");

	}

}
