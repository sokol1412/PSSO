package visitor.pattern;

//Visitor to print the expression in infix notation

public class InFixPrintVisitor implements VisitorProtocol.Visitor  {


  public void visit(VisitorProtocol.Node n)  {
	BinaryOperatorNode node = (BinaryOperatorNode)n;
    //print out left subtree
    System.out.print("(");
    if (node.getLeft() != null) node.getLeft().accept(this);
    //print out this node
    System.out.print(" " + node.getLabel() + " ");
    //print out right subtree
    if (node.getRight() != null) node.getRight().accept(this);
    System.out.print(")");
  }


  public void visit(VisitorProtocol.Leaf leaf)  {
	NumericNode node = (NumericNode)leaf;
    System.out.print(node.getLabel());
  }
}