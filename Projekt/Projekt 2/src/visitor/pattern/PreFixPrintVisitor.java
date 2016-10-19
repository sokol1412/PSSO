package visitor.pattern;

//Visitor to print the expression in prefix notation

public class PreFixPrintVisitor implements VisitorProtocol.Visitor {


  public void visit(VisitorProtocol.Node n)  {
	BinaryOperatorNode node = (BinaryOperatorNode)n;
    //print out this node
    System.out.print(node.getLabel());
    //print out left subtree
    if (node.getLeft() != null) node.getLeft().accept(this);
    //print out right subtree
    if (node.getRight() != null) node.getRight().accept(this);   
  }


  public void visit(VisitorProtocol.Leaf leaf)  {
	NumericNode node = (NumericNode)leaf;
    System.out.print(node.getLabel());
  }
}