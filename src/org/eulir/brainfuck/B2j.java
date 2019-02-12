import java.util.Scanner;

public class B2j {
	private static int[] p = new int[32768];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String code = sc.nextLine();
		int prog_len = code.length();
		System.out.println("import java.util.Scanner;\n\npublic class Main {\n	public static void main(String[] args) {\n		Scanner sc = new Scanner(System.in);\n		int[] x = new int[32768];\n		for (int xc = 0; xc < 32768; xc++) p[xc] = 0;\n		int index = 0;");
		for (int pc = 0; pc < prog_len; pc++) {
			switch (code.charAt(pc)) {
				case 43: 
					System.out.println("		x[index]++;");
					break;
				case 45:
					System.out.println("		x[index]--;");
					break;
				case 46:
					System.out.println("		System.out.print((char) x[index]);");
					break;
				case 44:
					System.out.println("		x[index] = sc.nextChar();");
					break;
				case 62:
					System.out.println("		index++;");
					break;
				case 60:
					System.out.println("		index--;");
					break;
				case 91:
					System.out.println("		while (x[index] != 0) {");
					break;
				case 93:
					System.out.println("		}");
					break;
			}
		}
		System.out.println("		System.out.println(\"\\n\");\n	}\n}");
	}
}