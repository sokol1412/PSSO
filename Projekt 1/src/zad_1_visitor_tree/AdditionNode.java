package zad_1_visitor_tree;

public class AdditionNode extends BinaryOperatorNode{
    public AdditionNode(TreeNode left, TreeNode right, String label){
        super(left,right,label);
    }
    
    public int compute(int x, int y){
        return x+y;
    }
    
}
