package org.eulir.brainfuck;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BVM {
	private short[] array = new short[32];
	private int index;

	private Scanner sc = new Scanner(System.in);

	public BVM() {
		IntStream.range(0, array.length).forEach(i -> array[i] = 0);
		this.index = 0;
	}

	public void interpret() {

	}
}
