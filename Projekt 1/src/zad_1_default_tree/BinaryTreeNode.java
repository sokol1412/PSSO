package zad_1_default_tree;
//Tree node that contains two children

public class BinaryTreeNode extends TreeNode {

	public BinaryTreeNode(String label) {
		super(label);
		left = right = null;
	}

	public BinaryTreeNode(String label, TreeNode left, TreeNode right) {
		super(label);
		this.left = left;
		this.right = right;
	}

	public Boolean isOperatorWithLessPriority() {
		if (label.equals("+") || label.equals("-"))
			return true;
		else
			return false;
	}

	public Boolean isOperator() {
		if (label.equals("+") || label.equals("-") || label.equals("*") || label.equals("/") || label.equals("%"))
			return true;
		else
			return false;
	}

	public void inFixPrint() {

		if (this.isOperatorWithLessPriority())
			System.out.print("( ");
		left.inFixPrint();
		System.out.print(" " + label + " ");
		right.inFixPrint();
		if (this.isOperatorWithLessPriority())
			System.out.print(" )");
	}

	public void preFixPrint() {
		if (this.isOperatorWithLessPriority())
			System.out.print("( ");
		System.out.print(" " + label + " ");
		left.preFixPrint();
		right.preFixPrint();
		if (this.isOperatorWithLessPriority())
			System.out.print(" )");
	}

	public void postFixPrint() {
		if (this.isOperatorWithLessPriority())
			System.out.print("( ");
		left.postFixPrint();
		right.postFixPrint();
		System.out.print(" " + label + " ");
		if (this.isOperatorWithLessPriority())
			System.out.print(" )");
	}

	public int count() {
		if (label.equals("+"))
			return Integer.parseInt(left.label) + Integer.parseInt(right.label);
		else if (label.equals("-"))
			return Integer.parseInt(left.label) - Integer.parseInt(right.label);
		else if (label.equals("/"))
			return Integer.parseInt(left.label) / Integer.parseInt(right.label);
		else if (label.equals("*"))
			return Integer.parseInt(left.label) * Integer.parseInt(right.label);
		else if (label.equals("%"))
			return Integer.parseInt(left.label) % Integer.parseInt(right.label);
		return 0;

	}

	public int evaluate() {
		int result = 0;
		if (this.left.isOperator())
			left.evaluate();
		if (this.right.isOperator())
			right.evaluate();
		result += this.count();
		label = String.valueOf(result);

		return result;
	}

	private TreeNode left, right;

}