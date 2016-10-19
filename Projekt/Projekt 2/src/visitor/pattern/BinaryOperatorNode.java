package visitor.pattern;

//Tree node that contains two children

public abstract class BinaryOperatorNode implements TreeNode  {

  public BinaryOperatorNode() {
    this.left = null;
    this.right = null;
  }

  public BinaryOperatorNode(TreeNode left, TreeNode right) {
    this.left = left;
    this.right = right;
  }

  public TreeNode getLeft() {
    return this.left;
  }

  public TreeNode getRight()  {
    return this.right;
  }

  // Apply this operator (+,-,*,/ etc.) to the given operands
  public abstract int compute(int a, int b);


  private TreeNode left, right;

}