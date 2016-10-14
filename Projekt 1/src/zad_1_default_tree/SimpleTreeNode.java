package zad_1_default_tree;
//Define tree element with no children

public class SimpleTreeNode extends TreeNode  {

  public SimpleTreeNode(String label) {
    super(label);
  }

  public void inFixPrint()  {
      System.out.print(" "+label+ " ");
  }
  
  public void preFixPrint()  {
      System.out.print(" "+label+ " ");
  }
  
  public void postFixPrint()  {
      System.out.print(" "+label+ " ");
  }
  
  public int evaluate(){
      return 0;
  }
  
  public Boolean isOperator(){
      return true;
  }
  
}