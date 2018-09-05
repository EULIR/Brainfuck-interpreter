package org.eulir.brainfuck;

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

	@Override
	public String toString() {
		return "Unclosed " + bracket + " in line " + lineNum + " index " + indexInLine + "\n";
	}

	public int getPos() {
		return position;
	}
}
