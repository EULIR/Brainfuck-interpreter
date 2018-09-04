package org.eulir.brainfuck.error;

@SuppressWarnings("WeakerAccess")
public class IndexOutOfBoundError extends RuntimeException {
	public IndexOutOfBoundError() {
		super("Index out of bound: -1");
	}
}
