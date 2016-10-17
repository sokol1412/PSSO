package zad_1_visitor_tree;


public class BinaryOperatorNode implements TreeNode{
    private TreeNode left;
    private TreeNode right;
    private String label;
    
    public BinaryOperatorNode(){
        
    }
    
    public BinaryOperatorNode(TreeNode left, TreeNode right, String label){
        this.left = left;
        this.right = right;
        this.label = label;
    }
    
    public int compute(int x, int y){
        return x+y;
    }
    
    public TreeNode getLeft(){
        return this.left;
    }
    
    public TreeNode getRight(){
        return this.right;
    }
    
    
    public void accept(Visitor visitor) {
        visitor.visitBinaryOperationNode(this);
    }

   
    public String getLabel(){
        return this.label;
    }
}
