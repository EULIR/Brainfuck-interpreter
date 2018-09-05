package org.eulir.brainfuck;

import org.eulir.brainfuck.error.IndexOutOfBoundError;
import org.eulir.brainfuck.error.MissBracketError;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Parser {
	private short[] array = new short[32];
	private int index;

	private char[] code;
	private boolean[] censor;

	private Scanner sc = new Scanner(System.in);

	public Parser(char[] code) {
		IntStream.range(0, array.length).forEach(i -> array[i] = 0);
		this.index = 0;
		this.code = code;
		censor = new boolean[this.code.length];
		IntStream.range(0, censor.length).forEach(i -> censor[i] = true);
	}

	public void interpret() {
		for (int i = 0; i < code.length; i++) {
			char c = code[i];
			switch (c) {
				case Token.LESS_THAN:
					index--;
					if (index < 0) throw new IndexOutOfBoundError();
					break;
				case Token.MORE_THAN:
					index++;
					if (index > array.length) expand();
					break;
				case Token.PLUS:
					array[index] = (short) (((int) c == Token.MAX_ROOM) ? Token.MIN_ROOM : ++c);
					break;
				case Token.MIUS:
					array[index] = (short) (((int) c == Token.MIN_ROOM) ? Token.MAX_ROOM : --c);
					break;
				case Token.DOT:
					System.out.print((char) array[index]);
					break;
				case Token.COMMA:
					array[index] = (short) sc.next().charAt(0);
					break;
				case Token.OPEN_BRACKET:
					break;
				case Token.END_BRACKET:
					break;
			}
		}
	}

	public void expand() {
		int length = array.length;
		short[] newArray = new short[length * 2];
		System.arraycopy(array, 0, newArray, 0, length);
		array = newArray;
	}

	public static int[] match(char[] code) {
		ArrayList<Bracket> error = new ArrayList<>();
		int[] matchBracket = new int[code.length];
		Stack<Bracket> left = new Stack<>();
		int lineNum = 1;
		int indexInLine = 0;
		for (int i = 0; i < code.length; i++) {
			char operator = code[i];
			if (operator == Token.OPEN_BRACKET) {
				left.push(new Bracket(i, Token.OPEN_BRACKET, lineNum, indexInLine));
			}
			if (operator == Token.END_BRACKET) {
				if (!left.isEmpty()) {
					Bracket bracket = left.pop();
					matchBracket[i] = bracket.getPos();
					matchBracket[bracket.getPos()] = i;
				} else {
					error.add(new Bracket(i, Token.END_BRACKET, lineNum, indexInLine));
				}
			}
			indexInLine++;
			if (operator == '\n') {
				lineNum++;
				indexInLine = 0;
			}
		}
		error.addAll(left);
		if (!error.isEmpty()) {
			error.forEach(System.err::println);
			throw new MissBracketError("Error information has been listed above");
		}
		return matchBracket;
	}
}
