package org.eulir.brainfuck.core;

public class Bracket {
	private int position;
	private char bracket;
	private int lineNum;
	private int indexInLine;

	public Bracket(int pos, char bracket, int line, int index) {
		position = pos;
		this.bracket = bracket;
		lineNum = line;
		indexInLine = index;
	}

	public String error() {
		return "Unclosed " + bracket + " in line " + lineNum + " index " + indexInLine + "\n";
	}


	public int getPos() {
		return position;
	}
}
