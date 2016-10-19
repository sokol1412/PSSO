package visitor.pattern;

import java.util.Stack;


public class EvaluateVisitor implements VisitorProtocol.Visitor  {

    private Stack<Integer> stack = new Stack<>();
    
    public int getValue() {
        return stack.peek();
    }

  public void visit(VisitorProtocol.Node n)  {   
	BinaryOperatorNode node = (BinaryOperatorNode)n;
    if (node.getLeft() != null) node.getLeft().accept(this);
    if (node.getRight() != null) node.getRight().accept(this);
    int right = stack.pop();
    int left = stack.pop();                 
    stack.push( node.compute(left, right) );
            
  }

  public void visit(VisitorProtocol.Leaf leaf)  {
	NumericNode node = (NumericNode)leaf;
    stack.push(node.getValue());
  }
}