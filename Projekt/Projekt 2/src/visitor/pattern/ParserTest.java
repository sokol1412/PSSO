
package visitor.pattern;


class ParserTest{
	public static void main(String[] args)  {
	    Parser parser = new Parser("1 + ( 2 - 3 * 4 ) % 5"); // spaces are vital!!	    
	    TreeNode node = parser.parse();

            node.accept(new InFixPrintVisitor());
            System.out.println();
            node.accept(new PreFixPrintVisitor());
            System.out.println();
            node.accept(new PostFixPrintVisitor());
            System.out.println();
            
            EvaluateVisitor v = new EvaluateVisitor();
	    node.accept(v);            
	    System.out.println("result: " + v.getValue());
            
           
	  }
	
}