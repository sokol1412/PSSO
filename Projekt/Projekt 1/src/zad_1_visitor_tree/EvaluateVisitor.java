package zad_1_visitor_tree;

import java.util.Stack;

public class EvaluateVisitor extends Visitor {

	private Stack<Integer> stack = new Stack<Integer>();

	public int getValue() {
		return stack.pop();
	}

	@Override
	public void visitBinaryOperationNode(BinaryOperatorNode node) {
		int result = 0;
		if (node.getLeft() != null)
			node.getLeft().accept(this);
		if (node.getRight() != null)
			node.getRight().accept(this);
		int r1 = stack.pop();
		int r2 = stack.pop();

		result = node.compute(r2, r1);
		stack.push(result);
	}

	@Override
	public void visitNumericNode(NumericNode node) {
		stack.push(node.getValue());
	}

}
