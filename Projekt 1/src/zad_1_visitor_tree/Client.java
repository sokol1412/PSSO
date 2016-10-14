package zad_1_visitor_tree;



public class Client { 
	

	public static void main(String[] args) { 
	    
	   Parser parser = new Parser();
            //TreeNode rootNode = parser.parse("1 + ( 2 - 3 * 4 ) / 5");// spaces are vital!!;
            //TreeNode rootNode = parser.parse("321 % 3");// spaces are vital!!;

	   		TreeNode rootNode = parser.parse("2 + 4 + 6 * ( 5 - 2 )");// SPACES!!!!!!!!!!!!!!!!!!!!1
            InFixPrintVisitor infix = new InFixPrintVisitor();
            rootNode.accept(infix);
            System.out.println("");
            PreFixPrintVisitor prefix = new PreFixPrintVisitor();
            rootNode.accept(prefix);
            System.out.println("");
            PostFixPrintVisitor postfix = new PostFixPrintVisitor();
            rootNode.accept(postfix);
            System.out.println("");
            EvaluateVisitor evaluate = new EvaluateVisitor();
            rootNode.accept(evaluate);
            System.out.println(evaluate.getValue());
            
	}
}