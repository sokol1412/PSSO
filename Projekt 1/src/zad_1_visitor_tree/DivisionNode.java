package zad_1_visitor_tree;

public class DivisionNode extends BinaryOperatorNode{
    
    public DivisionNode(TreeNode left, TreeNode right, String label){
        super(left,right,label);
    }
    
    public int compute(int x, int y){
        return x/y;
    }
    
}
