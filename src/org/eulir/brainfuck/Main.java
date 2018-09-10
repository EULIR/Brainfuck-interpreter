package org.eulir.brainfuck;

import org.eulir.brainfuck.core.Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	private static String code;

	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String tempString;
			while ((tempString = reader.readLine()) != null) sb.append(tempString);
			code = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void run(){
		readFileByLines("./code/OneDigitPlus.bf");
		Parser p = new Parser(code.toCharArray());
		p.interpret();
	}

	public static void main(String[] args) {
		run();
	}
}
