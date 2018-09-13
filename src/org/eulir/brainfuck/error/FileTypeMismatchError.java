package org.eulir.brainfuck.error;

@SuppressWarnings("WeakerAccess")
public class FileTypeMismatchError extends RuntimeError {
	public FileTypeMismatchError() {
		super("A Brainfuck file is required in this brainfuck interpreter");
	}
}
