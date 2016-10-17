package zad_1_default_tree;

public class ParserTest {
	public static void main(String[] args) {
		Parser parser = new Parser();
		TreeNode rootNode = parser.parse("2 + 4 + 6 * ( 5 - 2 )");// SPACES!!!!!!!!!!!!!!!!!!!!1
		// TreeNode rootNode = parser.parse("4 % 3");// SPACES!!!!!!!!!!!!!1

		rootNode.inFixPrint();
		System.out.println(" ");
		rootNode.preFixPrint();
		System.out.println(" ");
		rootNode.postFixPrint();
		System.out.println(" ");
		System.out.println("result: " + rootNode.evaluate());
	}
}