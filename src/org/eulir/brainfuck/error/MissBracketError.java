package org.eulir.brainfuck.error;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("WeakerAccess")
public class MissBracketError extends RuntimeError {
	public MissBracketError(@NotNull String message) {
		super(message);
	}

	public MissBracketError(int leftOrRight, int anotherBracketIndex) {
		this("Miss a " + (leftOrRight == 0 ? "left" : "right") + " bracket: the " +
				(leftOrRight == 0 ? "right" : "left") + "bracket is at " + anotherBracketIndex);
	}
}
