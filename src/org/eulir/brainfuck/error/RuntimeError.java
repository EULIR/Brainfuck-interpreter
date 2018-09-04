package org.eulir.brainfuck.error;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("WeakerAccess")
public class RuntimeError extends RuntimeException {
	public RuntimeError() {
		super("Run time error has been found when compiling");
	}

	public RuntimeError(@NotNull String message) {
		super(message);
	}
}
