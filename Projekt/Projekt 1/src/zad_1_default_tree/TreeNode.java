package zad_1_default_tree;
//abstract superclass of tree element types

public abstract class TreeNode  {

  protected TreeNode(String label)  {
    this.label = label;
  }

  public abstract void inFixPrint();
  public abstract void postFixPrint();
  public abstract void preFixPrint();
  public abstract int evaluate();
  public abstract Boolean isOperator();

  protected String label;
}